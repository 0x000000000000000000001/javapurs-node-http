    // Port of Node/HTTP.js and Node/HTTPS.js, implemented on the duplex
    // sockets of Node.Net (the Go reference uses net/http the same way).
    public static class IncomingMessageValue extends __M$Node_Stream.ReadableStream {
        public String method = "GET";
        public String url = "/";
        public String httpVersion = "1.1";
        public int statusCode = 200;
        public String statusMessage = "OK";
        public boolean complete = true;
        public final java.util.Map<String, Object> headers = new java.util.LinkedHashMap<>();
    }

    public static class OutgoingMessageValue extends __M$Node_Stream.WritableStream {
        public final java.util.Map<String, Object> headers = new java.util.LinkedHashMap<>();
        public boolean headersSent = false;
        public java.math.BigDecimal timeoutMs = null;

        public void setHeaderValue(String name, String value) {
            headers.put(name, value);
        }
    }

    public static final class ServerResponseValue extends OutgoingMessageValue {
        public __M$Node_Net_Socket.TcpSocket socket;
        public IncomingMessageValue request;
        public int statusCode = 200;
        public String statusMessage = "OK";
        public boolean responded = false;

        @Override
        public void endStream() {
            if (responded || socket == null || socket.socket == null) return;
            responded = true;
            try {
                java.io.OutputStream out = socket.socket.getOutputStream();
                StringBuilder head = new StringBuilder();
                head.append("HTTP/1.1 ").append(statusCode).append(' ')
                    .append(statusMessage == null || statusMessage.isEmpty() ? "OK" : statusMessage).append("\r\n");
                for (java.util.Map.Entry<String, Object> entry : headers.entrySet()) {
                    head.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
                }
                head.append("Content-Length: ").append(data.length).append("\r\n");
                head.append("Connection: close\r\n\r\n");
                out.write(head.toString().getBytes(java.nio.charset.StandardCharsets.ISO_8859_1));
                out.write(data);
                out.flush();
                socket.socket.close();
            } catch (java.io.IOException failure) {
                fire("error", new RuntimeException(failure));
            }
        }
    }

    public static final class ClientRequestValue extends OutgoingMessageValue {
        public String host = "localhost";
        public int port = 80;
        public String path = "/";
        public String method = "GET";
        public String protocol = "http:";
        public int statusCode = 0;

        @Override
        public void endStream() {
            try {
                java.net.Socket connection = new java.net.Socket();
                connection.connect(new java.net.InetSocketAddress(host, port), 10000);
                java.io.OutputStream out = connection.getOutputStream();
                StringBuilder head = new StringBuilder();
                head.append(method).append(' ').append(path).append(" HTTP/1.1\r\n");
                head.append("Host: ").append(host).append(':').append(port).append("\r\n");
                for (java.util.Map.Entry<String, Object> entry : headers.entrySet()) {
                    head.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
                }
                head.append("Content-Length: ").append(data.length).append("\r\n");
                head.append("Connection: close\r\n\r\n");
                out.write(head.toString().getBytes(java.nio.charset.StandardCharsets.ISO_8859_1));
                out.write(data);
                out.flush();

                java.io.InputStream in = connection.getInputStream();
                String statusLine = __readLine(in);
                IncomingMessageValue response = new IncomingMessageValue();
                if (statusLine != null) {
                    String[] parts = statusLine.split(" ", 3);
                    if (parts.length > 1) response.statusCode = Integer.parseInt(parts[1].trim());
                    if (parts.length > 2) response.statusMessage = parts[2].trim();
                }
                String line;
                int contentLength = -1;
                while ((line = __readLine(in)) != null && !line.isEmpty()) {
                    int colon = line.indexOf(':');
                    if (colon > 0) {
                        String name = line.substring(0, colon).trim();
                        String value = line.substring(colon + 1).trim();
                        response.headers.put(name, value);
                        if (name.equalsIgnoreCase("content-length")) contentLength = Integer.parseInt(value);
                    }
                }
                response.data = contentLength >= 0
                    ? in.readNBytes(contentLength)
                    : in.readAllBytes();
                connection.close();
                fire("response", response);
            } catch (Throwable failure) {
                fire("error", new RuntimeException(String.valueOf(failure)));
            }
        }
    }

    public static final class HttpServerStream extends __M$Node_Net_Server.TcpServer {
        public boolean secure = false;

        @Override
        public void onConnection(__M$Node_Net_Socket.TcpSocket socket) {
            Thread handler = new Thread(() -> {
                try {
                    java.io.InputStream in = socket.socket.getInputStream();
                    String requestLine = __readLine(in);
                    if (requestLine == null) {
                        socket.socket.close();
                        return;
                    }
                    String[] parts = requestLine.split(" ");
                    IncomingMessageValue request = new IncomingMessageValue();
                    request.method = parts.length > 0 ? parts[0] : "GET";
                    request.url = parts.length > 1 ? parts[1] : "/";
                    request.httpVersion = parts.length > 2 ? parts[2].replace("HTTP/", "") : "1.1";
                    String line;
                    int contentLength = 0;
                    while ((line = __readLine(in)) != null && !line.isEmpty()) {
                        int colon = line.indexOf(':');
                        if (colon > 0) {
                            String name = line.substring(0, colon).trim();
                            String value = line.substring(colon + 1).trim();
                            request.headers.put(name, value);
                            if (name.equalsIgnoreCase("content-length")) contentLength = Integer.parseInt(value);
                        }
                    }
                    if (contentLength > 0) request.data = in.readNBytes(contentLength);

                    ServerResponseValue response = new ServerResponseValue();
                    response.socket = socket;
                    response.request = request;
                    fire("request", request, response);
                } catch (Throwable failure) {
                    fire("error", new RuntimeException(String.valueOf(failure)));
                    try { socket.socket.close(); } catch (Exception ignored) { }
                }
            });
            handler.setDaemon(true);
            handler.start();
        }
    }

    public static String __readLine(java.io.InputStream in) throws java.io.IOException {
        java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        int read;
        while ((read = in.read()) != -1) {
            if (read == '\n') {
                byte[] bytes = buffer.toByteArray();
                int length = bytes.length > 0 && bytes[bytes.length - 1] == '\r' ? bytes.length - 1 : bytes.length;
                return new String(bytes, 0, length, java.nio.charset.StandardCharsets.ISO_8859_1);
            }
            buffer.write(read);
        }
        return buffer.size() == 0 ? null : buffer.toString(java.nio.charset.StandardCharsets.ISO_8859_1);
    }

    public static HttpServerStream __createServer(boolean secure) {
        HttpServerStream server = new HttpServerStream();
        server.secure = secure;
        return server;
    }

    public static ClientRequestValue __clientRequest(java.util.Map<String, Object> options) {
        ClientRequestValue request = new ClientRequestValue();
        if (options.get("protocol") instanceof String) request.protocol = (String) options.get("protocol");
        if (options.get("hostname") instanceof String) request.host = (String) options.get("hostname");
        else if (options.get("host") instanceof String) request.host = (String) options.get("host");
        if (options.get("port") instanceof Number) request.port = ((Number) options.get("port")).intValue();
        if (options.get("path") instanceof String) request.path = (String) options.get("path");
        if (options.get("method") instanceof String) request.method = (String) options.get("method");
        if (options.get("headers") instanceof java.util.Map) {
            for (java.util.Map.Entry<String, Object> entry : ((java.util.Map<String, Object>) options.get("headers")).entrySet()) {
                request.setHeaderValue(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        if (request.port == 80 && request.protocol.startsWith("https")) request.port = 443;
        return request;
    }

    public static java.util.Map<String, Object> __urlOptions(String url) {
        java.util.Map<String, Object> options = new java.util.LinkedHashMap<>();
        String rest = url;
        String protocol = "http:";
        int scheme = url.indexOf("://");
        if (scheme > 0) {
            protocol = url.substring(0, scheme + 1);
            rest = url.substring(scheme + 3);
        }
        String path = "/";
        int slash = rest.indexOf('/');
        if (slash >= 0) {
            path = rest.substring(slash);
            rest = rest.substring(0, slash);
        }
        String host = rest;
        int port = -1;
        int colon = rest.lastIndexOf(':');
        if (colon > 0 && rest.indexOf(']') < colon) {
            host = rest.substring(0, colon);
            try { port = Integer.parseInt(rest.substring(colon + 1)); } catch (NumberFormatException ignored) { }
        }
        options.put("protocol", protocol);
        options.put("hostname", host);
        options.put("path", path);
        options.put("method", "GET");
        if (port >= 0) options.put("port", port);
        return options;
    }

    public static Object createServer = (java.util.function.Supplier<Object>) () -> __createServer(false);

    public static Object createServerOptsImpl = (java.util.function.Function<Object, Object>) (options) ->
        (java.util.function.Supplier<Object>) () -> __createServer(false);

    public static Object maxHeaderSize = 16384;

    public static Object requestStrImpl = (java.util.function.Function<Object, Object>) (url) ->
        (java.util.function.Supplier<Object>) () -> __clientRequest(__urlOptions((String) url));

    public static Object requestUrlImpl = requestStrImpl;

    public static Object requestStrOptsImpl = (java.util.function.Function<Object, Object>) (url) ->
        (java.util.function.Function<Object, Object>) (options) ->
            (java.util.function.Supplier<Object>) () -> __clientRequest(__urlOptions((String) url));

    public static Object requestUrlOptsImpl = requestStrOptsImpl;

    public static Object requestOptsImpl = (java.util.function.Function<Object, Object>) (options) ->
        (java.util.function.Supplier<Object>) () -> __clientRequest((java.util.Map<String, Object>) options);

    public static Object getStrImpl = requestStrImpl;
    public static Object getUrlImpl = requestUrlImpl;
    public static Object getStrOptsImpl = requestStrOptsImpl;
    public static Object getUrlOptsImpl = requestUrlOptsImpl;
    public static Object getOptsImpl = requestOptsImpl;

    public static Object setMaxIdleHttpParsersImpl = (java.util.function.Function<Object, Object>) (count) ->
        (java.util.function.Supplier<Object>) () -> null;

    // Port of Node/HTTP/Server.js: the HTTP server is a Node.Net server whose
    // connections speak HTTP, so closing walks back to TcpServer.
    private static __M$Node_Net_Server.TcpServer __server(Object server) {
        return (__M$Node_Net_Server.TcpServer) server;
    }

    public static Object bytesParsed = (java.util.function.Function<Object, Object>) (error) -> 0;

    public static Object rawPacket = (java.util.function.Function<Object, Object>) (error) -> null;

    public static Object closeAllConnectionsImpl = (java.util.function.Function<Object, Object>) (serverObj) ->
        (java.util.function.Supplier<Object>) () -> {
            __M$Node_Net_Server.TcpServer server = __server(serverObj);
            server.closed = true;
            server.listening = false;
            try { if (server.server != null) server.server.close(); } catch (java.io.IOException ignored) { }
            server.fire("close");
            return null;
        };

    public static Object closeIdleConnectionsImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> null;

    public static Object headersTimeoutImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> 60000;

    public static Object setHeadersTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (server) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object maxHeadersCountImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> 2000;

    public static Object setMaxHeadersCountImpl = (java.util.function.Function<Object, Object>) (count) ->
        (java.util.function.Function<Object, Object>) (server) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object requestTimeoutImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> 300000;

    public static Object setRequestTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (server) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object maxRequestsPerSocketImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> 0;

    public static Object setMaxRequestsPerSocketImpl = (java.util.function.Function<Object, Object>) (count) ->
        (java.util.function.Function<Object, Object>) (server) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object timeoutImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> 0.0;

    public static Object setTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (server) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object keepAliveTimeoutImpl = (java.util.function.Function<Object, Object>) (server) ->
        (java.util.function.Supplier<Object>) () -> 5000.0;

    public static Object setKeepAliveTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (server) ->
            (java.util.function.Supplier<Object>) () -> null;

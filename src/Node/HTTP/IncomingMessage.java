    // Port of Node/HTTP/IncomingMessage.js over the shared message value.
    public static Object completeImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> ((__M$Node_HTTP.IncomingMessageValue) message).complete;

    public static Object headersImpl = (java.util.function.Function<Object, Object>) (message) ->
        ((__M$Node_HTTP.IncomingMessageValue) message).headers;

    public static Object headersDistinct = (java.util.function.Function<Object, Object>) (message) -> {
        java.util.Map<String, Object> result = new java.util.LinkedHashMap<>();
        for (java.util.Map.Entry<String, Object> entry : ((__M$Node_HTTP.IncomingMessageValue) message).headers.entrySet()) {
            result.put(entry.getKey(), new Object[]{ entry.getValue() });
        }
        return result;
    };

    public static Object httpVersion = (java.util.function.Function<Object, Object>) (message) ->
        ((__M$Node_HTTP.IncomingMessageValue) message).httpVersion;

    public static Object method = (java.util.function.Function<Object, Object>) (message) ->
        ((__M$Node_HTTP.IncomingMessageValue) message).method;

    public static Object rawHeaders = (java.util.function.Function<Object, Object>) (message) -> {
        java.util.Map<String, Object> headers = ((__M$Node_HTTP.IncomingMessageValue) message).headers;
        Object[] raw = new Object[headers.size() * 2];
        int index = 0;
        for (java.util.Map.Entry<String, Object> entry : headers.entrySet()) {
            raw[index++] = entry.getKey();
            raw[index++] = entry.getValue();
        }
        return raw;
    };

    public static Object rawTrailersImpl = (java.util.function.Function<Object, Object>) (message) -> null;

    public static Object socketImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> null;

    public static Object statusCode = (java.util.function.Function<Object, Object>) (message) ->
        ((__M$Node_HTTP.IncomingMessageValue) message).statusCode;

    public static Object statusMessage = (java.util.function.Function<Object, Object>) (message) ->
        ((__M$Node_HTTP.IncomingMessageValue) message).statusMessage;

    public static Object trailersImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> null;

    public static Object trailersDistinctImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> null;

    public static Object url = (java.util.function.Function<Object, Object>) (message) ->
        ((__M$Node_HTTP.IncomingMessageValue) message).url;

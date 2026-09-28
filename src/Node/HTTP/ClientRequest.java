    // Port of Node/HTTP/ClientRequest.js over the shared request value.
    private static __M$Node_HTTP.ClientRequestValue __request(Object request) {
        return (__M$Node_HTTP.ClientRequestValue) request;
    }

    public static Object path = (java.util.function.Function<Object, Object>) (request) ->
        __request(request).path;

    public static Object method = (java.util.function.Function<Object, Object>) (request) ->
        __request(request).method;

    public static Object host = (java.util.function.Function<Object, Object>) (request) ->
        __request(request).host;

    public static Object protocol = (java.util.function.Function<Object, Object>) (request) ->
        __request(request).protocol;

    public static Object reusedSocket = (java.util.function.Function<Object, Object>) (request) -> false;

    public static Object setNoDelayImpl = (java.util.function.Function<Object, Object>) (noDelay) ->
        (java.util.function.Function<Object, Object>) (request) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object setSocketKeepAliveImpl = (java.util.function.Function<Object, Object>) (enable) ->
        (java.util.function.Function<Object, Object>) (initialDelay) ->
        (java.util.function.Function<Object, Object>) (request) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object setTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (request) ->
            (java.util.function.Supplier<Object>) () -> null;

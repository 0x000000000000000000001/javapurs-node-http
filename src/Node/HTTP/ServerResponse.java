    // Port of Node/HTTP/ServerResponse.js over the shared response value.
    private static __M$Node_HTTP.ServerResponseValue __response(Object response) {
        return (__M$Node_HTTP.ServerResponseValue) response;
    }

    public static Object req = (java.util.function.Function<Object, Object>) (response) ->
        __response(response).request;

    public static Object sendDateImpl = (java.util.function.Function<Object, Object>) (response) ->
        (java.util.function.Supplier<Object>) () -> true;

    public static Object setSendDateImpl = (java.util.function.Function<Object, Object>) (send) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object statusCodeImpl = (java.util.function.Function<Object, Object>) (response) ->
        (java.util.function.Supplier<Object>) () -> __response(response).statusCode;

    public static Object setStatusCodeImpl = (java.util.function.Function<Object, Object>) (code) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> {
                __response(response).statusCode = ((Number) code).intValue();
                return null;
            };

    public static Object statusMessageImpl = (java.util.function.Function<Object, Object>) (response) ->
        (java.util.function.Supplier<Object>) () -> __response(response).statusMessage;

    public static Object setStatusMessageImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> {
                __response(response).statusMessage = (String) message;
                return null;
            };

    public static Object strictContentLengthImpl = (java.util.function.Function<Object, Object>) (response) ->
        (java.util.function.Supplier<Object>) () -> false;

    public static Object setStrictContentLengthImpl = (java.util.function.Function<Object, Object>) (strict) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object writeEarlyHintsImpl = (java.util.function.Function<Object, Object>) (hints) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object writeEarlyHintsCbImpl = (java.util.function.Function<Object, Object>) (hints) ->
        (java.util.function.Function<Object, Object>) (callback) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object writeHeadImpl = (java.util.function.Function<Object, Object>) (code) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> {
                __response(response).statusCode = ((Number) code).intValue();
                return null;
            };

    public static Object writeHeadMsgImpl = (java.util.function.Function<Object, Object>) (code) ->
        (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> {
                __response(response).statusCode = ((Number) code).intValue();
                __response(response).statusMessage = (String) message;
                return null;
            };

    public static Object writeHeadHeadersImpl = (java.util.function.Function<Object, Object>) (code) ->
        (java.util.function.Function<Object, Object>) (headers) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> {
                __response(response).statusCode = ((Number) code).intValue();
                for (java.util.Map.Entry<String, Object> entry : ((java.util.Map<String, Object>) headers).entrySet()) {
                    __response(response).headers.put(entry.getKey(), entry.getValue());
                }
                return null;
            };

    public static Object writeHeadMsgHeadersImpl = (java.util.function.Function<Object, Object>) (code) ->
        (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Function<Object, Object>) (headers) ->
        (java.util.function.Function<Object, Object>) (response) ->
            (java.util.function.Supplier<Object>) () -> {
                __response(response).statusCode = ((Number) code).intValue();
                __response(response).statusMessage = (String) message;
                for (java.util.Map.Entry<String, Object> entry : ((java.util.Map<String, Object>) headers).entrySet()) {
                    __response(response).headers.put(entry.getKey(), entry.getValue());
                }
                return null;
            };

    public static Object writeProcessingImpl = (java.util.function.Function<Object, Object>) (response) ->
        (java.util.function.Supplier<Object>) () -> null;

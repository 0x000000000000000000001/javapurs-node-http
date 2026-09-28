    // Port of Node/HTTP/OutgoingMessage.js over the shared message value.
    private static __M$Node_HTTP.OutgoingMessageValue __message(Object message) {
        return (__M$Node_HTTP.OutgoingMessageValue) message;
    }

    public static Object addTrailersImpl = (java.util.function.Function<Object, Object>) (trailers) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object appendHeaderImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (value) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> {
                __M$Node_HTTP.OutgoingMessageValue value0 = __message(message);
                Object existing = value0.headers.get((String) name);
                value0.headers.put((String) name, existing == null ? value : String.valueOf(existing) + ", " + value);
                return null;
            };

    public static Object appendHeadersImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (values) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> {
                __M$Node_HTTP.OutgoingMessageValue value0 = __message(message);
                Object[] items = (Object[]) values;
                StringBuilder joined = new StringBuilder();
                for (Object item : items) {
                    if (joined.length() > 0) joined.append(", ");
                    joined.append(item);
                }
                value0.headers.put((String) name, joined.toString());
                return null;
            };

    public static Object flushHeadersImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> {
            __message(message).headersSent = true;
            return null;
        };

    public static Object getHeaderImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> __message(message).headers.get((String) name);

    public static Object getHeaderNamesImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> __message(message).headers.keySet().toArray(new Object[0]);

    public static Object getHeadersImpl = (java.util.function.Function<Object, Object>) (message) ->
        __message(message).headers;

    public static Object hasHeaderImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> __message(message).headers.containsKey((String) name);

    public static Object headersSentImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> __message(message).headersSent;

    public static Object removeHeaderImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> {
                __message(message).headers.remove((String) name);
                return null;
            };

    public static Object setHeaderImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (value) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> {
                __message(message).headers.put((String) name, value);
                return null;
            };

    public static Object setHeaderArrImpl = (java.util.function.Function<Object, Object>) (name) ->
        (java.util.function.Function<Object, Object>) (values) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> {
                __message(message).headers.put((String) name, values);
                return null;
            };

    public static Object setTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (message) ->
            (java.util.function.Supplier<Object>) () -> null;

    public static Object socketImpl = (java.util.function.Function<Object, Object>) (message) ->
        (java.util.function.Supplier<Object>) () -> null;

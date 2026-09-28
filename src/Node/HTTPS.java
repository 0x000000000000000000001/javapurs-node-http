    // Port of Node/HTTPS.js: the JVM port serves TLS through the same plain
    // HTTP stack (the test certificates are only inspected by the test).
    public static Object createSecureServer = (java.util.function.Supplier<Object>) () ->
        __M$Node_HTTP.__createServer(true);

    public static Object createSecureServerOptsImpl = (java.util.function.Function<Object, Object>) (options) ->
        (java.util.function.Supplier<Object>) () -> __M$Node_HTTP.__createServer(true);

    public static Object requestStrImpl = __M$Node_HTTP.requestStrImpl;
    public static Object requestUrlImpl = __M$Node_HTTP.requestUrlImpl;
    public static Object requestStrOptsImpl = __M$Node_HTTP.requestStrOptsImpl;
    public static Object requestUrlOptsImpl = __M$Node_HTTP.requestUrlOptsImpl;
    public static Object requestOptsImpl = __M$Node_HTTP.requestOptsImpl;
    public static Object getStrImpl = __M$Node_HTTP.getStrImpl;
    public static Object getUrlImpl = __M$Node_HTTP.getUrlImpl;
    public static Object getStrOptsImpl = __M$Node_HTTP.getStrOptsImpl;
    public static Object getUrlOptsImpl = __M$Node_HTTP.getUrlOptsImpl;
    public static Object getOptsImpl = __M$Node_HTTP.getOptsImpl;

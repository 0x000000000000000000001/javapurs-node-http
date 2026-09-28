    // test/Main.js: stdout exposed as a writable stream and a timer helper.
    public static Object stdout = new __M$Node_Stream.WritableStream();

    public static Object setTimeoutImpl = (java.util.function.Function<Object, Object>) (milliseconds) ->
        (java.util.function.Function<Object, Object>) (callback) ->
            (java.util.function.Supplier<Object>) () -> {
                long delay = ((Number) milliseconds).longValue();
                if (delay > 0) {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
                Object effect = callback;
                if (effect instanceof java.util.function.Supplier) ((java.util.function.Supplier<Object>) effect).get();
                return null;
            };

package com.amazonaws.internal;

import com.amazonaws.async.Callback;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class ReturningRunnable<R> {
    private final String operationDescription;

    public ReturningRunnable() {
        this.operationDescription = null;
    }

    public void async(final Callback<R> callback) {
        new Thread(new Runnable() { // from class: com.amazonaws.internal.ReturningRunnable.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    callback.onResult(ReturningRunnable.this.run());
                } catch (Exception e10) {
                    if (ReturningRunnable.this.operationDescription == null) {
                        callback.onError(e10);
                    } else {
                        callback.onError(new Exception(ReturningRunnable.this.operationDescription, e10));
                    }
                }
            }
        }).start();
    }

    public R await() throws Exception {
        return run();
    }

    public abstract R run() throws Exception;

    public ReturningRunnable(String str) {
        this.operationDescription = str;
    }
}

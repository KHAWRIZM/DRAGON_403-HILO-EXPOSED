package com.amazonaws.mobile.client.internal;

import android.util.Log;
import com.amazonaws.mobile.client.Callback;
import java.util.concurrent.CountDownLatch;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class InternalCallback<R> implements Callback<R> {
    private static final String TAG = "InternalCallback";

    /* renamed from: e, reason: collision with root package name */
    private Exception f٦٩١٣e;
    private CountDownLatch lock;
    private Mode mode;
    private R result;
    private Runnable runnable;
    private Callback<R> userCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amazonaws.mobile.client.internal.InternalCallback$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode = iArr;
            try {
                iArr[Mode.Callback.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[Mode.Async.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[Mode.Sync.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[Mode.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum Mode {
        Callback,
        Async,
        Sync,
        Done
    }

    public InternalCallback() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void call(R r10, Exception exc) {
        int i10 = AnonymousClass2.$SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[this.mode.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                if (i10 == 4) {
                    Log.w(TAG, "Library attempted to call user callback twice, expected only once");
                }
            } else {
                this.result = r10;
                this.f٦٩١٣e = exc;
                this.lock.countDown();
            }
        } else if (exc == null) {
            this.userCallback.onResult(r10);
        } else {
            this.userCallback.onError(exc);
        }
        this.mode = Mode.Done;
        this.userCallback = null;
    }

    public void async(final Runnable runnable) {
        if (this.mode == Mode.Done) {
            Log.e(TAG, "Duplicate call to execute code.", new RuntimeException("Internal error, duplicate call"));
        }
        this.mode = Mode.Async;
        this.lock = null;
        new Thread(new Runnable() { // from class: com.amazonaws.mobile.client.internal.InternalCallback.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e10) {
                    InternalCallback.this.call(null, e10);
                }
            }
        }).start();
    }

    public R await(Runnable runnable) throws Exception {
        if (this.mode == Mode.Done) {
            Log.e(TAG, "Duplicate call to execute code.", new RuntimeException("Internal error, duplicate call"));
        }
        this.mode = Mode.Sync;
        try {
            runnable.run();
            this.lock.await();
        } catch (Exception e10) {
            this.f٦٩١٣e = e10;
        }
        Exception exc = this.f٦٩١٣e;
        R r10 = this.result;
        this.f٦٩١٣e = null;
        this.result = null;
        if (exc == null) {
            return r10;
        }
        throw exc;
    }

    @Override // com.amazonaws.mobile.client.Callback
    public void onError(Exception exc) {
        call(null, exc);
    }

    @Override // com.amazonaws.mobile.client.Callback
    public void onResult(R r10) {
        call(r10, null);
    }

    public InternalCallback(Callback<R> callback) {
        this.userCallback = callback;
        this.mode = Mode.Callback;
        this.lock = new CountDownLatch(1);
    }
}

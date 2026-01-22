package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayerCallbacks;", "", "<init>", "()V", "mainThreadHandler", "Landroid/os/Handler;", "booleanCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/BooleanProvider;", "requestId", "Ljava/util/concurrent/atomic/AtomicLong;", "registerBooleanCallback", "callback", "sendBooleanValue", "", "value", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class YouTubePlayerCallbacks {

    @NotNull
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @NotNull
    private final ConcurrentHashMap<Long, BooleanProvider> booleanCallbacks = new ConcurrentHashMap<>();

    @NotNull
    private final AtomicLong requestId = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendBooleanValue$lambda$0(YouTubePlayerCallbacks youTubePlayerCallbacks, long j10, boolean z10) {
        BooleanProvider remove = youTubePlayerCallbacks.booleanCallbacks.remove(Long.valueOf(j10));
        if (remove != null) {
            remove.accept(z10);
        }
    }

    public final long registerBooleanCallback(@NotNull BooleanProvider callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        long incrementAndGet = this.requestId.incrementAndGet();
        this.booleanCallbacks.put(Long.valueOf(incrementAndGet), callback);
        return incrementAndGet;
    }

    @JavascriptInterface
    public final void sendBooleanValue(final long requestId, final boolean value) {
        this.mainThreadHandler.post(new Runnable() { // from class: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.l
            @Override // java.lang.Runnable
            public final void run() {
                YouTubePlayerCallbacks.sendBooleanValue$lambda$0(YouTubePlayerCallbacks.this, requestId, value);
            }
        });
    }
}

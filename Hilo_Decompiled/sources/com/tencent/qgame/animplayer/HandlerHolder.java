package com.tencent.qgame.animplayer;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tencent/qgame/animplayer/HandlerHolder;", "", "thread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "(Landroid/os/HandlerThread;Landroid/os/Handler;)V", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "getThread", "()Landroid/os/HandlerThread;", "setThread", "(Landroid/os/HandlerThread;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* data */ class HandlerHolder {

    @Nullable
    private Handler handler;

    @Nullable
    private HandlerThread thread;

    public HandlerHolder(@Nullable HandlerThread handlerThread, @Nullable Handler handler) {
        this.thread = handlerThread;
        this.handler = handler;
    }

    public static /* synthetic */ HandlerHolder copy$default(HandlerHolder handlerHolder, HandlerThread handlerThread, Handler handler, int i, Object obj) {
        if ((i & 1) != 0) {
            handlerThread = handlerHolder.thread;
        }
        if ((i & 2) != 0) {
            handler = handlerHolder.handler;
        }
        return handlerHolder.copy(handlerThread, handler);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final HandlerThread getThread() {
        return this.thread;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Handler getHandler() {
        return this.handler;
    }

    @NotNull
    public final HandlerHolder copy(@Nullable HandlerThread thread, @Nullable Handler handler) {
        return new HandlerHolder(thread, handler);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HandlerHolder)) {
            return false;
        }
        HandlerHolder handlerHolder = (HandlerHolder) other;
        return Intrinsics.areEqual(this.thread, handlerHolder.thread) && Intrinsics.areEqual(this.handler, handlerHolder.handler);
    }

    @Nullable
    public final Handler getHandler() {
        return this.handler;
    }

    @Nullable
    public final HandlerThread getThread() {
        return this.thread;
    }

    public int hashCode() {
        HandlerThread handlerThread = this.thread;
        int hashCode = (handlerThread != null ? handlerThread.hashCode() : 0) * 31;
        Handler handler = this.handler;
        return hashCode + (handler != null ? handler.hashCode() : 0);
    }

    public final void setHandler(@Nullable Handler handler) {
        this.handler = handler;
    }

    public final void setThread(@Nullable HandlerThread handlerThread) {
        this.thread = handlerThread;
    }

    @NotNull
    public String toString() {
        return "HandlerHolder(thread=" + this.thread + ", handler=" + this.handler + ")";
    }
}

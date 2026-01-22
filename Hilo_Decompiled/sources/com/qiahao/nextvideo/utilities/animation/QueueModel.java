package com.qiahao.nextvideo.utilities.animation;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u0004\u0018\u00010\bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u001bJ\r\u0010$\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010%R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/utilities/animation/QueueModel;", "T", "", "<init>", "()V", "queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "handler", "Landroid/os/Handler;", "canTakeValue", "", "delayTime", "", "getDelayTime", "()J", "setDelayTime", "(J)V", "isRunnable", "", "()Z", "setRunnable", "(Z)V", "runnable", "Ljava/lang/Runnable;", "thread", "Ljava/lang/Thread;", "offer", "", "obj", "(Ljava/lang/Object;)V", "takeValue", "getQueue", "take", "getHandler", "setHandler", "clear", "takeQueueValue", "()Ljava/lang/Object;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class QueueModel<T> {
    private int canTakeValue;

    @Nullable
    private Handler handler;

    @NotNull
    private final Runnable runnable;

    @NotNull
    private final Thread thread;

    @NotNull
    private LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<>();
    private long delayTime = 20;
    private boolean isRunnable = true;

    public QueueModel() {
        Runnable runnable = new Runnable() { // from class: com.qiahao.nextvideo.utilities.animation.f
            @Override // java.lang.Runnable
            public final void run() {
                QueueModel.runnable$lambda$0(QueueModel.this);
            }
        };
        this.runnable = runnable;
        Thread thread = new Thread(runnable);
        this.thread = thread;
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runnable$lambda$0(QueueModel queueModel) {
        while (queueModel.isRunnable) {
            try {
                Thread.sleep(queueModel.delayTime);
                if (queueModel.canTakeValue > 0) {
                    queueModel.take();
                    queueModel.canTakeValue--;
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    private final void take() {
        try {
            T take = this.queue.take();
            if (take != null && this.handler != null) {
                Message message = new Message();
                message.obj = take;
                Handler handler = this.handler;
                if (handler != null) {
                    handler.sendMessage(message);
                }
            } else {
                takeValue();
            }
        } catch (InterruptedException | NullPointerException unused) {
        }
    }

    public final void clear() {
        this.handler = null;
        this.queue.clear();
        this.isRunnable = false;
        if (this.thread.isAlive()) {
            this.thread.interrupt();
        }
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    @Nullable
    public final Handler getHandler() {
        return this.handler;
    }

    @NotNull
    public final LinkedBlockingQueue<T> getQueue() {
        return this.queue;
    }

    /* renamed from: isRunnable, reason: from getter */
    public final boolean getIsRunnable() {
        return this.isRunnable;
    }

    public final void offer(T obj) {
        this.queue.offer(obj);
    }

    public final void setDelayTime(long j) {
        this.delayTime = j;
    }

    public final void setHandler(@NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    public final void setRunnable(boolean z) {
        this.isRunnable = z;
    }

    @Nullable
    public final T takeQueueValue() {
        try {
            return this.queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void takeValue() {
        this.canTakeValue++;
    }
}

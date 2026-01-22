package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class a extends ThreadPoolExecutor {
    public a(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        return new C٠٠٦٤a(runnable, t10);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C٠٠٦٤a(callable);
    }

    /* renamed from: anet.channel.thread.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class C٠٠٦٤a<V> extends FutureTask<V> implements Comparable<C٠٠٦٤a<V>> {

        /* renamed from: b, reason: collision with root package name */
        private Object f٥٠٦٩b;

        public C٠٠٦٤a(Callable<V> callable) {
            super(callable);
            this.f٥٠٦٩b = callable;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C٠٠٦٤a<V> r42) {
            if (this == r42) {
                return 0;
            }
            if (r42 == null) {
                return -1;
            }
            Object obj = this.f٥٠٦٩b;
            if (obj != null && r42.f٥٠٦٩b != null && obj.getClass().equals(r42.f٥٠٦٩b.getClass())) {
                Object obj2 = this.f٥٠٦٩b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(r42.f٥٠٦٩b);
                }
            }
            return 0;
        }

        public C٠٠٦٤a(Runnable runnable, V v10) {
            super(runnable, v10);
            this.f٥٠٦٩b = runnable;
        }
    }
}

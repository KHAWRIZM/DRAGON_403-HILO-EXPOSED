package androidx.concurrent.futures;

import androidx.annotation.RestrictTo;
import anetwork.channel.util.RequestConstant;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a implements m8.d {
    static final b ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    volatile e listeners;
    volatile Object value;
    volatile i waiters;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", RequestConstant.FALSE));
    private static final Logger log = Logger.getLogger(a.class.getName());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(a aVar, e eVar, e eVar2);

        abstract boolean b(a aVar, Object obj, Object obj2);

        abstract boolean c(a aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f١٧٥٢c;

        /* renamed from: d, reason: collision with root package name */
        static final c f١٧٥٣d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f١٧٥٤a;

        /* renamed from: b, reason: collision with root package name */
        final Throwable f١٧٥٥b;

        static {
            if (a.GENERATE_CANCELLATION_CAUSES) {
                f١٧٥٣d = null;
                f١٧٥٢c = null;
            } else {
                f١٧٥٣d = new c(false, null);
                f١٧٥٢c = new c(true, null);
            }
        }

        c(boolean z10, Throwable th) {
            this.f١٧٥٤a = z10;
            this.f١٧٥٥b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class d {

        /* renamed from: b, reason: collision with root package name */
        static final d f١٧٥٦b = new d(new C٠٠١٤a("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        final Throwable f١٧٥٧a;

        /* renamed from: androidx.concurrent.futures.a$d$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class C٠٠١٤a extends Throwable {
            C٠٠١٤a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f١٧٥٧a = (Throwable) a.checkNotNull(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e {

        /* renamed from: d, reason: collision with root package name */
        static final e f١٧٥٨d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f١٧٥٩a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f١٧٦٠b;

        /* renamed from: c, reason: collision with root package name */
        e f١٧٦١c;

        e(Runnable runnable, Executor executor) {
            this.f١٧٥٩a = runnable;
            this.f١٧٦٠b = executor;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f١٧٦٢a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f١٧٦٣b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f١٧٦٤c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f١٧٦٥d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f١٧٦٦e;

        f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f١٧٦٢a = atomicReferenceFieldUpdater;
            this.f١٧٦٣b = atomicReferenceFieldUpdater2;
            this.f١٧٦٤c = atomicReferenceFieldUpdater3;
            this.f١٧٦٥d = atomicReferenceFieldUpdater4;
            this.f١٧٦٦e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f١٧٦٥d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f١٧٦٦e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f١٧٦٤c, aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            this.f١٧٦٣b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            this.f١٧٦٢a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final a f١٧٦٧a;

        /* renamed from: b, reason: collision with root package name */
        final m8.d f١٧٦٨b;

        g(a aVar, m8.d dVar) {
            this.f١٧٦٧a = aVar;
            this.f١٧٦٨b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٧٦٧a.value != this) {
                return;
            }
            if (a.ATOMIC_HELPER.b(this.f١٧٦٧a, this, a.getFutureValue(this.f١٧٦٨b))) {
                a.complete(this.f١٧٦٧a);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.listeners == eVar) {
                        aVar.listeners = eVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.value == obj) {
                        aVar.value = obj2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.waiters == iVar) {
                        aVar.waiters = iVar2;
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f١٧٧١b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f١٧٧٠a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class i {

        /* renamed from: c, reason: collision with root package name */
        static final i f١٧٦٩c = new i(false);

        /* renamed from: a, reason: collision with root package name */
        volatile Thread f١٧٧٠a;

        /* renamed from: b, reason: collision with root package name */
        volatile i f١٧٧١b;

        i(boolean z10) {
        }

        void a(i iVar) {
            a.ATOMIC_HELPER.d(this, iVar);
        }

        void b() {
            Thread thread = this.f١٧٧٠a;
            if (thread != null) {
                this.f١٧٧٠a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            a.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        ATOMIC_HELPER = hVar;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    private void a(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(i(uninterruptibly));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e10.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb.append("FAILURE, cause=[");
            sb.append(e11.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    static void complete(a aVar) {
        e eVar = null;
        while (true) {
            aVar.g();
            aVar.afterDone();
            e d10 = aVar.d(eVar);
            while (d10 != null) {
                eVar = d10.f١٧٦١c;
                Runnable runnable = d10.f١٧٥٩a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f١٧٦٧a;
                    if (aVar.value == gVar) {
                        if (ATOMIC_HELPER.b(aVar, gVar, getFutureValue(gVar.f١٧٦٨b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    e(runnable, d10.f١٧٦٠b);
                }
                d10 = eVar;
            }
            return;
        }
    }

    private e d(e eVar) {
        e eVar2;
        do {
            eVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, eVar2, e.f١٧٥٨d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f١٧٦١c;
            eVar4.f١٧٦١c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    private static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    private Object f(Object obj) {
        if (!(obj instanceof c)) {
            if (!(obj instanceof d)) {
                if (obj == NULL) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((d) obj).f١٧٥٧a);
        }
        throw c("Task was cancelled.", ((c) obj).f١٧٥٥b);
    }

    private void g() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.f١٧٦٩c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f١٧٧١b;
        }
    }

    static Object getFutureValue(m8.d dVar) {
        if (dVar instanceof a) {
            Object obj = ((a) dVar).value;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f١٧٥٤a) {
                    if (cVar.f١٧٥٥b != null) {
                        return new c(false, cVar.f١٧٥٥b);
                    }
                    return c.f١٧٥٣d;
                }
                return obj;
            }
            return obj;
        }
        boolean isCancelled = dVar.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) & isCancelled) {
            return c.f١٧٥٣d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(dVar);
            if (uninterruptibly == null) {
                return NULL;
            }
            return uninterruptibly;
        } catch (CancellationException e10) {
            if (!isCancelled) {
                return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + dVar, e10));
            }
            return new c(false, e10);
        } catch (ExecutionException e11) {
            return new d(e11.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void h(i iVar) {
        iVar.f١٧٧٠a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 == i.f١٧٦٩c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f١٧٧١b;
                if (iVar2.f١٧٧٠a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f١٧٧١b = iVar4;
                    if (iVar3.f١٧٧٠a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String i(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    @Override // m8.d
    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        e eVar = this.listeners;
        if (eVar != e.f١٧٥٨d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f١٧٦١c = eVar;
                if (ATOMIC_HELPER.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.listeners;
                }
            } while (eVar != e.f١٧٥٨d);
        }
        e(runnable, executor);
    }

    protected void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        boolean z11;
        c cVar;
        boolean z12;
        Object obj = this.value;
        if (obj == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 | (obj instanceof g)) {
            if (GENERATE_CANCELLATION_CAUSES) {
                cVar = new c(z10, new CancellationException("Future.cancel() was called."));
            } else if (z10) {
                cVar = c.f١٧٥٢c;
            } else {
                cVar = c.f١٧٥٣d;
            }
            boolean z13 = false;
            a aVar = this;
            while (true) {
                if (ATOMIC_HELPER.b(aVar, obj, cVar)) {
                    if (z10) {
                        aVar.interruptTask();
                    }
                    complete(aVar);
                    if (!(obj instanceof g)) {
                        return true;
                    }
                    m8.d dVar = ((g) obj).f١٧٦٨b;
                    if (dVar instanceof a) {
                        aVar = (a) dVar;
                        obj = aVar.value;
                        if (obj == null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (!(z12 | (obj instanceof g))) {
                            return true;
                        }
                        z13 = true;
                    } else {
                        dVar.cancel(z10);
                        return true;
                    }
                } else {
                    obj = aVar.value;
                    if (!(obj instanceof g)) {
                        return z13;
                    }
                }
            }
        } else {
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) & (!(obj instanceof g))) {
                return f(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= SPIN_THRESHOLD_NANOS) {
                i iVar = this.waiters;
                if (iVar != i.f١٧٦٩c) {
                    i iVar2 = new i();
                    do {
                        iVar2.a(iVar);
                        if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof g))) {
                                        return f(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    h(iVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= SPIN_THRESHOLD_NANOS);
                            h(iVar2);
                        } else {
                            iVar = this.waiters;
                        }
                    } while (iVar != i.f١٧٦٩c);
                }
                return f(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) & (!(obj3 instanceof g))) {
                    return f(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + SPIN_THRESHOLD_NANOS < 0) {
                String str2 = str + " (plus ";
                long j11 = -nanos;
                long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(convert);
                boolean z10 = convert == 0 || nanos2 > SPIN_THRESHOLD_NANOS;
                if (convert > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    protected void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        boolean z10;
        if (this.value != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return (!(r0 instanceof g)) & z10;
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        boolean z10;
        if (future != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 & isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String pendingToString() {
        Object obj = this.value;
        if (obj instanceof g) {
            return "setFuture=[" + i(((g) obj).f١٧٦٨b) + "]";
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (ATOMIC_HELPER.b(this, null, obj)) {
            complete(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (ATOMIC_HELPER.b(this, null, new d((Throwable) checkNotNull(th)))) {
            complete(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean setFuture(m8.d dVar) {
        d dVar2;
        checkNotNull(dVar);
        Object obj = this.value;
        if (obj == null) {
            if (dVar.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(dVar))) {
                    return false;
                }
                complete(this);
                return true;
            }
            g gVar = new g(this, dVar);
            if (ATOMIC_HELPER.b(this, null, gVar)) {
                try {
                    dVar.addListener(gVar, androidx.concurrent.futures.d.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar2 = new d(th);
                    } catch (Throwable unused) {
                        dVar2 = d.f١٧٥٦b;
                    }
                    ATOMIC_HELPER.b(this, gVar, dVar2);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            dVar.cancel(((c) obj).f١٧٥٤a);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append(VideoEvent.PENDING);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        if ((obj instanceof c) && ((c) obj).f١٧٥٤a) {
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return f(obj2);
            }
            i iVar = this.waiters;
            if (iVar != i.f١٧٦٩c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                h(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return f(obj);
                    }
                    iVar = this.waiters;
                } while (iVar != i.f١٧٦٩c);
            }
            return f(this.value);
        }
        throw new InterruptedException();
    }
}

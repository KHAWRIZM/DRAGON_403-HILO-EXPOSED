package io.reactivex.rxjava3.core;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.jvm.internal.LongCompanionObject;
import zd.a1;
import zd.a2;
import zd.a3;
import zd.a4;
import zd.b1;
import zd.b2;
import zd.b3;
import zd.b4;
import zd.c1;
import zd.c2;
import zd.c3;
import zd.c4;
import zd.d1;
import zd.d2;
import zd.d3;
import zd.d4;
import zd.e1;
import zd.e2;
import zd.f1;
import zd.f2;
import zd.f3;
import zd.f4;
import zd.g1;
import zd.g2;
import zd.g3;
import zd.g4;
import zd.h1;
import zd.h2;
import zd.h3;
import zd.h4;
import zd.i1;
import zd.i2;
import zd.i3;
import zd.i4;
import zd.j1;
import zd.j2;
import zd.j3;
import zd.j4;
import zd.k1;
import zd.k2;
import zd.k3;
import zd.k4;
import zd.l1;
import zd.l2;
import zd.l3;
import zd.m1;
import zd.m2;
import zd.m3;
import zd.m4;
import zd.n0;
import zd.n1;
import zd.n2;
import zd.n3;
import zd.n4;
import zd.o0;
import zd.o1;
import zd.o2;
import zd.o3;
import zd.o4;
import zd.p1;
import zd.p2;
import zd.p3;
import zd.p4;
import zd.q0;
import zd.q1;
import zd.q2;
import zd.q3;
import zd.q4;
import zd.r0;
import zd.r1;
import zd.r3;
import zd.s0;
import zd.s1;
import zd.s2;
import zd.s3;
import zd.t0;
import zd.t1;
import zd.t2;
import zd.t3;
import zd.u0;
import zd.u1;
import zd.u2;
import zd.u3;
import zd.v0;
import zd.v1;
import zd.v2;
import zd.v3;
import zd.w1;
import zd.w2;
import zd.w3;
import zd.x0;
import zd.x1;
import zd.x2;
import zd.x3;
import zd.y0;
import zd.y1;
import zd.y2;
import zd.y3;
import zd.z0;
import zd.z1;
import zd.z2;
import zd.z3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class z<T> implements e0 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٤٩٨٠a;

        static {
            int[] iArr = new int[io.reactivex.rxjava3.core.a.values().length];
            f١٤٩٨٠a = iArr;
            try {
                iArr[io.reactivex.rxjava3.core.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٤٩٨٠a[io.reactivex.rxjava3.core.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٤٩٨٠a[io.reactivex.rxjava3.core.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٤٩٨٠a[io.reactivex.rxjava3.core.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private z a(pd.g gVar, pd.g gVar2, pd.a aVar, pd.a aVar2) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        Objects.requireNonNull(aVar2, "onAfterTerminate is null");
        return ie.a.o(new n0(this, gVar, gVar2, aVar, aVar2));
    }

    public static <T> z<T> amb(Iterable<? extends e0> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return ie.a.o(new zd.h(null, iterable));
    }

    @SafeVarargs
    public static <T> z<T> ambArray(e0... e0VarArr) {
        Objects.requireNonNull(e0VarArr, "sources is null");
        int length = e0VarArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(e0VarArr[0]);
        }
        return ie.a.o(new zd.h(e0VarArr, null));
    }

    private z b(long j10, TimeUnit timeUnit, e0 e0Var, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new c4(this, j10, timeUnit, h0Var, e0Var));
    }

    public static int bufferSize() {
        return h.b();
    }

    private z c(e0 e0Var, pd.o oVar, e0 e0Var2) {
        Objects.requireNonNull(oVar, "itemTimeoutIndicator is null");
        return ie.a.o(new b4(this, e0Var, oVar, e0Var2));
    }

    public static <T, R> z<R> combineLatest(Iterable<? extends e0> iterable, pd.o oVar) {
        return combineLatest(iterable, oVar, bufferSize());
    }

    public static <T, R> z<R> combineLatestArray(e0[] e0VarArr, pd.o oVar) {
        return combineLatestArray(e0VarArr, oVar, bufferSize());
    }

    public static <T, R> z<R> combineLatestArrayDelayError(e0[] e0VarArr, pd.o oVar) {
        return combineLatestArrayDelayError(e0VarArr, oVar, bufferSize());
    }

    public static <T, R> z<R> combineLatestDelayError(Iterable<? extends e0> iterable, pd.o oVar) {
        return combineLatestDelayError(iterable, oVar, bufferSize());
    }

    public static <T> z<T> concat(Iterable<? extends e0> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(rd.a.i(), false, bufferSize());
    }

    @SafeVarargs
    public static <T> z<T> concatArray(e0... e0VarArr) {
        Objects.requireNonNull(e0VarArr, "sources is null");
        if (e0VarArr.length == 0) {
            return empty();
        }
        if (e0VarArr.length == 1) {
            return wrap(e0VarArr[0]);
        }
        return ie.a.o(new zd.t(fromArray(e0VarArr), rd.a.i(), bufferSize(), fe.i.BOUNDARY));
    }

    @SafeVarargs
    public static <T> z<T> concatArrayDelayError(e0... e0VarArr) {
        Objects.requireNonNull(e0VarArr, "sources is null");
        if (e0VarArr.length == 0) {
            return empty();
        }
        if (e0VarArr.length == 1) {
            return wrap(e0VarArr[0]);
        }
        return concatDelayError(fromArray(e0VarArr));
    }

    @SafeVarargs
    public static <T> z<T> concatArrayEager(e0... e0VarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), e0VarArr);
    }

    @SafeVarargs
    public static <T> z<T> concatArrayEagerDelayError(e0... e0VarArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), e0VarArr);
    }

    public static <T> z<T> concatDelayError(Iterable<? extends e0> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> z<T> concatEager(Iterable<? extends e0> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> z<T> concatEagerDelayError(Iterable<? extends e0> iterable) {
        return concatEagerDelayError(iterable, bufferSize(), bufferSize());
    }

    public static <T> z<T> create(c0 c0Var) {
        Objects.requireNonNull(c0Var, "source is null");
        return ie.a.o(new zd.b0(c0Var));
    }

    public static <T> z<T> defer(pd.r rVar) {
        Objects.requireNonNull(rVar, "supplier is null");
        return ie.a.o(new zd.e0(rVar));
    }

    public static <T> z<T> empty() {
        return ie.a.o(s0.f٢٠٤٥٩a);
    }

    public static <T> z<T> error(pd.r rVar) {
        Objects.requireNonNull(rVar, "supplier is null");
        return ie.a.o(new t0(rVar));
    }

    public static <T> z<T> fromAction(pd.a aVar) {
        Objects.requireNonNull(aVar, "action is null");
        return ie.a.o(new b1(aVar));
    }

    @SafeVarargs
    public static <T> z<T> fromArray(T... tArr) {
        Objects.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return ie.a.o(new c1(tArr));
    }

    public static <T> z<T> fromCallable(Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return ie.a.o(new d1(callable));
    }

    public static <T> z<T> fromCompletable(f fVar) {
        Objects.requireNonNull(fVar, "completableSource is null");
        return ie.a.o(new e1(fVar));
    }

    public static <T> z<T> fromCompletionStage(CompletionStage<T> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return ie.a.o(new td.p(completionStage));
    }

    public static <T> z<T> fromFuture(Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return ie.a.o(new f1(future, 0L, null));
    }

    public static <T> z<T> fromIterable(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return ie.a.o(new g1(iterable));
    }

    public static <T> z<T> fromMaybe(n nVar) {
        Objects.requireNonNull(nVar, "maybe is null");
        return ie.a.o(new xd.c(nVar));
    }

    public static <T> z<T> fromOptional(Optional<T> optional) {
        Optional map;
        Object orElseGet;
        Objects.requireNonNull(optional, "optional is null");
        map = optional.map(new Function() { // from class: io.reactivex.rxjava3.core.w
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return z.just(obj);
            }
        });
        orElseGet = map.orElseGet(new Supplier() { // from class: io.reactivex.rxjava3.core.x
            @Override // java.util.function.Supplier
            public final Object get() {
                return z.empty();
            }
        });
        return (z) orElseGet;
    }

    public static <T> z<T> fromPublisher(kf.a aVar) {
        Objects.requireNonNull(aVar, "publisher is null");
        return ie.a.o(new h1(aVar));
    }

    public static <T> z<T> fromRunnable(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return ie.a.o(new i1(runnable));
    }

    public static <T> z<T> fromSingle(m0 m0Var) {
        Objects.requireNonNull(m0Var, "source is null");
        return ie.a.o(new ae.k(m0Var));
    }

    public static <T> z<T> fromStream(Stream<T> stream) {
        Objects.requireNonNull(stream, "stream is null");
        return ie.a.o(new td.q(stream));
    }

    public static <T> z<T> fromSupplier(pd.r rVar) {
        Objects.requireNonNull(rVar, "supplier is null");
        return ie.a.o(new j1(rVar));
    }

    public static <T> z<T> generate(pd.g gVar) {
        Objects.requireNonNull(gVar, "generator is null");
        return generate(rd.a.r(), r1.l(gVar), rd.a.g());
    }

    public static z<Long> interval(long j10, long j11, TimeUnit timeUnit) {
        return interval(j10, j11, timeUnit, ke.a.a());
    }

    public static z<Long> intervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit) {
        return intervalRange(j10, j11, j12, j13, timeUnit, ke.a.a());
    }

    public static <T> z<T> just(T t10) {
        Objects.requireNonNull(t10, "item is null");
        return ie.a.o(new v1(t10));
    }

    public static <T> z<T> merge(Iterable<? extends e0> iterable, int i10, int i11) {
        return fromIterable(iterable).flatMap(rd.a.i(), false, i10, i11);
    }

    @SafeVarargs
    public static <T> z<T> mergeArray(int i10, int i11, e0... e0VarArr) {
        return fromArray(e0VarArr).flatMap(rd.a.i(), false, i10, i11);
    }

    @SafeVarargs
    public static <T> z<T> mergeArrayDelayError(int i10, int i11, e0... e0VarArr) {
        return fromArray(e0VarArr).flatMap(rd.a.i(), true, i10, i11);
    }

    public static <T> z<T> mergeDelayError(Iterable<? extends e0> iterable) {
        return fromIterable(iterable).flatMap(rd.a.i(), true);
    }

    public static <T> z<T> never() {
        return ie.a.o(f2.f١٩٧٦٧a);
    }

    public static z<Integer> range(int i10, int i11) {
        if (i11 >= 0) {
            if (i11 == 0) {
                return empty();
            }
            if (i11 == 1) {
                return just(Integer.valueOf(i10));
            }
            if (i10 + (i11 - 1) <= 2147483647L) {
                return ie.a.o(new m2(i10, i11));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + i11);
    }

    public static z<Long> rangeLong(long j10, long j11) {
        if (j11 >= 0) {
            if (j11 == 0) {
                return empty();
            }
            if (j11 == 1) {
                return just(Long.valueOf(j10));
            }
            long j12 = (j11 - 1) + j10;
            if (j10 > 0 && j12 < 0) {
                throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
            }
            return ie.a.o(new n2(j10, j11));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j11);
    }

    public static <T> i0<Boolean> sequenceEqual(e0 e0Var, e0 e0Var2) {
        return sequenceEqual(e0Var, e0Var2, rd.b.a(), bufferSize());
    }

    public static <T> z<T> switchOnNext(e0 e0Var, int i10) {
        Objects.requireNonNull(e0Var, "sources is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new q3(e0Var, rd.a.i(), i10, false));
    }

    public static <T> z<T> switchOnNextDelayError(e0 e0Var) {
        return switchOnNextDelayError(e0Var, bufferSize());
    }

    public static z<Long> timer(long j10, TimeUnit timeUnit) {
        return timer(j10, timeUnit, ke.a.a());
    }

    public static <T> z<T> unsafeCreate(e0 e0Var) {
        Objects.requireNonNull(e0Var, "onSubscribe is null");
        if (!(e0Var instanceof z)) {
            return ie.a.o(new k1(e0Var));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> z<T> using(pd.r rVar, pd.o oVar, pd.g gVar) {
        return using(rVar, oVar, gVar, true);
    }

    public static <T> z<T> wrap(e0 e0Var) {
        Objects.requireNonNull(e0Var, "source is null");
        if (e0Var instanceof z) {
            return ie.a.o((z) e0Var);
        }
        return ie.a.o(new k1(e0Var));
    }

    public static <T, R> z<R> zip(Iterable<? extends e0> iterable, pd.o oVar) {
        Objects.requireNonNull(oVar, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        return ie.a.o(new p4(null, iterable, oVar, bufferSize(), false));
    }

    @SafeVarargs
    public static <T, R> z<R> zipArray(pd.o oVar, boolean z10, int i10, e0... e0VarArr) {
        Objects.requireNonNull(e0VarArr, "sources is null");
        if (e0VarArr.length == 0) {
            return empty();
        }
        Objects.requireNonNull(oVar, "zipper is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new p4(e0VarArr, null, oVar, i10, z10));
    }

    public final i0<Boolean> all(pd.q qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return ie.a.p(new zd.g(this, qVar));
    }

    public final z<T> ambWith(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return ambArray(this, e0Var);
    }

    public final i0<Boolean> any(pd.q qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return ie.a.p(new zd.j(this, qVar));
    }

    public final T blockingFirst() {
        ud.e eVar = new ud.e();
        subscribe(eVar);
        T t10 = (T) eVar.a();
        if (t10 != null) {
            return t10;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(pd.g gVar) {
        blockingForEach(gVar, bufferSize());
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        ud.f fVar = new ud.f();
        subscribe(fVar);
        T t10 = (T) fVar.a();
        if (t10 != null) {
            return t10;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new zd.c(this);
    }

    public final Iterable<T> blockingMostRecent(T t10) {
        Objects.requireNonNull(t10, "initialItem is null");
        return new zd.d(this, t10);
    }

    public final Iterable<T> blockingNext() {
        return new zd.e(this);
    }

    public final T blockingSingle() {
        T t10 = (T) singleElement().c();
        if (t10 != null) {
            return t10;
        }
        throw new NoSuchElementException();
    }

    public final Stream<T> blockingStream() {
        return blockingStream(bufferSize());
    }

    public final void blockingSubscribe() {
        zd.k.a(this);
    }

    public final z<List<T>> buffer(int i10) {
        return buffer(i10, i10);
    }

    public final z<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final z<T> cacheWithInitialCapacity(int i10) {
        rd.b.b(i10, "initialCapacity");
        return ie.a.o(new zd.p(this, i10));
    }

    public final <U> z<U> cast(Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return (z<U>) map(rd.a.d(cls));
    }

    public final <U> i0<U> collect(pd.r rVar, pd.b bVar) {
        Objects.requireNonNull(rVar, "initialItemSupplier is null");
        Objects.requireNonNull(bVar, "collector is null");
        return ie.a.p(new zd.r(this, rVar, bVar));
    }

    public final <U> i0<U> collectInto(U u10, pd.b bVar) {
        Objects.requireNonNull(u10, "initialItem is null");
        return collect(rd.a.l(u10), bVar);
    }

    public final <R> z<R> compose(f0 f0Var) {
        Objects.requireNonNull(f0Var, "composer is null");
        androidx.appcompat.app.a0.a(f0Var);
        throw null;
    }

    public final <R> z<R> concatMap(pd.o oVar) {
        return concatMap(oVar, 2);
    }

    public final b concatMapCompletable(pd.o oVar) {
        return concatMapCompletable(oVar, 2);
    }

    public final b concatMapCompletableDelayError(pd.o oVar) {
        return concatMapCompletableDelayError(oVar, true, 2);
    }

    public final <R> z<R> concatMapDelayError(pd.o oVar) {
        return concatMapDelayError(oVar, true, bufferSize());
    }

    public final <R> z<R> concatMapEager(pd.o oVar) {
        return concatMapEager(oVar, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> z<R> concatMapEagerDelayError(pd.o oVar, boolean z10) {
        return concatMapEagerDelayError(oVar, z10, Integer.MAX_VALUE, bufferSize());
    }

    public final <U> z<U> concatMapIterable(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new a1(this, oVar));
    }

    public final <R> z<R> concatMapMaybe(pd.o oVar) {
        return concatMapMaybe(oVar, 2);
    }

    public final <R> z<R> concatMapMaybeDelayError(pd.o oVar) {
        return concatMapMaybeDelayError(oVar, true, 2);
    }

    public final <R> z<R> concatMapSingle(pd.o oVar) {
        return concatMapSingle(oVar, 2);
    }

    public final <R> z<R> concatMapSingleDelayError(pd.o oVar) {
        return concatMapSingleDelayError(oVar, true, 2);
    }

    public final <R> z<R> concatMapStream(pd.o oVar) {
        return flatMapStream(oVar);
    }

    public final z<T> concatWith(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return concat(this, e0Var);
    }

    public final i0<Boolean> contains(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return any(rd.a.h(obj));
    }

    public final i0<Long> count() {
        return ie.a.p(new zd.a0(this));
    }

    public final <U> z<T> debounce(pd.o oVar) {
        Objects.requireNonNull(oVar, "debounceIndicator is null");
        return ie.a.o(new zd.c0(this, oVar));
    }

    public final z<T> defaultIfEmpty(T t10) {
        Objects.requireNonNull(t10, "defaultItem is null");
        return switchIfEmpty(just(t10));
    }

    public final <U> z<T> delay(pd.o oVar) {
        Objects.requireNonNull(oVar, "itemDelayIndicator is null");
        return (z<T>) flatMap(r1.c(oVar));
    }

    public final <U> z<T> delaySubscription(e0 e0Var) {
        Objects.requireNonNull(e0Var, "subscriptionIndicator is null");
        return ie.a.o(new zd.g0(this, e0Var));
    }

    public final <R> z<R> dematerialize(pd.o oVar) {
        Objects.requireNonNull(oVar, "selector is null");
        return ie.a.o(new zd.h0(this, oVar));
    }

    public final z<T> distinct() {
        return distinct(rd.a.i(), rd.a.f());
    }

    public final z<T> distinctUntilChanged() {
        return distinctUntilChanged(rd.a.i());
    }

    public final z<T> doAfterNext(pd.g gVar) {
        Objects.requireNonNull(gVar, "onAfterNext is null");
        return ie.a.o(new zd.l0(this, gVar));
    }

    public final z<T> doAfterTerminate(pd.a aVar) {
        Objects.requireNonNull(aVar, "onAfterTerminate is null");
        return a(rd.a.g(), rd.a.g(), rd.a.f١٧٥٠٢c, aVar);
    }

    public final z<T> doFinally(pd.a aVar) {
        Objects.requireNonNull(aVar, "onFinally is null");
        return ie.a.o(new zd.m0(this, aVar));
    }

    public final z<T> doOnComplete(pd.a aVar) {
        return a(rd.a.g(), rd.a.g(), aVar, rd.a.f١٧٥٠٢c);
    }

    public final z<T> doOnDispose(pd.a aVar) {
        return doOnLifecycle(rd.a.g(), aVar);
    }

    public final z<T> doOnEach(pd.g gVar) {
        Objects.requireNonNull(gVar, "onNotification is null");
        return a(rd.a.q(gVar), rd.a.p(gVar), rd.a.o(gVar), rd.a.f١٧٥٠٢c);
    }

    public final z<T> doOnError(pd.g gVar) {
        pd.g g10 = rd.a.g();
        pd.a aVar = rd.a.f١٧٥٠٢c;
        return a(g10, gVar, aVar, aVar);
    }

    public final z<T> doOnLifecycle(pd.g gVar, pd.a aVar) {
        Objects.requireNonNull(gVar, "onSubscribe is null");
        Objects.requireNonNull(aVar, "onDispose is null");
        return ie.a.o(new o0(this, gVar, aVar));
    }

    public final z<T> doOnNext(pd.g gVar) {
        pd.g g10 = rd.a.g();
        pd.a aVar = rd.a.f١٧٥٠٢c;
        return a(gVar, g10, aVar, aVar);
    }

    public final z<T> doOnSubscribe(pd.g gVar) {
        return doOnLifecycle(gVar, rd.a.f١٧٥٠٢c);
    }

    public final z<T> doOnTerminate(pd.a aVar) {
        Objects.requireNonNull(aVar, "onTerminate is null");
        return a(rd.a.g(), rd.a.a(aVar), aVar, rd.a.f١٧٥٠٢c);
    }

    public final j<T> elementAt(long j10) {
        if (j10 >= 0) {
            return ie.a.n(new q0(this, j10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final i0<T> elementAtOrError(long j10) {
        if (j10 >= 0) {
            return ie.a.p(new r0(this, j10, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final z<T> filter(pd.q qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return ie.a.o(new u0(this, qVar));
    }

    public final i0<T> first(T t10) {
        return elementAt(0L, t10);
    }

    public final j<T> firstElement() {
        return elementAt(0L);
    }

    public final i0<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final CompletionStage<T> firstOrErrorStage() {
        return p.a(subscribeWith(new td.j(false, null)));
    }

    public final CompletionStage<T> firstStage(T t10) {
        return p.a(subscribeWith(new td.j(true, t10)));
    }

    public final <R> z<R> flatMap(pd.o oVar) {
        return flatMap(oVar, false);
    }

    public final b flatMapCompletable(pd.o oVar) {
        return flatMapCompletable(oVar, false);
    }

    public final <U> z<U> flatMapIterable(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new a1(this, oVar));
    }

    public final <R> z<R> flatMapMaybe(pd.o oVar) {
        return flatMapMaybe(oVar, false);
    }

    public final <R> z<R> flatMapSingle(pd.o oVar) {
        return flatMapSingle(oVar, false);
    }

    public final <R> z<R> flatMapStream(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new td.m(this, oVar));
    }

    public final nd.c forEach(pd.g gVar) {
        return subscribe(gVar);
    }

    public final nd.c forEachWhile(pd.q qVar) {
        return forEachWhile(qVar, rd.a.f١٧٥٠٥f, rd.a.f١٧٥٠٢c);
    }

    public final <K> z<ge.b> groupBy(pd.o oVar) {
        return groupBy(oVar, rd.a.i(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> z<R> groupJoin(e0 e0Var, pd.o oVar, pd.o oVar2, pd.c cVar) {
        Objects.requireNonNull(e0Var, "other is null");
        Objects.requireNonNull(oVar, "leftEnd is null");
        Objects.requireNonNull(oVar2, "rightEnd is null");
        Objects.requireNonNull(cVar, "resultSelector is null");
        return ie.a.o(new n1(this, e0Var, oVar, oVar2, cVar));
    }

    public final z<T> hide() {
        return ie.a.o(new o1(this));
    }

    public final b ignoreElements() {
        return ie.a.l(new q1(this));
    }

    public final i0<Boolean> isEmpty() {
        return all(rd.a.b());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> z<R> join(e0 e0Var, pd.o oVar, pd.o oVar2, pd.c cVar) {
        Objects.requireNonNull(e0Var, "other is null");
        Objects.requireNonNull(oVar, "leftEnd is null");
        Objects.requireNonNull(oVar2, "rightEnd is null");
        Objects.requireNonNull(cVar, "resultSelector is null");
        return ie.a.o(new u1(this, e0Var, oVar, oVar2, cVar));
    }

    public final i0<T> last(T t10) {
        Objects.requireNonNull(t10, "defaultItem is null");
        return ie.a.p(new x1(this, t10));
    }

    public final j<T> lastElement() {
        return ie.a.n(new w1(this));
    }

    public final i0<T> lastOrError() {
        return ie.a.p(new x1(this, null));
    }

    public final CompletionStage<T> lastOrErrorStage() {
        return p.a(subscribeWith(new td.s(false, null)));
    }

    public final CompletionStage<T> lastStage(T t10) {
        return p.a(subscribeWith(new td.s(true, t10)));
    }

    public final <R> z<R> lift(d0 d0Var) {
        Objects.requireNonNull(d0Var, "lifter is null");
        return ie.a.o(new y1(this, d0Var));
    }

    public final <R> z<R> map(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new z1(this, oVar));
    }

    public final <R> z<R> mapOptional(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new td.w(this, oVar));
    }

    public final z<o> materialize() {
        return ie.a.o(new b2(this));
    }

    public final z<T> mergeWith(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return merge(this, e0Var);
    }

    public final z<T> observeOn(h0 h0Var) {
        return observeOn(h0Var, false, bufferSize());
    }

    public final <U> z<U> ofType(Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return filter(rd.a.j(cls)).cast(cls);
    }

    public final z<T> onErrorComplete() {
        return onErrorComplete(rd.a.c());
    }

    public final z<T> onErrorResumeNext(pd.o oVar) {
        Objects.requireNonNull(oVar, "fallbackSupplier is null");
        return ie.a.o(new i2(this, oVar));
    }

    public final z<T> onErrorResumeWith(e0 e0Var) {
        Objects.requireNonNull(e0Var, "fallback is null");
        return onErrorResumeNext(rd.a.k(e0Var));
    }

    public final z<T> onErrorReturn(pd.o oVar) {
        Objects.requireNonNull(oVar, "itemSupplier is null");
        return ie.a.o(new j2(this, oVar));
    }

    public final z<T> onErrorReturnItem(T t10) {
        Objects.requireNonNull(t10, "item is null");
        return onErrorReturn(rd.a.k(t10));
    }

    public final z<T> onTerminateDetach() {
        return ie.a.o(new zd.i0(this));
    }

    public final ge.a publish() {
        return ie.a.k(new k2(this));
    }

    public final j<T> reduce(pd.c cVar) {
        Objects.requireNonNull(cVar, "reducer is null");
        return ie.a.n(new o2(this, cVar));
    }

    public final <R> i0<R> reduceWith(pd.r rVar, pd.c cVar) {
        Objects.requireNonNull(rVar, "seedSupplier is null");
        Objects.requireNonNull(cVar, "reducer is null");
        return ie.a.p(new q2(this, rVar, cVar));
    }

    public final z<T> repeat() {
        return repeat(LongCompanionObject.MAX_VALUE);
    }

    public final z<T> repeatUntil(pd.e eVar) {
        Objects.requireNonNull(eVar, "stop is null");
        return ie.a.o(new t2(this, eVar));
    }

    public final z<T> repeatWhen(pd.o oVar) {
        Objects.requireNonNull(oVar, "handler is null");
        return ie.a.o(new u2(this, oVar));
    }

    public final ge.a replay() {
        return v2.k(this);
    }

    public final z<T> retry() {
        return retry(LongCompanionObject.MAX_VALUE, rd.a.c());
    }

    public final z<T> retryUntil(pd.e eVar) {
        Objects.requireNonNull(eVar, "stop is null");
        return retry(LongCompanionObject.MAX_VALUE, rd.a.s(eVar));
    }

    public final z<T> retryWhen(pd.o oVar) {
        Objects.requireNonNull(oVar, "handler is null");
        return ie.a.o(new y2(this, oVar));
    }

    public final void safeSubscribe(g0 g0Var) {
        Objects.requireNonNull(g0Var, "observer is null");
        if (g0Var instanceof he.d) {
            subscribe(g0Var);
        } else {
            subscribe(new he.d(g0Var));
        }
    }

    public final z<T> sample(long j10, TimeUnit timeUnit) {
        return sample(j10, timeUnit, ke.a.a());
    }

    public final z<T> scan(pd.c cVar) {
        Objects.requireNonNull(cVar, "accumulator is null");
        return ie.a.o(new c3(this, cVar));
    }

    public final <R> z<R> scanWith(pd.r rVar, pd.c cVar) {
        Objects.requireNonNull(rVar, "seedSupplier is null");
        Objects.requireNonNull(cVar, "accumulator is null");
        return ie.a.o(new d3(this, rVar, cVar));
    }

    public final z<T> serialize() {
        return ie.a.o(new g3(this));
    }

    public final z<T> share() {
        return publish().e();
    }

    public final i0<T> single(T t10) {
        Objects.requireNonNull(t10, "defaultItem is null");
        return ie.a.p(new i3(this, t10));
    }

    public final j<T> singleElement() {
        return ie.a.n(new h3(this));
    }

    public final i0<T> singleOrError() {
        return ie.a.p(new i3(this, null));
    }

    public final CompletionStage<T> singleOrErrorStage() {
        return p.a(subscribeWith(new td.y(false, null)));
    }

    public final CompletionStage<T> singleStage(T t10) {
        return p.a(subscribeWith(new td.y(true, t10)));
    }

    public final z<T> skip(long j10) {
        if (j10 >= 0) {
            if (j10 == 0) {
                return ie.a.o(this);
            }
            return ie.a.o(new j3(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 expected but it was " + j10);
    }

    public final z<T> skipLast(int i10) {
        if (i10 >= 0) {
            if (i10 == 0) {
                return ie.a.o(this);
            }
            return ie.a.o(new k3(this, i10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + i10);
    }

    public final <U> z<T> skipUntil(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return ie.a.o(new m3(this, e0Var));
    }

    public final z<T> skipWhile(pd.q qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return ie.a.o(new n3(this, qVar));
    }

    public final z<T> sorted() {
        return toList().q().map(rd.a.m(rd.a.n())).flatMapIterable(rd.a.i());
    }

    public final z<T> startWith(f fVar) {
        Objects.requireNonNull(fVar, "other is null");
        return concat(b.h(fVar).g(), this);
    }

    @SafeVarargs
    public final z<T> startWithArray(T... tArr) {
        z fromArray = fromArray(tArr);
        if (fromArray == empty()) {
            return ie.a.o(this);
        }
        return concatArray(fromArray, this);
    }

    public final z<T> startWithItem(T t10) {
        return concatArray(just(t10), this);
    }

    public final z<T> startWithIterable(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final nd.c subscribe() {
        return subscribe(rd.a.g(), rd.a.f١٧٥٠٥f, rd.a.f١٧٥٠٢c);
    }

    protected abstract void subscribeActual(g0 g0Var);

    public final z<T> subscribeOn(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new o3(this, h0Var));
    }

    public final <E extends g0> E subscribeWith(E e10) {
        subscribe(e10);
        return e10;
    }

    public final z<T> switchIfEmpty(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return ie.a.o(new p3(this, e0Var));
    }

    public final <R> z<R> switchMap(pd.o oVar) {
        return switchMap(oVar, bufferSize());
    }

    public final b switchMapCompletable(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.l(new yd.d(this, oVar, false));
    }

    public final b switchMapCompletableDelayError(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.l(new yd.d(this, oVar, true));
    }

    public final <R> z<R> switchMapDelayError(pd.o oVar) {
        return switchMapDelayError(oVar, bufferSize());
    }

    public final <R> z<R> switchMapMaybe(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new yd.e(this, oVar, false));
    }

    public final <R> z<R> switchMapMaybeDelayError(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new yd.e(this, oVar, true));
    }

    public final <R> z<R> switchMapSingle(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new yd.f(this, oVar, false));
    }

    public final <R> z<R> switchMapSingleDelayError(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new yd.f(this, oVar, true));
    }

    public final z<T> take(long j10) {
        if (j10 >= 0) {
            return ie.a.o(new r3(this, j10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    public final z<T> takeLast(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i10);
        }
        if (i10 == 0) {
            return ie.a.o(new p1(this));
        }
        if (i10 == 1) {
            return ie.a.o(new t3(this));
        }
        return ie.a.o(new s3(this, i10));
    }

    public final <U> z<T> takeUntil(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return ie.a.o(new v3(this, e0Var));
    }

    public final z<T> takeWhile(pd.q qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return ie.a.o(new x3(this, qVar));
    }

    public final he.f test() {
        he.f fVar = new he.f();
        subscribe(fVar);
        return fVar;
    }

    public final z<T> throttleFirst(long j10, TimeUnit timeUnit) {
        return throttleFirst(j10, timeUnit, ke.a.a());
    }

    public final z<T> throttleLast(long j10, TimeUnit timeUnit) {
        return sample(j10, timeUnit);
    }

    public final z<T> throttleLatest(long j10, TimeUnit timeUnit) {
        return throttleLatest(j10, timeUnit, ke.a.a(), false);
    }

    public final z<T> throttleWithTimeout(long j10, TimeUnit timeUnit) {
        return debounce(j10, timeUnit);
    }

    public final z<ke.b> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, ke.a.a());
    }

    public final <V> z<T> timeout(pd.o oVar) {
        return c(null, oVar, null);
    }

    public final z<ke.b> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, ke.a.a());
    }

    public final <R> R to(a0 a0Var) {
        Objects.requireNonNull(a0Var, "converter is null");
        androidx.appcompat.app.a0.a(a0Var);
        throw null;
    }

    public final h<T> toFlowable(io.reactivex.rxjava3.core.a aVar) {
        Objects.requireNonNull(aVar, "strategy is null");
        wd.b bVar = new wd.b(this);
        int i10 = a.f١٤٩٨٠a[aVar.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return bVar.h();
                    }
                    return ie.a.m(new wd.i(bVar));
                }
                return bVar;
            }
            return bVar.k();
        }
        return bVar.j();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new ud.n());
    }

    public final i0<List<T>> toList() {
        return toList(16);
    }

    public final <K> i0<Map<K, T>> toMap(pd.o oVar) {
        Objects.requireNonNull(oVar, "keySelector is null");
        return (i0<Map<K, T>>) collect(fe.l.a(), rd.a.C(oVar));
    }

    public final <K> i0<Map<K, Collection<T>>> toMultimap(pd.o oVar) {
        return (i0<Map<K, Collection<T>>>) toMultimap(oVar, rd.a.i(), fe.l.a(), fe.b.c());
    }

    public final i0<List<T>> toSortedList() {
        return toSortedList(rd.a.n());
    }

    public final z<T> unsubscribeOn(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new g4(this, h0Var));
    }

    public final z<z<T>> window(long j10) {
        return window(j10, j10, bufferSize());
    }

    public final <U, R> z<R> withLatestFrom(e0 e0Var, pd.c cVar) {
        Objects.requireNonNull(e0Var, "other is null");
        Objects.requireNonNull(cVar, "combiner is null");
        return ie.a.o(new n4(this, cVar, e0Var));
    }

    public final <U, R> z<R> zipWith(Iterable<U> iterable, pd.c cVar) {
        Objects.requireNonNull(iterable, "other is null");
        Objects.requireNonNull(cVar, "zipper is null");
        return ie.a.o(new q4(this, iterable, cVar));
    }

    public static <T, R> z<R> combineLatest(Iterable<? extends e0> iterable, pd.o oVar, int i10) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(oVar, "combiner is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new zd.s(null, iterable, oVar, i10 << 1, false));
    }

    public static <T, R> z<R> combineLatestArray(e0[] e0VarArr, pd.o oVar, int i10) {
        Objects.requireNonNull(e0VarArr, "sources is null");
        if (e0VarArr.length == 0) {
            return empty();
        }
        Objects.requireNonNull(oVar, "combiner is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new zd.s(e0VarArr, null, oVar, i10 << 1, false));
    }

    public static <T, R> z<R> combineLatestArrayDelayError(e0[] e0VarArr, pd.o oVar, int i10) {
        Objects.requireNonNull(e0VarArr, "sources is null");
        Objects.requireNonNull(oVar, "combiner is null");
        rd.b.b(i10, "bufferSize");
        if (e0VarArr.length == 0) {
            return empty();
        }
        return ie.a.o(new zd.s(e0VarArr, null, oVar, i10 << 1, true));
    }

    public static <T, R> z<R> combineLatestDelayError(Iterable<? extends e0> iterable, pd.o oVar, int i10) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(oVar, "combiner is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new zd.s(null, iterable, oVar, i10 << 1, true));
    }

    @SafeVarargs
    public static <T> z<T> concatArrayEager(int i10, int i11, e0... e0VarArr) {
        return fromArray(e0VarArr).concatMapEagerDelayError(rd.a.i(), false, i10, i11);
    }

    @SafeVarargs
    public static <T> z<T> concatArrayEagerDelayError(int i10, int i11, e0... e0VarArr) {
        return fromArray(e0VarArr).concatMapEagerDelayError(rd.a.i(), true, i10, i11);
    }

    public static <T> z<T> concatEager(Iterable<? extends e0> iterable, int i10, int i11) {
        return fromIterable(iterable).concatMapEagerDelayError(rd.a.i(), false, i10, i11);
    }

    public static <T> z<T> concatEagerDelayError(Iterable<? extends e0> iterable, int i10, int i11) {
        return fromIterable(iterable).concatMapEagerDelayError(rd.a.i(), true, i10, i11);
    }

    public static z<Long> interval(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new s1(Math.max(0L, j10), Math.max(0L, j11), timeUnit, h0Var));
    }

    public static z<Long> intervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit, h0 h0Var) {
        if (j11 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j11);
        }
        if (j11 == 0) {
            return empty().delay(j12, timeUnit, h0Var);
        }
        long j14 = j10 + (j11 - 1);
        if (j10 > 0 && j14 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new t1(j10, j14, Math.max(0L, j12), Math.max(0L, j13), timeUnit, h0Var));
    }

    public static <T> z<T> merge(Iterable<? extends e0> iterable) {
        return fromIterable(iterable).flatMap(rd.a.i());
    }

    @SafeVarargs
    public static <T> z<T> mergeArray(e0... e0VarArr) {
        return fromArray(e0VarArr).flatMap(rd.a.i(), e0VarArr.length);
    }

    @SafeVarargs
    public static <T> z<T> mergeArrayDelayError(e0... e0VarArr) {
        return fromArray(e0VarArr).flatMap(rd.a.i(), true, e0VarArr.length);
    }

    public static <T> z<T> mergeDelayError(Iterable<? extends e0> iterable, int i10, int i11) {
        return fromIterable(iterable).flatMap(rd.a.i(), true, i10, i11);
    }

    public static <T> i0<Boolean> sequenceEqual(e0 e0Var, e0 e0Var2, pd.d dVar) {
        return sequenceEqual(e0Var, e0Var2, dVar, bufferSize());
    }

    public static <T> z<T> switchOnNextDelayError(e0 e0Var, int i10) {
        Objects.requireNonNull(e0Var, "sources is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new q3(e0Var, rd.a.i(), i10, true));
    }

    public static z<Long> timer(long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new d4(Math.max(j10, 0L), timeUnit, h0Var));
    }

    public static <T, D> z<T> using(pd.r rVar, pd.o oVar, pd.g gVar, boolean z10) {
        Objects.requireNonNull(rVar, "resourceSupplier is null");
        Objects.requireNonNull(oVar, "sourceSupplier is null");
        Objects.requireNonNull(gVar, "resourceCleanup is null");
        return ie.a.o(new h4(rVar, oVar, gVar, z10));
    }

    public final void blockingForEach(pd.g gVar, int i10) {
        Objects.requireNonNull(gVar, "onNext is null");
        Iterator<T> it = blockingIterable(i10).iterator();
        while (it.hasNext()) {
            try {
                gVar.accept(it.next());
            } catch (Throwable th) {
                od.b.b(th);
                ((nd.c) it).dispose();
                throw fe.j.g(th);
            }
        }
    }

    public final Iterable<T> blockingIterable(int i10) {
        rd.b.b(i10, "capacityHint");
        return new zd.b(this, i10);
    }

    public final Stream<T> blockingStream(int i10) {
        Spliterator spliteratorUnknownSize;
        Stream stream;
        BaseStream onClose;
        Iterator<T> it = blockingIterable(i10).iterator();
        spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(it, 0);
        stream = StreamSupport.stream(spliteratorUnknownSize, false);
        final nd.c cVar = (nd.c) it;
        cVar.getClass();
        onClose = stream.onClose(new Runnable() { // from class: io.reactivex.rxjava3.core.y
            @Override // java.lang.Runnable
            public final void run() {
                nd.c.this.dispose();
            }
        });
        return v.a(onClose);
    }

    public final void blockingSubscribe(pd.g gVar) {
        zd.k.c(this, gVar, rd.a.f١٧٥٠٥f, rd.a.f١٧٥٠٢c);
    }

    public final z<List<T>> buffer(int i10, int i11) {
        return (z<List<T>>) buffer(i10, i11, fe.b.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> z<R> concatMap(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        if (this instanceof sd.h) {
            Object obj = ((sd.h) this).get();
            if (obj == null) {
                return empty();
            }
            return b3.a(obj, oVar);
        }
        return ie.a.o(new zd.t(this, oVar, i10, fe.i.IMMEDIATE));
    }

    public final b concatMapCompletable(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "capacityHint");
        return ie.a.l(new yd.a(this, oVar, fe.i.IMMEDIATE, i10));
    }

    public final b concatMapCompletableDelayError(pd.o oVar, boolean z10) {
        return concatMapCompletableDelayError(oVar, z10, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> z<R> concatMapDelayError(pd.o oVar, boolean z10, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        if (this instanceof sd.h) {
            Object obj = ((sd.h) this).get();
            if (obj == null) {
                return empty();
            }
            return b3.a(obj, oVar);
        }
        return ie.a.o(new zd.t(this, oVar, i10, z10 ? fe.i.END : fe.i.BOUNDARY));
    }

    public final <R> z<R> concatMapEager(pd.o oVar, int i10, int i11) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "maxConcurrency");
        rd.b.b(i11, "bufferSize");
        return ie.a.o(new zd.u(this, oVar, fe.i.IMMEDIATE, i10, i11));
    }

    public final <R> z<R> concatMapEagerDelayError(pd.o oVar, boolean z10, int i10, int i11) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "maxConcurrency");
        rd.b.b(i11, "bufferSize");
        return ie.a.o(new zd.u(this, oVar, z10 ? fe.i.END : fe.i.BOUNDARY, i10, i11));
    }

    public final <R> z<R> concatMapMaybe(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new yd.b(this, oVar, fe.i.IMMEDIATE, i10));
    }

    public final <R> z<R> concatMapMaybeDelayError(pd.o oVar, boolean z10) {
        return concatMapMaybeDelayError(oVar, z10, 2);
    }

    public final <R> z<R> concatMapSingle(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new yd.c(this, oVar, fe.i.IMMEDIATE, i10));
    }

    public final <R> z<R> concatMapSingleDelayError(pd.o oVar, boolean z10) {
        return concatMapSingleDelayError(oVar, z10, 2);
    }

    public final <K> z<T> distinct(pd.o oVar) {
        return distinct(oVar, rd.a.f());
    }

    public final <K> z<T> distinctUntilChanged(pd.o oVar) {
        Objects.requireNonNull(oVar, "keySelector is null");
        return ie.a.o(new zd.k0(this, oVar, rd.b.a()));
    }

    public final <R> z<R> flatMap(pd.o oVar, boolean z10) {
        return flatMap(oVar, z10, Integer.MAX_VALUE);
    }

    public final b flatMapCompletable(pd.o oVar, boolean z10) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.l(new x0(this, oVar, z10));
    }

    public final <R> z<R> flatMapMaybe(pd.o oVar, boolean z10) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new y0(this, oVar, z10));
    }

    public final <R> z<R> flatMapSingle(pd.o oVar, boolean z10) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.o(new z0(this, oVar, z10));
    }

    public final nd.c forEachWhile(pd.q qVar, pd.g gVar) {
        return forEachWhile(qVar, gVar, rd.a.f١٧٥٠٢c);
    }

    public final <K> z<ge.b> groupBy(pd.o oVar, boolean z10) {
        return groupBy(oVar, rd.a.i(), z10, bufferSize());
    }

    public final z<T> observeOn(h0 h0Var, boolean z10) {
        return observeOn(h0Var, z10, bufferSize());
    }

    public final z<T> onErrorComplete(pd.q qVar) {
        Objects.requireNonNull(qVar, "predicate is null");
        return ie.a.o(new h2(this, qVar));
    }

    public final <R> z<R> publish(pd.o oVar) {
        Objects.requireNonNull(oVar, "selector is null");
        return ie.a.o(new l2(this, oVar));
    }

    public final z<T> repeat(long j10) {
        if (j10 >= 0) {
            if (j10 == 0) {
                return empty();
            }
            return ie.a.o(new s2(this, j10));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    public final <R> z<R> replay(pd.o oVar) {
        Objects.requireNonNull(oVar, "selector is null");
        return v2.l(r1.g(this), oVar);
    }

    public final z<T> retry(pd.d dVar) {
        Objects.requireNonNull(dVar, "predicate is null");
        return ie.a.o(new w2(this, dVar));
    }

    public final z<T> sample(long j10, TimeUnit timeUnit, boolean z10) {
        return sample(j10, timeUnit, ke.a.a(), z10);
    }

    public final z<T> sorted(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return toList().q().map(rd.a.m(comparator)).flatMapIterable(rd.a.i());
    }

    public final nd.c subscribe(pd.g gVar) {
        return subscribe(gVar, rd.a.f١٧٥٠٥f, rd.a.f١٧٥٠٢c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> z<R> switchMap(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        if (this instanceof sd.h) {
            Object obj = ((sd.h) this).get();
            if (obj == null) {
                return empty();
            }
            return b3.a(obj, oVar);
        }
        return ie.a.o(new q3(this, oVar, i10, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> z<R> switchMapDelayError(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        if (this instanceof sd.h) {
            Object obj = ((sd.h) this).get();
            if (obj == null) {
                return empty();
            }
            return b3.a(obj, oVar);
        }
        return ie.a.o(new q3(this, oVar, i10, true));
    }

    public final z<T> throttleFirst(long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new y3(this, j10, timeUnit, h0Var));
    }

    public final z<T> throttleLast(long j10, TimeUnit timeUnit, h0 h0Var) {
        return sample(j10, timeUnit, h0Var);
    }

    public final z<T> throttleLatest(long j10, TimeUnit timeUnit, boolean z10) {
        return throttleLatest(j10, timeUnit, ke.a.a(), z10);
    }

    public final z<T> throttleWithTimeout(long j10, TimeUnit timeUnit, h0 h0Var) {
        return debounce(j10, timeUnit, h0Var);
    }

    public final z<ke.b> timeInterval(h0 h0Var) {
        return timeInterval(TimeUnit.MILLISECONDS, h0Var);
    }

    public final <V> z<T> timeout(pd.o oVar, e0 e0Var) {
        Objects.requireNonNull(e0Var, "fallback is null");
        return c(null, oVar, e0Var);
    }

    public final z<ke.b> timestamp(h0 h0Var) {
        return timestamp(TimeUnit.MILLISECONDS, h0Var);
    }

    public final i0<List<T>> toList(int i10) {
        rd.b.b(i10, "capacityHint");
        return ie.a.p(new f4(this, i10));
    }

    public final i0<List<T>> toSortedList(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return toList().j(rd.a.m(comparator));
    }

    public final z<z<T>> window(long j10, long j11) {
        return window(j10, j11, bufferSize());
    }

    public static <T> z<T> concat(e0 e0Var) {
        return concat(e0Var, bufferSize());
    }

    public static <T> z<T> concatDelayError(e0 e0Var) {
        return concatDelayError(e0Var, bufferSize(), true);
    }

    public static <T> z<T> concatEager(e0 e0Var) {
        return concatEager(e0Var, bufferSize(), bufferSize());
    }

    public static <T> z<T> concatEagerDelayError(e0 e0Var) {
        return concatEagerDelayError(e0Var, bufferSize(), bufferSize());
    }

    public static <T> z<T> error(Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return error(rd.a.l(th));
    }

    public static <T> z<T> fromFuture(Future<? extends T> future, long j10, TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return ie.a.o(new f1(future, j10, timeUnit));
    }

    public static <T> z<T> just(T t10, T t11) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        return fromArray(t10, t11);
    }

    public static <T> z<T> merge(Iterable<? extends e0> iterable, int i10) {
        return fromIterable(iterable).flatMap(rd.a.i(), i10);
    }

    public static <T> z<T> mergeDelayError(Iterable<? extends e0> iterable, int i10) {
        return fromIterable(iterable).flatMap(rd.a.i(), true, i10);
    }

    public static <T> i0<Boolean> sequenceEqual(e0 e0Var, e0 e0Var2, pd.d dVar, int i10) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(dVar, "isEqual is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.p(new f3(e0Var, e0Var2, dVar, i10));
    }

    public final T blockingSingle(T t10) {
        return (T) single(t10).c();
    }

    public final void blockingSubscribe(pd.g gVar, pd.g gVar2) {
        zd.k.c(this, gVar, gVar2, rd.a.f١٧٥٠٢c);
    }

    public final <U extends Collection<? super T>> z<U> buffer(int i10, int i11, pd.r rVar) {
        rd.b.b(i10, "count");
        rd.b.b(i11, "skip");
        Objects.requireNonNull(rVar, "bufferSupplier is null");
        return ie.a.o(new zd.l(this, i10, i11, rVar));
    }

    public final b concatMapCompletableDelayError(pd.o oVar, boolean z10, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.l(new yd.a(this, oVar, z10 ? fe.i.END : fe.i.BOUNDARY, i10));
    }

    public final <R> z<R> concatMapMaybeDelayError(pd.o oVar, boolean z10, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new yd.b(this, oVar, z10 ? fe.i.END : fe.i.BOUNDARY, i10));
    }

    public final <R> z<R> concatMapSingleDelayError(pd.o oVar, boolean z10, int i10) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new yd.c(this, oVar, z10 ? fe.i.END : fe.i.BOUNDARY, i10));
    }

    public final z<T> concatWith(m0 m0Var) {
        Objects.requireNonNull(m0Var, "other is null");
        return ie.a.o(new zd.y(this, m0Var));
    }

    public final z<T> debounce(long j10, TimeUnit timeUnit) {
        return debounce(j10, timeUnit, ke.a.a());
    }

    public final z<T> delay(long j10, TimeUnit timeUnit) {
        return delay(j10, timeUnit, ke.a.a(), false);
    }

    public final z<T> delaySubscription(long j10, TimeUnit timeUnit) {
        return delaySubscription(j10, timeUnit, ke.a.a());
    }

    public final <K> z<T> distinct(pd.o oVar, pd.r rVar) {
        Objects.requireNonNull(oVar, "keySelector is null");
        Objects.requireNonNull(rVar, "collectionSupplier is null");
        return ie.a.o(new zd.j0(this, oVar, rVar));
    }

    public final i0<T> elementAt(long j10, T t10) {
        if (j10 >= 0) {
            Objects.requireNonNull(t10, "defaultItem is null");
            return ie.a.p(new r0(this, j10, t10));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j10);
    }

    public final <R> z<R> flatMap(pd.o oVar, boolean z10, int i10) {
        return flatMap(oVar, z10, i10, bufferSize());
    }

    public final <U, V> z<V> flatMapIterable(pd.o oVar, pd.c cVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        Objects.requireNonNull(cVar, "combiner is null");
        return (z<V>) flatMap(r1.a(oVar), cVar, false, bufferSize(), bufferSize());
    }

    public final nd.c forEachWhile(pd.q qVar, pd.g gVar, pd.a aVar) {
        Objects.requireNonNull(qVar, "onNext is null");
        Objects.requireNonNull(gVar, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        ud.m mVar = new ud.m(qVar, gVar, aVar);
        subscribe(mVar);
        return mVar;
    }

    public final <K, V> z<ge.b> groupBy(pd.o oVar, pd.o oVar2) {
        return groupBy(oVar, oVar2, false, bufferSize());
    }

    public final z<T> mergeWith(m0 m0Var) {
        Objects.requireNonNull(m0Var, "other is null");
        return ie.a.o(new e2(this, m0Var));
    }

    public final z<T> observeOn(h0 h0Var, boolean z10, int i10) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new g2(this, h0Var, z10, i10));
    }

    public final <R> i0<R> reduce(R r10, pd.c cVar) {
        Objects.requireNonNull(r10, "seed is null");
        Objects.requireNonNull(cVar, "reducer is null");
        return ie.a.p(new p2(this, r10, cVar));
    }

    public final z<T> sample(long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new z2(this, j10, timeUnit, h0Var, false));
    }

    public final <R> z<R> scan(R r10, pd.c cVar) {
        Objects.requireNonNull(r10, "initialValue is null");
        return scanWith(rd.a.l(r10), cVar);
    }

    public final z<T> startWith(m0 m0Var) {
        Objects.requireNonNull(m0Var, "other is null");
        return concat(i0.r(m0Var).q(), this);
    }

    public final nd.c subscribe(pd.g gVar, pd.g gVar2) {
        return subscribe(gVar, gVar2, rd.a.f١٧٥٠٢c);
    }

    public final z<T> take(long j10, TimeUnit timeUnit) {
        return takeUntil(timer(j10, timeUnit));
    }

    public final z<T> takeUntil(pd.q qVar) {
        Objects.requireNonNull(qVar, "stopPredicate is null");
        return ie.a.o(new w3(this, qVar));
    }

    public final he.f test(boolean z10) {
        he.f fVar = new he.f();
        if (z10) {
            fVar.dispose();
        }
        subscribe(fVar);
        return fVar;
    }

    public final z<T> throttleLatest(long j10, TimeUnit timeUnit, h0 h0Var) {
        return throttleLatest(j10, timeUnit, h0Var, false);
    }

    public final z<ke.b> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, ke.a.a());
    }

    public final z<ke.b> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, ke.a.a());
    }

    public final <K, V> i0<Map<K, V>> toMap(pd.o oVar, pd.o oVar2) {
        Objects.requireNonNull(oVar, "keySelector is null");
        Objects.requireNonNull(oVar2, "valueSelector is null");
        return (i0<Map<K, V>>) collect(fe.l.a(), rd.a.D(oVar, oVar2));
    }

    public final z<z<T>> window(long j10, long j11, int i10) {
        rd.b.c(j10, "count");
        rd.b.c(j11, "skip");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new i4(this, j10, j11, i10));
    }

    public static <T> z<T> concat(e0 e0Var, int i10) {
        Objects.requireNonNull(e0Var, "sources is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new zd.t(e0Var, rd.a.i(), i10, fe.i.IMMEDIATE));
    }

    public static <T> z<T> concatDelayError(e0 e0Var, int i10, boolean z10) {
        Objects.requireNonNull(e0Var, "sources is null");
        rd.b.b(i10, "bufferSize is null");
        return ie.a.o(new zd.t(e0Var, rd.a.i(), i10, z10 ? fe.i.END : fe.i.BOUNDARY));
    }

    public static <T> z<T> concatEager(e0 e0Var, int i10, int i11) {
        return wrap(e0Var).concatMapEager(rd.a.i(), i10, i11);
    }

    public static <T> z<T> concatEagerDelayError(e0 e0Var, int i10, int i11) {
        return wrap(e0Var).concatMapEagerDelayError(rd.a.i(), true, i10, i11);
    }

    public static <T> z<T> merge(e0 e0Var) {
        Objects.requireNonNull(e0Var, "sources is null");
        return ie.a.o(new v0(e0Var, rd.a.i(), false, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> z<T> mergeDelayError(e0 e0Var) {
        Objects.requireNonNull(e0Var, "sources is null");
        return ie.a.o(new v0(e0Var, rd.a.i(), true, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> z<T> switchOnNext(e0 e0Var) {
        return switchOnNext(e0Var, bufferSize());
    }

    public static <T, R> z<R> zip(Iterable<? extends e0> iterable, pd.o oVar, boolean z10, int i10) {
        Objects.requireNonNull(oVar, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new p4(null, iterable, oVar, i10, z10));
    }

    public final void blockingSubscribe(pd.g gVar, pd.g gVar2, pd.a aVar) {
        zd.k.c(this, gVar, gVar2, aVar);
    }

    public final <R, A> i0<R> collect(Collector<T, A, R> collector) {
        Objects.requireNonNull(collector, "collector is null");
        return ie.a.p(new td.h(this, collector));
    }

    public final z<T> debounce(long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new zd.d0(this, j10, timeUnit, h0Var));
    }

    public final z<T> delay(long j10, TimeUnit timeUnit, boolean z10) {
        return delay(j10, timeUnit, ke.a.a(), z10);
    }

    public final z<T> delaySubscription(long j10, TimeUnit timeUnit, h0 h0Var) {
        return delaySubscription(timer(j10, timeUnit, h0Var));
    }

    public final z<T> distinctUntilChanged(pd.d dVar) {
        Objects.requireNonNull(dVar, "comparer is null");
        return ie.a.o(new zd.k0(this, rd.a.i(), dVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> z<R> flatMap(pd.o oVar, boolean z10, int i10, int i11) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "maxConcurrency");
        rd.b.b(i11, "bufferSize");
        if (this instanceof sd.h) {
            Object obj = ((sd.h) this).get();
            if (obj == null) {
                return empty();
            }
            return b3.a(obj, oVar);
        }
        return ie.a.o(new v0(this, oVar, z10, i10, i11));
    }

    public final <K, V> z<ge.b> groupBy(pd.o oVar, pd.o oVar2, boolean z10) {
        return groupBy(oVar, oVar2, z10, bufferSize());
    }

    public final <R> z<R> replay(pd.o oVar, int i10) {
        Objects.requireNonNull(oVar, "selector is null");
        rd.b.b(i10, "bufferSize");
        return v2.l(r1.i(this, i10, false), oVar);
    }

    public final z<T> retry(long j10) {
        return retry(j10, rd.a.c());
    }

    public final z<T> skip(long j10, TimeUnit timeUnit) {
        return skipUntil(timer(j10, timeUnit));
    }

    public final z<T> skipLast(long j10, TimeUnit timeUnit) {
        return skipLast(j10, timeUnit, ke.a.c(), false, bufferSize());
    }

    public final nd.c subscribe(pd.g gVar, pd.g gVar2, pd.a aVar) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        ud.q qVar = new ud.q(gVar, gVar2, aVar, rd.a.g());
        subscribe(qVar);
        return qVar;
    }

    public final z<T> take(long j10, TimeUnit timeUnit, h0 h0Var) {
        return takeUntil(timer(j10, timeUnit, h0Var));
    }

    public final z<T> throttleLatest(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new z3(this, j10, timeUnit, h0Var, z10));
    }

    public final z<ke.b> timeInterval(TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new a4(this, timeUnit, h0Var));
    }

    public final z<T> timeout(long j10, TimeUnit timeUnit) {
        return b(j10, timeUnit, null, ke.a.a());
    }

    public final z<ke.b> timestamp(TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return map(rd.a.t(timeUnit, h0Var));
    }

    public final <U extends Collection<? super T>> i0<U> toList(pd.r rVar) {
        Objects.requireNonNull(rVar, "collectionSupplier is null");
        return ie.a.p(new f4(this, rVar));
    }

    public final i0<List<T>> toSortedList(Comparator<? super T> comparator, int i10) {
        Objects.requireNonNull(comparator, "comparator is null");
        return toList(i10).j(rd.a.m(comparator));
    }

    public final <T1, T2, R> z<R> withLatestFrom(e0 e0Var, e0 e0Var2, pd.h hVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(hVar, "combiner is null");
        return withLatestFrom(new e0[]{e0Var, e0Var2}, rd.a.v(hVar));
    }

    public final <U, R> z<R> zipWith(e0 e0Var, pd.c cVar) {
        Objects.requireNonNull(e0Var, "other is null");
        return zip(this, e0Var, cVar);
    }

    public static <T, S> z<T> generate(pd.r rVar, pd.b bVar) {
        Objects.requireNonNull(bVar, "generator is null");
        return generate(rVar, r1.k(bVar), rd.a.g());
    }

    public static z<Long> interval(long j10, TimeUnit timeUnit) {
        return interval(j10, j10, timeUnit, ke.a.a());
    }

    public final T blockingFirst(T t10) {
        Objects.requireNonNull(t10, "defaultItem is null");
        ud.e eVar = new ud.e();
        subscribe(eVar);
        T t11 = (T) eVar.a();
        return t11 != null ? t11 : t10;
    }

    public final T blockingLast(T t10) {
        Objects.requireNonNull(t10, "defaultItem is null");
        ud.f fVar = new ud.f();
        subscribe(fVar);
        T t11 = (T) fVar.a();
        return t11 != null ? t11 : t10;
    }

    public final void blockingSubscribe(g0 g0Var) {
        Objects.requireNonNull(g0Var, "observer is null");
        zd.k.b(this, g0Var);
    }

    public final z<T> concatWith(n nVar) {
        Objects.requireNonNull(nVar, "other is null");
        return ie.a.o(new zd.x(this, nVar));
    }

    public final z<T> delay(long j10, TimeUnit timeUnit, h0 h0Var) {
        return delay(j10, timeUnit, h0Var, false);
    }

    public final <K, V> z<ge.b> groupBy(pd.o oVar, pd.o oVar2, boolean z10, int i10) {
        Objects.requireNonNull(oVar, "keySelector is null");
        Objects.requireNonNull(oVar2, "valueSelector is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new m1(this, oVar, oVar2, i10, z10));
    }

    public final z<T> mergeWith(n nVar) {
        Objects.requireNonNull(nVar, "other is null");
        return ie.a.o(new d2(this, nVar));
    }

    public final z<T> retry(long j10, pd.q qVar) {
        if (j10 >= 0) {
            Objects.requireNonNull(qVar, "predicate is null");
            return ie.a.o(new x2(this, j10, qVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j10);
    }

    public final z<T> skip(long j10, TimeUnit timeUnit, h0 h0Var) {
        return skipUntil(timer(j10, timeUnit, h0Var));
    }

    public final z<T> skipLast(long j10, TimeUnit timeUnit, boolean z10) {
        return skipLast(j10, timeUnit, ke.a.c(), z10, bufferSize());
    }

    public final z<T> startWith(n nVar) {
        Objects.requireNonNull(nVar, "other is null");
        return concat(j.g(nVar).f(), this);
    }

    public final z<T> takeLast(long j10, long j11, TimeUnit timeUnit) {
        return takeLast(j10, j11, timeUnit, ke.a.c(), false, bufferSize());
    }

    public final z<T> timeout(long j10, TimeUnit timeUnit, e0 e0Var) {
        Objects.requireNonNull(e0Var, "fallback is null");
        return b(j10, timeUnit, e0Var, ke.a.a());
    }

    public final <K, V> i0<Map<K, Collection<V>>> toMultimap(pd.o oVar, pd.o oVar2) {
        return toMultimap(oVar, oVar2, fe.l.a(), fe.b.c());
    }

    public static <T1, T2, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, pd.c cVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(cVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2}, rd.a.u(cVar), bufferSize());
    }

    public static z<Long> interval(long j10, TimeUnit timeUnit, h0 h0Var) {
        return interval(j10, j10, timeUnit, h0Var);
    }

    public static <T> z<T> just(T t10, T t11, T t12) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        return fromArray(t10, t11, t12);
    }

    public static <T> z<T> merge(e0 e0Var, int i10) {
        Objects.requireNonNull(e0Var, "sources is null");
        rd.b.b(i10, "maxConcurrency");
        return ie.a.o(new v0(e0Var, rd.a.i(), false, i10, bufferSize()));
    }

    public static <T> z<T> mergeDelayError(e0 e0Var, int i10) {
        Objects.requireNonNull(e0Var, "sources is null");
        rd.b.b(i10, "maxConcurrency");
        return ie.a.o(new v0(e0Var, rd.a.i(), true, i10, bufferSize()));
    }

    public final z<T> delay(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new zd.f0(this, j10, timeUnit, h0Var, z10));
    }

    public final z<T> doOnEach(g0 g0Var) {
        Objects.requireNonNull(g0Var, "observer is null");
        return a(r1.f(g0Var), r1.e(g0Var), r1.d(g0Var), rd.a.f١٧٥٠٢c);
    }

    public final z<T> sample(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new z2(this, j10, timeUnit, h0Var, z10));
    }

    public final z<T> skipLast(long j10, TimeUnit timeUnit, h0 h0Var) {
        return skipLast(j10, timeUnit, h0Var, false, bufferSize());
    }

    public final z<T> takeLast(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return takeLast(j10, j11, timeUnit, h0Var, false, bufferSize());
    }

    public final <K, V> i0<Map<K, V>> toMap(pd.o oVar, pd.o oVar2, pd.r rVar) {
        Objects.requireNonNull(oVar, "keySelector is null");
        Objects.requireNonNull(oVar2, "valueSelector is null");
        Objects.requireNonNull(rVar, "mapSupplier is null");
        return (i0<Map<K, V>>) collect(rVar, rd.a.D(oVar, oVar2));
    }

    public final i0<List<T>> toSortedList(int i10) {
        return toSortedList(rd.a.n(), i10);
    }

    public final <U, R> z<R> zipWith(e0 e0Var, pd.c cVar, boolean z10) {
        return zip(this, e0Var, cVar, z10);
    }

    public static <T> z<T> concat(e0 e0Var, e0 e0Var2) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        return concatArray(e0Var, e0Var2);
    }

    public static <T, S> z<T> generate(pd.r rVar, pd.b bVar, pd.g gVar) {
        Objects.requireNonNull(bVar, "generator is null");
        return generate(rVar, r1.k(bVar), gVar);
    }

    public final <U extends Collection<? super T>> z<U> buffer(int i10, pd.r rVar) {
        return buffer(i10, i10, rVar);
    }

    public final z<T> concatWith(f fVar) {
        Objects.requireNonNull(fVar, "other is null");
        return ie.a.o(new zd.w(this, fVar));
    }

    public final z<T> mergeWith(f fVar) {
        Objects.requireNonNull(fVar, "other is null");
        return ie.a.o(new c2(this, fVar));
    }

    public final <R> z<R> replay(pd.o oVar, int i10, boolean z10) {
        Objects.requireNonNull(oVar, "selector is null");
        rd.b.b(i10, "bufferSize");
        return v2.l(r1.i(this, i10, z10), oVar);
    }

    public final z<T> skipLast(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        return skipLast(j10, timeUnit, h0Var, z10, bufferSize());
    }

    public final z<T> startWith(e0 e0Var) {
        Objects.requireNonNull(e0Var, "other is null");
        return concatArray(e0Var, this);
    }

    public final z<T> takeLast(long j10, long j11, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        rd.b.b(i10, "bufferSize");
        if (j10 >= 0) {
            return ie.a.o(new u3(this, j10, j11, timeUnit, h0Var, i10, z10));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j10);
    }

    public final z<T> timeout(long j10, TimeUnit timeUnit, h0 h0Var, e0 e0Var) {
        Objects.requireNonNull(e0Var, "fallback is null");
        return b(j10, timeUnit, e0Var, h0Var);
    }

    public final z<z<T>> window(long j10, long j11, TimeUnit timeUnit) {
        return window(j10, j11, timeUnit, ke.a.a(), bufferSize());
    }

    public final <U, R> z<R> zipWith(e0 e0Var, pd.c cVar, boolean z10, int i10) {
        return zip(this, e0Var, cVar, z10, i10);
    }

    public static <T> i0<Boolean> sequenceEqual(e0 e0Var, e0 e0Var2, int i10) {
        return sequenceEqual(e0Var, e0Var2, rd.b.a(), i10);
    }

    public static <T1, T2, R> z<R> zip(e0 e0Var, e0 e0Var2, pd.c cVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(cVar, "zipper is null");
        return zipArray(rd.a.u(cVar), false, bufferSize(), e0Var, e0Var2);
    }

    public final z<List<T>> buffer(long j10, long j11, TimeUnit timeUnit) {
        return (z<List<T>>) buffer(j10, j11, timeUnit, ke.a.a(), fe.b.d());
    }

    public final z<T> retry(pd.q qVar) {
        return retry(LongCompanionObject.MAX_VALUE, qVar);
    }

    public final z<T> skipLast(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new l3(this, j10, timeUnit, h0Var, i10 << 1, z10));
    }

    public final <K, V> i0<Map<K, Collection<V>>> toMultimap(pd.o oVar, pd.o oVar2, pd.r rVar, pd.o oVar3) {
        Objects.requireNonNull(oVar, "keySelector is null");
        Objects.requireNonNull(oVar2, "valueSelector is null");
        Objects.requireNonNull(rVar, "mapSupplier is null");
        Objects.requireNonNull(oVar3, "collectionFactory is null");
        return (i0<Map<K, Collection<V>>>) collect(rVar, rd.a.E(oVar, oVar2, oVar3));
    }

    public final z<z<T>> window(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return window(j10, j11, timeUnit, h0Var, bufferSize());
    }

    public static <T, S> z<T> generate(pd.r rVar, pd.c cVar) {
        return generate(rVar, cVar, rd.a.g());
    }

    public static <T> z<T> merge(e0 e0Var, e0 e0Var2) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        return fromArray(e0Var, e0Var2).flatMap(rd.a.i(), false, 2);
    }

    public static <T> z<T> mergeDelayError(e0 e0Var, e0 e0Var2) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        return fromArray(e0Var, e0Var2).flatMap(rd.a.i(), true, 2);
    }

    public final z<List<T>> buffer(long j10, long j11, TimeUnit timeUnit, h0 h0Var) {
        return (z<List<T>>) buffer(j10, j11, timeUnit, h0Var, fe.b.d());
    }

    public final <R> z<R> concatMap(pd.o oVar, int i10, h0 h0Var) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new zd.v(this, oVar, i10, fe.i.IMMEDIATE, h0Var));
    }

    public final <R> z<R> concatMapDelayError(pd.o oVar, boolean z10, int i10, h0 h0Var) {
        Objects.requireNonNull(oVar, "mapper is null");
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.o(new zd.v(this, oVar, i10, z10 ? fe.i.END : fe.i.BOUNDARY, h0Var));
    }

    public final <U, V> z<T> delay(e0 e0Var, pd.o oVar) {
        return delaySubscription(e0Var).delay(oVar);
    }

    public final <U> z<T> sample(e0 e0Var) {
        Objects.requireNonNull(e0Var, "sampler is null");
        return ie.a.o(new a3(this, e0Var, false));
    }

    @Override // io.reactivex.rxjava3.core.e0
    public final void subscribe(g0 g0Var) {
        Objects.requireNonNull(g0Var, "observer is null");
        try {
            g0 x10 = ie.a.x(this, g0Var);
            Objects.requireNonNull(x10, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(x10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final z<T> timeout(long j10, TimeUnit timeUnit, h0 h0Var) {
        return b(j10, timeUnit, null, h0Var);
    }

    public final z<z<T>> window(long j10, long j11, TimeUnit timeUnit, h0 h0Var, int i10) {
        rd.b.c(j10, "timespan");
        rd.b.c(j11, "timeskip");
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(h0Var, "scheduler is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return ie.a.o(new m4(this, j10, j11, timeUnit, h0Var, LongCompanionObject.MAX_VALUE, i10, false));
    }

    public final <T1, T2, T3, R> z<R> withLatestFrom(e0 e0Var, e0 e0Var2, e0 e0Var3, pd.i iVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(iVar, "combiner is null");
        return withLatestFrom(new e0[]{e0Var, e0Var2, e0Var3}, rd.a.w(iVar));
    }

    public static <T1, T2, T3, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, pd.h hVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(hVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3}, rd.a.v(hVar), bufferSize());
    }

    public static <T> z<T> concat(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        return concatArray(e0Var, e0Var2, e0Var3);
    }

    public static <T, S> z<T> generate(pd.r rVar, pd.c cVar, pd.g gVar) {
        Objects.requireNonNull(rVar, "initialState is null");
        Objects.requireNonNull(cVar, "generator is null");
        Objects.requireNonNull(gVar, "disposeState is null");
        return ie.a.o(new l1(rVar, cVar, gVar));
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        return fromArray(t10, t11, t12, t13);
    }

    public final <U extends Collection<? super T>> z<U> buffer(long j10, long j11, TimeUnit timeUnit, h0 h0Var, pd.r rVar) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        Objects.requireNonNull(rVar, "bufferSupplier is null");
        return ie.a.o(new zd.o(this, j10, j11, timeUnit, h0Var, rVar, Integer.MAX_VALUE, false));
    }

    public final <R> z<R> replay(pd.o oVar, int i10, long j10, TimeUnit timeUnit) {
        return replay(oVar, i10, j10, timeUnit, ke.a.a());
    }

    public final <U, V> z<T> timeout(e0 e0Var, pd.o oVar) {
        Objects.requireNonNull(e0Var, "firstTimeoutIndicator is null");
        return c(e0Var, oVar, null);
    }

    public final <R> z<R> replay(pd.o oVar, int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(oVar, "selector is null");
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.l(r1.h(this, i10, j10, timeUnit, h0Var, false), oVar);
    }

    public final <U> z<T> sample(e0 e0Var, boolean z10) {
        Objects.requireNonNull(e0Var, "sampler is null");
        return ie.a.o(new a3(this, e0Var, z10));
    }

    public static <T> z<T> merge(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        return fromArray(e0Var, e0Var2, e0Var3).flatMap(rd.a.i(), false, 3);
    }

    public static <T> z<T> mergeDelayError(e0 e0Var, e0 e0Var2, e0 e0Var3) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        return fromArray(e0Var, e0Var2, e0Var3).flatMap(rd.a.i(), true, 3);
    }

    public static <T1, T2, R> z<R> zip(e0 e0Var, e0 e0Var2, pd.c cVar, boolean z10) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(cVar, "zipper is null");
        return zipArray(rd.a.u(cVar), z10, bufferSize(), e0Var, e0Var2);
    }

    public final <R> z<R> flatMap(pd.o oVar, pd.o oVar2, pd.r rVar) {
        Objects.requireNonNull(oVar, "onNextMapper is null");
        Objects.requireNonNull(oVar2, "onErrorMapper is null");
        Objects.requireNonNull(rVar, "onCompleteSupplier is null");
        return merge(new a2(this, oVar, oVar2, rVar));
    }

    public final z<T> takeLast(long j10, TimeUnit timeUnit) {
        return takeLast(j10, timeUnit, ke.a.c(), false, bufferSize());
    }

    public final <U, V> z<T> timeout(e0 e0Var, pd.o oVar, e0 e0Var2) {
        Objects.requireNonNull(e0Var, "firstTimeoutIndicator is null");
        Objects.requireNonNull(e0Var2, "fallback is null");
        return c(e0Var, oVar, e0Var2);
    }

    public final z<T> takeLast(long j10, TimeUnit timeUnit, boolean z10) {
        return takeLast(j10, timeUnit, ke.a.c(), z10, bufferSize());
    }

    public final <K, V> i0<Map<K, Collection<V>>> toMultimap(pd.o oVar, pd.o oVar2, pd.r rVar) {
        return toMultimap(oVar, oVar2, rVar, fe.b.c());
    }

    public static <T> z<T> concat(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        return concatArray(e0Var, e0Var2, e0Var3, e0Var4);
    }

    public final z<List<T>> buffer(long j10, TimeUnit timeUnit) {
        return buffer(j10, timeUnit, ke.a.a(), Integer.MAX_VALUE);
    }

    public final z<T> takeLast(long j10, TimeUnit timeUnit, h0 h0Var) {
        return takeLast(j10, timeUnit, h0Var, false, bufferSize());
    }

    public static <T1, T2, T3, T4, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, pd.i iVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(iVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3, e0Var4}, rd.a.w(iVar), bufferSize());
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13, T t14) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        Objects.requireNonNull(t14, "item5 is null");
        return fromArray(t10, t11, t12, t13, t14);
    }

    public final z<List<T>> buffer(long j10, TimeUnit timeUnit, int i10) {
        return buffer(j10, timeUnit, ke.a.a(), i10);
    }

    public final z<T> takeLast(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        return takeLast(j10, timeUnit, h0Var, z10, bufferSize());
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit) {
        return window(j10, timeUnit, ke.a.a(), LongCompanionObject.MAX_VALUE, false);
    }

    public final <T1, T2, T3, T4, R> z<R> withLatestFrom(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, pd.j jVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(jVar, "combiner is null");
        return withLatestFrom(new e0[]{e0Var, e0Var2, e0Var3, e0Var4}, rd.a.x(jVar));
    }

    public static <T> z<T> merge(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        return fromArray(e0Var, e0Var2, e0Var3, e0Var4).flatMap(rd.a.i(), false, 4);
    }

    public static <T> z<T> mergeDelayError(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        return fromArray(e0Var, e0Var2, e0Var3, e0Var4).flatMap(rd.a.i(), true, 4);
    }

    public static <T1, T2, R> z<R> zip(e0 e0Var, e0 e0Var2, pd.c cVar, boolean z10, int i10) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(cVar, "zipper is null");
        return zipArray(rd.a.u(cVar), z10, i10, e0Var, e0Var2);
    }

    public final z<List<T>> buffer(long j10, TimeUnit timeUnit, h0 h0Var, int i10) {
        return (z<List<T>>) buffer(j10, timeUnit, h0Var, i10, fe.b.d(), false);
    }

    public final <R> z<R> flatMap(pd.o oVar, pd.o oVar2, pd.r rVar, int i10) {
        Objects.requireNonNull(oVar, "onNextMapper is null");
        Objects.requireNonNull(oVar2, "onErrorMapper is null");
        Objects.requireNonNull(rVar, "onCompleteSupplier is null");
        return merge(new a2(this, oVar, oVar2, rVar), i10);
    }

    public final z<T> takeLast(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10, int i10) {
        return takeLast(LongCompanionObject.MAX_VALUE, j10, timeUnit, h0Var, z10, i10);
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit, long j11) {
        return window(j10, timeUnit, ke.a.a(), j11, false);
    }

    public final <U extends Collection<? super T>> z<U> buffer(long j10, TimeUnit timeUnit, h0 h0Var, int i10, pd.r rVar, boolean z10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        Objects.requireNonNull(rVar, "bufferSupplier is null");
        rd.b.b(i10, "count");
        return ie.a.o(new zd.o(this, j10, j10, timeUnit, h0Var, rVar, i10, z10));
    }

    public final <R> z<R> replay(pd.o oVar, int i10, long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        Objects.requireNonNull(oVar, "selector is null");
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.l(r1.h(this, i10, j10, timeUnit, h0Var, z10), oVar);
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit, long j11, boolean z10) {
        return window(j10, timeUnit, ke.a.a(), j11, z10);
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit, h0 h0Var) {
        return window(j10, timeUnit, h0Var, LongCompanionObject.MAX_VALUE, false);
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit, h0 h0Var, long j11) {
        return window(j10, timeUnit, h0Var, j11, false);
    }

    public static <T1, T2, T3, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, pd.h hVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(hVar, "zipper is null");
        return zipArray(rd.a.v(hVar), false, bufferSize(), e0Var, e0Var2, e0Var3);
    }

    public final <R> z<R> flatMap(pd.o oVar, int i10) {
        return flatMap(oVar, false, i10, bufferSize());
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit, h0 h0Var, long j11, boolean z10) {
        return window(j10, timeUnit, h0Var, j11, z10, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, pd.j jVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(jVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3, e0Var4, e0Var5}, rd.a.x(jVar), bufferSize());
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13, T t14, T t15) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        Objects.requireNonNull(t14, "item5 is null");
        Objects.requireNonNull(t15, "item6 is null");
        return fromArray(t10, t11, t12, t13, t14, t15);
    }

    public final <U, R> z<R> flatMap(pd.o oVar, pd.c cVar) {
        return flatMap(oVar, cVar, false, bufferSize(), bufferSize());
    }

    public final z<z<T>> window(long j10, TimeUnit timeUnit, h0 h0Var, long j11, boolean z10, int i10) {
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(h0Var, "scheduler is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        rd.b.c(j11, "count");
        return ie.a.o(new m4(this, j10, j10, timeUnit, h0Var, j11, i10, z10));
    }

    public final z<List<T>> buffer(long j10, TimeUnit timeUnit, h0 h0Var) {
        return (z<List<T>>) buffer(j10, timeUnit, h0Var, Integer.MAX_VALUE, fe.b.d(), false);
    }

    public final <U, R> z<R> flatMap(pd.o oVar, pd.c cVar, boolean z10) {
        return flatMap(oVar, cVar, z10, bufferSize(), bufferSize());
    }

    public final <R> z<R> withLatestFrom(e0[] e0VarArr, pd.o oVar) {
        Objects.requireNonNull(e0VarArr, "others is null");
        Objects.requireNonNull(oVar, "combiner is null");
        return ie.a.o(new o4(this, e0VarArr, oVar));
    }

    public final <TOpening, TClosing> z<List<T>> buffer(e0 e0Var, pd.o oVar) {
        return (z<List<T>>) buffer(e0Var, oVar, fe.b.d());
    }

    public final <U, R> z<R> flatMap(pd.o oVar, pd.c cVar, boolean z10, int i10) {
        return flatMap(oVar, cVar, z10, i10, bufferSize());
    }

    public final <R> z<R> replay(pd.o oVar, long j10, TimeUnit timeUnit) {
        return replay(oVar, j10, timeUnit, ke.a.a());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> z<U> buffer(e0 e0Var, pd.o oVar, pd.r rVar) {
        Objects.requireNonNull(e0Var, "openingIndicator is null");
        Objects.requireNonNull(oVar, "closingIndicator is null");
        Objects.requireNonNull(rVar, "bufferSupplier is null");
        return ie.a.o(new zd.m(this, e0Var, oVar, rVar));
    }

    public final <U, R> z<R> flatMap(pd.o oVar, pd.c cVar, boolean z10, int i10, int i11) {
        Objects.requireNonNull(oVar, "mapper is null");
        Objects.requireNonNull(cVar, "combiner is null");
        return flatMap(r1.b(oVar, cVar), z10, i10, i11);
    }

    public final <R> z<R> replay(pd.o oVar, long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(oVar, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.l(r1.j(this, j10, timeUnit, h0Var, false), oVar);
    }

    public static <T1, T2, T3, T4, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, pd.i iVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(iVar, "zipper is null");
        return zipArray(rd.a.w(iVar), false, bufferSize(), e0Var, e0Var2, e0Var3, e0Var4);
    }

    public final <R> z<R> withLatestFrom(Iterable<? extends e0> iterable, pd.o oVar) {
        Objects.requireNonNull(iterable, "others is null");
        Objects.requireNonNull(oVar, "combiner is null");
        return ie.a.o(new o4(this, iterable, oVar));
    }

    public final <B> z<z<T>> window(e0 e0Var) {
        return window(e0Var, bufferSize());
    }

    public final <U, R> z<R> flatMap(pd.o oVar, pd.c cVar, int i10) {
        return flatMap(oVar, cVar, false, i10, bufferSize());
    }

    public final <B> z<z<T>> window(e0 e0Var, int i10) {
        Objects.requireNonNull(e0Var, "boundaryIndicator is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new j4(this, e0Var, i10));
    }

    public static <T1, T2, T3, T4, T5, T6, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, pd.k kVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(kVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6}, rd.a.y(kVar), bufferSize());
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        Objects.requireNonNull(t14, "item5 is null");
        Objects.requireNonNull(t15, "item6 is null");
        Objects.requireNonNull(t16, "item7 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16);
    }

    public final <B> z<List<T>> buffer(e0 e0Var) {
        return (z<List<T>>) buffer(e0Var, fe.b.d());
    }

    public final <R> z<R> replay(pd.o oVar, long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        Objects.requireNonNull(oVar, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.l(r1.j(this, j10, timeUnit, h0Var, z10), oVar);
    }

    public final <B> z<List<T>> buffer(e0 e0Var, int i10) {
        rd.b.b(i10, "initialCapacity");
        return (z<List<T>>) buffer(e0Var, rd.a.e(i10));
    }

    public final <U, V> z<z<T>> window(e0 e0Var, pd.o oVar) {
        return window(e0Var, oVar, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, pd.j jVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(jVar, "zipper is null");
        return zipArray(rd.a.x(jVar), false, bufferSize(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5);
    }

    public final <B, U extends Collection<? super T>> z<U> buffer(e0 e0Var, pd.r rVar) {
        Objects.requireNonNull(e0Var, "boundaryIndicator is null");
        Objects.requireNonNull(rVar, "bufferSupplier is null");
        return ie.a.o(new zd.n(this, e0Var, rVar));
    }

    public final <U, V> z<z<T>> window(e0 e0Var, pd.o oVar, int i10) {
        Objects.requireNonNull(e0Var, "openingIndicator is null");
        Objects.requireNonNull(oVar, "closingIndicator is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.o(new k4(this, e0Var, oVar, i10));
    }

    public final ge.a replay(int i10) {
        rd.b.b(i10, "bufferSize");
        return v2.g(this, i10, false);
    }

    public final ge.a replay(int i10, boolean z10) {
        rd.b.b(i10, "bufferSize");
        return v2.g(this, i10, z10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, e0 e0Var7, pd.l lVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(e0Var7, "source7 is null");
        Objects.requireNonNull(lVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7}, rd.a.z(lVar), bufferSize());
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        Objects.requireNonNull(t14, "item5 is null");
        Objects.requireNonNull(t15, "item6 is null");
        Objects.requireNonNull(t16, "item7 is null");
        Objects.requireNonNull(t17, "item8 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17);
    }

    public final ge.a replay(int i10, long j10, TimeUnit timeUnit) {
        return replay(i10, j10, timeUnit, ke.a.a());
    }

    public final ge.a replay(int i10, long j10, TimeUnit timeUnit, h0 h0Var) {
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.h(this, j10, timeUnit, h0Var, i10, false);
    }

    public static <T1, T2, T3, T4, T5, T6, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, pd.k kVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(kVar, "zipper is null");
        return zipArray(rd.a.y(kVar), false, bufferSize(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6);
    }

    public final ge.a replay(int i10, long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        rd.b.b(i10, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.h(this, j10, timeUnit, h0Var, i10, z10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, e0 e0Var7, e0 e0Var8, pd.m mVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(e0Var7, "source7 is null");
        Objects.requireNonNull(e0Var8, "source8 is null");
        Objects.requireNonNull(mVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8}, rd.a.A(mVar), bufferSize());
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        Objects.requireNonNull(t14, "item5 is null");
        Objects.requireNonNull(t15, "item6 is null");
        Objects.requireNonNull(t16, "item7 is null");
        Objects.requireNonNull(t17, "item8 is null");
        Objects.requireNonNull(t18, "item9 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17, t18);
    }

    public final ge.a replay(long j10, TimeUnit timeUnit) {
        return replay(j10, timeUnit, ke.a.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, e0 e0Var7, pd.l lVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(e0Var7, "source7 is null");
        Objects.requireNonNull(lVar, "zipper is null");
        return zipArray(rd.a.z(lVar), false, bufferSize(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7);
    }

    public final ge.a replay(long j10, TimeUnit timeUnit, h0 h0Var) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.i(this, j10, timeUnit, h0Var, false);
    }

    public final ge.a replay(long j10, TimeUnit timeUnit, h0 h0Var, boolean z10) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(h0Var, "scheduler is null");
        return v2.i(this, j10, timeUnit, h0Var, z10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> z<R> combineLatest(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, e0 e0Var7, e0 e0Var8, e0 e0Var9, pd.n nVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(e0Var7, "source7 is null");
        Objects.requireNonNull(e0Var8, "source8 is null");
        Objects.requireNonNull(e0Var9, "source9 is null");
        Objects.requireNonNull(nVar, "combiner is null");
        return combineLatestArray(new e0[]{e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8, e0Var9}, rd.a.B(nVar), bufferSize());
    }

    public static <T> z<T> just(T t10, T t11, T t12, T t13, T t14, T t15, T t16, T t17, T t18, T t19) {
        Objects.requireNonNull(t10, "item1 is null");
        Objects.requireNonNull(t11, "item2 is null");
        Objects.requireNonNull(t12, "item3 is null");
        Objects.requireNonNull(t13, "item4 is null");
        Objects.requireNonNull(t14, "item5 is null");
        Objects.requireNonNull(t15, "item6 is null");
        Objects.requireNonNull(t16, "item7 is null");
        Objects.requireNonNull(t17, "item8 is null");
        Objects.requireNonNull(t18, "item9 is null");
        Objects.requireNonNull(t19, "item10 is null");
        return fromArray(t10, t11, t12, t13, t14, t15, t16, t17, t18, t19);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, e0 e0Var7, e0 e0Var8, pd.m mVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(e0Var7, "source7 is null");
        Objects.requireNonNull(e0Var8, "source8 is null");
        Objects.requireNonNull(mVar, "zipper is null");
        return zipArray(rd.a.A(mVar), false, bufferSize(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> z<R> zip(e0 e0Var, e0 e0Var2, e0 e0Var3, e0 e0Var4, e0 e0Var5, e0 e0Var6, e0 e0Var7, e0 e0Var8, e0 e0Var9, pd.n nVar) {
        Objects.requireNonNull(e0Var, "source1 is null");
        Objects.requireNonNull(e0Var2, "source2 is null");
        Objects.requireNonNull(e0Var3, "source3 is null");
        Objects.requireNonNull(e0Var4, "source4 is null");
        Objects.requireNonNull(e0Var5, "source5 is null");
        Objects.requireNonNull(e0Var6, "source6 is null");
        Objects.requireNonNull(e0Var7, "source7 is null");
        Objects.requireNonNull(e0Var8, "source8 is null");
        Objects.requireNonNull(e0Var9, "source9 is null");
        Objects.requireNonNull(nVar, "zipper is null");
        return zipArray(rd.a.B(nVar), false, bufferSize(), e0Var, e0Var2, e0Var3, e0Var4, e0Var5, e0Var6, e0Var7, e0Var8, e0Var9);
    }
}

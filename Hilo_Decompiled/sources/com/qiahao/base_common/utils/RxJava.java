package com.qiahao.base_common.utils;

import io.reactivex.rxjava3.core.c0;
import io.reactivex.rxjava3.core.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\u000bJE\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00072\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\f0\u0007¢\u0006\u0004\b\n\u0010\u000eJM\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00072\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\f0\u00072\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J%\u0010\u0012\u001a\u00020\t\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/qiahao/base_common/utils/RxJava;", "", "<init>", "()V", "T", "Lio/reactivex/rxjava3/core/c0;", "source", "Lpd/g;", "onNext", "Lnd/c;", "rx", "(Lio/reactivex/rxjava3/core/c0;Lpd/g;)Lnd/c;", "", "onError", "(Lio/reactivex/rxjava3/core/c0;Lpd/g;Lpd/g;)Lnd/c;", "Lpd/a;", "onComplete", "(Lio/reactivex/rxjava3/core/c0;Lpd/g;Lpd/g;Lpd/a;)Lnd/c;", "rxChildThread", "(Lio/reactivex/rxjava3/core/c0;)Lnd/c;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RxJava {

    @NotNull
    public static final RxJava INSTANCE = new RxJava();

    private RxJava() {
    }

    @NotNull
    public final <T> nd.c rx(@NotNull c0 source, @NotNull pd.g onNext) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        nd.c subscribe = z.create(source).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(onNext);
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        return subscribe;
    }

    @NotNull
    public final <T> nd.c rxChildThread(@NotNull c0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        nd.c subscribe = z.create(source).subscribeOn(ke.a.b()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        return subscribe;
    }

    @NotNull
    public final <T> nd.c rx(@NotNull c0 source, @NotNull pd.g onNext, @NotNull pd.g onError) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        Intrinsics.checkNotNullParameter(onError, "onError");
        nd.c subscribe = z.create(source).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(onNext, onError);
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        return subscribe;
    }

    @NotNull
    public final <T> nd.c rx(@NotNull c0 source, @NotNull pd.g onNext, @NotNull pd.g onError, @NotNull pd.a onComplete) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(onNext, "onNext");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        nd.c subscribe = z.create(source).subscribeOn(ke.a.b()).observeOn(md.b.c()).subscribe(onNext, onError, onComplete);
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        return subscribe;
    }
}

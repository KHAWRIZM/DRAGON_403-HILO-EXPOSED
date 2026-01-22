package com.qhqc.core.basic.net.flowCallAdapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096\u0002¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qhqc/core/basic/net/flowCallAdapter/FlowCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "async", "", "(Z)V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FlowCallAdapterFactory extends CallAdapter.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean async;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/basic/net/flowCallAdapter/FlowCallAdapterFactory$Companion;", "", "()V", "create", "Lcom/qhqc/core/basic/net/flowCallAdapter/FlowCallAdapterFactory;", "async", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FlowCallAdapterFactory create$default(Companion companion, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            return companion.create(z10);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final FlowCallAdapterFactory create() {
            return create$default(this, false, 1, null);
        }

        private Companion() {
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final FlowCallAdapterFactory create(boolean async) {
            return new FlowCallAdapterFactory(async, null);
        }
    }

    public /* synthetic */ FlowCallAdapterFactory(boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final FlowCallAdapterFactory create() {
        return INSTANCE.create();
    }

    @Nullable
    public CallAdapter<?, ?> get(@NotNull Type returnType, @NotNull Annotation[] annotations, @NotNull Retrofit retrofit) {
        CallAdapter<?, ?> createBodyFlowCallAdapter;
        CallAdapter<?, ?> createResponseFlowCallAdapter;
        Intrinsics.checkNotNullParameter(returnType, "returnType");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (!Intrinsics.areEqual(CallAdapter.Factory.getRawType(returnType), Flow.class)) {
            return null;
        }
        if (returnType instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) returnType);
            if (Intrinsics.areEqual(CallAdapter.Factory.getRawType(parameterUpperBound), Response.class)) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    boolean z10 = this.async;
                    Intrinsics.checkNotNull(parameterUpperBound2);
                    createResponseFlowCallAdapter = FlowCallAdapterFactoryKt.createResponseFlowCallAdapter(z10, parameterUpperBound2);
                    return createResponseFlowCallAdapter;
                }
                throw new IllegalStateException("the response type must be parameterized as Response<Foo>!");
            }
            boolean z11 = this.async;
            Intrinsics.checkNotNull(parameterUpperBound);
            createBodyFlowCallAdapter = FlowCallAdapterFactoryKt.createBodyFlowCallAdapter(z11, parameterUpperBound);
            return createBodyFlowCallAdapter;
        }
        throw new IllegalStateException("the flow type must be parameterized as Flow<Foo>!");
    }

    private FlowCallAdapterFactory(boolean z10) {
        this.async = z10;
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final FlowCallAdapterFactory create(boolean z10) {
        return INSTANCE.create(z10);
    }
}

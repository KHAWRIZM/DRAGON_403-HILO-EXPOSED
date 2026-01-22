package com.qiahao.base_common.network.gson;

import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import com.qiahao.base_common.network.model.GsonConverter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u0014\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/qiahao/base_common/network/gson/GsonConverterFactoryConstructer;", "Lretrofit2/Converter$Factory;", "Lcom/google/gson/d;", "gson", "<init>", "(Lcom/google/gson/d;)V", "Ljava/lang/reflect/Type;", "type", "", "", "annotations", "Lretrofit2/Retrofit;", "retrofit", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "responseBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "parameterAnnotations", "methodAnnotations", "Lokhttp3/RequestBody;", "requestBodyConverter", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "Lcom/google/gson/d;", "getGson", "()Lcom/google/gson/d;", "Lcom/qiahao/base_common/network/gson/FacelineGsonConverterFactory;", "facelineGsonConverterFactory", "Lcom/qiahao/base_common/network/gson/FacelineGsonConverterFactory;", "Lretrofit2/converter/gson/GsonConverterFactory;", "gsonConverterFactory", "Lretrofit2/converter/gson/GsonConverterFactory;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GsonConverterFactoryConstructer extends Converter.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final FacelineGsonConverterFactory facelineGsonConverterFactory;

    @NotNull
    private final d gson;

    @NotNull
    private final GsonConverterFactory gsonConverterFactory;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/network/gson/GsonConverterFactoryConstructer$Companion;", "", "<init>", "()V", "Lcom/google/gson/d;", "gson", "Lcom/qiahao/base_common/network/gson/GsonConverterFactoryConstructer;", "create", "(Lcom/google/gson/d;)Lcom/qiahao/base_common/network/gson/GsonConverterFactoryConstructer;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmOverloads
        @NotNull
        public final GsonConverterFactoryConstructer create(@NotNull d gson) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            return new GsonConverterFactoryConstructer(gson, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ GsonConverterFactoryConstructer(d dVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar);
    }

    @NotNull
    public final d getGson() {
        return this.gson;
    }

    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(@NotNull Type type, @NotNull Annotation[] parameterAnnotations, @NotNull Annotation[] methodAnnotations, @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(methodAnnotations, "methodAnnotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        this.gson.l(TypeToken.get(type));
        return null;
    }

    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(@NotNull Type type, @NotNull Annotation[] annotations, @NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        for (Annotation annotation : annotations) {
            if ((annotation instanceof GsonConverter) && Intrinsics.areEqual(((GsonConverter) annotation).value(), "common")) {
                return this.gsonConverterFactory.responseBodyConverter(type, annotations, retrofit);
            }
        }
        return this.facelineGsonConverterFactory.m٥٢٥responseBodyConverter(type, annotations, retrofit);
    }

    private GsonConverterFactoryConstructer(d dVar) {
        this.gson = dVar;
        this.facelineGsonConverterFactory = FacelineGsonConverterFactory.INSTANCE.create(dVar);
        GsonConverterFactory create = GsonConverterFactory.create(dVar);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.gsonConverterFactory = create;
    }
}

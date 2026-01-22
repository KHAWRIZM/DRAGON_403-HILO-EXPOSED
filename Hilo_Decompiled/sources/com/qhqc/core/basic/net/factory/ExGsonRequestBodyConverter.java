package com.qhqc.core.basic.net.factory;

import com.google.gson.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/qhqc/core/basic/net/factory/ExGsonRequestBodyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "Lcom/google/gson/w;", "adapter", "<init>", "(Lcom/google/gson/w;)V", "value", "convert", "(Ljava/lang/Object;)Lokhttp3/RequestBody;", "Lcom/google/gson/w;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ExGsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    @NotNull
    private final w adapter;

    public ExGsonRequestBodyConverter(@NotNull w adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object convert(Object obj) {
        return m٥١٦convert((ExGsonRequestBodyConverter<T>) obj);
    }

    @NotNull
    /* renamed from: convert, reason: collision with other method in class */
    public RequestBody m٥١٦convert(T value) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = this.adapter.toJson(value);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return companion.create(json, MediaType.Companion.parse("application/json; charset=UTF-8"));
    }
}

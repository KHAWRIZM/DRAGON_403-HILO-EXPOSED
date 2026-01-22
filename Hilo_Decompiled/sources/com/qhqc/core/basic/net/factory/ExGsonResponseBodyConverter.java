package com.qhqc.core.basic.net.factory;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.w;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.utils.EncryptUtils;
import com.qhqc.core.basic.utils.a;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/qhqc/core/basic/net/factory/ExGsonResponseBodyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "Lcom/google/gson/w;", "adapter", "<init>", "(Lcom/google/gson/w;)V", "", "value", DispatchConstants.SIGN, "", "checkSign", "(Ljava/lang/String;Ljava/lang/String;)Z", "convert", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "Lcom/google/gson/w;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ExGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    @NotNull
    private final w adapter;

    public ExGsonResponseBodyConverter(@NotNull w adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    private final boolean checkSign(String value, String sign) {
        if (TextUtils.isEmpty(value) || TextUtils.isEmpty(sign)) {
            return false;
        }
        String encryptHMAC = EncryptUtils.INSTANCE.encryptHMAC(value);
        a.a("pretty_sign = " + sign + " || " + encryptHMAC, new Object[0]);
        return Intrinsics.areEqual(encryptHMAC, sign);
    }

    @Nullable
    public T convert(@NotNull ResponseBody value) {
        T t10;
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            l e10 = n.c(value.string()).e();
            String h10 = e10.q("data").h();
            String h11 = e10.q(DispatchConstants.SIGN).h();
            Intrinsics.checkNotNull(h10);
            Intrinsics.checkNotNull(h11);
            if (checkSign(h10, h11)) {
                a.c(h10);
                l e11 = n.c(h10).e();
                int p10 = e11.q("code").p();
                i p11 = e11.p("data");
                if (p10 != 200) {
                    ApiErrorException apiErrorException = new ApiErrorException(e11.p("msg").h());
                    apiErrorException.setCode(p10);
                    if (p11.m()) {
                        String h12 = p11.h();
                        Intrinsics.checkNotNullExpressionValue(h12, "getAsString(...)");
                        apiErrorException.setErrorData(h12);
                        throw apiErrorException;
                    }
                    String iVar = p11.toString();
                    Intrinsics.checkNotNullExpressionValue(iVar, "toString(...)");
                    apiErrorException.setErrorData(iVar);
                    throw apiErrorException;
                }
                if (p11.m()) {
                    t10 = (T) p11.h();
                } else {
                    t10 = (T) this.adapter.fromJson(p11.toString());
                }
                CloseableKt.closeFinally(value, null);
                return t10;
            }
            throw new ApiErrorException(ApiErrorException.SIGN_CHECK_ERROR, "");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(value, th);
                throw th2;
            }
        }
    }
}

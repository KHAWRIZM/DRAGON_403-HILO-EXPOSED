package com.qhqc.core.basic.net.interceptor;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.gson.d;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.utils.a;
import java.net.URLDecoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/basic/net/interceptor/LogInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LogInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        ResponseBody body = proceed.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            String string = body.string();
            if (BasicModuleApp.INSTANCE.getDEBUG()) {
                try {
                    JSONObject jSONObject = new JSONObject(new d().s(request.body()));
                    JSONArray optJSONArray = jSONObject.optJSONArray("encodedNames");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("encodedValues");
                    if (optJSONArray != null) {
                        Intrinsics.checkNotNull(optJSONArray);
                        if (optJSONArray2 != null) {
                            Intrinsics.checkNotNull(optJSONArray2);
                            if (optJSONArray.length() == optJSONArray2.length()) {
                                int length = optJSONArray.length();
                                String str = "";
                                for (int i10 = 0; i10 < length; i10++) {
                                    str = ((Object) str) + optJSONArray.getString(i10) + "=" + optJSONArray2.get(i10) + DispatchConstants.SIGN_SPLIT_SYMBOL;
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Request url:%s\nRequest headers:\n%s", Arrays.copyOf(new Object[]{proceed.request().url().toString(), proceed.headers()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                a.b(format, new Object[0]);
                Buffer buffer = new Buffer();
                RequestBody body2 = request.body();
                if (body2 != null) {
                    body2.writeTo(buffer);
                }
                String format2 = String.format("RequestBody:%s", Arrays.copyOf(new Object[]{URLDecoder.decode(buffer.readByteString().utf8(), "UTF-8")}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                a.b(format2, new Object[0]);
            }
            return proceed.newBuilder().body(ResponseBody.Companion.create(string, contentType)).build();
        }
        return proceed;
    }
}

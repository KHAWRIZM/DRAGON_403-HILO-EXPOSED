package com.qiahao.base_common.network.interceptors;

import android.os.Build;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.cache.MMKVKey;
import com.qiahao.base_common.utils.g;
import com.qiahao.base_common.utils.language.LanguageHelper;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/network/interceptors/HeaderInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HeaderInterceptor implements Interceptor {

    @NotNull
    public static final String ANDROID = "android";

    @NotNull
    public static final String APP_VERSION = "appVersion";

    @NotNull
    public static final String CARRIER = "carrier";

    @NotNull
    public static final String CONTENT_TYPE = "Content-Type";

    @NotNull
    public static final String DEVICE_MODEL = "deviceModel";

    @NotNull
    public static final String DEVICE_TYPE = "deviceType";

    @NotNull
    public static final String DEVICE_VERSION = "deviceVersion";

    @NotNull
    public static final String IMEI = "imei";

    @NotNull
    public static final String IMEI2 = "imei2";

    @NotNull
    public static final String IMEI3 = "imei3";

    @NotNull
    public static final String IS_SIMULATOR = "isSimulator";

    @NotNull
    public static final String KEY = "biz";

    @NotNull
    public static final String LANGUAGE = "language";

    @NotNull
    public static final String NONCE = "nonce";

    @NotNull
    public static final String SIGNATURE = "signature";

    @NotNull
    public static final String TIMESTAMP = "timestamp";

    @NotNull
    public static final String TIME_ZONE = "timeZone";

    @NotNull
    public static final String TOKEN = "token";

    @NotNull
    public static final String VN = "VN";

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String str;
        String str2;
        String simOperator;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        try {
            BaseApplication.Companion companion = BaseApplication.INSTANCE;
            BaseApplication companion2 = companion.getInstance();
            int i10 = 1;
            if (companion2 != null && companion2.isVPNConnected()) {
                str = "HI";
            } else {
                str = "LO";
            }
            BaseApplication companion3 = companion.getInstance();
            if (companion3 == null || !companion3.isEmulator()) {
                i10 = 0;
            }
            String valueOf = String.valueOf(RangesKt.random(new IntRange(10000000, 99999999), Random.INSTANCE));
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            String d10 = g.d(valueOf2 + KEY + valueOf + str);
            Request.Builder addHeader = newBuilder.addHeader("Content-Type", "application/json").addHeader(TIMESTAMP, valueOf2).addHeader("nonce", valueOf);
            Intrinsics.checkNotNull(d10);
            Request.Builder addHeader2 = addHeader.addHeader("signature", d10);
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            Request.Builder addHeader3 = addHeader2.addHeader(TOKEN, (String) IStore.DefaultImpls.getValue$default(mMKVStore, MMKVKey.USER_TOKEN, "", null, 4, null)).addHeader(DEVICE_TYPE, "android").addHeader(VN, str).addHeader(DEVICE_VERSION, String.valueOf(Build.VERSION.SDK_INT));
            BaseApplication companion4 = companion.getInstance();
            String str3 = "";
            if (companion4 == null || (str2 = companion4.getVersionName()) == null) {
                str2 = "";
            }
            Request.Builder addHeader4 = addHeader3.addHeader("appVersion", str2);
            LanguageHelper languageHelper = LanguageHelper.INSTANCE;
            String language = languageHelper.getSystemLanguage().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            Request.Builder addHeader5 = addHeader4.addHeader(LANGUAGE, language);
            String currentTimeZone = languageHelper.getCurrentTimeZone();
            if (currentTimeZone == null) {
                currentTimeZone = "";
            }
            Request.Builder addHeader6 = addHeader5.addHeader("timeZone", currentTimeZone);
            BaseApplication companion5 = companion.getInstance();
            if (companion5 != null && (simOperator = companion5.getSimOperator()) != null) {
                str3 = simOperator;
            }
            addHeader6.addHeader("carrier", str3).addHeader(DEVICE_MODEL, Build.MANUFACTURER + "_" + Build.MODEL).addHeader(IS_SIMULATOR, String.valueOf(i10));
            newBuilder.addHeader(IMEI, UUIDHelper.INSTANCE.getUuid());
            newBuilder.addHeader(IMEI3, (String) IStore.DefaultImpls.getValue$default(mMKVStore, MMKVKey.SERVICE_DEVICE_ID, "", null, 4, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Response proceed = chain.proceed(newBuilder.build());
        String str4 = proceed.headers().get(TOKEN);
        if (str4 != null && !StringsKt.isBlank(str4)) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVKey.USER_TOKEN, str4, null, 4, null);
        }
        return proceed;
    }
}

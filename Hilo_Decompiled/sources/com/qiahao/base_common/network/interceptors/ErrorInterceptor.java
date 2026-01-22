package com.qiahao.base_common.network.interceptors;

import android.os.Build;
import com.facebook.share.internal.ShareConstants;
import com.oudi.utils.StringUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.R;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.FirebaseEventKey;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import javax.net.ssl.SSLException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/qiahao/base_common/network/interceptors/ErrorInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "printParams", "", "body", "Lokhttp3/RequestBody;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ErrorInterceptor implements Interceptor {
    private final String printParams(RequestBody body) {
        MediaType mediaType;
        Buffer buffer = new Buffer();
        if (body != null) {
            try {
                body.writeTo(buffer);
            } catch (IOException e10) {
                e10.printStackTrace();
                return "";
            }
        }
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        if (body != null) {
            mediaType = body.contentType();
        } else {
            mediaType = null;
        }
        if (mediaType != null) {
            forName = mediaType.charset(Charsets.UTF_8);
            Intrinsics.checkNotNull(forName);
        }
        return buffer.readString(forName);
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        String str;
        AppService service;
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
            Response proceed = chain.proceed(chain.request());
            if (proceed.code() == 200) {
                return proceed;
            }
            throw new HiloException(proceed.code(), proceed.message(), null, null, 12, null);
        } catch (Exception e10) {
            if (!Intrinsics.areEqual(chain.request().url().encodedPath(), "/v1/user/login") && !Intrinsics.areEqual(chain.request().url().encodedPath(), "/v1/user/login/phone")) {
                throw new IOException(ResourcesKtxKt.getStringById(this, R.string.the_network_error1));
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            StringUtils stringUtils = StringUtils.INSTANCE;
            String message = e10.getMessage();
            if (message == null) {
                message = "";
            }
            stringUtils.disposeString(hashMap, "errorMessage", message);
            if ((e10 instanceof SSLException) && (service = AppController.INSTANCE.getService()) != null) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                String message2 = e10.getMessage();
                if (message2 == null) {
                    message2 = "SSLException";
                }
                hashMap2.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, message2);
                Unit unit = Unit.INSTANCE;
                service.onEvent("login_hilo_e", hashMap2);
            }
            AppService service2 = AppController.INSTANCE.getService();
            if (service2 != null) {
                service2.onEvent(FirebaseEventKey.EVENT_LOGIN, hashMap);
            }
            BaseApplication companion = BaseApplication.INSTANCE.getInstance();
            if (companion != null) {
                str = companion.getVersionName();
            } else {
                str = null;
            }
            throw new HiloException(500, str + "|" + Build.VERSION.RELEASE + "|" + (System.currentTimeMillis() / 1000) + "|" + e10.getMessage(), null, null, 12, null);
        }
    }
}

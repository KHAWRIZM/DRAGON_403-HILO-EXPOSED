package com.qiahao.base_common.network.gson;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.json.JsonUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.R;
import com.qiahao.base_common.network.gson.FacelineGsonConverter;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.network.model.ErrorCode;
import com.qiahao.base_common.network.model.ErrorResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.g;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n5.e;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B\u001d\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/qiahao/base_common/network/gson/FacelineGsonConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "Lcom/google/gson/d;", "gson", "Lcom/google/gson/reflect/TypeToken;", "typeToken", "<init>", "(Lcom/google/gson/d;Lcom/google/gson/reflect/TypeToken;)V", "value", "convert", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "Lcom/google/gson/d;", "Lcom/google/gson/reflect/TypeToken;", "", TransferTable.COLUMN_KEY, "Ljava/lang/String;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFacelineGsonConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FacelineGsonConverter.kt\ncom/qiahao/base_common/network/gson/FacelineGsonConverter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FacelineGsonConverter<T> implements Converter<ResponseBody, T> {

    @NotNull
    private final d gson;

    @NotNull
    private final String key;

    @NotNull
    private final TypeToken<?> typeToken;

    public FacelineGsonConverter(@NotNull d gson, @NotNull TypeToken<?> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "typeToken");
        this.gson = gson;
        this.typeToken = typeToken;
        this.key = "hilo!@#$%^&*()_+";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0() {
        AppController appController = AppController.INSTANCE;
        AppService service = appController.getService();
        if (service != null && service.isAuthenticated()) {
            e.c("TOKEN_INVALID, TOKEN_EXPIRE  logout()");
            appController.getService().logout(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1() {
        AppController appController = AppController.INSTANCE;
        AppService service = appController.getService();
        if (service != null && service.isAuthenticated()) {
            appController.getService().logout(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$2() {
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.logout(true);
        }
    }

    @Nullable
    public T convert(@NotNull ResponseBody value) throws IOException {
        AppService service;
        Intrinsics.checkNotNullParameter(value, "value");
        String string = value.string();
        try {
            ApiResponse apiResponse = (ApiResponse) BaseApplication.INSTANCE.getGSON().j(string, ApiResponse.class);
            int code = apiResponse.getCode();
            if (code == 200) {
                if (!TextUtils.isEmpty(apiResponse.getEdata())) {
                    String edata = apiResponse.getEdata();
                    if (edata == null) {
                        edata = "";
                    }
                    String str = this.key;
                    return (T) this.gson.k(JsonUtils.replaceKey(string, new Pair("data", g.c(edata, str, str))), this.typeToken.getType());
                }
                return (T) this.gson.k(string, this.typeToken.getType());
            }
            if (code == 1015) {
                AppService service2 = AppController.INSTANCE.getService();
                if (service2 != null) {
                    service2.showUpdateDialog();
                }
                throw new HiloException(apiResponse.getCode(), apiResponse.getMessage(), null, null, 12, null);
            }
            if (code == 1020) {
                ErrorResponse messageData = apiResponse.getMessageData();
                if (messageData != null && (service = AppController.INSTANCE.getService()) != null) {
                    service.showErrorTipDialog(messageData);
                }
                throw new HiloException(apiResponse.getCode(), apiResponse.getMessage(), null, null, 12, null);
            }
            if (code == 9000) {
                HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: db.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        FacelineGsonConverter.convert$lambda$2();
                    }
                });
                int code2 = apiResponse.getCode();
                String message = apiResponse.getMessage();
                Bundle bundle = new Bundle();
                bundle.putLong(ErrorCode.keyOfBlockedExpireTime, 0L);
                Unit unit = Unit.INSTANCE;
                throw new HiloException(code2, message, bundle, null, 8, null);
            }
            if (code == 9011) {
                HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: db.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        FacelineGsonConverter.convert$lambda$1();
                    }
                });
                throw new HiloException(apiResponse.getCode(), apiResponse.getMessage(), null, null, 12, null);
            }
            if (code != 1001 && code != 1002) {
                throw new HiloException(apiResponse.getCode(), apiResponse.getMessage(), null, apiResponse.getMessageData(), 4, null);
            }
            HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: db.c
                @Override // java.lang.Runnable
                public final void run() {
                    FacelineGsonConverter.convert$lambda$0();
                }
            });
            throw new HiloException(apiResponse.getCode(), apiResponse.getMessage(), null, null, 12, null);
        } catch (Exception e10) {
            if (e10 instanceof HiloException) {
                HiloException hiloException = (HiloException) e10;
                e.c("请求接口报错：code:" + hiloException.getCode() + "   message:" + hiloException.getMessageData());
                throw e10;
            }
            e.c("请求接口报错: message:" + e10.getMessage());
            throw new HiloException(ErrorCode.ERROR_11111, ResourcesKtxKt.getStringById(this, R.string.the_network_error), null, null, 12, null);
        }
    }
}

package com.qhqc.core.feature.api;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.utils.EncryptUtils;
import com.qhqc.core.basic.utils.LogUtil;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/qhqc/core/feature/api/ParamsBuilder;", "", "<init>", "()V", NativeProtocol.WEB_DIALOG_PARAMS, "Lorg/json/JSONObject;", "getParamsDataStr", "", "getRandom", "put", TransferTable.COLUMN_KEY, "value", "buildParam", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "op", "operateOp", "id", "", "page", "pageCursor", "pageSize", "type", ShareConstants.RESULT_POST_ID, "content", "putJsonObjectValues", "jsonObject", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ParamsBuilder {

    @NotNull
    private final JSONObject params;

    public ParamsBuilder() {
        JSONObject jSONObject = new JSONObject();
        try {
            BasicModuleApp basicModuleApp = BasicModuleApp.INSTANCE;
            long uid = basicModuleApp.userAuth().getUid();
            jSONObject.put("user_id", uid);
            jSONObject.put(HeaderInterceptor.TOKEN, basicModuleApp.userAuth().getToken());
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Android");
            jSONObject.put("pkgname", basicModuleApp.userAuth().getPackageName());
            jSONObject.put(HeaderInterceptor.IMEI, basicModuleApp.userAuth().getDeviceId());
            jSONObject.put(HeaderInterceptor.LANGUAGE, basicModuleApp.userAuth().getLanguage());
            jSONObject.put("client_version", basicModuleApp.userAuth().getClientVersion());
            jSONObject.put("request_id", uid + getRandom());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        this.params = jSONObject;
    }

    private final String getRandom() {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < 8; i10++) {
            sb.append((int) (Math.random() * 10));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final HashMap<String, String> buildParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        String jSONObject = this.params.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        String replace = new Regex("'").replace(jSONObject, "’");
        hashMap.put("Api_data", replace);
        hashMap.put("Api_sign", EncryptUtils.INSTANCE.encryptHMAC(replace));
        if (BasicModuleApp.INSTANCE.getDEBUG()) {
            LogUtil.INSTANCE.d("request_params", "Api_data=" + replace + "\n\n");
        }
        return hashMap;
    }

    @NotNull
    public final ParamsBuilder content(@Nullable String value) {
        this.params.put("content", value);
        return this;
    }

    @NotNull
    public final String getParamsDataStr() {
        String jSONObject = this.params.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return new Regex("'").replace(jSONObject, "’");
    }

    @NotNull
    public final ParamsBuilder id(int value) {
        this.params.put("id", value);
        return this;
    }

    @NotNull
    public final ParamsBuilder op(@NotNull String op) {
        Intrinsics.checkNotNullParameter(op, "op");
        try {
            this.params.put("op", op);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final ParamsBuilder operateOp(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.params.put("operate_op", value);
        return this;
    }

    @NotNull
    public final ParamsBuilder page(int value) {
        this.params.put("page", value);
        return this;
    }

    @NotNull
    public final ParamsBuilder pageCursor(@Nullable String value) {
        this.params.put("pageCursor", value);
        return this;
    }

    @NotNull
    public final ParamsBuilder pageSize(int value) {
        this.params.put("pageSize", value);
        return this;
    }

    @NotNull
    public final ParamsBuilder postId(@Nullable String value) {
        this.params.put(ShareConstants.RESULT_POST_ID, value);
        return this;
    }

    @NotNull
    public final ParamsBuilder put(@NotNull String key, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            this.params.put(key, value);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return this;
    }

    @NotNull
    public final ParamsBuilder putJsonObjectValues(@NotNull JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNull(next);
            put(next, jsonObject.get(next));
        }
        return this;
    }

    @NotNull
    public final ParamsBuilder type(int value) {
        this.params.put("type", value);
        return this;
    }
}

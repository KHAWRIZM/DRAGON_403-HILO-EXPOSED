package com.qiahao.nextvideo.utilities.alicloud.push;

import androidx.annotation.Keep;
import com.alibaba.sdk.android.push.CommonCallback;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/push/AliCloudPushServiceRegisterCommonCallback;", "Lcom/alibaba/sdk/android/push/CommonCallback;", "<init>", "()V", "onSuccess", "", "p0", "", "onFailed", Constants.KEY_ERROR_CODE, "errorMessage", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class AliCloudPushServiceRegisterCommonCallback implements CommonCallback {
    public void onFailed(@Nullable String errorCode, @Nullable String errorMessage) {
        DebugToolsKt.printf(HiloAliyunMessageIntentService.TAG, "AliCloudPushServiceRegisterCommonCallback onFailed(" + errorCode + ": String?, " + errorMessage + ": String?)");
    }

    public void onSuccess(@Nullable String p0) {
        DebugToolsKt.printf(HiloAliyunMessageIntentService.TAG, "AliCloudPushServiceRegisterCommonCallback onSuccess(" + p0 + ": String?)");
    }
}

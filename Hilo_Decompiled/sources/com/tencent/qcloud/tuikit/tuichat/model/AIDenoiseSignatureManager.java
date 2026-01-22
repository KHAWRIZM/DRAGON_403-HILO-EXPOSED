package com.tencent.qcloud.tuikit.tuichat.model;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AIDenoiseSignatureManager {
    private static final String TAG = "AIDenoiseSignatureManager";
    private String aiDenoiseSignature = "";
    private int expiredTime;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class AIDenoiseSignatureManagerHolder {
        private static final AIDenoiseSignatureManager aiDenoiseSignatureManager = new AIDenoiseSignatureManager();

        private AIDenoiseSignatureManagerHolder() {
        }
    }

    public static AIDenoiseSignatureManager getInstance() {
        return AIDenoiseSignatureManagerHolder.aiDenoiseSignatureManager;
    }

    public String getSignature() {
        updateSignature();
        return this.aiDenoiseSignature;
    }

    public void updateSignature() {
        if (System.currentTimeMillis() / 1000 < this.expiredTime) {
            return;
        }
        V2TIMManager.getInstance().callExperimentalAPI("getAIDenoiseSignature", null, new V2TIMValueCallback<Object>() { // from class: com.tencent.qcloud.tuikit.tuichat.model.AIDenoiseSignatureManager.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                TUIChatLog.e(AIDenoiseSignatureManager.TAG, "getAIDenoiseSignature error, code:" + i + ", desc:" + str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Object obj) {
                if (obj == null || !(obj instanceof HashMap)) {
                    return;
                }
                HashMap hashMap = (HashMap) obj;
                Object obj2 = hashMap.get(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE);
                Object obj3 = hashMap.get("expired_time");
                if (obj2 != null) {
                    AIDenoiseSignatureManager.this.aiDenoiseSignature = (String) obj2;
                }
                if (obj3 != null) {
                    AIDenoiseSignatureManager.this.expiredTime = Integer.parseInt((String) obj3);
                }
            }
        });
    }
}

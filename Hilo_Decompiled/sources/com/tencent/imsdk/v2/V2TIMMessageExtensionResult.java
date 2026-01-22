package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageExtensionResult;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMMessageExtensionResult implements Serializable {
    private MessageExtensionResult extensionResult;

    public V2TIMMessageExtension getExtension() {
        if (this.extensionResult != null) {
            V2TIMMessageExtension v2TIMMessageExtension = new V2TIMMessageExtension();
            v2TIMMessageExtension.setMessageExtension(this.extensionResult.getExtension());
            return v2TIMMessageExtension;
        }
        return null;
    }

    public int getResultCode() {
        MessageExtensionResult messageExtensionResult = this.extensionResult;
        if (messageExtensionResult != null) {
            return messageExtensionResult.getResultCode();
        }
        return 0;
    }

    public String getResultInfo() {
        MessageExtensionResult messageExtensionResult = this.extensionResult;
        if (messageExtensionResult != null) {
            return messageExtensionResult.getResultInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageExtensionResult(MessageExtensionResult messageExtensionResult) {
        this.extensionResult = messageExtensionResult;
    }

    public String toString() {
        return "V2TIMMessageExtensionResult{code=" + getResultCode() + ",info=" + getResultInfo() + ",extension=" + getExtension() + '}';
    }
}

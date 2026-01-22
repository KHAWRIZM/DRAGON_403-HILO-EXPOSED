package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageExtensionResult implements Serializable {
    private MessageExtension extension;
    private int resultCode;
    private String resultInfo;

    public MessageExtension getExtension() {
        return this.extension;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }
}

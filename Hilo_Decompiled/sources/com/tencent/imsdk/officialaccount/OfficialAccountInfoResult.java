package com.tencent.imsdk.officialaccount;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class OfficialAccountInfoResult implements Serializable {
    private int errorCode;
    private String errorMessage;
    private String officialAccountID;
    private OfficialAccountInfo officialAccountInfo;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getOfficialAccountID() {
        return this.officialAccountID;
    }

    public OfficialAccountInfo getOfficialAccountInfo() {
        return this.officialAccountInfo;
    }
}

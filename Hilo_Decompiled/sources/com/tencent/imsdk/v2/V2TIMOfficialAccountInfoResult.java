package com.tencent.imsdk.v2;

import com.tencent.imsdk.officialaccount.OfficialAccountInfoResult;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMOfficialAccountInfoResult {
    private OfficialAccountInfoResult officialAccountInfoResult = new OfficialAccountInfoResult();

    public V2TIMOfficialAccountInfo getOfficialAccountInfo() {
        V2TIMOfficialAccountInfo v2TIMOfficialAccountInfo = new V2TIMOfficialAccountInfo();
        v2TIMOfficialAccountInfo.setOfficialAccountInfo(this.officialAccountInfoResult.getOfficialAccountInfo());
        return v2TIMOfficialAccountInfo;
    }

    public int getResultCode() {
        return this.officialAccountInfoResult.getErrorCode();
    }

    public String getResultInfo() {
        return this.officialAccountInfoResult.getErrorMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOfficialAccountInfoResult(OfficialAccountInfoResult officialAccountInfoResult) {
        this.officialAccountInfoResult = officialAccountInfoResult;
    }
}

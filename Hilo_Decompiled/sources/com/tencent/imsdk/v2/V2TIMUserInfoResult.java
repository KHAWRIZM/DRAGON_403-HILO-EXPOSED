package com.tencent.imsdk.v2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMUserInfoResult implements Serializable {
    private String nextCursor;
    private List<V2TIMUserFullInfo> v2TIMUserFullInfoList = new ArrayList();

    public String getNextCursor() {
        return this.nextCursor;
    }

    public List<V2TIMUserFullInfo> getUserFullInfoList() {
        return this.v2TIMUserFullInfoList;
    }

    public void setUserFullInfoResult(String str, List<V2TIMUserFullInfo> list) {
        this.nextCursor = str;
        this.v2TIMUserFullInfoList = list;
    }
}

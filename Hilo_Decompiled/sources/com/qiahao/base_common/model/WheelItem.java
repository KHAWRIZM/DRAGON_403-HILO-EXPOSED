package com.qiahao.base_common.model;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class WheelItem implements bb.a {
    String label;

    public WheelItem(String str) {
        this.label = str;
    }

    @Override // bb.a
    public String getShowText() {
        return this.label;
    }
}

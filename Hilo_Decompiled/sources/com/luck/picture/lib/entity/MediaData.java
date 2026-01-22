package com.luck.picture.lib.entity;

import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MediaData {
    public ArrayList<LocalMedia> data;
    public boolean isHasNextMore;

    public MediaData() {
    }

    public MediaData(boolean z10, ArrayList<LocalMedia> arrayList) {
        this.isHasNextMore = z10;
        this.data = arrayList;
    }
}

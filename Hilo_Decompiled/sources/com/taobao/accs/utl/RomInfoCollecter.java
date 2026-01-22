package com.taobao.accs.utl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class RomInfoCollecter {
    protected RomInfoCollecter mNextCollecter;

    public static RomInfoCollecter getCollecter() {
        return new e();
    }

    public abstract String collect();
}

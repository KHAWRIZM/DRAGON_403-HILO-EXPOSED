package com.taobao.accs.utl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class e extends RomInfoCollecter {
    @Override // com.taobao.accs.utl.RomInfoCollecter
    public String collect() {
        RomInfoCollecter romInfoCollecter;
        String g = UtilityImpl.g();
        if (g == null && (romInfoCollecter = this.mNextCollecter) != null) {
            return romInfoCollecter.collect();
        }
        return g;
    }
}

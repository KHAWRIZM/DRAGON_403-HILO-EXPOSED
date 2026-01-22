package com.google.android.gms.auth.api;

import com.google.android.gms.common.internal.ShowFirstParty;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zbc {
    protected Boolean zba;
    protected String zbb;

    public zbc() {
        this.zba = Boolean.FALSE;
    }

    @ShowFirstParty
    public final zbc zba(String str) {
        this.zbb = str;
        return this;
    }

    @ShowFirstParty
    public zbc(zbd zbdVar) {
        boolean z10;
        String str;
        this.zba = Boolean.FALSE;
        zbd.zbb(zbdVar);
        z10 = zbdVar.zbc;
        this.zba = Boolean.valueOf(z10);
        str = zbdVar.zbd;
        this.zbb = str;
    }
}

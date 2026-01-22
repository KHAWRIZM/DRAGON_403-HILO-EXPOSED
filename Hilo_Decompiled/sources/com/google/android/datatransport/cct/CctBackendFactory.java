package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import c7.h;
import c7.m;

@Keep
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CctBackendFactory implements c7.d {
    @Override // c7.d
    public m create(h hVar) {
        return new d(hVar.b(), hVar.e(), hVar.d());
    }
}

package com.tencent.liteav.base.system;

import com.tencent.liteav.base.util.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class c implements i.a {
    private static final c a = new c();

    private c() {
    }

    public static i.a a() {
        return a;
    }

    @Override // com.tencent.liteav.base.util.i.a
    public final void a(boolean z) {
        LiteavSystemInfo.onAppBackgroundStateChanged(z);
    }
}

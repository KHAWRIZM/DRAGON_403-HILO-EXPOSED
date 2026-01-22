package com.qhqc.core.basic.ktx;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0006\u0010\n\u001a\u00020\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"dp", "", "getDp", "(F)F", "", "(I)I", "sp", "getSp", "(F)I", "(I)F", "screenWidth", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DisplayKtxKt {
    public static final int getDp(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static final int getSp(float f10) {
        return (int) TypedValue.applyDimension(2, f10, Resources.getSystem().getDisplayMetrics());
    }

    public static final int screenWidth() {
        Object systemService = BasicModuleApp.application().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static final float getDp(float f10) {
        return TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics());
    }

    public static final float getSp(int i10) {
        return TypedValue.applyDimension(2, i10, Resources.getSystem().getDisplayMetrics());
    }
}

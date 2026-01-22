package com.oudi.utils.ktx;

import com.oudi.utils.UiUtils;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\b\u001a\u00020\u0002*\u00020\t\u001a\n\u0010\b\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000b"}, d2 = {"dp", "", "", "getDp", "(F)I", "(I)I", "px", "getPx", "toDP", "", "toPX", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UiKtxKt {
    public static final int getDp(float f10) {
        return toPX(f10);
    }

    public static final int getPx(float f10) {
        return MathKt.roundToInt(toDP(f10));
    }

    public static final float toDP(long j10) {
        return UiUtils.INSTANCE.px2dip((float) j10);
    }

    public static final int toPX(long j10) {
        return UiUtils.INSTANCE.dip2px((float) j10);
    }

    public static final int getDp(int i10) {
        return toPX(i10);
    }

    public static final int getPx(int i10) {
        return MathKt.roundToInt(toDP(i10));
    }

    public static final float toDP(float f10) {
        return UiUtils.INSTANCE.px2dip(f10);
    }

    public static final int toPX(float f10) {
        return UiUtils.INSTANCE.dip2px(f10);
    }

    public static final float toDP(int i10) {
        return UiUtils.INSTANCE.px2dip(i10);
    }

    public static final int toPX(int i10) {
        return UiUtils.INSTANCE.dip2px(i10);
    }
}

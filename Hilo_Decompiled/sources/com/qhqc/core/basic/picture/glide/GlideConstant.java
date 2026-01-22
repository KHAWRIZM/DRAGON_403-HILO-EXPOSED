package com.qhqc.core.basic.picture.glide;

import android.annotation.SuppressLint;
import com.qhqc.core.basic.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/qhqc/core/basic/picture/glide/GlideConstant;", "", "()V", "AVATAR_PRELOAD", "", "getAVATAR_PRELOAD", "()I", "setAVATAR_PRELOAD", "(I)V", "COLOR_PRELOAD", "getCOLOR_PRELOAD", "PRELOAD", "getPRELOAD", "TRANSPARENT", "getTRANSPARENT", "setDefAvatarPreload", "", "res", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"NonConstantResourceId"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class GlideConstant {
    private static int AVATAR_PRELOAD;
    private static final int COLOR_PRELOAD;

    @NotNull
    public static final GlideConstant INSTANCE = new GlideConstant();
    private static final int PRELOAD;
    private static final int TRANSPARENT;

    static {
        int i10 = R.color.glide_constant_default_preloading;
        PRELOAD = i10;
        TRANSPARENT = R.color.transparent;
        COLOR_PRELOAD = i10;
        AVATAR_PRELOAD = i10;
    }

    private GlideConstant() {
    }

    public final int getAVATAR_PRELOAD() {
        return AVATAR_PRELOAD;
    }

    public final int getCOLOR_PRELOAD() {
        return COLOR_PRELOAD;
    }

    public final int getPRELOAD() {
        return PRELOAD;
    }

    public final int getTRANSPARENT() {
        return TRANSPARENT;
    }

    public final void setAVATAR_PRELOAD(int i10) {
        AVATAR_PRELOAD = i10;
    }

    public final void setDefAvatarPreload(int res) {
        AVATAR_PRELOAD = res;
    }
}

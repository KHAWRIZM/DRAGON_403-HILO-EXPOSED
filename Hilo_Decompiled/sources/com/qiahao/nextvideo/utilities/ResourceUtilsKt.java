package com.qiahao.nextvideo.utilities;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"getDrawable", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "imageResID", "", "dimension", Constants.SEND_TYPE_RES, "width", "height", "getColor", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ResourceUtilsKt {
    public static final int getColor(@NotNull Resources resources, int i) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return androidx.core.content.res.h.d(resources, i, (Resources.Theme) null);
    }

    @Nullable
    public static final Drawable getDrawable(@NotNull Resources resources, int i, int i2) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Drawable f = androidx.core.content.res.h.f(resources, i, (Resources.Theme) null);
        if (f != null) {
            f.setBounds(0, 0, i2, i2);
        }
        return f;
    }

    @Nullable
    public static final Drawable getDrawable(@NotNull Resources resources, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Drawable f = androidx.core.content.res.h.f(resources, i, (Resources.Theme) null);
        if (f != null) {
            f.setBounds(0, 0, i2, i3);
        }
        return f;
    }
}

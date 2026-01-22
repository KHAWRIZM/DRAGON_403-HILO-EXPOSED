package com.skydoves.balloon.extensions;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\u0002H\u0000\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0000¨\u0006\u000f"}, d2 = {"contextColor", "", "Landroid/content/Context;", "resource", "contextDrawable", "Landroid/graphics/drawable/Drawable;", "dimen", "dimenRes", "displaySize", "Landroid/graphics/Point;", "dp2Px", "", "dp", "isFinishing", "", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ContextExtensionKt {
    public static final int contextColor(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$contextColor");
        return androidx.core.content.a.getColor(context, i);
    }

    @Nullable
    public static final Drawable contextDrawable(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$contextDrawable");
        return r1.a.b(context, i);
    }

    public static final int dimen(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$dimen");
        return context.getResources().getDimensionPixelSize(i);
    }

    @NotNull
    public static final Point displaySize(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$displaySize");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        return new Point(i, resources2.getDisplayMetrics().heightPixels);
    }

    public static final int dp2Px(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$dp2Px");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) (i * resources.getDisplayMetrics().density);
    }

    public static final boolean isFinishing(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "$this$isFinishing");
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return true;
        }
        return false;
    }

    public static final float dp2Px(@NotNull Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "$this$dp2Px");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return f * resources.getDisplayMetrics().density;
    }
}

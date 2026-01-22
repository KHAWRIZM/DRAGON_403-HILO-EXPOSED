package com.qmuiteam.qmui.kotlin;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\r"}, d2 = {"dimen", "", "Landroid/content/Context;", "resource", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "dip", "value", "", "px2dp", "px", "px2sp", "sp", "qmui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class DimenKtKt {
    public static final int dimen(@NotNull Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i10);
    }

    public static final int dip(@NotNull Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i10 * context.getResources().getDisplayMetrics().density);
    }

    public static final float px2dp(@NotNull Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return i10 / context.getResources().getDisplayMetrics().density;
    }

    public static final float px2sp(@NotNull Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return i10 / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final int sp(@NotNull Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i10 * context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static final int dimen(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dimen(context, i10);
    }

    public static final int dip(@NotNull Context context, float f10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (f10 * context.getResources().getDisplayMetrics().density);
    }

    public static final float px2dp(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return px2dp(context, i10);
    }

    public static final float px2sp(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return px2sp(context, i10);
    }

    public static final int sp(@NotNull Context context, float f10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (f10 * context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static final int dimen(@NotNull Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return dimen(context, i10);
    }

    public static final int dip(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dip(context, i10);
    }

    public static final float px2dp(@NotNull Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return px2dp(context, i10);
    }

    public static final float px2sp(@NotNull Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return px2sp(context, i10);
    }

    public static final int sp(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return sp(context, i10);
    }

    public static final int dip(@NotNull View view, float f10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dip(context, f10);
    }

    public static final int sp(@NotNull View view, float f10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return sp(context, f10);
    }

    public static final int dip(@NotNull Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return dip(context, i10);
    }

    public static final int sp(@NotNull Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return sp(context, i10);
    }

    public static final int dip(@NotNull Fragment fragment, float f10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return dip(context, f10);
    }

    public static final int sp(@NotNull Fragment fragment, float f10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return sp(context, f10);
    }
}

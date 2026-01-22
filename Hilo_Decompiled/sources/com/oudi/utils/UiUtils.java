package com.oudi.utils;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2.q;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0013"}, d2 = {"Lcom/oudi/utils/UiUtils;", "", "<init>", "()V", "getScreenWidth", "", "context", "Landroid/content/Context;", "getScreenHeight", "getScreenRatio", "", "dip2px", "dpValue", "px2dip", "pxValue", "isRtl", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UiUtils {
    public static final UiUtils INSTANCE = new UiUtils();

    private UiUtils() {
    }

    public final int dip2px(float dpValue) {
        Application app = AppUtils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp(...)");
        return dip2px(app, dpValue);
    }

    public final int getScreenHeight(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public final float getScreenRatio(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (getScreenWidth(context) * 1.0f) / getScreenHeight(context);
    }

    public final int getScreenWidth(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        if (systemService instanceof WindowManager) {
            windowManager = (WindowManager) systemService;
        } else {
            windowManager = null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public final boolean isRtl(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return 1 == view.getLayoutDirection();
    }

    public final float px2dip(float pxValue) {
        Application app = AppUtils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp(...)");
        return px2dip(app, pxValue);
    }

    public final int dip2px(Context context, float dpValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (TypedValue.applyDimension(1, dpValue, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public final boolean isRtl() {
        return q.a(Locale.getDefault()) == 1;
    }

    public final float px2dip(Context context, float pxValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TypedValue.applyDimension(0, pxValue, context.getResources().getDisplayMetrics());
    }
}

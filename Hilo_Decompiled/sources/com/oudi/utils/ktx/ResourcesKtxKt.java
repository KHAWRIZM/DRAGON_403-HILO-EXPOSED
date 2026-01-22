package com.oudi.utils.ktx;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.h;
import androidx.fragment.app.Fragment;
import com.oudi.utils.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\b2\b\b\u0001\u0010\u0006\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0001H\u0007\u001a\f\u0010\r\u001a\u00020\n*\u00020\u0001H\u0007\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\u0001H\u0007\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a1\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\b2\b\b\u0001\u0010\u0018\u001a\u00020\u0001H\u0007\u001a1\u0010\u0019\u001a\u0004\u0018\u00010\u0001*\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001b\u001a1\u0010\u001c\u001a\u0004\u0018\u00010\u0001*\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a \u0010\u001d\u001a\u00020\u0015*\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0015H\u0007¨\u0006\u001f"}, d2 = {"getColorById", "", "Landroidx/fragment/app/Fragment;", "colorResId", "getDrawableById", "Landroid/graphics/drawable/Drawable;", "drawableRedId", "Landroid/app/Activity;", "Landroid/content/Context;", "getStringById", "", "", "stringResId", "toStringRes", "toDrawableRes", "toColorRes", "getDrawableResFromAttr", "attrResId", "typedValue", "Landroid/util/TypedValue;", "resolveRefs", "", "(Landroid/content/Context;ILandroid/util/TypedValue;Z)Ljava/lang/Integer;", "getDrawableFromAttr", "attrId", "getColorResFromAttr", "getColorFromAttr", "(Landroid/content/Context;I)Ljava/lang/Integer;", "getLayoutResFromAttr", "getBooleanResFromAttr", "defValue", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ResourcesKtxKt {
    public static final boolean getBooleanResFromAttr(Context context, int i10, boolean z10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes((AttributeSet) null, new int[]{i10});
                boolean z11 = typedArray.getBoolean(0, z10);
                typedArray.recycle();
                return z11;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (typedArray != null) {
                    typedArray.recycle();
                }
                return z10;
            }
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public static /* synthetic */ boolean getBooleanResFromAttr$default(Context context, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return getBooleanResFromAttr(context, i10, z10);
    }

    public static final int getColorById(Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        return androidx.core.content.a.getColor(context, i10);
    }

    public static final Integer getColorFromAttr(Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Integer colorFromAttr = getColorFromAttr(context, i10);
            if (colorFromAttr == null) {
                return null;
            }
            return Integer.valueOf(h.d(context.getResources(), colorFromAttr.intValue(), null));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static final Integer getColorResFromAttr(Context context, int i10, TypedValue typedValue, boolean z10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(typedValue, "typedValue");
        try {
            context.getTheme().resolveAttribute(i10, typedValue, z10);
            return Integer.valueOf(typedValue.resourceId);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Integer getColorResFromAttr$default(Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return getColorResFromAttr(context, i10, typedValue, z10);
    }

    public static final Drawable getDrawableById(Fragment fragment, int i10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        return androidx.core.content.a.getDrawable(context, i10);
    }

    public static final Drawable getDrawableFromAttr(Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            Integer drawableResFromAttr$default = getDrawableResFromAttr$default(context, i10, null, false, 6, null);
            if (drawableResFromAttr$default == null) {
                return null;
            }
            return h.f(context.getResources(), drawableResFromAttr$default.intValue(), null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static final Integer getDrawableResFromAttr(Context context, int i10, TypedValue typedValue, boolean z10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(typedValue, "typedValue");
        try {
            context.getTheme().resolveAttribute(i10, typedValue, z10);
            return Integer.valueOf(typedValue.resourceId);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Integer getDrawableResFromAttr$default(Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return getDrawableResFromAttr(context, i10, typedValue, z10);
    }

    public static final Integer getLayoutResFromAttr(Context context, int i10, TypedValue typedValue, boolean z10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(typedValue, "typedValue");
        try {
            context.getTheme().resolveAttribute(i10, typedValue, z10);
            return Integer.valueOf(typedValue.resourceId);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Integer getLayoutResFromAttr$default(Context context, int i10, TypedValue typedValue, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typedValue = new TypedValue();
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        return getLayoutResFromAttr(context, i10, typedValue, z10);
    }

    public static final String getStringById(Object obj, int i10) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Application app = AppUtils.getApp();
        if (app == null) {
            return "";
        }
        try {
            String string = app.getString(i10);
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static final int toColorRes(int i10) {
        return androidx.core.content.a.getColor(AppUtils.getApp(), i10);
    }

    public static final Drawable toDrawableRes(int i10) {
        return androidx.core.content.a.getDrawable(AppUtils.getApp(), i10);
    }

    public static final String toStringRes(int i10) {
        String string = AppUtils.getApp().getString(i10);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final int getColorById(Activity activity, int i10) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return androidx.core.content.a.getColor(activity, i10);
    }

    public static final Drawable getDrawableById(Activity activity, int i10) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return androidx.core.content.a.getDrawable(activity, i10);
    }

    public static final int getColorById(Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return androidx.core.content.a.getColor(context, i10);
    }

    public static final Drawable getDrawableById(Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return androidx.core.content.a.getDrawable(context, i10);
    }
}

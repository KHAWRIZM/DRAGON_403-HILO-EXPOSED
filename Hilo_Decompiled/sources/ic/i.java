package ic;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.TextView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private static TypedValue f١٤٨٨٥a;

    public static void a(TextView textView, int i10) {
        TypedArray obtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, R.styleable.QMUITextCommonStyleDef, i10, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int paddingLeft = textView.getPaddingLeft();
        int paddingRight = textView.getPaddingRight();
        int paddingTop = textView.getPaddingTop();
        int paddingBottom = textView.getPaddingBottom();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.QMUITextCommonStyleDef_android_gravity) {
                textView.setGravity(obtainStyledAttributes.getInt(index, -1));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textColor) {
                textView.setTextColor(obtainStyledAttributes.getColorStateList(index));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textSize) {
                textView.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingLeft) {
                paddingLeft = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingRight) {
                paddingRight = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingTop) {
                paddingTop = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_paddingBottom) {
                paddingBottom = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_singleLine) {
                textView.setSingleLine(obtainStyledAttributes.getBoolean(index, false));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_ellipsize) {
                int i12 = obtainStyledAttributes.getInt(index, 3);
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            if (i12 == 4) {
                                textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                            }
                        } else {
                            textView.setEllipsize(TextUtils.TruncateAt.END);
                        }
                    } else {
                        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    }
                } else {
                    textView.setEllipsize(TextUtils.TruncateAt.START);
                }
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_maxLines) {
                textView.setMaxLines(obtainStyledAttributes.getInt(index, -1));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_background) {
                k.g(textView, obtainStyledAttributes.getDrawable(index));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_lineSpacingExtra) {
                textView.setLineSpacing(obtainStyledAttributes.getDimensionPixelSize(index, 0), 1.0f);
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_drawablePadding) {
                textView.setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textColorHint) {
                textView.setHintTextColor(obtainStyledAttributes.getColor(index, 0));
            } else if (index == R.styleable.QMUITextCommonStyleDef_android_textStyle) {
                textView.setTypeface(null, obtainStyledAttributes.getInt(index, -1));
            }
        }
        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        obtainStyledAttributes.recycle();
    }

    public static int b(Context context, int i10) {
        return c(context.getTheme(), i10);
    }

    public static int c(Resources.Theme theme, int i10) {
        if (f١٤٨٨٥a == null) {
            f١٤٨٨٥a = new TypedValue();
        }
        if (!theme.resolveAttribute(i10, f١٤٨٨٥a, true)) {
            return 0;
        }
        TypedValue typedValue = f١٤٨٨٥a;
        if (typedValue.type == 2) {
            return c(theme, typedValue.data);
        }
        return typedValue.data;
    }

    public static ColorStateList d(Context context, Resources.Theme theme, int i10) {
        if (i10 == 0) {
            return null;
        }
        if (f١٤٨٨٥a == null) {
            f١٤٨٨٥a = new TypedValue();
        }
        if (!theme.resolveAttribute(i10, f١٤٨٨٥a, true)) {
            return null;
        }
        TypedValue typedValue = f١٤٨٨٥a;
        int i11 = typedValue.type;
        if (i11 >= 28 && i11 <= 31) {
            return ColorStateList.valueOf(typedValue.data);
        }
        if (i11 == 2) {
            return d(context, theme, typedValue.data);
        }
        int i12 = typedValue.resourceId;
        if (i12 == 0) {
            return null;
        }
        return androidx.core.content.a.getColorStateList(context, i12);
    }

    public static int e(Context context, int i10) {
        if (f١٤٨٨٥a == null) {
            f١٤٨٨٥a = new TypedValue();
        }
        if (!context.getTheme().resolveAttribute(i10, f١٤٨٨٥a, true)) {
            return 0;
        }
        return TypedValue.complexToDimensionPixelSize(f١٤٨٨٥a.data, e.d(context));
    }

    public static Drawable f(Context context, int i10) {
        return g(context, context.getTheme(), i10);
    }

    public static Drawable g(Context context, Resources.Theme theme, int i10) {
        if (i10 == 0) {
            return null;
        }
        if (f١٤٨٨٥a == null) {
            f١٤٨٨٥a = new TypedValue();
        }
        if (!theme.resolveAttribute(i10, f١٤٨٨٥a, true)) {
            return null;
        }
        TypedValue typedValue = f١٤٨٨٥a;
        int i11 = typedValue.type;
        if (i11 >= 28 && i11 <= 31) {
            return new ColorDrawable(f١٤٨٨٥a.data);
        }
        if (i11 == 2) {
            return g(context, theme, typedValue.data);
        }
        int i12 = typedValue.resourceId;
        if (i12 == 0) {
            return null;
        }
        return f.a(context, i12);
    }

    public static Drawable h(Context context, TypedArray typedArray, int i10) {
        int i11;
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue != null && peekValue.type != 2 && (i11 = peekValue.resourceId) != 0) {
            return f.a(context, i11);
        }
        return null;
    }

    public static float i(Context context, int i10) {
        return j(context.getTheme(), i10);
    }

    public static float j(Resources.Theme theme, int i10) {
        if (f١٤٨٨٥a == null) {
            f١٤٨٨٥a = new TypedValue();
        }
        if (!theme.resolveAttribute(i10, f١٤٨٨٥a, true)) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return f١٤٨٨٥a.getFloat();
    }
}

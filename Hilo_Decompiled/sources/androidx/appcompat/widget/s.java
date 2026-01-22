package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.d1;
import com.amazonaws.services.s3.internal.Constants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class s {

    /* renamed from: l, reason: collision with root package name */
    private static final RectF f١٦٥٢l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap f١٦٥٣m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private int f١٦٥٤a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٦٥٥b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f١٦٥٦c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f١٦٥٧d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f١٦٥٨e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f١٦٥٩f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٦٦٠g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f١٦٦١h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f١٦٦٢i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f١٦٦٣j;

    /* renamed from: k, reason: collision with root package name */
    private final d f١٦٦٤k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {
        static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, d dVar) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                dVar.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b extends d {
        b() {
        }

        @Override // androidx.appcompat.widget.s.d
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) s.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class c extends b {
        c() {
        }

        @Override // androidx.appcompat.widget.s.b, androidx.appcompat.widget.s.d
        void a(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.s.d
        boolean b(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {
        d() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) s.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TextView textView) {
        this.f١٦٦٢i = textView;
        this.f١٦٦٣j = textView.getContext();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            this.f١٦٦٤k = new c();
        } else if (i10 >= 23) {
            this.f١٦٦٤k = new b();
        } else {
            this.f١٦٦٤k = new d();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f١٦٥٤a = 0;
        this.f١٦٥٧d = -1.0f;
        this.f١٦٥٨e = -1.0f;
        this.f١٦٥٦c = -1.0f;
        this.f١٦٥٩f = new int[0];
        this.f١٦٥٥b = false;
    }

    private int e(RectF rectF) {
        int length = this.f١٦٥٩f.length;
        if (length != 0) {
            int i10 = 1;
            int i11 = length - 1;
            int i12 = 0;
            while (i10 <= i11) {
                int i13 = (i10 + i11) / 2;
                if (x(this.f١٦٥٩f[i13], rectF)) {
                    int i14 = i13 + 1;
                    i12 = i10;
                    i10 = i14;
                } else {
                    i12 = i13 - 1;
                    i11 = i12;
                }
            }
            return this.f١٦٥٩f[i12];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method k(String str) {
        try {
            Method method = (Method) f١٦٥٣m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                f١٦٥٣m.put(str, method);
            }
            return method;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    static Object m(Object obj, String str, Object obj2) {
        try {
            return k(str).invoke(obj, null);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return obj2;
        }
    }

    private void s(float f10) {
        if (f10 != this.f١٦٦٢i.getPaint().getTextSize()) {
            this.f١٦٦٢i.getPaint().setTextSize(f10);
            boolean isInLayout = this.f١٦٦٢i.isInLayout();
            if (this.f١٦٦٢i.getLayout() != null) {
                this.f١٦٥٥b = false;
                try {
                    Method k10 = k("nullLayouts");
                    if (k10 != null) {
                        k10.invoke(this.f١٦٦٢i, null);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (!isInLayout) {
                    this.f١٦٦٢i.requestLayout();
                } else {
                    this.f١٦٦٢i.forceLayout();
                }
                this.f١٦٦٢i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f١٦٥٤a == 1) {
            if (!this.f١٦٦٠g || this.f١٦٥٩f.length == 0) {
                int floor = ((int) Math.floor((this.f١٦٥٨e - this.f١٦٥٧d) / this.f١٦٥٦c)) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f١٦٥٧d + (i10 * this.f١٦٥٦c));
                }
                this.f١٦٥٩f = b(iArr);
            }
            this.f١٦٥٥b = true;
        } else {
            this.f١٦٥٥b = false;
        }
        return this.f١٦٥٥b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f١٦٥٩f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z10;
        if (this.f١٦٥٩f.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٦٦٠g = z10;
        if (z10) {
            this.f١٦٥٤a = 1;
            this.f١٦٥٧d = r0[0];
            this.f١٦٥٨e = r0[r1 - 1];
            this.f١٦٥٦c = -1.0f;
        }
        return z10;
    }

    private boolean x(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f١٦٦٢i.getText();
        TransformationMethod transformationMethod = this.f١٦٦٢i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f١٦٦٢i)) != null) {
            text = transformation;
        }
        int maxLines = this.f١٦٦٢i.getMaxLines();
        l(i10);
        StaticLayout d10 = d(text, (Layout.Alignment) m(this.f١٦٦٢i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        if ((maxLines != -1 && (d10.getLineCount() > maxLines || d10.getLineEnd(d10.getLineCount() - 1) != text.length())) || d10.getHeight() > rectF.bottom) {
            return false;
        }
        return true;
    }

    private boolean y() {
        return !(this.f١٦٦٢i instanceof AppCompatEditText);
    }

    private void z(float f10, float f11, float f12) {
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            if (f11 > f10) {
                if (f12 > DownloadProgress.UNKNOWN_PROGRESS) {
                    this.f١٦٥٤a = 1;
                    this.f١٦٥٧d = f10;
                    this.f١٦٥٨e = f11;
                    this.f١٦٥٦c = f12;
                    this.f١٦٦٠g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int measuredWidth;
        if (!n()) {
            return;
        }
        if (this.f١٦٥٥b) {
            if (this.f١٦٦٢i.getMeasuredHeight() > 0 && this.f١٦٦٢i.getMeasuredWidth() > 0) {
                if (this.f١٦٦٤k.b(this.f١٦٦٢i)) {
                    measuredWidth = Constants.MB;
                } else {
                    measuredWidth = (this.f١٦٦٢i.getMeasuredWidth() - this.f١٦٦٢i.getTotalPaddingLeft()) - this.f١٦٦٢i.getTotalPaddingRight();
                }
                int height = (this.f١٦٦٢i.getHeight() - this.f١٦٦٢i.getCompoundPaddingBottom()) - this.f١٦٦٢i.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = f١٦٥٢l;
                    synchronized (rectF) {
                        try {
                            rectF.setEmpty();
                            rectF.right = measuredWidth;
                            rectF.bottom = height;
                            float e10 = e(rectF);
                            if (e10 != this.f١٦٦٢i.getTextSize()) {
                                t(0, e10);
                            }
                        } finally {
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f١٦٥٥b = true;
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(charSequence, alignment, i10, i11, this.f١٦٦٢i, this.f١٦٦١h, this.f١٦٦٤k);
        }
        return new StaticLayout(charSequence, this.f١٦٦١h, i10, alignment, this.f١٦٦٢i.getLineSpacingMultiplier(), this.f١٦٦٢i.getLineSpacingExtra(), this.f١٦٦٢i.getIncludeFontPadding());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return Math.round(this.f١٦٥٨e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f١٦٥٧d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f١٦٥٦c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] i() {
        return this.f١٦٥٩f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f١٦٥٤a;
    }

    void l(int i10) {
        TextPaint textPaint = this.f١٦٦١h;
        if (textPaint == null) {
            this.f١٦٦١h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f١٦٦١h.set(this.f١٦٦٢i.getPaint());
        this.f١٦٦١h.setTextSize(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        if (y() && this.f١٦٥٤a != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(AttributeSet attributeSet, int i10) {
        float f10;
        float f11;
        float f12;
        int resourceId;
        Context context = this.f١٦٦٣j;
        int[] iArr = R.styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f١٦٦٢i;
        d1.o0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i10, 0);
        int i11 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f١٦٥٤a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        if (obtainStyledAttributes.hasValue(i12)) {
            f10 = obtainStyledAttributes.getDimension(i12, -1.0f);
        } else {
            f10 = -1.0f;
        }
        int i13 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        if (obtainStyledAttributes.hasValue(i13)) {
            f11 = obtainStyledAttributes.getDimension(i13, -1.0f);
        } else {
            f11 = -1.0f;
        }
        int i14 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (obtainStyledAttributes.hasValue(i14)) {
            f12 = obtainStyledAttributes.getDimension(i14, -1.0f);
        } else {
            f12 = -1.0f;
        }
        int i15 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (y()) {
            if (this.f١٦٥٤a == 1) {
                if (!this.f١٦٦٠g) {
                    DisplayMetrics displayMetrics = this.f١٦٦٣j.getResources().getDisplayMetrics();
                    if (f11 == -1.0f) {
                        f11 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (f12 == -1.0f) {
                        f12 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (f10 == -1.0f) {
                        f10 = 1.0f;
                    }
                    z(f11, f12, f10);
                }
                u();
                return;
            }
            return;
        }
        this.f١٦٥٤a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i10, int i11, int i12, int i13) {
        if (y()) {
            DisplayMetrics displayMetrics = this.f١٦٦٣j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int[] iArr, int i10) {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f١٦٦٣j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f١٦٥٩f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f١٦٦٠g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i10) {
        if (y()) {
            if (i10 != 0) {
                if (i10 == 1) {
                    DisplayMetrics displayMetrics = this.f١٦٦٣j.getResources().getDisplayMetrics();
                    z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (u()) {
                        a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i10, float f10) {
        Resources resources;
        Context context = this.f١٦٦٣j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        s(TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics()));
    }
}

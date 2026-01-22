package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f {
    private static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        if (aVar != null) {
            return aVar;
        }
        if (z10) {
            return new a(i10, i12, i11);
        }
        return new a(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray k10 = k.k(resources, theme, attributeSet, R.styleable.GradientColor);
            float f10 = k.f(k10, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, DownloadProgress.UNKNOWN_PROGRESS);
            float f11 = k.f(k10, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, DownloadProgress.UNKNOWN_PROGRESS);
            float f12 = k.f(k10, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, DownloadProgress.UNKNOWN_PROGRESS);
            float f13 = k.f(k10, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, DownloadProgress.UNKNOWN_PROGRESS);
            float f14 = k.f(k10, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, DownloadProgress.UNKNOWN_PROGRESS);
            float f15 = k.f(k10, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, DownloadProgress.UNKNOWN_PROGRESS);
            int g10 = k.g(k10, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
            int b10 = k.b(k10, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean j10 = k.j(xmlPullParser, "centerColor");
            int b11 = k.b(k10, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int b12 = k.b(k10, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
            int g11 = k.g(k10, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float f16 = k.f(k10, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, DownloadProgress.UNKNOWN_PROGRESS);
            k10.recycle();
            a a10 = a(c(resources, xmlPullParser, attributeSet, theme), b10, b12, j10, b11);
            if (g10 != 1) {
                if (g10 != 2) {
                    return new LinearGradient(f10, f11, f12, f13, a10.f٢٧٦٤a, a10.f٢٧٦٥b, d(g11));
                }
                return new SweepGradient(f14, f15, a10.f٢٧٦٤a, a10.f٢٧٦٥b);
            }
            if (f16 > DownloadProgress.UNKNOWN_PROGRESS) {
                return new RadialGradient(f14, f15, f16, a10.f٢٧٦٤a, a10.f٢٧٦٥b, d(g11));
            }
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray k10 = k.k(resources, theme, attributeSet, R.styleable.GradientColorItem);
                int i10 = R.styleable.GradientColorItem_android_color;
                boolean hasValue = k10.hasValue(i10);
                int i11 = R.styleable.GradientColorItem_android_offset;
                boolean hasValue2 = k10.hasValue(i11);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = k10.getColor(i10, 0);
                float f10 = k10.getFloat(i11, DownloadProgress.UNKNOWN_PROGRESS);
                k10.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f10));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int[] f٢٧٦٤a;

        /* renamed from: b, reason: collision with root package name */
        final float[] f٢٧٦٥b;

        a(List list, List list2) {
            int size = list.size();
            this.f٢٧٦٤a = new int[size];
            this.f٢٧٦٥b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f٢٧٦٤a[i10] = ((Integer) list.get(i10)).intValue();
                this.f٢٧٦٥b[i10] = ((Float) list2.get(i10)).floatValue();
            }
        }

        a(int i10, int i11) {
            this.f٢٧٦٤a = new int[]{i10, i11};
            this.f٢٧٦٥b = new float[]{DownloadProgress.UNKNOWN_PROGRESS, 1.0f};
        }

        a(int i10, int i11, int i12) {
            this.f٢٧٦٤a = new int[]{i10, i11, i12};
            this.f٢٧٦٥b = new float[]{DownloadProgress.UNKNOWN_PROGRESS, 0.5f, 1.0f};
        }
    }
}

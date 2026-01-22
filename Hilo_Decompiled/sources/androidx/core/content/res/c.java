package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f٢٧٤٨a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal threadLocal = f٢٧٤٨a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        float f10;
        int attributeCount;
        int i10;
        Resources resources2 = resources;
        int i11 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i12 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i11 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray h10 = h(resources2, theme, attributeSet, R.styleable.ColorStateListItem);
                int i13 = R.styleable.ColorStateListItem_android_color;
                int resourceId = h10.getResourceId(i13, -1);
                if (resourceId != -1 && !f(resources2, resourceId)) {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = h10.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                    }
                } else {
                    color = h10.getColor(i13, -65281);
                }
                int i14 = R.styleable.ColorStateListItem_android_alpha;
                float f11 = 1.0f;
                if (h10.hasValue(i14)) {
                    f11 = h10.getFloat(i14, 1.0f);
                } else {
                    int i15 = R.styleable.ColorStateListItem_alpha;
                    if (h10.hasValue(i15)) {
                        f11 = h10.getFloat(i15, 1.0f);
                    }
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    int i16 = R.styleable.ColorStateListItem_android_lStar;
                    if (h10.hasValue(i16)) {
                        f10 = h10.getFloat(i16, -1.0f);
                        h10.recycle();
                        attributeCount = attributeSet.getAttributeCount();
                        int[] iArr3 = new int[attributeCount];
                        int i17 = 0;
                        for (i10 = 0; i10 < attributeCount; i10++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                            if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                                int i18 = i17 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr3[i17] = attributeNameResource;
                                i17 = i18;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr3, i17);
                        iArr2 = g.a(iArr2, i12, g(color, f11, f10));
                        iArr = (int[][]) g.b(iArr, i12, trimStateSet);
                        i12++;
                    }
                }
                f10 = h10.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
                h10.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr32 = new int[attributeCount];
                int i172 = 0;
                while (i10 < attributeCount) {
                }
                int[] trimStateSet2 = StateSet.trimStateSet(iArr32, i172);
                iArr2 = g.a(iArr2, i12, g(color, f11, f10));
                iArr = (int[][]) g.b(iArr, i12, trimStateSet2);
                i12++;
            }
            i11 = 1;
            resources2 = resources;
        }
        int[] iArr4 = new int[i12];
        int[][] iArr5 = new int[i12];
        System.arraycopy(iArr2, 0, iArr4, 0, i12);
        System.arraycopy(iArr, 0, iArr5, 0, i12);
        return new ColorStateList(iArr5, iArr4);
    }

    private static boolean f(Resources resources, int i10) {
        TypedValue c10 = c();
        resources.getValue(i10, c10, true);
        int i11 = c10.type;
        if (i11 >= 28 && i11 <= 31) {
            return true;
        }
        return false;
    }

    private static int g(int i10, float f10, float f11) {
        boolean z10;
        if (f11 >= DownloadProgress.UNKNOWN_PROGRESS && f11 <= 100.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (f10 == 1.0f && !z10) {
            return i10;
        }
        int b10 = j2.a.b((int) ((Color.alpha(i10) * f10) + 0.5f), 0, KotlinVersion.MAX_COMPONENT_VALUE);
        if (z10) {
            a c10 = a.c(i10);
            i10 = a.m(c10.j(), c10.i(), f11);
        }
        return (i10 & 16777215) | (b10 << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}

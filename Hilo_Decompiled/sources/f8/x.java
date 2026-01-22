package f8;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import com.google.android.material.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    int f١٤٢٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private a f١٤٢٧٩b;

    /* renamed from: c, reason: collision with root package name */
    int[][] f١٤٢٨٠c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    a[] f١٤٢٨١d = new a[10];

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public b f١٤٢٨٢a;

        a(b bVar) {
            this.f١٤٢٨٢a = bVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        c f١٤٢٨٣a;

        /* renamed from: b, reason: collision with root package name */
        float f١٤٢٨٤b;

        b(c cVar, float f10) {
            this.f١٤٢٨٣a = cVar;
            this.f١٤٢٨٤b = f10;
        }

        public int a(int i10) {
            c cVar = this.f١٤٢٨٣a;
            if (cVar == c.PERCENT) {
                return (int) (this.f١٤٢٨٤b * i10);
            }
            if (cVar == c.PIXELS) {
                return (int) this.f١٤٢٨٤b;
            }
            return 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum c {
        PERCENT,
        PIXELS
    }

    private void a(int[] iArr, a aVar) {
        int i10 = this.f١٤٢٧٨a;
        if (i10 == 0 || iArr.length == 0) {
            this.f١٤٢٧٩b = aVar;
        }
        if (i10 >= this.f١٤٢٨٠c.length) {
            f(i10, i10 + 10);
        }
        int[][] iArr2 = this.f١٤٢٨٠c;
        int i11 = this.f١٤٢٧٨a;
        iArr2[i11] = iArr;
        this.f١٤٢٨١d[i11] = aVar;
        this.f١٤٢٧٨a = i11 + 1;
    }

    public static x b(Context context, TypedArray typedArray, int i10) {
        int next;
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId == 0 || !context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            return null;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(resourceId);
            try {
                x xVar = new x();
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    if (xml.getName().equals("selector")) {
                        xVar.h(context, xml, asAttributeSet, context.getTheme());
                    }
                    xml.close();
                    return xVar;
                }
                throw new XmlPullParserException("No start tag found");
            } catch (Throwable th) {
                if (xml != null) {
                    try {
                        xml.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            return null;
        }
    }

    private b d(TypedArray typedArray, int i10, b bVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return bVar;
        }
        int i11 = peekValue.type;
        if (i11 == 5) {
            return new b(c.PIXELS, TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i11 == 6) {
            return new b(c.PERCENT, peekValue.getFraction(1.0f, 1.0f));
        }
        return bVar;
    }

    private void f(int i10, int i11) {
        int[][] iArr = new int[i11];
        System.arraycopy(this.f١٤٢٨٠c, 0, iArr, 0, i10);
        this.f١٤٢٨٠c = iArr;
        a[] aVarArr = new a[i11];
        System.arraycopy(this.f١٤٢٨١d, 0, aVarArr, 0, i10);
        this.f١٤٢٨١d = aVarArr;
    }

    private int g(int[] iArr) {
        int[][] iArr2 = this.f١٤٢٨٠c;
        for (int i10 = 0; i10 < this.f١٤٢٧٨a; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    private void h(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainStyledAttributes;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 >= depth || next != 3) {
                    if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                        Resources resources = context.getResources();
                        if (theme == null) {
                            obtainStyledAttributes = resources.obtainAttributes(attributeSet, R.styleable.StateListSizeChange);
                        } else {
                            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.StateListSizeChange, 0, 0);
                        }
                        b d10 = d(obtainStyledAttributes, R.styleable.StateListSizeChange_widthChange, null);
                        obtainStyledAttributes.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i10 = 0;
                        for (int i11 = 0; i11 < attributeCount; i11++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                            if (attributeNameResource != R.attr.widthChange) {
                                int i12 = i10 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i10] = attributeNameResource;
                                i10 = i12;
                            }
                        }
                        a(StateSet.trimStateSet(iArr, i10), new a(d10));
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public int c(int i10) {
        float max;
        int i11 = -i10;
        for (int i12 = 0; i12 < this.f١٤٢٧٨a; i12++) {
            b bVar = this.f١٤٢٨١d[i12].f١٤٢٨٢a;
            c cVar = bVar.f١٤٢٨٣a;
            if (cVar == c.PIXELS) {
                max = Math.max(i11, bVar.f١٤٢٨٤b);
            } else if (cVar == c.PERCENT) {
                max = Math.max(i11, i10 * bVar.f١٤٢٨٤b);
            }
            i11 = (int) max;
        }
        return i11;
    }

    public a e(int[] iArr) {
        int g10 = g(iArr);
        if (g10 < 0) {
            g10 = g(StateSet.WILD_CARD);
        }
        if (g10 < 0) {
            return this.f١٤٢٧٩b;
        }
        return this.f١٤٢٨١d[g10];
    }
}

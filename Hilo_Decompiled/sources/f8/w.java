package f8;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.google.android.material.R;
import f8.o;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    final int f١٤٢٦٢a;

    /* renamed from: b, reason: collision with root package name */
    final o f١٤٢٦٣b;

    /* renamed from: c, reason: collision with root package name */
    final int[][] f١٤٢٦٤c;

    /* renamed from: d, reason: collision with root package name */
    final o[] f١٤٢٦٥d;

    /* renamed from: e, reason: collision with root package name */
    final v f١٤٢٦٦e;

    /* renamed from: f, reason: collision with root package name */
    final v f١٤٢٦٧f;

    /* renamed from: g, reason: collision with root package name */
    final v f١٤٢٦٨g;

    /* renamed from: h, reason: collision with root package name */
    final v f١٤٢٦٩h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f١٤٢٧٠a;

        /* renamed from: b, reason: collision with root package name */
        private o f١٤٢٧١b;

        /* renamed from: c, reason: collision with root package name */
        private int[][] f١٤٢٧٢c;

        /* renamed from: d, reason: collision with root package name */
        private o[] f١٤٢٧٣d;

        /* renamed from: e, reason: collision with root package name */
        private v f١٤٢٧٤e;

        /* renamed from: f, reason: collision with root package name */
        private v f١٤٢٧٥f;

        /* renamed from: g, reason: collision with root package name */
        private v f١٤٢٧٦g;

        /* renamed from: h, reason: collision with root package name */
        private v f١٤٢٧٧h;

        private boolean k(int i10, int i11) {
            if ((i11 | i10) == i10) {
                return true;
            }
            return false;
        }

        private void l(int i10, int i11) {
            int[][] iArr = new int[i11];
            System.arraycopy(this.f١٤٢٧٢c, 0, iArr, 0, i10);
            this.f١٤٢٧٢c = iArr;
            o[] oVarArr = new o[i11];
            System.arraycopy(this.f١٤٢٧٣d, 0, oVarArr, 0, i10);
            this.f١٤٢٧٣d = oVarArr;
        }

        private void m() {
            this.f١٤٢٧١b = new o();
            this.f١٤٢٧٢c = new int[10];
            this.f١٤٢٧٣d = new o[10];
        }

        public b i(int[] iArr, o oVar) {
            int i10 = this.f١٤٢٧٠a;
            if (i10 == 0 || iArr.length == 0) {
                this.f١٤٢٧١b = oVar;
            }
            if (i10 >= this.f١٤٢٧٢c.length) {
                l(i10, i10 + 10);
            }
            int[][] iArr2 = this.f١٤٢٧٢c;
            int i11 = this.f١٤٢٧٠a;
            iArr2[i11] = iArr;
            this.f١٤٢٧٣d[i11] = oVar;
            this.f١٤٢٧٠a = i11 + 1;
            return this;
        }

        public w j() {
            if (this.f١٤٢٧٠a == 0) {
                return null;
            }
            return new w(this);
        }

        public b n(v vVar, int i10) {
            if (k(i10, 1)) {
                this.f١٤٢٧٤e = vVar;
            }
            if (k(i10, 2)) {
                this.f١٤٢٧٥f = vVar;
            }
            if (k(i10, 4)) {
                this.f١٤٢٧٦g = vVar;
            }
            if (k(i10, 8)) {
                this.f١٤٢٧٧h = vVar;
            }
            return this;
        }

        public b(w wVar) {
            int i10 = wVar.f١٤٢٦٢a;
            this.f١٤٢٧٠a = i10;
            this.f١٤٢٧١b = wVar.f١٤٢٦٣b;
            int[][] iArr = wVar.f١٤٢٦٤c;
            int[][] iArr2 = new int[iArr.length];
            this.f١٤٢٧٢c = iArr2;
            this.f١٤٢٧٣d = new o[wVar.f١٤٢٦٥d.length];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(wVar.f١٤٢٦٥d, 0, this.f١٤٢٧٣d, 0, this.f١٤٢٧٠a);
            this.f١٤٢٧٤e = wVar.f١٤٢٦٦e;
            this.f١٤٢٧٥f = wVar.f١٤٢٦٧f;
            this.f١٤٢٧٦g = wVar.f١٤٢٦٨g;
            this.f١٤٢٧٧h = wVar.f١٤٢٦٩h;
        }

        public b(o oVar) {
            m();
            i(StateSet.WILD_CARD, oVar);
        }

        private b(Context context, int i10) {
            int next;
            m();
            try {
                XmlResourceParser xml = context.getResources().getXml(i10);
                try {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next = xml.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next == 2) {
                        if (xml.getName().equals("selector")) {
                            w.g(this, context, xml, asAttributeSet, context.getTheme());
                        }
                        xml.close();
                        return;
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
                m();
            }
        }
    }

    public static w b(Context context, TypedArray typedArray, int i10) {
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        return new b(context, resourceId).j();
    }

    private int e(int[] iArr) {
        int[][] iArr2 = this.f١٤٢٦٤c;
        for (int i10 = 0; i10 < this.f١٤٢٦٢a; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(b bVar, Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
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
                            obtainStyledAttributes = resources.obtainAttributes(attributeSet, R.styleable.MaterialShape);
                        } else {
                            obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, 0, 0);
                        }
                        o m10 = o.b(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0)).m();
                        obtainStyledAttributes.recycle();
                        int attributeCount = attributeSet.getAttributeCount();
                        int[] iArr = new int[attributeCount];
                        int i10 = 0;
                        for (int i11 = 0; i11 < attributeCount; i11++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                            if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                                int i12 = i10 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr[i10] = attributeNameResource;
                                i10 = i12;
                            }
                        }
                        bVar.i(StateSet.trimStateSet(iArr, i10), m10);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public static int h(int i10) {
        int i11 = i10 & 5;
        return ((i10 & 10) >> 1) | (i11 << 1);
    }

    public o c(boolean z10) {
        if (z10 && (this.f١٤٢٦٦e != null || this.f١٤٢٦٧f != null || this.f١٤٢٦٨g != null || this.f١٤٢٦٩h != null)) {
            o.b w10 = this.f١٤٢٦٣b.w();
            v vVar = this.f١٤٢٦٦e;
            if (vVar != null) {
                w10.F(vVar.e());
            }
            v vVar2 = this.f١٤٢٦٧f;
            if (vVar2 != null) {
                w10.J(vVar2.e());
            }
            v vVar3 = this.f١٤٢٦٨g;
            if (vVar3 != null) {
                w10.w(vVar3.e());
            }
            v vVar4 = this.f١٤٢٦٩h;
            if (vVar4 != null) {
                w10.A(vVar4.e());
            }
            return w10.m();
        }
        return this.f١٤٢٦٣b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public o d(int[] iArr) {
        int e10 = e(iArr);
        if (e10 < 0) {
            e10 = e(StateSet.WILD_CARD);
        }
        if (this.f١٤٢٦٦e == null && this.f١٤٢٦٧f == null && this.f١٤٢٦٨g == null && this.f١٤٢٦٩h == null) {
            return this.f١٤٢٦٥d[e10];
        }
        o.b w10 = this.f١٤٢٦٥d[e10].w();
        v vVar = this.f١٤٢٦٦e;
        if (vVar != null) {
            w10.F(vVar.d(iArr));
        }
        v vVar2 = this.f١٤٢٦٧f;
        if (vVar2 != null) {
            w10.J(vVar2.d(iArr));
        }
        v vVar3 = this.f١٤٢٦٨g;
        if (vVar3 != null) {
            w10.w(vVar3.d(iArr));
        }
        v vVar4 = this.f١٤٢٦٩h;
        if (vVar4 != null) {
            w10.A(vVar4.d(iArr));
        }
        return w10.m();
    }

    public boolean f() {
        if (this.f١٤٢٦٢a > 1) {
            return true;
        }
        v vVar = this.f١٤٢٦٦e;
        if (vVar != null && vVar.h()) {
            return true;
        }
        v vVar2 = this.f١٤٢٦٧f;
        if (vVar2 != null && vVar2.h()) {
            return true;
        }
        v vVar3 = this.f١٤٢٦٨g;
        if (vVar3 != null && vVar3.h()) {
            return true;
        }
        v vVar4 = this.f١٤٢٦٩h;
        if (vVar4 != null && vVar4.h()) {
            return true;
        }
        return false;
    }

    public b i() {
        return new b(this);
    }

    private w(b bVar) {
        this.f١٤٢٦٢a = bVar.f١٤٢٧٠a;
        this.f١٤٢٦٣b = bVar.f١٤٢٧١b;
        this.f١٤٢٦٤c = bVar.f١٤٢٧٢c;
        this.f١٤٢٦٥d = bVar.f١٤٢٧٣d;
        this.f١٤٢٦٦e = bVar.f١٤٢٧٤e;
        this.f١٤٢٦٧f = bVar.f١٤٢٧٥f;
        this.f١٤٢٦٨g = bVar.f١٤٢٧٦g;
        this.f١٤٢٦٩h = bVar.f١٤٢٧٧h;
    }
}

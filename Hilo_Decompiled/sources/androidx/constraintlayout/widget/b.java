package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f٢٣٨٩a;

    /* renamed from: b, reason: collision with root package name */
    c f٢٣٩٠b;

    /* renamed from: c, reason: collision with root package name */
    int f٢٣٩١c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f٢٣٩٢d = -1;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray f٢٣٩٣e = new SparseArray();

    /* renamed from: f, reason: collision with root package name */
    private SparseArray f٢٣٩٤f = new SparseArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f٢٣٩٥a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f٢٣٩٦b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        int f٢٣٩٧c;

        /* renamed from: d, reason: collision with root package name */
        c f٢٣٩٨d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f٢٣٩٧c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f٢٣٩٥a = obtainStyledAttributes.getResourceId(index, this.f٢٣٩٥a);
                } else if (index == R.styleable.State_constraints) {
                    this.f٢٣٩٧c = obtainStyledAttributes.getResourceId(index, this.f٢٣٩٧c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f٢٣٩٧c);
                    context.getResources().getResourceName(this.f٢٣٩٧c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f٢٣٩٨d = cVar;
                        cVar.n(context, this.f٢٣٩٧c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(C٠٠١٧b r22) {
            this.f٢٣٩٦b.add(r22);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f٢٣٩٦b.size(); i10++) {
                if (((C٠٠١٧b) this.f٢٣٩٦b.get(i10)).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠١٧b {

        /* renamed from: a, reason: collision with root package name */
        float f٢٣٩٩a;

        /* renamed from: b, reason: collision with root package name */
        float f٢٤٠٠b;

        /* renamed from: c, reason: collision with root package name */
        float f٢٤٠١c;

        /* renamed from: d, reason: collision with root package name */
        float f٢٤٠٢d;

        /* renamed from: e, reason: collision with root package name */
        int f٢٤٠٣e;

        /* renamed from: f, reason: collision with root package name */
        c f٢٤٠٤f;

        public C٠٠١٧b(Context context, XmlPullParser xmlPullParser) {
            this.f٢٣٩٩a = Float.NaN;
            this.f٢٤٠٠b = Float.NaN;
            this.f٢٤٠١c = Float.NaN;
            this.f٢٤٠٢d = Float.NaN;
            this.f٢٤٠٣e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    this.f٢٤٠٣e = obtainStyledAttributes.getResourceId(index, this.f٢٤٠٣e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f٢٤٠٣e);
                    context.getResources().getResourceName(this.f٢٤٠٣e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f٢٤٠٤f = cVar;
                        cVar.n(context, this.f٢٤٠٣e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f٢٤٠٢d = obtainStyledAttributes.getDimension(index, this.f٢٤٠٢d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f٢٤٠٠b = obtainStyledAttributes.getDimension(index, this.f٢٤٠٠b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f٢٤٠١c = obtainStyledAttributes.getDimension(index, this.f٢٤٠١c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f٢٣٩٩a = obtainStyledAttributes.getDimension(index, this.f٢٣٩٩a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f٢٣٩٩a) && f10 < this.f٢٣٩٩a) {
                return false;
            }
            if (!Float.isNaN(this.f٢٤٠٠b) && f11 < this.f٢٤٠٠b) {
                return false;
            }
            if (!Float.isNaN(this.f٢٤٠١c) && f10 > this.f٢٤٠١c) {
                return false;
            }
            if (!Float.isNaN(this.f٢٤٠٢d) && f11 > this.f٢٤٠٢d) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f٢٣٨٩a = constraintLayout;
        a(context, i10);
    }

    private void a(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            int eventType = xml.getEventType();
            a aVar = null;
            while (true) {
                char c10 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xml.getName();
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c10 = 4;
                                        break;
                                    }
                                    break;
                                case 80204913:
                                    if (name.equals("State")) {
                                        c10 = 2;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        break;
                                    }
                                    break;
                                case 1657696882:
                                    if (name.equals("layoutDescription")) {
                                        c10 = 0;
                                        break;
                                    }
                                    break;
                                case 1901439077:
                                    if (name.equals("Variant")) {
                                        c10 = 3;
                                        break;
                                    }
                                    break;
                            }
                            c10 = 65535;
                            if (c10 != 2) {
                                if (c10 != 3) {
                                    if (c10 == 4) {
                                        b(context, xml);
                                    }
                                } else {
                                    C٠٠١٧b r02 = new C٠٠١٧b(context, xml);
                                    if (aVar != null) {
                                        aVar.a(r02);
                                    }
                                }
                            } else {
                                aVar = new a(context, xml);
                                this.f٢٣٩٣e.put(aVar.f٢٣٩٥a, aVar);
                            }
                        }
                    } else {
                        xml.getName();
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        int i10;
        c cVar = new c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                if (attributeValue.contains("/")) {
                    i10 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i10 = -1;
                }
                if (i10 == -1) {
                    if (attributeValue.length() > 1) {
                        i10 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.E(context, xmlPullParser);
                this.f٢٣٩٤f.put(i10, cVar);
                return;
            }
        }
    }

    public void c(d dVar) {
    }

    public void d(int i10, float f10, float f11) {
        c cVar;
        a aVar;
        int b10;
        c cVar2;
        int i11 = this.f٢٣٩١c;
        if (i11 == i10) {
            if (i10 == -1) {
                aVar = (a) this.f٢٣٩٣e.valueAt(0);
            } else {
                aVar = (a) this.f٢٣٩٣e.get(i11);
            }
            int i12 = this.f٢٣٩٢d;
            if ((i12 != -1 && ((C٠٠١٧b) aVar.f٢٣٩٦b.get(i12)).a(f10, f11)) || this.f٢٣٩٢d == (b10 = aVar.b(f10, f11))) {
                return;
            }
            if (b10 == -1) {
                cVar2 = this.f٢٣٩٠b;
            } else {
                cVar2 = ((C٠٠١٧b) aVar.f٢٣٩٦b.get(b10)).f٢٤٠٤f;
            }
            if (b10 != -1) {
                int i13 = ((C٠٠١٧b) aVar.f٢٣٩٦b.get(b10)).f٢٤٠٣e;
            }
            if (cVar2 == null) {
                return;
            }
            this.f٢٣٩٢d = b10;
            cVar2.i(this.f٢٣٨٩a);
            return;
        }
        this.f٢٣٩١c = i10;
        a aVar2 = (a) this.f٢٣٩٣e.get(i10);
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            cVar = aVar2.f٢٣٩٨d;
        } else {
            cVar = ((C٠٠١٧b) aVar2.f٢٣٩٦b.get(b11)).f٢٤٠٤f;
        }
        if (b11 != -1) {
            int i14 = ((C٠٠١٧b) aVar2.f٢٣٩٦b.get(b11)).f٢٤٠٣e;
        }
        if (cVar == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
            return;
        }
        this.f٢٣٩٢d = b11;
        cVar.i(this.f٢٣٨٩a);
    }
}

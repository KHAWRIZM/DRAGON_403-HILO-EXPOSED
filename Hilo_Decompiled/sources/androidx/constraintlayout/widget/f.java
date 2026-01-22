package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    int f٢٥١٧a = -1;

    /* renamed from: b, reason: collision with root package name */
    int f٢٥١٨b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f٢٥١٩c = -1;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray f٢٥٢٠d = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    private SparseArray f٢٥٢١e = new SparseArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f٢٥٢٢a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList f٢٥٢٣b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        int f٢٥٢٤c;

        /* renamed from: d, reason: collision with root package name */
        boolean f٢٥٢٥d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f٢٥٢٤c = -1;
            this.f٢٥٢٥d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f٢٥٢٢a = obtainStyledAttributes.getResourceId(index, this.f٢٥٢٢a);
                } else if (index == R.styleable.State_constraints) {
                    this.f٢٥٢٤c = obtainStyledAttributes.getResourceId(index, this.f٢٥٢٤c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f٢٥٢٤c);
                    context.getResources().getResourceName(this.f٢٥٢٤c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f٢٥٢٥d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f٢٥٢٣b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f٢٥٢٣b.size(); i10++) {
                if (((b) this.f٢٥٢٣b.get(i10)).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        float f٢٥٢٦a;

        /* renamed from: b, reason: collision with root package name */
        float f٢٥٢٧b;

        /* renamed from: c, reason: collision with root package name */
        float f٢٥٢٨c;

        /* renamed from: d, reason: collision with root package name */
        float f٢٥٢٩d;

        /* renamed from: e, reason: collision with root package name */
        int f٢٥٣٠e;

        /* renamed from: f, reason: collision with root package name */
        boolean f٢٥٣١f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f٢٥٢٦a = Float.NaN;
            this.f٢٥٢٧b = Float.NaN;
            this.f٢٥٢٨c = Float.NaN;
            this.f٢٥٢٩d = Float.NaN;
            this.f٢٥٣٠e = -1;
            this.f٢٥٣١f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    this.f٢٥٣٠e = obtainStyledAttributes.getResourceId(index, this.f٢٥٣٠e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f٢٥٣٠e);
                    context.getResources().getResourceName(this.f٢٥٣٠e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f٢٥٣١f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f٢٥٢٩d = obtainStyledAttributes.getDimension(index, this.f٢٥٢٩d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f٢٥٢٧b = obtainStyledAttributes.getDimension(index, this.f٢٥٢٧b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f٢٥٢٨c = obtainStyledAttributes.getDimension(index, this.f٢٥٢٨c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f٢٥٢٦a = obtainStyledAttributes.getDimension(index, this.f٢٥٢٦a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f٢٥٢٦a) && f10 < this.f٢٥٢٦a) {
                return false;
            }
            if (!Float.isNaN(this.f٢٥٢٧b) && f11 < this.f٢٥٢٧b) {
                return false;
            }
            if (!Float.isNaN(this.f٢٥٢٨c) && f10 > this.f٢٥٢٨c) {
                return false;
            }
            if (!Float.isNaN(this.f٢٥٢٩d) && f11 > this.f٢٥٢٩d) {
                return false;
            }
            return true;
        }
    }

    public f(Context context, XmlPullParser xmlPullParser) {
        b(context, xmlPullParser);
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.StateSet_defaultState) {
                this.f٢٥١٧a = obtainStyledAttributes.getResourceId(index, this.f٢٥١٧a);
            }
        }
        obtainStyledAttributes.recycle();
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar = null;
            while (true) {
                char c10 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType != 2) {
                            if (eventType != 3) {
                                continue;
                            } else if ("StateSet".equals(xmlPullParser.getName())) {
                                return;
                            }
                        } else {
                            String name = xmlPullParser.getName();
                            switch (name.hashCode()) {
                                case 80204913:
                                    if (name.equals("State")) {
                                        c10 = 2;
                                        break;
                                    }
                                    break;
                                case 1301459538:
                                    if (name.equals("LayoutDescription")) {
                                        c10 = 0;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
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
                                if (c10 == 3) {
                                    b bVar = new b(context, xmlPullParser);
                                    if (aVar != null) {
                                        aVar.a(bVar);
                                    }
                                }
                            } else {
                                aVar = new a(context, xmlPullParser);
                                this.f٢٥٢٠d.put(aVar.f٢٥٢٢a, aVar);
                            }
                        }
                    } else {
                        xmlPullParser.getName();
                    }
                    eventType = xmlPullParser.next();
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

    public int a(int i10, int i11, float f10, float f11) {
        a aVar = (a) this.f٢٥٢٠d.get(i11);
        if (aVar == null) {
            return i11;
        }
        if (f10 != -1.0f && f11 != -1.0f) {
            Iterator it = aVar.f٢٥٢٣b.iterator();
            b bVar = null;
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.a(f10, f11)) {
                    if (i10 == bVar2.f٢٥٣٠e) {
                        return i10;
                    }
                    bVar = bVar2;
                }
            }
            if (bVar != null) {
                return bVar.f٢٥٣٠e;
            }
            return aVar.f٢٥٢٤c;
        }
        if (aVar.f٢٥٢٤c == i10) {
            return i10;
        }
        Iterator it2 = aVar.f٢٥٢٣b.iterator();
        while (it2.hasNext()) {
            if (i10 == ((b) it2.next()).f٢٥٣٠e) {
                return i10;
            }
        }
        return aVar.f٢٥٢٤c;
    }

    public int c(int i10, int i11, int i12) {
        return d(-1, i10, i11, i12);
    }

    public int d(int i10, int i11, float f10, float f11) {
        a aVar;
        if (i10 == i11) {
            if (i11 == -1) {
                aVar = (a) this.f٢٥٢٠d.valueAt(0);
            } else {
                aVar = (a) this.f٢٥٢٠d.get(this.f٢٥١٨b);
            }
            if (aVar == null) {
                return -1;
            }
            if (this.f٢٥١٩c != -1 && ((b) aVar.f٢٥٢٣b.get(i10)).a(f10, f11)) {
                return i10;
            }
            int b10 = aVar.b(f10, f11);
            if (i10 == b10) {
                return i10;
            }
            if (b10 == -1) {
                return aVar.f٢٥٢٤c;
            }
            return ((b) aVar.f٢٥٢٣b.get(b10)).f٢٥٣٠e;
        }
        a aVar2 = (a) this.f٢٥٢٠d.get(i11);
        if (aVar2 == null) {
            return -1;
        }
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            return aVar2.f٢٥٢٤c;
        }
        return ((b) aVar2.f٢٥٢٣b.get(b11)).f٢٥٣٠e;
    }
}

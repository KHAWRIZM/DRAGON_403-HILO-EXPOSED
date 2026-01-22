package x6;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i {

    /* renamed from: n, reason: collision with root package name */
    static final String f١٨٩٥٣n = "i";

    /* renamed from: o, reason: collision with root package name */
    private static final Matrix f١٨٩٥٤o = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    private final XmlPullParser f١٨٩٥٦b;

    /* renamed from: j, reason: collision with root package name */
    private float f١٨٩٦٤j;

    /* renamed from: k, reason: collision with root package name */
    private float f١٨٩٦٥k;

    /* renamed from: l, reason: collision with root package name */
    private Path f١٨٩٦٦l;

    /* renamed from: a, reason: collision with root package name */
    private HashMap f١٨٩٥٥a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final RectF f١٨٩٥٧c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    private float f١٨٩٥٨d = 72.0f;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٨٩٥٩e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f١٨٩٦٠f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٨٩٦١g = false;

    /* renamed from: h, reason: collision with root package name */
    private final Deque f١٨٩٦٢h = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    private final Deque f١٨٩٦٣i = new LinkedList();

    /* renamed from: m, reason: collision with root package name */
    private g f١٨٩٦٧m = null;

    private i(XmlPullParser xmlPullParser) {
        this.f١٨٩٥٦b = xmlPullParser;
    }

    public static g d(InputStream inputStream) {
        return e(inputStream, true, 72.0f);
    }

    private static g e(InputStream inputStream, boolean z10, float f10) {
        try {
            jf.a aVar = new jf.a();
            i iVar = new i(aVar);
            iVar.l(f10);
            if (z10) {
                aVar.setInput(new InputStreamReader(inputStream));
                iVar.h();
            } else {
                a aVar2 = new a(inputStream);
                jf.a aVar3 = new jf.a();
                aVar3.setInput(new InputStreamReader(aVar2.b()));
                b bVar = new b(aVar3);
                bVar.c();
                iVar.f١٨٩٥٥a = bVar.f١٨٩٣٥a;
                aVar.setInput(new InputStreamReader(aVar2.b()));
                iVar.h();
            }
            return iVar.f١٨٩٦٧m;
        } catch (Exception e10) {
            Log.w(f١٨٩٥٣n, "Parse error: " + e10);
            throw new RuntimeException(e10);
        }
    }

    private Path f() {
        Path path = (Path) this.f١٨٩٦٢h.pop();
        this.f١٨٩٦٦l = (Path) this.f١٨٩٦٢h.peek();
        return path;
    }

    private Matrix g() {
        return (Matrix) this.f١٨٩٦٣i.pop();
    }

    private void i() {
        Path path = new Path();
        this.f١٨٩٦٦l = path;
        this.f١٨٩٦٢h.add(path);
    }

    private void j(Matrix matrix) {
        if (matrix == null) {
            matrix = f١٨٩٥٤o;
        }
        this.f١٨٩٦٣i.push(matrix);
    }

    private void k(XmlPullParser xmlPullParser) {
        Matrix a10;
        String c10 = e.c("transform", xmlPullParser);
        if (c10 == null) {
            a10 = f١٨٩٥٤o;
        } else {
            a10 = j.a(c10);
        }
        this.f١٨٩٦٣i.push(a10);
    }

    private String m(XmlPullParser xmlPullParser) {
        String str = "";
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            str = str + " " + xmlPullParser.getAttributeName(i10) + "='" + xmlPullParser.getAttributeValue(i10) + "'";
        }
        return str;
    }

    void a() {
        String name = this.f١٨٩٥٦b.getName();
        if (this.f١٨٩٦١g) {
            if (name.equals("defs")) {
                this.f١٨٩٦١g = false;
                return;
            }
            return;
        }
        if (name.equals("svg")) {
            Path f10 = f();
            f10.transform(g());
            this.f١٨٩٦٧m = new g(f10, this.f١٨٩٦٤j, this.f١٨٩٦٥k);
        } else if (name.equals("g")) {
            if (this.f١٨٩٥٩e) {
                int i10 = this.f١٨٩٦٠f - 1;
                this.f١٨٩٦٠f = i10;
                if (i10 == 0) {
                    this.f١٨٩٥٩e = false;
                }
            }
            Path f11 = f();
            f11.transform(g());
            this.f١٨٩٦٦l.addPath(f11);
        }
    }

    final Float b(String str, XmlPullParser xmlPullParser) {
        return c(str, xmlPullParser, null);
    }

    final Float c(String str, XmlPullParser xmlPullParser, Float f10) {
        Float a10 = e.a(str, xmlPullParser, this.f١٨٩٥٨d, this.f١٨٩٦٤j, this.f١٨٩٦٥k);
        if (a10 != null) {
            return a10;
        }
        return f10;
    }

    void h() {
        int eventType = this.f١٨٩٥٦b.getEventType();
        do {
            if (eventType != 2) {
                if (eventType == 3) {
                    a();
                }
            } else {
                n();
            }
            eventType = this.f١٨٩٥٦b.next();
        } while (eventType != 1);
    }

    void l(float f10) {
        this.f١٨٩٥٨d = f10;
    }

    void n() {
        ArrayList arrayList;
        String name = this.f١٨٩٥٦b.getName();
        if (this.f١٨٩٦١g) {
            return;
        }
        if (name.equals("svg")) {
            this.f١٨٩٦٤j = Math.round(c(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f١٨٩٥٦b, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)).floatValue());
            this.f١٨٩٦٥k = Math.round(c(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f١٨٩٥٦b, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)).floatValue());
            d a10 = d.a("viewBox", this.f١٨٩٥٦b);
            i();
            Matrix matrix = f١٨٩٥٤o;
            if (a10 != null && (arrayList = a10.f١٨٩٤٢a) != null && arrayList.size() == 4) {
                float f10 = this.f١٨٩٦٤j;
                if (f10 >= 0.1f && this.f١٨٩٦٥k >= -0.1f) {
                    matrix.setScale(f10 / (((Float) a10.f١٨٩٤٢a.get(2)).floatValue() - ((Float) a10.f١٨٩٤٢a.get(0)).floatValue()), this.f١٨٩٦٥k / (((Float) a10.f١٨٩٤٢a.get(3)).floatValue() - ((Float) a10.f١٨٩٤٢a.get(1)).floatValue()));
                } else {
                    this.f١٨٩٦٤j = ((Float) a10.f١٨٩٤٢a.get(2)).floatValue() - ((Float) a10.f١٨٩٤٢a.get(0)).floatValue();
                    this.f١٨٩٦٤j = ((Float) a10.f١٨٩٤٢a.get(3)).floatValue() - ((Float) a10.f١٨٩٤٢a.get(3)).floatValue();
                }
            }
            j(matrix);
            return;
        }
        if (name.equals("defs")) {
            this.f١٨٩٦١g = true;
            return;
        }
        if (name.equals("use")) {
            String c10 = e.c("xlink:href", this.f١٨٩٥٦b);
            String c11 = e.c("transform", this.f١٨٩٥٦b);
            String c12 = e.c("x", this.f١٨٩٥٦b);
            String c13 = e.c("y", this.f١٨٩٥٦b);
            if (c11 != null || c12 != null || c13 != null) {
                if (c11 != null) {
                    e.b(c11);
                }
                if (c12 != null || c13 != null) {
                    if (c12 != null) {
                        e.b(c12);
                    }
                    if (c13 != null) {
                        e.b(c13);
                    }
                }
            }
            for (int i10 = 0; i10 < this.f١٨٩٥٦b.getAttributeCount(); i10++) {
                String attributeName = this.f١٨٩٥٦b.getAttributeName(i10);
                if (!"x".equals(attributeName) && !"y".equals(attributeName) && !ViewHierarchyConstants.DIMENSION_WIDTH_KEY.equals(attributeName) && !ViewHierarchyConstants.DIMENSION_HEIGHT_KEY.equals(attributeName) && !"xlink:href".equals(attributeName) && !"transform".equals(attributeName)) {
                    e.b(this.f١٨٩٥٦b.getAttributeValue(i10));
                }
            }
            return;
        }
        if (name.equals("g")) {
            if (this.f١٨٩٥٩e) {
                this.f١٨٩٦٠f++;
            }
            if ("none".equals(e.c("display", this.f١٨٩٥٦b)) && !this.f١٨٩٥٩e) {
                this.f١٨٩٥٩e = true;
                this.f١٨٩٦٠f = 1;
            }
            k(this.f١٨٩٥٦b);
            i();
            return;
        }
        if (!this.f١٨٩٥٩e && name.equals("rect")) {
            Float c14 = c("x", this.f١٨٩٥٦b, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            Float c15 = c("y", this.f١٨٩٥٦b, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            Float b10 = b(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f١٨٩٥٦b);
            Float b11 = b(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f١٨٩٥٦b);
            Float c16 = c("rx", this.f١٨٩٥٦b, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            Float c17 = c("ry", this.f١٨٩٥٦b, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            Path path = new Path();
            if (c16.floatValue() <= DownloadProgress.UNKNOWN_PROGRESS && c17.floatValue() <= DownloadProgress.UNKNOWN_PROGRESS) {
                path.addRect(c14.floatValue(), c15.floatValue(), c14.floatValue() + b10.floatValue(), c15.floatValue() + b11.floatValue(), Path.Direction.CW);
            } else {
                this.f١٨٩٥٧c.set(c14.floatValue(), c15.floatValue(), c14.floatValue() + b10.floatValue(), c15.floatValue() + b11.floatValue());
                path.addRoundRect(this.f١٨٩٥٧c, c16.floatValue(), c17.floatValue(), Path.Direction.CW);
            }
            k(this.f١٨٩٥٦b);
            path.transform(g());
            this.f١٨٩٦٦l.addPath(path);
            return;
        }
        if (!this.f١٨٩٥٩e && name.equals("line")) {
            Float b12 = b("x1", this.f١٨٩٥٦b);
            Float b13 = b("x2", this.f١٨٩٥٦b);
            Float b14 = b("y1", this.f١٨٩٥٦b);
            Float b15 = b("y2", this.f١٨٩٥٦b);
            Path path2 = new Path();
            path2.moveTo(b12.floatValue(), b14.floatValue());
            path2.lineTo(b13.floatValue(), b15.floatValue());
            k(this.f١٨٩٥٦b);
            path2.transform(g());
            this.f١٨٩٦٦l.addPath(path2);
            return;
        }
        if (!this.f١٨٩٥٩e && name.equals("circle")) {
            Float b16 = b("cx", this.f١٨٩٥٦b);
            Float b17 = b("cy", this.f١٨٩٥٦b);
            Float b18 = b("r", this.f١٨٩٥٦b);
            if (b16 != null && b17 != null && b18 != null) {
                Path path3 = new Path();
                path3.addCircle(b16.floatValue(), b17.floatValue(), b18.floatValue(), Path.Direction.CW);
                k(this.f١٨٩٥٦b);
                path3.transform(g());
                this.f١٨٩٦٦l.addPath(path3);
                return;
            }
            return;
        }
        if (!this.f١٨٩٥٩e && name.equals("ellipse")) {
            Float b19 = b("cx", this.f١٨٩٥٦b);
            Float b20 = b("cy", this.f١٨٩٥٦b);
            Float b21 = b("rx", this.f١٨٩٥٦b);
            Float b22 = b("ry", this.f١٨٩٥٦b);
            if (b19 != null && b20 != null && b21 != null && b22 != null) {
                this.f١٨٩٥٧c.set(b19.floatValue() - b21.floatValue(), b20.floatValue() - b22.floatValue(), b19.floatValue() + b21.floatValue(), b20.floatValue() + b22.floatValue());
                Path path4 = new Path();
                path4.addOval(this.f١٨٩٥٧c, Path.Direction.CW);
                k(this.f١٨٩٥٦b);
                path4.transform(g());
                this.f١٨٩٦٦l.addPath(path4);
                return;
            }
            return;
        }
        if (!this.f١٨٩٥٩e && (name.equals("polygon") || name.equals("polyline"))) {
            d a11 = d.a("points", this.f١٨٩٥٦b);
            if (a11 != null) {
                Path path5 = new Path();
                ArrayList arrayList2 = a11.f١٨٩٤٢a;
                if (arrayList2.size() > 1) {
                    path5.moveTo(((Float) arrayList2.get(0)).floatValue(), ((Float) arrayList2.get(1)).floatValue());
                    for (int i11 = 2; i11 < arrayList2.size(); i11 += 2) {
                        path5.lineTo(((Float) arrayList2.get(i11)).floatValue(), ((Float) arrayList2.get(i11 + 1)).floatValue());
                    }
                    if (name.equals("polygon")) {
                        path5.close();
                    }
                    k(this.f١٨٩٥٦b);
                    path5.transform(g());
                    this.f١٨٩٦٦l.addPath(path5);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.f١٨٩٥٩e && name.equals("path")) {
            Path a12 = h.a(e.c("d", this.f١٨٩٥٦b));
            k(this.f١٨٩٥٦b);
            a12.transform(g());
            this.f١٨٩٦٦l.addPath(a12);
            return;
        }
        if ((this.f١٨٩٥٩e || !name.equals("metadata")) && !this.f١٨٩٥٩e) {
            Log.d(f١٨٩٥٣n, String.format("Unrecognized tag: %s (%s)", name, m(this.f١٨٩٥٦b)));
        }
    }
}

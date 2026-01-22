package d2;

import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements d {

    /* renamed from: d, reason: collision with root package name */
    p f١٣٥٧١d;

    /* renamed from: f, reason: collision with root package name */
    int f١٣٥٧٣f;

    /* renamed from: g, reason: collision with root package name */
    public int f١٣٥٧٤g;

    /* renamed from: a, reason: collision with root package name */
    public d f١٣٥٦٨a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٣٥٦٩b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f١٣٥٧٠c = false;

    /* renamed from: e, reason: collision with root package name */
    a f١٣٥٧٢e = a.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    int f١٣٥٧٥h = 1;

    /* renamed from: i, reason: collision with root package name */
    g f١٣٥٧٦i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f١٣٥٧٧j = false;

    /* renamed from: k, reason: collision with root package name */
    List f١٣٥٧٨k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    List f١٣٥٧٩l = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f١٣٥٧١d = pVar;
    }

    @Override // d2.d
    public void a(d dVar) {
        Iterator it = this.f١٣٥٧٩l.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f١٣٥٧٧j) {
                return;
            }
        }
        this.f١٣٥٧٠c = true;
        d dVar2 = this.f١٣٥٦٨a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f١٣٥٦٩b) {
            this.f١٣٥٧١d.a(this);
            return;
        }
        f fVar = null;
        int i10 = 0;
        for (f fVar2 : this.f١٣٥٧٩l) {
            if (!(fVar2 instanceof g)) {
                i10++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i10 == 1 && fVar.f١٣٥٧٧j) {
            g gVar = this.f١٣٥٧٦i;
            if (gVar != null) {
                if (gVar.f١٣٥٧٧j) {
                    this.f١٣٥٧٣f = this.f١٣٥٧٥h * gVar.f١٣٥٧٤g;
                } else {
                    return;
                }
            }
            d(fVar.f١٣٥٧٤g + this.f١٣٥٧٣f);
        }
        d dVar3 = this.f١٣٥٦٨a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f١٣٥٧٨k.add(dVar);
        if (this.f١٣٥٧٧j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f١٣٥٧٩l.clear();
        this.f١٣٥٧٨k.clear();
        this.f١٣٥٧٧j = false;
        this.f١٣٥٧٤g = 0;
        this.f١٣٥٧٠c = false;
        this.f١٣٥٦٩b = false;
    }

    public void d(int i10) {
        if (this.f١٣٥٧٧j) {
            return;
        }
        this.f١٣٥٧٧j = true;
        this.f١٣٥٧٤g = i10;
        for (d dVar : this.f١٣٥٧٨k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f١٣٥٧١d.f١٣٦٢٢b.v());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.f١٣٥٧٢e);
        sb.append("(");
        if (this.f١٣٥٧٧j) {
            obj = Integer.valueOf(this.f١٣٥٧٤g);
        } else {
            obj = "unresolved";
        }
        sb.append(obj);
        sb.append(") <t=");
        sb.append(this.f١٣٥٧٩l.size());
        sb.append(":d=");
        sb.append(this.f١٣٥٧٨k.size());
        sb.append(">");
        return sb.toString();
    }
}

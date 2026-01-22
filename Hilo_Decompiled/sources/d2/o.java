package d2;

import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o {

    /* renamed from: g, reason: collision with root package name */
    static int f١٣٦٠٦g;

    /* renamed from: b, reason: collision with root package name */
    int f١٣٦٠٨b;

    /* renamed from: d, reason: collision with root package name */
    int f١٣٦١٠d;

    /* renamed from: a, reason: collision with root package name */
    ArrayList f١٣٦٠٧a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    boolean f١٣٦٠٩c = false;

    /* renamed from: e, reason: collision with root package name */
    ArrayList f١٣٦١١e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٦١٢f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        WeakReference f١٣٦١٣a;

        /* renamed from: b, reason: collision with root package name */
        int f١٣٦١٤b;

        /* renamed from: c, reason: collision with root package name */
        int f١٣٦١٥c;

        /* renamed from: d, reason: collision with root package name */
        int f١٣٦١٦d;

        /* renamed from: e, reason: collision with root package name */
        int f١٣٦١٧e;

        /* renamed from: f, reason: collision with root package name */
        int f١٣٦١٨f;

        /* renamed from: g, reason: collision with root package name */
        int f١٣٦١٩g;

        public a(c2.e eVar, z1.d dVar, int i10) {
            this.f١٣٦١٣a = new WeakReference(eVar);
            this.f١٣٦١٤b = dVar.y(eVar.Q);
            this.f١٣٦١٥c = dVar.y(eVar.R);
            this.f١٣٦١٦d = dVar.y(eVar.S);
            this.f١٣٦١٧e = dVar.y(eVar.T);
            this.f١٣٦١٨f = dVar.y(eVar.U);
            this.f١٣٦١٩g = i10;
        }
    }

    public o(int i10) {
        int i11 = f١٣٦٠٦g;
        f١٣٦٠٦g = i11 + 1;
        this.f١٣٦٠٨b = i11;
        this.f١٣٦١٠d = i10;
    }

    private String e() {
        int i10 = this.f١٣٦١٠d;
        if (i10 == 0) {
            return "Horizontal";
        }
        if (i10 == 1) {
            return "Vertical";
        }
        if (i10 == 2) {
            return "Both";
        }
        return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    private int j(z1.d dVar, ArrayList arrayList, int i10) {
        int y10;
        int y11;
        c2.f fVar = (c2.f) ((c2.e) arrayList.get(0)).M();
        dVar.E();
        fVar.g(dVar, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ((c2.e) arrayList.get(i11)).g(dVar, false);
        }
        if (i10 == 0 && fVar.f٥٧٦٦g1 > 0) {
            c2.b.b(fVar, dVar, arrayList, 0);
        }
        if (i10 == 1 && fVar.f٥٧٦٧h1 > 0) {
            c2.b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.A();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f١٣٦١١e = new ArrayList();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f١٣٦١١e.add(new a((c2.e) arrayList.get(i12), dVar, i10));
        }
        if (i10 == 0) {
            y10 = dVar.y(fVar.Q);
            y11 = dVar.y(fVar.S);
            dVar.E();
        } else {
            y10 = dVar.y(fVar.R);
            y11 = dVar.y(fVar.T);
            dVar.E();
        }
        return y11 - y10;
    }

    public boolean a(c2.e eVar) {
        if (this.f١٣٦٠٧a.contains(eVar)) {
            return false;
        }
        this.f١٣٦٠٧a.add(eVar);
        return true;
    }

    public void b(ArrayList arrayList) {
        int size = this.f١٣٦٠٧a.size();
        if (this.f١٣٦١٢f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                o oVar = (o) arrayList.get(i10);
                if (this.f١٣٦١٢f == oVar.f١٣٦٠٨b) {
                    g(this.f١٣٦١٠d, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f١٣٦٠٨b;
    }

    public int d() {
        return this.f١٣٦١٠d;
    }

    public int f(z1.d dVar, int i10) {
        if (this.f١٣٦٠٧a.size() == 0) {
            return 0;
        }
        return j(dVar, this.f١٣٦٠٧a, i10);
    }

    public void g(int i10, o oVar) {
        Iterator it = this.f١٣٦٠٧a.iterator();
        while (it.hasNext()) {
            c2.e eVar = (c2.e) it.next();
            oVar.a(eVar);
            if (i10 == 0) {
                eVar.S0 = oVar.c();
            } else {
                eVar.T0 = oVar.c();
            }
        }
        this.f١٣٦١٢f = oVar.f١٣٦٠٨b;
    }

    public void h(boolean z10) {
        this.f١٣٦٠٩c = z10;
    }

    public void i(int i10) {
        this.f١٣٦١٠d = i10;
    }

    public String toString() {
        String str = e() + " [" + this.f١٣٦٠٨b + "] <";
        Iterator it = this.f١٣٦٠٧a.iterator();
        while (it.hasNext()) {
            str = str + " " + ((c2.e) it.next()).v();
        }
        return str + " >";
    }
}

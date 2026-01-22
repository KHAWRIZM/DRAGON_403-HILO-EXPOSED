package q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f١٧١١٥c = new e("COMPOSITION");

    /* renamed from: a, reason: collision with root package name */
    private final List f١٧١١٦a;

    /* renamed from: b, reason: collision with root package name */
    private f f١٧١١٧b;

    public e(String... strArr) {
        this.f١٧١١٦a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.f١٧١١٦a.get(r0.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f١٧١١٦a.add(str);
        return eVar;
    }

    public boolean c(String str, int i10) {
        boolean z10;
        boolean z11;
        if (i10 >= this.f١٧١١٦a.size()) {
            return false;
        }
        if (i10 == this.f١٧١١٦a.size() - 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str2 = (String) this.f١٧١١٦a.get(i10);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z11 = false;
            } else {
                z11 = true;
            }
            if ((!z10 && (i10 != this.f١٧١١٦a.size() - 2 || !b())) || !z11) {
                return false;
            }
            return true;
        }
        if (!z10 && ((String) this.f١٧١١٦a.get(i10 + 1)).equals(str)) {
            if (i10 != this.f١٧١١٦a.size() - 2 && (i10 != this.f١٧١١٦a.size() - 3 || !b())) {
                return false;
            }
            return true;
        }
        if (z10) {
            return true;
        }
        int i11 = i10 + 1;
        if (i11 < this.f١٧١١٦a.size() - 1) {
            return false;
        }
        return ((String) this.f١٧١١٦a.get(i11)).equals(str);
    }

    public f d() {
        return this.f١٧١١٧b;
    }

    public int e(String str, int i10) {
        if (f(str)) {
            return 0;
        }
        if (!((String) this.f١٧١١٦a.get(i10)).equals("**")) {
            return 1;
        }
        if (i10 == this.f١٧١١٦a.size() - 1 || !((String) this.f١٧١١٦a.get(i10 + 1)).equals(str)) {
            return 0;
        }
        return 2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f١٧١١٦a.equals(eVar.f١٧١١٦a)) {
            return false;
        }
        f fVar = this.f١٧١١٧b;
        f fVar2 = eVar.f١٧١١٧b;
        if (fVar != null) {
            return fVar.equals(fVar2);
        }
        if (fVar2 == null) {
            return true;
        }
        return false;
    }

    public boolean g(String str, int i10) {
        if (f(str)) {
            return true;
        }
        if (i10 >= this.f١٧١١٦a.size()) {
            return false;
        }
        if (((String) this.f١٧١١٦a.get(i10)).equals(str) || ((String) this.f١٧١١٦a.get(i10)).equals("**") || ((String) this.f١٧١١٦a.get(i10)).equals("*")) {
            return true;
        }
        return false;
    }

    public boolean h(String str, int i10) {
        if ("__container".equals(str) || i10 < this.f١٧١١٦a.size() - 1 || ((String) this.f١٧١١٦a.get(i10)).equals("**")) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f١٧١١٦a.hashCode() * 31;
        f fVar = this.f١٧١١٧b;
        if (fVar != null) {
            i10 = fVar.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public e i(f fVar) {
        e eVar = new e(this);
        eVar.f١٧١١٧b = fVar;
        return eVar;
    }

    public String toString() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f١٧١١٦a);
        sb.append(",resolved=");
        if (this.f١٧١١٧b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.f١٧١١٦a = new ArrayList(eVar.f١٧١١٦a);
        this.f١٧١١٧b = eVar.f١٧١١٧b;
    }
}

package h9;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private g9.b f١٤٥٥٠a;

    /* renamed from: b, reason: collision with root package name */
    private g9.a f١٤٥٥١b;

    /* renamed from: c, reason: collision with root package name */
    private g9.c f١٤٥٥٢c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٤٥٥٣d = -1;

    /* renamed from: e, reason: collision with root package name */
    private b f١٤٥٥٤e;

    public static boolean b(int i10) {
        if (i10 >= 0 && i10 < 8) {
            return true;
        }
        return false;
    }

    public b a() {
        return this.f١٤٥٥٤e;
    }

    public void c(g9.a aVar) {
        this.f١٤٥٥١b = aVar;
    }

    public void d(int i10) {
        this.f١٤٥٥٣d = i10;
    }

    public void e(b bVar) {
        this.f١٤٥٥٤e = bVar;
    }

    public void f(g9.b bVar) {
        this.f١٤٥٥٠a = bVar;
    }

    public void g(g9.c cVar) {
        this.f١٤٥٥٢c = cVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f١٤٥٥٠a);
        sb.append("\n ecLevel: ");
        sb.append(this.f١٤٥٥١b);
        sb.append("\n version: ");
        sb.append(this.f١٤٥٥٢c);
        sb.append("\n maskPattern: ");
        sb.append(this.f١٤٥٥٣d);
        if (this.f١٤٥٥٤e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f١٤٥٥٤e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}

package o4;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f١٦٦٣٦a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final j f١٦٦٣٧b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final j f١٦٦٣٨c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final j f١٦٦٣٩d = new d();

    /* renamed from: e, reason: collision with root package name */
    public static final j f١٦٦٤٠e = new e();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends j {
        a() {
        }

        @Override // o4.j
        public boolean a() {
            return true;
        }

        @Override // o4.j
        public boolean b() {
            return true;
        }

        @Override // o4.j
        public boolean c(m4.a aVar) {
            if (aVar == m4.a.REMOTE) {
                return true;
            }
            return false;
        }

        @Override // o4.j
        public boolean d(boolean z10, m4.a aVar, m4.c cVar) {
            if (aVar != m4.a.RESOURCE_DISK_CACHE && aVar != m4.a.MEMORY_CACHE) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends j {
        b() {
        }

        @Override // o4.j
        public boolean a() {
            return false;
        }

        @Override // o4.j
        public boolean b() {
            return false;
        }

        @Override // o4.j
        public boolean c(m4.a aVar) {
            return false;
        }

        @Override // o4.j
        public boolean d(boolean z10, m4.a aVar, m4.c cVar) {
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends j {
        c() {
        }

        @Override // o4.j
        public boolean a() {
            return true;
        }

        @Override // o4.j
        public boolean b() {
            return false;
        }

        @Override // o4.j
        public boolean c(m4.a aVar) {
            if (aVar != m4.a.DATA_DISK_CACHE && aVar != m4.a.MEMORY_CACHE) {
                return true;
            }
            return false;
        }

        @Override // o4.j
        public boolean d(boolean z10, m4.a aVar, m4.c cVar) {
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d extends j {
        d() {
        }

        @Override // o4.j
        public boolean a() {
            return false;
        }

        @Override // o4.j
        public boolean b() {
            return true;
        }

        @Override // o4.j
        public boolean c(m4.a aVar) {
            return false;
        }

        @Override // o4.j
        public boolean d(boolean z10, m4.a aVar, m4.c cVar) {
            if (aVar != m4.a.RESOURCE_DISK_CACHE && aVar != m4.a.MEMORY_CACHE) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class e extends j {
        e() {
        }

        @Override // o4.j
        public boolean a() {
            return true;
        }

        @Override // o4.j
        public boolean b() {
            return true;
        }

        @Override // o4.j
        public boolean c(m4.a aVar) {
            if (aVar == m4.a.REMOTE) {
                return true;
            }
            return false;
        }

        @Override // o4.j
        public boolean d(boolean z10, m4.a aVar, m4.c cVar) {
            if (((z10 && aVar == m4.a.DATA_DISK_CACHE) || aVar == m4.a.LOCAL) && cVar == m4.c.TRANSFORMED) {
                return true;
            }
            return false;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(m4.a aVar);

    public abstract boolean d(boolean z10, m4.a aVar, m4.c cVar);
}

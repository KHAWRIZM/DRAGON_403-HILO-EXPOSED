package k8;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class l {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class a implements k, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        final k f١٥٥٥٠a;

        /* renamed from: b, reason: collision with root package name */
        volatile transient boolean f١٥٥٥١b;

        /* renamed from: c, reason: collision with root package name */
        transient Object f١٥٥٥٢c;

        a(k kVar) {
            this.f١٥٥٥٠a = (k) h.i(kVar);
        }

        @Override // k8.k
        public Object get() {
            if (!this.f١٥٥٥١b) {
                synchronized (this) {
                    try {
                        if (!this.f١٥٥٥١b) {
                            Object obj = this.f١٥٥٥٠a.get();
                            this.f١٥٥٥٢c = obj;
                            this.f١٥٥٥١b = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return e.a(this.f١٥٥٥٢c);
        }

        public String toString() {
            Object obj;
            if (this.f١٥٥٥١b) {
                String valueOf = String.valueOf(this.f١٥٥٥٢c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(valueOf);
                sb.append(">");
                obj = sb.toString();
            } else {
                obj = this.f١٥٥٥٠a;
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class b implements k {

        /* renamed from: a, reason: collision with root package name */
        volatile k f١٥٥٥٣a;

        /* renamed from: b, reason: collision with root package name */
        volatile boolean f١٥٥٥٤b;

        /* renamed from: c, reason: collision with root package name */
        Object f١٥٥٥٥c;

        b(k kVar) {
            this.f١٥٥٥٣a = (k) h.i(kVar);
        }

        @Override // k8.k
        public Object get() {
            if (!this.f١٥٥٥٤b) {
                synchronized (this) {
                    try {
                        if (!this.f١٥٥٥٤b) {
                            k kVar = this.f١٥٥٥٣a;
                            Objects.requireNonNull(kVar);
                            Object obj = kVar.get();
                            this.f١٥٥٥٥c = obj;
                            this.f١٥٥٥٤b = true;
                            this.f١٥٥٥٣a = null;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return e.a(this.f١٥٥٥٥c);
        }

        public String toString() {
            Object obj = this.f١٥٥٥٣a;
            if (obj == null) {
                String valueOf = String.valueOf(this.f١٥٥٥٥c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(valueOf);
                sb.append(">");
                obj = sb.toString();
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class c implements k, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        final Object f١٥٥٥٦a;

        c(Object obj) {
            this.f١٥٥٥٦a = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return f.a(this.f١٥٥٥٦a, ((c) obj).f١٥٥٥٦a);
            }
            return false;
        }

        @Override // k8.k
        public Object get() {
            return this.f١٥٥٥٦a;
        }

        public int hashCode() {
            return f.b(this.f١٥٥٥٦a);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f١٥٥٥٦a);
            StringBuilder sb = new StringBuilder(valueOf.length() + 22);
            sb.append("Suppliers.ofInstance(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static k a(k kVar) {
        if (!(kVar instanceof b) && !(kVar instanceof a)) {
            if (kVar instanceof Serializable) {
                return new a(kVar);
            }
            return new b(kVar);
        }
        return kVar;
    }

    public static k b(Object obj) {
        return new c(obj);
    }
}

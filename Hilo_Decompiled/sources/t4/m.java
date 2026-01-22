package t4;

import java.util.Queue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final f5.h f١٨٠٧٨a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends f5.h {
        a(long j10) {
            super(j10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // f5.h
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void l(b bVar, Object obj) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        private static final Queue f١٨٠٨٠d = f5.l.g(0);

        /* renamed from: a, reason: collision with root package name */
        private int f١٨٠٨١a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٨٠٨٢b;

        /* renamed from: c, reason: collision with root package name */
        private Object f١٨٠٨٣c;

        private b() {
        }

        static b a(Object obj, int i10, int i11) {
            b bVar;
            Queue queue = f١٨٠٨٠d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.b(obj, i10, i11);
            return bVar;
        }

        private void b(Object obj, int i10, int i11) {
            this.f١٨٠٨٣c = obj;
            this.f١٨٠٨٢b = i10;
            this.f١٨٠٨١a = i11;
        }

        public void c() {
            Queue queue = f١٨٠٨٠d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f١٨٠٨٢b != bVar.f١٨٠٨٢b || this.f١٨٠٨١a != bVar.f١٨٠٨١a || !this.f١٨٠٨٣c.equals(bVar.f١٨٠٨٣c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f١٨٠٨١a * 31) + this.f١٨٠٨٢b) * 31) + this.f١٨٠٨٣c.hashCode();
        }
    }

    public m(long j10) {
        this.f١٨٠٧٨a = new a(j10);
    }

    public Object a(Object obj, int i10, int i11) {
        b a10 = b.a(obj, i10, i11);
        Object j10 = this.f١٨٠٧٨a.j(a10);
        a10.c();
        return j10;
    }

    public void b(Object obj, int i10, int i11, Object obj2) {
        this.f١٨٠٧٨a.m(b.a(obj, i10, i11), obj2);
    }
}

package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.j1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f٣٢٧٠a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f٣٢٧١b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f٣٢٧٢c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final j1.b f٣٢٧٣a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f٣٢٧٤b;

        /* renamed from: c, reason: collision with root package name */
        public final j1.b f٣٢٧٥c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f٣٢٧٦d;

        public a(j1.b bVar, Object obj, j1.b bVar2, Object obj2) {
            this.f٣٢٧٣a = bVar;
            this.f٣٢٧٤b = obj;
            this.f٣٢٧٥c = bVar2;
            this.f٣٢٧٦d = obj2;
        }
    }

    private c0(j1.b bVar, Object obj, j1.b bVar2, Object obj2) {
        this.f٣٢٧٠a = new a(bVar, obj, bVar2, obj2);
        this.f٣٢٧١b = obj;
        this.f٣٢٧٢c = obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(a aVar, Object obj, Object obj2) {
        return q.b(aVar.f٣٢٧٣a, 1, obj) + q.b(aVar.f٣٢٧٥c, 2, obj2);
    }

    public static c0 d(j1.b bVar, Object obj, j1.b bVar2, Object obj2) {
        return new c0(bVar, obj, bVar2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(i iVar, a aVar, Object obj, Object obj2) {
        q.u(iVar, aVar.f٣٢٧٣a, 1, obj);
        q.u(iVar, aVar.f٣٢٧٥c, 2, obj2);
    }

    public int a(int i10, Object obj, Object obj2) {
        return i.O(i10) + i.y(b(this.f٣٢٧٠a, obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c() {
        return this.f٣٢٧٠a;
    }
}

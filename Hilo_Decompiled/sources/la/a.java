package la;

import pd.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٥٨٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f١٥٨٤٢b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f١٥٨٤٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٥٨٤٤d;

    /* renamed from: la.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface InterfaceC٠١٨٧a extends q {
        @Override // pd.q
        boolean test(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i10) {
        this.f١٥٨٤١a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f١٥٨٤٢b = objArr;
        this.f١٥٨٤٣c = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        int i10 = this.f١٥٨٤١a;
        int i11 = this.f١٥٨٤٤d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f١٥٨٤٣c[i10] = objArr;
            this.f١٥٨٤٣c = objArr;
            i11 = 0;
        }
        this.f١٥٨٤٣c[i11] = obj;
        this.f١٥٨٤٤d = i11 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(InterfaceC٠١٨٧a r52) {
        int i10 = this.f١٥٨٤١a;
        for (Object[] objArr = this.f١٥٨٤٢b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj != null && !r52.test(obj)) {
                }
            }
        }
    }
}

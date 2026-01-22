package androidx.datastore.preferences.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class v0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f٣٥١٩a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٣٥٢٠b;

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f٣٥٢١c;

    /* renamed from: d, reason: collision with root package name */
    private final int f٣٥٢٢d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(j0 j0Var, String str, Object[] objArr) {
        this.f٣٥١٩a = j0Var;
        this.f٣٥٢٠b = str;
        this.f٣٥٢١c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f٣٥٢٢d = charAt;
            return;
        }
        int i10 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 >= 55296) {
                i10 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            } else {
                this.f٣٥٢٢d = i10 | (charAt2 << i11);
                return;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public boolean a() {
        if ((this.f٣٥٢٢d & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public j0 b() {
        return this.f٣٥١٩a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] c() {
        return this.f٣٥٢١c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f٣٥٢٠b;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public s0 getSyntax() {
        int i10 = this.f٣٥٢٢d;
        if ((i10 & 1) != 0) {
            return s0.PROTO2;
        }
        if ((i10 & 4) == 4) {
            return s0.EDITIONS;
        }
        return s0.PROTO3;
    }
}

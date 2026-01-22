package z1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f١٩٣٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٩٣٨٤b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i10) {
        if (i10 > 0) {
            this.f١٩٣٨٣a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // z1.f
    public void a(Object[] objArr, int i10) {
        if (i10 > objArr.length) {
            i10 = objArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            int i12 = this.f١٩٣٨٤b;
            Object[] objArr2 = this.f١٩٣٨٣a;
            if (i12 < objArr2.length) {
                objArr2[i12] = obj;
                this.f١٩٣٨٤b = i12 + 1;
            }
        }
    }

    @Override // z1.f
    public Object acquire() {
        int i10 = this.f١٩٣٨٤b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f١٩٣٨٣a;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.f١٩٣٨٤b = i10 - 1;
        return obj;
    }

    @Override // z1.f
    public boolean release(Object obj) {
        int i10 = this.f١٩٣٨٤b;
        Object[] objArr = this.f١٩٣٨٣a;
        if (i10 < objArr.length) {
            objArr[i10] = obj;
            this.f١٩٣٨٤b = i10 + 1;
            return true;
        }
        return false;
    }
}

package fe;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    final float f١٤٣١٤a;

    /* renamed from: b, reason: collision with root package name */
    int f١٤٣١٥b;

    /* renamed from: c, reason: collision with root package name */
    int f١٤٣١٦c;

    /* renamed from: d, reason: collision with root package name */
    int f١٤٣١٧d;

    /* renamed from: e, reason: collision with root package name */
    Object[] f١٤٣١٨e;

    public o() {
        this(16, 0.75f);
    }

    static int c(int i10) {
        int i11 = i10 * (-1640531527);
        return i11 ^ (i11 >>> 16);
    }

    public boolean a(Object obj) {
        Object obj2;
        Object[] objArr = this.f١٤٣١٨e;
        int i10 = this.f١٤٣١٥b;
        int c10 = c(obj.hashCode()) & i10;
        Object obj3 = objArr[c10];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                c10 = (c10 + 1) & i10;
                obj2 = objArr[c10];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[c10] = obj;
        int i11 = this.f١٤٣١٦c + 1;
        this.f١٤٣١٦c = i11;
        if (i11 >= this.f١٤٣١٧d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f١٤٣١٨e;
    }

    void d() {
        Object obj;
        Object[] objArr = this.f١٤٣١٨e;
        int length = objArr.length;
        int i10 = length << 1;
        int i11 = i10 - 1;
        Object[] objArr2 = new Object[i10];
        int i12 = this.f١٤٣١٦c;
        while (true) {
            int i13 = i12 - 1;
            if (i12 == 0) {
                this.f١٤٣١٥b = i11;
                this.f١٤٣١٧d = (int) (i10 * this.f١٤٣١٤a);
                this.f١٤٣١٨e = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int c10 = c(obj.hashCode()) & i11;
            if (objArr2[c10] == null) {
                objArr2[c10] = objArr[length];
                i12 = i13;
            }
            do {
                c10 = (c10 + 1) & i11;
            } while (objArr2[c10] != null);
            objArr2[c10] = objArr[length];
            i12 = i13;
        }
    }

    public boolean e(Object obj) {
        Object obj2;
        Object[] objArr = this.f١٤٣١٨e;
        int i10 = this.f١٤٣١٥b;
        int c10 = c(obj.hashCode()) & i10;
        Object obj3 = objArr[c10];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return f(c10, objArr, i10);
        }
        do {
            c10 = (c10 + 1) & i10;
            obj2 = objArr[c10];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return f(c10, objArr, i10);
    }

    boolean f(int i10, Object[] objArr, int i11) {
        int i12;
        Object obj;
        this.f١٤٣١٦c--;
        while (true) {
            int i13 = i10 + 1;
            while (true) {
                i12 = i13 & i11;
                obj = objArr[i12];
                if (obj == null) {
                    objArr[i10] = null;
                    return true;
                }
                int c10 = c(obj.hashCode()) & i11;
                if (i10 <= i12) {
                    if (i10 < c10 && c10 <= i12) {
                        i13 = i12 + 1;
                    }
                } else {
                    if (i10 >= c10 && c10 > i12) {
                        break;
                    }
                    i13 = i12 + 1;
                }
            }
            objArr[i10] = obj;
            i10 = i12;
        }
    }

    public int g() {
        return this.f١٤٣١٦c;
    }

    public o(int i10, float f10) {
        this.f١٤٣١٤a = f10;
        int a10 = p.a(i10);
        this.f١٤٣١٥b = a10 - 1;
        this.f١٤٣١٧d = (int) (f10 * a10);
        this.f١٤٣١٨e = new Object[a10];
    }
}

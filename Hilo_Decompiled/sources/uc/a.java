package uc;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    public static final a[] o;
    public final int a;
    public final boolean b;

    static {
        a aVar = new a(0, false);
        c = aVar;
        a aVar2 = new a(1, true);
        d = aVar2;
        a aVar3 = new a(2, false);
        e = aVar3;
        a aVar4 = new a(3, true);
        f = aVar4;
        a aVar5 = new a(4, false);
        g = aVar5;
        a aVar6 = new a(5, true);
        h = aVar6;
        a aVar7 = new a(6, false);
        i = aVar7;
        a aVar8 = new a(7, true);
        j = aVar8;
        a aVar9 = new a(8, false);
        k = aVar9;
        a aVar10 = new a(9, true);
        l = aVar10;
        a aVar11 = new a(10, false);
        m = aVar11;
        a aVar12 = new a(10, true);
        n = aVar12;
        o = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12};
    }

    private a(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    public boolean a(a aVar) {
        int i2 = this.a;
        int i3 = aVar.a;
        if (i2 >= i3 && ((this.b && l != this) || i2 != i3)) {
            return false;
        }
        return true;
    }

    public a b() {
        if (!this.b) {
            return o[this.a + 1];
        }
        return this;
    }

    public a c() {
        if (this.b) {
            a aVar = o[this.a - 1];
            if (!aVar.b) {
                return aVar;
            }
            return c;
        }
        return this;
    }
}

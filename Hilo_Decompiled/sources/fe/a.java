package fe;

import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final int f١٤٢٩٣a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f١٤٢٩٤b;

    /* renamed from: c, reason: collision with root package name */
    Object[] f١٤٢٩٥c;

    /* renamed from: d, reason: collision with root package name */
    int f١٤٢٩٦d;

    /* renamed from: fe.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface InterfaceC٠١٦٢a extends pd.q {
        @Override // pd.q
        boolean test(Object obj);
    }

    public a(int i10) {
        this.f١٤٢٩٣a = i10;
        Object[] objArr = new Object[i10 + 1];
        this.f١٤٢٩٤b = objArr;
        this.f١٤٢٩٥c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(g0 g0Var) {
        Object[] objArr = this.f١٤٢٩٤b;
        int i10 = this.f١٤٢٩٣a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (m.c(objArr2, g0Var)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(kf.b bVar) {
        Object[] objArr = this.f١٤٢٩٤b;
        int i10 = this.f١٤٢٩٣a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (m.d(objArr2, bVar)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public void c(Object obj) {
        int i10 = this.f١٤٢٩٣a;
        int i11 = this.f١٤٢٩٦d;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.f١٤٢٩٥c[i10] = objArr;
            this.f١٤٢٩٥c = objArr;
            i11 = 0;
        }
        this.f١٤٢٩٥c[i11] = obj;
        this.f١٤٢٩٦d = i11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(InterfaceC٠١٦٢a r52) {
        int i10 = this.f١٤٢٩٣a;
        for (Object[] objArr = this.f١٤٢٩٤b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    break;
                } else {
                    if (r52.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public void e(Object obj) {
        this.f١٤٢٩٤b[0] = obj;
    }
}

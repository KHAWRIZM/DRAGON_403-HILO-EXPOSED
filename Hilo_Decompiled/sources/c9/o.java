package c9;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class o implements v8.g {

    /* renamed from: a, reason: collision with root package name */
    private final j f٦٠٠٨a = new j();

    @Override // v8.g
    public y8.b a(String str, v8.a aVar, int i10, int i11, Map map) {
        if (aVar == v8.a.UPC_A) {
            return this.f٦٠٠٨a.a("0".concat(String.valueOf(str)), v8.a.EAN_13, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}

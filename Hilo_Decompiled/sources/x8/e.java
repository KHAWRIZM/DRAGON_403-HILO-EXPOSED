package x8;

import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f١٨٩٨٩c;

    /* renamed from: d, reason: collision with root package name */
    private final short f١٨٩٩٠d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, int i10, int i11) {
        super(gVar);
        this.f١٨٩٨٩c = (short) i10;
        this.f١٨٩٩٠d = (short) i11;
    }

    @Override // x8.g
    void c(y8.a aVar, byte[] bArr) {
        aVar.c(this.f١٨٩٨٩c, this.f١٨٩٩٠d);
    }

    public String toString() {
        short s10 = this.f١٨٩٨٩c;
        short s11 = this.f١٨٩٩٠d;
        return "<" + Integer.toBinaryString((s10 & ((1 << s11) - 1)) | (1 << s11) | (1 << this.f١٨٩٩٠d)).substring(1) + Typography.greater;
    }
}

package x8;

import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f١٨٩٨٠c;

    /* renamed from: d, reason: collision with root package name */
    private final short f١٨٩٨١d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, int i10, int i11) {
        super(gVar);
        this.f١٨٩٨٠c = (short) i10;
        this.f١٨٩٨١d = (short) i11;
    }

    @Override // x8.g
    public void c(y8.a aVar, byte[] bArr) {
        int i10 = 0;
        while (true) {
            short s10 = this.f١٨٩٨١d;
            if (i10 < s10) {
                if (i10 == 0 || (i10 == 31 && s10 <= 62)) {
                    aVar.c(31, 5);
                    short s11 = this.f١٨٩٨١d;
                    if (s11 > 62) {
                        aVar.c(s11 - 31, 16);
                    } else if (i10 == 0) {
                        aVar.c(Math.min((int) s11, 31), 5);
                    } else {
                        aVar.c(s11 - 31, 5);
                    }
                }
                aVar.c(bArr[this.f١٨٩٨٠c + i10], 8);
                i10++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f١٨٩٨٠c);
        sb.append("::");
        sb.append((this.f١٨٩٨٠c + this.f١٨٩٨١d) - 1);
        sb.append(Typography.greater);
        return sb.toString();
    }
}

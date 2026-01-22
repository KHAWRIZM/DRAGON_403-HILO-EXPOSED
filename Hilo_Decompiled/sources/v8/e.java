package v8;

import c9.j;
import c9.k;
import c9.l;
import c9.o;
import c9.s;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e implements g {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٨٦٠٤a;

        static {
            int[] iArr = new int[v8.a.values().length];
            f١٨٦٠٤a = iArr;
            try {
                iArr[v8.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٨٦٠٤a[v8.a.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٨٦٠٤a[v8.a.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٨٦٠٤a[v8.a.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٨٦٠٤a[v8.a.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١٨٦٠٤a[v8.a.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١٨٦٠٤a[v8.a.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١٨٦٠٤a[v8.a.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١٨٦٠٤a[v8.a.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١٨٦٠٤a[v8.a.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١٨٦٠٤a[v8.a.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f١٨٦٠٤a[v8.a.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f١٨٦٠٤a[v8.a.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // v8.g
    public y8.b a(String str, v8.a aVar, int i10, int i11, Map map) {
        g kVar;
        switch (a.f١٨٦٠٤a[aVar.ordinal()]) {
            case 1:
                kVar = new k();
                break;
            case 2:
                kVar = new s();
                break;
            case 3:
                kVar = new j();
                break;
            case 4:
                kVar = new o();
                break;
            case 5:
                kVar = new f9.a();
                break;
            case 6:
                kVar = new c9.f();
                break;
            case 7:
                kVar = new c9.h();
                break;
            case 8:
                kVar = new c9.d();
                break;
            case 9:
                kVar = new l();
                break;
            case 10:
                kVar = new d9.a();
                break;
            case 11:
                kVar = new c9.b();
                break;
            case 12:
                kVar = new a9.a();
                break;
            case 13:
                kVar = new w8.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
        }
        return kVar.a(str, aVar, i10, i11, map);
    }
}

package b0;

import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import k0.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final short[] f٥٣٠٠f = {96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f٥٣٠١g = {16, 32, 48, 64, 81, 113, 146, 210, 275, 403, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, MessageConstant$CommandId.COMMAND_SEND_INSTANT_ACK, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f٥٣٠٢h = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f٥٣٠٣i;

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f٥٣٠٤j;

    /* renamed from: c, reason: collision with root package name */
    public l f٥٣٠٧c;

    /* renamed from: d, reason: collision with root package name */
    public final InputStream f٥٣٠٨d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f٥٣٠٥a = false;

    /* renamed from: e, reason: collision with root package name */
    public final f f٥٣٠٩e = new f();

    /* renamed from: b, reason: collision with root package name */
    public d f٥٣٠٦b = new h();

    static {
        int[] iArr = new int[288];
        f٥٣٠٣i = iArr;
        Arrays.fill(iArr, 0, 144, 8);
        Arrays.fill(iArr, 144, 256, 9);
        Arrays.fill(iArr, 256, 280, 7);
        Arrays.fill(iArr, 280, 288, 8);
        int[] iArr2 = new int[32];
        f٥٣٠٤j = iArr2;
        Arrays.fill(iArr2, 5);
    }

    public b(InputStream inputStream) {
        this.f٥٣٠٧c = new l(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.f٥٣٠٨d = inputStream;
    }

    public static int a(l lVar, e eVar) {
        while (eVar != null && eVar.f٥٣١٥b == -1) {
            if (b(lVar, 1) == 0) {
                eVar = eVar.f٥٣١٦c;
            } else {
                eVar = eVar.f٥٣١٧d;
            }
        }
        if (eVar == null) {
            return -1;
        }
        return eVar.f٥٣١٥b;
    }

    public static long b(l lVar, int i10) {
        long readBits = lVar.readBits(i10);
        if (readBits != -1) {
            return readBits;
        }
        throw new EOFException("Truncated Deflate64 Stream");
    }

    public static e c(int[] iArr) {
        int[] iArr2 = new int[65];
        int i10 = 0;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
            iArr2[i11] = iArr2[i11] + 1;
        }
        int i12 = i10 + 1;
        int[] copyOf = Arrays.copyOf(iArr2, i12);
        int[] iArr3 = new int[i12];
        int i13 = 0;
        for (int i14 = 0; i14 <= i10; i14++) {
            i13 = (i13 + copyOf[i14]) << 1;
            iArr3[i14] = i13;
        }
        e eVar = new e(0);
        for (int i15 = 0; i15 < iArr.length; i15++) {
            int i16 = iArr[i15];
            if (i16 != 0) {
                int i17 = i16 - 1;
                int i18 = iArr3[i17];
                e eVar2 = eVar;
                for (int i19 = i17; i19 >= 0; i19--) {
                    if (((1 << i19) & i18) == 0) {
                        if (eVar2.f٥٣١٦c == null && eVar2.f٥٣١٥b == -1) {
                            eVar2.f٥٣١٦c = new e(eVar2.f٥٣١٤a + 1);
                        }
                        eVar2 = eVar2.f٥٣١٦c;
                    } else {
                        if (eVar2.f٥٣١٧d == null && eVar2.f٥٣١٥b == -1) {
                            eVar2.f٥٣١٧d = new e(eVar2.f٥٣١٤a + 1);
                        }
                        eVar2 = eVar2.f٥٣١٧d;
                    }
                }
                eVar2.f٥٣١٥b = i15;
                eVar2.f٥٣١٦c = null;
                eVar2.f٥٣١٧d = null;
                iArr3[i17] = iArr3[i17] + 1;
            }
        }
        return eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f٥٣٠٦b = new h();
        this.f٥٣٠٧c = null;
    }
}

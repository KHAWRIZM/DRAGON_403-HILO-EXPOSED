package k0;

import java.io.DataInputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class m {
    public static long a(DataInputStream dataInputStream) {
        long j10 = 0;
        for (int i10 = 0; i10 < 4; i10++) {
            j10 |= dataInputStream.readUnsignedByte() << (i10 * 8);
        }
        return j10;
    }

    public static void b(byte[] bArr, long j10, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i10 + i12] = (byte) (255 & j10);
            j10 >>= 8;
        }
    }
}

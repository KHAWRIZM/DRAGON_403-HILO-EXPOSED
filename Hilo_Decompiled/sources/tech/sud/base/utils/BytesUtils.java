package tech.sud.base.utils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class BytesUtils {
    public static int bytesToInt(byte[] bArr) {
        if (bArr != null && bArr.length == 4) {
            return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        return -1;
    }

    public static short bytesToShort(byte[] bArr) {
        if (bArr != null && bArr.length == 2) {
            return (short) ((bArr[1] & 255) | ((bArr[0] & 255) << 8));
        }
        return (short) -1;
    }
}

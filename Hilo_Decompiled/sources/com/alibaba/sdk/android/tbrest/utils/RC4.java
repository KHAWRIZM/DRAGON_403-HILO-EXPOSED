package com.alibaba.sdk.android.tbrest.utils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RC4 {
    private static final String RC4_PK = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class RC4Key {
        int[] state;

        /* renamed from: x, reason: collision with root package name */
        int f٦٨٥٤x;

        /* renamed from: y, reason: collision with root package name */
        int f٦٨٥٥y;

        private RC4Key() {
            this.state = new int[256];
        }
    }

    private static byte[] doRc4(byte[] bArr, RC4Key rC4Key) {
        if (bArr != null && rC4Key != null) {
            int i10 = rC4Key.f٦٨٥٤x;
            int i11 = rC4Key.f٦٨٥٥y;
            for (int i12 = 0; i12 < bArr.length; i12++) {
                i10 = (i10 + 1) % 256;
                int[] iArr = rC4Key.state;
                int i13 = iArr[i10];
                i11 = (i11 + i13) % 256;
                iArr[i10] = iArr[i11];
                iArr[i11] = i13;
                int i14 = (iArr[i10] + i13) % 256;
                bArr[i12] = (byte) (iArr[i14] ^ bArr[i12]);
            }
            rC4Key.f٦٨٥٤x = i10;
            rC4Key.f٦٨٥٥y = i11;
            return bArr;
        }
        return null;
    }

    private static RC4Key prepareKey(String str) {
        if (str == null) {
            return null;
        }
        RC4Key rC4Key = new RC4Key();
        for (int i10 = 0; i10 < 256; i10++) {
            rC4Key.state[i10] = i10;
        }
        rC4Key.f٦٨٥٤x = 0;
        rC4Key.f٦٨٥٥y = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 256; i13++) {
            try {
                char charAt = str.charAt(i11);
                int[] iArr = rC4Key.state;
                int i14 = iArr[i13];
                i12 = ((charAt + i14) + i12) % 256;
                iArr[i13] = iArr[i12];
                iArr[i12] = i14;
                i11 = (i11 + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return rC4Key;
    }

    public static byte[] rc4(byte[] bArr) {
        return rc4(bArr, RC4_PK);
    }

    private static byte[] rc4(byte[] bArr, String str) {
        RC4Key prepareKey;
        if (bArr == null || str == null || (prepareKey = prepareKey(str)) == null) {
            return null;
        }
        return doRc4(bArr, prepareKey);
    }
}

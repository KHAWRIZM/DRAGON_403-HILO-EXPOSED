package org.apache.commons.codec.digest;

import java.util.Random;
import okhttp3.internal.http2.Settings;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
class B64 {
    static final String B64T = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    B64() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b64from24bit(byte b, byte b2, byte b3, int i, StringBuilder sb2) {
        int i2 = ((b << 16) & 16777215) | ((b2 << 8) & Settings.DEFAULT_INITIAL_WINDOW_SIZE) | (b3 & 255);
        while (true) {
            int i3 = i - 1;
            if (i > 0) {
                sb2.append(B64T.charAt(i2 & 63));
                i2 >>= 6;
                i = i3;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getRandomSalt(int i) {
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 1; i2 <= i; i2++) {
            sb2.append(B64T.charAt(new Random().nextInt(64)));
        }
        return sb2.toString();
    }
}

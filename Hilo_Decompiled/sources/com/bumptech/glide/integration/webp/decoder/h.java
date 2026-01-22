package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import com.liulishuo.okdownload.DownloadTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, int i11, int i12, int i13) {
        int highestOneBit;
        int min = Math.min(i11 / i13, i10 / i12);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("Utils", 2) && max > 1) {
            Log.v("Utils", "Downsampling WEBP, sampleSize: " + max + ", target dimens: [" + i12 + "x" + i13 + "], actual dimens: [" + i10 + "x" + i11 + "]");
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        try {
            byte[] bArr = new byte[DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            if (Log.isLoggable("Utils", 5)) {
                Log.w("Utils", "Error reading data from stream", e10);
                return null;
            }
            return null;
        }
    }
}

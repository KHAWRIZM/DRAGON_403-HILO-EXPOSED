package com.amazonaws.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SdkDigestInputStream extends DigestInputStream implements MetricAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SKIP_BUF_SIZE = 2048;

    public SdkDigestInputStream(InputStream inputStream, MessageDigest messageDigest) {
        super(inputStream, messageDigest);
    }

    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public final boolean isMetricActivated() {
        if (((DigestInputStream) this).in instanceof MetricAware) {
            return ((MetricAware) ((DigestInputStream) this).in).isMetricActivated();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j10) throws IOException {
        if (j10 <= 0) {
            return j10;
        }
        int min = (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, j10);
        byte[] bArr = new byte[min];
        long j11 = j10;
        while (j11 > 0) {
            int read = read(bArr, 0, (int) Math.min(j11, min));
            if (read == -1) {
                if (j11 == j10) {
                    return -1L;
                }
                return j10 - j11;
            }
            j11 -= read;
        }
        return j10;
    }
}

package com.squareup.picasso;

import android.graphics.BitmapFactory;
import android.net.NetworkInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class b {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class a {
    }

    static void calculateInSampleSize(int i, int i2, BitmapFactory.Options options, com.squareup.picasso.a aVar) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options, aVar);
    }

    static BitmapFactory.Options createBitmapOptions(com.squareup.picasso.a aVar) {
        throw null;
    }

    static boolean requiresInSampleSize(BitmapFactory.Options options) {
        if (options != null && options.inJustDecodeBounds) {
            return true;
        }
        return false;
    }

    int getRetryCount() {
        return 0;
    }

    boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean supportsReplay() {
        return false;
    }

    static void calculateInSampleSize(int i, int i2, int i3, int i4, BitmapFactory.Options options, com.squareup.picasso.a aVar) {
        double floor;
        int i5;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                floor = Math.floor(i3 / i);
            } else if (i == 0) {
                floor = Math.floor(i4 / i2);
            } else {
                Math.floor(i4 / i2);
                Math.floor(i3 / i);
                throw null;
            }
            i5 = (int) floor;
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }
}

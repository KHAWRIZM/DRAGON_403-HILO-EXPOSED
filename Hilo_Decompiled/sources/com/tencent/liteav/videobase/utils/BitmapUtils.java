package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BitmapUtils {
    public static Bitmap createBitmap(Bitmap bitmap, Matrix matrix, boolean z) {
        if (bitmap == null) {
            return null;
        }
        bitmap.getConfig();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        try {
            if (z) {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                new Canvas(createBitmap).drawBitmap(bitmap, matrix, paint);
                return createBitmap;
            }
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            LiteavLog.e("BitmapUtils", "build bitmap failed.", th);
            return null;
        }
    }

    public static Bitmap createBitmapFromBuffer(ByteBuffer byteBuffer, int i, int i2) {
        try {
            byteBuffer.position(0);
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(byteBuffer);
            return createBitmap;
        } catch (Throwable th) {
            LiteavLog.e("BitmapUtils", "build bitmap failed.", th);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Bitmap createBitmapFromFile(String str, int i, int i2) {
        int i3;
        try {
            boolean z = true;
            boolean z2 = false;
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 1:
                    z = false;
                    z2 = z;
                    i3 = 0;
                    break;
                case 2:
                    z2 = z;
                    i3 = 0;
                    break;
                case 3:
                    z = false;
                    z2 = z;
                    i3 = 180;
                    break;
                case 4:
                    z2 = z;
                    i3 = 180;
                    break;
                case 5:
                    z2 = z;
                    i3 = 270;
                    break;
                case 6:
                    z = false;
                    z2 = z;
                    i3 = 90;
                    break;
                case 7:
                    z2 = z;
                    i3 = 90;
                    break;
                case 8:
                    z = false;
                    z2 = z;
                    i3 = 270;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            Matrix matrix = new Matrix();
            if (z2) {
                matrix.postScale(-1.0f, 1.0f);
            }
            if (i3 != 0) {
                matrix.postRotate(i3);
            }
            Bitmap loadBitmapFile = loadBitmapFile(str, i, i2, i3);
            return Bitmap.createBitmap(loadBitmapFile, 0, 0, loadBitmapFile.getWidth(), loadBitmapFile.getHeight(), matrix, true);
        } catch (Throwable th) {
            LiteavLog.e("BitmapUtils", "build bitmap failed, path: ".concat(String.valueOf(str)), th);
            return null;
        }
    }

    private static Bitmap loadBitmapFile(String str, int i, int i2, int i3) throws Throwable {
        boolean z;
        int i4;
        int i5;
        if (i > 0 && i2 > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i6 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (i3 != 90 && i3 != 270) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i4 = options.outHeight;
            } else {
                i4 = options.outWidth;
            }
            if (z) {
                i5 = options.outWidth;
            } else {
                i5 = options.outHeight;
            }
            if (i4 > i || i5 > i2) {
                int i7 = i4 / ((i / 2) + 1);
                int i8 = i5 / ((i2 / 2) + 1);
                if (i8 > i7) {
                    i6 = i7;
                } else {
                    i6 = i8;
                }
            }
            options.inSampleSize = i6;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return BitmapFactory.decodeFile(str);
    }

    public static void saveBitmapToFile(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            com.tencent.liteav.base.util.e.a(fileOutputStream);
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            LiteavLog.e("BitmapUtils", "save jpg file failed.", e);
            com.tencent.liteav.base.util.e.a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.tencent.liteav.base.util.e.a(fileOutputStream2);
            throw th;
        }
    }
}

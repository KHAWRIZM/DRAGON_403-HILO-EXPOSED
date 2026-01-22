package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.luck.picture.lib.basic.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BitmapUtils {
    private static final int ARGB_8888_MEMORY_BYTE = 4;
    private static final int MAX_BITMAP_SIZE = 104857600;

    public static int computeSize(int i10, int i11) {
        if (i10 % 2 == 1) {
            i10++;
        }
        if (i11 % 2 == 1) {
            i11++;
        }
        int max = Math.max(i10, i11);
        float min = Math.min(i10, i11) / max;
        if (min <= 1.0f && min > 0.5625d) {
            if (max < 1664) {
                return 1;
            }
            if (max < 4990) {
                return 2;
            }
            if (max > 4990 && max < 10240) {
                return 4;
            }
            return max / 1280;
        }
        double d10 = min;
        if (d10 <= 0.5625d && d10 > 0.5d) {
            int i12 = max / 1280;
            if (i12 == 0) {
                return 1;
            }
            return i12;
        }
        return (int) Math.ceil(max / (1280.0d / d10));
    }

    public static int[] getMaxImageSize(int i10, int i11) {
        int i12 = -1;
        if (i10 == 0 && i11 == 0) {
            return new int[]{-1, -1};
        }
        int computeSize = computeSize(i10, i11);
        long totalMemory = getTotalMemory();
        int i13 = computeSize;
        int i14 = -1;
        boolean z10 = false;
        while (!z10) {
            i12 = i10 / i13;
            i14 = i11 / i13;
            if (i12 * i14 * 4 > totalMemory) {
                i13 *= 2;
            } else {
                z10 = true;
            }
        }
        return new int[]{i12, i14};
    }

    public static long getTotalMemory() {
        long j10 = Runtime.getRuntime().totalMemory();
        if (j10 > 104857600) {
            return 104857600L;
        }
        return j10;
    }

    public static int readPictureDegree(Context context, String str) {
        androidx.exifinterface.media.a aVar;
        InputStream inputStream = null;
        try {
            try {
                if (PictureMimeType.isContent(str)) {
                    inputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    aVar = new androidx.exifinterface.media.a(inputStream);
                } else {
                    aVar = new androidx.exifinterface.media.a(str);
                }
                int e10 = aVar.e("Orientation", 1);
                if (e10 != 3) {
                    if (e10 != 6) {
                        if (e10 != 8) {
                            PictureFileUtils.close(inputStream);
                            return 0;
                        }
                        PictureFileUtils.close(inputStream);
                        return SubsamplingScaleImageView.ORIENTATION_270;
                    }
                    PictureFileUtils.close(inputStream);
                    return 90;
                }
                PictureFileUtils.close(inputStream);
                return 180;
            } catch (Exception e11) {
                e11.printStackTrace();
                PictureFileUtils.close(inputStream);
                return 0;
            }
        } catch (Throwable th) {
            PictureFileUtils.close(inputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void rotateImage(Context context, String str) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4;
        FileOutputStream fileOutputStream5;
        Bitmap decodeFile;
        FileOutputStream fileOutputStream6;
        FileOutputStream fileOutputStream7;
        FileOutputStream fileOutputStream8 = null;
        try {
            int readPictureDegree = readPictureDegree(context, str);
            if (readPictureDegree > 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (PictureMimeType.isContent(str)) {
                    InputStream openInputStream = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    try {
                        BitmapFactory.decodeStream(openInputStream, null, options);
                        fileOutputStream3 = openInputStream;
                    } catch (Exception e10) {
                        e = e10;
                        fileOutputStream = null;
                        bitmap = null;
                        fileOutputStream5 = openInputStream;
                        fileOutputStream8 = fileOutputStream5;
                        try {
                            e.printStackTrace();
                            PictureFileUtils.close(fileOutputStream8);
                            PictureFileUtils.close(fileOutputStream);
                            if (bitmap != null || bitmap.isRecycled()) {
                                return;
                            }
                            bitmap.recycle();
                        } catch (Throwable th) {
                            th = th;
                            PictureFileUtils.close(fileOutputStream8);
                            PictureFileUtils.close(fileOutputStream);
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        bitmap = null;
                        fileOutputStream4 = openInputStream;
                        fileOutputStream8 = fileOutputStream4;
                        PictureFileUtils.close(fileOutputStream8);
                        PictureFileUtils.close(fileOutputStream);
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        throw th;
                    }
                } else {
                    BitmapFactory.decodeFile(str, options);
                    fileOutputStream3 = null;
                }
                options.inSampleSize = computeSize(options.outWidth, options.outHeight);
                options.inJustDecodeBounds = false;
                if (PictureMimeType.isContent(str)) {
                    InputStream openInputStream2 = PictureContentResolver.openInputStream(context, Uri.parse(str));
                    decodeFile = BitmapFactory.decodeStream(openInputStream2, null, options);
                    fileOutputStream6 = openInputStream2;
                } else {
                    decodeFile = BitmapFactory.decodeFile(str, options);
                    fileOutputStream6 = fileOutputStream3;
                }
                if (decodeFile != null) {
                    try {
                        bitmap = rotatingImage(decodeFile, readPictureDegree);
                    } catch (Exception e11) {
                        e = e11;
                        fileOutputStream = null;
                        bitmap = decodeFile;
                        fileOutputStream5 = fileOutputStream6;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        bitmap = decodeFile;
                        fileOutputStream4 = fileOutputStream6;
                    }
                    try {
                        if (PictureMimeType.isContent(str)) {
                            fileOutputStream7 = (FileOutputStream) PictureContentResolver.openOutputStream(context, Uri.parse(str));
                        } else {
                            fileOutputStream7 = new FileOutputStream(str);
                        }
                        fileOutputStream8 = fileOutputStream7;
                        saveBitmapFile(bitmap, fileOutputStream8);
                        fileOutputStream2 = fileOutputStream8;
                    } catch (Exception e12) {
                        e = e12;
                        fileOutputStream = fileOutputStream8;
                        fileOutputStream5 = fileOutputStream6;
                        fileOutputStream8 = fileOutputStream5;
                        e.printStackTrace();
                        PictureFileUtils.close(fileOutputStream8);
                        PictureFileUtils.close(fileOutputStream);
                        if (bitmap != null) {
                            return;
                        } else {
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = fileOutputStream8;
                        fileOutputStream4 = fileOutputStream6;
                        fileOutputStream8 = fileOutputStream4;
                        PictureFileUtils.close(fileOutputStream8);
                        PictureFileUtils.close(fileOutputStream);
                        if (bitmap != null) {
                        }
                        throw th;
                    }
                } else {
                    fileOutputStream2 = null;
                    bitmap = decodeFile;
                }
                fileOutputStream8 = fileOutputStream6;
            } else {
                fileOutputStream2 = null;
                bitmap = null;
            }
            PictureFileUtils.close(fileOutputStream8);
            PictureFileUtils.close(fileOutputStream2);
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
        } catch (Exception e13) {
            e = e13;
            fileOutputStream = null;
            bitmap = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            bitmap = null;
        }
        bitmap.recycle();
    }

    public static Bitmap rotatingImage(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void saveBitmapFile(Bitmap bitmap, FileOutputStream fileOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
            PictureFileUtils.close(fileOutputStream);
            PictureFileUtils.close(byteArrayOutputStream);
        } catch (Exception e11) {
            e = e11;
            byteArrayOutputStream2 = byteArrayOutputStream;
            e.printStackTrace();
            PictureFileUtils.close(fileOutputStream);
            PictureFileUtils.close(byteArrayOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            PictureFileUtils.close(fileOutputStream);
            PictureFileUtils.close(byteArrayOutputStream2);
            throw th;
        }
    }
}

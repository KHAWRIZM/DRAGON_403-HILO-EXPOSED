package com.tencent.qcloud.tuicore.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUILogin;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ImageUtil {
    public static final String SP_IMAGE = "_conversation_group_face";

    public static Bitmap adaptBitmapFormPath(String str, int i, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = calculateInSampleSize(options, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i = 100;
        while (byteArrayOutputStream.toByteArray().length / LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static String generateImagePath(String str, int i) {
        return TUIConfig.getImageDownloadDir() + str + "_" + i;
    }

    public static int getBitmapDegree(Uri uri) {
        try {
            int attributeInt = new ExifInterface(FileUtil.getPathFromUri(uri)).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap getBitmapFormPath(Uri uri) {
        int i;
        Bitmap bitmap = null;
        try {
            InputStream openInputStream = TUIConfig.getAppContext().getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inDither = true;
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            options.inPreferredConfig = config;
            BitmapFactory.decodeStream(openInputStream, null, options);
            openInputStream.close();
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (i2 != -1 && i3 != -1) {
                int bitmapDegree = getBitmapDegree(uri);
                float f = 480.0f;
                float f2 = 800.0f;
                if (bitmapDegree == 90 || bitmapDegree == 270) {
                    f = 800.0f;
                    f2 = 480.0f;
                }
                if (i2 > i3) {
                    float f3 = i2;
                    if (f3 > f) {
                        i = (int) (f3 / f);
                        if (i <= 0) {
                            i = 1;
                        }
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i;
                        options2.inDither = true;
                        options2.inPreferredConfig = config;
                        InputStream openInputStream2 = TUIConfig.getAppContext().getContentResolver().openInputStream(uri);
                        bitmap = BitmapFactory.decodeStream(openInputStream2, null, options2);
                        openInputStream2.close();
                        compressImage(bitmap);
                        return rotateBitmapByDegree(bitmap, bitmapDegree);
                    }
                }
                if (i2 < i3) {
                    float f4 = i3;
                    if (f4 > f2) {
                        i = (int) (f4 / f2);
                        if (i <= 0) {
                        }
                        BitmapFactory.Options options22 = new BitmapFactory.Options();
                        options22.inSampleSize = i;
                        options22.inDither = true;
                        options22.inPreferredConfig = config;
                        InputStream openInputStream22 = TUIConfig.getAppContext().getContentResolver().openInputStream(uri);
                        bitmap = BitmapFactory.decodeStream(openInputStream22, null, options22);
                        openInputStream22.close();
                        compressImage(bitmap);
                        return rotateBitmapByDegree(bitmap, bitmapDegree);
                    }
                }
                i = 1;
                if (i <= 0) {
                }
                BitmapFactory.Options options222 = new BitmapFactory.Options();
                options222.inSampleSize = i;
                options222.inDither = true;
                options222.inPreferredConfig = config;
                InputStream openInputStream222 = TUIConfig.getAppContext().getContentResolver().openInputStream(uri);
                bitmap = BitmapFactory.decodeStream(openInputStream222, null, options222);
                openInputStream222.close();
                compressImage(bitmap);
                return rotateBitmapByDegree(bitmap, bitmapDegree);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    public static String getGroupConversationAvatar(String str) {
        String string = SPUtils.getInstance(TUILogin.getSdkAppId() + SP_IMAGE).getString(str, "");
        if (TextUtils.isEmpty(string) || !new File(string).isFile() || !new File(string).exists()) {
            return "";
        }
        return string;
    }

    public static String getImagePathAfterRotate(Uri uri) {
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(TUIConfig.getAppContext().getContentResolver().openInputStream(uri), null, null);
            int bitmapDegree = getBitmapDegree(uri);
            if (bitmapDegree == 0) {
                return FileUtil.getPathFromUri(uri);
            }
            Bitmap rotateBitmapByDegree = rotateBitmapByDegree(decodeStream, bitmapDegree);
            File generateFileName = FileUtil.generateFileName(FileUtil.getFileName(TUIConfig.getAppContext(), uri), FileUtil.getDocumentCacheDir(TUIConfig.getAppContext()));
            if (generateFileName == null) {
                return FileUtil.getPathFromUri(uri);
            }
            storeBitmap(generateFileName, rotateBitmapByDegree);
            rotateBitmapByDegree.recycle();
            return generateFileName.getAbsolutePath();
        } catch (FileNotFoundException unused) {
            return FileUtil.getPathFromUri(uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] getImageSize(String str) {
        int i;
        int[] iArr = new int[2];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int bitmapDegree = getBitmapDegree(str);
            if (bitmapDegree == 0) {
                iArr[0] = i2;
                iArr[1] = i3;
            } else {
                float f = 480.0f;
                float f2 = 800.0f;
                if (bitmapDegree == 90 || bitmapDegree == 270) {
                    f = 800.0f;
                    f2 = 480.0f;
                }
                if (i2 > i3) {
                    float f3 = i2;
                    if (f3 > f) {
                        i = (int) (f3 / f);
                        if (i <= 0) {
                            i = 1;
                        }
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inSampleSize = i;
                        options2.inDither = true;
                        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        Bitmap rotateBitmapByDegree = rotateBitmapByDegree(BitmapFactory.decodeFile(str, options2), bitmapDegree);
                        iArr[0] = rotateBitmapByDegree.getWidth();
                        iArr[1] = rotateBitmapByDegree.getHeight();
                    }
                }
                if (i2 < i3) {
                    float f4 = i3;
                    if (f4 > f2) {
                        i = (int) (f4 / f2);
                        if (i <= 0) {
                        }
                        BitmapFactory.Options options22 = new BitmapFactory.Options();
                        options22.inSampleSize = i;
                        options22.inDither = true;
                        options22.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        Bitmap rotateBitmapByDegree2 = rotateBitmapByDegree(BitmapFactory.decodeFile(str, options22), bitmapDegree);
                        iArr[0] = rotateBitmapByDegree2.getWidth();
                        iArr[1] = rotateBitmapByDegree2.getHeight();
                    }
                }
                i = 1;
                if (i <= 0) {
                }
                BitmapFactory.Options options222 = new BitmapFactory.Options();
                options222.inSampleSize = i;
                options222.inDither = true;
                options222.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap rotateBitmapByDegree22 = rotateBitmapByDegree(BitmapFactory.decodeFile(str, options222), bitmapDegree);
                iArr[0] = rotateBitmapByDegree22.getWidth();
                iArr[1] = rotateBitmapByDegree22.getHeight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    public static boolean isImageDownloaded(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            bitmap2 = bitmap;
        }
        if (bitmap != bitmap2) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static void setGroupConversationAvatar(String str, String str2) {
        SPUtils.getInstance(TUILogin.getSdkAppId() + SP_IMAGE).put(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x002e -> B:13:0x0044). Please report as a decompilation issue!!! */
    public static File storeBitmap(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        if (!file.exists() || file.isDirectory()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        fileOutputStream2 = null;
        try {
            try {
                try {
                    file.deleteOnExit();
                    file.createNewFile();
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
        } catch (IOException e) {
            e.printStackTrace();
            file.deleteOnExit();
            fileOutputStream2 = fileOutputStream2;
        }
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            fileOutputStream2 = compressFormat;
        } catch (IOException unused2) {
            fileOutputStream3 = fileOutputStream;
            file.deleteOnExit();
            fileOutputStream2 = fileOutputStream3;
            if (fileOutputStream3 != null) {
                fileOutputStream3.close();
                fileOutputStream2 = fileOutputStream3;
            }
            return file;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    file.deleteOnExit();
                }
            }
            throw th;
        }
        return file;
    }

    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f4 = width / 2;
            f3 = width;
            f2 = f3;
            f = 0.0f;
        } else {
            f = (width - height) / 2;
            f2 = height;
            f3 = width - f;
            width = height;
            f4 = height / 2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f, (int) 0.0f, (int) f3, (int) f2);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f2, (int) f2);
        new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle(f4, f4, f4, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static int getBitmapDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getBitmapFormPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getBitmapFormPath(Uri.fromFile(new File(str)));
    }
}

package com.oudi.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.ui.dialog.ImageTypeDialog;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageUtils {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF(ImageTypeDialog.CLICK_GIFT),
        TYPE_TIFF("tiff"),
        TYPE_BMP("bmp"),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN("unknown");

        String value;

        ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    private ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Bitmap addBorder(Bitmap bitmap, int i10, int i11, boolean z10, float f10, boolean z11) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z11) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i11);
        paint.setStyle(Paint.Style.STROKE);
        float f11 = i10;
        paint.setStrokeWidth(f11);
        if (z10) {
            canvas.drawCircle(width / 2.0f, height / 2.0f, (Math.min(width, height) / 2.0f) - (f11 / 2.0f), paint);
        } else {
            float f12 = i10 >> 1;
            canvas.drawRoundRect(new RectF(f12, f12, width - r5, height - r5), f10, f10, paint);
        }
        return bitmap;
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, int i10, int i11) {
        return addBorder(bitmap, i10, i11, true, DownloadProgress.UNKNOWN_PROGRESS, false);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, int i10, int i11, float f10) {
        return addBorder(bitmap, i10, i11, false, f10, false);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, int i12) {
        return addImageWatermark(bitmap, bitmap2, i10, i11, i12, false);
    }

    public static Bitmap addReflection(Bitmap bitmap, int i10) {
        return addReflection(bitmap, i10, false);
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, int i10, int i11, float f10, float f11) {
        return addTextWatermark(bitmap, str, i10, i11, f10, f11, false);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(AppUtils.getApp().getResources(), bitmap);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static Drawable bytes2Drawable(byte[] bArr) {
        return bitmap2Drawable(bytes2Bitmap(bArr));
    }

    private static String bytes2HexString(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return "";
        }
        char[] cArr = new char[length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = hexDigits;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        while (true) {
            if (i12 <= i11 && i13 <= i10) {
                return i14;
            }
            i12 >>= 1;
            i13 >>= 1;
            i14 <<= 1;
        }
    }

    public static Bitmap clip(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        return clip(bitmap, i10, i11, i12, i13, false);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i10) {
        return compressByQuality(bitmap, i10, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i10) {
        return compressBySampleSize(bitmap, i10, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i10, int i11) {
        return scale(bitmap, i10, i11, false);
    }

    private static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private static boolean createOrExistsDir(File file) {
        if (file != null && (!file.exists() ? file.mkdirs() : file.isDirectory())) {
            return true;
        }
        return false;
    }

    public static Bitmap drawColor(Bitmap bitmap, int i10) {
        return drawColor(bitmap, i10, false);
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap.Config config;
        Bitmap createBitmap;
        Bitmap.Config config2;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (drawable.getOpacity() != -1) {
                config2 = Bitmap.Config.ARGB_8888;
            } else {
                config2 = Bitmap.Config.RGB_565;
            }
            createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config2);
        } else {
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            createBitmap = Bitmap.createBitmap(1, 1, config);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable), compressFormat);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f10, float f11) {
        return fastBlur(bitmap, f10, f11, false, false);
    }

    public static Bitmap getBitmap(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    private static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static ImageType getImageType(String str) {
        return getImageType(getFileByPath(str));
    }

    public static int getRotateDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return SubsamplingScaleImageView.ORIENTATION_270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static int[] getSize(String str) {
        return getSize(getFileByPath(str));
    }

    private static byte[] input2Byte(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
                return byteArray;
            } catch (IOException e11) {
                e11.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            throw th;
        }
    }

    private static boolean isBMP(byte[] bArr) {
        if (bArr.length < 2 || bArr[0] != 66 || bArr[1] != 77) {
            return false;
        }
        return true;
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0) {
            return false;
        }
        return true;
    }

    private static boolean isGIF(byte[] bArr) {
        if (bArr.length < 6 || bArr[0] != 71 || bArr[1] != 73 || bArr[2] != 70 || bArr[3] != 56) {
            return false;
        }
        byte b10 = bArr[4];
        if ((b10 != 55 && b10 != 57) || bArr[5] != 97) {
            return false;
        }
        return true;
    }

    public static boolean isImage(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return isImage(file.getPath());
    }

    private static boolean isJPEG(byte[] bArr) {
        if (bArr.length < 2 || bArr[0] != -1 || bArr[1] != -40) {
            return false;
        }
        return true;
    }

    private static boolean isPNG(byte[] bArr) {
        if (bArr.length < 8 || bArr[0] != -119 || bArr[1] != 80 || bArr[2] != 78 || bArr[3] != 71 || bArr[4] != 13 || bArr[5] != 10 || bArr[6] != 26 || bArr[7] != 10) {
            return false;
        }
        return true;
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f10) {
        return renderScriptBlur(bitmap, f10, false);
    }

    public static Bitmap rotate(Bitmap bitmap, int i10, float f10, float f11) {
        return rotate(bitmap, i10, f10, f11, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, getFileByPath(str), compressFormat, false);
    }

    public static Bitmap scale(Bitmap bitmap, int i10, int i11) {
        return scale(bitmap, i10, i11, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f10, float f11) {
        return skew(bitmap, f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, false);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i10) {
        return stackBlur(bitmap, i10, false);
    }

    public static Bitmap toAlpha(Bitmap bitmap) {
        return toAlpha(bitmap, Boolean.FALSE);
    }

    public static Bitmap toGray(Bitmap bitmap) {
        return toGray(bitmap, false);
    }

    public static Bitmap toRound(Bitmap bitmap) {
        return toRound(bitmap, 0, 0, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f10) {
        return toRoundCorner(bitmap, f10, 0, 0, false);
    }

    public static Bitmap view2Bitmap(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, int i10, int i11, boolean z10) {
        return addBorder(bitmap, i10, i11, true, DownloadProgress.UNKNOWN_PROGRESS, z10);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, int i10, int i11, float f10, boolean z10) {
        return addBorder(bitmap, i10, i11, false, f10, z10);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, int i12, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (!isEmptyBitmap(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(copy);
            paint.setAlpha(i12);
            canvas.drawBitmap(bitmap2, i10, i11, paint);
        }
        if (z10 && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addReflection(Bitmap bitmap, int i10, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height - i10, width, i10, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height + i10, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, (Paint) null);
        float f10 = height;
        canvas.drawBitmap(createBitmap, DownloadProgress.UNKNOWN_PROGRESS, f10, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(DownloadProgress.UNKNOWN_PROGRESS, f10, DownloadProgress.UNKNOWN_PROGRESS, createBitmap2.getHeight(), 1895825407, 16777215, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(DownloadProgress.UNKNOWN_PROGRESS, f10, width, createBitmap2.getHeight(), paint);
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        if (z10 && !bitmap.isRecycled() && createBitmap2 != bitmap) {
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, float f10, int i10, float f11, float f12, boolean z10) {
        if (isEmptyBitmap(bitmap) || str == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(copy);
        paint.setColor(i10);
        paint.setTextSize(f10);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f11, f12 + f10, paint);
        if (z10 && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap clip(Bitmap bitmap, int i10, int i11, int i12, int i13, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i10, i11, i12, i13);
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i10, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i10, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i10, int i11, boolean z10) {
        return scale(bitmap, i10, i11, z10);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i10, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z10) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i10, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f10, float f11, boolean z10) {
        return fastBlur(bitmap, f10, f11, z10, false);
    }

    public static Bitmap getBitmap(File file, int i10, int i11) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImageType getImageType(File file) {
        FileInputStream fileInputStream;
        ImageType imageType;
        FileInputStream fileInputStream2 = null;
        try {
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            throw th;
        }
        try {
            imageType = getImageType(fileInputStream);
        } catch (IOException e12) {
            e = e12;
            try {
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
            }
            throw th;
        }
        if (imageType != null) {
            try {
                fileInputStream.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            return imageType;
        }
        fileInputStream.close();
        return null;
    }

    public static int[] getSize(File file) {
        if (file == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f10, boolean z10) {
        if (!z10) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(AppUtils.getApp());
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f10);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            renderScript.destroy();
            return bitmap;
        } catch (Throwable th) {
            if (renderScript != null) {
                renderScript.destroy();
            }
            throw th;
        }
    }

    public static Bitmap rotate(Bitmap bitmap, int i10, float f10, float f11, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (i10 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i10, f10, f11);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, file, compressFormat, false);
    }

    public static Bitmap scale(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
        if (z10 && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f10, float f11, boolean z10) {
        return skew(bitmap, f10, f11, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, z10);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i10, boolean z10) {
        int[] iArr;
        Bitmap copy = z10 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i11 = i10 < 1 ? 1 : i10;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i12 = width * height;
        int[] iArr2 = new int[i12];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = i11 + i11;
        int i16 = i15 + 1;
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int[] iArr5 = new int[i12];
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i15 + 2) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i20 = 0; i20 < i19; i20++) {
            iArr7[i20] = i20 / i18;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i16, 3);
        int i21 = i11 + 1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < height) {
            Bitmap bitmap2 = copy;
            int i25 = height;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = -i11;
            int i35 = 0;
            while (i34 <= i11) {
                int i36 = i14;
                int[] iArr9 = iArr6;
                int i37 = iArr2[Math.min(i13, Math.max(i34, 0)) + i23];
                int[] iArr10 = iArr8[i34 + i11];
                iArr10[0] = (i37 & 16711680) >> 16;
                iArr10[1] = (i37 & 65280) >> 8;
                iArr10[2] = i37 & KotlinVersion.MAX_COMPONENT_VALUE;
                int abs = i21 - Math.abs(i34);
                int i38 = iArr10[0];
                i35 += i38 * abs;
                int i39 = iArr10[1];
                i26 = (i39 * abs) + i26;
                int i40 = iArr10[2];
                i27 = (abs * i40) + i27;
                if (i34 > 0) {
                    i33 += i38;
                    i32 += i39;
                    i31 += i40;
                } else {
                    i30 += i38;
                    i29 += i39;
                    i28 += i40;
                }
                i34++;
                i14 = i36;
                iArr6 = iArr9;
            }
            int i41 = i14;
            int[] iArr11 = iArr6;
            int i42 = i35;
            int i43 = i11;
            int i44 = 0;
            while (i44 < width) {
                iArr3[i23] = iArr7[i42];
                iArr4[i23] = iArr7[i26];
                iArr5[i23] = iArr7[i27];
                int i45 = i42 - i30;
                int i46 = i26 - i29;
                int i47 = i27 - i28;
                int[] iArr12 = iArr8[((i43 - i11) + i16) % i16];
                int i48 = i30 - iArr12[0];
                int i49 = i29 - iArr12[1];
                int i50 = i28 - iArr12[2];
                if (i22 == 0) {
                    iArr = iArr7;
                    iArr11[i44] = Math.min(i44 + i11 + 1, i13);
                } else {
                    iArr = iArr7;
                }
                int i51 = iArr2[i24 + iArr11[i44]];
                int i52 = (i51 & 16711680) >> 16;
                iArr12[0] = i52;
                int i53 = (i51 & 65280) >> 8;
                iArr12[1] = i53;
                int i54 = i51 & KotlinVersion.MAX_COMPONENT_VALUE;
                iArr12[2] = i54;
                int i55 = i33 + i52;
                int i56 = i32 + i53;
                int i57 = i31 + i54;
                i42 = i45 + i55;
                i26 = i46 + i56;
                i27 = i47 + i57;
                i43 = (i43 + 1) % i16;
                int[] iArr13 = iArr8[i43 % i16];
                int i58 = iArr13[0];
                i30 = i48 + i58;
                int i59 = iArr13[1];
                i29 = i49 + i59;
                int i60 = iArr13[2];
                i28 = i50 + i60;
                i33 = i55 - i58;
                i32 = i56 - i59;
                i31 = i57 - i60;
                i23++;
                i44++;
                iArr7 = iArr;
            }
            i24 += width;
            i22++;
            copy = bitmap2;
            height = i25;
            i14 = i41;
            iArr6 = iArr11;
        }
        int[] iArr14 = iArr7;
        Bitmap bitmap3 = copy;
        int i61 = i14;
        int[] iArr15 = iArr6;
        int i62 = height;
        int i63 = 0;
        while (i63 < width) {
            int i64 = -i11;
            int i65 = i16;
            int[] iArr16 = iArr2;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = i64;
            int i74 = i64 * width;
            int i75 = 0;
            int i76 = 0;
            while (i73 <= i11) {
                int i77 = width;
                int max = Math.max(0, i74) + i63;
                int[] iArr17 = iArr8[i73 + i11];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i21 - Math.abs(i73);
                i75 = (iArr3[max] * abs2) + i75;
                i76 = (iArr4[max] * abs2) + i76;
                i66 = (iArr5[max] * abs2) + i66;
                if (i73 > 0) {
                    i72 += iArr17[0];
                    i71 += iArr17[1];
                    i70 += iArr17[2];
                } else {
                    i69 += iArr17[0];
                    i68 += iArr17[1];
                    i67 += iArr17[2];
                }
                int i78 = i61;
                if (i73 < i78) {
                    i74 += i77;
                }
                i73++;
                i61 = i78;
                width = i77;
            }
            int i79 = width;
            int i80 = i61;
            int i81 = i63;
            int i82 = i11;
            int i83 = i62;
            int i84 = 0;
            while (i84 < i83) {
                iArr16[i81] = (iArr16[i81] & (-16777216)) | (iArr14[i75] << 16) | (iArr14[i76] << 8) | iArr14[i66];
                int i85 = i75 - i69;
                int i86 = i76 - i68;
                int i87 = i66 - i67;
                int[] iArr18 = iArr8[((i82 - i11) + i65) % i65];
                int i88 = i69 - iArr18[0];
                int i89 = i68 - iArr18[1];
                int i90 = i67 - iArr18[2];
                int i91 = i11;
                if (i63 == 0) {
                    iArr15[i84] = Math.min(i84 + i21, i80) * i79;
                }
                int i92 = iArr15[i84] + i63;
                int i93 = iArr3[i92];
                iArr18[0] = i93;
                int i94 = iArr4[i92];
                iArr18[1] = i94;
                int i95 = iArr5[i92];
                iArr18[2] = i95;
                int i96 = i72 + i93;
                int i97 = i71 + i94;
                int i98 = i70 + i95;
                i75 = i85 + i96;
                i76 = i86 + i97;
                i66 = i87 + i98;
                i82 = (i82 + 1) % i65;
                int[] iArr19 = iArr8[i82];
                int i99 = iArr19[0];
                i69 = i88 + i99;
                int i100 = iArr19[1];
                i68 = i89 + i100;
                int i101 = iArr19[2];
                i67 = i90 + i101;
                i72 = i96 - i99;
                i71 = i97 - i100;
                i70 = i98 - i101;
                i81 += i79;
                i84++;
                i11 = i91;
            }
            i63++;
            i61 = i80;
            i62 = i83;
            i16 = i65;
            iArr2 = iArr16;
            width = i79;
        }
        int i102 = width;
        bitmap3.setPixels(iArr2, 0, i102, 0, 0, i102, i62);
        return bitmap3;
    }

    public static Bitmap toAlpha(Bitmap bitmap, Boolean bool) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap extractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled() && extractAlpha != bitmap) {
            bitmap.recycle();
        }
        return extractAlpha;
    }

    public static Bitmap toGray(Bitmap bitmap, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(DownloadProgress.UNKNOWN_PROGRESS);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, paint);
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap, boolean z10) {
        return toRound(bitmap, 0, 0, z10);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f10, boolean z10) {
        return toRoundCorner(bitmap, f10, 0, 0, z10);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f10, float f11) {
        return scale(bitmap, f10, f11, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f10, float f11, boolean z10, boolean z11) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f10);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f10, f10);
        canvas.drawBitmap(createBitmap, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, paint);
        Bitmap renderScriptBlur = renderScriptBlur(createBitmap, f11, z10);
        if (f10 != 1.0f && !z11) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(renderScriptBlur, width, height, true);
            if (!renderScriptBlur.isRecycled()) {
                renderScriptBlur.recycle();
            }
            if (z10 && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
                bitmap.recycle();
            }
            return createScaledBitmap;
        }
        if (z10 && !bitmap.isRecycled() && renderScriptBlur != bitmap) {
            bitmap.recycle();
        }
        return renderScriptBlur;
    }

    public static boolean isImage(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth != -1) {
                if (options.outHeight != -1) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z10) {
        return save(bitmap, getFileByPath(str), compressFormat, z10);
    }

    public static Bitmap skew(Bitmap bitmap, float f10, float f11, float f12, float f13) {
        return skew(bitmap, f10, f11, f12, f13, false);
    }

    public static Bitmap toRound(Bitmap bitmap, int i10, int i11) {
        return toRound(bitmap, i10, i11, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f10, int i10, int i11) {
        return toRoundCorner(bitmap, f10, i10, i11, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f10, float f11, boolean z10) {
        return scale(bitmap, f10, f11, z10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0043 -> B:18:0x0046). Please report as a decompilation issue!!! */
    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z10) {
        BufferedOutputStream bufferedOutputStream;
        boolean z11 = false;
        if (isEmptyBitmap(bitmap) || !createFileByDeleteOldFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        try {
            z11 = bitmap.compress(compressFormat, 100, bufferedOutputStream);
            if (z10 && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            bufferedOutputStream.close();
        } catch (IOException e12) {
            e = e12;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            return z11;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
        return z11;
    }

    public static Bitmap skew(Bitmap bitmap, float f10, float f11, float f12, float f13, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f10, f11, f12, f13);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f10 = min;
        float f11 = f10 / 2.0f;
        float f12 = width;
        float f13 = height;
        RectF rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f12, f13);
        rectF.inset((width - min) / 2.0f, (height - min) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        if (width != height) {
            matrix.preScale(f10 / f12, f10 / f13);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (i10 > 0) {
            paint.setShader(null);
            paint.setColor(i11);
            paint.setStyle(Paint.Style.STROKE);
            float f14 = i10;
            paint.setStrokeWidth(f14);
            canvas.drawCircle(f12 / 2.0f, f13 / 2.0f, f11 - (f14 / 2.0f), paint);
        }
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f10, int i10, int i11, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
        float f11 = i10;
        float f12 = f11 / 2.0f;
        rectF.inset(f12, f12);
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (i10 > 0) {
            paint.setShader(null);
            paint.setColor(i11);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f11);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, float f10, float f11) {
        return scale(bitmap, f10, f11, false);
    }

    public static Bitmap scale(Bitmap bitmap, float f10, float f11, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j10) {
        return compressByQuality(bitmap, j10, false);
    }

    public static Bitmap getBitmap(String str) {
        if (isSpace(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j10, boolean z10) {
        byte[] byteArray;
        if (isEmptyBitmap(bitmap) || j10 <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        int i10 = 100;
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j10) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(compressFormat, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j10) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i11 = 0;
                int i12 = 0;
                while (i11 < i10) {
                    i12 = (i11 + i10) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i12, byteArrayOutputStream);
                    long size = byteArrayOutputStream.size();
                    if (size == j10) {
                        break;
                    }
                    if (size > j10) {
                        i10 = i12 - 1;
                    } else {
                        i11 = i12 + 1;
                    }
                }
                if (i10 == i12 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i11, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i10, int i11) {
        return compressBySampleSize(bitmap, i10, i11, false);
    }

    public static Bitmap getBitmap(String str, int i10, int i11) {
        if (isSpace(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    private static ImageType getImageType(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[12];
            if (inputStream.read(bArr) != -1) {
                return getImageType(bArr);
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static ImageType getImageType(byte[] bArr) {
        String upperCase = bytes2HexString(bArr).toUpperCase();
        if (upperCase.contains("FFD8FF")) {
            return ImageType.TYPE_JPG;
        }
        if (upperCase.contains("89504E47")) {
            return ImageType.TYPE_PNG;
        }
        if (upperCase.contains("47494638")) {
            return ImageType.TYPE_GIF;
        }
        if (!upperCase.contains("49492A00") && !upperCase.contains("4D4D002A")) {
            if (upperCase.contains("424D")) {
                return ImageType.TYPE_BMP;
            }
            if (upperCase.startsWith("52494646") && upperCase.endsWith("57454250")) {
                return ImageType.TYPE_WEBP;
            }
            if (!upperCase.contains("00000100") && !upperCase.contains("00000200")) {
                return ImageType.TYPE_UNKNOWN;
            }
            return ImageType.TYPE_ICO;
        }
        return ImageType.TYPE_TIFF;
    }

    public static Bitmap getBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i10, int i11) {
        if (inputStream == null) {
            return null;
        }
        return getBitmap(input2Byte(inputStream), 0, i10, i11);
    }

    public static Bitmap getBitmap(byte[] bArr, int i10) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i10, bArr.length);
    }

    public static Bitmap getBitmap(byte[] bArr, int i10, int i11, int i12) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i10, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i10, bArr.length, options);
    }

    public static Bitmap toRound(Bitmap bitmap, float f10, boolean z10) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            canvas.drawRoundRect(rectF, f10, f10, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            if (z10 && !bitmap.isRecycled() && createBitmap != bitmap) {
                bitmap.recycle();
            }
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static Bitmap getBitmap(int i10) {
        Drawable drawable = androidx.core.content.a.getDrawable(AppUtils.getApp(), i10);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmap(int i10, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = AppUtils.getApp().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i10, options);
        options.inSampleSize = calculateInSampleSize(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i10, options);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor, int i10, int i11) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }
}

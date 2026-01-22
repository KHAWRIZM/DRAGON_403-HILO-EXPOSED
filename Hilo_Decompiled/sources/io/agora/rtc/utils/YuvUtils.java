package io.agora.rtc.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.util.Log;
import io.agora.rtc.gl.JavaI420Buffer;
import io.agora.rtc.gl.VideoFrame;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

@TargetApi(21)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class YuvUtils {
    public static final int I420 = 35;
    public static final int NV21 = 17;
    private static final String TAG = "YuvUtils";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class Plane {
        private ByteBuffer buffer;
        private int pixelStride;
        private int rowStride;

        public Plane(ByteBuffer byteBuffer, int i10, int i11) {
            this.buffer = byteBuffer;
            this.rowStride = i10;
            this.pixelStride = i11;
        }

        public ByteBuffer getBuffer() {
            return this.buffer;
        }

        public int getPixelStride() {
            return this.pixelStride;
        }

        public int getRowStride() {
            return this.rowStride;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getImageData(Image image, int i10) {
        int i11;
        int i12;
        int i13;
        Rect rect;
        int i14;
        int i15 = i10;
        int i16 = 17;
        int i17 = 35;
        if (i15 != 35 && i15 != 17) {
            throw new IllegalArgumentException("only support COLOR_FormatI420 and COLOR_FormatNV21");
        }
        if (supportedImageFormat(image)) {
            Rect cropRect = image.getCropRect();
            int format = image.getFormat();
            int width = cropRect.width();
            int height = cropRect.height();
            Image.Plane[] planes = image.getPlanes();
            int i18 = width * height;
            byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i18) / 8];
            byte[] bArr2 = new byte[planes[0].getRowStride()];
            int i19 = 1;
            int i20 = 0;
            int i21 = 0;
            int i22 = 1;
            while (i20 < planes.length) {
                if (i20 != 0) {
                    if (i20 != i19) {
                        if (i20 == 2) {
                            if (i15 == i17) {
                                i21 = (int) (i18 * 1.25d);
                            } else if (i15 == i16) {
                                i21 = i18;
                                i22 = 2;
                            }
                        }
                        ByteBuffer buffer = planes[i20].getBuffer();
                        int rowStride = planes[i20].getRowStride();
                        int pixelStride = planes[i20].getPixelStride();
                        if (i20 == 0) {
                            i11 = 0;
                        } else {
                            i11 = 1;
                        }
                        int i23 = width >> i11;
                        i12 = height >> i11;
                        buffer.position(((cropRect.top >> i11) * rowStride) + ((cropRect.left >> i11) * pixelStride));
                        i13 = 0;
                        while (i13 < i12) {
                            if (pixelStride == 1 && i22 == 1) {
                                buffer.get(bArr, i21, i23);
                                i21 += i23;
                                rect = cropRect;
                                i14 = i23;
                            } else {
                                rect = cropRect;
                                i14 = ((i23 - 1) * pixelStride) + 1;
                                buffer.get(bArr2, 0, i14);
                                for (int i24 = 0; i24 < i23; i24++) {
                                    bArr[i21] = bArr2[i24 * pixelStride];
                                    i21 += i22;
                                }
                            }
                            if (i13 < i12 - 1) {
                                buffer.position((buffer.position() + rowStride) - i14);
                            }
                            i13++;
                            cropRect = rect;
                        }
                        i20++;
                        i15 = i10;
                        i16 = 17;
                        i17 = 35;
                        i19 = 1;
                    } else if (i15 == i17) {
                        i21 = i18;
                    } else {
                        if (i15 == i16) {
                            i21 = i18 + 1;
                            i22 = 2;
                        }
                        ByteBuffer buffer2 = planes[i20].getBuffer();
                        int rowStride2 = planes[i20].getRowStride();
                        int pixelStride2 = planes[i20].getPixelStride();
                        if (i20 == 0) {
                        }
                        int i232 = width >> i11;
                        i12 = height >> i11;
                        buffer2.position(((cropRect.top >> i11) * rowStride2) + ((cropRect.left >> i11) * pixelStride2));
                        i13 = 0;
                        while (i13 < i12) {
                        }
                        i20++;
                        i15 = i10;
                        i16 = 17;
                        i17 = 35;
                        i19 = 1;
                    }
                } else {
                    i21 = 0;
                }
                i22 = 1;
                ByteBuffer buffer22 = planes[i20].getBuffer();
                int rowStride22 = planes[i20].getRowStride();
                int pixelStride22 = planes[i20].getPixelStride();
                if (i20 == 0) {
                }
                int i2322 = width >> i11;
                i12 = height >> i11;
                buffer22.position(((cropRect.top >> i11) * rowStride22) + ((cropRect.left >> i11) * pixelStride22));
                i13 = 0;
                while (i13 < i12) {
                }
                i20++;
                i15 = i10;
                i16 = 17;
                i17 = 35;
                i19 = 1;
            }
            return bArr;
        }
        throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
    }

    public static boolean supportedImageFormat(Image image) {
        int format = image.getFormat();
        if (format != 17 && format != 35 && format != 842094169) {
            return false;
        }
        return true;
    }

    public static void write420ImageToFile(Image image, String str) {
        if (image == null) {
            return;
        }
        try {
            YuvImage yuvImage = new YuvImage(yuv420toNV21(image), 17, image.getWidth(), image.getHeight(), null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, image.getWidth(), image.getHeight()), 100, byteArrayOutputStream);
            File file = new File(str);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e10) {
            Log.e(TAG, e10.toString());
        }
    }

    public static boolean writeNV21ToFile(byte[] bArr, int i10, int i11, String str) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i10, i11, null);
        Rect rect = new Rect(0, 0, i10, i11);
        try {
            File file = new File(str);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            yuvImage.compressToJpeg(rect, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e10) {
            Log.e(TAG, e10.toString());
            return false;
        }
    }

    public static void writeRawData(byte[] bArr, String str) {
        if (bArr != null && bArr.length != 0) {
            try {
                File file = new File(str);
                file.createNewFile();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            } catch (IOException e10) {
                Log.e(TAG, e10.toString());
            }
        }
    }

    public static void writeRgbaToFile(Buffer buffer, int i10, int i11, String str) {
        try {
            File file = new File(str);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(buffer);
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e10) {
            Log.e(TAG, e10.toString());
        }
    }

    public static byte[] yuv420toNV21(Image image) {
        int i10;
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i11 = width * height;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i11) / 8];
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i13 < planes.length) {
            if (i13 != 0) {
                if (i13 == i12) {
                    i14 = i11 + 1;
                } else if (i13 == 2) {
                    i14 = i11;
                }
                i15 = 2;
            } else {
                i14 = 0;
                i15 = 1;
            }
            ByteBuffer buffer = planes[i13].getBuffer();
            int rowStride = planes[i13].getRowStride();
            int pixelStride = planes[i13].getPixelStride();
            int i16 = i13 == 0 ? 0 : 1;
            int i17 = width >> i16;
            int i18 = height >> i16;
            int i19 = width;
            int i20 = height;
            buffer.position(((cropRect.top >> i16) * rowStride) + ((cropRect.left >> i16) * pixelStride));
            for (int i21 = 0; i21 < i18; i21++) {
                if (pixelStride == 1 && i15 == 1) {
                    buffer.get(bArr, i14, i17);
                    i14 += i17;
                    i10 = i17;
                } else {
                    i10 = ((i17 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i10);
                    for (int i22 = 0; i22 < i17; i22++) {
                        bArr[i14] = bArr2[i22 * pixelStride];
                        i14 += i15;
                    }
                }
                if (i21 < i18 - 1) {
                    buffer.position((buffer.position() + rowStride) - i10);
                }
            }
            i13++;
            width = i19;
            height = i20;
            i12 = 1;
        }
        return bArr;
    }

    public static byte[] yuv420toNV21(byte[] bArr, int i10, int i11) {
        return yuv420toNV21(JavaI420Buffer.createYUV(bArr, i10, i11), i10, i11);
    }

    public static byte[] yuv420toNV21(VideoFrame.I420Buffer i420Buffer, int i10, int i11) {
        int i12;
        int i13 = i10;
        int i14 = i11;
        Rect rect = new Rect(0, 0, i13, i14);
        int i15 = 1;
        int i16 = 2;
        Plane[] planeArr = {new Plane(i420Buffer.getDataY(), i420Buffer.getStrideY(), 1), new Plane(i420Buffer.getDataU(), i420Buffer.getStrideU(), 1), new Plane(i420Buffer.getDataV(), i420Buffer.getStrideV(), 1)};
        int i17 = i13 * i14;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(35) * i17) / 8];
        byte[] bArr2 = new byte[planeArr[0].getRowStride()];
        int i18 = 0;
        int i19 = 0;
        int i20 = 1;
        for (int i21 = 3; i18 < i21; i21 = 3) {
            if (i18 != 0) {
                if (i18 == i15) {
                    i19 = i17 + 1;
                } else if (i18 == i16) {
                    i19 = i17;
                }
                i20 = 2;
            } else {
                i19 = 0;
                i20 = 1;
            }
            ByteBuffer buffer = planeArr[i18].getBuffer();
            int rowStride = planeArr[i18].getRowStride();
            int pixelStride = planeArr[i18].getPixelStride();
            int i22 = i18 == 0 ? 0 : 1;
            int i23 = i13 >> i22;
            int i24 = i14 >> i22;
            buffer.position(((rect.top >> i22) * rowStride) + ((rect.left >> i22) * pixelStride));
            for (int i25 = 0; i25 < i24; i25++) {
                if (pixelStride == 1 && i20 == 1) {
                    buffer.get(bArr, i19, i23);
                    i19 += i23;
                    i12 = i23;
                } else {
                    i12 = ((i23 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i12);
                    for (int i26 = 0; i26 < i23; i26++) {
                        bArr[i19] = bArr2[i26 * pixelStride];
                        i19 += i20;
                    }
                }
                if (i25 < i24 - 1) {
                    buffer.position((buffer.position() + rowStride) - i12);
                }
            }
            i18++;
            i13 = i10;
            i14 = i11;
            i16 = 2;
            i15 = 1;
        }
        return bArr;
    }
}

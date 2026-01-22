package com.oudi.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import io.agora.rtc.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class NinePatchDrawableFactory {
    private static final int NO_SOLID_COLOR = 1;
    private static final int SIZE_OF_INT32 = 4;
    private static final int SIZE_OF_INT8 = 1;
    private static final int SIZE_OF_PTR = 4;
    private static final int SIZE_OF_UINT32 = 4;
    private static final int TRANSPARENT_COLOR = 0;

    public static NinePatchDrawable convertBitmap(Resources resources, Bitmap bitmap, String str) {
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk != null) {
            return convertCompiledBitmap(resources, bitmap, ninePatchChunk, str);
        }
        return convertNotCompiledBitmap(resources, bitmap, str);
    }

    private static NinePatchDrawable convertCompiledBitmap(Resources resources, Bitmap bitmap, byte[] bArr, String str) {
        return newInstance(resources, bitmap, bArr, getPadding(bArr), getLayoutBounds(bitmap), str);
    }

    private static NinePatchDrawable convertNotCompiledBitmap(Resources resources, Bitmap bitmap, String str) {
        Rect rect;
        Rect rect2;
        ByteBuffer createChunk;
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < 3 || height < 3 || (createChunk = createChunk(bitmap, width, height, (rect = new Rect(0, 0, 0, 0)), (rect2 = new Rect(0, 0, 0, 0)))) == null || (createBitmap = Bitmap.createBitmap(bitmap, 1, 1, width - 2, height - 2)) == null) {
            return null;
        }
        return newInstance(resources, createBitmap, createChunk.array(), rect, rect2, str);
    }

    private static ByteBuffer createChunk(Bitmap bitmap, int i10, int i11, Rect rect, Rect rect2) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19 = i10 - 2;
        int[] iArr = new int[i19];
        int i20 = i11 - 2;
        int[] iArr2 = new int[i20];
        int[] iArr3 = new int[Constants.ERR_WATERMARKR_INFO];
        int i21 = 1;
        int i22 = 0;
        boolean z10 = true;
        while (true) {
            i12 = i10 - 1;
            if (i21 >= i12) {
                break;
            }
            int pixel = bitmap.getPixel(i21, 0);
            if (z10) {
                if (pixel == -16777216) {
                    iArr[i22] = i21;
                    i22++;
                    z10 = false;
                }
            } else if (pixel != -16777216) {
                iArr[i22] = i21;
                i22++;
                z10 = true;
            }
            i21++;
        }
        if (i22 == 0) {
            return null;
        }
        if (i22 == 1) {
            iArr[i22] = i19;
            i22++;
        }
        int i23 = 0;
        int i24 = 1;
        boolean z11 = true;
        while (true) {
            i13 = i11 - 1;
            if (i24 >= i13) {
                break;
            }
            int pixel2 = bitmap.getPixel(0, i24);
            if (z11) {
                if (pixel2 == -16777216) {
                    iArr2[i23] = i24;
                    i23++;
                    z11 = false;
                }
            } else if (pixel2 != -16777216) {
                iArr2[i23] = i24;
                i23++;
                z11 = true;
            }
            i24++;
        }
        if (i23 == 0) {
            return null;
        }
        if (i23 == 1) {
            iArr2[i23] = i20;
            i23++;
        }
        int i25 = 1;
        boolean z12 = true;
        while (true) {
            if (i25 >= i12) {
                break;
            }
            int pixel3 = bitmap.getPixel(i25, i13);
            if (!z12) {
                if (pixel3 != -16777216) {
                    rect.right = (i10 - i25) - 1;
                    break;
                }
            } else if (pixel3 == -16777216) {
                rect.left = i25 - 1;
                z12 = false;
            }
            i25++;
        }
        int i26 = 1;
        boolean z13 = true;
        while (true) {
            if (i26 >= i13) {
                break;
            }
            int pixel4 = bitmap.getPixel(i12, i26);
            if (!z13) {
                if (pixel4 != -16777216) {
                    rect.bottom = (i11 - i26) - 1;
                    break;
                }
            } else if (pixel4 == -16777216) {
                rect.top = i26 - 1;
                z13 = false;
                i26++;
            }
            i26++;
        }
        int i27 = 1;
        if (bitmap.getPixel(1, i13) == -65536) {
            int i28 = 2;
            while (true) {
                if (i28 >= i12) {
                    break;
                }
                if (bitmap.getPixel(i28, i13) != -65536) {
                    rect2.left = i28 - i27;
                    break;
                }
                i28++;
                i27 = 1;
            }
        }
        if (bitmap.getPixel(i19, i13) == -65536) {
            int i29 = i10 - 3;
            while (true) {
                if (i29 <= 0) {
                    break;
                }
                if (bitmap.getPixel(i29, i13) != -65536) {
                    rect2.right = (i10 - i29) - 2;
                    break;
                }
                i29--;
            }
        }
        int i30 = 1;
        if (bitmap.getPixel(i12, 1) == -65536) {
            int i31 = 2;
            while (true) {
                if (i31 >= i13) {
                    break;
                }
                if (bitmap.getPixel(i12, i31) != -65536) {
                    rect2.top = i31 - i30;
                    break;
                }
                i31++;
                i30 = 1;
            }
        }
        if (bitmap.getPixel(i12, i20) == -65536) {
            int i32 = i11 - 3;
            while (true) {
                if (i32 <= 0) {
                    break;
                }
                if (bitmap.getPixel(i12, i32) != -65536) {
                    rect2.bottom = (i11 - i32) - 2;
                    break;
                }
                i32--;
            }
        }
        int i33 = (((i23 + 1) - (iArr2[0] > 1 ? 0 : 1)) - (iArr2[i23 + (-1)] < i20 ? 0 : 1)) * (((i22 + 1) - (iArr[0] > 1 ? 0 : 1)) - (iArr[i22 + (-1)] < i19 ? 0 : 1));
        if (i33 > 127) {
            return null;
        }
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        while (i34 <= i23) {
            if (i34 == 0) {
                i37 = 1;
            }
            int i38 = i34 < i23 ? iArr2[i34] : i20;
            if (i37 >= i38) {
                i14 = i19;
                i15 = i20;
            } else {
                int i39 = i35;
                int i40 = 0;
                while (i40 <= i22) {
                    if (i40 == 0) {
                        i39 = 1;
                    }
                    if (i40 < i22) {
                        i16 = i19;
                        i19 = iArr[i40];
                    } else {
                        i16 = i19;
                    }
                    if (i39 >= i19) {
                        i18 = i19;
                        i17 = i20;
                    } else {
                        i17 = i20;
                        i18 = i19;
                        iArr3[i36] = getBlockColor(bitmap, i39, i37, i19 - 1, i38 - 1);
                        i36++;
                    }
                    i40++;
                    i39 = i18;
                    i19 = i16;
                    i20 = i17;
                }
                i14 = i19;
                i15 = i20;
                i35 = i39;
            }
            i34++;
            i37 = i38;
            i19 = i14;
            i20 = i15;
        }
        for (int i41 = 0; i41 < i22; i41++) {
            iArr[i41] = iArr[i41] - 1;
        }
        int i42 = 1;
        int i43 = 0;
        while (i43 < i23) {
            iArr2[i43] = iArr2[i43] - i42;
            i43++;
            i42 = 1;
        }
        int i44 = i22 * 4;
        ByteBuffer order = ByteBuffer.allocate((i33 * 4) + i44 + 32 + i44).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) i22);
        order.put((byte) i23);
        order.put((byte) i33);
        order.putInt(0);
        order.putInt(0);
        order.putInt(rect.left);
        order.putInt(rect.right);
        order.putInt(rect.top);
        order.putInt(rect.bottom);
        order.putInt(0);
        for (int i45 = 0; i45 < i22; i45++) {
            order.putInt(iArr[i45]);
        }
        for (int i46 = 0; i46 < i23; i46++) {
            order.putInt(iArr2[i46]);
        }
        for (int i47 = 0; i47 < i33; i47++) {
            order.putInt(iArr3[i47]);
        }
        return order;
    }

    private static int getBlockColor(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        int pixel = bitmap.getPixel(i10, i11);
        while (i11 <= i13) {
            for (int i14 = i10; i14 <= i12; i14++) {
                int pixel2 = bitmap.getPixel(i14, i11);
                if (pixel2 != pixel && ((pixel2 | pixel) & (-16777216)) != 0) {
                    return 1;
                }
            }
            i11++;
        }
        if ((pixel & (-16777216)) == 0) {
            return 0;
        }
        return pixel;
    }

    private static Rect getLayoutBounds(Bitmap bitmap) {
        Rect rect = new Rect(0, 0, 0, 0);
        try {
            int[] iArr = (int[]) bitmap.getClass().getMethod("getLayoutBounds", null).invoke(bitmap, null);
            if (iArr != null) {
                rect.set(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
        } catch (NoSuchMethodException unused) {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return rect;
    }

    private static Rect getPadding(byte[] bArr) {
        Rect rect = new Rect(0, 0, 0, 0);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        order.get();
        order.get();
        order.get();
        order.get();
        order.getInt();
        order.getInt();
        rect.left = order.getInt();
        rect.right = order.getInt();
        rect.top = order.getInt();
        rect.bottom = order.getInt();
        return rect;
    }

    private static NinePatchDrawable newInstance(Resources resources, Bitmap bitmap, byte[] bArr, Rect rect, Rect rect2, String str) {
        try {
            return (NinePatchDrawable) NinePatchDrawable.class.getConstructor(Resources.class, Bitmap.class, byte[].class, Rect.class, Rect.class, String.class).newInstance(resources, bitmap, bArr, rect, rect2, str);
        } catch (NoSuchMethodException unused) {
            return new NinePatchDrawable(resources, bitmap, bArr, rect, str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return new NinePatchDrawable(resources, bitmap, bArr, rect, str);
        }
    }
}

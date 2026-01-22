package com.opensource.svgaplayer.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/opensource/svgaplayer/bitmap/SVGABitmapDecoder;", "T", "", "()V", "decodeBitmapFrom", "Landroid/graphics/Bitmap;", "data", "reqWidth", "", "reqHeight", "(Ljava/lang/Object;II)Landroid/graphics/Bitmap;", "onDecode", "ops", "Landroid/graphics/BitmapFactory$Options;", "(Ljava/lang/Object;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class SVGABitmapDecoder<T> {
    @Nullable
    public final Bitmap decodeBitmapFrom(T data, int reqWidth, int reqHeight) {
        boolean z10;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (reqWidth > 0 && reqHeight > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        options.inJustDecodeBounds = z10;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap onDecode = onDecode(data, options);
        if (!options.inJustDecodeBounds) {
            return onDecode;
        }
        options.inSampleSize = BitmapSampleSizeCalculator.INSTANCE.calculate(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return onDecode(data, options);
    }

    @Nullable
    public abstract Bitmap onDecode(T data, @NotNull BitmapFactory.Options ops);
}

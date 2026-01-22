package com.opensource.svgaplayer.bitmap;

import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/opensource/svgaplayer/bitmap/BitmapSampleSizeCalculator;", "", "()V", "calculate", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBitmapSampleSizeCalculator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitmapSampleSizeCalculator.kt\ncom/opensource/svgaplayer/bitmap/BitmapSampleSizeCalculator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class BitmapSampleSizeCalculator {

    @NotNull
    public static final BitmapSampleSizeCalculator INSTANCE = new BitmapSampleSizeCalculator();

    private BitmapSampleSizeCalculator() {
    }

    public final int calculate(@NotNull BitmapFactory.Options options, int reqWidth, int reqHeight) {
        Intrinsics.checkNotNullParameter(options, "options");
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int i10 = 1;
        if (reqHeight > 0 && reqWidth > 0 && (intValue > reqHeight || intValue2 > reqWidth)) {
            int i11 = intValue / 2;
            int i12 = intValue2 / 2;
            while (i11 / i10 >= reqHeight && i12 / i10 >= reqWidth) {
                i10 *= 2;
            }
        }
        return i10;
    }
}

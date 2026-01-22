package com.skydoves.balloon.extensions;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import h2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\u0001*\u00020\u00012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"resize", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "width", "", "height", "(Landroid/graphics/drawable/Drawable;Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "tint", "tintColor", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DrawableExtensionKt {
    @NotNull
    public static final Drawable resize(@NotNull Drawable drawable, @NotNull Context context, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(drawable, "$this$resize");
        Intrinsics.checkNotNullParameter(context, "context");
        if (num != null && num2 != null) {
            Bitmap createBitmap = Bitmap.createBitmap(num.intValue(), num2.intValue(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, num.intValue(), num2.intValue());
            drawable.draw(canvas);
            return new BitmapDrawable(context.getResources(), createBitmap);
        }
        return drawable;
    }

    @NotNull
    public static final Drawable tint(@NotNull Drawable drawable, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(drawable, "$this$tint");
        if (num != null) {
            b.o(b.r(drawable), ColorStateList.valueOf(num.intValue()));
        }
        return drawable;
    }
}

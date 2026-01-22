package com.qiahao.base_common.utils;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/base_common/utils/TextViewToBitmapUtils;", "", "<init>", "()V", "textToBitmap", "Landroid/graphics/Bitmap;", "textView", "Landroid/widget/TextView;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TextViewToBitmapUtils {

    @NotNull
    public static final TextViewToBitmapUtils INSTANCE = new TextViewToBitmapUtils();

    private TextViewToBitmapUtils() {
    }

    @NotNull
    public final Bitmap textToBitmap(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setDrawingCacheEnabled(true);
        textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(textView.getDrawingCache());
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        textView.destroyDrawingCache();
        return createBitmap;
    }
}

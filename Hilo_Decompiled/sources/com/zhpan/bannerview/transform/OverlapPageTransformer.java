package com.zhpan.bannerview.transform;

import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.indicator.utils.IndicatorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(api = 21)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/zhpan/bannerview/transform/OverlapPageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "orientation", "", "minScale", "", "unSelectedItemRotation", "unSelectedItemAlpha", "itemGap", "(IFFFF)V", "scalingValue", "transformPage", "", "page", "Landroid/view/View;", "position", "bannerview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class OverlapPageTransformer implements ViewPager2.PageTransformer {
    private final float itemGap;
    private final float minScale;
    private final int orientation;
    private float scalingValue;
    private final float unSelectedItemAlpha;
    private final float unSelectedItemRotation;

    public OverlapPageTransformer(int i, float f, float f2, float f3, float f4) {
        this.orientation = i;
        this.minScale = f;
        this.unSelectedItemRotation = f2;
        this.unSelectedItemAlpha = f3;
        this.itemGap = f4;
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException("minScale value should be between 1.0 to 0.0");
        }
        if (0.0f <= f3 && f3 <= 1.0f) {
            this.scalingValue = 0.2f;
            return;
        }
        throw new IllegalArgumentException("unSelectedItemAlpha value should be between 1.0 to 0.0");
    }

    public void transformPage(@NotNull View page, float position) {
        float f;
        int width;
        float abs;
        int width2;
        Intrinsics.checkNotNullParameter(page, "page");
        float f2 = this.minScale;
        if (f2 >= 0.8d) {
            f = 0.2f;
        } else if (f2 >= 0.6d) {
            f = 0.3f;
        } else {
            f = 0.4f;
        }
        this.scalingValue = f;
        page.setElevation(-Math.abs(position));
        float max = Math.max(1.0f - Math.abs(position * 0.5f), 0.5f);
        float f3 = this.unSelectedItemRotation;
        if (f3 != 0.0f) {
            float f4 = 1 - max;
            if (position <= 0.0f) {
                f3 = -f3;
            }
            page.setRotationY(f4 * f3);
        }
        float max2 = Math.max(1.0f - Math.abs(this.scalingValue * position), this.minScale);
        page.setScaleX(max2);
        page.setScaleY(max2);
        int dp2px = IndicatorUtils.dp2px(((int) this.itemGap) / 2);
        int i = this.orientation;
        if (i != 0) {
            if (i == 1) {
                float f5 = dp2px * position;
                if (position > 0.0f) {
                    width2 = -page.getWidth();
                } else {
                    width2 = page.getWidth();
                }
                page.setTranslationY(f5 + (width2 * (1.0f - max2)));
            } else {
                throw new IllegalArgumentException("Gives correct orientation value, ViewPager2.ORIENTATION_HORIZONTAL or ViewPager2.ORIENTATION_VERTICAL");
            }
        } else {
            float f6 = dp2px * position;
            if (position > 0.0f) {
                width = -page.getWidth();
            } else {
                width = page.getWidth();
            }
            page.setTranslationX(f6 + (width * (1.0f - max2)));
        }
        if (this.unSelectedItemAlpha != 1.0f) {
            if (position >= -1.0f && position <= 1.0f) {
                abs = ((1 - Math.abs(position)) * 0.5f) + 0.5f;
            } else {
                abs = 0.5f / Math.abs(position * position);
            }
            page.setAlpha(abs);
        }
    }

    public /* synthetic */ OverlapPageTransformer(int i, float f, float f2, float f3, float f4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 0.0f : f, (i2 & 4) != 0 ? 0.0f : f2, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? 0.0f : f4);
    }
}

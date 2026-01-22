package com.qiahao.nextvideo.ui.privilegesynopsis;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/privilegesynopsis/TransFormer;", "Landroidx/viewpager/widget/ViewPager$k;", "<init>", "()V", "Landroid/view/View;", "page", "", "position", "", "transformPage", "(Landroid/view/View;F)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransFormer implements ViewPager.k {
    public static final float MIN_ALPHA = 0.5f;
    public static final float MIN_SCALE = 0.8f;

    public void transformPage(@NotNull View page, float position) {
        Intrinsics.checkNotNullParameter(page, "page");
        if (position >= -1.0f && position <= 1.0f) {
            if (position <= 1.0f) {
                float f = 1;
                float max = Math.max(0.8f, f - Math.abs(position));
                if (position < 0.0f) {
                    float f2 = f + (position * 0.2f);
                    page.setScaleX(f2);
                    page.setScaleY(f2);
                } else {
                    float f3 = f - (position * 0.2f);
                    page.setScaleX(f3);
                    page.setScaleY(f3);
                }
                page.setAlpha((((max - 0.8f) / 0.19999999f) * 0.5f) + 0.5f);
                return;
            }
            return;
        }
        page.setAlpha(0.5f);
        page.setScaleX(0.8f);
        page.setScaleY(0.8f);
    }
}

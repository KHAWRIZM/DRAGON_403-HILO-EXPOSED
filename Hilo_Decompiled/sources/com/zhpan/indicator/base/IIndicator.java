package com.zhpan.indicator.base;

import androidx.viewpager.widget.ViewPager;
import com.zhpan.indicator.option.IndicatorOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/zhpan/indicator/base/IIndicator;", "Landroidx/viewpager/widget/ViewPager$j;", "", "notifyDataChanged", "()V", "Lcom/zhpan/indicator/option/IndicatorOptions;", "options", "setIndicatorOptions", "(Lcom/zhpan/indicator/option/IndicatorOptions;)V", "indicator_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IIndicator extends ViewPager.j {
    void notifyDataChanged();

    /* synthetic */ void onPageScrollStateChanged(int i);

    /* synthetic */ void onPageScrolled(int i, float f, int i2);

    /* synthetic */ void onPageSelected(int i);

    void setIndicatorOptions(@NotNull IndicatorOptions options);
}

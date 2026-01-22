package ed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.zhpan.indicator.R;
import com.zhpan.indicator.option.IndicatorOptions;
import com.zhpan.indicator.utils.IndicatorUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class a {
    public static void a(Context context, AttributeSet attributeSet, IndicatorOptions indicatorOptions) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorView);
            int i = obtainStyledAttributes.getInt(R.styleable.IndicatorView_vpi_slide_mode, 0);
            int i2 = obtainStyledAttributes.getInt(R.styleable.IndicatorView_vpi_style, 0);
            int color = obtainStyledAttributes.getColor(R.styleable.IndicatorView_vpi_slider_checked_color, Color.parseColor("#6C6D72"));
            int color2 = obtainStyledAttributes.getColor(R.styleable.IndicatorView_vpi_slider_normal_color, Color.parseColor("#8C18171C"));
            int i3 = obtainStyledAttributes.getInt(R.styleable.IndicatorView_vpi_orientation, 0);
            float dimension = obtainStyledAttributes.getDimension(R.styleable.IndicatorView_vpi_slider_radius, IndicatorUtils.dp2px(8.0f));
            indicatorOptions.setCheckedColor(color);
            indicatorOptions.setNormalSliderColor(color2);
            indicatorOptions.setOrientation(i3);
            indicatorOptions.setIndicatorStyle(i2);
            indicatorOptions.setSlideMode(i);
            float f = dimension * 2.0f;
            indicatorOptions.setSliderWidth(f, f);
            obtainStyledAttributes.recycle();
        }
    }
}

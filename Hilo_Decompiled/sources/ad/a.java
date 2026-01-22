package ad;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import com.zhpan.bannerview.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    private final c a;

    public a(c cVar) {
        this.a = cVar;
    }

    private void b(TypedArray typedArray) {
        int integer = typedArray.getInteger(R.styleable.BannerViewPager_bvp_interval, HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS);
        boolean z = typedArray.getBoolean(R.styleable.BannerViewPager_bvp_auto_play, true);
        boolean z2 = typedArray.getBoolean(R.styleable.BannerViewPager_bvp_can_loop, true);
        int dimension = (int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_page_margin, 0.0f);
        int dimension2 = (int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_round_corner, 0.0f);
        int dimension3 = (int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_reveal_width, -1000.0f);
        int i = typedArray.getInt(R.styleable.BannerViewPager_bvp_page_style, 0);
        int i2 = typedArray.getInt(R.styleable.BannerViewPager_bvp_scroll_duration, 0);
        this.a.F(integer);
        this.a.v(z);
        this.a.w(z2);
        this.a.I(dimension);
        this.a.M(dimension2);
        this.a.L(dimension3);
        this.a.G(dimension3);
        this.a.K(i);
        this.a.O(i2);
    }

    private void c(TypedArray typedArray) {
        int color = typedArray.getColor(R.styleable.BannerViewPager_bvp_indicator_checked_color, Color.parseColor("#8C18171C"));
        int color2 = typedArray.getColor(R.styleable.BannerViewPager_bvp_indicator_normal_color, Color.parseColor("#8C6C6D72"));
        int dimension = (int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_indicator_radius, dd.a.a(8.0f));
        int i = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_gravity, 0);
        int i2 = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_style, 0);
        int i3 = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_slide_mode, 0);
        int i4 = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_visibility, 0);
        this.a.B(color2, color);
        this.a.C(dimension, dimension);
        this.a.y(i);
        this.a.D(i2);
        this.a.A(i3);
        this.a.E(i4);
        this.a.x(dimension);
        this.a.z(dimension / 2);
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BannerViewPager);
            b(obtainStyledAttributes);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }
}

package cd;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a implements ViewPager2.PageTransformer {
    private final float a;

    public a(float f) {
        this.a = f;
    }

    public void transformPage(View view, float f) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2.0f);
        float f2 = width;
        view.setPivotX(f2 / 2.0f);
        if (f < -1.0f) {
            view.setScaleX(this.a);
            view.setScaleY(this.a);
            view.setPivotX(f2);
            return;
        }
        if (f <= 1.0f) {
            if (f < 0.0f) {
                float f3 = this.a;
                float f4 = ((f + 1.0f) * (1.0f - f3)) + f3;
                view.setScaleX(f4);
                view.setScaleY(f4);
                view.setPivotX(f2 * (((-f) * 0.5f) + 0.5f));
                return;
            }
            float f5 = 1.0f - f;
            float f6 = this.a;
            float f7 = ((1.0f - f6) * f5) + f6;
            view.setScaleX(f7);
            view.setScaleY(f7);
            view.setPivotX(f2 * f5 * 0.5f);
            return;
        }
        view.setPivotX(0.0f);
        view.setScaleX(this.a);
        view.setScaleY(this.a);
    }
}

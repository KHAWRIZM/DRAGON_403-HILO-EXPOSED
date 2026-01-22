package wc;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.d0;
import androidx.core.view.h0;
import androidx.core.view.o0;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.scwang.smart.refresh.layout.kernel.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c implements Interpolator {
    public static int b = 0;
    public static int c = 1;
    private static final float d = Resources.getSystem().getDisplayMetrics().density;
    private static final float e;
    private static final float f;
    private final int a;

    static {
        float k = 1.0f / k(1.0f);
        e = k;
        f = 1.0f - (k * k(1.0f));
    }

    public c(int i) {
        this.a = i;
    }

    public static boolean a(View view, PointF pointF, boolean z) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a = a(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a;
                }
            }
        }
        if (z || view.canScrollVertically(-1)) {
            return true;
        }
        return false;
    }

    public static boolean b(View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean b2 = b(childAt, pointF);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return b2;
                }
            }
            return true;
        }
        return true;
    }

    public static int c(float f2) {
        return (int) ((f2 * d) + 0.5f);
    }

    public static void d(View view, int i) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        }
    }

    public static boolean e(View view) {
        if (view instanceof tc.a) {
            return false;
        }
        if (!f(view) && !(view instanceof ViewPager) && !(view instanceof ViewPager2) && !(view instanceof h0)) {
            return false;
        }
        return true;
    }

    public static boolean f(View view) {
        if (view instanceof tc.a) {
            return false;
        }
        if (!(view instanceof AbsListView) && !(view instanceof ScrollView) && !(view instanceof o0) && !(view instanceof WebView) && !(view instanceof d0)) {
            return false;
        }
        return true;
    }

    public static boolean g(View view, View view2, float f2, float f3, PointF pointF) {
        boolean z;
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f3};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f2;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f4 = fArr[0];
        if (f4 >= 0.0f && scrollY >= 0.0f && f4 < view2.getWidth() && fArr[1] < view2.getHeight()) {
            z = true;
        } else {
            z = false;
        }
        if (z && pointF != null) {
            pointF.set(fArr[0] - f2, fArr[1] - f3);
        }
        return z;
    }

    public static int h(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    public static float i(int i) {
        return i / d;
    }

    public static void j(AbsListView absListView, int i) {
        absListView.scrollListBy(i);
    }

    private static float k(float f2) {
        float f3 = f2 * 8.0f;
        if (f3 < 1.0f) {
            return f3 - (1.0f - ((float) Math.exp(-f3)));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (this.a == c) {
            float f3 = 1.0f - f2;
            return 1.0f - (f3 * f3);
        }
        float k = e * k(f2);
        if (k > 0.0f) {
            return k + f;
        }
        return k;
    }
}

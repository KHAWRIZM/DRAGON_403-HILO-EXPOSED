package xc;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.core.view.d0;
import androidx.core.view.h0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.scwang.smart.refresh.layout.kernel.R;
import java.util.LinkedList;
import tc.b;
import tc.e;
import vc.j;
import wc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a implements b, vc.a, ValueAnimator.AnimatorUpdateListener {
    protected View a;
    protected View b;
    protected View c;
    protected View d;
    protected View e;
    protected int f = 0;
    protected boolean g = true;
    protected boolean h = true;
    protected com.scwang.smart.refresh.layout.simple.a i = new com.scwang.smart.refresh.layout.simple.a();

    public a(View view) {
        this.c = view;
        this.b = view;
        this.a = view;
    }

    @Override // tc.b
    public void a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.a.getLeft(), -this.a.getTop());
        View view = this.c;
        View view2 = this.a;
        if (view != view2) {
            this.c = l(view2, pointF, view);
        }
        if (this.c == this.a) {
            this.i.a = null;
        } else {
            this.i.a = pointF;
        }
    }

    @Override // tc.b
    public void b(e eVar, View view, View view2) {
        k(this.a, eVar);
        if (view != null || view2 != null) {
            this.d = view;
            this.e = view2;
            FrameLayout frameLayout = new FrameLayout(this.a.getContext());
            int indexOfChild = eVar.i().getLayout().indexOfChild(this.a);
            eVar.i().getLayout().removeView(this.a);
            frameLayout.addView(this.a, 0, new ViewGroup.LayoutParams(-1, -1));
            eVar.i().getLayout().addView(frameLayout, indexOfChild, this.a.getLayoutParams());
            this.a = frameLayout;
            if (view != null) {
                view.setTag(R.id.srl_tag, "fixed-top");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                int indexOfChild2 = viewGroup.indexOfChild(view);
                viewGroup.removeView(view);
                layoutParams.height = c.h(view);
                viewGroup.addView(new Space(this.a.getContext()), indexOfChild2, layoutParams);
                frameLayout.addView(view, 1, layoutParams);
            }
            if (view2 != null) {
                view2.setTag(R.id.srl_tag, "fixed-bottom");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                int indexOfChild3 = viewGroup2.indexOfChild(view2);
                viewGroup2.removeView(view2);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
                layoutParams2.height = c.h(view2);
                viewGroup2.addView(new Space(this.a.getContext()), indexOfChild3, layoutParams2);
                layoutParams3.gravity = 80;
                frameLayout.addView(view2, 1, layoutParams3);
            }
        }
    }

    @Override // tc.b
    public void c(j jVar) {
        if (jVar instanceof com.scwang.smart.refresh.layout.simple.a) {
            this.i = (com.scwang.smart.refresh.layout.simple.a) jVar;
        } else {
            this.i.b = jVar;
        }
    }

    @Override // tc.b
    public void d(boolean z) {
        this.i.c = z;
    }

    @Override // tc.b
    public ValueAnimator.AnimatorUpdateListener e(int i) {
        View view = this.c;
        if (view != null && i != 0) {
            if ((i < 0 && view.canScrollVertically(1)) || (i > 0 && this.c.canScrollVertically(-1))) {
                this.f = i;
                return this;
            }
            return null;
        }
        return null;
    }

    @Override // tc.b
    public View f() {
        return this.c;
    }

    @Override // tc.b
    public boolean g() {
        if (this.g && this.i.a(this.a)) {
            return true;
        }
        return false;
    }

    @Override // tc.b
    public View getView() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    @Override // tc.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(int i, int i2, int i3) {
        boolean z;
        View view;
        View view2;
        View findViewById;
        View findViewById2;
        boolean z2 = true;
        if (i2 != -1 && (findViewById2 = this.b.findViewById(i2)) != null) {
            if (i > 0) {
                findViewById2.setTranslationY(i);
                z = true;
                if (i3 != -1 && (findViewById = this.b.findViewById(i3)) != null) {
                    if (i >= 0) {
                        findViewById.setTranslationY(i);
                        if (!z2) {
                            this.b.setTranslationY(i);
                        } else {
                            this.b.setTranslationY(0.0f);
                        }
                        view = this.d;
                        if (view != null) {
                            view.setTranslationY(Math.max(0, i));
                        }
                        view2 = this.e;
                        if (view2 != null) {
                            view2.setTranslationY(Math.min(0, i));
                            return;
                        }
                        return;
                    }
                    if (findViewById.getTranslationY() < 0.0f) {
                        findViewById.setTranslationY(0.0f);
                    }
                }
                z2 = z;
                if (!z2) {
                }
                view = this.d;
                if (view != null) {
                }
                view2 = this.e;
                if (view2 != null) {
                }
            } else if (findViewById2.getTranslationY() > 0.0f) {
                findViewById2.setTranslationY(0.0f);
            }
        }
        z = false;
        if (i3 != -1) {
            if (i >= 0) {
            }
        }
        z2 = z;
        if (!z2) {
        }
        view = this.d;
        if (view != null) {
        }
        view2 = this.e;
        if (view2 != null) {
        }
    }

    @Override // tc.b
    public boolean i() {
        if (this.h && this.i.b(this.a)) {
            return true;
        }
        return false;
    }

    @Override // vc.a
    public void j(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    protected void k(View view, e eVar) {
        boolean z;
        boolean isInEditMode = this.a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof h0) || (view2 instanceof d0))) {
                break;
            }
            if (view2 == null) {
                z = true;
            } else {
                z = false;
            }
            view = m(view, z);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                wc.b.b(view, eVar, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.c = view2;
        }
    }

    protected View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (c.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if ((childAt instanceof ViewPager) || (childAt instanceof ViewPager2) || !c.e(childAt)) {
                        pointF.offset(pointF2.x, pointF2.y);
                        View l = l(childAt, pointF, view2);
                        pointF.offset(-pointF2.x, -pointF2.y);
                        return l;
                    }
                    return childAt;
                }
            }
        }
        return view2;
    }

    protected View m(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && c.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        if (view2 != null) {
            return view2;
        }
        return view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (intValue - this.f) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                c.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f = intValue;
    }
}

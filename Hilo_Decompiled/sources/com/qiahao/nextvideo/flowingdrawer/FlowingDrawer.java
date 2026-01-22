package com.qiahao.nextvideo.flowingdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FlowingDrawer extends ElasticDrawer {
    public FlowingDrawer(Context context) {
        super(context);
    }

    private boolean D(int i) {
        if (this.s == null) {
            return false;
        }
        int position = getPosition();
        if (position != 1) {
            if (position != 2 || d.b(this.s) <= i) {
                return false;
            }
        } else if (d.c(this.s) >= i) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        q(false);
    }

    private void I(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.C) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.k = motionEvent.getX(i);
            this.C = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean L() {
        int position = getPosition();
        if (position != 1) {
            if (position != 2 || (-this.w) > this.b / 2.0f) {
                return false;
            }
        } else if (this.w > this.b / 2.0f) {
            return false;
        }
        return true;
    }

    protected boolean B(float f, float f2) {
        if (Math.abs(f) > this.d && Math.abs(f) > Math.abs(f2)) {
            return true;
        }
        return false;
    }

    public void C(boolean z, float f) {
        d(0, 0, z, f);
    }

    protected boolean F() {
        int position = getPosition();
        if (position != 1) {
            if (position != 2) {
                return false;
            }
            int width = getWidth();
            int i = (int) this.i;
            boolean z = this.a;
            if ((z || i < width - this.r) && (!z || i < width + this.w)) {
                return false;
            }
            return true;
        }
        boolean z2 = this.a;
        if ((z2 || this.i > this.r) && (!z2 || this.i > this.w)) {
            return false;
        }
        return true;
    }

    protected boolean G(int i, float f) {
        if (this.a && this.q == 2) {
            return true;
        }
        int position = getPosition();
        if (position != 1) {
            if (position == 2) {
                int width = getWidth();
                boolean z = this.a;
                if (!z && this.i >= width - this.r && f < 0.0f) {
                    return true;
                }
                if (z && i >= width + this.w) {
                    return true;
                }
            }
        } else {
            boolean z2 = this.a;
            if (!z2 && this.i <= this.r && f > 0.0f) {
                return true;
            }
            if (z2 && i <= this.w) {
                return true;
            }
        }
        return false;
    }

    protected void H(float f, float f2, int i) {
        int position = getPosition();
        if (position != 1) {
            if (position == 2) {
                u(Math.max(Math.min(this.w + f, 0.0f), -this.b), f2, i);
                return;
            }
            return;
        }
        u(Math.min(Math.max(this.w + f, 0.0f), this.b), f2, i);
    }

    protected void J(int i, int i2) {
        int position = getPosition();
        int i3 = 0;
        if (position != 1) {
            if (position == 2) {
                if (this.B) {
                    int i4 = this.z;
                    if (i4 == 4) {
                        C(true, i2);
                        return;
                    }
                    if (i4 == 2 && L()) {
                        v(i2);
                        return;
                    }
                    this.m.computeCurrentVelocity(1000, this.e);
                    int l = (int) l(this.m);
                    this.k = i;
                    if (l <= 0) {
                        i3 = -this.b;
                    }
                    d(i3, l, true, i2);
                    return;
                }
                if (this.E) {
                    this.E = false;
                    return;
                } else {
                    if (this.a) {
                        C(true, i2);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.B) {
            int i5 = this.z;
            if (i5 == 4) {
                C(true, i2);
                return;
            }
            if (i5 == 2 && L()) {
                v(i2);
                return;
            }
            this.m.computeCurrentVelocity(1000, this.e);
            int l2 = (int) l(this.m);
            this.k = i;
            if (l2 > 0) {
                i3 = this.b;
            }
            d(i3, l2, true, i2);
            return;
        }
        if (this.E) {
            this.E = false;
        } else if (this.a) {
            C(true, i2);
        }
    }

    public void K(boolean z, float f) {
        int i;
        int position = getPosition();
        if (position != 1) {
            if (position != 2) {
                i = 0;
            } else {
                i = -this.b;
            }
        } else {
            i = this.b;
        }
        d(i, 0, z, f);
    }

    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    public void f(boolean z) {
        C(z, getHeight() / 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    public void m(Context context, AttributeSet attributeSet, int i) {
        super.m(context, attributeSet, i);
    }

    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    protected void o(int i) {
        if (this.s == null) {
            return;
        }
        int position = getPosition();
        if (position != 1) {
            if (position == 2) {
                this.s.setTranslationX(i + this.b);
            }
        } else {
            this.s.setTranslationX(i - this.b);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction() & 255;
        if (action != 1 && action != 3) {
            if (action == 0 && this.a && n()) {
                u(0.0f, 0.0f, 0);
                x();
                setDrawerState(0);
                this.B = false;
            }
            if (this.a) {
                int i2 = this.C;
                if (i2 == -1 || (i = motionEvent.findPointerIndex(i2)) == -1) {
                    i = 0;
                }
                if (D((int) motionEvent.getX(i))) {
                    return true;
                }
            }
            if (!this.a && !this.B && this.q == 0) {
                return false;
            }
            if (action != 0 && this.B) {
                return true;
            }
            int i3 = 8;
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        I(motionEvent);
                        this.k = motionEvent.getX(motionEvent.findPointerIndex(this.C));
                        this.l = motionEvent.getY(motionEvent.findPointerIndex(this.C));
                    }
                } else {
                    int i4 = this.C;
                    if (i4 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i4);
                        if (findPointerIndex == -1) {
                            this.B = false;
                            this.C = -1;
                            j();
                            C(true, motionEvent.getY());
                            return false;
                        }
                        float x = motionEvent.getX(findPointerIndex);
                        float f = x - this.k;
                        float y = motionEvent.getY(findPointerIndex);
                        if (B(f, y - this.l) && G((int) x, f)) {
                            x();
                            int i5 = this.z;
                            if (i5 != 8 && i5 != 6) {
                                setDrawerState(2);
                            } else {
                                setDrawerState(4);
                            }
                            this.B = true;
                            this.k = x;
                            this.l = y;
                        }
                    }
                }
            } else {
                float x2 = motionEvent.getX();
                this.i = x2;
                this.k = x2;
                float y2 = motionEvent.getY();
                this.j = y2;
                this.l = y2;
                boolean F = F();
                this.C = motionEvent.getPointerId(0);
                if (F) {
                    if (!this.a) {
                        i3 = 0;
                    }
                    setDrawerState(i3);
                    x();
                    this.B = false;
                }
            }
            if (this.m == null) {
                this.m = VelocityTracker.obtain();
            }
            this.m.addMovement(motionEvent);
            return this.B;
        }
        this.C = -1;
        this.B = false;
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
        if (Math.abs(this.w) > this.b / 2) {
            K(true, motionEvent.getY());
        } else {
            C(true, motionEvent.getY());
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        BuildLayerFrameLayout buildLayerFrameLayout = this.t;
        if (buildLayerFrameLayout != null && this.s != null) {
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (i5 > 0 && i6 > 0) {
                try {
                    buildLayerFrameLayout.layout(0, 0, i5, i6);
                    int min = Math.min(this.b, i5);
                    int position = getPosition();
                    if (position != 1) {
                        if (position != 2) {
                            this.s.layout(0, 0, min, i6);
                        } else {
                            this.s.layout(i5 - min, 0, i5, i6);
                        }
                    } else {
                        this.s.layout(0, 0, min, i6);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 0 && mode2 != 0) {
            try {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                if (this.s != null && this.t != null) {
                    if (this.w == -1.0f) {
                        post(new Runnable() { // from class: com.qiahao.nextvideo.flowingdrawer.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                FlowingDrawer.this.E();
                            }
                        });
                    }
                    this.s.measure(ViewGroup.getChildMeasureSpec(i, 0, this.b), ViewGroup.getChildMeasureSpec(i, 0, size2));
                    this.t.measure(ViewGroup.getChildMeasureSpec(i, 0, size), ViewGroup.getChildMeasureSpec(i, 0, size2));
                    setMeasuredDimension(size, size2);
                    z();
                    return;
                }
                super.onMeasure(i, i2);
                return;
            } catch (Exception e) {
                super.onMeasure(i, i2);
                e.printStackTrace();
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        o((int) this.w);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a && !this.B && this.q == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                I(motionEvent);
                                this.k = motionEvent.getX(motionEvent.findPointerIndex(this.C));
                                this.l = motionEvent.getY(motionEvent.findPointerIndex(this.C));
                            }
                        } else {
                            int action2 = (motionEvent.getAction() & 65280) >> 8;
                            this.k = motionEvent.getX(action2);
                            this.l = motionEvent.getY(action2);
                            this.C = motionEvent.getPointerId(action2);
                        }
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.C);
                    if (findPointerIndex == -1) {
                        this.B = false;
                        this.C = -1;
                        j();
                        C(true, motionEvent.getY());
                        return false;
                    }
                    if (this.B) {
                        w();
                        float x = motionEvent.getX(findPointerIndex);
                        float f = x - this.k;
                        float y = motionEvent.getY(findPointerIndex);
                        this.k = x;
                        this.l = y;
                        int i = this.z;
                        if (i == 2) {
                            if (getPosition() == 1) {
                                if (this.w + f < this.b / 2) {
                                    H(f, y, 1);
                                } else {
                                    this.m.computeCurrentVelocity(1000, this.e);
                                    int l = (int) l(this.m);
                                    this.k = x;
                                    d(this.b, l, true, y);
                                    this.E = true;
                                    j();
                                }
                            } else if (this.w + f > (-this.b) / 2) {
                                H(f, y, 1);
                            } else {
                                this.m.computeCurrentVelocity(1000, this.e);
                                int l2 = (int) l(this.m);
                                this.k = x;
                                d(-this.b, l2, true, y);
                                this.E = true;
                                j();
                            }
                        } else if (i == 4) {
                            H(f, y, 5);
                        }
                    }
                }
            }
            int findPointerIndex2 = motionEvent.findPointerIndex(this.C);
            if (findPointerIndex2 == -1) {
                findPointerIndex2 = 0;
            }
            J((int) motionEvent.getX(findPointerIndex2), (int) motionEvent.getY(findPointerIndex2));
            this.C = -1;
            this.B = false;
        } else {
            float x2 = motionEvent.getX();
            this.i = x2;
            this.k = x2;
            float y2 = motionEvent.getY();
            this.j = y2;
            this.l = y2;
            boolean F = F();
            this.C = motionEvent.getPointerId(0);
            if (F) {
                x();
                w();
            }
        }
        return true;
    }

    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    public void q(boolean z) {
        K(z, getHeight() / 2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    protected void w() {
        BuildLayerFrameLayout buildLayerFrameLayout;
        if (this.h && !this.g && (buildLayerFrameLayout = this.s) != null) {
            this.g = true;
            buildLayerFrameLayout.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    public void x() {
        super.x();
    }

    @Override // com.qiahao.nextvideo.flowingdrawer.ElasticDrawer
    protected void y() {
        BuildLayerFrameLayout buildLayerFrameLayout;
        if (this.g && (buildLayerFrameLayout = this.s) != null) {
            this.g = false;
            buildLayerFrameLayout.setLayerType(0, null);
        }
    }

    public FlowingDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlowingDrawer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

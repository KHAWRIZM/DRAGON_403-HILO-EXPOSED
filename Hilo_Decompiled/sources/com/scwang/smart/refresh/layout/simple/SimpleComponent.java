package com.scwang.smart.refresh.layout.simple;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import tc.d;
import tc.e;
import tc.f;
import uc.b;
import uc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class SimpleComponent extends RelativeLayout implements tc.a {
    protected c mSpinnerStyle;
    protected tc.a mWrappedInternal;
    protected View mWrappedView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleComponent(View view) {
        this(view, view instanceof tc.a ? (tc.a) view : null);
    }

    public boolean autoOpen(int i, float f, boolean z) {
        return false;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if ((obj instanceof tc.a) && getView() == ((tc.a) obj).getView()) {
            return true;
        }
        return false;
    }

    @Override // tc.a
    public c getSpinnerStyle() {
        int i;
        c cVar = this.mSpinnerStyle;
        if (cVar != null) {
            return cVar;
        }
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            return aVar.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.k) {
                c cVar2 = ((SmartRefreshLayout.k) layoutParams).b;
                this.mSpinnerStyle = cVar2;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            if (layoutParams != null && ((i = layoutParams.height) == 0 || i == -1)) {
                for (c cVar3 : c.i) {
                    if (cVar3.c) {
                        this.mSpinnerStyle = cVar3;
                        return cVar3;
                    }
                }
            }
        }
        c cVar4 = c.d;
        this.mSpinnerStyle = cVar4;
        return cVar4;
    }

    @Override // tc.a
    public View getView() {
        View view = this.mWrappedView;
        if (view == null) {
            return this;
        }
        return view;
    }

    @Override // tc.a
    public boolean isSupportHorizontalDrag() {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this && aVar.isSupportHorizontalDrag()) {
            return true;
        }
        return false;
    }

    public int onFinish(f fVar, boolean z) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            return aVar.onFinish(fVar, z);
        }
        return 0;
    }

    @Override // tc.a
    public void onHorizontalDrag(float f, int i, int i2) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            aVar.onHorizontalDrag(f, i, i2);
        }
    }

    public void onInitialized(e eVar, int i, int i2) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            aVar.onInitialized(eVar, i, i2);
            return;
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.k) {
                eVar.f(this, ((SmartRefreshLayout.k) layoutParams).a);
            }
        }
    }

    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            aVar.onMoving(z, f, i, i2, i3);
        }
    }

    public void onReleased(f fVar, int i, int i2) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            aVar.onReleased(fVar, i, i2);
        }
    }

    public void onStartAnimator(f fVar, int i, int i2) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            aVar.onStartAnimator(fVar, i, i2);
        }
    }

    public void onStateChanged(f fVar, b bVar, b bVar2) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            if ((this instanceof tc.c) && (aVar instanceof d)) {
                if (bVar.b) {
                    bVar = bVar.d();
                }
                if (bVar2.b) {
                    bVar2 = bVar2.d();
                }
            } else if ((this instanceof d) && (aVar instanceof tc.c)) {
                if (bVar.a) {
                    bVar = bVar.c();
                }
                if (bVar2.a) {
                    bVar2 = bVar2.c();
                }
            }
            tc.a aVar2 = this.mWrappedInternal;
            if (aVar2 != null) {
                aVar2.onStateChanged(fVar, bVar, bVar2);
            }
        }
    }

    public boolean setNoMoreData(boolean z) {
        tc.a aVar = this.mWrappedInternal;
        if ((aVar instanceof tc.c) && ((tc.c) aVar).setNoMoreData(z)) {
            return true;
        }
        return false;
    }

    public void setPrimaryColors(int... iArr) {
        tc.a aVar = this.mWrappedInternal;
        if (aVar != null && aVar != this) {
            aVar.setPrimaryColors(iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleComponent(View view, tc.a aVar) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = aVar;
        if ((this instanceof tc.c) && (aVar instanceof d) && aVar.getSpinnerStyle() == c.h) {
            aVar.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof d) {
            tc.a aVar2 = this.mWrappedInternal;
            if ((aVar2 instanceof tc.c) && aVar2.getSpinnerStyle() == c.h) {
                aVar.getView().setScaleY(-1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleComponent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

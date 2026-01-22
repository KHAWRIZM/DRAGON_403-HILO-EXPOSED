package com.qiahao.nextvideo.flowingdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class BuildLayerFrameLayout extends FrameLayout {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BuildLayerFrameLayout.this.a = true;
            BuildLayerFrameLayout.this.invalidate();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BuildLayerFrameLayout.this.c) {
                if (BuildLayerFrameLayout.this.getLayerType() != 2 || BuildLayerFrameLayout.this.d) {
                    BuildLayerFrameLayout.this.d = false;
                    BuildLayerFrameLayout.this.setLayerType(2, null);
                    BuildLayerFrameLayout.this.buildLayer();
                    BuildLayerFrameLayout.this.setLayerType(0, null);
                }
            }
        }
    }

    public BuildLayerFrameLayout(Context context) {
        super(context);
        this.b = true;
        this.d = true;
        setClipChildren(false);
        setLayerType(2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.a) {
            post(new b());
            this.a = false;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b) {
            post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHardwareLayersEnabled(boolean z) {
        this.b = z;
    }

    public BuildLayerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = true;
        this.d = true;
        setLayerType(2, null);
    }

    public BuildLayerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.d = true;
        setLayerType(2, null);
    }
}

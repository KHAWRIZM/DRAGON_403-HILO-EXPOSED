package com.qiahao.nextvideo.flowingdrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class NoClickThroughFrameLayout extends BuildLayerFrameLayout {
    public NoClickThroughFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public NoClickThroughFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NoClickThroughFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

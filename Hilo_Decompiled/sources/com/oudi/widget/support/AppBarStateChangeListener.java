package com.oudi.widget.support;

import com.google.android.material.appbar.AppBarLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class AppBarStateChangeListener implements AppBarLayout.h {
    public static final int STATE_COLLAPSED = 0;
    public static final int STATE_EXPANDED = 1;
    public static final int STATE_IDLE = -1;
    private int mCurrentState;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public @interface AppBarState {
    }

    @Override // com.google.android.material.appbar.AppBarLayout.b
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
        onOffsetChanged2(appBarLayout, i10);
        if (i10 == 0) {
            if (this.mCurrentState != 1) {
                onStateChanged(appBarLayout, 1);
            }
            this.mCurrentState = 1;
        } else if (Math.abs(i10) >= appBarLayout.getTotalScrollRange()) {
            if (this.mCurrentState != 0) {
                onStateChanged(appBarLayout, 0);
            }
            this.mCurrentState = 0;
        } else {
            if (this.mCurrentState != -1) {
                onStateChanged(appBarLayout, -1);
            }
            this.mCurrentState = -1;
        }
    }

    public void onOffsetChanged2(AppBarLayout appBarLayout, int i10) {
    }

    public void onStateChanged(AppBarLayout appBarLayout, int i10) {
    }
}

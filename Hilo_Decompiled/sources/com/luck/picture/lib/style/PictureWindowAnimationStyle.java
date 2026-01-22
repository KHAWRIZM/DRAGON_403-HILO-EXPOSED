package com.luck.picture.lib.style;

import com.luck.picture.lib.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureWindowAnimationStyle {
    public int activityEnterAnimation;
    public int activityExitAnimation;
    public int activityPreviewEnterAnimation;
    public int activityPreviewExitAnimation;

    public PictureWindowAnimationStyle() {
    }

    public static PictureWindowAnimationStyle ofDefaultWindowAnimationStyle() {
        return new PictureWindowAnimationStyle(R.anim.ps_anim_enter, R.anim.ps_anim_exit);
    }

    public int getActivityEnterAnimation() {
        return this.activityEnterAnimation;
    }

    public int getActivityExitAnimation() {
        return this.activityExitAnimation;
    }

    public int getActivityPreviewEnterAnimation() {
        return this.activityPreviewEnterAnimation;
    }

    public int getActivityPreviewExitAnimation() {
        return this.activityPreviewExitAnimation;
    }

    public void setActivityEnterAnimation(int i10) {
        this.activityEnterAnimation = i10;
    }

    public void setActivityExitAnimation(int i10) {
        this.activityExitAnimation = i10;
    }

    public void setActivityPreviewEnterAnimation(int i10) {
        this.activityPreviewEnterAnimation = i10;
    }

    public void setActivityPreviewExitAnimation(int i10) {
        this.activityPreviewExitAnimation = i10;
    }

    public PictureWindowAnimationStyle(int i10, int i11) {
        this.activityEnterAnimation = i10;
        this.activityExitAnimation = i11;
        this.activityPreviewEnterAnimation = i10;
        this.activityPreviewExitAnimation = i11;
    }
}

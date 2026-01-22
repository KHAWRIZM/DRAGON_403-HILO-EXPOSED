package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGroupSettingBindingImpl extends ActivityGroupSettingBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 15);
        sparseIntArray.put(R.id.imge, 16);
        sparseIntArray.put(R.id.na, 17);
        sparseIntArray.put(2131364012, 18);
        sparseIntArray.put(R.id.imageView2, 19);
        sparseIntArray.put(R.id.intr, 20);
        sparseIntArray.put(R.id.introduction, 21);
        sparseIntArray.put(R.id.imageView3, 22);
        sparseIntArray.put(R.id.ann, 23);
        sparseIntArray.put(R.id.announcement, 24);
        sparseIntArray.put(R.id.imageView4, 25);
        sparseIntArray.put(2131362002, 26);
        sparseIntArray.put(R.id.auto_welcome_contnet, 27);
        sparseIntArray.put(R.id.imageView9, 28);
        sparseIntArray.put(R.id.theme_tap, 29);
        sparseIntArray.put(R.id.imageView12, 30);
        sparseIntArray.put(R.id.membershipText, 31);
        sparseIntArray.put(R.id.membershipTo, 32);
        sparseIntArray.put(R.id.membershipDiamond, 33);
        sparseIntArray.put(R.id.mic_tap, 34);
        sparseIntArray.put(R.id.mic_number, 35);
        sparseIntArray.put(R.id.imageView5, 36);
        sparseIntArray.put(R.id.dice_tap, 37);
        sparseIntArray.put(R.id.dice_number, 38);
        sparseIntArray.put(R.id.imageView13, 39);
        sparseIntArray.put(R.id.switch_lock_text, 40);
        sparseIntArray.put(R.id.joined_password, 41);
        sparseIntArray.put(R.id.imageView8, 42);
        sparseIntArray.put(R.id.setMic, 43);
        sparseIntArray.put(R.id.setMicButton, 44);
        sparseIntArray.put(R.id.setMessage, 45);
        sparseIntArray.put(R.id.setMessageButton, 46);
        sparseIntArray.put(R.id.setPicture, 47);
        sparseIntArray.put(R.id.setPictureButton, 48);
    }

    public ActivityGroupSettingBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 49, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.actionRecords.setOnClickListener(onClickListener);
            this.backImageView.setOnClickListener(onClickListener);
            this.clAnnouncement.setOnClickListener(onClickListener);
            this.clAutoWelcome.setOnClickListener(onClickListener);
            this.clBlocklist.setOnClickListener(onClickListener);
            this.clDice.setOnClickListener(onClickListener);
            this.clIntroduction.setOnClickListener(onClickListener);
            this.clJoinedPassword.setOnClickListener(onClickListener);
            this.clMic.setOnClickListener(onClickListener);
            this.clTheme.setOnClickListener(onClickListener);
            this.imgPic.setOnClickListener(onClickListener);
            this.lcGroupSupport.setOnClickListener(onClickListener);
            this.membership.setOnClickListener(onClickListener);
            this.roomName.setOnClickListener(onClickListener);
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.ActivityGroupSettingBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private ActivityGroupSettingBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[14], (FrameLayout) objArr[0], (TextView) objArr[23], (TextView) objArr[24], (TextView) objArr[26], (TextView) objArr[27], (AppCompatImageView) objArr[1], (ConstraintLayout) objArr[5], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[13], (ConstraintLayout) objArr[10], (ConstraintLayout) objArr[4], (ConstraintLayout) objArr[11], (ConstraintLayout) objArr[9], (ConstraintLayout) objArr[7], (TextView) objArr[38], (TextView) objArr[37], (ImageView) objArr[30], (ImageView) objArr[39], (ImageView) objArr[19], (ImageView) objArr[22], (ImageView) objArr[25], (ImageView) objArr[36], (ImageView) objArr[42], (ImageView) objArr[28], (RoundedImageView) objArr[2], (AppCompatImageView) objArr[16], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[41], (ConstraintLayout) objArr[12], (ConstraintLayout) objArr[8], (AppCompatTextView) objArr[33], (TextView) objArr[31], (ImageView) objArr[32], (TextView) objArr[35], (TextView) objArr[34], (TextView) objArr[17], (TextView) objArr[18], (ConstraintLayout) objArr[3], (FrameLayout) objArr[45], (SwitchButton) objArr[46], (FrameLayout) objArr[43], (SwitchButton) objArr[44], (FrameLayout) objArr[47], (SwitchButton) objArr[48], (SwitchButton) objArr[40], (TextView) objArr[29], (Toolbar) objArr[15]);
        this.mDirtyFlags = -1L;
        this.actionRecords.setTag(null);
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.clAnnouncement.setTag(null);
        this.clAutoWelcome.setTag(null);
        this.clBlocklist.setTag(null);
        this.clDice.setTag(null);
        this.clIntroduction.setTag(null);
        this.clJoinedPassword.setTag(null);
        this.clMic.setTag(null);
        this.clTheme.setTag(null);
        this.imgPic.setTag(null);
        this.lcGroupSupport.setTag(null);
        this.membership.setTag(null);
        this.roomName.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

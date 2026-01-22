package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.CpLevelView;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityCpSpaceBindingImpl extends ActivityCpSpaceBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(57);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_title"}, new int[]{2}, new int[]{R.layout.include_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 3);
        sparseIntArray.put(R.id.buttonBg, 4);
        sparseIntArray.put(R.id.visit, 5);
        sparseIntArray.put(R.id.memorial, 6);
        sparseIntArray.put(R.id.memorialText, 7);
        sparseIntArray.put(R.id.memorialGroup, 8);
        sparseIntArray.put(R.id.certificate, 9);
        sparseIntArray.put(R.id.certificateText, 10);
        sparseIntArray.put(R.id.certificateGroup, 11);
        sparseIntArray.put(R.id.topIcon, 12);
        sparseIntArray.put(R.id.leftIcon, 13);
        sparseIntArray.put(R.id.rightIcon, 14);
        sparseIntArray.put(R.id.leftAvatar, 15);
        sparseIntArray.put(R.id.rightAvatar, 16);
        sparseIntArray.put(R.id.unBindAvatar, 17);
        sparseIntArray.put(R.id.leftName, 18);
        sparseIntArray.put(R.id.rightName, 19);
        sparseIntArray.put(R.id.addImage, 20);
        sparseIntArray.put(2131365296, 21);
        sparseIntArray.put(R.id.unBindApply, 22);
        sparseIntArray.put(R.id.applyAvatar, 23);
        sparseIntArray.put(R.id.applyContent, 24);
        sparseIntArray.put(R.id.revoke, 25);
        sparseIntArray.put(R.id.bindCp, 26);
        sparseIntArray.put(R.id.fell, 27);
        sparseIntArray.put(R.id.dayNumber, 28);
        sparseIntArray.put(2131362599, 29);
        sparseIntArray.put(R.id.dayLine, 30);
        sparseIntArray.put(R.id.cpTip, 31);
        sparseIntArray.put(R.id.stage, 32);
        sparseIntArray.put(R.id.banner, 33);
        sparseIntArray.put(R.id.touchBanner, 34);
        sparseIntArray.put(2131365152, 35);
        sparseIntArray.put(R.id.unBindText, 36);
        sparseIntArray.put(R.id.leftButton, 37);
        sparseIntArray.put(R.id.rightButton, 38);
        sparseIntArray.put(R.id.cpLevel, 39);
        sparseIntArray.put(R.id.pointLayout, 40);
        sparseIntArray.put(R.id.pointNumber, 41);
        sparseIntArray.put(R.id.pointText, 42);
        sparseIntArray.put(R.id.pointTip, 43);
        sparseIntArray.put(R.id.keepTip, 44);
        sparseIntArray.put(R.id.progressBg, 45);
        sparseIntArray.put(2131364344, 46);
        sparseIntArray.put(R.id.progressStart, 47);
        sparseIntArray.put(R.id.progressEnd, 48);
        sparseIntArray.put(R.id.pointGroup, 49);
        sparseIntArray.put(R.id.privilegeLayout, 50);
        sparseIntArray.put(2131364510, 51);
        sparseIntArray.put(R.id.privilegeTitle, 52);
        sparseIntArray.put(R.id.bindGroup, 53);
        sparseIntArray.put(R.id.unBindGroup, 54);
        sparseIntArray.put(R.id.myCpLayout, 55);
        sparseIntArray.put(R.id.myCp, 56);
    }

    public ActivityCpSpaceBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 57, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleBar(IncludeTitleBinding includeTitleBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.titleBar);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.titleBar.hasPendingBindings()) {
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
        this.titleBar.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeTitleBar((IncludeTitleBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleBar.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ActivityCpSpaceBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (FrameLayout) objArr[0], (ImageView) objArr[20], (HiloImageView) objArr[23], (TextView) objArr[24], (BannerViewPager) objArr[33], (TextView) objArr[26], (Group) objArr[53], (ImageView) objArr[4], (ImageView) objArr[9], (Group) objArr[11], (TextView) objArr[10], (CpLevelView) objArr[39], (TextView) objArr[31], (TextView) objArr[29], (ImageView) objArr[30], (TextView) objArr[28], (TextView) objArr[27], (TextView) objArr[44], (HiloImageView) objArr[15], (AppCompatImageView) objArr[37], (ImageView) objArr[13], (TextView) objArr[18], (ImageView) objArr[6], (Group) objArr[8], (TextView) objArr[7], (TextView) objArr[56], (FrameLayout) objArr[55], (Group) objArr[49], (ConstraintLayout) objArr[40], (TextView) objArr[41], (TextView) objArr[42], (TextView) objArr[43], (FrameLayout) objArr[50], (TextView) objArr[52], (ProgressBar) objArr[46], (ImageView) objArr[45], (TextView) objArr[48], (TextView) objArr[47], (RecyclerView) objArr[51], (TextView) objArr[25], (HiloImageView) objArr[16], (AppCompatImageView) objArr[38], (ImageView) objArr[14], (TextView) objArr[19], (ImageView) objArr[32], (TextView) objArr[35], (IncludeTitleBinding) objArr[2], (ImageView) objArr[3], (ImageView) objArr[12], (ImageView) objArr[21], (View) objArr[34], (ConstraintLayout) objArr[22], (ImageView) objArr[17], (Group) objArr[54], (TextView) objArr[36], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.titleBar);
        setRootTag(view);
        invalidateAll();
    }
}

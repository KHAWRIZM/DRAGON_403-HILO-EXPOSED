package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityRoomUserInfoLevelBindingImpl extends ActivityRoomUserInfoLevelBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 9);
        sparseIntArray.put(R.id.user_avatar_cimage_view, 10);
        sparseIntArray.put(R.id.online_status, 11);
        sparseIntArray.put(2131365557, 12);
        sparseIntArray.put(R.id.ll_level, 13);
        sparseIntArray.put(2131365568, 14);
        sparseIntArray.put(R.id.country_image, 15);
        sparseIntArray.put(R.id.age_text_view, 16);
        sparseIntArray.put(2131365691, 17);
        sparseIntArray.put(2131362273, 18);
        sparseIntArray.put(R.id.view_manager, 19);
        sparseIntArray.put(R.id.member_content, 20);
        sparseIntArray.put(R.id.view_admin, 21);
    }

    public ActivityRoomUserInfoLevelBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 22, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.backImageView.setOnClickListener(onClickListener);
            this.confim.setOnClickListener(onClickListener);
            this.llAdmin.setOnClickListener(onClickListener);
            this.llManager.setOnClickListener(onClickListener);
            this.llMember.setOnClickListener(onClickListener);
            this.tourist.setOnClickListener(onClickListener);
            this.viewMember.setOnClickListener(onClickListener);
            this.viewTourist.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.ActivityRoomUserInfoLevelBinding
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

    private ActivityRoomUserInfoLevelBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (GenderAgeTextView) objArr[16], (AppCompatImageView) objArr[1], (HiloGradeView) objArr[18], (TextView) objArr[8], (ImageView) objArr[15], (LinearLayout) objArr[3], (LinearLayout) objArr[13], (LinearLayout) objArr[2], (LinearLayout) objArr[4], (TextView) objArr[20], (View) objArr[11], (Toolbar) objArr[9], (LinearLayout) objArr[6], (CircleImageView) objArr[10], (TextView) objArr[12], (ImageView) objArr[14], (View) objArr[21], (View) objArr[19], (View) objArr[5], (View) objArr[7], (HiloGradeView) objArr[17]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.confim.setTag(null);
        this.llAdmin.setTag(null);
        this.llManager.setTag(null);
        this.llMember.setTag(null);
        this.tourist.setTag(null);
        this.viewMember.setTag(null);
        this.viewTourist.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGroupSupportBindingImpl extends ActivityGroupSupportBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 3);
        sparseIntArray.put(R.id.view1, 4);
        sparseIntArray.put(R.id.view2, 5);
        sparseIntArray.put(R.id.last_support_text, 6);
        sparseIntArray.put(R.id.last_week_support, 7);
        sparseIntArray.put(R.id.last_trophy_text, 8);
        sparseIntArray.put(R.id.last_week_trophy, 9);
        sparseIntArray.put(R.id.last_Level_text, 10);
        sparseIntArray.put(R.id.last_week_level, 11);
        sparseIntArray.put(R.id.view3, 12);
        sparseIntArray.put(R.id.view4, 13);
        sparseIntArray.put(R.id.this_support_text, 14);
        sparseIntArray.put(R.id.this_week_support, 15);
        sparseIntArray.put(R.id.this_trophy_text, 16);
        sparseIntArray.put(R.id.this_week_trophy, 17);
        sparseIntArray.put(R.id.this_Level_text, 18);
        sparseIntArray.put(R.id.this_week_level, 19);
        sparseIntArray.put(R.id.ll_owner_group, 20);
        sparseIntArray.put(R.id.ll_owner, 21);
        sparseIntArray.put(R.id.owner_avatar, 22);
        sparseIntArray.put(R.id.owner_name, 23);
        sparseIntArray.put(R.id.owner_id, 24);
        sparseIntArray.put(R.id.group_admin, 25);
        sparseIntArray.put(R.id.recycler_group_admin, 26);
        sparseIntArray.put(R.id.unreceive_award_btn1, 27);
        sparseIntArray.put(2131365027, 28);
        sparseIntArray.put(2131365036, 29);
        sparseIntArray.put(R.id.ll_can_reward, 30);
    }

    public ActivityGroupSupportBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 31, sIncludes, sViewsWithIds));
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
            this.receiveRewardBtn.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.ActivityGroupSupportBinding
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

    private ActivityGroupSupportBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[1], (LinearLayout) objArr[25], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[8], (TextView) objArr[11], (TextView) objArr[7], (TextView) objArr[9], (LinearLayout) objArr[30], (ConstraintLayout) objArr[21], (LinearLayout) objArr[20], (CircleImageView) objArr[22], (TextView) objArr[24], (TextView) objArr[23], (TextView) objArr[2], (RecyclerView) objArr[26], (TextView) objArr[28], (TextView) objArr[29], (TextView) objArr[18], (TextView) objArr[14], (TextView) objArr[16], (TextView) objArr[19], (TextView) objArr[15], (TextView) objArr[17], (Toolbar) objArr[3], (LinearLayout) objArr[27], (View) objArr[4], (View) objArr[5], (View) objArr[12], (View) objArr[13]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.receiveRewardBtn.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

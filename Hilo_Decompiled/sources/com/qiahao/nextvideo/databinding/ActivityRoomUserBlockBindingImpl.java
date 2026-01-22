package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import org.android.agoo.common.AgooConstants;
import t2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityRoomUserBlockBindingImpl extends ActivityRoomUserBlockBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 10);
        sparseIntArray.put(R.id.user_avatar_cimage_view, 11);
        sparseIntArray.put(R.id.online_status, 12);
        sparseIntArray.put(2131365557, 13);
        sparseIntArray.put(R.id.ll_level, 14);
        sparseIntArray.put(2131365568, 15);
        sparseIntArray.put(R.id.country_image, 16);
        sparseIntArray.put(R.id.age_text_view, 17);
        sparseIntArray.put(2131365691, 18);
        sparseIntArray.put(2131362273, 19);
        sparseIntArray.put(R.id.view_kick_out, 20);
        sparseIntArray.put(R.id.view_block_delete_history, 21);
        sparseIntArray.put(2131363500, 22);
        sparseIntArray.put(2131362440, 23);
        sparseIntArray.put(2131365026, 24);
    }

    public ActivityRoomUserBlockBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 25, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((3 & j) != 0) {
            this.backImageView.setOnClickListener(onClickListener);
            this.confim.setOnClickListener(onClickListener);
            this.llBlockDeleteHistory.setOnClickListener(onClickListener);
            this.llBlockNotDeleteHistory.setOnClickListener(onClickListener);
            this.llKickOut.setOnClickListener(onClickListener);
            this.svipLinear.setOnClickListener(onClickListener);
            this.svipView.setOnClickListener(onClickListener);
            this.viewBlockNotDeleteHistory.setOnClickListener(onClickListener);
        }
        if ((j & 2) != 0) {
            TextView textView = this.mboundView3;
            b.c(textView, textView.getResources().getString(2131952984, AgooConstants.ACK_REMOVE_PACKAGE));
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

    @Override // com.qiahao.nextvideo.databinding.ActivityRoomUserBlockBinding
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

    private ActivityRoomUserBlockBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (GenderAgeTextView) objArr[17], (AppCompatImageView) objArr[1], (HiloGradeView) objArr[19], (TextView) objArr[9], (TextView) objArr[23], (ImageView) objArr[16], (View) objArr[22], (LinearLayout) objArr[4], (LinearLayout) objArr[5], (LinearLayout) objArr[2], (LinearLayout) objArr[14], (View) objArr[12], (ConstraintLayout) objArr[7], (View) objArr[8], (TextView) objArr[24], (Toolbar) objArr[10], (CircleImageView) objArr[11], (TextView) objArr[13], (ImageView) objArr[15], (View) objArr[21], (View) objArr[6], (View) objArr[20], (HiloGradeView) objArr[18]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.confim.setTag(null);
        this.llBlockDeleteHistory.setTag(null);
        this.llBlockNotDeleteHistory.setTag(null);
        this.llKickOut.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.mboundView3 = textView;
        textView.setTag(null);
        this.svipLinear.setTag(null);
        this.svipView.setTag(null);
        this.viewBlockNotDeleteHistory.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

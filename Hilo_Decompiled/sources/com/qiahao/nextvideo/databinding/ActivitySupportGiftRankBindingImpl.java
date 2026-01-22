package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivitySupportGiftRankBindingImpl extends ActivitySupportGiftRankBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131365217, 3);
        sparseIntArray.put(R.id.title_text_view, 4);
        sparseIntArray.put(R.id.smart_refresh_layout, 5);
        sparseIntArray.put(R.id.ll_content_top2, 6);
        sparseIntArray.put(R.id.top2_avatar, 7);
        sparseIntArray.put(R.id.icon_vip2, 8);
        sparseIntArray.put(R.id.icon_noble2, 9);
        sparseIntArray.put(R.id.svip2, 10);
        sparseIntArray.put(R.id.top2_name, 11);
        sparseIntArray.put(R.id.top2_id, 12);
        sparseIntArray.put(R.id.ll_diamond2, 13);
        sparseIntArray.put(R.id.top2_diamond, 14);
        sparseIntArray.put(R.id.top_2_medal, 15);
        sparseIntArray.put(R.id.ll_content_top1, 16);
        sparseIntArray.put(R.id.top1_avatar, 17);
        sparseIntArray.put(R.id.icon_vip1, 18);
        sparseIntArray.put(R.id.icon_noble1, 19);
        sparseIntArray.put(R.id.svip1, 20);
        sparseIntArray.put(R.id.top1_name, 21);
        sparseIntArray.put(R.id.top1_id, 22);
        sparseIntArray.put(R.id.ll_diamond1, 23);
        sparseIntArray.put(R.id.top1_diamond, 24);
        sparseIntArray.put(R.id.top_1_medal, 25);
        sparseIntArray.put(R.id.ll_content_top3, 26);
        sparseIntArray.put(R.id.top3_avatar, 27);
        sparseIntArray.put(R.id.icon_vip3, 28);
        sparseIntArray.put(R.id.icon_noble3, 29);
        sparseIntArray.put(R.id.svip3, 30);
        sparseIntArray.put(R.id.top3_name, 31);
        sparseIntArray.put(R.id.top3_id, 32);
        sparseIntArray.put(R.id.ll_diamond3, 33);
        sparseIntArray.put(R.id.top3_diamond, 34);
        sparseIntArray.put(R.id.top_3_medal, 35);
        sparseIntArray.put(R.id.recycler_rank, 36);
        sparseIntArray.put(R.id.empty_tip_text_view, 37);
    }

    public ActivitySupportGiftRankBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 38, sIncludes, sViewsWithIds));
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
            this.icQuestion.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.ActivitySupportGiftRankBinding
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

    private ActivitySupportGiftRankBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[1], (AppCompatTextView) objArr[37], (ImageView) objArr[2], (ImageView) objArr[19], (ImageView) objArr[9], (ImageView) objArr[29], (ImageView) objArr[18], (ImageView) objArr[8], (ImageView) objArr[28], (LinearLayout) objArr[16], (LinearLayout) objArr[6], (LinearLayout) objArr[26], (LinearLayout) objArr[23], (LinearLayout) objArr[13], (LinearLayout) objArr[33], (RecyclerView) objArr[36], (SmartRefreshLayout) objArr[5], (ImageView) objArr[20], (ImageView) objArr[10], (ImageView) objArr[30], (AppCompatTextView) objArr[4], (Toolbar) objArr[3], (CircleImageView) objArr[17], (TextView) objArr[24], (ShineTextView) objArr[22], (MedalGridLayout) objArr[25], (TextView) objArr[21], (CircleImageView) objArr[7], (TextView) objArr[14], (ShineTextView) objArr[12], (MedalGridLayout) objArr[15], (TextView) objArr[11], (CircleImageView) objArr[27], (TextView) objArr[34], (ShineTextView) objArr[32], (MedalGridLayout) objArr[35], (TextView) objArr[31]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.icQuestion.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

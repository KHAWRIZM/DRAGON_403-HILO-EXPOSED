package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogLuckyBoxBindingImpl extends DialogLuckyBoxBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.lucky_box_content, 10);
        sparseIntArray.put(R.id.top_line_view, 11);
        sparseIntArray.put(R.id.diamond_count_tick_text_view, 12);
        sparseIntArray.put(R.id.ll_broad_cast, 13);
        sparseIntArray.put(R.id.imge1, 14);
        sparseIntArray.put(R.id.banner_view, 15);
        sparseIntArray.put(R.id.box_1, 16);
        sparseIntArray.put(R.id.box_2, 17);
        sparseIntArray.put(R.id.box_3, 18);
        sparseIntArray.put(R.id.box_4, 19);
        sparseIntArray.put(R.id.box_5, 20);
        sparseIntArray.put(R.id.box_6, 21);
        sparseIntArray.put(R.id.one_times_text, 22);
        sparseIntArray.put(R.id.one_times_diamond, 23);
        sparseIntArray.put(R.id.teen_times_text, 24);
        sparseIntArray.put(R.id.teen_times_diamond, 25);
        sparseIntArray.put(R.id.reward_layout, 26);
        sparseIntArray.put(R.id.title_bg, 27);
        sparseIntArray.put(R.id.teen_times_reward, 28);
        sparseIntArray.put(R.id.once_light, 29);
        sparseIntArray.put(R.id.one_reward, 30);
        sparseIntArray.put(2131362419, 31);
        sparseIntArray.put(R.id.once_again, 32);
    }

    public DialogLuckyBoxBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 33, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.bannerClick.setOnClickListener(onClickListener);
            this.drawOneTimes.setOnClickListener(onClickListener);
            this.drawTeenTimes.setOnClickListener(onClickListener);
            this.icLuckyBoxList.setOnClickListener(onClickListener);
            this.icLuckyBoxRank.setOnClickListener(onClickListener);
            this.llDiamond.setOnClickListener(onClickListener);
            this.rewardAgain.setOnClickListener(onClickListener);
            this.rewardConfirm.setOnClickListener(onClickListener);
            this.rewardList.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogLuckyBoxBinding
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

    private DialogLuckyBoxBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (View) objArr[5], (BannerViewPager) objArr[15], (ImageView) objArr[16], (ImageView) objArr[17], (ImageView) objArr[18], (ImageView) objArr[19], (ImageView) objArr[20], (ImageView) objArr[21], (TextView) objArr[31], (DiamondTickTextView) objArr[12], (View) objArr[6], (View) objArr[7], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[14], (ConstraintLayout) objArr[13], (LinearLayout) objArr[1], (ConstraintLayout) objArr[10], (TextView) objArr[32], (View) objArr[29], (ImageView) objArr[30], (TextView) objArr[23], (TextView) objArr[22], (View) objArr[9], (View) objArr[8], (ConstraintLayout) objArr[26], (ImageView) objArr[4], (TextView) objArr[25], (RecyclerView) objArr[28], (TextView) objArr[24], (View) objArr[27], (View) objArr[11]);
        this.mDirtyFlags = -1L;
        this.bannerClick.setTag(null);
        this.drawOneTimes.setTag(null);
        this.drawTeenTimes.setTag(null);
        this.icLuckyBoxList.setTag(null);
        this.icLuckyBoxRank.setTag(null);
        this.llDiamond.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.rewardAgain.setTag(null);
        this.rewardConfirm.setTag(null);
        this.rewardList.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

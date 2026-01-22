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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class LuckyWheelSelectDialogBindingImpl extends LuckyWheelSelectDialogBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_img, 6);
        sparseIntArray.put(R.id.recycler_view, 7);
        sparseIntArray.put(R.id.select_also_participate, 8);
        sparseIntArray.put(R.id.select_automatic_next_round, 9);
    }

    public LuckyWheelSelectDialogBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 10, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.close.setOnClickListener(onClickListener);
            this.llAlsoParticipate.setOnClickListener(onClickListener);
            this.llAutomaticNextRound.setOnClickListener(onClickListener);
            this.luckyWheelCreate.setOnClickListener(onClickListener);
            this.luckyWheelQuestion.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.LuckyWheelSelectDialogBinding
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

    private LuckyWheelSelectDialogBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ConstraintLayout) objArr[0], (ImageView) objArr[2], (LinearLayout) objArr[3], (LinearLayout) objArr[4], (TextView) objArr[5], (ImageView) objArr[1], (RecyclerView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.bgContent.setTag(null);
        this.close.setTag(null);
        this.llAlsoParticipate.setTag(null);
        this.llAutomaticNextRound.setTag(null);
        this.luckyWheelCreate.setTag(null);
        this.luckyWheelQuestion.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PinEntryEditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogJoinLockRoomBindingImpl extends DialogJoinLockRoomBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bg_group_pic, 4);
        sparseIntArray.put(R.id.group_pic, 5);
        sparseIntArray.put(R.id.ll_group_name, 6);
        sparseIntArray.put(R.id.group_name, 7);
        sparseIntArray.put(R.id.count_pic, 8);
        sparseIntArray.put(R.id.group_id, 9);
        sparseIntArray.put(R.id.ll_show_pass_word, 10);
        sparseIntArray.put(R.id.password, 11);
        sparseIntArray.put(R.id.join_pass_word_button_back_group, 12);
    }

    public DialogJoinLockRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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
            this.enterButton.setOnClickListener(onClickListener);
            this.reportImageView.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.DialogJoinLockRoomBinding
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

    private DialogJoinLockRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[4], (TextView) objArr[1], (ImageView) objArr[8], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[7], (RoundedImageView) objArr[5], (View) objArr[12], (LinearLayout) objArr[6], (LinearLayout) objArr[10], (PinEntryEditText) objArr[11], (AppCompatImageView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.close.setTag(null);
        this.enterButton.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.reportImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomInfo2BindingImpl extends DialogRoomInfo2Binding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bgGroupPic, 3);
        sparseIntArray.put(R.id.group_pic, 4);
        sparseIntArray.put(R.id.roomSvga, 5);
        sparseIntArray.put(R.id.roomImageHead, 6);
        sparseIntArray.put(R.id.group_name, 7);
        sparseIntArray.put(2131364963, 8);
        sparseIntArray.put(R.id.count_pic, 9);
        sparseIntArray.put(R.id.group_id, 10);
        sparseIntArray.put(R.id.tabLayout, 11);
        sparseIntArray.put(R.id.viewPage, 12);
    }

    public DialogRoomInfo2BindingImpl(f fVar, View view) {
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

    @Override // com.qiahao.nextvideo.databinding.DialogRoomInfo2Binding
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

    private DialogRoomInfo2BindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (RoundCornerImageView) objArr[3], (TextView) objArr[1], (ImageView) objArr[9], (ShineTextView) objArr[10], (NickTextView) objArr[7], (RoundedImageView) objArr[4], (AppCompatImageView) objArr[2], (ImageView) objArr[6], (SVGAImageView) objArr[5], (ImageView) objArr[8], (ViewPage2TabLayout) objArr[11], (ViewPager2) objArr[12]);
        this.mDirtyFlags = -1L;
        this.close.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.reportImageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

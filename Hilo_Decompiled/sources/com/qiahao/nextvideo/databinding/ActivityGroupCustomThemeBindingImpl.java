package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGroupCustomThemeBindingImpl extends ActivityGroupCustomThemeBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 4);
        sparseIntArray.put(R.id.imge, 5);
        sparseIntArray.put(R.id.custom_theme_back_group, 6);
        sparseIntArray.put(R.id.diamond_img, 7);
        sparseIntArray.put(R.id.diamond_and_time, 8);
    }

    public ActivityGroupCustomThemeBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.addThemeImage.setOnClickListener(onClickListener);
            this.backImageView.setOnClickListener(onClickListener);
            this.customTheme.setOnClickListener(onClickListener);
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

    @Override // com.qiahao.nextvideo.databinding.ActivityGroupCustomThemeBinding
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

    private ActivityGroupCustomThemeBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (ImageView) objArr[2], (AppCompatImageView) objArr[1], (TextView) objArr[3], (View) objArr[6], (TextView) objArr[8], (ImageView) objArr[7], (AppCompatImageView) objArr[5], (Toolbar) objArr[4]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.addThemeImage.setTag(null);
        this.backImageView.setTag(null);
        this.customTheme.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

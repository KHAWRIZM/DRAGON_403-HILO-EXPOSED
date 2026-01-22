package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import t2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class IncludeAccountItemBindingImpl extends IncludeAccountItemBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.startImage, 3);
        sparseIntArray.put(2131364936, 4);
        sparseIntArray.put(R.id.arrow, 5);
    }

    public IncludeAccountItemBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 6, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        long j2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Boolean bool = this.mShowLine;
        String str = this.mTitle;
        long j3 = j & 9;
        int i = 0;
        if (j3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j3 != 0) {
                if (safeUnbox) {
                    j2 = 32;
                } else {
                    j2 = 16;
                }
                j |= j2;
            }
            if (safeUnbox) {
                i = 8;
            }
        }
        long j4 = 12 & j;
        if ((j & 9) != 0) {
            this.line.setVisibility(i);
        }
        if (j4 != 0) {
            b.c(this.title, str);
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
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeAccountItemBinding
    public void setShowLine(Boolean bool) {
        this.mShowLine = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeAccountItemBinding
    public void setSubTitle(String str) {
        this.mSubTitle = str;
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeAccountItemBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (6 == i) {
            setShowLine((Boolean) obj);
        } else if (7 == i) {
            setSubTitle((String) obj);
        } else if (8 == i) {
            setTitle((String) obj);
        } else {
            return false;
        }
        return true;
    }

    private IncludeAccountItemBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[5], (View) objArr[2], (ImageView) objArr[3], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.line.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

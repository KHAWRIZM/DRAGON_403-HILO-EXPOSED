package com.qiahao.nextvideo.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import t2.a;
import t2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class IncludeMatchBigItemBindingImpl extends IncludeMatchBigItemBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public IncludeMatchBigItemBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 5, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        long j2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mButtonTitle;
        String str2 = this.mSubTitle;
        Boolean bool = this.mVisibilityButton;
        String str3 = this.mTitle;
        Drawable drawable = this.mImageSrc;
        long j3 = j & 36;
        int i = 0;
        if (j3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j3 != 0) {
                if (safeUnbox) {
                    j2 = 128;
                } else {
                    j2 = 64;
                }
                j |= j2;
            }
            if (!safeUnbox) {
                i = 8;
            }
        }
        long j4 = 40 & j;
        long j5 = 48 & j;
        if ((33 & j) != 0) {
            b.c(this.button, str);
        }
        if ((36 & j) != 0) {
            this.button.setVisibility(i);
        }
        if (j5 != 0) {
            a.a(this.image, drawable);
        }
        if ((j & 34) != 0) {
            b.c(this.subTitle, str2);
        }
        if (j4 != 0) {
            b.c(this.title, str3);
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
            this.mDirtyFlags = 32L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeMatchBigItemBinding
    public void setButtonTitle(String str) {
        this.mButtonTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeMatchBigItemBinding
    public void setImageSrc(Drawable drawable) {
        this.mImageSrc = drawable;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeMatchBigItemBinding
    public void setSubTitle(String str) {
        this.mSubTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeMatchBigItemBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (1 == i) {
            setButtonTitle((String) obj);
            return true;
        }
        if (7 == i) {
            setSubTitle((String) obj);
            return true;
        }
        if (9 == i) {
            setVisibilityButton((Boolean) obj);
            return true;
        }
        if (8 == i) {
            setTitle((String) obj);
            return true;
        }
        if (4 == i) {
            setImageSrc((Drawable) obj);
            return true;
        }
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.IncludeMatchBigItemBinding
    public void setVisibilityButton(Boolean bool) {
        this.mVisibilityButton = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    private IncludeMatchBigItemBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[4], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.button.setTag(null);
        this.image.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.subTitle.setTag(null);
        this.title.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

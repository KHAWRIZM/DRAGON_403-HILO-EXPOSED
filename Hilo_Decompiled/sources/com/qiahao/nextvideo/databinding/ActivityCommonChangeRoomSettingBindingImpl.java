package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import t2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityCommonChangeRoomSettingBindingImpl extends ActivityCommonChangeRoomSettingBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final AppCompatTextView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.titleBar, 6);
    }

    public ActivityCommonChangeRoomSettingBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mTitle;
        Integer num = this.mNumber;
        View.OnClickListener onClickListener = this.mClick;
        long j2 = 9 & j;
        long j3 = 10 & j;
        if (j3 != 0) {
            i = ViewDataBinding.safeUnbox(num);
        } else {
            i = 0;
        }
        if ((j & 12) != 0) {
            this.backImageView.setOnClickListener(onClickListener);
            this.save.setOnClickListener(onClickListener);
        }
        if (j3 != 0) {
            b.b(this.etContent, i);
            this.textNumber.setTag(num);
        }
        if (j2 != 0) {
            b.c(this.mboundView2, str);
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

    @Override // com.qiahao.nextvideo.databinding.ActivityCommonChangeRoomSettingBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.ActivityCommonChangeRoomSettingBinding
    public void setNumber(Integer num) {
        this.mNumber = num;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // com.qiahao.nextvideo.databinding.ActivityCommonChangeRoomSettingBinding
    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (8 == i) {
            setTitle((String) obj);
        } else if (5 == i) {
            setNumber((Integer) obj);
        } else if (2 == i) {
            setClick((View.OnClickListener) obj);
        } else {
            return false;
        }
        return true;
    }

    private ActivityCommonChangeRoomSettingBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[0], (AppCompatImageView) objArr[1], (EditText) objArr[4], (AppCompatTextView) objArr[3], (TextView) objArr[5], (Toolbar) objArr[6]);
        this.mDirtyFlags = -1L;
        this.activityMainContainer.setTag(null);
        this.backImageView.setTag(null);
        this.etContent.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) objArr[2];
        this.mboundView2 = appCompatTextView;
        appCompatTextView.setTag(null);
        this.save.setTag(null);
        this.textNumber.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

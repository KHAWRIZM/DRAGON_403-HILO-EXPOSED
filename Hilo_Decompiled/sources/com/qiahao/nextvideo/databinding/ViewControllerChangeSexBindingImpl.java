package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerChangeSexBindingImpl extends ViewControllerChangeSexBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.description_text, 1);
        sparseIntArray.put(R.id.sex_radio_group, 2);
        sparseIntArray.put(R.id.boy_radio_button, 3);
        sparseIntArray.put(R.id.girl_radio_button, 4);
        sparseIntArray.put(2131362424, 5);
    }

    public ViewControllerChangeSexBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 6, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
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
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewControllerChangeSexBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatRadioButton) objArr[3], (AppCompatButton) objArr[5], (CardView) objArr[0], (AppCompatTextView) objArr[1], (AppCompatRadioButton) objArr[4], (RadioGroup) objArr[2]);
        this.mDirtyFlags = -1L;
        this.contentBg.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

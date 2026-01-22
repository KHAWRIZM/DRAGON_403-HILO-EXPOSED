package com.qiahao.base_common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DialogReportBindingImpl extends DialogReportBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.descriptionText, 1);
        sparseIntArray.put(R.id.reportTypesRadioGroup, 2);
        sparseIntArray.put(R.id.firstRadioButton, 3);
        sparseIntArray.put(R.id.secondRadioButton, 4);
        sparseIntArray.put(R.id.threeRadioButton, 5);
        sparseIntArray.put(R.id.fourRadioButton, 6);
        sparseIntArray.put(R.id.confirmReportButton, 7);
        sparseIntArray.put(R.id.cancelButton, 8);
    }

    public DialogReportBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 9, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
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

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i10, Object obj) {
        return true;
    }

    private DialogReportBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatButton) objArr[8], (AppCompatButton) objArr[7], (AppCompatTextView) objArr[1], (AppCompatRadioButton) objArr[3], (AppCompatRadioButton) objArr[6], (RadioGroup) objArr[2], (AppCompatRadioButton) objArr[4], (AppCompatRadioButton) objArr[5]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

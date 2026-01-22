package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerFillUserDataBindingImpl extends ViewControllerFillUserDataBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.name_edit_text, 1);
        sparseIntArray.put(R.id.name_edit_text_divide_view, 2);
        sparseIntArray.put(R.id.birthday_edit_button, 3);
        sparseIntArray.put(R.id.birthday_edit_button_divide_view, 4);
        sparseIntArray.put(R.id.select_country, 5);
        sparseIntArray.put(R.id.country_edit_button_divide_view, 6);
        sparseIntArray.put(R.id.sex_radio_group, 7);
        sparseIntArray.put(R.id.boy_radio_button, 8);
        sparseIntArray.put(R.id.girl_radio_button, 9);
        sparseIntArray.put(R.id.gender_title_container, 10);
        sparseIntArray.put(R.id.male_text_view, 11);
        sparseIntArray.put(R.id.female_text_view, 12);
        sparseIntArray.put(R.id.register_tips_text_view, 13);
        sparseIntArray.put(R.id.next_button, 14);
    }

    public ViewControllerFillUserDataBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 15, sIncludes, sViewsWithIds));
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

    private ViewControllerFillUserDataBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatButton) objArr[3], (View) objArr[4], (AppCompatRadioButton) objArr[8], (FrameLayout) objArr[0], (View) objArr[6], (AppCompatTextView) objArr[12], (LinearLayoutCompat) objArr[10], (AppCompatRadioButton) objArr[9], (AppCompatTextView) objArr[11], (AppCompatEditText) objArr[1], (View) objArr[2], (AppCompatButton) objArr[14], (AppCompatTextView) objArr[13], (AppCompatButton) objArr[5], (RadioGroup) objArr[7]);
        this.mDirtyFlags = -1L;
        this.container.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

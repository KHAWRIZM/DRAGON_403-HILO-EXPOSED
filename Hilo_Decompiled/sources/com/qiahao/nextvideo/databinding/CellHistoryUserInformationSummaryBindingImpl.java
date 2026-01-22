package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CellHistoryUserInformationSummaryBindingImpl extends CellHistoryUserInformationSummaryBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.user_profile_picture_cornered_image_view, 1);
        sparseIntArray.put(R.id.report_image_view, 2);
        sparseIntArray.put(R.id.nickname_text_view, 3);
        sparseIntArray.put(R.id.age_text_view, 4);
        sparseIntArray.put(R.id.vip_symbol_image_view, 5);
        sparseIntArray.put(R.id.country_province_text_view, 6);
        sparseIntArray.put(R.id.matching_time_text_view, 7);
        sparseIntArray.put(R.id.delete_image_view, 8);
        sparseIntArray.put(R.id.liked_image_button, 9);
        sparseIntArray.put(R.id.chat_image_button, 10);
        sparseIntArray.put(R.id.video_call_image_button, 11);
    }

    public CellHistoryUserInformationSummaryBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 12, sIncludes, sViewsWithIds));
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

    private CellHistoryUserInformationSummaryBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (GenderAgeTextView) objArr[4], (AppCompatImageButton) objArr[10], (AppCompatTextView) objArr[6], (AppCompatImageButton) objArr[8], (AppCompatImageButton) objArr[9], (AppCompatTextView) objArr[7], (AppCompatTextView) objArr[3], (AppCompatImageView) objArr[2], (CorneredImageView) objArr[1], (AppCompatImageButton) objArr[11], (AppCompatImageView) objArr[5]);
        this.mDirtyFlags = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

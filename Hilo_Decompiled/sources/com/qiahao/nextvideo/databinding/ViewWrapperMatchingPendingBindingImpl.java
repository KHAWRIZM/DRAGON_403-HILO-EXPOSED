package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.paired.MatchingActionPendingCountDownProgressBar;
import com.qiahao.nextvideo.ui.paired.view.LaunchVideoCallButton;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewWrapperMatchingPendingBindingImpl extends ViewWrapperMatchingPendingBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.connect_status_progress_bar, 1);
        sparseIntArray.put(R.id.circle_image_view, 2);
        sparseIntArray.put(R.id.connect_failed_svg_image_view, 3);
        sparseIntArray.put(2131363182, 4);
        sparseIntArray.put(R.id.nickname_text_view, 5);
        sparseIntArray.put(R.id.age_text_view, 6);
        sparseIntArray.put(R.id.country_flag_image_view, 7);
        sparseIntArray.put(R.id.country_province_text_view, 8);
        sparseIntArray.put(R.id.connect_result_view_container, 9);
        sparseIntArray.put(R.id.accept_invite_button, 10);
        sparseIntArray.put(R.id.refuse_invite_button, 11);
    }

    public ViewWrapperMatchingPendingBindingImpl(f fVar, View view) {
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

    private ViewWrapperMatchingPendingBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (LaunchVideoCallButton) objArr[10], (GenderAgeTextView) objArr[6], (CircleImageView) objArr[2], (SVGAImageView) objArr[3], (LinearLayoutCompat) objArr[9], (MatchingActionPendingCountDownProgressBar) objArr[1], (AppCompatImageView) objArr[7], (AppCompatTextView) objArr[8], (ImageView) objArr[4], (AppCompatTextView) objArr[5], (AppCompatButton) objArr[11]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

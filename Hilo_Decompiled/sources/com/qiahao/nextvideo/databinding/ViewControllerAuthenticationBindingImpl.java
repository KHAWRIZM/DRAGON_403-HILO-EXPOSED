package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.base_common.wedgit.videoView.LifecycleVideoView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewControllerAuthenticationBindingImpl extends ViewControllerAuthenticationBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.videoView, 1);
        sparseIntArray.put(R.id.logo_imageview, 2);
        sparseIntArray.put(R.id.muLogin, 3);
        sparseIntArray.put(R.id.relativeLayout, 4);
        sparseIntArray.put(R.id.login_by_facebook_button, 5);
        sparseIntArray.put(R.id.login_by_google_button, 6);
        sparseIntArray.put(R.id.orLayout, 7);
        sparseIntArray.put(R.id.loginPhone, 8);
        sparseIntArray.put(R.id.user_protocal_text_view, 9);
        sparseIntArray.put(R.id.version_text_view, 10);
        sparseIntArray.put(R.id.server_text_view, 11);
        sparseIntArray.put(R.id.bg_launch_image_view, 12);
    }

    public ViewControllerAuthenticationBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
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

    private ViewControllerAuthenticationBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatImageView) objArr[12], (FrameLayout) objArr[0], (FrameLayout) objArr[5], (FrameLayout) objArr[6], (ImageView) objArr[8], (AppCompatImageView) objArr[2], (Button) objArr[3], (LinearLayoutCompat) objArr[7], (RelativeLayout) objArr[4], (AppCompatTextView) objArr[11], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[10], (LifecycleVideoView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.commonIdCoordinateLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

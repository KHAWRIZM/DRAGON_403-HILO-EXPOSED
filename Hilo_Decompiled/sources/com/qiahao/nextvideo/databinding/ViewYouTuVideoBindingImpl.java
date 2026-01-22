package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.youtube.YouTuBeSeekBar;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewYouTuVideoBindingImpl extends ViewYouTuVideoBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.panel, 1);
        sparseIntArray.put(2131362433, 2);
        sparseIntArray.put(R.id.playPauseButton, 3);
        sparseIntArray.put(R.id.youTuBeIcon, 4);
        sparseIntArray.put(R.id.addVideoIcon, 5);
        sparseIntArray.put(R.id.videoList, 6);
        sparseIntArray.put(R.id.videoExit, 7);
        sparseIntArray.put(R.id.seekbar, 8);
        sparseIntArray.put(2131365189, 9);
        sparseIntArray.put(R.id.addVideo, 10);
        sparseIntArray.put(R.id.addGroup, 11);
    }

    public ViewYouTuVideoBindingImpl(f fVar, View view) {
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

    private ViewYouTuVideoBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (Group) objArr[11], (TextView) objArr[10], (ImageView) objArr[5], (ConstraintLayout) objArr[2], (View) objArr[1], (ImageView) objArr[3], (YouTuBeSeekBar) objArr[8], (TextView) objArr[9], (ImageView) objArr[7], (ImageView) objArr[6], (ImageView) objArr[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

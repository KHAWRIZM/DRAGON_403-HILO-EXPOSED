package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogMedalLevelBindingImpl extends DialogMedalLevelBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.bg_content, 1);
        sparseIntArray.put(R.id.big_svga, 2);
        sparseIntArray.put(R.id.big_pic, 3);
        sparseIntArray.put(R.id.level_text, 4);
        sparseIntArray.put(R.id.progress_bar, 5);
        sparseIntArray.put(R.id.progress_text, 6);
        sparseIntArray.put(R.id.min_text_view, 7);
        sparseIntArray.put(R.id.current_text_view, 8);
        sparseIntArray.put(R.id.max_text_view, 9);
        sparseIntArray.put(R.id.medal_recycler_view, 10);
        sparseIntArray.put(R.id.button_activity, 11);
        sparseIntArray.put(R.id.get_medal_svga, 12);
    }

    public DialogMedalLevelBindingImpl(f fVar, View view) {
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

    private DialogMedalLevelBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[1], (ImageView) objArr[3], (SVGAImageView) objArr[2], (TextView) objArr[11], (TextView) objArr[8], (FrameLayout) objArr[0], (SVGAImageView) objArr[12], (TextView) objArr[4], (TextView) objArr[9], (RecyclerView) objArr[10], (TextView) objArr[7], (ProgressBar) objArr[5], (ConstraintLayout) objArr[6]);
        this.mDirtyFlags = -1L;
        this.frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

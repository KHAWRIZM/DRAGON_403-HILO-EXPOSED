package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.sheep.SheepFightBtn;
import com.qiahao.nextvideo.view.RatioConstraintLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ActivityGameMatchLobbyBindingImpl extends ActivityGameMatchLobbyBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ImageView mboundView1;
    private final ImageView mboundView2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.red_views, 3);
        sparseIntArray.put(R.id.point_red, 4);
        sparseIntArray.put(R.id.avatar_red, 5);
        sparseIntArray.put(2131364958, 6);
        sparseIntArray.put(R.id.ready_red, 7);
        sparseIntArray.put(R.id.name_red, 8);
        sparseIntArray.put(R.id.blue_views, 9);
        sparseIntArray.put(R.id.point_blue, 10);
        sparseIntArray.put(R.id.avatar_blue, 11);
        sparseIntArray.put(R.id.name_blue, 12);
        sparseIntArray.put(R.id.icon_vs, 13);
        sparseIntArray.put(R.id.btn_fight, 14);
        sparseIntArray.put(R.id.back, 15);
    }

    public ActivityGameMatchLobbyBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j & 1) != 0) {
            HiloUtils.setImageMirror(this.mboundView1, R.drawable.game_sheep_match_red);
            HiloUtils.setImageMirror(this.mboundView2, R.drawable.game_sheep_match_blue);
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

    private ActivityGameMatchLobbyBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (QMUIRadiusImageView) objArr[11], (QMUIRadiusImageView) objArr[5], (ImageView) objArr[15], (RatioConstraintLayout) objArr[9], (SheepFightBtn) objArr[14], (ImageView) objArr[13], (TextView) objArr[12], (TextView) objArr[8], (View) objArr[10], (View) objArr[4], (ImageView) objArr[7], (RatioConstraintLayout) objArr[3], (SVGAImageView) objArr[6]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.mboundView1 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[2];
        this.mboundView2 = imageView2;
        imageView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

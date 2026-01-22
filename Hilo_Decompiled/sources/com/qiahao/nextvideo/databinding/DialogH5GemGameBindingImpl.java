package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogH5GemGameBindingImpl extends DialogH5GemGameBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topBg, 1);
        sparseIntArray.put(R.id.gameTitle, 2);
        sparseIntArray.put(R.id.moneyLayout, 3);
        sparseIntArray.put(R.id.diamond, 4);
        sparseIntArray.put(R.id.diamondText, 5);
        sparseIntArray.put(2131361922, 6);
        sparseIntArray.put(R.id.rankLayout, 7);
        sparseIntArray.put(R.id.rank, 8);
        sparseIntArray.put(2131362014, 9);
        sparseIntArray.put(2131362015, 10);
        sparseIntArray.put(R.id.avatar3, 11);
        sparseIntArray.put(2131364510, 12);
        sparseIntArray.put(R.id.activity, 13);
        sparseIntArray.put(2131362100, 14);
        sparseIntArray.put(R.id.webView, 15);
    }

    public DialogH5GemGameBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 16, sIncludes, sViewsWithIds));
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

    private DialogH5GemGameBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[13], (ImageView) objArr[6], (QMUIRadiusImageView) objArr[9], (QMUIRadiusImageView) objArr[10], (QMUIRadiusImageView) objArr[11], (View) objArr[14], (ImageView) objArr[4], (TextView) objArr[5], (TextView) objArr[2], (ConstraintLayout) objArr[3], (QMUIRadiusImageView) objArr[8], (LinearLayout) objArr[7], (RecyclerView) objArr[12], (View) objArr[1], (WebView) objArr[15]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

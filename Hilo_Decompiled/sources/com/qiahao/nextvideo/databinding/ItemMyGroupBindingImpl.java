package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ItemMyGroupBindingImpl extends ItemMyGroupBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.room_avatar, 1);
        sparseIntArray.put(R.id.roomSvga, 2);
        sparseIntArray.put(R.id.roomImageHead, 3);
        sparseIntArray.put(R.id.icon_count, 4);
        sparseIntArray.put(R.id.group_name, 5);
        sparseIntArray.put(R.id.ll_rocket, 6);
        sparseIntArray.put(R.id.rocket1, 7);
        sparseIntArray.put(R.id.rocket2, 8);
        sparseIntArray.put(R.id.rocket3, 9);
        sparseIntArray.put(R.id.rocket4, 10);
        sparseIntArray.put(R.id.rocket5, 11);
        sparseIntArray.put(R.id.user_avatar_list, 12);
        sparseIntArray.put(R.id.on_mic_number, 13);
        sparseIntArray.put(R.id.group_announce, 14);
        sparseIntArray.put(R.id.linearLayout2, 15);
        sparseIntArray.put(R.id.person_number, 16);
        sparseIntArray.put(2131362971, 17);
    }

    public ItemMyGroupBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 18, sIncludes, sViewsWithIds));
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

    private ItemMyGroupBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[17], (TextView) objArr[14], (TextView) objArr[5], (ImageView) objArr[4], (LinearLayout) objArr[15], (LinearLayout) objArr[6], (TextView) objArr[13], (TextView) objArr[16], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (ImageView) objArr[11], (RoundedImageView) objArr[1], (ImageView) objArr[3], (SVGAImageView) objArr[2], (LinearLayout) objArr[12]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) objArr[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

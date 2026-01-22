package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.opensource.svgaplayer.SVGAImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ChatGroupInputLayoutBindingImpl extends ChatGroupInputLayoutBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.chatClickInput, 1);
        sparseIntArray.put(R.id.inputImage, 2);
        sparseIntArray.put(R.id.inputText, 3);
        sparseIntArray.put(R.id.chatBtnInput, 4);
        sparseIntArray.put(R.id.faceBtn, 5);
        sparseIntArray.put(R.id.roomSoundBtn, 6);
        sparseIntArray.put(R.id.micBtn, 7);
        sparseIntArray.put(R.id.chatBtn, 8);
        sparseIntArray.put(R.id.chatImage, 9);
        sparseIntArray.put(R.id.has_message_red_doc, 10);
        sparseIntArray.put(R.id.toolBtn, 11);
        sparseIntArray.put(R.id.gameBtn, 12);
        sparseIntArray.put(R.id.giftBtn, 13);
    }

    public ChatGroupInputLayoutBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 14, sIncludes, sViewsWithIds));
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

    private ChatGroupInputLayoutBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (FrameLayout) objArr[8], (ImageView) objArr[4], (LinearLayout) objArr[1], (ImageView) objArr[9], (LinearLayout) objArr[0], (ImageView) objArr[5], (ImageView) objArr[12], (SVGAImageView) objArr[13], (View) objArr[10], (ImageView) objArr[2], (TextView) objArr[3], (ImageView) objArr[7], (ImageView) objArr[6], (ImageView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.contentBack.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

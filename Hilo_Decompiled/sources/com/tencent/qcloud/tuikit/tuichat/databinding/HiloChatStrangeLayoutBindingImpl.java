package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.hilo.StrangeInputView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloChatStrangeLayoutBindingImpl extends HiloChatStrangeLayoutBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.strangeLayout, 1);
        sparseIntArray.put(R.id.atmosphere, 2);
        sparseIntArray.put(R.id.line, 3);
        sparseIntArray.put(R.id.proressNumber, 4);
        sparseIntArray.put(R.id.processBg, 5);
        sparseIntArray.put(R.id.process, 6);
        sparseIntArray.put(R.id.image1, 7);
        sparseIntArray.put(R.id.image2, 8);
        sparseIntArray.put(R.id.image3, 9);
        sparseIntArray.put(R.id.image4, 10);
        sparseIntArray.put(R.id.chat_message_layout, 11);
        sparseIntArray.put(R.id.chat_input_layout, 12);
    }

    public HiloChatStrangeLayoutBindingImpl(f fVar, View view) {
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

    private HiloChatStrangeLayoutBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TextView) objArr[2], (StrangeInputView) objArr[12], (MessageRecyclerView) objArr[11], (ImageView) objArr[7], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[10], (View) objArr[3], (View) objArr[6], (View) objArr[5], (TextView) objArr[4], (ConstraintLayout) objArr[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

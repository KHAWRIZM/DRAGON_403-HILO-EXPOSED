package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloChatStrangeInputLayoutBindingImpl extends HiloChatStrangeInputLayoutBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.topLine, 1);
        sparseIntArray.put(R.id.more_btn, 2);
        sparseIntArray.put(R.id.chat_message_input, 3);
        sparseIntArray.put(R.id.chat_voice_input, 4);
        sparseIntArray.put(R.id.voice_input_switch, 5);
        sparseIntArray.put(R.id.send_btn, 6);
        sparseIntArray.put(R.id.image, 7);
        sparseIntArray.put(R.id.emoji, 8);
        sparseIntArray.put(R.id.game, 9);
        sparseIntArray.put(R.id.video, 10);
        sparseIntArray.put(R.id.gift, 11);
        sparseIntArray.put(R.id.more_groups, 12);
    }

    public HiloChatStrangeInputLayoutBindingImpl(f fVar, View view) {
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

    private HiloChatStrangeInputLayoutBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (TIMMentionEditText) objArr[3], (Button) objArr[4], (ImageView) objArr[8], (ImageView) objArr[9], (ImageView) objArr[11], (ImageView) objArr[7], (ImageView) objArr[2], (RelativeLayout) objArr[12], (ImageView) objArr[6], (View) objArr[1], (ImageView) objArr[10], (ImageView) objArr[5]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

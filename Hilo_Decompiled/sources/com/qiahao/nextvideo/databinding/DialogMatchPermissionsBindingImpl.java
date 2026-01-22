package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogMatchPermissionsBindingImpl extends DialogMatchPermissionsBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.description_text, 1);
        sparseIntArray.put(R.id.camera_frame_layout, 2);
        sparseIntArray.put(R.id.camera_go_to_settings_text_view, 3);
        sparseIntArray.put(R.id.microphone_frame_layout, 4);
        sparseIntArray.put(R.id.microphone_go_to_settings_text_view, 5);
        sparseIntArray.put(R.id.allow_button, 6);
    }

    public DialogMatchPermissionsBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 7, sIncludes, sViewsWithIds));
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

    private DialogMatchPermissionsBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (AppCompatButton) objArr[6], (LinearLayoutCompat) objArr[0], (FrameLayout) objArr[2], (AppCompatTextView) objArr[3], (AppCompatTextView) objArr[1], (FrameLayout) objArr[4], (AppCompatTextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.bgRoot.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.tencent.qcloud.tuicore.component.UnreadCountTextView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MaxWidthFrameLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MaxWidthLinearLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HiloMessageAdapterItemContentBindingImpl extends HiloMessageAdapterItemContentBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.message_top_time_tv, 1);
        sparseIntArray.put(R.id.select_checkbox, 2);
        sparseIntArray.put(R.id.right_group_layout, 3);
        sparseIntArray.put(R.id.left_user_icon_view, 4);
        sparseIntArray.put(R.id.right_user_icon_view, 5);
        sparseIntArray.put(R.id.user_name_tv, 6);
        sparseIntArray.put(R.id.msg_detail_time_tv, 7);
        sparseIntArray.put(R.id.msg_content_ll, 8);
        sparseIntArray.put(R.id.audio_unread, 9);
        sparseIntArray.put(R.id.message_sending_pb, 10);
        sparseIntArray.put(R.id.is_read_tv, 11);
        sparseIntArray.put(R.id.message_status_iv, 12);
        sparseIntArray.put(R.id.msg_area_and_reply, 13);
        sparseIntArray.put(R.id.msg_area, 14);
        sparseIntArray.put(R.id.msg_content_fl, 15);
        sparseIntArray.put(R.id.reacts_view, 16);
        sparseIntArray.put(R.id.translate_content_fl, 17);
        sparseIntArray.put(R.id.quote_content_fl, 18);
        sparseIntArray.put(R.id.msg_reply_detail_fl, 19);
        sparseIntArray.put(R.id.reply_num, 20);
    }

    public HiloMessageAdapterItemContentBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 21, sIncludes, sViewsWithIds));
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

    private HiloMessageAdapterItemContentBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (UnreadCountTextView) objArr[9], (TextView) objArr[11], (UserIconView) objArr[4], (RelativeLayout) objArr[0], (ProgressBar) objArr[10], (ImageView) objArr[12], (TextView) objArr[1], (MaxWidthLinearLayout) objArr[14], (LinearLayout) objArr[13], (MaxWidthFrameLayout) objArr[15], (LinearLayout) objArr[8], (TextView) objArr[7], (LinearLayout) objArr[19], (MaxWidthFrameLayout) objArr[18], (ChatFlowReactView) objArr[16], (TextView) objArr[20], (RelativeLayout) objArr[3], (UserIconView) objArr[5], (CheckBox) objArr[2], (MaxWidthFrameLayout) objArr[17], (TextView) objArr[6]);
        this.mDirtyFlags = -1L;
        this.messageContentLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}

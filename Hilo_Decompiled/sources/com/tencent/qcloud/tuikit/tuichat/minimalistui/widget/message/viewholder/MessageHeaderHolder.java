package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MessageHeaderHolder extends MessageBaseHolder {
    private boolean mLoading;

    public MessageHeaderHolder(View view) {
        super(view);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(TUIMessageBean tUIMessageBean, int i) {
        RecyclerView.LayoutParams layoutParams = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (this.mLoading) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
            ((RecyclerView.ViewHolder) this).itemView.setVisibility(0);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
            ((RecyclerView.ViewHolder) this).itemView.setVisibility(8);
        }
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(layoutParams);
    }

    public void setLoadingStatus(boolean z) {
        this.mLoading = z;
        layoutViews(null, 0);
    }
}

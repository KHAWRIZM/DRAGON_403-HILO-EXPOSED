package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuicore.component.UnreadCountTextView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MaxWidthFrameLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MaxWidthLinearLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.ChatFlowReactView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageAdapterItemContentBinding extends ViewDataBinding {
    public final UnreadCountTextView audioUnread;
    public final TextView isReadTv;
    public final UserIconView leftUserIconView;
    public final RelativeLayout messageContentLayout;
    public final ProgressBar messageSendingPb;
    public final ImageView messageStatusIv;
    public final TextView messageTopTimeTv;
    public final MaxWidthLinearLayout msgArea;
    public final LinearLayout msgAreaAndReply;
    public final MaxWidthFrameLayout msgContentFl;
    public final LinearLayout msgContentLl;
    public final TextView msgDetailTimeTv;
    public final LinearLayout msgReplyDetailFl;
    public final MaxWidthFrameLayout quoteContentFl;
    public final ChatFlowReactView reactsView;
    public final TextView replyNum;
    public final RelativeLayout rightGroupLayout;
    public final UserIconView rightUserIconView;
    public final CheckBox selectCheckbox;
    public final MaxWidthFrameLayout translateContentFl;
    public final TextView userNameTv;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageAdapterItemContentBinding(Object obj, View view, int i, UnreadCountTextView unreadCountTextView, TextView textView, UserIconView userIconView, RelativeLayout relativeLayout, ProgressBar progressBar, ImageView imageView, TextView textView2, MaxWidthLinearLayout maxWidthLinearLayout, LinearLayout linearLayout, MaxWidthFrameLayout maxWidthFrameLayout, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, MaxWidthFrameLayout maxWidthFrameLayout2, ChatFlowReactView chatFlowReactView, TextView textView4, RelativeLayout relativeLayout2, UserIconView userIconView2, CheckBox checkBox, MaxWidthFrameLayout maxWidthFrameLayout3, TextView textView5) {
        super(obj, view, i);
        this.audioUnread = unreadCountTextView;
        this.isReadTv = textView;
        this.leftUserIconView = userIconView;
        this.messageContentLayout = relativeLayout;
        this.messageSendingPb = progressBar;
        this.messageStatusIv = imageView;
        this.messageTopTimeTv = textView2;
        this.msgArea = maxWidthLinearLayout;
        this.msgAreaAndReply = linearLayout;
        this.msgContentFl = maxWidthFrameLayout;
        this.msgContentLl = linearLayout2;
        this.msgDetailTimeTv = textView3;
        this.msgReplyDetailFl = linearLayout3;
        this.quoteContentFl = maxWidthFrameLayout2;
        this.reactsView = chatFlowReactView;
        this.replyNum = textView4;
        this.rightGroupLayout = relativeLayout2;
        this.rightUserIconView = userIconView2;
        this.selectCheckbox = checkBox;
        this.translateContentFl = maxWidthFrameLayout3;
        this.userNameTv = textView5;
    }

    public static HiloMessageAdapterItemContentBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageAdapterItemContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageAdapterItemContentBinding bind(View view, Object obj) {
        return (HiloMessageAdapterItemContentBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_adapter_item_content);
    }

    @Deprecated
    public static HiloMessageAdapterItemContentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageAdapterItemContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_adapter_item_content, viewGroup, z, obj);
    }

    public static HiloMessageAdapterItemContentBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageAdapterItemContentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageAdapterItemContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_adapter_item_content, (ViewGroup) null, false, obj);
    }
}

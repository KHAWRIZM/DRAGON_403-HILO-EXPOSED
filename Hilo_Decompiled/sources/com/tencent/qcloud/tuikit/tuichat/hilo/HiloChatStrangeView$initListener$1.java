package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.component.dialog.TUIKitDialog;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/tencent/qcloud/tuikit/tuichat/hilo/HiloChatStrangeView$initListener$1", "Lcom/tencent/qcloud/tuikit/tuichat/classicui/widget/message/MessageRecyclerView$OnPopActionClickListener;", "onCopyClick", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "onSendMessageClick", "retry", "", "onDeleteMessageClick", "onRevokeMessageClick", "onMultiSelectMessageClick", "onForwardMessageClick", "onReplyMessageClick", "onQuoteMessageClick", "onTranslateMessageClick", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class HiloChatStrangeView$initListener$1 implements MessageRecyclerView.OnPopActionClickListener {
    final /* synthetic */ HiloChatStrangeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HiloChatStrangeView$initListener$1(HiloChatStrangeView hiloChatStrangeView) {
        this.this$0 = hiloChatStrangeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDeleteMessageClick$lambda$1(View view) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onCopyClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Object systemService = this.this$0.getContext().getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        String selectText = msg.getSelectText();
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(Constants.SHARED_MESSAGE_ID_FILE, selectText));
        if (!TextUtils.isEmpty(selectText)) {
            String string = this.this$0.getResources().getString(R.string.copy_success_tip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastUtil.toastShortMessage(string);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onDeleteMessageClick(final TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        TUIKitDialog dialogWidth = new TUIKitDialog(this.this$0.getContext()).builder().setCancelable(true).setCancelOutside(true).setTitle(this.this$0.getContext().getString(R.string.chat_delete_msg_tip)).setDialogWidth(0.75f);
        String string = this.this$0.getContext().getString(com.tencent.qcloud.tuicore.R.string.sure);
        final HiloChatStrangeView hiloChatStrangeView = this.this$0;
        dialogWidth.setPositiveButton(string, new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HiloChatStrangeView.this.deleteMessage(msg);
            }
        }).setNegativeButton(this.this$0.getContext().getString(com.tencent.qcloud.tuicore.R.string.cancel), new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HiloChatStrangeView$initListener$1.onDeleteMessageClick$lambda$1(view);
            }
        }).show();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onForwardMessageClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onMultiSelectMessageClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.this$0.multiSelectMessage(msg);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onQuoteMessageClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.this$0.quoteMessage(msg);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onReplyMessageClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.this$0.replyMessage(msg);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onRevokeMessageClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.this$0.revokeMessage(msg);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onSendMessageClick(TUIMessageBean msg, boolean retry) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.this$0.sendMessage(msg, retry);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView.OnPopActionClickListener
    public void onTranslateMessageClick(TUIMessageBean msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.this$0.translateMessage(msg);
    }
}

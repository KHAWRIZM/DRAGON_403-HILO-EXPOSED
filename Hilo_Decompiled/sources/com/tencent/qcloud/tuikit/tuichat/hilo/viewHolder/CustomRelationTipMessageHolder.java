package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationTipBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationTipMessageBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationTipMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageRelationTipBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomRelationTipMessageHolder extends MessageEmptyBaseHolder<HiloMessageRelationTipBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRelationTipMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        HiloMessageRelationTipBinding binding;
        TextView textView;
        String str;
        super.layoutViews(msg, position);
        if ((msg instanceof RelationTipMessageBean) && (binding = getBinding()) != null && (textView = binding.content) != null) {
            RelationMessageData messageData = ((RelationTipMessageBean) msg).getMessageData();
            if (messageData != null) {
                str = messageData.getMsg();
            } else {
                str = null;
            }
            textView.setText(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageRelationTipBinding inflateViewBinding() {
        HiloMessageRelationTipBinding inflate = HiloMessageRelationTipBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.strange;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.ShapeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageCommonTextBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.strange.StrangeGiftTimeOutMessageBean;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/strange/StrangeCommonTextMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageCommonTextBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class StrangeCommonTextMessageHolder extends MessageEmptyBaseHolder<HiloMessageCommonTextBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangeCommonTextMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        HiloMessageCommonTextBinding binding;
        TextView textView7;
        super.layoutViews(msg, position);
        if ((msg instanceof StrangeGiftTimeOutMessageBean) && (binding = getBinding()) != null && (textView7 = binding.messageContainer) != null) {
            textView7.setText(((StrangeGiftTimeOutMessageBean) msg).getContent());
        }
        if (checkStrange()) {
            HiloMessageCommonTextBinding binding2 = getBinding();
            if (binding2 != null && (textView6 = binding2.messageContainer) != null) {
                textView6.setBackground(ShapeUtil.INSTANCE.createShape("#2B2839", "#2B2839", 11, GradientDrawable.Orientation.LEFT_RIGHT));
            }
            HiloMessageCommonTextBinding binding3 = getBinding();
            if (binding3 != null && (textView5 = binding3.messageContainer) != null) {
                textView5.setPadding(18, 2, 18, 4);
            }
            HiloMessageCommonTextBinding binding4 = getBinding();
            if (binding4 != null && (textView4 = binding4.messageContainer) != null) {
                textView4.setTextColor(a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.configColor80White));
                return;
            }
            return;
        }
        HiloMessageCommonTextBinding binding5 = getBinding();
        if (binding5 != null && (textView3 = binding5.messageContainer) != null) {
            textView3.setTextColor(a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_666666));
        }
        HiloMessageCommonTextBinding binding6 = getBinding();
        if (binding6 != null && (textView2 = binding6.messageContainer) != null) {
            textView2.setBackground(null);
        }
        HiloMessageCommonTextBinding binding7 = getBinding();
        if (binding7 != null && (textView = binding7.messageContainer) != null) {
            textView.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageCommonTextBinding inflateViewBinding() {
        HiloMessageCommonTextBinding inflate = HiloMessageCommonTextBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

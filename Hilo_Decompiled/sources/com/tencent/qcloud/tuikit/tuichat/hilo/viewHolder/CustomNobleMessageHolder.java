package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.im.SendNobleMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageNobleBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.NobleMessageBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomNobleMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/HiloMessageContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageNobleBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutVariableViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomNobleMessageHolder extends HiloMessageContentHolder<HiloMessageNobleBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomNobleMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(@Nullable TUIMessageBean msg, int position) {
        ImageView imageView;
        Integer nobleLevel;
        AppCompatTextView appCompatTextView;
        int i = 0;
        if (msg instanceof NobleMessageBean) {
            HiloMessageNobleBinding binding = getBinding();
            if (binding != null && (appCompatTextView = binding.subtitleTextView) != null) {
                String stringById = ResourcesKtxKt.getStringById(this, R.string.some_one_send_nobility);
                String nickName = ((NobleMessageBean) msg).getNickName();
                if (nickName == null) {
                    nickName = "";
                }
                String format = String.format(stringById, Arrays.copyOf(new Object[]{nickName}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                appCompatTextView.setText(format);
            }
            HiloMessageNobleBinding binding2 = getBinding();
            if (binding2 != null && (imageView = binding2.imagView) != null) {
                Context context = ((RecyclerView.ViewHolder) this).itemView.getContext();
                BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                SendNobleMessage messageData = ((NobleMessageBean) msg).getMessageData();
                if (messageData != null && (nobleLevel = messageData.getNobleLevel()) != null) {
                    i = nobleLevel.intValue();
                }
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, baseControlUtils.getNobleDrawableRes(i)));
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.HiloMessageContentHolder
    @NotNull
    public HiloMessageNobleBinding inflateViewBinding() {
        HiloMessageNobleBinding inflate = HiloMessageNobleBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.C2CEvent;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationExitBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationUnbindMessageBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationExitMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageRelationExitBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomRelationExitMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomRelationExitMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationExitMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,36:1\n61#2,9:37\n*S KotlinDebug\n*F\n+ 1 CustomRelationExitMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationExitMessageHolder\n*L\n29#1:37,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomRelationExitMessageHolder extends MessageEmptyBaseHolder<HiloMessageRelationExitBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRelationExitMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        UserIconView userIconView;
        UserIconView userIconView2;
        final TextView textView;
        TextView textView2;
        String tip;
        TextView textView3;
        String str;
        super.layoutViews(msg, position);
        if (msg instanceof RelationUnbindMessageBean) {
            HiloMessageRelationExitBinding binding = getBinding();
            LinearLayout linearLayout = null;
            if (binding != null) {
                userIconView = binding.leftUserIconView;
            } else {
                userIconView = null;
            }
            HiloMessageRelationExitBinding binding2 = getBinding();
            if (binding2 != null) {
                userIconView2 = binding2.rightUserIconView;
            } else {
                userIconView2 = null;
            }
            HiloMessageRelationExitBinding binding3 = getBinding();
            if (binding3 != null) {
                linearLayout = binding3.msgContentLl;
            }
            setUserAvatar(msg, userIconView, userIconView2, linearLayout);
            HiloMessageRelationExitBinding binding4 = getBinding();
            String str2 = "";
            if (binding4 != null && (textView3 = binding4.title) != null) {
                RelationMessageData messageData = ((RelationUnbindMessageBean) msg).getMessageData();
                if (messageData == null || (str = messageData.getMsg()) == null) {
                    str = "";
                }
                textView3.setText(str);
            }
            HiloMessageRelationExitBinding binding5 = getBinding();
            if (binding5 != null && (textView2 = binding5.subTitle) != null) {
                RelationMessageData messageData2 = ((RelationUnbindMessageBean) msg).getMessageData();
                if (messageData2 != null && (tip = messageData2.getTip()) != null) {
                    str2 = tip;
                }
                textView2.setText(str2);
            }
            HiloMessageRelationExitBinding binding6 = getBinding();
            if (binding6 != null && (textView = binding6.exit) != null) {
                final long j = 800;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomRelationExitMessageHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                            cf.c.c().l(new C2CEvent("relation_invite_or_cancel", ((RelationUnbindMessageBean) msg).getMessageData()));
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageRelationExitBinding inflateViewBinding() {
        HiloMessageRelationExitBinding inflate = HiloMessageRelationExitBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

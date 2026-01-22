package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.C2CEvent;
import com.qiahao.base_common.model.im.RelationMessageData;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationSuccessBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.RelationSuccessMessageBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationSuccessMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageRelationSuccessBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomRelationSuccessMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomRelationSuccessMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationSuccessMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,40:1\n61#2,9:41\n*S KotlinDebug\n*F\n+ 1 CustomRelationSuccessMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomRelationSuccessMessageHolder\n*L\n34#1:41,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomRelationSuccessMessageHolder extends MessageEmptyBaseHolder<HiloMessageRelationSuccessBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRelationSuccessMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        UserIconView userIconView;
        UserIconView userIconView2;
        CustomRelationSuccessMessageHolder customRelationSuccessMessageHolder;
        LinearLayout linearLayout;
        final TextView textView;
        QMUIRadiusImageView qMUIRadiusImageView;
        User receiver;
        QMUIRadiusImageView qMUIRadiusImageView2;
        String str;
        User sender;
        TextView textView2;
        String tip;
        TextView textView3;
        String str2;
        super.layoutViews(msg, position);
        if (msg instanceof RelationSuccessMessageBean) {
            HiloMessageRelationSuccessBinding binding = getBinding();
            String str3 = null;
            if (binding != null) {
                userIconView = binding.leftUserIconView;
            } else {
                userIconView = null;
            }
            HiloMessageRelationSuccessBinding binding2 = getBinding();
            if (binding2 != null) {
                userIconView2 = binding2.rightUserIconView;
            } else {
                userIconView2 = null;
            }
            HiloMessageRelationSuccessBinding binding3 = getBinding();
            if (binding3 != null) {
                linearLayout = binding3.msgContentLl;
                customRelationSuccessMessageHolder = this;
            } else {
                customRelationSuccessMessageHolder = this;
                linearLayout = null;
            }
            customRelationSuccessMessageHolder.setUserAvatar(msg, userIconView, userIconView2, linearLayout);
            HiloMessageRelationSuccessBinding binding4 = getBinding();
            String str4 = "";
            if (binding4 != null && (textView3 = binding4.title) != null) {
                RelationMessageData messageData = ((RelationSuccessMessageBean) msg).getMessageData();
                if (messageData == null || (str2 = messageData.getMsg()) == null) {
                    str2 = "";
                }
                textView3.setText(str2);
            }
            HiloMessageRelationSuccessBinding binding5 = getBinding();
            if (binding5 != null && (textView2 = binding5.subTitle) != null) {
                RelationMessageData messageData2 = ((RelationSuccessMessageBean) msg).getMessageData();
                if (messageData2 != null && (tip = messageData2.getTip()) != null) {
                    str4 = tip;
                }
                textView2.setText(str4);
            }
            HiloMessageRelationSuccessBinding binding6 = getBinding();
            if (binding6 != null && (qMUIRadiusImageView2 = binding6.avatar1) != null) {
                RelationMessageData messageData3 = ((RelationSuccessMessageBean) msg).getMessageData();
                if (messageData3 != null && (sender = messageData3.getSender()) != null) {
                    str = sender.getAvatar();
                } else {
                    str = null;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.default_user_icon), (c5.g) null, 49150, (Object) null);
            }
            HiloMessageRelationSuccessBinding binding7 = getBinding();
            if (binding7 != null && (qMUIRadiusImageView = binding7.avatar2) != null) {
                RelationMessageData messageData4 = ((RelationSuccessMessageBean) msg).getMessageData();
                if (messageData4 != null && (receiver = messageData4.getReceiver()) != null) {
                    str3 = receiver.getAvatar();
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.default_user_icon), (c5.g) null, 49150, (Object) null);
            }
            HiloMessageRelationSuccessBinding binding8 = getBinding();
            if (binding8 != null && (textView = binding8.goZone) != null) {
                final long j = 800;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomRelationSuccessMessageHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                            cf.c.c().l(new C2CEvent("relation_success", ((RelationSuccessMessageBean) msg).getMessageData()));
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageRelationSuccessBinding inflateViewBinding() {
        HiloMessageRelationSuccessBinding inflate = HiloMessageRelationSuccessBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.SheepMatchMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageSheepInviteBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.SheepInviteMessageBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomSheepInviteMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageSheepInviteBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomSheepInviteMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomSheepInviteMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomSheepInviteMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,40:1\n61#2,9:41\n*S KotlinDebug\n*F\n+ 1 CustomSheepInviteMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomSheepInviteMessageHolder\n*L\n29#1:41,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomSheepInviteMessageHolder extends MessageEmptyBaseHolder<HiloMessageSheepInviteBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomSheepInviteMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean layoutViews$lambda$1(CustomSheepInviteMessageHolder customSheepInviteMessageHolder, TUIMessageBean tUIMessageBean, int i, View view) {
        customSheepInviteMessageHolder.showDialog(tUIMessageBean, i, view, false, true, tUIMessageBean.isSelf());
        return false;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@NotNull final TUIMessageBean msg, final int position) {
        QMUIRadiusImageView qMUIRadiusImageView;
        UserIconView userIconView;
        UserIconView userIconView2;
        LinearLayout linearLayout;
        final View root;
        QMUIRadiusImageView qMUIRadiusImageView2;
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.layoutViews(msg, position);
        if (msg instanceof SheepInviteMessageBean) {
            HiloMessageSheepInviteBinding binding = getBinding();
            String str = null;
            if (binding != null) {
                userIconView = binding.leftUserIconView;
            } else {
                userIconView = null;
            }
            HiloMessageSheepInviteBinding binding2 = getBinding();
            if (binding2 != null) {
                userIconView2 = binding2.rightUserIconView;
            } else {
                userIconView2 = null;
            }
            HiloMessageSheepInviteBinding binding3 = getBinding();
            if (binding3 != null) {
                linearLayout = binding3.msgContentLl;
            } else {
                linearLayout = null;
            }
            setUserAvatar(msg, userIconView, userIconView2, linearLayout);
            HiloMessageSheepInviteBinding binding4 = getBinding();
            if (binding4 != null && (qMUIRadiusImageView2 = binding4.image) != null) {
                SheepMatchMessage messageData = ((SheepInviteMessageBean) msg).getMessageData();
                if (messageData != null) {
                    str = messageData.getCoverUrl();
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            HiloMessageSheepInviteBinding binding5 = getBinding();
            if (binding5 != null && (root = binding5.getRoot()) != null) {
                final long j = 800;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomSheepInviteMessageHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i;
                        Integer gameId;
                        Integer matchId;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            SheepMatchMessage messageData2 = ((SheepInviteMessageBean) msg).getMessageData();
                            int i2 = 0;
                            if (messageData2 != null && (matchId = messageData2.getMatchId()) != null) {
                                i = matchId.intValue();
                            } else {
                                i = 0;
                            }
                            SheepMatchMessage messageData3 = ((SheepInviteMessageBean) msg).getMessageData();
                            if (messageData3 != null && (gameId = messageData3.getGameId()) != null) {
                                i2 = gameId.intValue();
                            }
                            baseControlUtils.openSheep(i, i2);
                        }
                    }
                });
            }
        }
        HiloMessageSheepInviteBinding binding6 = getBinding();
        if (binding6 != null && (qMUIRadiusImageView = binding6.image) != null) {
            qMUIRadiusImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean layoutViews$lambda$1;
                    layoutViews$lambda$1 = CustomSheepInviteMessageHolder.layoutViews$lambda$1(CustomSheepInviteMessageHolder.this, msg, position, view);
                    return layoutViews$lambda$1;
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageSheepInviteBinding inflateViewBinding() {
        HiloMessageSheepInviteBinding inflate = HiloMessageSheepInviteBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

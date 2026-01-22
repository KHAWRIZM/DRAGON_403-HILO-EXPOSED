package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomJoinUserBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomKickBean;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomKickHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomJoinUserBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomKickHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomKickHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomKickHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,68:1\n61#2,9:69\n61#2,9:78\n*S KotlinDebug\n*F\n+ 1 RoomKickHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomKickHolder\n*L\n61#1:69,9\n64#1:78,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomKickHolder extends RoomEmptyBaseHolder<HiloRoomJoinUserBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomKickHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        String str;
        TextView textView;
        String str2;
        String str3;
        String operatorNick;
        String nick;
        final QMUIRadiusImageView qMUIRadiusImageView;
        final QMUIRadiusImageView qMUIRadiusImageView2;
        QMUIRadiusImageView qMUIRadiusImageView3;
        QMUIRadiusImageView qMUIRadiusImageView4;
        TextView textView2;
        String str4;
        String str5;
        String operatorNick2;
        String nick2;
        QMUIRadiusImageView qMUIRadiusImageView5;
        String str6;
        TextView textView3;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomKickBean)) {
            return;
        }
        HiloRoomJoinUserBinding binding = getBinding();
        if (binding != null && (textView3 = binding.userJoinContent) != null) {
            Dimens dimens = Dimens.INSTANCE;
            textView3.setMaxWidth(((dimens.getScreenWidth() - dimens.dpToPx(54)) - dimens.dpToPx(10)) - dimens.dpToPx(50));
        }
        HiloRoomJoinUserBinding binding2 = getBinding();
        String str7 = null;
        if (binding2 != null && (qMUIRadiusImageView5 = binding2.userAvatar) != null) {
            GroupRoomImCustomBean data = ((RoomKickBean) msg).getData();
            if (data != null) {
                str6 = data.getAvatar();
            } else {
                str6 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView5, ImageSizeKt.image100(str6), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.ic_user_place_avatar), (c5.g) null, 49150, (Object) null);
        }
        RoomKickBean roomKickBean = (RoomKickBean) msg;
        GroupRoomImCustomBean data2 = roomKickBean.getData();
        if (data2 != null) {
            str = data2.getType();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, MessageService.MSG_DB_NOTIFY_CLICK)) {
            HiloRoomJoinUserBinding binding3 = getBinding();
            if (binding3 != null && (textView2 = binding3.userJoinContent) != null) {
                String stringById = ResourcesKtxKt.getStringById(this, R.string.kicked_out_group);
                GroupRoomImCustomBean data3 = roomKickBean.getData();
                if (data3 != null && (nick2 = data3.getNick()) != null) {
                    str4 = AppUtilitiesKt.changeNickNameSizeInSixInclude(nick2);
                } else {
                    str4 = null;
                }
                GroupRoomImCustomBean data4 = roomKickBean.getData();
                if (data4 != null && (operatorNick2 = data4.getOperatorNick()) != null) {
                    str5 = AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick2);
                } else {
                    str5 = null;
                }
                String format = String.format(stringById, Arrays.copyOf(new Object[]{str4, str5}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView2.setText(format);
            }
        } else {
            HiloRoomJoinUserBinding binding4 = getBinding();
            if (binding4 != null && (textView = binding4.userJoinContent) != null) {
                String stringById2 = ResourcesKtxKt.getStringById(this, R.string.group_blocked_by);
                GroupRoomImCustomBean data5 = roomKickBean.getData();
                if (data5 != null && (nick = data5.getNick()) != null) {
                    str2 = AppUtilitiesKt.changeNickNameSizeInSixInclude(nick);
                } else {
                    str2 = null;
                }
                GroupRoomImCustomBean data6 = roomKickBean.getData();
                if (data6 != null && (operatorNick = data6.getOperatorNick()) != null) {
                    str3 = AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick);
                } else {
                    str3 = null;
                }
                String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str2, str3}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView.setText(format2);
            }
        }
        HiloRoomJoinUserBinding binding5 = getBinding();
        if (binding5 != null && (qMUIRadiusImageView4 = binding5.otherUserAvatar) != null) {
            qMUIRadiusImageView4.setVisibility(0);
        }
        HiloRoomJoinUserBinding binding6 = getBinding();
        if (binding6 != null && (qMUIRadiusImageView3 = binding6.otherUserAvatar) != null) {
            GroupRoomImCustomBean data7 = roomKickBean.getData();
            if (data7 != null) {
                str7 = data7.getOperatorAvatar();
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(str7), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.ic_user_place_avatar), (c5.g) null, 49150, (Object) null);
        }
        HiloRoomJoinUserBinding binding7 = getBinding();
        final long j = 800;
        if (binding7 != null && (qMUIRadiusImageView2 = binding7.otherUserAvatar) != null) {
            qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomKickHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str8;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                        QMUIRadiusImageView qMUIRadiusImageView6 = qMUIRadiusImageView2;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        GroupRoomImCustomBean data8 = ((RoomKickBean) msg).getData();
                        if (data8 == null || (str8 = data8.getOperatorExternalId()) == null) {
                            str8 = "";
                        }
                        baseControlUtils.roomOpenUserInfo(str8);
                    }
                }
            });
        }
        HiloRoomJoinUserBinding binding8 = getBinding();
        if (binding8 != null && (qMUIRadiusImageView = binding8.userAvatar) != null) {
            qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomKickHolder$layoutViews$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str8;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                        QMUIRadiusImageView qMUIRadiusImageView6 = qMUIRadiusImageView;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        GroupRoomImCustomBean data8 = ((RoomKickBean) msg).getData();
                        if (data8 == null || (str8 = data8.getExternalId()) == null) {
                            str8 = "";
                        }
                        baseControlUtils.roomOpenUserInfo(str8);
                    }
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder
    @NotNull
    public HiloRoomJoinUserBinding inflateViewBinding() {
        HiloRoomJoinUserBinding inflate = HiloRoomJoinUserBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

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
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomAppointedBean;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomAppointedHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomJoinUserBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomAppointedHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomAppointedHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomAppointedHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,85:1\n61#2,9:86\n61#2,9:95\n*S KotlinDebug\n*F\n+ 1 RoomAppointedHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomAppointedHolder\n*L\n78#1:86,9\n81#1:95,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomAppointedHolder extends RoomEmptyBaseHolder<HiloRoomJoinUserBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomAppointedHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        TextView textView;
        String operatorNick;
        String nick;
        Integer role;
        TextView textView2;
        String operatorNick2;
        String nick2;
        final QMUIRadiusImageView qMUIRadiusImageView;
        final QMUIRadiusImageView qMUIRadiusImageView2;
        QMUIRadiusImageView qMUIRadiusImageView3;
        QMUIRadiusImageView qMUIRadiusImageView4;
        QMUIRadiusImageView qMUIRadiusImageView5;
        TextView textView3;
        String operatorNick3;
        String nick3;
        Integer role2;
        TextView textView4;
        String operatorNick4;
        String nick4;
        QMUIRadiusImageView qMUIRadiusImageView6;
        TextView textView5;
        super.layoutViews(msg, position);
        if (msg instanceof RoomAppointedBean) {
            HiloRoomJoinUserBinding binding = getBinding();
            if (binding != null && (textView5 = binding.userJoinContent) != null) {
                Dimens dimens = Dimens.INSTANCE;
                textView5.setMaxWidth((((dimens.getScreenWidth() - dimens.dpToPx(54)) - dimens.dpToPx(10)) - dimens.dpToPx(50)) - dimens.dpToPx(50));
            }
            HiloRoomJoinUserBinding binding2 = getBinding();
            if (binding2 != null && (qMUIRadiusImageView6 = binding2.userAvatar) != null) {
                GroupRoomImCustomBean data = ((RoomAppointedBean) msg).getData();
                ImageKtxKt.loadImage$default(qMUIRadiusImageView6, ImageSizeKt.image100(data != null ? data.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.ic_user_place_avatar), (c5.g) null, 49150, (Object) null);
            }
            RoomAppointedBean roomAppointedBean = (RoomAppointedBean) msg;
            GroupRoomImCustomBean data2 = roomAppointedBean.getData();
            if (Intrinsics.areEqual(data2 != null ? data2.getType() : null, MessageService.MSG_ACCS_READY_REPORT)) {
                GroupRoomImCustomBean data3 = roomAppointedBean.getData();
                if (data3 != null && (role2 = data3.getRole()) != null && role2.intValue() == 10) {
                    HiloRoomJoinUserBinding binding3 = getBinding();
                    if (binding3 != null && (textView4 = binding3.userJoinContent) != null) {
                        String stringById = ResourcesKtxKt.getStringById(this, R.string.group_appointed_admin_by);
                        GroupRoomImCustomBean data4 = roomAppointedBean.getData();
                        String changeNickNameSizeInSixInclude = (data4 == null || (nick4 = data4.getNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(nick4);
                        GroupRoomImCustomBean data5 = roomAppointedBean.getData();
                        String format = String.format(stringById, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude, (data5 == null || (operatorNick4 = data5.getOperatorNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick4)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        textView4.setText(format);
                    }
                } else {
                    HiloRoomJoinUserBinding binding4 = getBinding();
                    if (binding4 != null && (textView3 = binding4.userJoinContent) != null) {
                        String stringById2 = ResourcesKtxKt.getStringById(this, R.string.appointed_as_manager);
                        GroupRoomImCustomBean data6 = roomAppointedBean.getData();
                        String changeNickNameSizeInSixInclude2 = (data6 == null || (nick3 = data6.getNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(nick3);
                        GroupRoomImCustomBean data7 = roomAppointedBean.getData();
                        String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude2, (data7 == null || (operatorNick3 = data7.getOperatorNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick3)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                        textView3.setText(format2);
                    }
                }
            } else {
                GroupRoomImCustomBean data8 = roomAppointedBean.getData();
                if (data8 != null && (role = data8.getRole()) != null && role.intValue() == 10) {
                    HiloRoomJoinUserBinding binding5 = getBinding();
                    if (binding5 != null && (textView2 = binding5.userJoinContent) != null) {
                        String stringById3 = ResourcesKtxKt.getStringById(this, R.string.group_remove_admin_by);
                        GroupRoomImCustomBean data9 = roomAppointedBean.getData();
                        String changeNickNameSizeInSixInclude3 = (data9 == null || (nick2 = data9.getNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(nick2);
                        GroupRoomImCustomBean data10 = roomAppointedBean.getData();
                        String format3 = String.format(stringById3, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude3, (data10 == null || (operatorNick2 = data10.getOperatorNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick2)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                        textView2.setText(format3);
                    }
                } else {
                    HiloRoomJoinUserBinding binding6 = getBinding();
                    if (binding6 != null && (textView = binding6.userJoinContent) != null) {
                        String stringById4 = ResourcesKtxKt.getStringById(this, R.string.removed_from_manager);
                        GroupRoomImCustomBean data11 = roomAppointedBean.getData();
                        String changeNickNameSizeInSixInclude4 = (data11 == null || (nick = data11.getNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(nick);
                        GroupRoomImCustomBean data12 = roomAppointedBean.getData();
                        String format4 = String.format(stringById4, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude4, (data12 == null || (operatorNick = data12.getOperatorNick()) == null) ? null : AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick)}, 2));
                        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                        textView.setText(format4);
                    }
                }
            }
            HiloRoomJoinUserBinding binding7 = getBinding();
            if (binding7 != null && (qMUIRadiusImageView5 = binding7.otherUserAvatar) != null) {
                qMUIRadiusImageView5.setVisibility(0);
            }
            HiloRoomJoinUserBinding binding8 = getBinding();
            if (binding8 != null && (qMUIRadiusImageView4 = binding8.otherUserAvatar) != null) {
                GroupRoomImCustomBean data13 = roomAppointedBean.getData();
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, ImageSizeKt.image100(data13 != null ? data13.getOperatorAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.ic_user_place_avatar), (c5.g) null, 49150, (Object) null);
            }
            HiloRoomJoinUserBinding binding9 = getBinding();
            if (binding9 != null && (qMUIRadiusImageView3 = binding9.otherUserAvatar) != null) {
                GroupRoomImCustomBean data14 = roomAppointedBean.getData();
                ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(data14 != null ? data14.getOperatorAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.ic_user_place_avatar), (c5.g) null, 49150, (Object) null);
            }
            HiloRoomJoinUserBinding binding10 = getBinding();
            final long j = 800;
            if (binding10 != null && (qMUIRadiusImageView2 = binding10.otherUserAvatar) != null) {
                qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomAppointedHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String str;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                            QMUIRadiusImageView qMUIRadiusImageView7 = qMUIRadiusImageView2;
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            GroupRoomImCustomBean data15 = ((RoomAppointedBean) msg).getData();
                            if (data15 == null || (str = data15.getOperatorExternalId()) == null) {
                                str = "";
                            }
                            baseControlUtils.roomOpenUserInfo(str);
                        }
                    }
                });
            }
            HiloRoomJoinUserBinding binding11 = getBinding();
            if (binding11 == null || (qMUIRadiusImageView = binding11.userAvatar) == null) {
                return;
            }
            qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomAppointedHolder$layoutViews$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                        QMUIRadiusImageView qMUIRadiusImageView7 = qMUIRadiusImageView;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        GroupRoomImCustomBean data15 = ((RoomAppointedBean) msg).getData();
                        if (data15 == null || (str = data15.getExternalId()) == null) {
                            str = "";
                        }
                        baseControlUtils.roomOpenUserInfo(str);
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

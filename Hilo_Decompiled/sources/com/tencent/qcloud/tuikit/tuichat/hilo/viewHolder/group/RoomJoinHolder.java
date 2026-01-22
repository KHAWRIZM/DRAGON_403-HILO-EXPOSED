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
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomJoinBean;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomJoinHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomJoinUserBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomJoinHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomJoinHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomJoinHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,47:1\n61#2,9:48\n*S KotlinDebug\n*F\n+ 1 RoomJoinHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomJoinHolder\n*L\n43#1:48,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomJoinHolder extends RoomEmptyBaseHolder<HiloRoomJoinUserBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomJoinHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        final QMUIRadiusImageView qMUIRadiusImageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        TextView textView;
        String nick;
        QMUIRadiusImageView qMUIRadiusImageView3;
        String str;
        TextView textView2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomJoinBean)) {
            return;
        }
        HiloRoomJoinUserBinding binding = getBinding();
        if (binding != null && (textView2 = binding.userJoinContent) != null) {
            Dimens dimens = Dimens.INSTANCE;
            textView2.setMaxWidth((((dimens.getScreenWidth() - dimens.dpToPx(54)) - dimens.dpToPx(10)) - dimens.dpToPx(50)) - dimens.dpToPx(50));
        }
        HiloRoomJoinUserBinding binding2 = getBinding();
        String str2 = null;
        if (binding2 != null && (qMUIRadiusImageView3 = binding2.userAvatar) != null) {
            GroupRoomImCustomBean data = ((RoomJoinBean) msg).getData();
            if (data != null) {
                str = data.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.ic_user_place_avatar), (c5.g) null, 49150, (Object) null);
        }
        HiloRoomJoinUserBinding binding3 = getBinding();
        if (binding3 != null && (textView = binding3.userJoinContent) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, R.string.group_join);
            GroupRoomImCustomBean data2 = ((RoomJoinBean) msg).getData();
            if (data2 != null && (nick = data2.getNick()) != null) {
                str2 = AppUtilitiesKt.changeNickNameSizeInSixInclude(nick);
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        HiloRoomJoinUserBinding binding4 = getBinding();
        if (binding4 != null && (qMUIRadiusImageView2 = binding4.otherUserAvatar) != null) {
            qMUIRadiusImageView2.setVisibility(8);
        }
        HiloRoomJoinUserBinding binding5 = getBinding();
        if (binding5 != null && (qMUIRadiusImageView = binding5.userAvatar) != null) {
            final long j = 800;
            qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomJoinHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                        QMUIRadiusImageView qMUIRadiusImageView4 = qMUIRadiusImageView;
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        GroupRoomImCustomBean data3 = ((RoomJoinBean) msg).getData();
                        if (data3 == null || (str3 = data3.getExternalId()) == null) {
                            str3 = "";
                        }
                        baseControlUtils.roomOpenUserInfo(str3);
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

package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.im.TIMUserExtBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.tencent.qcloud.tuicore.component.gatherimage.SynthesizedImageView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomGiftBinding;
import com.tencent.qcloud.tuikit.tuichat.databinding.IncludeMessageTitleChatBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomGiftBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomGiftHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomGiftBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "setGiftBubble", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomGiftHolder extends HiloRoomContentHolder<HiloRoomGiftBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomGiftHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    private final void setGiftBubble() {
        Integer num;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        TIMUserExtBean timUserExtBean = getTimUserExtBean();
        if (timUserExtBean != null) {
            num = timUserExtBean.getNobleLevel();
        } else {
            num = null;
        }
        int i = 0;
        if (num != null && num.intValue() > 0) {
            HiloRoomGiftBinding binding = getBinding();
            if (binding != null && (constraintLayout2 = binding.msgContentFrame) != null) {
                BaseService baseService = getBaseService();
                if (baseService != null) {
                    i = baseService.getChatNobleBackGroupDrawable(num.intValue());
                }
                constraintLayout2.setBackgroundResource(i);
                return;
            }
            return;
        }
        HiloRoomGiftBinding binding2 = getBinding();
        if (binding2 != null && (constraintLayout = binding2.msgContentFrame) != null) {
            BaseService baseService2 = getBaseService();
            if (baseService2 != null) {
                i = baseService2.getChatNobleBackGroupDrawable(0);
            }
            constraintLayout.setBackgroundResource(i);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        SvipData svipData;
        SynthesizedImageView avatar;
        SynthesizedImageView avatar2;
        TextView textView;
        SvipData svip;
        String operatorAvatar;
        TextView textView2;
        String str;
        TextView textView3;
        long j;
        Long giftNumber;
        SvipData receiveSvip;
        HiloRoomGiftBinding binding;
        TextView textView4;
        TextView textView5;
        String str2;
        ImageView imageView;
        String str3;
        GroupGiftDetail giftDetail;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomGiftBean)) {
            return;
        }
        HiloRoomGiftBinding binding2 = getBinding();
        String str4 = null;
        if (binding2 != null && (imageView = binding2.giftPic) != null) {
            GroupRoomImCustomBean data = ((RoomGiftBean) msg).getData();
            if (data != null && (giftDetail = data.getGiftDetail()) != null) {
                str3 = giftDetail.getIconUrl();
            } else {
                str3 = null;
            }
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(str3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.icon_default_gift), (c5.g) null, 49150, (Object) null);
        }
        HiloRoomGiftBinding binding3 = getBinding();
        if (binding3 != null && (textView5 = binding3.receiverUserName) != null) {
            GroupRoomImCustomBean data2 = ((RoomGiftBean) msg).getData();
            if (data2 != null) {
                str2 = data2.getNick();
            } else {
                str2 = null;
            }
            textView5.setText(str2);
        }
        RoomGiftBean roomGiftBean = (RoomGiftBean) msg;
        GroupRoomImCustomBean data3 = roomGiftBean.getData();
        if (data3 != null && (receiveSvip = data3.getReceiveSvip()) != null && receiveSvip.isMystery() && (binding = getBinding()) != null && (textView4 = binding.receiverUserName) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, R.string.mystery_name), Arrays.copyOf(new Object[]{receiveSvip.mysteryNumber()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView4.setText(format);
        }
        HiloRoomGiftBinding binding4 = getBinding();
        if (binding4 != null && (textView3 = binding4.giftNumber) != null) {
            GroupRoomImCustomBean data4 = roomGiftBean.getData();
            if (data4 != null && (giftNumber = data4.getGiftNumber()) != null) {
                j = giftNumber.longValue();
            } else {
                j = 1;
            }
            textView3.setText(String.valueOf(j));
        }
        IncludeMessageTitleChatBinding titleBinding = getTitleBinding();
        String str5 = "";
        if (titleBinding != null && (textView2 = titleBinding.userNameTv) != null) {
            GroupRoomImCustomBean data5 = roomGiftBean.getData();
            if (data5 == null || (str = data5.getOperatorNick()) == null) {
                str = "";
            }
            textView2.setText(str);
        }
        ArrayList arrayList = new ArrayList();
        GroupRoomImCustomBean data6 = roomGiftBean.getData();
        if (data6 != null && (operatorAvatar = data6.getOperatorAvatar()) != null) {
            str5 = operatorAvatar;
        }
        arrayList.add(ImageKtxKt.splicingAvatarUrl(str5));
        UserIconView leftUserIcon = getLeftUserIcon();
        if (leftUserIcon != null) {
            leftUserIcon.setIconUrls(arrayList);
        }
        TIMUserExtBean timUserExtBean = getTimUserExtBean();
        if (timUserExtBean != null) {
            svipData = timUserExtBean.getSvip();
        } else {
            svipData = null;
        }
        if (svipData != null && svipData.isMystery()) {
            IncludeMessageTitleChatBinding titleBinding2 = getTitleBinding();
            if (titleBinding2 != null && (textView = titleBinding2.userNameTv) != null) {
                String stringById = ResourcesKtxKt.getStringById(this, R.string.mystery_name);
                GroupRoomImCustomBean data7 = roomGiftBean.getData();
                if (data7 != null && (svip = data7.getSvip()) != null) {
                    str4 = svip.mysteryNumber();
                }
                String format2 = String.format(stringById, Arrays.copyOf(new Object[]{str4}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView.setText(format2);
            }
            UserIconView leftUserIcon2 = getLeftUserIcon();
            if (leftUserIcon2 != null && (avatar2 = leftUserIcon2.getAvatar()) != null) {
                avatar2.clear();
            }
            UserIconView leftUserIcon3 = getLeftUserIcon();
            if (leftUserIcon3 != null && (avatar = leftUserIcon3.getAvatar()) != null) {
                avatar.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.mystery_header));
                return;
            }
            return;
        }
        setGiftBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomGiftBinding inflateViewBinding() {
        HiloRoomGiftBinding inflate = HiloRoomGiftBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

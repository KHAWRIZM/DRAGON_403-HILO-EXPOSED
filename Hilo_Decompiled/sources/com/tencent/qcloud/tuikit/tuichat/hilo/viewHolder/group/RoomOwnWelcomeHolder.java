package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.SpannableTextBuilder;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.im.TIMUserExtBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomOwnWelcomeBinding;
import com.tencent.qcloud.tuikit.tuichat.databinding.IncludeMessageTitleChatBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomOwnWelcomeBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomOwnWelcomeHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomOwnWelcomeBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomOwnWelcomeHolder extends HiloRoomContentHolder<HiloRoomOwnWelcomeBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOwnWelcomeHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit layoutViews$lambda$1$lambda$0(RoomOwnWelcomeHolder roomOwnWelcomeHolder, TUIMessageBean tUIMessageBean, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "it");
        OnItemClickListener onItemClickListener = roomOwnWelcomeHolder.onItemClickListener;
        if (onItemClickListener != null) {
            GroupRoomImCustomBean data = ((RoomOwnWelcomeBean) tUIMessageBean).getData();
            if (data != null) {
                str2 = data.getExternalId();
            } else {
                str2 = null;
            }
            onItemClickListener.onType(5, str2);
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        SvipData svipData;
        String operatorAvatar;
        TextView textView;
        String str;
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        int i;
        TextView textView2;
        String str2;
        String str3;
        String content;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomOwnWelcomeBean)) {
            return;
        }
        TIMUserExtBean timUserExtBean = getTimUserExtBean();
        Integer num = null;
        if (timUserExtBean != null) {
            svipData = timUserExtBean.getSvip();
        } else {
            svipData = null;
        }
        HiloRoomOwnWelcomeBinding binding = getBinding();
        String str4 = "";
        if (binding != null && (textView2 = binding.content) != null) {
            SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(textView2);
            RoomOwnWelcomeBean roomOwnWelcomeBean = (RoomOwnWelcomeBean) msg;
            GroupRoomImCustomBean data = roomOwnWelcomeBean.getData();
            if (data != null) {
                str2 = data.getNick();
            } else {
                str2 = null;
            }
            SpannableTextBuilder appendText$default = SpannableTextBuilder.appendText$default(spannableTextBuilder, str2 + "  ", Integer.valueOf(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_ffd959)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, new Function1() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.e
                public final Object invoke(Object obj) {
                    Unit layoutViews$lambda$1$lambda$0;
                    layoutViews$lambda$1$lambda$0 = RoomOwnWelcomeHolder.layoutViews$lambda$1$lambda$0(RoomOwnWelcomeHolder.this, msg, (String) obj);
                    return layoutViews$lambda$1$lambda$0;
                }
            }, (Boolean) null, UserProxyUtility.roomMicNumChange, (Object) null);
            GroupRoomImCustomBean data2 = roomOwnWelcomeBean.getData();
            if (data2 == null || (content = data2.getContent()) == null) {
                str3 = "";
            } else {
                str3 = content;
            }
            SpannableTextBuilder.appendText$default(appendText$default, str3, Integer.valueOf(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white)), (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 252, (Object) null).apply();
        }
        if (svipData == null || !svipData.isMystery()) {
            IncludeMessageTitleChatBinding titleBinding = getTitleBinding();
            if (titleBinding != null && (textView = titleBinding.userNameTv) != null) {
                GroupRoomImCustomBean data3 = ((RoomOwnWelcomeBean) msg).getData();
                if (data3 == null || (str = data3.getOperatorNick()) == null) {
                    str = "";
                }
                textView.setText(str);
            }
            ArrayList arrayList = new ArrayList();
            GroupRoomImCustomBean data4 = ((RoomOwnWelcomeBean) msg).getData();
            if (data4 != null && (operatorAvatar = data4.getOperatorAvatar()) != null) {
                str4 = operatorAvatar;
            }
            arrayList.add(ImageKtxKt.splicingAvatarUrl(str4));
            UserIconView leftUserIcon = getLeftUserIcon();
            if (leftUserIcon != null) {
                leftUserIcon.setIconUrls(arrayList);
            }
        }
        TIMUserExtBean timUserExtBean2 = getTimUserExtBean();
        if (timUserExtBean2 != null) {
            num = timUserExtBean2.getNobleLevel();
        }
        if (num != null && num.intValue() > 0) {
            HiloRoomOwnWelcomeBinding binding2 = getBinding();
            if (binding2 != null && (constraintLayout2 = binding2.msgContentFrame) != null) {
                BaseService baseService = getBaseService();
                if (baseService != null) {
                    i = baseService.getChatNobleBackGroupDrawable(num.intValue());
                } else {
                    i = com.qiahao.base_common.R.drawable.ic_noble_chat_bg_v0;
                }
                constraintLayout2.setBackgroundResource(i);
                return;
            }
            return;
        }
        HiloRoomOwnWelcomeBinding binding3 = getBinding();
        if (binding3 != null && (constraintLayout = binding3.msgContentFrame) != null) {
            BaseService baseService2 = getBaseService();
            int i2 = 0;
            if (baseService2 != null) {
                i2 = baseService2.getChatNobleBackGroupDrawable(0);
            }
            constraintLayout.setBackgroundResource(i2);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomOwnWelcomeBinding inflateViewBinding() {
        HiloRoomOwnWelcomeBinding inflate = HiloRoomOwnWelcomeBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

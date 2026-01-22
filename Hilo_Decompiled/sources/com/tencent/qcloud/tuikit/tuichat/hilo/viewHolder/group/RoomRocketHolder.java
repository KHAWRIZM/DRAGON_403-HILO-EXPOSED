package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomRocketBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomRocketBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomRocketHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomRocketBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomRocketHolder extends HiloRoomContentHolder<HiloRoomRocketBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRocketHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        Integer num;
        String str;
        Object number;
        TextView textView;
        Object number2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomRocketBean)) {
            return;
        }
        RoomRocketBean roomRocketBean = (RoomRocketBean) msg;
        GroupRoomImCustomBean data = roomRocketBean.getData();
        if (data != null) {
            num = data.getAwardType();
        } else {
            num = null;
        }
        Object obj = MessageService.MSG_DB_READY_REPORT;
        if ((num == null || num.intValue() != 0) && (num == null || num.intValue() != 3)) {
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 2)) {
                str = "";
            } else {
                String stringById = ResourcesKtxKt.getStringById(this, R.string.get_prop_for_rocket);
                GroupRoomImCustomBean data2 = roomRocketBean.getData();
                if (data2 != null && (number = data2.getNumber()) != null) {
                    obj = number;
                }
                str = String.format(stringById, Arrays.copyOf(new Object[]{obj}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            }
        } else {
            String stringById2 = ResourcesKtxKt.getStringById(this, R.string.get_diamonds_for_rocket);
            GroupRoomImCustomBean data3 = roomRocketBean.getData();
            if (data3 != null && (number2 = data3.getNumber()) != null) {
                obj = number2;
            }
            str = String.format(stringById2, Arrays.copyOf(new Object[]{obj}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        HiloRoomRocketBinding binding = getBinding();
        if (binding != null && (textView = binding.contentText) != null) {
            textView.setText(str);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomRocketBinding inflateViewBinding() {
        HiloRoomRocketBinding inflate = HiloRoomRocketBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

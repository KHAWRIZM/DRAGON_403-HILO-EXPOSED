package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomGlobalGiftBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomLuckyBoxBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomLuckyBoxHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomGlobalGiftBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomLuckyBoxHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomLuckyBoxHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomLuckyBoxHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,44:1\n61#2,9:45\n*S KotlinDebug\n*F\n+ 1 RoomLuckyBoxHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomLuckyBoxHolder\n*L\n39#1:45,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomLuckyBoxHolder extends RoomEmptyBaseHolder<HiloRoomGlobalGiftBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLuckyBoxHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        final View root;
        TextView textView;
        String str;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomLuckyBoxBean)) {
            return;
        }
        HiloRoomGlobalGiftBinding binding = getBinding();
        if (binding != null && (textView = binding.giftTipText) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, R.string.try_get_diamonds_for_lucky_box);
            RoomLuckyBoxBean roomLuckyBoxBean = (RoomLuckyBoxBean) msg;
            GroupRoomImCustomBean data = roomLuckyBoxBean.getData();
            Integer num = null;
            if (data != null) {
                str = data.getNick();
            } else {
                str = null;
            }
            GroupRoomImCustomBean data2 = roomLuckyBoxBean.getData();
            if (data2 != null) {
                num = data2.getNumber();
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str, String.valueOf(num)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        HiloRoomGlobalGiftBinding binding2 = getBinding();
        if (binding2 != null && (root = binding2.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomLuckyBoxHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        cf.c.c().l(new LiveEvent("open_lucky_box", (Object) null, 2, (DefaultConstructorMarker) null));
                    }
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder
    @NotNull
    public HiloRoomGlobalGiftBinding inflateViewBinding() {
        HiloRoomGlobalGiftBinding inflate = HiloRoomGlobalGiftBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

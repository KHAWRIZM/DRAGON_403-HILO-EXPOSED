package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomGlobalGiftBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomSupportBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomSupportHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomGlobalGiftBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomSupportHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomSupportHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomSupportHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,38:1\n61#2,9:39\n*S KotlinDebug\n*F\n+ 1 RoomSupportHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomSupportHolder\n*L\n31#1:39,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomSupportHolder extends RoomEmptyBaseHolder<HiloRoomGlobalGiftBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomSupportHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        final View root;
        TextView textView;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomSupportBean)) {
            return;
        }
        HiloRoomGlobalGiftBinding binding = getBinding();
        if (binding != null && (textView = binding.giftTipText) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, R.string.today_group_refreshed));
        }
        HiloRoomGlobalGiftBinding binding2 = getBinding();
        if (binding2 != null && (root = binding2.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomSupportHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str;
                    String str2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        GroupRoomImCustomBean data = ((RoomSupportBean) msg).getData();
                        if (data != null) {
                            str = data.getH5();
                        } else {
                            str = null;
                        }
                        if (str != null && str.length() != 0) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            GroupRoomImCustomBean data2 = ((RoomSupportBean) msg).getData();
                            if (data2 == null || (str2 = data2.getH5()) == null) {
                                str2 = "";
                            }
                            baseControlUtils.openLevelActivity(str2);
                        }
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

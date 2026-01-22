package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomGlobalGiftBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomJumpBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomJumpHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomGlobalGiftBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomJumpHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomJumpHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomJumpHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,48:1\n61#2,9:49\n*S KotlinDebug\n*F\n+ 1 RoomJumpHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomJumpHolder\n*L\n32#1:49,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomJumpHolder extends RoomEmptyBaseHolder<HiloRoomGlobalGiftBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomJumpHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        final View root;
        TextView textView;
        String str;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomJumpBean)) {
            return;
        }
        HiloRoomGlobalGiftBinding binding = getBinding();
        if (binding != null && (textView = binding.giftTipText) != null) {
            GroupRoomImCustomBean data = ((RoomJumpBean) msg).getData();
            if (data != null) {
                str = data.getContent();
            } else {
                str = null;
            }
            textView.setText(str);
        }
        HiloRoomGlobalGiftBinding binding2 = getBinding();
        if (binding2 != null && (root = binding2.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomJumpHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i;
                    String str2;
                    String h5;
                    GroupRoomImCustomBean data2;
                    String groupId;
                    String groupId2;
                    Integer contentType;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        GroupRoomImCustomBean data3 = ((RoomJumpBean) msg).getData();
                        if (data3 != null && (contentType = data3.getContentType()) != null) {
                            i = contentType.intValue();
                        } else {
                            i = 0;
                        }
                        String str3 = "";
                        if (i != 1) {
                            if (i == 2 && (data2 = ((RoomJumpBean) msg).getData()) != null && (groupId = data2.getGroupId()) != null && groupId.length() > 0) {
                                BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                                GroupRoomImCustomBean data4 = ((RoomJumpBean) msg).getData();
                                if (data4 != null && (groupId2 = data4.getGroupId()) != null) {
                                    str3 = groupId2;
                                }
                                baseControlUtils.openRoom(str3);
                                return;
                            }
                            return;
                        }
                        GroupRoomImCustomBean data5 = ((RoomJumpBean) msg).getData();
                        if (data5 != null) {
                            str2 = data5.getH5();
                        } else {
                            str2 = null;
                        }
                        if (str2 != null && str2.length() != 0) {
                            BaseControlUtils baseControlUtils2 = BaseControlUtils.INSTANCE;
                            GroupRoomImCustomBean data6 = ((RoomJumpBean) msg).getData();
                            if (data6 != null && (h5 = data6.getH5()) != null) {
                                str3 = h5;
                            }
                            baseControlUtils2.openLevelActivity(str3);
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

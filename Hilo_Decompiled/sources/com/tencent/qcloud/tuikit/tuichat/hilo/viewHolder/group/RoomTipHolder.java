package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomTipBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomTipBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTipHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomTipBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomTipHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomTipHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTipHolder\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,33:1\n439#2:34\n*S KotlinDebug\n*F\n+ 1 RoomTipHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomTipHolder\n*L\n26#1:34\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomTipHolder extends RoomEmptyBaseHolder<HiloRoomTipBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTipHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomTipBean)) {
            return;
        }
        RoomTipBean roomTipBean = (RoomTipBean) msg;
        String str = "";
        if (roomTipBean.getTipType() == 2) {
            HiloRoomTipBinding binding = getBinding();
            if (binding != null && (textView4 = binding.contentText) != null) {
                textView4.setTextColor(Color.parseColor("#27e28c"));
            }
            HiloRoomTipBinding binding2 = getBinding();
            if (binding2 != null && (textView3 = binding2.contentText) != null) {
                String notice = roomTipBean.getNotice();
                if (notice != null) {
                    str = notice;
                }
                textView3.setText(str);
                return;
            }
            return;
        }
        if (roomTipBean.getTipType() == 3 || roomTipBean.getTipType() == 4) {
            HiloRoomTipBinding binding3 = getBinding();
            if (binding3 != null && (textView2 = binding3.contentText) != null) {
                textView2.setTextColor(-1);
            }
            HiloRoomTipBinding binding4 = getBinding();
            if (binding4 != null && (textView = binding4.contentText) != null) {
                String notice2 = roomTipBean.getNotice();
                if (notice2 != null) {
                    str = notice2;
                }
                textView.setText(str);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder
    @NotNull
    public HiloRoomTipBinding inflateViewBinding() {
        HiloRoomTipBinding inflate = HiloRoomTipBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

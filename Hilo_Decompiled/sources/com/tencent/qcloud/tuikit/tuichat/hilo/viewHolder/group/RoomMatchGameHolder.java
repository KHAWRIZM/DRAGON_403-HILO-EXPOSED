package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomMatchGameBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomMatchGameBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomMatchGameHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomMatchGameBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomMatchGameHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomMatchGameHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomMatchGameHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,38:1\n61#2,9:39\n*S KotlinDebug\n*F\n+ 1 RoomMatchGameHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomMatchGameHolder\n*L\n32#1:39,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomMatchGameHolder extends HiloRoomContentHolder<HiloRoomMatchGameBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomMatchGameHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        final View root;
        ImageView imageView;
        String str;
        TextView textView;
        String str2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomMatchGameBean)) {
            return;
        }
        HiloRoomMatchGameBinding binding = getBinding();
        if (binding != null && (textView = binding.content) != null) {
            RoomMatchGame data = ((RoomMatchGameBean) msg).getData();
            if (data == null || (str2 = data.getMsg()) == null) {
                str2 = "";
            }
            textView.setText(str2);
        }
        HiloRoomMatchGameBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.gameImage) != null) {
            RoomMatchGame data2 = ((RoomMatchGameBean) msg).getData();
            if (data2 != null) {
                str = data2.getGameIcon();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(str, UiKtxKt.toPX(40)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        HiloRoomMatchGameBinding binding3 = getBinding();
        if (binding3 != null && (root = binding3.getRoot()) != null) {
            final long j = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomMatchGameHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        cf.c.c().l(new LiveEvent("join_match_game", ((RoomMatchGameBean) msg).getData()));
                    }
                }
            });
        }
        setBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomMatchGameBinding inflateViewBinding() {
        HiloRoomMatchGameBinding inflate = HiloRoomMatchGameBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

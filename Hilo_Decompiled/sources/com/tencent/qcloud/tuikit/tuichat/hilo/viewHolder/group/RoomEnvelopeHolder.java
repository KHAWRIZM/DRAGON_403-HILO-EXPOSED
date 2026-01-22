package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.TIMRoomEnvelope;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomEnvolopeBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomEnvelopeBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEnvelopeHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomEnvolopeBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomEnvelopeHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomEnvelopeHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEnvelopeHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,35:1\n61#2,9:36\n*S KotlinDebug\n*F\n+ 1 RoomEnvelopeHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEnvelopeHolder\n*L\n30#1:36,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomEnvelopeHolder extends HiloRoomContentHolder<HiloRoomEnvolopeBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomEnvelopeHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        final ImageView imageView;
        TextView textView;
        String str;
        long j;
        Long diamondNum;
        ImageView imageView2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomEnvelopeBean)) {
            return;
        }
        HiloRoomEnvolopeBinding binding = getBinding();
        if (binding != null && (imageView2 = binding.bg) != null) {
            ImageKtxKt.toHorizontalMirror(imageView2, R.drawable.room_game_envelope_bg);
        }
        HiloRoomEnvolopeBinding binding2 = getBinding();
        if (binding2 != null && (textView = binding2.title) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, R.string.send_envelope_message);
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                TIMRoomEnvelope data = ((RoomEnvelopeBean) msg).getData();
                if (data != null && (diamondNum = data.getDiamondNum()) != null) {
                    j = diamondNum.longValue();
                } else {
                    j = 0;
                }
                str = service.formatNumber(j);
            } else {
                str = null;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        HiloRoomEnvolopeBinding binding3 = getBinding();
        if (binding3 != null && (imageView = binding3.bg) != null) {
            final long j2 = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEnvelopeHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnItemClickListener onItemClickListener;
                    Long l;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j2 || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        onItemClickListener = ((MessageBaseHolder) this).onItemClickListener;
                        if (onItemClickListener != null) {
                            TIMRoomEnvelope data2 = ((RoomEnvelopeBean) msg).getData();
                            if (data2 != null) {
                                l = data2.getLuckyBagId();
                            } else {
                                l = null;
                            }
                            onItemClickListener.onType(6, l);
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomEnvolopeBinding inflateViewBinding() {
        HiloRoomEnvolopeBinding inflate = HiloRoomEnvolopeBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

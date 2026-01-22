package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.im.TIMRoomEnvelopeGet;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomEnvolopeGetBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomEnvelopeGetBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEnvelopeGetHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomEnvolopeGetBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomEnvelopeGetHolder extends HiloRoomContentHolder<HiloRoomEnvolopeGetBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomEnvelopeGetHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        long j;
        String str;
        TextView textView;
        TextView textView2;
        Long diamondNum;
        Long diamondNum2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomEnvelopeGetBean)) {
            return;
        }
        RoomEnvelopeGetBean roomEnvelopeGetBean = (RoomEnvelopeGetBean) msg;
        TIMRoomEnvelopeGet data = roomEnvelopeGetBean.getData();
        long j2 = 0;
        if (data != null && (diamondNum2 = data.getDiamondNum()) != null) {
            j = diamondNum2.longValue();
        } else {
            j = 0;
        }
        String str2 = j + " " + ResourcesKtxKt.getStringById(this, R.string.diamonds);
        String stringById = ResourcesKtxKt.getStringById(this, R.string.envelope_get_message);
        TIMRoomEnvelopeGet data2 = roomEnvelopeGetBean.getData();
        String str3 = null;
        if (data2 != null) {
            str = data2.getSenderNick();
        } else {
            str = null;
        }
        TIMRoomEnvelopeGet data3 = roomEnvelopeGetBean.getData();
        if (data3 != null) {
            str3 = data3.getSenderCode();
        }
        TIMRoomEnvelopeGet data4 = roomEnvelopeGetBean.getData();
        if (data4 != null && (diamondNum = data4.getDiamondNum()) != null) {
            j2 = diamondNum.longValue();
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str, str3, Long.valueOf(j2)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        try {
            HiloRoomEnvolopeGetBinding binding = getBinding();
            if (binding != null && (textView2 = binding.text) != null) {
                SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(textView2), format, str2, Integer.valueOf(Color.parseColor("#FFE222")), (Integer) null, 8, (Object) null).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
            HiloRoomEnvolopeGetBinding binding2 = getBinding();
            if (binding2 != null && (textView = binding2.text) != null) {
                textView.setText(format);
            }
        }
        setBubble();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomEnvolopeGetBinding inflateViewBinding() {
        HiloRoomEnvolopeGetBinding inflate = HiloRoomEnvolopeGetBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

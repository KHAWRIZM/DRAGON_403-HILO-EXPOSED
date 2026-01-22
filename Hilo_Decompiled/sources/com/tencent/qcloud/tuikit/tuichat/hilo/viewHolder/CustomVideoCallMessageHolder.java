package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.VideoCallTipMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageVideoCallBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.VideoCallMessageBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomVideoCallMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/HiloMessageContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageVideoCallBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutVariableViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomVideoCallMessageHolder extends HiloMessageContentHolder<HiloMessageVideoCallBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomVideoCallMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(@Nullable TUIMessageBean msg, int position) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Integer num;
        String stringById;
        long j;
        Integer duration;
        if (msg instanceof VideoCallMessageBean) {
            HiloMessageVideoCallBinding binding = getBinding();
            if (binding != null && (textView3 = binding.text) != null) {
                VideoCallTipMessage messageData = ((VideoCallMessageBean) msg).getMessageData();
                if (messageData != null) {
                    num = messageData.getCallStatus();
                } else {
                    num = null;
                }
                int code = CallStatus.NORMAL.getCode();
                if (num != null && num.intValue() == code) {
                    try {
                        String stringById2 = ResourcesKtxKt.getStringById(this, R.string.call_time_);
                        VideoCallTipMessage messageData2 = ((VideoCallMessageBean) msg).getMessageData();
                        if (messageData2 != null && (duration = messageData2.getDuration()) != null) {
                            j = duration.intValue();
                        } else {
                            j = 0;
                        }
                        Pair durationInFormat = DateTimeUtilityKt.getDurationInFormat(j);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{durationInFormat.getFirst(), durationInFormat.getSecond()}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        stringById = String.format(stringById2, Arrays.copyOf(new Object[]{format}, 1));
                        Intrinsics.checkNotNullExpressionValue(stringById, "format(...)");
                    } catch (Exception unused) {
                        stringById = "";
                    }
                } else {
                    int code2 = CallStatus.CANCELED.getCode();
                    if (num != null && num.intValue() == code2) {
                        stringById = ResourcesKtxKt.getStringById(this, R.string.cancelled);
                    } else {
                        int code3 = CallStatus.TIMEOUT_REFUSE.getCode();
                        if (num != null && num.intValue() == code3) {
                            stringById = ResourcesKtxKt.getStringById(this, R.string.missed_call);
                        } else {
                            stringById = ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
                        }
                    }
                }
                textView3.setText(stringById);
            }
            if (Intrinsics.areEqual(((VideoCallMessageBean) msg).getSender(), BaseControlUtils.INSTANCE.getExternalId())) {
                HiloMessageVideoCallBinding binding2 = getBinding();
                if (binding2 != null && (textView2 = binding2.text) != null) {
                    textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_answered_video_call, 0);
                    return;
                }
                return;
            }
            HiloMessageVideoCallBinding binding3 = getBinding();
            if (binding3 != null && (textView = binding3.text) != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_dialed_video_call, 0, 0, 0);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.HiloMessageContentHolder
    @NotNull
    public HiloMessageVideoCallBinding inflateViewBinding() {
        HiloMessageVideoCallBinding inflate = HiloMessageVideoCallBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

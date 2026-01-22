package com.tencent.qcloud.tuikit.tuichat.hilo.bean;

import android.text.TextUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.im.CallStatus;
import com.qiahao.base_common.model.im.VideoCallTipMessage;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/VideoCallMessageBean;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "<init>", "()V", "messageData", "Lcom/qiahao/base_common/model/im/VideoCallTipMessage;", "getMessageData", "()Lcom/qiahao/base_common/model/im/VideoCallTipMessage;", "setMessageData", "(Lcom/qiahao/base_common/model/im/VideoCallTipMessage;)V", "onGetDisplayString", "", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "getLastText", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class VideoCallMessageBean extends TUIMessageBean {

    @Nullable
    private VideoCallTipMessage messageData;

    private final String getLastText() {
        int i;
        VideoCallTipMessage videoCallTipMessage = this.messageData;
        if (videoCallTipMessage == null) {
            return "";
        }
        Integer callStatus = videoCallTipMessage.getCallStatus();
        int code = CallStatus.NORMAL.getCode();
        if (callStatus != null && callStatus.intValue() == code) {
            try {
                String stringById = ResourcesKtxKt.getStringById(this, R.string.call_time_);
                Integer duration = videoCallTipMessage.getDuration();
                if (duration != null) {
                    i = duration.intValue();
                } else {
                    i = 0;
                }
                Pair durationInFormat = DateTimeUtilityKt.getDurationInFormat(i);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{durationInFormat.getFirst(), durationInFormat.getSecond()}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                String format2 = String.format(stringById, Arrays.copyOf(new Object[]{format}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                return format2;
            } catch (Exception unused) {
                return "";
            }
        }
        int code2 = CallStatus.CANCELED.getCode();
        if (callStatus != null && callStatus.intValue() == code2) {
            return ResourcesKtxKt.getStringById(this, R.string.cancelled);
        }
        int code3 = CallStatus.TIMEOUT_REFUSE.getCode();
        if (callStatus != null && callStatus.intValue() == code3) {
            return ResourcesKtxKt.getStringById(this, R.string.missed_call);
        }
        return ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
    }

    @Nullable
    public final VideoCallTipMessage getMessageData() {
        return this.messageData;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        return getLastText();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@Nullable V2TIMMessage v2TIMMessage) {
        byte[] bArr;
        String stringById;
        V2TIMCustomElem customElem;
        if (v2TIMMessage == null || (customElem = v2TIMMessage.getCustomElem()) == null || (bArr = customElem.getData()) == null) {
            bArr = new byte[0];
        }
        String str = new String(bArr, Charsets.UTF_8);
        if (!TextUtils.isEmpty(str)) {
            try {
                this.messageData = (VideoCallTipMessage) BaseApplication.Companion.getGSON().j(str, VideoCallTipMessage.class);
            } catch (Exception e) {
                TUIChatLog.e("CustomLinkMessageBean", "exception e = " + e);
            }
        }
        if (this.messageData != null) {
            stringById = getLastText();
        } else {
            stringById = ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
        }
        setExtra(stringById);
    }

    public final void setMessageData(@Nullable VideoCallTipMessage videoCallTipMessage) {
        this.messageData = videoCallTipMessage;
    }
}

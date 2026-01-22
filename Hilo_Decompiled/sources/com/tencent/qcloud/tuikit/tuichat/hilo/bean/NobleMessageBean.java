package com.tencent.qcloud.tuikit.tuichat.hilo.bean;

import android.text.TextUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.im.SendNobleMessage;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/NobleMessageBean;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "<init>", "()V", "messageData", "Lcom/qiahao/base_common/model/im/SendNobleMessage;", "getMessageData", "()Lcom/qiahao/base_common/model/im/SendNobleMessage;", "setMessageData", "(Lcom/qiahao/base_common/model/im/SendNobleMessage;)V", "onGetDisplayString", "", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class NobleMessageBean extends TUIMessageBean {

    @Nullable
    private SendNobleMessage messageData;

    @Nullable
    public final SendNobleMessage getMessageData() {
        return this.messageData;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        String str;
        String stringById = ResourcesKtxKt.getStringById(this, R.string.some_one_send_nobility);
        SendNobleMessage sendNobleMessage = this.messageData;
        if (sendNobleMessage == null || (str = sendNobleMessage.getNickName()) == null) {
            str = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@Nullable V2TIMMessage v2TIMMessage) {
        byte[] bArr;
        String str;
        String stringById;
        String str2;
        V2TIMCustomElem customElem;
        if (v2TIMMessage == null || (customElem = v2TIMMessage.getCustomElem()) == null || (bArr = customElem.getData()) == null) {
            bArr = new byte[0];
        }
        String str3 = new String(bArr, Charsets.UTF_8);
        if (!TextUtils.isEmpty(str3)) {
            try {
                SendNobleMessage sendNobleMessage = (SendNobleMessage) BaseApplication.Companion.getGSON().j(str3, SendNobleMessage.class);
                this.messageData = sendNobleMessage;
                if (sendNobleMessage != null) {
                    if (v2TIMMessage != null) {
                        str = v2TIMMessage.getNickName();
                    } else {
                        str = null;
                    }
                    sendNobleMessage.setNickName(str);
                }
            } catch (Exception e) {
                TUIChatLog.e("CustomLinkMessageBean", "exception e = " + e);
            }
        }
        if (this.messageData != null) {
            String stringById2 = ResourcesKtxKt.getStringById(this, R.string.some_one_send_nobility);
            SendNobleMessage sendNobleMessage2 = this.messageData;
            if (sendNobleMessage2 == null || (str2 = sendNobleMessage2.getNickName()) == null) {
                str2 = "";
            }
            stringById = String.format(stringById2, Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.checkNotNullExpressionValue(stringById, "format(...)");
        } else {
            stringById = ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
        }
        setExtra(stringById);
    }

    public final void setMessageData(@Nullable SendNobleMessage sendNobleMessage) {
        this.messageData = sendNobleMessage;
    }
}

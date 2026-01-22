package com.tencent.qcloud.tuikit.tuichat.hilo.bean;

import android.text.TextUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.im.SendHeadWearOrMountsMessage;
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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/HeadWearMessageBean;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "<init>", "()V", "messageData", "Lcom/qiahao/base_common/model/im/SendHeadWearOrMountsMessage;", "getMessageData", "()Lcom/qiahao/base_common/model/im/SendHeadWearOrMountsMessage;", "setMessageData", "(Lcom/qiahao/base_common/model/im/SendHeadWearOrMountsMessage;)V", "onGetDisplayString", "", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class HeadWearMessageBean extends TUIMessageBean {

    @Nullable
    private SendHeadWearOrMountsMessage messageData;

    @Nullable
    public final SendHeadWearOrMountsMessage getMessageData() {
        return this.messageData;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        String str;
        String stringById = ResourcesKtxKt.getStringById(this, R.string.you_get_new_props);
        SendHeadWearOrMountsMessage sendHeadWearOrMountsMessage = this.messageData;
        if (sendHeadWearOrMountsMessage == null || (str = sendHeadWearOrMountsMessage.getDays()) == null) {
            str = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@Nullable V2TIMMessage v2TIMMessage) {
        byte[] bArr;
        String stringById;
        String str;
        V2TIMCustomElem customElem;
        if (v2TIMMessage == null || (customElem = v2TIMMessage.getCustomElem()) == null || (bArr = customElem.getData()) == null) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr, Charsets.UTF_8);
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.messageData = (SendHeadWearOrMountsMessage) BaseApplication.Companion.getGSON().j(str2, SendHeadWearOrMountsMessage.class);
            } catch (Exception e) {
                TUIChatLog.e("CustomLinkMessageBean", "exception e = " + e);
            }
        }
        if (this.messageData != null) {
            String stringById2 = ResourcesKtxKt.getStringById(this, R.string.you_get_new_props);
            SendHeadWearOrMountsMessage sendHeadWearOrMountsMessage = this.messageData;
            if (sendHeadWearOrMountsMessage == null || (str = sendHeadWearOrMountsMessage.getDays()) == null) {
                str = "";
            }
            stringById = String.format(stringById2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(stringById, "format(...)");
        } else {
            stringById = ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
        }
        setExtra(stringById);
    }

    public final void setMessageData(@Nullable SendHeadWearOrMountsMessage sendHeadWearOrMountsMessage) {
        this.messageData = sendHeadWearOrMountsMessage;
    }
}

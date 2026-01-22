package com.tencent.qcloud.tuikit.tuichat.hilo.bean.strange;

import com.google.gson.d;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.im.MaskChatGiftReturnMsg;
import com.qiahao.base_common.support.BaseControlUtils;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/strange/StrangeGiftTimeOutMessageBean;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "<init>", "()V", "data", "Lcom/qiahao/base_common/model/im/MaskChatGiftReturnMsg;", "getData", "()Lcom/qiahao/base_common/model/im/MaskChatGiftReturnMsg;", "setData", "(Lcom/qiahao/base_common/model/im/MaskChatGiftReturnMsg;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "onGetDisplayString", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class StrangeGiftTimeOutMessageBean extends TUIMessageBean {

    @NotNull
    private String content = "";

    @Nullable
    private MaskChatGiftReturnMsg data;

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final MaskChatGiftReturnMsg getData() {
        return this.data;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        return this.content;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@Nullable V2TIMMessage v2TIMMessage) {
        String str;
        MaskChatGiftReturnMsg maskChatGiftReturnMsg;
        int i;
        V2TIMCustomElem customElem;
        byte[] data;
        if (v2TIMMessage == null || (customElem = v2TIMMessage.getCustomElem()) == null || (data = customElem.getData()) == null || (str = StringsKt.decodeToString(data)) == null) {
            str = "";
        }
        String str2 = null;
        try {
            maskChatGiftReturnMsg = (MaskChatGiftReturnMsg) new d().j(str, MaskChatGiftReturnMsg.class);
        } catch (Exception unused) {
            maskChatGiftReturnMsg = null;
        }
        this.data = maskChatGiftReturnMsg;
        if (maskChatGiftReturnMsg != null) {
            str2 = maskChatGiftReturnMsg.getSendExternalId();
        }
        if (Intrinsics.areEqual(str2, BaseControlUtils.INSTANCE.getExternalId())) {
            i = R.string.sender_gift_out_time_back_tip;
        } else {
            i = R.string.receiver_gift_out_time_back_tip;
        }
        this.content = ResourcesKtxKt.getStringById(this, i);
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setData(@Nullable MaskChatGiftReturnMsg maskChatGiftReturnMsg) {
        this.data = maskChatGiftReturnMsg;
    }
}

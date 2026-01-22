package com.tencent.qcloud.tuikit.tuichat.hilo.bean;

import android.text.TextUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.im.TextAndImageMessage;
import com.tencent.imsdk.v2.V2TIMCustomElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import kotlin.Metadata;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/TextAndImageMessageBean;", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "<init>", "()V", "messageData", "Lcom/qiahao/base_common/model/im/TextAndImageMessage;", "getMessageData", "()Lcom/qiahao/base_common/model/im/TextAndImageMessage;", "setMessageData", "(Lcom/qiahao/base_common/model/im/TextAndImageMessage;)V", "onGetDisplayString", "", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TextAndImageMessageBean extends TUIMessageBean {

    @Nullable
    private TextAndImageMessage messageData;

    @Nullable
    public final TextAndImageMessage getMessageData() {
        return this.messageData;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        String content;
        TextAndImageMessage textAndImageMessage = this.messageData;
        if (textAndImageMessage == null || (content = textAndImageMessage.getContent()) == null) {
            return "";
        }
        return content;
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
                this.messageData = (TextAndImageMessage) BaseApplication.Companion.getGSON().j(str, TextAndImageMessage.class);
            } catch (Exception e) {
                TUIChatLog.e("CustomLinkMessageBean", "exception e = " + e);
            }
        }
        TextAndImageMessage textAndImageMessage = this.messageData;
        if (textAndImageMessage != null) {
            if (textAndImageMessage == null || (stringById = textAndImageMessage.getContent()) == null) {
                stringById = "";
            }
        } else {
            stringById = ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
        }
        setExtra(stringById);
    }

    public final void setMessageData(@Nullable TextAndImageMessage textAndImageMessage) {
        this.messageData = textAndImageMessage;
    }
}

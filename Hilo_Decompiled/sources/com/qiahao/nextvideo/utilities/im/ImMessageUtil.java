package com.qiahao.nextvideo.utilities.im;

import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.VideoCallTipsMessage;
import com.qiahao.nextvideo.data.UserStore;
import com.taobao.accs.common.Constants;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMOfflinePushInfo;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ0\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ0\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/utilities/im/ImMessageUtil;", "", "<init>", "()V", "sendVideoMessage", "", "uid", "", "videoCallTipsMessage", "Lcom/qiahao/base_common/model/im/VideoCallTipsMessage;", "sendC2CMessage", Constants.SHARED_MESSAGE_ID_FILE, "disPlay", "listener", "Lcom/tencent/imsdk/v2/V2TIMSendCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "installLocalCustomMessage", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ImMessageUtil {

    @NotNull
    public static final ImMessageUtil INSTANCE = new ImMessageUtil();

    private ImMessageUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void installLocalCustomMessage$default(ImMessageUtil imMessageUtil, String str, Object obj, String str2, V2TIMSendCallback v2TIMSendCallback, int i, Object obj2) {
        if ((i & 8) != 0) {
            v2TIMSendCallback = null;
        }
        imMessageUtil.installLocalCustomMessage(str, obj, str2, v2TIMSendCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendC2CMessage$default(ImMessageUtil imMessageUtil, String str, Object obj, String str2, V2TIMSendCallback v2TIMSendCallback, int i, Object obj2) {
        if ((i & 8) != 0) {
            v2TIMSendCallback = null;
        }
        imMessageUtil.sendC2CMessage(str, obj, str2, v2TIMSendCallback);
    }

    public final void installLocalCustomMessage(@NotNull String uid, @NotNull Object message, @NotNull String disPlay, @Nullable V2TIMSendCallback<V2TIMMessage> listener) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        Intrinsics.checkNotNullParameter(disPlay, "disPlay");
        String str = null;
        TUIMessageBean buildCustomMessage = ChatMessageBuilder.buildCustomMessage(BaseApplication.Companion.getGSON().s(message), disPlay, null);
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
        v2TIMOfflinePushInfo.setTitle("Hilo");
        v2TIMOfflinePushInfo.setDesc(disPlay);
        buildCustomMessage.setStatus(2);
        buildCustomMessage.setCommonAttribute(buildCustomMessage.getV2TIMMessage());
        V2TIMMessageManager messageManager = V2TIMManager.getMessageManager();
        V2TIMMessage v2TIMMessage = buildCustomMessage.getV2TIMMessage();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        }
        messageManager.insertC2CMessageToLocalStorage(v2TIMMessage, uid, str, listener);
    }

    public final void sendC2CMessage(@NotNull String uid, @NotNull Object message, @NotNull String disPlay, @Nullable V2TIMSendCallback<V2TIMMessage> listener) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        Intrinsics.checkNotNullParameter(disPlay, "disPlay");
        TUIMessageBean buildCustomMessage = ChatMessageBuilder.buildCustomMessage(BaseApplication.Companion.getGSON().s(message), disPlay, null);
        V2TIMOfflinePushInfo v2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
        v2TIMOfflinePushInfo.setAndroidOPPOChannelID(SPUtils.DEFAULT_DATABASE);
        v2TIMOfflinePushInfo.setTitle("Hilo");
        v2TIMOfflinePushInfo.setDesc(disPlay);
        V2TIMManager.getMessageManager().sendMessage(buildCustomMessage.getV2TIMMessage(), uid, null, 0, false, v2TIMOfflinePushInfo, listener);
    }

    public final void sendVideoMessage(@NotNull String uid, @NotNull VideoCallTipsMessage videoCallTipsMessage) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(videoCallTipsMessage, "videoCallTipsMessage");
        sendC2CMessage$default(this, uid, videoCallTipsMessage, ResourcesKtxKt.getStringById(this, 2131953028), null, 8, null);
    }
}

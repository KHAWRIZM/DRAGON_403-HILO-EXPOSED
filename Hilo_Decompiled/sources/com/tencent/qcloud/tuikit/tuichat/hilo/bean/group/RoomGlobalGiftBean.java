package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import com.google.gson.d;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomGlobalGiftBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "<init>", "()V", "data", "Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;", "getData", "()Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;", "setData", "(Lcom/qiahao/base_common/model/im/GroupRoomImCustomBean;)V", "onGetDisplayString", "", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomGlobalGiftBean extends RoomTUIBean {

    @Nullable
    private GroupRoomImCustomBean data;

    @Nullable
    public final GroupRoomImCustomBean getData() {
        return this.data;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@NotNull V2TIMMessage v2TIMMessage) {
        GroupRoomImCustomBean groupRoomImCustomBean;
        Intrinsics.checkNotNullParameter(v2TIMMessage, TUIConstants.TUIChat.V2TIMMESSAGE);
        byte[] data = v2TIMMessage.getCustomElem().getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        try {
            groupRoomImCustomBean = (GroupRoomImCustomBean) new d().j(StringsKt.decodeToString(data), GroupRoomImCustomBean.class);
        } catch (Exception unused) {
            groupRoomImCustomBean = null;
        }
        this.data = groupRoomImCustomBean;
    }

    public final void setData(@Nullable GroupRoomImCustomBean groupRoomImCustomBean) {
        this.data = groupRoomImCustomBean;
    }
}

package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import com.oudi.utils.ktx.ResourcesKtxKt;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomUnNoBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "<init>", "()V", "onGetDisplayString", "", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomUnNoBean extends RoomTUIBean {
    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        return ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@NotNull V2TIMMessage v2TIMMessage) {
        Intrinsics.checkNotNullParameter(v2TIMMessage, TUIConstants.TUIChat.V2TIMMESSAGE);
    }
}

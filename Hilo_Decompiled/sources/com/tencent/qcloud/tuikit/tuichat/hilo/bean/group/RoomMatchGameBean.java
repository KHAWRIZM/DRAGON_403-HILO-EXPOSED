package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import com.google.gson.d;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomMatchGameBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "type", "", "data", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/RoomMatchGame;", "<init>", "(Ljava/lang/String;Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/RoomMatchGame;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getData", "()Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/RoomMatchGame;", "setData", "(Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/game/RoomMatchGame;)V", "onGetDisplayString", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomMatchGameBean extends RoomTUIBean {

    @Nullable
    private RoomMatchGame data;

    @NotNull
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomMatchGameBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final RoomMatchGame getData() {
        return this.data;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    @NotNull
    public String onGetDisplayString() {
        return "";
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public void onProcessMessage(@NotNull V2TIMMessage v2TIMMessage) {
        Intrinsics.checkNotNullParameter(v2TIMMessage, TUIConstants.TUIChat.V2TIMMESSAGE);
        byte[] data = v2TIMMessage.getCustomElem().getData();
        Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
        try {
            this.data = (RoomMatchGame) new d().j(StringsKt.decodeToString(data), RoomMatchGame.class);
        } catch (Exception unused) {
        }
    }

    public final void setData(@Nullable RoomMatchGame roomMatchGame) {
        this.data = roomMatchGame;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public /* synthetic */ RoomMatchGameBean(String str, RoomMatchGame roomMatchGame, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "120" : str, (i & 2) != 0 ? null : roomMatchGame);
    }

    public RoomMatchGameBean(@NotNull String str, @Nullable RoomMatchGame roomMatchGame) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.data = roomMatchGame;
    }
}

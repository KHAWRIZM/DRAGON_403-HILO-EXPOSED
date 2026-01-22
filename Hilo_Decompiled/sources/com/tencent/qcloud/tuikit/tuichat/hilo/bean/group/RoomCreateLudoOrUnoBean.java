package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import com.google.gson.d;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomCreateLudoOrUnoBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "type", "", "msg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getMsg", "setMsg", "onGetDisplayString", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomCreateLudoOrUnoBean extends RoomTUIBean {

    @Nullable
    private String msg;

    @NotNull
    private String type;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoomCreateLudoOrUnoBean() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
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
            RoomCreateLudoOrUnoBean roomCreateLudoOrUnoBean = (RoomCreateLudoOrUnoBean) new d().j(StringsKt.decodeToString(data), RoomCreateLudoOrUnoBean.class);
            this.type = roomCreateLudoOrUnoBean.type;
            this.msg = roomCreateLudoOrUnoBean.msg;
        } catch (Exception unused) {
        }
    }

    public final void setMsg(@Nullable String str) {
        this.msg = str;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public /* synthetic */ RoomCreateLudoOrUnoBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "101" : str, (i & 2) != 0 ? null : str2);
    }

    public RoomCreateLudoOrUnoBean(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.msg = str2;
    }
}

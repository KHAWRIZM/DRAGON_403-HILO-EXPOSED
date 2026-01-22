package com.tencent.qcloud.tuikit.tuichat.hilo.bean.group;

import com.google.gson.d;
import com.qiahao.base_common.model.ActivityDetailData;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomActivityBean;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomTUIBean;", "type", "", "activityData", "Lcom/qiahao/base_common/model/ActivityDetailData;", "<init>", "(Ljava/lang/String;Lcom/qiahao/base_common/model/ActivityDetailData;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getActivityData", "()Lcom/qiahao/base_common/model/ActivityDetailData;", "setActivityData", "(Lcom/qiahao/base_common/model/ActivityDetailData;)V", "onGetDisplayString", "onProcessMessage", "", TUIConstants.TUIChat.V2TIMMESSAGE, "Lcom/tencent/imsdk/v2/V2TIMMessage;", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomActivityBean extends RoomTUIBean {

    @Nullable
    private ActivityDetailData activityData;

    @NotNull
    private String type;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoomActivityBean() {
        this(r0, r0, 3, r0);
        String str = null;
    }

    @Nullable
    public final ActivityDetailData getActivityData() {
        return this.activityData;
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
            this.activityData = ((RoomActivityBean) new d().j(StringsKt.decodeToString(data), RoomActivityBean.class)).activityData;
        } catch (Exception unused) {
        }
    }

    public final void setActivityData(@Nullable ActivityDetailData activityDetailData) {
        this.activityData = activityDetailData;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public RoomActivityBean(@NotNull String str, @Nullable ActivityDetailData activityDetailData) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.activityData = activityDetailData;
    }

    public /* synthetic */ RoomActivityBean(String str, ActivityDetailData activityDetailData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "105" : str, (i & 2) != 0 ? null : activityDetailData);
    }
}

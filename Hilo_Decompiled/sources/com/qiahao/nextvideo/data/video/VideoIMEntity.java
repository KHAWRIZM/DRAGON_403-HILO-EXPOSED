package com.qiahao.nextvideo.data.video;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020 J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020!J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\"R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/video/VideoIMEntity;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "groupId", "", "user", "Lcom/qiahao/base_common/model/common/User;", "toUser", "data", "", "itemType", "", "<init>", "(Ljava/lang/String;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;Ljava/lang/Object;I)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "getToUser", "setToUser", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "getItemType", "()I", "setItemType", "(I)V", "analyzeData", "LuserProxy/UserProxy1$GroupPublicTextMessage;", "LuserProxy/UserProxy1$GroupPublicGiftMessage;", "LuserProxy/UserProxy1$GroupPublicInterMessage;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoIMEntity implements MultiItemEntity {

    @Nullable
    private Object data;

    @Nullable
    private String groupId;
    private int itemType;

    @Nullable
    private User toUser;

    @Nullable
    private User user;

    public VideoIMEntity(@Nullable String str, @Nullable User user, @Nullable User user2, @Nullable Object obj, int i) {
        this.groupId = str;
        this.user = user;
        this.toUser = user2;
        this.data = obj;
        this.itemType = i;
    }

    @NotNull
    public final VideoIMEntity analyzeData(@NotNull UserProxy1.GroupPublicTextMessage data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.groupId = data.getGroupId();
        UserProxy.User user = data.getUser();
        Intrinsics.checkNotNullExpressionValue(user, "getUser(...)");
        this.user = DataExternalKt.toUser(user);
        UserProxy.User toUser = data.getToUser();
        Intrinsics.checkNotNullExpressionValue(toUser, "getToUser(...)");
        this.toUser = DataExternalKt.toUser(toUser);
        this.data = data.getTextInfo();
        return this;
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    public int getItemType() {
        return this.itemType;
    }

    @Nullable
    public final User getToUser() {
        return this.toUser;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public final void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    public final void setToUser(@Nullable User user) {
        this.toUser = user;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public final VideoIMEntity analyzeData(@NotNull UserProxy1.GroupPublicGiftMessage data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.groupId = data.getGroupId();
        UserProxy.User user = data.getUser();
        Intrinsics.checkNotNullExpressionValue(user, "getUser(...)");
        this.user = DataExternalKt.toUser(user);
        UserProxy.User toUser = data.getToUser();
        Intrinsics.checkNotNullExpressionValue(toUser, "getToUser(...)");
        this.toUser = DataExternalKt.toUser(toUser);
        this.data = data.getGiftInfo();
        setItemType(174);
        return this;
    }

    public /* synthetic */ VideoIMEntity(String str, User user, User user2, Object obj, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : user, (i2 & 4) != 0 ? null : user2, (i2 & 8) != 0 ? null : obj, i);
    }

    @NotNull
    public final VideoIMEntity analyzeData(@NotNull UserProxy1.GroupPublicInterMessage data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.groupId = data.getGroupId();
        UserProxy.User user = data.getUser();
        Intrinsics.checkNotNullExpressionValue(user, "getUser(...)");
        this.user = DataExternalKt.toUser(user);
        UserProxy.User toUser = data.getToUser();
        Intrinsics.checkNotNullExpressionValue(toUser, "getToUser(...)");
        this.toUser = DataExternalKt.toUser(toUser);
        this.data = data.getInterInfo();
        return this;
    }
}

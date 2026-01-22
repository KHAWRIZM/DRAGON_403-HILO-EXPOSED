package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.data.room.RoomPK;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003JG\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/data/model/InRoomBean;", "", "provider", "", "channelId", "", "token", "agoraId", "micNumType", "groupPk", "Lcom/qiahao/nextvideo/data/room/RoomPK;", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILcom/qiahao/nextvideo/data/room/RoomPK;)V", "getProvider", "()I", "setProvider", "(I)V", "getChannelId", "()Ljava/lang/String;", "getToken", "getAgoraId", "getMicNumType", "getGroupPk", "()Lcom/qiahao/nextvideo/data/room/RoomPK;", "setGroupPk", "(Lcom/qiahao/nextvideo/data/room/RoomPK;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class InRoomBean {
    private final int agoraId;

    @NotNull
    private final String channelId;

    @Nullable
    private RoomPK groupPk;
    private final int micNumType;
    private int provider;

    @NotNull
    private final String token;

    public InRoomBean(int i, @NotNull String str, @NotNull String str2, int i2, int i3, @Nullable RoomPK roomPK) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "token");
        this.provider = i;
        this.channelId = str;
        this.token = str2;
        this.agoraId = i2;
        this.micNumType = i3;
        this.groupPk = roomPK;
    }

    public static /* synthetic */ InRoomBean copy$default(InRoomBean inRoomBean, int i, String str, String str2, int i2, int i3, RoomPK roomPK, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = inRoomBean.provider;
        }
        if ((i4 & 2) != 0) {
            str = inRoomBean.channelId;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            str2 = inRoomBean.token;
        }
        String str4 = str2;
        if ((i4 & 8) != 0) {
            i2 = inRoomBean.agoraId;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = inRoomBean.micNumType;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            roomPK = inRoomBean.groupPk;
        }
        return inRoomBean.copy(i, str3, str4, i5, i6, roomPK);
    }

    /* renamed from: component1, reason: from getter */
    public final int getProvider() {
        return this.provider;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component4, reason: from getter */
    public final int getAgoraId() {
        return this.agoraId;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMicNumType() {
        return this.micNumType;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final RoomPK getGroupPk() {
        return this.groupPk;
    }

    @NotNull
    public final InRoomBean copy(int provider, @NotNull String channelId, @NotNull String token, int agoraId, int micNumType, @Nullable RoomPK groupPk) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(token, "token");
        return new InRoomBean(provider, channelId, token, agoraId, micNumType, groupPk);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InRoomBean)) {
            return false;
        }
        InRoomBean inRoomBean = (InRoomBean) other;
        return this.provider == inRoomBean.provider && Intrinsics.areEqual(this.channelId, inRoomBean.channelId) && Intrinsics.areEqual(this.token, inRoomBean.token) && this.agoraId == inRoomBean.agoraId && this.micNumType == inRoomBean.micNumType && Intrinsics.areEqual(this.groupPk, inRoomBean.groupPk);
    }

    public final int getAgoraId() {
        return this.agoraId;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final RoomPK getGroupPk() {
        return this.groupPk;
    }

    public final int getMicNumType() {
        return this.micNumType;
    }

    public final int getProvider() {
        return this.provider;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int hashCode = ((((((((this.provider * 31) + this.channelId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.agoraId) * 31) + this.micNumType) * 31;
        RoomPK roomPK = this.groupPk;
        return hashCode + (roomPK == null ? 0 : roomPK.hashCode());
    }

    public final void setGroupPk(@Nullable RoomPK roomPK) {
        this.groupPk = roomPK;
    }

    public final void setProvider(int i) {
        this.provider = i;
    }

    @NotNull
    public String toString() {
        return "InRoomBean(provider=" + this.provider + ", channelId=" + this.channelId + ", token=" + this.token + ", agoraId=" + this.agoraId + ", micNumType=" + this.micNumType + ", groupPk=" + this.groupPk + ")";
    }

    public /* synthetic */ InRoomBean(int i, String str, String str2, int i2, int i3, RoomPK roomPK, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, i3, (i4 & 32) != 0 ? null : roomPK);
    }
}

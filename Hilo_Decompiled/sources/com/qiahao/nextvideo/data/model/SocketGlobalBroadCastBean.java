package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003Jm\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;", "", "senderExtId", "", "senderCode", "senderSex", "", "senderAvatar", "senderNick", "msg", "groupId", "senderNobleLevel", "isPinned", "", "senderSvipLevel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZI)V", "getSenderExtId", "()Ljava/lang/String;", "getSenderCode", "getSenderSex", "()I", "getSenderAvatar", "getSenderNick", "getMsg", "getGroupId", "getSenderNobleLevel", "()Z", "setPinned", "(Z)V", "getSenderSvipLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SocketGlobalBroadCastBean {

    @NotNull
    private final String groupId;
    private boolean isPinned;

    @NotNull
    private final String msg;

    @NotNull
    private final String senderAvatar;

    @NotNull
    private final String senderCode;

    @NotNull
    private final String senderExtId;

    @NotNull
    private final String senderNick;
    private final int senderNobleLevel;
    private final int senderSex;
    private final int senderSvipLevel;

    public SocketGlobalBroadCastBean(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i2, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(str, "senderExtId");
        Intrinsics.checkNotNullParameter(str2, "senderCode");
        Intrinsics.checkNotNullParameter(str3, "senderAvatar");
        Intrinsics.checkNotNullParameter(str4, "senderNick");
        Intrinsics.checkNotNullParameter(str5, "msg");
        Intrinsics.checkNotNullParameter(str6, "groupId");
        this.senderExtId = str;
        this.senderCode = str2;
        this.senderSex = i;
        this.senderAvatar = str3;
        this.senderNick = str4;
        this.msg = str5;
        this.groupId = str6;
        this.senderNobleLevel = i2;
        this.isPinned = z;
        this.senderSvipLevel = i3;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSenderExtId() {
        return this.senderExtId;
    }

    /* renamed from: component10, reason: from getter */
    public final int getSenderSvipLevel() {
        return this.senderSvipLevel;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getSenderCode() {
        return this.senderCode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSenderSex() {
        return this.senderSex;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getSenderNick() {
        return this.senderNick;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSenderNobleLevel() {
        return this.senderNobleLevel;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    @NotNull
    public final SocketGlobalBroadCastBean copy(@NotNull String senderExtId, @NotNull String senderCode, int senderSex, @NotNull String senderAvatar, @NotNull String senderNick, @NotNull String msg, @NotNull String groupId, int senderNobleLevel, boolean isPinned, int senderSvipLevel) {
        Intrinsics.checkNotNullParameter(senderExtId, "senderExtId");
        Intrinsics.checkNotNullParameter(senderCode, "senderCode");
        Intrinsics.checkNotNullParameter(senderAvatar, "senderAvatar");
        Intrinsics.checkNotNullParameter(senderNick, "senderNick");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new SocketGlobalBroadCastBean(senderExtId, senderCode, senderSex, senderAvatar, senderNick, msg, groupId, senderNobleLevel, isPinned, senderSvipLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocketGlobalBroadCastBean)) {
            return false;
        }
        SocketGlobalBroadCastBean socketGlobalBroadCastBean = (SocketGlobalBroadCastBean) other;
        return Intrinsics.areEqual(this.senderExtId, socketGlobalBroadCastBean.senderExtId) && Intrinsics.areEqual(this.senderCode, socketGlobalBroadCastBean.senderCode) && this.senderSex == socketGlobalBroadCastBean.senderSex && Intrinsics.areEqual(this.senderAvatar, socketGlobalBroadCastBean.senderAvatar) && Intrinsics.areEqual(this.senderNick, socketGlobalBroadCastBean.senderNick) && Intrinsics.areEqual(this.msg, socketGlobalBroadCastBean.msg) && Intrinsics.areEqual(this.groupId, socketGlobalBroadCastBean.groupId) && this.senderNobleLevel == socketGlobalBroadCastBean.senderNobleLevel && this.isPinned == socketGlobalBroadCastBean.isPinned && this.senderSvipLevel == socketGlobalBroadCastBean.senderSvipLevel;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    public final String getSenderCode() {
        return this.senderCode;
    }

    @NotNull
    public final String getSenderExtId() {
        return this.senderExtId;
    }

    @NotNull
    public final String getSenderNick() {
        return this.senderNick;
    }

    public final int getSenderNobleLevel() {
        return this.senderNobleLevel;
    }

    public final int getSenderSex() {
        return this.senderSex;
    }

    public final int getSenderSvipLevel() {
        return this.senderSvipLevel;
    }

    public int hashCode() {
        return (((((((((((((((((this.senderExtId.hashCode() * 31) + this.senderCode.hashCode()) * 31) + this.senderSex) * 31) + this.senderAvatar.hashCode()) * 31) + this.senderNick.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.senderNobleLevel) * 31) + a.a(this.isPinned)) * 31) + this.senderSvipLevel;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    @NotNull
    public String toString() {
        return "SocketGlobalBroadCastBean(senderExtId=" + this.senderExtId + ", senderCode=" + this.senderCode + ", senderSex=" + this.senderSex + ", senderAvatar=" + this.senderAvatar + ", senderNick=" + this.senderNick + ", msg=" + this.msg + ", groupId=" + this.groupId + ", senderNobleLevel=" + this.senderNobleLevel + ", isPinned=" + this.isPinned + ", senderSvipLevel=" + this.senderSvipLevel + ")";
    }
}

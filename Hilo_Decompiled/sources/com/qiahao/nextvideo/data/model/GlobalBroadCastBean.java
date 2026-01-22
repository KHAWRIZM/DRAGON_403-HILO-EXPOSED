package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003JO\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;", "", "createdTime", "", "msg", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "userGlobalBroadcastId", "groupId", "isPinned", "", "hasPassword", "<init>", "(JLjava/lang/String;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;JLjava/lang/String;ZZ)V", "getCreatedTime", "()J", "getMsg", "()Ljava/lang/String;", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "getUserGlobalBroadcastId", "getGroupId", "()Z", "setPinned", "(Z)V", "getHasPassword", "setHasPassword", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GlobalBroadCastBean {
    private final long createdTime;

    @NotNull
    private final String groupId;
    private boolean hasPassword;
    private boolean isPinned;

    @NotNull
    private final String msg;

    @NotNull
    private final UserSummaryInfo user;
    private final long userGlobalBroadcastId;

    public GlobalBroadCastBean(long j, @NotNull String str, @NotNull UserSummaryInfo userSummaryInfo, long j2, @NotNull String str2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        Intrinsics.checkNotNullParameter(str2, "groupId");
        this.createdTime = j;
        this.msg = str;
        this.user = userSummaryInfo;
        this.userGlobalBroadcastId = j2;
        this.groupId = str2;
        this.isPinned = z;
        this.hasPassword = z2;
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUserGlobalBroadcastId() {
        return this.userGlobalBroadcastId;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    @NotNull
    public final GlobalBroadCastBean copy(long createdTime, @NotNull String msg, @NotNull UserSummaryInfo user, long userGlobalBroadcastId, @NotNull String groupId, boolean isPinned, boolean hasPassword) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return new GlobalBroadCastBean(createdTime, msg, user, userGlobalBroadcastId, groupId, isPinned, hasPassword);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GlobalBroadCastBean)) {
            return false;
        }
        GlobalBroadCastBean globalBroadCastBean = (GlobalBroadCastBean) other;
        return this.createdTime == globalBroadCastBean.createdTime && Intrinsics.areEqual(this.msg, globalBroadCastBean.msg) && Intrinsics.areEqual(this.user, globalBroadCastBean.user) && this.userGlobalBroadcastId == globalBroadCastBean.userGlobalBroadcastId && Intrinsics.areEqual(this.groupId, globalBroadCastBean.groupId) && this.isPinned == globalBroadCastBean.isPinned && this.hasPassword == globalBroadCastBean.hasPassword;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public final long getUserGlobalBroadcastId() {
        return this.userGlobalBroadcastId;
    }

    public int hashCode() {
        return (((((((((((c.a(this.createdTime) * 31) + this.msg.hashCode()) * 31) + this.user.hashCode()) * 31) + c.a(this.userGlobalBroadcastId)) * 31) + this.groupId.hashCode()) * 31) + a.a(this.isPinned)) * 31) + a.a(this.hasPassword);
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final void setHasPassword(boolean z) {
        this.hasPassword = z;
    }

    public final void setPinned(boolean z) {
        this.isPinned = z;
    }

    @NotNull
    public String toString() {
        return "GlobalBroadCastBean(createdTime=" + this.createdTime + ", msg=" + this.msg + ", user=" + this.user + ", userGlobalBroadcastId=" + this.userGlobalBroadcastId + ", groupId=" + this.groupId + ", isPinned=" + this.isPinned + ", hasPassword=" + this.hasPassword + ")";
    }

    public /* synthetic */ GlobalBroadCastBean(long j, String str, UserSummaryInfo userSummaryInfo, long j2, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, userSummaryInfo, j2, str2, (i & 32) != 0 ? false : z, z2);
    }
}

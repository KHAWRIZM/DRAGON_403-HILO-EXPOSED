package com.qiahao.nextvideo.data.model;

import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003Ja\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;", "Ljava/io/Serializable;", "avatar", "", "groupId", AgooConstants.MESSAGE_ID, "", "assistants", "", "Lcom/qiahao/nextvideo/data/model/PowerManagers;", "memberNum", "name", "isMyGroupPower", "", TUIConstants.TUIChat.OWNER, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;ZLcom/qiahao/nextvideo/data/model/PowerManagers;)V", "getAvatar", "()Ljava/lang/String;", "getGroupId", "getId", "()I", "getAssistants", "()Ljava/util/List;", "getMemberNum", "getName", "()Z", "getOwner", "()Lcom/qiahao/nextvideo/data/model/PowerManagers;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupPowerTitleDetail implements Serializable {

    @Nullable
    private final List<PowerManagers> assistants;

    @NotNull
    private final String avatar;

    @NotNull
    private final String groupId;
    private final int id;
    private final boolean isMyGroupPower;

    @NotNull
    private final String memberNum;

    @NotNull
    private final String name;

    @NotNull
    private final PowerManagers owner;

    public GroupPowerTitleDetail(@NotNull String str, @NotNull String str2, int i, @Nullable List<PowerManagers> list, @NotNull String str3, @NotNull String str4, boolean z, @NotNull PowerManagers powerManagers) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "groupId");
        Intrinsics.checkNotNullParameter(str3, "memberNum");
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(powerManagers, TUIConstants.TUIChat.OWNER);
        this.avatar = str;
        this.groupId = str2;
        this.id = i;
        this.assistants = list;
        this.memberNum = str3;
        this.name = str4;
        this.isMyGroupPower = z;
        this.owner = powerManagers;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    @Nullable
    public final List<PowerManagers> component4() {
        return this.assistants;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsMyGroupPower() {
        return this.isMyGroupPower;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final PowerManagers getOwner() {
        return this.owner;
    }

    @NotNull
    public final GroupPowerTitleDetail copy(@NotNull String avatar, @NotNull String groupId, int id2, @Nullable List<PowerManagers> assistants, @NotNull String memberNum, @NotNull String name, boolean isMyGroupPower, @NotNull PowerManagers owner) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(memberNum, "memberNum");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(owner, TUIConstants.TUIChat.OWNER);
        return new GroupPowerTitleDetail(avatar, groupId, id2, assistants, memberNum, name, isMyGroupPower, owner);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupPowerTitleDetail)) {
            return false;
        }
        GroupPowerTitleDetail groupPowerTitleDetail = (GroupPowerTitleDetail) other;
        return Intrinsics.areEqual(this.avatar, groupPowerTitleDetail.avatar) && Intrinsics.areEqual(this.groupId, groupPowerTitleDetail.groupId) && this.id == groupPowerTitleDetail.id && Intrinsics.areEqual(this.assistants, groupPowerTitleDetail.assistants) && Intrinsics.areEqual(this.memberNum, groupPowerTitleDetail.memberNum) && Intrinsics.areEqual(this.name, groupPowerTitleDetail.name) && this.isMyGroupPower == groupPowerTitleDetail.isMyGroupPower && Intrinsics.areEqual(this.owner, groupPowerTitleDetail.owner);
    }

    @Nullable
    public final List<PowerManagers> getAssistants() {
        return this.assistants;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getMemberNum() {
        return this.memberNum;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final PowerManagers getOwner() {
        return this.owner;
    }

    public int hashCode() {
        int hashCode = ((((this.avatar.hashCode() * 31) + this.groupId.hashCode()) * 31) + this.id) * 31;
        List<PowerManagers> list = this.assistants;
        return ((((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.memberNum.hashCode()) * 31) + this.name.hashCode()) * 31) + a.a(this.isMyGroupPower)) * 31) + this.owner.hashCode();
    }

    public final boolean isMyGroupPower() {
        return this.isMyGroupPower;
    }

    @NotNull
    public String toString() {
        return "GroupPowerTitleDetail(avatar=" + this.avatar + ", groupId=" + this.groupId + ", id=" + this.id + ", assistants=" + this.assistants + ", memberNum=" + this.memberNum + ", name=" + this.name + ", isMyGroupPower=" + this.isMyGroupPower + ", owner=" + this.owner + ")";
    }
}

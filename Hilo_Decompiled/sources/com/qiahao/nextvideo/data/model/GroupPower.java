package com.qiahao.nextvideo.data.model;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupPower;", "", "diamondNum", "", TUIConstants.TUIChat.FACE_URL, "", "groupPowerId", "name", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "getDiamondNum", "()I", "getFaceUrl", "()Ljava/lang/String;", "getGroupPowerId", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupPower {
    private final int diamondNum;

    @NotNull
    private final String faceUrl;
    private final int groupPowerId;

    @NotNull
    private final String name;

    public GroupPower(int i, @NotNull String str, int i2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str2, "name");
        this.diamondNum = i;
        this.faceUrl = str;
        this.groupPowerId = i2;
        this.name = str2;
    }

    public static /* synthetic */ GroupPower copy$default(GroupPower groupPower, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = groupPower.diamondNum;
        }
        if ((i3 & 2) != 0) {
            str = groupPower.faceUrl;
        }
        if ((i3 & 4) != 0) {
            i2 = groupPower.groupPowerId;
        }
        if ((i3 & 8) != 0) {
            str2 = groupPower.name;
        }
        return groupPower.copy(i, str, i2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final GroupPower copy(int diamondNum, @NotNull String faceUrl, int groupPowerId, @NotNull String name) {
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(name, "name");
        return new GroupPower(diamondNum, faceUrl, groupPowerId, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupPower)) {
            return false;
        }
        GroupPower groupPower = (GroupPower) other;
        return this.diamondNum == groupPower.diamondNum && Intrinsics.areEqual(this.faceUrl, groupPower.faceUrl) && this.groupPowerId == groupPower.groupPowerId && Intrinsics.areEqual(this.name, groupPower.name);
    }

    public final int getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    public final int getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((this.diamondNum * 31) + this.faceUrl.hashCode()) * 31) + this.groupPowerId) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "GroupPower(diamondNum=" + this.diamondNum + ", faceUrl=" + this.faceUrl + ", groupPowerId=" + this.groupPowerId + ", name=" + this.name + ")";
    }
}

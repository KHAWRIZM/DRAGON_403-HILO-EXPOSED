package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupPowerWeekBean;", "Ljava/io/Serializable;", "diamondNum", "", TUIConstants.TUIChat.FACE_URL, "", "groupPowerId", "name", "userN", "<init>", "(JLjava/lang/String;JLjava/lang/String;J)V", "getDiamondNum", "()J", "getFaceUrl", "()Ljava/lang/String;", "getGroupPowerId", "getName", "getUserN", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupPowerWeekBean implements Serializable {
    private final long diamondNum;

    @NotNull
    private final String faceUrl;
    private final long groupPowerId;

    @NotNull
    private final String name;
    private final long userN;

    public GroupPowerWeekBean(long j, @NotNull String str, long j2, @NotNull String str2, long j3) {
        Intrinsics.checkNotNullParameter(str, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(str2, "name");
        this.diamondNum = j;
        this.faceUrl = str;
        this.groupPowerId = j2;
        this.name = str2;
        this.userN = j3;
    }

    /* renamed from: component1, reason: from getter */
    public final long getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final long getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUserN() {
        return this.userN;
    }

    @NotNull
    public final GroupPowerWeekBean copy(long diamondNum, @NotNull String faceUrl, long groupPowerId, @NotNull String name, long userN) {
        Intrinsics.checkNotNullParameter(faceUrl, TUIConstants.TUIChat.FACE_URL);
        Intrinsics.checkNotNullParameter(name, "name");
        return new GroupPowerWeekBean(diamondNum, faceUrl, groupPowerId, name, userN);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupPowerWeekBean)) {
            return false;
        }
        GroupPowerWeekBean groupPowerWeekBean = (GroupPowerWeekBean) other;
        return this.diamondNum == groupPowerWeekBean.diamondNum && Intrinsics.areEqual(this.faceUrl, groupPowerWeekBean.faceUrl) && this.groupPowerId == groupPowerWeekBean.groupPowerId && Intrinsics.areEqual(this.name, groupPowerWeekBean.name) && this.userN == groupPowerWeekBean.userN;
    }

    public final long getDiamondNum() {
        return this.diamondNum;
    }

    @NotNull
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    public final long getGroupPowerId() {
        return this.groupPowerId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getUserN() {
        return this.userN;
    }

    public int hashCode() {
        return (((((((c.a(this.diamondNum) * 31) + this.faceUrl.hashCode()) * 31) + c.a(this.groupPowerId)) * 31) + this.name.hashCode()) * 31) + c.a(this.userN);
    }

    @NotNull
    public String toString() {
        return "GroupPowerWeekBean(diamondNum=" + this.diamondNum + ", faceUrl=" + this.faceUrl + ", groupPowerId=" + this.groupPowerId + ", name=" + this.name + ", userN=" + this.userN + ")";
    }
}

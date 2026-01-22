package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/qiahao/base_common/model/im/GroupBroadcastMessage;", "", "groupBroadcastContent", "", "identifier", "groupId", "faceUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGroupBroadcastContent", "()Ljava/lang/String;", "setGroupBroadcastContent", "(Ljava/lang/String;)V", "getIdentifier", "setIdentifier", "getGroupId", "setGroupId", "getFaceUrl", "setFaceUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class GroupBroadcastMessage {

    @Nullable
    private String faceUrl;

    @Nullable
    private String groupBroadcastContent;

    @Nullable
    private String groupId;

    @Nullable
    private String identifier;

    public GroupBroadcastMessage() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GroupBroadcastMessage copy$default(GroupBroadcastMessage groupBroadcastMessage, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = groupBroadcastMessage.groupBroadcastContent;
        }
        if ((i10 & 2) != 0) {
            str2 = groupBroadcastMessage.identifier;
        }
        if ((i10 & 4) != 0) {
            str3 = groupBroadcastMessage.groupId;
        }
        if ((i10 & 8) != 0) {
            str4 = groupBroadcastMessage.faceUrl;
        }
        return groupBroadcastMessage.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupBroadcastContent() {
        return this.groupBroadcastContent;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @NotNull
    public final GroupBroadcastMessage copy(@Nullable String groupBroadcastContent, @Nullable String identifier, @Nullable String groupId, @Nullable String faceUrl) {
        return new GroupBroadcastMessage(groupBroadcastContent, identifier, groupId, faceUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupBroadcastMessage)) {
            return false;
        }
        GroupBroadcastMessage groupBroadcastMessage = (GroupBroadcastMessage) other;
        return Intrinsics.areEqual(this.groupBroadcastContent, groupBroadcastMessage.groupBroadcastContent) && Intrinsics.areEqual(this.identifier, groupBroadcastMessage.identifier) && Intrinsics.areEqual(this.groupId, groupBroadcastMessage.groupId) && Intrinsics.areEqual(this.faceUrl, groupBroadcastMessage.faceUrl);
    }

    @Nullable
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    @Nullable
    public final String getGroupBroadcastContent() {
        return this.groupBroadcastContent;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        String str = this.groupBroadcastContent;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.identifier;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.faceUrl;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setFaceUrl(@Nullable String str) {
        this.faceUrl = str;
    }

    public final void setGroupBroadcastContent(@Nullable String str) {
        this.groupBroadcastContent = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    @NotNull
    public String toString() {
        return "GroupBroadcastMessage(groupBroadcastContent=" + this.groupBroadcastContent + ", identifier=" + this.identifier + ", groupId=" + this.groupId + ", faceUrl=" + this.faceUrl + ")";
    }

    public GroupBroadcastMessage(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.groupBroadcastContent = str;
        this.identifier = str2;
        this.groupId = str3;
        this.faceUrl = str4;
    }

    public /* synthetic */ GroupBroadcastMessage(String str, String str2, String str3, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}

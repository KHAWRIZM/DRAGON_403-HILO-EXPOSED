package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/qiahao/base_common/model/im/InviteEnterRoomMessage;", "", "groupFaceUrl", "", "identifier", "groupId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGroupFaceUrl", "()Ljava/lang/String;", "setGroupFaceUrl", "(Ljava/lang/String;)V", "getIdentifier", "setIdentifier", "getGroupId", "setGroupId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class InviteEnterRoomMessage {

    @Nullable
    private String groupFaceUrl;

    @Nullable
    private String groupId;

    @Nullable
    private String identifier;

    public InviteEnterRoomMessage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InviteEnterRoomMessage copy$default(InviteEnterRoomMessage inviteEnterRoomMessage, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = inviteEnterRoomMessage.groupFaceUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = inviteEnterRoomMessage.identifier;
        }
        if ((i10 & 4) != 0) {
            str3 = inviteEnterRoomMessage.groupId;
        }
        return inviteEnterRoomMessage.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getGroupFaceUrl() {
        return this.groupFaceUrl;
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

    @NotNull
    public final InviteEnterRoomMessage copy(@Nullable String groupFaceUrl, @Nullable String identifier, @Nullable String groupId) {
        return new InviteEnterRoomMessage(groupFaceUrl, identifier, groupId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteEnterRoomMessage)) {
            return false;
        }
        InviteEnterRoomMessage inviteEnterRoomMessage = (InviteEnterRoomMessage) other;
        return Intrinsics.areEqual(this.groupFaceUrl, inviteEnterRoomMessage.groupFaceUrl) && Intrinsics.areEqual(this.identifier, inviteEnterRoomMessage.identifier) && Intrinsics.areEqual(this.groupId, inviteEnterRoomMessage.groupId);
    }

    @Nullable
    public final String getGroupFaceUrl() {
        return this.groupFaceUrl;
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
        String str = this.groupFaceUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.identifier;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.groupId;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setGroupFaceUrl(@Nullable String str) {
        this.groupFaceUrl = str;
    }

    public final void setGroupId(@Nullable String str) {
        this.groupId = str;
    }

    public final void setIdentifier(@Nullable String str) {
        this.identifier = str;
    }

    @NotNull
    public String toString() {
        return "InviteEnterRoomMessage(groupFaceUrl=" + this.groupFaceUrl + ", identifier=" + this.identifier + ", groupId=" + this.groupId + ")";
    }

    public InviteEnterRoomMessage(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.groupFaceUrl = str;
        this.identifier = str2;
        this.groupId = str3;
    }

    public /* synthetic */ InviteEnterRoomMessage(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}

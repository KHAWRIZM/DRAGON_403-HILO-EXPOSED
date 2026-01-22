package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/qiahao/base_common/model/im/InviteFamilyMessage;", "", "identifier", "", "familyId", "", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "getFamilyId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAvatar", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/qiahao/base_common/model/im/InviteFamilyMessage;", "equals", "", "other", "hashCode", "", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class InviteFamilyMessage {

    @Nullable
    private final String avatar;

    @Nullable
    private final Long familyId;

    @Nullable
    private final String identifier;

    public InviteFamilyMessage() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ InviteFamilyMessage copy$default(InviteFamilyMessage inviteFamilyMessage, String str, Long l10, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = inviteFamilyMessage.identifier;
        }
        if ((i10 & 2) != 0) {
            l10 = inviteFamilyMessage.familyId;
        }
        if ((i10 & 4) != 0) {
            str2 = inviteFamilyMessage.avatar;
        }
        return inviteFamilyMessage.copy(str, l10, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getFamilyId() {
        return this.familyId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final InviteFamilyMessage copy(@Nullable String identifier, @Nullable Long familyId, @Nullable String avatar) {
        return new InviteFamilyMessage(identifier, familyId, avatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteFamilyMessage)) {
            return false;
        }
        InviteFamilyMessage inviteFamilyMessage = (InviteFamilyMessage) other;
        return Intrinsics.areEqual(this.identifier, inviteFamilyMessage.identifier) && Intrinsics.areEqual(this.familyId, inviteFamilyMessage.familyId) && Intrinsics.areEqual(this.avatar, inviteFamilyMessage.avatar);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final Long getFamilyId() {
        return this.familyId;
    }

    @Nullable
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        String str = this.identifier;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.familyId;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.avatar;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "InviteFamilyMessage(identifier=" + this.identifier + ", familyId=" + this.familyId + ", avatar=" + this.avatar + ")";
    }

    public InviteFamilyMessage(@Nullable String str, @Nullable Long l10, @Nullable String str2) {
        this.identifier = str;
        this.familyId = l10;
        this.avatar = str2;
    }

    public /* synthetic */ InviteFamilyMessage(String str, Long l10, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : l10, (i10 & 4) != 0 ? null : str2);
    }
}

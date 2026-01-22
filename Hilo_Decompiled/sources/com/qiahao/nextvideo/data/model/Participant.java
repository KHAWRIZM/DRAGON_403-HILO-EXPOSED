package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Participant;", "", "avatar", "", Constants.KEY_HTTP_CODE, SupportGiftRankActivity.EXTERNAL_ID, "isPrettyCode", "", "nick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getCode", "setCode", "getExternalId", "setExternalId", "()Z", "setPrettyCode", "(Z)V", "getNick", "setNick", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Participant {

    @NotNull
    private String avatar;

    @NotNull
    private String code;

    @NotNull
    private String externalId;
    private boolean isPrettyCode;

    @Nullable
    private String nick;

    public Participant(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, SupportGiftRankActivity.EXTERNAL_ID);
        this.avatar = str;
        this.code = str2;
        this.externalId = str3;
        this.isPrettyCode = z;
        this.nick = str4;
    }

    public static /* synthetic */ Participant copy$default(Participant participant, String str, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = participant.avatar;
        }
        if ((i & 2) != 0) {
            str2 = participant.code;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = participant.externalId;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            z = participant.isPrettyCode;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str4 = participant.nick;
        }
        return participant.copy(str, str5, str6, z2, str4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsPrettyCode() {
        return this.isPrettyCode;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    public final Participant copy(@NotNull String avatar, @NotNull String code, @NotNull String externalId, boolean isPrettyCode, @Nullable String nick) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        return new Participant(avatar, code, externalId, isPrettyCode, nick);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Participant)) {
            return false;
        }
        Participant participant = (Participant) other;
        return Intrinsics.areEqual(this.avatar, participant.avatar) && Intrinsics.areEqual(this.code, participant.code) && Intrinsics.areEqual(this.externalId, participant.externalId) && this.isPrettyCode == participant.isPrettyCode && Intrinsics.areEqual(this.nick, participant.nick);
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    public int hashCode() {
        int hashCode = ((((((this.avatar.hashCode() * 31) + this.code.hashCode()) * 31) + this.externalId.hashCode()) * 31) + a.a(this.isPrettyCode)) * 31;
        String str = this.nick;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    public final void setAvatar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatar = str;
    }

    public final void setCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void setExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.externalId = str;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setPrettyCode(boolean z) {
        this.isPrettyCode = z;
    }

    @NotNull
    public String toString() {
        return "Participant(avatar=" + this.avatar + ", code=" + this.code + ", externalId=" + this.externalId + ", isPrettyCode=" + this.isPrettyCode + ", nick=" + this.nick + ")";
    }

    public /* synthetic */ Participant(String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z, (i & 16) != 0 ? "" : str4);
    }
}

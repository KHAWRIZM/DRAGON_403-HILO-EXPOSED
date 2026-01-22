package com.qiahao.nextvideo.data.model;

import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MicUsers;", "Ljava/io/Serializable;", "avatar", "", Constants.KEY_HTTP_CODE, SupportGiftRankActivity.EXTERNAL_ID, "isPrettyCode", "", "sex", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V", "getAvatar", "()Ljava/lang/String;", "getCode", "getExternalId", "()Z", "getSex", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MicUsers implements Serializable {

    @NotNull
    private final String avatar;

    @NotNull
    private final String code;

    @NotNull
    private final String externalId;
    private final boolean isPrettyCode;
    private final int sex;

    public MicUsers(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(str3, SupportGiftRankActivity.EXTERNAL_ID);
        this.avatar = str;
        this.code = str2;
        this.externalId = str3;
        this.isPrettyCode = z;
        this.sex = i;
    }

    public static /* synthetic */ MicUsers copy$default(MicUsers micUsers, String str, String str2, String str3, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = micUsers.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = micUsers.code;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = micUsers.externalId;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            z = micUsers.isPrettyCode;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            i = micUsers.sex;
        }
        return micUsers.copy(str, str4, str5, z2, i);
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

    /* renamed from: component5, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    @NotNull
    public final MicUsers copy(@NotNull String avatar, @NotNull String code, @NotNull String externalId, boolean isPrettyCode, int sex) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        return new MicUsers(avatar, code, externalId, isPrettyCode, sex);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MicUsers)) {
            return false;
        }
        MicUsers micUsers = (MicUsers) other;
        return Intrinsics.areEqual(this.avatar, micUsers.avatar) && Intrinsics.areEqual(this.code, micUsers.code) && Intrinsics.areEqual(this.externalId, micUsers.externalId) && this.isPrettyCode == micUsers.isPrettyCode && this.sex == micUsers.sex;
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

    public final int getSex() {
        return this.sex;
    }

    public int hashCode() {
        return (((((((this.avatar.hashCode() * 31) + this.code.hashCode()) * 31) + this.externalId.hashCode()) * 31) + a.a(this.isPrettyCode)) * 31) + this.sex;
    }

    public final boolean isPrettyCode() {
        return this.isPrettyCode;
    }

    @NotNull
    public String toString() {
        return "MicUsers(avatar=" + this.avatar + ", code=" + this.code + ", externalId=" + this.externalId + ", isPrettyCode=" + this.isPrettyCode + ", sex=" + this.sex + ")";
    }
}

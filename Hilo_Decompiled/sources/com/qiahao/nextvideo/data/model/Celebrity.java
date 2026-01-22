package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Celebrity;", "", "avatar", "", "defaultAvatar", "", "<init>", "(Ljava/lang/String;Z)V", "getAvatar", "()Ljava/lang/String;", "getDefaultAvatar", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Celebrity {

    @NotNull
    private final String avatar;
    private final boolean defaultAvatar;

    public Celebrity(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        this.avatar = str;
        this.defaultAvatar = z;
    }

    public static /* synthetic */ Celebrity copy$default(Celebrity celebrity, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = celebrity.avatar;
        }
        if ((i & 2) != 0) {
            z = celebrity.defaultAvatar;
        }
        return celebrity.copy(str, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    @NotNull
    public final Celebrity copy(@NotNull String avatar, boolean defaultAvatar) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        return new Celebrity(avatar, defaultAvatar);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Celebrity)) {
            return false;
        }
        Celebrity celebrity = (Celebrity) other;
        return Intrinsics.areEqual(this.avatar, celebrity.avatar) && this.defaultAvatar == celebrity.defaultAvatar;
    }

    @NotNull
    public final String getAvatar() {
        return this.avatar;
    }

    public final boolean getDefaultAvatar() {
        return this.defaultAvatar;
    }

    public int hashCode() {
        return (this.avatar.hashCode() * 31) + a.a(this.defaultAvatar);
    }

    @NotNull
    public String toString() {
        return "Celebrity(avatar=" + this.avatar + ", defaultAvatar=" + this.defaultAvatar + ")";
    }
}

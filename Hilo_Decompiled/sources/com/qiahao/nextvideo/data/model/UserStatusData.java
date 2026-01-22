package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/UserStatusData;", "", "invisible", "", "<init>", "(Ljava/lang/Boolean;)V", "getInvisible", "()Ljava/lang/Boolean;", "setInvisible", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/qiahao/nextvideo/data/model/UserStatusData;", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class UserStatusData {

    @Nullable
    private Boolean invisible;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserStatusData() {
        this(r0, 1, r0);
        Boolean bool = null;
    }

    public static /* synthetic */ UserStatusData copy$default(UserStatusData userStatusData, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = userStatusData.invisible;
        }
        return userStatusData.copy(bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getInvisible() {
        return this.invisible;
    }

    @NotNull
    public final UserStatusData copy(@Nullable Boolean invisible) {
        return new UserStatusData(invisible);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UserStatusData) && Intrinsics.areEqual(this.invisible, ((UserStatusData) other).invisible);
    }

    @Nullable
    public final Boolean getInvisible() {
        return this.invisible;
    }

    public int hashCode() {
        Boolean bool = this.invisible;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public final void setInvisible(@Nullable Boolean bool) {
        this.invisible = bool;
    }

    @NotNull
    public String toString() {
        return "UserStatusData(invisible=" + this.invisible + ")";
    }

    public UserStatusData(@Nullable Boolean bool) {
        this.invisible = bool;
    }

    public /* synthetic */ UserStatusData(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }
}

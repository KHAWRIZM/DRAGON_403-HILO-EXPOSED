package com.qiahao.nextvideo.data.model;

import com.google.firebase.sessions.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/SurplusDiamonds;", "", "userDiamonds", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(DLcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getUserDiamonds", "()D", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SurplusDiamonds {

    @NotNull
    @c("userBase")
    private final UserSummaryInfo user;

    @c("diamondNum")
    private final double userDiamonds;

    public SurplusDiamonds(double d, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.userDiamonds = d;
        this.user = userSummaryInfo;
    }

    public static /* synthetic */ SurplusDiamonds copy$default(SurplusDiamonds surplusDiamonds, double d, UserSummaryInfo userSummaryInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            d = surplusDiamonds.userDiamonds;
        }
        if ((i & 2) != 0) {
            userSummaryInfo = surplusDiamonds.user;
        }
        return surplusDiamonds.copy(d, userSummaryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final double getUserDiamonds() {
        return this.userDiamonds;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    @NotNull
    public final SurplusDiamonds copy(double userDiamonds, @NotNull UserSummaryInfo user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new SurplusDiamonds(userDiamonds, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurplusDiamonds)) {
            return false;
        }
        SurplusDiamonds surplusDiamonds = (SurplusDiamonds) other;
        return Double.compare(this.userDiamonds, surplusDiamonds.userDiamonds) == 0 && Intrinsics.areEqual(this.user, surplusDiamonds.user);
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public final double getUserDiamonds() {
        return this.userDiamonds;
    }

    public int hashCode() {
        return (a.a(this.userDiamonds) * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "SurplusDiamonds(userDiamonds=" + this.userDiamonds + ", user=" + this.user + ")";
    }
}

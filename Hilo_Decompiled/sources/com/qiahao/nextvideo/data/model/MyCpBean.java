package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MyCpBean;", "", "score", "", "connect_second", "created_time", "", "user", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "<init>", "(JJLjava/lang/String;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getScore", "()J", "getConnect_second", "getCreated_time", "()Ljava/lang/String;", "getUser", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MyCpBean {
    private final long connect_second;

    @NotNull
    private final String created_time;
    private final long score;

    @NotNull
    private final UserSummaryInfo user;

    public MyCpBean(long j, long j2, @NotNull String str, @NotNull UserSummaryInfo userSummaryInfo) {
        Intrinsics.checkNotNullParameter(str, "created_time");
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user");
        this.score = j;
        this.connect_second = j2;
        this.created_time = str;
        this.user = userSummaryInfo;
    }

    public static /* synthetic */ MyCpBean copy$default(MyCpBean myCpBean, long j, long j2, String str, UserSummaryInfo userSummaryInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            j = myCpBean.score;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = myCpBean.connect_second;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = myCpBean.created_time;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            userSummaryInfo = myCpBean.user;
        }
        return myCpBean.copy(j3, j4, str2, userSummaryInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final long getScore() {
        return this.score;
    }

    /* renamed from: component2, reason: from getter */
    public final long getConnect_second() {
        return this.connect_second;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCreated_time() {
        return this.created_time;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    @NotNull
    public final MyCpBean copy(long score, long connect_second, @NotNull String created_time, @NotNull UserSummaryInfo user) {
        Intrinsics.checkNotNullParameter(created_time, "created_time");
        Intrinsics.checkNotNullParameter(user, "user");
        return new MyCpBean(score, connect_second, created_time, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyCpBean)) {
            return false;
        }
        MyCpBean myCpBean = (MyCpBean) other;
        return this.score == myCpBean.score && this.connect_second == myCpBean.connect_second && Intrinsics.areEqual(this.created_time, myCpBean.created_time) && Intrinsics.areEqual(this.user, myCpBean.user);
    }

    public final long getConnect_second() {
        return this.connect_second;
    }

    @NotNull
    public final String getCreated_time() {
        return this.created_time;
    }

    public final long getScore() {
        return this.score;
    }

    @NotNull
    public final UserSummaryInfo getUser() {
        return this.user;
    }

    public int hashCode() {
        return (((((c.a(this.score) * 31) + c.a(this.connect_second)) * 31) + this.created_time.hashCode()) * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "MyCpBean(score=" + this.score + ", connect_second=" + this.connect_second + ", created_time=" + this.created_time + ", user=" + this.user + ")";
    }
}

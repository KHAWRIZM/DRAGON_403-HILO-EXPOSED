package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CpBean;", "", "score", "", "connect_second", "created_time", "ranking", "", "user_1", "Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "user_2", "<init>", "(JJJILcom/qiahao/nextvideo/data/model/UserSummaryInfo;Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;)V", "getScore", "()J", "getConnect_second", "getCreated_time", "getRanking", "()I", "getUser_1", "()Lcom/qiahao/nextvideo/data/model/UserSummaryInfo;", "getUser_2", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpBean {
    private final long connect_second;
    private final long created_time;
    private final int ranking;
    private final long score;

    @NotNull
    private final UserSummaryInfo user_1;

    @NotNull
    private final UserSummaryInfo user_2;

    public CpBean(long j, long j2, long j3, int i, @NotNull UserSummaryInfo userSummaryInfo, @NotNull UserSummaryInfo userSummaryInfo2) {
        Intrinsics.checkNotNullParameter(userSummaryInfo, "user_1");
        Intrinsics.checkNotNullParameter(userSummaryInfo2, "user_2");
        this.score = j;
        this.connect_second = j2;
        this.created_time = j3;
        this.ranking = i;
        this.user_1 = userSummaryInfo;
        this.user_2 = userSummaryInfo2;
    }

    /* renamed from: component1, reason: from getter */
    public final long getScore() {
        return this.score;
    }

    /* renamed from: component2, reason: from getter */
    public final long getConnect_second() {
        return this.connect_second;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreated_time() {
        return this.created_time;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRanking() {
        return this.ranking;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final UserSummaryInfo getUser_1() {
        return this.user_1;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final UserSummaryInfo getUser_2() {
        return this.user_2;
    }

    @NotNull
    public final CpBean copy(long score, long connect_second, long created_time, int ranking, @NotNull UserSummaryInfo user_1, @NotNull UserSummaryInfo user_2) {
        Intrinsics.checkNotNullParameter(user_1, "user_1");
        Intrinsics.checkNotNullParameter(user_2, "user_2");
        return new CpBean(score, connect_second, created_time, ranking, user_1, user_2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpBean)) {
            return false;
        }
        CpBean cpBean = (CpBean) other;
        return this.score == cpBean.score && this.connect_second == cpBean.connect_second && this.created_time == cpBean.created_time && this.ranking == cpBean.ranking && Intrinsics.areEqual(this.user_1, cpBean.user_1) && Intrinsics.areEqual(this.user_2, cpBean.user_2);
    }

    public final long getConnect_second() {
        return this.connect_second;
    }

    public final long getCreated_time() {
        return this.created_time;
    }

    public final int getRanking() {
        return this.ranking;
    }

    public final long getScore() {
        return this.score;
    }

    @NotNull
    public final UserSummaryInfo getUser_1() {
        return this.user_1;
    }

    @NotNull
    public final UserSummaryInfo getUser_2() {
        return this.user_2;
    }

    public int hashCode() {
        return (((((((((c.a(this.score) * 31) + c.a(this.connect_second)) * 31) + c.a(this.created_time)) * 31) + this.ranking) * 31) + this.user_1.hashCode()) * 31) + this.user_2.hashCode();
    }

    @NotNull
    public String toString() {
        return "CpBean(score=" + this.score + ", connect_second=" + this.connect_second + ", created_time=" + this.created_time + ", ranking=" + this.ranking + ", user_1=" + this.user_1 + ", user_2=" + this.user_2 + ")";
    }
}

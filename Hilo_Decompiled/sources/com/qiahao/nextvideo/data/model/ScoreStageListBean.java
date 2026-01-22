package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ScoreStageListBean;", "Ljava/io/Serializable;", "awardDiamonds", "", "score", "stage", "", "<init>", "(JJI)V", "getAwardDiamonds", "()J", "getScore", "getStage", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ScoreStageListBean implements Serializable {
    private final long awardDiamonds;
    private final long score;
    private final int stage;

    public ScoreStageListBean() {
        this(0L, 0L, 0, 7, null);
    }

    public static /* synthetic */ ScoreStageListBean copy$default(ScoreStageListBean scoreStageListBean, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = scoreStageListBean.awardDiamonds;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = scoreStageListBean.score;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = scoreStageListBean.stage;
        }
        return scoreStageListBean.copy(j3, j4, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getAwardDiamonds() {
        return this.awardDiamonds;
    }

    /* renamed from: component2, reason: from getter */
    public final long getScore() {
        return this.score;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStage() {
        return this.stage;
    }

    @NotNull
    public final ScoreStageListBean copy(long awardDiamonds, long score, int stage) {
        return new ScoreStageListBean(awardDiamonds, score, stage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScoreStageListBean)) {
            return false;
        }
        ScoreStageListBean scoreStageListBean = (ScoreStageListBean) other;
        return this.awardDiamonds == scoreStageListBean.awardDiamonds && this.score == scoreStageListBean.score && this.stage == scoreStageListBean.stage;
    }

    public final long getAwardDiamonds() {
        return this.awardDiamonds;
    }

    public final long getScore() {
        return this.score;
    }

    public final int getStage() {
        return this.stage;
    }

    public int hashCode() {
        return (((c.a(this.awardDiamonds) * 31) + c.a(this.score)) * 31) + this.stage;
    }

    @NotNull
    public String toString() {
        return "ScoreStageListBean(awardDiamonds=" + this.awardDiamonds + ", score=" + this.score + ", stage=" + this.stage + ")";
    }

    public ScoreStageListBean(long j, long j2, int i) {
        this.awardDiamonds = j;
        this.score = j2;
        this.stage = i;
    }

    public /* synthetic */ ScoreStageListBean(long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) == 0 ? j2 : 0L, (i2 & 4) != 0 ? 0 : i);
    }
}

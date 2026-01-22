package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Stage;", "", "Stage", "", "contributors", "", "Lcom/qiahao/nextvideo/data/model/Contributor;", "isComplete", "", "nextScore", "score", "award", "Lcom/qiahao/nextvideo/data/model/AwardBean;", "<init>", "(ILjava/util/List;ZIILcom/qiahao/nextvideo/data/model/AwardBean;)V", "getStage", "()I", "getContributors", "()Ljava/util/List;", "()Z", "getNextScore", "getScore", "getAward", "()Lcom/qiahao/nextvideo/data/model/AwardBean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Stage {
    private final int Stage;

    @NotNull
    private final AwardBean award;

    @NotNull
    private final List<Contributor> contributors;
    private final boolean isComplete;
    private final int nextScore;
    private final int score;

    public Stage(int i, @NotNull List<Contributor> list, boolean z, int i2, int i3, @NotNull AwardBean awardBean) {
        Intrinsics.checkNotNullParameter(list, "contributors");
        Intrinsics.checkNotNullParameter(awardBean, "award");
        this.Stage = i;
        this.contributors = list;
        this.isComplete = z;
        this.nextScore = i2;
        this.score = i3;
        this.award = awardBean;
    }

    public static /* synthetic */ Stage copy$default(Stage stage, int i, List list, boolean z, int i2, int i3, AwardBean awardBean, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = stage.Stage;
        }
        if ((i4 & 2) != 0) {
            list = stage.contributors;
        }
        List list2 = list;
        if ((i4 & 4) != 0) {
            z = stage.isComplete;
        }
        boolean z2 = z;
        if ((i4 & 8) != 0) {
            i2 = stage.nextScore;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            i3 = stage.score;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            awardBean = stage.award;
        }
        return stage.copy(i, list2, z2, i5, i6, awardBean);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStage() {
        return this.Stage;
    }

    @NotNull
    public final List<Contributor> component2() {
        return this.contributors;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsComplete() {
        return this.isComplete;
    }

    /* renamed from: component4, reason: from getter */
    public final int getNextScore() {
        return this.nextScore;
    }

    /* renamed from: component5, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final AwardBean getAward() {
        return this.award;
    }

    @NotNull
    public final Stage copy(int Stage, @NotNull List<Contributor> contributors, boolean isComplete, int nextScore, int score, @NotNull AwardBean award) {
        Intrinsics.checkNotNullParameter(contributors, "contributors");
        Intrinsics.checkNotNullParameter(award, "award");
        return new Stage(Stage, contributors, isComplete, nextScore, score, award);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stage)) {
            return false;
        }
        Stage stage = (Stage) other;
        return this.Stage == stage.Stage && Intrinsics.areEqual(this.contributors, stage.contributors) && this.isComplete == stage.isComplete && this.nextScore == stage.nextScore && this.score == stage.score && Intrinsics.areEqual(this.award, stage.award);
    }

    @NotNull
    public final AwardBean getAward() {
        return this.award;
    }

    @NotNull
    public final List<Contributor> getContributors() {
        return this.contributors;
    }

    public final int getNextScore() {
        return this.nextScore;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getStage() {
        return this.Stage;
    }

    public int hashCode() {
        return (((((((((this.Stage * 31) + this.contributors.hashCode()) * 31) + a.a(this.isComplete)) * 31) + this.nextScore) * 31) + this.score) * 31) + this.award.hashCode();
    }

    public final boolean isComplete() {
        return this.isComplete;
    }

    @NotNull
    public String toString() {
        return "Stage(Stage=" + this.Stage + ", contributors=" + this.contributors + ", isComplete=" + this.isComplete + ", nextScore=" + this.nextScore + ", score=" + this.score + ", award=" + this.award + ")";
    }
}

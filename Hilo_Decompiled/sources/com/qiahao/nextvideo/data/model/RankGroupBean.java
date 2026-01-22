package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/data/model/RankGroupBean;", "Ljava/io/Serializable;", "groupBase", "Lcom/qiahao/nextvideo/data/model/GroupBase;", "score", "", "<init>", "(Lcom/qiahao/nextvideo/data/model/GroupBase;J)V", "getGroupBase", "()Lcom/qiahao/nextvideo/data/model/GroupBase;", "getScore", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class RankGroupBean implements Serializable {

    @NotNull
    private final GroupBase groupBase;
    private final long score;

    public RankGroupBean(@NotNull GroupBase groupBase, long j) {
        Intrinsics.checkNotNullParameter(groupBase, "groupBase");
        this.groupBase = groupBase;
        this.score = j;
    }

    public static /* synthetic */ RankGroupBean copy$default(RankGroupBean rankGroupBean, GroupBase groupBase, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            groupBase = rankGroupBean.groupBase;
        }
        if ((i & 2) != 0) {
            j = rankGroupBean.score;
        }
        return rankGroupBean.copy(groupBase, j);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final GroupBase getGroupBase() {
        return this.groupBase;
    }

    /* renamed from: component2, reason: from getter */
    public final long getScore() {
        return this.score;
    }

    @NotNull
    public final RankGroupBean copy(@NotNull GroupBase groupBase, long score) {
        Intrinsics.checkNotNullParameter(groupBase, "groupBase");
        return new RankGroupBean(groupBase, score);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RankGroupBean)) {
            return false;
        }
        RankGroupBean rankGroupBean = (RankGroupBean) other;
        return Intrinsics.areEqual(this.groupBase, rankGroupBean.groupBase) && this.score == rankGroupBean.score;
    }

    @NotNull
    public final GroupBase getGroupBase() {
        return this.groupBase;
    }

    public final long getScore() {
        return this.score;
    }

    public int hashCode() {
        return (this.groupBase.hashCode() * 31) + c.a(this.score);
    }

    @NotNull
    public String toString() {
        return "RankGroupBean(groupBase=" + this.groupBase + ", score=" + this.score + ")";
    }
}

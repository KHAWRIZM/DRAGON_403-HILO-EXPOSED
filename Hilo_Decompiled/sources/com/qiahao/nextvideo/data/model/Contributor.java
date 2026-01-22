package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/data/model/Contributor;", "", "score", "", "user", "Lcom/qiahao/nextvideo/data/model/RocketUserBean;", "<init>", "(JLcom/qiahao/nextvideo/data/model/RocketUserBean;)V", "getScore", "()J", "getUser", "()Lcom/qiahao/nextvideo/data/model/RocketUserBean;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Contributor {
    private final long score;

    @NotNull
    private final RocketUserBean user;

    public Contributor(long j, @NotNull RocketUserBean rocketUserBean) {
        Intrinsics.checkNotNullParameter(rocketUserBean, "user");
        this.score = j;
        this.user = rocketUserBean;
    }

    public static /* synthetic */ Contributor copy$default(Contributor contributor, long j, RocketUserBean rocketUserBean, int i, Object obj) {
        if ((i & 1) != 0) {
            j = contributor.score;
        }
        if ((i & 2) != 0) {
            rocketUserBean = contributor.user;
        }
        return contributor.copy(j, rocketUserBean);
    }

    /* renamed from: component1, reason: from getter */
    public final long getScore() {
        return this.score;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final RocketUserBean getUser() {
        return this.user;
    }

    @NotNull
    public final Contributor copy(long score, @NotNull RocketUserBean user) {
        Intrinsics.checkNotNullParameter(user, "user");
        return new Contributor(score, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Contributor)) {
            return false;
        }
        Contributor contributor = (Contributor) other;
        return this.score == contributor.score && Intrinsics.areEqual(this.user, contributor.user);
    }

    public final long getScore() {
        return this.score;
    }

    @NotNull
    public final RocketUserBean getUser() {
        return this.user;
    }

    public int hashCode() {
        return (c.a(this.score) * 31) + this.user.hashCode();
    }

    @NotNull
    public String toString() {
        return "Contributor(score=" + this.score + ", user=" + this.user + ")";
    }
}

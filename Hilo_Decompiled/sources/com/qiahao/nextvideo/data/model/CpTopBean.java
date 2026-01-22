package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CpTopBean;", "", "cpId", "", "cpLevel", "Lcom/qiahao/base_common/model/cp/CpLevel;", "ranking", "", "score", "", "user1", "Lcom/qiahao/base_common/model/common/User;", "user2", "<init>", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/lang/String;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;)V", "getCpId", "()Ljava/lang/Integer;", "setCpId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCpLevel", "()Lcom/qiahao/base_common/model/cp/CpLevel;", "setCpLevel", "(Lcom/qiahao/base_common/model/cp/CpLevel;)V", "getRanking", "()Ljava/lang/String;", "setRanking", "(Ljava/lang/String;)V", "getScore", "()Ljava/lang/Long;", "setScore", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUser1", "()Lcom/qiahao/base_common/model/common/User;", "setUser1", "(Lcom/qiahao/base_common/model/common/User;)V", "getUser2", "setUser2", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Lcom/qiahao/base_common/model/cp/CpLevel;Ljava/lang/String;Ljava/lang/Long;Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/common/User;)Lcom/qiahao/nextvideo/data/model/CpTopBean;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CpTopBean {

    @Nullable
    private Integer cpId;

    @Nullable
    private CpLevel cpLevel;

    @Nullable
    private String ranking;

    @Nullable
    private Long score;

    @Nullable
    private User user1;

    @Nullable
    private User user2;

    public CpTopBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CpTopBean copy$default(CpTopBean cpTopBean, Integer num, CpLevel cpLevel, String str, Long l, User user, User user2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cpTopBean.cpId;
        }
        if ((i & 2) != 0) {
            cpLevel = cpTopBean.cpLevel;
        }
        CpLevel cpLevel2 = cpLevel;
        if ((i & 4) != 0) {
            str = cpTopBean.ranking;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            l = cpTopBean.score;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            user = cpTopBean.user1;
        }
        User user3 = user;
        if ((i & 32) != 0) {
            user2 = cpTopBean.user2;
        }
        return cpTopBean.copy(num, cpLevel2, str2, l2, user3, user2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Integer getCpId() {
        return this.cpId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getRanking() {
        return this.ranking;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final User getUser1() {
        return this.user1;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final User getUser2() {
        return this.user2;
    }

    @NotNull
    public final CpTopBean copy(@Nullable Integer cpId, @Nullable CpLevel cpLevel, @Nullable String ranking, @Nullable Long score, @Nullable User user1, @Nullable User user2) {
        return new CpTopBean(cpId, cpLevel, ranking, score, user1, user2);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CpTopBean)) {
            return false;
        }
        CpTopBean cpTopBean = (CpTopBean) other;
        return Intrinsics.areEqual(this.cpId, cpTopBean.cpId) && Intrinsics.areEqual(this.cpLevel, cpTopBean.cpLevel) && Intrinsics.areEqual(this.ranking, cpTopBean.ranking) && Intrinsics.areEqual(this.score, cpTopBean.score) && Intrinsics.areEqual(this.user1, cpTopBean.user1) && Intrinsics.areEqual(this.user2, cpTopBean.user2);
    }

    @Nullable
    public final Integer getCpId() {
        return this.cpId;
    }

    @Nullable
    public final CpLevel getCpLevel() {
        return this.cpLevel;
    }

    @Nullable
    public final String getRanking() {
        return this.ranking;
    }

    @Nullable
    public final Long getScore() {
        return this.score;
    }

    @Nullable
    public final User getUser1() {
        return this.user1;
    }

    @Nullable
    public final User getUser2() {
        return this.user2;
    }

    public int hashCode() {
        Integer num = this.cpId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        CpLevel cpLevel = this.cpLevel;
        int hashCode2 = (hashCode + (cpLevel == null ? 0 : cpLevel.hashCode())) * 31;
        String str = this.ranking;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.score;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        User user = this.user1;
        int hashCode5 = (hashCode4 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.user2;
        return hashCode5 + (user2 != null ? user2.hashCode() : 0);
    }

    public final void setCpId(@Nullable Integer num) {
        this.cpId = num;
    }

    public final void setCpLevel(@Nullable CpLevel cpLevel) {
        this.cpLevel = cpLevel;
    }

    public final void setRanking(@Nullable String str) {
        this.ranking = str;
    }

    public final void setScore(@Nullable Long l) {
        this.score = l;
    }

    public final void setUser1(@Nullable User user) {
        this.user1 = user;
    }

    public final void setUser2(@Nullable User user) {
        this.user2 = user;
    }

    @NotNull
    public String toString() {
        return "CpTopBean(cpId=" + this.cpId + ", cpLevel=" + this.cpLevel + ", ranking=" + this.ranking + ", score=" + this.score + ", user1=" + this.user1 + ", user2=" + this.user2 + ")";
    }

    public CpTopBean(@Nullable Integer num, @Nullable CpLevel cpLevel, @Nullable String str, @Nullable Long l, @Nullable User user, @Nullable User user2) {
        this.cpId = num;
        this.cpLevel = cpLevel;
        this.ranking = str;
        this.score = l;
        this.user1 = user;
        this.user2 = user2;
    }

    public /* synthetic */ CpTopBean(Integer num, CpLevel cpLevel, String str, Long l, User user, User user2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : cpLevel, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : user, (i & 32) != 0 ? null : user2);
    }
}

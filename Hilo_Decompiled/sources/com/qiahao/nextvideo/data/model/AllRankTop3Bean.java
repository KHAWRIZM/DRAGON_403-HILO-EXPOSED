package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AllRankTop3Bean;", "", "celebrity", "", "Lcom/qiahao/nextvideo/data/model/RankAvatarBean;", "charm", AgooConstants.MESSAGE_BODY_GROUP, "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCelebrity", "()Ljava/util/List;", "getCharm", "getGroup", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AllRankTop3Bean {

    @NotNull
    private final List<RankAvatarBean> celebrity;

    @NotNull
    private final List<RankAvatarBean> charm;

    @NotNull
    private final List<RankAvatarBean> group;

    public AllRankTop3Bean(@NotNull List<RankAvatarBean> list, @NotNull List<RankAvatarBean> list2, @NotNull List<RankAvatarBean> list3) {
        Intrinsics.checkNotNullParameter(list, "celebrity");
        Intrinsics.checkNotNullParameter(list2, "charm");
        Intrinsics.checkNotNullParameter(list3, AgooConstants.MESSAGE_BODY_GROUP);
        this.celebrity = list;
        this.charm = list2;
        this.group = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AllRankTop3Bean copy$default(AllRankTop3Bean allRankTop3Bean, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = allRankTop3Bean.celebrity;
        }
        if ((i & 2) != 0) {
            list2 = allRankTop3Bean.charm;
        }
        if ((i & 4) != 0) {
            list3 = allRankTop3Bean.group;
        }
        return allRankTop3Bean.copy(list, list2, list3);
    }

    @NotNull
    public final List<RankAvatarBean> component1() {
        return this.celebrity;
    }

    @NotNull
    public final List<RankAvatarBean> component2() {
        return this.charm;
    }

    @NotNull
    public final List<RankAvatarBean> component3() {
        return this.group;
    }

    @NotNull
    public final AllRankTop3Bean copy(@NotNull List<RankAvatarBean> celebrity, @NotNull List<RankAvatarBean> charm, @NotNull List<RankAvatarBean> group) {
        Intrinsics.checkNotNullParameter(celebrity, "celebrity");
        Intrinsics.checkNotNullParameter(charm, "charm");
        Intrinsics.checkNotNullParameter(group, AgooConstants.MESSAGE_BODY_GROUP);
        return new AllRankTop3Bean(celebrity, charm, group);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AllRankTop3Bean)) {
            return false;
        }
        AllRankTop3Bean allRankTop3Bean = (AllRankTop3Bean) other;
        return Intrinsics.areEqual(this.celebrity, allRankTop3Bean.celebrity) && Intrinsics.areEqual(this.charm, allRankTop3Bean.charm) && Intrinsics.areEqual(this.group, allRankTop3Bean.group);
    }

    @NotNull
    public final List<RankAvatarBean> getCelebrity() {
        return this.celebrity;
    }

    @NotNull
    public final List<RankAvatarBean> getCharm() {
        return this.charm;
    }

    @NotNull
    public final List<RankAvatarBean> getGroup() {
        return this.group;
    }

    public int hashCode() {
        return (((this.celebrity.hashCode() * 31) + this.charm.hashCode()) * 31) + this.group.hashCode();
    }

    @NotNull
    public String toString() {
        return "AllRankTop3Bean(celebrity=" + this.celebrity + ", charm=" + this.charm + ", group=" + this.group + ")";
    }
}

package com.qiahao.nextvideo.data.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupMemberListBean;", "", "members", "", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "online", "", "total", "<init>", "(Ljava/util/List;II)V", "getMembers", "()Ljava/util/List;", "getOnline", "()I", "getTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupMemberListBean {

    @NotNull
    private final List<MemberBean> members;
    private final int online;
    private final int total;

    public GroupMemberListBean(@NotNull List<MemberBean> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "members");
        this.members = list;
        this.online = i;
        this.total = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupMemberListBean copy$default(GroupMemberListBean groupMemberListBean, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = groupMemberListBean.members;
        }
        if ((i3 & 2) != 0) {
            i = groupMemberListBean.online;
        }
        if ((i3 & 4) != 0) {
            i2 = groupMemberListBean.total;
        }
        return groupMemberListBean.copy(list, i, i2);
    }

    @NotNull
    public final List<MemberBean> component1() {
        return this.members;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOnline() {
        return this.online;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final GroupMemberListBean copy(@NotNull List<MemberBean> members, int online, int total) {
        Intrinsics.checkNotNullParameter(members, "members");
        return new GroupMemberListBean(members, online, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMemberListBean)) {
            return false;
        }
        GroupMemberListBean groupMemberListBean = (GroupMemberListBean) other;
        return Intrinsics.areEqual(this.members, groupMemberListBean.members) && this.online == groupMemberListBean.online && this.total == groupMemberListBean.total;
    }

    @NotNull
    public final List<MemberBean> getMembers() {
        return this.members;
    }

    public final int getOnline() {
        return this.online;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((this.members.hashCode() * 31) + this.online) * 31) + this.total;
    }

    @NotNull
    public String toString() {
        return "GroupMemberListBean(members=" + this.members + ", online=" + this.online + ", total=" + this.total + ")";
    }
}

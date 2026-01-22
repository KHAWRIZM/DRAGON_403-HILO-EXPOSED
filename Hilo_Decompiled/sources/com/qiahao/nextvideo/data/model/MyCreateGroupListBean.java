package com.qiahao.nextvideo.data.model;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MyCreateGroupListBean;", "", "groups", "", "Lcom/qiahao/nextvideo/data/model/GroupBean;", "manageGroups", "myGroups", "total", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getGroups", "()Ljava/util/List;", "getManageGroups", "getMyGroups", "getTotal", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MyCreateGroupListBean {

    @NotNull
    private final List<GroupBean> groups;

    @NotNull
    private final List<GroupBean> manageGroups;

    @NotNull
    private final List<GroupBean> myGroups;
    private final int total;

    public MyCreateGroupListBean(@NotNull List<GroupBean> list, @NotNull List<GroupBean> list2, @NotNull List<GroupBean> list3, int i) {
        Intrinsics.checkNotNullParameter(list, "groups");
        Intrinsics.checkNotNullParameter(list2, "manageGroups");
        Intrinsics.checkNotNullParameter(list3, "myGroups");
        this.groups = list;
        this.manageGroups = list2;
        this.myGroups = list3;
        this.total = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyCreateGroupListBean copy$default(MyCreateGroupListBean myCreateGroupListBean, List list, List list2, List list3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = myCreateGroupListBean.groups;
        }
        if ((i2 & 2) != 0) {
            list2 = myCreateGroupListBean.manageGroups;
        }
        if ((i2 & 4) != 0) {
            list3 = myCreateGroupListBean.myGroups;
        }
        if ((i2 & 8) != 0) {
            i = myCreateGroupListBean.total;
        }
        return myCreateGroupListBean.copy(list, list2, list3, i);
    }

    @NotNull
    public final List<GroupBean> component1() {
        return this.groups;
    }

    @NotNull
    public final List<GroupBean> component2() {
        return this.manageGroups;
    }

    @NotNull
    public final List<GroupBean> component3() {
        return this.myGroups;
    }

    /* renamed from: component4, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final MyCreateGroupListBean copy(@NotNull List<GroupBean> groups, @NotNull List<GroupBean> manageGroups, @NotNull List<GroupBean> myGroups, int total) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(manageGroups, "manageGroups");
        Intrinsics.checkNotNullParameter(myGroups, "myGroups");
        return new MyCreateGroupListBean(groups, manageGroups, myGroups, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyCreateGroupListBean)) {
            return false;
        }
        MyCreateGroupListBean myCreateGroupListBean = (MyCreateGroupListBean) other;
        return Intrinsics.areEqual(this.groups, myCreateGroupListBean.groups) && Intrinsics.areEqual(this.manageGroups, myCreateGroupListBean.manageGroups) && Intrinsics.areEqual(this.myGroups, myCreateGroupListBean.myGroups) && this.total == myCreateGroupListBean.total;
    }

    @NotNull
    public final List<GroupBean> getGroups() {
        return this.groups;
    }

    @NotNull
    public final List<GroupBean> getManageGroups() {
        return this.manageGroups;
    }

    @NotNull
    public final List<GroupBean> getMyGroups() {
        return this.myGroups;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((((this.groups.hashCode() * 31) + this.manageGroups.hashCode()) * 31) + this.myGroups.hashCode()) * 31) + this.total;
    }

    @NotNull
    public String toString() {
        return "MyCreateGroupListBean(groups=" + this.groups + ", manageGroups=" + this.manageGroups + ", myGroups=" + this.myGroups + ", total=" + this.total + ")";
    }
}

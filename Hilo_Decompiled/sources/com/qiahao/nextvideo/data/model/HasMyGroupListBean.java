package com.qiahao.nextvideo.data.model;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/data/model/HasMyGroupListBean;", "", "groups", "", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "ownGroups", "total", "", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "getGroups", "()Ljava/util/List;", "getOwnGroups", "getTotal", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class HasMyGroupListBean {

    @Nullable
    private final List<HotGroupBean> groups;

    @Nullable
    private final List<HotGroupBean> ownGroups;
    private final int total;

    public HasMyGroupListBean(@Nullable List<HotGroupBean> list, @Nullable List<HotGroupBean> list2, int i) {
        this.groups = list;
        this.ownGroups = list2;
        this.total = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HasMyGroupListBean copy$default(HasMyGroupListBean hasMyGroupListBean, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = hasMyGroupListBean.groups;
        }
        if ((i2 & 2) != 0) {
            list2 = hasMyGroupListBean.ownGroups;
        }
        if ((i2 & 4) != 0) {
            i = hasMyGroupListBean.total;
        }
        return hasMyGroupListBean.copy(list, list2, i);
    }

    @Nullable
    public final List<HotGroupBean> component1() {
        return this.groups;
    }

    @Nullable
    public final List<HotGroupBean> component2() {
        return this.ownGroups;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final HasMyGroupListBean copy(@Nullable List<HotGroupBean> groups, @Nullable List<HotGroupBean> ownGroups, int total) {
        return new HasMyGroupListBean(groups, ownGroups, total);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HasMyGroupListBean)) {
            return false;
        }
        HasMyGroupListBean hasMyGroupListBean = (HasMyGroupListBean) other;
        return Intrinsics.areEqual(this.groups, hasMyGroupListBean.groups) && Intrinsics.areEqual(this.ownGroups, hasMyGroupListBean.ownGroups) && this.total == hasMyGroupListBean.total;
    }

    @Nullable
    public final List<HotGroupBean> getGroups() {
        return this.groups;
    }

    @Nullable
    public final List<HotGroupBean> getOwnGroups() {
        return this.ownGroups;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        List<HotGroupBean> list = this.groups;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<HotGroupBean> list2 = this.ownGroups;
        return ((hashCode + (list2 != null ? list2.hashCode() : 0)) * 31) + this.total;
    }

    @NotNull
    public String toString() {
        return "HasMyGroupListBean(groups=" + this.groups + ", ownGroups=" + this.ownGroups + ", total=" + this.total + ")";
    }
}

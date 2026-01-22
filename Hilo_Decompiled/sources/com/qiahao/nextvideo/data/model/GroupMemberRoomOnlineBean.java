package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/GroupMemberRoomOnlineBean;", "", "total", "", "users", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/User;", "Lkotlin/collections/ArrayList;", "serviceTime", "", "<init>", "(ILjava/util/ArrayList;J)V", "getTotal", "()I", "getUsers", "()Ljava/util/ArrayList;", "getServiceTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class GroupMemberRoomOnlineBean {
    private final long serviceTime;
    private final int total;

    @NotNull
    private final ArrayList<User> users;

    public GroupMemberRoomOnlineBean(int i, @NotNull ArrayList<User> arrayList, long j) {
        Intrinsics.checkNotNullParameter(arrayList, "users");
        this.total = i;
        this.users = arrayList;
        this.serviceTime = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupMemberRoomOnlineBean copy$default(GroupMemberRoomOnlineBean groupMemberRoomOnlineBean, int i, ArrayList arrayList, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = groupMemberRoomOnlineBean.total;
        }
        if ((i2 & 2) != 0) {
            arrayList = groupMemberRoomOnlineBean.users;
        }
        if ((i2 & 4) != 0) {
            j = groupMemberRoomOnlineBean.serviceTime;
        }
        return groupMemberRoomOnlineBean.copy(i, arrayList, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final ArrayList<User> component2() {
        return this.users;
    }

    /* renamed from: component3, reason: from getter */
    public final long getServiceTime() {
        return this.serviceTime;
    }

    @NotNull
    public final GroupMemberRoomOnlineBean copy(int total, @NotNull ArrayList<User> users, long serviceTime) {
        Intrinsics.checkNotNullParameter(users, "users");
        return new GroupMemberRoomOnlineBean(total, users, serviceTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupMemberRoomOnlineBean)) {
            return false;
        }
        GroupMemberRoomOnlineBean groupMemberRoomOnlineBean = (GroupMemberRoomOnlineBean) other;
        return this.total == groupMemberRoomOnlineBean.total && Intrinsics.areEqual(this.users, groupMemberRoomOnlineBean.users) && this.serviceTime == groupMemberRoomOnlineBean.serviceTime;
    }

    public final long getServiceTime() {
        return this.serviceTime;
    }

    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final ArrayList<User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        return (((this.total * 31) + this.users.hashCode()) * 31) + c.a(this.serviceTime);
    }

    @NotNull
    public String toString() {
        return "GroupMemberRoomOnlineBean(total=" + this.total + ", users=" + this.users + ", serviceTime=" + this.serviceTime + ")";
    }
}

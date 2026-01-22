package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "", "total", "", "users", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "Lkotlin/collections/ArrayList;", "serviceTime", "", "<init>", "(ILjava/util/ArrayList;J)V", "getTotal", "()I", "getUsers", "()Ljava/util/ArrayList;", "getServiceTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CurrentRoomOnlineBeanList {
    private final long serviceTime;
    private final int total;

    @NotNull
    private final ArrayList<CurrentRoomOnlineBean> users;

    public CurrentRoomOnlineBeanList(int i, @NotNull ArrayList<CurrentRoomOnlineBean> arrayList, long j) {
        Intrinsics.checkNotNullParameter(arrayList, "users");
        this.total = i;
        this.users = arrayList;
        this.serviceTime = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CurrentRoomOnlineBeanList copy$default(CurrentRoomOnlineBeanList currentRoomOnlineBeanList, int i, ArrayList arrayList, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = currentRoomOnlineBeanList.total;
        }
        if ((i2 & 2) != 0) {
            arrayList = currentRoomOnlineBeanList.users;
        }
        if ((i2 & 4) != 0) {
            j = currentRoomOnlineBeanList.serviceTime;
        }
        return currentRoomOnlineBeanList.copy(i, arrayList, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final ArrayList<CurrentRoomOnlineBean> component2() {
        return this.users;
    }

    /* renamed from: component3, reason: from getter */
    public final long getServiceTime() {
        return this.serviceTime;
    }

    @NotNull
    public final CurrentRoomOnlineBeanList copy(int total, @NotNull ArrayList<CurrentRoomOnlineBean> users, long serviceTime) {
        Intrinsics.checkNotNullParameter(users, "users");
        return new CurrentRoomOnlineBeanList(total, users, serviceTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CurrentRoomOnlineBeanList)) {
            return false;
        }
        CurrentRoomOnlineBeanList currentRoomOnlineBeanList = (CurrentRoomOnlineBeanList) other;
        return this.total == currentRoomOnlineBeanList.total && Intrinsics.areEqual(this.users, currentRoomOnlineBeanList.users) && this.serviceTime == currentRoomOnlineBeanList.serviceTime;
    }

    public final long getServiceTime() {
        return this.serviceTime;
    }

    public final int getTotal() {
        return this.total;
    }

    @NotNull
    public final ArrayList<CurrentRoomOnlineBean> getUsers() {
        return this.users;
    }

    public int hashCode() {
        return (((this.total * 31) + this.users.hashCode()) * 31) + c.a(this.serviceTime);
    }

    @NotNull
    public String toString() {
        return "CurrentRoomOnlineBeanList(total=" + this.total + ", users=" + this.users + ", serviceTime=" + this.serviceTime + ")";
    }
}

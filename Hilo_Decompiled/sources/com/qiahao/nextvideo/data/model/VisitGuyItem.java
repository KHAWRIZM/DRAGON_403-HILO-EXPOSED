package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/VisitGuyItem;", "", "hasRead", "", "n", "", "likeAt", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(ZJJLcom/qiahao/base_common/model/common/User;)V", "getHasRead", "()Z", "setHasRead", "(Z)V", "getN", "()J", "getLikeAt", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VisitGuyItem {

    @c("hasRead")
    private boolean hasRead;

    @c("visitTime")
    private final long likeAt;

    @c("n")
    private final long n;

    @Nullable
    @c("userBase")
    private final User user;

    public VisitGuyItem(boolean z, long j, long j2, @Nullable User user) {
        this.hasRead = z;
        this.n = j;
        this.likeAt = j2;
        this.user = user;
    }

    public static /* synthetic */ VisitGuyItem copy$default(VisitGuyItem visitGuyItem, boolean z, long j, long j2, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            z = visitGuyItem.hasRead;
        }
        if ((i & 2) != 0) {
            j = visitGuyItem.n;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = visitGuyItem.likeAt;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            user = visitGuyItem.user;
        }
        return visitGuyItem.copy(z, j3, j4, user);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasRead() {
        return this.hasRead;
    }

    /* renamed from: component2, reason: from getter */
    public final long getN() {
        return this.n;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLikeAt() {
        return this.likeAt;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final VisitGuyItem copy(boolean hasRead, long n, long likeAt, @Nullable User user) {
        return new VisitGuyItem(hasRead, n, likeAt, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisitGuyItem)) {
            return false;
        }
        VisitGuyItem visitGuyItem = (VisitGuyItem) other;
        return this.hasRead == visitGuyItem.hasRead && this.n == visitGuyItem.n && this.likeAt == visitGuyItem.likeAt && Intrinsics.areEqual(this.user, visitGuyItem.user);
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final long getLikeAt() {
        return this.likeAt;
    }

    public final long getN() {
        return this.n;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int a = ((((a.a(this.hasRead) * 31) + androidx.collection.c.a(this.n)) * 31) + androidx.collection.c.a(this.likeAt)) * 31;
        User user = this.user;
        return a + (user == null ? 0 : user.hashCode());
    }

    public final void setHasRead(boolean z) {
        this.hasRead = z;
    }

    @NotNull
    public String toString() {
        return "VisitGuyItem(hasRead=" + this.hasRead + ", n=" + this.n + ", likeAt=" + this.likeAt + ", user=" + this.user + ")";
    }

    public /* synthetic */ VisitGuyItem(boolean z, long j, long j2, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, j, j2, user);
    }
}

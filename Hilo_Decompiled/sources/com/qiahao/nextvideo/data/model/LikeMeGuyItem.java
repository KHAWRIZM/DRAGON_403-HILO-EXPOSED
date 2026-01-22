package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q2.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/model/LikeMeGuyItem;", "", "hasRead", "", "likeAt", "", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(ZJLcom/qiahao/base_common/model/common/User;)V", "getHasRead", "()Z", "setHasRead", "(Z)V", "getLikeAt", "()J", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class LikeMeGuyItem {

    @c("hasRead")
    private boolean hasRead;

    @c("likeMeTime")
    private final long likeAt;

    @Nullable
    @c("userBase")
    private final User user;

    public LikeMeGuyItem(boolean z, long j, @Nullable User user) {
        this.hasRead = z;
        this.likeAt = j;
        this.user = user;
    }

    public static /* synthetic */ LikeMeGuyItem copy$default(LikeMeGuyItem likeMeGuyItem, boolean z, long j, User user, int i, Object obj) {
        if ((i & 1) != 0) {
            z = likeMeGuyItem.hasRead;
        }
        if ((i & 2) != 0) {
            j = likeMeGuyItem.likeAt;
        }
        if ((i & 4) != 0) {
            user = likeMeGuyItem.user;
        }
        return likeMeGuyItem.copy(z, j, user);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHasRead() {
        return this.hasRead;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLikeAt() {
        return this.likeAt;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final LikeMeGuyItem copy(boolean hasRead, long likeAt, @Nullable User user) {
        return new LikeMeGuyItem(hasRead, likeAt, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LikeMeGuyItem)) {
            return false;
        }
        LikeMeGuyItem likeMeGuyItem = (LikeMeGuyItem) other;
        return this.hasRead == likeMeGuyItem.hasRead && this.likeAt == likeMeGuyItem.likeAt && Intrinsics.areEqual(this.user, likeMeGuyItem.user);
    }

    public final boolean getHasRead() {
        return this.hasRead;
    }

    public final long getLikeAt() {
        return this.likeAt;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int a = ((a.a(this.hasRead) * 31) + androidx.collection.c.a(this.likeAt)) * 31;
        User user = this.user;
        return a + (user == null ? 0 : user.hashCode());
    }

    public final void setHasRead(boolean z) {
        this.hasRead = z;
    }

    @NotNull
    public String toString() {
        return "LikeMeGuyItem(hasRead=" + this.hasRead + ", likeAt=" + this.likeAt + ", user=" + this.user + ")";
    }

    public /* synthetic */ LikeMeGuyItem(boolean z, long j, User user, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, j, user);
    }
}

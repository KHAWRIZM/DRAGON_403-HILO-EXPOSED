package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/model/PraiseGuyItem;", "", "likeCnt", "", "lastLikeMeTime", "", "user", "Lcom/qiahao/base_common/model/common/User;", "<init>", "(IJLcom/qiahao/base_common/model/common/User;)V", "getLikeCnt", "()I", "setLikeCnt", "(I)V", "getLastLikeMeTime", "()J", "setLastLikeMeTime", "(J)V", "getUser", "()Lcom/qiahao/base_common/model/common/User;", "setUser", "(Lcom/qiahao/base_common/model/common/User;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class PraiseGuyItem {
    private long lastLikeMeTime;
    private int likeCnt;

    @Nullable
    private User user;

    public PraiseGuyItem(int i, long j, @Nullable User user) {
        this.likeCnt = i;
        this.lastLikeMeTime = j;
        this.user = user;
    }

    public static /* synthetic */ PraiseGuyItem copy$default(PraiseGuyItem praiseGuyItem, int i, long j, User user, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = praiseGuyItem.likeCnt;
        }
        if ((i2 & 2) != 0) {
            j = praiseGuyItem.lastLikeMeTime;
        }
        if ((i2 & 4) != 0) {
            user = praiseGuyItem.user;
        }
        return praiseGuyItem.copy(i, j, user);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLikeCnt() {
        return this.likeCnt;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLastLikeMeTime() {
        return this.lastLikeMeTime;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    @NotNull
    public final PraiseGuyItem copy(int likeCnt, long lastLikeMeTime, @Nullable User user) {
        return new PraiseGuyItem(likeCnt, lastLikeMeTime, user);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PraiseGuyItem)) {
            return false;
        }
        PraiseGuyItem praiseGuyItem = (PraiseGuyItem) other;
        return this.likeCnt == praiseGuyItem.likeCnt && this.lastLikeMeTime == praiseGuyItem.lastLikeMeTime && Intrinsics.areEqual(this.user, praiseGuyItem.user);
    }

    public final long getLastLikeMeTime() {
        return this.lastLikeMeTime;
    }

    public final int getLikeCnt() {
        return this.likeCnt;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int a = ((this.likeCnt * 31) + c.a(this.lastLikeMeTime)) * 31;
        User user = this.user;
        return a + (user == null ? 0 : user.hashCode());
    }

    public final void setLastLikeMeTime(long j) {
        this.lastLikeMeTime = j;
    }

    public final void setLikeCnt(int i) {
        this.likeCnt = i;
    }

    public final void setUser(@Nullable User user) {
        this.user = user;
    }

    @NotNull
    public String toString() {
        return "PraiseGuyItem(likeCnt=" + this.likeCnt + ", lastLikeMeTime=" + this.lastLikeMeTime + ", user=" + this.user + ")";
    }

    public /* synthetic */ PraiseGuyItem(int i, long j, User user, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, j, user);
    }
}

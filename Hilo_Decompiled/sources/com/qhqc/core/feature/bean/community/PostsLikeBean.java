package com.qhqc.core.feature.bean.community;

import androidx.collection.c;
import com.qhqc.core.feature.bean.UserInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsLikeBean;", "", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "isFollowUser", "", "likeCreatedAt", "", "<init>", "(Lcom/qhqc/core/feature/bean/UserInfoBean;ZJ)V", "getUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "()Z", "setFollowUser", "(Z)V", "getLikeCreatedAt", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsLikeBean {
    private boolean isFollowUser;
    private final long likeCreatedAt;

    @Nullable
    private final UserInfoBean user;

    public PostsLikeBean(@Nullable UserInfoBean userInfoBean, boolean z10, long j10) {
        this.user = userInfoBean;
        this.isFollowUser = z10;
        this.likeCreatedAt = j10;
    }

    public static /* synthetic */ PostsLikeBean copy$default(PostsLikeBean postsLikeBean, UserInfoBean userInfoBean, boolean z10, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            userInfoBean = postsLikeBean.user;
        }
        if ((i10 & 2) != 0) {
            z10 = postsLikeBean.isFollowUser;
        }
        if ((i10 & 4) != 0) {
            j10 = postsLikeBean.likeCreatedAt;
        }
        return postsLikeBean.copy(userInfoBean, z10, j10);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final UserInfoBean getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsFollowUser() {
        return this.isFollowUser;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLikeCreatedAt() {
        return this.likeCreatedAt;
    }

    @NotNull
    public final PostsLikeBean copy(@Nullable UserInfoBean user, boolean isFollowUser, long likeCreatedAt) {
        return new PostsLikeBean(user, isFollowUser, likeCreatedAt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsLikeBean)) {
            return false;
        }
        PostsLikeBean postsLikeBean = (PostsLikeBean) other;
        return Intrinsics.areEqual(this.user, postsLikeBean.user) && this.isFollowUser == postsLikeBean.isFollowUser && this.likeCreatedAt == postsLikeBean.likeCreatedAt;
    }

    public final long getLikeCreatedAt() {
        return this.likeCreatedAt;
    }

    @Nullable
    public final UserInfoBean getUser() {
        return this.user;
    }

    public int hashCode() {
        UserInfoBean userInfoBean = this.user;
        return ((((userInfoBean == null ? 0 : userInfoBean.hashCode()) * 31) + a.a(this.isFollowUser)) * 31) + c.a(this.likeCreatedAt);
    }

    public final boolean isFollowUser() {
        return this.isFollowUser;
    }

    public final void setFollowUser(boolean z10) {
        this.isFollowUser = z10;
    }

    @NotNull
    public String toString() {
        return "PostsLikeBean(user=" + this.user + ", isFollowUser=" + this.isFollowUser + ", likeCreatedAt=" + this.likeCreatedAt + ")";
    }
}

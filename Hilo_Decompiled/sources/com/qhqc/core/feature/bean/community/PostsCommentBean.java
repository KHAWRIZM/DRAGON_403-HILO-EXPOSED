package com.qhqc.core.feature.bean.community;

import androidx.collection.c;
import com.qhqc.core.feature.bean.UserInfoBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0089\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010C\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\rHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010%\"\u0004\b(\u0010'R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019¨\u0006G"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "", "commentId", "", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "content", "createdAt", "", "idDelete", "", "isLike", "likeCount", "", "subCommentCnt", "subComments", "", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "currentPageCursor", "nextPageCursor", "<init>", "(Ljava/lang/String;Lcom/qhqc/core/feature/bean/UserInfoBean;Ljava/lang/String;JZZIILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "getUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "setUser", "(Lcom/qhqc/core/feature/bean/UserInfoBean;)V", "getContent", "setContent", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "getIdDelete", "()Z", "setIdDelete", "(Z)V", "setLike", "getLikeCount", "()I", "setLikeCount", "(I)V", "getSubCommentCnt", "setSubCommentCnt", "getSubComments", "()Ljava/util/List;", "setSubComments", "(Ljava/util/List;)V", "getCurrentPageCursor", "setCurrentPageCursor", "getNextPageCursor", "setNextPageCursor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsCommentBean {

    @Nullable
    private String commentId;

    @Nullable
    private String content;
    private long createdAt;

    @Nullable
    private transient String currentPageCursor;
    private boolean idDelete;
    private boolean isLike;
    private int likeCount;

    @Nullable
    private transient String nextPageCursor;
    private int subCommentCnt;

    @Nullable
    private List<PostsCommentFloorBean> subComments;

    @Nullable
    private UserInfoBean user;

    public PostsCommentBean() {
        this(null, null, null, 0L, false, false, 0, 0, null, null, null, 2047, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getCurrentPageCursor() {
        return this.currentPageCursor;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getNextPageCursor() {
        return this.nextPageCursor;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final UserInfoBean getUser() {
        return this.user;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIdDelete() {
        return this.idDelete;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    /* renamed from: component7, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSubCommentCnt() {
        return this.subCommentCnt;
    }

    @Nullable
    public final List<PostsCommentFloorBean> component9() {
        return this.subComments;
    }

    @NotNull
    public final PostsCommentBean copy(@Nullable String commentId, @Nullable UserInfoBean user, @Nullable String content, long createdAt, boolean idDelete, boolean isLike, int likeCount, int subCommentCnt, @Nullable List<PostsCommentFloorBean> subComments, @Nullable String currentPageCursor, @Nullable String nextPageCursor) {
        return new PostsCommentBean(commentId, user, content, createdAt, idDelete, isLike, likeCount, subCommentCnt, subComments, currentPageCursor, nextPageCursor);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsCommentBean)) {
            return false;
        }
        PostsCommentBean postsCommentBean = (PostsCommentBean) other;
        return Intrinsics.areEqual(this.commentId, postsCommentBean.commentId) && Intrinsics.areEqual(this.user, postsCommentBean.user) && Intrinsics.areEqual(this.content, postsCommentBean.content) && this.createdAt == postsCommentBean.createdAt && this.idDelete == postsCommentBean.idDelete && this.isLike == postsCommentBean.isLike && this.likeCount == postsCommentBean.likeCount && this.subCommentCnt == postsCommentBean.subCommentCnt && Intrinsics.areEqual(this.subComments, postsCommentBean.subComments) && Intrinsics.areEqual(this.currentPageCursor, postsCommentBean.currentPageCursor) && Intrinsics.areEqual(this.nextPageCursor, postsCommentBean.nextPageCursor);
    }

    @Nullable
    public final String getCommentId() {
        return this.commentId;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getCurrentPageCursor() {
        return this.currentPageCursor;
    }

    public final boolean getIdDelete() {
        return this.idDelete;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final String getNextPageCursor() {
        return this.nextPageCursor;
    }

    public final int getSubCommentCnt() {
        return this.subCommentCnt;
    }

    @Nullable
    public final List<PostsCommentFloorBean> getSubComments() {
        return this.subComments;
    }

    @Nullable
    public final UserInfoBean getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.commentId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        UserInfoBean userInfoBean = this.user;
        int hashCode2 = (hashCode + (userInfoBean == null ? 0 : userInfoBean.hashCode())) * 31;
        String str2 = this.content;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + c.a(this.createdAt)) * 31) + a.a(this.idDelete)) * 31) + a.a(this.isLike)) * 31) + this.likeCount) * 31) + this.subCommentCnt) * 31;
        List<PostsCommentFloorBean> list = this.subComments;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.currentPageCursor;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nextPageCursor;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final void setCommentId(@Nullable String str) {
        this.commentId = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCreatedAt(long j10) {
        this.createdAt = j10;
    }

    public final void setCurrentPageCursor(@Nullable String str) {
        this.currentPageCursor = str;
    }

    public final void setIdDelete(boolean z10) {
        this.idDelete = z10;
    }

    public final void setLike(boolean z10) {
        this.isLike = z10;
    }

    public final void setLikeCount(int i10) {
        this.likeCount = i10;
    }

    public final void setNextPageCursor(@Nullable String str) {
        this.nextPageCursor = str;
    }

    public final void setSubCommentCnt(int i10) {
        this.subCommentCnt = i10;
    }

    public final void setSubComments(@Nullable List<PostsCommentFloorBean> list) {
        this.subComments = list;
    }

    public final void setUser(@Nullable UserInfoBean userInfoBean) {
        this.user = userInfoBean;
    }

    @NotNull
    public String toString() {
        return "PostsCommentBean(commentId=" + this.commentId + ", user=" + this.user + ", content=" + this.content + ", createdAt=" + this.createdAt + ", idDelete=" + this.idDelete + ", isLike=" + this.isLike + ", likeCount=" + this.likeCount + ", subCommentCnt=" + this.subCommentCnt + ", subComments=" + this.subComments + ", currentPageCursor=" + this.currentPageCursor + ", nextPageCursor=" + this.nextPageCursor + ")";
    }

    public PostsCommentBean(@Nullable String str, @Nullable UserInfoBean userInfoBean, @Nullable String str2, long j10, boolean z10, boolean z11, int i10, int i11, @Nullable List<PostsCommentFloorBean> list, @Nullable String str3, @Nullable String str4) {
        this.commentId = str;
        this.user = userInfoBean;
        this.content = str2;
        this.createdAt = j10;
        this.idDelete = z10;
        this.isLike = z11;
        this.likeCount = i10;
        this.subCommentCnt = i11;
        this.subComments = list;
        this.currentPageCursor = str3;
        this.nextPageCursor = str4;
    }

    public /* synthetic */ PostsCommentBean(String str, UserInfoBean userInfoBean, String str2, long j10, boolean z10, boolean z11, int i10, int i11, List list, String str3, String str4, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? null : userInfoBean, (i12 & 4) != 0 ? "" : str2, (i12 & 8) != 0 ? 0L : j10, (i12 & 16) != 0 ? false : z10, (i12 & 32) != 0 ? false : z11, (i12 & 64) != 0 ? 0 : i10, (i12 & 128) == 0 ? i11 : 0, (i12 & 256) == 0 ? list : null, (i12 & 512) != 0 ? "" : str3, (i12 & 1024) == 0 ? str4 : "");
    }
}

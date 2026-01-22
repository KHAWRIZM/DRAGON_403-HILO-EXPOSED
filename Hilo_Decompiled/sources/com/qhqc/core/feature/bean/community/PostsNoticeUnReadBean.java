package com.qhqc.core.feature.bean.community;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "", "likeCnt", "", "commentCnt", "totalCnt", "followPostCnt", "<init>", "(IIII)V", "getLikeCnt", "()I", "setLikeCnt", "(I)V", "getCommentCnt", "setCommentCnt", "getTotalCnt", "setTotalCnt", "getFollowPostCnt", "setFollowPostCnt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsNoticeUnReadBean {
    private int commentCnt;
    private int followPostCnt;
    private int likeCnt;
    private int totalCnt;

    public PostsNoticeUnReadBean() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ PostsNoticeUnReadBean copy$default(PostsNoticeUnReadBean postsNoticeUnReadBean, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = postsNoticeUnReadBean.likeCnt;
        }
        if ((i14 & 2) != 0) {
            i11 = postsNoticeUnReadBean.commentCnt;
        }
        if ((i14 & 4) != 0) {
            i12 = postsNoticeUnReadBean.totalCnt;
        }
        if ((i14 & 8) != 0) {
            i13 = postsNoticeUnReadBean.followPostCnt;
        }
        return postsNoticeUnReadBean.copy(i10, i11, i12, i13);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLikeCnt() {
        return this.likeCnt;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCommentCnt() {
        return this.commentCnt;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalCnt() {
        return this.totalCnt;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFollowPostCnt() {
        return this.followPostCnt;
    }

    @NotNull
    public final PostsNoticeUnReadBean copy(int likeCnt, int commentCnt, int totalCnt, int followPostCnt) {
        return new PostsNoticeUnReadBean(likeCnt, commentCnt, totalCnt, followPostCnt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsNoticeUnReadBean)) {
            return false;
        }
        PostsNoticeUnReadBean postsNoticeUnReadBean = (PostsNoticeUnReadBean) other;
        return this.likeCnt == postsNoticeUnReadBean.likeCnt && this.commentCnt == postsNoticeUnReadBean.commentCnt && this.totalCnt == postsNoticeUnReadBean.totalCnt && this.followPostCnt == postsNoticeUnReadBean.followPostCnt;
    }

    public final int getCommentCnt() {
        return this.commentCnt;
    }

    public final int getFollowPostCnt() {
        return this.followPostCnt;
    }

    public final int getLikeCnt() {
        return this.likeCnt;
    }

    public final int getTotalCnt() {
        return this.totalCnt;
    }

    public int hashCode() {
        return (((((this.likeCnt * 31) + this.commentCnt) * 31) + this.totalCnt) * 31) + this.followPostCnt;
    }

    public final void setCommentCnt(int i10) {
        this.commentCnt = i10;
    }

    public final void setFollowPostCnt(int i10) {
        this.followPostCnt = i10;
    }

    public final void setLikeCnt(int i10) {
        this.likeCnt = i10;
    }

    public final void setTotalCnt(int i10) {
        this.totalCnt = i10;
    }

    @NotNull
    public String toString() {
        return "PostsNoticeUnReadBean(likeCnt=" + this.likeCnt + ", commentCnt=" + this.commentCnt + ", totalCnt=" + this.totalCnt + ", followPostCnt=" + this.followPostCnt + ")";
    }

    public PostsNoticeUnReadBean(int i10, int i11, int i12, int i13) {
        this.likeCnt = i10;
        this.commentCnt = i11;
        this.totalCnt = i12;
        this.followPostCnt = i13;
    }

    public /* synthetic */ PostsNoticeUnReadBean(int i10, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13);
    }
}

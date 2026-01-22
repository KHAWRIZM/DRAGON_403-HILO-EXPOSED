package com.qhqc.core.feature.bean.community;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsNoticePostsInfoBean;", "", "deleted", "", "post", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "comments", "", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "<init>", "(ILcom/qhqc/core/feature/bean/community/PostsInfoBean;Ljava/util/List;)V", "getDeleted", "()I", "setDeleted", "(I)V", "getPost", "()Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "setPost", "(Lcom/qhqc/core/feature/bean/community/PostsInfoBean;)V", "getComments", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsNoticePostsInfoBean {

    @Nullable
    private List<PostsCommentBean> comments;
    private int deleted;

    @Nullable
    private PostsInfoBean post;

    public PostsNoticePostsInfoBean(int i10, @Nullable PostsInfoBean postsInfoBean, @Nullable List<PostsCommentBean> list) {
        this.deleted = i10;
        this.post = postsInfoBean;
        this.comments = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostsNoticePostsInfoBean copy$default(PostsNoticePostsInfoBean postsNoticePostsInfoBean, int i10, PostsInfoBean postsInfoBean, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = postsNoticePostsInfoBean.deleted;
        }
        if ((i11 & 2) != 0) {
            postsInfoBean = postsNoticePostsInfoBean.post;
        }
        if ((i11 & 4) != 0) {
            list = postsNoticePostsInfoBean.comments;
        }
        return postsNoticePostsInfoBean.copy(i10, postsInfoBean, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getDeleted() {
        return this.deleted;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final PostsInfoBean getPost() {
        return this.post;
    }

    @Nullable
    public final List<PostsCommentBean> component3() {
        return this.comments;
    }

    @NotNull
    public final PostsNoticePostsInfoBean copy(int deleted, @Nullable PostsInfoBean post, @Nullable List<PostsCommentBean> comments) {
        return new PostsNoticePostsInfoBean(deleted, post, comments);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsNoticePostsInfoBean)) {
            return false;
        }
        PostsNoticePostsInfoBean postsNoticePostsInfoBean = (PostsNoticePostsInfoBean) other;
        return this.deleted == postsNoticePostsInfoBean.deleted && Intrinsics.areEqual(this.post, postsNoticePostsInfoBean.post) && Intrinsics.areEqual(this.comments, postsNoticePostsInfoBean.comments);
    }

    @Nullable
    public final List<PostsCommentBean> getComments() {
        return this.comments;
    }

    public final int getDeleted() {
        return this.deleted;
    }

    @Nullable
    public final PostsInfoBean getPost() {
        return this.post;
    }

    public int hashCode() {
        int i10 = this.deleted * 31;
        PostsInfoBean postsInfoBean = this.post;
        int hashCode = (i10 + (postsInfoBean == null ? 0 : postsInfoBean.hashCode())) * 31;
        List<PostsCommentBean> list = this.comments;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setComments(@Nullable List<PostsCommentBean> list) {
        this.comments = list;
    }

    public final void setDeleted(int i10) {
        this.deleted = i10;
    }

    public final void setPost(@Nullable PostsInfoBean postsInfoBean) {
        this.post = postsInfoBean;
    }

    @NotNull
    public String toString() {
        return "PostsNoticePostsInfoBean(deleted=" + this.deleted + ", post=" + this.post + ", comments=" + this.comments + ")";
    }

    public /* synthetic */ PostsNoticePostsInfoBean(int i10, PostsInfoBean postsInfoBean, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, postsInfoBean, (i11 & 4) != 0 ? null : list);
    }
}

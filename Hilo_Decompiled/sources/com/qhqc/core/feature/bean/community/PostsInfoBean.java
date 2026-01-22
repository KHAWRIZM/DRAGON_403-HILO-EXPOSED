package com.qhqc.core.feature.bean.community;

import androidx.collection.c;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qhqc.core.feature.bean.UserInfoBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u000bHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\t\u0010F\u001a\u00020\u000fHÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J¡\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000bHÆ\u0001J\u0013\u0010I\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\u000fHÖ\u0001J\t\u0010M\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010&\"\u0004\b3\u0010(R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010.\"\u0004\b5\u00100R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R\u001a\u0010\u0014\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010&\"\u0004\b:\u0010(¨\u0006N"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "id", "", "content", "mediaResources", "", "Lcom/qhqc/core/feature/bean/community/PostsInfoMediaBean;", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "isFollowUser", "", "createdAt", "", "likeCount", "", "likeUserList", "isLike", "commentCount", "subCommentCnt", "itemType", "isShowAllContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/qhqc/core/feature/bean/UserInfoBean;ZJILjava/util/List;ZIIIZ)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getContent", "setContent", "getMediaResources", "()Ljava/util/List;", "setMediaResources", "(Ljava/util/List;)V", "getUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "setUser", "(Lcom/qhqc/core/feature/bean/UserInfoBean;)V", "()Z", "setFollowUser", "(Z)V", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "getLikeCount", "()I", "setLikeCount", "(I)V", "getLikeUserList", "setLikeUserList", "setLike", "getCommentCount", "setCommentCount", "getSubCommentCnt", "setSubCommentCnt", "getItemType", "setItemType", "setShowAllContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "", "hashCode", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsInfoBean implements MultiItemEntity {
    private int commentCount;

    @Nullable
    private String content;
    private long createdAt;

    @Nullable
    private String id;
    private boolean isFollowUser;
    private boolean isLike;
    private transient boolean isShowAllContent;
    private int itemType;
    private int likeCount;

    @Nullable
    private List<UserInfoBean> likeUserList;

    @Nullable
    private List<PostsInfoMediaBean> mediaResources;
    private int subCommentCnt;

    @Nullable
    private UserInfoBean user;

    public PostsInfoBean(@Nullable String str, @Nullable String str2, @Nullable List<PostsInfoMediaBean> list, @Nullable UserInfoBean userInfoBean, boolean z10, long j10, int i10, @Nullable List<UserInfoBean> list2, boolean z11, int i11, int i12, int i13, boolean z12) {
        this.id = str;
        this.content = str2;
        this.mediaResources = list;
        this.user = userInfoBean;
        this.isFollowUser = z10;
        this.createdAt = j10;
        this.likeCount = i10;
        this.likeUserList = list2;
        this.isLike = z11;
        this.commentCount = i11;
        this.subCommentCnt = i12;
        this.itemType = i13;
        this.isShowAllContent = z12;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getCommentCount() {
        return this.commentCount;
    }

    /* renamed from: component11, reason: from getter */
    public final int getSubCommentCnt() {
        return this.subCommentCnt;
    }

    /* renamed from: component12, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsShowAllContent() {
        return this.isShowAllContent;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final List<PostsInfoMediaBean> component3() {
        return this.mediaResources;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final UserInfoBean getUser() {
        return this.user;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFollowUser() {
        return this.isFollowUser;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component7, reason: from getter */
    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final List<UserInfoBean> component8() {
        return this.likeUserList;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsLike() {
        return this.isLike;
    }

    @NotNull
    public final PostsInfoBean copy(@Nullable String id, @Nullable String content, @Nullable List<PostsInfoMediaBean> mediaResources, @Nullable UserInfoBean user, boolean isFollowUser, long createdAt, int likeCount, @Nullable List<UserInfoBean> likeUserList, boolean isLike, int commentCount, int subCommentCnt, int itemType, boolean isShowAllContent) {
        return new PostsInfoBean(id, content, mediaResources, user, isFollowUser, createdAt, likeCount, likeUserList, isLike, commentCount, subCommentCnt, itemType, isShowAllContent);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsInfoBean)) {
            return false;
        }
        PostsInfoBean postsInfoBean = (PostsInfoBean) other;
        return Intrinsics.areEqual(this.id, postsInfoBean.id) && Intrinsics.areEqual(this.content, postsInfoBean.content) && Intrinsics.areEqual(this.mediaResources, postsInfoBean.mediaResources) && Intrinsics.areEqual(this.user, postsInfoBean.user) && this.isFollowUser == postsInfoBean.isFollowUser && this.createdAt == postsInfoBean.createdAt && this.likeCount == postsInfoBean.likeCount && Intrinsics.areEqual(this.likeUserList, postsInfoBean.likeUserList) && this.isLike == postsInfoBean.isLike && this.commentCount == postsInfoBean.commentCount && this.subCommentCnt == postsInfoBean.subCommentCnt && this.itemType == postsInfoBean.itemType && this.isShowAllContent == postsInfoBean.isShowAllContent;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final List<UserInfoBean> getLikeUserList() {
        return this.likeUserList;
    }

    @Nullable
    public final List<PostsInfoMediaBean> getMediaResources() {
        return this.mediaResources;
    }

    public final int getSubCommentCnt() {
        return this.subCommentCnt;
    }

    @Nullable
    public final UserInfoBean getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<PostsInfoMediaBean> list = this.mediaResources;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        UserInfoBean userInfoBean = this.user;
        int hashCode4 = (((((((hashCode3 + (userInfoBean == null ? 0 : userInfoBean.hashCode())) * 31) + a.a(this.isFollowUser)) * 31) + c.a(this.createdAt)) * 31) + this.likeCount) * 31;
        List<UserInfoBean> list2 = this.likeUserList;
        return ((((((((((hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31) + a.a(this.isLike)) * 31) + this.commentCount) * 31) + this.subCommentCnt) * 31) + this.itemType) * 31) + a.a(this.isShowAllContent);
    }

    public final boolean isFollowUser() {
        return this.isFollowUser;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final boolean isShowAllContent() {
        return this.isShowAllContent;
    }

    public final void setCommentCount(int i10) {
        this.commentCount = i10;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setCreatedAt(long j10) {
        this.createdAt = j10;
    }

    public final void setFollowUser(boolean z10) {
        this.isFollowUser = z10;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public void setItemType(int i10) {
        this.itemType = i10;
    }

    public final void setLike(boolean z10) {
        this.isLike = z10;
    }

    public final void setLikeCount(int i10) {
        this.likeCount = i10;
    }

    public final void setLikeUserList(@Nullable List<UserInfoBean> list) {
        this.likeUserList = list;
    }

    public final void setMediaResources(@Nullable List<PostsInfoMediaBean> list) {
        this.mediaResources = list;
    }

    public final void setShowAllContent(boolean z10) {
        this.isShowAllContent = z10;
    }

    public final void setSubCommentCnt(int i10) {
        this.subCommentCnt = i10;
    }

    public final void setUser(@Nullable UserInfoBean userInfoBean) {
        this.user = userInfoBean;
    }

    @NotNull
    public String toString() {
        return "PostsInfoBean(id=" + this.id + ", content=" + this.content + ", mediaResources=" + this.mediaResources + ", user=" + this.user + ", isFollowUser=" + this.isFollowUser + ", createdAt=" + this.createdAt + ", likeCount=" + this.likeCount + ", likeUserList=" + this.likeUserList + ", isLike=" + this.isLike + ", commentCount=" + this.commentCount + ", subCommentCnt=" + this.subCommentCnt + ", itemType=" + this.itemType + ", isShowAllContent=" + this.isShowAllContent + ")";
    }

    public /* synthetic */ PostsInfoBean(String str, String str2, List list, UserInfoBean userInfoBean, boolean z10, long j10, int i10, List list2, boolean z11, int i11, int i12, int i13, boolean z12, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i14 & 4) != 0 ? null : list, (i14 & 8) != 0 ? null : userInfoBean, (i14 & 16) != 0 ? false : z10, j10, (i14 & 64) != 0 ? 0 : i10, (i14 & 128) != 0 ? null : list2, (i14 & 256) != 0 ? false : z11, (i14 & 512) != 0 ? 0 : i11, (i14 & 1024) != 0 ? 0 : i12, i13, (i14 & 4096) != 0 ? false : z12);
    }
}

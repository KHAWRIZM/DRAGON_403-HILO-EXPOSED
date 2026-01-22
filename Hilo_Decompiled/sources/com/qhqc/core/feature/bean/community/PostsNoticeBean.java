package com.qhqc.core.feature.bean.community;

import androidx.collection.c;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.feature.bean.UserInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\u0085\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010?\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0007HÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u00100\"\u0004\b1\u00102¨\u0006C"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsNoticeBean;", "", "id", "", "user", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "type", "", "content", "targetType", "targetContent", "createdAt", "", ShareConstants.RESULT_POST_ID, "commentId", "contentShow", "isFirstHistory", "", "<init>", "(Ljava/lang/String;Lcom/qhqc/core/feature/bean/UserInfoBean;ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "setUser", "(Lcom/qhqc/core/feature/bean/UserInfoBean;)V", "getType", "()I", "setType", "(I)V", "getContent", "setContent", "getTargetType", "setTargetType", "getTargetContent", "setTargetContent", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "getPostId", "setPostId", "getCommentId", "setCommentId", "getContentShow", "setContentShow", "()Z", "setFirstHistory", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsNoticeBean {

    @Nullable
    private String commentId;

    @Nullable
    private String content;

    @Nullable
    private transient String contentShow;
    private long createdAt;

    @Nullable
    private String id;
    private transient boolean isFirstHistory;

    @Nullable
    private String postId;

    @Nullable
    private String targetContent;
    private int targetType;
    private int type;

    @Nullable
    private UserInfoBean user;

    public PostsNoticeBean(@Nullable String str, @Nullable UserInfoBean userInfoBean, int i10, @Nullable String str2, int i11, @Nullable String str3, long j10, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z10) {
        this.id = str;
        this.user = userInfoBean;
        this.type = i10;
        this.content = str2;
        this.targetType = i11;
        this.targetContent = str3;
        this.createdAt = j10;
        this.postId = str4;
        this.commentId = str5;
        this.contentShow = str6;
        this.isFirstHistory = z10;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getContentShow() {
        return this.contentShow;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsFirstHistory() {
        return this.isFirstHistory;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final UserInfoBean getUser() {
        return this.user;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTargetType() {
        return this.targetType;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTargetContent() {
        return this.targetContent;
    }

    /* renamed from: component7, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    @NotNull
    public final PostsNoticeBean copy(@Nullable String id, @Nullable UserInfoBean user, int type, @Nullable String content, int targetType, @Nullable String targetContent, long createdAt, @Nullable String postId, @Nullable String commentId, @Nullable String contentShow, boolean isFirstHistory) {
        return new PostsNoticeBean(id, user, type, content, targetType, targetContent, createdAt, postId, commentId, contentShow, isFirstHistory);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsNoticeBean)) {
            return false;
        }
        PostsNoticeBean postsNoticeBean = (PostsNoticeBean) other;
        return Intrinsics.areEqual(this.id, postsNoticeBean.id) && Intrinsics.areEqual(this.user, postsNoticeBean.user) && this.type == postsNoticeBean.type && Intrinsics.areEqual(this.content, postsNoticeBean.content) && this.targetType == postsNoticeBean.targetType && Intrinsics.areEqual(this.targetContent, postsNoticeBean.targetContent) && this.createdAt == postsNoticeBean.createdAt && Intrinsics.areEqual(this.postId, postsNoticeBean.postId) && Intrinsics.areEqual(this.commentId, postsNoticeBean.commentId) && Intrinsics.areEqual(this.contentShow, postsNoticeBean.contentShow) && this.isFirstHistory == postsNoticeBean.isFirstHistory;
    }

    @Nullable
    public final String getCommentId() {
        return this.commentId;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getContentShow() {
        return this.contentShow;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }

    @Nullable
    public final String getTargetContent() {
        return this.targetContent;
    }

    public final int getTargetType() {
        return this.targetType;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final UserInfoBean getUser() {
        return this.user;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        UserInfoBean userInfoBean = this.user;
        int hashCode2 = (((hashCode + (userInfoBean == null ? 0 : userInfoBean.hashCode())) * 31) + this.type) * 31;
        String str2 = this.content;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.targetType) * 31;
        String str3 = this.targetContent;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + c.a(this.createdAt)) * 31;
        String str4 = this.postId;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.commentId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.contentShow;
        return ((hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + a.a(this.isFirstHistory);
    }

    public final boolean isFirstHistory() {
        return this.isFirstHistory;
    }

    public final void setCommentId(@Nullable String str) {
        this.commentId = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setContentShow(@Nullable String str) {
        this.contentShow = str;
    }

    public final void setCreatedAt(long j10) {
        this.createdAt = j10;
    }

    public final void setFirstHistory(boolean z10) {
        this.isFirstHistory = z10;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setPostId(@Nullable String str) {
        this.postId = str;
    }

    public final void setTargetContent(@Nullable String str) {
        this.targetContent = str;
    }

    public final void setTargetType(int i10) {
        this.targetType = i10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setUser(@Nullable UserInfoBean userInfoBean) {
        this.user = userInfoBean;
    }

    @NotNull
    public String toString() {
        return "PostsNoticeBean(id=" + this.id + ", user=" + this.user + ", type=" + this.type + ", content=" + this.content + ", targetType=" + this.targetType + ", targetContent=" + this.targetContent + ", createdAt=" + this.createdAt + ", postId=" + this.postId + ", commentId=" + this.commentId + ", contentShow=" + this.contentShow + ", isFirstHistory=" + this.isFirstHistory + ")";
    }

    public /* synthetic */ PostsNoticeBean(String str, UserInfoBean userInfoBean, int i10, String str2, int i11, String str3, long j10, String str4, String str5, String str6, boolean z10, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, userInfoBean, i10, str2, i11, str3, j10, str4, str5, str6, (i12 & 1024) != 0 ? false : z10);
    }
}

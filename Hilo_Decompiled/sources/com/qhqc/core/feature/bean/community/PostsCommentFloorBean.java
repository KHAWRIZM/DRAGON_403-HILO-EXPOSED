package com.qhqc.core.feature.bean.community;

import android.text.SpannableStringBuilder;
import androidx.collection.c;
import com.qhqc.core.feature.bean.UserInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003JO\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "", "commentId", "", "content", "createdAt", "", "fromUser", "Lcom/qhqc/core/feature/bean/UserInfoBean;", "toUser", "strBuilder", "Landroid/text/SpannableStringBuilder;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/qhqc/core/feature/bean/UserInfoBean;Lcom/qhqc/core/feature/bean/UserInfoBean;Landroid/text/SpannableStringBuilder;)V", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "getContent", "setContent", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "getFromUser", "()Lcom/qhqc/core/feature/bean/UserInfoBean;", "setFromUser", "(Lcom/qhqc/core/feature/bean/UserInfoBean;)V", "getToUser", "setToUser", "getStrBuilder", "()Landroid/text/SpannableStringBuilder;", "setStrBuilder", "(Landroid/text/SpannableStringBuilder;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsCommentFloorBean {

    @Nullable
    private String commentId;

    @Nullable
    private String content;
    private long createdAt;

    @Nullable
    private UserInfoBean fromUser;

    @Nullable
    private transient SpannableStringBuilder strBuilder;

    @Nullable
    private UserInfoBean toUser;

    public PostsCommentFloorBean() {
        this(null, null, 0L, null, null, null, 63, null);
    }

    public static /* synthetic */ PostsCommentFloorBean copy$default(PostsCommentFloorBean postsCommentFloorBean, String str, String str2, long j10, UserInfoBean userInfoBean, UserInfoBean userInfoBean2, SpannableStringBuilder spannableStringBuilder, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = postsCommentFloorBean.commentId;
        }
        if ((i10 & 2) != 0) {
            str2 = postsCommentFloorBean.content;
        }
        String str3 = str2;
        if ((i10 & 4) != 0) {
            j10 = postsCommentFloorBean.createdAt;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            userInfoBean = postsCommentFloorBean.fromUser;
        }
        UserInfoBean userInfoBean3 = userInfoBean;
        if ((i10 & 16) != 0) {
            userInfoBean2 = postsCommentFloorBean.toUser;
        }
        UserInfoBean userInfoBean4 = userInfoBean2;
        if ((i10 & 32) != 0) {
            spannableStringBuilder = postsCommentFloorBean.strBuilder;
        }
        return postsCommentFloorBean.copy(str, str3, j11, userInfoBean3, userInfoBean4, spannableStringBuilder);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final UserInfoBean getFromUser() {
        return this.fromUser;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final UserInfoBean getToUser() {
        return this.toUser;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final SpannableStringBuilder getStrBuilder() {
        return this.strBuilder;
    }

    @NotNull
    public final PostsCommentFloorBean copy(@Nullable String commentId, @Nullable String content, long createdAt, @Nullable UserInfoBean fromUser, @Nullable UserInfoBean toUser, @Nullable SpannableStringBuilder strBuilder) {
        return new PostsCommentFloorBean(commentId, content, createdAt, fromUser, toUser, strBuilder);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsCommentFloorBean)) {
            return false;
        }
        PostsCommentFloorBean postsCommentFloorBean = (PostsCommentFloorBean) other;
        return Intrinsics.areEqual(this.commentId, postsCommentFloorBean.commentId) && Intrinsics.areEqual(this.content, postsCommentFloorBean.content) && this.createdAt == postsCommentFloorBean.createdAt && Intrinsics.areEqual(this.fromUser, postsCommentFloorBean.fromUser) && Intrinsics.areEqual(this.toUser, postsCommentFloorBean.toUser) && Intrinsics.areEqual(this.strBuilder, postsCommentFloorBean.strBuilder);
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
    public final UserInfoBean getFromUser() {
        return this.fromUser;
    }

    @Nullable
    public final SpannableStringBuilder getStrBuilder() {
        return this.strBuilder;
    }

    @Nullable
    public final UserInfoBean getToUser() {
        return this.toUser;
    }

    public int hashCode() {
        String str = this.commentId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + c.a(this.createdAt)) * 31;
        UserInfoBean userInfoBean = this.fromUser;
        int hashCode3 = (hashCode2 + (userInfoBean == null ? 0 : userInfoBean.hashCode())) * 31;
        UserInfoBean userInfoBean2 = this.toUser;
        int hashCode4 = (hashCode3 + (userInfoBean2 == null ? 0 : userInfoBean2.hashCode())) * 31;
        SpannableStringBuilder spannableStringBuilder = this.strBuilder;
        return hashCode4 + (spannableStringBuilder != null ? spannableStringBuilder.hashCode() : 0);
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

    public final void setFromUser(@Nullable UserInfoBean userInfoBean) {
        this.fromUser = userInfoBean;
    }

    public final void setStrBuilder(@Nullable SpannableStringBuilder spannableStringBuilder) {
        this.strBuilder = spannableStringBuilder;
    }

    public final void setToUser(@Nullable UserInfoBean userInfoBean) {
        this.toUser = userInfoBean;
    }

    @NotNull
    public String toString() {
        return "PostsCommentFloorBean(commentId=" + this.commentId + ", content=" + this.content + ", createdAt=" + this.createdAt + ", fromUser=" + this.fromUser + ", toUser=" + this.toUser + ", strBuilder=" + ((Object) this.strBuilder) + ")";
    }

    public PostsCommentFloorBean(@Nullable String str, @Nullable String str2, long j10, @Nullable UserInfoBean userInfoBean, @Nullable UserInfoBean userInfoBean2, @Nullable SpannableStringBuilder spannableStringBuilder) {
        this.commentId = str;
        this.content = str2;
        this.createdAt = j10;
        this.fromUser = userInfoBean;
        this.toUser = userInfoBean2;
        this.strBuilder = spannableStringBuilder;
    }

    public /* synthetic */ PostsCommentFloorBean(String str, String str2, long j10, UserInfoBean userInfoBean, UserInfoBean userInfoBean2, SpannableStringBuilder spannableStringBuilder, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) == 0 ? str2 : "", (i10 & 4) != 0 ? 0L : j10, (i10 & 8) != 0 ? null : userInfoBean, (i10 & 16) != 0 ? null : userInfoBean2, (i10 & 32) != 0 ? null : spannableStringBuilder);
    }
}

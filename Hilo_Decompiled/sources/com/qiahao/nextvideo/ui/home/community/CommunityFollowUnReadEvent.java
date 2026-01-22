package com.qiahao.nextvideo.ui.home.community;

import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/community/CommunityFollowUnReadEvent;", "", "postsNoticeUnReadBean", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "<init>", "(Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;)V", "getPostsNoticeUnReadBean", "()Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class CommunityFollowUnReadEvent {

    @NotNull
    private final PostsNoticeUnReadBean postsNoticeUnReadBean;

    public CommunityFollowUnReadEvent(@NotNull PostsNoticeUnReadBean postsNoticeUnReadBean) {
        Intrinsics.checkNotNullParameter(postsNoticeUnReadBean, "postsNoticeUnReadBean");
        this.postsNoticeUnReadBean = postsNoticeUnReadBean;
    }

    public static /* synthetic */ CommunityFollowUnReadEvent copy$default(CommunityFollowUnReadEvent communityFollowUnReadEvent, PostsNoticeUnReadBean postsNoticeUnReadBean, int i, Object obj) {
        if ((i & 1) != 0) {
            postsNoticeUnReadBean = communityFollowUnReadEvent.postsNoticeUnReadBean;
        }
        return communityFollowUnReadEvent.copy(postsNoticeUnReadBean);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final PostsNoticeUnReadBean getPostsNoticeUnReadBean() {
        return this.postsNoticeUnReadBean;
    }

    @NotNull
    public final CommunityFollowUnReadEvent copy(@NotNull PostsNoticeUnReadBean postsNoticeUnReadBean) {
        Intrinsics.checkNotNullParameter(postsNoticeUnReadBean, "postsNoticeUnReadBean");
        return new CommunityFollowUnReadEvent(postsNoticeUnReadBean);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CommunityFollowUnReadEvent) && Intrinsics.areEqual(this.postsNoticeUnReadBean, ((CommunityFollowUnReadEvent) other).postsNoticeUnReadBean);
    }

    @NotNull
    public final PostsNoticeUnReadBean getPostsNoticeUnReadBean() {
        return this.postsNoticeUnReadBean;
    }

    public int hashCode() {
        return this.postsNoticeUnReadBean.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommunityFollowUnReadEvent(postsNoticeUnReadBean=" + this.postsNoticeUnReadBean + ")";
    }
}

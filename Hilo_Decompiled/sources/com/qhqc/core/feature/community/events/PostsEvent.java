package com.qhqc.core.feature.community.events;

import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/qhqc/core/feature/community/events/PostsEvent;", "Lcom/qhqc/core/feature/community/events/BaseEvent;", "event", "", ShareConstants.RESULT_POST_ID, "", "postsInfo", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "<init>", "(ILjava/lang/String;Lcom/qhqc/core/feature/bean/community/PostsInfoBean;)V", "getEvent", "()I", "getPostId", "()Ljava/lang/String;", "getPostsInfo", "()Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsEvent extends BaseEvent {
    public static final int EVENT_COMMENT_COUNT_CHANGED = 4097;
    public static final int EVENT_COMMENT_LIKE_CHANGED = 4098;
    public static final int EVENT_CREATE = 4096;
    public static final int EVENT_REMOVED = 4099;
    public static final int EVENT_SHOW_MORE_CONTENT = 4100;
    private final int event;

    @Nullable
    private final String postId;

    @Nullable
    private final PostsInfoBean postsInfo;

    public /* synthetic */ PostsEvent(int i10, String str, PostsInfoBean postsInfoBean, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, (i11 & 4) != 0 ? null : postsInfoBean);
    }

    public final int getEvent() {
        return this.event;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }

    @Nullable
    public final PostsInfoBean getPostsInfo() {
        return this.postsInfo;
    }

    public PostsEvent(int i10, @Nullable String str, @Nullable PostsInfoBean postsInfoBean) {
        this.event = i10;
        this.postId = str;
        this.postsInfo = postsInfoBean;
    }
}

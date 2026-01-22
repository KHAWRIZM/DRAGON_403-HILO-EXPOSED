package com.qhqc.core.feature.community.events;

import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\b\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\u0018R$\u0010#\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014¨\u0006'"}, d2 = {"Lcom/qhqc/core/feature/community/events/CommentEvent;", "Lcom/qhqc/core/feature/community/events/BaseEvent;", "", "event", "", ShareConstants.RESULT_POST_ID, "<init>", "(ILjava/lang/String;)V", "I", "getEvent", "()I", "Ljava/lang/String;", "getPostId", "()Ljava/lang/String;", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "item", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "getItem", "()Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "setItem", "(Lcom/qhqc/core/feature/bean/community/PostsCommentBean;)V", "position", "getPosition", "setPosition", "(I)V", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "itemCommentFloor", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "getItemCommentFloor", "()Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "setItemCommentFloor", "(Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;)V", "itemCommentFloorPosition", "getItemCommentFloorPosition", "setItemCommentFloorPosition", "commentSent", "getCommentSent", "setCommentSent", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommentEvent extends BaseEvent {
    public static final int EVENT_COMMENT_FLOOR_DELETED = 8199;
    public static final int EVENT_DELETED = 8198;
    public static final int EVENT_LIKE = 8193;
    public static final int EVENT_MORE_COMMENT_FLOOR = 8197;
    public static final int EVENT_REPLY = 8195;
    public static final int EVENT_REPLY_FLOOR = 8196;
    public static final int EVENT_SEND = 8194;

    @Nullable
    private PostsCommentBean commentSent;
    private final int event;

    @Nullable
    private PostsCommentBean item;

    @Nullable
    private PostsCommentFloorBean itemCommentFloor;

    @Nullable
    private final String postId;
    private int position = -1;
    private int itemCommentFloorPosition = -1;

    public CommentEvent(int i10, @Nullable String str) {
        this.event = i10;
        this.postId = str;
    }

    @Nullable
    public final PostsCommentBean getCommentSent() {
        return this.commentSent;
    }

    public final int getEvent() {
        return this.event;
    }

    @Nullable
    public final PostsCommentBean getItem() {
        return this.item;
    }

    @Nullable
    public final PostsCommentFloorBean getItemCommentFloor() {
        return this.itemCommentFloor;
    }

    public final int getItemCommentFloorPosition() {
        return this.itemCommentFloorPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final String getPostId() {
        return this.postId;
    }

    public final void setCommentSent(@Nullable PostsCommentBean postsCommentBean) {
        this.commentSent = postsCommentBean;
    }

    public final void setItem(@Nullable PostsCommentBean postsCommentBean) {
        this.item = postsCommentBean;
    }

    public final void setItemCommentFloor(@Nullable PostsCommentFloorBean postsCommentFloorBean) {
        this.itemCommentFloor = postsCommentFloorBean;
    }

    public final void setItemCommentFloorPosition(int i10) {
        this.itemCommentFloorPosition = i10;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }
}

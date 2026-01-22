package com.qhqc.core.feature.community.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/qhqc/core/feature/community/events/IEventsCallback;", "", "onCommentEvent", "", "event", "Lcom/qhqc/core/feature/community/events/CommentEvent;", "onPostsEvent", "Lcom/qhqc/core/feature/community/events/PostsEvent;", "onUserEvent", "Lcom/qhqc/core/feature/community/events/UserOperateEvent;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface IEventsCallback {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onCommentEvent(@NotNull IEventsCallback iEventsCallback, @NotNull CommentEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        public static void onPostsEvent(@NotNull IEventsCallback iEventsCallback, @NotNull PostsEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        public static void onUserEvent(@NotNull IEventsCallback iEventsCallback, @NotNull UserOperateEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    void onCommentEvent(@NotNull CommentEvent event);

    void onPostsEvent(@NotNull PostsEvent event);

    void onUserEvent(@NotNull UserOperateEvent event);
}

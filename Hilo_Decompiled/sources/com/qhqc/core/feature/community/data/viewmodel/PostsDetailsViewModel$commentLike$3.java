package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.events.CommentEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$commentLike$3", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsDetailsViewModel$commentLike$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostsCommentBean $item;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$commentLike$3(PostsCommentBean postsCommentBean, PostsDetailsViewModel postsDetailsViewModel, int i10, Continuation<? super PostsDetailsViewModel$commentLike$3> continuation) {
        super(2, continuation);
        this.$item = postsCommentBean;
        this.this$0 = postsDetailsViewModel;
        this.$position = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsDetailsViewModel$commentLike$3(this.$item, this.this$0, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$item.setLike(!r4.isLike());
            if (this.$item.isLike()) {
                PostsCommentBean postsCommentBean = this.$item;
                postsCommentBean.setLikeCount(postsCommentBean.getLikeCount() + 1);
            } else {
                this.$item.setLikeCount(r4.getLikeCount() - 1);
            }
            CommunityManager companion = CommunityManager.INSTANCE.getInstance();
            CommentEvent commentEvent = new CommentEvent(CommentEvent.EVENT_LIKE, this.this$0.getPostId());
            PostsCommentBean postsCommentBean2 = this.$item;
            int i10 = this.$position;
            commentEvent.setItem(postsCommentBean2);
            commentEvent.setPosition(i10);
            companion.dispatchCommentEvent$feature_community_release(commentEvent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$commentLike$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

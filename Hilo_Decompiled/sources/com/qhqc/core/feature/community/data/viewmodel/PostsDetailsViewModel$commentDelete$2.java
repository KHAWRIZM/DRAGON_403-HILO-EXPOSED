package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.qhqc.core.feature.community.events.PostsEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$commentDelete$2", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsDetailsViewModel$commentDelete$2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostsCommentBean $itemComment;
    final /* synthetic */ PostsCommentFloorBean $itemCommentFloor;
    final /* synthetic */ int $positionComment;
    final /* synthetic */ int $positionCommentFloor;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$commentDelete$2(PostsCommentFloorBean postsCommentFloorBean, PostsDetailsViewModel postsDetailsViewModel, PostsCommentBean postsCommentBean, int i10, int i11, Continuation<? super PostsDetailsViewModel$commentDelete$2> continuation) {
        super(2, continuation);
        this.$itemCommentFloor = postsCommentFloorBean;
        this.this$0 = postsDetailsViewModel;
        this.$itemComment = postsCommentBean;
        this.$positionComment = i10;
        this.$positionCommentFloor = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsDetailsViewModel$commentDelete$2(this.$itemCommentFloor, this.this$0, this.$itemComment, this.$positionComment, this.$positionCommentFloor, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$itemCommentFloor == null) {
                PostsInfoBean postsInfoBean = (PostsInfoBean) this.this$0.getPostsInfoLiveData().getValue();
                if (postsInfoBean != null) {
                    PostsCommentBean postsCommentBean = this.$itemComment;
                    PostsDetailsViewModel postsDetailsViewModel = this.this$0;
                    postsInfoBean.setCommentCount(postsInfoBean.getCommentCount() - (postsCommentBean.getSubCommentCnt() + 1));
                    CommunityManager.INSTANCE.getInstance().dispatchPostsEvent$feature_community_release(new PostsEvent(4097, postsDetailsViewModel.getPostId(), postsInfoBean));
                }
                CommunityManager companion = CommunityManager.INSTANCE.getInstance();
                CommentEvent commentEvent = new CommentEvent(CommentEvent.EVENT_DELETED, this.this$0.getPostId());
                PostsCommentBean postsCommentBean2 = this.$itemComment;
                int i10 = this.$positionComment;
                commentEvent.setItem(postsCommentBean2);
                commentEvent.setPosition(i10);
                companion.dispatchCommentEvent$feature_community_release(commentEvent);
            } else {
                PostsInfoBean postsInfoBean2 = (PostsInfoBean) this.this$0.getPostsInfoLiveData().getValue();
                if (postsInfoBean2 != null) {
                    PostsCommentBean postsCommentBean3 = this.$itemComment;
                    PostsDetailsViewModel postsDetailsViewModel2 = this.this$0;
                    postsCommentBean3.setSubCommentCnt(postsCommentBean3.getSubCommentCnt() - 1);
                    postsInfoBean2.setCommentCount(postsInfoBean2.getCommentCount() - 1);
                    CommunityManager.INSTANCE.getInstance().dispatchPostsEvent$feature_community_release(new PostsEvent(4097, postsDetailsViewModel2.getPostId(), postsInfoBean2));
                }
                CommunityManager companion2 = CommunityManager.INSTANCE.getInstance();
                CommentEvent commentEvent2 = new CommentEvent(CommentEvent.EVENT_COMMENT_FLOOR_DELETED, this.this$0.getPostId());
                PostsCommentBean postsCommentBean4 = this.$itemComment;
                int i11 = this.$positionComment;
                PostsCommentFloorBean postsCommentFloorBean = this.$itemCommentFloor;
                int i12 = this.$positionCommentFloor;
                commentEvent2.setItem(postsCommentBean4);
                commentEvent2.setPosition(i11);
                commentEvent2.setItemCommentFloor(postsCommentFloorBean);
                commentEvent2.setItemCommentFloorPosition(i12);
                companion2.dispatchCommentEvent$feature_community_release(commentEvent2);
            }
            this.this$0.showToast(R.string.feature_community_delete_success);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$commentDelete$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$sendComment$1$3", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsDetailsViewModel$sendComment$1$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ PostsInfoBean $postsInfo;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$sendComment$1$3(PostsDetailsViewModel postsDetailsViewModel, PostsInfoBean postsInfoBean, String str, Continuation<? super PostsDetailsViewModel$sendComment$1$3> continuation) {
        super(2, continuation);
        this.this$0 = postsDetailsViewModel;
        this.$postsInfo = postsInfoBean;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsDetailsViewModel$sendComment$1$3 postsDetailsViewModel$sendComment$1$3 = new PostsDetailsViewModel$sendComment$1$3(this.this$0, this.$postsInfo, this.$content, continuation);
        postsDetailsViewModel$sendComment$1$3.L$0 = obj;
        return postsDetailsViewModel$sendComment$1$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            CommunityManager companion2 = companion.getInstance();
            CommentEvent commentEvent = new CommentEvent(8194, this.this$0.getPostId());
            commentEvent.setCommentSent(new PostsCommentBean(str, companion.getInstance().getMyUserInfo(), this.$content, System.currentTimeMillis(), false, false, 0, 0, null, null, null, 2032, null));
            companion2.dispatchCommentEvent$feature_community_release(commentEvent);
            PostsInfoBean postsInfoBean = this.$postsInfo;
            postsInfoBean.setCommentCount(postsInfoBean.getCommentCount() + 1);
            companion.getInstance().dispatchPostsEvent$feature_community_release(new PostsEvent(4097, this.this$0.getPostId(), this.$postsInfo));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$sendComment$1$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

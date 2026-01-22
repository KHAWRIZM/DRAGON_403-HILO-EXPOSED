package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.PageDataBean;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorListBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$loadMoreCommentFloor$3", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsDetailsViewModel$loadMoreCommentFloor$3 extends SuspendLambda implements Function2<PostsCommentFloorListBean, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostsCommentBean $item;
    final /* synthetic */ int $position;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$loadMoreCommentFloor$3(PostsCommentBean postsCommentBean, PostsDetailsViewModel postsDetailsViewModel, int i10, Continuation<? super PostsDetailsViewModel$loadMoreCommentFloor$3> continuation) {
        super(2, continuation);
        this.$item = postsCommentBean;
        this.this$0 = postsDetailsViewModel;
        this.$position = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsDetailsViewModel$loadMoreCommentFloor$3 postsDetailsViewModel$loadMoreCommentFloor$3 = new PostsDetailsViewModel$loadMoreCommentFloor$3(this.$item, this.this$0, this.$position, continuation);
        postsDetailsViewModel$loadMoreCommentFloor$3.L$0 = obj;
        return postsDetailsViewModel$loadMoreCommentFloor$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsCommentFloorListBean postsCommentFloorListBean, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$loadMoreCommentFloor$3) create(postsCommentFloorListBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PostsCommentFloorListBean postsCommentFloorListBean = (PostsCommentFloorListBean) this.L$0;
            PostsCommentBean postsCommentBean = this.$item;
            postsCommentBean.setCurrentPageCursor(postsCommentBean.getNextPageCursor());
            this.$item.setNextPageCursor(postsCommentFloorListBean.getPageCursor());
            this.this$0.setCommentFloorInfos(postsCommentFloorListBean.getData());
            this.this$0.getCommentFloorListMoreLiveData().postValue(new Triple(PageDataBean.toPageData$default(postsCommentFloorListBean, 0, "", 1, null), this.$item, Boxing.boxInt(this.$position)));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

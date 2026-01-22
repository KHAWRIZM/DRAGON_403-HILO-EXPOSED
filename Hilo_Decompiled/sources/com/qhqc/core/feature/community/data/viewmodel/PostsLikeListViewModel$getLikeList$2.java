package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.PageDataBean;
import com.qhqc.core.feature.bean.community.PostsLikeListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsLikeListBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsLikeListViewModel$getLikeList$2", f = "PostsLikeListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsLikeListViewModel$getLikeList$2 extends SuspendLambda implements Function2<PostsLikeListBean, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageCursor;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsLikeListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsLikeListViewModel$getLikeList$2(PostsLikeListViewModel postsLikeListViewModel, String str, Continuation<? super PostsLikeListViewModel$getLikeList$2> continuation) {
        super(2, continuation);
        this.this$0 = postsLikeListViewModel;
        this.$pageCursor = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsLikeListViewModel$getLikeList$2 postsLikeListViewModel$getLikeList$2 = new PostsLikeListViewModel$getLikeList$2(this.this$0, this.$pageCursor, continuation);
        postsLikeListViewModel$getLikeList$2.L$0 = obj;
        return postsLikeListViewModel$getLikeList$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsLikeListBean postsLikeListBean, Continuation<? super Unit> continuation) {
        return ((PostsLikeListViewModel$getLikeList$2) create(postsLikeListBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getLikeListLiveData().postValue(PageDataBean.toPageData$default((PostsLikeListBean) this.L$0, 0, this.$pageCursor, 1, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

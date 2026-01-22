package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsInfoListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsInfoListBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$getUserPostsTotal$2", f = "PostsSquareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsSquareViewModel$getUserPostsTotal$2 extends SuspendLambda implements Function2<PostsInfoListBean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsSquareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsSquareViewModel$getUserPostsTotal$2(PostsSquareViewModel postsSquareViewModel, Continuation<? super PostsSquareViewModel$getUserPostsTotal$2> continuation) {
        super(2, continuation);
        this.this$0 = postsSquareViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsSquareViewModel$getUserPostsTotal$2 postsSquareViewModel$getUserPostsTotal$2 = new PostsSquareViewModel$getUserPostsTotal$2(this.this$0, continuation);
        postsSquareViewModel$getUserPostsTotal$2.L$0 = obj;
        return postsSquareViewModel$getUserPostsTotal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsInfoListBean postsInfoListBean, Continuation<? super Unit> continuation) {
        return ((PostsSquareViewModel$getUserPostsTotal$2) create(postsInfoListBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getPostUserTotalCount().postValue(Boxing.boxInt(((PostsInfoListBean) this.L$0).getTotal()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

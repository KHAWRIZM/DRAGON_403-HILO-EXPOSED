package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getPostsDetail$3", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsDetailsViewModel$getPostsDetail$3 extends SuspendLambda implements Function2<PostsInfoBean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$getPostsDetail$3(PostsDetailsViewModel postsDetailsViewModel, Continuation<? super PostsDetailsViewModel$getPostsDetail$3> continuation) {
        super(2, continuation);
        this.this$0 = postsDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsDetailsViewModel$getPostsDetail$3 postsDetailsViewModel$getPostsDetail$3 = new PostsDetailsViewModel$getPostsDetail$3(this.this$0, continuation);
        postsDetailsViewModel$getPostsDetail$3.L$0 = obj;
        return postsDetailsViewModel$getPostsDetail$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsInfoBean postsInfoBean, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$getPostsDetail$3) create(postsInfoBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PostsInfoBean postsInfoBean = (PostsInfoBean) this.L$0;
            String id = postsInfoBean.getId();
            if (id != null && id.length() != 0) {
                this.this$0.getPostsInfoLiveData().postValue(CommunityUtils.INSTANCE.setPostInfoData(postsInfoBean));
                return Unit.INSTANCE;
            }
            this.this$0.getDeletedStateLiveData().postValue(Boxing.boxInt(1));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

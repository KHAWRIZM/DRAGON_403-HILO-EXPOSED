package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.NewestUserBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/qhqc/core/feature/bean/community/NewestUserBean;", "Lkotlin/collections/ArrayList;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel$getPostNewestUserList$2", f = "PostsNoticeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsNoticeViewModel$getPostNewestUserList$2 extends SuspendLambda implements Function2<ArrayList<NewestUserBean>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsNoticeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsNoticeViewModel$getPostNewestUserList$2(PostsNoticeViewModel postsNoticeViewModel, Continuation<? super PostsNoticeViewModel$getPostNewestUserList$2> continuation) {
        super(2, continuation);
        this.this$0 = postsNoticeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsNoticeViewModel$getPostNewestUserList$2 postsNoticeViewModel$getPostNewestUserList$2 = new PostsNoticeViewModel$getPostNewestUserList$2(this.this$0, continuation);
        postsNoticeViewModel$getPostNewestUserList$2.L$0 = obj;
        return postsNoticeViewModel$getPostNewestUserList$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getPostNewestUserList().postValue((ArrayList) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ArrayList<NewestUserBean> arrayList, Continuation<? super Unit> continuation) {
        return ((PostsNoticeViewModel$getPostNewestUserList$2) create(arrayList, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

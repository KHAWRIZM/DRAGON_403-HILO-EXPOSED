package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.PageDataBean;
import com.qhqc.core.feature.bean.community.PostsNoticeListBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsNoticeListBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel$getNoticeList$3", f = "PostsNoticeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsNoticeViewModel$getNoticeList$3 extends SuspendLambda implements Function2<PostsNoticeListBean, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageCursor;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsNoticeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsNoticeViewModel$getNoticeList$3(PostsNoticeViewModel postsNoticeViewModel, String str, Continuation<? super PostsNoticeViewModel$getNoticeList$3> continuation) {
        super(2, continuation);
        this.this$0 = postsNoticeViewModel;
        this.$pageCursor = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsNoticeViewModel$getNoticeList$3 postsNoticeViewModel$getNoticeList$3 = new PostsNoticeViewModel$getNoticeList$3(this.this$0, this.$pageCursor, continuation);
        postsNoticeViewModel$getNoticeList$3.L$0 = obj;
        return postsNoticeViewModel$getNoticeList$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsNoticeListBean postsNoticeListBean, Continuation<? super Unit> continuation) {
        return ((PostsNoticeViewModel$getNoticeList$3) create(postsNoticeListBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PostsNoticeListBean postsNoticeListBean = (PostsNoticeListBean) this.L$0;
            list = this.this$0.noticeList;
            if (list != null && !list.isEmpty()) {
                this.this$0.getNoticeListLiveData().postValue(PageDataBean.toPageData$default(postsNoticeListBean, 0, this.$pageCursor, 1, null));
            } else {
                this.this$0.getEmptyListLiveData().postValue("emptyList");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

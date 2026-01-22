package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.PageDataBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoListBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsInfoListBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$getPostsList$3", f = "PostsSquareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsSquareViewModel$getPostsList$3 extends SuspendLambda implements Function2<PostsInfoListBean, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageCursor;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsSquareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsSquareViewModel$getPostsList$3(PostsSquareViewModel postsSquareViewModel, String str, Continuation<? super PostsSquareViewModel$getPostsList$3> continuation) {
        super(2, continuation);
        this.this$0 = postsSquareViewModel;
        this.$pageCursor = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsSquareViewModel$getPostsList$3 postsSquareViewModel$getPostsList$3 = new PostsSquareViewModel$getPostsList$3(this.this$0, this.$pageCursor, continuation);
        postsSquareViewModel$getPostsList$3.L$0 = obj;
        return postsSquareViewModel$getPostsList$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsInfoListBean postsInfoListBean, Continuation<? super Unit> continuation) {
        return ((PostsSquareViewModel$getPostsList$3) create(postsInfoListBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        int i10;
        String str2;
        PostsInfoBean postsInfoBean;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PostsInfoListBean postsInfoListBean = (PostsInfoListBean) this.L$0;
            if (this.this$0.getPostsType() == 2 && ((str = this.$pageCursor) == null || str.length() == 0)) {
                List<PostsInfoBean> data = postsInfoListBean.getData();
                if (data != null) {
                    i10 = data.size();
                } else {
                    i10 = 0;
                }
                if (i10 > 0) {
                    PostsSquareViewModel postsSquareViewModel = this.this$0;
                    List<PostsInfoBean> data2 = postsInfoListBean.getData();
                    if (data2 != null && (postsInfoBean = (PostsInfoBean) CollectionsKt.getOrNull(data2, 0)) != null) {
                        str2 = postsInfoBean.getId();
                    } else {
                        str2 = null;
                    }
                    postsSquareViewModel.followPostsListRead(str2);
                }
            }
            this.this$0.getPostsListLiveData().postValue(PageDataBean.toPageData$default(postsInfoListBean, 0, this.$pageCursor, 1, null));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

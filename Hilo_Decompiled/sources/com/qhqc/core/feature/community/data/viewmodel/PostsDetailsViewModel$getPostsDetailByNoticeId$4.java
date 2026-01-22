package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticePostsInfoBean;
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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/qhqc/core/feature/bean/community/PostsNoticePostsInfoBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getPostsDetailByNoticeId$4", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsDetailsViewModel$getPostsDetailByNoticeId$4 extends SuspendLambda implements Function2<PostsNoticePostsInfoBean, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$getPostsDetailByNoticeId$4(PostsDetailsViewModel postsDetailsViewModel, Continuation<? super PostsDetailsViewModel$getPostsDetailByNoticeId$4> continuation) {
        super(2, continuation);
        this.this$0 = postsDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsDetailsViewModel$getPostsDetailByNoticeId$4 postsDetailsViewModel$getPostsDetailByNoticeId$4 = new PostsDetailsViewModel$getPostsDetailByNoticeId$4(this.this$0, continuation);
        postsDetailsViewModel$getPostsDetailByNoticeId$4.L$0 = obj;
        return postsDetailsViewModel$getPostsDetailByNoticeId$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PostsNoticePostsInfoBean postsNoticePostsInfoBean, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$getPostsDetailByNoticeId$4) create(postsNoticePostsInfoBean, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PostsNoticePostsInfoBean postsNoticePostsInfoBean = (PostsNoticePostsInfoBean) this.L$0;
            if (postsNoticePostsInfoBean.getDeleted() == 1) {
                this.this$0.getDeletedStateLiveData().postValue(Boxing.boxInt(1));
                return Unit.INSTANCE;
            }
            this.this$0.getDeletedStateLiveData().postValue(Boxing.boxInt(postsNoticePostsInfoBean.getDeleted()));
            PostsInfoBean post = postsNoticePostsInfoBean.getPost();
            if (post != null) {
                PostsDetailsViewModel postsDetailsViewModel = this.this$0;
                String id = post.getId();
                if (id == null) {
                    id = "";
                }
                postsDetailsViewModel.setPostId(id);
                postsDetailsViewModel.getPostsInfoLiveData().postValue(CommunityUtils.INSTANCE.setPostInfoData(post));
            }
            this.this$0.getCommentListLiveData().postValue(new PageData(new Page(0, null, null, false, 0, false, 55, null), postsNoticePostsInfoBean.getComments()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

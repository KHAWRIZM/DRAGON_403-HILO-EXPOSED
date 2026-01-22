package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
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
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$postsLike$3", f = "PostsSquareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsSquareViewModel$postsLike$3 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostsInfoBean $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsSquareViewModel$postsLike$3(PostsInfoBean postsInfoBean, Continuation<? super PostsSquareViewModel$postsLike$3> continuation) {
        super(2, continuation);
        this.$item = postsInfoBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsSquareViewModel$postsLike$3(this.$item, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$item.setLike(!r5.isLike());
            if (this.$item.isLike()) {
                PostsInfoBean postsInfoBean = this.$item;
                postsInfoBean.setLikeCount(postsInfoBean.getLikeCount() + 1);
            } else {
                this.$item.setLikeCount(r5.getLikeCount() - 1);
            }
            CommunityManager.INSTANCE.getInstance().dispatchPostsEvent$feature_community_release(new PostsEvent(4098, this.$item.getId(), this.$item));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((PostsSquareViewModel$postsLike$3) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.events.PostsEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsOperateViewModel$localBlock$4", f = "PostsOperateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsOperateViewModel$localBlock$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFromBlock;
    final /* synthetic */ PostsInfoBean $postsInfo;
    int label;
    final /* synthetic */ PostsOperateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsOperateViewModel$localBlock$4(PostsOperateViewModel postsOperateViewModel, boolean z10, PostsInfoBean postsInfoBean, Continuation<? super PostsOperateViewModel$localBlock$4> continuation) {
        super(2, continuation);
        this.this$0 = postsOperateViewModel;
        this.$isFromBlock = z10;
        this.$postsInfo = postsInfoBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsOperateViewModel$localBlock$4(this.this$0, this.$isFromBlock, this.$postsInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IToast iToast;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.isLoading(false);
            if (this.$isFromBlock && (iToast = BasicModuleApp.INSTANCE.toastImpl()) != null) {
                iToast.showToast(CompatKtxKt.getString(R.string.feature_community_block_success));
            }
            CommunityManager.INSTANCE.getInstance().dispatchEvent(new PostsEvent(4099, this.$postsInfo.getId(), this.$postsInfo));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(boolean z10, Continuation<? super Unit> continuation) {
        return ((PostsOperateViewModel$localBlock$4) create(Boolean.valueOf(z10), continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

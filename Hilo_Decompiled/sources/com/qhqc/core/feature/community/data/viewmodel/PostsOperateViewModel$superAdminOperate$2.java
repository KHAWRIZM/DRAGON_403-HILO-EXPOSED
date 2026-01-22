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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsOperateViewModel$superAdminOperate$2", f = "PostsOperateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsOperateViewModel$superAdminOperate$2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $operate;
    final /* synthetic */ PostsInfoBean $postsInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsOperateViewModel$superAdminOperate$2(int i10, PostsInfoBean postsInfoBean, Continuation<? super PostsOperateViewModel$superAdminOperate$2> continuation) {
        super(2, continuation);
        this.$operate = i10;
        this.$postsInfo = postsInfoBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsOperateViewModel$superAdminOperate$2(this.$operate, this.$postsInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IToast iToast = BasicModuleApp.INSTANCE.toastImpl();
            if (iToast != null) {
                iToast.showToast(CompatKtxKt.getString(R.string.feature_community_operate_success));
            }
            int i10 = this.$operate;
            if (i10 == 10 || i10 == 11) {
                CommunityManager.INSTANCE.getInstance().dispatchEvent(new PostsEvent(4099, this.$postsInfo.getId(), this.$postsInfo));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((PostsOperateViewModel$superAdminOperate$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

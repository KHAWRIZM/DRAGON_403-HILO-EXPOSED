package com.qhqc.core.feature.community.data.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000f"}, d2 = {"Lcom/qhqc/core/feature/community/data/viewmodel/PostsOperateViewModel;", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "<init>", "()V", ChatMenuDialog.CLICK_REPORT, "", "postsInfo", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "operate", "", ChatMenuDialog.CLICK_DELETE, "localBlock", "isFromBlock", "", "superAdminOperate", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PostsOperateViewModel extends BaseViewModel {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$1(PostsOperateViewModel postsOperateViewModel, boolean z10) {
        postsOperateViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$2(PostsOperateViewModel postsOperateViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsOperateViewModel.onError(it);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void localBlock$default(PostsOperateViewModel postsOperateViewModel, PostsInfoBean postsInfoBean, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            postsOperateViewModel.localBlock(postsInfoBean, z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBlock");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit report$lambda$0(PostsOperateViewModel postsOperateViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsOperateViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit superAdminOperate$lambda$3(PostsOperateViewModel postsOperateViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsOperateViewModel.onError(it);
        return Unit.INSTANCE;
    }

    public final void delete(@NotNull PostsInfoBean postsInfo) {
        Intrinsics.checkNotNullParameter(postsInfo, "postsInfo");
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsDelete(postsInfo.getId()), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit delete$lambda$1;
                delete$lambda$1 = PostsOperateViewModel.delete$lambda$1(PostsOperateViewModel.this, ((Boolean) obj).booleanValue());
                return delete$lambda$1;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit delete$lambda$2;
                delete$lambda$2 = PostsOperateViewModel.delete$lambda$2(PostsOperateViewModel.this, (ApiErrorException) obj);
                return delete$lambda$2;
            }
        }, 1, null), new PostsOperateViewModel$delete$3(postsInfo, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void localBlock(@NotNull PostsInfoBean postsInfo, boolean isFromBlock) {
        Intrinsics.checkNotNullParameter(postsInfo, "postsInfo");
        isLoading(true);
        FlowKt.launchIn(FlowKt.catch(FlowKt.onEach(FlowKt.onCompletion(FlowKt.onStart(FlowKt.flowOn(FlowKt.flow(new PostsOperateViewModel$localBlock$1(postsInfo, null)), Dispatchers.getIO()), new PostsOperateViewModel$localBlock$2(null)), new PostsOperateViewModel$localBlock$3(null)), new PostsOperateViewModel$localBlock$4(this, isFromBlock, postsInfo, null)), new PostsOperateViewModel$localBlock$5(this, null)), ViewModelKt.getViewModelScope(this));
    }

    public final void report(@NotNull PostsInfoBean postsInfo, int operate) {
        Intrinsics.checkNotNullParameter(postsInfo, "postsInfo");
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsReport(postsInfo.getId(), operate), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit report$lambda$0;
                report$lambda$0 = PostsOperateViewModel.report$lambda$0(PostsOperateViewModel.this, (ApiErrorException) obj);
                return report$lambda$0;
            }
        }, 3, null), new PostsOperateViewModel$report$2(this, postsInfo, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void superAdminOperate(@Nullable PostsInfoBean postsInfo, int operate) {
        if (postsInfo == null) {
            return;
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsSuperAdminOperate(operate, postsInfo.getId()), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit superAdminOperate$lambda$3;
                superAdminOperate$lambda$3 = PostsOperateViewModel.superAdminOperate$lambda$3(PostsOperateViewModel.this, (ApiErrorException) obj);
                return superAdminOperate$lambda$3;
            }
        }, 3, null), new PostsOperateViewModel$superAdminOperate$2(operate, postsInfo, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }
}

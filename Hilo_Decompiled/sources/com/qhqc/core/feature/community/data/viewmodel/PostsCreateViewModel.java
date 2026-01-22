package com.qhqc.core.feature.community.data.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.qhqc.core.basic.aws.AwsS3Repository;
import com.qhqc.core.basic.aws.RequestListener;
import com.qhqc.core.basic.aws.Result;
import com.qhqc.core.basic.aws.S3Configs;
import com.qhqc.core.basic.aws.S3UploadRequest;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u001e\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\bH\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qhqc/core/feature/community/data/viewmodel/PostsCreateViewModel;", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "<init>", "()V", "mUploadList", "", "Lcom/qhqc/core/feature/bean/community/PostsCreateMediaBean;", "uploadImages", "", "publicType", "", "content", "", "list", "postCreate", "uploadImage", "Lcom/qhqc/core/basic/aws/Result;", "availablePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCreateViewModel extends BaseViewModel {

    @Nullable
    private volatile List<PostsCreateMediaBean> mUploadList;

    /* JADX INFO: Access modifiers changed from: private */
    public final void postCreate(int publicType, String content) {
        ApiCommunityPostsImpl apiCommunityPostsImpl = ApiCommunityPostsImpl.INSTANCE;
        List<PostsCreateMediaBean> list = this.mUploadList;
        if (list == null) {
            return;
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(apiCommunityPostsImpl.postsCreate(publicType, list, content), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postCreate$lambda$0;
                postCreate$lambda$0 = PostsCreateViewModel.postCreate$lambda$0(PostsCreateViewModel.this, ((Boolean) obj).booleanValue());
                return postCreate$lambda$0;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postCreate$lambda$1;
                postCreate$lambda$1 = PostsCreateViewModel.postCreate$lambda$1(PostsCreateViewModel.this, (ApiErrorException) obj);
                return postCreate$lambda$1;
            }
        }, 1, null), new PostsCreateViewModel$postCreate$3(this, content, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    static /* synthetic */ void postCreate$default(PostsCreateViewModel postsCreateViewModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if ((i11 & 2) != 0) {
            str = "";
        }
        postsCreateViewModel.postCreate(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postCreate$lambda$0(PostsCreateViewModel postsCreateViewModel, boolean z10) {
        postsCreateViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postCreate$lambda$1(PostsCreateViewModel postsCreateViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsCreateViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadImage(String str, Continuation<? super Result> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        new S3UploadRequest.Builder().setAvailablePath(str).setUploadPath("post/images/").setFileType(S3Configs.Type.IMAGE).setUploadListener(new RequestListener() { // from class: com.qhqc.core.feature.community.data.viewmodel.PostsCreateViewModel$uploadImage$2$1
            @Override // com.qhqc.core.basic.aws.RequestListener
            public void onComplete(Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                safeContinuation.resumeWith(kotlin.Result.m٥٤٤constructorimpl(result));
            }

            @Override // com.qhqc.core.basic.aws.RequestListener
            public void onFailed(Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                safeContinuation.resumeWith(kotlin.Result.m٥٤٤constructorimpl(null));
            }

            @Override // com.qhqc.core.basic.aws.RequestListener
            public void onProgress(Result result) {
                RequestListener.DefaultImpls.onProgress(this, result);
            }
        }).build(this).start(ViewModelKt.getViewModelScope(this));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ void uploadImages$default(PostsCreateViewModel postsCreateViewModel, int i10, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        if ((i11 & 2) != 0) {
            str = "";
        }
        postsCreateViewModel.uploadImages(i10, str, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        AwsS3Repository.INSTANCE.getInstance().clear(this);
    }

    public final void uploadImages(int publicType, @Nullable String content, @Nullable List<PostsCreateMediaBean> list) {
        isLoading(true);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new PostsCreateViewModel$uploadImages$1(this, list, publicType, content, null), 2, null);
    }
}

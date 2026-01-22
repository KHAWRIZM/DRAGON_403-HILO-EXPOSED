package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.basic.aws.Result;
import com.qhqc.core.basic.utils.LogUtil;
import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsCreateViewModel$uploadImages$1", f = "PostsCreateViewModel.kt", i = {0}, l = {47}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
@SourceDebugExtension({"SMAP\nPostsCreateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCreateViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsCreateViewModel$uploadImages$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,137:1\n1863#2,2:138\n*S KotlinDebug\n*F\n+ 1 PostsCreateViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsCreateViewModel$uploadImages$1\n*L\n45#1:138,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCreateViewModel$uploadImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ List<PostsCreateMediaBean> $list;
    final /* synthetic */ int $publicType;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PostsCreateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsCreateViewModel$uploadImages$1(PostsCreateViewModel postsCreateViewModel, List<PostsCreateMediaBean> list, int i10, String str, Continuation<? super PostsCreateViewModel$uploadImages$1> continuation) {
        super(2, continuation);
        this.this$0 = postsCreateViewModel;
        this.$list = list;
        this.$publicType = i10;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsCreateViewModel$uploadImages$1(this.this$0, this.$list, this.$publicType, this.$content, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0080  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0078 -> B:5:0x007b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        Iterator it;
        PostsCreateViewModel postsCreateViewModel;
        String uploadedPath;
        String str;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                PostsCreateMediaBean postsCreateMediaBean = (PostsCreateMediaBean) this.L$2;
                it = (Iterator) this.L$1;
                postsCreateViewModel = (PostsCreateViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                Result result = (Result) obj;
                String str4 = null;
                if (result == null) {
                    str = result.getRelativeUrl();
                } else {
                    str = null;
                }
                if (str == null && str.length() != 0) {
                    if (result != null) {
                        str2 = result.getRelativeUrl();
                    } else {
                        str2 = null;
                    }
                    postsCreateMediaBean.setUploadedPath(str2);
                    if (result != null) {
                        str3 = result.getAbsoluteUrl();
                    } else {
                        str3 = null;
                    }
                    postsCreateMediaBean.setUploadedPathAbsolute(str3);
                    LogUtil logUtil = LogUtil.INSTANCE;
                    int width = postsCreateMediaBean.getWidth();
                    int height = postsCreateMediaBean.getHeight();
                    if (result != null) {
                        str4 = result.getRelativeUrl();
                    }
                    logUtil.d("PostsCreateViewModel", "w_" + width + ",h_" + height + ",uploadPath=" + str4);
                    while (it.hasNext()) {
                        postsCreateMediaBean = (PostsCreateMediaBean) it.next();
                        String path = postsCreateMediaBean.getPath();
                        if (path != null && path.length() != 0 && ((uploadedPath = postsCreateMediaBean.getUploadedPath()) == null || uploadedPath.length() == 0)) {
                            String path2 = postsCreateMediaBean.getPath();
                            if (path2 == null) {
                                return Unit.INSTANCE;
                            }
                            this.L$0 = postsCreateViewModel;
                            this.L$1 = it;
                            this.L$2 = postsCreateMediaBean;
                            this.label = 1;
                            obj = postsCreateViewModel.uploadImage(path2, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Result result2 = (Result) obj;
                            String str42 = null;
                            if (result2 == null) {
                            }
                            if (str == null) {
                            }
                            postsCreateViewModel.isLoading(false);
                            return Unit.INSTANCE;
                        }
                    }
                    this.this$0.postCreate(this.$publicType, this.$content);
                    return Unit.INSTANCE;
                }
                postsCreateViewModel.isLoading(false);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.mUploadList = this.$list;
        list = this.this$0.mUploadList;
        if (list != null) {
            PostsCreateViewModel postsCreateViewModel2 = this.this$0;
            it = list.iterator();
            postsCreateViewModel = postsCreateViewModel2;
            while (it.hasNext()) {
            }
        }
        this.this$0.postCreate(this.$publicType, this.$content);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PostsCreateViewModel$uploadImages$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

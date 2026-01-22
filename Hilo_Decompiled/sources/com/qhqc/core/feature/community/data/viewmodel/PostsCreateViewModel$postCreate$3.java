package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoMediaBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.events.PostsEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsCreateViewModel$postCreate$3", f = "PostsCreateViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPostsCreateViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCreateViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsCreateViewModel$postCreate$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,137:1\n1863#2,2:138\n*S KotlinDebug\n*F\n+ 1 PostsCreateViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsCreateViewModel$postCreate$3\n*L\n80#1:138,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCreateViewModel$postCreate$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsCreateViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsCreateViewModel$postCreate$3(PostsCreateViewModel postsCreateViewModel, String str, Continuation<? super PostsCreateViewModel$postCreate$3> continuation) {
        super(2, continuation);
        this.this$0 = postsCreateViewModel;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsCreateViewModel$postCreate$3 postsCreateViewModel$postCreate$3 = new PostsCreateViewModel$postCreate$3(this.this$0, this.$content, continuation);
        postsCreateViewModel$postCreate$3.L$0 = obj;
        return postsCreateViewModel$postCreate$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<PostsCreateMediaBean> list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            ArrayList arrayList = new ArrayList();
            list = this.this$0.mUploadList;
            if (list != null) {
                for (PostsCreateMediaBean postsCreateMediaBean : list) {
                    arrayList.add(new PostsInfoMediaBean(1, postsCreateMediaBean.getUploadedPathAbsolute(), postsCreateMediaBean.getSize(), postsCreateMediaBean.getWidth(), postsCreateMediaBean.getHeight()));
                }
            }
            String str2 = this.$content;
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            PostsInfoBean postsInfoBean = new PostsInfoBean(str, str2, arrayList, companion.getInstance().getMyUserInfo(), false, System.currentTimeMillis(), 0, null, false, 0, 0, CommunityUtils.INSTANCE.getPostInfoItemType(arrayList.size()), false, 6096, null);
            companion.getInstance().dispatchEvent(new PostsEvent(4096, postsInfoBean.getId(), postsInfoBean));
            this.this$0.getOnSuccessLD().postValue(new Pair(Boxing.boxInt(1), str));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((PostsCreateViewModel$postCreate$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

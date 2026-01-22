package com.qhqc.core.feature.community.data.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModelKt;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import com.qhqc.core.feature.bean.community.PostsNoticeBean;
import com.qhqc.core.feature.bean.community.PostsNoticeListBean;
import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0003R#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R-\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a0\u000f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/qhqc/core/feature/community/data/viewmodel/PostsNoticeViewModel;", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "<init>", "()V", "", "pageCursor", "", "getNoticeList", "(Ljava/lang/String;)V", "noticeId", "", "totalCount", "readNotice", "(Ljava/lang/String;I)V", "getPostNewestUserList", "Lma/b;", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "Lcom/qhqc/core/feature/bean/community/PostsNoticeBean;", "noticeListLiveData", "Lma/b;", "getNoticeListLiveData", "()Lma/b;", "emptyListLiveData", "getEmptyListLiveData", "Ljava/util/ArrayList;", "Lcom/qhqc/core/feature/bean/community/NewestUserBean;", "Lkotlin/collections/ArrayList;", "postNewestUserList", "unReadIndex", "I", "", "noticeList", "Ljava/util/List;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsNoticeViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsNoticeViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsNoticeViewModel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,135:1\n49#2:136\n51#2:140\n46#3:137\n51#3:139\n105#4:138\n*S KotlinDebug\n*F\n+ 1 PostsNoticeViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsNoticeViewModel\n*L\n41#1:136\n41#1:140\n41#1:137\n41#1:139\n41#1:138\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsNoticeViewModel extends BaseViewModel {

    @Nullable
    private List<PostsNoticeBean> noticeList;

    @NotNull
    private final ma.b noticeListLiveData = new ma.b();

    @NotNull
    private final ma.b emptyListLiveData = new ma.b();

    @NotNull
    private final ma.b postNewestUserList = new ma.b();
    private volatile int unReadIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNoticeList$lambda$4(PostsNoticeViewModel postsNoticeViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsNoticeViewModel.noticeListLiveData.postValue(PageData.INSTANCE.error());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPostNewestUserList$lambda$6(PostsNoticeViewModel postsNoticeViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Log.e("errorData", it.getMsg());
        Log.e("errorDataCode", String.valueOf(it.getCode()));
        postsNoticeViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readNotice$lambda$5(ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final ma.b getEmptyListLiveData() {
        return this.emptyListLiveData;
    }

    public final void getNoticeList(@Nullable final String pageCursor) {
        final Flow flowOn = FlowKt.flowOn(ApiCommunityPostsImpl.INSTANCE.getNoticeList(pageCursor), Dispatchers.getIO());
        ResponseUtilsKt.startIn$default(FlowKt.onEach(FlowKt.flowOn(ResponseUtilsKt.flowRequest$default(new Flow<PostsNoticeListBean>() { // from class: com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel$getNoticeList$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PostsNoticeViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsNoticeViewModel\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n42#3,4:220\n46#3,31:225\n79#3,27:257\n1863#4:224\n1864#4:256\n*S KotlinDebug\n*F\n+ 1 PostsNoticeViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsNoticeViewModel\n*L\n45#1:224\n45#1:256\n*E\n"})
            /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel$getNoticeList$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $pageCursor$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ PostsNoticeViewModel this$0;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel$getNoticeList$$inlined$map$1$2", f = "PostsNoticeViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel$getNoticeList$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, PostsNoticeViewModel postsNoticeViewModel, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = postsNoticeViewModel;
                    this.$pageCursor$inlined = str;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i10;
                    PostsNoticeUnReadBean unRead;
                    int i11;
                    int i12;
                    int i13;
                    int i14;
                    int i15;
                    int i16;
                    int targetType;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i17 = anonymousClass1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i17 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i10 = anonymousClass1.label;
                            if (i10 == 0) {
                                if (i10 == 1) {
                                    ResultKt.throwOnFailure(obj2);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                PostsNoticeListBean postsNoticeListBean = (PostsNoticeListBean) obj;
                                List<PostsNoticeBean> data = postsNoticeListBean.getData();
                                if (data != null) {
                                    for (PostsNoticeBean postsNoticeBean : data) {
                                        int type = postsNoticeBean.getType();
                                        String str = "";
                                        if (type != 1) {
                                            if (type == 2 && (targetType = postsNoticeBean.getTargetType()) != 1 && targetType == 3) {
                                                str = CompatKtxKt.getString(R.string.feature_community_posts_notice_like_moment);
                                            }
                                        } else {
                                            int targetType2 = postsNoticeBean.getTargetType();
                                            if (targetType2 != 1) {
                                                if (targetType2 == 3) {
                                                    str = CompatKtxKt.toFormat(R.string.feature_community_posts_notice_comment, postsNoticeBean.getContent());
                                                }
                                            } else {
                                                str = CompatKtxKt.toFormat(R.string.feature_community_posts_notice_comment_reply, postsNoticeBean.getContent());
                                            }
                                        }
                                        postsNoticeBean.setContentShow(str);
                                    }
                                    String str2 = this.$pageCursor$inlined;
                                    if ((str2 == null || str2.length() == 0) && (unRead = postsNoticeListBean.getUnRead()) != null) {
                                        String str3 = null;
                                        if (data.size() > 0 && unRead.getTotalCnt() > 0) {
                                            this.this$0.unReadIndex = unRead.getTotalCnt();
                                            PostsNoticeViewModel postsNoticeViewModel = this.this$0;
                                            PostsNoticeBean postsNoticeBean2 = (PostsNoticeBean) CollectionsKt.getOrNull(data, 0);
                                            if (postsNoticeBean2 != null) {
                                                str3 = postsNoticeBean2.getId();
                                            }
                                            postsNoticeViewModel.readNotice(str3, unRead.getTotalCnt());
                                        } else {
                                            CommunityManager.noticeReadAll$default(CommunityManager.INSTANCE.getInstance(), null, 1, null);
                                        }
                                    }
                                    i11 = this.this$0.unReadIndex;
                                    if (i11 < data.size()) {
                                        i13 = this.this$0.unReadIndex;
                                        if (i13 >= 0) {
                                            String str4 = this.$pageCursor$inlined;
                                            if (str4 == null || str4.length() == 0) {
                                                i14 = this.this$0.unReadIndex;
                                                if (i14 > 0) {
                                                    i15 = this.this$0.unReadIndex;
                                                    data.get(i15).setFirstHistory(true);
                                                }
                                            } else {
                                                i16 = this.this$0.unReadIndex;
                                                data.get(i16).setFirstHistory(true);
                                            }
                                        }
                                    }
                                    PostsNoticeViewModel postsNoticeViewModel2 = this.this$0;
                                    i12 = postsNoticeViewModel2.unReadIndex;
                                    postsNoticeViewModel2.unReadIndex = i12 - data.size();
                                }
                                this.this$0.noticeList = postsNoticeListBean.getData();
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(postsNoticeListBean, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = anonymousClass1.label;
                    if (i10 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
                Object collect = flowOn.collect(new AnonymousClass2(flowCollector, this, pageCursor), continuation);
                if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit noticeList$lambda$4;
                noticeList$lambda$4 = PostsNoticeViewModel.getNoticeList$lambda$4(PostsNoticeViewModel.this, (ApiErrorException) obj);
                return noticeList$lambda$4;
            }
        }, 3, null), Dispatchers.getMain()), new PostsNoticeViewModel$getNoticeList$3(this, pageCursor, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    @NotNull
    public final ma.b getNoticeListLiveData() {
        return this.noticeListLiveData;
    }

    @NotNull
    public final ma.b getPostNewestUserList() {
        return this.postNewestUserList;
    }

    public final void readNotice(@Nullable String noticeId, int totalCount) {
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.readNotice(noticeId), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit readNotice$lambda$5;
                readNotice$lambda$5 = PostsNoticeViewModel.readNotice$lambda$5((ApiErrorException) obj);
                return readNotice$lambda$5;
            }
        }, 3, null), new PostsNoticeViewModel$readNotice$2(null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    /* renamed from: getPostNewestUserList, reason: collision with other method in class */
    public final void m٥٢٣getPostNewestUserList() {
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.getPostNewestUserList(), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postNewestUserList$lambda$6;
                postNewestUserList$lambda$6 = PostsNoticeViewModel.getPostNewestUserList$lambda$6(PostsNoticeViewModel.this, (ApiErrorException) obj);
                return postNewestUserList$lambda$6;
            }
        }, 3, null), new PostsNoticeViewModel$getPostNewestUserList$2(this, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }
}

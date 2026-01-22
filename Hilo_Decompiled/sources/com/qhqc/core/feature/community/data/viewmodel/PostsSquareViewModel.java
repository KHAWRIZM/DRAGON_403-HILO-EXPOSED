package com.qhqc.core.feature.community.data.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoListBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.data.room.CommunityRoomLocalDB;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\"0!8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110!8\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&¨\u0006*"}, d2 = {"Lcom/qhqc/core/feature/community/data/viewmodel/PostsSquareViewModel;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsOperateViewModel;", "<init>", "()V", "", "lastPostId", "", "followPostsListRead", "(Ljava/lang/String;)V", "pageCursor", "getPostsList", "", "userId", "getUserPostsTotal", "(Ljava/lang/String;J)V", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "item", "", "position", "postsLike", "(Lcom/qhqc/core/feature/bean/community/PostsInfoBean;I)V", "postsType", "I", "getPostsType", "()I", "setPostsType", "(I)V", "targetId", "J", "getTargetId", "()J", "setTargetId", "(J)V", "Lma/b;", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "postsListLiveData", "Lma/b;", "getPostsListLiveData", "()Lma/b;", "postUserTotalCount", "getPostUserTotalCount", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsSquareViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsSquareViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsSquareViewModel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,154:1\n49#2:155\n51#2:159\n46#3:156\n51#3:158\n105#4:157\n*S KotlinDebug\n*F\n+ 1 PostsSquareViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsSquareViewModel\n*L\n55#1:155\n55#1:159\n55#1:156\n55#1:158\n55#1:157\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsSquareViewModel extends PostsOperateViewModel {
    public static final int POSTS_TYPE_FOLLOW = 2;
    public static final int POSTS_TYPE_RECOMMEND = 1;
    public static final int POSTS_TYPE_USER = 3;
    private long targetId;
    private int postsType = 1;

    @NotNull
    private final ma.b postsListLiveData = new ma.b();

    @NotNull
    private final ma.b postUserTotalCount = new ma.b();

    /* JADX INFO: Access modifiers changed from: private */
    public final void followPostsListRead(String lastPostId) {
        if (lastPostId != null && lastPostId.length() != 0) {
            ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.readFollowPostsList(lastPostId), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit followPostsListRead$lambda$4;
                    followPostsListRead$lambda$4 = PostsSquareViewModel.followPostsListRead$lambda$4((ApiErrorException) obj);
                    return followPostsListRead$lambda$4;
                }
            }, 3, null), new PostsSquareViewModel$followPostsListRead$2(null)), ViewModelKt.getViewModelScope(this), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit followPostsListRead$lambda$4(ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPostsList$lambda$2(PostsSquareViewModel postsSquareViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsSquareViewModel.postsListLiveData.postValue(PageData.INSTANCE.error());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getUserPostsTotal$default(PostsSquareViewModel postsSquareViewModel, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        postsSquareViewModel.getUserPostsTotal(str, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserPostsTotal$lambda$3(ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postsLike$lambda$5(boolean z10) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postsLike$lambda$6(PostsSquareViewModel postsSquareViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsSquareViewModel.onError(it);
        return Unit.INSTANCE;
    }

    @NotNull
    public final ma.b getPostUserTotalCount() {
        return this.postUserTotalCount;
    }

    public final void getPostsList(@Nullable String pageCursor) {
        int i10 = this.postsType;
        String str = "recommend";
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    str = "user";
                }
            } else {
                str = "follow";
            }
        }
        final Flow postsInfoList$default = ApiCommunityPostsImpl.getPostsInfoList$default(ApiCommunityPostsImpl.INSTANCE, pageCursor, 0, str, this.targetId, 2, null);
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(FlowKt.flowOn(new Flow<PostsInfoListBean>() { // from class: com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$getPostsList$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PostsSquareViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsSquareViewModel\n*L\n1#1,218:1\n50#2:219\n57#3,16:220\n*E\n"})
            /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$getPostsList$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$getPostsList$$inlined$map$1$2", f = "PostsSquareViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel$getPostsList$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i10;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i11 = anonymousClass1.label;
                        if ((i11 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i11 - Integer.MIN_VALUE;
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
                                PostsInfoListBean postsInfoListBean = (PostsInfoListBean) obj;
                                List<String> blockHistoryPostsIdList = CommunityRoomLocalDB.Companion.get().postsBlockHistoryDao().getBlockHistoryPostsIdList(CommunityManager.INSTANCE.getInstance().getUid());
                                List<PostsInfoBean> data = postsInfoListBean.getData();
                                if (data != null) {
                                    Iterator<PostsInfoBean> it = data.iterator();
                                    while (it.hasNext()) {
                                        PostsInfoBean next = it.next();
                                        CommunityUtils.INSTANCE.setPostInfoData(next);
                                        if (blockHistoryPostsIdList.contains(next.getId())) {
                                            it.remove();
                                        }
                                    }
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(postsInfoListBean, anonymousClass1) == coroutine_suspended) {
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
                Object collect = postsInfoList$default.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, Dispatchers.getIO()), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsList$lambda$2;
                postsList$lambda$2 = PostsSquareViewModel.getPostsList$lambda$2(PostsSquareViewModel.this, (ApiErrorException) obj);
                return postsList$lambda$2;
            }
        }, 3, null), new PostsSquareViewModel$getPostsList$3(this, pageCursor, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    @NotNull
    public final ma.b getPostsListLiveData() {
        return this.postsListLiveData;
    }

    public final int getPostsType() {
        return this.postsType;
    }

    public final long getTargetId() {
        return this.targetId;
    }

    public final void getUserPostsTotal(@Nullable String pageCursor, long userId) {
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.getPostsInfoList$default(ApiCommunityPostsImpl.INSTANCE, pageCursor, 0, "user", userId, 2, null), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit userPostsTotal$lambda$3;
                userPostsTotal$lambda$3 = PostsSquareViewModel.getUserPostsTotal$lambda$3((ApiErrorException) obj);
                return userPostsTotal$lambda$3;
            }
        }, 3, null), new PostsSquareViewModel$getUserPostsTotal$2(this, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void postsLike(@NotNull PostsInfoBean item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsLikes(item.getId(), !item.isLike()), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsLike$lambda$5;
                postsLike$lambda$5 = PostsSquareViewModel.postsLike$lambda$5(((Boolean) obj).booleanValue());
                return postsLike$lambda$5;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsLike$lambda$6;
                postsLike$lambda$6 = PostsSquareViewModel.postsLike$lambda$6(PostsSquareViewModel.this, (ApiErrorException) obj);
                return postsLike$lambda$6;
            }
        }, 1, null), new PostsSquareViewModel$postsLike$3(item, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void setPostsType(int i10) {
        this.postsType = i10;
    }

    public final void setTargetId(long j10) {
        this.targetId = j10;
    }
}

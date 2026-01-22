package com.qhqc.core.feature.community.data.viewmodel;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.ktx.SpannableStringKtxKt;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.bean.community.PostsCommentListBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticePostsInfoBean;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.ui.adapter.PostsCommentFloorListAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0003J\u001d\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019JA\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u001a2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b \u0010\u0019J\u001d\u0010!\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b!\u0010\u0015J3\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010%\u001a\u00020\u0012¢\u0006\u0004\b&\u0010'J)\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u0019R$\u00100\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.\"\u0004\b2\u0010\u0019R\"\u00104\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R#\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100@0:8\u0006¢\u0006\f\n\u0004\bA\u0010=\u001a\u0004\bB\u0010?R5\u0010D\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050@\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120C0:8\u0006¢\u0006\f\n\u0004\bD\u0010=\u001a\u0004\bE\u0010?R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00120:8\u0006¢\u0006\f\n\u0004\bF\u0010=\u001a\u0004\bG\u0010?¨\u0006H"}, d2 = {"Lcom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsOperateViewModel;", "<init>", "()V", "", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "list", "", "setCommentFloorInfos", "(Ljava/util/List;)V", "o", "setCommentFloorInfo", "(Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;)V", "getPostsDetail", "getPostsDetailByNoticeId", "postsLike", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "item", "", "position", "commentLike", "(Lcom/qhqc/core/feature/bean/community/PostsCommentBean;I)V", "", "content", "sendComment", "(Ljava/lang/String;)V", "Lkotlin/Pair;", "replyComment", "replyCommentFloor", "sendCommentFloor", "(Ljava/lang/String;Lkotlin/Pair;Lkotlin/Pair;)V", "pageCursor", "getComments", "loadMoreCommentFloor", "itemComment", "positionComment", "itemCommentFloor", "positionCommentFloor", "commentDelete", "(Lcom/qhqc/core/feature/bean/community/PostsCommentBean;ILcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;I)V", "operate", "commentReport", "(ILcom/qhqc/core/feature/bean/community/PostsCommentBean;Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;)V", ShareConstants.RESULT_POST_ID, "Ljava/lang/String;", "getPostId", "()Ljava/lang/String;", "setPostId", "noticeId", "getNoticeId", "setNoticeId", "", "targetUserId", "J", "getTargetUserId", "()J", "setTargetUserId", "(J)V", "Lma/b;", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "postsInfoLiveData", "Lma/b;", "getPostsInfoLiveData", "()Lma/b;", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "commentListLiveData", "getCommentListLiveData", "Lkotlin/Triple;", "commentFloorListMoreLiveData", "getCommentFloorListMoreLiveData", "deletedStateLiveData", "getDeletedStateLiveData", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsDetailsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsDetailsViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,416:1\n49#2:417\n51#2:421\n49#2:422\n51#2:426\n46#3:418\n51#3:420\n46#3:423\n51#3:425\n105#4:419\n105#4:424\n*S KotlinDebug\n*F\n+ 1 PostsDetailsViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel\n*L\n79#1:417\n79#1:421\n274#1:422\n274#1:426\n79#1:418\n79#1:420\n274#1:423\n274#1:425\n79#1:419\n274#1:424\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsDetailsViewModel extends PostsOperateViewModel {
    private long targetUserId;

    @NotNull
    private String postId = "";

    @Nullable
    private String noticeId = "";

    @NotNull
    private final ma.b postsInfoLiveData = new ma.b();

    @NotNull
    private final ma.b commentListLiveData = new ma.b();

    @NotNull
    private final ma.b commentFloorListMoreLiveData = new ma.b();

    @NotNull
    private final ma.b deletedStateLiveData = new ma.b();

    public static /* synthetic */ void commentDelete$default(PostsDetailsViewModel postsDetailsViewModel, PostsCommentBean postsCommentBean, int i10, PostsCommentFloorBean postsCommentFloorBean, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            postsCommentFloorBean = null;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        postsDetailsViewModel.commentDelete(postsCommentBean, i10, postsCommentFloorBean, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commentDelete$lambda$21(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commentLike$lambda$8(PostsDetailsViewModel postsDetailsViewModel, boolean z10) {
        postsDetailsViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commentLike$lambda$9(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void commentReport$default(PostsDetailsViewModel postsDetailsViewModel, int i10, PostsCommentBean postsCommentBean, PostsCommentFloorBean postsCommentFloorBean, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            postsCommentFloorBean = null;
        }
        postsDetailsViewModel.commentReport(i10, postsCommentBean, postsCommentFloorBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commentReport$lambda$22(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getComments$lambda$17(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.commentListLiveData.postValue(PageData.INSTANCE.error());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPostsDetail$lambda$0(PostsDetailsViewModel postsDetailsViewModel, boolean z10) {
        postsDetailsViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPostsDetail$lambda$1(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPostsDetailByNoticeId$lambda$4(PostsDetailsViewModel postsDetailsViewModel, boolean z10) {
        postsDetailsViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPostsDetailByNoticeId$lambda$5(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMoreCommentFloor$lambda$19(PostsDetailsViewModel postsDetailsViewModel, boolean z10) {
        postsDetailsViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadMoreCommentFloor$lambda$20(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postsLike$lambda$6(boolean z10) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postsLike$lambda$7(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendComment$lambda$12$lambda$10(PostsDetailsViewModel postsDetailsViewModel, boolean z10) {
        postsDetailsViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendComment$lambda$12$lambda$11(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendCommentFloor$default(PostsDetailsViewModel postsDetailsViewModel, String str, Pair pair, Pair pair2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            pair2 = null;
        }
        postsDetailsViewModel.sendCommentFloor(str, pair, pair2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendCommentFloor$lambda$13(PostsDetailsViewModel postsDetailsViewModel, boolean z10) {
        postsDetailsViewModel.isLoading(z10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendCommentFloor$lambda$14(PostsDetailsViewModel postsDetailsViewModel, ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        postsDetailsViewModel.onError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCommentFloorInfo(PostsCommentFloorBean o10) {
        UserInfoBean toUser = o10.getToUser();
        if (toUser != null) {
            String str = "@" + toUser.getNick();
            SpannableString spannableString = new SpannableString(CompatKtxKt.messageFormat(R.string.feature_community_posts_reply, str, o10.getContent()));
            SpannableStringKtxKt.setStyleTargetTextSpan(spannableString, new PostsCommentFloorListAdapter.UserClickableSpan(toUser, CompatKtxKt.getColor(R.color.text_theme)), str);
            o10.setStrBuilder(new SpannableStringBuilder(spannableString));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCommentFloorInfos(List<PostsCommentFloorBean> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<PostsCommentFloorBean> it = list.iterator();
            while (it.hasNext()) {
                setCommentFloorInfo(it.next());
            }
        }
    }

    public final void commentDelete(@NotNull PostsCommentBean itemComment, int positionComment, @Nullable PostsCommentFloorBean itemCommentFloor, int positionCommentFloor) {
        String commentId;
        Intrinsics.checkNotNullParameter(itemComment, "itemComment");
        ApiCommunityPostsImpl apiCommunityPostsImpl = ApiCommunityPostsImpl.INSTANCE;
        if (itemCommentFloor != null) {
            commentId = itemCommentFloor.getCommentId();
        } else {
            commentId = itemComment.getCommentId();
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(apiCommunityPostsImpl.commentOperateDelete(commentId), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit commentDelete$lambda$21;
                commentDelete$lambda$21 = PostsDetailsViewModel.commentDelete$lambda$21(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return commentDelete$lambda$21;
            }
        }, 3, null), new PostsDetailsViewModel$commentDelete$2(itemCommentFloor, this, itemComment, positionComment, positionCommentFloor, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void commentLike(@NotNull PostsCommentBean item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.commentLike(item.getCommentId(), !item.isLike()), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit commentLike$lambda$8;
                commentLike$lambda$8 = PostsDetailsViewModel.commentLike$lambda$8(PostsDetailsViewModel.this, ((Boolean) obj).booleanValue());
                return commentLike$lambda$8;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit commentLike$lambda$9;
                commentLike$lambda$9 = PostsDetailsViewModel.commentLike$lambda$9(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return commentLike$lambda$9;
            }
        }, 1, null), new PostsDetailsViewModel$commentLike$3(item, this, position, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void commentReport(int operate, @NotNull PostsCommentBean itemComment, @Nullable PostsCommentFloorBean itemCommentFloor) {
        String commentId;
        Intrinsics.checkNotNullParameter(itemComment, "itemComment");
        ApiCommunityPostsImpl apiCommunityPostsImpl = ApiCommunityPostsImpl.INSTANCE;
        if (itemCommentFloor != null) {
            commentId = itemCommentFloor.getCommentId();
        } else {
            commentId = itemComment.getCommentId();
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(apiCommunityPostsImpl.commentOperateReport(operate, commentId), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit commentReport$lambda$22;
                commentReport$lambda$22 = PostsDetailsViewModel.commentReport$lambda$22(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return commentReport$lambda$22;
            }
        }, 3, null), new PostsDetailsViewModel$commentReport$2(null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    @NotNull
    public final ma.b getCommentFloorListMoreLiveData() {
        return this.commentFloorListMoreLiveData;
    }

    @NotNull
    public final ma.b getCommentListLiveData() {
        return this.commentListLiveData;
    }

    public final void getComments(@Nullable String pageCursor) {
        final Flow<PostsCommentListBean> commentList = ApiCommunityPostsImpl.INSTANCE.getCommentList(this.postId, pageCursor);
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(FlowKt.flowOn(new Flow<PostsCommentListBean>() { // from class: com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getComments$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PostsDetailsViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n275#3:220\n276#3,2:222\n278#3:225\n1863#4:221\n1864#4:224\n*S KotlinDebug\n*F\n+ 1 PostsDetailsViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel\n*L\n275#1:221\n275#1:224\n*E\n"})
            /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getComments$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ PostsDetailsViewModel this$0;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getComments$$inlined$map$1$2", f = "PostsDetailsViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getComments$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, PostsDetailsViewModel postsDetailsViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = postsDetailsViewModel;
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
                                PostsCommentListBean postsCommentListBean = (PostsCommentListBean) obj;
                                List<PostsCommentBean> data = postsCommentListBean.getData();
                                if (data != null) {
                                    Iterator<T> it = data.iterator();
                                    while (it.hasNext()) {
                                        this.this$0.setCommentFloorInfos(((PostsCommentBean) it.next()).getSubComments());
                                    }
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(postsCommentListBean, anonymousClass1) == coroutine_suspended) {
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
                Object collect = commentList.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, Dispatchers.getIO()), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit comments$lambda$17;
                comments$lambda$17 = PostsDetailsViewModel.getComments$lambda$17(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return comments$lambda$17;
            }
        }, 3, null), new PostsDetailsViewModel$getComments$3(this, pageCursor, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    @NotNull
    public final ma.b getDeletedStateLiveData() {
        return this.deletedStateLiveData;
    }

    @Nullable
    public final String getNoticeId() {
        return this.noticeId;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }

    public final void getPostsDetail() {
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsDetail(this.postId), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsDetail$lambda$0;
                postsDetail$lambda$0 = PostsDetailsViewModel.getPostsDetail$lambda$0(PostsDetailsViewModel.this, ((Boolean) obj).booleanValue());
                return postsDetail$lambda$0;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsDetail$lambda$1;
                postsDetail$lambda$1 = PostsDetailsViewModel.getPostsDetail$lambda$1(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return postsDetail$lambda$1;
            }
        }, 1, null), new PostsDetailsViewModel$getPostsDetail$3(this, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void getPostsDetailByNoticeId() {
        final Flow flowOn = FlowKt.flowOn(ApiCommunityPostsImpl.INSTANCE.postsDetailByNoticeId(this.noticeId), Dispatchers.getIO());
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(new Flow<PostsNoticePostsInfoBean>() { // from class: com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getPostsDetailByNoticeId$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PostsDetailsViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n80#3:220\n81#3,2:222\n83#3:225\n1863#4:221\n1864#4:224\n*S KotlinDebug\n*F\n+ 1 PostsDetailsViewModel.kt\ncom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel\n*L\n80#1:221\n80#1:224\n*E\n"})
            /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getPostsDetailByNoticeId$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ PostsDetailsViewModel this$0;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getPostsDetailByNoticeId$$inlined$map$1$2", f = "PostsDetailsViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$getPostsDetailByNoticeId$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, PostsDetailsViewModel postsDetailsViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = postsDetailsViewModel;
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
                                PostsNoticePostsInfoBean postsNoticePostsInfoBean = (PostsNoticePostsInfoBean) obj;
                                List<PostsCommentBean> comments = postsNoticePostsInfoBean.getComments();
                                if (comments != null) {
                                    Iterator<T> it = comments.iterator();
                                    while (it.hasNext()) {
                                        this.this$0.setCommentFloorInfos(((PostsCommentBean) it.next()).getSubComments());
                                    }
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(postsNoticePostsInfoBean, anonymousClass1) == coroutine_suspended) {
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
                Object collect = flowOn.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsDetailByNoticeId$lambda$4;
                postsDetailByNoticeId$lambda$4 = PostsDetailsViewModel.getPostsDetailByNoticeId$lambda$4(PostsDetailsViewModel.this, ((Boolean) obj).booleanValue());
                return postsDetailByNoticeId$lambda$4;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsDetailByNoticeId$lambda$5;
                postsDetailByNoticeId$lambda$5 = PostsDetailsViewModel.getPostsDetailByNoticeId$lambda$5(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return postsDetailByNoticeId$lambda$5;
            }
        }, 1, null), new PostsDetailsViewModel$getPostsDetailByNoticeId$4(this, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    @NotNull
    public final ma.b getPostsInfoLiveData() {
        return this.postsInfoLiveData;
    }

    public final long getTargetUserId() {
        return this.targetUserId;
    }

    public final void loadMoreCommentFloor(@NotNull PostsCommentBean item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.getCommentFloorList(this.postId, item.getCommentId(), item.getNextPageCursor()), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit loadMoreCommentFloor$lambda$19;
                loadMoreCommentFloor$lambda$19 = PostsDetailsViewModel.loadMoreCommentFloor$lambda$19(PostsDetailsViewModel.this, ((Boolean) obj).booleanValue());
                return loadMoreCommentFloor$lambda$19;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit loadMoreCommentFloor$lambda$20;
                loadMoreCommentFloor$lambda$20 = PostsDetailsViewModel.loadMoreCommentFloor$lambda$20(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return loadMoreCommentFloor$lambda$20;
            }
        }, 1, null), new PostsDetailsViewModel$loadMoreCommentFloor$3(item, this, position, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void postsLike() {
        PostsInfoBean postsInfoBean = (PostsInfoBean) this.postsInfoLiveData.getValue();
        if (postsInfoBean == null) {
            return;
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsLikes(postsInfoBean.getId(), !postsInfoBean.isLike()), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsLike$lambda$6;
                postsLike$lambda$6 = PostsDetailsViewModel.postsLike$lambda$6(((Boolean) obj).booleanValue());
                return postsLike$lambda$6;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit postsLike$lambda$7;
                postsLike$lambda$7 = PostsDetailsViewModel.postsLike$lambda$7(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return postsLike$lambda$7;
            }
        }, 1, null), new PostsDetailsViewModel$postsLike$3(postsInfoBean, this, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void sendComment(@Nullable String content) {
        PostsInfoBean postsInfoBean = (PostsInfoBean) this.postsInfoLiveData.getValue();
        if (postsInfoBean != null) {
            ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.sendPostsComment(postsInfoBean.getId(), content), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit sendComment$lambda$12$lambda$10;
                    sendComment$lambda$12$lambda$10 = PostsDetailsViewModel.sendComment$lambda$12$lambda$10(PostsDetailsViewModel.this, ((Boolean) obj).booleanValue());
                    return sendComment$lambda$12$lambda$10;
                }
            }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit sendComment$lambda$12$lambda$11;
                    sendComment$lambda$12$lambda$11 = PostsDetailsViewModel.sendComment$lambda$12$lambda$11(PostsDetailsViewModel.this, (ApiErrorException) obj);
                    return sendComment$lambda$12$lambda$11;
                }
            }, 1, null), new PostsDetailsViewModel$sendComment$1$3(this, postsInfoBean, content, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
        }
    }

    public final void sendCommentFloor(@NotNull String content, @NotNull Pair<PostsCommentBean, Integer> replyComment, @Nullable Pair<PostsCommentFloorBean, Integer> replyCommentFloor) {
        String commentId;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(replyComment, "replyComment");
        String commentId2 = replyComment.getFirst().getCommentId();
        if (replyCommentFloor != null) {
            commentId = replyCommentFloor.getFirst().getCommentId();
        } else {
            commentId = replyComment.getFirst().getCommentId();
        }
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.sendPostsCommentFloor(this.postId, content, commentId2, commentId), false, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit sendCommentFloor$lambda$13;
                sendCommentFloor$lambda$13 = PostsDetailsViewModel.sendCommentFloor$lambda$13(PostsDetailsViewModel.this, ((Boolean) obj).booleanValue());
                return sendCommentFloor$lambda$13;
            }
        }, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit sendCommentFloor$lambda$14;
                sendCommentFloor$lambda$14 = PostsDetailsViewModel.sendCommentFloor$lambda$14(PostsDetailsViewModel.this, (ApiErrorException) obj);
                return sendCommentFloor$lambda$14;
            }
        }, 1, null), new PostsDetailsViewModel$sendCommentFloor$3(this, content, replyCommentFloor, replyComment, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    public final void setNoticeId(@Nullable String str) {
        this.noticeId = str;
    }

    public final void setPostId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.postId = str;
    }

    public final void setTargetUserId(long j10) {
        this.targetUserId = j10;
    }
}

package com.qhqc.core.feature.community.data.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.net.ResponseUtilsKt;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel;
import com.qhqc.core.feature.api.community.impl.ApiCommunityPostsImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\bR.\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/qhqc/core/feature/community/data/viewmodel/PostsLikeListViewModel;", "Lcom/qhqc/core/basic/uiframe/viewmodel/BaseViewModel;", "<init>", "()V", "", "pageCursor", "", "getLikeList", "(Ljava/lang/String;)V", ShareConstants.RESULT_POST_ID, "Ljava/lang/String;", "getPostId", "()Ljava/lang/String;", "setPostId", "Lma/b;", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "Lcom/qhqc/core/feature/bean/community/PostsLikeBean;", "likeListLiveData", "Lma/b;", "getLikeListLiveData", "()Lma/b;", "setLikeListLiveData", "(Lma/b;)V", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsLikeListViewModel extends BaseViewModel {

    @NotNull
    private String postId = "";

    @NotNull
    private ma.b likeListLiveData = new ma.b();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getLikeList$lambda$0(ApiErrorException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void getLikeList(@Nullable String pageCursor) {
        ResponseUtilsKt.startIn$default(FlowKt.onEach(ResponseUtilsKt.flowRequest$default(ApiCommunityPostsImpl.INSTANCE.postsLikeList(this.postId, pageCursor), false, null, new Function1() { // from class: com.qhqc.core.feature.community.data.viewmodel.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit likeList$lambda$0;
                likeList$lambda$0 = PostsLikeListViewModel.getLikeList$lambda$0((ApiErrorException) obj);
                return likeList$lambda$0;
            }
        }, 3, null), new PostsLikeListViewModel$getLikeList$2(this, pageCursor, null)), ViewModelKt.getViewModelScope(this), false, 2, null);
    }

    @NotNull
    public final ma.b getLikeListLiveData() {
        return this.likeListLiveData;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }

    public final void setLikeListLiveData(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.likeListLiveData = bVar;
    }

    public final void setPostId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.postId = str;
    }
}

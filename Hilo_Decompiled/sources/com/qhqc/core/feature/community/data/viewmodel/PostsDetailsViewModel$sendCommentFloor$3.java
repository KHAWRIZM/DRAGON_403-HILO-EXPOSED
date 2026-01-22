package com.qhqc.core.feature.community.data.viewmodel;

import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.events.CommentEvent;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel$sendCommentFloor$3", f = "PostsDetailsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsDetailsViewModel$sendCommentFloor$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Pair<PostsCommentBean, Integer> $replyComment;
    final /* synthetic */ Pair<PostsCommentFloorBean, Integer> $replyCommentFloor;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostsDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsDetailsViewModel$sendCommentFloor$3(PostsDetailsViewModel postsDetailsViewModel, String str, Pair<PostsCommentFloorBean, Integer> pair, Pair<PostsCommentBean, Integer> pair2, Continuation<? super PostsDetailsViewModel$sendCommentFloor$3> continuation) {
        super(2, continuation);
        this.this$0 = postsDetailsViewModel;
        this.$content = str;
        this.$replyCommentFloor = pair;
        this.$replyComment = pair2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostsDetailsViewModel$sendCommentFloor$3 postsDetailsViewModel$sendCommentFloor$3 = new PostsDetailsViewModel$sendCommentFloor$3(this.this$0, this.$content, this.$replyCommentFloor, this.$replyComment, continuation);
        postsDetailsViewModel$sendCommentFloor$3.L$0 = obj;
        return postsDetailsViewModel$sendCommentFloor$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserInfoBean user;
        int i10;
        PostsCommentFloorBean postsCommentFloorBean;
        int i11;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            PostsInfoBean postsInfoBean = (PostsInfoBean) this.this$0.getPostsInfoLiveData().getValue();
            if (postsInfoBean != null) {
                PostsDetailsViewModel postsDetailsViewModel = this.this$0;
                postsInfoBean.setCommentCount(postsInfoBean.getCommentCount() + 1);
                CommunityManager.INSTANCE.getInstance().dispatchPostsEvent$feature_community_release(new PostsEvent(4097, postsDetailsViewModel.getPostId(), postsInfoBean));
            }
            String str2 = this.$content;
            long currentTimeMillis = System.currentTimeMillis();
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            UserInfoBean myUserInfo = companion.getInstance().getMyUserInfo();
            Pair<PostsCommentFloorBean, Integer> pair = this.$replyCommentFloor;
            if (pair != null) {
                user = pair.getFirst().getFromUser();
            } else {
                user = this.$replyComment.getFirst().getUser();
            }
            PostsCommentFloorBean postsCommentFloorBean2 = new PostsCommentFloorBean(str, str2, currentTimeMillis, myUserInfo, user, null, 32, null);
            this.this$0.setCommentFloorInfo(postsCommentFloorBean2);
            if (this.$replyComment.getFirst().getSubComments() == null) {
                this.$replyComment.getFirst().setSubComments(new ArrayList());
            }
            List<PostsCommentFloorBean> subComments = this.$replyComment.getFirst().getSubComments();
            if (subComments != null) {
                Boxing.boxBoolean(subComments.add(postsCommentFloorBean2));
            }
            PostsCommentBean first = this.$replyComment.getFirst();
            first.setSubCommentCnt(first.getSubCommentCnt() + 1);
            CommunityManager companion2 = companion.getInstance();
            if (this.$replyCommentFloor == null) {
                i10 = CommentEvent.EVENT_REPLY;
            } else {
                i10 = CommentEvent.EVENT_REPLY_FLOOR;
            }
            CommentEvent commentEvent = new CommentEvent(i10, this.this$0.getPostId());
            Pair<PostsCommentBean, Integer> pair2 = this.$replyComment;
            Pair<PostsCommentFloorBean, Integer> pair3 = this.$replyCommentFloor;
            commentEvent.setItem(pair2.getFirst());
            commentEvent.setPosition(pair2.getSecond().intValue());
            if (pair3 != null) {
                postsCommentFloorBean = pair3.getFirst();
            } else {
                postsCommentFloorBean = null;
            }
            commentEvent.setItemCommentFloor(postsCommentFloorBean);
            if (pair3 != null) {
                i11 = pair3.getSecond().intValue();
            } else {
                i11 = -1;
            }
            commentEvent.setItemCommentFloorPosition(i11);
            companion2.dispatchCommentEvent$feature_community_release(commentEvent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((PostsDetailsViewModel$sendCommentFloor$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

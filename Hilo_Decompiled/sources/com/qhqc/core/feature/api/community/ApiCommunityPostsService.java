package com.qhqc.core.feature.api.community;

import com.facebook.internal.NativeProtocol;
import com.qhqc.core.feature.api.ServiceRouterKt;
import com.qhqc.core.feature.bean.community.NewestUserBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorListBean;
import com.qhqc.core.feature.bean.community.PostsCommentListBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoListBean;
import com.qhqc.core.feature.bean.community.PostsLikeListBean;
import com.qhqc.core.feature.bean.community.PostsNoticeListBean;
import com.qhqc.core.feature.bean.community.PostsNoticePostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'J4\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H'¨\u0006#"}, d2 = {"Lcom/qhqc/core/feature/api/community/ApiCommunityPostsService;", "", "postsCreate", "Lkotlinx/coroutines/flow/Flow;", "", NativeProtocol.WEB_DIALOG_PARAMS, "", "postsLikes", "postsDetails", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "postsLikeList", "Lcom/qhqc/core/feature/bean/community/PostsLikeListBean;", "postsOperate", "getPostsInfoList", "Lcom/qhqc/core/feature/bean/community/PostsInfoListBean;", "postsListOperate", "sendComment", "commentLikes", "commentOperate", "commentList", "Lcom/qhqc/core/feature/bean/community/PostsCommentListBean;", "commentFloorList", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorListBean;", "noticeList", "Lcom/qhqc/core/feature/bean/community/PostsNoticeListBean;", "postsDetailsByNoticeId", "Lcom/qhqc/core/feature/bean/community/PostsNoticePostsInfoBean;", "noticeRead", "getUnRead", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "clearUnreadCount", "getPostNewestUserList", "Ljava/util/ArrayList;", "Lcom/qhqc/core/feature/bean/community/NewestUserBean;", "Lkotlin/collections/ArrayList;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface ApiCommunityPostsService {
    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_NOTICE)
    @NotNull
    Flow<Object> clearUnreadCount(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_COMMENT_LIST)
    @NotNull
    Flow<PostsCommentFloorListBean> commentFloorList(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_COMMENT)
    @NotNull
    Flow<String> commentLikes(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_COMMENT_LIST)
    @NotNull
    Flow<PostsCommentListBean> commentList(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_COMMENT)
    @NotNull
    Flow<Object> commentOperate(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST_LIST)
    @NotNull
    Flow<ArrayList<NewestUserBean>> getPostNewestUserList(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST_LIST)
    @NotNull
    Flow<PostsInfoListBean> getPostsInfoList(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_NOTICE)
    @NotNull
    Flow<PostsNoticeUnReadBean> getUnRead(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_NOTICE)
    @NotNull
    Flow<PostsNoticeListBean> noticeList(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_NOTICE)
    @NotNull
    Flow<Object> noticeRead(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST)
    @NotNull
    Flow<String> postsCreate(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST)
    @NotNull
    Flow<PostsInfoBean> postsDetails(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_NOTICE)
    @NotNull
    Flow<PostsNoticePostsInfoBean> postsDetailsByNoticeId(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST)
    @NotNull
    Flow<PostsLikeListBean> postsLikeList(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST)
    @NotNull
    Flow<Object> postsLikes(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST_LIST)
    @NotNull
    Flow<Object> postsListOperate(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_POST)
    @NotNull
    Flow<Object> postsOperate(@FieldMap @NotNull Map<String, String> params);

    @FormUrlEncoded
    @POST(ServiceRouterKt.SR_COMMUNITY_COMMENT)
    @NotNull
    Flow<String> sendComment(@FieldMap @NotNull Map<String, String> params);
}

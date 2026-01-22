package com.qhqc.core.feature.api.community.impl;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.net.HttpUtils;
import com.qhqc.core.feature.api.ParamsBuilder;
import com.qhqc.core.feature.api.community.ApiCommunityPostsService;
import com.qhqc.core.feature.bean.community.NewestUserBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorListBean;
import com.qhqc.core.feature.bean.community.PostsCommentListBean;
import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoListBean;
import com.qhqc.core.feature.bean.community.PostsLikeListBean;
import com.qhqc.core.feature.bean.community.PostsNoticeListBean;
import com.qhqc.core.feature.bean.community.PostsNoticePostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticeUnReadBean;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J.\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\bJ4\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J \u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ4\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\bJ \u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ*\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\bJ\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007J\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0007J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\b2\u0006\u00104\u001a\u00020\nJ\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u00103\u001a\u0004\u0018\u00010\bJ\u001e\u00106\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u00104\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\bJ\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u001e\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u00104\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u001c\u00109\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020;0:j\b\u0012\u0004\u0012\u00020;`<0\u0007¨\u0006="}, d2 = {"Lcom/qhqc/core/feature/api/community/impl/ApiCommunityPostsImpl;", "", "<init>", "()V", "apiImp", "Lcom/qhqc/core/feature/api/community/ApiCommunityPostsService;", "postsCreate", "Lkotlinx/coroutines/flow/Flow;", "", "publicType", "", "sources", "", "Lcom/qhqc/core/feature/bean/community/PostsCreateMediaBean;", "content", "getPostsInfoList", "Lcom/qhqc/core/feature/bean/community/PostsInfoListBean;", "pageCursor", "pageSize", "op", "targetUserId", "", "postsLikes", ShareConstants.RESULT_POST_ID, "isLike", "", "postsDetail", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "postsDetailByNoticeId", "Lcom/qhqc/core/feature/bean/community/PostsNoticePostsInfoBean;", "noticeId", "postsLikeList", "Lcom/qhqc/core/feature/bean/community/PostsLikeListBean;", "commentLike", "commentId", "sendPostsComment", "sendPostsCommentFloor", "toCommentId", "getCommentList", "Lcom/qhqc/core/feature/bean/community/PostsCommentListBean;", "getCommentFloorList", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorListBean;", "getNoticeList", "Lcom/qhqc/core/feature/bean/community/PostsNoticeListBean;", "readFollowPostsList", "lastPostId", "readNotice", "clearUnreadCount", "getUnReadNotice", "Lcom/qhqc/core/feature/bean/community/PostsNoticeUnReadBean;", "postsReport", "postsId", "operate", "postsDelete", "postsSuperAdminOperate", "commentOperateDelete", "commentOperateReport", "getPostNewestUserList", "Ljava/util/ArrayList;", "Lcom/qhqc/core/feature/bean/community/NewestUserBean;", "Lkotlin/collections/ArrayList;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ApiCommunityPostsImpl {

    @NotNull
    public static final ApiCommunityPostsImpl INSTANCE = new ApiCommunityPostsImpl();

    private ApiCommunityPostsImpl() {
    }

    private final ApiCommunityPostsService apiImp() {
        return (ApiCommunityPostsService) HttpUtils.build$default(HttpUtils.INSTANCE.getNewInstance(), ApiCommunityPostsService.class, false, 2, null);
    }

    public static /* synthetic */ Flow getNoticeList$default(ApiCommunityPostsImpl apiCommunityPostsImpl, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return apiCommunityPostsImpl.getNoticeList(str);
    }

    public static /* synthetic */ Flow getPostsInfoList$default(ApiCommunityPostsImpl apiCommunityPostsImpl, String str, int i10, String str2, long j10, int i11, Object obj) {
        int i12;
        if ((i11 & 2) != 0) {
            i12 = 10;
        } else {
            i12 = i10;
        }
        if ((i11 & 4) != 0) {
            str2 = "newest";
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            j10 = 0;
        }
        return apiCommunityPostsImpl.getPostsInfoList(str, i12, str3, j10);
    }

    public static /* synthetic */ Flow postsCreate$default(ApiCommunityPostsImpl apiCommunityPostsImpl, int i10, List list, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        return apiCommunityPostsImpl.postsCreate(i10, list, str);
    }

    @NotNull
    public final Flow<Object> clearUnreadCount() {
        return apiImp().clearUnreadCount(new ParamsBuilder().op("notice").operateOp("clear").buildParam());
    }

    @NotNull
    public final Flow<String> commentLike(@Nullable String commentId, boolean isLike) {
        int i10;
        ApiCommunityPostsService apiImp = apiImp();
        ParamsBuilder put = new ParamsBuilder().op("comment").operateOp("like").put("commentId", commentId);
        if (isLike) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        return apiImp.commentLikes(put.put("like", Integer.valueOf(i10)).buildParam());
    }

    @NotNull
    public final Flow<Object> commentOperateDelete(@Nullable String commentId) {
        return apiImp().commentOperate(new ParamsBuilder().op("comment").operateOp(ChatMenuDialog.CLICK_DELETE).put("commentId", commentId).buildParam());
    }

    @NotNull
    public final Flow<Object> commentOperateReport(int operate, @Nullable String commentId) {
        int i10 = 4;
        if (operate != 4) {
            if (operate != 5) {
                if (operate != 6) {
                    i10 = 1;
                }
            } else {
                i10 = 3;
            }
        } else {
            i10 = 2;
        }
        return apiImp().commentOperate(new ParamsBuilder().op("comment").operateOp(ChatMenuDialog.CLICK_REPORT).put("commentId", commentId).put("reason", Integer.valueOf(i10)).buildParam());
    }

    @NotNull
    public final Flow<PostsCommentFloorListBean> getCommentFloorList(@Nullable String postId, @Nullable String commentId, @Nullable String pageCursor) {
        return apiImp().commentFloorList(new ParamsBuilder().op("commentlist").operateOp("second").postId(postId).put("commentId", commentId).pageCursor(pageCursor).pageSize(10).buildParam());
    }

    @NotNull
    public final Flow<PostsCommentListBean> getCommentList(@Nullable String postId, @Nullable String pageCursor) {
        return apiImp().commentList(new ParamsBuilder().op("commentlist").operateOp("first").postId(postId).pageCursor(pageCursor).pageSize(10).buildParam());
    }

    @NotNull
    public final Flow<PostsNoticeListBean> getNoticeList(@Nullable String pageCursor) {
        return apiImp().noticeList(new ParamsBuilder().op("notice").operateOp("list").pageCursor(pageCursor).pageSize(10).buildParam());
    }

    @NotNull
    public final Flow<ArrayList<NewestUserBean>> getPostNewestUserList() {
        return apiImp().getPostNewestUserList(new ParamsBuilder().op("postlist").operateOp("latest_users").buildParam());
    }

    @NotNull
    public final Flow<PostsInfoListBean> getPostsInfoList(@Nullable String pageCursor, int pageSize, @NotNull String op, long targetUserId) {
        Intrinsics.checkNotNullParameter(op, "op");
        return apiImp().getPostsInfoList(new ParamsBuilder().op("postlist").operateOp(op).pageCursor(pageCursor).pageSize(pageSize).put("targetUserId", Long.valueOf(targetUserId)).buildParam());
    }

    @NotNull
    public final Flow<PostsNoticeUnReadBean> getUnReadNotice() {
        return apiImp().getUnRead(new ParamsBuilder().op("notice").operateOp("unread").buildParam());
    }

    @NotNull
    public final Flow<String> postsCreate(int publicType, @NotNull List<PostsCreateMediaBean> sources, @Nullable String content) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        JSONArray jSONArray = new JSONArray();
        for (PostsCreateMediaBean postsCreateMediaBean : sources) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", postsCreateMediaBean.getMediaType());
            jSONObject.put("url", postsCreateMediaBean.getUploadedPath());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, postsCreateMediaBean.getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, postsCreateMediaBean.getHeight());
            jSONObject.put("fileMd5", postsCreateMediaBean.getMd5());
            jSONArray.put(jSONObject);
        }
        return apiImp().postsCreate(new ParamsBuilder().op("post").operateOp("create").put("publicType", Integer.valueOf(publicType)).put("content", content).put("resources", jSONArray).buildParam());
    }

    @NotNull
    public final Flow<Object> postsDelete(@Nullable String postsId) {
        return apiImp().postsOperate(new ParamsBuilder().op("post").operateOp(ChatMenuDialog.CLICK_DELETE).postId(postsId).buildParam());
    }

    @NotNull
    public final Flow<PostsInfoBean> postsDetail(@Nullable String postId) {
        return apiImp().postsDetails(new ParamsBuilder().op("post").operateOp("detail").postId(postId).buildParam());
    }

    @NotNull
    public final Flow<PostsNoticePostsInfoBean> postsDetailByNoticeId(@Nullable String noticeId) {
        return apiImp().postsDetailsByNoticeId(new ParamsBuilder().op("notice").operateOp("notice_to_post").put("noticeId", noticeId).buildParam());
    }

    @NotNull
    public final Flow<PostsLikeListBean> postsLikeList(@Nullable String postId, @Nullable String pageCursor) {
        return apiImp().postsLikeList(new ParamsBuilder().op("post").operateOp("like_list").postId(postId).pageCursor(pageCursor).pageSize(10).buildParam());
    }

    @NotNull
    public final Flow<Object> postsLikes(@Nullable String postId, boolean isLike) {
        int i10;
        ApiCommunityPostsService apiImp = apiImp();
        ParamsBuilder postId2 = new ParamsBuilder().op("post").operateOp("like").postId(postId);
        if (isLike) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        return apiImp.postsLikes(postId2.put("like", Integer.valueOf(i10)).buildParam());
    }

    @NotNull
    public final Flow<Object> postsReport(@Nullable String postsId, int operate) {
        int i10 = 4;
        if (operate != 4) {
            if (operate != 5) {
                if (operate != 6) {
                    i10 = 1;
                }
            } else {
                i10 = 3;
            }
        } else {
            i10 = 2;
        }
        return apiImp().postsOperate(new ParamsBuilder().op("post").operateOp(ChatMenuDialog.CLICK_REPORT).postId(postsId).put("reason", Integer.valueOf(i10)).buildParam());
    }

    @NotNull
    public final Flow<Object> postsSuperAdminOperate(int operate, @Nullable String postsId) {
        String str;
        ParamsBuilder postId = new ParamsBuilder().op("post").postId(postsId);
        switch (operate) {
            case 8:
                postId.put("recommend", 1);
                str = "recommend";
                break;
            case 9:
                str = ViewHierarchyConstants.DIMENSION_TOP_KEY;
                break;
            case 10:
                str = "hide";
                break;
            case 11:
                str = ChatMenuDialog.CLICK_DELETE;
                break;
            case 12:
                str = "ban";
                break;
            default:
                str = "";
                break;
        }
        postId.operateOp(str);
        return apiImp().postsOperate(postId.buildParam());
    }

    @NotNull
    public final Flow<Object> readFollowPostsList(@Nullable String lastPostId) {
        return apiImp().postsListOperate(new ParamsBuilder().op("postlist").operateOp("follow_read").put("lastPostId", lastPostId).buildParam());
    }

    @NotNull
    public final Flow<Object> readNotice(@Nullable String noticeId) {
        return apiImp().noticeRead(new ParamsBuilder().op("notice").operateOp("read").put("noticeId", noticeId).buildParam());
    }

    @NotNull
    public final Flow<String> sendPostsComment(@Nullable String postId, @Nullable String content) {
        return apiImp().sendComment(new ParamsBuilder().op("comment").operateOp("post").postId(postId).content(content).buildParam());
    }

    @NotNull
    public final Flow<String> sendPostsCommentFloor(@Nullable String postId, @Nullable String content, @Nullable String commentId, @Nullable String toCommentId) {
        return apiImp().sendComment(new ParamsBuilder().op("comment").operateOp("comment").postId(postId).put("commentId", commentId).put("toCommentId", toCommentId).content(content).buildParam());
    }
}

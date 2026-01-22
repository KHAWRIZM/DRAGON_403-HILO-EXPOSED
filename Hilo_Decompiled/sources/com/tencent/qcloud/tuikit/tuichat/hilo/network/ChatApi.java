package com.tencent.qcloud.tuikit.tuichat.hilo.network;

import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.im.StrangeChange;
import com.qiahao.base_common.network.CommonApi;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\bJ/\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00122\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0017\u0010\u0018J=\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00050\u00042\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u00122\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u0012H'¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u0012H'¢\u0006\u0004\b \u0010\u001fJ/\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010!\u001a\u00020\u00122\b\b\u0001\u0010\"\u001a\u00020\u0012H'¢\u0006\u0004\b#\u0010$J9\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010%\u001a\u00020\u00122\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u0012H'¢\u0006\u0004\b&\u0010'J9\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00122\b\b\u0001\u0010(\u001a\u00020\u0012H'¢\u0006\u0004\b)\u0010*J9\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00122\b\b\u0001\u0010(\u001a\u00020\u0012H'¢\u0006\u0004\b+\u0010*J/\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010!\u001a\u00020\u00122\b\b\u0001\u0010\"\u001a\u00020\u0012H'¢\u0006\u0004\b,\u0010$J9\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010!\u001a\u00020\u00122\b\b\u0001\u0010-\u001a\u00020\u0002H'¢\u0006\u0004\b.\u0010\u001bJ%\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b/\u0010\bJ%\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b1\u0010\b¨\u00062"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/network/ChatApi;", "Lcom/qiahao/base_common/network/CommonApi;", "", "toUID", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "Lcom/qiahao/base_common/model/common/LikeResult;", "unlike", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", OnlineCellViewHolder.CLICK_LIKE, SupportGiftRankActivity.EXTERNAL_ID, "groupId", "Lcom/qiahao/base_common/model/common/User;", "fetchUserDetail", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "", "giftID", "sceneUid", "", "giftN", "giftText", "maskGroupId", "Lcom/qiahao/base_common/model/common/ChannelEventGiftAddTime;", "userChatSendGift", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", GameMatchActivity.GAME_ID, "inviteSheep", "(Ljava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "type", "", "cpInviteReply", "(Ljava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", "cpReply", "msgType", "msgId", "checkCpIm", "(II)Lio/reactivex/rxjava3/core/i0;", "matchId", "roomMatchGameJoin", "(ILjava/lang/String;I)Lio/reactivex/rxjava3/core/i0;", CpSpaceActivity.RELATION_TYPE, "relationInviteReply", "(Ljava/lang/String;II)Lio/reactivex/rxjava3/core/i0;", "relationReply", "checkRelationIm", "content", "sendStrangeMessage", "exitStrangeChat", "Lcom/qiahao/base_common/model/im/StrangeChange;", "strangeGroupIn", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface ChatApi extends CommonApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ i0 inviteSheep$default(ChatApi chatApi, String str, int i, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                if ((i2 & 4) != 0) {
                    str2 = "";
                }
                return chatApi.inviteSheep(str, i, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inviteSheep");
        }

        public static /* synthetic */ i0 userChatSendGift$default(ChatApi chatApi, String str, long j, String str2, int i, String str3, String str4, int i2, Object obj) {
            int i3;
            String str5;
            String str6;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i3 = 1;
                } else {
                    i3 = i;
                }
                if ((i2 & 16) != 0) {
                    str5 = null;
                } else {
                    str5 = str3;
                }
                if ((i2 & 32) != 0) {
                    str6 = null;
                } else {
                    str6 = str4;
                }
                return chatApi.userChatSendGift(str, j, str2, i3, str5, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: userChatSendGift");
        }
    }

    @GET("/v2/cp/im/check")
    @NotNull
    i0<ApiResponse<Object>> checkCpIm(@Query("msgType") int msgType, @Query("msgId") int msgId);

    @GET("/v1/specialRelation/im/check")
    @NotNull
    i0<ApiResponse<Object>> checkRelationIm(@Query("msgType") int msgType, @Query("msgId") int msgId);

    @FormUrlEncoded
    @POST("/v2/cp/relation/invite/reply")
    @NotNull
    i0<ApiResponse<Object>> cpInviteReply(@Field("externalId") @NotNull String externalId, @Field("type") int type);

    @FormUrlEncoded
    @POST("/v2/cp/relation/cancel/reply")
    @NotNull
    i0<ApiResponse<Object>> cpReply(@Field("externalId") @NotNull String externalId, @Field("type") int type);

    @FormUrlEncoded
    @POST("/v1/mask/match/close")
    @NotNull
    i0<ApiResponse<Object>> exitStrangeChat(@Field("groupId") @NotNull String groupId);

    @GET("/v1/user/detail/{userExternalId}")
    @NotNull
    i0<ApiResponse<User>> fetchUserDetail(@Path("userExternalId") @NotNull String externalId, @NotNull @Query("groupId") String groupId);

    @FormUrlEncoded
    @POST("/v1/game/sheep/invite")
    @NotNull
    i0<ApiResponse<Integer>> inviteSheep(@Field("externalId") @Nullable String externalId, @Field("gameId") int gameId, @Field("groupId") @Nullable String groupId);

    @POST("/v1/user/like/{likeUserExternalId}")
    @NotNull
    i0<ApiResponse<LikeResult>> like(@Path("likeUserExternalId") @NotNull String toUID);

    @FormUrlEncoded
    @POST("/v1/specialRelation/invite/reply")
    @NotNull
    i0<ApiResponse<Object>> relationInviteReply(@Field("externalId") @NotNull String externalId, @Field("type") int type, @Field("relationType") int relationType);

    @FormUrlEncoded
    @POST("/v1/specialRelation/cancel/reply")
    @NotNull
    i0<ApiResponse<Object>> relationReply(@Field("externalId") @NotNull String externalId, @Field("type") int type, @Field("relationType") int relationType);

    @FormUrlEncoded
    @POST("/v1/game/sheep/join")
    @NotNull
    i0<ApiResponse<Object>> roomMatchGameJoin(@Field("matchId") int matchId, @Field("groupId") @NotNull String groupId, @Field("gameId") int gameId);

    @FormUrlEncoded
    @POST("/v1/mask/chat/send")
    @NotNull
    i0<ApiResponse<Object>> sendStrangeMessage(@Field("groupId") @NotNull String groupId, @Field("msgType") int msgType, @Field("content") @NotNull String content);

    @FormUrlEncoded
    @PUT("/v1/mask/group/in")
    @NotNull
    i0<ApiResponse<StrangeChange>> strangeGroupIn(@Field("groupId") @NotNull String groupId);

    @DELETE("/v1/user/like/{likeUserExternalId}")
    @NotNull
    i0<ApiResponse<LikeResult>> unlike(@Path("likeUserExternalId") @NotNull String toUID);

    @FormUrlEncoded
    @POST("/v1/gift/private")
    @NotNull
    i0<ApiResponse<ChannelEventGiftAddTime>> userChatSendGift(@Field("toUserExternalId") @NotNull String toUID, @Field("resGiftId") long giftID, @Field("sceneUid") @NotNull String sceneUid, @Field("giftN") int giftN, @Field("giftText") @Nullable String giftText, @Field("maskGroupId") @Nullable String maskGroupId);
}

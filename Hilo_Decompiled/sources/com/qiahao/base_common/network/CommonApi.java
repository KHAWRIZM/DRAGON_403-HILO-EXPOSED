package com.qiahao.base_common.network;

import com.qiahao.base_common.model.common.CheckSessionBean;
import com.qiahao.base_common.model.common.NetworkData;
import com.qiahao.base_common.network.model.ApiResponse;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\bJQ\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J]\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u0004H'¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/network/CommonApi;", "", "", "userExternalId", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "Lcom/qiahao/base_common/model/common/CheckSessionBean;", "checkCanSession", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "externalId", "blockUser", "toUID", "", "reportFrom", "reasonType", "reason", "image", "reportUser", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "groupId", "strangeReportUser", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/model/common/NetworkData;", "getDispatcher", "()Lio/reactivex/rxjava3/core/i0;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface CommonApi {
    @POST("/v1/user/block/{blockUserExternalId}")
    @NotNull
    i0<ApiResponse<Object>> blockUser(@Path("blockUserExternalId") @NotNull String externalId);

    @GET("/v1/session/check")
    @NotNull
    i0<ApiResponse<CheckSessionBean>> checkCanSession(@NotNull @Query("userExternalId") String userExternalId);

    @GET("/dispatcher")
    @NotNull
    i0<ApiResponse<NetworkData>> getDispatcher();

    @FormUrlEncoded
    @POST("/v1/user/report")
    @NotNull
    i0<ApiResponse<Object>> reportUser(@Field("toUserExternalId") @NotNull String toUID, @Field("fromPageType") int reportFrom, @Field("reasonType") int reasonType, @Field("reason") @Nullable String reason, @Field("imageUrl") @Nullable String image);

    @FormUrlEncoded
    @POST("/v1/mask/chat/report")
    @NotNull
    i0<ApiResponse<Object>> strangeReportUser(@Field("toUserExternalId") @NotNull String toUID, @Field("fromPageType") int reportFrom, @Field("reasonType") int reasonType, @Field("reason") @Nullable String reason, @Field("imageUrl") @Nullable String image, @Field("groupId") @Nullable String groupId);
}

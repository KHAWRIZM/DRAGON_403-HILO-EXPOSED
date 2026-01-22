package com.qiahao.nextvideo.room.viewmodel;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.ViewModelKt;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.network.AppServer;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJÑ\u0001\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$R(\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\bR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010(\u001a\u0004\b2\u0010*\"\u0004\b3\u0010,R(\u00104\u001a\b\u0012\u0004\u0012\u00020\u00130%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010(\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R(\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010(\u001a\u0004\b8\u0010*\"\u0004\b9\u0010,¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/GroupSettingViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "", "groupId", "", GroupSettingViewModel.INTERFACE_GETGROUP, "(Ljava/lang/String;)V", "isCanShowSupportLayout", "", "micNumType", "updateMicNumber", "(I)V", "name", "introduction", "notification", TUIConstants.TUIChat.FACE_URL, "password", "", "loadHistory", "autoWelcome", "diceNum", "type", GroupSettingViewModel.TOURIST_MIC, GroupSettingViewModel.TOURIST_MSG, GroupSettingViewModel.TOURIST_PIC, GroupSettingViewModel.TOURIST_FEE, "memberFee", "diceType", "md5", "updateGroupInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/io/File;", "file", "startUpload", "(Ljava/io/File;)V", "Lma/b;", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "mGroupDetail", "Lma/b;", "getMGroupDetail", "()Lma/b;", "setMGroupDetail", "(Lma/b;)V", "mGroupId", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "getUpdateGroupInfo", "setUpdateGroupInfo", "mGroupLoadHistory", "getMGroupLoadHistory", "setMGroupLoadHistory", "mCanShowSupportLayout", "getMCanShowSupportLayout", "setMCanShowSupportLayout", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSettingViewModel extends BaseViewModel {

    @NotNull
    public static final String FILE_ERROR = "file_error";

    @NotNull
    public static final String INTERFACE_GETGROUP = "getGroupDetail";

    @NotNull
    public static final String INTERFACE_GROUP_AUTO_WELCOME = "group_auto_welcome";

    @NotNull
    public static final String INTERFACE_GROUP_DICE_NUM = "group_diceNum";

    @NotNull
    public static final String INTERFACE_GROUP_FACE_URL = "group_faceUrl";

    @NotNull
    public static final String INTERFACE_GROUP_INTRODUCTION = "group_introduction";

    @NotNull
    public static final String INTERFACE_GROUP_LOAD_HISTORY = "group_loadHistory";

    @NotNull
    public static final String INTERFACE_GROUP_NAME = "group_name";

    @NotNull
    public static final String INTERFACE_GROUP_NOTIFICATION = "group_notification";

    @NotNull
    public static final String INTERFACE_GROUP_PASSWORD = "group_password";

    @NotNull
    private static final String TAG = "GroupSettingViewModel";

    @NotNull
    public static final String TOURIST_FEE = "isChangeFee";

    @NotNull
    public static final String TOURIST_MIC = "touristMic";

    @NotNull
    public static final String TOURIST_MSG = "touristSendMsg";

    @NotNull
    public static final String TOURIST_PIC = "touristSendPic";

    @NotNull
    private ma.b mGroupDetail = new ma.b();

    @NotNull
    private String mGroupId = "";

    @NotNull
    private ma.b updateGroupInfo = new ma.b();

    @NotNull
    private ma.b mGroupLoadHistory = new ma.b();

    @NotNull
    private ma.b mCanShowSupportLayout = new ma.b();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGroupDetail$lambda$1(GroupSettingViewModel groupSettingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupDetailBean groupDetailBean = (GroupDetailBean) apiResponse.getData();
        if (groupDetailBean != null) {
            groupSettingViewModel.mGroupDetail.postValue(groupDetailBean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGroupDetail$lambda$2(GroupSettingViewModel groupSettingViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        groupSettingViewModel.getMErrorDetail().postValue(new Pair(INTERFACE_GETGROUP, th.getLocalizedMessage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isCanShowSupportLayout$lambda$4(GroupSettingViewModel groupSettingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Log.d(TAG, "isCanShowSupportLayout: " + apiResponse.getData());
        Boolean bool = (Boolean) apiResponse.getData();
        if (bool != null) {
            groupSettingViewModel.mCanShowSupportLayout.postValue(bool);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit isCanShowSupportLayout$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpload$lambda$7(GroupSettingViewModel groupSettingViewModel, File file, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            Log.d(TAG, "uploadImage: " + pair.getSecond());
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(groupSettingViewModel), (CoroutineContext) null, (CoroutineStart) null, new GroupSettingViewModel$startUpload$1$1(file, groupSettingViewModel, pair, null), 3, (Object) null);
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupSettingViewModel, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpload$lambda$8(GroupSettingViewModel groupSettingViewModel, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = ResourcesKtxKt.getStringById(groupSettingViewModel, 2131952667);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void updateGroupInfo$default(GroupSettingViewModel groupSettingViewModel, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, String str7, Integer num, String str8, Integer num2, Integer num3, Integer num4, int i, Integer num5, Integer num6, String str9, int i2, Object obj) {
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Boolean bool2;
        String str16;
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        int i3;
        Integer num11;
        Integer num12;
        String str17;
        if ((i2 & 1) != 0) {
            str10 = groupSettingViewModel.mGroupId;
        } else {
            str10 = str;
        }
        if ((i2 & 2) != 0) {
            str11 = null;
        } else {
            str11 = str2;
        }
        if ((i2 & 4) != 0) {
            str12 = null;
        } else {
            str12 = str3;
        }
        if ((i2 & 8) != 0) {
            str13 = null;
        } else {
            str13 = str4;
        }
        if ((i2 & 16) != 0) {
            str14 = null;
        } else {
            str14 = str5;
        }
        if ((i2 & 32) != 0) {
            str15 = null;
        } else {
            str15 = str6;
        }
        if ((i2 & 64) != 0) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        if ((i2 & 128) != 0) {
            str16 = null;
        } else {
            str16 = str7;
        }
        if ((i2 & 256) != 0) {
            num7 = null;
        } else {
            num7 = num;
        }
        if ((i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0) {
            num8 = null;
        } else {
            num8 = num2;
        }
        if ((i2 & 2048) != 0) {
            num9 = null;
        } else {
            num9 = num3;
        }
        if ((i2 & 4096) != 0) {
            num10 = null;
        } else {
            num10 = num4;
        }
        if ((i2 & 8192) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        if ((i2 & 16384) != 0) {
            num11 = null;
        } else {
            num11 = num5;
        }
        if ((32768 & i2) != 0) {
            num12 = null;
        } else {
            num12 = num6;
        }
        if ((i2 & 65536) != 0) {
            str17 = null;
        } else {
            str17 = str9;
        }
        groupSettingViewModel.updateGroupInfo(str10, str11, str12, str13, str14, str15, bool2, str16, num7, str8, num8, num9, num10, i3, num11, num12, str17);
    }

    public final void getGroupDetail(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mGroupId = groupId;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomInfo(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.i
            public final Object invoke(Object obj) {
                Unit groupDetail$lambda$1;
                groupDetail$lambda$1 = GroupSettingViewModel.getGroupDetail$lambda$1(GroupSettingViewModel.this, (ApiResponse) obj);
                return groupDetail$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.j
            public final Object invoke(Object obj) {
                Unit groupDetail$lambda$2;
                groupDetail$lambda$2 = GroupSettingViewModel.getGroupDetail$lambda$2(GroupSettingViewModel.this, (Throwable) obj);
                return groupDetail$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final ma.b getMCanShowSupportLayout() {
        return this.mCanShowSupportLayout;
    }

    @NotNull
    public final ma.b getMGroupDetail() {
        return this.mGroupDetail;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    @NotNull
    public final ma.b getMGroupLoadHistory() {
        return this.mGroupLoadHistory;
    }

    @NotNull
    public final ma.b getUpdateGroupInfo() {
        return this.updateGroupInfo;
    }

    public final void isCanShowSupportLayout(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().canOpenGroupSupport(groupId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.g
            public final Object invoke(Object obj) {
                Unit isCanShowSupportLayout$lambda$4;
                isCanShowSupportLayout$lambda$4 = GroupSettingViewModel.isCanShowSupportLayout$lambda$4(GroupSettingViewModel.this, (ApiResponse) obj);
                return isCanShowSupportLayout$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.h
            public final Object invoke(Object obj) {
                Unit isCanShowSupportLayout$lambda$5;
                isCanShowSupportLayout$lambda$5 = GroupSettingViewModel.isCanShowSupportLayout$lambda$5((Throwable) obj);
                return isCanShowSupportLayout$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void setMCanShowSupportLayout(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mCanShowSupportLayout = bVar;
    }

    public final void setMGroupDetail(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mGroupDetail = bVar;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMGroupLoadHistory(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mGroupLoadHistory = bVar;
    }

    public final void setUpdateGroupInfo(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.updateGroupInfo = bVar;
    }

    public final void startUpload(@NotNull final File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!file.exists()) {
            getMErrorDetail().setValue(new Pair(FILE_ERROR, ""));
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AliCloudService.uploadFileToAWS$default(AliCloudService.INSTANCE.getShared(), AliCloudService.OSS_FOLDER_GROUP, file, null, 4, null), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.k
                public final Object invoke(Object obj) {
                    Unit startUpload$lambda$7;
                    startUpload$lambda$7 = GroupSettingViewModel.startUpload$lambda$7(GroupSettingViewModel.this, file, (Pair) obj);
                    return startUpload$lambda$7;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.l
                public final Object invoke(Object obj) {
                    Unit startUpload$lambda$8;
                    startUpload$lambda$8 = GroupSettingViewModel.startUpload$lambda$8(GroupSettingViewModel.this, (Throwable) obj);
                    return startUpload$lambda$8;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }

    public final void updateGroupInfo(@NotNull String groupId, @Nullable final String name, @Nullable final String introduction, @Nullable final String notification, @Nullable String faceUrl, @Nullable final String password, @Nullable final Boolean loadHistory, @Nullable final String autoWelcome, @Nullable final Integer diceNum, @NotNull final String type, @Nullable final Integer touristMic, @Nullable final Integer touristSendMsg, @Nullable final Integer touristSendPic, int isChangeFee, @Nullable final Integer memberFee, @Nullable final Integer diceType, @Nullable String md5) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(type, "type");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        AppServer.INSTANCE.getApis().updateGroupInfo(groupId, name, introduction, notification, faceUrl, password, loadHistory, autoWelcome, null, diceNum, touristMic, touristSendMsg, touristSendPic, Integer.valueOf(isChangeFee), memberFee, diceType, md5).p(ke.a.b()).k(ke.a.b()).a(new io.reactivex.rxjava3.core.k0() { // from class: com.qiahao.nextvideo.room.viewmodel.GroupSettingViewModel$updateGroupInfo$1
            public void onError(Throwable e) {
                Intrinsics.checkNotNullParameter(e, "e");
                GroupSettingViewModel.this.getMErrorDetail().postValue(new Pair(type, e.getLocalizedMessage()));
            }

            public void onSubscribe(nd.c d) {
                Intrinsics.checkNotNullParameter(d, "d");
                Log.d("GroupSettingViewModel", "onSubscribe: ");
            }

            public void onSuccess(ApiResponse<String> t) {
                String str;
                Intrinsics.checkNotNullParameter(t, "t");
                if (t.isOk()) {
                    GroupSettingViewModel.this.getUpdateGroupInfo().postValue(Boolean.TRUE);
                    GroupDetailBean groupDetailBean = (GroupDetailBean) GroupSettingViewModel.this.getMGroupDetail().getValue();
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_NAME) && groupDetailBean != null) {
                        String str2 = name;
                        Intrinsics.checkNotNull(str2);
                        groupDetailBean.setName(str2);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_INTRODUCTION) && groupDetailBean != null) {
                        String str3 = introduction;
                        Intrinsics.checkNotNull(str3);
                        groupDetailBean.setIntroduction(str3);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_NOTIFICATION) && groupDetailBean != null) {
                        String str4 = notification;
                        Intrinsics.checkNotNull(str4);
                        groupDetailBean.setNotification(str4);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_FACE_URL)) {
                        booleanRef.element = true;
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_PASSWORD)) {
                        String str5 = password;
                        Intrinsics.checkNotNull(str5);
                        if (str5.length() == 0) {
                            if (groupDetailBean != null) {
                                groupDetailBean.setPassword(null);
                            }
                        } else if (groupDetailBean != null) {
                            groupDetailBean.setPassword(password);
                        }
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_AUTO_WELCOME) && groupDetailBean != null) {
                        String str6 = autoWelcome;
                        Intrinsics.checkNotNull(str6);
                        groupDetailBean.setWelcomeText(str6);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_LOAD_HISTORY) && groupDetailBean != null) {
                        Boolean bool = loadHistory;
                        Intrinsics.checkNotNull(bool);
                        groupDetailBean.setLoadHistory(bool);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.INTERFACE_GROUP_DICE_NUM)) {
                        if (groupDetailBean != null) {
                            Integer num = diceNum;
                            Intrinsics.checkNotNull(num);
                            groupDetailBean.setDiceNum(num);
                        }
                        if (groupDetailBean != null) {
                            Integer num2 = diceType;
                            Intrinsics.checkNotNull(num2);
                            groupDetailBean.setDiceType(num2);
                        }
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.TOURIST_MIC) && groupDetailBean != null) {
                        groupDetailBean.setTouristMic(touristMic);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.TOURIST_MSG) && groupDetailBean != null) {
                        groupDetailBean.setTouristSendMsg(touristSendMsg);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.TOURIST_PIC) && groupDetailBean != null) {
                        groupDetailBean.setTouristSendPic(touristSendPic);
                    }
                    if (Intrinsics.areEqual(type, GroupSettingViewModel.TOURIST_FEE) && groupDetailBean != null) {
                        groupDetailBean.setMemberFee(memberFee);
                    }
                    if (!booleanRef.element) {
                        if (groupDetailBean != null) {
                            GroupSettingViewModel.this.getMGroupDetail().postValue(groupDetailBean);
                            return;
                        }
                        return;
                    } else {
                        GroupSettingViewModel groupSettingViewModel = GroupSettingViewModel.this;
                        GroupDetailBean groupDetailBean2 = (GroupDetailBean) groupSettingViewModel.getMGroupDetail().getValue();
                        if (groupDetailBean2 == null || (str = groupDetailBean2.getGroupId()) == null) {
                            str = "";
                        }
                        groupSettingViewModel.getGroupDetail(str);
                        return;
                    }
                }
                GroupSettingViewModel.this.getMErrorDetail().postValue(new Pair(type, t.getMessage()));
            }
        });
    }

    public final void updateMicNumber(int micNumType) {
        GroupDetailBean groupDetailBean = (GroupDetailBean) this.mGroupDetail.getValue();
        if (groupDetailBean != null) {
            groupDetailBean.setMicNumType(Integer.valueOf(micNumType));
        }
        if (groupDetailBean != null) {
            this.mGroupDetail.postValue(groupDetailBean);
        }
    }
}

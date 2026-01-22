package com.qiahao.nextvideo.data.service;

import android.graphics.Color;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.MedalBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.NobleBeanConfig;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010\u0013\u001a\u00020\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u0007J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/service/OutPutOtherModuleService;", "Lcom/qiahao/base_common/service/BaseService;", "<init>", "()V", "mMedalBeanList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/MedalBean;", "Lkotlin/collections/ArrayList;", "getMMedalBeanList", "()Ljava/util/ArrayList;", "setMMedalBeanList", "(Ljava/util/ArrayList;)V", "mNobleBeanConfigList", "Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "getMNobleBeanConfigList", "setMNobleBeanConfigList", "initMedalList", "", "initNobleBeanConfigList", "saveNobleConfigListCache", "nobleBeanConfigList", "getMedalList", "getLevelBg", "", "level", "", "isCharm", "", "isWealth", "isActivity", "getNobleColor", "nobleLevel", "defaultColor", "getNobleDrawableRes", "getUserHasOnMic", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOutPutOtherModuleService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OutPutOtherModuleService.kt\ncom/qiahao/nextvideo/data/service/OutPutOtherModuleService\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,121:1\n439#2:122\n*S KotlinDebug\n*F\n+ 1 OutPutOtherModuleService.kt\ncom/qiahao/nextvideo/data/service/OutPutOtherModuleService\n*L\n100#1:122\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OutPutOtherModuleService extends BaseService {

    @NotNull
    public static final String MEDAL_LOCAL_CACHE = "medal_local_cache";

    @NotNull
    public static final String NOBLE_LOCAL_CACHE = "noble_local_cache";

    @NotNull
    private ArrayList<MedalBean> mMedalBeanList = new ArrayList<>();

    @NotNull
    private ArrayList<NobleBeanConfig> mNobleBeanConfigList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initMedalList$lambda$0(OutPutOtherModuleService outPutOtherModuleService, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MEDAL_LOCAL_CACHE, BaseApplication.Companion.getGSON().s(apiResponse.getData()), (String) null, 4, (Object) null);
        Object data = apiResponse.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.MedalBean>");
        outPutOtherModuleService.mMedalBeanList = (ArrayList) data;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initMedalList$lambda$1(OutPutOtherModuleService outPutOtherModuleService, Throwable th) {
        ArrayList<MedalBean> arrayList;
        Intrinsics.checkNotNullParameter(th, "it");
        try {
            Object k = BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MEDAL_LOCAL_CACHE, "", (String) null, 4, (Object) null), new TypeToken<List<? extends MedalBean>>() { // from class: com.qiahao.nextvideo.data.service.OutPutOtherModuleService$initMedalList$2$typeToken$1
            }.getType());
            Intrinsics.checkNotNull(k, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.MedalBean>");
            arrayList = (ArrayList) k;
        } catch (Exception unused) {
            arrayList = new ArrayList<>();
        }
        outPutOtherModuleService.mMedalBeanList = arrayList;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNobleBeanConfigList$lambda$2(OutPutOtherModuleService outPutOtherModuleService, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Object data = apiResponse.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.NobleBeanConfig>");
        ArrayList<NobleBeanConfig> arrayList = (ArrayList) data;
        outPutOtherModuleService.mNobleBeanConfigList = arrayList;
        outPutOtherModuleService.saveNobleConfigListCache(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNobleBeanConfigList$lambda$3(OutPutOtherModuleService outPutOtherModuleService, Throwable th) {
        ArrayList<NobleBeanConfig> arrayList;
        Intrinsics.checkNotNullParameter(th, "it");
        try {
            Object k = BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, NOBLE_LOCAL_CACHE, "", (String) null, 4, (Object) null), new TypeToken<List<? extends NobleBeanConfig>>() { // from class: com.qiahao.nextvideo.data.service.OutPutOtherModuleService$initNobleBeanConfigList$2$typeToken$1
            }.getType());
            Intrinsics.checkNotNull(k, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.NobleBeanConfig>");
            arrayList = (ArrayList) k;
        } catch (Exception unused) {
            arrayList = new ArrayList<>();
        }
        outPutOtherModuleService.mNobleBeanConfigList = arrayList;
        return Unit.INSTANCE;
    }

    public int getLevelBg(long level, boolean isCharm, boolean isWealth, boolean isActivity) {
        return UserService.INSTANCE.getLevelBg(level, isCharm, isWealth, isActivity);
    }

    @NotNull
    public final ArrayList<MedalBean> getMMedalBeanList() {
        return this.mMedalBeanList;
    }

    @NotNull
    public final ArrayList<NobleBeanConfig> getMNobleBeanConfigList() {
        return this.mNobleBeanConfigList;
    }

    public int getNobleColor(int nobleLevel, int defaultColor) {
        if (defaultColor == 0) {
            return UserService.INSTANCE.getNobleColor(nobleLevel, Color.parseColor("#ffffff"));
        }
        return UserService.INSTANCE.getNobleColor(nobleLevel, defaultColor);
    }

    public int getNobleDrawableRes(int nobleLevel) {
        return UserService.INSTANCE.getNobleDrawableRes(nobleLevel);
    }

    public boolean getUserHasOnMic() {
        String str;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        return meetingRoomManager.checkUserOnMic(str);
    }

    public final void initMedalList() {
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getMedalList(), new Function1() { // from class: com.qiahao.nextvideo.data.service.h
            public final Object invoke(Object obj) {
                Unit initMedalList$lambda$0;
                initMedalList$lambda$0 = OutPutOtherModuleService.initMedalList$lambda$0(OutPutOtherModuleService.this, (ApiResponse) obj);
                return initMedalList$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.i
            public final Object invoke(Object obj) {
                Unit initMedalList$lambda$1;
                initMedalList$lambda$1 = OutPutOtherModuleService.initMedalList$lambda$1(OutPutOtherModuleService.this, (Throwable) obj);
                return initMedalList$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void initNobleBeanConfigList() {
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getNobleConfig(), new Function1() { // from class: com.qiahao.nextvideo.data.service.j
            public final Object invoke(Object obj) {
                Unit initNobleBeanConfigList$lambda$2;
                initNobleBeanConfigList$lambda$2 = OutPutOtherModuleService.initNobleBeanConfigList$lambda$2(OutPutOtherModuleService.this, (ApiResponse) obj);
                return initNobleBeanConfigList$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.k
            public final Object invoke(Object obj) {
                Unit initNobleBeanConfigList$lambda$3;
                initNobleBeanConfigList$lambda$3 = OutPutOtherModuleService.initNobleBeanConfigList$lambda$3(OutPutOtherModuleService.this, (Throwable) obj);
                return initNobleBeanConfigList$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final void saveNobleConfigListCache(@NotNull ArrayList<NobleBeanConfig> nobleBeanConfigList) {
        Intrinsics.checkNotNullParameter(nobleBeanConfigList, "nobleBeanConfigList");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, NOBLE_LOCAL_CACHE, BaseApplication.Companion.getGSON().s(nobleBeanConfigList), (String) null, 4, (Object) null);
    }

    public final void setMMedalBeanList(@NotNull ArrayList<MedalBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mMedalBeanList = arrayList;
    }

    public final void setMNobleBeanConfigList(@NotNull ArrayList<NobleBeanConfig> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mNobleBeanConfigList = arrayList;
    }

    @NotNull
    /* renamed from: getMedalList, reason: merged with bridge method [inline-methods] */
    public ArrayList<MedalBean> m٠getMedalList() {
        return this.mMedalBeanList;
    }
}

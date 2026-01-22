package com.qiahao.nextvideo.data.service;

import android.util.Log;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.BlockListBean;
import com.qiahao.nextvideo.data.model.CountriesResponse;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.GiftShortcutData;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.HasMyGroupListBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.model.HotGroupListBean;
import com.qiahao.nextvideo.data.model.JoinGroupBean;
import com.qiahao.nextvideo.data.model.SearchGroupListBean;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 _2\u00020\u0001:\u0001_B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\fJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\fJ\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0010J)\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00190\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001e0\u00190\u0018¢\u0006\u0004\b#\u0010$J1\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00190\u0018¢\u0006\u0004\b(\u0010$J!\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00190\u00182\u0006\u0010)\u001a\u00020\u0005¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00190\u0018¢\u0006\u0004\b.\u0010$J\u001f\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001e0\u00190\u0018¢\u0006\u0004\b0\u0010$J!\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00190\u00182\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b1\u0010,J!\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00190\u00182\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b2\u0010,J!\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00190\u00182\u0006\u00103\u001a\u00020\u0005¢\u0006\u0004\b5\u0010,J+\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00190\u00182\u0006\u0010\t\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b7\u00108J9\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u00182\u0006\u0010\t\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:¢\u0006\u0004\b=\u0010>J)\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u00182\u0006\u0010\t\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005¢\u0006\u0004\b?\u00108J)\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u00182\u0006\u0010\t\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005¢\u0006\u0004\b@\u00108J=\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u00182\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00152\b\b\u0002\u0010B\u001a\u00020:2\b\b\u0002\u0010C\u001a\u00020:¢\u0006\u0004\bD\u0010EJ#\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00190\u00182\b\b\u0002\u0010F\u001a\u00020\u0015¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00190\u0018¢\u0006\u0004\bJ\u0010$J)\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u00190\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\bL\u0010\u001cJ\u001f\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00190\u0018¢\u0006\u0004\bM\u0010$J/\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u00190\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\bN\u0010\u001cJ\r\u0010O\u001a\u00020\n¢\u0006\u0004\bO\u0010\u0003J1\u0010R\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020Q0\u0004j\b\u0012\u0004\u0012\u00020Q`\u00060\u00190\u00182\u0006\u0010P\u001a\u00020\u0015¢\u0006\u0004\bR\u0010IJ)\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00190\u00182\u0006\u0010T\u001a\u00020S2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\bV\u0010WR*\u0010Y\u001a\u00020:2\u0006\u0010X\u001a\u00020:8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006`"}, d2 = {"Lcom/qiahao/nextvideo/data/service/GroupService;", "", "<init>", "()V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBlockRoomIdList", "()Ljava/util/ArrayList;", "groupId", "", "setBlockRoomIdList", "(Ljava/lang/String;)V", "H5Url", "setLevelH5", "getLevelH5", "()Ljava/lang/String;", "setGroupSupportH5", "getGroupSupportH5", "setLuckWheelH5", "getLuckWheelH5", "", "pageIndex", "pageSize", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "Lcom/qiahao/nextvideo/data/model/HotGroupListBean;", "getPopularViewList", "(II)Lio/reactivex/rxjava3/core/i0;", "lastId", "", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "getLatestGroupList", "(III)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/model/common/Country;", "getTop7Country", "()Lio/reactivex/rxjava3/core/i0;", "countryShortName", "getCountryGroup", "(Ljava/lang/String;II)Lio/reactivex/rxjava3/core/i0;", "getNewRecommendGroupList", "userExternalId", "Lcom/qiahao/nextvideo/data/model/HasMyGroupListBean;", "getPublicGroup", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/nextvideo/data/model/CreateGroupBean;", "createGroup", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "getGroupTopBanner", "joinGroup", "leaveGroup", Constants.KEY_HTTP_CODE, "Lcom/qiahao/nextvideo/data/model/SearchGroupListBean;", "searchGroup", "Lcom/qiahao/nextvideo/data/model/BlockListBean;", "getRoomBlockMemberList", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", SupportGiftRankActivity.EXTERNAL_ID, "", "removeHistory", "blackImei", "groupBlockListAddUser", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/rxjava3/core/i0;", "removeGroupBlockById", "groupKick", "type", "isBlock", "isPK", "reportGroup", "(Ljava/lang/String;IZZ)Lio/reactivex/rxjava3/core/i0;", "filterArea", "Lcom/qiahao/nextvideo/data/model/CountriesResponse;", "fetchCountries", "(I)Lio/reactivex/rxjava3/core/i0;", "getOwnGroup", "Lcom/qiahao/nextvideo/data/model/JoinGroupBean;", "getMyJoinedGroup", "getMyRecentGroup", "getMyPermanentGroup", "logout", "column", "Lcom/qiahao/base_common/model/GiftData;", "giftListOfType", "", "giftId", "Lcom/qiahao/nextvideo/data/model/GiftShortcutData;", "giftShortcut", "(JLjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "value", "hasSaveLocalUnread", "Z", "getHasSaveLocalUnread", "()Z", "setHasSaveLocalUnread", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String HAS_SAVE_GROUP_UNREAD = "group_unread_save";
    public static final int IM_STATUS_ON_LINE = 2;

    @NotNull
    private static final String TAG = "GroupService";

    @NotNull
    private static final Lazy<GroupService> instance$delegate;

    @NotNull
    private static final Lazy<je.b> mGroupEventProcessorObservable$delegate;
    private boolean hasSaveLocalUnread;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/service/GroupService$Companion;", "", "<init>", "()V", "", "online", "", "userIsOnline", "(I)Z", "", "birthday", "", "changeAge", "(J)Ljava/lang/String;", "Lcom/qiahao/nextvideo/data/service/GroupService;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/qiahao/nextvideo/data/service/GroupService;", "instance", "Lje/b;", "Lcom/qiahao/nextvideo/room/manager/GroupEvent;", "mGroupEventProcessorObservable$delegate", "getMGroupEventProcessorObservable", "()Lje/b;", "mGroupEventProcessorObservable", "TAG", "Ljava/lang/String;", "IM_STATUS_ON_LINE", "I", "HAS_SAVE_GROUP_UNREAD", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String changeAge(long birthday) {
            if (birthday <= 0) {
                return "";
            }
            return String.valueOf((DateTimeUtilityKt.getConstantTimeSecs() - birthday) / 31536000);
        }

        @NotNull
        public final GroupService getInstance() {
            return (GroupService) GroupService.instance$delegate.getValue();
        }

        @NotNull
        public final je.b getMGroupEventProcessorObservable() {
            Object value = GroupService.mGroupEventProcessorObservable$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (je.b) value;
        }

        public final boolean userIsOnline(int online) {
            return online == 2;
        }

        private Companion() {
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        instance$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.qiahao.nextvideo.data.service.f
            public final Object invoke() {
                GroupService instance_delegate$lambda$1;
                instance_delegate$lambda$1 = GroupService.instance_delegate$lambda$1();
                return instance_delegate$lambda$1;
            }
        });
        mGroupEventProcessorObservable$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.qiahao.nextvideo.data.service.g
            public final Object invoke() {
                je.b mGroupEventProcessorObservable_delegate$lambda$3;
                mGroupEventProcessorObservable_delegate$lambda$3 = GroupService.mGroupEventProcessorObservable_delegate$lambda$3();
                return mGroupEventProcessorObservable_delegate$lambda$3;
            }
        });
    }

    private GroupService() {
    }

    public static /* synthetic */ i0 fetchCountries$default(GroupService groupService, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return groupService.fetchCountries(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupService instance_delegate$lambda$1() {
        return new GroupService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final je.b mGroupEventProcessorObservable_delegate$lambda$3() {
        je.b u = je.b.u();
        u.q(md.b.c()).f(md.b.c());
        return u;
    }

    public static /* synthetic */ i0 reportGroup$default(GroupService groupService, String str, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        return groupService.reportGroup(str, i, z, z2);
    }

    @NotNull
    public final i0<ApiResponse<CreateGroupBean>> createGroup() {
        return AppServer.INSTANCE.getApis().createGroup();
    }

    @NotNull
    public final i0<ApiResponse<CountriesResponse>> fetchCountries(int filterArea) {
        return AppServer.INSTANCE.getApis().countries(filterArea);
    }

    @Nullable
    public final ArrayList<String> getBlockRoomIdList() {
        String str;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null && user.getExternalId() != null) {
            MMKVToLocalCache.Companion companion2 = MMKVToLocalCache.INSTANCE;
            User user2 = companion.getShared().getUser();
            if (user2 == null || (str = user2.getExternalId()) == null) {
                str = "";
            }
            return companion2.getBlockRoomIdList(str);
        }
        return null;
    }

    @NotNull
    public final i0<ApiResponse<HotGroupListBean>> getCountryGroup(@NotNull String countryShortName, int pageIndex, int pageSize) {
        Intrinsics.checkNotNullParameter(countryShortName, "countryShortName");
        return AppServer.INSTANCE.getApis().getCountryGroup(countryShortName, pageIndex, pageSize);
    }

    @NotNull
    public final String getGroupSupportH5() {
        return (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "group_support_h5", "", (String) null, 4, (Object) null);
    }

    @NotNull
    public final i0<ApiResponse<List<GroupTopBannerBean>>> getGroupTopBanner() {
        return AppServer.INSTANCE.getApis().groupBanner();
    }

    public final boolean getHasSaveLocalUnread() {
        if (this.hasSaveLocalUnread) {
            Log.d(TAG, "hasSaveLocalUnread: 返回true!!!");
            return true;
        }
        Log.d(TAG, "hasSaveLocalUnread: 获取数据");
        boolean booleanValue = ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, HAS_SAVE_GROUP_UNREAD, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        this.hasSaveLocalUnread = booleanValue;
        return booleanValue;
    }

    @NotNull
    public final i0<ApiResponse<List<HotGroupBean>>> getLatestGroupList(int pageIndex, int pageSize, int lastId) {
        return AppServer.INSTANCE.getApis().getLatestGroup(pageIndex, pageSize, lastId);
    }

    @NotNull
    public final String getLevelH5() {
        return (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "H5_url", "", (String) null, 4, (Object) null);
    }

    @NotNull
    public final String getLuckWheelH5() {
        return (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "group_luck_wheel_h5", "", (String) null, 4, (Object) null);
    }

    @NotNull
    public final i0<ApiResponse<JoinGroupBean>> getMyJoinedGroup(int pageIndex, int pageSize) {
        return AppServer.INSTANCE.getApis().getMyJoinedGroup(pageIndex, pageSize);
    }

    @NotNull
    public final i0<ApiResponse<List<HotGroupBean>>> getMyPermanentGroup(int pageIndex, int pageSize) {
        return AppServer.INSTANCE.getApis().getMyPermanentGroup(pageIndex, pageSize);
    }

    @NotNull
    public final i0<ApiResponse<List<HotGroupBean>>> getMyRecentGroup() {
        return AppServer.INSTANCE.getApis().getMyRecentGroup();
    }

    @NotNull
    public final i0<ApiResponse<List<HotGroupBean>>> getNewRecommendGroupList() {
        return AppServer.INSTANCE.getApis().getNewRecommendGroup();
    }

    @NotNull
    public final i0<ApiResponse<List<HotGroupBean>>> getOwnGroup() {
        return AppServer.INSTANCE.getApis().getOwnGroup();
    }

    @NotNull
    public final i0<ApiResponse<HotGroupListBean>> getPopularViewList(int pageIndex, int pageSize) {
        return AppServer.INSTANCE.getApis().getPopularGroup(pageIndex, pageSize);
    }

    @NotNull
    public final i0<ApiResponse<HasMyGroupListBean>> getPublicGroup(@NotNull String userExternalId) {
        Intrinsics.checkNotNullParameter(userExternalId, "userExternalId");
        return AppServer.INSTANCE.getApis().getPublicGroup(userExternalId);
    }

    @NotNull
    public final i0<ApiResponse<BlockListBean>> getRoomBlockMemberList(@NotNull String groupId, @Nullable String code) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return AppServer.INSTANCE.getApis().getGroupBlockList(groupId, code);
    }

    @NotNull
    public final i0<ApiResponse<List<Country>>> getTop7Country() {
        return AppServer.INSTANCE.getApis().getTop7Country();
    }

    @NotNull
    public final i0<ApiResponse<ArrayList<GiftData>>> giftListOfType(int column) {
        return AppServer.INSTANCE.getApis().giftListOfType(column);
    }

    @NotNull
    public final i0<ApiResponse<GiftShortcutData>> giftShortcut(long giftId, @NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return AppServer.INSTANCE.getApis().giftShortcut(giftId, groupId);
    }

    @NotNull
    public final i0<ApiResponse<String>> groupBlockListAddUser(@NotNull String groupId, @NotNull String externalId, boolean removeHistory, boolean blackImei) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        return AppServer.INSTANCE.getApis().groupBlockListAddUser(groupId, externalId, removeHistory, blackImei);
    }

    @NotNull
    public final i0<ApiResponse<String>> groupKick(@NotNull String groupId, @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        return AppServer.INSTANCE.getApis().groupKick(groupId, externalId);
    }

    @NotNull
    public final i0<ApiResponse<Integer>> joinGroup(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return ServerApi.DefaultImpls.joinGroup$default(AppServer.INSTANCE.getApis(), groupId, 0, 2, null);
    }

    @NotNull
    public final i0<ApiResponse<Object>> leaveGroup(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return AppServer.INSTANCE.getApis().leaveGroup(groupId);
    }

    public final void logout() {
    }

    @NotNull
    public final i0<ApiResponse<String>> removeGroupBlockById(@NotNull String groupId, @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        return AppServer.INSTANCE.getApis().removeGroupBlockById(groupId, externalId);
    }

    @NotNull
    public final i0<ApiResponse<String>> reportGroup(@NotNull String groupId, int type, boolean isBlock, boolean isPK) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        return AppServer.INSTANCE.getApis().reportGroup(groupId, type, "", "", isBlock, isPK);
    }

    @NotNull
    public final i0<ApiResponse<SearchGroupListBean>> searchGroup(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        return AppServer.INSTANCE.getApis().searchGroup(code);
    }

    public final void setBlockRoomIdList(@NotNull String groupId) {
        String externalId;
        String externalId2;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        ArrayList<String> blockRoomIdList = getBlockRoomIdList();
        String str = "";
        if (blockRoomIdList == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(groupId);
            MMKVToLocalCache.Companion companion = MMKVToLocalCache.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (externalId2 = user.getExternalId()) != null) {
                str = externalId2;
            }
            companion.setBlockRoom(str, arrayList);
            return;
        }
        blockRoomIdList.add(groupId);
        MMKVToLocalCache.Companion companion2 = MMKVToLocalCache.INSTANCE;
        User user2 = UserStore.INSTANCE.getShared().getUser();
        if (user2 != null && (externalId = user2.getExternalId()) != null) {
            str = externalId;
        }
        companion2.setBlockRoom(str, blockRoomIdList);
    }

    public final void setGroupSupportH5(@NotNull String H5Url) {
        Intrinsics.checkNotNullParameter(H5Url, "H5Url");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "group_support_h5", H5Url, (String) null, 4, (Object) null);
    }

    public final void setHasSaveLocalUnread(boolean z) {
        Log.d(TAG, "hasSaveLocalUnread: 设置值" + z);
        this.hasSaveLocalUnread = z;
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, HAS_SAVE_GROUP_UNREAD, Boolean.TRUE, (String) null, 4, (Object) null);
    }

    public final void setLevelH5(@NotNull String H5Url) {
        Intrinsics.checkNotNullParameter(H5Url, "H5Url");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "H5_url", H5Url, (String) null, 4, (Object) null);
    }

    public final void setLuckWheelH5(@NotNull String H5Url) {
        Intrinsics.checkNotNullParameter(H5Url, "H5Url");
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "group_luck_wheel_h5", H5Url, (String) null, 4, (Object) null);
    }
}

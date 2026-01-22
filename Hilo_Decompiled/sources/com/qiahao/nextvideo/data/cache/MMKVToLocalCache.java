package com.qiahao.nextvideo.data.cache;

import android.util.Log;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.nextvideo.data.model.AllRankTop3Bean;
import com.qiahao.nextvideo.data.model.CelebrityOrCharmBean;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.model.CpBean;
import com.qiahao.nextvideo.data.model.CpTop3Bean;
import com.qiahao.nextvideo.data.model.GroupPowerTitleDetail;
import com.qiahao.nextvideo.data.model.GroupPowerWeekBean;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.model.HotGroupListBean;
import com.qiahao.nextvideo.data.model.MultiHotGroupBean;
import com.qiahao.nextvideo.data.model.MyCpBean;
import com.qiahao.nextvideo.data.model.MySupportAllBean;
import com.qiahao.nextvideo.data.model.OpenScreenBean;
import com.qiahao.nextvideo.data.model.RankGroupBean;
import com.qiahao.nextvideo.data.model.ScrollBean;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.data.model.WeekPowerTop3Bean;
import com.qiahao.nextvideo.ui.conversation.ConversationCellUIModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/data/cache/MMKVToLocalCache;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MMKVToLocalCache {

    @NotNull
    public static final String BLOCK_ROOM = "block_room";

    @NotNull
    public static final String CHARM_DAY_COMMON_RANK_CACHE = "charm_day_rank_cache";

    @NotNull
    public static final String CHARM_MONTH_COMMON_RANK_CACHE = "charm_month_rank_cache";

    @NotNull
    public static final String CHARM_WEEK_COMMON_RANK_CACHE = "charm_week_rank_cache";

    @NotNull
    public static final String CHAT_CONTACTS_CACHE = "chat_contacts_cache";

    @NotNull
    public static final String CHAT_GROUP_CACHE = "chat_group_cache";

    @NotNull
    public static final String CHAT_PRIVATE_CACHE = "chat_private_cache";

    @NotNull
    public static final String CP_ALL_COMMON_RANK_CACHE = "cp_all_rank_cache";

    @NotNull
    public static final String CP_DAY_COMMON_RANK_CACHE = "cp_day_rank_cache";

    @NotNull
    public static final String CP_MONTH_COMMON_RANK_CACHE = "cp_month_rank_cache";

    @NotNull
    public static final String CP_WEEK_COMMON_RANK_CACHE = "cp_week_rank_cache";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DAILY_OPEN_APP_TIMES = "daily_open_app_times";

    @NotNull
    public static final String DISCOVER_BANNER_CACHE = "discover_banner_cache";

    @NotNull
    public static final String DISCOVER_CP_TOP = "discover_cp_top";

    @NotNull
    public static final String DISCOVER_GROUP_CACHE = "discover_group_cache";

    @NotNull
    public static final String DISCOVER_TOP7_COUNTRY_CACHE = "discover_top7_country_cache";

    @NotNull
    public static final String FAMOUS_DAY_COMMON_RANK_CACHE = "famous_day_rank_cache";

    @NotNull
    public static final String FAMOUS_MONTH_COMMON_RANK_CACHE = "famous_month_rank_cache";

    @NotNull
    public static final String FAMOUS_WEEK_COMMON_RANK_CACHE = "famous_week_rank_cache";

    @NotNull
    public static final String GROUP_LATEST_POPULAR_CACHE = "group_latest_popular_cache";

    @NotNull
    public static final String GROUP_POPULAR_CACHE = "group_popular_cache2";

    @NotNull
    public static final String JOIN_GROUP_CACHE = "join_group_cache1";

    @NotNull
    public static final String LUCKY_BOX_RANK_BANNER_CACHE = "lucky_box_rank_banner_cache";

    @NotNull
    public static final String MY_CP_RANK_CACHE = "my_cp_rank_cache";

    @NotNull
    public static final String MY_GROUP_CACHE = "my_group_cache1";

    @NotNull
    public static final String OPEN_APP_TIMES = "open_app_times";

    @NotNull
    public static final String OPEN_SOURCE_DATA = "new_open_source_data";

    @NotNull
    public static final String POPULAR_BANNER_CACHE = "popular_banner_cache";

    @NotNull
    public static final String POPULAR_POWER_FLIPPER_CACHE = "popular_power_flipper_cache";

    @NotNull
    public static final String POPULAR_RANK_FLIPPER_CACHE = "popular_rank_flipper_cache";

    @NotNull
    public static final String POWER_DETAIL_CACHE = "power_detail_cache";

    @NotNull
    public static final String POWER_LAST_WEEK_RANK_CACHE = "power_last_week_rank_cache";

    @NotNull
    public static final String POWER_THIS_WEEK_RANK_CACHE = "power_this_week_rank_cache";

    @NotNull
    public static final String RECENTLY_GROUP_CACHE = "recently_group_cache";

    @NotNull
    public static final String ROOM_DAY_COMMON_RANK_CACHE = "room_day_rank_cache";

    @NotNull
    public static final String ROOM_MONTH_COMMON_RANK_CACHE = "room_month_rank_cache";

    @NotNull
    public static final String ROOM_WEEK_COMMON_RANK_CACHE = "room_week_rank_cache";

    @NotNull
    public static final String SAY_HI_CACHE = "say_hi_cache";

    @NotNull
    public static final String SUPPORT_GIFT_RANK_CHCHE = "support_gift_rank_cache";

    @NotNull
    private static final String TAG = "MMKVToLocalCache";

    @Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201J\u0010\u00102\u001a\u0004\u0018\u0001012\u0006\u0010/\u001a\u00020\u0005J&\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u00052\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000506j\b\u0012\u0004\u0012\u00020\u0005`7J\"\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u000106j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`72\u0006\u00104\u001a\u00020\u0005J\u0014\u00109\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020;0:J\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:J\u000e\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u0004\u0018\u00010?J\u000e\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020CJ\b\u0010D\u001a\u0004\u0018\u00010CJ\u0014\u0010E\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020F0:J\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010:J\u001e\u0010H\u001a\u00020.2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020;06j\b\u0012\u0004\u0012\u00020;`7J\u001a\u0010I\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u000106j\n\u0012\u0004\u0012\u00020;\u0018\u0001`7J\u001c\u0010J\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020K0:2\u0006\u0010L\u001a\u00020\u0005J\u0016\u0010M\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010:2\u0006\u0010L\u001a\u00020\u0005J\u001c\u0010N\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020O0:2\u0006\u0010L\u001a\u00020\u0005J\u0016\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010:2\u0006\u0010L\u001a\u00020\u0005J\u001c\u0010Q\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020O0:2\u0006\u0010L\u001a\u00020\u0005J\u0016\u0010R\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010:2\u0006\u0010L\u001a\u00020\u0005J\u001c\u0010S\u001a\u00020.2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0:2\u0006\u0010L\u001a\u00020VJ\u0016\u0010W\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010:2\u0006\u0010L\u001a\u00020VJ\u000e\u0010X\u001a\u00020.2\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u0004\u0018\u00010ZJ\u0014\u0010\\\u001a\u00020.2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020^0:J\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010:J\u0014\u0010`\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020a0:J\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020a\u0018\u00010:J\u0014\u0010c\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020d0:J\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010:J\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010:J\u0014\u0010g\u001a\u00020.2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020d0:J\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010:J\u0014\u0010j\u001a\u00020.2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020d0:J\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010:J\u0014\u0010l\u001a\u00020.2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020d0:J\u0014\u0010m\u001a\u00020.2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020p0oJ\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010oJ\u0014\u0010r\u001a\u00020.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020s0:J\u000e\u0010t\u001a\n\u0012\u0004\u0012\u00020s\u0018\u00010:J\u000e\u0010u\u001a\u00020.2\u0006\u0010v\u001a\u00020wJ\b\u0010x\u001a\u0004\u0018\u00010wJ\u000e\u0010y\u001a\u00020.2\u0006\u0010v\u001a\u00020zJ\b\u0010{\u001a\u0004\u0018\u00010zJ\u001e\u0010|\u001a\u00020.2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020}06j\b\u0012\u0004\u0012\u00020}`7J\u001a\u0010~\u001a\u0016\u0012\u0004\u0012\u00020}\u0018\u000106j\n\u0012\u0004\u0012\u00020}\u0018\u0001`7J \u0010\u007f\u001a\u00020.2\u0018\u00105\u001a\u0014\u0012\u0005\u0012\u00030\u0080\u000106j\t\u0012\u0005\u0012\u00030\u0080\u0001`7J\u001d\u0010\u0081\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u000106j\u000b\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u0001`7J)\u0010\u0082\u0001\u001a\u00020.2\u0018\u00105\u001a\u0014\u0012\u0005\u0012\u00030\u0083\u000106j\t\u0012\u0005\u0012\u00030\u0083\u0001`72\u0006\u0010L\u001a\u00020\u0005J%\u0010\u0084\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u000106j\u000b\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u0001`72\u0006\u0010L\u001a\u00020\u0005J!\u0010\u0085\u0001\u001a\u00020.2\u0018\u00105\u001a\u0014\u0012\u0005\u0012\u00030\u0086\u000106j\t\u0012\u0005\u0012\u00030\u0086\u0001`7J\u001d\u0010\u0087\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u000106j\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u0001`7J\u0010\u0010\u0088\u0001\u001a\u00020.2\u0007\u0010\u0089\u0001\u001a\u00020VJ\u0007\u0010\u008a\u0001\u001a\u00020VR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/qiahao/nextvideo/data/cache/MMKVToLocalCache$Companion;", "", "<init>", "()V", "TAG", "", "OPEN_SOURCE_DATA", "OPEN_APP_TIMES", "DAILY_OPEN_APP_TIMES", "SAY_HI_CACHE", "GROUP_POPULAR_CACHE", "GROUP_LATEST_POPULAR_CACHE", "CHAT_GROUP_CACHE", "CHAT_PRIVATE_CACHE", "CHAT_CONTACTS_CACHE", "MY_GROUP_CACHE", "JOIN_GROUP_CACHE", "RECENTLY_GROUP_CACHE", "POWER_THIS_WEEK_RANK_CACHE", "POWER_LAST_WEEK_RANK_CACHE", "POWER_DETAIL_CACHE", "CHARM_DAY_COMMON_RANK_CACHE", "CHARM_WEEK_COMMON_RANK_CACHE", "CHARM_MONTH_COMMON_RANK_CACHE", "FAMOUS_DAY_COMMON_RANK_CACHE", "FAMOUS_WEEK_COMMON_RANK_CACHE", "FAMOUS_MONTH_COMMON_RANK_CACHE", "ROOM_DAY_COMMON_RANK_CACHE", "ROOM_WEEK_COMMON_RANK_CACHE", "ROOM_MONTH_COMMON_RANK_CACHE", "DISCOVER_TOP7_COUNTRY_CACHE", "DISCOVER_BANNER_CACHE", "POPULAR_BANNER_CACHE", "POPULAR_POWER_FLIPPER_CACHE", "POPULAR_RANK_FLIPPER_CACHE", "DISCOVER_GROUP_CACHE", "DISCOVER_CP_TOP", "SUPPORT_GIFT_RANK_CHCHE", "MY_CP_RANK_CACHE", "CP_DAY_COMMON_RANK_CACHE", "CP_WEEK_COMMON_RANK_CACHE", "CP_MONTH_COMMON_RANK_CACHE", "CP_ALL_COMMON_RANK_CACHE", "BLOCK_ROOM", "LUCKY_BOX_RANK_BANNER_CACHE", "saveDiscoverGroupCache", "", "countryName", "hotgroupBean", "Lcom/qiahao/nextvideo/data/model/HotGroupListBean;", "getDiscoverGroupCache", "setBlockRoom", "userExtraId", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBlockRoomIdList", "savePopularBannerCache", "", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "getPopularBannerCache", "savePopularRankFlipperCache", "allRankTop3Bean", "Lcom/qiahao/nextvideo/data/model/AllRankTop3Bean;", "getPopularRankFlipperCache", "savePopularPowerFlipperCache", "weekPowerTop3Bean", "Lcom/qiahao/nextvideo/data/model/WeekPowerTop3Bean;", "getPopularPowerFlipperCache", "saveDiscoverTop7CountryCache", "Lcom/qiahao/base_common/model/common/Country;", "getDiscoverTop7CountryCache", "saveDiscoverBannerCache", "getDiscoverBannerCache", "saveRoomRankCache", "Lcom/qiahao/nextvideo/data/model/RankGroupBean;", "type", "getRoomRankCache", "saveCharmRankCache", "Lcom/qiahao/nextvideo/data/model/CelebrityOrCharmBean;", "getCharmRankCache", "saveFamousRankCache", "getFamousRankCache", "savePowerFromTypeWeekRankCache", "groupPowerWeekBeanList", "Lcom/qiahao/nextvideo/data/model/GroupPowerWeekBean;", "", "getPowerFromWeekRankCache", "savePowerDetailCache", "groupPowerTitleDetail", "Lcom/qiahao/nextvideo/data/model/GroupPowerTitleDetail;", "getPowerDetailCache", "saveSayHiCache", "onlineCellUIModel", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "getSayHiCache", "saveNewGroupPopularCache", "Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "getNewChatPopularCache", "saveLatestGroupPopularCache", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "getLatestGroupCache", "getMyGroupCache", "saveMyGroupCache", "hotGroupBean", "getJoinGroupCache", "saveJoinGroupCache", "getRecentlyGroupCache", "saveRecentlyGroupCache", "saveChatPrivateCache", "conversationCellUIModels", "", "Lcom/qiahao/nextvideo/ui/conversation/ConversationCellUIModel;", "getChatPrivateCache", "saveChatContactsCache", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "getChatContactsCache", "saveSupportMyRank", "it", "Lcom/qiahao/nextvideo/data/model/MySupportAllBean;", "getSupportMyRank", "saveCpTop3Cache", "Lcom/qiahao/nextvideo/data/model/CpTop3Bean;", "getCpTop3Cache", "saveLuckyBoxRankCache", "Lcom/qiahao/nextvideo/data/model/ScrollBean;", "getLuckyBoxRankCache", "saveCpMyRankCache", "Lcom/qiahao/nextvideo/data/model/MyCpBean;", "getCpMyRankCache", "saveCpRankCache", "Lcom/qiahao/nextvideo/data/model/CpBean;", "getCpRankCache", "saveOpenSourceData", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "getOpenSourceData", "saveCurrentOpenAppTimes", "times", "getCurrentOenAppTimes", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ArrayList<String> getBlockRoomIdList(@NotNull String userExtraId) {
            Intrinsics.checkNotNullParameter(userExtraId, "userExtraId");
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.BLOCK_ROOM + userExtraId, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<String>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getBlockRoomIdList$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<CelebrityOrCharmBean> getCharmRankCache(@NotNull String type) {
            String str;
            Intrinsics.checkNotNullParameter(type, "type");
            int hashCode = type.hashCode();
            String str2 = "";
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
                    if (hashCode == 104080000 && type.equals("month")) {
                        Log.d(MMKVToLocalCache.TAG, "getCharmRankCache: CHARM_MONTH_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHARM_MONTH_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                    }
                    str = "";
                } else {
                    if (type.equals("week")) {
                        Log.d(MMKVToLocalCache.TAG, "getCharmRankCache: CHARM_WEEK_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHARM_WEEK_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                    }
                    str = "";
                }
            } else {
                if (type.equals("day")) {
                    Log.d(MMKVToLocalCache.TAG, "getCharmRankCache: CHARM_DAY_COMMON_RANK_CACHE");
                    str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHARM_DAY_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                }
                str = "";
            }
            if (str != null) {
                str2 = str;
            }
            try {
                return (List) BaseApplication.Companion.getGSON().k(str2, new TypeToken<List<? extends CelebrityOrCharmBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getCharmRankCache$typeToken$1
                }.getType());
            } catch (Exception unused) {
                return null;
            }
        }

        @Nullable
        public final List<ContactsLikeEachItem> getChatContactsCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHAT_CONTACTS_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends ContactsLikeEachItem>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getChatContactsCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<ConversationCellUIModel> getChatPrivateCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHAT_PRIVATE_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<ConversationCellUIModel>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getChatPrivateCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final ArrayList<MyCpBean> getCpMyRankCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.MY_CP_RANK_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<MyCpBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getCpMyRankCache$typeToken$1
            }.getType());
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Nullable
        public final ArrayList<CpBean> getCpRankCache(@NotNull String type) {
            String str;
            Intrinsics.checkNotNullParameter(type, "type");
            String str2 = "";
            switch (type.hashCode()) {
                case 96673:
                    if (type.equals("all")) {
                        Log.d(MMKVToLocalCache.TAG, "getCpRankCache: CP_ALL_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_ALL_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                        break;
                    }
                    str = "";
                    break;
                case 99228:
                    if (type.equals("day")) {
                        Log.d(MMKVToLocalCache.TAG, "getCpRankCache: CP_DAY_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_DAY_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                        break;
                    }
                    str = "";
                    break;
                case 3645428:
                    if (type.equals("week")) {
                        Log.d(MMKVToLocalCache.TAG, "getCpRankCache: CP_WEEK_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_WEEK_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                        break;
                    }
                    str = "";
                    break;
                case 104080000:
                    if (type.equals("month")) {
                        Log.d(MMKVToLocalCache.TAG, "getCpRankCache: CP_MONTH_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_MONTH_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                        break;
                    }
                    str = "";
                    break;
                default:
                    str = "";
                    break;
            }
            if (str != null) {
                str2 = str;
            }
            try {
                return (ArrayList) BaseApplication.Companion.getGSON().k(str2, new TypeToken<ArrayList<CpBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getCpRankCache$typeToken$1
                }.getType());
            } catch (Exception unused) {
                return null;
            }
        }

        @Nullable
        public final CpTop3Bean getCpTop3Cache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.DISCOVER_CP_TOP, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (CpTop3Bean) BaseApplication.Companion.getGSON().j(str, CpTop3Bean.class);
        }

        public final int getCurrentOenAppTimes() {
            return ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.OPEN_APP_TIMES, 0, (String) null, 4, (Object) null)).intValue();
        }

        @Nullable
        public final ArrayList<GroupTopBannerBean> getDiscoverBannerCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.DISCOVER_BANNER_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<GroupTopBannerBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getDiscoverBannerCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final HotGroupListBean getDiscoverGroupCache(@NotNull String countryName) {
            Intrinsics.checkNotNullParameter(countryName, "countryName");
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, countryName, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (HotGroupListBean) BaseApplication.Companion.getGSON().j(str, HotGroupListBean.class);
        }

        @Nullable
        public final List<Country> getDiscoverTop7CountryCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.DISCOVER_TOP7_COUNTRY_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends Country>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getDiscoverTop7CountryCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<CelebrityOrCharmBean> getFamousRankCache(@NotNull String type) {
            String str;
            Intrinsics.checkNotNullParameter(type, "type");
            int hashCode = type.hashCode();
            String str2 = "";
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
                    if (hashCode == 104080000 && type.equals("month")) {
                        Log.d(MMKVToLocalCache.TAG, "getFamousRankCache: FAMOUS_MONTH_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.FAMOUS_MONTH_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                    }
                    str = "";
                } else {
                    if (type.equals("week")) {
                        Log.d(MMKVToLocalCache.TAG, "getFamousRankCache: FAMOUS_WEEK_COMMON_RANK_CACHE");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.FAMOUS_WEEK_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                    }
                    str = "";
                }
            } else {
                if (type.equals("day")) {
                    Log.d(MMKVToLocalCache.TAG, "getFamousRankCache: FAMOUS_DAY_COMMON_RANK_CACHE");
                    str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.FAMOUS_DAY_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                }
                str = "";
            }
            if (str != null) {
                str2 = str;
            }
            try {
                return (List) BaseApplication.Companion.getGSON().k(str2, new TypeToken<List<? extends CelebrityOrCharmBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getFamousRankCache$typeToken$1
                }.getType());
            } catch (Exception unused) {
                return null;
            }
        }

        @Nullable
        public final List<HotGroupBean> getJoinGroupCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.JOIN_GROUP_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends HotGroupBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getJoinGroupCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<HotGroupBean> getLatestGroupCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.GROUP_LATEST_POPULAR_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends HotGroupBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getLatestGroupCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final ArrayList<ScrollBean> getLuckyBoxRankCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.LUCKY_BOX_RANK_BANNER_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<ScrollBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getLuckyBoxRankCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<HotGroupBean> getMyGroupCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.MY_GROUP_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends HotGroupBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getMyGroupCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<MultiHotGroupBean> getNewChatPopularCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.GROUP_POPULAR_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends MultiHotGroupBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getNewChatPopularCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final ArrayList<OpenScreenBean> getOpenSourceData() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.OPEN_SOURCE_DATA, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<OpenScreenBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getOpenSourceData$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<GroupTopBannerBean> getPopularBannerCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POPULAR_BANNER_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends GroupTopBannerBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getPopularBannerCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final WeekPowerTop3Bean getPopularPowerFlipperCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POPULAR_POWER_FLIPPER_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (WeekPowerTop3Bean) BaseApplication.Companion.getGSON().j(str, WeekPowerTop3Bean.class);
        }

        @Nullable
        public final AllRankTop3Bean getPopularRankFlipperCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POPULAR_RANK_FLIPPER_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (AllRankTop3Bean) BaseApplication.Companion.getGSON().j(str, AllRankTop3Bean.class);
        }

        @Nullable
        public final GroupPowerTitleDetail getPowerDetailCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POWER_DETAIL_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (GroupPowerTitleDetail) BaseApplication.Companion.getGSON().j(str, GroupPowerTitleDetail.class);
        }

        @Nullable
        public final List<GroupPowerWeekBean> getPowerFromWeekRankCache(int type) {
            String str;
            if (type == 1) {
                str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POWER_THIS_WEEK_RANK_CACHE, "", (String) null, 4, (Object) null);
            } else {
                str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POWER_LAST_WEEK_RANK_CACHE, "", (String) null, 4, (Object) null);
            }
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends GroupPowerWeekBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getPowerFromWeekRankCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<HotGroupBean> getRecentlyGroupCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.RECENTLY_GROUP_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends HotGroupBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getRecentlyGroupCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final List<RankGroupBean> getRoomRankCache(@NotNull String type) {
            String str;
            Intrinsics.checkNotNullParameter(type, "type");
            int hashCode = type.hashCode();
            String str2 = "";
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
                    if (hashCode == 104080000 && type.equals("month")) {
                        Log.d(MMKVToLocalCache.TAG, "getRoomRankCache: CommonRankChildWrapper.MONTH");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.ROOM_MONTH_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                    }
                    str = "";
                } else {
                    if (type.equals("week")) {
                        Log.d(MMKVToLocalCache.TAG, "getRoomRankCache: CommonRankChildWrapper.WEEK");
                        str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.ROOM_WEEK_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                    }
                    str = "";
                }
            } else {
                if (type.equals("day")) {
                    Log.d(MMKVToLocalCache.TAG, "getRoomRankCache: CommonRankChildWrapper.DAY");
                    str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.ROOM_DAY_COMMON_RANK_CACHE, (Object) null, (String) null, 4, (Object) null);
                }
                str = "";
            }
            if (str != null) {
                str2 = str;
            }
            try {
                return (List) BaseApplication.Companion.getGSON().k(str2, new TypeToken<List<? extends RankGroupBean>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getRoomRankCache$typeToken$1
                }.getType());
            } catch (Exception unused) {
                return null;
            }
        }

        @Nullable
        public final List<VideoBaseData> getSayHiCache() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.SAY_HI_CACHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (List) BaseApplication.Companion.getGSON().k(str, new TypeToken<List<? extends VideoBaseData>>() { // from class: com.qiahao.nextvideo.data.cache.MMKVToLocalCache$Companion$getSayHiCache$typeToken$1
            }.getType());
        }

        @Nullable
        public final MySupportAllBean getSupportMyRank() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.SUPPORT_GIFT_RANK_CHCHE, "", (String) null, 4, (Object) null);
            if (str == null) {
                return null;
            }
            if (str.length() != 0) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return (MySupportAllBean) BaseApplication.Companion.getGSON().j(str, MySupportAllBean.class);
        }

        public final void saveCharmRankCache(@NotNull List<CelebrityOrCharmBean> list, @NotNull String type) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(type, "type");
            String s = BaseApplication.Companion.getGSON().s(list);
            int hashCode = type.hashCode();
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
                    if (hashCode == 104080000 && type.equals("month")) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHARM_MONTH_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        Log.d(MMKVToLocalCache.TAG, "saveCharmRankCache: MONTH CHARM_MONTH_COMMON_RANK_CACHE");
                        return;
                    }
                    return;
                }
                if (type.equals("week")) {
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHARM_WEEK_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                    Log.d(MMKVToLocalCache.TAG, "saveCharmRankCache: WEEK CHARM_WEEK_COMMON_RANK_CACHE");
                    return;
                }
                return;
            }
            if (type.equals("day")) {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHARM_DAY_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                Log.d(MMKVToLocalCache.TAG, "saveCharmRankCache: DAY CHARM_DAY_COMMON_RANK_CACHE");
            }
        }

        public final void saveChatContactsCache(@NotNull List<ContactsLikeEachItem> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHAT_CONTACTS_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveChatPrivateCache(@NotNull List<ConversationCellUIModel> conversationCellUIModels) {
            Intrinsics.checkNotNullParameter(conversationCellUIModels, "conversationCellUIModels");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CHAT_PRIVATE_CACHE, BaseApplication.Companion.getGSON().s(conversationCellUIModels), (String) null, 4, (Object) null);
        }

        public final void saveCpMyRankCache(@NotNull ArrayList<MyCpBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.MY_CP_RANK_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveCpRankCache(@NotNull ArrayList<CpBean> list, @NotNull String type) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(type, "type");
            String s = BaseApplication.Companion.getGSON().s(list);
            switch (type.hashCode()) {
                case 96673:
                    if (type.equals("all")) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_ALL_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        Log.d(MMKVToLocalCache.TAG, "saveCpRankCache: ALL CP_ALL_COMMON_RANK_CACHE");
                        return;
                    }
                    return;
                case 99228:
                    if (type.equals("day")) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_DAY_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        Log.d(MMKVToLocalCache.TAG, "saveCpRankCache: DAY CP_DAY_COMMON_RANK_CACHE");
                        return;
                    }
                    return;
                case 3645428:
                    if (type.equals("week")) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_WEEK_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        Log.d(MMKVToLocalCache.TAG, "saveCpRankCache: WEEK CP_WEEK_COMMON_RANK_CACHE");
                        return;
                    }
                    return;
                case 104080000:
                    if (type.equals("month")) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.CP_MONTH_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        Log.d(MMKVToLocalCache.TAG, "saveCpRankCache: MONTH CP_MONTH_COMMON_RANK_CACHE");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void saveCpTop3Cache(@NotNull CpTop3Bean it) {
            Intrinsics.checkNotNullParameter(it, "it");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.DISCOVER_CP_TOP, BaseApplication.Companion.getGSON().s(it), (String) null, 4, (Object) null);
        }

        public final void saveCurrentOpenAppTimes(int times) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.OPEN_APP_TIMES, Integer.valueOf(times), (String) null, 4, (Object) null);
        }

        public final void saveDiscoverBannerCache(@NotNull ArrayList<GroupTopBannerBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.DISCOVER_BANNER_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveDiscoverGroupCache(@NotNull String countryName, @NotNull HotGroupListBean hotgroupBean) {
            Intrinsics.checkNotNullParameter(countryName, "countryName");
            Intrinsics.checkNotNullParameter(hotgroupBean, "hotgroupBean");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, countryName, BaseApplication.Companion.getGSON().s(hotgroupBean), (String) null, 4, (Object) null);
        }

        public final void saveDiscoverTop7CountryCache(@NotNull List<Country> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.DISCOVER_TOP7_COUNTRY_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveFamousRankCache(@NotNull List<CelebrityOrCharmBean> list, @NotNull String type) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(type, "type");
            String s = BaseApplication.Companion.getGSON().s(list);
            int hashCode = type.hashCode();
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
                    if (hashCode == 104080000 && type.equals("month")) {
                        Log.d(MMKVToLocalCache.TAG, "saveFamousRankCache: FAMOUS_MONTH_COMMON_RANK_CACHE");
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.FAMOUS_MONTH_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        return;
                    }
                    return;
                }
                if (type.equals("week")) {
                    Log.d(MMKVToLocalCache.TAG, "saveFamousRankCache: FAMOUS_WEEK_COMMON_RANK_CACHE");
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.FAMOUS_WEEK_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                    return;
                }
                return;
            }
            if (type.equals("day")) {
                Log.d(MMKVToLocalCache.TAG, "saveFamousRankCache: FAMOUS_DAY_COMMON_RANK_CACHE");
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.FAMOUS_DAY_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
            }
        }

        public final void saveJoinGroupCache(@NotNull List<HotGroupBean> hotGroupBean) {
            Intrinsics.checkNotNullParameter(hotGroupBean, "hotGroupBean");
            Log.d(MMKVToLocalCache.TAG, "getCache: saveJoinGroupCache() " + hotGroupBean.size() + " ");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.JOIN_GROUP_CACHE, BaseApplication.Companion.getGSON().s(hotGroupBean), (String) null, 4, (Object) null);
        }

        public final void saveLatestGroupPopularCache(@NotNull List<HotGroupBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.GROUP_LATEST_POPULAR_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveLuckyBoxRankCache(@NotNull ArrayList<ScrollBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.LUCKY_BOX_RANK_BANNER_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveMyGroupCache(@NotNull List<HotGroupBean> hotGroupBean) {
            Intrinsics.checkNotNullParameter(hotGroupBean, "hotGroupBean");
            Log.d(MMKVToLocalCache.TAG, "getCache: saveMyGroupCache() " + hotGroupBean.size() + " ");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.MY_GROUP_CACHE, BaseApplication.Companion.getGSON().s(hotGroupBean), (String) null, 4, (Object) null);
        }

        public final void saveNewGroupPopularCache(@NotNull List<MultiHotGroupBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.GROUP_POPULAR_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void saveOpenSourceData(@NotNull ArrayList<OpenScreenBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.OPEN_SOURCE_DATA, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void savePopularBannerCache(@NotNull List<GroupTopBannerBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POPULAR_BANNER_CACHE, BaseApplication.Companion.getGSON().s(list), (String) null, 4, (Object) null);
        }

        public final void savePopularPowerFlipperCache(@NotNull WeekPowerTop3Bean weekPowerTop3Bean) {
            Intrinsics.checkNotNullParameter(weekPowerTop3Bean, "weekPowerTop3Bean");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POPULAR_POWER_FLIPPER_CACHE, BaseApplication.Companion.getGSON().s(weekPowerTop3Bean), (String) null, 4, (Object) null);
        }

        public final void savePopularRankFlipperCache(@NotNull AllRankTop3Bean allRankTop3Bean) {
            Intrinsics.checkNotNullParameter(allRankTop3Bean, "allRankTop3Bean");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POPULAR_RANK_FLIPPER_CACHE, BaseApplication.Companion.getGSON().s(allRankTop3Bean), (String) null, 4, (Object) null);
        }

        public final void savePowerDetailCache(@NotNull GroupPowerTitleDetail groupPowerTitleDetail) {
            Intrinsics.checkNotNullParameter(groupPowerTitleDetail, "groupPowerTitleDetail");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POWER_DETAIL_CACHE, BaseApplication.Companion.getGSON().s(groupPowerTitleDetail), (String) null, 4, (Object) null);
        }

        public final void savePowerFromTypeWeekRankCache(@NotNull List<GroupPowerWeekBean> groupPowerWeekBeanList, int type) {
            Intrinsics.checkNotNullParameter(groupPowerWeekBeanList, "groupPowerWeekBeanList");
            String s = BaseApplication.Companion.getGSON().s(groupPowerWeekBeanList);
            if (type == 1) {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POWER_THIS_WEEK_RANK_CACHE, s, (String) null, 4, (Object) null);
            } else {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.POWER_LAST_WEEK_RANK_CACHE, s, (String) null, 4, (Object) null);
            }
        }

        public final void saveRecentlyGroupCache(@NotNull List<HotGroupBean> hotGroupBean) {
            Intrinsics.checkNotNullParameter(hotGroupBean, "hotGroupBean");
            Log.d(MMKVToLocalCache.TAG, "getCache: saveRecentlyGroupCache() " + hotGroupBean.size() + " ");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.RECENTLY_GROUP_CACHE, BaseApplication.Companion.getGSON().s(hotGroupBean), (String) null, 4, (Object) null);
        }

        public final void saveRoomRankCache(@NotNull List<RankGroupBean> list, @NotNull String type) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(type, "type");
            String s = BaseApplication.Companion.getGSON().s(list);
            int hashCode = type.hashCode();
            if (hashCode != 99228) {
                if (hashCode != 3645428) {
                    if (hashCode == 104080000 && type.equals("month")) {
                        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.ROOM_MONTH_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                        Log.d(MMKVToLocalCache.TAG, "saveRoomRankCache: MONTH ROOM_MONTH_COMMON_RANK_CACHE");
                        return;
                    }
                    return;
                }
                if (type.equals("week")) {
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.ROOM_WEEK_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                    Log.d(MMKVToLocalCache.TAG, "saveRoomRankCache: WEEK ROOM_WEEK_COMMON_RANK_CACHE");
                    return;
                }
                return;
            }
            if (type.equals("day")) {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.ROOM_DAY_COMMON_RANK_CACHE, s, (String) null, 4, (Object) null);
                Log.d(MMKVToLocalCache.TAG, "saveRoomRankCache: DAY ROOM_DAY_COMMON_RANK_CACHE");
            }
        }

        public final void saveSayHiCache(@NotNull List<VideoBaseData> onlineCellUIModel) {
            Intrinsics.checkNotNullParameter(onlineCellUIModel, "onlineCellUIModel");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.SAY_HI_CACHE, BaseApplication.Companion.getGSON().s(onlineCellUIModel), (String) null, 4, (Object) null);
        }

        public final void saveSupportMyRank(@NotNull MySupportAllBean it) {
            Intrinsics.checkNotNullParameter(it, "it");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.SUPPORT_GIFT_RANK_CHCHE, BaseApplication.Companion.getGSON().s(it), (String) null, 4, (Object) null);
        }

        public final void setBlockRoom(@NotNull String userExtraId, @NotNull ArrayList<String> list) {
            Intrinsics.checkNotNullParameter(userExtraId, "userExtraId");
            Intrinsics.checkNotNullParameter(list, "list");
            String s = BaseApplication.Companion.getGSON().s(list);
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVToLocalCache.BLOCK_ROOM + userExtraId, s, (String) null, 4, (Object) null);
        }

        private Companion() {
        }
    }
}

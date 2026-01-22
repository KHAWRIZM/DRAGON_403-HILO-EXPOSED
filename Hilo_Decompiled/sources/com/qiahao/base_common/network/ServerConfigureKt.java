package com.qiahao.base_common.network;

import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.BaseUrlData;
import com.qiahao.base_common.model.cache.MMKVKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u001f\u001a\u00020 \u001a\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0001\u001a\u0006\u0010#\u001a\u00020 \"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\"\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\"*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0016j\b\u0012\u0004\u0012\u00020\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\"*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0016j\b\u0012\u0004\u0012\u00020\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b\"&\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\"&\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020,0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*¨\u0006/"}, d2 = {"BASE_URL_KEY", "", "kProductionServer", "kTestServer", "kLocalServer", "communityTestServer", "communityProductionServer", "H5BaseDebug", "H5Base", "mIndex", "", "getMIndex", "()I", "setMIndex", "(I)V", "mBaseUrlData", "Lcom/qiahao/base_common/model/BaseUrlData;", "getMBaseUrlData", "()Lcom/qiahao/base_common/model/BaseUrlData;", "setMBaseUrlData", "(Lcom/qiahao/base_common/model/BaseUrlData;)V", "mHttpList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMHttpList", "()Ljava/util/ArrayList;", "setMHttpList", "(Ljava/util/ArrayList;)V", "mWebSocketList", "getMWebSocketList", "setMWebSocketList", "resolverBaseUrlData", "", "updateServer", "json", "changProductionHttps", "availableServers", "", "Lcom/qiahao/base_common/network/ServerInfo;", "getAvailableServers", "()Ljava/util/Map;", "setAvailableServers", "(Ljava/util/Map;)V", "communityServers", "Lcom/qiahao/base_common/network/CommunityServerInfo;", "getCommunityServers", "setCommunityServers", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nServerConfigure.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerConfigure.kt\ncom/qiahao/base_common/network/ServerConfigureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1#2:169\n1878#3,3:170\n*S KotlinDebug\n*F\n+ 1 ServerConfigure.kt\ncom/qiahao/base_common/network/ServerConfigureKt\n*L\n99#1:170,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ServerConfigureKt {

    @NotNull
    public static final String BASE_URL_KEY = "appConfig";

    @NotNull
    public static final String H5Base = "https://h5.chathot.me";

    @NotNull
    public static final String H5BaseDebug = "https://test.chathot.me";

    @NotNull
    private static Map<String, ServerInfo> availableServers = null;

    @NotNull
    public static final String communityProductionServer = "communityServer";

    @NotNull
    private static Map<String, CommunityServerInfo> communityServers = null;

    @NotNull
    public static final String communityTestServer = "communityTest";

    @NotNull
    public static final String kLocalServer = "localhost";

    @NotNull
    public static final String kProductionServer = "production";

    @NotNull
    public static final String kTestServer = "test";

    @Nullable
    private static BaseUrlData mBaseUrlData;

    @NotNull
    private static ArrayList<String> mHttpList;
    private static int mIndex = ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVKey.PRODUCTION_SERVER_INDEX, 0, null, 4, null)).intValue();

    @NotNull
    private static ArrayList<String> mWebSocketList;

    static {
        List<String> wsURLs;
        List<String> wsURLs2;
        List<String> apiURLs;
        List<String> apiURLs2;
        ArrayList<String> arrayList = new ArrayList<>();
        resolverBaseUrlData();
        BaseUrlData baseUrlData = mBaseUrlData;
        if (baseUrlData != null && (apiURLs = baseUrlData.getApiURLs()) != null && (!apiURLs.isEmpty())) {
            BaseUrlData baseUrlData2 = mBaseUrlData;
            if (baseUrlData2 != null && (apiURLs2 = baseUrlData2.getApiURLs()) != null) {
                arrayList.addAll(apiURLs2);
            }
        } else {
            arrayList.add("https://api.tikhak.com");
            arrayList.add("https://apiv1.faceline.live");
            arrayList.add("https://api.hiloconn.com");
        }
        mHttpList = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        resolverBaseUrlData();
        BaseUrlData baseUrlData3 = mBaseUrlData;
        if (baseUrlData3 != null && (wsURLs = baseUrlData3.getWsURLs()) != null && (!wsURLs.isEmpty())) {
            BaseUrlData baseUrlData4 = mBaseUrlData;
            if (baseUrlData4 != null && (wsURLs2 = baseUrlData4.getWsURLs()) != null) {
                arrayList2.addAll(wsURLs2);
            }
        } else {
            arrayList2.add("wss://ws.tikhak.com/ws");
            arrayList2.add("wss://ws.faceline.live/ws");
            arrayList2.add("wss://ws.hiloconn.com/ws");
        }
        mWebSocketList = arrayList2;
        String str = mHttpList.get(mIndex);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = str;
        String str3 = mWebSocketList.get(mIndex);
        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
        availableServers = MapsKt.mapOf(TuplesKt.to(kProductionServer, new ServerInfo("Production", " N/A", kProductionServer, str2, "6291d069123642d9929a49c734c50719", "uwd1c0sxu5t41", str3, 40000066, 15813, "https://h5.chathot.me/action/activityFile/hiloUserLevel/index.html", H5Base)), TuplesKt.to("test", new ServerInfo("Test", " N/A", "test", "https://test.apiv1.faceline.live", "fc3e087f701b4f788099e1924c3cc7b0", "pvxdm17jpe9tr", "wss://test.ws.faceline.live/ws", 1400548270, 20242, "http://test.chathot.me/action/activityhtml/hiloUserLevel/index.html", H5BaseDebug)), TuplesKt.to(kLocalServer, new ServerInfo("Local", " N/A", kLocalServer, "https://test.apiv1.faceline.live", "fc3e087f701b4f788099e1924c3cc7b0", "pvxdm17jpe9tr", "wss://test.ws.faceline.live:443/ws", 1400548270, 20242, "http://test.chathot.me/action/activityhtml/hiloUserLevel/index.html", H5BaseDebug)));
        communityServers = MapsKt.mapOf(TuplesKt.to(communityTestServer, new CommunityServerInfo("CommunityTest", communityTestServer, "https://test-moment.faceline.live:7110")), TuplesKt.to(communityProductionServer, new CommunityServerInfo("CommunityProduction", communityProductionServer, "https://moment.tikhak.com")));
    }

    public static final void changProductionHttps() {
        String str;
        ServerInfo serverInfo = availableServers.get(kProductionServer);
        if (serverInfo != null) {
            str = serverInfo.getBaseUrl();
        } else {
            str = null;
        }
        int i10 = -1;
        int i11 = 0;
        for (Object obj : mHttpList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual((String) obj, str)) {
                i10 = i11;
            }
            i11 = i12;
        }
        if (i10 == mHttpList.size() - 1) {
            mIndex = 0;
        } else {
            mIndex++;
        }
        ServerInfo serverInfo2 = availableServers.get(kProductionServer);
        if (serverInfo2 != null) {
            serverInfo2.setBaseUrl(mHttpList.get(mIndex));
        }
        ServerInfo serverInfo3 = availableServers.get(kProductionServer);
        if (serverInfo3 != null) {
            serverInfo3.setMatchWebSocketAddr(mWebSocketList.get(mIndex));
        }
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, MMKVKey.PRODUCTION_SERVER_INDEX, Integer.valueOf(mIndex), null, 4, null);
    }

    @NotNull
    public static final Map<String, ServerInfo> getAvailableServers() {
        return availableServers;
    }

    @NotNull
    public static final Map<String, CommunityServerInfo> getCommunityServers() {
        return communityServers;
    }

    @Nullable
    public static final BaseUrlData getMBaseUrlData() {
        return mBaseUrlData;
    }

    @NotNull
    public static final ArrayList<String> getMHttpList() {
        return mHttpList;
    }

    public static final int getMIndex() {
        return mIndex;
    }

    @NotNull
    public static final ArrayList<String> getMWebSocketList() {
        return mWebSocketList;
    }

    public static final void resolverBaseUrlData() {
        if (mBaseUrlData != null) {
            return;
        }
        try {
            mBaseUrlData = (BaseUrlData) BaseApplication.INSTANCE.getGSON().j((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, MMKVKey.FIREBASE_BASE_URL, "", null, 4, null), BaseUrlData.class);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static final void setAvailableServers(@NotNull Map<String, ServerInfo> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        availableServers = map;
    }

    public static final void setCommunityServers(@NotNull Map<String, CommunityServerInfo> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        communityServers = map;
    }

    public static final void setMBaseUrlData(@Nullable BaseUrlData baseUrlData) {
        mBaseUrlData = baseUrlData;
    }

    public static final void setMHttpList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mHttpList = arrayList;
    }

    public static final void setMIndex(int i10) {
        mIndex = i10;
    }

    public static final void setMWebSocketList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mWebSocketList = arrayList;
    }

    public static final void updateServer(@NotNull String json) {
        Integer num;
        List<String> wsURLs;
        List<String> wsURLs2;
        List<String> apiURLs;
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            BaseUrlData baseUrlData = (BaseUrlData) BaseApplication.INSTANCE.getGSON().j(json, BaseUrlData.class);
            List<String> apiURLs2 = baseUrlData.getApiURLs();
            Integer num2 = null;
            if (apiURLs2 != null) {
                num = Integer.valueOf(apiURLs2.size());
            } else {
                num = null;
            }
            List<String> wsURLs3 = baseUrlData.getWsURLs();
            if (wsURLs3 != null) {
                num2 = Integer.valueOf(wsURLs3.size());
            }
            if (!Intrinsics.areEqual(num, num2)) {
                return;
            }
            mBaseUrlData = baseUrlData;
            if (baseUrlData.getApiURLs() != null && (!r3.isEmpty())) {
                mHttpList.clear();
                BaseUrlData baseUrlData2 = mBaseUrlData;
                if (baseUrlData2 != null && (apiURLs = baseUrlData2.getApiURLs()) != null) {
                    mHttpList.addAll(apiURLs);
                }
            }
            BaseUrlData baseUrlData3 = mBaseUrlData;
            if (baseUrlData3 != null && (wsURLs = baseUrlData3.getWsURLs()) != null && (!wsURLs.isEmpty())) {
                mWebSocketList.clear();
                BaseUrlData baseUrlData4 = mBaseUrlData;
                if (baseUrlData4 != null && (wsURLs2 = baseUrlData4.getWsURLs()) != null) {
                    mWebSocketList.addAll(wsURLs2);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}

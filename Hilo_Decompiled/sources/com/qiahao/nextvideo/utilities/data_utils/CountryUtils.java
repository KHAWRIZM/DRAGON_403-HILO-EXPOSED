package com.qiahao.nextvideo.utilities.data_utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.gson.d;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.nextvideo.data.model.CountriesResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/utilities/data_utils/CountryUtils;", "", "<init>", "()V", "saveCountryList", "", "data", "Lcom/qiahao/nextvideo/data/model/CountriesResponse;", "getCountryList", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/common/Country;", "Lkotlin/collections/ArrayList;", "getDefaultCountryISO", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCountryUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CountryUtils.kt\ncom/qiahao/nextvideo/utilities/data_utils/CountryUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n1#2:67\n1869#3,2:68\n*S KotlinDebug\n*F\n+ 1 CountryUtils.kt\ncom/qiahao/nextvideo/utilities/data_utils/CountryUtils\n*L\n54#1:68,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CountryUtils {

    @NotNull
    public static final CountryUtils INSTANCE = new CountryUtils();

    private CountryUtils() {
    }

    @Nullable
    public final ArrayList<Country> getCountryList() {
        try {
            return (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "country_list", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<Country>>() { // from class: com.qiahao.nextvideo.utilities.data_utils.CountryUtils$getCountryList$typeToken$1
            }.getType());
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final Country getDefaultCountryISO(@NotNull Context context) {
        String networkCountryIso;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            if (TextUtils.isEmpty(telephonyManager.getNetworkCountryIso())) {
                networkCountryIso = telephonyManager.getSimCountryIso();
            } else {
                networkCountryIso = telephonyManager.getNetworkCountryIso();
            }
            ArrayList<Country> countryList = getCountryList();
            if (countryList != null) {
                for (Country country : countryList) {
                    Intrinsics.checkNotNull(networkCountryIso);
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    String lowerCase = networkCountryIso.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String areaShortName = country.getAreaShortName();
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    String lowerCase2 = areaShortName.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        return country;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return new Country("KSA", "https://oss.iludo.live/image/843ae1588aed49048b20ad18540c01ab.png", "KSA", 70101L, "966", "SA");
    }

    public final void saveCountryList(@Nullable CountriesResponse data) {
        List<Country> noCommon;
        List<Country> common;
        ArrayList arrayList = new ArrayList();
        if (data != null && (common = data.getCommon()) != null) {
            arrayList.addAll(common);
        }
        if (data != null && (noCommon = data.getNoCommon()) != null) {
            arrayList.addAll(noCommon);
        }
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "country_list", new d().s(arrayList), (String) null, 4, (Object) null);
    }
}

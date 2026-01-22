package com.qiahao.nextvideo.ui.home.filter.regoinpreference;

import com.qiahao.nextvideo.data.model.MatchSetTypes;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/regoinpreference/RegionPreferenceCategory;", "", "aliasName", "", "price", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getAliasName", "()Ljava/lang/String;", "getPrice", "()I", "setPrice", "(I)V", "GLOBAL", "USER_OF_COUNTRY", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RegionPreferenceCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegionPreferenceCategory[] $VALUES;
    public static final RegionPreferenceCategory GLOBAL;
    public static final RegionPreferenceCategory USER_OF_COUNTRY;

    @NotNull
    private final String aliasName;
    private int price;

    private static final /* synthetic */ RegionPreferenceCategory[] $values() {
        return new RegionPreferenceCategory[]{GLOBAL, USER_OF_COUNTRY};
    }

    static {
        int i;
        MatchSetTypes matchSetTypes;
        MatchSetTypes matchSetTypes2;
        PurchaseService.Companion companion = PurchaseService.INSTANCE;
        PurchaseFeeDetailsX purchaseFeeDetail = companion.getShared().getPurchaseFeeDetail();
        int i2 = 0;
        if (purchaseFeeDetail != null && (matchSetTypes2 = purchaseFeeDetail.getMatchSetTypes()) != null) {
            i = matchSetTypes2.getGlobalFee();
        } else {
            i = 0;
        }
        GLOBAL = new RegionPreferenceCategory("GLOBAL", 0, "Global", i);
        PurchaseFeeDetailsX purchaseFeeDetail2 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail2 != null && (matchSetTypes = purchaseFeeDetail2.getMatchSetTypes()) != null) {
            i2 = matchSetTypes.getUserCountryFee();
        }
        USER_OF_COUNTRY = new RegionPreferenceCategory("USER_OF_COUNTRY", 1, "UserOfCountry", i2);
        RegionPreferenceCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private RegionPreferenceCategory(String str, int i, String str2, int i2) {
        this.aliasName = str2;
        this.price = i2;
    }

    @NotNull
    public static EnumEntries<RegionPreferenceCategory> getEntries() {
        return $ENTRIES;
    }

    public static RegionPreferenceCategory valueOf(String str) {
        return (RegionPreferenceCategory) Enum.valueOf(RegionPreferenceCategory.class, str);
    }

    public static RegionPreferenceCategory[] values() {
        return (RegionPreferenceCategory[]) $VALUES.clone();
    }

    @NotNull
    public final String getAliasName() {
        return this.aliasName;
    }

    public final int getPrice() {
        return this.price;
    }

    public final void setPrice(int i) {
        this.price = i;
    }
}

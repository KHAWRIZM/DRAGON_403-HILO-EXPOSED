package com.qiahao.nextvideo.ui.home.filter.genderpreference;

import com.qiahao.nextvideo.data.model.MatchSetTypes;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/filter/genderpreference/GenderPreferenceCategory;", "", Constants.KEY_HTTP_CODE, "", "price", "<init>", "(Ljava/lang/String;III)V", "getCode", "()I", "getPrice", "setPrice", "(I)V", "Both", "Female", "Male", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GenderPreferenceCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GenderPreferenceCategory[] $VALUES;
    public static final GenderPreferenceCategory Both;
    public static final GenderPreferenceCategory Female;
    public static final GenderPreferenceCategory Male;
    private final int code;
    private int price;

    private static final /* synthetic */ GenderPreferenceCategory[] $values() {
        return new GenderPreferenceCategory[]{Both, Female, Male};
    }

    static {
        int i;
        int i2;
        MatchSetTypes matchSetTypes;
        MatchSetTypes matchSetTypes2;
        MatchSetTypes matchSetTypes3;
        PurchaseService.Companion companion = PurchaseService.INSTANCE;
        PurchaseFeeDetailsX purchaseFeeDetail = companion.getShared().getPurchaseFeeDetail();
        int i3 = 0;
        if (purchaseFeeDetail != null && (matchSetTypes3 = purchaseFeeDetail.getMatchSetTypes()) != null) {
            i = matchSetTypes3.getUseBalanceSexMatchFee();
        } else {
            i = 0;
        }
        Both = new GenderPreferenceCategory("Both", 0, 0, i);
        PurchaseFeeDetailsX purchaseFeeDetail2 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail2 != null && (matchSetTypes2 = purchaseFeeDetail2.getMatchSetTypes()) != null) {
            i2 = matchSetTypes2.getUseFemaleMatchFee();
        } else {
            i2 = 0;
        }
        Female = new GenderPreferenceCategory("Female", 1, 2, i2);
        PurchaseFeeDetailsX purchaseFeeDetail3 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail3 != null && (matchSetTypes = purchaseFeeDetail3.getMatchSetTypes()) != null) {
            i3 = matchSetTypes.getUseMaleMatchFee();
        }
        Male = new GenderPreferenceCategory("Male", 2, 1, i3);
        GenderPreferenceCategory[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private GenderPreferenceCategory(String str, int i, int i2, int i3) {
        this.code = i2;
        this.price = i3;
    }

    @NotNull
    public static EnumEntries<GenderPreferenceCategory> getEntries() {
        return $ENTRIES;
    }

    public static GenderPreferenceCategory valueOf(String str) {
        return (GenderPreferenceCategory) Enum.valueOf(GenderPreferenceCategory.class, str);
    }

    public static GenderPreferenceCategory[] values() {
        return (GenderPreferenceCategory[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final int getPrice() {
        return this.price;
    }

    public final void setPrice(int i) {
        this.price = i;
    }
}

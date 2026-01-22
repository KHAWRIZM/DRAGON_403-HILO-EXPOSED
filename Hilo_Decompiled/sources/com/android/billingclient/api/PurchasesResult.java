package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\rR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/android/billingclient/api/PurchasesResult;", "", "Lcom/android/billingclient/api/w;", "billingResult", "", "Lcom/android/billingclient/api/Purchase;", "purchasesList", "<init>", "(Lcom/android/billingclient/api/w;Ljava/util/List;)V", "", "hashCode", "()I", "component1", "()Lcom/android/billingclient/api/w;", "copy", "(Lcom/android/billingclient/api/w;Ljava/util/List;)Lcom/android/billingclient/api/PurchasesResult;", "", "toString", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/w;", "getBillingResult", "Ljava/util/List;", "getPurchasesList", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class PurchasesResult {

    /* renamed from: zza, reason: from toString */
    @NotNull
    private final w billingResult;

    /* renamed from: zzb, reason: from toString */
    @NotNull
    private final List purchasesList;

    public PurchasesResult(@RecentlyNonNull w billingResult, @RecentlyNonNull List<? extends Purchase> purchasesList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
        this.billingResult = billingResult;
        this.purchasesList = purchasesList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RecentlyNonNull
    public static /* synthetic */ PurchasesResult copy$default(@RecentlyNonNull PurchasesResult purchasesResult, @RecentlyNonNull w wVar, @RecentlyNonNull List list, int i10, @RecentlyNonNull Object obj) {
        if ((i10 & 1) != 0) {
            wVar = purchasesResult.billingResult;
        }
        if ((i10 & 2) != 0) {
            list = purchasesResult.purchasesList;
        }
        return purchasesResult.copy(wVar, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final w getBillingResult() {
        return this.billingResult;
    }

    @NotNull
    public final List<Purchase> component2() {
        return this.purchasesList;
    }

    @NotNull
    public final PurchasesResult copy(@RecentlyNonNull w billingResult, @RecentlyNonNull List<? extends Purchase> purchasesList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
        return new PurchasesResult(billingResult, purchasesList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchasesResult)) {
            return false;
        }
        PurchasesResult purchasesResult = (PurchasesResult) other;
        return Intrinsics.areEqual(this.billingResult, purchasesResult.billingResult) && Intrinsics.areEqual(this.purchasesList, purchasesResult.purchasesList);
    }

    @NotNull
    public final w getBillingResult() {
        return this.billingResult;
    }

    @NotNull
    public final List<Purchase> getPurchasesList() {
        return this.purchasesList;
    }

    public int hashCode() {
        return (this.billingResult.hashCode() * 31) + this.purchasesList.hashCode();
    }

    @NotNull
    public String toString() {
        return "PurchasesResult(billingResult=" + this.billingResult + ", purchasesList=" + this.purchasesList + ")";
    }
}

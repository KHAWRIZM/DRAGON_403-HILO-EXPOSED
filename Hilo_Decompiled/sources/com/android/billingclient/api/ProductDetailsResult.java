package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ,\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\rR\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/android/billingclient/api/ProductDetailsResult;", "", "Lcom/android/billingclient/api/w;", "billingResult", "", "Lcom/android/billingclient/api/e0;", "productDetailsList", "<init>", "(Lcom/android/billingclient/api/w;Ljava/util/List;)V", "", "hashCode", "()I", "component1", "()Lcom/android/billingclient/api/w;", "copy", "(Lcom/android/billingclient/api/w;Ljava/util/List;)Lcom/android/billingclient/api/ProductDetailsResult;", "", "toString", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/w;", "getBillingResult", "Ljava/util/List;", "getProductDetailsList", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class ProductDetailsResult {

    /* renamed from: zza, reason: from toString */
    @NotNull
    private final w billingResult;

    /* renamed from: zzb, reason: from toString */
    @Nullable
    private final List productDetailsList;

    public ProductDetailsResult(@RecentlyNonNull w billingResult, @Nullable List<e0> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.billingResult = billingResult;
        this.productDetailsList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RecentlyNonNull
    public static /* synthetic */ ProductDetailsResult copy$default(@RecentlyNonNull ProductDetailsResult productDetailsResult, @RecentlyNonNull w wVar, @RecentlyNonNull List list, int i10, @RecentlyNonNull Object obj) {
        if ((i10 & 1) != 0) {
            wVar = productDetailsResult.billingResult;
        }
        if ((i10 & 2) != 0) {
            list = productDetailsResult.productDetailsList;
        }
        return productDetailsResult.copy(wVar, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final w getBillingResult() {
        return this.billingResult;
    }

    @RecentlyNullable
    public final List<e0> component2() {
        return this.productDetailsList;
    }

    @NotNull
    public final ProductDetailsResult copy(@RecentlyNonNull w billingResult, @Nullable List<e0> productDetailsList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new ProductDetailsResult(billingResult, productDetailsList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductDetailsResult)) {
            return false;
        }
        ProductDetailsResult productDetailsResult = (ProductDetailsResult) other;
        return Intrinsics.areEqual(this.billingResult, productDetailsResult.billingResult) && Intrinsics.areEqual(this.productDetailsList, productDetailsResult.productDetailsList);
    }

    @NotNull
    public final w getBillingResult() {
        return this.billingResult;
    }

    @RecentlyNullable
    public final List<e0> getProductDetailsList() {
        return this.productDetailsList;
    }

    public int hashCode() {
        int hashCode = this.billingResult.hashCode() * 31;
        List list = this.productDetailsList;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "ProductDetailsResult(billingResult=" + this.billingResult + ", productDetailsList=" + this.productDetailsList + ")";
    }
}

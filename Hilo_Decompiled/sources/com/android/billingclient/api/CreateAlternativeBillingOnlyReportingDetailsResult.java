package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "", "Lcom/android/billingclient/api/w;", "billingResult", "Lcom/android/billingclient/api/e;", "alternativeBillingOnlyReportingDetails", "<init>", "(Lcom/android/billingclient/api/w;Lcom/android/billingclient/api/e;)V", "", "hashCode", "()I", "component2", "()Lcom/android/billingclient/api/e;", "component1", "()Lcom/android/billingclient/api/w;", "copy", "(Lcom/android/billingclient/api/w;Lcom/android/billingclient/api/e;)Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/e;", "getAlternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/w;", "getBillingResult", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class CreateAlternativeBillingOnlyReportingDetailsResult {

    /* renamed from: zza, reason: from toString */
    @NotNull
    private final w billingResult;

    /* renamed from: zzb, reason: from toString */
    @Nullable
    private final e alternativeBillingOnlyReportingDetails;

    public CreateAlternativeBillingOnlyReportingDetailsResult(@RecentlyNonNull w billingResult, @Nullable e eVar) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.billingResult = billingResult;
        this.alternativeBillingOnlyReportingDetails = eVar;
    }

    @RecentlyNonNull
    public static /* synthetic */ CreateAlternativeBillingOnlyReportingDetailsResult copy$default(@RecentlyNonNull CreateAlternativeBillingOnlyReportingDetailsResult createAlternativeBillingOnlyReportingDetailsResult, @RecentlyNonNull w wVar, @RecentlyNonNull e eVar, int i10, @RecentlyNonNull Object obj) {
        if ((i10 & 1) != 0) {
            wVar = createAlternativeBillingOnlyReportingDetailsResult.billingResult;
        }
        if ((i10 & 2) != 0) {
            eVar = createAlternativeBillingOnlyReportingDetailsResult.alternativeBillingOnlyReportingDetails;
        }
        return createAlternativeBillingOnlyReportingDetailsResult.copy(wVar, eVar);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final w getBillingResult() {
        return this.billingResult;
    }

    @RecentlyNullable
    /* renamed from: component2, reason: from getter */
    public final e getAlternativeBillingOnlyReportingDetails() {
        return this.alternativeBillingOnlyReportingDetails;
    }

    @NotNull
    public final CreateAlternativeBillingOnlyReportingDetailsResult copy(@RecentlyNonNull w billingResult, @Nullable e alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult, alternativeBillingOnlyReportingDetails);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateAlternativeBillingOnlyReportingDetailsResult)) {
            return false;
        }
        CreateAlternativeBillingOnlyReportingDetailsResult createAlternativeBillingOnlyReportingDetailsResult = (CreateAlternativeBillingOnlyReportingDetailsResult) other;
        return Intrinsics.areEqual(this.billingResult, createAlternativeBillingOnlyReportingDetailsResult.billingResult) && Intrinsics.areEqual(this.alternativeBillingOnlyReportingDetails, createAlternativeBillingOnlyReportingDetailsResult.alternativeBillingOnlyReportingDetails);
    }

    @RecentlyNullable
    public final e getAlternativeBillingOnlyReportingDetails() {
        return this.alternativeBillingOnlyReportingDetails;
    }

    @NotNull
    public final w getBillingResult() {
        return this.billingResult;
    }

    public int hashCode() {
        int hashCode = this.billingResult.hashCode() * 31;
        e eVar = this.alternativeBillingOnlyReportingDetails;
        return hashCode + (eVar == null ? 0 : eVar.hashCode());
    }

    @NotNull
    public String toString() {
        return "CreateAlternativeBillingOnlyReportingDetailsResult(billingResult=" + this.billingResult + ", alternativeBillingOnlyReportingDetails=" + this.alternativeBillingOnlyReportingDetails + ")";
    }
}

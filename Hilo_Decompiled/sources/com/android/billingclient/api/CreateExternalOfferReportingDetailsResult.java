package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "", "Lcom/android/billingclient/api/w;", "billingResult", "Lcom/android/billingclient/api/a0;", "externalOfferReportingDetails", "<init>", "(Lcom/android/billingclient/api/w;Lcom/android/billingclient/api/a0;)V", "", "hashCode", "()I", "component1", "()Lcom/android/billingclient/api/w;", "copy", "(Lcom/android/billingclient/api/w;Lcom/android/billingclient/api/a0;)Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "component2", "()Lcom/android/billingclient/api/a0;", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/w;", "getBillingResult", "Lcom/android/billingclient/api/a0;", "getExternalOfferReportingDetails", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class CreateExternalOfferReportingDetailsResult {

    /* renamed from: zza, reason: from toString */
    @NotNull
    private final w billingResult;

    /* renamed from: zzb, reason: from toString */
    @Nullable
    private final a0 externalOfferReportingDetails;

    public CreateExternalOfferReportingDetailsResult(@RecentlyNonNull w billingResult, @Nullable a0 a0Var) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.billingResult = billingResult;
        this.externalOfferReportingDetails = a0Var;
    }

    @RecentlyNonNull
    public static /* synthetic */ CreateExternalOfferReportingDetailsResult copy$default(@RecentlyNonNull CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult, @RecentlyNonNull w wVar, @RecentlyNonNull a0 a0Var, int i10, @RecentlyNonNull Object obj) {
        if ((i10 & 1) != 0) {
            wVar = createExternalOfferReportingDetailsResult.billingResult;
        }
        if ((i10 & 2) != 0) {
            a0Var = createExternalOfferReportingDetailsResult.externalOfferReportingDetails;
        }
        return createExternalOfferReportingDetailsResult.copy(wVar, a0Var);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final w getBillingResult() {
        return this.billingResult;
    }

    @RecentlyNullable
    /* renamed from: component2, reason: from getter */
    public final a0 getExternalOfferReportingDetails() {
        return this.externalOfferReportingDetails;
    }

    @NotNull
    public final CreateExternalOfferReportingDetailsResult copy(@RecentlyNonNull w billingResult, @Nullable a0 externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new CreateExternalOfferReportingDetailsResult(billingResult, externalOfferReportingDetails);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateExternalOfferReportingDetailsResult)) {
            return false;
        }
        CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult = (CreateExternalOfferReportingDetailsResult) other;
        return Intrinsics.areEqual(this.billingResult, createExternalOfferReportingDetailsResult.billingResult) && Intrinsics.areEqual(this.externalOfferReportingDetails, createExternalOfferReportingDetailsResult.externalOfferReportingDetails);
    }

    @NotNull
    public final w getBillingResult() {
        return this.billingResult;
    }

    @RecentlyNullable
    public final a0 getExternalOfferReportingDetails() {
        return this.externalOfferReportingDetails;
    }

    public int hashCode() {
        int hashCode = this.billingResult.hashCode() * 31;
        a0 a0Var = this.externalOfferReportingDetails;
        return hashCode + (a0Var == null ? 0 : a0Var.hashCode());
    }

    @NotNull
    public String toString() {
        return "CreateExternalOfferReportingDetailsResult(billingResult=" + this.billingResult + ", externalOfferReportingDetails=" + this.externalOfferReportingDetails + ")";
    }
}

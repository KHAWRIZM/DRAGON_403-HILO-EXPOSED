package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;", "", "adSelectionId", "", "seller", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "adSelectionResult", "", "(JLandroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;[B)V", "getAdSelectionId", "()J", "getAdSelectionResult", "()[B", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "convertToAdServices", "Landroid/adservices/adselection/PersistAdSelectionResultRequest;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class PersistAdSelectionResultRequest {
    private final long adSelectionId;

    @Nullable
    private final byte[] adSelectionResult;

    @Nullable
    private final AdTechIdentifier seller;

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j10) {
        this(j10, null, null, 6, null);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final android.adservices.adselection.PersistAdSelectionResultRequest convertToAdServices$ads_adservices_release() {
        PersistAdSelectionResultRequest.Builder adSelectionId;
        android.adservices.common.AdTechIdentifier adTechIdentifier;
        PersistAdSelectionResultRequest.Builder seller;
        PersistAdSelectionResultRequest.Builder adSelectionResult;
        android.adservices.adselection.PersistAdSelectionResultRequest build;
        adSelectionId = n0.a().setAdSelectionId(this.adSelectionId);
        AdTechIdentifier adTechIdentifier2 = this.seller;
        if (adTechIdentifier2 != null) {
            adTechIdentifier = adTechIdentifier2.convertToAdServices$ads_adservices_release();
        } else {
            adTechIdentifier = null;
        }
        seller = adSelectionId.setSeller(adTechIdentifier);
        adSelectionResult = seller.setAdSelectionResult(this.adSelectionResult);
        build = adSelectionResult.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ult)\n            .build()");
        return build;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) other;
        if (this.adSelectionId == persistAdSelectionResultRequest.adSelectionId && Intrinsics.areEqual(this.seller, persistAdSelectionResultRequest.seller) && Arrays.equals(this.adSelectionResult, persistAdSelectionResultRequest.adSelectionResult)) {
            return true;
        }
        return false;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @Nullable
    public final byte[] getAdSelectionResult() {
        return this.adSelectionResult;
    }

    @Nullable
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i10;
        int a10 = androidx.collection.c.a(this.adSelectionId) * 31;
        AdTechIdentifier adTechIdentifier = this.seller;
        int i11 = 0;
        if (adTechIdentifier != null) {
            i10 = adTechIdentifier.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = (a10 + i10) * 31;
        byte[] bArr = this.adSelectionResult;
        if (bArr != null) {
            i11 = bArr.hashCode();
        }
        return i12 + i11;
    }

    @NotNull
    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.adSelectionId + ", seller=" + this.seller + ", adSelectionResult=" + this.adSelectionResult;
    }

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j10, @Nullable AdTechIdentifier adTechIdentifier) {
        this(j10, adTechIdentifier, null, 4, null);
    }

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j10, @Nullable AdTechIdentifier adTechIdentifier, @Nullable byte[] bArr) {
        this.adSelectionId = j10;
        this.seller = adTechIdentifier;
        this.adSelectionResult = bArr;
    }

    public /* synthetic */ PersistAdSelectionResultRequest(long j10, AdTechIdentifier adTechIdentifier, byte[] bArr, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(j10, (i10 & 2) != 0 ? null : adTechIdentifier, (i10 & 4) != 0 ? null : bArr);
    }
}

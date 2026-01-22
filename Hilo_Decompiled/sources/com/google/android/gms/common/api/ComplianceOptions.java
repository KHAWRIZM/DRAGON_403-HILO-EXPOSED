package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ComplianceOptionsCreator")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ComplianceOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ComplianceOptions> CREATOR;
    public static final ComplianceOptions zza;

    @SafeParcelable.Field(getter = "getCallerProductId", id = 1)
    private final int zzb;

    @SafeParcelable.Field(getter = "getDataOwnerProductId", id = 2)
    private final int zzc;

    @SafeParcelable.Field(getter = "getProcessingReason", id = 3)
    private final int zzd;

    @SafeParcelable.Field(defaultValue = "true", getter = "isUserData", id = 4)
    private final boolean zze;

    @KeepForSdk
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder {
        private int zza = -1;
        private int zzb = -1;
        private int zzc = 0;
        private boolean zzd = true;

        @KeepForSdk
        public ComplianceOptions build() {
            return new ComplianceOptions(this.zza, this.zzb, this.zzc, this.zzd);
        }

        @KeepForSdk
        public Builder setCallerProductId(int i10) {
            this.zza = i10;
            return this;
        }

        @KeepForSdk
        public Builder setDataOwnerProductId(int i10) {
            this.zzb = i10;
            return this;
        }

        @KeepForSdk
        public Builder setIsUserData(boolean z10) {
            this.zzd = z10;
            return this;
        }

        @KeepForSdk
        public Builder setProcessingReason(int i10) {
            this.zzc = i10;
            return this;
        }
    }

    static {
        Builder newBuilder = newBuilder();
        newBuilder.setCallerProductId(-1);
        newBuilder.setDataOwnerProductId(-1);
        newBuilder.setProcessingReason(0);
        newBuilder.setIsUserData(true);
        zza = newBuilder.build();
        CREATOR = new zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ComplianceOptions(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) boolean z10) {
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = z10;
    }

    @KeepForSdk
    public static Builder newBuilder() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ComplianceOptions)) {
            return false;
        }
        ComplianceOptions complianceOptions = (ComplianceOptions) obj;
        if (this.zzb != complianceOptions.zzb || this.zzc != complianceOptions.zzc || this.zzd != complianceOptions.zzd || this.zze != complianceOptions.zze) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Boolean.valueOf(this.zze));
    }

    @KeepForSdk
    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setCallerProductId(this.zzb);
        builder.setDataOwnerProductId(this.zzc);
        builder.setProcessingReason(this.zzd);
        builder.setIsUserData(this.zze);
        return builder;
    }

    public final String toString() {
        return "ComplianceOptions{callerProductId=" + this.zzb + ", dataOwnerProductId=" + this.zzc + ", processingReason=" + this.zzd + ", isUserData=" + this.zze + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i11);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @KeepForSdk
    public static final Builder newBuilder(Context context) {
        return newBuilder();
    }
}

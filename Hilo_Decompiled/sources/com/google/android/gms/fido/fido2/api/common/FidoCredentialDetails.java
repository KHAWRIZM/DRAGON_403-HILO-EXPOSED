package com.google.android.gms.fido.fido2.api.common;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fido.zzgx;

@SafeParcelable.Class(creator = "FidoCredentialDetailsCreator")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class FidoCredentialDetails extends AbstractSafeParcelable {
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new zzy();

    @SafeParcelable.Field(getter = "getUserName", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getUserDisplayName", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getUserId", id = 3, type = "byte[]")
    private final zzgx zzc;

    @SafeParcelable.Field(getter = "getCredentialId", id = 4, type = "byte[]")
    private final zzgx zzd;

    @SafeParcelable.Field(getter = "getIsDiscoverable", id = 5)
    private final boolean zze;

    @SafeParcelable.Field(getter = "getIsPaymentCredential", id = 6)
    private final boolean zzf;

    @SafeParcelable.Field(defaultValue = "0", getter = "getLastUsedTime", id = 7)
    private final long zzg;

    @SafeParcelable.Field(getter = "getOwningAccount", id = 8)
    private final Account zzh;

    @SafeParcelable.Field(getter = "getIsCryptauthSigninCredentialForAccount", id = 9)
    private final boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public FidoCredentialDetails(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) byte[] bArr2, @SafeParcelable.Param(id = 5) boolean z10, @SafeParcelable.Param(id = 6) boolean z11, @SafeParcelable.Param(id = 7) long j10, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 9) boolean z12) {
        zzgx zzl;
        if (bArr == null) {
            zzl = null;
        } else {
            zzl = zzgx.zzl(bArr, 0, bArr.length);
        }
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzl2 = zzgx.zzl(bArr2, 0, bArr2.length);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzl;
        this.zzd = zzl2;
        this.zze = z10;
        this.zzf = z11;
        this.zzg = j10;
        this.zzh = account;
        this.zzi = z12;
    }

    public static FidoCredentialDetails deserializeFromBytes(byte[] bArr) {
        return (FidoCredentialDetails) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        if (!Objects.equal(this.zza, fidoCredentialDetails.zza) || !Objects.equal(this.zzb, fidoCredentialDetails.zzb) || !Objects.equal(this.zzc, fidoCredentialDetails.zzc) || !Objects.equal(this.zzd, fidoCredentialDetails.zzd) || this.zze != fidoCredentialDetails.zze || this.zzf != fidoCredentialDetails.zzf || this.zzi != fidoCredentialDetails.zzi || this.zzg != fidoCredentialDetails.zzg || !Objects.equal(this.zzh, fidoCredentialDetails.zzh)) {
            return false;
        }
        return true;
    }

    public byte[] getCredentialId() {
        return this.zzd.zzm();
    }

    public zzgx getCredentialIdAsByteString() {
        return this.zzd;
    }

    public boolean getIsDiscoverable() {
        return this.zze;
    }

    public boolean getIsPaymentCredential() {
        return this.zzf;
    }

    public long getLastUsedTime() {
        return this.zzg;
    }

    public String getUserDisplayName() {
        return this.zzb;
    }

    public byte[] getUserId() {
        zzgx zzgxVar = this.zzc;
        if (zzgxVar == null) {
            return null;
        }
        return zzgxVar.zzm();
    }

    public zzgx getUserIdAsByteString() {
        return this.zzc;
    }

    public String getUserName() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Boolean.valueOf(this.zzi), Long.valueOf(this.zzg), this.zzh);
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUserName(), false);
        SafeParcelWriter.writeString(parcel, 2, getUserDisplayName(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getUserId(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getCredentialId(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getIsDiscoverable());
        SafeParcelWriter.writeBoolean(parcel, 6, getIsPaymentCredential());
        SafeParcelWriter.writeLong(parcel, 7, getLastUsedTime());
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

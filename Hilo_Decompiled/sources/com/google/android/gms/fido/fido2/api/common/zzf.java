package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzgx;

@SafeParcelable.Class(creator = "AuthenticationExtensionsDevicePublicKeyOutputsCreator")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    @SafeParcelable.Field(getter = "getSignature", id = 1, type = "byte[]")
    private final zzgx zza;

    @SafeParcelable.Field(getter = "getAuthenticatorOutput", id = 2, type = "byte[]")
    private final zzgx zzb;

    public zzf(zzgx zzgxVar, zzgx zzgxVar2) {
        this.zza = zzgxVar;
        this.zzb = zzgxVar2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzfVar = (zzf) obj;
        if (!Objects.equal(this.zza, zzfVar.zza) || !Objects.equal(this.zzb, zzfVar.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        byte[] zzm;
        zzgx zzgxVar = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        byte[] bArr = null;
        if (zzgxVar == null) {
            zzm = null;
        } else {
            zzm = zzgxVar.zzm();
        }
        SafeParcelWriter.writeByteArray(parcel, 1, zzm, false);
        zzgx zzgxVar2 = this.zzb;
        if (zzgxVar2 != null) {
            bArr = zzgxVar2.zzm();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzgx;

@SafeParcelable.Class(creator = "CableAuthenticationDataCreator")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    @SafeParcelable.Field(getter = "getVersion", id = 1)
    private final long zza;

    @SafeParcelable.Field(getter = "getClientEid", id = 2, type = "byte[]")
    private final zzgx zzb;

    @SafeParcelable.Field(getter = "getAuthenticatorEid", id = 3, type = "byte[]")
    private final zzgx zzc;

    @SafeParcelable.Field(getter = "getSessionPreKey", id = 4, type = "byte[]")
    private final zzgx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(id = 1) long j10, @SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) byte[] bArr2, @SafeParcelable.Param(id = 4) byte[] bArr3) {
        byte[] bArr4 = (byte[]) Preconditions.checkNotNull(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) Preconditions.checkNotNull(bArr2);
        zzgx zzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) Preconditions.checkNotNull(bArr3);
        zzgx zzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.zza = j10;
        this.zzb = (zzgx) Preconditions.checkNotNull(zzl);
        this.zzc = (zzgx) Preconditions.checkNotNull(zzl2);
        this.zzd = (zzgx) Preconditions.checkNotNull(zzl3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        if (this.zza != zzqVar.zza || !Objects.equal(this.zzb, zzqVar.zzb) || !Objects.equal(this.zzc, zzqVar.zzc) || !Objects.equal(this.zzd, zzqVar.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), this.zzb, this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        long j10 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, j10);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb.zzm(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc.zzm(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.zzd.zzm(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

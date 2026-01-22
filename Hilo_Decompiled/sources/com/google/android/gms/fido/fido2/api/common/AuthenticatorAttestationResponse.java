package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.common.Transport;
import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import com.google.android.gms.internal.fido.zzbi;
import com.google.android.gms.internal.fido.zzbj;
import com.google.android.gms.internal.fido.zzgf;
import com.google.android.gms.internal.fido.zzgj;
import com.google.android.gms.internal.fido.zzgx;
import com.google.android.gms.internal.fido.zzhj;
import com.google.android.gms.internal.fido.zzhm;
import com.google.android.gms.internal.fido.zzho;
import com.google.android.gms.internal.fido.zzhp;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AuthenticatorAttestationResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();

    @SafeParcelable.Field(getter = "getKeyHandle", id = 2, type = "byte[]")
    private final zzgx zza;

    @SafeParcelable.Field(getter = "getClientDataJSON", id = 3, type = "byte[]")
    private final zzgx zzb;

    @SafeParcelable.Field(getter = "getAttestationObject", id = 4, type = "byte[]")
    private final zzgx zzc;

    @SafeParcelable.Field(getter = "getTransports", id = 5)
    private final String[] zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AuthenticatorAttestationResponse(@SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) byte[] bArr2, @SafeParcelable.Param(id = 4) byte[] bArr3, @SafeParcelable.Param(id = 5) String[] strArr) {
        byte[] bArr4 = (byte[]) Preconditions.checkNotNull(bArr);
        zzgx zzgxVar = zzgx.zzb;
        zzgx zzl = zzgx.zzl(bArr4, 0, bArr4.length);
        byte[] bArr5 = (byte[]) Preconditions.checkNotNull(bArr2);
        zzgx zzl2 = zzgx.zzl(bArr5, 0, bArr5.length);
        byte[] bArr6 = (byte[]) Preconditions.checkNotNull(bArr3);
        zzgx zzl3 = zzgx.zzl(bArr6, 0, bArr6.length);
        this.zza = (zzgx) Preconditions.checkNotNull(zzl);
        this.zzb = (zzgx) Preconditions.checkNotNull(zzl2);
        this.zzc = (zzgx) Preconditions.checkNotNull(zzl3);
        this.zzd = (String[]) Preconditions.checkNotNull(strArr);
    }

    public static AuthenticatorAttestationResponse deserializeFromBytes(byte[] bArr) {
        return (AuthenticatorAttestationResponse) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        if (!Objects.equal(this.zza, authenticatorAttestationResponse.zza) || !Objects.equal(this.zzb, authenticatorAttestationResponse.zzb) || !Objects.equal(this.zzc, authenticatorAttestationResponse.zzc)) {
            return false;
        }
        return true;
    }

    public byte[] getAttestationObject() {
        return this.zzc.zzm();
    }

    public zzgx getAttestationObjectAsByteString() {
        return this.zzc;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse
    public byte[] getClientDataJSON() {
        return this.zzb.zzm();
    }

    public zzgx getClientDataJSONAsByteString() {
        return this.zzb;
    }

    @Deprecated
    public byte[] getKeyHandle() {
        return this.zza.zzm();
    }

    public zzgx getKeyHandleAsByteString() {
        return this.zza;
    }

    public String[] getTransports() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Objects.hashCode(this.zza)), Integer.valueOf(Objects.hashCode(this.zzb)), Integer.valueOf(Objects.hashCode(this.zzc)));
    }

    @Override // com.google.android.gms.fido.fido2.api.common.AuthenticatorResponse
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public String toString() {
        zzbi zza = zzbj.zza(this);
        zzgf zzf = zzgf.zzf();
        byte[] keyHandle = getKeyHandle();
        zza.zzb(SignResponseData.JSON_RESPONSE_DATA_KEY_HANDLE, zzf.zzg(keyHandle, 0, keyHandle.length));
        zzgf zzf2 = zzgf.zzf();
        byte[] clientDataJSON = getClientDataJSON();
        zza.zzb("clientDataJSON", zzf2.zzg(clientDataJSON, 0, clientDataJSON.length));
        zzgf zzf3 = zzgf.zzf();
        byte[] attestationObject = getAttestationObject();
        zza.zzb("attestationObject", zzf3.zzg(attestationObject, 0, attestationObject.length));
        zza.zzb("transports", Arrays.toString(this.zzd));
        return zza.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getKeyHandle(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getClientDataJSON(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getAttestationObject(), false);
        SafeParcelWriter.writeStringArray(parcel, 5, getTransports(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0201 A[Catch: JSONException -> 0x001c, TRY_LEAVE, TryCatch #5 {JSONException -> 0x001c, blocks: (B:3:0x0005, B:5:0x000e, B:6:0x001f, B:8:0x0023, B:9:0x0030, B:10:0x0036, B:12:0x003b, B:14:0x0049, B:16:0x0056, B:17:0x004f, B:20:0x0058, B:22:0x0061, B:24:0x0069, B:26:0x007b, B:27:0x0083, B:29:0x0087, B:31:0x0099, B:33:0x00b7, B:34:0x00cf, B:39:0x00f5, B:45:0x01ed, B:47:0x0201, B:50:0x0115, B:52:0x0127, B:57:0x013b, B:60:0x015d, B:62:0x0173, B:64:0x0179, B:65:0x0198, B:66:0x019d, B:67:0x019e, B:68:0x01a3, B:73:0x01ae, B:75:0x01be, B:77:0x01cc, B:78:0x01e1, B:79:0x01e6, B:80:0x01e7, B:81:0x01ec, B:82:0x020b, B:83:0x0210, B:86:0x0211, B:87:0x0218, B:88:0x0219, B:89:0x021e, B:93:0x0222, B:94:0x0229, B:96:0x022c, B:97:0x0233, B:99:0x0234, B:100:0x023b, B:101:0x023e, B:102:0x0245, B:104:0x0246, B:105:0x024d, B:109:0x0251, B:110:0x0258), top: B:2:0x0005, inners: #3, #4, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject zza() {
        byte[] zza;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.zzb != null) {
                jSONObject.put("clientDataJSON", Base64Utils.encodeUrlSafeNoPadding(getClientDataJSON()));
            }
            if (this.zzc != null) {
                jSONObject.put("attestationObject", Base64Utils.encodeUrlSafeNoPadding(getAttestationObject()));
            }
            JSONArray jSONArray = new JSONArray();
            int i10 = 0;
            while (true) {
                String[] strArr = this.zzd;
                if (i10 >= strArr.length) {
                    break;
                }
                if (strArr[i10].equals(Transport.HYBRID.toString())) {
                    jSONArray.put(i10, "hybrid");
                } else {
                    jSONArray.put(i10, this.zzd[i10]);
                }
                i10++;
            }
            jSONObject.put("transports", jSONArray);
            try {
                try {
                    zzhp zzhpVar = (zzhp) zzhp.zzj(getAttestationObject()).zzh().zzc().get(zzhp.zzi("authData"));
                    if (zzhpVar != null) {
                        zzgx zzc = zzhpVar.zze().zzc();
                        ByteBuffer zzi = zzc.zzi();
                        try {
                            zzi.position(zzi.position() + 32);
                            if ((zzi.get() & 64) != 0) {
                                zzi.position(zzi.position() + 4);
                                zzi.position(zzi.position() + 16);
                                zzi.position(zzi.position() + zzi.getShort());
                                try {
                                    zzhm zzh = zzhp.zzk(zzc.zzg(zzi.position(), zzc.zzd()).zzh()).zzh();
                                    zzhp zzhpVar2 = (zzhp) zzh.zzc().get(zzhp.zzg(3L));
                                    zzhp zzhpVar3 = (zzhp) zzh.zzc().get(zzhp.zzg(1L));
                                    if (zzhpVar2 != null && zzhpVar3 != null) {
                                        try {
                                            long zzc2 = zzhpVar2.zzf().zzc();
                                            long zzc3 = zzhpVar3.zzf().zzc();
                                            if (zzc3 != 1) {
                                                if (zzc3 == 2) {
                                                    zzc3 = 2;
                                                }
                                                zza = null;
                                                jSONObject.put("authenticatorData", Base64Utils.encodeUrlSafeNoPadding(zzc.zzm()));
                                                jSONObject.put("publicKeyAlgorithm", zzc2);
                                                if (zza != null) {
                                                    jSONObject.put("publicKey", Base64Utils.encodeUrlSafeNoPadding(zza));
                                                }
                                                return jSONObject;
                                            }
                                            zzhp zzhpVar4 = (zzhp) zzh.zzc().get(zzhp.zzg(-1L));
                                            if (zzhpVar4 != null) {
                                                long zzc4 = zzhpVar4.zzf().zzc();
                                                if (zzc3 == 2 && zzc4 == 1) {
                                                    zzhp zzhpVar5 = (zzhp) zzh.zzc().get(zzhp.zzg(-2L));
                                                    zzhp zzhpVar6 = (zzhp) zzh.zzc().get(zzhp.zzg(-3L));
                                                    if (zzhpVar5 != null && zzhpVar6 != null) {
                                                        zzgx zzc5 = zzhpVar5.zze().zzc();
                                                        zzgx zzc6 = zzhpVar6.zze().zzc();
                                                        if (zzc5.zzd() == 32 && zzc6.zzd() == 32) {
                                                            zza = zzgj.zza(Base64.decode("MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE", 0), zzc5.zzm(), zzc6.zzm());
                                                        } else {
                                                            throw new IllegalArgumentException("COSE coordinates are the wrong size");
                                                        }
                                                    } else {
                                                        throw new IllegalArgumentException("COSE key missing required fields");
                                                    }
                                                } else {
                                                    if (zzc3 == 1 && zzc4 == 6) {
                                                        zzhp zzhpVar7 = (zzhp) zzh.zzc().get(zzhp.zzg(-2L));
                                                        if (zzhpVar7 != null) {
                                                            zzgx zzc7 = zzhpVar7.zze().zzc();
                                                            if (zzc7.zzd() == 32) {
                                                                zza = zzgj.zza(Base64.decode("MCowBQYDK2VwAyEA", 0), zzc7.zzm());
                                                            } else {
                                                                throw new IllegalArgumentException("COSE coordinates are the wrong size");
                                                            }
                                                        } else {
                                                            throw new IllegalArgumentException("COSE key missing required fields");
                                                        }
                                                    }
                                                    zza = null;
                                                }
                                                jSONObject.put("authenticatorData", Base64Utils.encodeUrlSafeNoPadding(zzc.zzm()));
                                                jSONObject.put("publicKeyAlgorithm", zzc2);
                                                if (zza != null) {
                                                }
                                                return jSONObject;
                                            }
                                            throw new IllegalArgumentException("COSE key missing required fields");
                                        } catch (zzho e10) {
                                            throw new IllegalArgumentException("COSE key ill-formed", e10);
                                        }
                                    }
                                    throw new IllegalArgumentException("COSE key missing required fields");
                                } catch (zzhj e11) {
                                    e = e11;
                                    throw new IllegalArgumentException("failed to parse COSE key", e);
                                } catch (zzho e12) {
                                    e = e12;
                                    throw new IllegalArgumentException("failed to parse COSE key", e);
                                }
                            }
                            throw new IllegalArgumentException("authData does not include credential data");
                        } catch (IllegalArgumentException e13) {
                            throw new IllegalArgumentException("ill-formed authenticator data", e13);
                        }
                    }
                    throw new IllegalArgumentException("attestation object missing authData");
                } catch (zzho e14) {
                    throw new IllegalArgumentException("authData value has wrong type", e14);
                }
            } catch (zzhj e15) {
                e = e15;
                throw new IllegalArgumentException("failed to parse attestation object", e);
            } catch (zzho e16) {
                e = e16;
                throw new IllegalArgumentException("failed to parse attestation object", e);
            }
        } catch (JSONException e17) {
            throw new RuntimeException("Error encoding AuthenticatorAttestationResponse to JSON object", e17);
        }
    }
}

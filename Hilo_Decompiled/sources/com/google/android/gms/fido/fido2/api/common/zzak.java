package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.fido.zzfv;
import com.google.android.gms.internal.fido.zzfx;
import com.google.android.gms.internal.fido.zzgj;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "PrfExtensionCreator")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();
    private static final byte[] zza = "WebAuthn PRF\u0000".getBytes(StandardCharsets.UTF_8);

    @SafeParcelable.Field(getter = "getEvaluationPoints", id = 1)
    private final byte[][] zzb;

    @SafeParcelable.Constructor
    public zzak(@SafeParcelable.Param(id = 1) byte[][] bArr) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (bArr != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10);
        if (1 != ((bArr.length & 1) ^ 1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkArgument(z11);
        for (int i10 = 0; i10 < bArr.length; i10 += 2) {
            if (i10 == 0 || bArr[i10] != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            Preconditions.checkArgument(z12);
            int i11 = i10 + 1;
            if (bArr[i11] != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkArgument(z13);
            int length = bArr[i11].length;
            if (length == 32 || length == 64) {
                z14 = true;
            } else {
                z14 = false;
            }
            Preconditions.checkArgument(z14);
        }
        this.zzb = bArr;
    }

    public static zzak zza(JSONObject jSONObject, boolean z10) throws JSONException {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject.has("eval")) {
                arrayList.add(null);
                if (z10) {
                    arrayList.add(zzd(jSONObject.getJSONObject("eval")));
                } else {
                    arrayList.add(zze(jSONObject.getJSONObject("eval")));
                }
            }
            if (jSONObject.has("evalByCredential")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("evalByCredential");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(Base64Utils.decodeUrlSafeNoPadding(next));
                    if (z10) {
                        arrayList.add(zzd(jSONObject2.getJSONObject(next)));
                    } else {
                        arrayList.add(zze(jSONObject2.getJSONObject(next)));
                    }
                }
            }
            return new zzak((byte[][]) arrayList.toArray(new byte[0]));
        } catch (IllegalArgumentException unused) {
            throw new JSONException("invalid base64url value");
        }
    }

    private static JSONObject zzb(byte[] bArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bArr.length == 32) {
            jSONObject.put("first", Base64Utils.encodeUrlSafeNoPadding(bArr));
        } else {
            jSONObject.put("first", Base64.encodeToString(bArr, 0, 32, 11));
            jSONObject.put("second", Base64.encodeToString(bArr, 32, 32, 11));
        }
        return jSONObject;
    }

    private static byte[] zzc(byte[] bArr) {
        zzfv zza2 = zzfx.zza().zza();
        zza2.zza(zza);
        zza2.zza(bArr);
        return zza2.zzc().zzd();
    }

    private static byte[] zzd(JSONObject jSONObject) throws JSONException {
        byte[] decodeUrlSafeNoPadding = Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString("first"));
        if (decodeUrlSafeNoPadding.length == 32) {
            if (!jSONObject.has("second")) {
                return decodeUrlSafeNoPadding;
            }
            byte[] decodeUrlSafeNoPadding2 = Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString("second"));
            if (decodeUrlSafeNoPadding2.length == 32) {
                return zzgj.zza(decodeUrlSafeNoPadding, decodeUrlSafeNoPadding2);
            }
            throw new JSONException("hashed PRF value with wrong length");
        }
        throw new JSONException("hashed PRF value with wrong length");
    }

    private static byte[] zze(JSONObject jSONObject) throws JSONException {
        byte[] zzc = zzc(Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString("first")));
        if (!jSONObject.has("second")) {
            return zzc;
        }
        return zzgj.zza(zzc, zzc(Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString("second"))));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzak)) {
            return false;
        }
        return Arrays.deepEquals(this.zzb, ((zzak) obj).zzb);
    }

    public final int hashCode() {
        int i10 = 0;
        for (byte[] bArr : this.zzb) {
            if (bArr != null) {
                i10 ^= Objects.hashCode(bArr);
            }
        }
        return i10;
    }

    public final String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i10 = 0;
            JSONObject jSONObject2 = null;
            while (true) {
                byte[][] bArr = this.zzb;
                if (i10 < bArr.length) {
                    if (bArr[i10] == null) {
                        jSONObject.put("eval", zzb(bArr[i10 + 1]));
                    } else {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                            jSONObject.put("evalByCredential", jSONObject2);
                        }
                        jSONObject2.put(Base64Utils.encodeUrlSafeNoPadding(this.zzb[i10]), zzb(this.zzb[i10 + 1]));
                    }
                    i10 += 2;
                } else {
                    return "PrfExtension{" + jSONObject.toString() + "}";
                }
            }
        } catch (JSONException e10) {
            return "PrfExtension{Exception:" + e10.getMessage() + "}";
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        byte[][] bArr = this.zzb;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArrayArray(parcel, 1, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.android.gms.internal.fido.zzbl;
import com.google.android.gms.internal.fido.zzia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "PublicKeyCredentialCreationOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PublicKeyCredentialCreationOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzan();

    @SafeParcelable.Field(getter = "getRp", id = 2)
    private final PublicKeyCredentialRpEntity zza;

    @SafeParcelable.Field(getter = "getUser", id = 3)
    private final PublicKeyCredentialUserEntity zzb;

    @SafeParcelable.Field(getter = "getChallenge", id = 4)
    private final byte[] zzc;

    @SafeParcelable.Field(getter = "getParameters", id = 5)
    private final List zzd;

    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 6)
    private final Double zze;

    @SafeParcelable.Field(getter = "getExcludeList", id = 7)
    private final List zzf;

    @SafeParcelable.Field(getter = "getAuthenticatorSelection", id = 8)
    private final AuthenticatorSelectionCriteria zzg;

    @SafeParcelable.Field(getter = "getRequestId", id = 9)
    private final Integer zzh;

    @SafeParcelable.Field(getter = "getTokenBinding", id = 10)
    private final TokenBinding zzi;

    @SafeParcelable.Field(getter = "getAttestationConveyancePreferenceAsString", id = 11, type = "java.lang.String")
    private final AttestationConveyancePreference zzj;

    @SafeParcelable.Field(getter = "getAuthenticationExtensions", id = 12)
    private final AuthenticationExtensions zzk;

    @SafeParcelable.Field(getter = "getJsonString", id = 13)
    private final String zzl;

    @SafeParcelable.Field(getter = "getResultReceiver", id = 14)
    private ResultReceiver zzm;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder {
        private PublicKeyCredentialRpEntity zza;
        private PublicKeyCredentialUserEntity zzb;
        private byte[] zzc;
        private List zzd;
        private Double zze;
        private List zzf;
        private AuthenticatorSelectionCriteria zzg;
        private Integer zzh;
        private TokenBinding zzi;
        private AttestationConveyancePreference zzj;
        private AuthenticationExtensions zzk;

        public PublicKeyCredentialCreationOptions build() {
            String attestationConveyancePreference;
            PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = this.zza;
            PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
            byte[] bArr = this.zzc;
            List list = this.zzd;
            Double d10 = this.zze;
            List list2 = this.zzf;
            AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
            Integer num = this.zzh;
            TokenBinding tokenBinding = this.zzi;
            AttestationConveyancePreference attestationConveyancePreference2 = this.zzj;
            if (attestationConveyancePreference2 == null) {
                attestationConveyancePreference = null;
            } else {
                attestationConveyancePreference = attestationConveyancePreference2.toString();
            }
            return new PublicKeyCredentialCreationOptions(publicKeyCredentialRpEntity, publicKeyCredentialUserEntity, bArr, list, d10, list2, authenticatorSelectionCriteria, num, tokenBinding, attestationConveyancePreference, this.zzk, null, null);
        }

        public Builder setAttestationConveyancePreference(AttestationConveyancePreference attestationConveyancePreference) {
            this.zzj = attestationConveyancePreference;
            return this;
        }

        public Builder setAuthenticationExtensions(AuthenticationExtensions authenticationExtensions) {
            this.zzk = authenticationExtensions;
            return this;
        }

        public Builder setAuthenticatorSelection(AuthenticatorSelectionCriteria authenticatorSelectionCriteria) {
            this.zzg = authenticatorSelectionCriteria;
            return this;
        }

        public Builder setChallenge(byte[] bArr) {
            this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        public Builder setExcludeList(List<PublicKeyCredentialDescriptor> list) {
            this.zzf = list;
            return this;
        }

        public Builder setParameters(List<PublicKeyCredentialParameters> list) {
            this.zzd = (List) Preconditions.checkNotNull(list);
            return this;
        }

        public Builder setRequestId(Integer num) {
            this.zzh = num;
            return this;
        }

        public Builder setRp(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity) {
            this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
            return this;
        }

        public Builder setTimeoutSeconds(Double d10) {
            this.zze = d10;
            return this;
        }

        public Builder setTokenBinding(TokenBinding tokenBinding) {
            this.zzi = tokenBinding;
            return this;
        }

        public Builder setUser(PublicKeyCredentialUserEntity publicKeyCredentialUserEntity) {
            this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PublicKeyCredentialCreationOptions(@SafeParcelable.Param(id = 2) PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, @SafeParcelable.Param(id = 3) PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, @SafeParcelable.Param(id = 4) byte[] bArr, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) Double d10, @SafeParcelable.Param(id = 7) List list2, @SafeParcelable.Param(id = 8) AuthenticatorSelectionCriteria authenticatorSelectionCriteria, @SafeParcelable.Param(id = 9) Integer num, @SafeParcelable.Param(id = 10) TokenBinding tokenBinding, @SafeParcelable.Param(id = 11) String str, @SafeParcelable.Param(id = 12) AuthenticationExtensions authenticationExtensions, @SafeParcelable.Param(id = 13) String str2, @SafeParcelable.Param(id = 14) ResultReceiver resultReceiver) {
        this.zzm = resultReceiver;
        if (str2 != null) {
            try {
                PublicKeyCredentialCreationOptions zza = zza(new JSONObject(str2));
                this.zza = zza.zza;
                this.zzb = zza.zzb;
                this.zzc = zza.zzc;
                this.zzd = zza.zzd;
                this.zze = zza.zze;
                this.zzf = zza.zzf;
                this.zzg = zza.zzg;
                this.zzh = zza.zzh;
                this.zzi = zza.zzi;
                this.zzj = zza.zzj;
                this.zzk = zza.zzk;
                this.zzl = str2;
                return;
            } catch (JSONException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        this.zza = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
        this.zzb = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
        this.zzc = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzd = (List) Preconditions.checkNotNull(list);
        this.zze = d10;
        this.zzf = list2;
        this.zzg = authenticatorSelectionCriteria;
        this.zzh = num;
        this.zzi = tokenBinding;
        if (str != null) {
            try {
                this.zzj = AttestationConveyancePreference.fromString(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e11) {
                throw new IllegalArgumentException(e11);
            }
        } else {
            this.zzj = null;
        }
        this.zzk = authenticationExtensions;
        this.zzl = null;
    }

    public static PublicKeyCredentialCreationOptions deserializeFromBytes(byte[] bArr) {
        return (PublicKeyCredentialCreationOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public static PublicKeyCredentialCreationOptions zza(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3;
        String str4;
        Boolean bool;
        zzbl zzc;
        Builder builder = new Builder();
        JSONObject jSONObject2 = jSONObject.getJSONObject("rp");
        Parcelable.Creator<PublicKeyCredentialRpEntity> creator = PublicKeyCredentialRpEntity.CREATOR;
        String string = jSONObject2.getString("id");
        String string2 = jSONObject2.getString("name");
        String str5 = null;
        if (jSONObject2.has("icon")) {
            str = jSONObject2.optString("icon");
        } else {
            str = null;
        }
        builder.setRp(new PublicKeyCredentialRpEntity(string, string2, str));
        JSONObject jSONObject3 = jSONObject.getJSONObject("user");
        Parcelable.Creator<PublicKeyCredentialUserEntity> creator2 = PublicKeyCredentialUserEntity.CREATOR;
        byte[] decodeUrlSafeNoPadding = Base64Utils.decodeUrlSafeNoPadding(jSONObject3.getString("id"));
        String string3 = jSONObject3.getString("name");
        String optString = jSONObject3.optString("displayName");
        if (jSONObject3.has("icon")) {
            str2 = jSONObject3.optString("icon");
        } else {
            str2 = null;
        }
        builder.setUser(new PublicKeyCredentialUserEntity(decodeUrlSafeNoPadding, string3, str2, optString));
        builder.setChallenge(Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString(ClientData.KEY_CHALLENGE)));
        JSONArray jSONArray = jSONObject.getJSONArray("pubKeyCredParams");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject4 = jSONArray.getJSONObject(i10);
            try {
                zzc = zzbl.zzd(new PublicKeyCredentialParameters(jSONObject4.getString("type"), jSONObject4.getInt("alg")));
            } catch (IllegalArgumentException unused) {
                zzc = zzbl.zzc();
            }
            if (zzc.zzb()) {
                arrayList.add(zzc.zza());
            }
        }
        builder.setParameters(arrayList);
        if (jSONObject.has("timeout")) {
            builder.setTimeoutSeconds(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
        }
        if (jSONObject.has("excludeCredentials")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("excludeCredentials");
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                arrayList2.add(PublicKeyCredentialDescriptor.zza(jSONArray2.getJSONObject(i11)));
            }
            builder.setExcludeList(arrayList2);
        }
        if (jSONObject.has("authenticatorSelection")) {
            JSONObject jSONObject5 = jSONObject.getJSONObject("authenticatorSelection");
            Parcelable.Creator<AuthenticatorSelectionCriteria> creator3 = AuthenticatorSelectionCriteria.CREATOR;
            if (jSONObject5.has("authenticatorAttachment")) {
                str3 = jSONObject5.optString("authenticatorAttachment");
            } else {
                str3 = null;
            }
            if (jSONObject5.has("residentKey")) {
                str4 = jSONObject5.optString("residentKey");
            } else {
                str4 = null;
            }
            if (jSONObject5.has("requireResidentKey")) {
                bool = Boolean.valueOf(jSONObject5.optBoolean("requireResidentKey"));
            } else {
                bool = null;
            }
            if (jSONObject5.has("userVerification")) {
                str5 = jSONObject5.optString("userVerification");
            }
            builder.setAuthenticatorSelection(new AuthenticatorSelectionCriteria(str3, bool, str5, str4));
        }
        if (jSONObject.has("extensions")) {
            builder.setAuthenticationExtensions(AuthenticationExtensions.zza(jSONObject.getJSONObject("extensions")));
        }
        if (jSONObject.has("attestation")) {
            try {
                builder.setAttestationConveyancePreference(AttestationConveyancePreference.fromString(jSONObject.getString("attestation")));
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e10) {
                Log.w("PKCCreationOptions", "Invalid AttestationConveyancePreference", e10);
                builder.setAttestationConveyancePreference(AttestationConveyancePreference.NONE);
            }
        }
        return builder.build();
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        if (!Objects.equal(this.zza, publicKeyCredentialCreationOptions.zza) || !Objects.equal(this.zzb, publicKeyCredentialCreationOptions.zzb) || !Arrays.equals(this.zzc, publicKeyCredentialCreationOptions.zzc) || !Objects.equal(this.zze, publicKeyCredentialCreationOptions.zze) || !this.zzd.containsAll(publicKeyCredentialCreationOptions.zzd) || !publicKeyCredentialCreationOptions.zzd.containsAll(this.zzd) || ((((list = this.zzf) != null || publicKeyCredentialCreationOptions.zzf != null) && (list == null || (list2 = publicKeyCredentialCreationOptions.zzf) == null || !list.containsAll(list2) || !publicKeyCredentialCreationOptions.zzf.containsAll(this.zzf))) || !Objects.equal(this.zzg, publicKeyCredentialCreationOptions.zzg) || !Objects.equal(this.zzh, publicKeyCredentialCreationOptions.zzh) || !Objects.equal(this.zzi, publicKeyCredentialCreationOptions.zzi) || !Objects.equal(this.zzj, publicKeyCredentialCreationOptions.zzj) || !Objects.equal(this.zzk, publicKeyCredentialCreationOptions.zzk) || !Objects.equal(this.zzl, publicKeyCredentialCreationOptions.zzl))) {
            return false;
        }
        return true;
    }

    public AttestationConveyancePreference getAttestationConveyancePreference() {
        return this.zzj;
    }

    public String getAttestationConveyancePreferenceAsString() {
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzk;
    }

    public AuthenticatorSelectionCriteria getAuthenticatorSelection() {
        return this.zzg;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] getChallenge() {
        return this.zzc;
    }

    public List<PublicKeyCredentialDescriptor> getExcludeList() {
        return this.zzf;
    }

    public String getJsonString() {
        return this.zzl;
    }

    public List<PublicKeyCredentialParameters> getParameters() {
        return this.zzd;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Integer getRequestId() {
        return this.zzh;
    }

    public PublicKeyCredentialRpEntity getRp() {
        return this.zza;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Double getTimeoutSeconds() {
        return this.zze;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public TokenBinding getTokenBinding() {
        return this.zzi;
    }

    public PublicKeyCredentialUserEntity getUser() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] serializeToBytes() {
        if (zzia.zzd()) {
            Builder builder = new Builder();
            builder.setRp(this.zza);
            builder.setUser(this.zzb);
            builder.setChallenge(this.zzc);
            builder.setParameters(this.zzd);
            builder.setTimeoutSeconds(this.zze);
            builder.setExcludeList(this.zzf);
            builder.setAuthenticatorSelection(this.zzg);
            builder.setRequestId(this.zzh);
            builder.setTokenBinding(this.zzi);
            builder.setAttestationConveyancePreference(this.zzj);
            builder.setAuthenticationExtensions(this.zzk);
            return SafeParcelableSerializer.serializeToBytes(builder.build());
        }
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public final String toString() {
        AuthenticationExtensions authenticationExtensions = this.zzk;
        AttestationConveyancePreference attestationConveyancePreference = this.zzj;
        TokenBinding tokenBinding = this.zzi;
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = this.zzg;
        List list = this.zzf;
        List list2 = this.zzd;
        byte[] bArr = this.zzc;
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = this.zzb;
        return "PublicKeyCredentialCreationOptions{\n rp=" + String.valueOf(this.zza) + ", \n user=" + String.valueOf(publicKeyCredentialUserEntity) + ", \n challenge=" + Base64Utils.encodeUrlSafeNoPadding(bArr) + ", \n parameters=" + String.valueOf(list2) + ", \n timeoutSeconds=" + this.zze + ", \n excludeList=" + String.valueOf(list) + ", \n authenticatorSelection=" + String.valueOf(authenticatorSelectionCriteria) + ", \n requestId=" + this.zzh + ", \n tokenBinding=" + String.valueOf(tokenBinding) + ", \n attestationConveyancePreference=" + String.valueOf(attestationConveyancePreference) + ", \n authenticationExtensions=" + String.valueOf(authenticationExtensions) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getRp(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getUser(), i10, false);
        SafeParcelWriter.writeByteArray(parcel, 4, getChallenge(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getParameters(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 6, getTimeoutSeconds(), false);
        SafeParcelWriter.writeTypedList(parcel, 7, getExcludeList(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getAuthenticatorSelection(), i10, false);
        SafeParcelWriter.writeIntegerObject(parcel, 9, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 10, getTokenBinding(), i10, false);
        SafeParcelWriter.writeString(parcel, 11, getAttestationConveyancePreferenceAsString(), false);
        SafeParcelWriter.writeParcelable(parcel, 12, getAuthenticationExtensions(), i10, false);
        SafeParcelWriter.writeString(parcel, 13, getJsonString(), false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public PublicKeyCredentialCreationOptions(String str) {
        try {
            PublicKeyCredentialCreationOptions zza = zza(new JSONObject(str));
            this.zza = zza.zza;
            this.zzb = zza.zzb;
            this.zzc = zza.zzc;
            this.zzd = zza.zzd;
            this.zze = zza.zze;
            this.zzf = zza.zzf;
            this.zzg = zza.zzg;
            this.zzh = zza.zzh;
            this.zzi = zza.zzi;
            this.zzj = zza.zzj;
            this.zzk = zza.zzk;
            this.zzl = str;
        } catch (JSONException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}

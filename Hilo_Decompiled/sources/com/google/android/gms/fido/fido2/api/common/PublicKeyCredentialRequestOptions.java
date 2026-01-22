package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.google.android.gms.internal.fido.zzia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "PublicKeyCredentialRequestOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PublicKeyCredentialRequestOptions extends RequestOptions {
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new zzar();

    @SafeParcelable.Field(getter = "getChallenge", id = 2)
    private final byte[] zza;

    @SafeParcelable.Field(getter = "getTimeoutSeconds", id = 3)
    private final Double zzb;

    @SafeParcelable.Field(getter = "getRpId", id = 4)
    private final String zzc;

    @SafeParcelable.Field(getter = "getAllowList", id = 5)
    private final List zzd;

    @SafeParcelable.Field(getter = "getRequestId", id = 6)
    private final Integer zze;

    @SafeParcelable.Field(getter = "getTokenBinding", id = 7)
    private final TokenBinding zzf;

    @SafeParcelable.Field(getter = "getUserVerificationAsString", id = 8, type = "java.lang.String")
    private final UserVerificationRequirement zzg;

    @SafeParcelable.Field(getter = "getAuthenticationExtensions", id = 9)
    private final AuthenticationExtensions zzh;

    @SafeParcelable.Field(getter = "getLongRequestId", id = 10)
    private final Long zzi;

    @SafeParcelable.Field(getter = "getResultReceiver", id = 12)
    private ResultReceiver zzj;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder {
        private byte[] zza;
        private Double zzb;
        private String zzc;
        private List zzd;
        private Integer zze;
        private TokenBinding zzf;
        private UserVerificationRequirement zzg;
        private AuthenticationExtensions zzh;
        private Long zzi;
        private ResultReceiver zzj;

        public Builder() {
        }

        public PublicKeyCredentialRequestOptions build() {
            String userVerificationRequirement;
            byte[] bArr = this.zza;
            Double d10 = this.zzb;
            String str = this.zzc;
            List list = this.zzd;
            Integer num = this.zze;
            TokenBinding tokenBinding = this.zzf;
            UserVerificationRequirement userVerificationRequirement2 = this.zzg;
            if (userVerificationRequirement2 == null) {
                userVerificationRequirement = null;
            } else {
                userVerificationRequirement = userVerificationRequirement2.toString();
            }
            return new PublicKeyCredentialRequestOptions(bArr, d10, str, list, num, tokenBinding, userVerificationRequirement, this.zzh, this.zzi, null, this.zzj);
        }

        public Builder setAllowList(List<PublicKeyCredentialDescriptor> list) {
            this.zzd = list;
            return this;
        }

        public Builder setAuthenticationExtensions(AuthenticationExtensions authenticationExtensions) {
            this.zzh = authenticationExtensions;
            return this;
        }

        public Builder setChallenge(byte[] bArr) {
            this.zza = (byte[]) Preconditions.checkNotNull(bArr);
            return this;
        }

        public Builder setRequestId(Integer num) {
            this.zze = num;
            return this;
        }

        public Builder setRpId(String str) {
            this.zzc = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public Builder setTimeoutSeconds(Double d10) {
            this.zzb = d10;
            return this;
        }

        public Builder setTokenBinding(TokenBinding tokenBinding) {
            this.zzf = tokenBinding;
            return this;
        }

        public final Builder zza(Long l10) {
            this.zzi = l10;
            return this;
        }

        public final Builder zzb(ResultReceiver resultReceiver) {
            this.zzj = null;
            return this;
        }

        public final Builder zzc(UserVerificationRequirement userVerificationRequirement) {
            this.zzg = userVerificationRequirement;
            return this;
        }

        public Builder(PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
            if (publicKeyCredentialRequestOptions != null) {
                this.zza = publicKeyCredentialRequestOptions.getChallenge();
                this.zzb = publicKeyCredentialRequestOptions.getTimeoutSeconds();
                this.zzc = publicKeyCredentialRequestOptions.getRpId();
                this.zzd = publicKeyCredentialRequestOptions.getAllowList();
                this.zze = publicKeyCredentialRequestOptions.getRequestId();
                this.zzf = publicKeyCredentialRequestOptions.getTokenBinding();
                this.zzg = publicKeyCredentialRequestOptions.zzb();
                this.zzh = publicKeyCredentialRequestOptions.getAuthenticationExtensions();
                this.zzi = publicKeyCredentialRequestOptions.zzc();
                this.zzj = publicKeyCredentialRequestOptions.zza();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PublicKeyCredentialRequestOptions(@SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) Double d10, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) Integer num, @SafeParcelable.Param(id = 7) TokenBinding tokenBinding, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) AuthenticationExtensions authenticationExtensions, @SafeParcelable.Param(id = 10) Long l10, @SafeParcelable.Param(id = 11) String str3, @SafeParcelable.Param(id = 12) ResultReceiver resultReceiver) {
        JSONArray jSONArray;
        this.zzj = resultReceiver;
        if (str3 != null && zzia.zzc()) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                Builder builder = new Builder();
                builder.setChallenge(Base64Utils.decodeUrlSafeNoPadding(jSONObject.getString(ClientData.KEY_CHALLENGE)));
                if (jSONObject.has("timeout")) {
                    builder.setTimeoutSeconds(Double.valueOf(jSONObject.getDouble("timeout") / 1000.0d));
                } else if (jSONObject.has("timeoutSeconds")) {
                    builder.setTimeoutSeconds(Double.valueOf(jSONObject.getDouble("timeoutSeconds")));
                }
                builder.setRpId(jSONObject.getString("rpId"));
                if (jSONObject.has("allowList")) {
                    jSONArray = jSONObject.getJSONArray("allowList");
                } else {
                    jSONArray = jSONObject.has("allowCredentials") ? jSONObject.getJSONArray("allowCredentials") : null;
                }
                if (jSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        arrayList.add(PublicKeyCredentialDescriptor.zza(jSONArray.getJSONObject(i10)));
                    }
                    builder.setAllowList(arrayList);
                }
                if (jSONObject.has("requestId")) {
                    builder.setRequestId(Integer.valueOf(jSONObject.getInt("requestId")));
                }
                if (jSONObject.has("tokenBinding")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("tokenBinding");
                    builder.setTokenBinding(new TokenBinding(jSONObject2.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS), jSONObject2.has("id") ? jSONObject2.getString("id") : null));
                }
                if (jSONObject.has("userVerification")) {
                    builder.zzc(UserVerificationRequirement.fromString(jSONObject.getString("userVerification")));
                }
                if (jSONObject.has("authenticationExtensions")) {
                    builder.setAuthenticationExtensions(AuthenticationExtensions.zza(jSONObject.getJSONObject("authenticationExtensions")));
                } else if (jSONObject.has("extensions")) {
                    builder.setAuthenticationExtensions(AuthenticationExtensions.zza(jSONObject.getJSONObject("extensions")));
                }
                if (jSONObject.has("longRequestId")) {
                    builder.zza(Long.valueOf(jSONObject.getLong("longRequestId")));
                }
                PublicKeyCredentialRequestOptions build = builder.build();
                this.zza = build.zza;
                this.zzb = build.zzb;
                this.zzc = build.zzc;
                this.zzd = build.zzd;
                this.zze = build.zze;
                this.zzf = build.zzf;
                this.zzg = build.zzg;
                this.zzh = build.zzh;
                this.zzi = build.zzi;
                return;
            } catch (zzbc e10) {
                e = e10;
                throw new IllegalArgumentException(e);
            } catch (JSONException e11) {
                e = e11;
                throw new IllegalArgumentException(e);
            }
        }
        this.zza = (byte[]) Preconditions.checkNotNull(bArr);
        this.zzb = d10;
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = list;
        this.zze = num;
        this.zzf = tokenBinding;
        this.zzi = l10;
        if (str2 != null) {
            try {
                this.zzg = UserVerificationRequirement.fromString(str2);
            } catch (zzbc e12) {
                throw new IllegalArgumentException(e12);
            }
        } else {
            this.zzg = null;
        }
        this.zzh = authenticationExtensions;
    }

    public static PublicKeyCredentialRequestOptions deserializeFromBytes(byte[] bArr) {
        return (PublicKeyCredentialRequestOptions) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialRequestOptions)) {
            return false;
        }
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
        if (!Arrays.equals(this.zza, publicKeyCredentialRequestOptions.zza) || !Objects.equal(this.zzb, publicKeyCredentialRequestOptions.zzb) || !Objects.equal(this.zzc, publicKeyCredentialRequestOptions.zzc) || ((((list = this.zzd) != null || publicKeyCredentialRequestOptions.zzd != null) && (list == null || (list2 = publicKeyCredentialRequestOptions.zzd) == null || !list.containsAll(list2) || !publicKeyCredentialRequestOptions.zzd.containsAll(this.zzd))) || !Objects.equal(this.zze, publicKeyCredentialRequestOptions.zze) || !Objects.equal(this.zzf, publicKeyCredentialRequestOptions.zzf) || !Objects.equal(this.zzg, publicKeyCredentialRequestOptions.zzg) || !Objects.equal(this.zzh, publicKeyCredentialRequestOptions.zzh) || !Objects.equal(this.zzi, publicKeyCredentialRequestOptions.zzi))) {
            return false;
        }
        return true;
    }

    public List<PublicKeyCredentialDescriptor> getAllowList() {
        return this.zzd;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zzh;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] getChallenge() {
        return this.zza;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Integer getRequestId() {
        return this.zze;
    }

    public String getRpId() {
        return this.zzc;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public TokenBinding getTokenBinding() {
        return this.zzf;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @Override // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] serializeToBytes() {
        if (zzia.zzd()) {
            Builder builder = new Builder(this);
            builder.zzb(null);
            return SafeParcelableSerializer.serializeToBytes(builder.build());
        }
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public final String toString() {
        AuthenticationExtensions authenticationExtensions = this.zzh;
        UserVerificationRequirement userVerificationRequirement = this.zzg;
        TokenBinding tokenBinding = this.zzf;
        List list = this.zzd;
        return "PublicKeyCredentialRequestOptions{\n challenge=" + Base64Utils.encodeUrlSafeNoPadding(this.zza) + ", \n timeoutSeconds=" + this.zzb + ", \n rpId='" + this.zzc + "', \n allowList=" + String.valueOf(list) + ", \n requestId=" + this.zze + ", \n tokenBinding=" + String.valueOf(tokenBinding) + ", \n userVerification=" + String.valueOf(userVerificationRequirement) + ", \n authenticationExtensions=" + String.valueOf(authenticationExtensions) + ", \n longRequestId=" + this.zzi + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        String userVerificationRequirement;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, getChallenge(), false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeString(parcel, 4, getRpId(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getAllowList(), false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, getRequestId(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getTokenBinding(), i10, false);
        UserVerificationRequirement userVerificationRequirement2 = this.zzg;
        if (userVerificationRequirement2 == null) {
            userVerificationRequirement = null;
        } else {
            userVerificationRequirement = userVerificationRequirement2.toString();
        }
        SafeParcelWriter.writeString(parcel, 8, userVerificationRequirement, false);
        SafeParcelWriter.writeParcelable(parcel, 9, getAuthenticationExtensions(), i10, false);
        SafeParcelWriter.writeLongObject(parcel, 10, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 11, null, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzj, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ResultReceiver zza() {
        return this.zzj;
    }

    public final UserVerificationRequirement zzb() {
        return this.zzg;
    }

    public final Long zzc() {
        return this.zzi;
    }
}

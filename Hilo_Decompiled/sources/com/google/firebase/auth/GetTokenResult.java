package com.google.firebase.auth;

import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class GetTokenResult {
    private String zza;
    private Map<String, Object> zzb;

    @KeepForSdk
    public GetTokenResult(String str, Map<String, Object> map) {
        this.zza = str;
        this.zzb = map;
    }

    private final long zza(String str) {
        Integer num = (Integer) this.zzb.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }

    public long getAuthTimestamp() {
        return zza("auth_time");
    }

    public Map<String, Object> getClaims() {
        return this.zzb;
    }

    public long getExpirationTimestamp() {
        return zza(AuthenticationTokenClaims.JSON_KEY_EXP);
    }

    public long getIssuedAtTimestamp() {
        return zza(AuthenticationTokenClaims.JSON_KEY_IAT);
    }

    public String getSignInProvider() {
        Map map = (Map) this.zzb.get(RemoteConfigComponent.DEFAULT_NAMESPACE);
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    @KeepForSdk
    public String getSignInSecondFactor() {
        Map map = (Map) this.zzb.get(RemoteConfigComponent.DEFAULT_NAMESPACE);
        if (map != null) {
            return (String) map.get("sign_in_second_factor");
        }
        return null;
    }

    public String getToken() {
        return this.zza;
    }
}

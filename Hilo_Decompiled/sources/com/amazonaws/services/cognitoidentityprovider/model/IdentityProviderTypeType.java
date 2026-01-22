package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum IdentityProviderTypeType {
    SAML("SAML"),
    Facebook("Facebook"),
    Google("Google"),
    LoginWithAmazon("LoginWithAmazon"),
    SignInWithApple("SignInWithApple"),
    OIDC("OIDC");

    private static final Map<String, IdentityProviderTypeType> enumMap;
    private String value;

    static {
        IdentityProviderTypeType identityProviderTypeType = SAML;
        IdentityProviderTypeType identityProviderTypeType2 = Facebook;
        IdentityProviderTypeType identityProviderTypeType3 = Google;
        IdentityProviderTypeType identityProviderTypeType4 = LoginWithAmazon;
        IdentityProviderTypeType identityProviderTypeType5 = SignInWithApple;
        IdentityProviderTypeType identityProviderTypeType6 = OIDC;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SAML", identityProviderTypeType);
        hashMap.put("Facebook", identityProviderTypeType2);
        hashMap.put("Google", identityProviderTypeType3);
        hashMap.put("LoginWithAmazon", identityProviderTypeType4);
        hashMap.put("SignInWithApple", identityProviderTypeType5);
        hashMap.put("OIDC", identityProviderTypeType6);
    }

    IdentityProviderTypeType(String str) {
        this.value = str;
    }

    public static IdentityProviderTypeType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, IdentityProviderTypeType> map = enumMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
        throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}

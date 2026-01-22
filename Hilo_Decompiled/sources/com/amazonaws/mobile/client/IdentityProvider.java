package com.amazonaws.mobile.client;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum IdentityProvider {
    AMAZON("www.amazon.com"),
    FACEBOOK("graph.facebook.com"),
    GOOGLE("accounts.google.com"),
    TWITTER("api.twitter.com"),
    DEVELOPER("cognito-identity.amazonaws.com");

    private final String key;

    IdentityProvider(String str) {
        this.key = str;
    }

    public boolean equals(String str) {
        return this.key.equals(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.key;
    }
}

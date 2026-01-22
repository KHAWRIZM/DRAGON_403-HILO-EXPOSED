package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Credentials implements Serializable {
    private String accessKeyId;
    private Date expiration;
    private String secretAccessKey;
    private String sessionToken;

    public Credentials() {
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        if (credentials.getAccessKeyId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAccessKeyId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (credentials.getAccessKeyId() != null && !credentials.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if (credentials.getSecretAccessKey() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSecretAccessKey() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (credentials.getSecretAccessKey() != null && !credentials.getSecretAccessKey().equals(getSecretAccessKey())) {
            return false;
        }
        if (credentials.getSessionToken() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSessionToken() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (credentials.getSessionToken() != null && !credentials.getSessionToken().equals(getSessionToken())) {
            return false;
        }
        if (credentials.getExpiration() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getExpiration() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (credentials.getExpiration() == null || credentials.getExpiration().equals(getExpiration())) {
            return true;
        }
        return false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getAccessKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSecretAccessKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSecretAccessKey().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSessionToken() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSessionToken().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getExpiration() != null) {
            i10 = getExpiration().hashCode();
        }
        return i13 + i10;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessKeyId() != null) {
            sb.append("AccessKeyId: " + getAccessKeyId() + ",");
        }
        if (getSecretAccessKey() != null) {
            sb.append("SecretAccessKey: " + getSecretAccessKey() + ",");
        }
        if (getSessionToken() != null) {
            sb.append("SessionToken: " + getSessionToken() + ",");
        }
        if (getExpiration() != null) {
            sb.append("Expiration: " + getExpiration());
        }
        sb.append("}");
        return sb.toString();
    }

    public Credentials withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public Credentials withExpiration(Date date) {
        this.expiration = date;
        return this;
    }

    public Credentials withSecretAccessKey(String str) {
        this.secretAccessKey = str;
        return this;
    }

    public Credentials withSessionToken(String str) {
        this.sessionToken = str;
        return this;
    }

    public Credentials(String str, String str2, String str3, Date date) {
        setAccessKeyId(str);
        setSecretAccessKey(str2);
        setSessionToken(str3);
        setExpiration(date);
    }
}

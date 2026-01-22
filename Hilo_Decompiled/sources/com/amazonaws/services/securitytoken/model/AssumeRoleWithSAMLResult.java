package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AssumeRoleWithSAMLResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private String audience;
    private Credentials credentials;
    private String issuer;
    private String nameQualifier;
    private Integer packedPolicySize;
    private String subject;
    private String subjectType;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithSAMLResult)) {
            return false;
        }
        AssumeRoleWithSAMLResult assumeRoleWithSAMLResult = (AssumeRoleWithSAMLResult) obj;
        if (assumeRoleWithSAMLResult.getCredentials() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCredentials() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getCredentials() != null && !assumeRoleWithSAMLResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAssumedRoleUser() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAssumedRoleUser() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAssumedRoleUser() != null && !assumeRoleWithSAMLResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getPackedPolicySize() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getPackedPolicySize() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getPackedPolicySize() != null && !assumeRoleWithSAMLResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubject() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getSubject() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubject() != null && !assumeRoleWithSAMLResult.getSubject().equals(getSubject())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubjectType() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getSubjectType() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubjectType() != null && !assumeRoleWithSAMLResult.getSubjectType().equals(getSubjectType())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getIssuer() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getIssuer() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getIssuer() != null && !assumeRoleWithSAMLResult.getIssuer().equals(getIssuer())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAudience() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getAudience() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAudience() != null && !assumeRoleWithSAMLResult.getAudience().equals(getAudience())) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getNameQualifier() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getNameQualifier() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getNameQualifier() == null || assumeRoleWithSAMLResult.getNameQualifier().equals(getNameQualifier())) {
            return true;
        }
        return false;
    }

    public AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public String getAudience() {
        return this.audience;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getNameQualifier() {
        return this.nameQualifier;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getSubjectType() {
        return this.subjectType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int i10 = 0;
        if (getCredentials() == null) {
            hashCode = 0;
        } else {
            hashCode = getCredentials().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAssumedRoleUser() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAssumedRoleUser().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getPackedPolicySize() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPackedPolicySize().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getSubject() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getSubject().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getSubjectType() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getSubjectType().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getIssuer() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getIssuer().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getAudience() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getAudience().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getNameQualifier() != null) {
            i10 = getNameQualifier().hashCode();
        }
        return i17 + i10;
    }

    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
    }

    public void setAudience(String str) {
        this.audience = str;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setNameQualifier(String str) {
        this.nameQualifier = str;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setSubjectType(String str) {
        this.subjectType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getAssumedRoleUser() != null) {
            sb.append("AssumedRoleUser: " + getAssumedRoleUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize() + ",");
        }
        if (getSubject() != null) {
            sb.append("Subject: " + getSubject() + ",");
        }
        if (getSubjectType() != null) {
            sb.append("SubjectType: " + getSubjectType() + ",");
        }
        if (getIssuer() != null) {
            sb.append("Issuer: " + getIssuer() + ",");
        }
        if (getAudience() != null) {
            sb.append("Audience: " + getAudience() + ",");
        }
        if (getNameQualifier() != null) {
            sb.append("NameQualifier: " + getNameQualifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleWithSAMLResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
        this.assumedRoleUser = assumedRoleUser;
        return this;
    }

    public AssumeRoleWithSAMLResult withAudience(String str) {
        this.audience = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    public AssumeRoleWithSAMLResult withIssuer(String str) {
        this.issuer = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withNameQualifier(String str) {
        this.nameQualifier = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public AssumeRoleWithSAMLResult withSubject(String str) {
        this.subject = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withSubjectType(String str) {
        this.subjectType = str;
        return this;
    }
}

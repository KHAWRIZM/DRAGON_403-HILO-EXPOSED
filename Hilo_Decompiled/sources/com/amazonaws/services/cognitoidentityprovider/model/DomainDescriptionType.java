package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DomainDescriptionType implements Serializable {
    private String aWSAccountId;
    private String cloudFrontDistribution;
    private CustomDomainConfigType customDomainConfig;
    private String domain;
    private String s3Bucket;
    private String status;
    private String userPoolId;
    private String version;

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
        if (obj == null || !(obj instanceof DomainDescriptionType)) {
            return false;
        }
        DomainDescriptionType domainDescriptionType = (DomainDescriptionType) obj;
        if (domainDescriptionType.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (domainDescriptionType.getUserPoolId() != null && !domainDescriptionType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (domainDescriptionType.getAWSAccountId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAWSAccountId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (domainDescriptionType.getAWSAccountId() != null && !domainDescriptionType.getAWSAccountId().equals(getAWSAccountId())) {
            return false;
        }
        if (domainDescriptionType.getDomain() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDomain() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (domainDescriptionType.getDomain() != null && !domainDescriptionType.getDomain().equals(getDomain())) {
            return false;
        }
        if (domainDescriptionType.getS3Bucket() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getS3Bucket() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (domainDescriptionType.getS3Bucket() != null && !domainDescriptionType.getS3Bucket().equals(getS3Bucket())) {
            return false;
        }
        if (domainDescriptionType.getCloudFrontDistribution() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getCloudFrontDistribution() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (domainDescriptionType.getCloudFrontDistribution() != null && !domainDescriptionType.getCloudFrontDistribution().equals(getCloudFrontDistribution())) {
            return false;
        }
        if (domainDescriptionType.getVersion() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getVersion() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (domainDescriptionType.getVersion() != null && !domainDescriptionType.getVersion().equals(getVersion())) {
            return false;
        }
        if (domainDescriptionType.getStatus() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getStatus() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (domainDescriptionType.getStatus() != null && !domainDescriptionType.getStatus().equals(getStatus())) {
            return false;
        }
        if (domainDescriptionType.getCustomDomainConfig() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getCustomDomainConfig() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (domainDescriptionType.getCustomDomainConfig() == null || domainDescriptionType.getCustomDomainConfig().equals(getCustomDomainConfig())) {
            return true;
        }
        return false;
    }

    public String getAWSAccountId() {
        return this.aWSAccountId;
    }

    public String getCloudFrontDistribution() {
        return this.cloudFrontDistribution;
    }

    public CustomDomainConfigType getCustomDomainConfig() {
        return this.customDomainConfig;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getS3Bucket() {
        return this.s3Bucket;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getVersion() {
        return this.version;
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
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAWSAccountId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAWSAccountId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDomain() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDomain().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getS3Bucket() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getS3Bucket().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getCloudFrontDistribution() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getCloudFrontDistribution().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getVersion() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getVersion().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getStatus() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getStatus().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getCustomDomainConfig() != null) {
            i10 = getCustomDomainConfig().hashCode();
        }
        return i17 + i10;
    }

    public void setAWSAccountId(String str) {
        this.aWSAccountId = str;
    }

    public void setCloudFrontDistribution(String str) {
        this.cloudFrontDistribution = str;
    }

    public void setCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setS3Bucket(String str) {
        this.s3Bucket = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getAWSAccountId() != null) {
            sb.append("AWSAccountId: " + getAWSAccountId() + ",");
        }
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getS3Bucket() != null) {
            sb.append("S3Bucket: " + getS3Bucket() + ",");
        }
        if (getCloudFrontDistribution() != null) {
            sb.append("CloudFrontDistribution: " + getCloudFrontDistribution() + ",");
        }
        if (getVersion() != null) {
            sb.append("Version: " + getVersion() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getCustomDomainConfig() != null) {
            sb.append("CustomDomainConfig: " + getCustomDomainConfig());
        }
        sb.append("}");
        return sb.toString();
    }

    public DomainDescriptionType withAWSAccountId(String str) {
        this.aWSAccountId = str;
        return this;
    }

    public DomainDescriptionType withCloudFrontDistribution(String str) {
        this.cloudFrontDistribution = str;
        return this;
    }

    public DomainDescriptionType withCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
        return this;
    }

    public DomainDescriptionType withDomain(String str) {
        this.domain = str;
        return this;
    }

    public DomainDescriptionType withS3Bucket(String str) {
        this.s3Bucket = str;
        return this;
    }

    public DomainDescriptionType withStatus(String str) {
        this.status = str;
        return this;
    }

    public DomainDescriptionType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public DomainDescriptionType withVersion(String str) {
        this.version = str;
        return this;
    }

    public void setStatus(DomainStatusType domainStatusType) {
        this.status = domainStatusType.toString();
    }

    public DomainDescriptionType withStatus(DomainStatusType domainStatusType) {
        this.status = domainStatusType.toString();
        return this;
    }
}

package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class LookupDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String developerUserIdentifier;
    private String identityId;
    private String identityPoolId;
    private Integer maxResults;
    private String nextToken;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LookupDeveloperIdentityRequest)) {
            return false;
        }
        LookupDeveloperIdentityRequest lookupDeveloperIdentityRequest = (LookupDeveloperIdentityRequest) obj;
        if (lookupDeveloperIdentityRequest.getIdentityPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getIdentityPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getIdentityPoolId() != null && !lookupDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getIdentityId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getIdentityId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getIdentityId() != null && !lookupDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getDeveloperUserIdentifier() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeveloperUserIdentifier() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getDeveloperUserIdentifier() != null && !lookupDeveloperIdentityRequest.getDeveloperUserIdentifier().equals(getDeveloperUserIdentifier())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getMaxResults() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getMaxResults() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getMaxResults() != null && !lookupDeveloperIdentityRequest.getMaxResults().equals(getMaxResults())) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getNextToken() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getNextToken() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (lookupDeveloperIdentityRequest.getNextToken() == null || lookupDeveloperIdentityRequest.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getDeveloperUserIdentifier() {
        return this.developerUserIdentifier;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Integer getMaxResults() {
        return this.maxResults;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getIdentityId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentityId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDeveloperUserIdentifier() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeveloperUserIdentifier().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getMaxResults() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getMaxResults().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i14 + i10;
    }

    public void setDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setMaxResults(Integer num) {
        this.maxResults = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getDeveloperUserIdentifier() != null) {
            sb.append("DeveloperUserIdentifier: " + getDeveloperUserIdentifier() + ",");
        }
        if (getMaxResults() != null) {
            sb.append("MaxResults: " + getMaxResults() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public LookupDeveloperIdentityRequest withDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
        return this;
    }

    public LookupDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public LookupDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public LookupDeveloperIdentityRequest withMaxResults(Integer num) {
        this.maxResults = num;
        return this;
    }

    public LookupDeveloperIdentityRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}

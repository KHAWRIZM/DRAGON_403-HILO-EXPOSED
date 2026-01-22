package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UnlinkDeveloperIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String developerProviderName;
    private String developerUserIdentifier;
    private String identityId;
    private String identityPoolId;

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
        if (obj == null || !(obj instanceof UnlinkDeveloperIdentityRequest)) {
            return false;
        }
        UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest = (UnlinkDeveloperIdentityRequest) obj;
        if (unlinkDeveloperIdentityRequest.getIdentityId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getIdentityId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityId() != null && !unlinkDeveloperIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityPoolId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getIdentityPoolId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getIdentityPoolId() != null && !unlinkDeveloperIdentityRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperProviderName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeveloperProviderName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperProviderName() != null && !unlinkDeveloperIdentityRequest.getDeveloperProviderName().equals(getDeveloperProviderName())) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getDeveloperUserIdentifier() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier() == null || unlinkDeveloperIdentityRequest.getDeveloperUserIdentifier().equals(getDeveloperUserIdentifier())) {
            return true;
        }
        return false;
    }

    public String getDeveloperProviderName() {
        return this.developerProviderName;
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

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getIdentityPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getIdentityPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDeveloperProviderName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeveloperProviderName().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getDeveloperUserIdentifier() != null) {
            i10 = getDeveloperUserIdentifier().hashCode();
        }
        return i13 + i10;
    }

    public void setDeveloperProviderName(String str) {
        this.developerProviderName = str;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getDeveloperProviderName() != null) {
            sb.append("DeveloperProviderName: " + getDeveloperProviderName() + ",");
        }
        if (getDeveloperUserIdentifier() != null) {
            sb.append("DeveloperUserIdentifier: " + getDeveloperUserIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public UnlinkDeveloperIdentityRequest withDeveloperProviderName(String str) {
        this.developerProviderName = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withDeveloperUserIdentifier(String str) {
        this.developerUserIdentifier = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public UnlinkDeveloperIdentityRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }
}

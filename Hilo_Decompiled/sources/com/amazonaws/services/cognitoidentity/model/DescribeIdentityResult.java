package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeIdentityResult implements Serializable {
    private Date creationDate;
    private String identityId;
    private Date lastModifiedDate;
    private List<String> logins;

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
        if (obj == null || !(obj instanceof DescribeIdentityResult)) {
            return false;
        }
        DescribeIdentityResult describeIdentityResult = (DescribeIdentityResult) obj;
        if (describeIdentityResult.getIdentityId() == null) {
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
        if (describeIdentityResult.getIdentityId() != null && !describeIdentityResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (describeIdentityResult.getLogins() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getLogins() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (describeIdentityResult.getLogins() != null && !describeIdentityResult.getLogins().equals(getLogins())) {
            return false;
        }
        if (describeIdentityResult.getCreationDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCreationDate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (describeIdentityResult.getCreationDate() != null && !describeIdentityResult.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (describeIdentityResult.getLastModifiedDate() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getLastModifiedDate() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (describeIdentityResult.getLastModifiedDate() == null || describeIdentityResult.getLastModifiedDate().equals(getLastModifiedDate())) {
            return true;
        }
        return false;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public List<String> getLogins() {
        return this.logins;
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
        if (getLogins() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getLogins().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCreationDate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCreationDate().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getLastModifiedDate() != null) {
            i10 = getLastModifiedDate().hashCode();
        }
        return i13 + i10;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setLogins(Collection<String> collection) {
        if (collection == null) {
            this.logins = null;
        } else {
            this.logins = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeIdentityResult withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public DescribeIdentityResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public DescribeIdentityResult withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public DescribeIdentityResult withLogins(String... strArr) {
        if (getLogins() == null) {
            this.logins = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.logins.add(str);
        }
        return this;
    }

    public DescribeIdentityResult withLogins(Collection<String> collection) {
        setLogins(collection);
        return this;
    }
}

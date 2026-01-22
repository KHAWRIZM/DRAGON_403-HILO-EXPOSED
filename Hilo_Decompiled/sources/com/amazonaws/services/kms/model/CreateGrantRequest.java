package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private GrantConstraints constraints;
    private String granteePrincipal;
    private String keyId;
    private String name;
    private String retiringPrincipal;
    private List<String> operations = new ArrayList();
    private List<String> grantTokens = new ArrayList();

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGrantRequest)) {
            return false;
        }
        CreateGrantRequest createGrantRequest = (CreateGrantRequest) obj;
        if (createGrantRequest.getKeyId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getKeyId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createGrantRequest.getKeyId() != null && !createGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (createGrantRequest.getGranteePrincipal() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getGranteePrincipal() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (createGrantRequest.getGranteePrincipal() != null && !createGrantRequest.getGranteePrincipal().equals(getGranteePrincipal())) {
            return false;
        }
        if (createGrantRequest.getRetiringPrincipal() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getRetiringPrincipal() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (createGrantRequest.getRetiringPrincipal() != null && !createGrantRequest.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return false;
        }
        if (createGrantRequest.getOperations() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getOperations() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (createGrantRequest.getOperations() != null && !createGrantRequest.getOperations().equals(getOperations())) {
            return false;
        }
        if (createGrantRequest.getConstraints() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getConstraints() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (createGrantRequest.getConstraints() != null && !createGrantRequest.getConstraints().equals(getConstraints())) {
            return false;
        }
        if (createGrantRequest.getGrantTokens() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getGrantTokens() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (createGrantRequest.getGrantTokens() != null && !createGrantRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if (createGrantRequest.getName() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getName() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (createGrantRequest.getName() == null || createGrantRequest.getName().equals(getName())) {
            return true;
        }
        return false;
    }

    public GrantConstraints getConstraints() {
        return this.constraints;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOperations() {
        return this.operations;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getGranteePrincipal() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getGranteePrincipal().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getRetiringPrincipal() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getRetiringPrincipal().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getOperations() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getOperations().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getConstraints() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getConstraints().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getGrantTokens() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getGrantTokens().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getName() != null) {
            i10 = getName().hashCode();
        }
        return i16 + i10;
    }

    public void setConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperations(Collection<String> collection) {
        if (collection == null) {
            this.operations = null;
        } else {
            this.operations = new ArrayList(collection);
        }
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGranteePrincipal() != null) {
            sb.append("GranteePrincipal: " + getGranteePrincipal() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal() + ",");
        }
        if (getOperations() != null) {
            sb.append("Operations: " + getOperations() + ",");
        }
        if (getConstraints() != null) {
            sb.append("Constraints: " + getConstraints() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateGrantRequest withConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
        return this;
    }

    public CreateGrantRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public CreateGrantRequest withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public CreateGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public CreateGrantRequest withName(String str) {
        this.name = str;
        return this;
    }

    public CreateGrantRequest withOperations(String... strArr) {
        if (getOperations() == null) {
            this.operations = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.operations.add(str);
        }
        return this;
    }

    public CreateGrantRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public CreateGrantRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public CreateGrantRequest withOperations(Collection<String> collection) {
        setOperations(collection);
        return this;
    }
}

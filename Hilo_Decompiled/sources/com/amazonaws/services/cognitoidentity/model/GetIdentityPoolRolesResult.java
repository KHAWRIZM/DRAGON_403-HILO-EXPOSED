package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetIdentityPoolRolesResult implements Serializable {
    private String identityPoolId;
    private Map<String, RoleMapping> roleMappings;
    private Map<String, String> roles;

    public GetIdentityPoolRolesResult addRoleMappingsEntry(String str, RoleMapping roleMapping) {
        if (this.roleMappings == null) {
            this.roleMappings = new HashMap();
        }
        if (!this.roleMappings.containsKey(str)) {
            this.roleMappings.put(str, roleMapping);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetIdentityPoolRolesResult addRolesEntry(String str, String str2) {
        if (this.roles == null) {
            this.roles = new HashMap();
        }
        if (!this.roles.containsKey(str)) {
            this.roles.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetIdentityPoolRolesResult clearRoleMappingsEntries() {
        this.roleMappings = null;
        return this;
    }

    public GetIdentityPoolRolesResult clearRolesEntries() {
        this.roles = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityPoolRolesResult)) {
            return false;
        }
        GetIdentityPoolRolesResult getIdentityPoolRolesResult = (GetIdentityPoolRolesResult) obj;
        if (getIdentityPoolRolesResult.getIdentityPoolId() == null) {
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
        if (getIdentityPoolRolesResult.getIdentityPoolId() != null && !getIdentityPoolRolesResult.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if (getIdentityPoolRolesResult.getRoles() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getRoles() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getIdentityPoolRolesResult.getRoles() != null && !getIdentityPoolRolesResult.getRoles().equals(getRoles())) {
            return false;
        }
        if (getIdentityPoolRolesResult.getRoleMappings() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getRoleMappings() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (getIdentityPoolRolesResult.getRoleMappings() == null || getIdentityPoolRolesResult.getRoleMappings().equals(getRoleMappings())) {
            return true;
        }
        return false;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, RoleMapping> getRoleMappings() {
        return this.roleMappings;
    }

    public Map<String, String> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getIdentityPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getRoles() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getRoles().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getRoleMappings() != null) {
            i10 = getRoleMappings().hashCode();
        }
        return i12 + i10;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
    }

    public void setRoles(Map<String, String> map) {
        this.roles = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityPoolId() != null) {
            sb.append("IdentityPoolId: " + getIdentityPoolId() + ",");
        }
        if (getRoles() != null) {
            sb.append("Roles: " + getRoles() + ",");
        }
        if (getRoleMappings() != null) {
            sb.append("RoleMappings: " + getRoleMappings());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdentityPoolRolesResult withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public GetIdentityPoolRolesResult withRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
        return this;
    }

    public GetIdentityPoolRolesResult withRoles(Map<String, String> map) {
        this.roles = map;
        return this;
    }
}

package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ReEncryptRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String destinationEncryptionAlgorithm;
    private String destinationKeyId;
    private String sourceEncryptionAlgorithm;
    private String sourceKeyId;
    private Map<String, String> sourceEncryptionContext = new HashMap();
    private Map<String, String> destinationEncryptionContext = new HashMap();
    private List<String> grantTokens = new ArrayList();

    public ReEncryptRequest addDestinationEncryptionContextEntry(String str, String str2) {
        if (this.destinationEncryptionContext == null) {
            this.destinationEncryptionContext = new HashMap();
        }
        if (!this.destinationEncryptionContext.containsKey(str)) {
            this.destinationEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ReEncryptRequest addSourceEncryptionContextEntry(String str, String str2) {
        if (this.sourceEncryptionContext == null) {
            this.sourceEncryptionContext = new HashMap();
        }
        if (!this.sourceEncryptionContext.containsKey(str)) {
            this.sourceEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ReEncryptRequest clearDestinationEncryptionContextEntries() {
        this.destinationEncryptionContext = null;
        return this;
    }

    public ReEncryptRequest clearSourceEncryptionContextEntries() {
        this.sourceEncryptionContext = null;
        return this;
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
        if (obj == null || !(obj instanceof ReEncryptRequest)) {
            return false;
        }
        ReEncryptRequest reEncryptRequest = (ReEncryptRequest) obj;
        if (reEncryptRequest.getCiphertextBlob() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCiphertextBlob() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (reEncryptRequest.getCiphertextBlob() != null && !reEncryptRequest.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionContext() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSourceEncryptionContext() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionContext() != null && !reEncryptRequest.getSourceEncryptionContext().equals(getSourceEncryptionContext())) {
            return false;
        }
        if (reEncryptRequest.getSourceKeyId() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSourceKeyId() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (reEncryptRequest.getSourceKeyId() != null && !reEncryptRequest.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if (reEncryptRequest.getDestinationKeyId() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getDestinationKeyId() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (reEncryptRequest.getDestinationKeyId() != null && !reEncryptRequest.getDestinationKeyId().equals(getDestinationKeyId())) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionContext() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getDestinationEncryptionContext() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionContext() != null && !reEncryptRequest.getDestinationEncryptionContext().equals(getDestinationEncryptionContext())) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionAlgorithm() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getSourceEncryptionAlgorithm() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionAlgorithm() != null && !reEncryptRequest.getSourceEncryptionAlgorithm().equals(getSourceEncryptionAlgorithm())) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionAlgorithm() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getDestinationEncryptionAlgorithm() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionAlgorithm() != null && !reEncryptRequest.getDestinationEncryptionAlgorithm().equals(getDestinationEncryptionAlgorithm())) {
            return false;
        }
        if (reEncryptRequest.getGrantTokens() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getGrantTokens() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (reEncryptRequest.getGrantTokens() == null || reEncryptRequest.getGrantTokens().equals(getGrantTokens())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getDestinationEncryptionAlgorithm() {
        return this.destinationEncryptionAlgorithm;
    }

    public Map<String, String> getDestinationEncryptionContext() {
        return this.destinationEncryptionContext;
    }

    public String getDestinationKeyId() {
        return this.destinationKeyId;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getSourceEncryptionAlgorithm() {
        return this.sourceEncryptionAlgorithm;
    }

    public Map<String, String> getSourceEncryptionContext() {
        return this.sourceEncryptionContext;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
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
        if (getCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getCiphertextBlob().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSourceEncryptionContext() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSourceEncryptionContext().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSourceKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSourceKeyId().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getDestinationKeyId() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getDestinationKeyId().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getDestinationEncryptionContext() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getDestinationEncryptionContext().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getSourceEncryptionAlgorithm() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getSourceEncryptionAlgorithm().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getDestinationEncryptionAlgorithm() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getDestinationEncryptionAlgorithm().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getGrantTokens() != null) {
            i10 = getGrantTokens().hashCode();
        }
        return i17 + i10;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
    }

    public void setDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
    }

    public void setDestinationKeyId(String str) {
        this.destinationKeyId = str;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
    }

    public void setSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getSourceEncryptionContext() != null) {
            sb.append("SourceEncryptionContext: " + getSourceEncryptionContext() + ",");
        }
        if (getSourceKeyId() != null) {
            sb.append("SourceKeyId: " + getSourceKeyId() + ",");
        }
        if (getDestinationKeyId() != null) {
            sb.append("DestinationKeyId: " + getDestinationKeyId() + ",");
        }
        if (getDestinationEncryptionContext() != null) {
            sb.append("DestinationEncryptionContext: " + getDestinationEncryptionContext() + ",");
        }
        if (getSourceEncryptionAlgorithm() != null) {
            sb.append("SourceEncryptionAlgorithm: " + getSourceEncryptionAlgorithm() + ",");
        }
        if (getDestinationEncryptionAlgorithm() != null) {
            sb.append("DestinationEncryptionAlgorithm: " + getDestinationEncryptionAlgorithm() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public ReEncryptRequest withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptRequest withDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest withDestinationKeyId(String str) {
        this.destinationKeyId = str;
        return this;
    }

    public ReEncryptRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
        return this;
    }

    public ReEncryptRequest withSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public void setDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public void setSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public ReEncryptRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}

package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerifyRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> grantTokens = new ArrayList();
    private String keyId;
    private ByteBuffer message;
    private String messageType;
    private ByteBuffer signature;
    private String signingAlgorithm;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyRequest)) {
            return false;
        }
        VerifyRequest verifyRequest = (VerifyRequest) obj;
        if (verifyRequest.getKeyId() == null) {
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
        if (verifyRequest.getKeyId() != null && !verifyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (verifyRequest.getMessage() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMessage() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (verifyRequest.getMessage() != null && !verifyRequest.getMessage().equals(getMessage())) {
            return false;
        }
        if (verifyRequest.getMessageType() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getMessageType() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (verifyRequest.getMessageType() != null && !verifyRequest.getMessageType().equals(getMessageType())) {
            return false;
        }
        if (verifyRequest.getSignature() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getSignature() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (verifyRequest.getSignature() != null && !verifyRequest.getSignature().equals(getSignature())) {
            return false;
        }
        if (verifyRequest.getSigningAlgorithm() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getSigningAlgorithm() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (verifyRequest.getSigningAlgorithm() != null && !verifyRequest.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return false;
        }
        if (verifyRequest.getGrantTokens() == null) {
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
        if (verifyRequest.getGrantTokens() == null || verifyRequest.getGrantTokens().equals(getGrantTokens())) {
            return true;
        }
        return false;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getMessage() {
        return this.message;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public ByteBuffer getSignature() {
        return this.signature;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMessage() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMessage().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getMessageType() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getMessageType().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getSignature() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getSignature().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getSigningAlgorithm() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getSigningAlgorithm().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getGrantTokens() != null) {
            i10 = getGrantTokens().hashCode();
        }
        return i15 + i10;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public void setSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
    }

    public void setSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getMessage() != null) {
            sb.append("Message: " + getMessage() + ",");
        }
        if (getMessageType() != null) {
            sb.append("MessageType: " + getMessageType() + ",");
        }
        if (getSignature() != null) {
            sb.append("Signature: " + getSignature() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.grantTokens.add(str);
        }
        return this;
    }

    public VerifyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyRequest withMessage(ByteBuffer byteBuffer) {
        this.message = byteBuffer;
        return this;
    }

    public VerifyRequest withMessageType(String str) {
        this.messageType = str;
        return this;
    }

    public VerifyRequest withSignature(ByteBuffer byteBuffer) {
        this.signature = byteBuffer;
        return this;
    }

    public VerifyRequest withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyRequest withMessageType(MessageType messageType) {
        this.messageType = messageType.toString();
        return this;
    }

    public VerifyRequest withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }

    public VerifyRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }
}

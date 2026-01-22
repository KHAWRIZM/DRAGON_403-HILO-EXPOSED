package org.apache.commons.sudcompress.archivers.zip;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class GeneralPurposeBit implements Cloneable {
    private static final int DATA_DESCRIPTOR_FLAG = 8;
    private static final int ENCRYPTION_FLAG = 1;
    private static final int NUMBER_OF_SHANNON_FANO_TREES_FLAG = 4;
    private static final int SLIDING_DICTIONARY_SIZE_FLAG = 2;
    private static final int STRONG_ENCRYPTION_FLAG = 64;
    public static final int UFT8_NAMES_FLAG = 2048;
    private int numberOfShannonFanoTrees;
    private int slidingDictionarySize;
    private boolean languageEncodingFlag = false;
    private boolean dataDescriptorFlag = false;
    private boolean encryptionFlag = false;
    private boolean strongEncryptionFlag = false;

    public static GeneralPurposeBit parse(byte[] bArr, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int value = ZipShort.getValue(bArr, i);
        GeneralPurposeBit generalPurposeBit = new GeneralPurposeBit();
        boolean z4 = false;
        if ((value & 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        generalPurposeBit.useDataDescriptor(z);
        if ((value & 2048) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        generalPurposeBit.useUTF8ForNames(z2);
        if ((value & 64) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        generalPurposeBit.useStrongEncryption(z3);
        if ((value & 1) != 0) {
            z4 = true;
        }
        generalPurposeBit.useEncryption(z4);
        if ((value & 2) != 0) {
            i2 = 8192;
        } else {
            i2 = 4096;
        }
        generalPurposeBit.slidingDictionarySize = i2;
        if ((value & 4) != 0) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        generalPurposeBit.numberOfShannonFanoTrees = i3;
        return generalPurposeBit;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e);
        }
    }

    public byte[] encode() {
        byte[] bArr = new byte[2];
        encode(bArr, 0);
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeneralPurposeBit)) {
            return false;
        }
        GeneralPurposeBit generalPurposeBit = (GeneralPurposeBit) obj;
        if (generalPurposeBit.encryptionFlag != this.encryptionFlag || generalPurposeBit.strongEncryptionFlag != this.strongEncryptionFlag || generalPurposeBit.languageEncodingFlag != this.languageEncodingFlag || generalPurposeBit.dataDescriptorFlag != this.dataDescriptorFlag) {
            return false;
        }
        return true;
    }

    public int getNumberOfShannonFanoTrees() {
        return this.numberOfShannonFanoTrees;
    }

    public int getSlidingDictionarySize() {
        return this.slidingDictionarySize;
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * 17) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public void useDataDescriptor(boolean z) {
        this.dataDescriptorFlag = z;
    }

    public void useEncryption(boolean z) {
        this.encryptionFlag = z;
    }

    public void useStrongEncryption(boolean z) {
        this.strongEncryptionFlag = z;
        if (z) {
            useEncryption(true);
        }
    }

    public void useUTF8ForNames(boolean z) {
        this.languageEncodingFlag = z;
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public boolean usesStrongEncryption() {
        if (this.encryptionFlag && this.strongEncryptionFlag) {
            return true;
        }
        return false;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }

    public void encode(byte[] bArr, int i) {
        ZipShort.putShort((this.dataDescriptorFlag ? 8 : 0) | (this.languageEncodingFlag ? 2048 : 0) | (this.encryptionFlag ? 1 : 0) | (this.strongEncryptionFlag ? 64 : 0), bArr, i);
    }
}

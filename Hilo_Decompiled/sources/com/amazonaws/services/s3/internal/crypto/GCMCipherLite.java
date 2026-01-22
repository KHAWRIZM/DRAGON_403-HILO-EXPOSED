package com.amazonaws.services.s3.internal.crypto;

import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class GCMCipherLite extends CipherLite {
    private static final int BITS = 8;
    private static final int TAG_LENGTH = ContentCryptoScheme.AES_GCM.getTagLengthInBits() / 8;
    private CipherLite aux;
    private long currentCount;
    private boolean doneFinal;
    private byte[] finalBytes;
    private boolean invisiblyProcessed;
    private long markedCount;
    private long outputByteCount;
    private boolean securityViolated;
    private final int tagLen;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GCMCipherLite(Cipher cipher, SecretKey secretKey, int i10) {
        super(cipher, ContentCryptoScheme.AES_GCM, secretKey, i10);
        int i11;
        if (i10 == 1) {
            i11 = TAG_LENGTH;
        } else {
            i11 = 0;
        }
        this.tagLen = i11;
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException();
        }
    }

    private int checkMax(int i10) {
        if (this.outputByteCount + i10 <= 68719476704L) {
            return i10;
        }
        this.securityViolated = true;
        throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + this.outputByteCount + ", delta=" + i10 + "]");
    }

    private final byte[] doFinal0(byte[] bArr, int i10, int i11) throws IllegalBlockSizeException, BadPaddingException {
        if (this.doneFinal) {
            if (!this.securityViolated) {
                if (2 == getCipherMode()) {
                    byte[] bArr2 = this.finalBytes;
                    if (bArr2 == null) {
                        return null;
                    }
                    return (byte[]) bArr2.clone();
                }
                byte[] bArr3 = this.finalBytes;
                int length = bArr3.length;
                int i12 = this.tagLen;
                int i13 = length - i12;
                if (i11 == i13) {
                    return (byte[]) bArr3.clone();
                }
                if (i11 < i13 && i11 + this.currentCount == this.outputByteCount) {
                    return Arrays.copyOfRange(bArr3, (bArr3.length - i12) - i11, bArr3.length);
                }
                throw new IllegalStateException("Inconsistent re-rencryption");
            }
            throw new SecurityException();
        }
        this.doneFinal = true;
        byte[] doFinal = super.doFinal(bArr, i10, i11);
        this.finalBytes = doFinal;
        if (doFinal == null) {
            return null;
        }
        this.outputByteCount += checkMax(doFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        if (this.doneFinal) {
            if (!this.securityViolated) {
                byte[] bArr = this.finalBytes;
                if (bArr == null) {
                    return null;
                }
                return (byte[]) bArr.clone();
            }
            throw new SecurityException();
        }
        this.doneFinal = true;
        byte[] doFinal = super.doFinal();
        this.finalBytes = doFinal;
        if (doFinal == null) {
            return null;
        }
        this.outputByteCount += checkMax(doFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    long getCurrentCount() {
        return this.currentCount;
    }

    byte[] getFinalBytes() {
        byte[] bArr = this.finalBytes;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    long getMarkedCount() {
        return this.markedCount;
    }

    long getOutputByteCount() {
        return this.outputByteCount;
    }

    byte[] getTag() {
        byte[] bArr;
        if (getCipherMode() == 1 && (bArr = this.finalBytes) != null) {
            return Arrays.copyOfRange(bArr, bArr.length - this.tagLen, bArr.length);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    public long mark() {
        long j10;
        if (this.aux == null) {
            j10 = this.outputByteCount;
        } else {
            j10 = this.currentCount;
        }
        this.markedCount = j10;
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    public boolean markSupported() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    public void reset() {
        long j10 = this.markedCount;
        if (j10 < this.outputByteCount || this.invisiblyProcessed) {
            try {
                this.aux = createAuxiliary(j10);
                this.currentCount = this.markedCount;
            } catch (Exception e10) {
                if (e10 instanceof RuntimeException) {
                    throw ((RuntimeException) e10);
                }
                throw new IllegalStateException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    public byte[] update(byte[] bArr, int i10, int i11) {
        byte[] update;
        CipherLite cipherLite = this.aux;
        int i12 = 0;
        boolean z10 = false;
        r1 = false;
        boolean z11 = false;
        if (cipherLite == null) {
            update = super.update(bArr, i10, i11);
            if (update == null) {
                if (bArr.length > 0) {
                    z10 = true;
                }
                this.invisiblyProcessed = z10;
                return null;
            }
            this.outputByteCount += checkMax(update.length);
            if (update.length == 0 && i11 > 0) {
                z11 = true;
            }
            this.invisiblyProcessed = z11;
        } else {
            update = cipherLite.update(bArr, i10, i11);
            if (update == null) {
                return null;
            }
            long length = this.currentCount + update.length;
            this.currentCount = length;
            long j10 = this.outputByteCount;
            if (length == j10) {
                this.aux = null;
            } else if (length > j10) {
                if (1 != getCipherMode()) {
                    byte[] bArr2 = this.finalBytes;
                    if (bArr2 != null) {
                        i12 = bArr2.length;
                    }
                    long j11 = this.outputByteCount;
                    long j12 = i12;
                    long length2 = (j11 - (this.currentCount - update.length)) - j12;
                    this.currentCount = j11 - j12;
                    this.aux = null;
                    return Arrays.copyOf(update, (int) length2);
                }
                throw new IllegalStateException("currentCount=" + this.currentCount + " > outputByteCount=" + this.outputByteCount);
            }
        }
        return update;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    final byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    public final byte[] doFinal(byte[] bArr, int i10, int i11) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal0(bArr, i10, i11);
    }
}

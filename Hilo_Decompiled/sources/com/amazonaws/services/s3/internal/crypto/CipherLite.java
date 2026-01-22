package com.amazonaws.services.s3.internal.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.SecretKey;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CipherLite {
    static final CipherLite NULL = new CipherLite() { // from class: com.amazonaws.services.s3.internal.crypto.CipherLite.1
        @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
        CipherLite createAuxiliary(long j10) {
            return this;
        }

        @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
        CipherLite createInverse() {
            return this;
        }
    };
    private final Cipher cipher;
    private final int cipherMode;
    private final ContentCryptoScheme scheme;
    private final SecretKey secreteKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite createAuxiliary(long j10) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return this.scheme.createAuxillaryCipher(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider(), j10);
    }

    CipherLite createInverse() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        int i10 = this.cipherMode;
        int i11 = 1;
        if (i10 != 2) {
            if (i10 == 1) {
                i11 = 2;
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), i11, this.cipher.getProvider());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite createUsingIV(byte[] bArr) {
        return this.scheme.createCipherLite(this.secreteKey, bArr, this.cipherMode, this.cipher.getProvider());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal();
    }

    final int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    final Cipher getCipher() {
        return this.cipher;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getCipherAlgorithm() {
        return this.cipher.getAlgorithm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getCipherMode() {
        return this.cipherMode;
    }

    final Provider getCipherProvider() {
        return this.cipher.getProvider();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ContentCryptoScheme getContentCryptoScheme() {
        return this.scheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] getIV() {
        return this.cipher.getIV();
    }

    int getOutputSize(int i10) {
        return this.cipher.getOutputSize(i10);
    }

    final String getSecretKeyAlgorithm() {
        return this.secreteKey.getAlgorithm();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long mark() {
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean markSupported() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite recreate() {
        return this.scheme.createCipherLite(this.secreteKey, this.cipher.getIV(), this.cipherMode, this.cipher.getProvider());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        throw new IllegalStateException("mark/reset not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] update(byte[] bArr, int i10, int i11) {
        return this.cipher.update(bArr, i10, i11);
    }

    private CipherLite() {
        this.cipher = new NullCipher();
        this.scheme = null;
        this.secreteKey = null;
        this.cipherMode = -1;
    }

    byte[] doFinal(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] doFinal(byte[] bArr, int i10, int i11) throws IllegalBlockSizeException, BadPaddingException {
        return this.cipher.doFinal(bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CipherLite(Cipher cipher, ContentCryptoScheme contentCryptoScheme, SecretKey secretKey, int i10) {
        this.cipher = cipher;
        this.scheme = contentCryptoScheme;
        this.secreteKey = secretKey;
        this.cipherMode = i10;
    }
}

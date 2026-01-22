package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import com.amazonaws.util.StringUtils;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Hkdf {
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private static final int MAX_KEY_SIZE = 255;
    private final String algorithm;
    private SecretKey prk = null;

    private Hkdf(String str) {
        if (str.startsWith("Hmac")) {
            this.algorithm = str;
            return;
        }
        throw new IllegalArgumentException("Invalid algorithm " + str + ". Hkdf may only be used with Hmac algorithms.");
    }

    private void assertInitialized() {
        if (this.prk != null) {
        } else {
            throw new IllegalStateException("Hkdf has not been initialized");
        }
    }

    private Mac createMac() {
        try {
            Mac mac = Mac.getInstance(this.algorithm);
            mac.init(this.prk);
            return mac;
        } catch (InvalidKeyException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static Hkdf getInstance(String str) throws NoSuchAlgorithmException {
        Mac.getInstance(str);
        return new Hkdf(str);
    }

    public byte[] deriveKey(String str, int i10) {
        return deriveKey(str != null ? str.getBytes(StringUtils.UTF8) : null, i10);
    }

    public void init(byte[] bArr) {
        init(bArr, null);
    }

    public void unsafeInitWithoutKeyExtraction(SecretKey secretKey) throws InvalidKeyException {
        if (secretKey.getAlgorithm().equals(this.algorithm)) {
            this.prk = secretKey;
            return;
        }
        throw new InvalidKeyException("Algorithm for the provided key must match the algorithm for this Hkdf. Expected " + this.algorithm + " but found " + secretKey.getAlgorithm());
    }

    public byte[] deriveKey(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[i10];
        try {
            deriveKey(bArr, i10, bArr2, 0);
            return bArr2;
        } catch (ShortBufferException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void init(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr2 == null ? EMPTY_ARRAY : (byte[]) bArr2.clone();
        byte[] bArr4 = EMPTY_ARRAY;
        try {
            try {
                Mac mac = Mac.getInstance(this.algorithm);
                if (bArr3.length == 0) {
                    bArr3 = new byte[mac.getMacLength()];
                    Arrays.fill(bArr3, (byte) 0);
                }
                mac.init(new SecretKeySpec(bArr3, this.algorithm));
                bArr4 = mac.doFinal(bArr);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr4, this.algorithm);
                Arrays.fill(bArr4, (byte) 0);
                unsafeInitWithoutKeyExtraction(secretKeySpec);
                Arrays.fill(bArr4, (byte) 0);
            } catch (GeneralSecurityException e10) {
                throw new RuntimeException("Unexpected exception", e10);
            }
        } catch (Throwable th) {
            Arrays.fill(bArr4, (byte) 0);
            throw th;
        }
    }

    public void deriveKey(byte[] bArr, int i10, byte[] bArr2, int i11) throws ShortBufferException {
        assertInitialized();
        if (i10 >= 0) {
            if (bArr2.length >= i11 + i10) {
                Mac createMac = createMac();
                if (i10 <= createMac.getMacLength() * 255) {
                    byte[] bArr3 = EMPTY_ARRAY;
                    byte b10 = 1;
                    int i12 = 0;
                    while (i12 < i10) {
                        try {
                            createMac.update(bArr3);
                            createMac.update(bArr);
                            createMac.update(b10);
                            bArr3 = createMac.doFinal();
                            int i13 = 0;
                            while (i13 < bArr3.length && i12 < i10) {
                                bArr2[i12] = bArr3[i13];
                                i13++;
                                i12++;
                            }
                            b10 = (byte) (b10 + 1);
                        } finally {
                            Arrays.fill(bArr3, (byte) 0);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Requested keys may not be longer than 255 times the underlying HMAC length.");
            }
            throw new ShortBufferException();
        }
        throw new IllegalArgumentException("Length must be a non-negative value.");
    }
}

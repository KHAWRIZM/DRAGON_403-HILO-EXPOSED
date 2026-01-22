package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import android.content.Context;
import android.os.Build;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import com.facebook.internal.security.CertificateUtil;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class CognitoDeviceHelper {
    private static final String COGNITO_DEVICE_CACHE = "CognitoIdentityProviderDeviceCache";
    private static final String COGNITO_DEVICE_GROUP_KEY = "DeviceGroupKey";
    private static final String COGNITO_DEVICE_KEY = "DeviceKey";
    private static final String COGNITO_DEVICE_SECRET = "DeviceSecret";
    public static final int DEFAULT_DEVICE_PAGINATION_LIMIT = 10;
    private static final Log LOGGER = LogFactory.getLog(CognitoDeviceHelper.class);
    private static final Object LOCK = new Object();
    static deviceSRP srpCalculator = null;
    static Map<String, AWSKeyValueStore> awsKeyValueStoreMap = new HashMap();
    private static boolean isPersistenceEnabled = true;

    public static void cacheDeviceGroupKey(String str, String str2, String str3, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).put(COGNITO_DEVICE_GROUP_KEY, str3);
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
        }
    }

    public static void cacheDeviceKey(String str, String str2, String str3, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).put(COGNITO_DEVICE_KEY, str3);
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
        }
    }

    public static void cacheDeviceVerifier(String str, String str2, String str3, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).put(COGNITO_DEVICE_SECRET, str3);
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
        }
    }

    public static void clearCachedDevice(String str, String str2, Context context) {
        try {
            getAWSKeyValueStore(context, str, str2).clear();
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
        }
    }

    public static String generateRandomString() {
        return String.valueOf(UUID.randomUUID());
    }

    public static Map<String, String> generateVerificationParameters(String str, String str2) {
        HashMap hashMap = new HashMap();
        String generateRandomString = generateRandomString();
        deviceSRP devicesrp = new deviceSRP(str2, str, generateRandomString);
        srpCalculator = devicesrp;
        byte[] byteArray = devicesrp.getSalt().toByteArray();
        byte[] byteArray2 = srpCalculator.getVerifier().toByteArray();
        hashMap.put("salt", new String(Base64.encode(byteArray)));
        hashMap.put("verifier", new String(Base64.encode(byteArray2)));
        hashMap.put("secret", generateRandomString);
        return hashMap;
    }

    private static AWSKeyValueStore getAWSKeyValueStore(Context context, String str, String str2) {
        synchronized (LOCK) {
            try {
                String deviceDetailsCacheForUser = getDeviceDetailsCacheForUser(str, str2);
                if (awsKeyValueStoreMap.containsKey(deviceDetailsCacheForUser)) {
                    return awsKeyValueStoreMap.get(deviceDetailsCacheForUser);
                }
                AWSKeyValueStore aWSKeyValueStore = new AWSKeyValueStore(context, deviceDetailsCacheForUser, isPersistenceEnabled);
                awsKeyValueStoreMap.put(deviceDetailsCacheForUser, aWSKeyValueStore);
                return aWSKeyValueStore;
            } catch (Exception e10) {
                LOGGER.error("Error in retrieving the persistent store.", e10);
                return null;
            }
        }
    }

    private static String getDeviceDetailsCacheForUser(String str, String str2) {
        return "CognitoIdentityProviderDeviceCache." + str2 + InstructionFileId.DOT + str;
    }

    public static String getDeviceGroupKey(String str, String str2, Context context) {
        try {
            AWSKeyValueStore aWSKeyValueStore = getAWSKeyValueStore(context, str, str2);
            if (aWSKeyValueStore != null && aWSKeyValueStore.contains(COGNITO_DEVICE_GROUP_KEY)) {
                return aWSKeyValueStore.get(COGNITO_DEVICE_GROUP_KEY);
            }
            return null;
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
            return null;
        }
    }

    public static String getDeviceKey(String str, String str2, Context context) {
        try {
            AWSKeyValueStore aWSKeyValueStore = getAWSKeyValueStore(context, str, str2);
            if (aWSKeyValueStore != null && aWSKeyValueStore.contains(COGNITO_DEVICE_KEY)) {
                return aWSKeyValueStore.get(COGNITO_DEVICE_KEY);
            }
            return null;
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
            return null;
        }
    }

    public static String getDeviceName() {
        return Build.MODEL;
    }

    public static String getDeviceSecret(String str, String str2, Context context) {
        try {
            AWSKeyValueStore aWSKeyValueStore = getAWSKeyValueStore(context, str, str2);
            if (aWSKeyValueStore != null && aWSKeyValueStore.contains(COGNITO_DEVICE_SECRET)) {
                return aWSKeyValueStore.get(COGNITO_DEVICE_SECRET);
            }
            return null;
        } catch (Exception e10) {
            LOGGER.error("Error accessing SharedPreferences", e10);
            return null;
        }
    }

    public static void setPersistenceEnabled(boolean z10) {
        synchronized (LOCK) {
            try {
                isPersistenceEnabled = z10;
                Iterator<String> it = awsKeyValueStoreMap.keySet().iterator();
                while (it.hasNext()) {
                    awsKeyValueStoreMap.get(it.next()).setPersistenceEnabled(z10);
                }
            } catch (Exception e10) {
                LOGGER.error("Error in setting the isPersistenceEnabled flag in the key-value store.", e10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class deviceSRP {
        private static final String HASH_ALGORITHM = "SHA-256";
        private static final int SALT_LENGTH_BITS = 128;
        private static final SecureRandom SECURE_RANDOM;
        private final BigInteger salt;
        private final BigInteger verifier;
        private static final ThreadLocal<MessageDigest> THREAD_MESSAGE_DIGEST = new ThreadLocal<MessageDigest>() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper.deviceSRP.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public MessageDigest initialValue() {
                try {
                    return MessageDigest.getInstance(deviceSRP.HASH_ALGORITHM);
                } catch (NoSuchAlgorithmException e10) {
                    throw new ExceptionInInitializerError(e10);
                }
            }
        };
        private static final String HEX_N = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
        private static final BigInteger N = new BigInteger(HEX_N, 16);
        private static final BigInteger GG = BigInteger.valueOf(2);

        static {
            try {
                SECURE_RANDOM = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e10) {
                throw new ExceptionInInitializerError(e10);
            }
        }

        public deviceSRP(String str, String str2, String str3) {
            byte[] userIdHash = getUserIdHash(str, str2, str3);
            BigInteger bigInteger = new BigInteger(128, SECURE_RANDOM);
            this.salt = bigInteger;
            this.verifier = calcVerifier(bigInteger, userIdHash);
        }

        public static void begin() {
            THREAD_MESSAGE_DIGEST.get().reset();
        }

        private static BigInteger calcVerifier(BigInteger bigInteger, byte[] bArr) {
            begin();
            update(bigInteger);
            update(bArr);
            return GG.modPow(new BigInteger(1, end()), N);
        }

        public static byte[] end() {
            return THREAD_MESSAGE_DIGEST.get().digest();
        }

        private byte[] getUserIdHash(String str, String str2, String str3) {
            begin();
            update(str, str2, CertificateUtil.DELIMITER, str3);
            return end();
        }

        public static void update(String... strArr) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            for (String str : strArr) {
                if (str != null) {
                    messageDigest.update(str.getBytes(StringUtils.UTF8));
                }
            }
        }

        public BigInteger getSalt() {
            return this.salt;
        }

        public BigInteger getVerifier() {
            return this.verifier;
        }

        public static void update(String str) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            if (str != null) {
                messageDigest.update(str.getBytes(StringUtils.UTF8));
            }
        }

        public static void update(BigInteger... bigIntegerArr) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            for (BigInteger bigInteger : bigIntegerArr) {
                if (bigInteger != null) {
                    messageDigest.update(bigInteger.toByteArray());
                }
            }
        }

        public static void update(BigInteger bigInteger) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            if (bigInteger != null) {
                messageDigest.update(bigInteger.toByteArray());
            }
        }

        public static void update(ByteBuffer byteBuffer) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            if (byteBuffer != null) {
                messageDigest.update(byteBuffer.array());
            }
        }

        public static void update(byte[] bArr) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            if (bArr != null) {
                messageDigest.update(bArr);
            }
        }
    }
}

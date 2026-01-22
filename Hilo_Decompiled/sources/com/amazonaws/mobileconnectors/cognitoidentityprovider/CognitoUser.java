package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChooseMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.RegisterMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.VerifyMfaContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoNotAuthorizedException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.DevicesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.RegisterMfaHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoAccessToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoIdToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens.CognitoRefreshToken;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoDeviceHelper;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoSecretHash;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.Hkdf;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.AuthenticationResultType;
import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryDetailsType;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmDeviceResult;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceSecretVerifierConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordResult;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserAttributeVerificationCodeResult;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetUserResult;
import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidParameterException;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult;
import com.amazonaws.services.cognitoidentityprovider.model.NewDeviceMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ResendConfirmationCodeResult;
import com.amazonaws.services.cognitoidentityprovider.model.ResourceNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.amazonaws.services.cognitoidentityprovider.model.SMSMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserMFAPreferenceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsRequest;
import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaSettingsType;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserAttributesResult;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotFoundException;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenRequest;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResponseType;
import com.amazonaws.services.cognitoidentityprovider.model.VerifySoftwareTokenResult;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import com.facebook.internal.security.CertificateUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CognitoUser {
    private static final int SRP_RADIX = 16;
    private final String clientId;
    private final String clientSecret;
    private final AmazonCognitoIdentityProvider cognitoIdentityProviderClient;
    private final Context context;
    private final CognitoUserPool pool;
    private String secretHash;
    private String userId;
    private String usernameInternal;
    private static final Log LOGGER = LogFactory.getLog(CognitoUser.class);
    private static final Object GET_CACHED_SESSION_LOCK = new Object();
    private String deviceKey = null;
    private CognitoUserSession cipSession = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class AuthenticationHelper {
        private static final String DERIVED_KEY_INFO = "Caldera Derived Key";
        private static final int DERIVED_KEY_SIZE = 16;
        private static final int EPHEMERAL_KEY_LENGTH = 1024;
        private static final BigInteger GG;
        private static final String HEX_N = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
        private static final BigInteger KK;
        private static final BigInteger N;
        private static final SecureRandom SECURE_RANDOM;
        private static final ThreadLocal<MessageDigest> THREAD_MESSAGE_DIGEST;
        private BigInteger A;

        /* renamed from: a, reason: collision with root package name */
        private BigInteger f٦٩١٤a;
        private String poolName;

        static {
            BigInteger bigInteger = new BigInteger(HEX_N, 16);
            N = bigInteger;
            BigInteger valueOf = BigInteger.valueOf(2L);
            GG = valueOf;
            ThreadLocal<MessageDigest> threadLocal = new ThreadLocal<MessageDigest>() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.AuthenticationHelper.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public MessageDigest initialValue() {
                    try {
                        return MessageDigest.getInstance("SHA-256");
                    } catch (NoSuchAlgorithmException e10) {
                        throw new CognitoInternalErrorException("Exception in authentication", e10);
                    }
                }
            };
            THREAD_MESSAGE_DIGEST = threadLocal;
            try {
                SECURE_RANDOM = SecureRandom.getInstance("SHA1PRNG");
                MessageDigest messageDigest = threadLocal.get();
                messageDigest.reset();
                messageDigest.update(bigInteger.toByteArray());
                KK = new BigInteger(1, messageDigest.digest(valueOf.toByteArray()));
            } catch (NoSuchAlgorithmException e10) {
                throw new CognitoInternalErrorException(e10.getMessage(), e10);
            }
        }

        public AuthenticationHelper(String str) {
            BigInteger bigInteger;
            BigInteger modPow;
            do {
                BigInteger bigInteger2 = new BigInteger(1024, SECURE_RANDOM);
                bigInteger = N;
                BigInteger mod = bigInteger2.mod(bigInteger);
                this.f٦٩١٤a = mod;
                modPow = GG.modPow(mod, bigInteger);
                this.A = modPow;
            } while (modPow.mod(bigInteger).equals(BigInteger.ZERO));
            if (str.contains("_")) {
                this.poolName = str.split("_", 2)[1];
            } else {
                this.poolName = str;
            }
        }

        public BigInteger getA() {
            return this.A;
        }

        public byte[] getPasswordAuthenticationKey(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2) {
            MessageDigest messageDigest = THREAD_MESSAGE_DIGEST.get();
            messageDigest.reset();
            messageDigest.update(this.A.toByteArray());
            BigInteger bigInteger3 = new BigInteger(1, messageDigest.digest(bigInteger.toByteArray()));
            if (!bigInteger3.equals(BigInteger.ZERO)) {
                messageDigest.reset();
                String str3 = this.poolName;
                Charset charset = StringUtils.UTF8;
                messageDigest.update(str3.getBytes(charset));
                messageDigest.update(str.getBytes(charset));
                messageDigest.update(CertificateUtil.DELIMITER.getBytes(charset));
                byte[] digest = messageDigest.digest(str2.getBytes(charset));
                messageDigest.reset();
                messageDigest.update(bigInteger2.toByteArray());
                BigInteger bigInteger4 = new BigInteger(1, messageDigest.digest(digest));
                BigInteger bigInteger5 = KK;
                BigInteger bigInteger6 = GG;
                BigInteger bigInteger7 = N;
                BigInteger mod = bigInteger.subtract(bigInteger5.multiply(bigInteger6.modPow(bigInteger4, bigInteger7))).modPow(this.f٦٩١٤a.add(bigInteger3.multiply(bigInteger4)), bigInteger7).mod(bigInteger7);
                try {
                    Hkdf hkdf = Hkdf.getInstance("HmacSHA256");
                    hkdf.init(mod.toByteArray(), bigInteger3.toByteArray());
                    return hkdf.deriveKey(DERIVED_KEY_INFO, 16);
                } catch (NoSuchAlgorithmException e10) {
                    throw new CognitoInternalErrorException(e10.getMessage(), e10);
                }
            }
            throw new CognitoInternalErrorException("Hash of A and B cannot be zero");
        }

        public BigInteger geta() {
            return this.f٦٩١٤a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CognitoUser(CognitoUserPool cognitoUserPool, String str, String str2, String str3, String str4, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider, Context context) {
        this.pool = cognitoUserPool;
        this.context = context;
        this.userId = str;
        this.cognitoIdentityProviderClient = amazonCognitoIdentityProvider;
        this.clientId = str2;
        this.clientSecret = str3;
        this.secretHash = str4;
    }

    private AssociateSoftwareTokenResult associateTotpMfaInternal(AssociateSoftwareTokenRequest associateSoftwareTokenRequest) {
        return this.cognitoIdentityProviderClient.associateSoftwareToken(associateSoftwareTokenRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AssociateSoftwareTokenResult associateTotpMfaInternalWithSession(String str) {
        if (str != null) {
            AssociateSoftwareTokenRequest associateSoftwareTokenRequest = new AssociateSoftwareTokenRequest();
            associateSoftwareTokenRequest.setSession(str);
            return associateTotpMfaInternal(associateSoftwareTokenRequest);
        }
        throw new CognitoNotAuthorizedException("session token is invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AssociateSoftwareTokenResult associateTotpMfaInternalWithTokens(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            AssociateSoftwareTokenRequest associateSoftwareTokenRequest = new AssociateSoftwareTokenRequest();
            associateSoftwareTokenRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            return associateTotpMfaInternal(associateSoftwareTokenRequest);
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePasswordInternal(String str, String str2, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
            changePasswordRequest.setPreviousPassword(str);
            changePasswordRequest.setProposedPassword(str2);
            changePasswordRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            this.cognitoIdentityProviderClient.changePassword(changePasswordRequest);
            return;
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private void clearCachedTokens() {
        try {
            String format = String.format("CognitoIdentityProvider.%s.%s.idToken", this.clientId, this.userId);
            String format2 = String.format("CognitoIdentityProvider.%s.%s.accessToken", this.clientId, this.userId);
            String format3 = String.format("CognitoIdentityProvider.%s.%s.refreshToken", this.clientId, this.userId);
            this.pool.awsKeyValueStore.remove(format);
            this.pool.awsKeyValueStore.remove(format2);
            this.pool.awsKeyValueStore.remove(format3);
        } catch (Exception e10) {
            LOGGER.error("Error while deleting from SharedPreferences", e10);
        }
    }

    private ConfirmDeviceResult confirmDevice(NewDeviceMetadataType newDeviceMetadataType) {
        Map<String, String> generateVerificationParameters = CognitoDeviceHelper.generateVerificationParameters(newDeviceMetadataType.getDeviceKey(), newDeviceMetadataType.getDeviceGroupKey());
        new ConfirmDeviceResult().setUserConfirmationNecessary(Boolean.FALSE);
        try {
            ConfirmDeviceResult confirmDeviceInternal = confirmDeviceInternal(getCachedSession(), newDeviceMetadataType.getDeviceKey(), generateVerificationParameters.get("verifier"), generateVerificationParameters.get("salt"), CognitoDeviceHelper.getDeviceName());
            CognitoDeviceHelper.cacheDeviceKey(this.usernameInternal, this.pool.getUserPoolId(), newDeviceMetadataType.getDeviceKey(), this.context);
            CognitoDeviceHelper.cacheDeviceVerifier(this.usernameInternal, this.pool.getUserPoolId(), generateVerificationParameters.get("secret"), this.context);
            CognitoDeviceHelper.cacheDeviceGroupKey(this.usernameInternal, this.pool.getUserPoolId(), newDeviceMetadataType.getDeviceGroupKey(), this.context);
            return confirmDeviceInternal;
        } catch (Exception e10) {
            LOGGER.error("Device confirmation failed: ", e10);
            return null;
        }
    }

    private ConfirmDeviceResult confirmDeviceInternal(CognitoUserSession cognitoUserSession, String str, String str2, String str3, String str4) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            if (str != null && str4 != null) {
                DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = new DeviceSecretVerifierConfigType();
                deviceSecretVerifierConfigType.setPasswordVerifier(str2);
                deviceSecretVerifierConfigType.setSalt(str3);
                ConfirmDeviceRequest confirmDeviceRequest = new ConfirmDeviceRequest();
                confirmDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                confirmDeviceRequest.setDeviceKey(str);
                confirmDeviceRequest.setDeviceName(str4);
                confirmDeviceRequest.setDeviceSecretVerifierConfig(deviceSecretVerifierConfigType);
                return this.cognitoIdentityProviderClient.confirmDevice(confirmDeviceRequest);
            }
            if (str == null) {
                throw new CognitoParameterInvalidException("Device key is null");
            }
            throw new CognitoParameterInvalidException("Device name is null");
        }
        throw new CognitoNotAuthorizedException("User is not authorized");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmPasswordInternal(String str, String str2, Map<String, String> map) {
        ConfirmForgotPasswordRequest confirmForgotPasswordRequest = new ConfirmForgotPasswordRequest();
        confirmForgotPasswordRequest.setUsername(this.userId);
        confirmForgotPasswordRequest.setClientId(this.clientId);
        confirmForgotPasswordRequest.setSecretHash(this.secretHash);
        confirmForgotPasswordRequest.setConfirmationCode(str);
        confirmForgotPasswordRequest.setPassword(str2);
        confirmForgotPasswordRequest.setUserContextData(getUserContextData());
        confirmForgotPasswordRequest.setClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            confirmForgotPasswordRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        this.cognitoIdentityProviderClient.confirmForgotPassword(confirmForgotPasswordRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmSignUpInternal(String str, boolean z10, Map<String, String> map) {
        ConfirmSignUpRequest withUserContextData = new ConfirmSignUpRequest().withClientId(this.clientId).withSecretHash(this.secretHash).withUsername(this.userId).withConfirmationCode(str).withForceAliasCreation(Boolean.valueOf(z10)).withClientMetadata(map).withUserContextData(getUserContextData());
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withUserContextData.setAnalyticsMetadata(analyticsMetadataType);
        }
        this.cognitoIdentityProviderClient.confirmSignUp(withUserContextData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAttributesInternal(List<String> list, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null) {
            if (cognitoUserSession.isValid()) {
                if (list == null || list.size() < 1) {
                    return;
                }
                DeleteUserAttributesRequest deleteUserAttributesRequest = new DeleteUserAttributesRequest();
                deleteUserAttributesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                deleteUserAttributesRequest.setUserAttributeNames(list);
                this.cognitoIdentityProviderClient.deleteUserAttributes(deleteUserAttributesRequest);
                return;
            }
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteUserInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null) {
            if (cognitoUserSession.isValid()) {
                DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
                deleteUserRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                this.cognitoIdentityProviderClient.deleteUser(deleteUserRequest);
                return;
            }
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private Runnable deviceSrpAuthentication(RespondToAuthChallengeResult respondToAuthChallengeResult, final AuthenticationHandler authenticationHandler, final boolean z10) {
        String deviceSecret = CognitoDeviceHelper.getDeviceSecret(this.usernameInternal, this.pool.getUserPoolId(), this.context);
        String deviceGroupKey = CognitoDeviceHelper.getDeviceGroupKey(this.usernameInternal, this.pool.getUserPoolId(), this.context);
        AuthenticationHelper authenticationHelper = new AuthenticationHelper(deviceGroupKey);
        try {
            RespondToAuthChallengeResult respondToAuthChallenge = this.cognitoIdentityProviderClient.respondToAuthChallenge(initiateDevicesAuthRequest(authenticationHelper));
            if (CognitoServiceConstants.CHLG_TYPE_DEVICE_PASSWORD_VERIFIER.equals(respondToAuthChallenge.getChallengeName())) {
                return handleChallenge(this.cognitoIdentityProviderClient.respondToAuthChallenge(deviceSrpAuthRequest(respondToAuthChallenge, deviceSecret, deviceGroupKey, authenticationHelper)), (AuthenticationDetails) null, authenticationHandler, z10);
            }
            return handleChallenge(respondToAuthChallenge, (AuthenticationDetails) null, authenticationHandler, z10);
        } catch (NotAuthorizedException unused) {
            CognitoDeviceHelper.clearCachedDevice(this.usernameInternal, this.pool.getUserPoolId(), this.context);
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.38
                @Override // java.lang.Runnable
                public void run() {
                    authenticationHandler.getAuthenticationDetails(new AuthenticationContinuation(this, CognitoUser.this.context, z10, authenticationHandler), this.getUserId());
                }
            };
        } catch (Exception e10) {
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.39
                @Override // java.lang.Runnable
                public void run() {
                    authenticationHandler.onFailure(e10);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ForgotPasswordResult forgotPasswordInternal(Map<String, String> map) {
        ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
        forgotPasswordRequest.setClientId(this.clientId);
        forgotPasswordRequest.setSecretHash(this.secretHash);
        forgotPasswordRequest.setUsername(this.userId);
        forgotPasswordRequest.setUserContextData(getUserContextData());
        forgotPasswordRequest.setClientMetadata(map);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            forgotPasswordRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.cognitoIdentityProviderClient.forgotPassword(forgotPasswordRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetUserAttributeVerificationCodeResult getAttributeVerificationCodeInternal(String str, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest = new GetUserAttributeVerificationCodeRequest();
            getUserAttributeVerificationCodeRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            getUserAttributeVerificationCodeRequest.setAttributeName(str);
            return this.cognitoIdentityProviderClient.getUserAttributeVerificationCode(getUserAttributeVerificationCodeRequest);
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private CognitoUserSession getCognitoUserSession(AuthenticationResultType authenticationResultType) {
        return getCognitoUserSession(authenticationResultType, null);
    }

    private UserContextDataType getUserContextData() {
        return this.pool.getUserContextData(this.userId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CognitoUserDetails getUserDetailsInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            GetUserRequest getUserRequest = new GetUserRequest();
            getUserRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            GetUserResult user = this.cognitoIdentityProviderClient.getUser(getUserRequest);
            return new CognitoUserDetails(new CognitoUserAttributes(user.getUserAttributes()), new CognitoUserSettings(user.getMFAOptions()));
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void globalSignOutInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null) {
            if (cognitoUserSession.isValid()) {
                GlobalSignOutRequest globalSignOutRequest = new GlobalSignOutRequest();
                globalSignOutRequest.setAccessToken(getCachedSession().getAccessToken().getJWTToken());
                this.cognitoIdentityProviderClient.globalSignOut(globalSignOutRequest);
                return;
            }
            throw new CognitoNotAuthorizedException("user is not authenticated");
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private Runnable handleChallenge(RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, boolean z10) {
        Runnable runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.26
            @Override // java.lang.Runnable
            public void run() {
                authenticationHandler.onFailure(new CognitoInternalErrorException("Authentication failed due to an internal error"));
            }
        };
        if (respondToAuthChallengeResult == null) {
            return runnable;
        }
        updateInternalUsername(respondToAuthChallengeResult.getChallengeParameters());
        String challengeName = respondToAuthChallengeResult.getChallengeName();
        if (challengeName == null) {
            final CognitoUserSession cognitoUserSession = getCognitoUserSession(respondToAuthChallengeResult.getAuthenticationResult());
            cacheTokens(cognitoUserSession);
            NewDeviceMetadataType newDeviceMetadata = respondToAuthChallengeResult.getAuthenticationResult().getNewDeviceMetadata();
            if (newDeviceMetadata == null) {
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.27
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.onSuccess(cognitoUserSession, null);
                    }
                };
            }
            ConfirmDeviceResult confirmDevice = confirmDevice(newDeviceMetadata);
            if (confirmDevice != null && confirmDevice.isUserConfirmationNecessary().booleanValue()) {
                final CognitoDevice cognitoDevice = new CognitoDevice(newDeviceMetadata.getDeviceKey(), null, null, null, null, this, this.context);
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.28
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.onSuccess(cognitoUserSession, cognitoDevice);
                    }
                };
            }
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.29
                @Override // java.lang.Runnable
                public void run() {
                    authenticationHandler.onSuccess(cognitoUserSession, null);
                }
            };
        }
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(challengeName)) {
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.30
                @Override // java.lang.Runnable
                public void run() {
                    authenticationHandler.onFailure(new CognitoInternalErrorException("Authentication failed due to an internal error: PASSWORD_VERIFIER challenge encountered not at the start of authentication flow"));
                }
            };
        }
        if (!"SMS_MFA".equals(challengeName) && !CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(challengeName)) {
            if (CognitoServiceConstants.CHLG_TYPE_SELECT_MFA_TYPE.equals(challengeName)) {
                final ChooseMfaContinuation chooseMfaContinuation = new ChooseMfaContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z10, authenticationHandler);
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.32
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.authenticationChallenge(chooseMfaContinuation);
                    }
                };
            }
            if (CognitoServiceConstants.CHLG_TYPE_MFA_SETUP.equals(challengeName)) {
                final RegisterMfaContinuation registerMfaContinuation = new RegisterMfaContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z10, authenticationHandler);
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.33
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.authenticationChallenge(registerMfaContinuation);
                    }
                };
            }
            if (CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH.equals(challengeName)) {
                return deviceSrpAuthentication(respondToAuthChallengeResult, authenticationHandler, z10);
            }
            if (CognitoServiceConstants.CHLG_TYPE_NEW_PASSWORD_REQUIRED.equals(challengeName)) {
                final NewPasswordContinuation newPasswordContinuation = new NewPasswordContinuation(this, this.context, this.usernameInternal, this.clientId, this.secretHash, respondToAuthChallengeResult, z10, authenticationHandler);
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.34
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.authenticationChallenge(newPasswordContinuation);
                    }
                };
            }
            Context context = this.context;
            String str = this.usernameInternal;
            String str2 = this.clientId;
            final ChallengeContinuation challengeContinuation = new ChallengeContinuation(this, context, str, str2, CognitoSecretHash.getSecretHash(str, str2, this.clientSecret), respondToAuthChallengeResult, z10, authenticationHandler);
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.35
                @Override // java.lang.Runnable
                public void run() {
                    authenticationHandler.authenticationChallenge(challengeContinuation);
                }
            };
        }
        final MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation = new MultiFactorAuthenticationContinuation(this, this.context, respondToAuthChallengeResult, z10, authenticationHandler);
        return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.31
            @Override // java.lang.Runnable
            public void run() {
                authenticationHandler.getMFACode(multiFactorAuthenticationContinuation);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InitiateAuthRequest initiateCustomAuthRequest(AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH);
        initiateAuthRequest.setClientId(this.clientId);
        Map<String, String> authenticationParameters = authenticationDetails.getAuthenticationParameters();
        if (this.clientSecret != null && authenticationParameters.get("SECRET_HASH") == null) {
            String secretHash = CognitoSecretHash.getSecretHash(authenticationDetails.getUserId(), this.clientId, this.clientSecret);
            this.secretHash = secretHash;
            authenticationParameters.put("SECRET_HASH", secretHash);
        }
        if ("SRP_A".equals(authenticationDetails.getCustomChallenge())) {
            authenticationParameters.put("SRP_A", authenticationHelper.getA().toString(16));
        }
        initiateAuthRequest.setAuthParameters(authenticationDetails.getAuthenticationParameters());
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType attributeType : authenticationDetails.getValidationData()) {
                hashMap.put(attributeType.getName(), attributeType.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    private RespondToAuthChallengeRequest initiateDevicesAuthRequest(AuthenticationHelper authenticationHelper) {
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeName(CognitoServiceConstants.CHLG_TYPE_DEVICE_SRP_AUTH);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("USERNAME", this.usernameInternal);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("SRP_A", authenticationHelper.getA().toString(16));
        respondToAuthChallengeRequest.addChallengeResponsesEntry("DEVICE_KEY", this.deviceKey);
        respondToAuthChallengeRequest.addChallengeResponsesEntry("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setUserContextData(getUserContextData());
        return respondToAuthChallengeRequest;
    }

    private InitiateAuthRequest initiateRefreshTokenAuthRequest(CognitoUserSession cognitoUserSession) {
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.addAuthParametersEntry(CognitoServiceConstants.AUTH_PARAM_REFRESH_TOKEN, cognitoUserSession.getRefreshToken().getToken());
        if (this.deviceKey == null) {
            String str = this.usernameInternal;
            if (str != null) {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            } else {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(cognitoUserSession.getUsername(), this.pool.getUserPoolId(), this.context);
            }
        }
        initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", this.deviceKey);
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", this.clientSecret);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_REFRESH_TOKEN);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            initiateAuthRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InitiateAuthRequest initiateUserPasswordAuthRequest(AuthenticationDetails authenticationDetails) {
        if (!StringUtils.isBlank(authenticationDetails.getUserId()) && !StringUtils.isBlank(authenticationDetails.getPassword())) {
            InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
            initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD);
            initiateAuthRequest.setClientId(this.clientId);
            initiateAuthRequest.addAuthParametersEntry("USERNAME", authenticationDetails.getUserId());
            initiateAuthRequest.addAuthParametersEntry("PASSWORD", authenticationDetails.getPassword());
            initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", CognitoSecretHash.getSecretHash(this.userId, this.clientId, this.clientSecret));
            if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
                HashMap hashMap = new HashMap();
                for (AttributeType attributeType : authenticationDetails.getValidationData()) {
                    hashMap.put(attributeType.getName(), attributeType.getValue());
                }
                initiateAuthRequest.setClientMetadata(hashMap);
            }
            return initiateAuthRequest;
        }
        throw new CognitoNotAuthorizedException("User name and password are required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InitiateAuthRequest initiateUserSrpAuthRequest(AuthenticationDetails authenticationDetails, AuthenticationHelper authenticationHelper) {
        this.userId = authenticationDetails.getUserId();
        InitiateAuthRequest initiateAuthRequest = new InitiateAuthRequest();
        initiateAuthRequest.setAuthFlow(CognitoServiceConstants.AUTH_TYPE_INIT_USER_SRP);
        initiateAuthRequest.setClientId(this.clientId);
        initiateAuthRequest.addAuthParametersEntry("SECRET_HASH", CognitoSecretHash.getSecretHash(this.userId, this.clientId, this.clientSecret));
        initiateAuthRequest.addAuthParametersEntry("USERNAME", authenticationDetails.getUserId());
        initiateAuthRequest.addAuthParametersEntry("SRP_A", authenticationHelper.getA().toString(16));
        String str = this.deviceKey;
        if (str == null) {
            initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", CognitoDeviceHelper.getDeviceKey(authenticationDetails.getUserId(), this.pool.getUserPoolId(), this.context));
        } else {
            initiateAuthRequest.addAuthParametersEntry("DEVICE_KEY", str);
        }
        if (authenticationDetails.getValidationData() != null && authenticationDetails.getValidationData().size() > 0) {
            HashMap hashMap = new HashMap();
            for (AttributeType attributeType : authenticationDetails.getValidationData()) {
                hashMap.put(attributeType.getName(), attributeType.getValue());
            }
            initiateAuthRequest.setClientMetadata(hashMap);
        }
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            initiateAuthRequest.setAnalyticsMetadata(analyticsMetadataType);
        }
        initiateAuthRequest.setUserContextData(getUserContextData());
        return initiateAuthRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ListDevicesResult listDevicesInternal(CognitoUserSession cognitoUserSession, int i10, String str) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            ListDevicesRequest listDevicesRequest = new ListDevicesRequest();
            if (i10 < 1) {
                listDevicesRequest.setLimit(10);
            } else {
                listDevicesRequest.setLimit(Integer.valueOf(i10));
            }
            listDevicesRequest.setPaginationToken(str);
            listDevicesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            return this.cognitoIdentityProviderClient.listDevices(listDevicesRequest);
        }
        throw new CognitoNotAuthorizedException("User is not authorized");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a7 A[Catch: Exception -> 0x0082, TryCatch #0 {Exception -> 0x0082, blocks: (B:3:0x000a, B:6:0x0072, B:8:0x007c, B:9:0x009d, B:11:0x00a7, B:13:0x00b1, B:14:0x00cf, B:16:0x00d9, B:18:0x00e3, B:19:0x00e9, B:20:0x0100, B:25:0x00b7, B:27:0x0085), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d9 A[Catch: Exception -> 0x0082, TryCatch #0 {Exception -> 0x0082, blocks: (B:3:0x000a, B:6:0x0072, B:8:0x007c, B:9:0x009d, B:11:0x00a7, B:13:0x00b1, B:14:0x00cf, B:16:0x00d9, B:18:0x00e3, B:19:0x00e9, B:20:0x0100, B:25:0x00b7, B:27:0x0085), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CognitoUserSession readCachedTokens() {
        CognitoIdToken cognitoIdToken;
        CognitoAccessToken cognitoAccessToken;
        CognitoRefreshToken cognitoRefreshToken = null;
        CognitoUserSession cognitoUserSession = new CognitoUserSession(null, null, null);
        try {
            String str = "CognitoIdentityProvider." + this.clientId + InstructionFileId.DOT + this.userId + ".idToken";
            String str2 = "CognitoIdentityProvider." + this.clientId + InstructionFileId.DOT + this.userId + ".accessToken";
            String str3 = "CognitoIdentityProvider." + this.clientId + InstructionFileId.DOT + this.userId + ".refreshToken";
            if (this.pool.awsKeyValueStore.contains(str)) {
                String str4 = this.pool.awsKeyValueStore.get(str);
                if (str4 != null) {
                    cognitoIdToken = new CognitoIdToken(str4);
                    if (this.pool.awsKeyValueStore.contains(str2)) {
                        String str5 = this.pool.awsKeyValueStore.get(str2);
                        if (str5 != null) {
                            cognitoAccessToken = new CognitoAccessToken(str5);
                            if (this.pool.awsKeyValueStore.contains(str3)) {
                                String str6 = this.pool.awsKeyValueStore.get(str3);
                                if (str6 != null) {
                                    cognitoRefreshToken = new CognitoRefreshToken(str6);
                                } else {
                                    LOGGER.warn("IdToken for " + str3 + " is null.");
                                }
                            }
                            return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
                        }
                        LOGGER.warn("IdToken for " + str2 + " is null.");
                    }
                    cognitoAccessToken = null;
                    if (this.pool.awsKeyValueStore.contains(str3)) {
                    }
                    return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
                }
                LOGGER.warn("IdToken for " + str + " is null.");
            }
            cognitoIdToken = null;
            if (this.pool.awsKeyValueStore.contains(str2)) {
            }
            cognitoAccessToken = null;
            if (this.pool.awsKeyValueStore.contains(str3)) {
            }
            return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
        } catch (Exception e10) {
            LOGGER.error("Error while reading the tokens from the persistent store.", e10);
            return cognitoUserSession;
        }
    }

    private CognitoUserSession refreshSession(CognitoUserSession cognitoUserSession) {
        InitiateAuthResult initiateAuth = this.cognitoIdentityProviderClient.initiateAuth(initiateRefreshTokenAuthRequest(cognitoUserSession));
        if (initiateAuth.getAuthenticationResult() != null) {
            return getCognitoUserSession(initiateAuth.getAuthenticationResult(), cognitoUserSession.getRefreshToken());
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResendConfirmationCodeResult resendConfirmationCodeInternal() {
        ResendConfirmationCodeRequest withSecretHash = new ResendConfirmationCodeRequest().withUsername(this.userId).withClientId(this.clientId).withSecretHash(this.secretHash);
        String pinpointEndpointId = this.pool.getPinpointEndpointId();
        withSecretHash.setUserContextData(getUserContextData());
        if (pinpointEndpointId != null) {
            AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
            analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
            withSecretHash.setAnalyticsMetadata(analyticsMetadataType);
        }
        return this.cognitoIdentityProviderClient.resendConfirmationCode(withSecretHash);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserMfaSettingsInternal(List<CognitoMfaSettings> list, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            if (list != null && list.size() >= 1) {
                SetUserMFAPreferenceRequest setUserMFAPreferenceRequest = new SetUserMFAPreferenceRequest();
                setUserMFAPreferenceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                for (CognitoMfaSettings cognitoMfaSettings : list) {
                    if ("SMS_MFA".equals(cognitoMfaSettings.getMfaName())) {
                        SMSMfaSettingsType sMSMfaSettingsType = new SMSMfaSettingsType();
                        sMSMfaSettingsType.setEnabled(Boolean.valueOf(cognitoMfaSettings.isEnabled()));
                        sMSMfaSettingsType.setPreferredMfa(Boolean.valueOf(cognitoMfaSettings.isPreferred()));
                        setUserMFAPreferenceRequest.setSMSMfaSettings(sMSMfaSettingsType);
                    }
                    if (CognitoMfaSettings.TOTP_MFA.equals(cognitoMfaSettings.getMfaName())) {
                        SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType = new SoftwareTokenMfaSettingsType();
                        softwareTokenMfaSettingsType.setEnabled(Boolean.valueOf(cognitoMfaSettings.isEnabled()));
                        softwareTokenMfaSettingsType.setPreferredMfa(Boolean.valueOf(cognitoMfaSettings.isPreferred()));
                        setUserMFAPreferenceRequest.setSoftwareTokenMfaSettings(softwareTokenMfaSettingsType);
                    }
                }
                this.cognitoIdentityProviderClient.setUserMFAPreference(setUserMFAPreferenceRequest);
                return;
            }
            throw new CognitoParameterInvalidException("mfa settings are empty");
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserSettingsInternal(CognitoUserSettings cognitoUserSettings, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            if (cognitoUserSettings != null) {
                SetUserSettingsRequest setUserSettingsRequest = new SetUserSettingsRequest();
                setUserSettingsRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
                setUserSettingsRequest.setMFAOptions(cognitoUserSettings.getSettingsList());
                this.cognitoIdentityProviderClient.setUserSettings(setUserSettingsRequest);
                return;
            }
            throw new CognitoParameterInvalidException("user attributes is null");
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private Runnable startWithCustomAuth(final AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, final boolean z10) {
        return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.25
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AuthenticationHelper authenticationHelper = new AuthenticationHelper(CognitoUser.this.getUserPoolId());
                    InitiateAuthResult initiateAuth = CognitoUser.this.cognitoIdentityProviderClient.initiateAuth(CognitoUser.this.initiateCustomAuthRequest(authenticationDetails, authenticationHelper));
                    CognitoUser.this.updateInternalUsername(initiateAuth.getChallengeParameters());
                    if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(initiateAuth.getChallengeName())) {
                        if (authenticationDetails.getPassword() != null) {
                            CognitoUser.this.respondToChallenge(CognitoUser.this.userSrpAuthRequest(initiateAuth.getChallengeParameters(), authenticationDetails.getPassword(), initiateAuth.getChallengeName(), initiateAuth.getSession(), authenticationHelper), authenticationHandler, z10).run();
                            return;
                        }
                        throw new IllegalStateException("Failed to find password in authentication details to response to PASSWORD_VERIFIER challenge");
                    }
                    CognitoUser.this.handleChallenge(initiateAuth, authenticationDetails, authenticationHandler, z10).run();
                } catch (Exception e10) {
                    authenticationHandler.onFailure(e10);
                }
            }
        };
    }

    private Runnable startWithUserPasswordAuth(final AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, final boolean z10) {
        return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.37
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InitiateAuthResult initiateAuth = CognitoUser.this.cognitoIdentityProviderClient.initiateAuth(CognitoUser.this.initiateUserPasswordAuthRequest(authenticationDetails));
                    CognitoUser.this.usernameInternal = initiateAuth.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_USER_ID_FOR_SRP);
                    CognitoUser.this.handleChallenge(initiateAuth, authenticationDetails, authenticationHandler, z10).run();
                } catch (Exception e10) {
                    authenticationHandler.onFailure(e10);
                }
            }
        };
    }

    private Runnable startWithUserSrpAuth(final AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, final boolean z10) {
        return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.24
            @Override // java.lang.Runnable
            public void run() {
                AuthenticationHelper authenticationHelper = new AuthenticationHelper(CognitoUser.this.pool.getUserPoolId());
                try {
                    InitiateAuthResult initiateAuth = CognitoUser.this.cognitoIdentityProviderClient.initiateAuth(CognitoUser.this.initiateUserSrpAuthRequest(authenticationDetails, authenticationHelper));
                    CognitoUser.this.updateInternalUsername(initiateAuth.getChallengeParameters());
                    if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(initiateAuth.getChallengeName())) {
                        if (authenticationDetails.getPassword() != null) {
                            CognitoUser.this.respondToChallenge(CognitoUser.this.userSrpAuthRequest(initiateAuth.getChallengeParameters(), authenticationDetails.getPassword(), initiateAuth.getChallengeName(), initiateAuth.getSession(), authenticationHelper), authenticationHandler, z10).run();
                            return;
                        }
                        throw new IllegalStateException("Failed to find password in authentication details to response to PASSWORD_VERIFIER challenge");
                    }
                    CognitoUser.this.handleChallenge(initiateAuth, authenticationDetails, authenticationHandler, z10).run();
                } catch (ResourceNotFoundException e10) {
                    CognitoUser cognitoUser = CognitoUser.this;
                    if (e10.getMessage().contains("Device")) {
                        CognitoDeviceHelper.clearCachedDevice(CognitoUser.this.usernameInternal, CognitoUser.this.pool.getUserPoolId(), CognitoUser.this.context);
                        authenticationHandler.getAuthenticationDetails(new AuthenticationContinuation(cognitoUser, CognitoUser.this.context, z10, authenticationHandler), cognitoUser.getUserId());
                        return;
                    }
                    authenticationHandler.onFailure(e10);
                } catch (Exception e11) {
                    authenticationHandler.onFailure(e11);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateUserAttributesResult updateAttributesInternal(CognitoUserAttributes cognitoUserAttributes, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            UpdateUserAttributesRequest updateUserAttributesRequest = new UpdateUserAttributesRequest();
            updateUserAttributesRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            updateUserAttributesRequest.setUserAttributes(cognitoUserAttributes.getAttributesList());
            return this.cognitoIdentityProviderClient.updateUserAttributes(updateUserAttributesRequest);
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInternalUsername(Map<String, String> map) {
        if (this.usernameInternal == null && map != null && map.containsKey("USERNAME")) {
            String str = map.get("USERNAME");
            this.usernameInternal = str;
            this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            if (this.secretHash == null) {
                this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RespondToAuthChallengeRequest userSrpAuthRequest(Map<String, String> map, String str, String str2, String str3, AuthenticationHelper authenticationHelper) {
        String str4 = map.get("USERNAME");
        String str5 = map.get(CognitoServiceConstants.CHLG_PARAM_USER_ID_FOR_SRP);
        String str6 = map.get(CognitoServiceConstants.CHLG_PARAM_SRP_B);
        String str7 = map.get(CognitoServiceConstants.CHLG_PARAM_SALT);
        String str8 = map.get(CognitoServiceConstants.CHLG_PARAM_SECRET_BLOCK);
        this.usernameInternal = str4;
        this.deviceKey = CognitoDeviceHelper.getDeviceKey(str4, this.pool.getUserPoolId(), this.context);
        this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
        BigInteger bigInteger = new BigInteger(str6, 16);
        if (!bigInteger.mod(AuthenticationHelper.N).equals(BigInteger.ZERO)) {
            byte[] passwordAuthenticationKey = authenticationHelper.getPasswordAuthenticationKey(str5, str, bigInteger, new BigInteger(str7, 16));
            Date date = new Date();
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(passwordAuthenticationKey, "HmacSHA256"));
                String str9 = this.pool.getUserPoolId().split("_", 2)[1];
                Charset charset = StringUtils.UTF8;
                mac.update(str9.getBytes(charset));
                mac.update(str5.getBytes(charset));
                mac.update(Base64.decode(str8));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String format = simpleDateFormat.format(date);
                byte[] doFinal = mac.doFinal(format.getBytes(charset));
                HashMap hashMap = new HashMap();
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SECRET_BLOCK, str8);
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SIGNATURE, new String(Base64.encode(doFinal), charset));
                hashMap.put(CognitoServiceConstants.CHLG_RESP_TIMESTAMP, format);
                hashMap.put("USERNAME", this.usernameInternal);
                hashMap.put("DEVICE_KEY", this.deviceKey);
                hashMap.put("SECRET_HASH", this.secretHash);
                RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
                respondToAuthChallengeRequest.setChallengeName(str2);
                respondToAuthChallengeRequest.setClientId(this.clientId);
                respondToAuthChallengeRequest.setSession(str3);
                respondToAuthChallengeRequest.setChallengeResponses(hashMap);
                String pinpointEndpointId = this.pool.getPinpointEndpointId();
                if (pinpointEndpointId != null) {
                    AnalyticsMetadataType analyticsMetadataType = new AnalyticsMetadataType();
                    analyticsMetadataType.setAnalyticsEndpointId(pinpointEndpointId);
                    respondToAuthChallengeRequest.setAnalyticsMetadata(analyticsMetadataType);
                }
                respondToAuthChallengeRequest.setUserContextData(getUserContextData());
                return respondToAuthChallengeRequest;
            } catch (Exception e10) {
                throw new CognitoInternalErrorException("SRP error", e10);
            }
        }
        throw new CognitoInternalErrorException("SRP error, B cannot be zero");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VerifyUserAttributeResult verifyAttributeInternal(String str, String str2, CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            VerifyUserAttributeRequest verifyUserAttributeRequest = new VerifyUserAttributeRequest();
            verifyUserAttributeRequest.setAttributeName(str);
            verifyUserAttributeRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            verifyUserAttributeRequest.setCode(str2);
            return this.cognitoIdentityProviderClient.verifyUserAttribute(verifyUserAttributeRequest);
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    private VerifySoftwareTokenResult verifyTotpAssociationInternal(VerifySoftwareTokenRequest verifySoftwareTokenRequest) {
        return this.cognitoIdentityProviderClient.verifySoftwareToken(verifySoftwareTokenRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VerifySoftwareTokenResult verifyTotpAssociationWithSession(String str, String str2, String str3) {
        if (str != null) {
            VerifySoftwareTokenRequest verifySoftwareTokenRequest = new VerifySoftwareTokenRequest();
            verifySoftwareTokenRequest.setSession(str);
            verifySoftwareTokenRequest.setUserCode(str2);
            verifySoftwareTokenRequest.setFriendlyDeviceName(str3);
            return verifyTotpAssociationInternal(verifySoftwareTokenRequest);
        }
        throw new CognitoNotAuthorizedException("session token is invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VerifySoftwareTokenResult verifyTotpAssociationWithTokens(CognitoUserSession cognitoUserSession, String str, String str2) {
        if (cognitoUserSession != null && cognitoUserSession.isValid()) {
            VerifySoftwareTokenRequest verifySoftwareTokenRequest = new VerifySoftwareTokenRequest();
            verifySoftwareTokenRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            verifySoftwareTokenRequest.setUserCode(str);
            verifySoftwareTokenRequest.setFriendlyDeviceName(str2);
            return verifyTotpAssociationInternal(verifySoftwareTokenRequest);
        }
        throw new CognitoNotAuthorizedException("user is not authenticated");
    }

    Runnable _initiateUserAuthentication(final AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, boolean z10) {
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD_VERIFIER.equals(authenticationDetails.getAuthenticationType())) {
            return startWithUserSrpAuth(authenticationDetails, authenticationHandler, z10);
        }
        if (CognitoServiceConstants.CHLG_TYPE_CUSTOM_CHALLENGE.equals(authenticationDetails.getAuthenticationType())) {
            return startWithCustomAuth(authenticationDetails, authenticationHandler, z10);
        }
        if (CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD.equals(authenticationDetails.getAuthenticationType())) {
            return startWithUserPasswordAuth(authenticationDetails, authenticationHandler, z10);
        }
        return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.8
            @Override // java.lang.Runnable
            public void run() {
                authenticationHandler.onFailure(new CognitoParameterInvalidException("Unsupported authentication type " + authenticationDetails.getAuthenticationType()));
            }
        };
    }

    public void associateSoftwareToken(String str, RegisterMfaHandler registerMfaHandler) {
        AssociateSoftwareTokenResult associateTotpMfaInternalWithTokens;
        boolean z10;
        if (registerMfaHandler != null) {
            try {
                CognitoUserSession cachedSession = getCachedSession();
                if (!StringUtils.isBlank(str)) {
                    associateTotpMfaInternalWithTokens = associateTotpMfaInternalWithSession(str);
                    z10 = true;
                } else {
                    associateTotpMfaInternalWithTokens = associateTotpMfaInternalWithTokens(cachedSession);
                    z10 = false;
                }
                String session = associateTotpMfaInternalWithTokens.getSession();
                HashMap hashMap = new HashMap();
                hashMap.put("type", CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA);
                hashMap.put("secretKey", associateTotpMfaInternalWithTokens.getSecretCode());
                registerMfaHandler.onVerify(new VerifyMfaContinuation(this.context, this.clientId, this, registerMfaHandler, hashMap, z10, session, false));
                return;
            } catch (Exception e10) {
                registerMfaHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void associateSoftwareTokenInBackground(final String str, final RegisterMfaHandler registerMfaHandler) {
        if (registerMfaHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.13
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    AssociateSoftwareTokenResult associateTotpMfaInternalWithTokens;
                    boolean z10;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUserSession cachedSession = this.getCachedSession();
                        if (!StringUtils.isBlank(str)) {
                            associateTotpMfaInternalWithTokens = CognitoUser.this.associateTotpMfaInternalWithSession(str);
                            z10 = true;
                        } else {
                            associateTotpMfaInternalWithTokens = CognitoUser.this.associateTotpMfaInternalWithTokens(cachedSession);
                            z10 = false;
                        }
                        final String session = associateTotpMfaInternalWithTokens.getSession();
                        final HashMap hashMap = new HashMap();
                        hashMap.put("type", CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA);
                        hashMap.put("secretKey", associateTotpMfaInternalWithTokens.getSecretCode());
                        if (z10) {
                            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.13.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                    RegisterMfaHandler registerMfaHandler2 = registerMfaHandler;
                                    Context context = CognitoUser.this.context;
                                    String str2 = CognitoUser.this.clientId;
                                    AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                    registerMfaHandler2.onVerify(new VerifyMfaContinuation(context, str2, this, registerMfaHandler, hashMap, true, session, true));
                                }
                            };
                        } else {
                            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.13.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                                    RegisterMfaHandler registerMfaHandler2 = registerMfaHandler;
                                    Context context = CognitoUser.this.context;
                                    String str2 = CognitoUser.this.clientId;
                                    AnonymousClass13 anonymousClass132 = AnonymousClass13.this;
                                    registerMfaHandler2.onVerify(new VerifyMfaContinuation(context, str2, this, registerMfaHandler, hashMap, false, session, true));
                                }
                            };
                        }
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.13.3
                            @Override // java.lang.Runnable
                            public void run() {
                                registerMfaHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    void cacheTokens(CognitoUserSession cognitoUserSession) {
        String str;
        String str2;
        try {
            String str3 = "CognitoIdentityProvider." + this.clientId + InstructionFileId.DOT + this.userId + ".idToken";
            String str4 = "CognitoIdentityProvider." + this.clientId + InstructionFileId.DOT + this.userId + ".accessToken";
            String str5 = "CognitoIdentityProvider." + this.clientId + InstructionFileId.DOT + this.userId + ".refreshToken";
            String str6 = "CognitoIdentityProvider." + this.clientId + ".LastAuthUser";
            if (cognitoUserSession != null) {
                AWSKeyValueStore aWSKeyValueStore = this.pool.awsKeyValueStore;
                String str7 = null;
                if (cognitoUserSession.getIdToken() != null) {
                    str = cognitoUserSession.getIdToken().getJWTToken();
                } else {
                    str = null;
                }
                aWSKeyValueStore.put(str3, str);
                AWSKeyValueStore aWSKeyValueStore2 = this.pool.awsKeyValueStore;
                if (cognitoUserSession.getAccessToken() != null) {
                    str2 = cognitoUserSession.getAccessToken().getJWTToken();
                } else {
                    str2 = null;
                }
                aWSKeyValueStore2.put(str4, str2);
                AWSKeyValueStore aWSKeyValueStore3 = this.pool.awsKeyValueStore;
                if (cognitoUserSession.getRefreshToken() != null) {
                    str7 = cognitoUserSession.getRefreshToken().getToken();
                }
                aWSKeyValueStore3.put(str5, str7);
            }
            this.pool.awsKeyValueStore.put(str6, this.userId);
        } catch (Exception e10) {
            LOGGER.error("Error while writing to SharedPreferences.", e10);
        }
    }

    public void changePassword(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                changePasswordInternal(str, str2, getCachedSession());
                genericHandler.onSuccess();
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void changePasswordInBackground(final String str, final String str2, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.9
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.changePasswordInternal(str, str2, this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.9.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void confirmPassword(String str, String str2, ForgotPasswordHandler forgotPasswordHandler) {
        confirmPassword(str, str2, Collections.emptyMap(), forgotPasswordHandler);
    }

    public void confirmPasswordInBackground(String str, String str2, ForgotPasswordHandler forgotPasswordHandler) {
        confirmPasswordInBackground(str, str2, Collections.emptyMap(), forgotPasswordHandler);
    }

    public void confirmSignUp(String str, boolean z10, GenericHandler genericHandler) {
        confirmSignUp(str, z10, Collections.emptyMap(), genericHandler);
    }

    public void confirmSignUpInBackground(String str, boolean z10, GenericHandler genericHandler) {
        confirmSignUpInBackground(str, z10, Collections.emptyMap(), genericHandler);
    }

    public void deleteAttributes(List<String> list, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                deleteAttributesInternal(list, getCachedSession());
                genericHandler.onSuccess();
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void deleteAttributesInBackground(final List<String> list, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.16
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.deleteAttributesInternal(list, this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.16.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.16.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void deleteUser(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                deleteUserInternal(getCachedSession());
                genericHandler.onSuccess();
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void deleteUserInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.18
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.deleteUserInternal(this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.18.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.18.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public RespondToAuthChallengeRequest deviceSrpAuthRequest(RespondToAuthChallengeResult respondToAuthChallengeResult, String str, String str2, AuthenticationHelper authenticationHelper) {
        this.usernameInternal = respondToAuthChallengeResult.getChallengeParameters().get("USERNAME");
        BigInteger bigInteger = new BigInteger(respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SRP_B), 16);
        if (!bigInteger.mod(AuthenticationHelper.N).equals(BigInteger.ZERO)) {
            byte[] passwordAuthenticationKey = authenticationHelper.getPasswordAuthenticationKey(this.deviceKey, str, bigInteger, new BigInteger(respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SALT), 16));
            Date date = new Date();
            try {
                Mac mac = Mac.getInstance("HmacSHA256");
                mac.init(new SecretKeySpec(passwordAuthenticationKey, "HmacSHA256"));
                Charset charset = StringUtils.UTF8;
                mac.update(str2.getBytes(charset));
                mac.update(this.deviceKey.getBytes(charset));
                mac.update(Base64.decode(respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SECRET_BLOCK)));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String format = simpleDateFormat.format(date);
                byte[] doFinal = mac.doFinal(format.getBytes(charset));
                this.secretHash = CognitoSecretHash.getSecretHash(this.usernameInternal, this.clientId, this.clientSecret);
                HashMap hashMap = new HashMap();
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SECRET_BLOCK, respondToAuthChallengeResult.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_SECRET_BLOCK));
                hashMap.put(CognitoServiceConstants.CHLG_RESP_PASSWORD_CLAIM_SIGNATURE, new String(Base64.encode(doFinal), charset));
                hashMap.put(CognitoServiceConstants.CHLG_RESP_TIMESTAMP, format);
                hashMap.put("USERNAME", this.usernameInternal);
                hashMap.put("DEVICE_KEY", this.deviceKey);
                hashMap.put("SECRET_HASH", this.secretHash);
                RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
                respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
                respondToAuthChallengeRequest.setClientId(this.clientId);
                respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
                respondToAuthChallengeRequest.setChallengeResponses(hashMap);
                respondToAuthChallengeRequest.setUserContextData(getUserContextData());
                return respondToAuthChallengeRequest;
            } catch (Exception e10) {
                throw new CognitoInternalErrorException("SRP error", e10);
            }
        }
        throw new CognitoInternalErrorException("SRP error, B cannot be zero");
    }

    public void forgotPassword(ForgotPasswordHandler forgotPasswordHandler) {
        forgotPassword(Collections.emptyMap(), forgotPasswordHandler);
    }

    public void forgotPasswordInBackground(ForgotPasswordHandler forgotPasswordHandler) {
        forgotPasswordInBackground(Collections.emptyMap(), forgotPasswordHandler);
    }

    public void getAttributeVerificationCode(String str, VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            try {
                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(getAttributeVerificationCodeInternal(str, getCachedSession()).getCodeDeliveryDetails()));
                return;
            } catch (Exception e10) {
                verificationHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void getAttributeVerificationCodeInBackground(final String str, final VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.11
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final GetUserAttributeVerificationCodeResult attributeVerificationCodeInternal = CognitoUser.this.getAttributeVerificationCodeInternal(str, this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(attributeVerificationCodeInternal.getCodeDeliveryDetails()));
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.11.2
                            @Override // java.lang.Runnable
                            public void run() {
                                verificationHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CognitoUserSession getCachedSession() {
        synchronized (GET_CACHED_SESSION_LOCK) {
            try {
                if (this.userId != null) {
                    CognitoUserSession cognitoUserSession = this.cipSession;
                    if (cognitoUserSession != null && cognitoUserSession.isValidForThreshold()) {
                        return this.cipSession;
                    }
                    CognitoUserSession readCachedTokens = readCachedTokens();
                    if (readCachedTokens.isValidForThreshold()) {
                        this.cipSession = readCachedTokens;
                        return readCachedTokens;
                    }
                    if (readCachedTokens.getRefreshToken() != null) {
                        try {
                            try {
                                try {
                                    CognitoUserSession refreshSession = refreshSession(readCachedTokens);
                                    this.cipSession = refreshSession;
                                    cacheTokens(refreshSession);
                                    return this.cipSession;
                                } catch (NotAuthorizedException e10) {
                                    clearCachedTokens();
                                    throw new CognitoNotAuthorizedException("User is not authenticated", e10);
                                }
                            } catch (Exception e11) {
                                throw new CognitoInternalErrorException("Failed to authenticate user", e11);
                            }
                        } catch (UserNotFoundException e12) {
                            clearCachedTokens();
                            throw new CognitoNotAuthorizedException("User does not exist", e12);
                        }
                    }
                    throw new CognitoNotAuthorizedException("User is not authenticated");
                }
                throw new CognitoNotAuthorizedException("User-ID is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AmazonCognitoIdentityProvider getCognitoIdentityProviderClient() {
        return this.cognitoIdentityProviderClient;
    }

    public void getDetails(GetDetailsHandler getDetailsHandler) {
        if (getDetailsHandler != null) {
            try {
                getDetailsHandler.onSuccess(getUserDetailsInternal(getCachedSession()));
                return;
            } catch (Exception e10) {
                getDetailsHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void getDetailsInBackground(final GetDetailsHandler getDetailsHandler) {
        if (getDetailsHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.10
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final CognitoUserDetails userDetailsInternal = CognitoUser.this.getUserDetailsInternal(this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                getDetailsHandler.onSuccess(userDetailsInternal);
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.10.2
                            @Override // java.lang.Runnable
                            public void run() {
                                getDetailsHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void getSession(AuthenticationHandler authenticationHandler) {
        if (authenticationHandler != null) {
            try {
                getCachedSession();
                authenticationHandler.onSuccess(this.cipSession, null);
                return;
            } catch (CognitoNotAuthorizedException unused) {
                authenticationHandler.getAuthenticationDetails(new AuthenticationContinuation(this, this.context, false, authenticationHandler), getUserId());
                return;
            } catch (InvalidParameterException e10) {
                authenticationHandler.onFailure(e10);
                return;
            } catch (Exception e11) {
                authenticationHandler.onFailure(e11);
                return;
            }
        }
        throw new InvalidParameterException("callback is null");
    }

    public void getSessionInBackground(final AuthenticationHandler authenticationHandler) {
        if (authenticationHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.5
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.getCachedSession();
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                authenticationHandler.onSuccess(CognitoUser.this.cipSession, null);
                            }
                        };
                    } catch (CognitoNotAuthorizedException unused) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.5.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                AuthenticationContinuation authenticationContinuation = new AuthenticationContinuation(this, CognitoUser.this.context, true, authenticationHandler);
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                authenticationHandler.getAuthenticationDetails(authenticationContinuation, this.getUserId());
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.5.3
                            @Override // java.lang.Runnable
                            public void run() {
                                authenticationHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserPoolId() {
        return this.pool.getUserPoolId();
    }

    public void globalSignOut(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                globalSignOutInternal(getCachedSession());
                signOut();
                genericHandler.onSuccess();
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void globalSignOutInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.17
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.globalSignOutInternal(this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CognitoUser.this.signOut();
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.17.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public Runnable initiateUserAuthentication(AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, final boolean z10) {
        final Runnable _initiateUserAuthentication = _initiateUserAuthentication(authenticationDetails, new AuthenticationHandler() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.6
            @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
            public void authenticationChallenge(final ChallengeContinuation challengeContinuation) {
                if (z10) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.6.4
                        @Override // java.lang.Runnable
                        public void run() {
                            authenticationHandler.authenticationChallenge(challengeContinuation);
                        }
                    });
                } else {
                    authenticationHandler.authenticationChallenge(challengeContinuation);
                }
            }

            @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
            public void getAuthenticationDetails(final AuthenticationContinuation authenticationContinuation, final String str) {
                if (z10) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            authenticationHandler.getAuthenticationDetails(authenticationContinuation, str);
                        }
                    });
                } else {
                    authenticationHandler.getAuthenticationDetails(authenticationContinuation, str);
                }
            }

            @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
            public void getMFACode(final MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                if (z10) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            authenticationHandler.getMFACode(multiFactorAuthenticationContinuation);
                        }
                    });
                } else {
                    authenticationHandler.getMFACode(multiFactorAuthenticationContinuation);
                }
            }

            @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
            public void onFailure(final Exception exc) {
                if (z10) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.6.5
                        @Override // java.lang.Runnable
                        public void run() {
                            authenticationHandler.onFailure(exc);
                        }
                    });
                } else {
                    authenticationHandler.onFailure(exc);
                }
            }

            @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler
            public void onSuccess(final CognitoUserSession cognitoUserSession, final CognitoDevice cognitoDevice) {
                if (z10) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            authenticationHandler.onSuccess(cognitoUserSession, cognitoDevice);
                        }
                    });
                } else {
                    authenticationHandler.onSuccess(cognitoUserSession, cognitoDevice);
                }
            }
        }, z10);
        if (z10) {
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.7
                @Override // java.lang.Runnable
                public void run() {
                    new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            _initiateUserAuthentication.run();
                        }
                    }).start();
                }
            };
        }
        return _initiateUserAuthentication;
    }

    public void listDevices(int i10, String str, DevicesHandler devicesHandler) {
        if (devicesHandler != null) {
            try {
                ListDevicesResult listDevicesInternal = listDevicesInternal(getCachedSession(), i10, str);
                ArrayList arrayList = new ArrayList();
                Iterator<DeviceType> it = listDevicesInternal.getDevices().iterator();
                while (it.hasNext()) {
                    arrayList.add(new CognitoDevice(it.next(), this, this.context));
                }
                devicesHandler.onSuccess(arrayList);
                return;
            } catch (Exception e10) {
                devicesHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void listDevicesInBackground(final int i10, final String str, final DevicesHandler devicesHandler) {
        if (devicesHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.40
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        ListDevicesResult listDevicesInternal = CognitoUser.this.listDevicesInternal(this.getCachedSession(), i10, str);
                        final ArrayList arrayList = new ArrayList();
                        Iterator<DeviceType> it = listDevicesInternal.getDevices().iterator();
                        while (it.hasNext()) {
                            arrayList.add(new CognitoDevice(it.next(), this, CognitoUser.this.context));
                        }
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.40.1
                            @Override // java.lang.Runnable
                            public void run() {
                                devicesHandler.onSuccess(arrayList);
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.40.2
                            @Override // java.lang.Runnable
                            public void run() {
                                devicesHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void resendConfirmationCode(VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            try {
                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(resendConfirmationCodeInternal().getCodeDeliveryDetails()));
                return;
            } catch (Exception e10) {
                verificationHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void resendConfirmationCodeInBackground(final VerificationHandler verificationHandler) {
        if (verificationHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.2
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final ResendConfirmationCodeResult resendConfirmationCodeInternal = CognitoUser.this.resendConfirmationCodeInternal();
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                verificationHandler.onSuccess(new CognitoUserCodeDeliveryDetails(resendConfirmationCodeInternal.getCodeDeliveryDetails()));
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                verificationHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public Runnable respondToChallenge(RespondToAuthChallengeRequest respondToAuthChallengeRequest, final AuthenticationHandler authenticationHandler, final boolean z10) {
        if (respondToAuthChallengeRequest != null) {
            try {
                if (respondToAuthChallengeRequest.getChallengeResponses() != null) {
                    respondToAuthChallengeRequest.getChallengeResponses().put("DEVICE_KEY", this.deviceKey);
                }
            } catch (ResourceNotFoundException e10) {
                if (e10.getMessage().contains("Device")) {
                    CognitoDeviceHelper.clearCachedDevice(this.usernameInternal, this.pool.getUserPoolId(), this.context);
                    return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.21
                        @Override // java.lang.Runnable
                        public void run() {
                            authenticationHandler.getAuthenticationDetails(new AuthenticationContinuation(this, CognitoUser.this.context, z10, authenticationHandler), this.getUserId());
                        }
                    };
                }
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.22
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.onFailure(e10);
                    }
                };
            } catch (Exception e11) {
                return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.23
                    @Override // java.lang.Runnable
                    public void run() {
                        authenticationHandler.onFailure(e11);
                    }
                };
            }
        }
        return handleChallenge(this.cognitoIdentityProviderClient.respondToAuthChallenge(respondToAuthChallengeRequest), (AuthenticationDetails) null, authenticationHandler, z10);
    }

    public Runnable respondToMfaChallenge(String str, RespondToAuthChallengeResult respondToAuthChallengeResult, AuthenticationHandler authenticationHandler, boolean z10) {
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        HashMap hashMap = new HashMap();
        if ("SMS_MFA".equals(respondToAuthChallengeResult.getChallengeName())) {
            hashMap.put(CognitoServiceConstants.CHLG_RESP_SMS_MFA_CODE, str);
        } else if (CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(respondToAuthChallengeResult.getChallengeName())) {
            hashMap.put(CognitoServiceConstants.CHLG_RESP_SOFTWARE_TOKEN_MFA_CODE, str);
        }
        hashMap.put("USERNAME", this.usernameInternal);
        hashMap.put("DEVICE_KEY", this.deviceKey);
        hashMap.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setSession(respondToAuthChallengeResult.getSession());
        respondToAuthChallengeRequest.setChallengeName(respondToAuthChallengeResult.getChallengeName());
        respondToAuthChallengeRequest.setChallengeResponses(hashMap);
        respondToAuthChallengeRequest.setUserContextData(getUserContextData());
        return respondToChallenge(respondToAuthChallengeRequest, authenticationHandler, z10);
    }

    public void setUserMfaSettingsInBackground(final List<CognitoMfaSettings> list, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            final CognitoUserSession cachedSession = getCachedSession();
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.20
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.setUserMfaSettingsInternal(list, cachedSession);
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.20.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void setUserSettings(CognitoUserSettings cognitoUserSettings, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                setUserSettingsInternal(cognitoUserSettings, getCachedSession());
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void setUserSettingsInBackground(final CognitoUserSettings cognitoUserSettings, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            final CognitoUserSession cachedSession = getCachedSession();
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.19
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.setUserSettingsInternal(cognitoUserSettings, cachedSession);
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.19.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void signOut() {
        this.cipSession = null;
        clearCachedTokens();
    }

    public CognitoDevice thisDevice() {
        if (this.deviceKey == null) {
            String str = this.usernameInternal;
            if (str != null) {
                this.deviceKey = CognitoDeviceHelper.getDeviceKey(str, this.pool.getUserPoolId(), this.context);
            } else {
                String str2 = this.userId;
                if (str2 != null) {
                    String deviceKey = CognitoDeviceHelper.getDeviceKey(str2, this.pool.getUserPoolId(), this.context);
                    this.deviceKey = deviceKey;
                    if (deviceKey == null) {
                        this.deviceKey = CognitoDeviceHelper.getDeviceKey(readCachedTokens().getUsername(), this.pool.getUserPoolId(), this.context);
                    }
                }
            }
        }
        String str3 = this.deviceKey;
        if (str3 != null) {
            return new CognitoDevice(str3, null, null, null, null, this, this.context);
        }
        return null;
    }

    public void updateAttributes(CognitoUserAttributes cognitoUserAttributes, UpdateAttributesHandler updateAttributesHandler) {
        if (updateAttributesHandler != null) {
            try {
                UpdateUserAttributesResult updateAttributesInternal = updateAttributesInternal(cognitoUserAttributes, getCachedSession());
                ArrayList arrayList = new ArrayList();
                if (updateAttributesInternal.getCodeDeliveryDetailsList() != null) {
                    Iterator<CodeDeliveryDetailsType> it = updateAttributesInternal.getCodeDeliveryDetailsList().iterator();
                    while (it.hasNext()) {
                        arrayList.add(new CognitoUserCodeDeliveryDetails(it.next()));
                    }
                }
                updateAttributesHandler.onSuccess(arrayList);
                return;
            } catch (Exception e10) {
                updateAttributesHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void updateAttributesInBackground(final CognitoUserAttributes cognitoUserAttributes, final UpdateAttributesHandler updateAttributesHandler) {
        if (updateAttributesHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.15
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        UpdateUserAttributesResult updateAttributesInternal = CognitoUser.this.updateAttributesInternal(cognitoUserAttributes, this.getCachedSession());
                        final ArrayList arrayList = new ArrayList();
                        if (updateAttributesInternal.getCodeDeliveryDetailsList() != null) {
                            Iterator<CodeDeliveryDetailsType> it = updateAttributesInternal.getCodeDeliveryDetailsList().iterator();
                            while (it.hasNext()) {
                                arrayList.add(new CognitoUserCodeDeliveryDetails(it.next()));
                            }
                        }
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.15.1
                            @Override // java.lang.Runnable
                            public void run() {
                                updateAttributesHandler.onSuccess(arrayList);
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.15.2
                            @Override // java.lang.Runnable
                            public void run() {
                                updateAttributesHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void verifyAttribute(String str, String str2, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                verifyAttributeInternal(str, str2, getCachedSession());
                genericHandler.onSuccess();
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void verifyAttributeInBackground(final String str, final String str2, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.12
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.verifyAttributeInternal(str, str2, this.getCachedSession());
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.12.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void verifySoftwareToken(String str, String str2, String str3, RegisterMfaHandler registerMfaHandler) {
        VerifySoftwareTokenResult verifyTotpAssociationWithTokens;
        boolean z10;
        if (registerMfaHandler != null) {
            try {
                CognitoUserSession cachedSession = getCachedSession();
                if (!StringUtils.isBlank(str)) {
                    verifyTotpAssociationWithTokens = verifyTotpAssociationWithSession(str, str2, str3);
                    z10 = true;
                } else {
                    verifyTotpAssociationWithTokens = verifyTotpAssociationWithTokens(cachedSession, str2, str3);
                    z10 = false;
                }
                String session = verifyTotpAssociationWithTokens.getSession();
                if (!VerifySoftwareTokenResponseType.ERROR.equals(verifyTotpAssociationWithTokens.getStatus())) {
                    if (z10) {
                        registerMfaHandler.onSuccess(session);
                        return;
                    } else {
                        registerMfaHandler.onSuccess(null);
                        return;
                    }
                }
                throw new CognitoInternalErrorException("verification failed");
            } catch (Exception e10) {
                registerMfaHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void verifySoftwareTokenInBackground(final String str, final String str2, final String str3, final RegisterMfaHandler registerMfaHandler) {
        if (registerMfaHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.14
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    VerifySoftwareTokenResult verifyTotpAssociationWithTokens;
                    boolean z10;
                    final String session;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUserSession cachedSession = this.getCachedSession();
                        if (!StringUtils.isBlank(str)) {
                            verifyTotpAssociationWithTokens = CognitoUser.this.verifyTotpAssociationWithSession(str, str2, str3);
                            z10 = true;
                        } else {
                            verifyTotpAssociationWithTokens = CognitoUser.this.verifyTotpAssociationWithTokens(cachedSession, str2, str3);
                            z10 = false;
                        }
                        session = verifyTotpAssociationWithTokens.getSession();
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.14.3
                            @Override // java.lang.Runnable
                            public void run() {
                                registerMfaHandler.onFailure(e10);
                            }
                        };
                    }
                    if (!VerifySoftwareTokenResponseType.ERROR.equals(verifyTotpAssociationWithTokens.getStatus())) {
                        if (z10) {
                            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.14.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    registerMfaHandler.onSuccess(session);
                                }
                            };
                        } else {
                            runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.14.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    registerMfaHandler.onSuccess(null);
                                }
                            };
                        }
                        handler.post(runnable);
                        return;
                    }
                    throw new CognitoInternalErrorException("verification failed");
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    private CognitoUserSession getCognitoUserSession(AuthenticationResultType authenticationResultType, CognitoRefreshToken cognitoRefreshToken) {
        CognitoIdToken cognitoIdToken = new CognitoIdToken(authenticationResultType.getIdToken());
        CognitoAccessToken cognitoAccessToken = new CognitoAccessToken(authenticationResultType.getAccessToken());
        if (cognitoRefreshToken == null) {
            cognitoRefreshToken = new CognitoRefreshToken(authenticationResultType.getRefreshToken());
        }
        return new CognitoUserSession(cognitoIdToken, cognitoAccessToken, cognitoRefreshToken);
    }

    public void confirmPassword(String str, String str2, Map<String, String> map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            try {
                confirmPasswordInternal(str, str2, map);
                forgotPasswordHandler.onSuccess();
                return;
            } catch (Exception e10) {
                forgotPasswordHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void confirmPasswordInBackground(final String str, final String str2, final Map<String, String> map, final ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.4
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.confirmPasswordInternal(str, str2, map);
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                forgotPasswordHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.4.2
                            @Override // java.lang.Runnable
                            public void run() {
                                forgotPasswordHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void confirmSignUp(String str, boolean z10, Map<String, String> map, GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                confirmSignUpInternal(str, z10, map);
                genericHandler.onSuccess();
                return;
            } catch (Exception e10) {
                genericHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void forgotPassword(Map<String, String> map, ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            try {
                forgotPasswordHandler.getResetCode(new ForgotPasswordContinuation(this, new CognitoUserCodeDeliveryDetails(forgotPasswordInternal(map).getCodeDeliveryDetails()), false, forgotPasswordHandler));
                return;
            } catch (Exception e10) {
                forgotPasswordHandler.onFailure(e10);
                return;
            }
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void forgotPasswordInBackground(final Map<String, String> map, final ForgotPasswordHandler forgotPasswordHandler) {
        if (forgotPasswordHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.3
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        final ForgotPasswordContinuation forgotPasswordContinuation = new ForgotPasswordContinuation(this, new CognitoUserCodeDeliveryDetails(CognitoUser.this.forgotPasswordInternal(map).getCodeDeliveryDetails()), true, forgotPasswordHandler);
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                forgotPasswordHandler.getResetCode(forgotPasswordContinuation);
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                forgotPasswordHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    public void confirmSignUpInBackground(final String str, final boolean z10, final Map<String, String> map, final GenericHandler genericHandler) {
        if (genericHandler != null) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoUser.this.context.getMainLooper());
                    try {
                        CognitoUser.this.confirmSignUpInternal(str, z10, map);
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e10) {
                        runnable = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                genericHandler.onFailure(e10);
                            }
                        };
                    }
                    handler.post(runnable);
                }
            }).start();
            return;
        }
        throw new CognitoParameterInvalidException("callback is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable handleChallenge(InitiateAuthResult initiateAuthResult, AuthenticationDetails authenticationDetails, final AuthenticationHandler authenticationHandler, boolean z10) {
        try {
            RespondToAuthChallengeResult respondToAuthChallengeResult = new RespondToAuthChallengeResult();
            respondToAuthChallengeResult.setChallengeName(initiateAuthResult.getChallengeName());
            respondToAuthChallengeResult.setSession(initiateAuthResult.getSession());
            respondToAuthChallengeResult.setAuthenticationResult(initiateAuthResult.getAuthenticationResult());
            respondToAuthChallengeResult.setChallengeParameters(initiateAuthResult.getChallengeParameters());
            return handleChallenge(respondToAuthChallengeResult, authenticationDetails, authenticationHandler, z10);
        } catch (Exception e10) {
            return new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser.36
                @Override // java.lang.Runnable
                public void run() {
                    authenticationHandler.onFailure(e10);
                }
            };
        }
    }
}

package androidx.credentials.provider;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.utils.PrivilegedApp;
import androidx.credentials.provider.utils.RequestValidationUtil;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo;", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "signingInfo", "Landroid/content/pm/SigningInfo;", "origin", "(Ljava/lang/String;Landroid/content/pm/SigningInfo;Ljava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "getPackageName", "getSigningInfo", "()Landroid/content/pm/SigningInfo;", "privilegedAllowlist", "isAppPrivileged", "", "candidateApps", "", "Landroidx/credentials/provider/utils/PrivilegedApp;", "candidateFingerprints", "", "isOriginPopulated", "Companion", "SignatureVerifierApi28", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCallingAppInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallingAppInfo.kt\nandroidx/credentials/provider/CallingAppInfo\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,192:1\n1#2:193\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class CallingAppInfo {

    @NotNull
    private static final String TAG = "CallingAppInfo";

    @Nullable
    private final String origin;

    @NotNull
    private final String packageName;

    @NotNull
    private final SigningInfo signingInfo;

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(28)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/credentials/provider/CallingAppInfo$SignatureVerifierApi28;", "", "signingInfo", "Landroid/content/pm/SigningInfo;", "(Landroid/content/pm/SigningInfo;)V", "convertToFingerprints", "", "", "signatures", "", "Landroid/content/pm/Signature;", "([Landroid/content/pm/Signature;)Ljava/util/Set;", "getSignatureFingerprints", "verifySignatureFingerprints", "", "candidateSigFingerprints", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class SignatureVerifierApi28 {

        @NotNull
        private final SigningInfo signingInfo;

        public SignatureVerifierApi28(@NotNull SigningInfo signingInfo) {
            Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
            this.signingInfo = signingInfo;
        }

        private final Set<String> convertToFingerprints(Signature[] signatures) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Signature signature : signatures) {
                byte[] digest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
                Intrinsics.checkNotNullExpressionValue(digest, "digest");
                linkedHashSet.add(ArraysKt.joinToString$default(digest, (CharSequence) CertificateUtil.DELIMITER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: androidx.credentials.provider.CallingAppInfo$SignatureVerifierApi28$convertToFingerprints$1
                    @NotNull
                    public final CharSequence invoke(byte b10) {
                        String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                        return format;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b10) {
                        return invoke(b10.byteValue());
                    }
                }, 30, (Object) null));
            }
            return linkedHashSet;
        }

        private final Set<String> getSignatureFingerprints() {
            boolean hasMultipleSigners;
            Signature[] signingCertificateHistory;
            Signature[] signingCertificateHistory2;
            Signature[] apkContentsSigners;
            Signature[] apkContentsSigners2;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            hasMultipleSigners = this.signingInfo.hasMultipleSigners();
            if (hasMultipleSigners) {
                apkContentsSigners = this.signingInfo.getApkContentsSigners();
                if (apkContentsSigners != null) {
                    apkContentsSigners2 = this.signingInfo.getApkContentsSigners();
                    Intrinsics.checkNotNullExpressionValue(apkContentsSigners2, "signingInfo.apkContentsSigners");
                    linkedHashSet.addAll(convertToFingerprints(apkContentsSigners2));
                    return linkedHashSet;
                }
            }
            signingCertificateHistory = this.signingInfo.getSigningCertificateHistory();
            if (signingCertificateHistory != null) {
                signingCertificateHistory2 = this.signingInfo.getSigningCertificateHistory();
                Signature signature = signingCertificateHistory2[0];
                Intrinsics.checkNotNullExpressionValue(signature, "signingInfo.signingCertificateHistory[0]");
                linkedHashSet.addAll(convertToFingerprints(new Signature[]{signature}));
            }
            return linkedHashSet;
        }

        public final boolean verifySignatureFingerprints(@NotNull Set<String> candidateSigFingerprints) {
            boolean hasMultipleSigners;
            Intrinsics.checkNotNullParameter(candidateSigFingerprints, "candidateSigFingerprints");
            Set<String> signatureFingerprints = getSignatureFingerprints();
            hasMultipleSigners = this.signingInfo.hasMultipleSigners();
            if (hasMultipleSigners) {
                return candidateSigFingerprints.containsAll(signatureFingerprints);
            }
            if (!CollectionsKt.intersect(candidateSigFingerprints, signatureFingerprints).isEmpty()) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CallingAppInfo(@NotNull String packageName, @NotNull SigningInfo signingInfo) {
        this(packageName, signingInfo, null, 4, null);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
    }

    private final boolean isAppPrivileged(List<PrivilegedApp> candidateApps) {
        for (PrivilegedApp privilegedApp : candidateApps) {
            if (Intrinsics.areEqual(privilegedApp.getPackageName(), this.packageName)) {
                return isAppPrivileged(privilegedApp.getFingerprints());
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    public final String getOrigin() {
        return this.origin;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final SigningInfo getSigningInfo() {
        return this.signingInfo;
    }

    public final boolean isOriginPopulated() {
        if (this.origin != null) {
            return true;
        }
        return false;
    }

    @JvmOverloads
    public CallingAppInfo(@NotNull String packageName, @NotNull SigningInfo signingInfo, @Nullable String str) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(signingInfo, "signingInfo");
        this.packageName = packageName;
        this.signingInfo = signingInfo;
        this.origin = str;
        if (packageName.length() <= 0) {
            throw new IllegalArgumentException("packageName must not be empty");
        }
    }

    @Nullable
    public final String getOrigin(@NotNull String privilegedAllowlist) {
        Intrinsics.checkNotNullParameter(privilegedAllowlist, "privilegedAllowlist");
        if (RequestValidationUtil.INSTANCE.isValidJSON(privilegedAllowlist)) {
            String str = this.origin;
            if (str == null) {
                return str;
            }
            try {
                if (isAppPrivileged(PrivilegedApp.INSTANCE.extractPrivilegedApps$credentials_release(new JSONObject(privilegedAllowlist)))) {
                    return this.origin;
                }
                throw new IllegalStateException("Origin is not being returned as the calling app did notmatch the privileged allowlist");
            } catch (JSONException unused) {
                throw new IllegalArgumentException("privilegedAllowlist must be formatted properly");
            }
        }
        throw new IllegalArgumentException("privilegedAllowlist must not be empty, and must be a valid JSON");
    }

    private final boolean isAppPrivileged(Set<String> candidateFingerprints) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new SignatureVerifierApi28(this.signingInfo).verifySignatureFingerprints(candidateFingerprints);
        }
        return false;
    }

    public /* synthetic */ CallingAppInfo(String str, SigningInfo signingInfo, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, signingInfo, (i10 & 4) != 0 ? null : str2);
    }
}

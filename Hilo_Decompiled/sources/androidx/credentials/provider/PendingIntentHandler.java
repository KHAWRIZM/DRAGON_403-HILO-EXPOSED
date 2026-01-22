package androidx.credentials.provider;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.CreateCredentialRequest;
import android.service.credentials.GetCredentialRequest;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.PendingIntentHandler;
import androidx.credentials.provider.ProviderGetCredentialRequest;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(34)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler;", "", "()V", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class PendingIntentHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "PendingIntentHandler";

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/credentials/provider/PendingIntentHandler$Companion;", "", "()V", "TAG", "", "retrieveBeginGetCredentialRequest", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "intent", "Landroid/content/Intent;", "retrieveProviderCreateCredentialRequest", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "retrieveProviderGetCredentialRequest", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", "setBeginGetCredentialResponse", "", "response", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "setCreateCredentialException", "exception", "Landroidx/credentials/exceptions/CreateCredentialException;", "setCreateCredentialResponse", "Landroidx/credentials/CreateCredentialResponse;", "setGetCredentialException", "Landroidx/credentials/exceptions/GetCredentialException;", "setGetCredentialResponse", "Landroidx/credentials/GetCredentialResponse;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPendingIntentHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PendingIntentHandler.kt\nandroidx/credentials/provider/PendingIntentHandler$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,312:1\n1#2:313\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialOption retrieveProviderGetCredentialRequest$lambda$1(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CredentialOption) tmp0.invoke(obj);
        }

        @JvmStatic
        @Nullable
        public final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(@NotNull Intent intent) {
            Object parcelableExtra;
            Intrinsics.checkNotNullParameter(intent, "intent");
            parcelableExtra = intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_REQUEST", j0.a());
            android.service.credentials.BeginGetCredentialRequest a10 = k0.a(parcelableExtra);
            if (a10 != null) {
                return BeginGetCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(a10);
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        @Nullable
        public final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(@NotNull Intent intent) {
            Object parcelableExtra;
            String type;
            Bundle data;
            Bundle data2;
            android.service.credentials.CallingAppInfo callingAppInfo;
            String origin;
            android.service.credentials.CallingAppInfo callingAppInfo2;
            String packageName;
            android.service.credentials.CallingAppInfo callingAppInfo3;
            SigningInfo signingInfo;
            android.service.credentials.CallingAppInfo callingAppInfo4;
            String origin2;
            Intrinsics.checkNotNullParameter(intent, "intent");
            parcelableExtra = intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_REQUEST", l0.a());
            CreateCredentialRequest a10 = n0.a(parcelableExtra);
            if (a10 == 0) {
                Log.i(PendingIntentHandler.TAG, "Request not found in pendingIntent");
                return (ProviderCreateCredentialRequest) a10;
            }
            try {
                CreateCredentialRequest.Companion companion = androidx.credentials.CreateCredentialRequest.INSTANCE;
                type = a10.getType();
                Intrinsics.checkNotNullExpressionValue(type, "frameworkReq.type");
                data = a10.getData();
                Intrinsics.checkNotNullExpressionValue(data, "frameworkReq.data");
                data2 = a10.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "frameworkReq.data");
                callingAppInfo = a10.getCallingAppInfo();
                origin = callingAppInfo.getOrigin();
                androidx.credentials.CreateCredentialRequest createFrom = companion.createFrom(type, data, data2, false, origin);
                callingAppInfo2 = a10.getCallingAppInfo();
                packageName = callingAppInfo2.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "frameworkReq.callingAppInfo.packageName");
                callingAppInfo3 = a10.getCallingAppInfo();
                signingInfo = callingAppInfo3.getSigningInfo();
                Intrinsics.checkNotNullExpressionValue(signingInfo, "frameworkReq.callingAppInfo.signingInfo");
                callingAppInfo4 = a10.getCallingAppInfo();
                origin2 = callingAppInfo4.getOrigin();
                return new ProviderCreateCredentialRequest(createFrom, new CallingAppInfo(packageName, signingInfo, origin2));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @JvmStatic
        @Nullable
        public final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(@NotNull Intent intent) {
            Object parcelableExtra;
            List credentialOptions;
            Stream stream;
            Stream map;
            Collector list;
            Object collect;
            android.service.credentials.CallingAppInfo callingAppInfo;
            String packageName;
            android.service.credentials.CallingAppInfo callingAppInfo2;
            SigningInfo signingInfo;
            android.service.credentials.CallingAppInfo callingAppInfo3;
            String origin;
            Intrinsics.checkNotNullParameter(intent, "intent");
            parcelableExtra = intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_REQUEST", h0.a());
            GetCredentialRequest a10 = a1.a(parcelableExtra);
            if (a10 == null) {
                Log.i(PendingIntentHandler.TAG, "Get request from framework is null");
                return null;
            }
            ProviderGetCredentialRequest.Companion companion = ProviderGetCredentialRequest.INSTANCE;
            credentialOptions = a10.getCredentialOptions();
            stream = credentialOptions.stream();
            final PendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1 pendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1 = new Function1<android.credentials.CredentialOption, CredentialOption>() { // from class: androidx.credentials.provider.PendingIntentHandler$Companion$retrieveProviderGetCredentialRequest$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CredentialOption invoke(android.credentials.CredentialOption credentialOption) {
                    return invoke2(l1.a(credentialOption));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CredentialOption invoke2(android.credentials.CredentialOption credentialOption) {
                    String type;
                    Bundle credentialRetrievalData;
                    Bundle candidateQueryData;
                    boolean isSystemProviderRequired;
                    Set<ComponentName> allowedProviders;
                    CredentialOption.Companion companion2 = CredentialOption.INSTANCE;
                    type = credentialOption.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "option.type");
                    credentialRetrievalData = credentialOption.getCredentialRetrievalData();
                    Intrinsics.checkNotNullExpressionValue(credentialRetrievalData, "option.credentialRetrievalData");
                    candidateQueryData = credentialOption.getCandidateQueryData();
                    Intrinsics.checkNotNullExpressionValue(candidateQueryData, "option.candidateQueryData");
                    isSystemProviderRequired = credentialOption.isSystemProviderRequired();
                    allowedProviders = credentialOption.getAllowedProviders();
                    Intrinsics.checkNotNullExpressionValue(allowedProviders, "option.allowedProviders");
                    return companion2.createFrom(type, credentialRetrievalData, candidateQueryData, isSystemProviderRequired, allowedProviders);
                }
            };
            map = stream.map(new Function() { // from class: androidx.credentials.provider.f1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    CredentialOption retrieveProviderGetCredentialRequest$lambda$1;
                    retrieveProviderGetCredentialRequest$lambda$1 = PendingIntentHandler.Companion.retrieveProviderGetCredentialRequest$lambda$1(Function1.this, obj);
                    return retrieveProviderGetCredentialRequest$lambda$1;
                }
            });
            list = Collectors.toList();
            collect = map.collect(list);
            Intrinsics.checkNotNullExpressionValue(collect, "frameworkReq.credentialO…lect(Collectors.toList())");
            callingAppInfo = a10.getCallingAppInfo();
            packageName = callingAppInfo.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "frameworkReq.callingAppInfo.packageName");
            callingAppInfo2 = a10.getCallingAppInfo();
            signingInfo = callingAppInfo2.getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "frameworkReq.callingAppInfo.signingInfo");
            callingAppInfo3 = a10.getCallingAppInfo();
            origin = callingAppInfo3.getOrigin();
            return companion.createFrom$credentials_release((List) collect, new CallingAppInfo(packageName, signingInfo, origin));
        }

        @JvmStatic
        public final void setBeginGetCredentialResponse(@NotNull Intent intent, @NotNull BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            intent.putExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
        }

        @JvmStatic
        public final void setCreateCredentialException(@NotNull Intent intent, @NotNull CreateCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(exception, "exception");
            v.a();
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", u.a(exception.getType(), exception.getMessage()));
        }

        @JvmStatic
        public final void setCreateCredentialResponse(@NotNull Intent intent, @NotNull CreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            w0.a();
            intent.putExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", v0.a(response.getData()));
        }

        @JvmStatic
        public final void setGetCredentialException(@NotNull Intent intent, @NotNull GetCredentialException exception) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(exception, "exception");
            x.a();
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", w.a(exception.getType(), exception.getMessage()));
        }

        @JvmStatic
        public final void setGetCredentialResponse(@NotNull Intent intent, @NotNull GetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(response, "response");
            t0.a();
            u0.a();
            intent.putExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", r0.a(q0.a(response.getCredential().getType(), response.getCredential().getData())));
        }

        private Companion() {
        }
    }

    @JvmStatic
    @Nullable
    public static final BeginGetCredentialRequest retrieveBeginGetCredentialRequest(@NotNull Intent intent) {
        return INSTANCE.retrieveBeginGetCredentialRequest(intent);
    }

    @JvmStatic
    @Nullable
    public static final ProviderCreateCredentialRequest retrieveProviderCreateCredentialRequest(@NotNull Intent intent) {
        return INSTANCE.retrieveProviderCreateCredentialRequest(intent);
    }

    @JvmStatic
    @Nullable
    public static final ProviderGetCredentialRequest retrieveProviderGetCredentialRequest(@NotNull Intent intent) {
        return INSTANCE.retrieveProviderGetCredentialRequest(intent);
    }

    @JvmStatic
    public static final void setBeginGetCredentialResponse(@NotNull Intent intent, @NotNull BeginGetCredentialResponse beginGetCredentialResponse) {
        INSTANCE.setBeginGetCredentialResponse(intent, beginGetCredentialResponse);
    }

    @JvmStatic
    public static final void setCreateCredentialException(@NotNull Intent intent, @NotNull CreateCredentialException createCredentialException) {
        INSTANCE.setCreateCredentialException(intent, createCredentialException);
    }

    @JvmStatic
    public static final void setCreateCredentialResponse(@NotNull Intent intent, @NotNull CreateCredentialResponse createCredentialResponse) {
        INSTANCE.setCreateCredentialResponse(intent, createCredentialResponse);
    }

    @JvmStatic
    public static final void setGetCredentialException(@NotNull Intent intent, @NotNull GetCredentialException getCredentialException) {
        INSTANCE.setGetCredentialException(intent, getCredentialException);
    }

    @JvmStatic
    public static final void setGetCredentialResponse(@NotNull Intent intent, @NotNull GetCredentialResponse getCredentialResponse) {
        INSTANCE.setGetCredentialResponse(intent, getCredentialResponse);
    }
}

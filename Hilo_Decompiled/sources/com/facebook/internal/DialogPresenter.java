package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u000f\u0010\u0013J)\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u000f\u0010\u0018J1\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b$\u0010#J!\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b&\u0010\fJ+\u0010+\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0007¢\u0006\u0004\b+\u0010,J)\u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b1\u00102J+\u00104\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0007¢\u0006\u0004\b4\u0010,J\u0019\u00106\u001a\u0004\u0018\u0001052\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0002082\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b9\u0010:J'\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b=\u0010>J'\u0010C\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020'H\u0007¢\u0006\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/facebook/internal/DialogPresenter;", "", "<init>", "()V", "Lcom/facebook/internal/AppCall;", "appCall", "", "setupAppCallForCannotShowError", "(Lcom/facebook/internal/AppCall;)V", "Lcom/facebook/FacebookException;", "validationError", "setupAppCallForValidationError", "(Lcom/facebook/internal/AppCall;Lcom/facebook/FacebookException;)V", "Landroid/app/Activity;", "activity", "present", "(Lcom/facebook/internal/AppCall;Landroid/app/Activity;)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/AppCall;Lcom/facebook/internal/FragmentWrapper;)V", "Landroidx/activity/result/e;", "registry", "Lcom/facebook/CallbackManager;", "callbackManager", "(Lcom/facebook/internal/AppCall;Landroidx/activity/result/e;Lcom/facebook/CallbackManager;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "startActivityForResultWithAndroidX", "(Landroidx/activity/result/e;Lcom/facebook/CallbackManager;Landroid/content/Intent;I)V", "Lcom/facebook/internal/DialogFeature;", "feature", "", "canPresentNativeDialogWithFeature", "(Lcom/facebook/internal/DialogFeature;)Z", "canPresentWebFallbackDialogWithFeature", "exception", "setupAppCallForErrorResult", "", "actionName", "Landroid/os/Bundle;", DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, "setupAppCallForWebDialog", "(Lcom/facebook/internal/AppCall;Ljava/lang/String;Landroid/os/Bundle;)V", "setupAppCallForWebFallbackDialog", "(Lcom/facebook/internal/AppCall;Landroid/os/Bundle;Lcom/facebook/internal/DialogFeature;)V", "Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "parameterProvider", "setupAppCallForNativeDialog", "(Lcom/facebook/internal/AppCall;Lcom/facebook/internal/DialogPresenter$ParameterProvider;Lcom/facebook/internal/DialogFeature;)V", NativeProtocol.WEB_DIALOG_ACTION, "setupAppCallForCustomTabDialog", "Landroid/net/Uri;", "getDialogWebFallbackUri", "(Lcom/facebook/internal/DialogFeature;)Landroid/net/Uri;", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "getProtocolVersionForNativeDialog", "(Lcom/facebook/internal/DialogFeature;)Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "applicationId", "", "getVersionSpecForFeature", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/internal/DialogFeature;)[I", "Landroid/content/Context;", "context", "eventName", "outcome", "logDialogActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "ParameterProvider", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class DialogPresenter {

    @NotNull
    public static final DialogPresenter INSTANCE = new DialogPresenter();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "", "legacyParameters", "Landroid/os/Bundle;", "getLegacyParameters", "()Landroid/os/Bundle;", DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, "getParameters", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ParameterProvider {
        @Nullable
        Bundle getLegacyParameters();

        @Nullable
        Bundle getParameters();
    }

    private DialogPresenter() {
    }

    @JvmStatic
    public static final boolean canPresentNativeDialogWithFeature(@NotNull DialogFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (getProtocolVersionForNativeDialog(feature).getProtocolVersion() != -1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean canPresentWebFallbackDialogWithFeature(@NotNull DialogFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (INSTANCE.getDialogWebFallbackUri(feature) != null) {
            return true;
        }
        return false;
    }

    private final Uri getDialogWebFallbackUri(DialogFeature feature) {
        String name = feature.name();
        String action = feature.getAction();
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.INSTANCE.getDialogFeatureConfig(FacebookSdk.getApplicationId(), action, name);
        if (dialogFeatureConfig != null) {
            return dialogFeatureConfig.getFallbackUrl();
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(@NotNull DialogFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        String applicationId = FacebookSdk.getApplicationId();
        String action = feature.getAction();
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(action, INSTANCE.getVersionSpecForFeature(applicationId, action, feature));
    }

    private final int[] getVersionSpecForFeature(String applicationId, String actionName, DialogFeature feature) {
        int[] versionSpec;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.INSTANCE.getDialogFeatureConfig(applicationId, actionName, feature.name());
        if (dialogFeatureConfig == null) {
            versionSpec = null;
        } else {
            versionSpec = dialogFeatureConfig.getVersionSpec();
        }
        if (versionSpec == null) {
            return new int[]{feature.getMinVersion()};
        }
        return versionSpec;
    }

    @JvmStatic
    public static final void logDialogActivity(@NotNull Context context, @NotNull String eventName, @NotNull String outcome) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, outcome);
        internalAppEventsLogger.logEventImplicitly(eventName, bundle);
    }

    @JvmStatic
    public static final void present(@NotNull AppCall appCall, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @JvmStatic
    public static final void setupAppCallForCannotShowError(@NotNull AppCall appCall) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    @JvmStatic
    public static final void setupAppCallForCustomTabDialog(@NotNull AppCall appCall, @Nullable String action, @Nullable Bundle parameters) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Validate validate = Validate.INSTANCE;
        Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), CustomTabUtils.getDefaultRedirectURI());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, action);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, parameters);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, CustomTabUtils.getChromePackage());
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), action, NativeProtocol.getLatestKnownVersion(), null);
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForErrorResult(@NotNull AppCall appCall, @Nullable FacebookException exception) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (exception == null) {
            return;
        }
        Validate validate = Validate.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(exception));
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForNativeDialog(@NotNull AppCall appCall, @NotNull ParameterProvider parameterProvider, @NotNull DialogFeature feature) {
        Bundle legacyParameters;
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(parameterProvider, "parameterProvider");
        Intrinsics.checkNotNullParameter(feature, "feature");
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = feature.getAction();
        NativeProtocol.ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(feature);
        int protocolVersion = protocolVersionForNativeDialog.getProtocolVersion();
        if (protocolVersion != -1) {
            if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion)) {
                legacyParameters = parameterProvider.getParameters();
            } else {
                legacyParameters = parameterProvider.getLegacyParameters();
            }
            if (legacyParameters == null) {
                legacyParameters = new Bundle();
            }
            Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, legacyParameters);
            if (createPlatformActivityIntent != null) {
                appCall.setRequestIntent(createPlatformActivityIntent);
                return;
            }
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
    }

    @JvmStatic
    public static final void setupAppCallForValidationError(@NotNull AppCall appCall, @Nullable FacebookException validationError) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        setupAppCallForErrorResult(appCall, validationError);
    }

    @JvmStatic
    public static final void setupAppCallForWebDialog(@NotNull AppCall appCall, @Nullable String actionName, @Nullable Bundle parameters) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Validate validate = Validate.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, actionName);
        bundle.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, parameters);
        Intent intent = new Intent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), actionName, NativeProtocol.getLatestKnownVersion(), bundle);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForWebFallbackDialog(@NotNull AppCall appCall, @Nullable Bundle parameters, @NotNull DialogFeature feature) {
        Uri buildUri;
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(feature, "feature");
        Validate validate = Validate.INSTANCE;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String name = feature.name();
        Uri dialogWebFallbackUri = INSTANCE.getDialogWebFallbackUri(feature);
        if (dialogWebFallbackUri != null) {
            int latestKnownVersion = NativeProtocol.getLatestKnownVersion();
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            String uuid = appCall.getCallId().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "appCall.callId.toString()");
            Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(uuid, latestKnownVersion, parameters);
            if (queryParamsForPlatformActivityIntentWebFallback != null) {
                if (dialogWebFallbackUri.isRelative()) {
                    Utility utility = Utility.INSTANCE;
                    buildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback);
                } else {
                    Utility utility2 = Utility.INSTANCE;
                    buildUri = Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
                }
                Bundle bundle = new Bundle();
                bundle.putString("url", buildUri.toString());
                bundle.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
                Intent intent = new Intent();
                NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), feature.getAction(), NativeProtocol.getLatestKnownVersion(), bundle);
                intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
                intent.setAction(FacebookDialogFragment.TAG);
                appCall.setRequestIntent(intent);
                return;
            }
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + '\'');
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [T, androidx.activity.result.d] */
    @JvmStatic
    public static final void startActivityForResultWithAndroidX(@NotNull androidx.activity.result.e registry, @Nullable final CallbackManager callbackManager, @NotNull Intent intent, final int requestCode) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(intent, "intent");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? i10 = registry.i(Intrinsics.stringPlus("facebook-dialog-request-", Integer.valueOf(requestCode)), new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.internal.DialogPresenter$startActivityForResultWithAndroidX$1
            @Override // androidx.activity.result.contract.ActivityResultContract
            @NotNull
            public Intent createIntent(@NotNull Context context, @NotNull Intent input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                return input;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.activity.result.contract.ActivityResultContract
            @NotNull
            public Pair<Integer, Intent> parseResult(int resultCode, @Nullable Intent intent2) {
                Pair<Integer, Intent> create = Pair.create(Integer.valueOf(resultCode), intent2);
                Intrinsics.checkNotNullExpressionValue(create, "create(resultCode, intent)");
                return create;
            }
        }, new ActivityResultCallback() { // from class: com.facebook.internal.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DialogPresenter.m٣٦٥startActivityForResultWithAndroidX$lambda2(CallbackManager.this, requestCode, objectRef, (Pair) obj);
            }
        });
        objectRef.element = i10;
        if (i10 != 0) {
            i10.launch(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: startActivityForResultWithAndroidX$lambda-2, reason: not valid java name */
    public static final void m٣٦٥startActivityForResultWithAndroidX$lambda2(CallbackManager callbackManager, int i10, Ref.ObjectRef launcher, Pair pair) {
        Intrinsics.checkNotNullParameter(launcher, "$launcher");
        if (callbackManager == null) {
            callbackManager = new CallbackManagerImpl();
        }
        Object obj = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj, "result.first");
        callbackManager.onActivityResult(i10, ((Number) obj).intValue(), (Intent) pair.second);
        androidx.activity.result.d dVar = (androidx.activity.result.d) launcher.element;
        if (dVar != null) {
            synchronized (dVar) {
                dVar.unregister();
                launcher.element = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @JvmStatic
    public static final void present(@NotNull AppCall appCall, @NotNull FragmentWrapper fragmentWrapper) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        fragmentWrapper.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @JvmStatic
    public static final void present(@NotNull AppCall appCall, @NotNull androidx.activity.result.e registry, @Nullable CallbackManager callbackManager) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intent requestIntent = appCall.getRequestIntent();
        if (requestIntent == null) {
            return;
        }
        startActivityForResultWithAndroidX(registry, callbackManager, requestIntent, appCall.getRequestCode());
        appCall.setPending();
    }
}

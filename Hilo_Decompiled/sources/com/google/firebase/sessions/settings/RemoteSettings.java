package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.dagger.Lazy;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(B7\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002J\u0011\u0010&\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "lazySettingsCache", "Ldagger/Lazy;", "Lcom/google/firebase/sessions/settings/SettingsCache;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Ldagger/Lazy;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "getSettingsCache", "()Lcom/google/firebase/sessions/settings/SettingsCache;", "clearCachedSettings", "", "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", "", "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRemoteSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,171:1\n120#2,10:172\n*S KotlinDebug\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings\n*L\n75#1:172,10\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class RemoteSettings implements SettingsProvider {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String FORWARD_SLASH_STRING = "/";

    @Deprecated
    @NotNull
    public static final String TAG = "SessionConfigFetcher";

    @NotNull
    private final ApplicationInfo appInfo;

    @NotNull
    private final CoroutineContext backgroundDispatcher;

    @NotNull
    private final CrashlyticsSettingsFetcher configsFetcher;

    @NotNull
    private final Mutex fetchInProgress;

    @NotNull
    private final FirebaseInstallationsApi firebaseInstallationsApi;

    @NotNull
    private final Lazy<SettingsCache> lazySettingsCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteSettings(@Background @NotNull CoroutineContext backgroundDispatcher, @NotNull FirebaseInstallationsApi firebaseInstallationsApi, @NotNull ApplicationInfo appInfo, @NotNull CrashlyticsSettingsFetcher configsFetcher, @NotNull Lazy<SettingsCache> lazySettingsCache) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(lazySettingsCache, "lazySettingsCache");
        this.backgroundDispatcher = backgroundDispatcher;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.lazySettingsCache = lazySettingsCache;
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        SettingsCache settingsCache = this.lazySettingsCache.get();
        Intrinsics.checkNotNullExpressionValue(settingsCache, "lazySettingsCache.get()");
        return settingsCache;
    }

    private final String removeForwardSlashesIn(String s10) {
        return new Regex("/").replace(s10, "");
    }

    @VisibleForTesting
    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new RemoteSettings$clearCachedSettings$1(this, null), 3, null);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    @Nullable
    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    @Nullable
    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    @Nullable
    /* renamed from: getSessionRestartTimeout-FghU774, reason: contains not printable characters */
    public Duration mo٤٤٢getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (sessionRestartTimeout != null) {
            Duration.Companion companion = Duration.INSTANCE;
            return Duration.m١٩٩٣boximpl(DurationKt.toDuration(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[Catch: all -> 0x0055, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0055, blocks: (B:32:0x0051, B:35:0x00c1, B:49:0x0097), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc A[Catch: all -> 0x0162, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0162, blocks: (B:33:0x00b3, B:38:0x00cc, B:47:0x008d, B:52:0x00a2), top: B:46:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097 A[Catch: all -> 0x0055, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0055, blocks: (B:32:0x0051, B:35:0x00c1, B:49:0x0097), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a2 A[Catch: all -> 0x0162, TRY_ENTER, TryCatch #0 {all -> 0x0162, blocks: (B:33:0x00b3, B:38:0x00cc, B:47:0x008d, B:52:0x00a2), top: B:46:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSettings(@NotNull Continuation<? super Unit> continuation) {
        RemoteSettings$updateSettings$1 remoteSettings$updateSettings$1;
        ?? r82;
        Mutex mutex;
        Object obj;
        Mutex mutex2;
        RemoteSettings remoteSettings;
        String fid;
        Object obj2;
        try {
            try {
                if (continuation instanceof RemoteSettings$updateSettings$1) {
                    remoteSettings$updateSettings$1 = (RemoteSettings$updateSettings$1) continuation;
                    int i10 = remoteSettings$updateSettings$1.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        remoteSettings$updateSettings$1.label = i10 - Integer.MIN_VALUE;
                        Object obj3 = remoteSettings$updateSettings$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        r82 = remoteSettings$updateSettings$1.label;
                        if (r82 == 0) {
                            if (r82 != 1) {
                                if (r82 != 2) {
                                    if (r82 == 3) {
                                        mutex = (Mutex) remoteSettings$updateSettings$1.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj3);
                                            obj2 = null;
                                        } catch (Throwable th) {
                                            th = th;
                                            obj = null;
                                            mutex.unlock(obj);
                                            throw th;
                                        }
                                        try {
                                            Unit unit = Unit.INSTANCE;
                                            mutex.unlock(obj2);
                                            return Unit.INSTANCE;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obj = null;
                                            mutex.unlock(obj);
                                            throw th;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex2 = (Mutex) remoteSettings$updateSettings$1.L$1;
                                remoteSettings = (RemoteSettings) remoteSettings$updateSettings$1.L$0;
                                ResultKt.throwOnFailure(obj3);
                                fid = ((InstallationId) obj3).getFid();
                                if (!Intrinsics.areEqual(fid, "")) {
                                    Log.w(TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                                    Unit unit2 = Unit.INSTANCE;
                                    mutex2.unlock((Object) null);
                                    return unit2;
                                }
                                Pair pair = TuplesKt.to("X-Crashlytics-Installation-ID", fid);
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String format = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                                Pair pair2 = TuplesKt.to("X-Crashlytics-Device-Model", remoteSettings.removeForwardSlashesIn(format));
                                String INCREMENTAL = Build.VERSION.INCREMENTAL;
                                Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                                Pair pair3 = TuplesKt.to("X-Crashlytics-OS-Build-Version", remoteSettings.removeForwardSlashesIn(INCREMENTAL));
                                String RELEASE = Build.VERSION.RELEASE;
                                Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                                Map<String, String> mapOf = MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("X-Crashlytics-OS-Display-Version", remoteSettings.removeForwardSlashesIn(RELEASE)), TuplesKt.to("X-Crashlytics-API-Client-Version", remoteSettings.appInfo.getSessionSdkVersion()));
                                Log.d(TAG, "Fetching settings from server.");
                                CrashlyticsSettingsFetcher crashlyticsSettingsFetcher = remoteSettings.configsFetcher;
                                obj2 = null;
                                RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings, null);
                                RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                                remoteSettings$updateSettings$1.L$0 = mutex2;
                                remoteSettings$updateSettings$1.L$1 = null;
                                remoteSettings$updateSettings$1.label = 3;
                                if (crashlyticsSettingsFetcher.doConfigFetch(mapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, remoteSettings$updateSettings$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutex = mutex2;
                                Unit unit3 = Unit.INSTANCE;
                                mutex.unlock(obj2);
                                return Unit.INSTANCE;
                            }
                            mutex2 = (Mutex) remoteSettings$updateSettings$1.L$1;
                            remoteSettings = (RemoteSettings) remoteSettings$updateSettings$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                        } else {
                            ResultKt.throwOnFailure(obj3);
                            if (!this.fetchInProgress.isLocked() && !getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions()) {
                                return Unit.INSTANCE;
                            }
                            Mutex mutex3 = this.fetchInProgress;
                            remoteSettings$updateSettings$1.L$0 = this;
                            remoteSettings$updateSettings$1.L$1 = mutex3;
                            remoteSettings$updateSettings$1.label = 1;
                            if (mutex3.lock((Object) null, remoteSettings$updateSettings$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mutex2 = mutex3;
                            remoteSettings = this;
                        }
                        if (remoteSettings.getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions()) {
                            Log.d(TAG, "Remote settings cache not expired. Using cached values.");
                            Unit unit4 = Unit.INSTANCE;
                            mutex2.unlock((Object) null);
                            return unit4;
                        }
                        InstallationId.Companion companion = InstallationId.INSTANCE;
                        FirebaseInstallationsApi firebaseInstallationsApi = remoteSettings.firebaseInstallationsApi;
                        remoteSettings$updateSettings$1.L$0 = remoteSettings;
                        remoteSettings$updateSettings$1.L$1 = mutex2;
                        remoteSettings$updateSettings$1.label = 2;
                        obj3 = companion.create(firebaseInstallationsApi, remoteSettings$updateSettings$1);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fid = ((InstallationId) obj3).getFid();
                        if (!Intrinsics.areEqual(fid, "")) {
                        }
                    }
                }
                if (remoteSettings.getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions()) {
                }
            } catch (Throwable th3) {
                th = th3;
                mutex = mutex2;
                obj = null;
                mutex.unlock(obj);
                throw th;
            }
            if (r82 == 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            mutex = r82;
        }
        remoteSettings$updateSettings$1 = new RemoteSettings$updateSettings$1(this, continuation);
        Object obj32 = remoteSettings$updateSettings$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r82 = remoteSettings$updateSettings$1.label;
    }
}

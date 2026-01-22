package com.qhqc.lib.indicate;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\rJ\u001a\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/qhqc/lib/indicate/IndicateService;", "", "<init>", "()V", "getPackageName", "", "buildIndicateInfoSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIndicateAsync", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "getIndicateSync", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "lib_deviceIndicate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class IndicateService {

    @SuppressLint({"StaticFieldLeak"})
    public static Context mContext;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<IndicateService> mInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.qhqc.lib.indicate.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IndicateService mInstance_delegate$lambda$2;
            mInstance_delegate$lambda$2 = IndicateService.mInstance_delegate$lambda$2();
            return mInstance_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000bR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/qhqc/lib/indicate/IndicateService$Companion;", "", "<init>", "()V", "mInstance", "Lcom/qhqc/lib/indicate/IndicateService;", "getMInstance", "()Lcom/qhqc/lib/indicate/IndicateService;", "mInstance$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getInstance", "logEnable", "", "enable", "", "init", "applicationContext", "lib_deviceIndicate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final IndicateService getMInstance() {
            return (IndicateService) IndicateService.mInstance$delegate.getValue();
        }

        @JvmStatic
        @NotNull
        public final IndicateService getInstance() {
            return getMInstance();
        }

        @NotNull
        public final Context getMContext() {
            Context context = IndicateService.mContext;
            if (context != null) {
                return context;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            return null;
        }

        public final void init(@NotNull Context applicationContext) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            setMContext(applicationContext);
        }

        public final void logEnable(boolean enable) {
            LogUtils.INSTANCE.setLogEnable(enable);
        }

        public final void setMContext(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            IndicateService.mContext = context;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildIndicateInfoSync(Continuation<? super String> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("package_name", getPackageName());
        IndicateIdUtils indicateIdUtils = IndicateIdUtils.INSTANCE;
        Companion companion = INSTANCE;
        jSONObject.put("app_signature_hash", indicateIdUtils.getAppSignature(companion.getMContext()));
        BuildInfoUtil buildInfoUtil = BuildInfoUtil.INSTANCE;
        jSONObject.put("build_info", buildInfoUtil.getBuildInfo());
        jSONObject.put("build_info_variable", buildInfoUtil.getBuildInfoVariable());
        jSONObject.put("android_id", indicateIdUtils.getAndroidId());
        jSONObject.put("sim", indicateIdUtils.getSimInfo(companion.getMContext()).toString());
        try {
            if (!AdvertisingIdClient.getAdvertisingIdInfo(companion.getMContext()).isLimitAdTrackingEnabled()) {
                jSONObject.put("g_ad_id", AdvertisingIdClient.getAdvertisingIdInfo(companion.getMContext()).getId());
            }
        } catch (Exception unused) {
        }
        jSONObject.put("indicate_uuid", IndicateIdUtils.INSTANCE.loadUUId());
        Result.Companion companion2 = Result.INSTANCE;
        safeContinuation.resumeWith(Result.m٥٤٤constructorimpl(jSONObject.toString()));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ void getIndicateAsync$default(IndicateService indicateService, CoroutineScope coroutineScope, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        indicateService.getIndicateAsync(coroutineScope, function1);
    }

    public static /* synthetic */ Object getIndicateSync$default(IndicateService indicateService, CoroutineScope coroutineScope, Continuation continuation, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineScope = null;
        }
        return indicateService.getIndicateSync(coroutineScope, continuation);
    }

    @JvmStatic
    @NotNull
    public static final IndicateService getInstance() {
        return INSTANCE.getInstance();
    }

    private final String getPackageName() {
        String packageName = INSTANCE.getMContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IndicateService mInstance_delegate$lambda$2() {
        return new IndicateService();
    }

    public final void getIndicateAsync(@Nullable CoroutineScope scope, @NotNull Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Flow onEach = FlowKt.onEach(FlowKt.catch(FlowKt.flowOn(FlowKt.flow(new IndicateService$getIndicateAsync$1(this, null)), Dispatchers.getIO()), new IndicateService$getIndicateAsync$2(block, null)), new IndicateService$getIndicateAsync$3(block, null));
        if (scope == null) {
            scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        }
        FlowKt.launchIn(onEach, scope);
    }

    @Nullable
    public final Object getIndicateSync(@Nullable CoroutineScope coroutineScope, @NotNull Continuation<? super String> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        getIndicateAsync(coroutineScope, new Function1<String, Unit>() { // from class: com.qhqc.lib.indicate.IndicateService$getIndicateSync$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(Result.m٥٤٤constructorimpl(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}

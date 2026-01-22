package com.qiahao.base_common.utils;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.opensource.svgaplayer.SVGAParser;
import java.net.URL;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ(\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/qiahao/base_common/utils/SafeSVGAParser;", "", "<init>", "()V", "TAG", "", "svgaScope", "Lkotlinx/coroutines/CoroutineScope;", "decodeFromURL", "Lkotlinx/coroutines/Job;", "url", "Ljava/net/URL;", "completion", "Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "timeoutSeconds", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "decodeFromAssets", "assetName", "decodeFromURLCancellable", "Lcom/qiahao/base_common/utils/CancellableSVGAJob;", "decodeFromAssetsCancellable", "cancelAll", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SafeSVGAParser {

    @NotNull
    private static final String TAG = "SafeSVGAParser";

    @NotNull
    public static final SafeSVGAParser INSTANCE = new SafeSVGAParser();

    @NotNull
    private static final CoroutineScope svgaScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    private SafeSVGAParser() {
    }

    public static /* synthetic */ Job decodeFromAssets$default(SafeSVGAParser safeSVGAParser, String str, SVGAParser.ParseCompletion parseCompletion, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 10;
        }
        return safeSVGAParser.decodeFromAssets(str, parseCompletion, j10);
    }

    public static /* synthetic */ CancellableSVGAJob decodeFromAssetsCancellable$default(SafeSVGAParser safeSVGAParser, String str, SVGAParser.ParseCompletion parseCompletion, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 10;
        }
        return safeSVGAParser.decodeFromAssetsCancellable(str, parseCompletion, j10);
    }

    public static /* synthetic */ Job decodeFromURL$default(SafeSVGAParser safeSVGAParser, URL url, SVGAParser.ParseCompletion parseCompletion, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 10;
        }
        return safeSVGAParser.decodeFromURL(url, parseCompletion, j10);
    }

    public static /* synthetic */ CancellableSVGAJob decodeFromURLCancellable$default(SafeSVGAParser safeSVGAParser, URL url, SVGAParser.ParseCompletion parseCompletion, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 10;
        }
        return safeSVGAParser.decodeFromURLCancellable(url, parseCompletion, j10);
    }

    public final void cancelAll() {
        Job job = (Job) svgaScope.getCoroutineContext().get(Job.INSTANCE);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @NotNull
    public final Job decodeFromAssets(@NotNull String assetName, @NotNull SVGAParser.ParseCompletion completion, long timeoutSeconds) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(completion, "completion");
        launch$default = BuildersKt__Builders_commonKt.launch$default(svgaScope, null, null, new SafeSVGAParser$decodeFromAssets$1(timeoutSeconds, assetName, completion, null), 3, null);
        return launch$default;
    }

    @NotNull
    public final CancellableSVGAJob decodeFromAssetsCancellable(@NotNull String assetName, @NotNull SVGAParser.ParseCompletion completion, long timeoutSeconds) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CancellableSVGAJob(decodeFromAssets(assetName, completion, timeoutSeconds));
    }

    @NotNull
    public final Job decodeFromURL(@NotNull URL url, @NotNull SVGAParser.ParseCompletion completion, long timeoutSeconds) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(completion, "completion");
        launch$default = BuildersKt__Builders_commonKt.launch$default(svgaScope, null, null, new SafeSVGAParser$decodeFromURL$1(timeoutSeconds, url, completion, null), 3, null);
        return launch$default;
    }

    @NotNull
    public final CancellableSVGAJob decodeFromURLCancellable(@NotNull URL url, @NotNull SVGAParser.ParseCompletion completion, long timeoutSeconds) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new CancellableSVGAJob(decodeFromURL(url, completion, timeoutSeconds));
    }

    public static /* synthetic */ Job decodeFromAssets$default(SafeSVGAParser safeSVGAParser, LifecycleOwner lifecycleOwner, String str, SVGAParser.ParseCompletion parseCompletion, long j10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = 10;
        }
        return safeSVGAParser.decodeFromAssets(lifecycleOwner, str, parseCompletion, j10);
    }

    public static /* synthetic */ Job decodeFromURL$default(SafeSVGAParser safeSVGAParser, LifecycleOwner lifecycleOwner, URL url, SVGAParser.ParseCompletion parseCompletion, long j10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = 10;
        }
        return safeSVGAParser.decodeFromURL(lifecycleOwner, url, parseCompletion, j10);
    }

    @NotNull
    public final Job decodeFromAssets(@NotNull LifecycleOwner lifecycleOwner, @NotNull String assetName, @NotNull SVGAParser.ParseCompletion completion, long timeoutSeconds) {
        final Job launch$default;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(completion, "completion");
        launch$default = BuildersKt__Builders_commonKt.launch$default(svgaScope, null, null, new SafeSVGAParser$decodeFromAssets$job$1(timeoutSeconds, assetName, completion, null), 3, null);
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.qiahao.base_common.utils.SafeSVGAParser$decodeFromAssets$2
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.a(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
                owner.getLifecycle().removeObserver(this);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.c(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.d(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.e(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.f(this, lifecycleOwner2);
            }
        });
        return launch$default;
    }

    @NotNull
    public final Job decodeFromURL(@NotNull LifecycleOwner lifecycleOwner, @NotNull URL url, @NotNull SVGAParser.ParseCompletion completion, long timeoutSeconds) {
        final Job launch$default;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(completion, "completion");
        launch$default = BuildersKt__Builders_commonKt.launch$default(svgaScope, null, null, new SafeSVGAParser$decodeFromURL$job$1(timeoutSeconds, url, completion, null), 3, null);
        lifecycleOwner.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: com.qiahao.base_common.utils.SafeSVGAParser$decodeFromURL$2
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.a(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                Job.DefaultImpls.cancel$default(Job.this, (CancellationException) null, 1, (Object) null);
                owner.getLifecycle().removeObserver(this);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.c(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.d(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.e(this, lifecycleOwner2);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                androidx.lifecycle.f.f(this, lifecycleOwner2);
            }
        });
        return launch$default;
    }
}

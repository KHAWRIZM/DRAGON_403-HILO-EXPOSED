package com.qiahao.base_common.wedgit.videoView;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.VideoView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.wedgit.videoView.LifecycleVideoView;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014J\u0006\u0010 \u001a\u00020\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/wedgit/videoView/LifecycleVideoView;", "Landroid/widget/VideoView;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loopJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isLooping", "", "videoUri", "Landroid/net/Uri;", "bindLifecycle", "", "lifecycle", "setLooping", "looping", "onResume", "owner", "onStop", "onDestroy", "safePlay", ShareConstants.MEDIA_URI, "safeStop", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LifecycleVideoView extends VideoView implements DefaultLifecycleObserver {
    private boolean isLooping;

    @Nullable
    private LifecycleOwner lifecycleOwner;

    @Nullable
    private Job loopJob;

    @NotNull
    private final CoroutineScope scope;

    @Nullable
    private Uri videoUri;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifecycleVideoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(final LifecycleVideoView lifecycleVideoView, MediaPlayer mediaPlayer) {
        lifecycleVideoView.post(new Runnable() { // from class: hb.f
            @Override // java.lang.Runnable
            public final void run() {
                LifecycleVideoView.lambda$1$lambda$0(LifecycleVideoView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(final LifecycleVideoView lifecycleVideoView, MediaPlayer mediaPlayer) {
        int i10;
        double videoWidth = mediaPlayer.getVideoWidth();
        double videoHeight = mediaPlayer.getVideoHeight();
        if (videoWidth > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && videoHeight > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            final ViewGroup.LayoutParams layoutParams = lifecycleVideoView.getLayoutParams();
            final int i11 = lifecycleVideoView.getResources().getDisplayMetrics().widthPixels;
            int i12 = lifecycleVideoView.getResources().getDisplayMetrics().heightPixels;
            BaseApplication.Companion companion = BaseApplication.INSTANCE;
            BaseApplication companion2 = companion.getInstance();
            int i13 = 0;
            if (companion2 != null) {
                i10 = companion2.getMNavigationHeight();
            } else {
                i10 = 0;
            }
            int i14 = i12 + i10;
            BaseApplication companion3 = companion.getInstance();
            if (companion3 != null) {
                i13 = companion3.getMStatusHeight();
            }
            final int i15 = i14 + i13 + 5;
            if (i11 > 0 && i15 > 0) {
                final int i16 = i11 / i15;
                final double d10 = videoWidth / videoHeight;
                lifecycleVideoView.post(new Runnable() { // from class: hb.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        LifecycleVideoView.lambda$3$lambda$2(i16, d10, layoutParams, i11, i15, lifecycleVideoView);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(LifecycleVideoView lifecycleVideoView) {
        if (lifecycleVideoView.isLooping) {
            lifecycleVideoView.seekTo(0);
            lifecycleVideoView.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$3$lambda$2(int i10, double d10, ViewGroup.LayoutParams layoutParams, int i11, int i12, LifecycleVideoView lifecycleVideoView) {
        if (i10 > d10) {
            layoutParams.height = (int) (i11 / d10);
        } else {
            layoutParams.width = (int) (i12 * d10);
        }
        lifecycleVideoView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void safePlay$lambda$5$lambda$4(LifecycleVideoView lifecycleVideoView, Uri uri) {
        lifecycleVideoView.setVideoURI(uri);
        lifecycleVideoView.start();
    }

    public final void bindLifecycle(@NotNull LifecycleOwner lifecycle) {
        Lifecycle.State state;
        Lifecycle lifecycle2;
        Lifecycle lifecycle3;
        Lifecycle lifecycle4;
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        setBackgroundColor(0);
        this.lifecycleOwner = lifecycle;
        if (lifecycle != null && (lifecycle4 = lifecycle.getLifecycle()) != null) {
            lifecycle4.removeObserver(this);
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle3 = lifecycleOwner.getLifecycle()) != null) {
            lifecycle3.addObserver(this);
        }
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        if (lifecycleOwner2 != null && (lifecycle2 = lifecycleOwner2.getLifecycle()) != null) {
            state = lifecycle2.getState();
        } else {
            state = null;
        }
        if (state == Lifecycle.State.DESTROYED) {
            stopPlayback();
            CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
            Job job = this.loopJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        f.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, "owner");
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycleOwner = null;
        stopPlayback();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        Job job = this.loopJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loopJob = null;
        setOnPreparedListener(null);
        setOnCompletionListener(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        f.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.isLooping) {
            safePlay(this.videoUri);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        f.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        f.f(this, owner);
        pause();
    }

    public final void safePlay(@Nullable final Uri uri) {
        if (uri != null) {
            this.videoUri = uri;
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                post(new Runnable() { // from class: hb.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        LifecycleVideoView.safePlay$lambda$5$lambda$4(LifecycleVideoView.this, uri);
                    }
                });
            } else {
                setVideoURI(uri);
                start();
            }
        }
    }

    public final void safeStop() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            post(new Runnable() { // from class: hb.e
                @Override // java.lang.Runnable
                public final void run() {
                    LifecycleVideoView.this.stopPlayback();
                }
            });
        } else {
            stopPlayback();
        }
    }

    public final void setLooping(boolean looping) {
        this.isLooping = looping;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifecycleVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LifecycleVideoView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifecycleVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: hb.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                LifecycleVideoView._init_$lambda$1(LifecycleVideoView.this, mediaPlayer);
            }
        });
        setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: hb.d
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                LifecycleVideoView._init_$lambda$3(LifecycleVideoView.this, mediaPlayer);
            }
        });
    }
}

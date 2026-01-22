package com.tencent.qgame.animplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.taobao.accs.common.Constants;
import com.tencent.qgame.animplayer.AnimView$animProxyListener$2;
import com.tencent.qgame.animplayer.file.AssetsFileContainer;
import com.tencent.qgame.animplayer.file.FileContainer;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.inter.IAnimListener;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import com.tencent.qgame.animplayer.inter.OnResourceClickListener;
import com.tencent.qgame.animplayer.mask.MaskConfig;
import com.tencent.qgame.animplayer.mix.MixAnimPlugin;
import com.tencent.qgame.animplayer.textureview.InnerTextureView;
import com.tencent.qgame.animplayer.util.ALog;
import com.tencent.qgame.animplayer.util.IScaleType;
import com.tencent.qgame.animplayer.util.ScaleType;
import com.tencent.qgame.animplayer.util.ScaleTypeUtil;
import java.io.File;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000e\b\u0016\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001dB%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018H\u0007J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010!H\u0016J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020(H\u0014J\b\u00101\u001a\u00020(H\u0014J(\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0014J \u00107\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0016J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J \u0010;\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0012\u0010>\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010?\u001a\u00020(2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\tH\u0016J\u0010\u0010D\u001a\u00020(2\u0006\u0010E\u001a\u00020\tH\u0016J\u0010\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020\u0018H\u0016J\u0012\u0010H\u001a\u00020(2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010K\u001a\u00020(2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\tH\u0007J\u0018\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010R\u001a\u00020(2\u0006\u0010W\u001a\u00020\u0016H\u0016J\u0010\u0010R\u001a\u00020(2\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020(H\u0016J\u0018\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020\u00182\u0006\u0010]\u001a\u00020\u0018H\u0016J\u0016\u0010^\u001a\u00020(2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020(0`H\u0002J\u0012\u0010a\u001a\u00020(2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b$\u0010%¨\u0006e"}, d2 = {"Lcom/tencent/qgame/animplayer/AnimView;", "Lcom/tencent/qgame/animplayer/IAnimView;", "Landroid/widget/FrameLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animListener", "Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "animProxyListener", "com/tencent/qgame/animplayer/AnimView$animProxyListener$2$1", "getAnimProxyListener", "()Lcom/tencent/qgame/animplayer/AnimView$animProxyListener$2$1;", "animProxyListener$delegate", "Lkotlin/Lazy;", "innerTextureView", "Lcom/tencent/qgame/animplayer/textureview/InnerTextureView;", "lastFile", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "needPrepareTextureView", "", "onSizeChangedCalled", "player", "Lcom/tencent/qgame/animplayer/AnimPlayer;", "prepareTextureViewRunnable", "Ljava/lang/Runnable;", "scaleTypeUtil", "Lcom/tencent/qgame/animplayer/util/ScaleTypeUtil;", "surface", "Landroid/graphics/SurfaceTexture;", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "uiHandler$delegate", "enableAutoTxtColorFill", "", "enable", "enableVersion1", "getRealSize", "Lkotlin/Pair;", "getSurfaceTexture", "hide", "isRunning", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onSurfaceTextureAvailable", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "prepareTextureView", "setAnimListener", "setFetchResource", "fetchResource", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "setFps", "fps", "setLoop", "playLoop", "setMute", "isMute", "setOnResourceClickListener", "resourceClickListener", "Lcom/tencent/qgame/animplayer/inter/OnResourceClickListener;", "setScaleType", "scaleType", "Lcom/tencent/qgame/animplayer/util/IScaleType;", "type", "Lcom/tencent/qgame/animplayer/util/ScaleType;", "setVideoMode", Constants.KEY_MODE, "startPlay", "assetManager", "Landroid/content/res/AssetManager;", "assetsPath", "", "fileContainer", "file", "Ljava/io/File;", "stopPlay", "supportMask", "isSupport", "isEdgeBlur", "ui", "f", "Lkotlin/Function0;", "updateMaskConfig", "maskConfig", "Lcom/tencent/qgame/animplayer/mask/MaskConfig;", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AnimView extends FrameLayout implements IAnimView, TextureView.SurfaceTextureListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AnimView.class), "uiHandler", "getUiHandler()Landroid/os/Handler;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AnimView.class), "animProxyListener", "getAnimProxyListener()Lcom/tencent/qgame/animplayer/AnimView$animProxyListener$2$1;"))};
    private static final String TAG = "AnimPlayer.AnimView";
    private HashMap _$_findViewCache;
    private IAnimListener animListener;

    /* renamed from: animProxyListener$delegate, reason: from kotlin metadata */
    private final Lazy animProxyListener;
    private InnerTextureView innerTextureView;
    private IFileContainer lastFile;
    private boolean needPrepareTextureView;
    private boolean onSizeChangedCalled;
    private AnimPlayer player;
    private final Runnable prepareTextureViewRunnable;
    private final ScaleTypeUtil scaleTypeUtil;
    private SurfaceTexture surface;

    /* renamed from: uiHandler$delegate, reason: from kotlin metadata */
    private final Lazy uiHandler;

    @JvmOverloads
    public AnimView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    public static final /* synthetic */ AnimPlayer access$getPlayer$p(AnimView animView) {
        AnimPlayer animPlayer = animView.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return animPlayer;
    }

    private final AnimView$animProxyListener$2.AnonymousClass1 getAnimProxyListener() {
        Lazy lazy = this.animProxyListener;
        KProperty kProperty = $$delegatedProperties[1];
        return (AnimView$animProxyListener$2.AnonymousClass1) lazy.getValue();
    }

    private final Handler getUiHandler() {
        Lazy lazy = this.uiHandler;
        KProperty kProperty = $$delegatedProperties[0];
        return (Handler) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hide() {
        IFileContainer iFileContainer = this.lastFile;
        if (iFileContainer != null) {
            iFileContainer.close();
        }
        ui(new Function0<Unit>() { // from class: com.tencent.qgame.animplayer.AnimView$hide$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٥٩invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٥٩invoke() {
                AnimView.this.removeAllViews();
            }
        });
    }

    private final void ui(final Function0<Unit> f) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            f.invoke();
        } else {
            getUiHandler().post(new Runnable() { // from class: com.tencent.qgame.animplayer.AnimView$ui$1
                @Override // java.lang.Runnable
                public final void run() {
                    f.invoke();
                }
            });
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void enableAutoTxtColorFill(boolean enable) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        MixAnimPlugin mixAnimPlugin = animPlayer.getPluginManager().getMixAnimPlugin();
        if (mixAnimPlugin != null) {
            mixAnimPlugin.setAutoTxtColorFill(enable);
        }
    }

    @Deprecated(message = "Compatible older version mp4, default false")
    public final void enableVersion1(boolean enable) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setEnableVersion1(enable);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    @NotNull
    public Pair<Integer, Integer> getRealSize() {
        return this.scaleTypeUtil.getRealSize();
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    @Nullable
    public SurfaceTexture getSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        InnerTextureView innerTextureView = this.innerTextureView;
        if (innerTextureView == null || (surfaceTexture = innerTextureView.getSurfaceTexture()) == null) {
            return this.surface;
        }
        return surfaceTexture;
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public boolean isRunning() {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        return animPlayer.isRunning();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IFileContainer iFileContainer;
        ALog.INSTANCE.i(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setDetachedFromWindow(false);
        AnimPlayer animPlayer2 = this.player;
        if (animPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        if (animPlayer2.getPlayLoop() > 0 && (iFileContainer = this.lastFile) != null) {
            startPlay(iFileContainer);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ALog.INSTANCE.i(TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setDetachedFromWindow(true);
        AnimPlayer animPlayer2 = this.player;
        if (animPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer2.onSurfaceTextureDestroyed();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ALog.INSTANCE.i(TAG, "onSizeChanged w=" + w + ", h=" + h);
        this.scaleTypeUtil.setLayoutSize(w, h);
        this.onSizeChangedCalled = true;
        if (this.needPrepareTextureView) {
            this.needPrepareTextureView = false;
            prepareTextureView();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
        ALog.INSTANCE.i(TAG, "onSurfaceTextureAvailable width=" + width + " height=" + height);
        this.surface = surface;
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.onSurfaceTextureAvailable(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
        ALog.INSTANCE.i(TAG, "onSurfaceTextureDestroyed");
        this.surface = null;
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.onSurfaceTextureDestroyed();
        getUiHandler().post(new Runnable() { // from class: com.tencent.qgame.animplayer.AnimView$onSurfaceTextureDestroyed$1
            @Override // java.lang.Runnable
            public final void run() {
                InnerTextureView innerTextureView;
                innerTextureView = AnimView.this.innerTextureView;
                if (innerTextureView != null) {
                    innerTextureView.setSurfaceTextureListener(null);
                }
                AnimView.this.innerTextureView = null;
                AnimView.this.removeAllViews();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
        ALog.INSTANCE.i(TAG, "onSurfaceTextureSizeChanged " + width + " x " + height);
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.onSurfaceTextureSizeChanged(width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void prepareTextureView() {
        if (this.onSizeChangedCalled) {
            getUiHandler().post(this.prepareTextureViewRunnable);
        } else {
            ALog.INSTANCE.e(TAG, "onSizeChanged not called");
            this.needPrepareTextureView = true;
        }
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setAnimListener(@Nullable IAnimListener animListener) {
        this.animListener = animListener;
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setFetchResource(@Nullable IFetchResource fetchResource) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        MixAnimPlugin mixAnimPlugin = animPlayer.getPluginManager().getMixAnimPlugin();
        if (mixAnimPlugin != null) {
            mixAnimPlugin.setResourceRequest(fetchResource);
        }
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setFps(int fps) {
        ALog.INSTANCE.i(TAG, "setFps=" + fps);
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setDefaultFps(fps);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setLoop(int playLoop) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setPlayLoop(playLoop);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setMute(boolean isMute) {
        ALog.INSTANCE.e(TAG, "set mute=" + isMute);
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setMute(isMute);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setOnResourceClickListener(@Nullable OnResourceClickListener resourceClickListener) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        MixAnimPlugin mixAnimPlugin = animPlayer.getPluginManager().getMixAnimPlugin();
        if (mixAnimPlugin != null) {
            mixAnimPlugin.setResourceClickListener(resourceClickListener);
        }
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setScaleType(@NotNull ScaleType type) {
        this.scaleTypeUtil.setCurrentScaleType(type);
    }

    @Deprecated(message = "Compatible older version mp4")
    public final void setVideoMode(int mode) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setVideoMode(mode);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void startPlay(@NotNull File file) {
        try {
            startPlay(new FileContainer(file));
        } catch (Throwable unused) {
            getAnimProxyListener().onFailed(10007, Constant.ERROR_MSG_FILE_ERROR);
            getAnimProxyListener().onVideoComplete();
        }
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void stopPlay() {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.stopPlay();
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void supportMask(boolean isSupport, boolean isEdgeBlur) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.setSupportMaskBoolean(isSupport);
        AnimPlayer animPlayer2 = this.player;
        if (animPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer2.setMaskEdgeBlurBoolean(isEdgeBlur);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void updateMaskConfig(@Nullable MaskConfig maskConfig) {
        AnimPlayer animPlayer = this.player;
        if (animPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("player");
        }
        animPlayer.updateMaskConfig(maskConfig);
    }

    @JvmOverloads
    public AnimView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void setScaleType(@NotNull IScaleType scaleType) {
        this.scaleTypeUtil.setScaleTypeImpl(scaleType);
    }

    public /* synthetic */ AnimView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmOverloads
    public AnimView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uiHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.tencent.qgame.animplayer.AnimView$uiHandler$2
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m١٦١invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.scaleTypeUtil = new ScaleTypeUtil();
        this.animProxyListener = LazyKt.lazy(new Function0<AnimView$animProxyListener$2.AnonymousClass1>() { // from class: com.tencent.qgame.animplayer.AnimView$animProxyListener$2

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016¨\u0006\u0011"}, d2 = {"com/tencent/qgame/animplayer/AnimView$animProxyListener$2$1", "Lcom/tencent/qgame/animplayer/inter/IAnimListener;", "onFailed", "", "errorType", "", "errorMsg", "", "onVideoComplete", "onVideoConfigReady", "", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "onVideoDestroy", "onVideoRender", "frameIndex", "onVideoStart", "animplayer_release"}, k = 1, mv = {1, 1, 15})
            /* renamed from: com.tencent.qgame.animplayer.AnimView$animProxyListener$2$1, reason: invalid class name */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
            public static final class AnonymousClass1 implements IAnimListener {
                AnonymousClass1() {
                }

                @Override // com.tencent.qgame.animplayer.inter.IAnimListener
                public void onFailed(int errorType, @Nullable String errorMsg) {
                    IAnimListener iAnimListener;
                    iAnimListener = AnimView.this.animListener;
                    if (iAnimListener != null) {
                        iAnimListener.onFailed(errorType, errorMsg);
                    }
                }

                @Override // com.tencent.qgame.animplayer.inter.IAnimListener
                public void onVideoComplete() {
                    IAnimListener iAnimListener;
                    AnimView.this.hide();
                    iAnimListener = AnimView.this.animListener;
                    if (iAnimListener != null) {
                        iAnimListener.onVideoComplete();
                    }
                }

                @Override // com.tencent.qgame.animplayer.inter.IAnimListener
                public boolean onVideoConfigReady(@NotNull AnimConfig config) {
                    ScaleTypeUtil scaleTypeUtil;
                    IAnimListener iAnimListener;
                    scaleTypeUtil = AnimView.this.scaleTypeUtil;
                    scaleTypeUtil.setVideoSize(config.getWidth(), config.getHeight());
                    iAnimListener = AnimView.this.animListener;
                    if (iAnimListener != null) {
                        return iAnimListener.onVideoConfigReady(config);
                    }
                    return IAnimListener.DefaultImpls.onVideoConfigReady(this, config);
                }

                @Override // com.tencent.qgame.animplayer.inter.IAnimListener
                public void onVideoDestroy() {
                    IAnimListener iAnimListener;
                    AnimView.this.hide();
                    iAnimListener = AnimView.this.animListener;
                    if (iAnimListener != null) {
                        iAnimListener.onVideoDestroy();
                    }
                }

                @Override // com.tencent.qgame.animplayer.inter.IAnimListener
                public void onVideoRender(int frameIndex, @Nullable AnimConfig config) {
                    IAnimListener iAnimListener;
                    iAnimListener = AnimView.this.animListener;
                    if (iAnimListener != null) {
                        iAnimListener.onVideoRender(frameIndex, config);
                    }
                }

                @Override // com.tencent.qgame.animplayer.inter.IAnimListener
                public void onVideoStart() {
                    IAnimListener iAnimListener;
                    iAnimListener = AnimView.this.animListener;
                    if (iAnimListener != null) {
                        iAnimListener.onVideoStart();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final AnonymousClass1 m١٥٨invoke() {
                return new AnonymousClass1();
            }
        });
        this.prepareTextureViewRunnable = new Runnable() { // from class: com.tencent.qgame.animplayer.AnimView$prepareTextureViewRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                ScaleTypeUtil scaleTypeUtil;
                InnerTextureView innerTextureView;
                AnimView.this.removeAllViews();
                AnimView animView = AnimView.this;
                InnerTextureView innerTextureView2 = new InnerTextureView(context, null, 0, 6, null);
                innerTextureView2.setPlayer(AnimView.access$getPlayer$p(AnimView.this));
                innerTextureView2.setOpaque(false);
                innerTextureView2.setSurfaceTextureListener(AnimView.this);
                scaleTypeUtil = AnimView.this.scaleTypeUtil;
                innerTextureView2.setLayoutParams(scaleTypeUtil.getLayoutParam(innerTextureView2));
                animView.innerTextureView = innerTextureView2;
                AnimView animView2 = AnimView.this;
                innerTextureView = animView2.innerTextureView;
                animView2.addView(innerTextureView);
            }
        };
        hide();
        AnimPlayer animPlayer = new AnimPlayer(this);
        this.player = animPlayer;
        animPlayer.setAnimListener(getAnimProxyListener());
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void startPlay(@NotNull AssetManager assetManager, @NotNull String assetsPath) {
        try {
            startPlay(new AssetsFileContainer(assetManager, assetsPath));
        } catch (Throwable unused) {
            getAnimProxyListener().onFailed(10007, Constant.ERROR_MSG_FILE_ERROR);
            getAnimProxyListener().onVideoComplete();
        }
    }

    @Override // com.tencent.qgame.animplayer.IAnimView
    public void startPlay(@NotNull final IFileContainer fileContainer) {
        ui(new Function0<Unit>() { // from class: com.tencent.qgame.animplayer.AnimView$startPlay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٦٠invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٦٠invoke() {
                if (AnimView.this.getVisibility() != 0) {
                    ALog.INSTANCE.e("AnimPlayer.AnimView", "AnimView is GONE, can't play");
                } else {
                    if (!AnimView.access$getPlayer$p(AnimView.this).isRunning()) {
                        AnimView.this.lastFile = fileContainer;
                        AnimView.access$getPlayer$p(AnimView.this).startPlay(fileContainer);
                        return;
                    }
                    ALog.INSTANCE.e("AnimPlayer.AnimView", "is running can not start");
                }
            }
        });
    }
}

package com.qiahao.base_common.player.svga;

import android.content.Context;
import android.util.AttributeSet;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.component.ICleared;
import com.oudi.core.exceptions.SuperException;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadManager;
import com.qiahao.base_common.download.DownloadRequest;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.utils.PathHelper;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J*\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0006\u0010 \u001a\u00020\u0012J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010\"\u001a\u00020\u000fH\u0002J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010$\u001a\u00020\u0017J\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020\u0017J\b\u0010'\u001a\u00020\u0017H\u0016J\u0019\u0010(\u001a\u0004\u0018\u00010\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010)R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/qiahao/base_common/player/svga/SVGAView;", "Lcom/opensource/svgaplayer/SVGAImageView;", "Lcom/oudi/core/component/ICleared;", "Lcom/oudi/utils/log/ILog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "url", "", "downloadingUrl", "parseCompletion", "Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "defaultCallBack", "Lcom/oudi/core/callback/SuperCallBack;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "init", "", "loadAssets", "path", "callback", "loadFile", "loadFileResources", "loadUrl", "isAnimationReuse", "", "getParseCompletion", "getDefaultCallBack", "getDownloadTag", "isAnimatingForUrl", "pause", "stop", "start", "onCleared", "isDynamicDecoration", "(Ljava/lang/String;)Ljava/lang/Boolean;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SVGAView extends SVGAImageView implements ICleared, ILog {

    @Nullable
    private SuperCallBack<SVGAVideoEntity> defaultCallBack;

    @Nullable
    private volatile String downloadingUrl;

    @Nullable
    private SVGAParser.ParseCompletion parseCompletion;

    @Nullable
    private String url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String getDownloadTag() {
        return String.valueOf(hashCode());
    }

    private final void init(Context context, AttributeSet attrs, int defStyleAttr) {
    }

    private final Boolean isDynamicDecoration(String url) {
        if (url == null) {
            return null;
        }
        return Boolean.valueOf(StringsKt.endsWith$default(url, PathHelper.SUFFIX_TYPE_SVGA, false, 2, (Object) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadAssets$default(SVGAView sVGAView, String str, SuperCallBack superCallBack, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                superCallBack = null;
            }
            sVGAView.loadAssets(str, superCallBack);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAssets");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadFile$default(SVGAView sVGAView, String str, SuperCallBack superCallBack, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                superCallBack = null;
            }
            sVGAView.loadFile(str, superCallBack);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFileResources(String path) {
        try {
            SVGAParser.decodeFromInputStream$default(SVGAParser.INSTANCE.shareParser(), new BufferedInputStream(new FileInputStream(path)), path, getParseCompletion(), true, null, null, 48, null);
        } catch (Exception e10) {
            SuperCallBack<SVGAVideoEntity> superCallBack = this.defaultCallBack;
            if (superCallBack != null) {
                superCallBack.onFailure(e10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void loadUrl$default(SVGAView sVGAView, String str, boolean z10, SuperCallBack superCallBack, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            if ((i10 & 4) != 0) {
                superCallBack = null;
            }
            sVGAView.loadUrl(str, z10, superCallBack);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUrl");
    }

    @NotNull
    public final SuperCallBack<SVGAVideoEntity> getDefaultCallBack() {
        if (this.defaultCallBack == null) {
            this.defaultCallBack = new SuperCallBack<SVGAVideoEntity>() { // from class: com.qiahao.base_common.player.svga.SVGAView$getDefaultCallBack$1
                @Override // com.oudi.core.component.IDispatchers
                public CoroutineContext getCoroutineContext() {
                    return SuperCallBack.DefaultImpls.getCoroutineContext(this);
                }

                @Override // com.oudi.core.callback.SuperCallBack
                public void onFailure(Throwable throwable) {
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                }

                @Override // com.oudi.core.callback.SuperCallBack
                public void onSuccess(SVGAVideoEntity result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    SVGAView.this.stop();
                    SVGAView.this.setVideoItem(result);
                    SVGAView.this.start();
                }
            };
        }
        SuperCallBack<SVGAVideoEntity> superCallBack = this.defaultCallBack;
        Intrinsics.checkNotNull(superCallBack);
        return superCallBack;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @NotNull
    public final SVGAParser.ParseCompletion getParseCompletion() {
        if (this.parseCompletion == null) {
            this.parseCompletion = new SVGAParser.ParseCompletion() { // from class: com.qiahao.base_common.player.svga.SVGAView$getParseCompletion$1
                @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    SVGAView.this.getDefaultCallBack().onSuccess(videoItem);
                }

                @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                public void onError() {
                    ILog.DefaultImpls.logE$default((ILog) SVGAView.this, "ParseCompletion - onError()", (String) null, false, 6, (Object) null);
                    SVGAView.this.getDefaultCallBack().onFailure(new SuperException(0, 1, (DefaultConstructorMarker) null));
                }
            };
        }
        SVGAParser.ParseCompletion parseCompletion = this.parseCompletion;
        Intrinsics.checkNotNull(parseCompletion);
        return parseCompletion;
    }

    public final boolean isAnimatingForUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (getIsAnimating() && Intrinsics.areEqual(this.url, url)) {
            return true;
        }
        return false;
    }

    public final void loadAssets(@NotNull String path, @Nullable SuperCallBack<SVGAVideoEntity> callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.url = null;
        this.defaultCallBack = callback;
        SVGAParser.INSTANCE.shareParser().decodeFromAssets(path, getParseCompletion());
    }

    public final void loadFile(@NotNull String path, @Nullable SuperCallBack<SVGAVideoEntity> callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.url = null;
        this.defaultCallBack = callback;
        loadFileResources(path);
    }

    public final void loadUrl(@NotNull String url, boolean isAnimationReuse, @Nullable final SuperCallBack<SVGAVideoEntity> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (isAnimationReuse && isAnimatingForUrl(url)) {
            return;
        }
        if (Intrinsics.areEqual(isDynamicDecoration(url), Boolean.TRUE)) {
            this.defaultCallBack = callback;
            this.url = url;
            if (this.downloadingUrl != null) {
                if (Intrinsics.areEqual(this.downloadingUrl, url)) {
                    return;
                } else {
                    DownloadManager.INSTANCE.stopTag(getDownloadTag());
                }
            }
            this.downloadingUrl = url;
            DownloadManager.INSTANCE.download(DownloadRequest.Companion.build$default(DownloadRequest.INSTANCE, url, PathHelper.INSTANCE.getAppPrivateDownloadPath(), getDownloadTag(), null, null, null, 56, null), new DownloadListener() { // from class: com.qiahao.base_common.player.svga.SVGAView$loadUrl$1
                @Override // com.qiahao.base_common.download.DownloadListener
                public void onCompleted(DownloadTask task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    DownloadListener.DefaultImpls.onCompleted(this, task);
                    SVGAView.this.downloadingUrl = null;
                    SVGAView sVGAView = SVGAView.this;
                    String filePath = task.getFilePath();
                    if (filePath == null) {
                        filePath = "";
                    }
                    sVGAView.loadFileResources(filePath);
                }

                @Override // com.qiahao.base_common.download.DownloadListener
                public void onError(DownloadTask task, Throwable throwable) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    DownloadListener.DefaultImpls.onError(this, task, throwable);
                    SVGAView.this.downloadingUrl = null;
                    SuperCallBack<SVGAVideoEntity> superCallBack = callback;
                    if (superCallBack != null) {
                        superCallBack.onFailure(throwable);
                    }
                }

                @Override // com.qiahao.base_common.download.DownloadListener
                public void onProgress(DownloadTask downloadTask, int i10, int i11) {
                    DownloadListener.DefaultImpls.onProgress(this, downloadTask, i10, i11);
                }
            });
            return;
        }
        ImageKtxKt.loadImage$default(this, url, null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, 65534, null);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        this.defaultCallBack = null;
        this.downloadingUrl = null;
        this.url = null;
        DownloadManager.INSTANCE.stopTag(getDownloadTag());
        stop();
        clearAnimation();
    }

    public final void pause() {
        super.pauseAnimation();
    }

    public final void start() {
        super.startAnimation();
    }

    public final void stop() {
        super.stopAnimation(true);
        setImageDrawable(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet, i10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}

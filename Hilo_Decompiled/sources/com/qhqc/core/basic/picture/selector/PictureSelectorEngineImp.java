package com.qhqc.core.basic.picture.selector;

import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.engine.CompressEngine;
import com.luck.picture.lib.engine.CompressFileEngine;
import com.luck.picture.lib.engine.ExtendLoaderEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.engine.PictureSelectorEngine;
import com.luck.picture.lib.engine.SandboxFileEngine;
import com.luck.picture.lib.engine.UriToFileTransformEngine;
import com.luck.picture.lib.engine.VideoPlayerEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PictureSelectorEngineImp;", "Lcom/luck/picture/lib/engine/PictureSelectorEngine;", "()V", "createCompressEngine", "Lcom/luck/picture/lib/engine/CompressEngine;", "createCompressFileEngine", "Lcom/luck/picture/lib/engine/CompressFileEngine;", "createImageLoaderEngine", "Lcom/luck/picture/lib/engine/ImageEngine;", "createLayoutResourceListener", "Lcom/luck/picture/lib/interfaces/OnInjectLayoutResourceListener;", "createLoaderDataEngine", "Lcom/luck/picture/lib/engine/ExtendLoaderEngine;", "createSandboxFileEngine", "Lcom/luck/picture/lib/engine/SandboxFileEngine;", "createUriToFileTransformEngine", "Lcom/luck/picture/lib/engine/UriToFileTransformEngine;", "createVideoPlayerEngine", "Lcom/luck/picture/lib/engine/VideoPlayerEngine;", "getResultCallbackListener", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "onCreateLoader", "Lcom/luck/picture/lib/basic/IBridgeLoaderFactory;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PictureSelectorEngineImp implements PictureSelectorEngine {
    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public CompressEngine createCompressEngine() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public CompressFileEngine createCompressFileEngine() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @NotNull
    public ImageEngine createImageLoaderEngine() {
        return GlideEngine.INSTANCE.getInstance();
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public OnInjectLayoutResourceListener createLayoutResourceListener() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public ExtendLoaderEngine createLoaderDataEngine() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public SandboxFileEngine createSandboxFileEngine() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public UriToFileTransformEngine createUriToFileTransformEngine() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public VideoPlayerEngine<?> createVideoPlayerEngine() {
        return null;
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @NotNull
    public OnResultCallbackListener<LocalMedia> getResultCallbackListener() {
        return new OnResultCallbackListener<LocalMedia>() { // from class: com.qhqc.core.basic.picture.selector.PictureSelectorEngineImp$getResultCallbackListener$1
            @Override // com.luck.picture.lib.interfaces.OnResultCallbackListener
            public void onCancel() {
            }

            @Override // com.luck.picture.lib.interfaces.OnResultCallbackListener
            public void onResult(@Nullable ArrayList<LocalMedia> result) {
            }
        };
    }

    @Override // com.luck.picture.lib.engine.PictureSelectorEngine
    @Nullable
    public IBridgeLoaderFactory onCreateLoader() {
        return null;
    }
}

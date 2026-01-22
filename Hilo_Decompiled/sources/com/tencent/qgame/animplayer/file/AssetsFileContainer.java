package com.tencent.qgame.animplayer.file;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaExtractor;
import com.tencent.qgame.animplayer.util.ALog;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tencent/qgame/animplayer/file/AssetsFileContainer;", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "assetManager", "Landroid/content/res/AssetManager;", "assetsPath", "", "(Landroid/content/res/AssetManager;Ljava/lang/String;)V", "assetFd", "Landroid/content/res/AssetFileDescriptor;", "assetsInputStream", "Landroid/content/res/AssetManager$AssetInputStream;", "close", "", "closeRandomRead", "read", "", "b", "", "off", "len", "setDataSource", "extractor", "Landroid/media/MediaExtractor;", "skip", "pos", "", "startRandomRead", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AssetsFileContainer implements IFileContainer {
    private static final String TAG = "AnimPlayer.FileContainer";
    private final AssetFileDescriptor assetFd;
    private final AssetManager.AssetInputStream assetsInputStream;

    public AssetsFileContainer(@NotNull AssetManager assetManager, @NotNull String str) {
        AssetFileDescriptor openFd = assetManager.openFd(str);
        Intrinsics.checkExpressionValueIsNotNull(openFd, "assetManager.openFd(assetsPath)");
        this.assetFd = openFd;
        InputStream open = assetManager.open(str, 2);
        if (open != null) {
            this.assetsInputStream = (AssetManager.AssetInputStream) open;
            ALog.INSTANCE.i(TAG, "AssetsFileContainer init");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.res.AssetManager.AssetInputStream");
    }

    @Override // com.tencent.qgame.animplayer.file.IFileContainer
    public void close() {
        this.assetFd.close();
        this.assetsInputStream.close();
    }

    @Override // com.tencent.qgame.animplayer.file.IFileContainer
    public void closeRandomRead() {
        this.assetsInputStream.close();
    }

    @Override // com.tencent.qgame.animplayer.file.IFileContainer
    public int read(@NotNull byte[] b, int off, int len) {
        return this.assetsInputStream.read(b, off, len);
    }

    @Override // com.tencent.qgame.animplayer.file.IFileContainer
    public void setDataSource(@NotNull MediaExtractor extractor) {
        if (this.assetFd.getDeclaredLength() < 0) {
            extractor.setDataSource(this.assetFd.getFileDescriptor());
        } else {
            extractor.setDataSource(this.assetFd.getFileDescriptor(), this.assetFd.getStartOffset(), this.assetFd.getDeclaredLength());
        }
    }

    @Override // com.tencent.qgame.animplayer.file.IFileContainer
    public void skip(long pos) {
        this.assetsInputStream.skip(pos);
    }

    @Override // com.tencent.qgame.animplayer.file.IFileContainer
    public void startRandomRead() {
    }
}

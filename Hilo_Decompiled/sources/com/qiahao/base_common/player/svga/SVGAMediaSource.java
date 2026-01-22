package com.qiahao.base_common.player.svga;

import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.qiahao.base_common.player.PlayerMediaSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010%\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010'\u001a\u0004\u0018\u00010\u0017J\u000e\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0017J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020 H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/qiahao/base_common/player/svga/SVGAMediaSource;", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "<init>", "()V", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "filePath", "getFilePath", "setFilePath", "assetsFilePath", "getAssetsFilePath", "setAssetsFilePath", "loopCount", "", ViewHierarchyConstants.TAG_KEY, "", "scaleType", "Landroid/widget/ImageView$ScaleType;", "resourceParser", "Lcom/qiahao/base_common/player/svga/SVGAResourceParser;", "dynamicEntity", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "getDynamicEntity", "()Lcom/opensource/svgaplayer/SVGADynamicEntity;", "setDynamicEntity", "(Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "getLoopCount", "setLoopCount", "", "count", "setLoop", "getScaleType", "setScaleType", "setTag", "getTag", "getResourceParser", "setResourceParser", "parser", "toString", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class SVGAMediaSource implements PlayerMediaSource {

    @Nullable
    private String assetsFilePath;

    @Nullable
    private SVGADynamicEntity dynamicEntity;

    @Nullable
    private String filePath;
    private int loopCount;

    @Nullable
    private SVGAResourceParser resourceParser;

    @Nullable
    private ImageView.ScaleType scaleType;

    @Nullable
    private Object tag;

    @Nullable
    private String url;

    public SVGAMediaSource() {
        this.loopCount = 1;
    }

    @Nullable
    public final String getAssetsFilePath() {
        return this.assetsFilePath;
    }

    @Nullable
    public final SVGADynamicEntity getDynamicEntity() {
        return this.dynamicEntity;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    @Nullable
    public final SVGAResourceParser getResourceParser() {
        return this.resourceParser;
    }

    @NotNull
    public final ImageView.ScaleType getScaleType() {
        ImageView.ScaleType scaleType = this.scaleType;
        if (scaleType == null) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        return scaleType;
    }

    @Override // com.qiahao.base_common.player.PlayerMediaSource
    @Nullable
    public Object getTag() {
        return this.tag;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Override // com.qiahao.base_common.player.PlayerMediaSource, com.oudi.utils.ICleared
    public void onCleared() {
        PlayerMediaSource.DefaultImpls.onCleared(this);
        SVGAResourceParser sVGAResourceParser = this.resourceParser;
        if (sVGAResourceParser != null) {
            sVGAResourceParser.onCleared();
        }
        this.resourceParser = null;
    }

    public final void setAssetsFilePath(@Nullable String str) {
        this.assetsFilePath = str;
    }

    public final void setDynamicEntity(@Nullable SVGADynamicEntity sVGADynamicEntity) {
        this.dynamicEntity = sVGADynamicEntity;
    }

    public final void setFilePath(@Nullable String str) {
        this.filePath = str;
    }

    public final void setLoop() {
        this.loopCount = -1;
    }

    public final void setLoopCount(int count) {
        this.loopCount = count;
    }

    public final void setResourceParser(@NotNull SVGAResourceParser parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.resourceParser = parser;
    }

    public final void setScaleType(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.scaleType = scaleType;
    }

    @Override // com.qiahao.base_common.player.PlayerMediaSource
    public void setTag(@Nullable Object tag) {
        this.tag = tag;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "SVGAMediaSource{url:" + this.url + ",filePath:" + this.filePath + ",loopCount:" + this.loopCount + ",tag:" + this.tag + "}";
    }

    public SVGAMediaSource(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.loopCount = 1;
        this.url = url;
    }
}

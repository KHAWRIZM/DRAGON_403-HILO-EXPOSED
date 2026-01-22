package com.qiahao.base_common.player.vap;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.core.component.ICleared;
import com.qiahao.base_common.player.PlayerMediaSource;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import com.tencent.qgame.animplayer.util.ScaleType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/qiahao/base_common/player/vap/VapMediaSource;", "Lcom/qiahao/base_common/player/PlayerMediaSource;", "<init>", "()V", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "filePath", "getFilePath", "setFilePath", "loopCount", "", ViewHierarchyConstants.TAG_KEY, "", "scaleType", "Lcom/tencent/qgame/animplayer/util/ScaleType;", "fetchResource", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "getLoopCount", "setLoopCount", "", "count", "setLoop", "getFetchResource", "setFetchResource", "resource", "getScaleType", "setScaleType", "setTag", "getTag", "toString", "onCleared", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VapMediaSource implements PlayerMediaSource {

    @Nullable
    private IFetchResource fetchResource;

    @Nullable
    private String filePath;
    private int loopCount;

    @Nullable
    private ScaleType scaleType;

    @Nullable
    private Object tag;

    @Nullable
    private String url;

    public VapMediaSource() {
        this.loopCount = 1;
    }

    @Nullable
    public final IFetchResource getFetchResource() {
        return this.fetchResource;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    @NotNull
    public final ScaleType getScaleType() {
        ScaleType scaleType = this.scaleType;
        if (scaleType == null) {
            return ScaleType.CENTER_CROP;
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
        ICleared iCleared;
        PlayerMediaSource.DefaultImpls.onCleared(this);
        ICleared iCleared2 = this.fetchResource;
        if (iCleared2 instanceof ICleared) {
            iCleared = iCleared2;
        } else {
            iCleared = null;
        }
        if (iCleared != null) {
            iCleared.onCleared();
        }
        this.fetchResource = null;
    }

    public final void setFetchResource(@NotNull IFetchResource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.fetchResource = resource;
    }

    public final void setFilePath(@Nullable String str) {
        this.filePath = str;
    }

    public final void setLoop() {
        this.loopCount = Integer.MAX_VALUE;
    }

    public final void setLoopCount(int count) {
        this.loopCount = count;
    }

    public final void setScaleType(@NotNull ScaleType scaleType) {
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
        return "VapMediaSource{url:" + this.url + ",filePath:" + this.filePath + ",loopCount:" + this.loopCount + ",scaleType:" + this.scaleType + ",tag:" + this.tag + "}";
    }

    public VapMediaSource(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.loopCount = 1;
        this.url = url;
    }
}

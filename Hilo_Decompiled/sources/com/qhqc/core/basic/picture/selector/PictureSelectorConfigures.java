package com.qhqc.core.basic.picture.selector;

import com.luck.picture.lib.config.SelectMimeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000bR\u001a\u0010)\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013¨\u00061"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PictureSelectorConfigures;", "", "b", "Lcom/qhqc/core/basic/picture/selector/PictureSelectorConfigures$Companion$Builder;", "(Lcom/qhqc/core/basic/picture/selector/PictureSelectorConfigures$Companion$Builder;)V", "()V", "cropHeight", "", "getCropHeight", "()I", "setCropHeight", "(I)V", "cropWidth", "getCropWidth", "setCropWidth", "isCompress", "", "()Z", "setCompress", "(Z)V", "isEnableCrop", "setEnableCrop", "isGif", "setGif", "isPreviewImage", "setPreviewImage", "mLeastCompressSize", "getMLeastCompressSize", "setMLeastCompressSize", "mVideoMaxSecond", "getMVideoMaxSecond", "setMVideoMaxSecond", "mVideoMinSecond", "getMVideoMinSecond", "setMVideoMinSecond", "maxSelect", "getMaxSelect", "setMaxSelect", "showType", "getShowType", "setShowType", "withCamera", "getWithCamera", "setWithCamera", "setCropWH", "", "w", "h", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PictureSelectorConfigures {
    private int cropHeight;
    private int cropWidth;
    private boolean isCompress;
    private boolean isEnableCrop;
    private boolean isGif;
    private boolean isPreviewImage;
    private int mLeastCompressSize;
    private int mVideoMaxSecond;
    private int mVideoMinSecond;
    private int maxSelect;
    private int showType;
    private boolean withCamera;

    public PictureSelectorConfigures(@NotNull Companion.Builder b10) {
        Intrinsics.checkNotNullParameter(b10, "b");
        this.cropWidth = 400;
        this.cropHeight = 400;
        this.isEnableCrop = true;
        this.maxSelect = 1;
        this.showType = SelectMimeType.ofImage();
        this.isCompress = true;
        this.mVideoMinSecond = 1;
        this.mVideoMaxSecond = 30;
        this.mLeastCompressSize = 5;
        this.cropWidth = b10.getCropWidth();
        this.cropHeight = b10.getCropHeight();
        this.isEnableCrop = b10.getIsEnableCrop();
        this.isPreviewImage = b10.getIsPreviewImage();
        this.isGif = b10.getIsGif();
        this.withCamera = b10.getWithCamera();
        this.maxSelect = b10.getMaxSelect();
        this.showType = b10.getShowType();
        this.isCompress = b10.getIsCompress();
        this.mVideoMaxSecond = b10.getVideoMaxSecond();
        this.mVideoMinSecond = b10.getVideoMinSecond();
        this.mLeastCompressSize = b10.getMLeastCompressSize();
    }

    public final int getCropHeight() {
        return this.cropHeight;
    }

    public final int getCropWidth() {
        return this.cropWidth;
    }

    public final int getMLeastCompressSize() {
        return this.mLeastCompressSize;
    }

    public final int getMVideoMaxSecond() {
        return this.mVideoMaxSecond;
    }

    public final int getMVideoMinSecond() {
        return this.mVideoMinSecond;
    }

    public final int getMaxSelect() {
        return this.maxSelect;
    }

    public final int getShowType() {
        return this.showType;
    }

    public final boolean getWithCamera() {
        return this.withCamera;
    }

    /* renamed from: isCompress, reason: from getter */
    public final boolean getIsCompress() {
        return this.isCompress;
    }

    /* renamed from: isEnableCrop, reason: from getter */
    public final boolean getIsEnableCrop() {
        return this.isEnableCrop;
    }

    /* renamed from: isGif, reason: from getter */
    public final boolean getIsGif() {
        return this.isGif;
    }

    /* renamed from: isPreviewImage, reason: from getter */
    public final boolean getIsPreviewImage() {
        return this.isPreviewImage;
    }

    public final void setCompress(boolean z10) {
        this.isCompress = z10;
    }

    public final void setCropHeight(int i10) {
        this.cropHeight = i10;
    }

    public final void setCropWH(int w10, int h10) {
        this.cropWidth = w10;
        this.cropHeight = h10;
    }

    public final void setCropWidth(int i10) {
        this.cropWidth = i10;
    }

    public final void setEnableCrop(boolean z10) {
        this.isEnableCrop = z10;
    }

    public final void setGif(boolean z10) {
        this.isGif = z10;
    }

    public final void setMLeastCompressSize(int i10) {
        this.mLeastCompressSize = i10;
    }

    public final void setMVideoMaxSecond(int i10) {
        this.mVideoMaxSecond = i10;
    }

    public final void setMVideoMinSecond(int i10) {
        this.mVideoMinSecond = i10;
    }

    public final void setMaxSelect(int i10) {
        this.maxSelect = i10;
    }

    public final void setPreviewImage(boolean z10) {
        this.isPreviewImage = z10;
    }

    public final void setShowType(int i10) {
        this.showType = i10;
    }

    public final void setWithCamera(boolean z10) {
        this.withCamera = z10;
    }

    public PictureSelectorConfigures() {
        this.cropWidth = 400;
        this.cropHeight = 400;
        this.isEnableCrop = true;
        this.maxSelect = 1;
        this.showType = SelectMimeType.ofImage();
        this.isCompress = true;
        this.mVideoMinSecond = 1;
        this.mVideoMaxSecond = 30;
        this.mLeastCompressSize = 5;
    }
}

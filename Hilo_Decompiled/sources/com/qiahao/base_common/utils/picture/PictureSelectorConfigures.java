package com.qiahao.base_common.utils.picture;

import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\n\"\u0004\b&\u0010\fR\u001a\u0010'\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\n\"\u0004\b)\u0010\fR\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/qiahao/base_common/utils/picture/PictureSelectorConfigures;", "", "b", "Lcom/qiahao/base_common/utils/picture/PictureSelectorConfigures$Companion$Builder;", "<init>", "(Lcom/qiahao/base_common/utils/picture/PictureSelectorConfigures$Companion$Builder;)V", "()V", "cropWidth", "", "getCropWidth", "()I", "setCropWidth", "(I)V", "cropHeight", "getCropHeight", "setCropHeight", "isEnableCrop", "", "()Z", "setEnableCrop", "(Z)V", "isPreviewImage", "setPreviewImage", "isGif", "setGif", "maxSelect", "getMaxSelect", "setMaxSelect", "withCamera", "getWithCamera", "setWithCamera", "showType", "getShowType", "setShowType", "isCompress", "setCompress", "mVideoMinSecond", "getMVideoMinSecond", "setMVideoMinSecond", "mVideoMaxSecond", "getMVideoMaxSecond", "setMVideoMaxSecond", "mFileMaxSize", "", "getMFileMaxSize", "()J", "setMFileMaxSize", "(J)V", "mSelectList", "", "Lcom/luck/picture/lib/entity/LocalMedia;", "getMSelectList", "()Ljava/util/List;", "setMSelectList", "(Ljava/util/List;)V", "setCropWH", "", "w", "h", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PictureSelectorConfigures {
    private int cropHeight;
    private int cropWidth;
    private boolean isCompress;
    private boolean isEnableCrop;
    private boolean isGif;
    private boolean isPreviewImage;
    private long mFileMaxSize;

    @Nullable
    private List<? extends LocalMedia> mSelectList;
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
        this.mSelectList = b10.getSelectList();
        this.mFileMaxSize = b10.getFileMaxSize();
    }

    public final int getCropHeight() {
        return this.cropHeight;
    }

    public final int getCropWidth() {
        return this.cropWidth;
    }

    public final long getMFileMaxSize() {
        return this.mFileMaxSize;
    }

    @Nullable
    public final List<LocalMedia> getMSelectList() {
        return this.mSelectList;
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

    public final void setMFileMaxSize(long j10) {
        this.mFileMaxSize = j10;
    }

    public final void setMSelectList(@Nullable List<? extends LocalMedia> list) {
        this.mSelectList = list;
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
    }
}

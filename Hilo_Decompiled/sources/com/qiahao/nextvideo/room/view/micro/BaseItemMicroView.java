package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\"H&J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u001cJ\u0016\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010(\u001a\u00020\"H\u0016J\u000e\u0010)\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010*\u001a\u00020\"H&J\b\u0010+\u001a\u00020\"H&J\b\u0010,\u001a\u00020\"H&J\u0010\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\"H\u0014J3\u00101\u001a\u00020\"2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u000206¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000204J\u0018\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u000204H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006A"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mMicBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "getMMicBean", "()Lcom/qiahao/nextvideo/data/model/MicroBean;", "setMMicBean", "(Lcom/qiahao/nextvideo/data/model/MicroBean;)V", "mPosition", "", "getMPosition", "()I", "setMPosition", "(I)V", "svipLevel", "getSvipLevel", "()Ljava/lang/Integer;", "setSvipLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mOnMicroItemClickListener", "Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;", "getMOnMicroItemClickListener", "()Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;", "setMOnMicroItemClickListener", "(Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;)V", "initView", "", "updateView", "setMicroItemClickListener", "onMicroItemClickListener", "updateDate", "micBean", "updateScore", "refreshSVIP", "stopMicSVGA", "recoverMicSVGA", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "onDetachedFromWindow", "refreshMusicSvga", "nobleLevel", "musicSVGA", "Lcom/opensource/svgaplayer/SVGAImageView;", "isMusic", "", "micForbid", "(Ljava/lang/Integer;Lcom/opensource/svgaplayer/SVGAImageView;ZZ)V", "refreshEmptyMic", "emptyMicImage", "Landroid/widget/ImageView;", "emptyMicSVGA", "loadSVGFromAssets", "assetName", "imageView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseItemMicroView extends FrameLayout {

    @NotNull
    private static final String TAG = "BaseItemMicroView";

    @Nullable
    private MicroBean mMicBean;

    @Nullable
    private OnMicroItemClickListener mOnMicroItemClickListener;
    private int mPosition;

    @Nullable
    private Integer svipLevel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseItemMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void loadSVGFromAssets(final String assetName, final SVGAImageView imageView) {
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets(assetName, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.BaseItemMicroView$loadSVGFromAssets$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    if (BaseItemMicroView.this.isAttachedToWindow()) {
                        imageView.setVideoItem(videoItem);
                        imageView.startAnimation();
                    }
                }

                public void onError() {
                    Log.e("BaseItemMicroView", "Failed to decode SVG from assets: " + assetName);
                    if (BaseItemMicroView.this.isAttachedToWindow()) {
                        imageView.setVisibility(8);
                    }
                }
            });
        } catch (Exception e) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放麦位皮肤失败: " + e.getMessage(), false, 4, (Object) null);
            if (isAttachedToWindow()) {
                imageView.setVisibility(8);
            }
        }
    }

    public static /* synthetic */ void refreshMusicSvga$default(BaseItemMicroView baseItemMicroView, Integer num, SVGAImageView sVGAImageView, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            baseItemMicroView.refreshMusicSvga(num, sVGAImageView, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshMusicSvga");
    }

    @Nullable
    public final MicroBean getMMicBean() {
        return this.mMicBean;
    }

    @Nullable
    public final OnMicroItemClickListener getMOnMicroItemClickListener() {
        return this.mOnMicroItemClickListener;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    @Nullable
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    public abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mOnMicroItemClickListener = null;
        Log.d(TAG, "onDetachedFromWindow: ----");
    }

    public abstract void recoverMicSVGA();

    public final void refreshEmptyMic(@NotNull ImageView emptyMicImage, @NotNull SVGAImageView emptyMicSVGA) {
        Intrinsics.checkNotNullParameter(emptyMicImage, "emptyMicImage");
        Intrinsics.checkNotNullParameter(emptyMicSVGA, "emptyMicSVGA");
        String micSVGA = SvipTypeUtils.INSTANCE.getMicSVGA(this.svipLevel);
        if (micSVGA == null) {
            emptyMicSVGA.stopAnimation(true);
            emptyMicImage.setVisibility(0);
            emptyMicSVGA.setVisibility(8);
        } else {
            emptyMicImage.setVisibility(8);
            emptyMicSVGA.setVisibility(0);
            loadSVGFromAssets(micSVGA, emptyMicSVGA);
        }
    }

    public final void refreshMusicSvga(@Nullable Integer nobleLevel, @NotNull SVGAImageView musicSVGA, boolean isMusic, boolean micForbid) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(musicSVGA, "musicSVGA");
        if (isMusic && !micForbid) {
            if (nobleLevel != null) {
                i = nobleLevel.intValue();
            } else {
                i = 0;
            }
            if (i < 10) {
                str = "svga/music_default.svga";
            } else {
                str = "svga/music_gold.svga";
            }
            loadSVGFromAssets(str, musicSVGA);
            return;
        }
        musicSVGA.stopAnimation(true);
        musicSVGA.setVisibility(8);
    }

    public final void refreshSVIP(int svipLevel) {
        this.svipLevel = Integer.valueOf(svipLevel);
        updateView();
    }

    public final void setMMicBean(@Nullable MicroBean microBean) {
        this.mMicBean = microBean;
    }

    public final void setMOnMicroItemClickListener(@Nullable OnMicroItemClickListener onMicroItemClickListener) {
        this.mOnMicroItemClickListener = onMicroItemClickListener;
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }

    public final void setMicroItemClickListener(@NotNull OnMicroItemClickListener onMicroItemClickListener) {
        Intrinsics.checkNotNullParameter(onMicroItemClickListener, "onMicroItemClickListener");
        Log.d(TAG, "onMicroItemClickListener: ----");
        this.mOnMicroItemClickListener = onMicroItemClickListener;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    public abstract void showFaceSvga(@NotNull String faceSVGAUrl);

    public abstract void showMicSpeakWaveAnim();

    public abstract void stopMicSVGA();

    public final void updateDate(@NotNull MicroBean micBean, int svipLevel) {
        Intrinsics.checkNotNullParameter(micBean, "micBean");
        this.svipLevel = Integer.valueOf(svipLevel);
        MicroBean microBean = this.mMicBean;
        if (microBean == null) {
            this.mMicBean = micBean;
            updateView();
        } else if (microBean != null && (!microBean.checkDataIsEqual(micBean))) {
            this.mMicBean = micBean;
            updateView();
        }
    }

    public void updateScore() {
    }

    public abstract void updateView();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseItemMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.svipLevel = 0;
        initView();
    }
}

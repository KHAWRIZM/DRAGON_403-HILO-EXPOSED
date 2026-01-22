package com.opensource.svgaplayer.drawer;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.os.Build;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.IClickAreaListener;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGASoundManager;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.drawer.SGVADrawer;
import com.opensource.svgaplayer.entities.SVGAAudioEntity;
import com.opensource.svgaplayer.entities.SVGAPathEntity;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u000267B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J \u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J\u001c\u0010$\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010%\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010&\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J,\u0010'\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000e2\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020 2\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u001cR\u00020\u00010.H\u0002J\"\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020 2\u0010\u0010-\u001a\f\u0012\b\u0012\u00060\u001cR\u00020\u00010.H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*H\u0002R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer;", "Lcom/opensource/svgaplayer/drawer/SGVADrawer;", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "dynamicItem", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;Lcom/opensource/svgaplayer/SVGADynamicEntity;)V", "beginIndexList", "", "", "[Ljava/lang/Boolean;", "drawTextCache", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "getDynamicItem", "()Lcom/opensource/svgaplayer/SVGADynamicEntity;", "endIndexList", "matrixScaleTempValues", "", "pathCache", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$PathCache;", "sharedValues", "Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$ShareValues;", "drawDynamic", "", "sprite", "Lcom/opensource/svgaplayer/drawer/SGVADrawer$SVGADrawerSprite;", "canvas", "Landroid/graphics/Canvas;", "frameIndex", "", "drawFrame", "scaleType", "Landroid/widget/ImageView$ScaleType;", "drawImage", "drawShape", "drawSprite", "drawTextOnBitmap", "drawingBitmap", "frameMatrix", "Landroid/graphics/Matrix;", "isMatteBegin", "spriteIndex", "sprites", "", "isMatteEnd", "matrixScale", "", "matrix", "playAudio", "shareFrameMatrix", "transform", "PathCache", "ShareValues", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGACanvasDrawer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGACanvasDrawer.kt\ncom/opensource/svgaplayer/drawer/SVGACanvasDrawer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,560:1\n1864#2,3:561\n1864#2,3:564\n1864#2,3:567\n1855#2,2:570\n1855#2,2:572\n*S KotlinDebug\n*F\n+ 1 SVGACanvasDrawer.kt\ncom/opensource/svgaplayer/drawer/SVGACanvasDrawer\n*L\n45#1:561,3\n95#1:564,3\n125#1:567,3\n158#1:570,2\n338#1:572,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGACanvasDrawer extends SGVADrawer {

    @Nullable
    private Boolean[] beginIndexList;

    @NotNull
    private final HashMap<String, Bitmap> drawTextCache;

    @NotNull
    private final SVGADynamicEntity dynamicItem;

    @Nullable
    private Boolean[] endIndexList;

    @NotNull
    private final float[] matrixScaleTempValues;

    @NotNull
    private final PathCache pathCache;

    @NotNull
    private final ShareValues sharedValues;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$PathCache;", "", "()V", "cache", "Ljava/util/HashMap;", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "Landroid/graphics/Path;", "Lkotlin/collections/HashMap;", "canvasHeight", "", "canvasWidth", "buildPath", "shape", "onSizeChanged", "", "canvas", "Landroid/graphics/Canvas;", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class PathCache {

        @NotNull
        private final HashMap<SVGAVideoShapeEntity, Path> cache = new HashMap<>();
        private int canvasHeight;
        private int canvasWidth;

        @NotNull
        public final Path buildPath(@NotNull SVGAVideoShapeEntity shape) {
            Intrinsics.checkNotNullParameter(shape, "shape");
            if (!this.cache.containsKey(shape)) {
                Path path = new Path();
                Path shapePath = shape.getShapePath();
                Intrinsics.checkNotNull(shapePath);
                path.set(shapePath);
                this.cache.put(shape, path);
            }
            Path path2 = this.cache.get(shape);
            Intrinsics.checkNotNull(path2);
            return path2;
        }

        public final void onSizeChanged(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.canvasWidth != canvas.getWidth() || this.canvasHeight != canvas.getHeight()) {
                this.cache.clear();
            }
            this.canvasWidth = canvas.getWidth();
            this.canvasHeight = canvas.getHeight();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SVGACanvasDrawer$ShareValues;", "", "()V", "shareMatteCanvas", "Landroid/graphics/Canvas;", "shareMattePaint", "Landroid/graphics/Paint;", "sharedMatrix", "Landroid/graphics/Matrix;", "sharedMatrix2", "sharedMatteBitmap", "Landroid/graphics/Bitmap;", "sharedPaint", "sharedPath", "Landroid/graphics/Path;", "sharedPath2", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class ShareValues {

        @Nullable
        private Canvas shareMatteCanvas;

        @Nullable
        private Bitmap sharedMatteBitmap;

        @NotNull
        private final Paint sharedPaint = new Paint();

        @NotNull
        private final Path sharedPath = new Path();

        @NotNull
        private final Path sharedPath2 = new Path();

        @NotNull
        private final Matrix sharedMatrix = new Matrix();

        @NotNull
        private final Matrix sharedMatrix2 = new Matrix();

        @NotNull
        private final Paint shareMattePaint = new Paint();

        @NotNull
        public final Canvas shareMatteCanvas(int width, int height) {
            if (this.shareMatteCanvas == null) {
                this.sharedMatteBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8);
            }
            Bitmap bitmap = this.sharedMatteBitmap;
            Intrinsics.checkNotNull(bitmap);
            return new Canvas(bitmap);
        }

        @NotNull
        public final Paint shareMattePaint() {
            this.shareMattePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return this.shareMattePaint;
        }

        @NotNull
        public final Matrix sharedMatrix() {
            this.sharedMatrix.reset();
            return this.sharedMatrix;
        }

        @NotNull
        public final Matrix sharedMatrix2() {
            this.sharedMatrix2.reset();
            return this.sharedMatrix2;
        }

        @NotNull
        public final Bitmap sharedMatteBitmap() {
            Bitmap bitmap = this.sharedMatteBitmap;
            Intrinsics.checkNotNull(bitmap, "null cannot be cast to non-null type android.graphics.Bitmap");
            return bitmap;
        }

        @NotNull
        public final Paint sharedPaint() {
            this.sharedPaint.reset();
            return this.sharedPaint;
        }

        @NotNull
        public final Path sharedPath() {
            this.sharedPath.reset();
            return this.sharedPath;
        }

        @NotNull
        public final Path sharedPath2() {
            this.sharedPath2.reset();
            return this.sharedPath2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGACanvasDrawer(@NotNull SVGAVideoEntity videoItem, @NotNull SVGADynamicEntity dynamicItem) {
        super(videoItem);
        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
        Intrinsics.checkNotNullParameter(dynamicItem, "dynamicItem");
        this.dynamicItem = dynamicItem;
        this.sharedValues = new ShareValues();
        this.drawTextCache = new HashMap<>();
        this.pathCache = new PathCache();
        this.matrixScaleTempValues = new float[16];
    }

    private final void drawDynamic(SGVADrawer.SVGADrawerSprite sprite, Canvas canvas, int frameIndex) {
        String str = sprite.get_imageKey();
        if (str == null) {
            return;
        }
        Function2<Canvas, Integer, Boolean> function2 = this.dynamicItem.getDynamicDrawer$lib_svga_release().get(str);
        if (function2 != null) {
            Matrix shareFrameMatrix = shareFrameMatrix(sprite.getFrameEntity().getTransform());
            canvas.save();
            canvas.concat(shareFrameMatrix);
            function2.invoke(canvas, Integer.valueOf(frameIndex));
            canvas.restore();
        }
        Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.dynamicItem.getDynamicDrawerSized$lib_svga_release().get(str);
        if (function4 != null) {
            Matrix shareFrameMatrix2 = shareFrameMatrix(sprite.getFrameEntity().getTransform());
            canvas.save();
            canvas.concat(shareFrameMatrix2);
            function4.invoke(canvas, Integer.valueOf(frameIndex), Integer.valueOf((int) sprite.getFrameEntity().getLayout().getWidth()), Integer.valueOf((int) sprite.getFrameEntity().getLayout().getHeight()));
            canvas.restore();
        }
    }

    private final void drawImage(SGVADrawer.SVGADrawerSprite sprite, Canvas canvas) {
        String str;
        String str2 = sprite.get_imageKey();
        if (str2 == null || Intrinsics.areEqual(this.dynamicItem.getDynamicHidden$lib_svga_release().get(str2), Boolean.TRUE)) {
            return;
        }
        if (StringsKt.endsWith$default(str2, ".matte", false, 2, (Object) null)) {
            str = str2.substring(0, str2.length() - 6);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = str2;
        }
        Bitmap bitmap = this.dynamicItem.getDynamicImage$lib_svga_release().get(str);
        if (bitmap == null && (bitmap = getVideoItem().getImageMap$lib_svga_release().get(str)) == null) {
            return;
        }
        Bitmap bitmap2 = bitmap;
        Matrix shareFrameMatrix = shareFrameMatrix(sprite.getFrameEntity().getTransform());
        Paint sharedPaint = this.sharedValues.sharedPaint();
        sharedPaint.setAntiAlias(getVideoItem().getAntiAlias());
        sharedPaint.setFilterBitmap(getVideoItem().getAntiAlias());
        sharedPaint.setAlpha((int) (sprite.getFrameEntity().getAlpha() * KotlinVersion.MAX_COMPONENT_VALUE));
        if (sprite.getFrameEntity().getMaskPath() != null) {
            SVGAPathEntity maskPath = sprite.getFrameEntity().getMaskPath();
            if (maskPath == null) {
                return;
            }
            canvas.save();
            Path sharedPath = this.sharedValues.sharedPath();
            maskPath.buildPath(sharedPath);
            sharedPath.transform(shareFrameMatrix);
            canvas.clipPath(sharedPath);
            shareFrameMatrix.preScale((float) (sprite.getFrameEntity().getLayout().getWidth() / bitmap2.getWidth()), (float) (sprite.getFrameEntity().getLayout().getHeight() / bitmap2.getHeight()));
            if (!bitmap2.isRecycled()) {
                canvas.drawBitmap(bitmap2, shareFrameMatrix, sharedPaint);
            }
            canvas.restore();
        } else {
            shareFrameMatrix.preScale((float) (sprite.getFrameEntity().getLayout().getWidth() / bitmap2.getWidth()), (float) (sprite.getFrameEntity().getLayout().getHeight() / bitmap2.getHeight()));
            if (!bitmap2.isRecycled()) {
                canvas.drawBitmap(bitmap2, shareFrameMatrix, sharedPaint);
            }
        }
        IClickAreaListener iClickAreaListener = this.dynamicItem.getDynamicIClickArea$lib_svga_release().get(str2);
        if (iClickAreaListener != null) {
            float[] fArr = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};
            shareFrameMatrix.getValues(fArr);
            iClickAreaListener.onResponseArea(str2, (int) fArr[2], (int) fArr[5], (int) ((bitmap2.getWidth() * fArr[0]) + fArr[2]), (int) ((bitmap2.getHeight() * fArr[4]) + fArr[5]));
        }
        drawTextOnBitmap(canvas, bitmap2, sprite, shareFrameMatrix);
    }

    private final void drawShape(SGVADrawer.SVGADrawerSprite sprite, Canvas canvas) {
        float[] lineDash;
        String lineJoin;
        String lineCap;
        int fill;
        Matrix shareFrameMatrix = shareFrameMatrix(sprite.getFrameEntity().getTransform());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : sprite.getFrameEntity().getShapes()) {
            sVGAVideoShapeEntity.buildPath();
            if (sVGAVideoShapeEntity.getShapePath() != null) {
                Paint sharedPaint = this.sharedValues.sharedPaint();
                sharedPaint.reset();
                sharedPaint.setAntiAlias(getVideoItem().getAntiAlias());
                double alpha = sprite.getFrameEntity().getAlpha();
                double d10 = KotlinVersion.MAX_COMPONENT_VALUE;
                sharedPaint.setAlpha((int) (alpha * d10));
                Path sharedPath = this.sharedValues.sharedPath();
                sharedPath.reset();
                sharedPath.addPath(this.pathCache.buildPath(sVGAVideoShapeEntity));
                Matrix sharedMatrix2 = this.sharedValues.sharedMatrix2();
                sharedMatrix2.reset();
                Matrix transform = sVGAVideoShapeEntity.getTransform();
                if (transform != null) {
                    sharedMatrix2.postConcat(transform);
                }
                sharedMatrix2.postConcat(shareFrameMatrix);
                sharedPath.transform(sharedMatrix2);
                SVGAVideoShapeEntity.Styles styles = sVGAVideoShapeEntity.getStyles();
                if (styles != null && (fill = styles.getFill()) != 0) {
                    sharedPaint.setStyle(Paint.Style.FILL);
                    sharedPaint.setColor(fill);
                    int min = Math.min(KotlinVersion.MAX_COMPONENT_VALUE, Math.max(0, (int) (sprite.getFrameEntity().getAlpha() * d10)));
                    if (min != 255) {
                        sharedPaint.setAlpha(min);
                    }
                    if (sprite.getFrameEntity().getMaskPath() != null) {
                        canvas.save();
                    }
                    SVGAPathEntity maskPath = sprite.getFrameEntity().getMaskPath();
                    if (maskPath != null) {
                        Path sharedPath2 = this.sharedValues.sharedPath2();
                        maskPath.buildPath(sharedPath2);
                        sharedPath2.transform(shareFrameMatrix);
                        canvas.clipPath(sharedPath2);
                    }
                    canvas.drawPath(sharedPath, sharedPaint);
                    if (sprite.getFrameEntity().getMaskPath() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.Styles styles2 = sVGAVideoShapeEntity.getStyles();
                if (styles2 != null && styles2.getStrokeWidth() > DownloadProgress.UNKNOWN_PROGRESS) {
                    sharedPaint.setAlpha((int) (sprite.getFrameEntity().getAlpha() * d10));
                    sharedPaint.setStyle(Paint.Style.STROKE);
                    SVGAVideoShapeEntity.Styles styles3 = sVGAVideoShapeEntity.getStyles();
                    if (styles3 != null) {
                        sharedPaint.setColor(styles3.getStroke());
                        int min2 = Math.min(KotlinVersion.MAX_COMPONENT_VALUE, Math.max(0, (int) (sprite.getFrameEntity().getAlpha() * d10)));
                        if (min2 != 255) {
                            sharedPaint.setAlpha(min2);
                        }
                    }
                    float matrixScale = matrixScale(shareFrameMatrix);
                    SVGAVideoShapeEntity.Styles styles4 = sVGAVideoShapeEntity.getStyles();
                    if (styles4 != null) {
                        sharedPaint.setStrokeWidth(styles4.getStrokeWidth() * matrixScale);
                    }
                    SVGAVideoShapeEntity.Styles styles5 = sVGAVideoShapeEntity.getStyles();
                    if (styles5 != null && (lineCap = styles5.getLineCap()) != null) {
                        if (StringsKt.equals(lineCap, "butt", true)) {
                            sharedPaint.setStrokeCap(Paint.Cap.BUTT);
                        } else if (StringsKt.equals(lineCap, "round", true)) {
                            sharedPaint.setStrokeCap(Paint.Cap.ROUND);
                        } else if (StringsKt.equals(lineCap, "square", true)) {
                            sharedPaint.setStrokeCap(Paint.Cap.SQUARE);
                        }
                    }
                    SVGAVideoShapeEntity.Styles styles6 = sVGAVideoShapeEntity.getStyles();
                    if (styles6 != null && (lineJoin = styles6.getLineJoin()) != null) {
                        if (StringsKt.equals(lineJoin, "miter", true)) {
                            sharedPaint.setStrokeJoin(Paint.Join.MITER);
                        } else if (StringsKt.equals(lineJoin, "round", true)) {
                            sharedPaint.setStrokeJoin(Paint.Join.ROUND);
                        } else if (StringsKt.equals(lineJoin, "bevel", true)) {
                            sharedPaint.setStrokeJoin(Paint.Join.BEVEL);
                        }
                    }
                    if (sVGAVideoShapeEntity.getStyles() != null) {
                        sharedPaint.setStrokeMiter(r12.getMiterLimit() * matrixScale);
                    }
                    SVGAVideoShapeEntity.Styles styles7 = sVGAVideoShapeEntity.getStyles();
                    if (styles7 != null && (lineDash = styles7.getLineDash()) != null && lineDash.length == 3 && (lineDash[0] > DownloadProgress.UNKNOWN_PROGRESS || lineDash[1] > DownloadProgress.UNKNOWN_PROGRESS)) {
                        float f10 = lineDash[0];
                        if (f10 < 1.0f) {
                            f10 = 1.0f;
                        }
                        float f11 = f10 * matrixScale;
                        float f12 = lineDash[1];
                        if (f12 < 0.1f) {
                            f12 = 0.1f;
                        }
                        sharedPaint.setPathEffect(new DashPathEffect(new float[]{f11, f12 * matrixScale}, lineDash[2] * matrixScale));
                    }
                    if (sprite.getFrameEntity().getMaskPath() != null) {
                        canvas.save();
                    }
                    SVGAPathEntity maskPath2 = sprite.getFrameEntity().getMaskPath();
                    if (maskPath2 != null) {
                        Path sharedPath22 = this.sharedValues.sharedPath2();
                        maskPath2.buildPath(sharedPath22);
                        sharedPath22.transform(shareFrameMatrix);
                        canvas.clipPath(sharedPath22);
                    }
                    canvas.drawPath(sharedPath, sharedPaint);
                    if (sprite.getFrameEntity().getMaskPath() != null) {
                        canvas.restore();
                    }
                }
            }
        }
    }

    private final void drawSprite(SGVADrawer.SVGADrawerSprite sprite, Canvas canvas, int frameIndex) {
        drawImage(sprite, canvas);
        drawShape(sprite, canvas);
        drawDynamic(sprite, canvas, frameIndex);
    }

    private final void drawTextOnBitmap(Canvas canvas, Bitmap drawingBitmap, SGVADrawer.SVGADrawerSprite sprite, Matrix frameMatrix) {
        int i10;
        StaticLayout.Builder obtain;
        StaticLayout.Builder alignment;
        StaticLayout.Builder maxLines;
        StaticLayout.Builder ellipsize;
        StaticLayout build;
        TextPaint textPaint;
        if (this.dynamicItem.getIsTextDirty()) {
            this.drawTextCache.clear();
            this.dynamicItem.setTextDirty$lib_svga_release(false);
        }
        String str = sprite.get_imageKey();
        if (str == null) {
            return;
        }
        String str2 = this.dynamicItem.getDynamicText$lib_svga_release().get(str);
        Bitmap bitmap = null;
        if (str2 != null && (textPaint = this.dynamicItem.getDynamicTextPaint$lib_svga_release().get(str)) != null && (bitmap = this.drawTextCache.get(str)) == null) {
            bitmap = Bitmap.createBitmap(drawingBitmap.getWidth(), drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Rect rect = new Rect(0, 0, drawingBitmap.getWidth(), drawingBitmap.getHeight());
            Intrinsics.checkNotNull(bitmap);
            Canvas canvas2 = new Canvas(bitmap);
            textPaint.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            float f10 = 2;
            canvas2.drawText(str2, rect.centerX(), (rect.centerY() - (fontMetrics.top / f10)) - (fontMetrics.bottom / f10), textPaint);
            this.drawTextCache.put(str, bitmap);
        }
        BoringLayout boringLayout = this.dynamicItem.getDynamicBoringLayoutText$lib_svga_release().get(str);
        if (boringLayout != null && (bitmap = this.drawTextCache.get(str)) == null) {
            boringLayout.getPaint().setAntiAlias(true);
            bitmap = Bitmap.createBitmap(drawingBitmap.getWidth(), drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNull(bitmap);
            Canvas canvas3 = new Canvas(bitmap);
            canvas3.translate(DownloadProgress.UNKNOWN_PROGRESS, (drawingBitmap.getHeight() - boringLayout.getHeight()) / 2);
            boringLayout.draw(canvas3);
            this.drawTextCache.put(str, bitmap);
        }
        StaticLayout staticLayout = this.dynamicItem.getDynamicStaticLayoutText$lib_svga_release().get(str);
        if (staticLayout != null && (bitmap = this.drawTextCache.get(str)) == null) {
            staticLayout.getPaint().setAntiAlias(true);
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Field declaredField = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                    declaredField.setAccessible(true);
                    i10 = declaredField.getInt(staticLayout);
                } catch (Exception unused) {
                    i10 = Integer.MAX_VALUE;
                }
                obtain = StaticLayout.Builder.obtain(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), drawingBitmap.getWidth());
                alignment = obtain.setAlignment(staticLayout.getAlignment());
                maxLines = alignment.setMaxLines(i10);
                ellipsize = maxLines.setEllipsize(TextUtils.TruncateAt.END);
                build = ellipsize.build();
            } else {
                build = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), drawingBitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
            }
            Intrinsics.checkNotNull(build);
            Bitmap createBitmap = Bitmap.createBitmap(drawingBitmap.getWidth(), drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNull(createBitmap);
            Canvas canvas4 = new Canvas(createBitmap);
            canvas4.translate(DownloadProgress.UNKNOWN_PROGRESS, (drawingBitmap.getHeight() - build.getHeight()) / 2);
            build.draw(canvas4);
            this.drawTextCache.put(str, createBitmap);
            bitmap = createBitmap;
        }
        if (bitmap != null) {
            Paint sharedPaint = this.sharedValues.sharedPaint();
            sharedPaint.setAntiAlias(getVideoItem().getAntiAlias());
            sharedPaint.setAlpha((int) (sprite.getFrameEntity().getAlpha() * KotlinVersion.MAX_COMPONENT_VALUE));
            if (sprite.getFrameEntity().getMaskPath() != null) {
                SVGAPathEntity maskPath = sprite.getFrameEntity().getMaskPath();
                if (maskPath != null) {
                    canvas.save();
                    canvas.concat(frameMatrix);
                    canvas.clipRect(0, 0, drawingBitmap.getWidth(), drawingBitmap.getHeight());
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    sharedPaint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                    Path sharedPath = this.sharedValues.sharedPath();
                    maskPath.buildPath(sharedPath);
                    canvas.drawPath(sharedPath, sharedPaint);
                    canvas.restore();
                    return;
                }
                return;
            }
            sharedPaint.setFilterBitmap(getVideoItem().getAntiAlias());
            canvas.drawBitmap(bitmap, frameMatrix, sharedPaint);
        }
    }

    private final boolean isMatteBegin(int spriteIndex, List<SGVADrawer.SVGADrawerSprite> sprites) {
        String str;
        SGVADrawer.SVGADrawerSprite sVGADrawerSprite;
        if (this.beginIndexList == null) {
            int size = sprites.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i10 = 0; i10 < size; i10++) {
                boolArr[i10] = Boolean.FALSE;
            }
            int i11 = 0;
            for (Object obj : sprites) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SGVADrawer.SVGADrawerSprite sVGADrawerSprite2 = (SGVADrawer.SVGADrawerSprite) obj;
                String str2 = sVGADrawerSprite2.get_imageKey();
                if ((str2 == null || !StringsKt.endsWith$default(str2, ".matte", false, 2, (Object) null)) && (str = sVGADrawerSprite2.get_matteKey()) != null && str.length() > 0 && (sVGADrawerSprite = sprites.get(i11 - 1)) != null) {
                    String str3 = sVGADrawerSprite.get_matteKey();
                    if (str3 != null && str3.length() != 0) {
                        if (!Intrinsics.areEqual(sVGADrawerSprite.get_matteKey(), sVGADrawerSprite2.get_matteKey())) {
                            boolArr[i11] = Boolean.TRUE;
                        }
                    } else {
                        boolArr[i11] = Boolean.TRUE;
                    }
                }
                i11 = i12;
            }
            this.beginIndexList = boolArr;
        }
        Boolean[] boolArr2 = this.beginIndexList;
        if (boolArr2 == null) {
            return false;
        }
        return boolArr2[spriteIndex].booleanValue();
    }

    private final boolean isMatteEnd(int spriteIndex, List<SGVADrawer.SVGADrawerSprite> sprites) {
        String str;
        if (this.endIndexList == null) {
            int size = sprites.size();
            Boolean[] boolArr = new Boolean[size];
            for (int i10 = 0; i10 < size; i10++) {
                boolArr[i10] = Boolean.FALSE;
            }
            int i11 = 0;
            for (Object obj : sprites) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SGVADrawer.SVGADrawerSprite sVGADrawerSprite = (SGVADrawer.SVGADrawerSprite) obj;
                String str2 = sVGADrawerSprite.get_imageKey();
                if ((str2 == null || !StringsKt.endsWith$default(str2, ".matte", false, 2, (Object) null)) && (str = sVGADrawerSprite.get_matteKey()) != null && str.length() > 0) {
                    if (i11 == sprites.size() - 1) {
                        boolArr[i11] = Boolean.TRUE;
                    } else {
                        SGVADrawer.SVGADrawerSprite sVGADrawerSprite2 = sprites.get(i12);
                        if (sVGADrawerSprite2 != null) {
                            String str3 = sVGADrawerSprite2.get_matteKey();
                            if (str3 != null && str3.length() != 0) {
                                if (!Intrinsics.areEqual(sVGADrawerSprite2.get_matteKey(), sVGADrawerSprite.get_matteKey())) {
                                    boolArr[i11] = Boolean.TRUE;
                                }
                            } else {
                                boolArr[i11] = Boolean.TRUE;
                            }
                        }
                    }
                }
                i11 = i12;
            }
            this.endIndexList = boolArr;
        }
        Boolean[] boolArr2 = this.endIndexList;
        if (boolArr2 == null) {
            return false;
        }
        return boolArr2[spriteIndex].booleanValue();
    }

    private final float matrixScale(Matrix matrix) {
        float f10;
        matrix.getValues(this.matrixScaleTempValues);
        float[] fArr = this.matrixScaleTempValues;
        float f11 = fArr[0];
        if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        double d10 = f11;
        double d11 = fArr[3];
        double d12 = fArr[1];
        double d13 = fArr[4];
        if (d10 * d13 == d11 * d12) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        double sqrt = Math.sqrt((d10 * d10) + (d11 * d11));
        double d14 = d10 / sqrt;
        double d15 = d11 / sqrt;
        double d16 = (d14 * d12) + (d15 * d13);
        double d17 = d12 - (d14 * d16);
        double d18 = d13 - (d16 * d15);
        double sqrt2 = Math.sqrt((d17 * d17) + (d18 * d18));
        if (d14 * (d18 / sqrt2) < d15 * (d17 / sqrt2)) {
            sqrt = -sqrt;
        }
        if (getScaleInfo().getRatioX()) {
            f10 = (float) sqrt;
        } else {
            f10 = (float) sqrt2;
        }
        return Math.abs(f10);
    }

    private final void playAudio(int frameIndex) {
        Integer soundID;
        for (SVGAAudioEntity sVGAAudioEntity : getVideoItem().getAudioList$lib_svga_release()) {
            if (sVGAAudioEntity.getStartFrame() == frameIndex) {
                SVGASoundManager sVGASoundManager = SVGASoundManager.INSTANCE;
                if (sVGASoundManager.isInit$lib_svga_release()) {
                    Integer soundID2 = sVGAAudioEntity.getSoundID();
                    if (soundID2 != null) {
                        sVGAAudioEntity.setPlayID(Integer.valueOf(sVGASoundManager.play$lib_svga_release(soundID2.intValue())));
                    }
                } else {
                    SoundPool soundPool = getVideoItem().getSoundPool();
                    if (soundPool != null && (soundID = sVGAAudioEntity.getSoundID()) != null) {
                        sVGAAudioEntity.setPlayID(Integer.valueOf(soundPool.play(soundID.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                    }
                }
            }
            if (sVGAAudioEntity.getEndFrame() <= frameIndex) {
                Integer playID = sVGAAudioEntity.getPlayID();
                if (playID != null) {
                    int intValue = playID.intValue();
                    SVGASoundManager sVGASoundManager2 = SVGASoundManager.INSTANCE;
                    if (sVGASoundManager2.isInit$lib_svga_release()) {
                        sVGASoundManager2.stop$lib_svga_release(intValue);
                    } else {
                        SoundPool soundPool2 = getVideoItem().getSoundPool();
                        if (soundPool2 != null) {
                            soundPool2.stop(intValue);
                        }
                    }
                }
                sVGAAudioEntity.setPlayID(null);
            }
        }
    }

    private final Matrix shareFrameMatrix(Matrix transform) {
        Matrix sharedMatrix = this.sharedValues.sharedMatrix();
        sharedMatrix.postScale(getScaleInfo().getScaleFx(), getScaleInfo().getScaleFy());
        sharedMatrix.postTranslate(getScaleInfo().getTranFx(), getScaleInfo().getTranFy());
        sharedMatrix.preConcat(transform);
        return sharedMatrix;
    }

    @Override // com.opensource.svgaplayer.drawer.SGVADrawer
    public void drawFrame(@NotNull Canvas canvas, int frameIndex, @NotNull ImageView.ScaleType scaleType) {
        boolean z10;
        SGVADrawer.SVGADrawerSprite sVGADrawerSprite;
        int i10;
        int i11;
        SGVADrawer.SVGADrawerSprite sVGADrawerSprite2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        super.drawFrame(canvas, frameIndex, scaleType);
        playAudio(frameIndex);
        this.pathCache.onSizeChanged(canvas);
        List<SGVADrawer.SVGADrawerSprite> requestFrameSprites$lib_svga_release = requestFrameSprites$lib_svga_release(frameIndex);
        if (requestFrameSprites$lib_svga_release.size() <= 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = null;
        this.beginIndexList = null;
        this.endIndexList = null;
        boolean z11 = false;
        String str = requestFrameSprites$lib_svga_release.get(0).get_imageKey();
        int i12 = 2;
        if (str != null) {
            z10 = StringsKt.endsWith$default(str, ".matte", false, 2, (Object) null);
        } else {
            z10 = false;
        }
        int i13 = -1;
        int i14 = 0;
        for (Object obj2 : requestFrameSprites$lib_svga_release) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SGVADrawer.SVGADrawerSprite sVGADrawerSprite3 = (SGVADrawer.SVGADrawerSprite) obj2;
            String str2 = sVGADrawerSprite3.get_imageKey();
            if (str2 != null) {
                if (z10) {
                    if (StringsKt.endsWith$default(str2, ".matte", z11, i12, obj)) {
                        linkedHashMap.put(str2, sVGADrawerSprite3);
                    }
                } else {
                    drawSprite(sVGADrawerSprite3, canvas, frameIndex);
                }
                i14 = i15;
                obj = null;
                z11 = false;
                i12 = 2;
            }
            if (isMatteBegin(i14, requestFrameSprites$lib_svga_release)) {
                sVGADrawerSprite = sVGADrawerSprite3;
                i10 = i14;
                i11 = -1;
                i13 = canvas.saveLayer(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, canvas.getWidth(), canvas.getHeight(), null);
            } else {
                sVGADrawerSprite = sVGADrawerSprite3;
                i10 = i14;
                i11 = -1;
            }
            drawSprite(sVGADrawerSprite, canvas, frameIndex);
            if (isMatteEnd(i10, requestFrameSprites$lib_svga_release) && (sVGADrawerSprite2 = (SGVADrawer.SVGADrawerSprite) linkedHashMap.get(sVGADrawerSprite.get_matteKey())) != null) {
                drawSprite(sVGADrawerSprite2, this.sharedValues.shareMatteCanvas(canvas.getWidth(), canvas.getHeight()), frameIndex);
                canvas.drawBitmap(this.sharedValues.sharedMatteBitmap(), DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.sharedValues.shareMattePaint());
                if (i13 != i11) {
                    canvas.restoreToCount(i13);
                } else {
                    canvas.restore();
                }
            }
            i14 = i15;
            obj = null;
            z11 = false;
            i12 = 2;
        }
        releaseFrameSprites$lib_svga_release(requestFrameSprites$lib_svga_release);
    }

    @NotNull
    public final SVGADynamicEntity getDynamicItem() {
        return this.dynamicItem;
    }
}

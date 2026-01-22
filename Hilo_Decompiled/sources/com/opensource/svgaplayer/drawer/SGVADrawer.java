package com.opensource.svgaplayer.drawer;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.entities.SVGAVideoSpriteEntity;
import com.opensource.svgaplayer.entities.SVGAVideoSpriteFrameEntity;
import com.opensource.svgaplayer.utils.Pools;
import com.opensource.svgaplayer.utils.SVGAScaleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001f\u0010\u0016\u001a\u00020\u000f2\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u000bR\u00020\u00000\u0018H\u0000¢\u0006\u0002\b\u0019J\u001f\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u000bR\u00020\u00000\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\u000bR\u00020\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SGVADrawer;", "", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "(Lcom/opensource/svgaplayer/SVGAVideoEntity;)V", "scaleInfo", "Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "getScaleInfo", "()Lcom/opensource/svgaplayer/utils/SVGAScaleInfo;", "spritePool", "Lcom/opensource/svgaplayer/utils/Pools$SimplePool;", "Lcom/opensource/svgaplayer/drawer/SGVADrawer$SVGADrawerSprite;", "getVideoItem", "()Lcom/opensource/svgaplayer/SVGAVideoEntity;", "drawFrame", "", "canvas", "Landroid/graphics/Canvas;", "frameIndex", "", "scaleType", "Landroid/widget/ImageView$ScaleType;", "releaseFrameSprites", "sprites", "", "releaseFrameSprites$lib_svga_release", "requestFrameSprites", "requestFrameSprites$lib_svga_release", "SVGADrawerSprite", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSGVADrawer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SGVADrawer.kt\ncom/opensource/svgaplayer/drawer/SGVADrawer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1603#2,9:55\n1855#2:64\n1856#2:66\n1612#2:67\n1855#2,2:68\n1#3:65\n*S KotlinDebug\n*F\n+ 1 SGVADrawer.kt\ncom/opensource/svgaplayer/drawer/SGVADrawer\n*L\n28#1:55,9\n28#1:64\n28#1:66\n28#1:67\n46#1:68,2\n28#1:65\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SGVADrawer {

    @NotNull
    private final SVGAScaleInfo scaleInfo;

    @NotNull
    private final Pools.SimplePool<SVGADrawerSprite> spritePool;

    @NotNull
    private final SVGAVideoEntity videoItem;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/opensource/svgaplayer/drawer/SGVADrawer$SVGADrawerSprite;", "", "_matteKey", "", "_imageKey", "_frameEntity", "Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity;", "(Lcom/opensource/svgaplayer/drawer/SGVADrawer;Ljava/lang/String;Ljava/lang/String;Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity;)V", "get_frameEntity", "()Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity;", "set_frameEntity", "(Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteFrameEntity;)V", "get_imageKey", "()Ljava/lang/String;", "set_imageKey", "(Ljava/lang/String;)V", "get_matteKey", "set_matteKey", "frameEntity", "getFrameEntity", "imageKey", "getImageKey", "matteKey", "getMatteKey", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public final class SVGADrawerSprite {

        @Nullable
        private SVGAVideoSpriteFrameEntity _frameEntity;

        @Nullable
        private String _imageKey;

        @Nullable
        private String _matteKey;

        public SVGADrawerSprite(@Nullable String str, @Nullable String str2, @Nullable SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity) {
            this._matteKey = str;
            this._imageKey = str2;
            this._frameEntity = sVGAVideoSpriteFrameEntity;
        }

        @NotNull
        public final SVGAVideoSpriteFrameEntity getFrameEntity() {
            SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = this._frameEntity;
            Intrinsics.checkNotNull(sVGAVideoSpriteFrameEntity);
            return sVGAVideoSpriteFrameEntity;
        }

        @Nullable
        /* renamed from: getImageKey, reason: from getter */
        public final String get_imageKey() {
            return this._imageKey;
        }

        @Nullable
        /* renamed from: getMatteKey, reason: from getter */
        public final String get_matteKey() {
            return this._matteKey;
        }

        @Nullable
        public final SVGAVideoSpriteFrameEntity get_frameEntity() {
            return this._frameEntity;
        }

        @Nullable
        public final String get_imageKey() {
            return this._imageKey;
        }

        @Nullable
        public final String get_matteKey() {
            return this._matteKey;
        }

        public final void set_frameEntity(@Nullable SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity) {
            this._frameEntity = sVGAVideoSpriteFrameEntity;
        }

        public final void set_imageKey(@Nullable String str) {
            this._imageKey = str;
        }

        public final void set_matteKey(@Nullable String str) {
            this._matteKey = str;
        }

        public /* synthetic */ SVGADrawerSprite(SGVADrawer sGVADrawer, String str, String str2, SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : sVGAVideoSpriteFrameEntity);
        }
    }

    public SGVADrawer(@NotNull SVGAVideoEntity videoItem) {
        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
        this.videoItem = videoItem;
        this.scaleInfo = new SVGAScaleInfo();
        this.spritePool = new Pools.SimplePool<>(Math.max(1, videoItem.getSpriteList$lib_svga_release().size()));
    }

    public void drawFrame(@NotNull Canvas canvas, int frameIndex, @NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.scaleInfo.performScaleType(canvas.getWidth(), canvas.getHeight(), (float) this.videoItem.getVideoSize().getWidth(), (float) this.videoItem.getVideoSize().getHeight(), scaleType);
    }

    @NotNull
    public final SVGAScaleInfo getScaleInfo() {
        return this.scaleInfo;
    }

    @NotNull
    public final SVGAVideoEntity getVideoItem() {
        return this.videoItem;
    }

    public final void releaseFrameSprites$lib_svga_release(@NotNull List<SVGADrawerSprite> sprites) {
        Intrinsics.checkNotNullParameter(sprites, "sprites");
        Iterator<T> it = sprites.iterator();
        while (it.hasNext()) {
            this.spritePool.release((SVGADrawerSprite) it.next());
        }
    }

    @NotNull
    public final List<SVGADrawerSprite> requestFrameSprites$lib_svga_release(int frameIndex) {
        String imageKey;
        List<SVGAVideoSpriteEntity> spriteList$lib_svga_release = this.videoItem.getSpriteList$lib_svga_release();
        ArrayList arrayList = new ArrayList();
        for (SVGAVideoSpriteEntity sVGAVideoSpriteEntity : spriteList$lib_svga_release) {
            SVGADrawerSprite sVGADrawerSprite = null;
            if (frameIndex >= 0 && frameIndex < sVGAVideoSpriteEntity.getFrames().size() && (imageKey = sVGAVideoSpriteEntity.getImageKey()) != null && (StringsKt.endsWith$default(imageKey, ".matte", false, 2, (Object) null) || sVGAVideoSpriteEntity.getFrames().get(frameIndex).getAlpha() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
                sVGADrawerSprite = this.spritePool.acquire();
                if (sVGADrawerSprite == null) {
                    sVGADrawerSprite = new SVGADrawerSprite(this, null, null, null, 7, null);
                }
                sVGADrawerSprite.set_matteKey(sVGAVideoSpriteEntity.getMatteKey());
                sVGADrawerSprite.set_imageKey(sVGAVideoSpriteEntity.getImageKey());
                sVGADrawerSprite.set_frameEntity(sVGAVideoSpriteEntity.getFrames().get(frameIndex));
            }
            if (sVGADrawerSprite != null) {
                arrayList.add(sVGADrawerSprite);
            }
        }
        return arrayList;
    }
}

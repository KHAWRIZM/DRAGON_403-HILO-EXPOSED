package com.qiahao.base_common.player.svga;

import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.core.component.ICleared;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/qiahao/base_common/player/svga/SVGAResourceParser;", "Lcom/oudi/core/component/ICleared;", "parse", "Lcom/opensource/svgaplayer/SVGADrawable;", "player", "Lcom/qiahao/base_common/player/svga/SVGAPlayer;", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface SVGAResourceParser extends ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static void onCleared(@NotNull SVGAResourceParser sVGAResourceParser) {
            ICleared.DefaultImpls.onCleared(sVGAResourceParser);
        }
    }

    @NotNull
    SVGADrawable parse(@NotNull SVGAPlayer player, @NotNull SVGAVideoEntity videoItem);
}

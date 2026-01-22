package com.qiahao.nextvideo.utilities;

import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.opensource.svgaplayer.SVGADynamicEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J0\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/utilities/SVGAUtil;", "", "<init>", "()V", "SENDER_NAME", "", "RECEIVER_NAME", "SENDER_AVATAR", "RECEIVER_AVATAR", "GIFT_TEXT", "setText", "", "svgaDynamicEntity", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "text", "key", "textColor", "", "textSize", "", "textStyle", "Landroid/graphics/Typeface;", "location", "Landroid/text/Layout$Alignment;", "(Lcom/opensource/svgaplayer/SVGADynamicEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Landroid/graphics/Typeface;Landroid/text/Layout$Alignment;)V", "setAvatarView", "url", "textPaint", "Landroid/text/TextPaint;", "setStaticLayout", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SVGAUtil {

    @NotNull
    public static final String GIFT_TEXT = "gift_text";

    @NotNull
    public static final SVGAUtil INSTANCE = new SVGAUtil();

    @NotNull
    public static final String RECEIVER_AVATAR = "receiver_avatar";

    @NotNull
    public static final String RECEIVER_NAME = "receiver_name";

    @NotNull
    public static final String SENDER_AVATAR = "sender_avatar";

    @NotNull
    public static final String SENDER_NAME = "sender_name";

    private SVGAUtil() {
    }

    private final void setStaticLayout(SVGADynamicEntity svgaDynamicEntity, String text, String key, TextPaint textPaint, Layout.Alignment location) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        svgaDynamicEntity.setDynamicText(new StaticLayout(spannableStringBuilder, 0, spannableStringBuilder.length(), textPaint, 0, location, 1.0f, 0.0f, false), key);
    }

    public static /* synthetic */ void setText$default(SVGAUtil sVGAUtil, SVGADynamicEntity sVGADynamicEntity, String str, String str2, Integer num, Float f, Typeface typeface, Layout.Alignment alignment, int i, Object obj) {
        Integer num2;
        Float f2;
        Typeface typeface2;
        Layout.Alignment alignment2;
        if ((i & 8) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i & 16) != 0) {
            f2 = null;
        } else {
            f2 = f;
        }
        if ((i & 32) != 0) {
            typeface2 = null;
        } else {
            typeface2 = typeface;
        }
        if ((i & 64) != 0) {
            alignment2 = null;
        } else {
            alignment2 = alignment;
        }
        sVGAUtil.setText(sVGADynamicEntity, str, str2, num2, f2, typeface2, alignment2);
    }

    public final void setAvatarView(@NotNull SVGADynamicEntity svgaDynamicEntity, @NotNull String url, @NotNull String key) {
        Intrinsics.checkNotNullParameter(svgaDynamicEntity, "svgaDynamicEntity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(key, "key");
        svgaDynamicEntity.setDynamicImage(url, key);
    }

    public final void setText(@NotNull SVGADynamicEntity svgaDynamicEntity, @NotNull String text, @NotNull String key, @Nullable Integer textColor, @Nullable Float textSize, @Nullable Typeface textStyle, @Nullable Layout.Alignment location) {
        Intrinsics.checkNotNullParameter(svgaDynamicEntity, "svgaDynamicEntity");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(key, "key");
        TextPaint textPaint = new TextPaint();
        if (textColor != null) {
            textPaint.setColor(textColor.intValue());
        }
        if (textSize != null) {
            textPaint.setTextSize(textSize.floatValue());
        }
        if (textStyle != null) {
            textPaint.setTypeface(textStyle);
        }
        if (location != null) {
            setStaticLayout(svgaDynamicEntity, text, key, textPaint, location);
        } else {
            setText(svgaDynamicEntity, text, key, textPaint);
        }
    }

    private final void setText(SVGADynamicEntity svgaDynamicEntity, String text, String key, TextPaint textPaint) {
        svgaDynamicEntity.setDynamicText(text, textPaint, key);
    }
}

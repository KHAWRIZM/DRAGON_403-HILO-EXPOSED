package com.skydoves.balloon;

import android.content.Context;
import android.graphics.Typeface;
import android.text.method.MovementMethod;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/skydoves/balloon/TextForm;", "", "builder", "Lcom/skydoves/balloon/TextForm$Builder;", "(Lcom/skydoves/balloon/TextForm$Builder;)V", "movementMethod", "Landroid/text/method/MovementMethod;", "getMovementMethod", "()Landroid/text/method/MovementMethod;", "text", "", "getText", "()Ljava/lang/CharSequence;", "textColor", "", "getTextColor", "()I", "textGravity", "getTextGravity", "textIsHtml", "", "getTextIsHtml", "()Z", "textSize", "", "getTextSize", "()F", "textStyle", "getTextStyle", "textTypeface", "Landroid/graphics/Typeface;", "getTextTypeface", "()Landroid/graphics/Typeface;", "Builder", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TextForm {

    @Nullable
    private final MovementMethod movementMethod;

    @NotNull
    private final CharSequence text;
    private final int textColor;
    private final int textGravity;
    private final boolean textIsHtml;
    private final float textSize;
    private final int textStyle;

    @Nullable
    private final Typeface textTypeface;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\nJ\u0010\u0010\u001b\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\fJ\u0010\u0010 \u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00118\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/skydoves/balloon/TextForm$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Landroid/text/method/MovementMethod;", "movementMethod", "", "text", "", "textColor", "textGravity", "", "textIsHtml", "", "textSize", "textTypeface", "Landroid/graphics/Typeface;", "textTypefaceObject", "build", "Lcom/skydoves/balloon/TextForm;", "setMovementMethod", "value", "setText", "setTextColor", "setTextColorResource", "setTextGravity", "setTextIsHtml", "setTextResource", "setTextSize", "setTextTypeface", "balloon_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Builder {

        @NotNull
        private final Context context;

        @JvmField
        @Nullable
        public MovementMethod movementMethod;

        @JvmField
        @NotNull
        public CharSequence text;

        @JvmField
        public int textColor;

        @JvmField
        public int textGravity;

        @JvmField
        public boolean textIsHtml;

        @JvmField
        public float textSize;

        @JvmField
        public int textTypeface;

        @JvmField
        @Nullable
        public Typeface textTypefaceObject;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.text = "";
            this.textSize = 12.0f;
            this.textColor = -1;
            this.textGravity = 17;
        }

        @NotNull
        public final TextForm build() {
            return new TextForm(this);
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final Builder setMovementMethod(@NotNull MovementMethod value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.movementMethod = value;
            return this;
        }

        @NotNull
        public final Builder setText(@NotNull CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.text = value;
            return this;
        }

        @NotNull
        public final Builder setTextColor(int value) {
            this.textColor = value;
            return this;
        }

        @NotNull
        public final Builder setTextColorResource(int value) {
            this.textColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setTextGravity(int value) {
            this.textGravity = value;
            return this;
        }

        @NotNull
        public final Builder setTextIsHtml(boolean value) {
            this.textIsHtml = value;
            return this;
        }

        @NotNull
        public final Builder setTextResource(int value) {
            String string = this.context.getString(value);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(value)");
            this.text = string;
            return this;
        }

        @NotNull
        public final Builder setTextSize(float value) {
            this.textSize = value;
            return this;
        }

        @NotNull
        public final Builder setTextTypeface(int value) {
            this.textTypeface = value;
            return this;
        }

        @NotNull
        public final Builder setTextTypeface(@Nullable Typeface value) {
            this.textTypefaceObject = value;
            return this;
        }
    }

    public TextForm(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.text = builder.text;
        this.textSize = builder.textSize;
        this.textColor = builder.textColor;
        this.textIsHtml = builder.textIsHtml;
        this.movementMethod = builder.movementMethod;
        this.textStyle = builder.textTypeface;
        this.textTypeface = builder.textTypefaceObject;
        this.textGravity = builder.textGravity;
    }

    @Nullable
    public final MovementMethod getMovementMethod() {
        return this.movementMethod;
    }

    @NotNull
    public final CharSequence getText() {
        return this.text;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextGravity() {
        return this.textGravity;
    }

    public final boolean getTextIsHtml() {
        return this.textIsHtml;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    @Nullable
    public final Typeface getTextTypeface() {
        return this.textTypeface;
    }
}

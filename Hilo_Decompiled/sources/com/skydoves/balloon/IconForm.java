package com.skydoves.balloon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/skydoves/balloon/IconForm;", "", "builder", "Lcom/skydoves/balloon/IconForm$Builder;", "(Lcom/skydoves/balloon/IconForm$Builder;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawableRes", "", "getDrawableRes", "()Ljava/lang/Integer;", "setDrawableRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "iconColor", "getIconColor", "()I", "iconGravity", "Lcom/skydoves/balloon/IconGravity;", "getIconGravity", "()Lcom/skydoves/balloon/IconGravity;", "iconSize", "getIconSize", "iconSpace", "getIconSpace", "Builder", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class IconForm {

    @Nullable
    private final Drawable drawable;

    @Nullable
    private Integer drawableRes;
    private final int iconColor;

    @NotNull
    private final IconGravity iconGravity;
    private final int iconSize;
    private final int iconSpace;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eJ\u0010\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u0010\u0010\u001b\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\n8\u0006@FX\u0087\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/skydoves/balloon/IconForm$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Landroid/graphics/drawable/Drawable;", "drawable", "", "drawableRes", "Ljava/lang/Integer;", "iconColor", "Lcom/skydoves/balloon/IconGravity;", "iconGravity", "iconSize", "iconSpace", "build", "Lcom/skydoves/balloon/IconForm;", "setDrawable", "value", "setDrawableGravity", "setDrawableResource", "setIconColor", "setIconColorResource", "setIconSize", "setIconSpace", "balloon_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Builder {

        @NotNull
        private final Context context;

        @JvmField
        @Nullable
        public Drawable drawable;

        @JvmField
        @Nullable
        public Integer drawableRes;

        @JvmField
        public int iconColor;

        @JvmField
        @NotNull
        public IconGravity iconGravity;

        @JvmField
        public int iconSize;

        @JvmField
        public int iconSpace;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.iconGravity = IconGravity.LEFT;
            this.iconSize = ContextExtensionKt.dp2Px(context, 28);
            this.iconSpace = ContextExtensionKt.dp2Px(context, 8);
            this.iconColor = -1;
        }

        @NotNull
        public final IconForm build() {
            return new IconForm(this);
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        @NotNull
        public final Builder setDrawable(@Nullable Drawable value) {
            this.drawable = value;
            return this;
        }

        @NotNull
        public final Builder setDrawableGravity(@NotNull IconGravity value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconGravity = value;
            return this;
        }

        @NotNull
        public final Builder setDrawableResource(int value) {
            this.drawableRes = Integer.valueOf(value);
            return this;
        }

        @NotNull
        public final Builder setIconColor(int value) {
            this.iconColor = value;
            return this;
        }

        @NotNull
        public final Builder setIconColorResource(int value) {
            this.iconColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIconSize(int value) {
            this.iconSize = value;
            return this;
        }

        @NotNull
        public final Builder setIconSpace(int value) {
            this.iconSpace = value;
            return this;
        }
    }

    public IconForm(@NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.drawable = builder.drawable;
        this.drawableRes = builder.drawableRes;
        this.iconGravity = builder.iconGravity;
        this.iconSize = builder.iconSize;
        this.iconSpace = builder.iconSpace;
        this.iconColor = builder.iconColor;
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.drawable;
    }

    @Nullable
    public final Integer getDrawableRes() {
        return this.drawableRes;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    @NotNull
    public final IconGravity getIconGravity() {
        return this.iconGravity;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getIconSpace() {
        return this.iconSpace;
    }

    public final void setDrawableRes(@Nullable Integer num) {
        this.drawableRes = num;
    }
}

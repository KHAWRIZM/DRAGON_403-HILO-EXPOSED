package com.qhqc.core.basic.ktx;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"drawableStart", "", "T", "Landroid/widget/TextView;", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "Landroid/graphics/drawable/Drawable;", "(Landroid/widget/TextView;Landroid/graphics/drawable/Drawable;)V", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewKtxKt {
    public static final <T extends TextView> void drawableStart(@NotNull T t10, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        t10.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);
    }
}

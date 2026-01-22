package com.qiahao.nextvideo.ui.reusable.generators;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/generators/Buttons;", "", "<init>", "()V", "createDefaultImageButton", "Landroid/widget/ImageButton;", "context", "Landroid/content/Context;", "size", "", "createDefaultGradientButton", "Landroidx/appcompat/widget/AppCompatButton;", "height", "width", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Buttons {

    @NotNull
    public static final Buttons INSTANCE = new Buttons();

    private Buttons() {
    }

    public static /* synthetic */ AppCompatButton createDefaultGradientButton$default(Buttons buttons, Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = Dimens.INSTANCE.dpToPx(50);
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        return buttons.createDefaultGradientButton(context, i, i2);
    }

    public static /* synthetic */ ImageButton createDefaultImageButton$default(Buttons buttons, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Dimens.INSTANCE.dpToPx(44);
        }
        return buttons.createDefaultImageButton(context, i);
    }

    @NotNull
    public final AppCompatButton createDefaultGradientButton(@NotNull Context context, int height, int width) {
        Intrinsics.checkNotNullParameter(context, "context");
        AppCompatButton appCompatButton = new AppCompatButton(context);
        appCompatButton.setBackgroundResource(2131233270);
        appCompatButton.setTextSize(Dimens.INSTANCE.getFontSizeLarge());
        appCompatButton.setTextColor(-1);
        appCompatButton.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        return appCompatButton;
    }

    @NotNull
    public final ImageButton createDefaultImageButton(@NotNull Context context, int size) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageButton imageButton = new ImageButton(context);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setBackgroundResource(R.drawable.ripple_white_oval);
        imageButton.setLayoutParams(new ViewGroup.LayoutParams(size, size));
        return imageButton;
    }
}

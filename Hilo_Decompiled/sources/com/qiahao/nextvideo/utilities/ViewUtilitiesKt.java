package com.qiahao.nextvideo.utilities;

import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewGroupKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\u000b\u001a\u001b\u0010\u0010\u001a\u00020\u0006*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0012\u001a\u00020\u0006*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0011\u001a+\u0010\u0018\u001a\u00020\u0006*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\u0006*\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u001b\u001aS\u0010%\u001a\u00020\u0006*\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c26\u0010$\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0004\b%\u0010&\u001a)\u0010,\u001a\u00020\u0006*\u00020'2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001¢\u0006\u0004\b,\u0010-\u001a)\u0010,\u001a\u00020\u0006*\u00020\r2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001¢\u0006\u0004\b,\u0010.\u001a-\u00102\u001a\u00020\u0006*\u00020'2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010(2\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001¢\u0006\u0004\b2\u0010-\"\u0011\u00106\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Landroid/view/View;", "", "x", "y", "width", "height", "", "setFrame", "(Landroid/view/View;IIII)V", "dimension", "makeExactlyMeasure", "(Landroid/view/View;I)I", "makeAtMostMeasure", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/graphics/drawable/Drawable;", "drawable", "setDrawableLeft", "(Landroidx/appcompat/widget/AppCompatTextView;Landroid/graphics/drawable/Drawable;)V", "setDrawableRight", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;", Constants.KEY_MODEL, "Lc5/g;", "listener", VerificationCodeFragment.TYPE_BIND, "(Landroidx/appcompat/widget/AppCompatImageView;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;Lc5/g;)V", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;Lcom/qiahao/nextvideo/ui/reusable/uimodels/ImageUIModel;)V", "Landroid/widget/RadioGroup;", "rechargeRadioGroup", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "childIndex", "Landroidx/appcompat/widget/AppCompatRadioButton;", "childView", "each", "eachViewGroup", "(Landroid/widget/RadioGroup;Landroid/widget/RadioGroup;Lkotlin/jvm/functions/Function2;)V", "Landroid/widget/TextView;", "", Constants.KEY_TARGET, "colorNormal", "colorTarget", "setTargetTextColor", "(Landroid/widget/TextView;Ljava/lang/String;II)V", "(Landroidx/appcompat/widget/AppCompatTextView;Ljava/lang/String;II)V", "content", "colorStart", "colorEnd", "setTextColor", "", "getRightToLeftDirection", "()Z", "rightToLeftDirection", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewUtilitiesKt {
    public static final void bind(@NotNull AppCompatImageView appCompatImageView, @NotNull ImageUIModel imageUIModel, @Nullable c5.g gVar) {
        Intrinsics.checkNotNullParameter(appCompatImageView, "<this>");
        Intrinsics.checkNotNullParameter(imageUIModel, Constants.KEY_MODEL);
        ImageKtxKt.loadImage$default(appCompatImageView, imageUIModel.getImageUrl(), (Uri) null, (File) null, imageUIModel.getImageRes(), (Bitmap) null, appCompatImageView.getScaleType(), false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, imageUIModel.getPlaceholder(), imageUIModel.getErrorholder(), gVar, 8150, (Object) null);
    }

    public static /* synthetic */ void bind$default(AppCompatImageView appCompatImageView, ImageUIModel imageUIModel, c5.g gVar, int i, Object obj) {
        if ((i & 2) != 0) {
            gVar = null;
        }
        bind(appCompatImageView, imageUIModel, gVar);
    }

    public static final void eachViewGroup(@NotNull RadioGroup radioGroup, @NotNull RadioGroup radioGroup2, @NotNull Function2<? super Integer, ? super AppCompatRadioButton, Unit> function2) {
        Intrinsics.checkNotNullParameter(radioGroup, "<this>");
        Intrinsics.checkNotNullParameter(radioGroup2, "rechargeRadioGroup");
        Intrinsics.checkNotNullParameter(function2, "each");
        int childCount = radioGroup2.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View view = ViewGroupKt.get(radioGroup2, i2);
            if (view instanceof AppCompatRadioButton) {
                function2.invoke(Integer.valueOf(i), view);
                i++;
            }
        }
    }

    public static /* synthetic */ void eachViewGroup$default(RadioGroup radioGroup, RadioGroup radioGroup2, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            radioGroup2 = radioGroup;
        }
        eachViewGroup(radioGroup, radioGroup2, function2);
    }

    public static final boolean getRightToLeftDirection() {
        if (l2.q.a(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    public static final int makeAtMostMeasure(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
    }

    public static final int makeExactlyMeasure(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    public static final void setDrawableLeft(@NotNull AppCompatTextView appCompatTextView, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(appCompatTextView, "<this>");
        appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public static final void setDrawableRight(@NotNull AppCompatTextView appCompatTextView, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(appCompatTextView, "<this>");
        appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    public static final void setFrame(@NotNull View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public static final void setTargetTextColor(@NotNull TextView textView, @NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.KEY_TARGET);
        textView.setTextColor(i);
        CharSequence text = textView.getText();
        Intrinsics.checkNotNull(text);
        int indexOf$default = StringsKt.indexOf$default(text, str, 0, false, 4, (Object) null);
        if (indexOf$default == -1) {
            return;
        }
        int length = str.length() + indexOf$default;
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), indexOf$default, length, 17);
            textView.setText(spannableStringBuilder);
        } catch (Exception e) {
            Log.e("ViewUtilities", "setTargetTextColor:异常" + e.getLocalizedMessage() + " ");
        }
    }

    public static final void setTextColor(@NotNull final TextView textView, @Nullable final String str, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.post(new Runnable() { // from class: com.qiahao.nextvideo.utilities.v0
            @Override // java.lang.Runnable
            public final void run() {
                ViewUtilitiesKt.setTextColor$lambda$1(textView, i, i2, str);
            }
        });
    }

    public static /* synthetic */ void setTextColor$default(TextView textView, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        setTextColor(textView, str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTextColor$lambda$1(TextView textView, int i, int i2, String str) {
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getMeasuredWidth(), 0.0f, androidx.core.content.a.getColor(textView.getContext(), i), androidx.core.content.a.getColor(textView.getContext(), i2), Shader.TileMode.CLAMP));
        if (str != null) {
            textView.setText(str);
        }
    }

    public static final void bind(@NotNull ImageView imageView, @NotNull ImageUIModel imageUIModel) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageUIModel, Constants.KEY_MODEL);
        ImageKtxKt.loadImage$default(imageView, imageUIModel.getImageUrl(), (Uri) null, (File) null, imageUIModel.getImageRes(), (Bitmap) null, imageView.getScaleType(), false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, imageUIModel.getPlaceholder(), imageUIModel.getErrorholder(), (c5.g) null, 40918, (Object) null);
    }

    public static final void setTargetTextColor(@NotNull AppCompatTextView appCompatTextView, @NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(appCompatTextView, "<this>");
        Intrinsics.checkNotNullParameter(str, Constants.KEY_TARGET);
        appCompatTextView.setTextColor(i);
        CharSequence text = appCompatTextView.getText();
        Intrinsics.checkNotNull(text);
        int indexOf$default = StringsKt.indexOf$default(text, str, 0, false, 4, (Object) null);
        if (indexOf$default == -1) {
            return;
        }
        int length = str.length() + indexOf$default;
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), indexOf$default, length, 17);
            appCompatTextView.setText(spannableStringBuilder.toString());
        } catch (Exception e) {
            Log.e("ViewUtilities", "setTargetTextColor:异常" + e.getLocalizedMessage() + " ");
        }
    }
}

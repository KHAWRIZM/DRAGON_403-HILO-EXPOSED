package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.utils.Dimens;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/GenderAgeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setCompoundDrawablesWithIntrinsicBounds", "", "left", "top", "right", "bottom", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GenderAgeTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GenderAgeTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence text = getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() == 0) {
            setCompoundDrawablePadding(0);
            Dimens dimens = Dimens.INSTANCE;
            setPadding(dimens.dpToPx(6), 0, dimens.dpToPx(6), 0);
        } else {
            Dimens dimens2 = Dimens.INSTANCE;
            setPadding(dimens2.dpToPx(3), 0, dimens2.dpToPx(3), 0);
            setCompoundDrawablePadding(dimens2.dpToPx(3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top2, int right, int bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top2, right, bottom);
        CharSequence text = getText();
        if (text != null && text.length() != 0) {
            Dimens dimens = Dimens.INSTANCE;
            setPadding(dimens.dpToPx(3), 0, dimens.dpToPx(3), 0);
            setCompoundDrawablePadding(dimens.dpToPx(3));
        } else {
            setCompoundDrawablePadding(0);
            Dimens dimens2 = Dimens.INSTANCE;
            setPadding(dimens2.dpToPx(6), 0, dimens2.dpToPx(6), 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(@Nullable CharSequence text, @NotNull TextView.BufferType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        super/*android.widget.TextView*/.setText(text, type);
        if (text != null && text.length() != 0) {
            Dimens dimens = Dimens.INSTANCE;
            setPadding(dimens.dpToPx(3), 0, dimens.dpToPx(3), 0);
            setCompoundDrawablePadding(dimens.dpToPx(3));
        } else {
            setCompoundDrawablePadding(0);
            Dimens dimens2 = Dimens.INSTANCE;
            setPadding(dimens2.dpToPx(6), 0, dimens2.dpToPx(6), 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GenderAgeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence text = getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() == 0) {
            setCompoundDrawablePadding(0);
            Dimens dimens = Dimens.INSTANCE;
            setPadding(dimens.dpToPx(6), 0, dimens.dpToPx(6), 0);
        } else {
            Dimens dimens2 = Dimens.INSTANCE;
            setPadding(dimens2.dpToPx(3), 0, dimens2.dpToPx(3), 0);
            setCompoundDrawablePadding(dimens2.dpToPx(3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GenderAgeTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CharSequence text = getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        if (text.length() == 0) {
            setCompoundDrawablePadding(0);
            Dimens dimens = Dimens.INSTANCE;
            setPadding(dimens.dpToPx(6), 0, dimens.dpToPx(6), 0);
        } else {
            Dimens dimens2 = Dimens.INSTANCE;
            setPadding(dimens2.dpToPx(3), 0, dimens2.dpToPx(3), 0);
            setCompoundDrawablePadding(dimens2.dpToPx(3));
        }
    }
}

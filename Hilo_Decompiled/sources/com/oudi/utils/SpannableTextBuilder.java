package com.oudi.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0002'(B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005Ju\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001aJ5\u0010\u001b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00102\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017JJ\u0010 \u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0018R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006)"}, d2 = {"Lcom/oudi/utils/SpannableTextBuilder;", "", "textView", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;)V", "spannableBuilder", "Landroid/text/SpannableStringBuilder;", "getSpannableBuilder", "()Landroid/text/SpannableStringBuilder;", "spannableBuilder$delegate", "Lkotlin/Lazy;", "appendText", ViewHierarchyConstants.TEXT_KEY, "", "textColor", "", "backgroundColor", "textSize", "textStyle", "underline", "", "clickListener", "Lkotlin/Function1;", "", "centerline", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Ljava/lang/Boolean;)Lcom/oudi/utils/SpannableTextBuilder;", "changeTextColor", "colorText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/oudi/utils/SpannableTextBuilder;", "appendDrawable", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "appendTextRoundBackground", "paddingHorizontal", "paddingVertical", "marginHorizontal", "round", "build", "apply", "TextClickableSpan", "DrawableClickableSpan", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SpannableTextBuilder {

    /* renamed from: spannableBuilder$delegate, reason: from kotlin metadata */
    private final Lazy spannableBuilder = LazyKt.lazy(new Function0() { // from class: com.oudi.utils.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SpannableStringBuilder spannableBuilder_delegate$lambda$0;
            spannableBuilder_delegate$lambda$0 = SpannableTextBuilder.spannableBuilder_delegate$lambda$0();
            return spannableBuilder_delegate$lambda$0;
        }
    });
    private final TextView textView;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/oudi/utils/SpannableTextBuilder$DrawableClickableSpan;", "Landroid/text/style/ClickableSpan;", "clickListener", "Lkotlin/Function1;", "", "", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "<init>", "(Lkotlin/jvm/functions/Function1;I)V", "onClick", "widget", "Landroid/view/View;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DrawableClickableSpan extends ClickableSpan {
        private final Function1<Integer, Unit> clickListener;
        private final int drawable;

        /* JADX WARN: Multi-variable type inference failed */
        public DrawableClickableSpan(Function1<? super Integer, Unit> function1, int i10) {
            this.clickListener = function1;
            this.drawable = i10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function1<Integer, Unit> function1 = this.clickListener;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this.drawable));
            }
        }

        public /* synthetic */ DrawableClickableSpan(Function1 function1, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : function1, i10);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/oudi/utils/SpannableTextBuilder$TextClickableSpan;", "Landroid/text/style/ClickableSpan;", "clickListener", "Lkotlin/Function1;", "", "", ViewHierarchyConstants.TEXT_KEY, "textColor", "", "underline", "", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;IZ)V", "onClick", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class TextClickableSpan extends ClickableSpan {
        private final Function1<String, Unit> clickListener;
        private final String text;
        private final int textColor;
        private final boolean underline;

        /* JADX WARN: Multi-variable type inference failed */
        public TextClickableSpan(Function1<? super String, Unit> function1, String text, int i10, boolean z10) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.clickListener = function1;
            this.text = text;
            this.textColor = i10;
            this.underline = z10;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            Function1<String, Unit> function1 = this.clickListener;
            if (function1 != null) {
                function1.invoke(this.text);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setColor(this.textColor);
            ds.setUnderlineText(this.underline);
        }

        public /* synthetic */ TextClickableSpan(Function1 function1, String str, int i10, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : function1, str, i10, z10);
        }
    }

    public SpannableTextBuilder(TextView textView) {
        this.textView = textView;
    }

    public static /* synthetic */ SpannableTextBuilder appendText$default(SpannableTextBuilder spannableTextBuilder, String str, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, Function1 function1, Boolean bool2, int i10, Object obj) {
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Boolean bool3;
        Function1 function12;
        Boolean bool4 = null;
        if ((i10 & 2) != 0) {
            num5 = null;
        } else {
            num5 = num;
        }
        if ((i10 & 4) != 0) {
            num6 = null;
        } else {
            num6 = num2;
        }
        if ((i10 & 8) != 0) {
            num7 = null;
        } else {
            num7 = num3;
        }
        if ((i10 & 16) != 0) {
            num8 = null;
        } else {
            num8 = num4;
        }
        if ((i10 & 32) != 0) {
            bool3 = null;
        } else {
            bool3 = bool;
        }
        if ((i10 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        if ((i10 & 128) == 0) {
            bool4 = bool2;
        }
        return spannableTextBuilder.appendText(str, num5, num6, num7, num8, bool3, function12, bool4);
    }

    public static /* synthetic */ SpannableTextBuilder changeTextColor$default(SpannableTextBuilder spannableTextBuilder, String str, String str2, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        if ((i10 & 8) != 0) {
            num2 = null;
        }
        return spannableTextBuilder.changeTextColor(str, str2, num, num2);
    }

    private final SpannableStringBuilder getSpannableBuilder() {
        return (SpannableStringBuilder) this.spannableBuilder.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SpannableStringBuilder spannableBuilder_delegate$lambda$0() {
        return new SpannableStringBuilder();
    }

    public final SpannableTextBuilder appendDrawable(int drawable, Function1<? super Integer, Unit> clickListener) {
        Context context;
        int length = getSpannableBuilder().length();
        getSpannableBuilder().append("[icon}");
        int length2 = getSpannableBuilder().length();
        TextView textView = this.textView;
        if (textView != null && (context = textView.getContext()) != null) {
            getSpannableBuilder().setSpan(new VerticalImageSpan(context, drawable), length, length2, 33);
        }
        if (clickListener != null) {
            TextView textView2 = this.textView;
            if (textView2 != null) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            getSpannableBuilder().setSpan(new DrawableClickableSpan(clickListener, drawable), length, length2, 33);
        }
        return this;
    }

    public final SpannableTextBuilder appendText(String text, Integer textColor, Integer backgroundColor, Integer textSize, Integer textStyle, Boolean underline, Function1<? super String, Unit> clickListener, Boolean centerline) {
        boolean z10;
        Intrinsics.checkNotNullParameter(text, "text");
        int length = getSpannableBuilder().length();
        getSpannableBuilder().append((CharSequence) text);
        int length2 = getSpannableBuilder().length();
        if (textColor != null) {
            getSpannableBuilder().setSpan(new ForegroundColorSpan(textColor.intValue()), length, length2, 33);
        }
        if (backgroundColor != null) {
            getSpannableBuilder().setSpan(new BackgroundColorSpan(backgroundColor.intValue()), length, length2, 33);
        }
        if (textSize != null) {
            getSpannableBuilder().setSpan(new AbsoluteSizeSpan(textSize.intValue(), true), length, length2, 33);
        }
        if (textStyle != null) {
            getSpannableBuilder().setSpan(new StyleSpan(textStyle.intValue()), length, length2, 33);
        }
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(underline, bool)) {
            getSpannableBuilder().setSpan(new UnderlineSpan(), length, length2, 33);
        }
        if (Intrinsics.areEqual(centerline, bool)) {
            getSpannableBuilder().setSpan(new StrikethroughSpan(), length, length2, 33);
        }
        if (clickListener != null) {
            TextView textView = this.textView;
            if (textView != null) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            TextClickableSpan textClickableSpan = null;
            if (textColor == null) {
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textColor = Integer.valueOf(textView2.getCurrentTextColor());
                } else {
                    textColor = null;
                }
            }
            if (textColor != null) {
                int intValue = textColor.intValue();
                if (underline != null) {
                    z10 = underline.booleanValue();
                } else {
                    z10 = false;
                }
                textClickableSpan = new TextClickableSpan(clickListener, text, intValue, z10);
            }
            getSpannableBuilder().setSpan(textClickableSpan, length, length2, 33);
        }
        return this;
    }

    public final SpannableTextBuilder appendTextRoundBackground(String text, int textColor, int textSize, int backgroundColor, int paddingHorizontal, int paddingVertical, int marginHorizontal, int round) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = getSpannableBuilder().length();
        getSpannableBuilder().append((CharSequence) text);
        getSpannableBuilder().setSpan(new RoundBackgroundColorSpan(textColor, textSize, backgroundColor, paddingHorizontal, paddingVertical, marginHorizontal, round), length, getSpannableBuilder().length(), 33);
        return this;
    }

    public final void apply() {
        TextView textView = this.textView;
        if (textView != null) {
            textView.setText(getSpannableBuilder());
        }
    }

    public final SpannableStringBuilder build() {
        return getSpannableBuilder();
    }

    public final SpannableTextBuilder changeTextColor(String text, String colorText, Integer textColor, Integer textSize) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(colorText, "colorText");
        getSpannableBuilder().clear();
        int indexOf$default = StringsKt.indexOf$default((CharSequence) text, colorText, 0, false, 6, (Object) null);
        getSpannableBuilder().append((CharSequence) text);
        int length = colorText.length() + indexOf$default;
        if (textColor != null) {
            getSpannableBuilder().setSpan(new ForegroundColorSpan(textColor.intValue()), indexOf$default, length, 33);
        }
        if (textSize != null) {
            getSpannableBuilder().setSpan(new AbsoluteSizeSpan(textSize.intValue(), true), indexOf$default, length, 33);
        }
        return this;
    }
}

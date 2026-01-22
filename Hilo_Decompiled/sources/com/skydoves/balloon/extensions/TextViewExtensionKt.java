package com.skydoves.balloon.extensions;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import com.skydoves.balloon.IconForm;
import com.skydoves.balloon.IconGravity;
import com.skydoves.balloon.TextForm;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.vectortext.VectorTextViewParams;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l2.b;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¨\u0006\u0010"}, d2 = {"fromHtml", "Landroid/text/Spanned;", "text", "", "applyDrawable", "", "Landroid/widget/TextView;", "vectorTextViewParams", "Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "applyIconForm", "Lcom/skydoves/balloon/vectortext/VectorTextView;", "iconForm", "Lcom/skydoves/balloon/IconForm;", "applyTextForm", "textForm", "Lcom/skydoves/balloon/TextForm;", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TextViewExtensionKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IconGravity.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[IconGravity.LEFT.ordinal()] = 1;
            iArr[IconGravity.TOP.ordinal()] = 2;
            iArr[IconGravity.BOTTOM.ordinal()] = 3;
            iArr[IconGravity.RIGHT.ordinal()] = 4;
        }
    }

    public static final void applyDrawable(@NotNull TextView textView, @NotNull VectorTextViewParams vectorTextViewParams) {
        Drawable tint;
        Drawable tint2;
        Drawable tint3;
        Drawable tint4;
        Intrinsics.checkNotNullParameter(textView, "$this$applyDrawable");
        Intrinsics.checkNotNullParameter(vectorTextViewParams, "vectorTextViewParams");
        Integer iconSize = vectorTextViewParams.getIconSize();
        Drawable drawable = null;
        if (iconSize == null) {
            Integer heightRes = vectorTextViewParams.getHeightRes();
            if (heightRes != null) {
                int intValue = heightRes.intValue();
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                iconSize = Integer.valueOf(context.getResources().getDimensionPixelSize(intValue));
            } else {
                iconSize = null;
            }
        }
        if (iconSize == null) {
            Integer squareSizeRes = vectorTextViewParams.getSquareSizeRes();
            if (squareSizeRes != null) {
                int intValue2 = squareSizeRes.intValue();
                Context context2 = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                iconSize = Integer.valueOf(context2.getResources().getDimensionPixelSize(intValue2));
            } else {
                iconSize = null;
            }
        }
        Integer iconSize2 = vectorTextViewParams.getIconSize();
        if (iconSize2 == null) {
            Integer widthRes = vectorTextViewParams.getWidthRes();
            if (widthRes != null) {
                int intValue3 = widthRes.intValue();
                Context context3 = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                iconSize2 = Integer.valueOf(context3.getResources().getDimensionPixelSize(intValue3));
            } else {
                iconSize2 = null;
            }
        }
        if (iconSize2 == null) {
            Integer squareSizeRes2 = vectorTextViewParams.getSquareSizeRes();
            if (squareSizeRes2 != null) {
                int intValue4 = squareSizeRes2.intValue();
                Context context4 = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                iconSize2 = Integer.valueOf(context4.getResources().getDimensionPixelSize(intValue4));
            } else {
                iconSize2 = null;
            }
        }
        Drawable drawableLeft = vectorTextViewParams.getDrawableLeft();
        if (drawableLeft == null) {
            Integer drawableLeftRes = vectorTextViewParams.getDrawableLeftRes();
            if (drawableLeftRes != null) {
                drawableLeft = r1.a.b(textView.getContext(), drawableLeftRes.intValue());
            } else {
                drawableLeft = null;
            }
        }
        if (drawableLeft != null && (tint4 = DrawableExtensionKt.tint(drawableLeft, vectorTextViewParams.getTintColor())) != null) {
            Context context5 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            DrawableExtensionKt.resize(tint4, context5, iconSize2, iconSize);
        }
        Drawable drawableRight = vectorTextViewParams.getDrawableRight();
        if (drawableRight == null) {
            Integer drawableRightRes = vectorTextViewParams.getDrawableRightRes();
            if (drawableRightRes != null) {
                drawableRight = r1.a.b(textView.getContext(), drawableRightRes.intValue());
            } else {
                drawableRight = null;
            }
        }
        if (drawableRight != null && (tint3 = DrawableExtensionKt.tint(drawableRight, vectorTextViewParams.getTintColor())) != null) {
            Context context6 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "context");
            DrawableExtensionKt.resize(tint3, context6, iconSize2, iconSize);
        }
        Drawable drawableBottom = vectorTextViewParams.getDrawableBottom();
        if (drawableBottom == null) {
            Integer drawableBottomRes = vectorTextViewParams.getDrawableBottomRes();
            if (drawableBottomRes != null) {
                drawableBottom = r1.a.b(textView.getContext(), drawableBottomRes.intValue());
            } else {
                drawableBottom = null;
            }
        }
        if (drawableBottom != null && (tint2 = DrawableExtensionKt.tint(drawableBottom, vectorTextViewParams.getTintColor())) != null) {
            Context context7 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "context");
            DrawableExtensionKt.resize(tint2, context7, iconSize2, iconSize);
        }
        Drawable drawableTop = vectorTextViewParams.getDrawableTop();
        if (drawableTop != null) {
            drawable = drawableTop;
        } else {
            Integer drawableTopRes = vectorTextViewParams.getDrawableTopRes();
            if (drawableTopRes != null) {
                drawable = r1.a.b(textView.getContext(), drawableTopRes.intValue());
            }
        }
        if (drawable != null && (tint = DrawableExtensionKt.tint(drawable, vectorTextViewParams.getTintColor())) != null) {
            Context context8 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "context");
            DrawableExtensionKt.resize(tint, context8, iconSize2, iconSize);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawable, drawableRight, drawableBottom);
        Integer compoundDrawablePadding = vectorTextViewParams.getCompoundDrawablePadding();
        if (compoundDrawablePadding != null) {
            textView.setCompoundDrawablePadding(compoundDrawablePadding.intValue());
            return;
        }
        Integer compoundDrawablePaddingRes = vectorTextViewParams.getCompoundDrawablePaddingRes();
        if (compoundDrawablePaddingRes != null) {
            int intValue5 = compoundDrawablePaddingRes.intValue();
            Context context9 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context9, "context");
            textView.setCompoundDrawablePadding(context9.getResources().getDimensionPixelSize(intValue5));
        }
    }

    public static final void applyIconForm(@NotNull VectorTextView vectorTextView, @NotNull IconForm iconForm) {
        Intrinsics.checkNotNullParameter(vectorTextView, "$this$applyIconForm");
        Intrinsics.checkNotNullParameter(iconForm, "iconForm");
        if (iconForm.getDrawable() != null) {
            Integer valueOf = Integer.valueOf(iconForm.getIconSize());
            Integer valueOf2 = Integer.valueOf(iconForm.getIconSpace());
            Integer valueOf3 = Integer.valueOf(iconForm.getIconColor());
            if (valueOf3.intValue() == Integer.MIN_VALUE) {
                valueOf3 = null;
            }
            VectorTextViewParams vectorTextViewParams = new VectorTextViewParams(null, null, null, null, null, null, null, null, valueOf2, valueOf, null, valueOf3, null, null, null, 29951, null);
            int i = WhenMappings.$EnumSwitchMapping$0[iconForm.getIconGravity().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            vectorTextViewParams.setDrawableRight(iconForm.getDrawable());
                            vectorTextViewParams.setDrawableRightRes(iconForm.getDrawableRes());
                        }
                    } else {
                        vectorTextViewParams.setDrawableBottom(iconForm.getDrawable());
                        vectorTextViewParams.setDrawableBottomRes(iconForm.getDrawableRes());
                    }
                } else {
                    vectorTextViewParams.setDrawableTop(iconForm.getDrawable());
                    vectorTextViewParams.setDrawableTopRes(iconForm.getDrawableRes());
                }
            } else {
                vectorTextViewParams.setDrawableLeft(iconForm.getDrawable());
                vectorTextViewParams.setDrawableLeftRes(iconForm.getDrawableRes());
            }
            Unit unit = Unit.INSTANCE;
            vectorTextView.setDrawableTextViewParams(vectorTextViewParams);
        }
    }

    public static final void applyTextForm(@NotNull TextView textView, @NotNull TextForm textForm) {
        CharSequence text;
        Intrinsics.checkNotNullParameter(textView, "$this$applyTextForm");
        Intrinsics.checkNotNullParameter(textForm, "textForm");
        boolean textIsHtml = textForm.getTextIsHtml();
        if (textIsHtml) {
            text = fromHtml(textForm.getText().toString());
        } else if (!textIsHtml) {
            text = textForm.getText();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(text);
        textView.setTextSize(textForm.getTextSize());
        textView.setGravity(textForm.getTextGravity());
        textView.setTextColor(textForm.getTextColor());
        Typeface textTypeface = textForm.getTextTypeface();
        if (textTypeface != null) {
            textView.setTypeface(textTypeface);
        } else {
            textView.setTypeface(textView.getTypeface(), textForm.getTextStyle());
        }
        MovementMethod movementMethod = textForm.getMovementMethod();
        if (movementMethod != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    private static final Spanned fromHtml(String str) {
        Spanned fromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(str, 0);
            return fromHtml;
        }
        return b.a(str, 0);
    }
}

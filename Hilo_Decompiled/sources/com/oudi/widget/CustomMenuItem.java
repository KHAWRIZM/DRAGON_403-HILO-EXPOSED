package com.oudi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.ktx.ResourcesKtxKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u00108\u001a\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010:\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010:\u001a\u0002092\b\b\u0001\u0010=\u001a\u00020\nJ\u0010\u0010>\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010>\u001a\u0002092\b\b\u0001\u0010=\u001a\u00020\nJ\u0010\u0010?\u001a\u0002092\b\u0010;\u001a\u0004\u0018\u00010<J\u0010\u0010?\u001a\u0002092\b\b\u0001\u0010=\u001a\u00020\nJ\u0017\u0010@\u001a\u0002092\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010BJ\u0010\u0010@\u001a\u0002092\b\u0010C\u001a\u0004\u0018\u00010DJ\u0017\u0010E\u001a\u0002092\n\b\u0001\u0010A\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010BJ\u0010\u0010E\u001a\u0002092\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u0002092\u0006\u0010G\u001a\u00020HJ\b\u0010J\u001a\u0004\u0018\u00010KJ\b\u0010L\u001a\u0004\u0018\u00010KR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b\"\u0010\u001fR\u001d\u0010$\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b%\u0010\u0011R\u001d\u0010'\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0013\u001a\u0004\b(\u0010\u001aR\u001d\u0010*\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b+\u0010\u001fR\u001d\u0010-\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b.\u0010\u0011R\u001d\u00100\u001a\u0004\u0018\u0001018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0013\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0013\u001a\u0004\b6\u00103¨\u0006M"}, d2 = {"Lcom/oudi/widget/CustomMenuItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "menuItemView", "Landroid/view/ViewGroup;", "getMenuItemView", "()Landroid/view/ViewGroup;", "menuItemView$delegate", "Lkotlin/Lazy;", "menuItemBodyView", "getMenuItemBodyView", "menuItemBodyView$delegate", "leftIconView", "Landroid/widget/ImageView;", "getLeftIconView", "()Landroid/widget/ImageView;", "leftIconView$delegate", "leftTextView", "Landroid/widget/TextView;", "getLeftTextView", "()Landroid/widget/TextView;", "leftTextView$delegate", "leftSubTextView", "getLeftSubTextView", "leftSubTextView$delegate", "leftLayoutView", "getLeftLayoutView", "leftLayoutView$delegate", "rightIconView", "getRightIconView", "rightIconView$delegate", "rightTextView", "getRightTextView", "rightTextView$delegate", "rightLayoutView", "getRightLayoutView", "rightLayoutView$delegate", "dividerTopView", "Landroid/view/View;", "getDividerTopView", "()Landroid/view/View;", "dividerTopView$delegate", "dividerBottomView", "getDividerBottomView", "dividerBottomView$delegate", "init", "", "setLeftText", ViewHierarchyConstants.TEXT_KEY, "", "resid", "setLeftSubText", "setRightText", "setLeftIcon", "resId", "(Ljava/lang/Integer;)V", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "Landroid/graphics/drawable/Drawable;", "setRightIcon", "setDivideTopEnabled", "isEnabled", "", "setDivideBottomEnabled", "getLeftText", "", "getRightText", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomMenuItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomMenuItem.kt\ncom/oudi/widget/CustomMenuItem\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,348:1\n40#2,6:349\n40#2,6:355\n40#2,6:361\n40#2,6:367\n40#2,6:373\n40#2,6:381\n40#2,6:387\n40#2,6:393\n40#2,6:399\n40#2,6:405\n40#2,6:411\n40#2,6:417\n40#2,6:423\n40#2,6:429\n376#3,2:379\n*S KotlinDebug\n*F\n+ 1 CustomMenuItem.kt\ncom/oudi/widget/CustomMenuItem\n*L\n96#1:349,6\n102#1:355,6\n108#1:361,6\n115#1:367,6\n121#1:373,6\n207#1:381,6\n210#1:387,6\n231#1:393,6\n248#1:399,6\n265#1:405,6\n295#1:411,6\n318#1:417,6\n327#1:423,6\n336#1:429,6\n190#1:379,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CustomMenuItem extends FrameLayout {

    /* renamed from: dividerBottomView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dividerBottomView;

    /* renamed from: dividerTopView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy dividerTopView;

    /* renamed from: leftIconView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftIconView;

    /* renamed from: leftLayoutView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftLayoutView;

    /* renamed from: leftSubTextView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftSubTextView;

    /* renamed from: leftTextView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy leftTextView;

    /* renamed from: menuItemBodyView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy menuItemBodyView;

    /* renamed from: menuItemView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy menuItemView;

    /* renamed from: rightIconView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightIconView;

    /* renamed from: rightLayoutView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightLayoutView;

    /* renamed from: rightTextView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rightTextView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomMenuItem(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View dividerBottomView_delegate$lambda$10(CustomMenuItem customMenuItem) {
        return customMenuItem.findViewById(R.id.v_divider_bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View dividerTopView_delegate$lambda$9(CustomMenuItem customMenuItem) {
        return customMenuItem.findViewById(R.id.v_divider_top);
    }

    private final ViewGroup getMenuItemBodyView() {
        return (ViewGroup) this.menuItemBodyView.getValue();
    }

    private final ViewGroup getMenuItemView() {
        return (ViewGroup) this.menuItemView.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0337  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int dimensionPixelSize;
        int color;
        View dividerTopView;
        View dividerBottomView;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int i15;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ImageView rightIconView;
        ViewGroup leftLayoutView;
        TextView leftSubTextView;
        ImageView rightIconView2;
        ViewGroup.LayoutParams layoutParams3;
        ImageView rightIconView3;
        ViewGroup.LayoutParams layoutParams4;
        ImageView leftIconView;
        ViewGroup.LayoutParams layoutParams5;
        ImageView leftIconView2;
        ViewGroup.LayoutParams layoutParams6;
        TextView rightTextView;
        TextView rightTextView2;
        TextView leftSubTextView2;
        TextView leftSubTextView3;
        TextView leftTextView;
        TextView leftTextView2;
        int i16;
        int i17;
        ImageView rightIconView4;
        int i18;
        int i19;
        int i20;
        ImageView leftIconView3;
        LayoutInflater.from(context).inflate(R.layout.custom_menu_item, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomMenuItem);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CustomMenuItem_cmi_leftIcon);
        if (drawable != null && (leftIconView3 = getLeftIconView()) != null) {
            leftIconView3.setImageDrawable(drawable);
        }
        ImageView leftIconView4 = getLeftIconView();
        int i21 = 8;
        if (leftIconView4 != null) {
            ImageView leftIconView5 = getLeftIconView();
            Intrinsics.checkNotNull(leftIconView5);
            if (leftIconView5.getDrawable() != null) {
                i20 = 0;
            } else {
                i20 = 8;
            }
            leftIconView4.setVisibility(i20);
        }
        String string = obtainStyledAttributes.getString(R.styleable.CustomMenuItem_cmi_leftText);
        TextView leftTextView3 = getLeftTextView();
        if (leftTextView3 != null) {
            leftTextView3.setText(string);
        }
        TextView leftTextView4 = getLeftTextView();
        if (leftTextView4 != null) {
            TextView leftTextView5 = getLeftTextView();
            Intrinsics.checkNotNull(leftTextView5);
            CharSequence text = leftTextView5.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            if (text.length() > 0) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            leftTextView4.setVisibility(i19);
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.CustomMenuItem_cmi_leftSubText);
        TextView leftSubTextView4 = getLeftSubTextView();
        if (leftSubTextView4 != null) {
            leftSubTextView4.setText(string2);
        }
        TextView leftSubTextView5 = getLeftSubTextView();
        if (leftSubTextView5 != null) {
            TextView leftSubTextView6 = getLeftSubTextView();
            Intrinsics.checkNotNull(leftSubTextView6);
            CharSequence text2 = leftSubTextView6.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            if (text2.length() > 0) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            leftSubTextView5.setVisibility(i18);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.CustomMenuItem_cmi_rightIcon);
        if (drawable2 != null && (rightIconView4 = getRightIconView()) != null) {
            rightIconView4.setImageDrawable(drawable2);
        }
        ImageView rightIconView5 = getRightIconView();
        if (rightIconView5 != null) {
            ImageView rightIconView6 = getRightIconView();
            Intrinsics.checkNotNull(rightIconView6);
            if (rightIconView6.getDrawable() != null) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            rightIconView5.setVisibility(i17);
        }
        String string3 = obtainStyledAttributes.getString(R.styleable.CustomMenuItem_cmi_rightText);
        TextView rightTextView3 = getRightTextView();
        if (rightTextView3 != null) {
            rightTextView3.setText(string3);
        }
        TextView rightTextView4 = getRightTextView();
        if (rightTextView4 != null) {
            TextView rightTextView5 = getRightTextView();
            Intrinsics.checkNotNull(rightTextView5);
            CharSequence text3 = rightTextView5.getText();
            Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
            if (text3.length() > 0) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            rightTextView4.setVisibility(i16);
        }
        int color2 = obtainStyledAttributes.getColor(R.styleable.CustomMenuItem_cmi_leftTextColor, -1);
        if (color2 != -1 && (leftTextView2 = getLeftTextView()) != null) {
            leftTextView2.setTextColor(color2);
        }
        int i22 = R.styleable.CustomMenuItem_cmi_leftTextSize;
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(i22, -1);
        if (dimensionPixelSize4 != -1 && (leftTextView = getLeftTextView()) != null) {
            leftTextView.setTextSize(0, dimensionPixelSize4);
        }
        int color3 = obtainStyledAttributes.getColor(R.styleable.CustomMenuItem_cmi_leftSubTextColor, -1);
        if (color3 != -1 && (leftSubTextView3 = getLeftSubTextView()) != null) {
            leftSubTextView3.setTextColor(color3);
        }
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(i22, -1);
        if (dimensionPixelSize5 != -1 && (leftSubTextView2 = getLeftSubTextView()) != null) {
            leftSubTextView2.setTextSize(0, dimensionPixelSize5);
        }
        int color4 = obtainStyledAttributes.getColor(R.styleable.CustomMenuItem_cmi_rightTextColor, -1);
        if (color4 != -1 && (rightTextView2 = getRightTextView()) != null) {
            rightTextView2.setTextColor(color4);
        }
        int dimensionPixelSize6 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_rightTextSize, -1);
        if (dimensionPixelSize6 != -1 && (rightTextView = getRightTextView()) != null) {
            rightTextView.setTextSize(0, dimensionPixelSize6);
        }
        int dimensionPixelSize7 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_leftIconWidth, -1);
        if (dimensionPixelSize7 != -1 && (leftIconView2 = getLeftIconView()) != null && (layoutParams6 = leftIconView2.getLayoutParams()) != null) {
            layoutParams6.width = dimensionPixelSize7;
        }
        int dimensionPixelSize8 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_leftIconHeight, -1);
        if (dimensionPixelSize8 != -1 && (leftIconView = getLeftIconView()) != null && (layoutParams5 = leftIconView.getLayoutParams()) != null) {
            layoutParams5.height = dimensionPixelSize8;
        }
        int dimensionPixelSize9 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_rightIconWidth, -1);
        if (dimensionPixelSize9 != -1 && (rightIconView3 = getRightIconView()) != null && (layoutParams4 = rightIconView3.getLayoutParams()) != null) {
            layoutParams4.width = dimensionPixelSize9;
        }
        int dimensionPixelSize10 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_rightIconHeight, -1);
        if (dimensionPixelSize10 != -1 && (rightIconView2 = getRightIconView()) != null && (layoutParams3 = rightIconView2.getLayoutParams()) != null) {
            layoutParams3.height = dimensionPixelSize10;
        }
        int i23 = R.styleable.CustomMenuItem_cmi_paddingStart;
        ViewGroup menuItemView = getMenuItemView();
        if (menuItemView != null) {
            i10 = menuItemView.getPaddingStart();
        } else {
            i10 = 0;
        }
        int dimensionPixelSize11 = obtainStyledAttributes.getDimensionPixelSize(i23, i10);
        int i24 = R.styleable.CustomMenuItem_cmi_paddingEnd;
        ViewGroup menuItemView2 = getMenuItemView();
        if (menuItemView2 != null) {
            i11 = menuItemView2.getPaddingEnd();
        } else {
            i11 = 0;
        }
        int dimensionPixelSize12 = obtainStyledAttributes.getDimensionPixelSize(i24, i11);
        int i25 = R.styleable.CustomMenuItem_cmi_paddingTop;
        ViewGroup menuItemView3 = getMenuItemView();
        if (menuItemView3 != null) {
            i12 = menuItemView3.getPaddingTop();
        } else {
            i12 = 0;
        }
        int dimensionPixelSize13 = obtainStyledAttributes.getDimensionPixelSize(i25, i12);
        int i26 = R.styleable.CustomMenuItem_cmi_paddingBottom;
        ViewGroup menuItemView4 = getMenuItemView();
        if (menuItemView4 != null) {
            i13 = menuItemView4.getPaddingBottom();
        } else {
            i13 = 0;
        }
        int dimensionPixelSize14 = obtainStyledAttributes.getDimensionPixelSize(i26, i13);
        ViewGroup menuItemBodyView = getMenuItemBodyView();
        if (menuItemBodyView != null) {
            menuItemBodyView.setPadding(dimensionPixelSize11, dimensionPixelSize13, dimensionPixelSize12, dimensionPixelSize14);
        }
        int dimensionPixelSize15 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_leftTextMargin, -1);
        int dimensionPixelSize16 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_leftIconTextMargin, -1);
        int dimensionPixelSize17 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_rightIconTextMargin, -1);
        if (dimensionPixelSize15 != -1 && (leftSubTextView = getLeftSubTextView()) != null) {
            com.oudi.utils.ktx.ViewKtxKt.setMargin$default(leftSubTextView, null, Integer.valueOf(dimensionPixelSize15), null, null, 13, null);
        }
        if (dimensionPixelSize16 != -1 && (leftLayoutView = getLeftLayoutView()) != null) {
            com.oudi.utils.ktx.ViewKtxKt.setMargin$default(leftLayoutView, Integer.valueOf(dimensionPixelSize16), null, null, null, 14, null);
        }
        if (dimensionPixelSize17 != -1 && (rightIconView = getRightIconView()) != null) {
            com.oudi.utils.ktx.ViewKtxKt.setMargin$default(rightIconView, Integer.valueOf(dimensionPixelSize17), null, null, null, 14, null);
        }
        int i27 = R.styleable.CustomMenuItem_cmi_rightTextMarginLeft;
        TextView rightTextView6 = getRightTextView();
        if (rightTextView6 != null) {
            ViewGroup.LayoutParams layoutParams7 = rightTextView6.getLayoutParams();
            if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                i14 = ((ViewGroup.MarginLayoutParams) layoutParams7).getMarginStart();
                com.oudi.utils.ktx.ViewKtxKt.setMargin$default(getRightTextView(), Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i27, i14)), null, null, null, 14, null);
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_dividerHeight, -1);
                if (dimensionPixelSize != -1) {
                    View dividerTopView2 = getDividerTopView();
                    if (dividerTopView2 != null && (layoutParams2 = dividerTopView2.getLayoutParams()) != null) {
                        layoutParams2.height = dimensionPixelSize;
                    }
                    View dividerBottomView2 = getDividerBottomView();
                    if (dividerBottomView2 != null && (layoutParams = dividerBottomView2.getLayoutParams()) != null) {
                        layoutParams.height = dimensionPixelSize;
                    }
                }
                color = obtainStyledAttributes.getColor(R.styleable.CustomMenuItem_cmi_dividerColor, -1);
                if (color != -1) {
                    View dividerTopView3 = getDividerTopView();
                    if (dividerTopView3 != null) {
                        dividerTopView3.setBackgroundColor(color);
                    }
                    View dividerBottomView3 = getDividerBottomView();
                    if (dividerBottomView3 != null) {
                        dividerBottomView3.setBackgroundColor(color);
                    }
                }
                boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.CustomMenuItem_cmi_dividerTopEnabled, false);
                boolean z11 = obtainStyledAttributes.getBoolean(R.styleable.CustomMenuItem_cmi_dividerBottomEnabled, false);
                dividerTopView = getDividerTopView();
                if (dividerTopView != null) {
                    if (z10) {
                        i15 = 0;
                    } else {
                        i15 = 8;
                    }
                    dividerTopView.setVisibility(i15);
                }
                dividerBottomView = getDividerBottomView();
                if (dividerBottomView != null) {
                    if (z11) {
                        i21 = 0;
                    }
                    dividerBottomView.setVisibility(i21);
                }
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_dividerMarginLeft, -1);
                dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_dividerMarginRight, -1);
                if (dimensionPixelSize2 != -1) {
                    View dividerTopView4 = getDividerTopView();
                    if (dividerTopView4 != null) {
                        com.oudi.utils.ktx.ViewKtxKt.setMargin$default(dividerTopView4, Integer.valueOf(dimensionPixelSize2), null, null, null, 14, null);
                    }
                    View dividerBottomView4 = getDividerBottomView();
                    if (dividerBottomView4 != null) {
                        com.oudi.utils.ktx.ViewKtxKt.setMargin$default(dividerBottomView4, Integer.valueOf(dimensionPixelSize2), null, null, null, 14, null);
                    }
                }
                if (dimensionPixelSize3 != -1) {
                    View dividerTopView5 = getDividerTopView();
                    if (dividerTopView5 != null) {
                        com.oudi.utils.ktx.ViewKtxKt.setMargin$default(dividerTopView5, null, null, Integer.valueOf(dimensionPixelSize3), null, 11, null);
                    }
                    View dividerBottomView5 = getDividerBottomView();
                    if (dividerBottomView5 != null) {
                        com.oudi.utils.ktx.ViewKtxKt.setMargin$default(dividerBottomView5, null, null, Integer.valueOf(dimensionPixelSize3), null, 11, null);
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
        i14 = 0;
        com.oudi.utils.ktx.ViewKtxKt.setMargin$default(getRightTextView(), Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i27, i14)), null, null, null, 14, null);
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_dividerHeight, -1);
        if (dimensionPixelSize != -1) {
        }
        color = obtainStyledAttributes.getColor(R.styleable.CustomMenuItem_cmi_dividerColor, -1);
        if (color != -1) {
        }
        boolean z102 = obtainStyledAttributes.getBoolean(R.styleable.CustomMenuItem_cmi_dividerTopEnabled, false);
        boolean z112 = obtainStyledAttributes.getBoolean(R.styleable.CustomMenuItem_cmi_dividerBottomEnabled, false);
        dividerTopView = getDividerTopView();
        if (dividerTopView != null) {
        }
        dividerBottomView = getDividerBottomView();
        if (dividerBottomView != null) {
        }
        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_dividerMarginLeft, -1);
        dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CustomMenuItem_cmi_dividerMarginRight, -1);
        if (dimensionPixelSize2 != -1) {
        }
        if (dimensionPixelSize3 != -1) {
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView leftIconView_delegate$lambda$2(CustomMenuItem customMenuItem) {
        return (ImageView) customMenuItem.findViewById(R.id.iv_left_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup leftLayoutView_delegate$lambda$5(CustomMenuItem customMenuItem) {
        return (ViewGroup) customMenuItem.findViewById(R.id.layout_left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView leftSubTextView_delegate$lambda$4(CustomMenuItem customMenuItem) {
        return (TextView) customMenuItem.findViewById(R.id.tv_left_sub_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView leftTextView_delegate$lambda$3(CustomMenuItem customMenuItem) {
        return (TextView) customMenuItem.findViewById(R.id.tv_left_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup menuItemBodyView_delegate$lambda$1(CustomMenuItem customMenuItem) {
        return (ViewGroup) customMenuItem.findViewById(R.id.layout_menu_item_body);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup menuItemView_delegate$lambda$0(CustomMenuItem customMenuItem) {
        return (ViewGroup) customMenuItem.findViewById(R.id.layout_menu_item_root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView rightIconView_delegate$lambda$6(CustomMenuItem customMenuItem) {
        return (ImageView) customMenuItem.findViewById(R.id.iv_right_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup rightLayoutView_delegate$lambda$8(CustomMenuItem customMenuItem) {
        return (ViewGroup) customMenuItem.findViewById(R.id.layout_right);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView rightTextView_delegate$lambda$7(CustomMenuItem customMenuItem) {
        return (TextView) customMenuItem.findViewById(R.id.tv_right_text);
    }

    @Nullable
    public final View getDividerBottomView() {
        return (View) this.dividerBottomView.getValue();
    }

    @Nullable
    public final View getDividerTopView() {
        return (View) this.dividerTopView.getValue();
    }

    @Nullable
    public final ImageView getLeftIconView() {
        return (ImageView) this.leftIconView.getValue();
    }

    @Nullable
    public final ViewGroup getLeftLayoutView() {
        return (ViewGroup) this.leftLayoutView.getValue();
    }

    @Nullable
    public final TextView getLeftSubTextView() {
        return (TextView) this.leftSubTextView.getValue();
    }

    @Nullable
    public final String getLeftText() {
        CharSequence text;
        TextView leftTextView = getLeftTextView();
        if (leftTextView != null && (text = leftTextView.getText()) != null) {
            return text.toString();
        }
        return null;
    }

    @Nullable
    public final TextView getLeftTextView() {
        return (TextView) this.leftTextView.getValue();
    }

    @Nullable
    public final ImageView getRightIconView() {
        return (ImageView) this.rightIconView.getValue();
    }

    @Nullable
    public final ViewGroup getRightLayoutView() {
        return (ViewGroup) this.rightLayoutView.getValue();
    }

    @Nullable
    public final String getRightText() {
        CharSequence text;
        TextView rightTextView = getRightTextView();
        if (rightTextView != null && (text = rightTextView.getText()) != null) {
            return text.toString();
        }
        return null;
    }

    @Nullable
    public final TextView getRightTextView() {
        return (TextView) this.rightTextView.getValue();
    }

    public final void setDivideBottomEnabled(boolean isEnabled) {
        int i10;
        View dividerBottomView = getDividerBottomView();
        if (dividerBottomView != null) {
            if (isEnabled) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            dividerBottomView.setVisibility(i10);
        }
    }

    public final void setDivideTopEnabled(boolean isEnabled) {
        int i10;
        View dividerTopView = getDividerTopView();
        if (dividerTopView != null) {
            if (isEnabled) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            dividerTopView.setVisibility(i10);
        }
    }

    public final void setLeftIcon(@Nullable Integer resId) {
        if (resId == null) {
            ImageView leftIconView = getLeftIconView();
            if (leftIconView != null) {
                leftIconView.setImageDrawable(null);
            }
            ImageView leftIconView2 = getLeftIconView();
            if (leftIconView2 != null) {
                leftIconView2.setVisibility(8);
                return;
            }
            return;
        }
        ImageView leftIconView3 = getLeftIconView();
        if (leftIconView3 != null) {
            leftIconView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), resId.intValue()));
        }
        ImageView leftIconView4 = getLeftIconView();
        if (leftIconView4 != null) {
            leftIconView4.setVisibility(0);
        }
    }

    public final void setLeftSubText(@Nullable CharSequence text) {
        TextView leftSubTextView = getLeftSubTextView();
        if (leftSubTextView != null) {
            leftSubTextView.setText(text);
        }
        TextView leftSubTextView2 = getLeftSubTextView();
        if (leftSubTextView2 != null) {
            TextView leftSubTextView3 = getLeftSubTextView();
            Intrinsics.checkNotNull(leftSubTextView3);
            CharSequence text2 = leftSubTextView3.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            leftSubTextView2.setVisibility(text2.length() > 0 ? 0 : 8);
        }
    }

    public final void setLeftText(@Nullable CharSequence text) {
        TextView leftTextView = getLeftTextView();
        if (leftTextView != null) {
            leftTextView.setText(text);
        }
        TextView leftTextView2 = getLeftTextView();
        if (leftTextView2 != null) {
            TextView leftTextView3 = getLeftTextView();
            Intrinsics.checkNotNull(leftTextView3);
            CharSequence text2 = leftTextView3.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            leftTextView2.setVisibility(text2.length() > 0 ? 0 : 8);
        }
    }

    public final void setRightIcon(@Nullable Integer resId) {
        if (resId == null) {
            ImageView rightIconView = getRightIconView();
            if (rightIconView != null) {
                rightIconView.setImageDrawable(null);
            }
            ImageView rightIconView2 = getRightIconView();
            if (rightIconView2 != null) {
                rightIconView2.setVisibility(8);
                return;
            }
            return;
        }
        ImageView rightIconView3 = getRightIconView();
        if (rightIconView3 != null) {
            rightIconView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), resId.intValue()));
        }
        ImageView rightIconView4 = getRightIconView();
        if (rightIconView4 != null) {
            rightIconView4.setVisibility(0);
        }
    }

    public final void setRightText(@Nullable CharSequence text) {
        TextView rightTextView = getRightTextView();
        if (rightTextView != null) {
            rightTextView.setText(text);
        }
        TextView rightTextView2 = getRightTextView();
        if (rightTextView2 != null) {
            TextView rightTextView3 = getRightTextView();
            Intrinsics.checkNotNull(rightTextView3);
            CharSequence text2 = rightTextView3.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            rightTextView2.setVisibility(text2.length() > 0 ? 0 : 8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomMenuItem(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomMenuItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomMenuItem(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.menuItemView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewGroup menuItemView_delegate$lambda$0;
                menuItemView_delegate$lambda$0 = CustomMenuItem.menuItemView_delegate$lambda$0(CustomMenuItem.this);
                return menuItemView_delegate$lambda$0;
            }
        });
        this.menuItemBodyView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewGroup menuItemBodyView_delegate$lambda$1;
                menuItemBodyView_delegate$lambda$1 = CustomMenuItem.menuItemBodyView_delegate$lambda$1(CustomMenuItem.this);
                return menuItemBodyView_delegate$lambda$1;
            }
        });
        this.leftIconView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ImageView leftIconView_delegate$lambda$2;
                leftIconView_delegate$lambda$2 = CustomMenuItem.leftIconView_delegate$lambda$2(CustomMenuItem.this);
                return leftIconView_delegate$lambda$2;
            }
        });
        this.leftTextView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextView leftTextView_delegate$lambda$3;
                leftTextView_delegate$lambda$3 = CustomMenuItem.leftTextView_delegate$lambda$3(CustomMenuItem.this);
                return leftTextView_delegate$lambda$3;
            }
        });
        this.leftSubTextView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextView leftSubTextView_delegate$lambda$4;
                leftSubTextView_delegate$lambda$4 = CustomMenuItem.leftSubTextView_delegate$lambda$4(CustomMenuItem.this);
                return leftSubTextView_delegate$lambda$4;
            }
        });
        this.leftLayoutView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewGroup leftLayoutView_delegate$lambda$5;
                leftLayoutView_delegate$lambda$5 = CustomMenuItem.leftLayoutView_delegate$lambda$5(CustomMenuItem.this);
                return leftLayoutView_delegate$lambda$5;
            }
        });
        this.rightIconView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ImageView rightIconView_delegate$lambda$6;
                rightIconView_delegate$lambda$6 = CustomMenuItem.rightIconView_delegate$lambda$6(CustomMenuItem.this);
                return rightIconView_delegate$lambda$6;
            }
        });
        this.rightTextView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextView rightTextView_delegate$lambda$7;
                rightTextView_delegate$lambda$7 = CustomMenuItem.rightTextView_delegate$lambda$7(CustomMenuItem.this);
                return rightTextView_delegate$lambda$7;
            }
        });
        this.rightLayoutView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ViewGroup rightLayoutView_delegate$lambda$8;
                rightLayoutView_delegate$lambda$8 = CustomMenuItem.rightLayoutView_delegate$lambda$8(CustomMenuItem.this);
                return rightLayoutView_delegate$lambda$8;
            }
        });
        this.dividerTopView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View dividerTopView_delegate$lambda$9;
                dividerTopView_delegate$lambda$9 = CustomMenuItem.dividerTopView_delegate$lambda$9(CustomMenuItem.this);
                return dividerTopView_delegate$lambda$9;
            }
        });
        this.dividerBottomView = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View dividerBottomView_delegate$lambda$10;
                dividerBottomView_delegate$lambda$10 = CustomMenuItem.dividerBottomView_delegate$lambda$10(CustomMenuItem.this);
                return dividerBottomView_delegate$lambda$10;
            }
        });
        init(context, attributeSet, i10, i11);
    }

    public final void setLeftIcon(@Nullable Drawable drawable) {
        ImageView leftIconView = getLeftIconView();
        if (leftIconView != null) {
            leftIconView.setImageDrawable(drawable);
        }
        ImageView leftIconView2 = getLeftIconView();
        if (leftIconView2 != null) {
            leftIconView2.setVisibility(drawable != null ? 0 : 8);
        }
    }

    public final void setLeftSubText(int resid) {
        setLeftSubText(ResourcesKtxKt.toStringRes(resid));
    }

    public final void setLeftText(int resid) {
        setLeftText(ResourcesKtxKt.toStringRes(resid));
    }

    public final void setRightIcon(@Nullable Drawable drawable) {
        ImageView rightIconView = getRightIconView();
        if (rightIconView != null) {
            rightIconView.setImageDrawable(drawable);
        }
        ImageView rightIconView2 = getRightIconView();
        if (rightIconView2 != null) {
            rightIconView2.setVisibility(drawable != null ? 0 : 8);
        }
    }

    public final void setRightText(int resid) {
        setRightText(ResourcesKtxKt.toStringRes(resid));
    }
}

package com.qhqc.core.feature.community.ui.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.ktx.DisplayKtxKt;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.BasicDialogFragment;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.DialogOptions;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityDialogTipsBinding;
import com.qhqc.core.feature.community.ui.dialog.TipsDialog;
import com.ruffian.library.widget.RTextView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog;", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/BasicDialogFragment;", "dialogOptions", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$Options;", "<init>", "(Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$Options;)V", "binding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityDialogTipsBinding;", "onCreateDefView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getOptions", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/DialogOptions;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "onInit", "onDestroyView", "addBtn", "option", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$BtnOptions;", "createBtn", "Lcom/ruffian/library/widget/RTextView;", "Builder", "Options", "ContentOptions", "BtnOptions", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTipsDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TipsDialog.kt\ncom/qhqc/core/feature/community/ui/dialog/TipsDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,301:1\n1863#2,2:302\n256#3,2:304\n256#3,2:306\n256#3,2:308\n*S KotlinDebug\n*F\n+ 1 TipsDialog.kt\ncom/qhqc/core/feature/community/ui/dialog/TipsDialog\n*L\n57#1:302,2\n63#1:304,2\n66#1:306,2\n80#1:308,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TipsDialog extends BasicDialogFragment {

    @Nullable
    private FeatureCommunityDialogTipsBinding binding;

    @NotNull
    private final Options dialogOptions;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R7\u00101\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u000207\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R7\u0010<\u001a\u001f\u0012\u0013\u0012\u00110=¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u000207\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$BtnOptions;", "", "<init>", "()V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", "getWidth", "()I", "setWidth", "(I)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "setHeight", "gravity", "getGravity", "setGravity", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "textColor", "getTextColor", "setTextColor", "cornerRadius", "getCornerRadius", "setCornerRadius", "backgroundColorNormal", "getBackgroundColorNormal", "setBackgroundColorNormal", "borderWidthNormal", "getBorderWidthNormal", "setBorderWidthNormal", "borderColorNormal", "getBorderColorNormal", "setBorderColorNormal", ViewHierarchyConstants.TEXT_KEY, "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "layoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "getLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "setLayoutParams", "(Landroid/widget/LinearLayout$LayoutParams;)V", "onView", "Lkotlin/Function1;", "Lcom/ruffian/library/widget/RTextView;", "Lkotlin/ParameterName;", "name", "v", "", "getOnView", "()Lkotlin/jvm/functions/Function1;", "setOnView", "(Lkotlin/jvm/functions/Function1;)V", "onClick", "Landroid/widget/TextView;", "getOnClick", "setOnClick", "isDismissAfterClick", "", "()Z", "setDismissAfterClick", "(Z)V", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class BtnOptions {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private int borderColorNormal;
        private int borderWidthNormal;
        private boolean isDismissAfterClick;

        @NotNull
        private LinearLayout.LayoutParams layoutParams;

        @Nullable
        private Function1<? super TextView, Unit> onClick;

        @Nullable
        private Function1<? super RTextView, Unit> onView;
        private int width = (int) DisplayKtxKt.getDp(180.0f);
        private int height = (int) DisplayKtxKt.getDp(34.0f);
        private int gravity = 17;
        private float textSize = 14.0f;
        private int textColor = -1;
        private float cornerRadius = DisplayKtxKt.getDp(34.0f);
        private int backgroundColorNormal = CompatKtxKt.getColor(R.color.btn_normal);

        @NotNull
        private CharSequence text = CompatKtxKt.getString(R.string.confirm);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$BtnOptions$Companion;", "", "<init>", "()V", "defConfirmOptions", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$BtnOptions;", "defCancelOptions", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final BtnOptions defCancelOptions() {
                BtnOptions btnOptions = new BtnOptions();
                btnOptions.setText(CompatKtxKt.getString(R.string.cancel));
                btnOptions.setTextColor(Color.parseColor("#cfcfcf"));
                btnOptions.setCornerRadius(DisplayKtxKt.getDp(34.0f));
                btnOptions.setBackgroundColorNormal(0);
                btnOptions.setBorderWidthNormal((int) DisplayKtxKt.getDp(1.0f));
                btnOptions.setBorderColorNormal(Color.parseColor("#cfcfcf"));
                return btnOptions;
            }

            @NotNull
            public final BtnOptions defConfirmOptions() {
                BtnOptions btnOptions = new BtnOptions();
                btnOptions.setText(CompatKtxKt.getString(R.string.confirm));
                return btnOptions;
            }

            private Companion() {
            }
        }

        public BtnOptions() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = (int) DisplayKtxKt.getDp(14.0f);
            layoutParams.gravity = 17;
            this.layoutParams = layoutParams;
            this.isDismissAfterClick = true;
        }

        public final int getBackgroundColorNormal() {
            return this.backgroundColorNormal;
        }

        public final int getBorderColorNormal() {
            return this.borderColorNormal;
        }

        public final int getBorderWidthNormal() {
            return this.borderWidthNormal;
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final int getHeight() {
            return this.height;
        }

        @NotNull
        public final LinearLayout.LayoutParams getLayoutParams() {
            return this.layoutParams;
        }

        @Nullable
        public final Function1<TextView, Unit> getOnClick() {
            return this.onClick;
        }

        @Nullable
        public final Function1<RTextView, Unit> getOnView() {
            return this.onView;
        }

        @NotNull
        public final CharSequence getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        public final int getWidth() {
            return this.width;
        }

        /* renamed from: isDismissAfterClick, reason: from getter */
        public final boolean getIsDismissAfterClick() {
            return this.isDismissAfterClick;
        }

        public final void setBackgroundColorNormal(int i10) {
            this.backgroundColorNormal = i10;
        }

        public final void setBorderColorNormal(int i10) {
            this.borderColorNormal = i10;
        }

        public final void setBorderWidthNormal(int i10) {
            this.borderWidthNormal = i10;
        }

        public final void setCornerRadius(float f10) {
            this.cornerRadius = f10;
        }

        public final void setDismissAfterClick(boolean z10) {
            this.isDismissAfterClick = z10;
        }

        public final void setGravity(int i10) {
            this.gravity = i10;
        }

        public final void setHeight(int i10) {
            this.height = i10;
        }

        public final void setLayoutParams(@NotNull LinearLayout.LayoutParams layoutParams) {
            Intrinsics.checkNotNullParameter(layoutParams, "<set-?>");
            this.layoutParams = layoutParams;
        }

        public final void setOnClick(@Nullable Function1<? super TextView, Unit> function1) {
            this.onClick = function1;
        }

        public final void setOnView(@Nullable Function1<? super RTextView, Unit> function1) {
            this.onView = function1;
        }

        public final void setText(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.text = charSequence;
        }

        public final void setTextColor(int i10) {
            this.textColor = i10;
        }

        public final void setTextSize(float f10) {
            this.textSize = f10;
        }

        public final void setWidth(int i10) {
            this.width = i10;
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJA\u0010\t\u001a\u00020\u00002%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\bJ7\u0010\u0013\u001a\u00020\u00002%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\bJ7\u0010\u0015\u001a\u00020\u00002%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\u001d\u001a\u00020\u0018J\u0010\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\u001d\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$Builder;", "", "<init>", "()V", "mOptions", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$Options;", "addBtnOptions", "option", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$BtnOptions;", "withDefBtn", "onConfirmClick", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ParameterName;", "name", "v", "", "btnConfirm", "btnCancel", "withBtnConfirm", "onClick", "withBtnCancel", "setDialogGravity", "gravity", "", "setTextTitle", ViewHierarchyConstants.TEXT_KEY, "", "setTextContent", "textRes", "setTextContentOptions", "options", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$ContentOptions;", "setCancelable", "cancelable", "", "setCustomView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "build", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Builder {

        @NotNull
        private final Options mOptions = new Options();

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder withBtnCancel$default(Builder builder, Function1 function1, BtnOptions btnOptions, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                function1 = null;
            }
            if ((i10 & 2) != 0) {
                btnOptions = BtnOptions.INSTANCE.defCancelOptions();
            }
            return builder.withBtnCancel(function1, btnOptions);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder withBtnConfirm$default(Builder builder, Function1 function1, BtnOptions btnOptions, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                function1 = null;
            }
            if ((i10 & 2) != 0) {
                btnOptions = BtnOptions.INSTANCE.defConfirmOptions();
            }
            return builder.withBtnConfirm(function1, btnOptions);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder withDefBtn$default(Builder builder, Function1 function1, BtnOptions btnOptions, BtnOptions btnOptions2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                function1 = null;
            }
            if ((i10 & 2) != 0) {
                btnOptions = BtnOptions.INSTANCE.defConfirmOptions();
            }
            if ((i10 & 4) != 0) {
                btnOptions2 = BtnOptions.INSTANCE.defCancelOptions();
            }
            return builder.withDefBtn(function1, btnOptions, btnOptions2);
        }

        @NotNull
        public final Builder addBtnOptions(@NotNull BtnOptions option) {
            Intrinsics.checkNotNullParameter(option, "option");
            this.mOptions.addBtnOption(option);
            return this;
        }

        @NotNull
        public final TipsDialog build() {
            return new TipsDialog(this.mOptions);
        }

        @NotNull
        public final Builder setCancelable(boolean cancelable) {
            this.mOptions.setCancelable(cancelable);
            return this;
        }

        @NotNull
        public final Builder setCustomView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mOptions.setCustomView(view);
            return this;
        }

        @NotNull
        public final Builder setDialogGravity(int gravity) {
            this.mOptions.setDialogGravity(gravity);
            return this;
        }

        @NotNull
        public final Builder setTextContent(@Nullable CharSequence text) {
            this.mOptions.setTextContent(text);
            return this;
        }

        @NotNull
        public final Builder setTextContentOptions(@NotNull ContentOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.mOptions.setTextContentOptions(options);
            return this;
        }

        @NotNull
        public final Builder setTextTitle(@Nullable CharSequence text) {
            this.mOptions.setTextTitle(text);
            return this;
        }

        @NotNull
        public final Builder withBtnCancel(@Nullable Function1<? super TextView, Unit> onClick, @NotNull BtnOptions btnCancel) {
            Intrinsics.checkNotNullParameter(btnCancel, "btnCancel");
            if (onClick != null) {
                btnCancel.setOnClick(onClick);
            }
            addBtnOptions(btnCancel);
            return this;
        }

        @NotNull
        public final Builder withBtnConfirm(@Nullable Function1<? super TextView, Unit> onClick, @NotNull BtnOptions btnConfirm) {
            Intrinsics.checkNotNullParameter(btnConfirm, "btnConfirm");
            if (onClick != null) {
                btnConfirm.setOnClick(onClick);
            }
            addBtnOptions(btnConfirm);
            return this;
        }

        @NotNull
        public final Builder withDefBtn(@Nullable Function1<? super TextView, Unit> onConfirmClick, @NotNull BtnOptions btnConfirm, @NotNull BtnOptions btnCancel) {
            Intrinsics.checkNotNullParameter(btnConfirm, "btnConfirm");
            Intrinsics.checkNotNullParameter(btnCancel, "btnCancel");
            if (onConfirmClick != null) {
                btnConfirm.setOnClick(onConfirmClick);
            }
            addBtnOptions(btnConfirm).addBtnOptions(btnCancel);
            return this;
        }

        @NotNull
        public final Builder setTextContent(int textRes) {
            return setTextContent(CompatKtxKt.getString(textRes));
        }

        @NotNull
        public final Builder setTextTitle(int textRes) {
            return setTextTitle(CompatKtxKt.getString(textRes));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$ContentOptions;", "", "<init>", "()V", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "textColor", "getTextColor", "setTextColor", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class ContentOptions {
        private int gravity = 17;
        private float textSize = 14.0f;
        private int textColor = CompatKtxKt.getColor(R.color.color_333333);

        public final int getGravity() {
            return this.gravity;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        public final void setGravity(int i10) {
            this.gravity = i10;
        }

        public final void setTextColor(int i10) {
            this.textColor = i10;
        }

        public final void setTextSize(float f10) {
            this.textSize = f10;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0006R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$Options;", "", "<init>", "()V", "btnOptions", "Ljava/util/ArrayList;", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$BtnOptions;", "Lkotlin/collections/ArrayList;", "getBtnOptions", "()Ljava/util/ArrayList;", "dialogGravity", "", "getDialogGravity", "()I", "setDialogGravity", "(I)V", "textTitle", "", "getTextTitle", "()Ljava/lang/CharSequence;", "setTextTitle", "(Ljava/lang/CharSequence;)V", "textContent", "getTextContent", "setTextContent", "textContentOptions", "Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$ContentOptions;", "getTextContentOptions", "()Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$ContentOptions;", "setTextContentOptions", "(Lcom/qhqc/core/feature/community/ui/dialog/TipsDialog$ContentOptions;)V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "cancelable", "", "getCancelable", "()Z", "setCancelable", "(Z)V", "addBtnOption", "", "option", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Options {

        @Nullable
        private View customView;

        @Nullable
        private CharSequence textContent;

        @Nullable
        private ContentOptions textContentOptions;

        @Nullable
        private CharSequence textTitle;

        @NotNull
        private final ArrayList<BtnOptions> btnOptions = new ArrayList<>();
        private int dialogGravity = 17;
        private boolean cancelable = true;

        public final void addBtnOption(@NotNull BtnOptions option) {
            Intrinsics.checkNotNullParameter(option, "option");
            this.btnOptions.add(option);
        }

        @NotNull
        public final ArrayList<BtnOptions> getBtnOptions() {
            return this.btnOptions;
        }

        public final boolean getCancelable() {
            return this.cancelable;
        }

        @Nullable
        public final View getCustomView() {
            return this.customView;
        }

        public final int getDialogGravity() {
            return this.dialogGravity;
        }

        @Nullable
        public final CharSequence getTextContent() {
            return this.textContent;
        }

        @Nullable
        public final ContentOptions getTextContentOptions() {
            return this.textContentOptions;
        }

        @Nullable
        public final CharSequence getTextTitle() {
            return this.textTitle;
        }

        public final void setCancelable(boolean z10) {
            this.cancelable = z10;
        }

        public final void setCustomView(@Nullable View view) {
            this.customView = view;
        }

        public final void setDialogGravity(int i10) {
            this.dialogGravity = i10;
        }

        public final void setTextContent(@Nullable CharSequence charSequence) {
            this.textContent = charSequence;
        }

        public final void setTextContentOptions(@Nullable ContentOptions contentOptions) {
            this.textContentOptions = contentOptions;
        }

        public final void setTextTitle(@Nullable CharSequence charSequence) {
            this.textTitle = charSequence;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TipsDialog() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void addBtn(final BtnOptions option) {
        LinearLayoutCompat linearLayoutCompat;
        final RTextView createBtn = createBtn(option);
        FeatureCommunityDialogTipsBinding featureCommunityDialogTipsBinding = this.binding;
        if (featureCommunityDialogTipsBinding != null && (linearLayoutCompat = featureCommunityDialogTipsBinding.mContentView) != null) {
            linearLayoutCompat.addView(createBtn, option.getLayoutParams());
        }
        createBtn.setText(option.getText());
        Function1<RTextView, Unit> onView = option.getOnView();
        if (onView != null) {
            onView.invoke(createBtn);
        }
        createBtn.setOnClickListener(new View.OnClickListener() { // from class: za.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipsDialog.addBtn$lambda$4(TipsDialog.BtnOptions.this, createBtn, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addBtn$lambda$4(BtnOptions btnOptions, RTextView rTextView, TipsDialog tipsDialog, View view) {
        Function1<TextView, Unit> onClick = btnOptions.getOnClick();
        if (onClick != null) {
            onClick.invoke(rTextView);
        }
        if (btnOptions.getIsDismissAfterClick()) {
            tipsDialog.dismiss();
        }
    }

    private final RTextView createBtn(BtnOptions option) {
        RTextView rTextView = new RTextView(requireContext());
        rTextView.setWidth(option.getWidth());
        rTextView.setHeight(option.getHeight());
        rTextView.setGravity(option.getGravity());
        rTextView.setTextSize(2, option.getTextSize());
        rTextView.setTextColor(option.getTextColor());
        rTextView.getHelper().u(option.getCornerRadius());
        rTextView.getHelper().m(option.getBackgroundColorNormal());
        if (option.getBorderColorNormal() != 0) {
            rTextView.getHelper().r(option.getBorderColorNormal());
        }
        if (option.getBorderWidthNormal() != 0) {
            rTextView.getHelper().s(option.getBorderWidthNormal());
        }
        return rTextView;
    }

    private final void onInit(Bundle savedInstanceState) {
        Iterator<T> it = this.dialogOptions.getBtnOptions().iterator();
        while (it.hasNext()) {
            addBtn((BtnOptions) it.next());
        }
        FeatureCommunityDialogTipsBinding featureCommunityDialogTipsBinding = this.binding;
        if (featureCommunityDialogTipsBinding != null) {
            CharSequence textTitle = this.dialogOptions.getTextTitle();
            if (textTitle != null && textTitle.length() != 0) {
                TextView mTvTitle = featureCommunityDialogTipsBinding.mTvTitle;
                Intrinsics.checkNotNullExpressionValue(mTvTitle, "mTvTitle");
                mTvTitle.setVisibility(0);
                featureCommunityDialogTipsBinding.mTvTitle.setText(this.dialogOptions.getTextTitle());
            } else {
                TextView mTvTitle2 = featureCommunityDialogTipsBinding.mTvTitle;
                Intrinsics.checkNotNullExpressionValue(mTvTitle2, "mTvTitle");
                mTvTitle2.setVisibility(8);
            }
            ContentOptions textContentOptions = this.dialogOptions.getTextContentOptions();
            if (textContentOptions != null) {
                featureCommunityDialogTipsBinding.mTvContent.setGravity(textContentOptions.getGravity());
                featureCommunityDialogTipsBinding.mTvContent.setTextSize(2, textContentOptions.getTextSize());
                featureCommunityDialogTipsBinding.mTvContent.setTextColor(textContentOptions.getTextColor());
            }
            featureCommunityDialogTipsBinding.mTvContent.setText(this.dialogOptions.getTextContent());
            if (this.dialogOptions.getCustomView() != null) {
                CharSequence textContent = this.dialogOptions.getTextContent();
                if (textContent == null || textContent.length() == 0) {
                    TextView mTvContent = featureCommunityDialogTipsBinding.mTvContent;
                    Intrinsics.checkNotNullExpressionValue(mTvContent, "mTvContent");
                    mTvContent.setVisibility(8);
                }
                featureCommunityDialogTipsBinding.mCustomViewContainer.addView(this.dialogOptions.getCustomView(), new FrameLayout.LayoutParams(-1, -2));
            }
            setCancelable(this.dialogOptions.getCancelable());
        }
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.BasicDialogFragment
    @NotNull
    public DialogOptions getOptions() {
        DialogOptions options = super.getOptions();
        options.setGravity(this.dialogOptions.getDialogGravity());
        return options;
    }

    @Override // com.qhqc.core.basic.uiframe.ui.dialogfragment.BasicDialogFragment
    @NotNull
    public View onCreateDefView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FeatureCommunityDialogTipsBinding inflate = FeatureCommunityDialogTipsBinding.inflate(inflater, container, false);
        this.binding = inflate;
        Intrinsics.checkNotNull(inflate);
        FrameLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        onInit(savedInstanceState);
    }

    public /* synthetic */ TipsDialog(Options options, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new Options() : options);
    }

    public TipsDialog(@NotNull Options dialogOptions) {
        Intrinsics.checkNotNullParameter(dialogOptions, "dialogOptions");
        this.dialogOptions = dialogOptions;
    }
}

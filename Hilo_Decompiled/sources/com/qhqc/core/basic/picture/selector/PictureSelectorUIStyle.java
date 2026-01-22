package com.qhqc.core.basic.picture.selector;

import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.style.TitleBarStyle;
import com.qhqc.core.basic.R;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.yalantis.ucrop.UCrop;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PictureSelectorUIStyle;", "", "()V", "getCropDefOptions", "Lcom/yalantis/ucrop/UCrop$Options;", "getDefStyle", "Lcom/luck/picture/lib/style/PictureSelectorStyle;", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PictureSelectorUIStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static UCrop.Options mCropOptions;

    @Nullable
    private static PictureSelectorStyle mDefStyle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qhqc/core/basic/picture/selector/PictureSelectorUIStyle$Companion;", "", "()V", "mCropOptions", "Lcom/yalantis/ucrop/UCrop$Options;", "mDefStyle", "Lcom/luck/picture/lib/style/PictureSelectorStyle;", "setCropDefOptions", "", "option", "setDefStyle", "style", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setCropDefOptions(@NotNull UCrop.Options option) {
            Intrinsics.checkNotNullParameter(option, "option");
            PictureSelectorUIStyle.mCropOptions = option;
        }

        public final void setDefStyle(@NotNull PictureSelectorStyle style) {
            Intrinsics.checkNotNullParameter(style, "style");
            PictureSelectorUIStyle.mDefStyle = style;
        }

        private Companion() {
        }
    }

    @NotNull
    public final UCrop.Options getCropDefOptions() {
        UCrop.Options options = mCropOptions;
        if (options != null) {
            return options;
        }
        UCrop.Options options2 = new UCrop.Options();
        options2.setShowCropGrid(false);
        options2.setCompressionQuality(90);
        options2.setHideBottomControls(true);
        options2.setSkipCropMimeType(new String[]{"image/gif", "image/GIF"});
        int i10 = R.color.colorAccent;
        options2.setToolbarColor(CompatKtxKt.getColor(i10));
        options2.setStatusBarColor(CompatKtxKt.getColor(i10));
        options2.setToolbarTitleSize(15);
        options2.setToolbarWidgetColor(-1);
        return options2;
    }

    @NotNull
    public final PictureSelectorStyle getDefStyle() {
        PictureSelectorStyle pictureSelectorStyle = mDefStyle;
        if (pictureSelectorStyle != null) {
            return pictureSelectorStyle;
        }
        PictureSelectorStyle pictureSelectorStyle2 = new PictureSelectorStyle();
        TitleBarStyle titleBarStyle = new TitleBarStyle();
        titleBarStyle.setTitleTextSize(15);
        titleBarStyle.setTitleLeftBackResource(R.drawable.basic_picture_selector_icon_back);
        titleBarStyle.setTitleAlbumBackgroundResource(R.drawable.basic_picture_selector_title_bg);
        titleBarStyle.setTitleBackgroundColor(CompatKtxKt.getColor(R.color.colorAccent));
        titleBarStyle.setHideCancelButton(true);
        pictureSelectorStyle2.setTitleBarStyle(titleBarStyle);
        SelectMainStyle selectMainStyle = new SelectMainStyle();
        int i10 = R.color.basic_picture_selector_text_select;
        selectMainStyle.setSelectTextColor(CompatKtxKt.getColor(i10));
        pictureSelectorStyle2.setSelectMainStyle(selectMainStyle);
        BottomNavBarStyle bottomNavBarStyle = new BottomNavBarStyle();
        bottomNavBarStyle.setBottomPreviewSelectTextColor(CompatKtxKt.getColor(i10));
        pictureSelectorStyle2.setBottomBarStyle(bottomNavBarStyle);
        return pictureSelectorStyle2;
    }
}

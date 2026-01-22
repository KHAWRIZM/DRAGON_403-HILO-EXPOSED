package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogShowSvgaOrPicBinding;
import java.io.File;
import java.net.URL;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/PicOrSvgaShowDialog;", "Lcom/qiahao/nextvideo/room/dialog/BaseBottomSheetDialog;", "url", "", "svgaUrl", "mCurrentContext", "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getSvgaUrl", "setSvgaUrl", "binding", "Lcom/qiahao/nextvideo/databinding/DialogShowSvgaOrPicBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogShowSvgaOrPicBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogShowSvgaOrPicBinding;)V", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "parser$delegate", "Lkotlin/Lazy;", "initStyle", "", "initDataBinding", "initView", "onDetachedFromWindow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PicOrSvgaShowDialog extends BaseBottomSheetDialog {

    @NotNull
    private static final String TAG = "PicOrSvgaShowDialog";
    public DialogShowSvgaOrPicBinding binding;

    @NotNull
    private final Context mCurrentContext;

    /* renamed from: parser$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parser;

    @NotNull
    private String svgaUrl;

    @NotNull
    private String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicOrSvgaShowDialog(@NotNull String str, @NotNull String str2, @NotNull Context context) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "svgaUrl");
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        this.url = str;
        this.svgaUrl = str2;
        this.mCurrentContext = context;
        this.parser = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.w1
            public final Object invoke() {
                SVGAParser parser_delegate$lambda$0;
                parser_delegate$lambda$0 = PicOrSvgaShowDialog.parser_delegate$lambda$0();
                return parser_delegate$lambda$0;
            }
        });
    }

    private final SVGAParser getParser() {
        return (SVGAParser) this.parser.getValue();
    }

    private final void initView() {
        if (this.svgaUrl.length() > 0) {
            getParser().decodeFromURL(new URL(this.svgaUrl + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.PicOrSvgaShowDialog$initView$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    PicOrSvgaShowDialog.this.getBinding().bigSvga.stopAnimation(true);
                    PicOrSvgaShowDialog.this.getBinding().bigSvga.setImageDrawable(new SVGADrawable(videoItem));
                    PicOrSvgaShowDialog.this.getBinding().bigSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } else if (this.url.length() > 0) {
            ImageView imageView = getBinding().bigPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "bigPic");
            ImageKtxKt.loadImage$default(imageView, this.url, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        getBinding().bigSvga.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.room.dialog.PicOrSvgaShowDialog$initView$2
            public void onFinished() {
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SVGAParser parser_delegate$lambda$0() {
        return SVGAParser.Companion.shareParser();
    }

    @NotNull
    public final DialogShowSvgaOrPicBinding getBinding() {
        DialogShowSvgaOrPicBinding dialogShowSvgaOrPicBinding = this.binding;
        if (dialogShowSvgaOrPicBinding != null) {
            return dialogShowSvgaOrPicBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override // com.qiahao.nextvideo.room.dialog.BaseBottomSheetDialog
    public void initDataBinding() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setBinding((DialogShowSvgaOrPicBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_show_svga_or_pic, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        initStyle();
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.room.dialog.BaseBottomSheetDialog
    public void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            frameLayout.getLayoutParams().height = -1;
            BottomSheetBehavior.s0(frameLayout).c(3);
            frameLayout.setBackground(new ColorDrawable(0));
        }
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setDimAmount(0.0f);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getBinding().bigSvga.isAnimating()) {
            getBinding().bigSvga.stopAnimation(true);
        }
    }

    public final void setBinding(@NotNull DialogShowSvgaOrPicBinding dialogShowSvgaOrPicBinding) {
        Intrinsics.checkNotNullParameter(dialogShowSvgaOrPicBinding, "<set-?>");
        this.binding = dialogShowSvgaOrPicBinding;
    }

    public final void setSvgaUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.svgaUrl = str;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public /* synthetic */ PicOrSvgaShowDialog(String str, String str2, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, context);
    }
}

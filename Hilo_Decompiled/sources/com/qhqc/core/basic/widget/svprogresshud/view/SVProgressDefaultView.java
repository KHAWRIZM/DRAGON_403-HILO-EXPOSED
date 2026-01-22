package com.qhqc.core.basic.widget.svprogresshud.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qhqc.core.basic.widget.R;
import com.qhqc.core.basic.widget.svprogresshud.indicator.Indicator;
import com.qhqc.core.basic.widget.svprogresshud.indicator.IndicatorView;
import com.qhqc.core.basic.widget.svprogresshud.indicator.LineScalePulseOutIndicator;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020\u0019J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010#\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010$\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010%\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010&\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010'\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010(\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/view/SVProgressDefaultView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "Lcom/qhqc/core/basic/widget/svprogresshud/view/SVCircleProgressBar;", "circleProgressBar", "getCircleProgressBar", "()Lcom/qhqc/core/basic/widget/svprogresshud/view/SVCircleProgressBar;", "indicatorView", "Lcom/qhqc/core/basic/widget/svprogresshud/indicator/IndicatorView;", "ivBigLoading", "Landroid/widget/ImageView;", "ivSmallLoading", "mRotateAnimation", "Landroid/view/animation/RotateAnimation;", "resBigLoading", "", "resError", "resInfo", "resSuccess", "tvMsg", "Landroid/widget/TextView;", "clearAnimations", "", "dismiss", "init", "initViews", "setText", "string", "", "show", "showBaseStatus", "res", "showErrorWithStatus", "showInfoWithStatus", "showProgress", "showSuccessWithStatus", "showWithProgress", "showWithStatus", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SVProgressDefaultView extends LinearLayout {

    @Nullable
    private SVCircleProgressBar circleProgressBar;

    @Nullable
    private IndicatorView indicatorView;

    @Nullable
    private ImageView ivBigLoading;

    @Nullable
    private ImageView ivSmallLoading;

    @Nullable
    private RotateAnimation mRotateAnimation;
    private final int resBigLoading;
    private final int resError;
    private final int resInfo;
    private final int resSuccess;

    @Nullable
    private TextView tvMsg;

    public SVProgressDefaultView(@Nullable Context context) {
        super(context);
        this.resBigLoading = R.drawable.ic_svstatus_loading;
        this.resInfo = R.drawable.ic_svstatus_info;
        this.resSuccess = R.drawable.ic_svstatus_success;
        this.resError = R.drawable.ic_svstatus_error;
        initViews();
        init();
    }

    private final void clearAnimations() {
    }

    private final void init() {
        RotateAnimation rotateAnimation = new RotateAnimation(DownloadProgress.UNKNOWN_PROGRESS, 359.0f, 1, 0.5f, 1, 0.5f);
        this.mRotateAnimation = rotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation);
        rotateAnimation.setDuration(1000L);
        RotateAnimation rotateAnimation2 = this.mRotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation2);
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        RotateAnimation rotateAnimation3 = this.mRotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation3);
        rotateAnimation3.setRepeatCount(-1);
        RotateAnimation rotateAnimation4 = this.mRotateAnimation;
        Intrinsics.checkNotNull(rotateAnimation4);
        rotateAnimation4.setRepeatMode(1);
        LineScalePulseOutIndicator lineScalePulseOutIndicator = new LineScalePulseOutIndicator();
        IndicatorView indicatorView = this.indicatorView;
        if (indicatorView != null) {
            indicatorView.setIndicator(lineScalePulseOutIndicator);
        }
    }

    private final void initViews() {
        LayoutInflater.from(getContext()).inflate(R.layout.basic_widget_layout_view_svprogressdefault, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.ivBigLoading);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivBigLoading = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.ivSmallLoading);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivSmallLoading = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.circleProgressBar);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.qhqc.core.basic.widget.svprogresshud.view.SVCircleProgressBar");
        this.circleProgressBar = (SVCircleProgressBar) findViewById3;
        View findViewById4 = findViewById(R.id.tvMsg);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.tvMsg = (TextView) findViewById4;
        this.indicatorView = (IndicatorView) findViewById(R.id.indicator_view);
    }

    public final void dismiss() {
        clearAnimations();
        IndicatorView indicatorView = this.indicatorView;
        if (indicatorView != null) {
            Intrinsics.checkNotNull(indicatorView);
            if (indicatorView.getMIndicator() != null) {
                IndicatorView indicatorView2 = this.indicatorView;
                Intrinsics.checkNotNull(indicatorView2);
                Indicator mIndicator = indicatorView2.getMIndicator();
                Intrinsics.checkNotNull(mIndicator);
                mIndicator.stop();
            }
        }
    }

    @Nullable
    public final SVCircleProgressBar getCircleProgressBar() {
        return this.circleProgressBar;
    }

    public final void setText(@Nullable String string) {
        TextView textView = this.tvMsg;
        Intrinsics.checkNotNull(textView);
        textView.setText(string);
    }

    public final void show() {
        clearAnimations();
        ImageView imageView = this.ivSmallLoading;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        SVCircleProgressBar sVCircleProgressBar = this.circleProgressBar;
        Intrinsics.checkNotNull(sVCircleProgressBar);
        sVCircleProgressBar.setVisibility(8);
        TextView textView = this.tvMsg;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(8);
        IndicatorView indicatorView = this.indicatorView;
        if (indicatorView != null) {
            indicatorView.show();
        }
    }

    public final void showBaseStatus(int res, @Nullable String string) {
        clearAnimations();
        TextView textView = this.tvMsg;
        Intrinsics.checkNotNull(textView);
        textView.setText(string);
        ImageView imageView = this.ivBigLoading;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        SVCircleProgressBar sVCircleProgressBar = this.circleProgressBar;
        Intrinsics.checkNotNull(sVCircleProgressBar);
        sVCircleProgressBar.setVisibility(8);
        TextView textView2 = this.tvMsg;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(0);
        IndicatorView indicatorView = this.indicatorView;
        if (indicatorView != null) {
            indicatorView.show();
        }
    }

    public final void showErrorWithStatus(@Nullable String string) {
        showBaseStatus(this.resError, string);
    }

    public final void showInfoWithStatus(@Nullable String string) {
        showBaseStatus(this.resInfo, string);
    }

    public final void showProgress(@Nullable String string) {
        clearAnimations();
        TextView textView = this.tvMsg;
        Intrinsics.checkNotNull(textView);
        textView.setText(string);
        ImageView imageView = this.ivBigLoading;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(8);
        ImageView imageView2 = this.ivSmallLoading;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setVisibility(8);
        TextView textView2 = this.tvMsg;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(0);
        IndicatorView indicatorView = this.indicatorView;
        if (indicatorView != null) {
            indicatorView.show();
        }
    }

    public final void showSuccessWithStatus(@Nullable String string) {
        showBaseStatus(this.resSuccess, string);
    }

    public final void showWithProgress(@Nullable String string) {
        showProgress(string);
    }

    public final void showWithStatus(@Nullable String string) {
        if (string == null) {
            show();
            return;
        }
        showBaseStatus(this.resBigLoading, string);
        ImageView imageView = this.ivSmallLoading;
        Intrinsics.checkNotNull(imageView);
        imageView.startAnimation(this.mRotateAnimation);
    }
}

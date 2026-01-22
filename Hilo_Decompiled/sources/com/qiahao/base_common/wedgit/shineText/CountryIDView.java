package com.qiahao.base_common.wedgit.shineText;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.databinding.ViewCountryIdBinding;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.utils.Dimens;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J,\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020!J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/CountryIDView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/base_common/databinding/ViewCountryIdBinding;", "getBinding", "()Lcom/qiahao/base_common/databinding/ViewCountryIdBinding;", "setBinding", "(Lcom/qiahao/base_common/databinding/ViewCountryIdBinding;)V", "mImgWidth", "", "mImgHeight", "mBgHeight", "mTextSize", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "initView", "", "refreshText", "countryId", "", "idFrameType", "defaultColor", "isPrettyCode", "", "showSVGA", "svga", "Lcom/opensource/svgaplayer/SVGAImageView;", "reShowSVGA", "setDefaultColor", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CountryIDView extends FrameLayout {

    @Nullable
    private ViewCountryIdBinding binding;
    private float mBgHeight;
    private float mImgHeight;
    private float mImgWidth;
    private float mTextSize;

    @NotNull
    private final SVGAParser parser;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountryIDView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView(Context context, AttributeSet attrs) {
        ViewGroup.LayoutParams layoutParams;
        ViewCountryIdBinding viewCountryIdBinding;
        CountryShineTextView countryShineTextView;
        CountryShineTextView countryShineTextView2;
        CountryShineTextView countryShineTextView3;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        this.binding = (ViewCountryIdBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.view_country_id, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CountryIDView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mImgWidth = obtainStyledAttributes.getFloat(R.styleable.CountryIDView_countryIDSVGAWidth, DownloadProgress.UNKNOWN_PROGRESS);
        this.mImgHeight = obtainStyledAttributes.getFloat(R.styleable.CountryIDView_countryIDSVGAHeight, DownloadProgress.UNKNOWN_PROGRESS);
        this.mBgHeight = obtainStyledAttributes.getFloat(R.styleable.CountryIDView_countryIDTextHeight, DownloadProgress.UNKNOWN_PROGRESS);
        this.mTextSize = obtainStyledAttributes.getFloat(R.styleable.CountryIDView_countryIDTextSize, DownloadProgress.UNKNOWN_PROGRESS);
        obtainStyledAttributes.recycle();
        ViewCountryIdBinding viewCountryIdBinding2 = this.binding;
        ViewGroup.LayoutParams layoutParams2 = null;
        if (viewCountryIdBinding2 != null && (sVGAImageView2 = viewCountryIdBinding2.svga) != null) {
            layoutParams = sVGAImageView2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        float f10 = this.mImgWidth;
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(f10);
        }
        float f11 = this.mImgHeight;
        if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
            ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(f11);
        }
        ViewCountryIdBinding viewCountryIdBinding3 = this.binding;
        if (viewCountryIdBinding3 != null && (sVGAImageView = viewCountryIdBinding3.svga) != null) {
            sVGAImageView.setLayoutParams(bVar);
        }
        ViewCountryIdBinding viewCountryIdBinding4 = this.binding;
        if (viewCountryIdBinding4 != null && (countryShineTextView3 = viewCountryIdBinding4.countryId) != null) {
            layoutParams2 = countryShineTextView3.getLayoutParams();
        }
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        float f12 = this.mBgHeight;
        if (f12 > DownloadProgress.UNKNOWN_PROGRESS) {
            ((ViewGroup.MarginLayoutParams) bVar2).height = UiKtxKt.toPX(f12);
        }
        if (this.mImgWidth > 30.0f) {
            bVar2.setMarginStart(UiKtxKt.toPX(16));
        } else {
            bVar2.setMarginStart(UiKtxKt.toPX(14));
        }
        ViewCountryIdBinding viewCountryIdBinding5 = this.binding;
        if (viewCountryIdBinding5 != null && (countryShineTextView2 = viewCountryIdBinding5.countryId) != null) {
            countryShineTextView2.setLayoutParams(bVar2);
        }
        float f13 = this.mTextSize;
        if (f13 > DownloadProgress.UNKNOWN_PROGRESS && (viewCountryIdBinding = this.binding) != null && (countryShineTextView = viewCountryIdBinding.countryId) != null) {
            countryShineTextView.setTextSize(2, f13);
        }
    }

    public static /* synthetic */ void refreshText$default(CountryIDView countryIDView, String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        countryIDView.refreshText(str, i10, i11, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshText$lambda$0(int i10, CountryIDView countryIDView, String str, boolean z10, int i11) {
        CountryShineTextView countryShineTextView;
        CountryShineTextView countryShineTextView2;
        ShineTextView shineTextView;
        Group group;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        CountryShineTextView countryShineTextView3;
        CountryShineTextView countryShineTextView4;
        ShineTextView shineTextView2;
        Group group2;
        SVGAImageView sVGAImageView3;
        SVGAImageView sVGAImageView4;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        ShineTextView shineTextView5;
        ShineTextView shineTextView6;
        ShineTextView shineTextView7;
        ShineTextView shineTextView8;
        Group group3;
        if (i10 != 1) {
            if (i10 != 2) {
                ViewCountryIdBinding viewCountryIdBinding = countryIDView.binding;
                if (viewCountryIdBinding != null && (group3 = viewCountryIdBinding.group) != null) {
                    group3.setVisibility(8);
                }
                ViewCountryIdBinding viewCountryIdBinding2 = countryIDView.binding;
                if (viewCountryIdBinding2 != null && (shineTextView8 = viewCountryIdBinding2.userId) != null) {
                    shineTextView8.setVisibility(0);
                }
                if (z10) {
                    Drawable f10 = androidx.core.content.res.h.f(countryIDView.getResources(), R.drawable.icon_beauty_account, null);
                    if (f10 != null) {
                        Dimens dimens = Dimens.INSTANCE;
                        f10.setBounds(0, 0, dimens.dpToPx(4), dimens.dpToPx(4));
                    }
                    ViewCountryIdBinding viewCountryIdBinding3 = countryIDView.binding;
                    if (viewCountryIdBinding3 != null && (shineTextView7 = viewCountryIdBinding3.userId) != null) {
                        shineTextView7.setCompoundDrawablesWithIntrinsicBounds(f10, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                    ViewCountryIdBinding viewCountryIdBinding4 = countryIDView.binding;
                    if (viewCountryIdBinding4 != null && (shineTextView6 = viewCountryIdBinding4.userId) != null) {
                        shineTextView6.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
                    }
                } else {
                    ViewCountryIdBinding viewCountryIdBinding5 = countryIDView.binding;
                    if (viewCountryIdBinding5 != null && (shineTextView3 = viewCountryIdBinding5.userId) != null) {
                        shineTextView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
                ViewCountryIdBinding viewCountryIdBinding6 = countryIDView.binding;
                if (viewCountryIdBinding6 != null && (shineTextView5 = viewCountryIdBinding6.userId) != null) {
                    shineTextView5.setText(str);
                }
                ViewCountryIdBinding viewCountryIdBinding7 = countryIDView.binding;
                if (viewCountryIdBinding7 != null && (shineTextView4 = viewCountryIdBinding7.userId) != null) {
                    shineTextView4.setTextColor(i11);
                    return;
                }
                return;
            }
            ViewCountryIdBinding viewCountryIdBinding8 = countryIDView.binding;
            if (viewCountryIdBinding8 != null && (sVGAImageView4 = viewCountryIdBinding8.svga) != null) {
                sVGAImageView4.setTag("svga/country_id11.svga");
            }
            ViewCountryIdBinding viewCountryIdBinding9 = countryIDView.binding;
            if (viewCountryIdBinding9 != null && (sVGAImageView3 = viewCountryIdBinding9.glisten) != null) {
                sVGAImageView3.setTag("svga/country_glisten11.svga");
            }
            ViewCountryIdBinding viewCountryIdBinding10 = countryIDView.binding;
            if (viewCountryIdBinding10 != null && (group2 = viewCountryIdBinding10.group) != null) {
                group2.setVisibility(0);
            }
            ViewCountryIdBinding viewCountryIdBinding11 = countryIDView.binding;
            if (viewCountryIdBinding11 != null && (shineTextView2 = viewCountryIdBinding11.userId) != null) {
                shineTextView2.setVisibility(8);
            }
            ViewCountryIdBinding viewCountryIdBinding12 = countryIDView.binding;
            if (viewCountryIdBinding12 != null && (countryShineTextView4 = viewCountryIdBinding12.countryId) != null) {
                countryShineTextView4.setText(str);
            }
            ViewCountryIdBinding viewCountryIdBinding13 = countryIDView.binding;
            if (viewCountryIdBinding13 != null && (countryShineTextView3 = viewCountryIdBinding13.countryId) != null) {
                countryShineTextView3.setBackgroundDrawable(androidx.core.content.a.getDrawable(countryIDView.getContext(), R.drawable.country_id11));
            }
            countryIDView.reShowSVGA();
            return;
        }
        ViewCountryIdBinding viewCountryIdBinding14 = countryIDView.binding;
        if (viewCountryIdBinding14 != null && (sVGAImageView2 = viewCountryIdBinding14.svga) != null) {
            sVGAImageView2.setTag("svga/country_id.svga");
        }
        ViewCountryIdBinding viewCountryIdBinding15 = countryIDView.binding;
        if (viewCountryIdBinding15 != null && (sVGAImageView = viewCountryIdBinding15.glisten) != null) {
            sVGAImageView.setTag("svga/country_glisten.svga");
        }
        ViewCountryIdBinding viewCountryIdBinding16 = countryIDView.binding;
        if (viewCountryIdBinding16 != null && (group = viewCountryIdBinding16.group) != null) {
            group.setVisibility(0);
        }
        ViewCountryIdBinding viewCountryIdBinding17 = countryIDView.binding;
        if (viewCountryIdBinding17 != null && (shineTextView = viewCountryIdBinding17.userId) != null) {
            shineTextView.setVisibility(8);
        }
        ViewCountryIdBinding viewCountryIdBinding18 = countryIDView.binding;
        if (viewCountryIdBinding18 != null && (countryShineTextView2 = viewCountryIdBinding18.countryId) != null) {
            countryShineTextView2.setText(str);
        }
        ViewCountryIdBinding viewCountryIdBinding19 = countryIDView.binding;
        if (viewCountryIdBinding19 != null && (countryShineTextView = viewCountryIdBinding19.countryId) != null) {
            countryShineTextView.setBackgroundDrawable(androidx.core.content.a.getDrawable(countryIDView.getContext(), R.drawable.country_id));
        }
        countryIDView.reShowSVGA();
    }

    private final void showSVGA(final SVGAImageView svga) {
        if (svga != null) {
            try {
                Object tag = svga.getTag();
                if (tag != null) {
                    this.parser.decodeFromAssets((String) tag, new SVGAParser.ParseCompletion() { // from class: com.qiahao.base_common.wedgit.shineText.CountryIDView$showSVGA$1$1
                        @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                        public void onComplete(SVGAVideoEntity videoItem) {
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            SVGADrawable sVGADrawable = new SVGADrawable(videoItem);
                            SVGAImageView.this.stopAnimation(true);
                            SVGAImageView.this.setImageDrawable(sVGADrawable);
                            SVGAImageView.this.setLoops(-1);
                            SVGAImageView.this.startAnimation();
                        }

                        @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
                        public void onError() {
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    public final ViewCountryIdBinding getBinding() {
        return this.binding;
    }

    public final void reShowSVGA() {
        SVGAImageView sVGAImageView;
        ViewCountryIdBinding viewCountryIdBinding = this.binding;
        SVGAImageView sVGAImageView2 = null;
        if (viewCountryIdBinding != null) {
            sVGAImageView = viewCountryIdBinding.svga;
        } else {
            sVGAImageView = null;
        }
        showSVGA(sVGAImageView);
        ViewCountryIdBinding viewCountryIdBinding2 = this.binding;
        if (viewCountryIdBinding2 != null) {
            sVGAImageView2 = viewCountryIdBinding2.glisten;
        }
        showSVGA(sVGAImageView2);
    }

    public final void refreshText(@NotNull final String countryId, final int idFrameType, final int defaultColor, final boolean isPrettyCode) {
        View root;
        Intrinsics.checkNotNullParameter(countryId, "countryId");
        ViewCountryIdBinding viewCountryIdBinding = this.binding;
        if (viewCountryIdBinding != null && (root = viewCountryIdBinding.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.shineText.c
                @Override // java.lang.Runnable
                public final void run() {
                    CountryIDView.refreshText$lambda$0(idFrameType, this, countryId, isPrettyCode, defaultColor);
                }
            });
        }
    }

    public final void setBinding(@Nullable ViewCountryIdBinding viewCountryIdBinding) {
        this.binding = viewCountryIdBinding;
    }

    public final void setDefaultColor(int defaultColor) {
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        ShineTextView shineTextView;
        ViewCountryIdBinding viewCountryIdBinding = this.binding;
        if (viewCountryIdBinding != null && (shineTextView = viewCountryIdBinding.userId) != null) {
            shineTextView.setTextColor(defaultColor);
        }
        ViewCountryIdBinding viewCountryIdBinding2 = this.binding;
        if (viewCountryIdBinding2 != null && (sVGAImageView2 = viewCountryIdBinding2.svga) != null) {
            sVGAImageView2.stopAnimation();
        }
        ViewCountryIdBinding viewCountryIdBinding3 = this.binding;
        if (viewCountryIdBinding3 != null && (sVGAImageView = viewCountryIdBinding3.glisten) != null) {
            sVGAImageView.stopAnimation();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountryIDView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountryIDView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.parser = SVGAParser.INSTANCE.shareParser();
        initView(context, attributeSet);
    }
}

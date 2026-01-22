package com.qiahao.base_common.wedgit.shineText;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.qiahao.base_common.R;
import com.qiahao.base_common.databinding.NickTextViewBinding;
import com.qiahao.base_common.model.ShineColorData;
import com.qiahao.base_common.model.cache.MP4Key;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.vap.VapPlayer;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.wedgit.shineText.CenterGlowBreathingTextView;
import com.tencent.qgame.animplayer.AnimView;
import com.tencent.qgame.animplayer.util.ScaleType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\u001a\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010#\u001a\u00020\u001eH\u0014J\b\u0010$\u001a\u00020\u001eH\u0014J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\u001eJ&\u0010(\u001a\u00020\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\nJ\u001c\u0010,\u001a\u00020\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010*\u001a\u00020\nJ\u001c\u0010-\u001a\u00020\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010+\u001a\u00020\nJ\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nJ\u000e\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0011J\u0006\u00103\u001a\u00020\u001eR\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/qiahao/base_common/wedgit/shineText/NickTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDefaultColor", "mTextSize", "", "mTextStyle", "mText", "", "mShowFire", "", "mVipLevel", "mNobleLevel", "mBinding", "Lcom/qiahao/base_common/databinding/NickTextViewBinding;", "isVisible", "mCurrentAnimMode", "Lcom/qiahao/base_common/wedgit/shineText/CenterGlowBreathingTextView$AnimMode;", "mColorArray", "Lcom/qiahao/base_common/model/ShineColorData;", "initView", "", "startMP4", "stopMp4", "checkFireView", "getDefaultConfirm", "onAttachedToWindow", "onDetachedFromWindow", "startOrStopAnim", "isStart", "cleanAnimator", "setSVipAndNoble", "content", "vipLevel", "nobleLevel", "setTextAndVipLevel", "setNobleLevel", "setTextColor", "textColor", "setDefault", "setText", "str", "resetSvipAndNoble", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
@SourceDebugExtension({"SMAP\nNickTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NickTextView.kt\ncom/qiahao/base_common/wedgit/shineText/NickTextView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,288:1\n1#2:289\n51#3,9:290\n*S KotlinDebug\n*F\n+ 1 NickTextView.kt\ncom/qiahao/base_common/wedgit/shineText/NickTextView\n*L\n126#1:290,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class NickTextView extends FrameLayout {
    private boolean isVisible;

    @Nullable
    private NickTextViewBinding mBinding;

    @Nullable
    private ShineColorData mColorArray;

    @NotNull
    private CenterGlowBreathingTextView.AnimMode mCurrentAnimMode;
    private int mDefaultColor;
    private int mNobleLevel;
    private boolean mShowFire;

    @Nullable
    private String mText;
    private float mTextSize;
    private int mTextStyle;
    private int mVipLevel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDefaultColor = -1;
        this.mTextSize = 10.0f;
        this.isVisible = true;
        this.mCurrentAnimMode = CenterGlowBreathingTextView.AnimMode.FLOW_ONLY;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkFireView$lambda$4(NickTextView nickTextView) {
        AnimView animView;
        AnimView animView2;
        int i10;
        int i11;
        ViewGroup.LayoutParams layoutParams;
        AnimView animView3;
        AnimView animView4;
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        CenterGlowBreathingTextView.AnimMode animMode = nickTextView.mCurrentAnimMode;
        CenterGlowBreathingTextView.AnimMode animMode2 = CenterGlowBreathingTextView.AnimMode.GLOW_AND_FLOW;
        if (animMode == animMode2) {
            NickTextViewBinding nickTextViewBinding = nickTextView.mBinding;
            if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
                i11 = centerGlowBreathingTextView.getHeight();
            } else {
                i11 = 0;
            }
            NickTextViewBinding nickTextViewBinding2 = nickTextView.mBinding;
            if (nickTextViewBinding2 != null && (animView4 = nickTextViewBinding2.videoPlayer) != null) {
                layoutParams = animView4.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (i11 > 0) {
                ((ViewGroup.MarginLayoutParams) bVar).width = (int) (((i11 * 250) * 1.5f) / 115);
                ((ViewGroup.MarginLayoutParams) bVar).height = i11;
                bVar.setMarginStart((-i11) / 2);
            }
            NickTextViewBinding nickTextViewBinding3 = nickTextView.mBinding;
            if (nickTextViewBinding3 != null && (animView3 = nickTextViewBinding3.videoPlayer) != null) {
                animView3.setLayoutParams(bVar);
            }
        }
        NickTextViewBinding nickTextViewBinding4 = nickTextView.mBinding;
        if (nickTextViewBinding4 != null && (animView2 = nickTextViewBinding4.videoPlayer) != null) {
            if (nickTextView.mCurrentAnimMode == animMode2) {
                i10 = 4;
            } else {
                i10 = 8;
            }
            animView2.setVisibility(i10);
        }
        NickTextViewBinding nickTextViewBinding5 = nickTextView.mBinding;
        if (nickTextViewBinding5 != null && (animView = nickTextViewBinding5.videoPlayer) != null) {
            animView.invalidate();
        }
    }

    private final void getDefaultConfirm(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] NickTextView = R.styleable.NickTextView;
            Intrinsics.checkNotNullExpressionValue(NickTextView, "NickTextView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, NickTextView, 0, 0);
            this.mDefaultColor = obtainStyledAttributes.getColor(R.styleable.NickTextView_android_textColor, 0);
            this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.NickTextView_android_textSize, 10.0f);
            this.mTextStyle = obtainStyledAttributes.getInt(R.styleable.NickTextView_android_textStyle, 0);
            String string = obtainStyledAttributes.getString(R.styleable.NickTextView_android_text);
            if (string == null) {
                string = "";
            }
            this.mText = string;
            this.mShowFire = obtainStyledAttributes.getBoolean(R.styleable.NickTextView_showFire, false);
            obtainStyledAttributes.recycle();
        }
    }

    private final void initView() {
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        NickTextViewBinding nickTextViewBinding;
        VapPlayer vapPlayer;
        ConstraintLayout constraintLayout;
        NickTextViewBinding inflate = NickTextViewBinding.inflate(LayoutInflater.from(getContext()), this, true);
        this.mBinding = inflate;
        if (inflate != null && (constraintLayout = inflate.constraint) != null && (constraintLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 17;
            constraintLayout.setLayoutParams(layoutParams2);
        }
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner != null && (nickTextViewBinding = this.mBinding) != null && (vapPlayer = nickTextViewBinding.videoPlayer) != null) {
            vapPlayer.bindingLifeCycle(lifecycleOwner);
        }
        NickTextViewBinding nickTextViewBinding2 = this.mBinding;
        if (nickTextViewBinding2 != null && (centerGlowBreathingTextView = nickTextViewBinding2.text) != null) {
            centerGlowBreathingTextView.setDefaultColor(this.mDefaultColor);
            centerGlowBreathingTextView.setTextSize(0, this.mTextSize);
            centerGlowBreathingTextView.setTypeface(Typeface.defaultFromStyle(this.mTextStyle));
            checkFireView();
            centerGlowBreathingTextView.setText(this.mText);
            centerGlowBreathingTextView.setMAnimationListener(new Function1() { // from class: com.qiahao.base_common.wedgit.shineText.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit initView$lambda$3$lambda$2;
                    initView$lambda$3$lambda$2 = NickTextView.initView$lambda$3$lambda$2(NickTextView.this, ((Boolean) obj).booleanValue());
                    return initView$lambda$3$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3$lambda$2(NickTextView nickTextView, boolean z10) {
        if (z10) {
            nickTextView.startMP4();
        } else {
            nickTextView.stopMp4();
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setNobleLevel$default(NickTextView nickTextView, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        nickTextView.setNobleLevel(str, i10);
    }

    public static /* synthetic */ void setSVipAndNoble$default(NickTextView nickTextView, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = "";
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        nickTextView.setSVipAndNoble(str, i10, i11);
    }

    public static /* synthetic */ void setTextAndVipLevel$default(NickTextView nickTextView, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        nickTextView.setTextAndVipLevel(str, i10);
    }

    private final void startMP4() {
        VapPlayer vapPlayer;
        String str;
        VapPlayer vapPlayer2;
        AnimView animView;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (animView = nickTextViewBinding.videoPlayer) != null) {
            animView.setVisibility(0);
        }
        NickTextViewBinding nickTextViewBinding2 = this.mBinding;
        if (nickTextViewBinding2 != null && (vapPlayer2 = nickTextViewBinding2.videoPlayer) != null) {
            vapPlayer2.setScaleType(ScaleType.CENTER_CROP);
        }
        NickTextViewBinding nickTextViewBinding3 = this.mBinding;
        if (nickTextViewBinding3 != null && (vapPlayer = nickTextViewBinding3.videoPlayer) != null) {
            if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                str = MP4Key.NICK_FIRE_RIGHT_MP4;
            } else {
                str = MP4Key.NICK_FIRE_MP4;
            }
            vapPlayer.prepare(str, new VapMediaSource());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOrStopAnim$lambda$6(NickTextView nickTextView, boolean z10) {
        if (z10) {
            nickTextView.startMP4();
        } else {
            nickTextView.stopMp4();
        }
        return Unit.INSTANCE;
    }

    private final void stopMp4() {
        VapPlayer vapPlayer;
        AnimView animView;
        CenterGlowBreathingTextView.AnimMode animMode;
        int i10;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (animView = nickTextViewBinding.videoPlayer) != null) {
            CenterGlowBreathingTextView centerGlowBreathingTextView = nickTextViewBinding.text;
            if (centerGlowBreathingTextView != null) {
                animMode = centerGlowBreathingTextView.getAnimMode();
            } else {
                animMode = null;
            }
            if (animMode == CenterGlowBreathingTextView.AnimMode.GLOW_AND_FLOW) {
                i10 = 4;
            } else {
                i10 = 8;
            }
            animView.setVisibility(i10);
        }
        NickTextViewBinding nickTextViewBinding2 = this.mBinding;
        if (nickTextViewBinding2 != null && (vapPlayer = nickTextViewBinding2.videoPlayer) != null) {
            vapPlayer.stop(true);
        }
    }

    public final void checkFireView() {
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
            centerGlowBreathingTextView.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.shineText.f
                @Override // java.lang.Runnable
                public final void run() {
                    NickTextView.checkFireView$lambda$4(NickTextView.this);
                }
            });
        }
    }

    public final void cleanAnimator() {
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
            centerGlowBreathingTextView.cleanAnim();
        }
        stopMp4();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startOrStopAnim(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        startOrStopAnim(false);
    }

    public final void resetSvipAndNoble() {
        this.mVipLevel = 0;
        this.mNobleLevel = 0;
        this.mColorArray = null;
    }

    public final void setDefault(int textColor) {
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        this.mDefaultColor = textColor;
        resetSvipAndNoble();
        cleanAnimator();
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
            centerGlowBreathingTextView.setDefaultColor(textColor);
            centerGlowBreathingTextView.setText("");
        }
    }

    public final void setNobleLevel(@Nullable String content, int nobleLevel) {
        setSVipAndNoble(content, this.mVipLevel, nobleLevel);
    }

    public final void setSVipAndNoble(@Nullable String content, int vipLevel, int nobleLevel) {
        CenterGlowBreathingTextView.AnimMode animMode;
        final CenterGlowBreathingTextView centerGlowBreathingTextView;
        int[] shineColor;
        String str = this.mText;
        CenterGlowBreathingTextView.AnimMode animMode2 = this.mCurrentAnimMode;
        this.mColorArray = null;
        this.mVipLevel = vipLevel;
        this.mNobleLevel = nobleLevel;
        this.mText = content;
        ShineTextUtils shineTextUtils = ShineTextUtils.INSTANCE;
        String str2 = "";
        if (content == null) {
            content = "";
        }
        ShineColorData svipNick = shineTextUtils.getSvipNick(vipLevel, content);
        if (svipNick != null) {
            this.mColorArray = svipNick;
        }
        int i10 = this.mNobleLevel;
        String str3 = this.mText;
        if (str3 == null) {
            str3 = "";
        }
        ShineColorData noble = shineTextUtils.getNoble(i10, str3);
        if (noble != null) {
            this.mColorArray = noble;
        }
        if (this.mNobleLevel >= 10 && this.mShowFire) {
            animMode = CenterGlowBreathingTextView.AnimMode.GLOW_AND_FLOW;
        } else {
            animMode = CenterGlowBreathingTextView.AnimMode.FLOW_ONLY;
        }
        this.mCurrentAnimMode = animMode;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
            centerGlowBreathingTextView.setAnimMode(animMode);
            ShineColorData shineColorData = this.mColorArray;
            if (shineColorData != null && (shineColor = shineColorData.getShineColor()) != null) {
                centerGlowBreathingTextView.setBgColors(shineColor);
            }
            String str4 = this.mText;
            if (str4 != null) {
                str2 = str4;
            }
            centerGlowBreathingTextView.setText(str2);
            if (!Intrinsics.areEqual(str, this.mText) || animMode2 != this.mCurrentAnimMode) {
                checkFireView();
            }
            centerGlowBreathingTextView.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.shineText.g
                @Override // java.lang.Runnable
                public final void run() {
                    CenterGlowBreathingTextView.this.startAnim();
                }
            });
        }
    }

    public final void setText(@NotNull String str) {
        final CenterGlowBreathingTextView centerGlowBreathingTextView;
        Intrinsics.checkNotNullParameter(str, "str");
        String str2 = this.mText;
        this.mText = str;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
            if (!Intrinsics.areEqual(str2, str)) {
                checkFireView();
            }
            centerGlowBreathingTextView.setText(str);
            centerGlowBreathingTextView.post(new Runnable() { // from class: com.qiahao.base_common.wedgit.shineText.h
                @Override // java.lang.Runnable
                public final void run() {
                    CenterGlowBreathingTextView.this.startAnim();
                }
            });
        }
    }

    public final void setTextAndVipLevel(@Nullable String content, int vipLevel) {
        setSVipAndNoble(content, vipLevel, this.mNobleLevel);
    }

    public final void setTextColor(int textColor) {
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        this.mDefaultColor = textColor;
        NickTextViewBinding nickTextViewBinding = this.mBinding;
        if (nickTextViewBinding != null && (centerGlowBreathingTextView = nickTextViewBinding.text) != null) {
            centerGlowBreathingTextView.setDefaultColor(textColor);
            centerGlowBreathingTextView.invalidate();
        }
    }

    public final void startOrStopAnim(boolean isStart) {
        CenterGlowBreathingTextView centerGlowBreathingTextView;
        Function1<Boolean, Unit> function1;
        CenterGlowBreathingTextView centerGlowBreathingTextView2;
        NickTextViewBinding nickTextViewBinding;
        CenterGlowBreathingTextView centerGlowBreathingTextView3;
        CenterGlowBreathingTextView centerGlowBreathingTextView4;
        if (isStart) {
            NickTextViewBinding nickTextViewBinding2 = this.mBinding;
            if (nickTextViewBinding2 != null && (centerGlowBreathingTextView4 = nickTextViewBinding2.text) != null) {
                function1 = centerGlowBreathingTextView4.getMAnimationListener();
            } else {
                function1 = null;
            }
            if (function1 == null && (nickTextViewBinding = this.mBinding) != null && (centerGlowBreathingTextView3 = nickTextViewBinding.text) != null) {
                centerGlowBreathingTextView3.setMAnimationListener(new Function1() { // from class: com.qiahao.base_common.wedgit.shineText.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit startOrStopAnim$lambda$6;
                        startOrStopAnim$lambda$6 = NickTextView.startOrStopAnim$lambda$6(NickTextView.this, ((Boolean) obj).booleanValue());
                        return startOrStopAnim$lambda$6;
                    }
                });
            }
            NickTextViewBinding nickTextViewBinding3 = this.mBinding;
            if (nickTextViewBinding3 != null && (centerGlowBreathingTextView2 = nickTextViewBinding3.text) != null) {
                centerGlowBreathingTextView2.startAnim();
                return;
            }
            return;
        }
        NickTextViewBinding nickTextViewBinding4 = this.mBinding;
        if (nickTextViewBinding4 != null && (centerGlowBreathingTextView = nickTextViewBinding4.text) != null) {
            centerGlowBreathingTextView.cleanAnim();
        }
        stopMp4();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDefaultColor = -1;
        this.mTextSize = 10.0f;
        this.isVisible = true;
        this.mCurrentAnimMode = CenterGlowBreathingTextView.AnimMode.FLOW_ONLY;
        getDefaultConfirm(context, attributeSet);
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDefaultColor = -1;
        this.mTextSize = 10.0f;
        this.isVisible = true;
        this.mCurrentAnimMode = CenterGlowBreathingTextView.AnimMode.FLOW_ONLY;
        getDefaultConfirm(context, attributeSet);
        initView();
    }
}

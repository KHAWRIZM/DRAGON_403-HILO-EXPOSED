package com.opensource.svgaplayer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.utils.SVGARange;
import com.opensource.svgaplayer.utils.log.LogUtils;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001:\u0003defB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00106\u001a\u000207J(\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00000;2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010;H\u0002J\b\u0010>\u001a\u00020?H\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u0002072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010C\u001a\u0002072\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010F\u001a\u0002072\b\u0010G\u001a\u0004\u0018\u00010*H\u0002J\b\u0010H\u001a\u000207H\u0014J\b\u0010I\u001a\u000207H\u0014J\u0012\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010LH\u0017J\u000e\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020\nJ\u0018\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010=J\u0006\u0010P\u001a\u000207J\u001a\u0010Q\u001a\u0002072\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020\u0012H\u0002J\u000e\u0010U\u001a\u0002072\u0006\u0010V\u001a\u000203J\u0018\u0010W\u001a\u0002072\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010X\u001a\u00020\u0012J\u0010\u0010Y\u001a\u0002072\b\u0010Z\u001a\u0004\u0018\u00010[J\u001a\u0010Y\u001a\u0002072\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010O\u001a\u0004\u0018\u00010=J\b\u0010\\\u001a\u000207H\u0002J\u0006\u0010]\u001a\u000207J\u0010\u0010]\u001a\u0002072\u0006\u0010Z\u001a\u00020[H\u0002J\u001a\u0010]\u001a\u0002072\b\u0010R\u001a\u0004\u0018\u00010S2\b\b\u0002\u0010T\u001a\u00020\u0012J\u0016\u0010^\u001a\u0002072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u0012J\u0016\u0010a\u001a\u0002072\u0006\u0010b\u001a\u00020?2\u0006\u0010`\u001a\u00020\u0012J\u0006\u0010c\u001a\u000207J\u000e\u0010c\u001a\u0002072\u0006\u00106\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/opensource/svgaplayer/SVGACallback;", "getCallback", "()Lcom/opensource/svgaplayer/SVGACallback;", "setCallback", "(Lcom/opensource/svgaplayer/SVGACallback;)V", "clearsAfterDetached", "", "getClearsAfterDetached", "()Z", "setClearsAfterDetached", "(Z)V", "clearsAfterStop", "getClearsAfterStop$annotations", "()V", "getClearsAfterStop", "setClearsAfterStop", "fillMode", "Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "getFillMode", "()Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "setFillMode", "(Lcom/opensource/svgaplayer/SVGAImageView$FillMode;)V", "<set-?>", "isAnimating", "loops", "getLoops", "()I", "setLoops", "(I)V", "mAnimator", "Landroid/animation/ValueAnimator;", "mAnimatorListener", "Lcom/opensource/svgaplayer/SVGAImageView$AnimatorListener;", "mAnimatorUpdateListener", "Lcom/opensource/svgaplayer/SVGAImageView$AnimatorUpdateListener;", "mAntiAlias", "mAutoPlay", "mEndFrame", "mItemClickAreaListener", "Lcom/opensource/svgaplayer/SVGAClickAreaListener;", "mSource", "mStartFrame", "clear", "", "createParseCompletion", "Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "ref", "Ljava/lang/ref/WeakReference;", "dynamicItemRef", "Lcom/opensource/svgaplayer/SVGADynamicEntity;", "generateScale", "", "getSVGADrawable", "Lcom/opensource/svgaplayer/SVGADrawable;", "loadAttrs", "onAnimationEnd", "animation", "Landroid/animation/Animator;", "onAnimatorUpdate", "animator", "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "parserSource", "source", "dynamicItem", "pauseAnimation", "play", "range", "Lcom/opensource/svgaplayer/utils/SVGARange;", "reverse", "setOnAnimKeyClickListener", "clickListener", "setSource", "autoPlay", "setVideoItem", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "setupDrawable", "startAnimation", "stepToFrame", "frame", "andPlay", "stepToPercentage", "percentage", "stopAnimation", "AnimatorListener", "AnimatorUpdateListener", "FillMode", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGAImageView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGAImageView.kt\ncom/opensource/svgaplayer/SVGAImageView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SVGAImageView extends ImageView {

    @NotNull
    private final String TAG;

    @Nullable
    private SVGACallback callback;
    private boolean clearsAfterDetached;
    private boolean clearsAfterStop;

    @NotNull
    private FillMode fillMode;
    private boolean isAnimating;
    private int loops;

    @Nullable
    private ValueAnimator mAnimator;

    @NotNull
    private final AnimatorListener mAnimatorListener;

    @NotNull
    private final AnimatorUpdateListener mAnimatorUpdateListener;
    private boolean mAntiAlias;
    private boolean mAutoPlay;
    private int mEndFrame;

    @Nullable
    private SVGAClickAreaListener mItemClickAreaListener;

    @Nullable
    private String mSource;
    private int mStartFrame;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$AnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", ViewHierarchyConstants.VIEW_KEY, "Lcom/opensource/svgaplayer/SVGAImageView;", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "weakReference", "Ljava/lang/ref/WeakReference;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class AnimatorListener implements Animator.AnimatorListener {

        @NotNull
        private final WeakReference<SVGAImageView> weakReference;

        public AnimatorListener(@NotNull SVGAImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.weakReference = new WeakReference<>(view);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.isAnimating = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.onAnimationEnd(animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            SVGACallback callback;
            Intrinsics.checkNotNullParameter(animation, "animation");
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null && (callback = sVGAImageView.getCallback()) != null) {
                callback.onRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.isAnimating = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", ViewHierarchyConstants.VIEW_KEY, "Lcom/opensource/svgaplayer/SVGAImageView;", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "weakReference", "Ljava/lang/ref/WeakReference;", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class AnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {

        @NotNull
        private final WeakReference<SVGAImageView> weakReference;

        public AnimatorUpdateListener(@NotNull SVGAImageView view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.weakReference = new WeakReference<>(view);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NotNull ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            SVGAImageView sVGAImageView = this.weakReference.get();
            if (sVGAImageView != null) {
                sVGAImageView.onAnimatorUpdate(animation);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/opensource/svgaplayer/SVGAImageView$FillMode;", "", "(Ljava/lang/String;I)V", "Backward", "Forward", "Clear", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class FillMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FillMode[] $VALUES;
        public static final FillMode Backward = new FillMode("Backward", 0);
        public static final FillMode Forward = new FillMode("Forward", 1);
        public static final FillMode Clear = new FillMode("Clear", 2);

        private static final /* synthetic */ FillMode[] $values() {
            return new FillMode[]{Backward, Forward, Clear};
        }

        static {
            FillMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private FillMode(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<FillMode> getEntries() {
            return $ENTRIES;
        }

        public static FillMode valueOf(String str) {
            return (FillMode) Enum.valueOf(FillMode.class, str);
        }

        public static FillMode[] values() {
            return (FillMode[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FillMode.values().length];
            try {
                iArr[FillMode.Backward.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FillMode.Forward.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FillMode.Clear.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SVGAImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final SVGAParser.ParseCompletion createParseCompletion(final WeakReference<SVGAImageView> ref, final WeakReference<SVGADynamicEntity> dynamicItemRef) {
        return new SVGAParser.ParseCompletion() { // from class: com.opensource.svgaplayer.SVGAImageView$createParseCompletion$1
            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(@NotNull SVGAVideoEntity videoItem) {
                SVGAImageView sVGAImageView;
                SVGADynamicEntity sVGADynamicEntity;
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                WeakReference<SVGAImageView> weakReference = ref;
                if (weakReference != null && (sVGAImageView = weakReference.get()) != null) {
                    WeakReference<SVGADynamicEntity> weakReference2 = dynamicItemRef;
                    if (weakReference2 != null) {
                        sVGADynamicEntity = weakReference2.get();
                    } else {
                        sVGADynamicEntity = null;
                    }
                    if (sVGADynamicEntity == null) {
                        sVGAImageView.startAnimation(videoItem);
                        return;
                    }
                    SVGADynamicEntity sVGADynamicEntity2 = weakReference2.get();
                    Intrinsics.checkNotNull(sVGADynamicEntity2);
                    sVGAImageView.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity2));
                    sVGAImageView.startAnimation();
                }
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ SVGAParser.ParseCompletion createParseCompletion$default(SVGAImageView sVGAImageView, WeakReference weakReference, WeakReference weakReference2, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                weakReference2 = null;
            }
            return sVGAImageView.createParseCompletion(weakReference, weakReference2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createParseCompletion");
    }

    private final double generateScale() {
        double d10 = 1.0d;
        try {
            Class<?> cls = Class.forName("android.animation.ValueAnimator");
            Method declaredMethod = cls.getDeclaredMethod("getDurationScale", null);
            if (declaredMethod == null) {
                return 1.0d;
            }
            Object invoke = declaredMethod.invoke(cls, null);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Float");
            double floatValue = ((Float) invoke).floatValue();
            if (floatValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod("setDurationScale", Float.TYPE);
                    if (declaredMethod2 == null) {
                        return floatValue;
                    }
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(cls, Float.valueOf(1.0f));
                    LogUtils.INSTANCE.info(this.TAG, "The animation duration scale has been reset to 1.0x, because you closed it on developer options.");
                    return 1.0d;
                } catch (Exception e10) {
                    e = e10;
                    d10 = floatValue;
                    e.printStackTrace();
                    return d10;
                }
            }
            return floatValue;
        } catch (Exception e11) {
            e = e11;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "It is recommended to use clearAfterDetached, or manually call to SVGAVideoEntity#clear.If you just consider cleaning up the canvas after playing, you can use FillMode#Clear.")
    public static /* synthetic */ void getClearsAfterStop$annotations() {
    }

    private final SVGADrawable getSVGADrawable() {
        Drawable drawable = getDrawable();
        if (drawable instanceof SVGADrawable) {
            return (SVGADrawable) drawable;
        }
        return null;
    }

    private final void loadAttrs(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.SVGAImageView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.loops = obtainStyledAttributes.getInt(R.styleable.SVGAImageView_loopCount, 0);
        this.clearsAfterStop = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterStop, true);
        this.clearsAfterDetached = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_clearsAfterDetached, true);
        this.mAntiAlias = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_antiAlias, true);
        this.mAutoPlay = obtainStyledAttributes.getBoolean(R.styleable.SVGAImageView_autoPlay, true);
        String string = obtainStyledAttributes.getString(R.styleable.SVGAImageView_fillMode);
        if (string != null) {
            switch (string.hashCode()) {
                case 48:
                    if (string.equals("0")) {
                        this.fillMode = FillMode.Backward;
                        break;
                    }
                    break;
                case 49:
                    if (string.equals("1")) {
                        this.fillMode = FillMode.Forward;
                        break;
                    }
                    break;
                case 50:
                    if (string.equals("2")) {
                        this.fillMode = FillMode.Clear;
                        break;
                    }
                    break;
            }
        }
        String string2 = obtainStyledAttributes.getString(R.styleable.SVGAImageView_source);
        if (string2 != null) {
            this.mSource = string2;
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimationEnd(Animator animation) {
        this.isAnimating = false;
        stopAnimation();
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            int i10 = WhenMappings.$EnumSwitchMapping$0[this.fillMode.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        sVGADrawable.setCleared$lib_svga_release(true);
                    }
                } else {
                    sVGADrawable.setCurrentFrame$lib_svga_release(this.mEndFrame);
                }
            } else {
                sVGADrawable.setCurrentFrame$lib_svga_release(this.mStartFrame);
            }
        }
        if (this.clearsAfterStop) {
            Intrinsics.checkNotNull(animation, "null cannot be cast to non-null type android.animation.ValueAnimator");
            if (((ValueAnimator) animation).getRepeatCount() <= 0) {
                clear();
            }
        }
        SVGACallback sVGACallback = this.callback;
        if (sVGACallback != null) {
            sVGACallback.onFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnimatorUpdate(ValueAnimator animator) {
        Object obj;
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return;
        }
        if (animator != null) {
            obj = animator.getAnimatedValue();
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        sVGADrawable.setCurrentFrame$lib_svga_release(((Integer) obj).intValue());
        double currentFrame = (sVGADrawable.getCurrentFrame() + 1) / sVGADrawable.getVideoItem().getFrames();
        SVGACallback sVGACallback = this.callback;
        if (sVGACallback != null) {
            sVGACallback.onStep(sVGADrawable.getCurrentFrame(), currentFrame);
        }
    }

    private final void play(SVGARange range, boolean reverse) {
        int i10;
        int i11;
        int i12;
        LogUtils.INSTANCE.info(this.TAG, "================ start animation ================");
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return;
        }
        setupDrawable();
        int i13 = 0;
        if (range != null) {
            i10 = range.getLocation();
        } else {
            i10 = 0;
        }
        this.mStartFrame = Math.max(0, i10);
        int frames = sVGADrawable.getVideoItem().getFrames() - 1;
        if (range != null) {
            i13 = range.getLocation();
        }
        if (range != null) {
            i11 = range.getLength();
        } else {
            i11 = Integer.MAX_VALUE;
        }
        int min = Math.min(frames, (i13 + i11) - 1);
        this.mEndFrame = min;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mStartFrame, min);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration((long) ((((this.mEndFrame - this.mStartFrame) + 1) * (1000 / r0.getFPS())) / generateScale()));
        int i14 = this.loops;
        if (i14 <= 0) {
            i12 = 99999;
        } else {
            i12 = i14 - 1;
        }
        ofInt.setRepeatCount(i12);
        ofInt.addUpdateListener(this.mAnimatorUpdateListener);
        ofInt.addListener(this.mAnimatorListener);
        if (reverse) {
            ofInt.reverse();
        } else {
            ofInt.start();
        }
        this.mAnimator = ofInt;
    }

    public static /* synthetic */ void setSource$default(SVGAImageView sVGAImageView, String str, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            sVGAImageView.setSource(str, z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSource");
    }

    private final void setupDrawable() {
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return;
        }
        sVGADrawable.setCleared$lib_svga_release(false);
        ImageView.ScaleType scaleType = getScaleType();
        Intrinsics.checkNotNullExpressionValue(scaleType, "getScaleType(...)");
        sVGADrawable.setScaleType(scaleType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAnimation(final SVGAVideoEntity videoItem) {
        post(new Runnable() { // from class: com.opensource.svgaplayer.d
            @Override // java.lang.Runnable
            public final void run() {
                SVGAImageView.startAnimation$lambda$3(SVGAVideoEntity.this, this);
            }
        });
    }

    public static /* synthetic */ void startAnimation$default(SVGAImageView sVGAImageView, SVGARange sVGARange, boolean z10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            sVGAImageView.startAnimation(sVGARange, z10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAnimation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$3(SVGAVideoEntity videoItem, SVGAImageView this$0) {
        Intrinsics.checkNotNullParameter(videoItem, "$videoItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        videoItem.setAntiAlias(this$0.mAntiAlias);
        this$0.setVideoItem(videoItem);
        SVGADrawable sVGADrawable = this$0.getSVGADrawable();
        if (sVGADrawable != null) {
            ImageView.ScaleType scaleType = this$0.getScaleType();
            Intrinsics.checkNotNullExpressionValue(scaleType, "getScaleType(...)");
            sVGADrawable.setScaleType(scaleType);
        }
        if (this$0.mAutoPlay) {
            this$0.startAnimation();
        }
    }

    public final void clear() {
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.setCleared$lib_svga_release(true);
        }
        SVGADrawable sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 != null) {
            sVGADrawable2.clear();
        }
        setImageDrawable(null);
    }

    @Nullable
    public final SVGACallback getCallback() {
        return this.callback;
    }

    public final boolean getClearsAfterDetached() {
        return this.clearsAfterDetached;
    }

    public final boolean getClearsAfterStop() {
        return this.clearsAfterStop;
    }

    @NotNull
    public final FillMode getFillMode() {
        return this.fillMode;
    }

    public final int getLoops() {
        return this.loops;
    }

    /* renamed from: isAnimating, reason: from getter */
    public final boolean getIsAnimating() {
        return this.isAnimating;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mSource;
        if (str != null && str.length() > 0) {
            parserSource(str);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation(this.clearsAfterDetached);
        if (this.clearsAfterDetached) {
            clear();
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        SVGAClickAreaListener sVGAClickAreaListener;
        if (event != null && event.getAction() == 0) {
            SVGADrawable sVGADrawable = getSVGADrawable();
            if (sVGADrawable == null) {
                return super.onTouchEvent(event);
            }
            for (Map.Entry<String, int[]> entry : sVGADrawable.getDynamicItem().getMClickMap$lib_svga_release().entrySet()) {
                String key = entry.getKey();
                int[] value = entry.getValue();
                if (event.getX() >= value[0] && event.getX() <= value[2] && event.getY() >= value[1] && event.getY() <= value[3] && (sVGAClickAreaListener = this.mItemClickAreaListener) != null) {
                    sVGAClickAreaListener.onClick(key);
                    return true;
                }
            }
            return super.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public final void parserSource(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        parserSource(source, null);
    }

    public final void pauseAnimation() {
        stopAnimation(false);
        SVGACallback sVGACallback = this.callback;
        if (sVGACallback != null) {
            sVGACallback.onPause();
        }
    }

    public final void setCallback(@Nullable SVGACallback sVGACallback) {
        this.callback = sVGACallback;
    }

    public final void setClearsAfterDetached(boolean z10) {
        this.clearsAfterDetached = z10;
    }

    public final void setClearsAfterStop(boolean z10) {
        this.clearsAfterStop = z10;
    }

    public final void setFillMode(@NotNull FillMode fillMode) {
        Intrinsics.checkNotNullParameter(fillMode, "<set-?>");
        this.fillMode = fillMode;
    }

    public final void setLoops(int i10) {
        this.loops = i10;
    }

    public final void setOnAnimKeyClickListener(@NotNull SVGAClickAreaListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.mItemClickAreaListener = clickListener;
    }

    public final void setSource(@NotNull String source, boolean autoPlay) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        this.mSource = source;
        if (getVisibility() == 0 && (str = this.mSource) != null && str.length() != 0 && autoPlay) {
            parserSource(source);
        }
    }

    public final void setVideoItem(@Nullable SVGAVideoEntity videoItem) {
        setVideoItem(videoItem, new SVGADynamicEntity());
    }

    public final void stepToFrame(int frame, boolean andPlay) {
        pauseAnimation();
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable == null) {
            return;
        }
        sVGADrawable.setCurrentFrame$lib_svga_release(frame);
        if (andPlay) {
            startAnimation();
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator != null) {
                valueAnimator.setCurrentPlayTime(Math.max(DownloadProgress.UNKNOWN_PROGRESS, Math.min(1.0f, frame / sVGADrawable.getVideoItem().getFrames())) * ((float) valueAnimator.getDuration()));
            }
        }
    }

    public final void stepToPercentage(double percentage, boolean andPlay) {
        SVGADrawable sVGADrawable;
        Drawable drawable = getDrawable();
        if (drawable instanceof SVGADrawable) {
            sVGADrawable = (SVGADrawable) drawable;
        } else {
            sVGADrawable = null;
        }
        if (sVGADrawable == null) {
            return;
        }
        int frames = (int) (sVGADrawable.getVideoItem().getFrames() * percentage);
        if (frames >= sVGADrawable.getVideoItem().getFrames() && frames > 0) {
            frames = sVGADrawable.getVideoItem().getFrames() - 1;
        }
        stepToFrame(frames, andPlay);
    }

    public final void stopAnimation() {
        stopAnimation(this.clearsAfterStop);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SVGAImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void parserSource(@NotNull String source, @Nullable SVGADynamicEntity dynamicItem) {
        Intrinsics.checkNotNullParameter(source, "source");
        WeakReference<SVGAImageView> weakReference = new WeakReference<>(this);
        SVGAParser shareParser = SVGAParser.INSTANCE.shareParser();
        if (StringsKt.startsWith$default(source, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(source, "https://", false, 2, (Object) null)) {
            if (shareParser != null) {
                shareParser.decodeFromURL(new URL(source), createParseCompletion(weakReference, dynamicItem != null ? new WeakReference<>(dynamicItem) : null));
            }
        } else if (shareParser != null) {
            shareParser.decodeFromAssets(source, createParseCompletion(weakReference, dynamicItem != null ? new WeakReference<>(dynamicItem) : null));
        }
    }

    public final void setVideoItem(@Nullable SVGAVideoEntity videoItem, @Nullable SVGADynamicEntity dynamicItem) {
        if (videoItem == null) {
            setImageDrawable(null);
            return;
        }
        if (dynamicItem == null) {
            dynamicItem = new SVGADynamicEntity();
        }
        SVGADrawable sVGADrawable = new SVGADrawable(videoItem, dynamicItem);
        sVGADrawable.setCleared$lib_svga_release(true);
        setImageDrawable(sVGADrawable);
    }

    public final void startAnimation() {
        startAnimation(null, false);
    }

    public final void stopAnimation(boolean clear) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        SVGADrawable sVGADrawable = getSVGADrawable();
        if (sVGADrawable != null) {
            sVGADrawable.stop();
        }
        SVGADrawable sVGADrawable2 = getSVGADrawable();
        if (sVGADrawable2 == null) {
            return;
        }
        sVGADrawable2.setCleared$lib_svga_release(clear);
    }

    public /* synthetic */ SVGAImageView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void startAnimation(@Nullable SVGARange range, boolean reverse) {
        stopAnimation(false);
        play(range, reverse);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SVGAImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SVGAImageView";
        this.clearsAfterStop = true;
        this.clearsAfterDetached = true;
        this.fillMode = FillMode.Clear;
        this.mAntiAlias = true;
        this.mAutoPlay = true;
        this.mAnimatorListener = new AnimatorListener(this);
        this.mAnimatorUpdateListener = new AnimatorUpdateListener(this);
        if (attributeSet != null) {
            loadAttrs(attributeSet);
        }
    }
}

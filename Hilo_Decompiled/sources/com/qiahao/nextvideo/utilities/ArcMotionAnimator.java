package com.qiahao.nextvideo.utilities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.data.room.HiloAnimatorData;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014J0\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u001bJ\"\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0002J.\u0010'\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u0018J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00120\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/utilities/ArcMotionAnimator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "parentView", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "getParentView", "()Landroid/view/ViewGroup;", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "Landroid/graphics/Path;", "animatorCount", "", "animatorList", "Ljava/util/HashMap;", "", "Landroid/animation/ObjectAnimator;", "Lkotlin/collections/HashMap;", "notAddAnimator", "Lcom/qiahao/nextvideo/data/room/HiloAnimatorData;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "bindLifecycle", "", "createArcPath", "startX", "", "startY", "endX", "endY", "arcHeight", "start", "duration", "", "repeatCount", "view", "Landroid/view/View;", "handleAnimationEnd", "addAnimation", "position", "stop", "onDestroy", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nArcMotionAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArcMotionAnimator.kt\ncom/qiahao/nextvideo/utilities/ArcMotionAnimator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1869#2,2:195\n*S KotlinDebug\n*F\n+ 1 ArcMotionAnimator.kt\ncom/qiahao/nextvideo/utilities/ArcMotionAnimator\n*L\n181#1:195,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ArcMotionAnimator implements DefaultLifecycleObserver {
    private volatile int animatorCount;

    @NotNull
    private final HashMap<String, ObjectAnimator> animatorList;

    @NotNull
    private final CoroutineScope coroutineScope;

    @Nullable
    private Lifecycle lifecycle;

    @NotNull
    private final HashMap<String, HiloAnimatorData> notAddAnimator;

    @NotNull
    private final ViewGroup parentView;

    @Nullable
    private Path path;

    public ArcMotionAnimator(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        this.parentView = viewGroup;
        this.animatorList = new HashMap<>();
        this.notAddAnimator = new HashMap<>();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    public static /* synthetic */ void createArcPath$default(ArcMotionAnimator arcMotionAnimator, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        float f6;
        if ((i & 16) != 0) {
            f6 = 100.0f;
        } else {
            f6 = f5;
        }
        arcMotionAnimator.createArcPath(f, f2, f3, f4, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAnimationEnd(View view) {
        ViewGroup viewGroup;
        HiloAnimatorData remove;
        view.setVisibility(8);
        ViewParent parent = view.getParent();
        String str = null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        Object tag = view.getTag();
        if (tag instanceof String) {
            str = (String) tag;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        this.animatorCount--;
        if (str != null) {
            this.animatorList.remove(str);
            if (StringsKt.endsWith(str, "7", true)) {
                String substring = str.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (this.notAddAnimator.containsKey(substring) && (remove = this.notAddAnimator.remove(substring)) != null) {
                    addAnimation(remove.getStartX(), remove.getStartY(), remove.getEndX(), remove.getEndY(), remove.getPosition());
                }
            }
        }
    }

    public static /* synthetic */ void start$default(ArcMotionAnimator arcMotionAnimator, long j, int i, View view, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 2000;
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        arcMotionAnimator.start(j, i, view);
    }

    public final void addAnimation(int startX, int startY, int endX, int endY, int position) {
        if (this.animatorList.containsKey(position + "_7")) {
            this.notAddAnimator.put(String.valueOf(position), new HiloAnimatorData(startX, startY, endX, endY, position));
        } else {
            BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArcMotionAnimator$addAnimation$1(this, position, startX, startY, endX, endY, null), 3, (Object) null);
        }
    }

    public final void bindLifecycle(@NotNull Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    public final void createArcPath(float startX, float startY, float endX, float endY, float arcHeight) {
        Path path = new Path();
        path.moveTo(startX, startY);
        float f = 2;
        path.quadTo((startX + endX) / f, ((startY + endY) / f) - arcHeight, endX, endY);
        this.path = path;
    }

    @NotNull
    public final ViewGroup getParentView() {
        return this.parentView;
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.a(this, lifecycleOwner);
    }

    public void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, TUIConstants.TUIChat.OWNER);
        stop();
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.f.f(this, lifecycleOwner);
    }

    public final void start(long duration, int repeatCount, @NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Path path = this.path;
        if (path != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.X, (Property<View, Float>) View.Y, path);
            HashMap<String, ObjectAnimator> hashMap = this.animatorList;
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            hashMap.put((String) tag, ofFloat);
            ofFloat.setDuration(duration);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(repeatCount);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.qiahao.nextvideo.utilities.ArcMotionAnimator$start$1$animator$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.handleAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.handleAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    int i;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view.setVisibility(0);
                    ArcMotionAnimator arcMotionAnimator = this;
                    i = arcMotionAnimator.animatorCount;
                    arcMotionAnimator.animatorCount = i + 1;
                }
            });
            ofFloat.start();
        }
    }

    public final void stop() {
        Collection<ObjectAnimator> values = this.animatorList.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (ObjectAnimator objectAnimator : values) {
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
            }
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
        this.animatorList.clear();
        this.notAddAnimator.clear();
        JobKt.cancel$default(this.coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
    }
}

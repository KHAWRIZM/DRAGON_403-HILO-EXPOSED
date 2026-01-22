package com.qiahao.nextvideo.room.p٠٠٠float;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import c5.g;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.databinding.RoomFloatingViewBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import nd.a;
import o4.j;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ'\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001d\u0010\fJ\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\fJ\r\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010\fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u0010*R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010*R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010*R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010*R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010*R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/qiahao/nextvideo/room/float/RoomFloatView;", "Landroid/widget/FrameLayout;", "Landroid/app/Activity;", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/app/Activity;Landroid/util/AttributeSet;I)V", "", "initView", "()V", "snapToEdge", "from", "to", "", "vertical", "animateTo", "(IIZ)V", "updatePosition", "restoreLastPosition", "cancelAnimation", VerificationCodeFragment.TYPE_BIND, "dismiss", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDetachedFromWindow", "show", "hide", "Lcom/qiahao/nextvideo/databinding/RoomFloatingViewBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/RoomFloatingViewBinding;", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "Lnd/a;", "disposables", "Lnd/a;", "screenWidth", "I", "screenHeight", "margin48", "margin160", "slop", "Lkotlinx/coroutines/CoroutineScope;", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/WindowManager$LayoutParams;", "floatParams", "Landroid/view/WindowManager$LayoutParams;", "Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/animation/ValueAnimator;", "isDragging", "Z", "moveVertical", "isShown", "", TUIConstants.TUIChat.FACE_URL, "Ljava/lang/String;", "touchDownX", "touchDownY", "startX", "startY", "Landroid/view/animation/RotateAnimation;", "rotateAnim$delegate", "Lkotlin/Lazy;", "getRotateAnim", "()Landroid/view/animation/RotateAnimation;", "rotateAnim", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomFloatView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomFloatView.kt\ncom/qiahao/nextvideo/room/float/RoomFloatView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,255:1\n1#2:256\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class RoomFloatView extends FrameLayout {

    @NotNull
    private final RoomFloatingViewBinding binding;

    @NotNull
    private final a disposables;

    @NotNull
    private String faceUrl;

    @NotNull
    private final WindowManager.LayoutParams floatParams;
    private boolean isDragging;
    private boolean isShown;
    private final int margin160;
    private final int margin48;
    private boolean moveVertical;

    /* renamed from: rotateAnim$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy rotateAnim;
    private final int screenHeight;
    private final int screenWidth;
    private final int slop;
    private int startX;
    private int startY;
    private int touchDownX;
    private int touchDownY;

    @Nullable
    private ValueAnimator valueAnimator;

    @NotNull
    private final CoroutineScope viewScope;

    @NotNull
    private final WindowManager windowManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomFloatView(@NotNull Activity activity) {
        this(activity, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
    }

    private final void animateTo(int from, int to, final boolean vertical) {
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to);
        ofInt.setDuration(Math.abs(to - from));
        ofInt.setInterpolator(new AccelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.room.float.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RoomFloatView.animateTo$lambda$6$lambda$5(vertical, this, valueAnimator);
            }
        });
        ofInt.start();
        this.valueAnimator = ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTo$lambda$6$lambda$5(boolean z, RoomFloatView roomFloatView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (z) {
            roomFloatView.floatParams.x = intValue;
        } else {
            roomFloatView.floatParams.y = intValue;
        }
        roomFloatView.updatePosition();
    }

    private final void bind() {
        String str;
        GroupDetailBean groupDetailBean = MeetingRoomManager.INSTANCE.getGroupDetailBean();
        if (groupDetailBean != null) {
            str = groupDetailBean.getFaceUrl();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.faceUrl = str;
        this.binding.currentStateTextView.setText(ResourcesKtxKt.getStringById(this, 2131952939));
        AppCompatImageView appCompatImageView = this.binding.avatarCircleImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "avatarCircleImageView");
        ImageKtxKt.loadImage$default(appCompatImageView, this.faceUrl, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (g) null, 40958, (Object) null);
    }

    private final void cancelAnimation() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.binding.avatarCircleImageView.clearAnimation();
    }

    private final RotateAnimation getRotateAnim() {
        return (RotateAnimation) this.rotateAnim.getValue();
    }

    private final void initView() {
        this.binding.dismissImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.float.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomFloatView.this.dismiss();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.float.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomFloatView.initView$lambda$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(View view) {
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, MeetingRoomManager.INSTANCE.getMGroupId(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    private final void restoreLastPosition() {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        int intValue = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore, "RoomFloatViewX", -1, (String) null, 4, (Object) null)).intValue();
        int intValue2 = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore, "RoomFloatViewY", -1, (String) null, 4, (Object) null)).intValue();
        if (intValue != -1 && intValue2 != -1) {
            WindowManager.LayoutParams layoutParams = this.floatParams;
            layoutParams.x = intValue;
            layoutParams.y = intValue2;
        } else {
            WindowManager.LayoutParams layoutParams2 = this.floatParams;
            int i = this.margin48;
            layoutParams2.x = i;
            layoutParams2.y = (this.screenHeight - this.margin160) - i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RotateAnimation rotateAnim_delegate$lambda$2() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(8000L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setFillAfter(true);
        return rotateAnimation;
    }

    private final void snapToEdge() {
        int i = 0;
        if (this.floatParams.y < getHeight()) {
            int i2 = this.slop;
            int width = (this.screenWidth - getWidth()) - this.slop;
            WindowManager.LayoutParams layoutParams = this.floatParams;
            int i3 = layoutParams.x;
            if (i2 <= i3 && i3 <= width) {
                this.moveVertical = false;
                animateTo(layoutParams.y, 0, false);
                return;
            }
        }
        if (this.floatParams.y > this.screenHeight - (getHeight() * 2)) {
            int i4 = this.slop;
            int width2 = (this.screenWidth - getWidth()) - this.slop;
            int i5 = this.floatParams.x;
            if (i4 <= i5 && i5 <= width2) {
                int height = this.screenHeight - getHeight();
                this.moveVertical = false;
                animateTo(this.floatParams.y, height, false);
                return;
            }
        }
        this.moveVertical = true;
        int i6 = this.floatParams.x;
        int i7 = this.screenWidth;
        if (i6 >= i7 / 2) {
            i = i7 - getWidth();
        }
        animateTo(this.floatParams.x, i, true);
    }

    private final void updatePosition() {
        try {
            Result.Companion companion = Result.Companion;
            this.windowManager.updateViewLayout(this, this.floatParams);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "RoomFloatViewX", Integer.valueOf(this.floatParams.x), (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "RoomFloatViewY", Integer.valueOf(this.floatParams.y), (String) null, 4, (Object) null);
    }

    public final void dismiss() {
        hide();
        MeetingRoomManager.leaveRoom$default(MeetingRoomManager.INSTANCE, false, 1, null);
    }

    public final void hide() {
        if (this.isShown) {
            this.isShown = false;
            cancelAnimation();
            try {
                Result.Companion companion = Result.Companion;
                this.windowManager.removeViewImmediate(this);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelAnimation();
        this.disposables.d();
        CoroutineScopeKt.cancel$default(this.viewScope, (CancellationException) null, 1, (Object) null);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r0 != 3) goto L٢٠;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int rawX = (int) (event.getRawX() - this.touchDownX);
                    int rawY = (int) (event.getRawY() - this.touchDownY);
                    if (Math.abs(rawX) > this.slop || Math.abs(rawY) > this.slop) {
                        this.isDragging = true;
                        WindowManager.LayoutParams layoutParams = this.floatParams;
                        layoutParams.x = this.startX + rawX;
                        layoutParams.y = this.startY + rawY;
                        updatePosition();
                    }
                }
            }
            if (this.isDragging) {
                setPressed(false);
            }
            snapToEdge();
        } else {
            cancelAnimation();
            setPressed(true);
            this.isDragging = false;
            this.touchDownX = (int) event.getRawX();
            this.touchDownY = (int) event.getRawY();
            WindowManager.LayoutParams layoutParams2 = this.floatParams;
            this.startX = layoutParams2.x;
            this.startY = layoutParams2.y;
        }
        if (!this.isDragging && !super.onTouchEvent(event)) {
            return false;
        }
        return true;
    }

    public final void show() {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!meetingRoomManager.isRoomSmall()) {
            if (this.isShown) {
                hide();
                return;
            }
            return;
        }
        String str = null;
        if (this.isShown) {
            String str2 = this.faceUrl;
            GroupDetailBean groupDetailBean = meetingRoomManager.getGroupDetailBean();
            if (groupDetailBean != null) {
                str = groupDetailBean.getFaceUrl();
            }
            if (!Intrinsics.areEqual(str2, str)) {
                bind();
                return;
            }
            return;
        }
        restoreLastPosition();
        this.isShown = true;
        this.binding.avatarCircleImageView.startAnimation(getRotateAnim());
        this.windowManager.addView(this, this.floatParams);
        snapToEdge();
        bind();
        BuildersKt.launch$default(this.viewScope, Dispatchers.getMain(), (CoroutineStart) null, new RoomFloatView$show$1(this, null), 2, (Object) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomFloatView(@NotNull Activity activity, @Nullable AttributeSet attributeSet) {
        this(activity, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
    }

    public /* synthetic */ RoomFloatView(Activity activity, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomFloatView(@NotNull Activity activity, @Nullable AttributeSet attributeSet, int i) {
        super(activity, attributeSet, i);
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        RoomFloatingViewBinding inflate = RoomFloatingViewBinding.inflate(LayoutInflater.from(activity), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        Object systemService = activity.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        this.disposables = new a();
        Dimens dimens = Dimens.INSTANCE;
        this.screenWidth = dimens.getScreenWidth();
        int screenHeight = dimens.getScreenHeight();
        this.screenHeight = screenHeight;
        this.margin48 = dimens.dpToPx(48);
        this.margin160 = dimens.dpToPx(UserProxyUtility.exitRoom);
        this.slop = 3;
        this.viewScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags |= 262184;
        layoutParams.format = 1;
        layoutParams.alpha = 1.0f;
        layoutParams.gravity = 51;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.x = 0;
        layoutParams.y = screenHeight / 2;
        this.floatParams = layoutParams;
        this.faceUrl = "";
        this.rotateAnim = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.float.a
            public final Object invoke() {
                RotateAnimation rotateAnim_delegate$lambda$2;
                rotateAnim_delegate$lambda$2 = RoomFloatView.rotateAnim_delegate$lambda$2();
                return rotateAnim_delegate$lambda$2;
            }
        });
        initView();
    }
}

package com.qiahao.nextvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import cf.c;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\b\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000fH\u0016J(\u00107\u001a\u00020'2\u0006\u00106\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\fH\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u00106\u001a\u00020\u000fH\u0016J\u000e\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u000201J\u0010\u0010>\u001a\u00020'2\u0006\u0010=\u001a\u000201H\u0016J\b\u0010?\u001a\u00020'H\u0002J\b\u0010@\u001a\u00020'H\u0002J\u000e\u0010A\u001a\u00020'H\u0082@¢\u0006\u0002\u0010BJ\u0012\u0010C\u001a\u00020'2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0016J\u0006\u0010E\u001a\u00020'J\b\u0010F\u001a\u00020'H\u0002J\u0006\u0010G\u001a\u00020\u0011R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/qiahao/nextvideo/view/RoomAllGiftView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHolder", "Landroid/view/SurfaceHolder;", "mFlag", "", "mFlowers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/PointF;", "mBitmapList", "Landroid/graphics/Bitmap;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "mRandom", "Ljava/util/Random;", "mBitmap", "mNowTime", "mStop", "isDelay", "mCanvas", "Landroid/graphics/Canvas;", "mListener", "Lkotlin/Function0;", "", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "currentOperation", "Lkotlinx/coroutines/Job;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "init", "surfaceCreated", "holder", "surfaceChanged", "format", "width", "height", "surfaceDestroyed", "bindToLifecycle", TUIConstants.TUIChat.OWNER, "onDestroy", "cleanup", "clearSurfaceView", "runFalling", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAllGift", "bitmap", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "addBitmap", "isPlayAnimation", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomAllGiftView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomAllGiftView.kt\ncom/qiahao/nextvideo/view/RoomAllGiftView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,301:1\n1869#2,2:302\n1869#2,2:304\n1869#2,2:306\n*S KotlinDebug\n*F\n+ 1 RoomAllGiftView.kt\ncom/qiahao/nextvideo/view/RoomAllGiftView\n*L\n158#1:302,2\n180#1:304,2\n190#1:306,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAllGiftView extends SurfaceView implements SurfaceHolder.Callback, DefaultLifecycleObserver {

    @Nullable
    private Job currentOperation;
    private boolean isDelay;

    @Nullable
    private LifecycleOwner lifecycleOwner;

    @Nullable
    private Bitmap mBitmap;

    @NotNull
    private CopyOnWriteArrayList<Bitmap> mBitmapList;

    @Nullable
    private Canvas mCanvas;
    private boolean mFlag;

    @NotNull
    private CopyOnWriteArrayList<PointF> mFlowers;

    @NotNull
    private SurfaceHolder mHolder;

    @Nullable
    private Function0<Unit> mListener;
    private int mNowTime;

    @NotNull
    private Random mRandom;
    private boolean mStop;

    @NotNull
    private final Mutex mutex;

    @Nullable
    private CountDownTimer timerTask;

    @NotNull
    private final CoroutineScope viewScope;

    public RoomAllGiftView(@Nullable Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        Intrinsics.checkNotNullExpressionValue(holder, "getHolder(...)");
        this.mHolder = holder;
        this.mFlowers = new CopyOnWriteArrayList<>();
        this.mBitmapList = new CopyOnWriteArrayList<>();
        this.mRandom = new Random();
        this.viewScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        init();
    }

    private final void addBitmap() {
        float f;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            PointF pointF = new PointF();
            pointF.x = this.mRandom.nextInt(getWidth()) - UiKtxKt.toPX(60);
            Bitmap bitmap2 = this.mBitmap;
            if (bitmap2 != null) {
                f = bitmap2.getHeight();
            } else {
                f = 0.0f;
            }
            pointF.y = -f;
            this.mFlowers.add(pointF);
        }
    }

    private final void cleanup() {
        Lifecycle lifecycle;
        CoroutineScopeKt.cancel$default(this.viewScope, (CancellationException) null, 1, (Object) null);
        Job job = this.currentOperation;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.currentOperation = null;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycleOwner = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearSurfaceView() {
        Canvas lockCanvas;
        try {
            try {
                try {
                    synchronized (this.mHolder) {
                        lockCanvas = this.mHolder.lockCanvas();
                        if (lockCanvas != null) {
                            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    if (lockCanvas != null) {
                        synchronized (this.mHolder) {
                            this.mHolder.unlockCanvasAndPost(lockCanvas);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (0 != 0) {
                        synchronized (this.mHolder) {
                            this.mHolder.unlockCanvasAndPost(null);
                            Unit unit3 = Unit.INSTANCE;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    synchronized (this.mHolder) {
                        this.mHolder.unlockCanvasAndPost(null);
                        Unit unit4 = Unit.INSTANCE;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private final void init() {
        this.mHolder.addCallback(this);
        setClickable(false);
        setZOrderOnTop(true);
        this.mHolder.setFormat(-3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0049 -> B:10:0x004c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runFalling(Continuation<? super Unit> continuation) {
        RoomAllGiftView$runFalling$1 roomAllGiftView$runFalling$1;
        int i;
        RoomAllGiftView roomAllGiftView;
        Bitmap bitmap;
        float f;
        Bitmap bitmap2;
        Canvas canvas;
        float f2;
        if (continuation instanceof RoomAllGiftView$runFalling$1) {
            roomAllGiftView$runFalling$1 = (RoomAllGiftView$runFalling$1) continuation;
            int i2 = roomAllGiftView$runFalling$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                roomAllGiftView$runFalling$1.label = i2 - Integer.MIN_VALUE;
                Object obj = roomAllGiftView$runFalling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = roomAllGiftView$runFalling$1.label;
                if (i == 0) {
                    if (i == 1) {
                        roomAllGiftView = (RoomAllGiftView) roomAllGiftView$runFalling$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        try {
                            try {
                            } catch (Throwable th) {
                                try {
                                    Canvas canvas2 = roomAllGiftView.mCanvas;
                                    if (canvas2 != null) {
                                        roomAllGiftView.mHolder.unlockCanvasAndPost(canvas2);
                                        roomAllGiftView.mCanvas = null;
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Canvas canvas3 = roomAllGiftView.mCanvas;
                            if (canvas3 != null) {
                                roomAllGiftView.mHolder.unlockCanvasAndPost(canvas3);
                                roomAllGiftView.mCanvas = null;
                            }
                        }
                        synchronized (roomAllGiftView.mHolder) {
                            try {
                                int i3 = roomAllGiftView.mNowTime;
                                boolean z = false;
                                if (i3 > 0 && !roomAllGiftView.mStop) {
                                    roomAllGiftView.mNowTime = i3 - 20;
                                    Canvas lockCanvas = roomAllGiftView.mHolder.lockCanvas();
                                    roomAllGiftView.mCanvas = lockCanvas;
                                    if (lockCanvas != null) {
                                        lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                                    }
                                    Iterator<T> it = roomAllGiftView.mFlowers.iterator();
                                    PointF pointF = null;
                                    while (true) {
                                        float f3 = 0.0f;
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        pointF = (PointF) it.next();
                                        Bitmap bitmap3 = roomAllGiftView.mBitmap;
                                        if (bitmap3 != null && !bitmap3.isRecycled() && (bitmap2 = roomAllGiftView.mBitmap) != null && (canvas = roomAllGiftView.mCanvas) != null) {
                                            if (pointF != null) {
                                                f2 = pointF.x;
                                            } else {
                                                f2 = 0.0f;
                                            }
                                            if (pointF != null) {
                                                f3 = pointF.y;
                                            }
                                            canvas.drawBitmap(bitmap2, f2, f3, (Paint) null);
                                        }
                                        if (pointF != null) {
                                            float f4 = pointF.y;
                                            pointF.y = f4 + (100 * (Math.abs(f4) / roomAllGiftView.getHeight())) + 20;
                                        }
                                    }
                                    if (roomAllGiftView.mNowTime > 1500) {
                                        roomAllGiftView.addBitmap();
                                    }
                                    for (PointF pointF2 : roomAllGiftView.mFlowers) {
                                        if (Intrinsics.areEqual(pointF2, pointF)) {
                                            if (pointF != null) {
                                                f = pointF.y;
                                            } else {
                                                f = 0.0f;
                                            }
                                            if (f >= roomAllGiftView.getHeight()) {
                                                roomAllGiftView.mFlowers.remove(pointF2);
                                            }
                                        }
                                    }
                                } else {
                                    Canvas lockCanvas2 = roomAllGiftView.mHolder.lockCanvas();
                                    roomAllGiftView.mCanvas = lockCanvas2;
                                    if (lockCanvas2 != null) {
                                        lockCanvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                                    }
                                    if (roomAllGiftView.mNowTime <= 0) {
                                        Iterator<T> it2 = roomAllGiftView.mBitmapList.iterator();
                                        while (it2.hasNext()) {
                                            if (Intrinsics.areEqual(((Bitmap) it2.next()).toString(), String.valueOf(roomAllGiftView.mBitmap))) {
                                                z = true;
                                            }
                                        }
                                        if (!z && (bitmap = roomAllGiftView.mBitmap) != null && !bitmap.isRecycled()) {
                                            roomAllGiftView.mBitmap = null;
                                        }
                                        roomAllGiftView.mFlowers.clear();
                                        roomAllGiftView.startAllGift(null);
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                            } finally {
                            }
                        }
                        Canvas canvas4 = roomAllGiftView.mCanvas;
                        if (canvas4 != null) {
                            try {
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            roomAllGiftView.mHolder.unlockCanvasAndPost(canvas4);
                            roomAllGiftView.mCanvas = null;
                        }
                        if (!roomAllGiftView.mFlag) {
                            roomAllGiftView$runFalling$1.L$0 = roomAllGiftView;
                            roomAllGiftView$runFalling$1.label = 1;
                            if (DelayKt.delay(5L, roomAllGiftView$runFalling$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            synchronized (roomAllGiftView.mHolder) {
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    roomAllGiftView = this;
                    if (!roomAllGiftView.mFlag) {
                    }
                }
            }
        }
        roomAllGiftView$runFalling$1 = new RoomAllGiftView$runFalling$1(this, continuation);
        Object obj2 = roomAllGiftView$runFalling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = roomAllGiftView$runFalling$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ void startAllGift$default(RoomAllGiftView roomAllGiftView, Bitmap bitmap, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = null;
        }
        roomAllGiftView.startAllGift(bitmap);
    }

    public final void bindToLifecycle(@NotNull LifecycleOwner owner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(owner, TUIConstants.TUIChat.OWNER);
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        this.lifecycleOwner = owner;
        owner.getLifecycle().addObserver(this);
        if (owner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            destroy();
        }
    }

    public final void destroy() {
        cleanup();
        try {
            this.mNowTime = 0;
            this.mFlag = false;
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mBitmap = null;
            }
            this.mBitmapList.clear();
            post(new Runnable() { // from class: com.qiahao.nextvideo.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    RoomAllGiftView.this.clearSurfaceView();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public final boolean isPlayAnimation() {
        if (this.mNowTime > 0) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        f.a(this, lifecycleOwner);
    }

    public void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, TUIConstants.TUIChat.OWNER);
        f.b(this, owner);
        destroy();
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        f.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        f.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        f.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        f.f(this, lifecycleOwner);
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public final void startAllGift(@Nullable Bitmap bitmap) {
        boolean z;
        if (bitmap != null) {
            this.mBitmapList.add(bitmap);
        }
        if (this.isDelay) {
            this.mStop = true;
        }
        if (this.mStop) {
            return;
        }
        c c = c.c();
        if (this.mBitmapList.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        c.l(new LiveEvent("isShow", Boolean.valueOf(z)));
        if (this.mBitmapList.size() > 0 && this.mNowTime <= 0) {
            this.mBitmap = this.mBitmapList.get(0);
            this.mBitmapList.remove(0);
            this.mNowTime = 5000;
        }
        try {
            if (!this.mFlag) {
                this.mFlag = true;
                this.currentOperation = BuildersKt.launch$default(this.viewScope, (CoroutineContext) null, (CoroutineStart) null, new RoomAllGiftView$startAllGift$2(this, null), 3, (Object) null);
            }
            if (this.mNowTime <= 0) {
                this.mFlag = false;
                Function0<Unit> function0 = this.mListener;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.mFlag = false;
        BuildersKt.launch$default(this.viewScope, (CoroutineContext) null, (CoroutineStart) null, new RoomAllGiftView$surfaceDestroyed$1(this, null), 3, (Object) null);
    }

    public RoomAllGiftView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        SurfaceHolder holder = getHolder();
        Intrinsics.checkNotNullExpressionValue(holder, "getHolder(...)");
        this.mHolder = holder;
        this.mFlowers = new CopyOnWriteArrayList<>();
        this.mBitmapList = new CopyOnWriteArrayList<>();
        this.mRandom = new Random();
        this.viewScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        init();
    }

    public RoomAllGiftView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SurfaceHolder holder = getHolder();
        Intrinsics.checkNotNullExpressionValue(holder, "getHolder(...)");
        this.mHolder = holder;
        this.mFlowers = new CopyOnWriteArrayList<>();
        this.mBitmapList = new CopyOnWriteArrayList<>();
        this.mRandom = new Random();
        this.viewScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        init();
    }
}

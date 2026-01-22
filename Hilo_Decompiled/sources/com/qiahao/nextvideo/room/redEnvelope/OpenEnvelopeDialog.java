package com.qiahao.nextvideo.room.redEnvelope;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.utils.SVGARange;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.databinding.DialogOpenEnvelopeBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeDetailActivity;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.imsdk.v2.V2TIMManager;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010\u0016\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010$R\"\u0010'\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010$R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/OpenEnvelopeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogOpenEnvelopeBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "mEnvelopeData", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/room/EnvelopeData;)V", "", "initView", "()V", "refreshView", "playOpenSVGA", "openEnvelope", "countDown", "playSVGA", "", "getLayoutResId", "()I", "", "isNeedFullScreen", "()Z", "onInitialize", "dismiss", "Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "getMEnvelopeData", "()Lcom/qiahao/nextvideo/data/room/EnvelopeData;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "isOpen", "Z", "setOpen", "(Z)V", "isRoom", "setRoom", "canGet", "getCanGet", "setCanGet", "Landroid/os/CountDownTimer;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "Lcom/opensource/svgaplayer/SVGAParser;", "parser$delegate", "Lkotlin/Lazy;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "parser", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOpenEnvelopeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OpenEnvelopeDialog.kt\ncom/qiahao/nextvideo/room/redEnvelope/OpenEnvelopeDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,263:1\n61#2,9:264\n61#2,9:273\n61#2,9:282\n61#2,9:291\n61#2,9:300\n61#2,9:309\n61#2,9:318\n*S KotlinDebug\n*F\n+ 1 OpenEnvelopeDialog.kt\ncom/qiahao/nextvideo/room/redEnvelope/OpenEnvelopeDialog\n*L\n71#1:264,9\n74#1:273,9\n82#1:282,9\n85#1:291,9\n88#1:300,9\n89#1:309,9\n90#1:318,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OpenEnvelopeDialog extends BaseBindingDialog<DialogOpenEnvelopeBinding> {
    private boolean canGet;
    private boolean isOpen;
    private boolean isRoom;

    @NotNull
    private final nd.a mCompositeDisposable;

    @Nullable
    private final EnvelopeData mEnvelopeData;

    /* renamed from: parser$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parser;

    @Nullable
    private CountDownTimer timerTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenEnvelopeDialog(@NotNull Context context, @Nullable EnvelopeData envelopeData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEnvelopeData = envelopeData;
        this.mCompositeDisposable = new nd.a();
        this.isOpen = true;
        this.parser = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.redEnvelope.a
            public final Object invoke() {
                SVGAParser parser_delegate$lambda$0;
                parser_delegate$lambda$0 = OpenEnvelopeDialog.parser_delegate$lambda$0();
                return parser_delegate$lambda$0;
            }
        });
    }

    public static final /* synthetic */ DialogOpenEnvelopeBinding access$getBinding(OpenEnvelopeDialog openEnvelopeDialog) {
        return (DialogOpenEnvelopeBinding) openEnvelopeDialog.getBinding();
    }

    private final void countDown() {
        long j;
        Long start;
        if (!this.isRoom) {
            CountDownTimer countDownTimer = this.timerTask;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            EnvelopeData envelopeData = this.mEnvelopeData;
            if (envelopeData != null && (start = envelopeData.getStart()) != null) {
                j = start.longValue();
            } else {
                j = 0;
            }
            final long serverTime = (j - V2TIMManager.getInstance().getServerTime()) * 1000;
            CountDownTimer countDownTimer2 = new CountDownTimer(serverTime) { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$countDown$1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    OpenEnvelopeDialog.this.setCanGet(true);
                    OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).time.setVisibility(8);
                    OpenEnvelopeDialog.this.playOpenSVGA();
                }

                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).time.setText(com.qiahao.base_common.utils.f.c(((int) millisUntilFinished) / 1000));
                }
            };
            this.timerTask = countDownTimer2;
            countDownTimer2.start();
        }
    }

    private final SVGAParser getParser() {
        return (SVGAParser) this.parser.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        long j;
        boolean z;
        boolean z2;
        String str;
        Long myDiamond;
        EnvelopeData envelopeData = this.mEnvelopeData;
        if (envelopeData != null && (myDiamond = envelopeData.getMyDiamond()) != null) {
            j = myDiamond.longValue();
        } else {
            j = 0;
        }
        boolean z3 = true;
        if (j == 0) {
            z = true;
        } else {
            z = false;
        }
        this.isOpen = z;
        EnvelopeData envelopeData2 = this.mEnvelopeData;
        if (envelopeData2 != null) {
            z2 = Intrinsics.areEqual(envelopeData2.isWorld(), Boolean.FALSE);
        } else {
            z2 = false;
        }
        this.isRoom = z2;
        EnvelopeData envelopeData3 = this.mEnvelopeData;
        if (envelopeData3 == null || !envelopeData3.canGetWorld()) {
            z3 = false;
        }
        this.canGet = z3;
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogOpenEnvelopeBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        final ImageView imageView = ((DialogOpenEnvelopeBinding) getBinding()).close;
        final long j2 = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j2 || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final SVGAImageView sVGAImageView = ((DialogOpenEnvelopeBinding) getBinding()).openSvga;
        sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j2 || (sVGAImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                    SVGAImageView sVGAImageView2 = sVGAImageView;
                    if (this.getCanGet()) {
                        this.openEnvelope();
                        return;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getContext(), ResourcesKtxKt.getStringById(this, 2131954511), false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                }
            }
        });
        final TextView textView = ((DialogOpenEnvelopeBinding) getBinding()).envelopeDetail;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long j3;
                Long luckyBagId;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j2 || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    RedEnvelopeDetailActivity.Companion companion = RedEnvelopeDetailActivity.INSTANCE;
                    Context context = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    EnvelopeData mEnvelopeData = this.getMEnvelopeData();
                    if (mEnvelopeData != null && (luckyBagId = mEnvelopeData.getLuckyBagId()) != null) {
                        j3 = luckyBagId.longValue();
                    } else {
                        j3 = 0;
                    }
                    companion.start(context, j3);
                }
            }
        });
        final TextView textView2 = ((DialogOpenEnvelopeBinding) getBinding()).okBtn;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j2 || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ImageView imageView2 = ((DialogOpenEnvelopeBinding) getBinding()).bg;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j2 || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogOpenEnvelopeBinding) getBinding()).avatar;
        qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j2 || (qMUIRadiusImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView2;
                }
            }
        });
        final ConstraintLayout constraintLayout = ((DialogOpenEnvelopeBinding) getBinding()).constraint;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j2 || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.dismiss();
                }
            }
        });
        refreshView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openEnvelope() {
        long j;
        Long luckyBagId;
        ServerApi apis = AppServer.INSTANCE.getApis();
        EnvelopeData envelopeData = this.mEnvelopeData;
        if (envelopeData != null && (luckyBagId = envelopeData.getLuckyBagId()) != null) {
            j = luckyBagId.longValue();
        } else {
            j = 0;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.openEnvelope(j), new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.b
            public final Object invoke(Object obj) {
                Unit openEnvelope$lambda$10;
                openEnvelope$lambda$10 = OpenEnvelopeDialog.openEnvelope$lambda$10(OpenEnvelopeDialog.this, (ApiResponse) obj);
                return openEnvelope$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.c
            public final Object invoke(Object obj) {
                Unit openEnvelope$lambda$11;
                openEnvelope$lambda$11 = OpenEnvelopeDialog.openEnvelope$lambda$11(OpenEnvelopeDialog.this, (Throwable) obj);
                return openEnvelope$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openEnvelope$lambda$10(OpenEnvelopeDialog openEnvelopeDialog, ApiResponse apiResponse) {
        double d;
        long j;
        Long balance;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        EnvelopeData envelopeData = (EnvelopeData) apiResponse.getData();
        if (envelopeData != null && (balance = envelopeData.getBalance()) != null) {
            d = balance.longValue();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        EnvelopeData envelopeData2 = openEnvelopeDialog.mEnvelopeData;
        if (envelopeData2 != null) {
            EnvelopeData envelopeData3 = (EnvelopeData) apiResponse.getData();
            if (envelopeData3 == null || (j = envelopeData3.getDiamond()) == null) {
                j = 0L;
            }
            envelopeData2.setMyDiamond(j);
        }
        openEnvelopeDialog.playSVGA();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit openEnvelope$lambda$11(OpenEnvelopeDialog openEnvelopeDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = openEnvelopeDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(openEnvelopeDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SVGAParser parser_delegate$lambda$0() {
        return SVGAParser.Companion.shareParser();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playOpenSVGA() {
        String str = "svga/envelope_open.svga";
        if (!this.isRoom && !this.canGet) {
            str = "svga/envelope_count_down.svga";
        }
        getParser().decodeFromAssets(str, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$playOpenSVGA$1
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).openSvga.stopAnimation(true);
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).openSvga.setLoops(-1);
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).openSvga.setImageDrawable(new SVGADrawable(videoItem));
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).openSvga.startAnimation();
            }

            public void onError() {
            }
        });
    }

    private final void playSVGA() {
        ((DialogOpenEnvelopeBinding) getBinding()).flipSvga.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$playSVGA$1
            public void onFinished() {
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).flipSvga.setVisibility(8);
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        });
        getParser().decodeFromAssets("svga/envelope_flip.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$playSVGA$2
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).flipSvga.setVisibility(0);
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).flipSvga.stopAnimation(true);
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).flipSvga.setLoops(1);
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).flipSvga.setImageDrawable(new SVGADrawable(videoItem));
                OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).flipSvga.startAnimation((SVGARange) null, true);
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                ConstraintLayout constraintLayout = OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).constraint;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "constraint");
                ObjectAnimator alpha = animationUtility.alpha(constraintLayout, false);
                alpha.setDuration(200L);
                alpha.start();
                ConstraintLayout constraintLayout2 = OpenEnvelopeDialog.access$getBinding(OpenEnvelopeDialog.this).constraint;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "constraint");
                ObjectAnimator alpha2 = animationUtility.alpha(constraintLayout2, true);
                final OpenEnvelopeDialog openEnvelopeDialog = OpenEnvelopeDialog.this;
                alpha2.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.OpenEnvelopeDialog$playSVGA$2$onComplete$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        OpenEnvelopeDialog.this.setOpen(false);
                        OpenEnvelopeDialog.this.refreshView();
                    }
                });
                alpha2.setDuration(150L);
                alpha2.setStartDelay(550L);
                alpha2.start();
            }

            public void onError() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshView() {
        String str;
        String str2;
        int i;
        long j;
        if (this.isOpen) {
            ((DialogOpenEnvelopeBinding) getBinding()).openName.setTextColor(Color.parseColor("#ffffff"));
            ((DialogOpenEnvelopeBinding) getBinding()).openSubTitle.setTextColor(Color.parseColor("#ffffff"));
            ((DialogOpenEnvelopeBinding) getBinding()).openDiamond.setTextColor(Color.parseColor("#FFF984"));
            ((DialogOpenEnvelopeBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.dialog_envelope_open_bg));
            EnvelopeData envelopeData = this.mEnvelopeData;
            if (envelopeData != null) {
                QMUIRadiusImageView qMUIRadiusImageView = ((DialogOpenEnvelopeBinding) getBinding()).avatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, envelopeData.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
                ((DialogOpenEnvelopeBinding) getBinding()).openName.setText(envelopeData.getNick());
                TextView textView = ((DialogOpenEnvelopeBinding) getBinding()).openDiamond;
                Long diamond = envelopeData.getDiamond();
                if (diamond != null) {
                    j = diamond.longValue();
                } else {
                    j = 0;
                }
                textView.setText(NumberUtilsKt.rankNumberFormat(j));
            }
            TextView textView2 = ((DialogOpenEnvelopeBinding) getBinding()).time;
            if (this.isRoom) {
                i = 8;
            } else {
                i = 0;
            }
            textView2.setVisibility(i);
            ((DialogOpenEnvelopeBinding) getBinding()).openSubTitle.setText(ResourcesKtxKt.getStringById(this, 2131954040));
            ((DialogOpenEnvelopeBinding) getBinding()).openSvga.setVisibility(0);
            ((DialogOpenEnvelopeBinding) getBinding()).envelopeDetail.setVisibility(8);
            ((DialogOpenEnvelopeBinding) getBinding()).okBtn.setVisibility(8);
            playOpenSVGA();
            countDown();
            return;
        }
        ((DialogOpenEnvelopeBinding) getBinding()).openName.setTextColor(Color.parseColor("#333333"));
        ((DialogOpenEnvelopeBinding) getBinding()).openSubTitle.setTextColor(Color.parseColor("#EF003E"));
        ((DialogOpenEnvelopeBinding) getBinding()).openDiamond.setTextColor(Color.parseColor("#EF003E"));
        ((DialogOpenEnvelopeBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.dialog_envelope_end_bg));
        QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogOpenEnvelopeBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatar");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Long l = null;
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView3 = ((DialogOpenEnvelopeBinding) getBinding()).openName;
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getNick();
        } else {
            str2 = null;
        }
        textView3.setText(str2);
        TextView textView4 = ((DialogOpenEnvelopeBinding) getBinding()).openDiamond;
        EnvelopeData envelopeData2 = this.mEnvelopeData;
        if (envelopeData2 != null) {
            l = envelopeData2.getMyDiamond();
        }
        textView4.setText(String.valueOf(l));
        ((DialogOpenEnvelopeBinding) getBinding()).close.setVisibility(8);
        ((DialogOpenEnvelopeBinding) getBinding()).openSubTitle.setText(ResourcesKtxKt.getStringById(this, 2131954539));
        ((DialogOpenEnvelopeBinding) getBinding()).openSvga.setVisibility(8);
        ((DialogOpenEnvelopeBinding) getBinding()).envelopeDetail.setVisibility(0);
        ((DialogOpenEnvelopeBinding) getBinding()).okBtn.setVisibility(0);
        ((DialogOpenEnvelopeBinding) getBinding()).time.setVisibility(8);
        ((DialogOpenEnvelopeBinding) getBinding()).openSvga.stopAnimation();
    }

    public void dismiss() {
        super.dismiss();
        ((DialogOpenEnvelopeBinding) getBinding()).flipSvga.clear();
        ((DialogOpenEnvelopeBinding) getBinding()).openSvga.clear();
        ((DialogOpenEnvelopeBinding) getBinding()).lightSvga.clear();
        this.mCompositeDisposable.d();
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
    }

    public final boolean getCanGet() {
        return this.canGet;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_open_envelope;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final EnvelopeData getMEnvelopeData() {
        return this.mEnvelopeData;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* renamed from: isOpen, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    /* renamed from: isRoom, reason: from getter */
    public final boolean getIsRoom() {
        return this.isRoom;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.redEnvelope.d
            @Override // java.lang.Runnable
            public final void run() {
                OpenEnvelopeDialog.this.initView();
            }
        }, 200L);
    }

    public final void setCanGet(boolean z) {
        this.canGet = z;
    }

    public final void setOpen(boolean z) {
        this.isOpen = z;
    }

    public final void setRoom(boolean z) {
        this.isRoom = z;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public /* synthetic */ OpenEnvelopeDialog(Context context, EnvelopeData envelopeData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : envelopeData);
    }
}

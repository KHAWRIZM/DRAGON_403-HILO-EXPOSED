package com.qiahao.nextvideo.sheep;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.webkit.WebSettings;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import cf.m;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.permission.PermissionInterceptor;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.data.sheep.SheepMatchData;
import com.qiahao.nextvideo.databinding.ActivityGameMatchBinding;
import com.qiahao.nextvideo.room.game.SheepEndDialog;
import com.qiahao.nextvideo.room.help.GameJum;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.home.game.MatchGameActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020\u0016H\u0016J\u0006\u0010%\u001a\u00020\u0016J\b\u0010&\u001a\u00020\u0016H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/sheep/GameMatchActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGameMatchBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/sheep/GameMatchViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/sheep/GameMatchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isJoinChannel", "", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "showExitDialog", "initTimerTask", "timeCount", "", "onSheepEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "joinChannel", "startAnimations", "endAnimations", "checkAudioPermission", "onBackPressed", "exitGame", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameMatchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameMatchActivity.kt\ncom/qiahao/nextvideo/sheep/GameMatchActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,451:1\n61#2,9:452\n*S KotlinDebug\n*F\n+ 1 GameMatchActivity.kt\ncom/qiahao/nextvideo/sheep/GameMatchActivity\n*L\n125#1:452,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameMatchActivity extends HiloBaseBindingActivity<ActivityGameMatchBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GAME_ID = "gameId";

    @NotNull
    public static final String MATH_ID = "mathId";

    @NotNull
    public static final String ROOM_ID = "room_id";
    private boolean isJoinChannel;

    @Nullable
    private CountDownTimer timerTask;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.sheep.b
        public final Object invoke() {
            GameMatchViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = GameMatchActivity.viewModel_delegate$lambda$0(GameMatchActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/sheep/GameMatchActivity$Companion;", "", "<init>", "()V", "MATH_ID", "", MatchGameActivity.GAME_ID, "ROOM_ID", "startActivity", "", "context", "Landroid/content/Context;", GameMatchActivity.MATH_ID, "", GameMatchActivity.GAME_ID, TUIConstants.TUILive.ROOM_ID, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                str = "";
            }
            companion.startActivity(context, i, i2, str);
        }

        public final void startActivity(@NotNull Context context, int mathId, int gameId, @NotNull String roomId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(roomId, TUIConstants.TUILive.ROOM_ID);
            Intent intent = new Intent(context, (Class<?>) GameMatchActivity.class);
            intent.putExtra(GameMatchActivity.MATH_ID, mathId);
            intent.putExtra(GameMatchActivity.GAME_ID, gameId);
            intent.putExtra(GameMatchActivity.ROOM_ID, roomId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean checkAudioPermission() {
        boolean m = w9.h.m(this, fa.b.o());
        if (!m) {
            w9.h.t(this).p(fa.b.o()).j(new PermissionInterceptor()).r(new w9.c() { // from class: com.qiahao.nextvideo.sheep.a
                public final void onResult(List list, List list2) {
                    GameMatchActivity.checkAudioPermission$lambda$22(GameMatchActivity.this, list, list2);
                }
            });
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAudioPermission$lambda$22(GameMatchActivity gameMatchActivity, List list, List list2) {
        UserProxy1.SheepMatchSuccess mMatchSuccess;
        Intrinsics.checkNotNullParameter(list, "grantedList");
        Intrinsics.checkNotNullParameter(list2, "deniedList");
        if (list2.isEmpty() && (mMatchSuccess = gameMatchActivity.getViewModel().getMMatchSuccess()) != null) {
            HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
            String token = mMatchSuccess.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            String channelId = mMatchSuccess.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            hiloRtcEngine.joinChannel(token, channelId, mMatchSuccess.getAgoraId(), mMatchSuccess.getProvider());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void endAnimations() {
        int i;
        ActivityGameMatchBinding activityGameMatchBinding = (ActivityGameMatchBinding) getBinding();
        activityGameMatchBinding.webView.setVisibility(0);
        ((ActivityGameMatchBinding) getBinding()).btnFight.stopLoop();
        ConstraintLayout constraintLayout = activityGameMatchBinding.blueViews;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        boolean rightToLeftDirection = hiloUtils.getRightToLeftDirection();
        int i2 = R.anim.anim_game_sheep_end;
        if (rightToLeftDirection) {
            i = R.anim.anim_game_sheep_end_rtl;
        } else {
            i = R.anim.anim_game_sheep_end;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, i);
        loadAnimation.setDuration(500L);
        loadAnimation.setFillAfter(true);
        constraintLayout.startAnimation(loadAnimation);
        ConstraintLayout constraintLayout2 = activityGameMatchBinding.redViews;
        if (!hiloUtils.getRightToLeftDirection()) {
            i2 = R.anim.anim_game_sheep_end_rtl;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, i2);
        loadAnimation2.setDuration(500L);
        loadAnimation2.setFillAfter(true);
        constraintLayout2.startAnimation(loadAnimation2);
        ImageView imageView = activityGameMatchBinding.iconVs;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_other_end);
        loadAnimation3.setDuration(150L);
        loadAnimation3.setFillAfter(true);
        loadAnimation3.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(loadAnimation3);
        AppCompatTextView appCompatTextView = activityGameMatchBinding.btnFight;
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_other_end);
        loadAnimation4.setDuration(150L);
        loadAnimation4.setFillAfter(true);
        loadAnimation4.setInterpolator(new LinearInterpolator());
        appCompatTextView.startAnimation(loadAnimation4);
        activityGameMatchBinding.webView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_game_web_start));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameMatchViewModel getViewModel() {
        return (GameMatchViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMatchData().observe(this, new GameMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.sheep.e
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = GameMatchActivity.initData$lambda$2(GameMatchActivity.this, (SheepMatchData) obj);
                return initData$lambda$2;
            }
        }));
        getViewModel().getExitSuccess().observe(this, new GameMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.sheep.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = GameMatchActivity.initData$lambda$3(GameMatchActivity.this, (Boolean) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getError().observe(this, new GameMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.sheep.g
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = GameMatchActivity.initData$lambda$4(GameMatchActivity.this, (Throwable) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().joinMatch(getViewModel().getMMathId(), 0, getViewModel().getMGameId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(GameMatchActivity gameMatchActivity, SheepMatchData sheepMatchData) {
        String str;
        String str2;
        if (sheepMatchData != null) {
            QMUIRadiusImageView qMUIRadiusImageView = gameMatchActivity.getBinding().avatarBlue;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarBlue");
            User user = sheepMatchData.getUser();
            if (user != null) {
                str = user.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
            TextView textView = gameMatchActivity.getBinding().nameBlue;
            User user2 = sheepMatchData.getUser();
            if (user2 == null || (str2 = user2.getNick()) == null) {
                str2 = "";
            }
            textView.setText(str2);
            gameMatchActivity.initTimerTask(sheepMatchData.getRemainSecond());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(GameMatchActivity gameMatchActivity, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            gameMatchActivity.exitGame();
            gameMatchActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$4(GameMatchActivity gameMatchActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(gameMatchActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, gameMatchActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            gameMatchActivity.exitGame();
            gameMatchActivity.finish();
        }
        return Unit.INSTANCE;
    }

    private final void initTimerTask(long timeCount) {
        if (timeCount < 1) {
            return;
        }
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final long j = timeCount * 1000;
        CountDownTimer countDownTimer2 = new CountDownTimer(j) { // from class: com.qiahao.nextvideo.sheep.GameMatchActivity$initTimerTask$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, GameMatchActivity.this, ResourcesKtxKt.getStringById(this, 2131954080), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                GameMatchActivity.this.exitGame();
                GameMatchActivity.this.finish();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                String valueOf;
                ActivityGameMatchBinding binding;
                if (millisUntilFinished < 1000) {
                    valueOf = MessageService.MSG_DB_READY_REPORT;
                } else {
                    valueOf = String.valueOf((int) (millisUntilFinished / 1000));
                }
                binding = GameMatchActivity.this.getBinding();
                TextView textView = binding.nameRed;
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131952390), Arrays.copyOf(new Object[]{valueOf}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
        };
        this.timerTask = countDownTimer2;
        countDownTimer2.start();
    }

    private final void initView() {
        getBinding().btnFight.setText(ResourcesKtxKt.getStringById(this, 2131952851));
        WebSettings settings = getBinding().webView.getSettings();
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setMixedContentMode(2);
        settings.setBlockNetworkImage(false);
        settings.setDatabaseEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        startAnimations();
        final ImageView imageView = getBinding().back;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.sheep.GameMatchActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.showExitDialog();
                }
            }
        });
    }

    private final void joinChannel() {
        UserProxy1.SheepMatchSuccess mMatchSuccess;
        this.isJoinChannel = true;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        MeetingRoomManager.leaveRoom$default(meetingRoomManager, false, 1, null);
        cf.c.c().l(new LiveEvent("EXIT_ROOM", DataExternalKt.createExitRoom(meetingRoomManager.getMGroupId(), 0)));
        meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().closeRoomFloatView());
        if (checkAudioPermission() && (mMatchSuccess = getViewModel().getMMatchSuccess()) != null) {
            HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
            String token = mMatchSuccess.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            String channelId = mMatchSuccess.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "getChannelId(...)");
            hiloRtcEngine.joinChannel(token, channelId, mMatchSuccess.getAgoraId(), mMatchSuccess.getProvider());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSheepEvent$lambda$7(GameMatchActivity gameMatchActivity) {
        CountDownTimer countDownTimer = gameMatchActivity.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        gameMatchActivity.endAnimations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onSheepEvent$lambda$9$lambda$8(GameMatchActivity gameMatchActivity, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        int hashCode = str.hashCode();
        if (hashCode != -2061950503) {
            if (hashCode != 1195475146) {
                if (hashCode == 1405947938 && str.equals(SheepEndDialog.ONCE_AGAIN)) {
                    gameMatchActivity.getViewModel().setMGameStatus(0);
                    HiloRtcEngine.INSTANCE.leaveChannel();
                    gameMatchActivity.getViewModel().joinMatch(0, gameMatchActivity.getViewModel().getMMathId(), gameMatchActivity.getViewModel().getMGameId());
                    gameMatchActivity.startAnimations();
                }
            } else if (str.equals(SheepEndDialog.BACK_PRESSED)) {
                gameMatchActivity.showExitDialog();
            }
        } else if (str.equals(SheepEndDialog.CLOSE_GAME)) {
            gameMatchActivity.exitGame();
            gameMatchActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showExitDialog() {
        new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952644)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.sheep.GameMatchActivity$showExitDialog$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                GameMatchViewModel viewModel;
                GameMatchViewModel viewModel2;
                GameMatchViewModel viewModel3;
                viewModel = GameMatchActivity.this.getViewModel();
                viewModel2 = GameMatchActivity.this.getViewModel();
                int mMathId = viewModel2.getMMathId();
                viewModel3 = GameMatchActivity.this.getViewModel();
                viewModel.exitMatchGame(mMathId, viewModel3.getMGameId());
                GameMatchActivity.this.exitGame();
                GameMatchActivity.this.finish();
            }
        }).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startAnimations() {
        int i;
        ((ActivityGameMatchBinding) getBinding()).svga.setVisibility(0);
        ActivityGameMatchBinding activityGameMatchBinding = (ActivityGameMatchBinding) getBinding();
        activityGameMatchBinding.webView.setVisibility(8);
        ((ActivityGameMatchBinding) getBinding()).btnFight.startLoop();
        ConstraintLayout constraintLayout = activityGameMatchBinding.blueViews;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        boolean rightToLeftDirection = hiloUtils.getRightToLeftDirection();
        int i2 = R.anim.anim_game_sheep_start;
        if (rightToLeftDirection) {
            i = R.anim.anim_game_sheep_start_rtl;
        } else {
            i = R.anim.anim_game_sheep_start;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, i);
        loadAnimation.setDuration(500L);
        loadAnimation.setFillAfter(true);
        constraintLayout.startAnimation(loadAnimation);
        ConstraintLayout constraintLayout2 = activityGameMatchBinding.redViews;
        if (!hiloUtils.getRightToLeftDirection()) {
            i2 = R.anim.anim_game_sheep_start_rtl;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, i2);
        loadAnimation2.setDuration(500L);
        loadAnimation2.setFillAfter(true);
        constraintLayout2.startAnimation(loadAnimation2);
        ImageView imageView = activityGameMatchBinding.iconVs;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_match_vs);
        loadAnimation3.setFillAfter(true);
        loadAnimation3.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(loadAnimation3);
        AppCompatTextView appCompatTextView = activityGameMatchBinding.btnFight;
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_match_fight);
        loadAnimation4.setDuration(200L);
        loadAnimation4.setStartOffset(450L);
        loadAnimation4.setFillAfter(true);
        appCompatTextView.startAnimation(loadAnimation4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameMatchViewModel viewModel_delegate$lambda$0(GameMatchActivity gameMatchActivity) {
        return new ViewModelProvider(gameMatchActivity).get(GameMatchViewModel.class);
    }

    public final void exitGame() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        if (this.isJoinChannel) {
            HiloRtcEngine.INSTANCE.leaveChannel();
        }
        getBinding().webView.destroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_game_match;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onBackPressed() {
        try {
            if (!isFinishing() && !isDestroyed()) {
                showExitDialog();
            } else {
                super.onBackPressed();
            }
        } catch (Exception unused) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        exitGame();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        getViewModel().setMMathId(getIntent().getIntExtra(MATH_ID, 0));
        getViewModel().setMGameId(getIntent().getIntExtra(GAME_ID, 0));
        GameMatchViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra(ROOM_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        viewModel.setMRoomId(stringExtra);
        initView();
        initData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m(threadMode = ThreadMode.MAIN)
    public final void onSheepEvent(@NotNull EventBusKey event) {
        String str;
        String str2;
        String nick;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        switch (type.hashCode()) {
            case -2011896460:
                if (type.equals("H5_GAME_MUTE") && this.isJoinChannel) {
                    HiloRtcEngine.INSTANCE.leaveChannel();
                    return;
                }
                return;
            case -1818651964:
                if (type.equals("H5_GAME_UN_MUTE")) {
                    joinChannel();
                    return;
                }
                return;
            case -1689495676:
                if (type.equals("H5_JOIN_CHANNEL_SUCCESS") && this.isJoinChannel) {
                    HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
                    hiloRtcEngine.setClientRole(1);
                    hiloRtcEngine.muteAllRemoteAudioStreams(false);
                    return;
                }
                return;
            case -1203996164:
                if (!type.equals("game_match_success") || getViewModel().getMGameStatus() == 2) {
                    return;
                }
                CountDownTimer countDownTimer = this.timerTask;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                getViewModel().setMGameStatus(2);
                ((ActivityGameMatchBinding) getBinding()).svga.setVisibility(8);
                if (event.getData() instanceof UserProxy1.SheepMatchSuccess) {
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy1.SheepMatchSuccess");
                    UserProxy1.SheepMatchSuccess sheepMatchSuccess = (UserProxy1.SheepMatchSuccess) data;
                    getViewModel().setMMatchSuccess(sheepMatchSuccess);
                    getViewModel().setMMathId((int) sheepMatchSuccess.getMatchId());
                    String gameUrl = GameJum.INSTANCE.getGameUrl(getViewModel().getMGameId());
                    if (TextUtils.isEmpty(gameUrl)) {
                        return;
                    }
                    NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                    String addLanguage = navigationHelper.addLanguage(navigationHelper.addParams(gameUrl, new Pair[]{new Pair("match_id", String.valueOf(sheepMatchSuccess.getMatchId()))}));
                    if (!TextUtils.isEmpty(getViewModel().getMRoomId())) {
                        addLanguage = navigationHelper.addParams(addLanguage, new Pair[]{new Pair("current_room_id", getViewModel().getMRoomId())});
                    }
                    ((ActivityGameMatchBinding) getBinding()).webView.loadWebViewUrl(addLanguage);
                    QMUIRadiusImageView qMUIRadiusImageView = ((ActivityGameMatchBinding) getBinding()).avatarBlue;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarBlue");
                    UserProxy.User user = sheepMatchSuccess.getUser();
                    String str3 = null;
                    if (user != null) {
                        str = user.getAvatar();
                    } else {
                        str = null;
                    }
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                    TextView textView = ((ActivityGameMatchBinding) getBinding()).nameBlue;
                    UserProxy.User user2 = sheepMatchSuccess.getUser();
                    String str4 = "";
                    if (user2 == null || (str2 = user2.getNick()) == null) {
                        str2 = "";
                    }
                    textView.setText(str2);
                    QMUIRadiusImageView qMUIRadiusImageView2 = ((ActivityGameMatchBinding) getBinding()).avatarRed;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatarRed");
                    UserProxy.User otherUser = sheepMatchSuccess.getOtherUser();
                    if (otherUser != null) {
                        str3 = otherUser.getAvatar();
                    }
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                    TextView textView2 = ((ActivityGameMatchBinding) getBinding()).nameRed;
                    UserProxy.User otherUser2 = sheepMatchSuccess.getOtherUser();
                    if (otherUser2 != null && (nick = otherUser2.getNick()) != null) {
                        str4 = nick;
                    }
                    textView2.setText(str4);
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.sheep.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameMatchActivity.onSheepEvent$lambda$7(GameMatchActivity.this);
                        }
                    }, 2000L);
                    return;
                }
                return;
            case -24148726:
                if (type.equals("game_result") && (event.getData() instanceof UserProxy1.SheepGameResult)) {
                    Object data2 = event.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type userProxy.UserProxy1.SheepGameResult");
                    UserProxy1.SheepGameResult sheepGameResult = (UserProxy1.SheepGameResult) data2;
                    if (((int) sheepGameResult.getMatchId()) == getViewModel().getMMathId()) {
                        getViewModel().setMGameStatus(3);
                        SheepEndDialog sheepEndDialog = new SheepEndDialog(this, sheepGameResult);
                        sheepEndDialog.setListener(new Function1() { // from class: com.qiahao.nextvideo.sheep.d
                            public final Object invoke(Object obj) {
                                Unit onSheepEvent$lambda$9$lambda$8;
                                onSheepEvent$lambda$9$lambda$8 = GameMatchActivity.onSheepEvent$lambda$9$lambda$8(GameMatchActivity.this, (String) obj);
                                return onSheepEvent$lambda$9$lambda$8;
                            }
                        });
                        sheepEndDialog.show();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }
}

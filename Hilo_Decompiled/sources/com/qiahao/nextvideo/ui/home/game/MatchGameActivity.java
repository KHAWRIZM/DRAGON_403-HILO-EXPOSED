package com.qiahao.nextvideo.ui.home.game;

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
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.GameLobbyMatch;
import com.qiahao.nextvideo.databinding.ActivityGameMatchLobbyBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u0006H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0007J\b\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0014J\u0006\u0010-\u001a\u00020\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/game/MatchGameActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGameMatchLobbyBinding;", "<init>", "()V", GameMatchActivity.GAME_ID, "", "getGameId", "()I", "setGameId", "(I)V", "gameType", "getGameType", "setGameType", Constants.KEY_MODEL, "getModel", "setModel", "viewModel", "Lcom/qiahao/nextvideo/ui/home/game/GameLobbyViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/game/GameLobbyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "onInitialize", "", "initView", "initData", "showExitDialog", "initTimerTask", "timeCount", "", "onSheepEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "startAnimations", "endAnimations", "onBackPressed", "onDestroy", "exitGame", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatchGameActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchGameActivity.kt\ncom/qiahao/nextvideo/ui/home/game/MatchGameActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,337:1\n61#2,9:338\n*S KotlinDebug\n*F\n+ 1 MatchGameActivity.kt\ncom/qiahao/nextvideo/ui/home/game/MatchGameActivity\n*L\n86#1:338,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchGameActivity extends HiloBaseBindingActivity<ActivityGameMatchLobbyBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String GAME_ID = "GAME_ID";

    @NotNull
    public static final String GAME_TYPE = "GAME_TYPE";

    @NotNull
    public static final String MODE = "MODE";
    private int gameId;
    private int gameType;
    private int model;

    @Nullable
    private CountDownTimer timerTask;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.game.f0
        public final Object invoke() {
            GameLobbyViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = MatchGameActivity.viewModel_delegate$lambda$0(MatchGameActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/game/MatchGameActivity$Companion;", "", "<init>", "()V", MatchGameActivity.GAME_ID, "", MatchGameActivity.GAME_TYPE, MatchGameActivity.MODE, "startActivity", "", "context", "Landroid/content/Context;", GameMatchActivity.GAME_ID, "", "gameType", Constants.KEY_MODE, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, int gameId, int gameType, int mode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) MatchGameActivity.class);
            intent.putExtra(MatchGameActivity.GAME_ID, gameId);
            intent.putExtra(MatchGameActivity.GAME_TYPE, gameType);
            intent.putExtra(MatchGameActivity.MODE, mode);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void endAnimations() {
        int i;
        ActivityGameMatchLobbyBinding activityGameMatchLobbyBinding = (ActivityGameMatchLobbyBinding) getBinding();
        ((ActivityGameMatchLobbyBinding) getBinding()).btnFight.stopLoop();
        ConstraintLayout constraintLayout = activityGameMatchLobbyBinding.blueViews;
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
        ConstraintLayout constraintLayout2 = activityGameMatchLobbyBinding.redViews;
        if (!hiloUtils.getRightToLeftDirection()) {
            i2 = R.anim.anim_game_sheep_end_rtl;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, i2);
        loadAnimation2.setDuration(500L);
        loadAnimation2.setFillAfter(true);
        constraintLayout2.startAnimation(loadAnimation2);
        ImageView imageView = activityGameMatchLobbyBinding.iconVs;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_other_end);
        loadAnimation3.setDuration(150L);
        loadAnimation3.setFillAfter(true);
        loadAnimation3.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(loadAnimation3);
        AppCompatTextView appCompatTextView = activityGameMatchLobbyBinding.btnFight;
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_other_end);
        loadAnimation4.setDuration(150L);
        loadAnimation4.setFillAfter(true);
        loadAnimation4.setInterpolator(new LinearInterpolator());
        appCompatTextView.startAnimation(loadAnimation4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameLobbyViewModel getViewModel() {
        return (GameLobbyViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMatchData().observe(this, new MatchGameActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.c0
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = MatchGameActivity.initData$lambda$3(MatchGameActivity.this, (GameLobbyMatch) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getExitSuccess().observe(this, new MatchGameActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.d0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = MatchGameActivity.initData$lambda$4(MatchGameActivity.this, (Boolean) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getError().observe(this, new MatchGameActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.game.e0
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = MatchGameActivity.initData$lambda$5(MatchGameActivity.this, (Throwable) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().joinMatch(this.gameId, this.model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(final MatchGameActivity matchGameActivity, final GameLobbyMatch gameLobbyMatch) {
        long j;
        if (gameLobbyMatch != null) {
            if (!TextUtils.isEmpty(gameLobbyMatch.getLastGroupId())) {
                new TipDialog(matchGameActivity).setTipContent(ResourcesKtxKt.getStringById(matchGameActivity, 2131953243)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.game.MatchGameActivity$initData$1$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                        matchGameActivity.exitGame();
                    }

                    public void confirm() {
                        String str;
                        int i;
                        int i2;
                        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                        String lastGroupId = GameLobbyMatch.this.getLastGroupId();
                        if (lastGroupId == null) {
                            lastGroupId = "";
                        }
                        String lastGameCode = GameLobbyMatch.this.getLastGameCode();
                        if (lastGameCode == null) {
                            str = "";
                        } else {
                            str = lastGameCode;
                        }
                        Integer lastGameType = GameLobbyMatch.this.getLastGameType();
                        if (lastGameType != null) {
                            i = lastGameType.intValue();
                        } else {
                            i = 0;
                        }
                        Integer lastMode = GameLobbyMatch.this.getLastMode();
                        if (lastMode != null) {
                            i2 = lastMode.intValue();
                        } else {
                            i2 = 0;
                        }
                        StartRoomUtils.start$default(startRoomUtils, lastGroupId, false, 0, null, null, null, null, 0, 0, i, str, null, false, 0, true, i2, 14846, null);
                        matchGameActivity.exitGame();
                    }
                }).show();
            } else {
                Long remainSecond = gameLobbyMatch.getRemainSecond();
                if (remainSecond != null) {
                    j = remainSecond.longValue();
                } else {
                    j = 0;
                }
                matchGameActivity.initTimerTask(j);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(MatchGameActivity matchGameActivity, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            matchGameActivity.exitGame();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$5(final MatchGameActivity matchGameActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 4000) {
                RoomTipDialog roomTipDialog = new RoomTipDialog(matchGameActivity);
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = "";
                }
                roomTipDialog.setTipContent(errorMessage).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.game.MatchGameActivity$initData$3$1
                    public void cancel() {
                        MatchGameActivity.this.exitGame();
                    }

                    public void confirm() {
                        WalletActivity.INSTANCE.start(MatchGameActivity.this);
                        MatchGameActivity.this.exitGame();
                    }
                }).show();
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                String errorMessage2 = hiloException.getErrorMessage();
                if (errorMessage2 == null) {
                    errorMessage2 = ResourcesKtxKt.getStringById(matchGameActivity, 2131952667);
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, matchGameActivity, errorMessage2, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                matchGameActivity.exitGame();
            }
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
        CountDownTimer countDownTimer2 = new CountDownTimer(j) { // from class: com.qiahao.nextvideo.ui.home.game.MatchGameActivity$initTimerTask$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                GameLobbyViewModel viewModel;
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, MatchGameActivity.this, ResourcesKtxKt.getStringById(this, 2131954080), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                viewModel = MatchGameActivity.this.getViewModel();
                viewModel.exitMatchGame();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                String valueOf;
                ActivityGameMatchLobbyBinding binding;
                if (millisUntilFinished < 1000) {
                    valueOf = MessageService.MSG_DB_READY_REPORT;
                } else {
                    valueOf = String.valueOf((int) (millisUntilFinished / 1000));
                }
                binding = MatchGameActivity.this.getBinding();
                TextView textView = binding.nameRed;
                String format = String.format(ResourcesKtxKt.getStringById(this, 2131952390), Arrays.copyOf(new Object[]{valueOf}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
        };
        this.timerTask = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        String str2;
        this.gameId = getIntent().getIntExtra(GAME_ID, 0);
        this.gameType = getIntent().getIntExtra(GAME_TYPE, 0);
        this.model = getIntent().getIntExtra(MODE, 0);
        ((ActivityGameMatchLobbyBinding) getBinding()).btnFight.setText(ResourcesKtxKt.getStringById(this, 2131952851));
        QMUIRadiusImageView qMUIRadiusImageView = ((ActivityGameMatchLobbyBinding) getBinding()).avatarBlue;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarBlue");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            str = user.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        TextView textView = ((ActivityGameMatchLobbyBinding) getBinding()).nameBlue;
        User user2 = companion.getShared().getUser();
        if (user2 == null || (str2 = user2.getNick()) == null) {
            str2 = "";
        }
        textView.setText(str2);
        startAnimations();
        final ImageView imageView = ((ActivityGameMatchLobbyBinding) getBinding()).back;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.game.MatchGameActivity$initView$$inlined$singleClick$default$1
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showExitDialog() {
        new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131952644)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.game.MatchGameActivity$showExitDialog$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                GameLobbyViewModel viewModel;
                viewModel = MatchGameActivity.this.getViewModel();
                viewModel.exitMatchGame();
            }
        }).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startAnimations() {
        int i;
        ((ActivityGameMatchLobbyBinding) getBinding()).svga.setVisibility(0);
        ActivityGameMatchLobbyBinding activityGameMatchLobbyBinding = (ActivityGameMatchLobbyBinding) getBinding();
        ((ActivityGameMatchLobbyBinding) getBinding()).btnFight.startLoop();
        ConstraintLayout constraintLayout = activityGameMatchLobbyBinding.blueViews;
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
        ConstraintLayout constraintLayout2 = activityGameMatchLobbyBinding.redViews;
        if (!hiloUtils.getRightToLeftDirection()) {
            i2 = R.anim.anim_game_sheep_start_rtl;
        }
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, i2);
        loadAnimation2.setDuration(500L);
        loadAnimation2.setFillAfter(true);
        constraintLayout2.startAnimation(loadAnimation2);
        ImageView imageView = activityGameMatchLobbyBinding.iconVs;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_match_vs);
        loadAnimation3.setFillAfter(true);
        loadAnimation3.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(loadAnimation3);
        AppCompatTextView appCompatTextView = activityGameMatchLobbyBinding.btnFight;
        Animation loadAnimation4 = AnimationUtils.loadAnimation(this, R.anim.anim_game_sheep_match_fight);
        loadAnimation4.setDuration(200L);
        loadAnimation4.setStartOffset(450L);
        loadAnimation4.setFillAfter(true);
        appCompatTextView.startAnimation(loadAnimation4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameLobbyViewModel viewModel_delegate$lambda$0(MatchGameActivity matchGameActivity) {
        return new ViewModelProvider(matchGameActivity).get(GameLobbyViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void exitGame() {
        getViewModel().getMCompositeDisposable().d();
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        finish();
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final int getGameType() {
        return this.gameType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_game_match_lobby;
    }

    public final int getModel() {
        return this.model;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onBackPressed() {
        showExitDialog();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        exitGame();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onSheepEvent(@NotNull EventBusKey event) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!Intrinsics.areEqual(event.getType(), "lobby_match_success") || getViewModel().getMGameStatus() == 2) {
            return;
        }
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        getBinding().svga.setVisibility(8);
        getViewModel().setMGameStatus(2);
        if (event.getData() instanceof UserProxy1.LobbyMatchSuccess) {
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy1.LobbyMatchSuccess");
            UserProxy1.LobbyMatchSuccess lobbyMatchSuccess = (UserProxy1.LobbyMatchSuccess) data;
            QMUIRadiusImageView qMUIRadiusImageView = getBinding().avatarRed;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarRed");
            UserProxy.User otherUser = lobbyMatchSuccess.getOtherUser();
            if (otherUser != null) {
                str = otherUser.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
            TextView textView = getBinding().nameRed;
            UserProxy.User otherUser2 = lobbyMatchSuccess.getOtherUser();
            if (otherUser2 == null || (str2 = otherUser2.getNick()) == null) {
                str2 = "";
            }
            textView.setText(str2);
            endAnimations();
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.isRoomOpen()) {
                cf.c.c().l(new RoomEvent().closeRoom(meetingRoomManager.getMGroupId(), true));
            }
            StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
            String groupId = lobbyMatchSuccess.getGroupId();
            Intrinsics.checkNotNullExpressionValue(groupId, "getGroupId(...)");
            String gameCode = lobbyMatchSuccess.getGameCode();
            Intrinsics.checkNotNullExpressionValue(gameCode, "getGameCode(...)");
            StartRoomUtils.start$default(startRoomUtils, groupId, false, 0, null, null, null, null, 0, 0, this.gameType, gameCode, null, false, 0, true, this.model, 14846, null);
            exitGame();
        }
    }

    public final void setGameId(int i) {
        this.gameId = i;
    }

    public final void setGameType(int i) {
        this.gameType = i;
    }

    public final void setModel(int i) {
        this.model = i;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }
}

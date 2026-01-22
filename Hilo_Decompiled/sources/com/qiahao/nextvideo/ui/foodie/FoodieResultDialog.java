package com.qiahao.nextvideo.ui.foodie;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialogFragment;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.foodie.FoodieDrawResult;
import com.qiahao.nextvideo.data.foodie.FoodieGameInfo;
import com.qiahao.nextvideo.databinding.ActivityFoodieResultDialogBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieResultDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialogFragment;", "Lcom/qiahao/nextvideo/databinding/ActivityFoodieResultDialogBinding;", "viewModel", "Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "<init>", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;)V", "getViewModel", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieViewModel;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "", "getGravity", "onStart", "", "getHeight", "onInitialize", "playAnim", "fillPage", "info", "Lcom/qiahao/nextvideo/data/foodie/FoodieGameInfo;", "onDestroy", "checkStateSaved", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieResultDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieResultDialog.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieResultDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,164:1\n61#2,9:165\n61#2,9:174\n1#3:183\n1878#4,3:184\n*S KotlinDebug\n*F\n+ 1 FoodieResultDialog.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieResultDialog\n*L\n73#1:165,9\n74#1:174,9\n122#1:184,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieResultDialog extends BaseBindingDialogFragment<ActivityFoodieResultDialogBinding> {

    @Nullable
    private CountDownTimer timerTask;

    @NotNull
    private final FoodieViewModel viewModel;

    public FoodieResultDialog(@NotNull FoodieViewModel foodieViewModel) {
        Intrinsics.checkNotNullParameter(foodieViewModel, "viewModel");
        this.viewModel = foodieViewModel;
    }

    public static final /* synthetic */ ActivityFoodieResultDialogBinding access$getBinding(FoodieResultDialog foodieResultDialog) {
        return (ActivityFoodieResultDialogBinding) foodieResultDialog.getBinding();
    }

    private final boolean checkStateSaved() {
        AppCompatActivity appCompatActivity;
        AppCompatActivity context = getContext();
        FragmentManager fragmentManager = null;
        if (context instanceof AppCompatActivity) {
            appCompatActivity = context;
        } else {
            appCompatActivity = null;
        }
        if (appCompatActivity != null) {
            fragmentManager = appCompatActivity.getSupportFragmentManager();
        }
        if (fragmentManager == null || !fragmentManager.isStateSaved()) {
            return false;
        }
        return true;
    }

    private final void fillPage(FoodieGameInfo info) {
        long j;
        int i;
        Drawable drawable;
        int i2;
        long j2;
        long j3;
        ArrayList<FoodieDrawResult> arrayList;
        String str;
        long j4;
        String str2;
        String str3;
        long j5;
        String str4;
        String str5;
        long j6;
        String str6;
        Long winDiamond;
        Long betDiamond;
        Integer round;
        Drawable drawable2;
        Integer winFoodieId;
        Long winDiamond2;
        if (info != null && (winDiamond2 = info.getWinDiamond()) != null) {
            j = winDiamond2.longValue();
        } else {
            j = 0;
        }
        if (info != null && (winFoodieId = info.getWinFoodieId()) != null) {
            i = winFoodieId.intValue();
        } else {
            i = 0;
        }
        if (j > 0) {
            ImageView imageView = ((ActivityFoodieResultDialogBinding) getBinding()).ivDog;
            Context context = getContext();
            if (context != null) {
                drawable2 = androidx.core.content.a.getDrawable(context, R.drawable.ic_foodie_result_dog_happy);
            } else {
                drawable2 = null;
            }
            imageView.setImageDrawable(drawable2);
        } else {
            ImageView imageView2 = ((ActivityFoodieResultDialogBinding) getBinding()).ivDog;
            Context context2 = getContext();
            if (context2 != null) {
                drawable = androidx.core.content.a.getDrawable(context2, R.drawable.ic_foodie_result_dog_cry);
            } else {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
        }
        if (i < 100) {
            this.viewModel.playMusic(FoodieMusicType.SMALL_REWARD);
        } else {
            playAnim();
            this.viewModel.playMusic(FoodieMusicType.BIG_REWARD);
        }
        TextView textView = ((ActivityFoodieResultDialogBinding) getBinding()).tvRound;
        String stringById = ResourcesKtxKt.getStringById(this, 2131952775);
        if (info != null && (round = info.getRound()) != null) {
            i2 = round.intValue();
        } else {
            i2 = 0;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = ((ActivityFoodieResultDialogBinding) getBinding()).tvReward;
        FoodieUtil foodieUtil = FoodieUtil.INSTANCE;
        textView2.setText(foodieUtil.formatKValue(j));
        TextView textView3 = ((ActivityFoodieResultDialogBinding) getBinding()).tvBet;
        if (info != null && (betDiamond = info.getBetDiamond()) != null) {
            j2 = betDiamond.longValue();
        } else {
            j2 = 0;
        }
        textView3.setText(foodieUtil.formatKValue(j2));
        FoodieViewModel foodieViewModel = this.viewModel;
        if (info != null && (winDiamond = info.getWinDiamond()) != null) {
            j3 = winDiamond.longValue();
        } else {
            j3 = 0;
        }
        foodieViewModel.onRewardChange(j3);
        ImageView imageView3 = ((ActivityFoodieResultDialogBinding) getBinding()).ivResult;
        Intrinsics.checkNotNullExpressionValue(imageView3, "ivResult");
        ImageKtxKt.loadImage$default(imageView3, foodieUtil.getFoodieIcon(i), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        if (info == null || (arrayList = info.getTop3()) == null) {
            arrayList = new ArrayList<>();
        }
        int i3 = 0;
        for (Object obj : arrayList) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FoodieDrawResult foodieDrawResult = (FoodieDrawResult) obj;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ((ActivityFoodieResultDialogBinding) getBinding()).clBronzePlace.setVisibility(0);
                        TextView textView4 = ((ActivityFoodieResultDialogBinding) getBinding()).tvBronzeName;
                        User user = foodieDrawResult.getUser();
                        if (user != null) {
                            str5 = user.getNick();
                        } else {
                            str5 = null;
                        }
                        textView4.setText(str5);
                        TextView textView5 = ((ActivityFoodieResultDialogBinding) getBinding()).tvBronzeRank;
                        FoodieUtil foodieUtil2 = FoodieUtil.INSTANCE;
                        Long diamond = foodieDrawResult.getDiamond();
                        if (diamond != null) {
                            j6 = diamond.longValue();
                        } else {
                            j6 = 0;
                        }
                        textView5.setText(foodieUtil2.formatKValue(j6));
                        QMUIRadiusImageView qMUIRadiusImageView = ((ActivityFoodieResultDialogBinding) getBinding()).civBronzeAvatar;
                        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "civBronzeAvatar");
                        User user2 = foodieDrawResult.getUser();
                        if (user2 != null) {
                            str6 = user2.getAvatar();
                        } else {
                            str6 = null;
                        }
                        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str6, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                    }
                } else {
                    ((ActivityFoodieResultDialogBinding) getBinding()).clSilverPlace.setVisibility(0);
                    TextView textView6 = ((ActivityFoodieResultDialogBinding) getBinding()).tvSilverName;
                    User user3 = foodieDrawResult.getUser();
                    if (user3 != null) {
                        str3 = user3.getNick();
                    } else {
                        str3 = null;
                    }
                    textView6.setText(str3);
                    TextView textView7 = ((ActivityFoodieResultDialogBinding) getBinding()).tvSilverRank;
                    FoodieUtil foodieUtil3 = FoodieUtil.INSTANCE;
                    Long diamond2 = foodieDrawResult.getDiamond();
                    if (diamond2 != null) {
                        j5 = diamond2.longValue();
                    } else {
                        j5 = 0;
                    }
                    textView7.setText(foodieUtil3.formatKValue(j5));
                    QMUIRadiusImageView qMUIRadiusImageView2 = ((ActivityFoodieResultDialogBinding) getBinding()).civSilverAvatar;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "civSilverAvatar");
                    User user4 = foodieDrawResult.getUser();
                    if (user4 != null) {
                        str4 = user4.getAvatar();
                    } else {
                        str4 = null;
                    }
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                }
            } else {
                ((ActivityFoodieResultDialogBinding) getBinding()).clGoldPlace.setVisibility(0);
                TextView textView8 = ((ActivityFoodieResultDialogBinding) getBinding()).tvGoldName;
                User user5 = foodieDrawResult.getUser();
                if (user5 != null) {
                    str = user5.getNick();
                } else {
                    str = null;
                }
                textView8.setText(str);
                TextView textView9 = ((ActivityFoodieResultDialogBinding) getBinding()).tvGoldRank;
                FoodieUtil foodieUtil4 = FoodieUtil.INSTANCE;
                Long diamond3 = foodieDrawResult.getDiamond();
                if (diamond3 != null) {
                    j4 = diamond3.longValue();
                } else {
                    j4 = 0;
                }
                textView9.setText(foodieUtil4.formatKValue(j4));
                QMUIRadiusImageView qMUIRadiusImageView3 = ((ActivityFoodieResultDialogBinding) getBinding()).civGoldAvatar;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "civGoldAvatar");
                User user6 = foodieDrawResult.getUser();
                if (user6 != null) {
                    str2 = user6.getAvatar();
                } else {
                    str2 = null;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView3, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            i3 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(FoodieResultDialog foodieResultDialog) {
        if (((ActivityFoodieResultDialogBinding) foodieResultDialog.getBinding()).ivGoldCrown.getLayoutDirection() == 1) {
            ((ActivityFoodieResultDialogBinding) foodieResultDialog.getBinding()).ivGoldCrown.setScaleX(-1.0f);
            ((ActivityFoodieResultDialogBinding) foodieResultDialog.getBinding()).ivSilverCrown.setScaleX(-1.0f);
            ((ActivityFoodieResultDialogBinding) foodieResultDialog.getBinding()).ivBronzeCrown.setScaleX(-1.0f);
        }
    }

    private final void playAnim() {
        SVGAParser.Companion.shareParser().decodeFromAssets("svga/foodie_win_big_reward.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieResultDialog$playAnim$1
            public void onComplete(SVGAVideoEntity svgaVideoEntity) {
                Intrinsics.checkNotNullParameter(svgaVideoEntity, "svgaVideoEntity");
                FoodieResultDialog.access$getBinding(FoodieResultDialog.this).svgaImageView.setImageDrawable(new SVGADrawable(svgaVideoEntity));
                FoodieResultDialog.access$getBinding(FoodieResultDialog.this).svgaImageView.setLoops(1);
                FoodieResultDialog.access$getBinding(FoodieResultDialog.this).svgaImageView.startAnimation();
            }

            public void onError() {
            }
        });
    }

    protected int getGravity() {
        return 80;
    }

    protected int getHeight() {
        return -1;
    }

    protected int getLayoutResId() {
        return R.layout.activity_foodie_result_dialog;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    @NotNull
    public final FoodieViewModel getViewModel() {
        return this.viewModel;
    }

    public void onDestroy() {
        if (!checkStateSaved()) {
            this.viewModel.onResultActivityFinish();
            CountDownTimer countDownTimer = this.timerTask;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timerTask = null;
            ((ActivityFoodieResultDialogBinding) getBinding()).svgaImageView.clear();
        }
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onDestroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseDialogFragment*/.onInitialize();
        TextView textView = ((ActivityFoodieResultDialogBinding) getBinding()).tvCountDown;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952774), Arrays.copyOf(new Object[]{3}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        TextView textView2 = ((ActivityFoodieResultDialogBinding) getBinding()).tvCountDown;
        String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952774), Arrays.copyOf(new Object[]{MessageService.MSG_ACCS_READY_REPORT}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(format2);
        CountDownTimer countDownTimer = new CountDownTimer() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieResultDialog$onInitialize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView3 = FoodieResultDialog.access$getBinding(FoodieResultDialog.this).tvCountDown;
                String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131952774), Arrays.copyOf(new Object[]{String.valueOf(((int) millisUntilFinished) / 1000)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                textView3.setText(format3);
            }
        };
        this.timerTask = countDownTimer;
        countDownTimer.start();
        ((ActivityFoodieResultDialogBinding) getBinding()).ivGoldCrown.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.foodie.d1
            @Override // java.lang.Runnable
            public final void run() {
                FoodieResultDialog.onInitialize$lambda$1(FoodieResultDialog.this);
            }
        });
        final FrameLayout frameLayout = ((ActivityFoodieResultDialogBinding) getBinding()).parentContainer;
        final long j = 800;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieResultDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                }
            }
        });
        final FrameLayout frameLayout2 = ((ActivityFoodieResultDialogBinding) getBinding()).frameLayout;
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieResultDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout2) > j || (frameLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout2, currentTimeMillis);
                }
            }
        });
        fillPage(this.viewModel.getGameInfo());
    }

    public void onStart() {
        Window window;
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
        }
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }
}

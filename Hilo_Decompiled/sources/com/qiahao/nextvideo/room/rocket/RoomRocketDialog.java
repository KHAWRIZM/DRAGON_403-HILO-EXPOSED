package com.qiahao.nextvideo.room.rocket;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import c5.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.AwardBean;
import com.qiahao.nextvideo.data.model.Contributor;
import com.qiahao.nextvideo.data.model.RocketDetailBean;
import com.qiahao.nextvideo.data.model.RocketUserBean;
import com.qiahao.nextvideo.data.model.Stage;
import com.qiahao.nextvideo.databinding.DialogRoomRocketBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u001d\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\rJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\rJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010\rJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\b(\u0010#J\u0015\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0003¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0016¢\u0006\u0004\b,\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/room/rocket/RoomRocketDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/view/View$OnClickListener;", "", "mGroupId", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Ljava/lang/String;Landroid/content/Context;I)V", "", "getData", "()V", "Lcom/qiahao/nextvideo/data/model/Stage;", "currentStage", "updateProcess", "(Lcom/qiahao/nextvideo/data/model/Stage;)V", "updateLayout", "showRewardLayout", "", "Lcom/qiahao/nextvideo/data/model/Contributor;", "contributor", "showTopContributorAvatar", "(Ljava/util/List;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initStyle", "initDataBinding", "show", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "type", "changeRocketTypeAndBindView", "(I)V", "view", "changeRocketBgLight", SupportGiftRankActivity.EXTERNAL_ID, "onOpenUserProfile", "(Ljava/lang/String;)V", "onDetachedFromWindow", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "Lcom/qiahao/nextvideo/databinding/DialogRoomRocketBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogRoomRocketBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogRoomRocketBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogRoomRocketBinding;)V", "mCurrentContext", "Landroid/content/Context;", "Lcom/qiahao/nextvideo/data/model/RocketDetailBean;", "mRocketDetailBean", "Lcom/qiahao/nextvideo/data/model/RocketDetailBean;", "mCurrentStage", "Lcom/qiahao/nextvideo/data/model/Stage;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRocketDialog extends BottomSheetDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "RoomRocketDialog";
    public DialogRoomRocketBinding binding;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private Context mCurrentContext;

    @Nullable
    private Stage mCurrentStage;

    @NotNull
    private final String mGroupId;

    @Nullable
    private RocketDetailBean mRocketDetailBean;

    public /* synthetic */ RoomRocketDialog(String str, Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, (i2 & 4) != 0 ? R.style.HiloBottomSheetDialog : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeRocketBgLight$lambda$4$lambda$3(RoomRocketDialog roomRocketDialog, View view) {
        ViewGroup.LayoutParams layoutParams = roomRocketDialog.getBinding().bgLight.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        ((ConstraintLayout.b) layoutParams2).i = view.getId();
        ((ConstraintLayout.b) layoutParams2).l = view.getId();
        ((ConstraintLayout.b) layoutParams2).t = view.getId();
        ((ConstraintLayout.b) layoutParams2).v = view.getId();
        roomRocketDialog.getBinding().bgLight.setLayoutParams(layoutParams2);
    }

    private final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRocketRoomDetailData(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.rocket.a
            public final Object invoke(Object obj) {
                Unit data$lambda$0;
                data$lambda$0 = RoomRocketDialog.getData$lambda$0(RoomRocketDialog.this, (ApiResponse) obj);
                return data$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.rocket.b
            public final Object invoke(Object obj) {
                Unit data$lambda$1;
                data$lambda$1 = RoomRocketDialog.getData$lambda$1((Throwable) obj);
                return data$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$0(RoomRocketDialog roomRocketDialog, ApiResponse apiResponse) {
        int i;
        Stage stage;
        RocketDetailBean rocketDetailBean;
        List<Stage> stages;
        Stage stage2;
        List<Stage> stages2;
        List<Stage> stages3;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        RocketDetailBean rocketDetailBean2 = (RocketDetailBean) apiResponse.getData();
        roomRocketDialog.mRocketDetailBean = rocketDetailBean2;
        int i2 = 0;
        if (rocketDetailBean2 != null && (stages3 = rocketDetailBean2.getStages()) != null) {
            i = stages3.size();
        } else {
            i = 0;
        }
        int i3 = 0;
        while (true) {
            if (i3 < i) {
                RocketDetailBean rocketDetailBean3 = roomRocketDialog.mRocketDetailBean;
                if (rocketDetailBean3 != null && (stages2 = rocketDetailBean3.getStages()) != null) {
                    stage = stages2.get(i3);
                } else {
                    stage = null;
                }
                if (stage != null && (rocketDetailBean = roomRocketDialog.mRocketDetailBean) != null && (stages = rocketDetailBean.getStages()) != null && (stage2 = stages.get(i3)) != null && !stage2.isComplete()) {
                    i2 = i3;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        roomRocketDialog.changeRocketTypeAndBindView(i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "getData: ");
        return Unit.INSTANCE;
    }

    private final void showRewardLayout(Stage currentStage) {
        AwardBean award = currentStage.getAward();
        ImageView imageView = getBinding().bigReward;
        Intrinsics.checkNotNullExpressionValue(imageView, "bigReward");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(award.getPropertyUrl(), UiKtxKt.toPX(UserProxyUtility.cpUpgrades)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (g) null, 49150, (Object) null);
        ImageView imageView2 = getBinding().smallReward1;
        Intrinsics.checkNotNullExpressionValue(imageView2, "smallReward1");
        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.image100(award.getHeaddress1Url()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (g) null, 49150, (Object) null);
        ImageView imageView3 = getBinding().smallReward2;
        Intrinsics.checkNotNullExpressionValue(imageView3, "smallReward2");
        ImageKtxKt.loadImage$default(imageView3, ImageSizeKt.image100(award.getHeaddress2Url()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (g) null, 49150, (Object) null);
    }

    private final void showTopContributorAvatar(List<Contributor> contributor) {
        getBinding().top1Avatar.setVisibility(4);
        getBinding().top2Avatar.setVisibility(4);
        getBinding().top3Avatar.setVisibility(4);
        getBinding().top1Name.setVisibility(4);
        getBinding().top2Name.setVisibility(4);
        getBinding().top3Name.setVisibility(4);
        if (!contributor.isEmpty()) {
            getBinding().top1Name.setVisibility(0);
            getBinding().top1Avatar.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView = getBinding().top1Avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "top1Avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(contributor.get(0).getUser().getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
            getBinding().top1Name.setText(contributor.get(0).getUser().getNick());
        }
        if (contributor.size() > 1) {
            getBinding().top2Name.setVisibility(0);
            getBinding().top2Avatar.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView2 = getBinding().top2Avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "top2Avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(contributor.get(1).getUser().getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
            getBinding().top2Name.setText(contributor.get(1).getUser().getNick());
        }
        if (contributor.size() > 2) {
            getBinding().top3Name.setVisibility(0);
            getBinding().top3Avatar.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView3 = getBinding().top3Avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "top3Avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(contributor.get(2).getUser().getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
            getBinding().top3Name.setText(contributor.get(2).getUser().getNick());
        }
    }

    private final void updateLayout(Stage currentStage) {
        if (currentStage.isComplete()) {
            getBinding().progressContent.setVisibility(8);
            getBinding().topContributorsContent.setVisibility(0);
            showTopContributorAvatar(currentStage.getContributors());
        } else {
            getBinding().progressContent.setVisibility(0);
            getBinding().topContributorsContent.setVisibility(8);
            showRewardLayout(currentStage);
        }
    }

    private final void updateProcess(Stage currentStage) {
        ProgressBar progressBar = getBinding().progressBar;
        progressBar.setMax(currentStage.getNextScore());
        progressBar.setProgress(currentStage.getScore());
        progressBar.post(new Runnable() { // from class: com.qiahao.nextvideo.room.rocket.d
            @Override // java.lang.Runnable
            public final void run() {
                RoomRocketDialog.updateProcess$lambda$6$lambda$5(RoomRocketDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateProcess$lambda$6$lambda$5(RoomRocketDialog roomRocketDialog) {
        ConstraintLayout.b layoutParams = roomRocketDialog.getBinding().light.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        bVar.setMarginStart((int) (roomRocketDialog.getBinding().progressBar.getWidth() * (roomRocketDialog.getBinding().progressBar.getProgress() / roomRocketDialog.getBinding().progressBar.getMax())));
        roomRocketDialog.getBinding().light.setLayoutParams(bVar);
    }

    public final void changeRocketBgLight(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getBinding().bgLight.post(new Runnable() { // from class: com.qiahao.nextvideo.room.rocket.c
            @Override // java.lang.Runnable
            public final void run() {
                RoomRocketDialog.changeRocketBgLight$lambda$4$lambda$3(RoomRocketDialog.this, view);
            }
        });
    }

    public final void changeRocketTypeAndBindView(int type) {
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            ImageView imageView = getBinding().bigRocket;
                            Intrinsics.checkNotNullExpressionValue(imageView, "bigRocket");
                            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_big_orange_panel), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                            ImageView imageView2 = getBinding().smallOrangeRocket;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "smallOrangeRocket");
                            changeRocketBgLight(imageView2);
                        }
                    } else {
                        ImageView imageView3 = getBinding().bigRocket;
                        Intrinsics.checkNotNullExpressionValue(imageView3, "bigRocket");
                        ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_big_purple_panel), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                        ImageView imageView4 = getBinding().smallPurpleRocket;
                        Intrinsics.checkNotNullExpressionValue(imageView4, "smallPurpleRocket");
                        changeRocketBgLight(imageView4);
                    }
                } else {
                    ImageView imageView5 = getBinding().bigRocket;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "bigRocket");
                    ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_big_red_panel), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                    ImageView imageView6 = getBinding().smallRedRocket;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "smallRedRocket");
                    changeRocketBgLight(imageView6);
                }
            } else {
                ImageView imageView7 = getBinding().bigRocket;
                Intrinsics.checkNotNullExpressionValue(imageView7, "bigRocket");
                ImageKtxKt.loadImage$default(imageView7, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_big_blue_panel), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                ImageView imageView8 = getBinding().smallBlueRocket;
                Intrinsics.checkNotNullExpressionValue(imageView8, "smallBlueRocket");
                changeRocketBgLight(imageView8);
            }
        } else {
            ImageView imageView9 = getBinding().bigRocket;
            Intrinsics.checkNotNullExpressionValue(imageView9, "bigRocket");
            ImageKtxKt.loadImage$default(imageView9, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_big_green_panel), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            ImageView imageView10 = getBinding().smallGreenRocket;
            Intrinsics.checkNotNullExpressionValue(imageView10, "smallGreenRocket");
            changeRocketBgLight(imageView10);
        }
        RocketDetailBean rocketDetailBean = this.mRocketDetailBean;
        if (rocketDetailBean != null && rocketDetailBean.getStages().size() > type) {
            Stage stage = rocketDetailBean.getStages().get(type);
            this.mCurrentStage = stage;
            updateProcess(stage);
            updateLayout(stage);
        }
    }

    @NotNull
    public final DialogRoomRocketBinding getBinding() {
        DialogRoomRocketBinding dialogRoomRocketBinding = this.binding;
        if (dialogRoomRocketBinding != null) {
            return dialogRoomRocketBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final void initDataBinding() {
        setBinding((DialogRoomRocketBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_room_rocket, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            BottomSheetBehavior.s0(frameLayout).Y0(-1);
            frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setDimAmount(0.0f);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        boolean z;
        List<Contributor> contributors;
        Contributor contributor;
        RocketUserBean user;
        String externalId;
        List<Contributor> contributors2;
        int i;
        List<Contributor> contributors3;
        Contributor contributor2;
        RocketUserBean user2;
        String externalId2;
        List<Contributor> contributors4;
        int i2;
        List<Contributor> contributors5;
        Contributor contributor3;
        RocketUserBean user3;
        String externalId3;
        List<Contributor> contributors6;
        Intrinsics.checkNotNullParameter(v, "v");
        String str = "";
        boolean z2 = true;
        switch (v.getId()) {
            case R.id.small_blue_rocket /* 2131364843 */:
                changeRocketTypeAndBindView(1);
                ImageView imageView = getBinding().smallBlueRocket;
                Intrinsics.checkNotNullExpressionValue(imageView, "smallBlueRocket");
                changeRocketBgLight(imageView);
                return;
            case R.id.small_green_rocket /* 2131364844 */:
                changeRocketTypeAndBindView(0);
                return;
            case R.id.small_orange_rocket /* 2131364847 */:
                changeRocketTypeAndBindView(4);
                ImageView imageView2 = getBinding().smallOrangeRocket;
                Intrinsics.checkNotNullExpressionValue(imageView2, "smallOrangeRocket");
                changeRocketBgLight(imageView2);
                return;
            case R.id.small_purple_rocket /* 2131364848 */:
                changeRocketTypeAndBindView(3);
                ImageView imageView3 = getBinding().smallPurpleRocket;
                Intrinsics.checkNotNullExpressionValue(imageView3, "smallPurpleRocket");
                changeRocketBgLight(imageView3);
                return;
            case R.id.small_red_rocket /* 2131364849 */:
                changeRocketTypeAndBindView(2);
                ImageView imageView4 = getBinding().smallRedRocket;
                Intrinsics.checkNotNullExpressionValue(imageView4, "smallRedRocket");
                changeRocketBgLight(imageView4);
                return;
            case R.id.top1_avatar /* 2131365223 */:
                Stage stage = this.mCurrentStage;
                if (stage != null) {
                    if (stage != null && (contributors2 = stage.getContributors()) != null && (!contributors2.isEmpty())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Stage stage2 = this.mCurrentStage;
                        if (stage2 != null && (contributors = stage2.getContributors()) != null && (contributor = contributors.get(0)) != null && (user = contributor.getUser()) != null && (externalId = user.getExternalId()) != null) {
                            str = externalId;
                        }
                        if (str.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            onOpenUserProfile(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.top2_avatar /* 2131365245 */:
                Stage stage3 = this.mCurrentStage;
                if (stage3 != null) {
                    if (stage3 != null && (contributors4 = stage3.getContributors()) != null) {
                        i = contributors4.size();
                    } else {
                        i = 0;
                    }
                    if (i > 1) {
                        Stage stage4 = this.mCurrentStage;
                        if (stage4 != null && (contributors3 = stage4.getContributors()) != null && (contributor2 = contributors3.get(1)) != null && (user2 = contributor2.getUser()) != null && (externalId2 = user2.getExternalId()) != null) {
                            str = externalId2;
                        }
                        if (str.length() <= 0) {
                            z2 = false;
                        }
                        if (z2) {
                            onOpenUserProfile(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.top3_avatar /* 2131365266 */:
                Stage stage5 = this.mCurrentStage;
                if (stage5 != null && (contributors6 = stage5.getContributors()) != null) {
                    i2 = contributors6.size();
                } else {
                    i2 = 0;
                }
                if (i2 > 2) {
                    Stage stage6 = this.mCurrentStage;
                    if (stage6 != null && (contributors5 = stage6.getContributors()) != null && (contributor3 = contributors5.get(2)) != null && (user3 = contributor3.getUser()) != null && (externalId3 = user3.getExternalId()) != null) {
                        str = externalId3;
                    }
                    if (str.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        onOpenUserProfile(str);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDismissWithAnimation(true);
        initDataBinding();
        initStyle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mCompositeDisposable.d();
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    public final void setBinding(@NotNull DialogRoomRocketBinding dialogRoomRocketBinding) {
        Intrinsics.checkNotNullParameter(dialogRoomRocketBinding, "<set-?>");
        this.binding = dialogRoomRocketBinding;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        getData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRocketDialog(@NotNull String str, @NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGroupId = str;
        this.mCurrentContext = context;
        this.mCompositeDisposable = new nd.a();
    }
}

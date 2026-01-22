package com.qiahao.nextvideo.room.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.data.game.GameConfigLudo;
import com.qiahao.nextvideo.databinding.DialogCreateLudoBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.family.FamilyMoreDialog;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0014¢\u0006\u0004\b \u0010\u001fR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b5\u0010\u001f\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R?\u0010C\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006I"}, d2 = {"Lcom/qiahao/nextvideo/room/game/CreateLudoDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCreateLudoBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "createLudoData", "", "gameCode", "Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "gameConfig", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/game/CreateSudData;Ljava/lang/String;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;)V", "", "confirmCreate", "()V", "Landroid/view/View;", "clickButton", "relevanceButton", "checkSelectButton", "(Landroid/view/View;Landroid/view/View;)V", "Landroid/widget/TextView;", "checkSelectText", "(Landroid/widget/TextView;Landroid/widget/TextView;)V", "checkDiamond", "", "getLayoutResId", "()I", "onInitialize", "", "isBottomStyle", "()Z", "isNeedFullScreen", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "getCreateLudoData", "()Lcom/qiahao/nextvideo/data/game/CreateSudData;", "setCreateLudoData", "(Lcom/qiahao/nextvideo/data/game/CreateSudData;)V", "Ljava/lang/String;", "getGameCode", "()Ljava/lang/String;", "setGameCode", "(Ljava/lang/String;)V", "Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "getGameConfig", "()Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "setGameConfig", "(Lcom/qiahao/nextvideo/data/game/GameConfigLudo;)V", "mPosition", "I", "getMPosition", "setMPosition", "(I)V", "isCreateGem", "Z", "setCreateGem", "(Z)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createListener", "Lkotlin/jvm/functions/Function1;", "getCreateListener", "()Lkotlin/jvm/functions/Function1;", "setCreateListener", "(Lkotlin/jvm/functions/Function1;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCreateLudoDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateLudoDialog.kt\ncom/qiahao/nextvideo/room/game/CreateLudoDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,194:1\n1878#2,3:195\n1#3:198\n*S KotlinDebug\n*F\n+ 1 CreateLudoDialog.kt\ncom/qiahao/nextvideo/room/game/CreateLudoDialog\n*L\n108#1:195,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CreateLudoDialog extends BaseBindingDialog<DialogCreateLudoBinding> {

    @Nullable
    private Function1<? super CreateSudData, Unit> createListener;

    @Nullable
    private CreateSudData createLudoData;

    @Nullable
    private String gameCode;

    @Nullable
    private GameConfigLudo gameConfig;
    private boolean isCreateGem;

    @NotNull
    private nd.a mCompositeDisposable;
    private int mPosition;

    public /* synthetic */ CreateLudoDialog(Context context, CreateSudData createSudData, String str, GameConfigLudo gameConfigLudo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : createSudData, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : gameConfigLudo);
    }

    private final void checkDiamond() {
        int i;
        String str;
        String str2;
        ArrayList<Integer> diamond;
        String str3;
        ArrayList<Integer> diamond2;
        Integer num;
        int i2 = this.mPosition;
        Integer valueOf = Integer.valueOf(R.drawable.ludo_create_add_default_icon);
        Integer valueOf2 = Integer.valueOf(R.drawable.ludo_create_minus_default_icon);
        if (i2 == 0) {
            ImageView imageView = ((DialogCreateLudoBinding) getBinding()).minus;
            Intrinsics.checkNotNullExpressionValue(imageView, "minus");
            str = "minus";
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            str2 = "add";
        } else {
            GameConfigLudo gameConfigLudo = this.gameConfig;
            if (gameConfigLudo != null && (diamond = gameConfigLudo.getDiamond()) != null) {
                i = diamond.size();
            } else {
                i = 0;
            }
            if (i2 != i - 1) {
                str = "minus";
                ImageView imageView2 = ((DialogCreateLudoBinding) getBinding()).minus;
                Intrinsics.checkNotNullExpressionValue(imageView2, str);
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_minus_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                ImageView imageView3 = ((DialogCreateLudoBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView3, "add");
                str2 = "add";
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_add_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                ImageView imageView4 = ((DialogCreateLudoBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView4, "add");
                str = "minus";
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                str2 = "add";
            }
        }
        if (!this.isCreateGem) {
            ImageView imageView5 = ((DialogCreateLudoBinding) getBinding()).minus;
            Intrinsics.checkNotNullExpressionValue(imageView5, str);
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView6 = ((DialogCreateLudoBinding) getBinding()).add;
            Intrinsics.checkNotNullExpressionValue(imageView6, str2);
            ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        TextView textView = ((DialogCreateLudoBinding) getBinding()).diamondText;
        GameConfigLudo gameConfigLudo2 = this.gameConfig;
        if (gameConfigLudo2 == null || (diamond2 = gameConfigLudo2.getDiamond()) == null || (num = diamond2.get(this.mPosition)) == null || (str3 = num.toString()) == null) {
            str3 = "";
        }
        textView.setText(str3);
    }

    private final void checkSelectButton(View clickButton, View relevanceButton) {
        if (!clickButton.isSelected()) {
            clickButton.setSelected(true);
        }
        if (relevanceButton != null) {
            relevanceButton.setSelected(false);
        }
    }

    static /* synthetic */ void checkSelectButton$default(CreateLudoDialog createLudoDialog, View view, View view2, int i, Object obj) {
        if ((i & 2) != 0) {
            view2 = null;
        }
        createLudoDialog.checkSelectButton(view, view2);
    }

    private final void checkSelectText(TextView clickButton, TextView relevanceButton) {
        clickButton.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.ludo_create_select));
        clickButton.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099850));
        relevanceButton.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.ludo_create_unselect));
        relevanceButton.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099904));
    }

    private final void confirmCreate() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Long gameId;
        Function1<? super CreateSudData, Unit> function1;
        int i6;
        ArrayList<Integer> diamond;
        Integer num;
        if (((DialogCreateLudoBinding) getBinding()).magicSelect.isSelected()) {
            CreateSudData createSudData = this.createLudoData;
            if (createSudData != null) {
                createSudData.setOnOff1(1);
            }
        } else {
            CreateSudData createSudData2 = this.createLudoData;
            if (createSudData2 != null) {
                createSudData2.setOnOff1(0);
            }
        }
        if (((DialogCreateLudoBinding) getBinding()).autoMatch.isSelected()) {
            CreateSudData createSudData3 = this.createLudoData;
            if (createSudData3 != null) {
                createSudData3.setAutoMatch(1);
            }
        } else {
            CreateSudData createSudData4 = this.createLudoData;
            if (createSudData4 != null) {
                createSudData4.setAutoMatch(0);
            }
        }
        CreateSudData createSudData5 = this.createLudoData;
        if (createSudData5 != null) {
            GameConfigLudo gameConfigLudo = this.gameConfig;
            if (gameConfigLudo != null && (diamond = gameConfigLudo.getDiamond()) != null && (num = diamond.get(this.mPosition)) != null) {
                i6 = num.intValue();
            } else {
                i6 = 0;
            }
            createSudData5.setDiamond(i6);
        }
        if (this.isCreateGem) {
            CreateSudData createSudData6 = this.createLudoData;
            if (createSudData6 != null && (function1 = this.createListener) != null) {
                function1.invoke(createSudData6);
                return;
            }
            return;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        CreateSudData createSudData7 = this.createLudoData;
        if (createSudData7 != null && (gameId = createSudData7.getGameId()) != null) {
            j = gameId.longValue();
        } else {
            j = 0;
        }
        long j2 = j;
        CreateSudData createSudData8 = this.createLudoData;
        if (createSudData8 != null) {
            i = createSudData8.getMode();
        } else {
            i = 0;
        }
        CreateSudData createSudData9 = this.createLudoData;
        if (createSudData9 != null) {
            i2 = createSudData9.getPiece();
        } else {
            i2 = 0;
        }
        CreateSudData createSudData10 = this.createLudoData;
        if (createSudData10 != null) {
            i3 = createSudData10.getOnOff1();
        } else {
            i3 = 0;
        }
        CreateSudData createSudData11 = this.createLudoData;
        if (createSudData11 != null) {
            i4 = createSudData11.getDiamond();
        } else {
            i4 = 0;
        }
        CreateSudData createSudData12 = this.createLudoData;
        if (createSudData12 != null) {
            i5 = createSudData12.getAutoMatch();
        } else {
            i5 = 0;
        }
        String str = this.gameCode;
        if (str == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.editSud(j2, i, i2, i3, i4, i5, str), new Function1() { // from class: com.qiahao.nextvideo.room.game.s
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$4;
                confirmCreate$lambda$4 = CreateLudoDialog.confirmCreate$lambda$4(CreateLudoDialog.this, (ApiResponse) obj);
                return confirmCreate$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.game.t
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$5;
                confirmCreate$lambda$5 = CreateLudoDialog.confirmCreate$lambda$5(CreateLudoDialog.this, (Throwable) obj);
                return confirmCreate$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmCreate$lambda$4(CreateLudoDialog createLudoDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        createLudoDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmCreate$lambda$5(CreateLudoDialog createLudoDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = createLudoDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(createLudoDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, createLudoDialog.getContext(), ResourcesKtxKt.getStringById(createLudoDialog, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(CreateLudoDialog createLudoDialog, View view) {
        int i;
        ArrayList<Integer> diamond;
        ArrayList<Integer> diamond2;
        int i2 = 0;
        switch (view.getId()) {
            case 2131361922:
                if (!createLudoDialog.isCreateGem) {
                    return;
                }
                int i3 = createLudoDialog.mPosition;
                GameConfigLudo gameConfigLudo = createLudoDialog.gameConfig;
                if (gameConfigLudo != null && (diamond2 = gameConfigLudo.getDiamond()) != null) {
                    i = diamond2.size();
                } else {
                    i = 0;
                }
                if (i3 >= i - 1) {
                    GameConfigLudo gameConfigLudo2 = createLudoDialog.gameConfig;
                    if (gameConfigLudo2 != null && (diamond = gameConfigLudo2.getDiamond()) != null) {
                        i2 = diamond.size();
                    }
                    createLudoDialog.mPosition = i2 - 1;
                } else {
                    createLudoDialog.mPosition++;
                }
                createLudoDialog.checkDiamond();
                return;
            case R.id.autoMatch /* 2131362008 */:
            case R.id.autoText /* 2131362009 */:
                ((DialogCreateLudoBinding) createLudoDialog.getBinding()).autoMatch.setSelected(!((DialogCreateLudoBinding) createLudoDialog.getBinding()).autoMatch.isSelected());
                return;
            case R.id.classic /* 2131362356 */:
                CreateSudData createSudData = createLudoDialog.createLudoData;
                if (createSudData != null) {
                    createSudData.setMode(2);
                }
                TextView textView = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView, "classic");
                TextView textView2 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView2, FamilyMoreDialog.CLICK_QUICK);
                createLudoDialog.checkSelectText(textView, textView2);
                return;
            case R.id.close /* 2131362369 */:
            case R.id.rootLayout /* 2131364676 */:
                createLudoDialog.dismiss();
                return;
            case R.id.createButton /* 2131362560 */:
                createLudoDialog.confirmCreate();
                return;
            case R.id.fourSelect /* 2131362940 */:
                CreateSudData createSudData2 = createLudoDialog.createLudoData;
                if (createSudData2 != null) {
                    createSudData2.setPiece(4);
                }
                TextView textView3 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).fourSelect;
                Intrinsics.checkNotNullExpressionValue(textView3, "fourSelect");
                TextView textView4 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).twoSelect;
                Intrinsics.checkNotNullExpressionValue(textView4, "twoSelect");
                createLudoDialog.checkSelectText(textView3, textView4);
                return;
            case R.id.magic /* 2131363725 */:
            case R.id.magicIcon /* 2131363726 */:
            case R.id.magicSelect /* 2131363727 */:
                ((DialogCreateLudoBinding) createLudoDialog.getBinding()).magicSelect.setSelected(!((DialogCreateLudoBinding) createLudoDialog.getBinding()).magicSelect.isSelected());
                return;
            case R.id.minus /* 2131363910 */:
                if (!createLudoDialog.isCreateGem) {
                    return;
                }
                int i4 = createLudoDialog.mPosition;
                if (i4 <= 0) {
                    createLudoDialog.mPosition = 0;
                } else {
                    createLudoDialog.mPosition = i4 - 1;
                }
                createLudoDialog.checkDiamond();
                return;
            case R.id.quick /* 2131364409 */:
                CreateSudData createSudData3 = createLudoDialog.createLudoData;
                if (createSudData3 != null) {
                    createSudData3.setMode(1);
                }
                TextView textView5 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView5, FamilyMoreDialog.CLICK_QUICK);
                TextView textView6 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView6, "classic");
                createLudoDialog.checkSelectText(textView5, textView6);
                return;
            case R.id.twoSelect /* 2131365465 */:
                CreateSudData createSudData4 = createLudoDialog.createLudoData;
                if (createSudData4 != null) {
                    createSudData4.setPiece(2);
                }
                TextView textView7 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).twoSelect;
                Intrinsics.checkNotNullExpressionValue(textView7, "twoSelect");
                TextView textView8 = ((DialogCreateLudoBinding) createLudoDialog.getBinding()).fourSelect;
                Intrinsics.checkNotNullExpressionValue(textView8, "fourSelect");
                createLudoDialog.checkSelectText(textView7, textView8);
                return;
            default:
                return;
        }
    }

    @Nullable
    public final Function1<CreateSudData, Unit> getCreateListener() {
        return this.createListener;
    }

    @Nullable
    public final CreateSudData getCreateLudoData() {
        return this.createLudoData;
    }

    @Nullable
    public final String getGameCode() {
        return this.gameCode;
    }

    @Nullable
    public final GameConfigLudo getGameConfig() {
        return this.gameConfig;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_create_ludo;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public final int getMPosition() {
        return this.mPosition;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* renamed from: isCreateGem, reason: from getter */
    public final boolean getIsCreateGem() {
        return this.isCreateGem;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        ArrayList<Integer> diamond;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogCreateLudoBinding) getBinding()).setClick(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateLudoDialog.onInitialize$lambda$0(CreateLudoDialog.this, view);
            }
        });
        ConstraintLayout constraintLayout = ((DialogCreateLudoBinding) getBinding()).moneyLayout;
        GameConfigLudo gameConfigLudo = this.gameConfig;
        int i2 = 0;
        if (gameConfigLudo != null) {
            z = Intrinsics.areEqual(gameConfigLudo.getShowBetModule(), Boolean.TRUE);
        } else {
            z = false;
        }
        int i3 = 4;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        constraintLayout.setVisibility(i);
        TextView textView = ((DialogCreateLudoBinding) getBinding()).bet;
        GameConfigLudo gameConfigLudo2 = this.gameConfig;
        if (gameConfigLudo2 != null) {
            z2 = Intrinsics.areEqual(gameConfigLudo2.getShowBetModule(), Boolean.TRUE);
        } else {
            z2 = false;
        }
        if (z2) {
            i3 = 0;
        }
        textView.setVisibility(i3);
        boolean z4 = true;
        if (this.createLudoData == null) {
            this.createLudoData = new CreateSudData(1, 1, 0, 0, 0, 0, MeetingRoomManager.INSTANCE.getMGroupId(), null, UserProxyUtility.roomMicNumChange, null);
            this.isCreateGem = true;
            ((DialogCreateLudoBinding) getBinding()).createButton.setText(ResourcesKtxKt.getStringById(this, 2131952331));
        }
        CreateSudData createSudData = this.createLudoData;
        if (createSudData != null) {
            if (createSudData.getMode() == 1) {
                TextView textView2 = ((DialogCreateLudoBinding) getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView2, FamilyMoreDialog.CLICK_QUICK);
                TextView textView3 = ((DialogCreateLudoBinding) getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView3, "classic");
                checkSelectText(textView2, textView3);
            } else {
                TextView textView4 = ((DialogCreateLudoBinding) getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView4, "classic");
                TextView textView5 = ((DialogCreateLudoBinding) getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView5, FamilyMoreDialog.CLICK_QUICK);
                checkSelectText(textView4, textView5);
            }
            if (createSudData.getPiece() == 2) {
                TextView textView6 = ((DialogCreateLudoBinding) getBinding()).twoSelect;
                Intrinsics.checkNotNullExpressionValue(textView6, "twoSelect");
                TextView textView7 = ((DialogCreateLudoBinding) getBinding()).fourSelect;
                Intrinsics.checkNotNullExpressionValue(textView7, "fourSelect");
                checkSelectText(textView6, textView7);
            } else {
                TextView textView8 = ((DialogCreateLudoBinding) getBinding()).fourSelect;
                Intrinsics.checkNotNullExpressionValue(textView8, "fourSelect");
                TextView textView9 = ((DialogCreateLudoBinding) getBinding()).twoSelect;
                Intrinsics.checkNotNullExpressionValue(textView9, "twoSelect");
                checkSelectText(textView8, textView9);
            }
            ImageView imageView = ((DialogCreateLudoBinding) getBinding()).magicSelect;
            if (createSudData.getOnOff1() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            imageView.setSelected(z3);
            ImageView imageView2 = ((DialogCreateLudoBinding) getBinding()).autoMatch;
            if (createSudData.getAutoMatch() != 1) {
                z4 = false;
            }
            imageView2.setSelected(z4);
            GameConfigLudo gameConfigLudo3 = this.gameConfig;
            if (gameConfigLudo3 != null && (diamond = gameConfigLudo3.getDiamond()) != null) {
                for (Object obj : diamond) {
                    int i4 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (((Number) obj).intValue() == createSudData.getDiamond()) {
                        this.mPosition = i2;
                    }
                    i2 = i4;
                }
            }
            checkDiamond();
        }
    }

    public final void setCreateGem(boolean z) {
        this.isCreateGem = z;
    }

    public final void setCreateListener(@Nullable Function1<? super CreateSudData, Unit> function1) {
        this.createListener = function1;
    }

    public final void setCreateLudoData(@Nullable CreateSudData createSudData) {
        this.createLudoData = createSudData;
    }

    public final void setGameCode(@Nullable String str) {
        this.gameCode = str;
    }

    public final void setGameConfig(@Nullable GameConfigLudo gameConfigLudo) {
        this.gameConfig = gameConfigLudo;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateLudoDialog(@NotNull Context context, @Nullable CreateSudData createSudData, @Nullable String str, @Nullable GameConfigLudo gameConfigLudo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.createLudoData = createSudData;
        this.gameCode = str;
        this.gameConfig = gameConfigLudo;
        this.mPosition = 1;
        this.mCompositeDisposable = new nd.a();
    }
}

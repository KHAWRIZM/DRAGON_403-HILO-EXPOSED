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
import com.qiahao.nextvideo.databinding.DialogCreateCarromBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH\u0014¢\u0006\u0004\b!\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\"R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u0010 \"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R?\u0010@\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/qiahao/nextvideo/room/game/CreateCarromDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCreateCarromBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "createCarromData", "", "gameCode", "Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "gameConfig", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/game/CreateSudData;Ljava/lang/String;Lcom/qiahao/nextvideo/data/game/GameConfigLudo;)V", "", "confirmCreate", "()V", "Landroid/view/View;", "clickButton", "relevanceButton", "checkSelectButton", "(Landroid/view/View;Landroid/view/View;)V", "Landroid/widget/TextView;", "relevanceButton1", "checkSelectText", "(Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V", "checkDiamond", "", "getLayoutResId", "()I", "onInitialize", "", "isBottomStyle", "()Z", "isNeedFullScreen", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "Ljava/lang/String;", "getGameCode", "()Ljava/lang/String;", "setGameCode", "(Ljava/lang/String;)V", "Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "getGameConfig", "()Lcom/qiahao/nextvideo/data/game/GameConfigLudo;", "setGameConfig", "(Lcom/qiahao/nextvideo/data/game/GameConfigLudo;)V", "mPosition", "I", "getMPosition", "setMPosition", "(I)V", "isCreateGem", "Z", "setCreateGem", "(Z)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createListener", "Lkotlin/jvm/functions/Function1;", "getCreateListener", "()Lkotlin/jvm/functions/Function1;", "setCreateListener", "(Lkotlin/jvm/functions/Function1;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCreateCarromDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateCarromDialog.kt\ncom/qiahao/nextvideo/room/game/CreateCarromDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1878#2,3:192\n1#3:195\n*S KotlinDebug\n*F\n+ 1 CreateCarromDialog.kt\ncom/qiahao/nextvideo/room/game/CreateCarromDialog\n*L\n105#1:192,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CreateCarromDialog extends BaseBindingDialog<DialogCreateCarromBinding> {

    @Nullable
    private CreateSudData createCarromData;

    @Nullable
    private Function1<? super CreateSudData, Unit> createListener;

    @Nullable
    private String gameCode;

    @Nullable
    private GameConfigLudo gameConfig;
    private boolean isCreateGem;

    @NotNull
    private nd.a mCompositeDisposable;
    private int mPosition;

    public /* synthetic */ CreateCarromDialog(Context context, CreateSudData createSudData, String str, GameConfigLudo gameConfigLudo, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
            ImageView imageView = ((DialogCreateCarromBinding) getBinding()).minus;
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
                ImageView imageView2 = ((DialogCreateCarromBinding) getBinding()).minus;
                Intrinsics.checkNotNullExpressionValue(imageView2, str);
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_minus_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                ImageView imageView3 = ((DialogCreateCarromBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView3, "add");
                str2 = "add";
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_add_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                ImageView imageView4 = ((DialogCreateCarromBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView4, "add");
                str = "minus";
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                str2 = "add";
            }
        }
        if (!this.isCreateGem) {
            ImageView imageView5 = ((DialogCreateCarromBinding) getBinding()).minus;
            Intrinsics.checkNotNullExpressionValue(imageView5, str);
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView6 = ((DialogCreateCarromBinding) getBinding()).add;
            Intrinsics.checkNotNullExpressionValue(imageView6, str2);
            ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        TextView textView = ((DialogCreateCarromBinding) getBinding()).diamondText;
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

    static /* synthetic */ void checkSelectButton$default(CreateCarromDialog createCarromDialog, View view, View view2, int i, Object obj) {
        if ((i & 2) != 0) {
            view2 = null;
        }
        createCarromDialog.checkSelectButton(view, view2);
    }

    private final void checkSelectText(TextView clickButton, TextView relevanceButton, TextView relevanceButton1) {
        clickButton.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.carrom_create_select));
        clickButton.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099925));
        relevanceButton.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.carrom_create_unselect));
        relevanceButton.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099951));
        relevanceButton1.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.carrom_create_unselect));
        relevanceButton1.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099951));
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
        if (((DialogCreateCarromBinding) getBinding()).autoMatch.isSelected()) {
            CreateSudData createSudData = this.createCarromData;
            if (createSudData != null) {
                createSudData.setAutoMatch(1);
            }
        } else {
            CreateSudData createSudData2 = this.createCarromData;
            if (createSudData2 != null) {
                createSudData2.setAutoMatch(0);
            }
        }
        CreateSudData createSudData3 = this.createCarromData;
        if (createSudData3 != null) {
            GameConfigLudo gameConfigLudo = this.gameConfig;
            if (gameConfigLudo != null && (diamond = gameConfigLudo.getDiamond()) != null && (num = diamond.get(this.mPosition)) != null) {
                i6 = num.intValue();
            } else {
                i6 = 0;
            }
            createSudData3.setDiamond(i6);
        }
        if (this.isCreateGem) {
            CreateSudData createSudData4 = this.createCarromData;
            if (createSudData4 != null && (function1 = this.createListener) != null) {
                function1.invoke(createSudData4);
                return;
            }
            return;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        CreateSudData createSudData5 = this.createCarromData;
        if (createSudData5 != null && (gameId = createSudData5.getGameId()) != null) {
            j = gameId.longValue();
        } else {
            j = 0;
        }
        CreateSudData createSudData6 = this.createCarromData;
        if (createSudData6 != null) {
            i = createSudData6.getMode();
        } else {
            i = 0;
        }
        CreateSudData createSudData7 = this.createCarromData;
        if (createSudData7 != null) {
            i2 = createSudData7.getPiece();
        } else {
            i2 = 0;
        }
        CreateSudData createSudData8 = this.createCarromData;
        if (createSudData8 != null) {
            i3 = createSudData8.getOnOff1();
        } else {
            i3 = 0;
        }
        CreateSudData createSudData9 = this.createCarromData;
        if (createSudData9 != null) {
            i4 = createSudData9.getDiamond();
        } else {
            i4 = 0;
        }
        CreateSudData createSudData10 = this.createCarromData;
        if (createSudData10 != null) {
            i5 = createSudData10.getAutoMatch();
        } else {
            i5 = 0;
        }
        String str = this.gameCode;
        if (str == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.editSud(j, i, i2, i3, i4, i5, str), new Function1() { // from class: com.qiahao.nextvideo.room.game.h
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$4;
                confirmCreate$lambda$4 = CreateCarromDialog.confirmCreate$lambda$4(CreateCarromDialog.this, (ApiResponse) obj);
                return confirmCreate$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.game.i
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$5;
                confirmCreate$lambda$5 = CreateCarromDialog.confirmCreate$lambda$5(CreateCarromDialog.this, (Throwable) obj);
                return confirmCreate$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmCreate$lambda$4(CreateCarromDialog createCarromDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        createCarromDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmCreate$lambda$5(CreateCarromDialog createCarromDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = createCarromDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(createCarromDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, createCarromDialog.getContext(), ResourcesKtxKt.getStringById(createCarromDialog, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(CreateCarromDialog createCarromDialog, View view) {
        int i;
        ArrayList<Integer> diamond;
        ArrayList<Integer> diamond2;
        int i2 = 0;
        switch (view.getId()) {
            case 2131361922:
                if (!createCarromDialog.isCreateGem) {
                    return;
                }
                int i3 = createCarromDialog.mPosition;
                GameConfigLudo gameConfigLudo = createCarromDialog.gameConfig;
                if (gameConfigLudo != null && (diamond2 = gameConfigLudo.getDiamond()) != null) {
                    i = diamond2.size();
                } else {
                    i = 0;
                }
                if (i3 >= i - 1) {
                    GameConfigLudo gameConfigLudo2 = createCarromDialog.gameConfig;
                    if (gameConfigLudo2 != null && (diamond = gameConfigLudo2.getDiamond()) != null) {
                        i2 = diamond.size();
                    }
                    createCarromDialog.mPosition = i2 - 1;
                } else {
                    createCarromDialog.mPosition++;
                }
                createCarromDialog.checkDiamond();
                return;
            case R.id.autoMatch /* 2131362008 */:
            case R.id.autoText /* 2131362009 */:
                ((DialogCreateCarromBinding) createCarromDialog.getBinding()).autoMatch.setSelected(!((DialogCreateCarromBinding) createCarromDialog.getBinding()).autoMatch.isSelected());
                return;
            case R.id.carrom /* 2131362232 */:
                CreateSudData createSudData = createCarromDialog.createCarromData;
                if (createSudData != null) {
                    createSudData.setMode(1);
                }
                CreateSudData createSudData2 = createCarromDialog.createCarromData;
                if (createSudData2 != null) {
                    createSudData2.setPiece(2);
                }
                TextView textView = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).carrom;
                Intrinsics.checkNotNullExpressionValue(textView, "carrom");
                TextView textView2 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).freestyle;
                Intrinsics.checkNotNullExpressionValue(textView2, "freestyle");
                TextView textView3 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).two;
                Intrinsics.checkNotNullExpressionValue(textView3, "two");
                createCarromDialog.checkSelectText(textView, textView2, textView3);
                return;
            case R.id.close /* 2131362369 */:
            case R.id.rootLayout /* 2131364676 */:
                createCarromDialog.dismiss();
                return;
            case R.id.createButton /* 2131362560 */:
                createCarromDialog.confirmCreate();
                return;
            case R.id.freestyle /* 2131362948 */:
                CreateSudData createSudData3 = createCarromDialog.createCarromData;
                if (createSudData3 != null) {
                    createSudData3.setMode(2);
                }
                CreateSudData createSudData4 = createCarromDialog.createCarromData;
                if (createSudData4 != null) {
                    createSudData4.setPiece(2);
                }
                TextView textView4 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).freestyle;
                Intrinsics.checkNotNullExpressionValue(textView4, "freestyle");
                TextView textView5 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).carrom;
                Intrinsics.checkNotNullExpressionValue(textView5, "carrom");
                TextView textView6 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).two;
                Intrinsics.checkNotNullExpressionValue(textView6, "two");
                createCarromDialog.checkSelectText(textView4, textView5, textView6);
                return;
            case R.id.minus /* 2131363910 */:
                if (!createCarromDialog.isCreateGem) {
                    return;
                }
                int i4 = createCarromDialog.mPosition;
                if (i4 <= 0) {
                    createCarromDialog.mPosition = 0;
                } else {
                    createCarromDialog.mPosition = i4 - 1;
                }
                createCarromDialog.checkDiamond();
                return;
            case R.id.two /* 2131365453 */:
                CreateSudData createSudData5 = createCarromDialog.createCarromData;
                if (createSudData5 != null) {
                    createSudData5.setMode(3);
                }
                CreateSudData createSudData6 = createCarromDialog.createCarromData;
                if (createSudData6 != null) {
                    createSudData6.setPiece(4);
                }
                TextView textView7 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).two;
                Intrinsics.checkNotNullExpressionValue(textView7, "two");
                TextView textView8 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).carrom;
                Intrinsics.checkNotNullExpressionValue(textView8, "carrom");
                TextView textView9 = ((DialogCreateCarromBinding) createCarromDialog.getBinding()).freestyle;
                Intrinsics.checkNotNullExpressionValue(textView9, "freestyle");
                createCarromDialog.checkSelectText(textView7, textView8, textView9);
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
    public final String getGameCode() {
        return this.gameCode;
    }

    @Nullable
    public final GameConfigLudo getGameConfig() {
        return this.gameConfig;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_create_carrom;
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
        ArrayList<Integer> diamond;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogCreateCarromBinding) getBinding()).setClick(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateCarromDialog.onInitialize$lambda$0(CreateCarromDialog.this, view);
            }
        });
        ConstraintLayout constraintLayout = ((DialogCreateCarromBinding) getBinding()).moneyLayout;
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
        TextView textView = ((DialogCreateCarromBinding) getBinding()).bet;
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
        boolean z3 = true;
        if (this.createCarromData == null) {
            this.createCarromData = new CreateSudData(18, 1, 0, 0, 0, 0, MeetingRoomManager.INSTANCE.getMGroupId(), null, UserProxyUtility.roomMicNumChange, null);
            this.isCreateGem = true;
            ((DialogCreateCarromBinding) getBinding()).createButton.setText(ResourcesKtxKt.getStringById(this, 2131952331));
        }
        CreateSudData createSudData = this.createCarromData;
        if (createSudData != null) {
            int mode = createSudData.getMode();
            if (mode != 1) {
                if (mode != 2) {
                    TextView textView2 = ((DialogCreateCarromBinding) getBinding()).two;
                    Intrinsics.checkNotNullExpressionValue(textView2, "two");
                    TextView textView3 = ((DialogCreateCarromBinding) getBinding()).carrom;
                    Intrinsics.checkNotNullExpressionValue(textView3, "carrom");
                    TextView textView4 = ((DialogCreateCarromBinding) getBinding()).freestyle;
                    Intrinsics.checkNotNullExpressionValue(textView4, "freestyle");
                    checkSelectText(textView2, textView3, textView4);
                } else {
                    TextView textView5 = ((DialogCreateCarromBinding) getBinding()).freestyle;
                    Intrinsics.checkNotNullExpressionValue(textView5, "freestyle");
                    TextView textView6 = ((DialogCreateCarromBinding) getBinding()).carrom;
                    Intrinsics.checkNotNullExpressionValue(textView6, "carrom");
                    TextView textView7 = ((DialogCreateCarromBinding) getBinding()).two;
                    Intrinsics.checkNotNullExpressionValue(textView7, "two");
                    checkSelectText(textView5, textView6, textView7);
                }
            } else {
                TextView textView8 = ((DialogCreateCarromBinding) getBinding()).carrom;
                Intrinsics.checkNotNullExpressionValue(textView8, "carrom");
                TextView textView9 = ((DialogCreateCarromBinding) getBinding()).freestyle;
                Intrinsics.checkNotNullExpressionValue(textView9, "freestyle");
                TextView textView10 = ((DialogCreateCarromBinding) getBinding()).two;
                Intrinsics.checkNotNullExpressionValue(textView10, "two");
                checkSelectText(textView8, textView9, textView10);
            }
            ImageView imageView = ((DialogCreateCarromBinding) getBinding()).autoMatch;
            if (createSudData.getAutoMatch() != 1) {
                z3 = false;
            }
            imageView.setSelected(z3);
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
    public CreateCarromDialog(@NotNull Context context, @Nullable CreateSudData createSudData, @Nullable String str, @Nullable GameConfigLudo gameConfigLudo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.createCarromData = createSudData;
        this.gameCode = str;
        this.gameConfig = gameConfigLudo;
        this.mPosition = 1;
        this.mCompositeDisposable = new nd.a();
    }
}

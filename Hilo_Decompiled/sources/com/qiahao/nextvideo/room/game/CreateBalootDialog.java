package com.qiahao.nextvideo.room.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.CreateSudData;
import com.qiahao.nextvideo.databinding.DialogCreateBalootBinding;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001eH\u0014¢\u0006\u0004\b!\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\"R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u0010 \"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R?\u0010@\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/qiahao/nextvideo/room/game/CreateBalootDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCreateBalootBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "createBalootData", "", "gameCode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "diamondList", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/game/CreateSudData;Ljava/lang/String;Ljava/util/ArrayList;)V", "", "confirmCreate", "()V", "Landroid/view/View;", "clickButton", "relevanceButton", "checkSelectButton", "(Landroid/view/View;Landroid/view/View;)V", "Landroid/widget/TextView;", "checkSelectText", "(Landroid/widget/TextView;Landroid/widget/TextView;)V", "checkDiamond", "getLayoutResId", "()I", "onInitialize", "", "isBottomStyle", "()Z", "isNeedFullScreen", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "Ljava/lang/String;", "getGameCode", "()Ljava/lang/String;", "setGameCode", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "getDiamondList", "()Ljava/util/ArrayList;", "setDiamondList", "(Ljava/util/ArrayList;)V", "mPosition", "I", "getMPosition", "setMPosition", "(I)V", "isCreateGem", "Z", "setCreateGem", "(Z)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createListener", "Lkotlin/jvm/functions/Function1;", "getCreateListener", "()Lkotlin/jvm/functions/Function1;", "setCreateListener", "(Lkotlin/jvm/functions/Function1;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCreateBalootDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateBalootDialog.kt\ncom/qiahao/nextvideo/room/game/CreateBalootDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n1878#2,3:173\n1#3:176\n*S KotlinDebug\n*F\n+ 1 CreateBalootDialog.kt\ncom/qiahao/nextvideo/room/game/CreateBalootDialog\n*L\n88#1:173,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CreateBalootDialog extends BaseBindingDialog<DialogCreateBalootBinding> {

    @Nullable
    private CreateSudData createBalootData;

    @Nullable
    private Function1<? super CreateSudData, Unit> createListener;

    @Nullable
    private ArrayList<Integer> diamondList;

    @Nullable
    private String gameCode;
    private boolean isCreateGem;

    @NotNull
    private nd.a mCompositeDisposable;
    private int mPosition;

    public /* synthetic */ CreateBalootDialog(Context context, CreateSudData createSudData, String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : createSudData, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : arrayList);
    }

    private final void checkDiamond() {
        int i;
        String str;
        String str2;
        String str3;
        Integer num;
        int i2 = this.mPosition;
        Integer valueOf = Integer.valueOf(R.drawable.ludo_create_add_default_icon);
        Integer valueOf2 = Integer.valueOf(R.drawable.ludo_create_minus_default_icon);
        if (i2 == 0) {
            ImageView imageView = ((DialogCreateBalootBinding) getBinding()).minus;
            Intrinsics.checkNotNullExpressionValue(imageView, "minus");
            str = "minus";
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            str2 = "add";
        } else {
            ArrayList<Integer> arrayList = this.diamondList;
            if (arrayList != null) {
                i = arrayList.size();
            } else {
                i = 0;
            }
            if (i2 != i - 1) {
                str = "minus";
                ImageView imageView2 = ((DialogCreateBalootBinding) getBinding()).minus;
                Intrinsics.checkNotNullExpressionValue(imageView2, str);
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_minus_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                ImageView imageView3 = ((DialogCreateBalootBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView3, "add");
                str2 = "add";
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_add_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                ImageView imageView4 = ((DialogCreateBalootBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView4, "add");
                str = "minus";
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                str2 = "add";
            }
        }
        if (!this.isCreateGem) {
            ImageView imageView5 = ((DialogCreateBalootBinding) getBinding()).minus;
            Intrinsics.checkNotNullExpressionValue(imageView5, str);
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView6 = ((DialogCreateBalootBinding) getBinding()).add;
            Intrinsics.checkNotNullExpressionValue(imageView6, str2);
            ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        TextView textView = ((DialogCreateBalootBinding) getBinding()).diamondText;
        ArrayList<Integer> arrayList2 = this.diamondList;
        if (arrayList2 == null || (num = arrayList2.get(this.mPosition)) == null || (str3 = num.toString()) == null) {
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

    static /* synthetic */ void checkSelectButton$default(CreateBalootDialog createBalootDialog, View view, View view2, int i, Object obj) {
        if ((i & 2) != 0) {
            view2 = null;
        }
        createBalootDialog.checkSelectButton(view, view2);
    }

    private final void checkSelectText(TextView clickButton, TextView relevanceButton) {
        clickButton.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.ballot_create_select));
        clickButton.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099850));
        relevanceButton.setBackground(androidx.core.content.a.getDrawable(clickButton.getContext(), R.drawable.ballot_create_unselect));
        relevanceButton.setTextColor(androidx.core.content.a.getColor(clickButton.getContext(), 2131099916));
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
        Integer num;
        if (((DialogCreateBalootBinding) getBinding()).autoMatch.isSelected()) {
            CreateSudData createSudData = this.createBalootData;
            if (createSudData != null) {
                createSudData.setAutoMatch(1);
            }
        } else {
            CreateSudData createSudData2 = this.createBalootData;
            if (createSudData2 != null) {
                createSudData2.setAutoMatch(0);
            }
        }
        CreateSudData createSudData3 = this.createBalootData;
        if (createSudData3 != null) {
            ArrayList<Integer> arrayList = this.diamondList;
            if (arrayList != null && (num = arrayList.get(this.mPosition)) != null) {
                i6 = num.intValue();
            } else {
                i6 = 0;
            }
            createSudData3.setDiamond(i6);
        }
        if (this.isCreateGem) {
            CreateSudData createSudData4 = this.createBalootData;
            if (createSudData4 != null && (function1 = this.createListener) != null) {
                function1.invoke(createSudData4);
                return;
            }
            return;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        CreateSudData createSudData5 = this.createBalootData;
        if (createSudData5 != null && (gameId = createSudData5.getGameId()) != null) {
            j = gameId.longValue();
        } else {
            j = 0;
        }
        CreateSudData createSudData6 = this.createBalootData;
        if (createSudData6 != null) {
            i = createSudData6.getMode();
        } else {
            i = 0;
        }
        CreateSudData createSudData7 = this.createBalootData;
        if (createSudData7 != null) {
            i2 = createSudData7.getPiece();
        } else {
            i2 = 0;
        }
        CreateSudData createSudData8 = this.createBalootData;
        if (createSudData8 != null) {
            i3 = createSudData8.getOnOff1();
        } else {
            i3 = 0;
        }
        CreateSudData createSudData9 = this.createBalootData;
        if (createSudData9 != null) {
            i4 = createSudData9.getDiamond();
        } else {
            i4 = 0;
        }
        CreateSudData createSudData10 = this.createBalootData;
        if (createSudData10 != null) {
            i5 = createSudData10.getAutoMatch();
        } else {
            i5 = 0;
        }
        String str = this.gameCode;
        if (str == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.editSud(j, i, i2, i3, i4, i5, str), new Function1() { // from class: com.qiahao.nextvideo.room.game.e
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$4;
                confirmCreate$lambda$4 = CreateBalootDialog.confirmCreate$lambda$4(CreateBalootDialog.this, (ApiResponse) obj);
                return confirmCreate$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.game.f
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$5;
                confirmCreate$lambda$5 = CreateBalootDialog.confirmCreate$lambda$5(CreateBalootDialog.this, (Throwable) obj);
                return confirmCreate$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmCreate$lambda$4(CreateBalootDialog createBalootDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        createBalootDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmCreate$lambda$5(CreateBalootDialog createBalootDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = createBalootDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(createBalootDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, createBalootDialog.getContext(), ResourcesKtxKt.getStringById(createBalootDialog, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(CreateBalootDialog createBalootDialog, View view) {
        int i;
        int i2 = 0;
        switch (view.getId()) {
            case 2131361922:
                if (!createBalootDialog.isCreateGem) {
                    return;
                }
                int i3 = createBalootDialog.mPosition;
                ArrayList<Integer> arrayList = createBalootDialog.diamondList;
                if (arrayList != null) {
                    i = arrayList.size();
                } else {
                    i = 0;
                }
                if (i3 >= i - 1) {
                    ArrayList<Integer> arrayList2 = createBalootDialog.diamondList;
                    if (arrayList2 != null) {
                        i2 = arrayList2.size();
                    }
                    createBalootDialog.mPosition = i2 - 1;
                } else {
                    createBalootDialog.mPosition++;
                }
                createBalootDialog.checkDiamond();
                return;
            case R.id.autoMatch /* 2131362008 */:
            case R.id.autoText /* 2131362009 */:
                ((DialogCreateBalootBinding) createBalootDialog.getBinding()).autoMatch.setSelected(!((DialogCreateBalootBinding) createBalootDialog.getBinding()).autoMatch.isSelected());
                return;
            case R.id.classic /* 2131362356 */:
                CreateSudData createSudData = createBalootDialog.createBalootData;
                if (createSudData != null) {
                    createSudData.setMode(2);
                }
                TextView textView = ((DialogCreateBalootBinding) createBalootDialog.getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView, "classic");
                TextView textView2 = ((DialogCreateBalootBinding) createBalootDialog.getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView2, FamilyMoreDialog.CLICK_QUICK);
                createBalootDialog.checkSelectText(textView, textView2);
                return;
            case R.id.close /* 2131362369 */:
            case R.id.rootLayout /* 2131364676 */:
                createBalootDialog.dismiss();
                return;
            case R.id.createButton /* 2131362560 */:
                createBalootDialog.confirmCreate();
                return;
            case R.id.minus /* 2131363910 */:
                if (!createBalootDialog.isCreateGem) {
                    return;
                }
                int i4 = createBalootDialog.mPosition;
                if (i4 <= 0) {
                    createBalootDialog.mPosition = 0;
                } else {
                    createBalootDialog.mPosition = i4 - 1;
                }
                createBalootDialog.checkDiamond();
                return;
            case R.id.quick /* 2131364409 */:
                CreateSudData createSudData2 = createBalootDialog.createBalootData;
                if (createSudData2 != null) {
                    createSudData2.setMode(1);
                }
                TextView textView3 = ((DialogCreateBalootBinding) createBalootDialog.getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView3, FamilyMoreDialog.CLICK_QUICK);
                TextView textView4 = ((DialogCreateBalootBinding) createBalootDialog.getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView4, "classic");
                createBalootDialog.checkSelectText(textView3, textView4);
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
    public final ArrayList<Integer> getDiamondList() {
        return this.diamondList;
    }

    @Nullable
    public final String getGameCode() {
        return this.gameCode;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_create_baloot;
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
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogCreateBalootBinding) getBinding()).setClick(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateBalootDialog.onInitialize$lambda$0(CreateBalootDialog.this, view);
            }
        });
        boolean z = true;
        if (this.createBalootData == null) {
            this.createBalootData = new CreateSudData(14, 1, 0, 0, 0, 0, MeetingRoomManager.INSTANCE.getMGroupId(), null, UserProxyUtility.roomMicNumChange, null);
            this.isCreateGem = true;
            ((DialogCreateBalootBinding) getBinding()).createButton.setText(ResourcesKtxKt.getStringById(this, 2131952331));
        }
        CreateSudData createSudData = this.createBalootData;
        if (createSudData != null) {
            if (createSudData.getMode() == 1) {
                TextView textView = ((DialogCreateBalootBinding) getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView, FamilyMoreDialog.CLICK_QUICK);
                TextView textView2 = ((DialogCreateBalootBinding) getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView2, "classic");
                checkSelectText(textView, textView2);
            } else {
                TextView textView3 = ((DialogCreateBalootBinding) getBinding()).classic;
                Intrinsics.checkNotNullExpressionValue(textView3, "classic");
                TextView textView4 = ((DialogCreateBalootBinding) getBinding()).quick;
                Intrinsics.checkNotNullExpressionValue(textView4, FamilyMoreDialog.CLICK_QUICK);
                checkSelectText(textView3, textView4);
            }
            ImageView imageView = ((DialogCreateBalootBinding) getBinding()).autoMatch;
            int i = 0;
            if (createSudData.getAutoMatch() != 1) {
                z = false;
            }
            imageView.setSelected(z);
            ArrayList<Integer> arrayList = this.diamondList;
            if (arrayList != null) {
                for (Object obj : arrayList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (((Number) obj).intValue() == createSudData.getDiamond()) {
                        this.mPosition = i;
                    }
                    i = i2;
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

    public final void setDiamondList(@Nullable ArrayList<Integer> arrayList) {
        this.diamondList = arrayList;
    }

    public final void setGameCode(@Nullable String str) {
        this.gameCode = str;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMPosition(int i) {
        this.mPosition = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateBalootDialog(@NotNull Context context, @Nullable CreateSudData createSudData, @Nullable String str, @Nullable ArrayList<Integer> arrayList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.createBalootData = createSudData;
        this.gameCode = str;
        this.diamondList = arrayList;
        this.mPosition = 1;
        this.mCompositeDisposable = new nd.a();
    }
}

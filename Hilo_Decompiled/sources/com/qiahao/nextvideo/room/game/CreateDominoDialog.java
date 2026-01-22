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
import com.qiahao.nextvideo.databinding.DialogCreateDominoBinding;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u0018R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u0010\u0018\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R?\u0010=\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u000f\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/qiahao/nextvideo/room/game/CreateDominoDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogCreateDominoBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "createDominoData", "", "gameCode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "diamondList", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/game/CreateSudData;Ljava/lang/String;Ljava/util/ArrayList;)V", "", "confirmCreate", "()V", "checkDiamond", "getLayoutResId", "()I", "onInitialize", "", "isBottomStyle", "()Z", "isNeedFullScreen", "Lcom/qiahao/nextvideo/data/game/CreateSudData;", "getCreateDominoData", "()Lcom/qiahao/nextvideo/data/game/CreateSudData;", "setCreateDominoData", "(Lcom/qiahao/nextvideo/data/game/CreateSudData;)V", "Ljava/lang/String;", "getGameCode", "()Ljava/lang/String;", "setGameCode", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "getDiamondList", "()Ljava/util/ArrayList;", "setDiamondList", "(Ljava/util/ArrayList;)V", "mPosition", "I", "getMPosition", "setMPosition", "(I)V", "isCreateGem", "Z", "setCreateGem", "(Z)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createLudoData", "createListener", "Lkotlin/jvm/functions/Function1;", "getCreateListener", "()Lkotlin/jvm/functions/Function1;", "setCreateListener", "(Lkotlin/jvm/functions/Function1;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCreateDominoDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateDominoDialog.kt\ncom/qiahao/nextvideo/room/game/CreateDominoDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,137:1\n1878#2,3:138\n1#3:141\n*S KotlinDebug\n*F\n+ 1 CreateDominoDialog.kt\ncom/qiahao/nextvideo/room/game/CreateDominoDialog\n*L\n73#1:138,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CreateDominoDialog extends BaseBindingDialog<DialogCreateDominoBinding> {

    @Nullable
    private CreateSudData createDominoData;

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

    public /* synthetic */ CreateDominoDialog(Context context, CreateSudData createSudData, String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
            ImageView imageView = ((DialogCreateDominoBinding) getBinding()).minus;
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
                ImageView imageView2 = ((DialogCreateDominoBinding) getBinding()).minus;
                Intrinsics.checkNotNullExpressionValue(imageView2, str);
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_minus_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                ImageView imageView3 = ((DialogCreateDominoBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView3, "add");
                str2 = "add";
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_create_add_icon), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                ImageView imageView4 = ((DialogCreateDominoBinding) getBinding()).add;
                Intrinsics.checkNotNullExpressionValue(imageView4, "add");
                str = "minus";
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                str2 = "add";
            }
        }
        if (!this.isCreateGem) {
            ImageView imageView5 = ((DialogCreateDominoBinding) getBinding()).minus;
            Intrinsics.checkNotNullExpressionValue(imageView5, str);
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, valueOf2, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView6 = ((DialogCreateDominoBinding) getBinding()).add;
            Intrinsics.checkNotNullExpressionValue(imageView6, str2);
            ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        TextView textView = ((DialogCreateDominoBinding) getBinding()).diamondText;
        ArrayList<Integer> arrayList2 = this.diamondList;
        if (arrayList2 == null || (num = arrayList2.get(this.mPosition)) == null || (str3 = num.toString()) == null) {
            str3 = "";
        }
        textView.setText(str3);
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
        if (((DialogCreateDominoBinding) getBinding()).autoMatch.isSelected()) {
            CreateSudData createSudData = this.createDominoData;
            if (createSudData != null) {
                createSudData.setAutoMatch(1);
            }
        } else {
            CreateSudData createSudData2 = this.createDominoData;
            if (createSudData2 != null) {
                createSudData2.setAutoMatch(0);
            }
        }
        CreateSudData createSudData3 = this.createDominoData;
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
            CreateSudData createSudData4 = this.createDominoData;
            if (createSudData4 != null && (function1 = this.createListener) != null) {
                function1.invoke(createSudData4);
                return;
            }
            return;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        CreateSudData createSudData5 = this.createDominoData;
        if (createSudData5 != null && (gameId = createSudData5.getGameId()) != null) {
            j = gameId.longValue();
        } else {
            j = 0;
        }
        CreateSudData createSudData6 = this.createDominoData;
        if (createSudData6 != null) {
            i = createSudData6.getMode();
        } else {
            i = 0;
        }
        CreateSudData createSudData7 = this.createDominoData;
        if (createSudData7 != null) {
            i2 = createSudData7.getPiece();
        } else {
            i2 = 0;
        }
        CreateSudData createSudData8 = this.createDominoData;
        if (createSudData8 != null) {
            i3 = createSudData8.getOnOff1();
        } else {
            i3 = 0;
        }
        CreateSudData createSudData9 = this.createDominoData;
        if (createSudData9 != null) {
            i4 = createSudData9.getDiamond();
        } else {
            i4 = 0;
        }
        CreateSudData createSudData10 = this.createDominoData;
        if (createSudData10 != null) {
            i5 = createSudData10.getAutoMatch();
        } else {
            i5 = 0;
        }
        String str = this.gameCode;
        if (str == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.editSud(j, i, i2, i3, i4, i5, str), new Function1() { // from class: com.qiahao.nextvideo.room.game.m
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$4;
                confirmCreate$lambda$4 = CreateDominoDialog.confirmCreate$lambda$4(CreateDominoDialog.this, (ApiResponse) obj);
                return confirmCreate$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.game.n
            public final Object invoke(Object obj) {
                Unit confirmCreate$lambda$5;
                confirmCreate$lambda$5 = CreateDominoDialog.confirmCreate$lambda$5(CreateDominoDialog.this, (Throwable) obj);
                return confirmCreate$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmCreate$lambda$4(CreateDominoDialog createDominoDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        createDominoDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirmCreate$lambda$5(CreateDominoDialog createDominoDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = createDominoDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(createDominoDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, createDominoDialog.getContext(), ResourcesKtxKt.getStringById(createDominoDialog, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(CreateDominoDialog createDominoDialog, View view) {
        int i;
        int i2 = 0;
        switch (view.getId()) {
            case 2131361922:
                if (!createDominoDialog.isCreateGem) {
                    return;
                }
                int i3 = createDominoDialog.mPosition;
                ArrayList<Integer> arrayList = createDominoDialog.diamondList;
                if (arrayList != null) {
                    i = arrayList.size();
                } else {
                    i = 0;
                }
                if (i3 >= i - 1) {
                    ArrayList<Integer> arrayList2 = createDominoDialog.diamondList;
                    if (arrayList2 != null) {
                        i2 = arrayList2.size();
                    }
                    createDominoDialog.mPosition = i2 - 1;
                } else {
                    createDominoDialog.mPosition++;
                }
                createDominoDialog.checkDiamond();
                return;
            case R.id.autoMatch /* 2131362008 */:
            case R.id.autoText /* 2131362009 */:
                ((DialogCreateDominoBinding) createDominoDialog.getBinding()).autoMatch.setSelected(!((DialogCreateDominoBinding) createDominoDialog.getBinding()).autoMatch.isSelected());
                return;
            case R.id.close /* 2131362369 */:
            case R.id.rootLayout /* 2131364676 */:
                createDominoDialog.dismiss();
                return;
            case R.id.createButton /* 2131362560 */:
                createDominoDialog.confirmCreate();
                return;
            case R.id.minus /* 2131363910 */:
                if (!createDominoDialog.isCreateGem) {
                    return;
                }
                int i4 = createDominoDialog.mPosition;
                if (i4 <= 0) {
                    createDominoDialog.mPosition = 0;
                } else {
                    createDominoDialog.mPosition = i4 - 1;
                }
                createDominoDialog.checkDiamond();
                return;
            default:
                return;
        }
    }

    @Nullable
    public final CreateSudData getCreateDominoData() {
        return this.createDominoData;
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
        return R.layout.dialog_create_domino;
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
        ((DialogCreateDominoBinding) getBinding()).setClick(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.game.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateDominoDialog.onInitialize$lambda$0(CreateDominoDialog.this, view);
            }
        });
        boolean z = true;
        if (this.createDominoData == null) {
            this.createDominoData = new CreateSudData(10, 0, 0, 0, 0, 0, MeetingRoomManager.INSTANCE.getMGroupId(), null, UserProxyUtility.roomLeave, null);
            this.isCreateGem = true;
            ((DialogCreateDominoBinding) getBinding()).createButton.setText(ResourcesKtxKt.getStringById(this, 2131952331));
        }
        CreateSudData createSudData = this.createDominoData;
        if (createSudData != null) {
            ImageView imageView = ((DialogCreateDominoBinding) getBinding()).autoMatch;
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

    public final void setCreateDominoData(@Nullable CreateSudData createSudData) {
        this.createDominoData = createSudData;
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
    public CreateDominoDialog(@NotNull Context context, @Nullable CreateSudData createSudData, @Nullable String str, @Nullable ArrayList<Integer> arrayList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.createDominoData = createSudData;
        this.gameCode = str;
        this.diamondList = arrayList;
        this.mPosition = 1;
        this.mCompositeDisposable = new nd.a();
    }
}

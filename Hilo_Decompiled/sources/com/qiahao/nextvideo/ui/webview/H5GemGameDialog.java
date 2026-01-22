package com.qiahao.nextvideo.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.GemGameRank;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GemGameData;
import com.qiahao.nextvideo.databinding.DialogH5GemGameBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.gem.GemStoreDialog;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.webview.JsInterfaceListener;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\fJ\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010\u0014R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010 R\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z¨\u0006\\"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/H5GemGameDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogH5GemGameBinding;", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "Landroid/content/Context;", "context", "", GameMatchActivity.GAME_ID, "<init>", "(Landroid/content/Context;I)V", "", "initWebView", "()V", "clickH5Url", "gemGameData", "gemGameRank", "(I)V", "refreshTopView", "refreshRank", "getLayoutResId", "()I", "", "isBottomStyle", "()Z", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "", "groupId", "openGroupPager", "(Ljava/lang/String;)V", SupportGiftRankActivity.EXTERNAL_ID, "openPersonPage", "onBackPressed", "dismiss", "I", "getGameId", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/JsInterface;)V", "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/data/model/GemGameData;", "gemData", "Lcom/qiahao/nextvideo/data/model/GemGameData;", "getGemData", "()Lcom/qiahao/nextvideo/data/model/GemGameData;", "setGemData", "(Lcom/qiahao/nextvideo/data/model/GemGameData;)V", "Lcom/qiahao/nextvideo/data/game/GemGameRank;", "rankData", "Lcom/qiahao/nextvideo/data/game/GemGameRank;", "getRankData", "()Lcom/qiahao/nextvideo/data/game/GemGameRank;", "setRankData", "(Lcom/qiahao/nextvideo/data/game/GemGameRank;)V", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "selectGame", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "getSelectGame", "()Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "setSelectGame", "(Lcom/qiahao/nextvideo/data/model/GameConfiguration;)V", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "Lcom/qiahao/nextvideo/ui/webview/GemGameAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/webview/GemGameAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nH5GemGameDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5GemGameDialog.kt\ncom/qiahao/nextvideo/ui/webview/H5GemGameDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,356:1\n61#2,9:357\n61#2,9:366\n61#2,9:375\n61#2,9:384\n61#2,9:393\n61#2,9:402\n1878#3,3:411\n*S KotlinDebug\n*F\n+ 1 H5GemGameDialog.kt\ncom/qiahao/nextvideo/ui/webview/H5GemGameDialog\n*L\n109#1:357,9\n122#1:366,9\n131#1:375,9\n135#1:384,9\n139#1:393,9\n143#1:402,9\n271#1:411,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class H5GemGameDialog extends BaseBindingDialog<DialogH5GemGameBinding> implements JsInterfaceListener {
    private final int gameId;

    @Nullable
    private GemGameData gemData;
    public JsInterface jsInterface;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;
    public WebChromeClient mWebChromeClient;

    @Nullable
    private GemGameRank rankData;

    @Nullable
    private GameConfiguration selectGame;

    @NotNull
    private String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5GemGameDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gameId = i;
        this.mCompositeDisposable = new nd.a();
        this.url = "";
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.webview.q
            public final Object invoke() {
                GemGameAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = H5GemGameDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    public static final /* synthetic */ DialogH5GemGameBinding access$getBinding(H5GemGameDialog h5GemGameDialog) {
        return (DialogH5GemGameBinding) h5GemGameDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickH5Url() {
        String str;
        String str2;
        GemGameRank gemGameRank = this.rankData;
        if (gemGameRank != null) {
            str = gemGameRank.getH5Url();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            getMAdapter().setMSelectPosition(-1);
            getMAdapter().notifyDataSetChanged();
            NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
            GemGameRank gemGameRank2 = this.rankData;
            if (gemGameRank2 == null || (str2 = gemGameRank2.getH5Url()) == null) {
                str2 = "";
            }
            this.url = navigationHelper.addUserStatus(str2);
            ((DialogH5GemGameBinding) getBinding()).webView.loadUrl(this.url);
        }
    }

    private final void gemGameData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().gemGameData(), new Function1() { // from class: com.qiahao.nextvideo.ui.webview.u
            public final Object invoke(Object obj) {
                Unit gemGameData$lambda$14;
                gemGameData$lambda$14 = H5GemGameDialog.gemGameData$lambda$14(H5GemGameDialog.this, (ApiResponse) obj);
                return gemGameData$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.webview.v
            public final Object invoke(Object obj) {
                Unit gemGameData$lambda$15;
                gemGameData$lambda$15 = H5GemGameDialog.gemGameData$lambda$15((Throwable) obj);
                return gemGameData$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gemGameData$lambda$14(H5GemGameDialog h5GemGameDialog, ApiResponse apiResponse) {
        Integer gameId;
        int i;
        GameConfiguration gameConfiguration;
        ArrayList<GameConfiguration> games;
        ArrayList<GameConfiguration> games2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GemGameData gemGameData = (GemGameData) apiResponse.getData();
        if (gemGameData != null) {
            h5GemGameDialog.gemData = gemGameData;
            ArrayList<GameConfiguration> games3 = gemGameData.getGames();
            int i2 = 0;
            if (games3 != null) {
                int i3 = 0;
                for (Object obj : games3) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    GameConfiguration gameConfiguration2 = (GameConfiguration) obj;
                    Integer gameId2 = gameConfiguration2.getGameId();
                    int i5 = h5GemGameDialog.gameId;
                    if (gameId2 != null && gameId2.intValue() == i5) {
                        h5GemGameDialog.getMAdapter().setMSelectPosition(i3);
                        h5GemGameDialog.selectGame = gameConfiguration2;
                    }
                    i3 = i4;
                }
            }
            ArrayList<GameConfiguration> arrayList = null;
            if (h5GemGameDialog.selectGame == null) {
                GemGameData gemGameData2 = h5GemGameDialog.gemData;
                if (gemGameData2 != null && (games2 = gemGameData2.getGames()) != null) {
                    i = games2.size();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    h5GemGameDialog.getMAdapter().setMSelectPosition(0);
                    GemGameData gemGameData3 = h5GemGameDialog.gemData;
                    if (gemGameData3 != null && (games = gemGameData3.getGames()) != null) {
                        gameConfiguration = games.get(0);
                    } else {
                        gameConfiguration = null;
                    }
                    h5GemGameDialog.selectGame = gameConfiguration;
                }
            }
            GemGameAdapter mAdapter = h5GemGameDialog.getMAdapter();
            GemGameData gemGameData4 = h5GemGameDialog.gemData;
            if (gemGameData4 != null) {
                arrayList = gemGameData4.getGames();
            }
            mAdapter.setList(arrayList);
            GameConfiguration gameConfiguration3 = h5GemGameDialog.selectGame;
            if (gameConfiguration3 != null && (gameId = gameConfiguration3.getGameId()) != null) {
                i2 = gameId.intValue();
            }
            h5GemGameDialog.gemGameRank(i2);
            h5GemGameDialog.refreshTopView();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gemGameData$lambda$15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void gemGameRank(int gameId) {
        if (gameId == 0) {
            return;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().gemGameRank(gameId), new Function1() { // from class: com.qiahao.nextvideo.ui.webview.s
            public final Object invoke(Object obj) {
                Unit gemGameRank$lambda$17;
                gemGameRank$lambda$17 = H5GemGameDialog.gemGameRank$lambda$17(H5GemGameDialog.this, (ApiResponse) obj);
                return gemGameRank$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.webview.t
            public final Object invoke(Object obj) {
                Unit gemGameRank$lambda$18;
                gemGameRank$lambda$18 = H5GemGameDialog.gemGameRank$lambda$18((Throwable) obj);
                return gemGameRank$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gemGameRank$lambda$17(H5GemGameDialog h5GemGameDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GemGameRank gemGameRank = (GemGameRank) apiResponse.getData();
        if (gemGameRank != null) {
            h5GemGameDialog.rankData = gemGameRank;
            h5GemGameDialog.refreshRank();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gemGameRank$lambda$18(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GemGameAdapter getMAdapter() {
        return (GemGameAdapter) this.mAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private final void initWebView() {
        setBackgroundDimEnabled(false);
        UserStore.Companion companion = UserStore.INSTANCE;
        nd.c subscribe = companion.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$1
            public final void accept(UserObjectEvent userObjectEvent) {
                Double pinkDiamondNum;
                if (userObjectEvent != null) {
                    H5GemGameDialog h5GemGameDialog = H5GemGameDialog.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        TextView textView = H5GemGameDialog.access$getBinding(h5GemGameDialog).diamondText;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        textView.setText(String.valueOf((user == null || (pinkDiamondNum = user.getPinkDiamondNum()) == null) ? null : Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()))));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.mCompositeDisposable);
        ((DialogH5GemGameBinding) getBinding()).bg.setBackgroundColor(Color.parseColor("#0d1843"));
        ((DialogH5GemGameBinding) getBinding()).topBg.setBackground(ShapeUtil.INSTANCE.createShapeTop("#0d1843", 14));
        nd.c subscribe2 = companion.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$2
            public final void accept(UserObjectEvent userObjectEvent) {
                Double pinkDiamondNum;
                if (userObjectEvent != null) {
                    H5GemGameDialog h5GemGameDialog = H5GemGameDialog.this;
                    if (userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY) {
                        TextView textView = H5GemGameDialog.access$getBinding(h5GemGameDialog).diamondText;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        textView.setText(String.valueOf((user == null || (pinkDiamondNum = user.getPinkDiamondNum()) == null) ? null : Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()))));
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.mCompositeDisposable);
        final ImageView imageView = ((DialogH5GemGameBinding) getBinding()).activity;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GemGameAdapter mAdapter;
                GemGameAdapter mAdapter2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    mAdapter = this.getMAdapter();
                    mAdapter.setMSelectPosition(-1);
                    mAdapter2 = this.getMAdapter();
                    mAdapter2.notifyDataSetChanged();
                    H5GemGameDialog h5GemGameDialog = this;
                    NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                    GemGameData gemData = h5GemGameDialog.getGemData();
                    if (gemData == null || (str = gemData.getH5Url()) == null) {
                        str = "";
                    }
                    h5GemGameDialog.setUrl(navigationHelper.addUserStatus(str));
                    H5GemGameDialog.access$getBinding(this).webView.loadUrl(this.getUrl());
                }
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.webview.r
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                H5GemGameDialog.initWebView$lambda$2(H5GemGameDialog.this, baseQuickAdapter, view, i);
            }
        });
        final ConstraintLayout constraintLayout = ((DialogH5GemGameBinding) getBinding()).moneyLayout;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    BaseActivity activity = HiloUtils.INSTANCE.getActivity(this.getContext());
                    if (activity != null) {
                        new GemStoreDialog().show(activity.getSupportFragmentManager(), "other");
                    }
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView = ((DialogH5GemGameBinding) getBinding()).rank;
        qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView2 = qMUIRadiusImageView;
                    this.clickH5Url();
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogH5GemGameBinding) getBinding()).avatar1;
        qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView2;
                    this.clickH5Url();
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView3 = ((DialogH5GemGameBinding) getBinding()).avatar2;
        qMUIRadiusImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView3) > j || (qMUIRadiusImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView3, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView4 = qMUIRadiusImageView3;
                    this.clickH5Url();
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView4 = ((DialogH5GemGameBinding) getBinding()).avatar3;
        qMUIRadiusImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView4) > j || (qMUIRadiusImageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView4, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView5 = qMUIRadiusImageView4;
                    this.clickH5Url();
                }
            }
        });
        ((DialogH5GemGameBinding) getBinding()).recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$10
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                int childLayoutPosition = parent.getChildLayoutPosition(view);
                int itemCount = state.getItemCount() - 1;
                if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                    outRect.right = UiKtxKt.toPX(10);
                    if (childLayoutPosition == itemCount) {
                        outRect.left = UiKtxKt.toPX(70);
                        return;
                    }
                    return;
                }
                outRect.left = UiKtxKt.toPX(10);
                if (childLayoutPosition == itemCount) {
                    outRect.right = UiKtxKt.toPX(70);
                }
            }
        });
        ((DialogH5GemGameBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        WebSettings settings = ((DialogH5GemGameBinding) getBinding()).webView.getSettings();
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setDatabaseEnabled(true);
        settings.setMixedContentMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        ((DialogH5GemGameBinding) getBinding()).webView.setBackgroundColor(0);
        ((DialogH5GemGameBinding) getBinding()).webView.getBackground().setAlpha(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebView webView = ((DialogH5GemGameBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        JsInterface jsInterface = new JsInterface(context, webView);
        jsInterface.setListener(this);
        setJsInterface(jsInterface);
        ((DialogH5GemGameBinding) getBinding()).webView.addJavascriptInterface(getJsInterface(), "androidJsObject");
        ((DialogH5GemGameBinding) getBinding()).webView.setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$13
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.H5GemGameDialog$initWebView$14
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };
        ((DialogH5GemGameBinding) getBinding()).webView.setWebChromeClient(webChromeClient);
        setMWebChromeClient(webChromeClient);
        gemGameData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWebView$lambda$2(H5GemGameDialog h5GemGameDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GameConfiguration gameConfiguration = (GameConfiguration) h5GemGameDialog.getMAdapter().getData().get(i);
        h5GemGameDialog.getMAdapter().setMSelectPosition(i);
        h5GemGameDialog.getMAdapter().notifyDataSetChanged();
        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
        String url = gameConfiguration.getUrl();
        if (url == null) {
            url = "";
        }
        h5GemGameDialog.url = navigationHelper.addUserStatus(url);
        ((DialogH5GemGameBinding) h5GemGameDialog.getBinding()).webView.loadUrl(h5GemGameDialog.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GemGameAdapter mAdapter_delegate$lambda$0() {
        return new GemGameAdapter();
    }

    private final void refreshRank() {
        int i;
        int i2;
        int i3;
        ArrayList<User> rank;
        User user;
        ArrayList<User> rank2;
        String str;
        ArrayList<User> rank3;
        User user2;
        ArrayList<User> rank4;
        String str2;
        ArrayList<User> rank5;
        User user3;
        ArrayList<User> rank6;
        GemGameRank gemGameRank = this.rankData;
        if (gemGameRank != null && (rank6 = gemGameRank.getRank()) != null) {
            i = rank6.size();
        } else {
            i = 0;
        }
        String str3 = null;
        if (i >= 1) {
            QMUIRadiusImageView qMUIRadiusImageView = ((DialogH5GemGameBinding) getBinding()).avatar1;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar1");
            GemGameRank gemGameRank2 = this.rankData;
            if (gemGameRank2 != null && (rank5 = gemGameRank2.getRank()) != null && (user3 = rank5.get(0)) != null) {
                str2 = user3.getAvatar();
            } else {
                str2 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            ((DialogH5GemGameBinding) getBinding()).avatar1.setVisibility(0);
        } else {
            ((DialogH5GemGameBinding) getBinding()).avatar1.setVisibility(8);
        }
        GemGameRank gemGameRank3 = this.rankData;
        if (gemGameRank3 != null && (rank4 = gemGameRank3.getRank()) != null) {
            i2 = rank4.size();
        } else {
            i2 = 0;
        }
        if (i2 >= 2) {
            QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogH5GemGameBinding) getBinding()).avatar2;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatar2");
            GemGameRank gemGameRank4 = this.rankData;
            if (gemGameRank4 != null && (rank3 = gemGameRank4.getRank()) != null && (user2 = rank3.get(1)) != null) {
                str = user2.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            ((DialogH5GemGameBinding) getBinding()).avatar2.setVisibility(0);
        } else {
            ((DialogH5GemGameBinding) getBinding()).avatar2.setVisibility(8);
        }
        GemGameRank gemGameRank5 = this.rankData;
        if (gemGameRank5 != null && (rank2 = gemGameRank5.getRank()) != null) {
            i3 = rank2.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 3) {
            QMUIRadiusImageView qMUIRadiusImageView3 = ((DialogH5GemGameBinding) getBinding()).avatar3;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "avatar3");
            GemGameRank gemGameRank6 = this.rankData;
            if (gemGameRank6 != null && (rank = gemGameRank6.getRank()) != null && (user = rank.get(2)) != null) {
                str3 = user.getAvatar();
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(str3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            ((DialogH5GemGameBinding) getBinding()).avatar3.setVisibility(0);
            return;
        }
        ((DialogH5GemGameBinding) getBinding()).avatar3.setVisibility(8);
    }

    private final void refreshTopView() {
        String str;
        Long l;
        String str2;
        Double pinkDiamondNum;
        GemGameData gemGameData = this.gemData;
        Double d = null;
        if (gemGameData != null) {
            str = gemGameData.getH5Url();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            ((DialogH5GemGameBinding) getBinding()).activity.setVisibility(0);
        } else {
            ((DialogH5GemGameBinding) getBinding()).activity.setVisibility(8);
        }
        TextView textView = ((DialogH5GemGameBinding) getBinding()).diamondText;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (pinkDiamondNum = user.getPinkDiamondNum()) != null) {
            l = Long.valueOf(MathKt.roundToLong(pinkDiamondNum.doubleValue()));
        } else {
            l = null;
        }
        textView.setText(String.valueOf(l));
        ViewGroup.LayoutParams layoutParams = ((DialogH5GemGameBinding) getBinding()).webView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        GameConfiguration gameConfiguration = this.selectGame;
        if (gameConfiguration != null) {
            d = gameConfiguration.getRate();
        }
        ((ConstraintLayout.b) layoutParams2).I = "1:" + d;
        ((DialogH5GemGameBinding) getBinding()).webView.setLayoutParams(layoutParams2);
        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
        GameConfiguration gameConfiguration2 = this.selectGame;
        if (gameConfiguration2 == null || (str2 = gameConfiguration2.getUrl()) == null) {
            str2 = "";
        }
        this.url = navigationHelper.addUserStatus(str2);
        ((DialogH5GemGameBinding) getBinding()).webView.loadUrl(this.url);
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
        cf.c.c().r(this);
        ((DialogH5GemGameBinding) getBinding()).webView.destroy();
    }

    public final int getGameId() {
        return this.gameId;
    }

    @Nullable
    public final GemGameData getGemData() {
        return this.gemData;
    }

    @NotNull
    public final JsInterface getJsInterface() {
        JsInterface jsInterface = this.jsInterface;
        if (jsInterface != null) {
            return jsInterface;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        return null;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_h5_gem_game;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final WebChromeClient getMWebChromeClient() {
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            return webChromeClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWebChromeClient");
        return null;
    }

    @Nullable
    public final GemGameRank getRankData() {
        return this.rankData;
    }

    @Nullable
    public final GameConfiguration getSelectGame() {
        return this.selectGame;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        super/*android.app.Dialog*/.onBackPressed();
        if (((DialogH5GemGameBinding) getBinding()).webView.canGoBack()) {
            ((DialogH5GemGameBinding) getBinding()).webView.goBack();
        } else {
            dismiss();
        }
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        cf.c.c().p(this);
        initWebView();
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void onProgressChanged(int i) {
        JsInterfaceListener.DefaultImpls.onProgressChanged(this, i);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void onReceivedTitle(@Nullable String str) {
        JsInterfaceListener.DefaultImpls.onReceivedTitle(this, str);
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "refresh_h5")) {
            ((DialogH5GemGameBinding) getBinding()).webView.loadUrl(this.url);
        }
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openGroupPager(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        JsInterfaceListener.DefaultImpls.openGroupPager(this, groupId);
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupId, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        }
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openGroupSupport() {
        JsInterfaceListener.DefaultImpls.openGroupSupport(this);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openPersonPage(@NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, externalId, false, 2, null);
    }

    public final void setGemData(@Nullable GemGameData gemGameData) {
        this.gemData = gemGameData;
    }

    public final void setJsInterface(@NotNull JsInterface jsInterface) {
        Intrinsics.checkNotNullParameter(jsInterface, "<set-?>");
        this.jsInterface = jsInterface;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMWebChromeClient(@NotNull WebChromeClient webChromeClient) {
        Intrinsics.checkNotNullParameter(webChromeClient, "<set-?>");
        this.mWebChromeClient = webChromeClient;
    }

    public final void setRankData(@Nullable GemGameRank gemGameRank) {
        this.rankData = gemGameRank;
    }

    public final void setSelectGame(@Nullable GameConfiguration gameConfiguration) {
        this.selectGame = gameConfiguration;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}

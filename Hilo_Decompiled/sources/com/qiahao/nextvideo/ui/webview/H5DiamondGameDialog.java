package com.qiahao.nextvideo.ui.webview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.DialogH5DiamondGameBinding;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.ui.webview.JsInterfaceListener;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u0013R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R6\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u000105j\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`68\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u0011R\"\u0010C\u001a\u00020B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/H5DiamondGameDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogH5DiamondGameBinding;", "Lcom/qiahao/nextvideo/ui/webview/JsInterfaceListener;", "Landroid/content/Context;", "context", "", GameMatchActivity.GAME_ID, "<init>", "(Landroid/content/Context;I)V", "", "initWebView", "()V", "gemGameData", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "gameConfiguration", "loadGame", "(Lcom/qiahao/nextvideo/data/model/GameConfiguration;)V", "getLayoutResId", "()I", "", "isBottomStyle", "()Z", "onInitialize", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "onBackPressed", "dismiss", "I", "getGameId", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "jsInterface", "Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "getJsInterface", "()Lcom/qiahao/nextvideo/ui/webview/JsInterface;", "setJsInterface", "(Lcom/qiahao/nextvideo/ui/webview/JsInterface;)V", "Landroid/webkit/WebChromeClient;", "mWebChromeClient", "Landroid/webkit/WebChromeClient;", "getMWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setMWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "gemData", "Ljava/util/ArrayList;", "getGemData", "()Ljava/util/ArrayList;", "setGemData", "(Ljava/util/ArrayList;)V", "selectGame", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "getSelectGame", "()Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "setSelectGame", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "Lcom/qiahao/nextvideo/ui/webview/GemGameAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/webview/GemGameAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nH5DiamondGameDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5DiamondGameDialog.kt\ncom/qiahao/nextvideo/ui/webview/H5DiamondGameDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,229:1\n1878#2,3:230\n*S KotlinDebug\n*F\n+ 1 H5DiamondGameDialog.kt\ncom/qiahao/nextvideo/ui/webview/H5DiamondGameDialog\n*L\n177#1:230,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class H5DiamondGameDialog extends BaseBindingDialog<DialogH5DiamondGameBinding> implements JsInterfaceListener {
    private final int gameId;

    @Nullable
    private ArrayList<GameConfiguration> gemData;
    public JsInterface jsInterface;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;
    public WebChromeClient mWebChromeClient;

    @Nullable
    private GameConfiguration selectGame;

    @NotNull
    private String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H5DiamondGameDialog(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gameId = i;
        this.mCompositeDisposable = new nd.a();
        this.url = "";
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.webview.o
            public final Object invoke() {
                GemGameAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = H5DiamondGameDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        r3 = com.oudi.utils.store.MMKVStore.INSTANCE;
        r0 = r9.selectGame;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
    
        if (r0 == null) goto L٤٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ad, code lost:
    
        r5 = r0.getGameId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b4, code lost:
    
        com.oudi.utils.store.IStore.DefaultImpls.setValue$default(r3, "LAST_DIAMOND_GAME", r5, (java.lang.String) null, 4, (java.lang.Object) null);
        r0 = cf.c.c();
        r4 = r9.selectGame;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
    
        if (r4 == null) goto L٥٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c6, code lost:
    
        r2 = r4.getGameId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ca, code lost:
    
        r0.l(new com.qiahao.base_common.model.eventBus.LiveEvent("REFRESH_DIAMOND_GAME_ICON", r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b3, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void gemGameData() {
        Integer num;
        Integer gameId;
        int i;
        GameConfiguration gameConfiguration;
        try {
            ArrayList<GameConfiguration> arrayList = (ArrayList) BaseApplication.Companion.getGSON().k((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "DIAMOND_GAME_LIST", "", (String) null, 4, (Object) null), new TypeToken<ArrayList<GameConfiguration>>() { // from class: com.qiahao.nextvideo.ui.webview.H5DiamondGameDialog$gemGameData$type$1
            }.getType());
            if (arrayList != null) {
                this.gemData = arrayList;
                boolean z = false;
                int i2 = 0;
                for (Object obj : arrayList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    GameConfiguration gameConfiguration2 = (GameConfiguration) obj;
                    Integer gameId2 = gameConfiguration2.getGameId();
                    int i4 = this.gameId;
                    if (gameId2 != null && gameId2.intValue() == i4) {
                        getMAdapter().setMSelectPosition(i2);
                        this.selectGame = gameConfiguration2;
                    }
                    i2 = i3;
                }
                Integer num2 = null;
                if (this.selectGame == null) {
                    ArrayList<GameConfiguration> arrayList2 = this.gemData;
                    if (arrayList2 != null) {
                        i = arrayList2.size();
                    } else {
                        i = 0;
                    }
                    if (i > 0) {
                        getMAdapter().setMSelectPosition(0);
                        ArrayList<GameConfiguration> arrayList3 = this.gemData;
                        if (arrayList3 != null) {
                            gameConfiguration = arrayList3.get(0);
                        } else {
                            gameConfiguration = null;
                        }
                        this.selectGame = gameConfiguration;
                    }
                }
                GameConfiguration gameConfiguration3 = this.selectGame;
                if (gameConfiguration3 != null) {
                    num = gameConfiguration3.getGameId();
                } else {
                    num = null;
                }
                if (num != null) {
                    GameConfiguration gameConfiguration4 = this.selectGame;
                    if (gameConfiguration4 != null && (gameId = gameConfiguration4.getGameId()) != null && gameId.intValue() == 0) {
                        z = true;
                    }
                }
                loadGame(this.selectGame);
                getMAdapter().setList(this.gemData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final GemGameAdapter getMAdapter() {
        return (GemGameAdapter) this.mAdapter.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initWebView() {
        setBackgroundDimEnabled(false);
        ((DialogH5DiamondGameBinding) getBinding()).bg.setBackgroundColor(Color.parseColor("#0D1843"));
        ((DialogH5DiamondGameBinding) getBinding()).topBg.setBackground(ShapeUtil.INSTANCE.createShapeTop("#0D1843", 14));
        ((DialogH5DiamondGameBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.webview.n
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                H5DiamondGameDialog.initWebView$lambda$1(H5DiamondGameDialog.this, baseQuickAdapter, view, i);
            }
        });
        ((DialogH5DiamondGameBinding) getBinding()).recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.webview.H5DiamondGameDialog$initWebView$2
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
                        outRect.left = UiKtxKt.toPX(10);
                        return;
                    }
                    return;
                }
                outRect.left = UiKtxKt.toPX(10);
                if (childLayoutPosition == itemCount) {
                    outRect.right = UiKtxKt.toPX(10);
                }
            }
        });
        WebSettings settings = ((DialogH5DiamondGameBinding) getBinding()).webView.getSettings();
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
        ((DialogH5DiamondGameBinding) getBinding()).webView.setBackgroundColor(0);
        ((DialogH5DiamondGameBinding) getBinding()).webView.getBackground().setAlpha(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        WebView webView = ((DialogH5DiamondGameBinding) getBinding()).webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        JsInterface jsInterface = new JsInterface(context, webView);
        jsInterface.setListener(this);
        setJsInterface(jsInterface);
        ((DialogH5DiamondGameBinding) getBinding()).webView.addJavascriptInterface(getJsInterface(), "androidJsObject");
        ((DialogH5DiamondGameBinding) getBinding()).webView.setWebViewClient(new WebViewClient() { // from class: com.qiahao.nextvideo.ui.webview.H5DiamondGameDialog$initWebView$5
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
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.qiahao.nextvideo.ui.webview.H5DiamondGameDialog$initWebView$6
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        };
        ((DialogH5DiamondGameBinding) getBinding()).webView.setWebChromeClient(webChromeClient);
        setMWebChromeClient(webChromeClient);
        gemGameData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWebView$lambda$1(H5DiamondGameDialog h5DiamondGameDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Integer gameId;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GameConfiguration gameConfiguration = (GameConfiguration) h5DiamondGameDialog.getMAdapter().getData().get(i);
        if (gameConfiguration.getGameId() != null && ((gameId = gameConfiguration.getGameId()) == null || gameId.intValue() != 0)) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "LAST_DIAMOND_GAME", gameConfiguration.getGameId(), (String) null, 4, (Object) null);
            cf.c.c().l(new LiveEvent("REFRESH_DIAMOND_GAME_ICON", gameConfiguration.getGameId()));
        }
        h5DiamondGameDialog.getMAdapter().setMSelectPosition(i);
        h5DiamondGameDialog.getMAdapter().notifyDataSetChanged();
        h5DiamondGameDialog.loadGame(gameConfiguration);
    }

    private final void loadGame(GameConfiguration gameConfiguration) {
        Object obj;
        String str;
        ViewGroup.LayoutParams layoutParams = ((DialogH5DiamondGameBinding) getBinding()).webView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
        if (gameConfiguration == null || (obj = gameConfiguration.getRate()) == null) {
            obj = 1;
        }
        ((ConstraintLayout.b) layoutParams2).I = "1:" + obj;
        ((DialogH5DiamondGameBinding) getBinding()).webView.setLayoutParams(layoutParams2);
        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
        if (gameConfiguration == null || (str = gameConfiguration.getUrl()) == null) {
            str = "";
        }
        this.url = navigationHelper.addUserStatus(str);
        ((DialogH5DiamondGameBinding) getBinding()).webView.loadUrl(this.url);
    }

    static /* synthetic */ void loadGame$default(H5DiamondGameDialog h5DiamondGameDialog, GameConfiguration gameConfiguration, int i, Object obj) {
        if ((i & 1) != 0) {
            gameConfiguration = null;
        }
        h5DiamondGameDialog.loadGame(gameConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GemGameAdapter mAdapter_delegate$lambda$0() {
        return new GemGameAdapter();
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
        cf.c.c().r(this);
        ((DialogH5DiamondGameBinding) getBinding()).webView.destroy();
    }

    public final int getGameId() {
        return this.gameId;
    }

    @Nullable
    public final ArrayList<GameConfiguration> getGemData() {
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
        return R.layout.dialog_h5_diamond_game;
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
        if (((DialogH5DiamondGameBinding) getBinding()).webView.canGoBack()) {
            ((DialogH5DiamondGameBinding) getBinding()).webView.goBack();
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
            ((DialogH5DiamondGameBinding) getBinding()).webView.loadUrl(this.url);
        }
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openGroupPager(@NotNull String str) {
        JsInterfaceListener.DefaultImpls.openGroupPager(this, str);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openGroupSupport() {
        JsInterfaceListener.DefaultImpls.openGroupSupport(this);
    }

    @Override // com.qiahao.nextvideo.ui.webview.JsInterfaceListener
    public void openPersonPage(@NotNull String str) {
        JsInterfaceListener.DefaultImpls.openPersonPage(this, str);
    }

    public final void setGemData(@Nullable ArrayList<GameConfiguration> arrayList) {
        this.gemData = arrayList;
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

    public final void setSelectGame(@Nullable GameConfiguration gameConfiguration) {
        this.selectGame = gameConfiguration;
    }

    public final void setUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}

package com.qiahao.nextvideo.ui.authentication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.ServerConfigureKt;
import com.qiahao.base_common.network.ServerInfo;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewControllerServerSelectionBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/authentication/ServerSelectionViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "<init>", "()V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerServerSelectionBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nServerSelectionViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ServerSelectionViewController.kt\ncom/qiahao/nextvideo/ui/authentication/ServerSelectionViewController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1869#2,2:90\n*S KotlinDebug\n*F\n+ 1 ServerSelectionViewController.kt\ncom/qiahao/nextvideo/ui/authentication/ServerSelectionViewController\n*L\n52#1:90,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ServerSelectionViewController extends BaseViewController {

    @NotNull
    public static final String TAG = "serverSelection";
    private ViewControllerServerSelectionBinding binding;

    public ServerSelectionViewController() {
        setTag(TAG);
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setAllowTapOutsideToDismiss(true);
        presentationStyle.setFullscreen(false);
        presentationStyle.setGravity(17);
        presentationStyle.setOverCurrentContext(true);
        presentationStyle.setAnimation(PresentingAnimation.BOTTOM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$4$lambda$3$lambda$2(ServerInfo serverInfo, ServerInfo serverInfo2, ServerSelectionViewController serverSelectionViewController, View view) {
        String str;
        BaseServer.INSTANCE.switchToServer(serverInfo);
        if (Intrinsics.areEqual(serverInfo2.getName(), "Production")) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "communitySelectedServer", "communityServer", (String) null, 4, (Object) null);
            str = "https://moment.tikhak.com";
        } else {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "communitySelectedServer", "communityTest", (String) null, 4, (Object) null);
            str = "https://test-moment.faceline.live:7110";
        }
        Log.e("communityUrl22", str);
        BaseControlUtils.INSTANCE.changeCommunityServer(str);
        ViewController.dismiss$default(serverSelectionViewController, false, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerServerSelectionBinding inflate = ViewControllerServerSelectionBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        for (final ServerInfo serverInfo : ServerConfigureKt.getAvailableServers().values()) {
            AppCompatButton appCompatButton = new AppCompatButton(getRequireContext());
            String baseUrl = serverInfo.getBaseUrl();
            ServerInfo selectedServerInfo = BaseServer.INSTANCE.getSelectedServerInfo();
            ViewControllerServerSelectionBinding viewControllerServerSelectionBinding = null;
            if (selectedServerInfo != null) {
                str = selectedServerInfo.getBaseUrl();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(baseUrl, str)) {
                appCompatButton.setBackgroundResource(R.drawable.bg_button_stroke_rounded_50dp);
                appCompatButton.setTextColor(-65536);
            } else {
                appCompatButton.setBackgroundResource(R.drawable.bg_button_stroke_rounded_50dp);
                appCompatButton.setTextColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            }
            appCompatButton.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            appCompatButton.setText(serverInfo.getName() + serverInfo.getDescription());
            ViewControllerServerSelectionBinding viewControllerServerSelectionBinding2 = this.binding;
            if (viewControllerServerSelectionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewControllerServerSelectionBinding = viewControllerServerSelectionBinding2;
            }
            viewControllerServerSelectionBinding.serverSelectionList.addView(appCompatButton);
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.authentication.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ServerSelectionViewController.viewDidLoad$lambda$4$lambda$3$lambda$2(serverInfo, serverInfo, this, view2);
                }
            });
        }
    }
}

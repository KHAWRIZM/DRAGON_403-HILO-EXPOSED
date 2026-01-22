package com.qiahao.nextvideo.ui.webview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.utilities.StorageUtils;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/qiahao/nextvideo/ui/webview/JsInterface$chooseVideo$1", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "onResult", "", "result", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class JsInterface$chooseVideo$1 implements OnResultCallbackListener<LocalMedia> {
    final /* synthetic */ JsInterface this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsInterface$chooseVideo$1(JsInterface jsInterface) {
        this.this$0 = jsInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$1(JsInterface jsInterface, long j, long j2) {
        jsInterface.getWebView().evaluateJavascript("javascript:videoProgress(\"" + ((int) ((j * 100) / j2)) + "\")", null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$2(JsInterface jsInterface, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            jsInterface.getWebView().evaluateJavascript("javascript:selectVideo(\"https://image.whoisamy.shop/" + pair.getSecond() + "\")", null);
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = jsInterface.getContext();
            String string = jsInterface.getContext().getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$3(JsInterface jsInterface, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = jsInterface.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string = jsInterface.getContext().getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void onCancel() {
    }

    public void onResult(ArrayList<LocalMedia> result) {
        String compressPath;
        if (result != null && result.size() > 0) {
            LocalMedia localMedia = result.get(0);
            if (localMedia.isCut() && !localMedia.isCompressed()) {
                compressPath = localMedia.getCutPath();
            } else if (!localMedia.isCompressed() && (!localMedia.isCut() || !localMedia.isCompressed())) {
                if (!TextUtils.isEmpty(localMedia.getRealPath())) {
                    compressPath = localMedia.getRealPath();
                } else {
                    compressPath = localMedia.getPath();
                }
            } else {
                compressPath = localMedia.getCompressPath();
            }
            File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
            if (fileCompat != null && fileCompat.exists()) {
                AliCloudService shared = AliCloudService.INSTANCE.getShared();
                final JsInterface jsInterface = this.this$0;
                i0<Pair<Boolean, String>> uploadFile = shared.uploadFile(AliCloudService.OSS_SCREENSHOT, fileCompat, true, new Function2() { // from class: com.qiahao.nextvideo.ui.webview.e0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit onResult$lambda$1;
                        onResult$lambda$1 = JsInterface$chooseVideo$1.onResult$lambda$1(JsInterface.this, ((Long) obj).longValue(), ((Long) obj2).longValue());
                        return onResult$lambda$1;
                    }
                });
                final JsInterface jsInterface2 = this.this$0;
                Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.webview.f0
                    public final Object invoke(Object obj) {
                        Unit onResult$lambda$2;
                        onResult$lambda$2 = JsInterface$chooseVideo$1.onResult$lambda$2(JsInterface.this, (Pair) obj);
                        return onResult$lambda$2;
                    }
                };
                final JsInterface jsInterface3 = this.this$0;
                RxUtilsKt.observeOnMainThread$default(uploadFile, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.webview.g0
                    public final Object invoke(Object obj) {
                        Unit onResult$lambda$3;
                        onResult$lambda$3 = JsInterface$chooseVideo$1.onResult$lambda$3(JsInterface.this, (Throwable) obj);
                        return onResult$lambda$3;
                    }
                }, (Function0) null, false, 12, (Object) null);
            }
        }
    }
}

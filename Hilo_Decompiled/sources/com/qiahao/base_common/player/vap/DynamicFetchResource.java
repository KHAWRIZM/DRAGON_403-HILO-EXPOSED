package com.qiahao.base_common.player.vap;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.facebook.internal.NativeProtocol;
import com.oudi.core.component.ICleared;
import com.oudi.utils.AppUtils;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.utils.image.ImageKtx;
import com.tencent.qgame.animplayer.inter.IFetchResource;
import com.tencent.qgame.animplayer.mix.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR7\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u001f` 8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/qiahao/base_common/player/vap/DynamicFetchResource;", "Lcom/tencent/qgame/animplayer/inter/IFetchResource;", "Lcom/oudi/core/component/ICleared;", "Lcom/oudi/utils/log/ILog;", "", "", NativeProtocol.WEB_DIALOG_PARAMS, "<init>", "(Ljava/util/Map;)V", "Lcom/tencent/qgame/animplayer/mix/Resource;", "resource", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "result", "fetchImage", "(Lcom/tencent/qgame/animplayer/mix/Resource;Lkotlin/jvm/functions/Function1;)V", "fetchText", "", "resources", "releaseResource", "(Ljava/util/List;)V", "url", "loadImage", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onCleared", "()V", "Ljava/util/Map;", "getParams", "()Ljava/util/Map;", "Ljava/util/ArrayList;", "Lcom/bumptech/glide/request/target/c;", "Lkotlin/collections/ArrayList;", "targetList$delegate", "Lkotlin/Lazy;", "getTargetList", "()Ljava/util/ArrayList;", "targetList", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDynamicFetchResource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynamicFetchResource.kt\ncom/qiahao/base_common/player/vap/DynamicFetchResource\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1869#2,2:89\n1869#2,2:91\n*S KotlinDebug\n*F\n+ 1 DynamicFetchResource.kt\ncom/qiahao/base_common/player/vap/DynamicFetchResource\n*L\n45#1:89,2\n80#1:91,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DynamicFetchResource implements IFetchResource, ICleared, ILog {

    @NotNull
    private final Map<String, String> params;

    /* renamed from: targetList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy targetList;

    public DynamicFetchResource(@NotNull Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        this.targetList = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.vap.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList targetList_delegate$lambda$0;
                targetList_delegate$lambda$0 = DynamicFetchResource.targetList_delegate$lambda$0();
                return targetList_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList targetList_delegate$lambda$0() {
        return new ArrayList();
    }

    public void fetchImage(@NotNull Resource resource, @NotNull Function1<? super Bitmap, Unit> result) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(result, "result");
        String tag = resource.getTag();
        String str = this.params.get(tag);
        ILog.DefaultImpls.logD$default(this, "fetchImage() key:" + tag + " ,value:" + str, null, false, 6, null);
        if (str != null && str.length() != 0) {
            loadImage(str, result);
        } else {
            result.invoke(null);
        }
    }

    public void fetchText(@NotNull Resource resource, @NotNull Function1<? super String, Unit> result) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(result, "result");
        String tag = resource.getTag();
        String str = this.params.get(tag);
        ILog.DefaultImpls.logD$default(this, "fetchText() key:" + tag + " ,value:" + str, null, false, 6, null);
        result.invoke(str);
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @NotNull
    protected final Map<String, String> getParams() {
        return this.params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<com.bumptech.glide.request.target.c> getTargetList() {
        return (ArrayList) this.targetList.getValue();
    }

    protected void loadImage(@NotNull final String url, @NotNull final Function1<? super Bitmap, Unit> result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        com.bumptech.glide.request.target.c cVar = new com.bumptech.glide.request.target.c() { // from class: com.qiahao.base_common.player.vap.DynamicFetchResource$loadImage$target$1
            @Override // com.bumptech.glide.request.target.j
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.j
            public void onLoadFailed(Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                ILog.DefaultImpls.logE$default((ILog) DynamicFetchResource.this, "loadImage() onLoadFailed() url:" + url, (String) null, false, 6, (Object) null);
                DynamicFetchResource.this.getTargetList().remove(this);
                result.invoke(null);
            }

            @Override // com.bumptech.glide.request.target.j
            public void onResourceReady(Bitmap resource, d5.b transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                DynamicFetchResource.this.getTargetList().remove(this);
                result.invoke(resource);
            }
        };
        getTargetList().add(cVar);
        ImageKtx imageKtx = ImageKtx.INSTANCE;
        Application app = AppUtils.getApp();
        Intrinsics.checkNotNullExpressionValue(app, "getApp(...)");
        imageKtx.downloadBitmap(app, url, true, cVar);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        ICleared.DefaultImpls.onCleared(this);
        ILog.DefaultImpls.logD$default(this, "onCleared() targetList:" + getTargetList().size(), null, false, 6, null);
        try {
            Iterator<T> it = getTargetList().iterator();
            while (it.hasNext()) {
                Glide.with(AppUtils.getApp()).f((com.bumptech.glide.request.target.c) it.next());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        getTargetList().clear();
    }

    public void releaseResource(@NotNull List<Resource> resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Iterator<T> it = resources.iterator();
        while (it.hasNext()) {
            Bitmap bitmap = ((Resource) it.next()).getBitmap();
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}

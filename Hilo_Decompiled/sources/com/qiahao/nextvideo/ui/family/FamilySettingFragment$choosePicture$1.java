package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.utilities.StorageUtils;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"com/qiahao/nextvideo/ui/family/FamilySettingFragment$choosePicture$1", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "onResult", "", "result", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilySettingFragment$choosePicture$1 implements OnResultCallbackListener<LocalMedia> {
    final /* synthetic */ FamilySettingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FamilySettingFragment$choosePicture$1(FamilySettingFragment familySettingFragment) {
        this.this$0 = familySettingFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$1(FamilySettingFragment familySettingFragment, FamilySettingFragment$choosePicture$1 familySettingFragment$choosePicture$1, File file, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(familySettingFragment), (CoroutineContext) null, (CoroutineStart) null, new FamilySettingFragment$choosePicture$1$onResult$2$1(file, familySettingFragment, pair, null), 3, (Object) null);
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, familySettingFragment.getContext(), ResourcesKtxKt.getStringById(familySettingFragment$choosePicture$1, 2131952667), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$2(FamilySettingFragment familySettingFragment, FamilySettingFragment$choosePicture$1 familySettingFragment$choosePicture$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = familySettingFragment.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = ResourcesKtxKt.getStringById(familySettingFragment$choosePicture$1, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
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
            final File fileCompat = StorageUtils.INSTANCE.getFileCompat(compressPath);
            if (fileCompat != null && fileCompat.exists()) {
                io.reactivex.rxjava3.core.i0 uploadFileToAWS$default = AliCloudService.uploadFileToAWS$default(AliCloudService.INSTANCE.getShared(), AliCloudService.OSS_SCREENSHOT, fileCompat, null, 4, null);
                final FamilySettingFragment familySettingFragment = this.this$0;
                Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.family.m3
                    public final Object invoke(Object obj) {
                        Unit onResult$lambda$1;
                        onResult$lambda$1 = FamilySettingFragment$choosePicture$1.onResult$lambda$1(FamilySettingFragment.this, this, fileCompat, (Pair) obj);
                        return onResult$lambda$1;
                    }
                };
                final FamilySettingFragment familySettingFragment2 = this.this$0;
                RxUtilsKt.observeOnMainThread$default(uploadFileToAWS$default, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.family.n3
                    public final Object invoke(Object obj) {
                        Unit onResult$lambda$2;
                        onResult$lambda$2 = FamilySettingFragment$choosePicture$1.onResult$lambda$2(FamilySettingFragment.this, this, (Throwable) obj);
                        return onResult$lambda$2;
                    }
                }, (Function0) null, false, 12, (Object) null);
            }
        }
    }
}

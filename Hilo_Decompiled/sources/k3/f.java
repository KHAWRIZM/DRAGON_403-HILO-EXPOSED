package k3;

import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.download.DownloadListener;
import com.qiahao.base_common.download.DownloadTask;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.hilo_message.R;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import com.qiahao.hilo_message.databinding.ActivityMediaViewBinding;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaDetailActivity f١٥٤٨٨a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f١٥٤٨٩b;

    public f(MediaDetailActivity mediaDetailActivity, String str) {
        this.f١٥٤٨٨a = mediaDetailActivity;
        this.f١٥٤٨٩b = str;
    }

    @Override // com.qiahao.base_common.download.DownloadListener
    public final void onCompleted(DownloadTask task) {
        ActivityMediaViewBinding activityMediaViewBinding;
        ProgressBar progressBar;
        Intrinsics.checkNotNullParameter(task, "task");
        DownloadListener.DefaultImpls.onCompleted(this, task);
        String filePath = task.getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        File file = new File(filePath);
        this.f١٥٤٨٨a.downloadPath = file.getAbsolutePath();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f١٥٤٨٨a), Dispatchers.getIO(), null, new e(this.f١٥٤٨٨a, this.f١٥٤٨٩b, null), 2, null);
        this.f١٥٤٨٨a.saveToGallery(file);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.INSTANCE, this.f١٥٤٨٨a, ResourcesKtxKt.getStringById(this, R.string.succeed), false, 4, null);
        if (normal$default != null) {
            normal$default.show();
        }
        activityMediaViewBinding = this.f١٥٤٨٨a.binding;
        if (activityMediaViewBinding != null && (progressBar = activityMediaViewBinding.loadingProgress) != null) {
            progressBar.setVisibility(8);
        }
        this.f١٥٤٨٨a.refreshVisibleView();
    }

    @Override // com.qiahao.base_common.download.DownloadListener
    public final void onError(DownloadTask task, Throwable throwable) {
        ActivityMediaViewBinding activityMediaViewBinding;
        ProgressBar progressBar;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        DownloadListener.DefaultImpls.onError(this, task, throwable);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.INSTANCE, this.f١٥٤٨٨a, ResourcesKtxKt.getStringById(this, R.string.fail), false, 4, null);
        if (normal$default != null) {
            normal$default.show();
        }
        activityMediaViewBinding = this.f١٥٤٨٨a.binding;
        if (activityMediaViewBinding != null && (progressBar = activityMediaViewBinding.loadingProgress) != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // com.qiahao.base_common.download.DownloadListener
    public final void onProgress(DownloadTask task, int i10, int i11) {
        ActivityMediaViewBinding activityMediaViewBinding;
        ActivityMediaViewBinding activityMediaViewBinding2;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        Intrinsics.checkNotNullParameter(task, "task");
        DownloadListener.DefaultImpls.onProgress(this, task, i10, i11);
        activityMediaViewBinding = this.f١٥٤٨٨a.binding;
        if (activityMediaViewBinding != null && (progressBar2 = activityMediaViewBinding.loadingProgress) != null) {
            progressBar2.setVisibility(0);
        }
        activityMediaViewBinding2 = this.f١٥٤٨٨a.binding;
        if (activityMediaViewBinding2 != null && (progressBar = activityMediaViewBinding2.loadingProgress) != null) {
            progressBar.setProgress((i10 * 100) / i11);
        }
    }
}

package k3;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.github.chrisbanes.photoview.PhotoView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import com.qiahao.hilo_message.databinding.ActivityMediaViewBinding;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaDetailActivity f١٥٤٩٨a;

    public k(MediaDetailActivity mediaDetailActivity) {
        this.f١٥٤٩٨a = mediaDetailActivity;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent p02) {
        ActivityMediaViewBinding activityMediaViewBinding;
        float f10;
        ActivityMediaViewBinding activityMediaViewBinding2;
        float f11;
        ActivityMediaViewBinding activityMediaViewBinding3;
        float f12;
        ActivityMediaViewBinding activityMediaViewBinding4;
        PhotoView photoView;
        ActivityMediaViewBinding activityMediaViewBinding5;
        PhotoView photoView2;
        ActivityMediaViewBinding activityMediaViewBinding6;
        PhotoView photoView3;
        ActivityMediaViewBinding activityMediaViewBinding7;
        PhotoView photoView4;
        PhotoView photoView5;
        ActivityMediaViewBinding activityMediaViewBinding8;
        PhotoView photoView6;
        ActivityMediaViewBinding activityMediaViewBinding9;
        PhotoView photoView7;
        PhotoView photoView8;
        PhotoView photoView9;
        Intrinsics.checkNotNullParameter(p02, "p0");
        activityMediaViewBinding = this.f١٥٤٩٨a.binding;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        if (activityMediaViewBinding != null && (photoView9 = activityMediaViewBinding.photoView) != null) {
            f10 = photoView9.getScale();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        activityMediaViewBinding2 = this.f١٥٤٩٨a.binding;
        if (activityMediaViewBinding2 != null && (photoView8 = activityMediaViewBinding2.photoView) != null) {
            f11 = photoView8.getMediumScale();
        } else {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (f10 > f11) {
            activityMediaViewBinding8 = this.f١٥٤٩٨a.binding;
            if (activityMediaViewBinding8 != null && (photoView6 = activityMediaViewBinding8.photoView) != null) {
                activityMediaViewBinding9 = this.f١٥٤٩٨a.binding;
                if (activityMediaViewBinding9 != null && (photoView7 = activityMediaViewBinding9.photoView) != null) {
                    f13 = photoView7.getMinimumScale();
                }
                photoView6.setScale(f13, true);
            }
        } else {
            activityMediaViewBinding3 = this.f١٥٤٩٨a.binding;
            if (activityMediaViewBinding3 != null && (photoView5 = activityMediaViewBinding3.photoView) != null) {
                f12 = photoView5.getMediumScale();
            } else {
                f12 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            if (f10 < f12) {
                activityMediaViewBinding6 = this.f١٥٤٩٨a.binding;
                if (activityMediaViewBinding6 != null && (photoView3 = activityMediaViewBinding6.photoView) != null) {
                    activityMediaViewBinding7 = this.f١٥٤٩٨a.binding;
                    if (activityMediaViewBinding7 != null && (photoView4 = activityMediaViewBinding7.photoView) != null) {
                        f13 = photoView4.getMediumScale();
                    }
                    photoView3.setScale(f13, true);
                }
            } else {
                activityMediaViewBinding4 = this.f١٥٤٩٨a.binding;
                if (activityMediaViewBinding4 != null && (photoView = activityMediaViewBinding4.photoView) != null) {
                    activityMediaViewBinding5 = this.f١٥٤٩٨a.binding;
                    if (activityMediaViewBinding5 != null && (photoView2 = activityMediaViewBinding5.photoView) != null) {
                        f13 = photoView2.getMaximumScale();
                    }
                    photoView.setScale(f13, true);
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return false;
    }
}

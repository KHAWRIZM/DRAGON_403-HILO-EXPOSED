package com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
class PreviewState implements State {
    public static final String TAG = "PreviewState";
    private CameraMachine machine;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreviewState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f) {
        TUIChatLog.i("PreviewState", ServiceInitializer.getAppContext().getString(R.string.no_event_cancle_tip));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void capture() {
        CameraInterface.getInstance().takePicture(new CameraInterface.TakePictureCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.PreviewState.1
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface.TakePictureCallback
            public void captureResult(Bitmap bitmap, boolean z) {
                PreviewState.this.machine.getView().showPicture(bitmap, z);
                PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowPictureState());
                TUIChatLog.i("PreviewState", "capture");
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void confirm() {
        TUIChatLog.i("PreviewState", ServiceInitializer.getAppContext().getString(R.string.no_event_confirm_tip));
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void flash(String str) {
        CameraInterface.getInstance().setFlashMode(str);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback) {
        TUIChatLog.i("PreviewState", "preview state foucs");
        if (this.machine.getView().handlerFoucs(f, f2)) {
            CameraInterface.getInstance().handleFocus(this.machine.getContext(), f, f2, focusCallback);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void record(Surface surface, float f) {
        CameraInterface.getInstance().startRecord(surface, f, null);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void restart() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void stop() {
        CameraInterface.getInstance().doStopPreview();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void stopRecord(final boolean z, long j) {
        CameraInterface.getInstance().stopRecord(z, new CameraInterface.StopRecordCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.PreviewState.2
            @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface.StopRecordCallback
            public void recordResult(String str, Bitmap bitmap) {
                if (z) {
                    PreviewState.this.machine.getView().resetState(3);
                } else {
                    PreviewState.this.machine.getView().playVideo(bitmap, str);
                    PreviewState.this.machine.setState(PreviewState.this.machine.getBorrowVideoState());
                }
            }
        });
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().switchCamera(surfaceHolder, f);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void zoom(float f, int i) {
        TUIChatLog.i("PreviewState", "zoom");
        CameraInterface.getInstance().setZoom(f, i);
    }
}

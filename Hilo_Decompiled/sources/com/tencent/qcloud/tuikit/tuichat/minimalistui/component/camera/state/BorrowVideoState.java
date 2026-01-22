package com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.view.CameraInterface;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BorrowVideoState implements State {
    private static final String TAG = "BorrowVideoState";
    private CameraMachine machine;

    public BorrowVideoState(CameraMachine cameraMachine) {
        this.machine = cameraMachine;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void cancle(SurfaceHolder surfaceHolder, float f) {
        this.machine.getView().resetState(2);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void capture() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void confirm() {
        this.machine.getView().confirmState(2);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void flash(String str) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void foucs(float f, float f2, CameraInterface.FocusCallback focusCallback) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void record(Surface surface, float f) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void restart() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void start(SurfaceHolder surfaceHolder, float f) {
        CameraInterface.getInstance().doStartPreview(surfaceHolder, f);
        CameraMachine cameraMachine = this.machine;
        cameraMachine.setState(cameraMachine.getPreviewState());
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void stop() {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void stopRecord(boolean z, long j) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void swtich(SurfaceHolder surfaceHolder, float f) {
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.component.camera.state.State
    public void zoom(float f, int i) {
        TUIChatLog.i(TAG, "zoom");
    }
}

package com.tencent.rtmp.video;

import android.hardware.display.VirtualDisplay;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class VirtualDisplayWrapper {
    private VirtualDisplay mVirtualDisplay;

    public VirtualDisplayWrapper(VirtualDisplay virtualDisplay) {
        this.mVirtualDisplay = virtualDisplay;
    }

    public void release() {
        VirtualDisplay virtualDisplay = this.mVirtualDisplay;
        if (virtualDisplay != null) {
            virtualDisplay.release();
            this.mVirtualDisplay = null;
        }
    }

    public void resize(int i, int i2) {
        VirtualDisplay virtualDisplay = this.mVirtualDisplay;
        if (virtualDisplay != null) {
            virtualDisplay.resize(i, i2, 1);
        }
    }
}

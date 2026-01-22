package io.agora.rtc;

import android.opengl.EGLContext;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RtcEngineEx extends RtcEngine {
    public abstract int enableRecap(int i10);

    public abstract int enableTransportQualityIndication(boolean z10);

    public abstract String getParameters(String str);

    public abstract String makeQualityReportUrl(String str, int i10, int i11, int i12);

    public abstract int monitorAudioRouteChange(boolean z10);

    public abstract int playRecap();

    public abstract int setApiCallMode(int i10);

    public abstract int setAppType(int i10);

    public abstract int setProfile(String str, boolean z10);

    public abstract int setTextureId(int i10, EGLContext eGLContext, int i11, int i12, long j10);

    public abstract int setTextureId(int i10, javax.microedition.khronos.egl.EGLContext eGLContext, int i11, int i12, long j10);

    public abstract int updateSharedContext(EGLContext eGLContext);

    public abstract int updateSharedContext(javax.microedition.khronos.egl.EGLContext eGLContext);
}

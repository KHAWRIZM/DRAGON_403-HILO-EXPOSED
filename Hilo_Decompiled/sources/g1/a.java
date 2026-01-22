package g1;

import j.n;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements ISudFSMStateHandle {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f١٤٣٧٥a;

    /* renamed from: b, reason: collision with root package name */
    public final String f١٤٣٧٦b;

    public a(String str, p1.a aVar) {
        this.f١٤٣٧٦b = str;
        this.f١٤٣٧٥a = new WeakReference(aVar);
    }

    public final void failure(String str) {
        boolean z10;
        n nVar = (n) this.f١٤٣٧٥a.get();
        StringBuilder sb = new StringBuilder("failure handle is null:");
        if (nVar == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        sb.append("  state:");
        sb.append(this.f١٤٣٧٦b);
        sb.append("  dataJson:");
        sb.append(str);
        LogUtils.file("SUDSudFSMStateHandleImpl", sb.toString());
        if (nVar != null) {
            try {
                nVar.f("fail", new JSONObject(str));
            } catch (Exception e10) {
                LogUtils.file("SUDSudFSMStateHandleImpl", "failure state：" + this.f١٤٣٧٦b + " 发生异常：" + LogUtils.getErrorInfo(e10));
            }
        }
    }

    public final void success(String str) {
        boolean z10;
        n nVar = (n) this.f١٤٣٧٥a.get();
        StringBuilder sb = new StringBuilder("success handle is null:");
        if (nVar == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        sb.append("  state:");
        sb.append(this.f١٤٣٧٦b);
        sb.append("  dataJson:");
        sb.append(str);
        LogUtils.file("SUDSudFSMStateHandleImpl", sb.toString());
        if (nVar != null) {
            try {
                nVar.f("success", new JSONObject(str));
            } catch (Exception e10) {
                LogUtils.file("SUDSudFSMStateHandleImpl", "success state：" + this.f١٤٣٧٦b + " 发生异常：" + LogUtils.getErrorInfo(e10));
            }
        }
    }
}

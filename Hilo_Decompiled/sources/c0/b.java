package c0;

import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements uf.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f٥٦٣٦a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f٥٦٣٧b;

    public b(WeakReference weakReference, String str) {
        this.f٥٦٣٦a = weakReference;
        this.f٥٦٣٧b = str;
    }

    public final void onCompleted(String str) {
        i iVar = (i) this.f٥٦٣٦a.get();
        if (iVar != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("request_id", this.f٥٦٣٧b);
                str = jSONObject.toString();
            } catch (Exception e10) {
                LogUtils.file("SudAiManager", LogUtils.getErrorInfo(e10));
            }
            iVar.onCompleted(str);
        }
    }

    public final void onFailure(int i10, String str) {
        i iVar = (i) this.f٥٦٣٦a.get();
        if (iVar != null) {
            iVar.onCompleted(c.a(i10, this.f٥٦٣٧b, str));
        }
    }
}

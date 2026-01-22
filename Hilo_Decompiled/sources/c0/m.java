package c0;

import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class m implements uf.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f٥٦٥١a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f٥٦٥٢b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f٥٦٥٣c;

    public m(WeakReference weakReference, String str, String str2) {
        this.f٥٦٥١a = weakReference;
        this.f٥٦٥٢b = str;
        this.f٥٦٥٣c = str2;
    }

    public final void onCompleted(String str) {
        i iVar = (i) this.f٥٦٥١a.get();
        if (iVar != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("request_id", this.f٥٦٥٢b);
                jSONObject.put("event", this.f٥٦٥٣c);
                str = jSONObject.toString();
            } catch (Exception e10) {
                LogUtils.file("SudAiManager", LogUtils.getErrorInfo(e10));
            }
            iVar.onCompleted(str);
        }
    }

    public final void onFailure(int i10, String str) {
        i iVar = (i) this.f٥٦٥١a.get();
        if (iVar != null) {
            iVar.onCompleted(c.a(i10, this.f٥٦٥٢b, str));
        }
    }
}

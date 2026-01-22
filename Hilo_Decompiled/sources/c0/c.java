package c0;

import android.text.TextUtils;
import d.p;
import java.lang.ref.WeakReference;
import java.util.UUID;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;
import qf.x;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c {
    public static String a(int i10, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", str);
            jSONObject.put("ret_code", i10);
            jSONObject.put("ret_msg", str2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(String str, i iVar) {
        String str2;
        String str3;
        d.b bVar;
        String str4;
        d.k kVar;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("request_id");
        } catch (Exception e10) {
            e = e10;
            str2 = null;
        }
        try {
            str3 = jSONObject.optString("event");
        } catch (Exception e11) {
            e = e11;
            LogUtils.file("SudAiManager", LogUtils.getErrorInfo(e));
            str3 = null;
            m mVar = new m(new WeakReference(iVar), str2, str3);
            if (e.d.f١٣٧١٩b.a) {
            }
        }
        m mVar2 = new m(new WeakReference(iVar), str2, str3);
        if (e.d.f١٣٧١٩b.a) {
            mVar2.onFailure(-10103, "Please call initSDK first successfully");
            return;
        }
        p pVar = e.d.f١٣٧٢٢e;
        if (pVar != null && (kVar = pVar.f١٣٥٣٧c) != null) {
            bVar = kVar.f١٣٥٢٢m;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            str4 = bVar.f١٣٤٨٢a;
        } else {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            mVar2.onFailure(-1, "model_api_cfg ai_normal url is null");
            return;
        }
        Request.Builder post = x.e(u.j.b(UUID.randomUUID().toString()), new wf.e(), (EventListener) null).url(str4).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), str));
        qf.i.a(post);
        qf.i.b.newCall(post.build()).enqueue(new uf.c(mVar2));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(String str, k kVar) {
        String str2;
        String str3;
        d.b bVar;
        String str4;
        d.k kVar2;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("request_id");
        } catch (Exception e10) {
            e = e10;
            str2 = null;
        }
        try {
            str3 = jSONObject.optString("event");
        } catch (Exception e11) {
            e = e11;
            LogUtils.file("SudAiManager", LogUtils.getErrorInfo(e));
            str3 = null;
            WeakReference weakReference = new WeakReference(kVar);
            a aVar = new a(weakReference, str2, str3);
            if (e.d.f١٣٧١٩b.a) {
            }
        }
        WeakReference weakReference2 = new WeakReference(kVar);
        a aVar2 = new a(weakReference2, str2, str3);
        if (e.d.f١٣٧١٩b.a) {
            k kVar3 = (k) weakReference2.get();
            if (kVar3 != null) {
                kVar3.a(a(-10103, str2, "Please call initSDK first successfully"));
                return;
            }
            return;
        }
        p pVar = e.d.f١٣٧٢٢e;
        if (pVar != null && (kVar2 = pVar.f١٣٥٣٧c) != null) {
            bVar = kVar2.f١٣٥٢٢m;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            str4 = bVar.f١٣٤٨٣b;
        } else {
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            k kVar4 = (k) weakReference2.get();
            if (kVar4 != null) {
                kVar4.a(a(-1, str2, "model_api_cfg sse url is null"));
                return;
            }
            return;
        }
        Request.Builder post = x.e(u.j.b(UUID.randomUUID().toString()), new wf.e(), (EventListener) null).url(str4).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), str));
        post.addHeader("sud_log_level_key", "sud_log_level_value_headers");
        qf.i.a(post);
        qf.i.b.newCall(post.build()).enqueue(new uf.i(aVar2));
    }
}

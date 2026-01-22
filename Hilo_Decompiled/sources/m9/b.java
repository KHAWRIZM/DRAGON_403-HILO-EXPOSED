package m9;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b extends c {
    @Override // m9.d
    public t9.a a(Context context, int i10, Intent intent) {
        if (4103 != i10 && 4098 != i10 && 4108 != i10) {
            return null;
        }
        t9.a d10 = d(intent, i10);
        o9.a.a(context, "push_transmit", (t9.b) d10);
        return d10;
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("msg_command");
        } catch (JSONException e10) {
            p9.d.a(e10.getMessage());
            return "";
        }
    }

    public t9.a d(Intent intent, int i10) {
        int parseInt;
        try {
            t9.b bVar = new t9.b();
            bVar.x(p9.b.e(intent.getStringExtra("messageID")));
            bVar.F(p9.b.e(intent.getStringExtra("taskID")));
            bVar.w(p9.b.e(intent.getStringExtra("globalID")));
            bVar.n(p9.b.e(intent.getStringExtra("appPackage")));
            bVar.H(p9.b.e(intent.getStringExtra("title")));
            bVar.p(p9.b.e(intent.getStringExtra("content")));
            bVar.r(p9.b.e(intent.getStringExtra("description")));
            String e10 = p9.b.e(intent.getStringExtra("notifyID"));
            int i11 = 0;
            if (TextUtils.isEmpty(e10)) {
                parseInt = 0;
            } else {
                parseInt = Integer.parseInt(e10);
            }
            bVar.B(parseInt);
            bVar.z(p9.b.e(intent.getStringExtra("miniProgramPkg")));
            bVar.y(i10);
            bVar.u(p9.b.e(intent.getStringExtra("eventId")));
            bVar.E(p9.b.e(intent.getStringExtra("statistics_extra")));
            String e11 = p9.b.e(intent.getStringExtra("data_extra"));
            bVar.q(e11);
            String c10 = c(e11);
            if (!TextUtils.isEmpty(c10)) {
                i11 = Integer.parseInt(c10);
            }
            bVar.A(i11);
            bVar.o(p9.b.e(intent.getStringExtra("balanceTime")));
            bVar.D(p9.b.e(intent.getStringExtra("startDate")));
            bVar.t(p9.b.e(intent.getStringExtra("endDate")));
            bVar.G(p9.b.e(intent.getStringExtra("timeRanges")));
            bVar.C(p9.b.e(intent.getStringExtra("rule")));
            bVar.v(p9.b.e(intent.getStringExtra("forcedDelivery")));
            bVar.s(p9.b.e(intent.getStringExtra("distinctBycontent")));
            bVar.m(p9.b.e(intent.getStringExtra("appID")));
            return bVar;
        } catch (Exception e12) {
            p9.d.a("OnHandleIntent--" + e12.getMessage());
            return null;
        }
    }
}

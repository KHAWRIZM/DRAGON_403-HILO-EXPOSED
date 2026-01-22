package u3;

import anet.channel.request.Request;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements f {
    @Override // u3.f
    public d a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(Request.Method.GET);
        httpURLConnection.connect();
        return new a(httpURLConnection);
    }
}

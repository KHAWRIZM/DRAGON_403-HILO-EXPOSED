package u3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f١٨٢٢٨a;

    public a(HttpURLConnection httpURLConnection) {
        this.f١٨٢٢٨a = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f١٨٢٢٨a.disconnect();
    }

    @Override // u3.d
    public String d() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f١٨٢٢٨a.getURL() + ". Failed with " + this.f١٨٢٢٨a.getResponseCode() + "\n" + a(this.f١٨٢٢٨a);
        } catch (IOException e10) {
            x3.f.d("get error failed ", e10);
            return e10.getMessage();
        }
    }

    @Override // u3.d
    public boolean isSuccessful() {
        try {
            if (this.f١٨٢٢٨a.getResponseCode() / 100 != 2) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // u3.d
    public String p() {
        return this.f١٨٢٢٨a.getContentType();
    }

    @Override // u3.d
    public InputStream r() {
        return this.f١٨٢٢٨a.getInputStream();
    }
}

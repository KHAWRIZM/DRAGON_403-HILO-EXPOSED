package wf;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class d implements Interceptor {
    public static boolean d;
    public volatile TreeSet a = new TreeSet();
    public final b b = new b();
    public volatile int c = 1;

    public static boolean a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, Math.min(buffer.size(), 64L));
            for (int i = 0; i < 16; i++) {
                if (!buffer2.exhausted()) {
                    int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                    if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x037c, code lost:
    
        if ("chunked".equalsIgnoreCase(r4.header("Transfer-Encoding")) == false) goto L١٦٤;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0177 A[ADDED_TO_REGION] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response intercept(Interceptor.Chain chain) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ResponseBody responseBody;
        String str7;
        Long l;
        long j;
        String value;
        String str8;
        int i;
        Charset charset;
        String value2;
        int i2 = this.c;
        Request request = chain.request();
        if (i2 == 1) {
            return chain.proceed(request);
        }
        if (i2 == 4) {
            z = true;
        } else {
            z = false;
        }
        if (!z && i2 != 3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && "sud_log_level_value_headers".equals(request.header("sud_log_level_key"))) {
            Request.Builder newBuilder = request.newBuilder();
            newBuilder.removeHeader("sud_log_level_key");
            request = newBuilder.build();
            z = false;
        }
        RequestBody body = request.body();
        Connection connection = chain.connection();
        String str9 = (("--> " + request.method()) + " ") + request.url();
        if (connection != null) {
            str9 = str9 + connection.protocol();
        }
        if (!z2 && body != null) {
            str9 = (str9 + " (requestBody.contentLength()") + "-byte body)";
        }
        this.b.a(str9);
        String str10 = "Content-Length";
        Charset charset2 = null;
        String str11 = "";
        if (!z2) {
            str = "Content-Length";
            z3 = z2;
            str2 = " ";
            str3 = "-byte body omitted)";
        } else {
            Headers headers = request.headers();
            if (body != null) {
                if (body.get$contentType() != null) {
                    z3 = z2;
                    if (headers.get("Content-Type") == null) {
                        str2 = " ";
                        this.b.a("Content-Type: " + body.get$contentType());
                        if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                            b bVar = this.b;
                            StringBuilder sb2 = new StringBuilder("Content-Length: ");
                            str8 = "-byte body omitted)";
                            sb2.append(body.contentLength());
                            bVar.a(sb2.toString());
                            i = 0;
                            while (i < headers.size()) {
                                if (this.a.contains(headers.name(i))) {
                                    value2 = str2;
                                } else {
                                    value2 = headers.value(i);
                                }
                                this.b.a(headers.name(i) + ": " + value2);
                                i++;
                                str10 = str10;
                            }
                            str = str10;
                            if (z || body == null) {
                                str3 = str8;
                                this.b.a("--> END " + request.method());
                            } else {
                                String str12 = request.headers().get("Content-Encoding");
                                if (str12 != null && !str12.equalsIgnoreCase("identity") && !str12.equalsIgnoreCase("gzip")) {
                                    this.b.a("--> END " + request.method() + " (encoded body omitted)");
                                } else {
                                    Buffer buffer = new Buffer();
                                    body.writeTo(buffer);
                                    MediaType mediaType = body.get$contentType();
                                    Charset charset3 = StandardCharsets.UTF_8;
                                    if (mediaType != null) {
                                        charset = mediaType.charset(charset3);
                                    } else {
                                        charset = null;
                                    }
                                    if (charset != null) {
                                        charset3 = charset;
                                    }
                                    this.b.a("");
                                    if (a(buffer)) {
                                        this.b.a(buffer.readString(charset3));
                                        this.b.a("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                                    } else {
                                        b bVar2 = this.b;
                                        StringBuilder sb3 = new StringBuilder("--> END ");
                                        sb3.append(request.method());
                                        sb3.append(" (binary ");
                                        sb3.append(body.contentLength());
                                        str3 = str8;
                                        sb3.append(str3);
                                        bVar2.a(sb3.toString());
                                    }
                                }
                                str3 = str8;
                            }
                        }
                    }
                } else {
                    z3 = z2;
                }
                str2 = " ";
                if (body.contentLength() != -1) {
                    b bVar3 = this.b;
                    StringBuilder sb22 = new StringBuilder("Content-Length: ");
                    str8 = "-byte body omitted)";
                    sb22.append(body.contentLength());
                    bVar3.a(sb22.toString());
                    i = 0;
                    while (i < headers.size()) {
                    }
                    str = str10;
                    if (z) {
                    }
                    str3 = str8;
                    this.b.a("--> END " + request.method());
                }
            } else {
                z3 = z2;
                str2 = " ";
            }
            str8 = "-byte body omitted)";
            i = 0;
            while (i < headers.size()) {
            }
            str = str10;
            if (z) {
            }
            str3 = str8;
            this.b.a("--> END " + request.method());
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            if (body2 != null) {
                long contentLength = body2.getContentLength();
                if (contentLength != -1) {
                    str4 = "$contentLength-byte";
                } else {
                    str4 = "unknown-length";
                }
                b bVar4 = this.b;
                Locale locale = Locale.getDefault();
                Integer valueOf = Integer.valueOf(proceed.code());
                if (proceed.message().isEmpty()) {
                    str6 = "";
                    str5 = str3;
                } else {
                    str5 = str3;
                    str6 = "";
                    str11 = str2 + proceed.message();
                }
                HttpUrl url = proceed.request().url();
                Long valueOf2 = Long.valueOf(millis);
                if (!z3) {
                    responseBody = body2;
                    str7 = ", " + str4 + " body";
                } else {
                    responseBody = body2;
                    str7 = ")";
                }
                bVar4.a(String.format(locale, "<-- %s%s %s (%dms%s)", valueOf, str11, url, valueOf2, str7));
                if (z3) {
                    Headers headers2 = proceed.headers();
                    for (int i3 = 0; i3 < headers2.size(); i3++) {
                        if (this.a.contains(headers2.name(i3))) {
                            value = str2;
                        } else {
                            value = headers2.value(i3);
                        }
                        this.b.a(headers2.name(i3) + ": " + value);
                    }
                    if (z && !"HEAD".equals(proceed.request().method())) {
                        int code = proceed.code();
                        if ((code >= 100 && code < 200) || code == 204 || code == 304) {
                            try {
                                j = Long.parseLong(proceed.headers().get(str));
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = -1;
                            }
                            if (j == -1) {
                            }
                        }
                        String str13 = proceed.headers().get("Content-Encoding");
                        if (str13 != null && !str13.equalsIgnoreCase("identity") && !str13.equalsIgnoreCase("gzip")) {
                            this.b.a("<-- END HTTP (encoded body omitted)");
                        } else {
                            BufferedSource source = responseBody.getSource();
                            source.request(Long.MAX_VALUE);
                            Buffer buffer2 = source.buffer();
                            if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                                l = Long.valueOf(buffer2.size());
                                GzipSource gzipSource = new GzipSource(buffer2.clone());
                                try {
                                    buffer2 = new Buffer();
                                    buffer2.writeAll(gzipSource);
                                    gzipSource.close();
                                } finally {
                                }
                            } else {
                                l = null;
                            }
                            MediaType mediaType2 = responseBody.get$contentType();
                            Charset charset4 = StandardCharsets.UTF_8;
                            if (mediaType2 != null) {
                                charset2 = mediaType2.charset(charset4);
                            }
                            if (charset2 != null) {
                                charset4 = charset2;
                            }
                            if (!a(buffer2)) {
                                this.b.a(str6);
                                this.b.a("<-- END HTTP (binary " + buffer2.size() + str5);
                                return proceed;
                            }
                            String str14 = str6;
                            if (contentLength != 0) {
                                this.b.a(str14);
                                this.b.a(buffer2.clone().readString(charset4));
                            }
                            if (l != null) {
                                this.b.a(String.format(Locale.getDefault(), "<-- END HTTP (%d-byte, %d-gzipped-byte body)", Long.valueOf(buffer2.size()), l));
                            } else {
                                b bVar5 = this.b;
                                Locale.getDefault();
                                bVar5.a("<-- END HTTP (" + buffer2.size() + "-byte body)");
                            }
                        }
                    }
                    this.b.a("<-- END HTTP");
                }
            }
            return proceed;
        } catch (Exception e2) {
            this.b.a("<-- HTTP FAILED: " + e2);
            throw e2;
        }
    }
}

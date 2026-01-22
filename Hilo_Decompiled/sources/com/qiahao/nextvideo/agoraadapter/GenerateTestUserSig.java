package com.qiahao.nextvideo.agoraadapter;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.Deflater;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class GenerateTestUserSig {
    private static final int EXPIRETIME = 604800;
    private static final int SDKAPPID = SDKConfig.TX_SDKAPPID;
    public static final String SECRETKEY = "";
    private String key;
    private long sdkappid;

    public GenerateTestUserSig(long j, String str) {
        this.sdkappid = j;
        this.key = str;
    }

    public static byte[] base64EncodeUrl(byte[] bArr) {
        byte[] bytes = new String(Base64.encode(bArr, 2)).getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (b != 43) {
                if (b != 47) {
                    if (b == 61) {
                        bytes[i] = 95;
                    }
                } else {
                    bytes[i] = 45;
                }
            } else {
                bytes[i] = 42;
            }
        }
        return bytes;
    }

    private String genSig(String str, long j, byte[] bArr) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TLS.ver", "2.0");
            jSONObject.put("TLS.identifier", str);
            jSONObject.put("TLS.sdkappid", this.sdkappid);
            jSONObject.put("TLS.expire", j);
            jSONObject.put("TLS.time", currentTimeMillis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (bArr != null) {
            str2 = Base64.encodeToString(bArr, 2);
            try {
                jSONObject.put("TLS.userbuf", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            str2 = null;
        }
        String hmacsha256 = hmacsha256(str, currentTimeMillis, j, str2);
        if (hmacsha256.length() == 0) {
            return "";
        }
        try {
            jSONObject.put("TLS.sig", hmacsha256);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        Deflater deflater = new Deflater();
        jSONObject.toString();
        deflater.setInput(jSONObject.toString().getBytes(Charset.forName("UTF-8")));
        deflater.finish();
        byte[] bArr2 = new byte[2048];
        int deflate = deflater.deflate(bArr2);
        deflater.end();
        return new String(base64EncodeUrl(Arrays.copyOfRange(bArr2, 0, deflate)));
    }

    public static String genTestUserSig(String str) {
        return new GenerateTestUserSig(SDKAPPID, "").genSig(str, 604800L);
    }

    private String hmacsha256(String str, long j, long j2, String str2) {
        String str3 = "TLS.identifier:" + str + "\nTLS.sdkappid:" + this.sdkappid + "\nTLS.time:" + j + "\nTLS.expire:" + j2 + "\n";
        if (str2 != null) {
            str3 = str3 + "TLS.userbuf:" + str2 + "\n";
        }
        try {
            byte[] bytes = this.key.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
            return new String(Base64.encode(mac.doFinal(str3.getBytes("UTF-8")), 2));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public String genSigWithUserBuf(String str, long j, byte[] bArr) {
        return genSig(str, j, bArr);
    }

    public String genSig(String str, long j) {
        return genSig(str, j, null);
    }
}

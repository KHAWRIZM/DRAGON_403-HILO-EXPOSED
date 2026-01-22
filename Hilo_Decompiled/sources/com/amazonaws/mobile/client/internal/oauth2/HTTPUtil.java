package com.amazonaws.mobile.client.internal.oauth2;

import anet.channel.request.Request;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthClientException;
import com.amazonaws.mobileconnectors.cognitoauth.exceptions.AuthServiceException;
import com.amazonaws.util.StringUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class HTTPUtil {
    HTTPUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String httpPost(URL url, Map<String, String> map, Map<String, String> map2) throws Exception {
        BufferedReader bufferedReader;
        InputStream errorStream;
        if (url != null && map2 != null && map2.size() >= 1) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            DataOutputStream dataOutputStream = null;
            try {
                httpsURLConnection.setRequestMethod(Request.Method.POST);
                httpsURLConnection.setDoOutput(true);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpsURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                httpsURLConnection.addRequestProperty("x-amz-user-agent", AWSMobileClient.USER_AGENT);
                httpsURLConnection.setRequestProperty("User-Agent", httpsURLConnection.getRequestProperty("User-Agent") + " " + AWSMobileClient.USER_AGENT);
                StringBuilder sb = new StringBuilder();
                int size = map2.size();
                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                    sb.append(URLEncoder.encode(entry2.getKey(), "UTF-8"));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry2.getValue(), "UTF-8"));
                    int i10 = size - 1;
                    if (size > 1) {
                        sb.append(Typography.amp);
                    }
                    size = i10;
                }
                String sb2 = sb.toString();
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpsURLConnection.getOutputStream());
                try {
                    dataOutputStream2.writeBytes(sb2);
                    dataOutputStream2.flush();
                    httpsURLConnection.getHeaderFields();
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 500) {
                        if (responseCode < 400) {
                            errorStream = httpsURLConnection.getInputStream();
                        } else {
                            errorStream = httpsURLConnection.getErrorStream();
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    sb3.append(readLine);
                                } else {
                                    String sb4 = sb3.toString();
                                    dataOutputStream2.close();
                                    bufferedReader.close();
                                    return sb4;
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            dataOutputStream = dataOutputStream2;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream = dataOutputStream2;
                            if (dataOutputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    } else {
                        throw new AuthServiceException(httpsURLConnection.getResponseMessage());
                    }
                } catch (Exception e11) {
                    e = e11;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e12) {
                e = e12;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } else {
            throw new AuthClientException("Invalid http request parameters");
        }
    }

    public static OAuth2Tokens parseHttpResponse(String str) throws JSONException {
        Long l10;
        if (str != null && !str.isEmpty()) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR.toString(), null);
            String optString2 = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR_DESCRIPTION.toString(), null);
            String optString3 = jSONObject.optString(OAuth2Constants.TokenResponseFields.ERROR_URI.toString(), null);
            if (optString == null) {
                String optString4 = jSONObject.optString(OAuth2Constants.TokenResponseFields.EXPIRES_IN.toString());
                if (!StringUtils.isBlank(optString4)) {
                    l10 = Long.valueOf(Long.parseLong(optString4));
                } else {
                    l10 = null;
                }
                return new OAuth2Tokens(jSONObject.getString(OAuth2Constants.TokenResponseFields.ACCESS_TOKEN.toString()), jSONObject.optString(OAuth2Constants.TokenResponseFields.ID_TOKEN.toString(), null), jSONObject.optString(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString(), null), jSONObject.getString(OAuth2Constants.TokenResponseFields.TOKEN_TYPE.toString()), l10, Long.valueOf(System.currentTimeMillis() / 1000), jSONObject.optString(OAuth2Constants.SCOPES, null));
            }
            throw new OAuth2Exception("Failed to exchange code for tokens", optString, optString2, optString3);
        }
        throw new IllegalArgumentException("Invalid (null) response from Amazon Cognito Auth endpoint");
    }
}

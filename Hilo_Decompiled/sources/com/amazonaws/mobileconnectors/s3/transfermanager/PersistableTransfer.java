package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.JsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class PersistableTransfer {
    public static <T extends PersistableTransfer> T deserializeFrom(InputStream inputStream) {
        AwsJsonReader jsonReader = JsonUtils.getJsonReader(new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8)));
        try {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            long[] jArr = null;
            String str4 = null;
            ResponseHeaderOverrides responseHeaderOverrides = null;
            String str5 = null;
            long j10 = -1;
            long j11 = -1;
            boolean z10 = false;
            String str6 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("pauseType")) {
                    str = jsonReader.nextString();
                } else if (nextName.equals("bucketName")) {
                    str6 = jsonReader.nextString();
                } else if (nextName.equals(TransferTable.COLUMN_KEY)) {
                    str2 = jsonReader.nextString();
                } else if (nextName.equals("file")) {
                    str5 = jsonReader.nextString();
                } else if (nextName.equals("multipartUploadId")) {
                    str4 = jsonReader.nextString();
                } else if (nextName.equals("partSize")) {
                    j10 = Long.parseLong(jsonReader.nextString());
                } else if (nextName.equals("mutlipartUploadThreshold")) {
                    j11 = Long.parseLong(jsonReader.nextString());
                } else if (nextName.equals("versionId")) {
                    str3 = jsonReader.nextString();
                } else if (nextName.equals("range")) {
                    jsonReader.beginArray();
                    long[] jArr2 = {Long.parseLong(jsonReader.nextString()), Long.parseLong(jsonReader.nextString())};
                    jsonReader.endArray();
                    jArr = jArr2;
                } else if (nextName.equals("responseHeaders")) {
                    ResponseHeaderOverrides responseHeaderOverrides2 = new ResponseHeaderOverrides();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        if (nextName2.equals("contentType")) {
                            responseHeaderOverrides2.setContentType(jsonReader.nextString());
                        } else if (nextName2.equals("contentLanguage")) {
                            responseHeaderOverrides2.setContentLanguage(jsonReader.nextString());
                        } else if (nextName2.equals("expires")) {
                            responseHeaderOverrides2.setExpires(jsonReader.nextString());
                        } else if (nextName2.equals("cacheControl")) {
                            responseHeaderOverrides2.setCacheControl(jsonReader.nextString());
                        } else if (nextName2.equals("contentDisposition")) {
                            responseHeaderOverrides2.setContentDisposition(jsonReader.nextString());
                        } else if (nextName2.equals("contentEncoding")) {
                            responseHeaderOverrides2.setContentEncoding(jsonReader.nextString());
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    responseHeaderOverrides = responseHeaderOverrides2;
                } else if (nextName.equals("isRequesterPays")) {
                    z10 = Boolean.parseBoolean(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if ("download".equals(str)) {
                return new PersistableDownload(str6, str2, str3, jArr, responseHeaderOverrides, z10, str5);
            }
            if ("upload".equals(str)) {
                return new PersistableUpload(str6, str2, str5, str4, j10, j11);
            }
            throw new UnsupportedOperationException("Unsupported paused transfer type: " + str);
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public abstract String serialize();

    public final void serialize(OutputStream outputStream) throws IOException {
        outputStream.write(serialize().getBytes(StringUtils.UTF8));
        outputStream.flush();
    }

    public static <T extends PersistableTransfer> T deserializeFrom(String str) {
        if (str == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StringUtils.UTF8));
        try {
            return (T) deserializeFrom(byteArrayInputStream);
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}

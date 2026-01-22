package com.amazonaws.services.s3.internal;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.SSEAlgorithm;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.Md5Utils;
import com.amazonaws.util.StringUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.net.ssl.SSLProtocolException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ServiceUtils {
    public static final boolean APPEND_MODE = true;
    private static final int DEAFAULT_BYTE_SIZE = 10240;
    public static final boolean OVERWRITE_MODE = false;
    private static final Log log = LogFactory.getLog(ServiceUtils.class);

    @Deprecated
    protected static final DateUtils DATE_UTILS = new DateUtils();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface RetryableS3DownloadTask {
        S3Object getS3ObjectStream();

        boolean needIntegrityCheck();
    }

    public static URL convertRequestToUrl(Request<?> request) {
        return convertRequestToUrl(request, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0097 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void downloadObjectToFile(S3Object s3Object, File file, boolean z10, boolean z11) {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        byte[] bArr2;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z11));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            byte[] bArr5 = new byte[DEAFAULT_BYTE_SIZE];
            while (true) {
                int read = s3Object.getObjectContent().read(bArr5);
                if (read > -1) {
                    bufferedOutputStream.write(bArr5, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                        log.debug("Caught exception. Ignoring.");
                    }
                }
            }
            bufferedOutputStream.close();
            try {
                s3Object.getObjectContent().close();
            } catch (Exception unused2) {
                log.debug("Caught exception. Ignoring.");
            }
            try {
            } catch (Exception e11) {
                e = e11;
                bArr = null;
            }
            if (!isMultipartUploadETag(s3Object.getObjectMetadata().getETag())) {
                bArr = Md5Utils.computeMD5Hash(new FileInputStream(file));
                try {
                    bArr3 = BinaryUtils.fromHex(s3Object.getObjectMetadata().getETag());
                } catch (Exception e12) {
                    e = e12;
                    log.warn("Unable to calculate MD5 hash to validate download: " + e.getMessage(), e);
                    bArr2 = bArr3;
                    bArr4 = bArr;
                    if (z10) {
                    }
                }
                bArr2 = bArr3;
                bArr4 = bArr;
                if (z10 && bArr4 != null && bArr2 != null && !Arrays.equals(bArr4, bArr2)) {
                    throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data stored in '" + file.getAbsolutePath() + "' may be corrupt.");
                }
                return;
            }
            bArr2 = null;
            if (z10) {
            }
        } catch (IOException e13) {
            e = e13;
            s3Object.getObjectContent().abort();
            throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                bufferedOutputStream2.close();
            } catch (Exception unused3) {
                log.debug("Caught exception. Ignoring.");
            }
            try {
                s3Object.getObjectContent().close();
                throw th;
            } catch (Exception unused4) {
                log.debug("Caught exception. Ignoring.");
                throw th;
            }
        }
    }

    public static String formatIso8601Date(Date date) {
        return DateUtils.formatISO8601Date(date);
    }

    public static String formatRfc822Date(Date date) {
        return DateUtils.formatRFC822Date(date);
    }

    public static boolean isMultipartUploadETag(String str) {
        return str.contains("-");
    }

    public static String join(List<String> list) {
        String str = "";
        boolean z10 = true;
        for (String str2 : list) {
            if (!z10) {
                str = str + ", ";
            }
            str = str + str2;
            z10 = false;
        }
        return str;
    }

    public static Date parseIso8601Date(String str) {
        return DateUtils.parseISO8601Date(str);
    }

    public static Date parseRfc822Date(String str) {
        return DateUtils.parseRFC822Date(str);
    }

    public static String removeQuotes(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("\"")) {
            trim = trim.substring(1);
        }
        if (trim.endsWith("\"")) {
            return trim.substring(0, trim.length() - 1);
        }
        return trim;
    }

    public static S3Object retryableDownloadS3ObjectToFile(File file, RetryableS3DownloadTask retryableS3DownloadTask, boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        while (true) {
            S3Object s3ObjectStream = retryableS3DownloadTask.getS3ObjectStream();
            if (s3ObjectStream == null) {
                return null;
            }
            try {
                try {
                    downloadObjectToFile(s3ObjectStream, file, retryableS3DownloadTask.needIntegrityCheck(), z10);
                    s3ObjectStream.getObjectContent().abort();
                    z12 = z13;
                    z11 = false;
                } catch (AmazonClientException e10) {
                    if (e10.isRetryable()) {
                        if (!(e10.getCause() instanceof SocketException) && !(e10.getCause() instanceof SSLProtocolException)) {
                            if (!z13) {
                                log.info("Retry the download of object " + s3ObjectStream.getKey() + " (bucket " + s3ObjectStream.getBucketName() + ")", e10);
                                s3ObjectStream.getObjectContent().abort();
                                z11 = true;
                                z12 = true;
                            } else {
                                throw e10;
                            }
                        } else {
                            throw e10;
                        }
                    } else {
                        throw e10;
                    }
                }
                if (!z11) {
                    return s3ObjectStream;
                }
                z13 = z12;
            } catch (Throwable th) {
                s3ObjectStream.getObjectContent().abort();
                throw th;
            }
        }
    }

    public static boolean skipMd5CheckPerRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return skipMd5CheckPerRequest(amazonWebServiceRequest, null);
    }

    public static boolean skipMd5CheckPerResponse(ObjectMetadata objectMetadata) {
        return skipMd5CheckPerResponse(objectMetadata, null);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(StringUtils.UTF8);
    }

    public static URL convertRequestToUrl(Request<?> request, boolean z10) {
        String str;
        boolean z11 = true;
        String urlEncode = S3HttpUtils.urlEncode(request.getResourcePath(), true);
        if (z10 && urlEncode.startsWith("/")) {
            urlEncode = urlEncode.substring(1);
        }
        String str2 = request.getEndpoint() + ("/" + urlEncode).replaceAll("(?<=/)/", "%2F");
        for (String str3 : request.getParameters().keySet()) {
            if (z11) {
                str = str2 + "?";
                z11 = false;
            } else {
                str = str2 + DispatchConstants.SIGN_SPLIT_SYMBOL;
            }
            str2 = str + str3 + "=" + S3HttpUtils.urlEncode(request.getParameters().get(str3), false);
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e10) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e10.getMessage(), e10);
        }
    }

    public static boolean skipMd5CheckPerRequest(AmazonWebServiceRequest amazonWebServiceRequest, S3ClientOptions s3ClientOptions) {
        if ((s3ClientOptions != null && s3ClientOptions.isContentMd5CheckSkipped()) || System.getProperty("com.amazonaws.services.s3.disableGetObjectMD5Validation") != null) {
            return true;
        }
        if (amazonWebServiceRequest instanceof GetObjectRequest) {
            GetObjectRequest getObjectRequest = (GetObjectRequest) amazonWebServiceRequest;
            if (getObjectRequest.getRange() != null || getObjectRequest.getSSECustomerKey() != null) {
                return true;
            }
        } else {
            if (!(amazonWebServiceRequest instanceof PutObjectRequest)) {
                return (amazonWebServiceRequest instanceof UploadPartRequest) && ((UploadPartRequest) amazonWebServiceRequest).getSSECustomerKey() != null;
            }
            PutObjectRequest putObjectRequest = (PutObjectRequest) amazonWebServiceRequest;
            ObjectMetadata metadata = putObjectRequest.getMetadata();
            if ((metadata != null && metadata.getSSEAlgorithm() != null) || putObjectRequest.getSSECustomerKey() != null) {
                return true;
            }
            if (putObjectRequest.getSSEAwsKeyManagementParams() != null && (putObjectRequest.getSSEAwsKeyManagementParams().getEncryption() != null || putObjectRequest.getSSEAwsKeyManagementParams().getAwsKmsKeyId() != null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean skipMd5CheckPerResponse(ObjectMetadata objectMetadata, S3ClientOptions s3ClientOptions) {
        if (s3ClientOptions != null && s3ClientOptions.isContentMd5CheckSkipped()) {
            return true;
        }
        if (objectMetadata == null) {
            return false;
        }
        return objectMetadata.getSSECustomerAlgorithm() != null || SSEAlgorithm.KMS.toString().equals(objectMetadata.getSSEAlgorithm());
    }
}

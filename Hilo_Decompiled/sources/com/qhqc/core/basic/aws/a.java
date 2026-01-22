package com.qhqc.core.basic.aws;

import android.content.Context;
import android.util.Log;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final String f١٢٢٢٤d = "a";

    /* renamed from: a, reason: collision with root package name */
    private AmazonS3Client f١٢٢٢٥a;

    /* renamed from: b, reason: collision with root package name */
    private AWSCredentialsProvider f١٢٢٢٦b;

    /* renamed from: c, reason: collision with root package name */
    private TransferUtility f١٢٢٢٧c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qhqc.core.basic.aws.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class C٠١٤٤a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f١٢٢٢٨a;

        C٠١٤٤a(CountDownLatch countDownLatch) {
            this.f١٢٢٢٨a = countDownLatch;
        }

        @Override // com.amazonaws.mobile.client.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(UserStateDetails userStateDetails) {
            this.f١٢٢٢٨a.countDown();
        }

        @Override // com.amazonaws.mobile.client.Callback
        public void onError(Exception exc) {
            Log.e(a.f١٢٢٢٤d, "onError: ", exc);
            this.f١٢٢٢٨a.countDown();
        }
    }

    private AWSCredentialsProvider b(Context context) {
        if (this.f١٢٢٢٦b == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AWSMobileClient.getInstance().initialize(context, new C٠١٤٤a(countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e10) {
                Log.e(f١٢٢٢٤d, "onError: ", e10);
                e10.printStackTrace();
            }
            this.f١٢٢٢٦b = AWSMobileClient.getInstance();
        }
        return this.f١٢٢٢٦b;
    }

    public AmazonS3Client c(Context context) {
        if (this.f١٢٢٢٥a == null) {
            try {
                AmazonS3Client amazonS3Client = new AmazonS3Client(b(context), Region.getRegion(new AWSConfiguration(context).optJsonObject("S3TransferUtility").getString("Region")));
                this.f١٢٢٢٥a = amazonS3Client;
                amazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return this.f١٢٢٢٥a;
    }

    public TransferUtility d(Context context) {
        if (this.f١٢٢٢٧c == null) {
            this.f١٢٢٢٧c = TransferUtility.builder().context(context).s3Client(c(context)).awsConfiguration(new AWSConfiguration(context)).build();
        }
        return this.f١٢٢٢٧c;
    }
}

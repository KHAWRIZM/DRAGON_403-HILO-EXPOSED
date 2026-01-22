package xb;

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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class a {
    private static final String d = "a";
    private AmazonS3Client a;
    private AWSCredentialsProvider b;
    private TransferUtility c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: xb.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class C٠٠٦٠a implements Callback {
        final /* synthetic */ CountDownLatch a;

        C٠٠٦٠a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(UserStateDetails userStateDetails) {
            this.a.countDown();
        }

        public void onError(Exception exc) {
            Log.e(a.d, "onError: ", exc);
            this.a.countDown();
        }
    }

    private AWSCredentialsProvider b(Context context) {
        if (this.b == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AWSMobileClient.getInstance().initialize(context, new C٠٠٦٠a(countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                Log.e(d, "onError: ", e);
                e.printStackTrace();
            }
            this.b = AWSMobileClient.getInstance();
        }
        return this.b;
    }

    public AmazonS3Client c(Context context) {
        if (this.a == null) {
            try {
                AmazonS3Client amazonS3Client = new AmazonS3Client(b(context), Region.getRegion(new AWSConfiguration(context).optJsonObject("S3TransferUtility").getString("Region")));
                this.a = amazonS3Client;
                amazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this.a;
    }

    public TransferUtility d(Context context) {
        if (this.c == null) {
            this.c = TransferUtility.builder().context(context).s3Client(c(context)).awsConfiguration(new AWSConfiguration(context)).build();
        }
        return this.c;
    }
}

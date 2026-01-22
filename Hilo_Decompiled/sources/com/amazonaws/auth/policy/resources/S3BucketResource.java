package com.amazonaws.auth.policy.resources;

import com.amazonaws.auth.policy.Resource;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class S3BucketResource extends Resource {
    public S3BucketResource(String str) {
        super("arn:aws:s3:::" + str);
    }
}

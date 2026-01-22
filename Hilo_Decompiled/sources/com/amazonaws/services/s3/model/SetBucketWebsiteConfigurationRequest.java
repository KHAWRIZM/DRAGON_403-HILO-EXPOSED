package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetBucketWebsiteConfigurationRequest extends AmazonWebServiceRequest {
    private String bucketName;
    private BucketWebsiteConfiguration configuration;

    public SetBucketWebsiteConfigurationRequest(String str, BucketWebsiteConfiguration bucketWebsiteConfiguration) {
        this.bucketName = str;
        this.configuration = bucketWebsiteConfiguration;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public BucketWebsiteConfiguration getConfiguration() {
        return this.configuration;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setConfiguration(BucketWebsiteConfiguration bucketWebsiteConfiguration) {
        this.configuration = bucketWebsiteConfiguration;
    }

    public SetBucketWebsiteConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public SetBucketWebsiteConfigurationRequest withConfiguration(BucketWebsiteConfiguration bucketWebsiteConfiguration) {
        setConfiguration(bucketWebsiteConfiguration);
        return this;
    }
}

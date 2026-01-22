package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CustomDomainConfigType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class CustomDomainConfigTypeJsonMarshaller {
    private static CustomDomainConfigTypeJsonMarshaller instance;

    CustomDomainConfigTypeJsonMarshaller() {
    }

    public static CustomDomainConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CustomDomainConfigTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(CustomDomainConfigType customDomainConfigType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (customDomainConfigType.getCertificateArn() != null) {
            String certificateArn = customDomainConfigType.getCertificateArn();
            awsJsonWriter.name("CertificateArn");
            awsJsonWriter.value(certificateArn);
        }
        awsJsonWriter.endObject();
    }
}

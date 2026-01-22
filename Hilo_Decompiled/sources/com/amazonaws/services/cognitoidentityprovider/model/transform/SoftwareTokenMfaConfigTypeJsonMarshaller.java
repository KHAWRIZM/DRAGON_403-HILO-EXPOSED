package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SoftwareTokenMfaConfigType;
import com.amazonaws.util.json.AwsJsonWriter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class SoftwareTokenMfaConfigTypeJsonMarshaller {
    private static SoftwareTokenMfaConfigTypeJsonMarshaller instance;

    SoftwareTokenMfaConfigTypeJsonMarshaller() {
    }

    public static SoftwareTokenMfaConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new SoftwareTokenMfaConfigTypeJsonMarshaller();
        }
        return instance;
    }

    public void marshall(SoftwareTokenMfaConfigType softwareTokenMfaConfigType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (softwareTokenMfaConfigType.getEnabled() != null) {
            Boolean enabled = softwareTokenMfaConfigType.getEnabled();
            awsJsonWriter.name("Enabled");
            awsJsonWriter.value(enabled.booleanValue());
        }
        awsJsonWriter.endObject();
    }
}

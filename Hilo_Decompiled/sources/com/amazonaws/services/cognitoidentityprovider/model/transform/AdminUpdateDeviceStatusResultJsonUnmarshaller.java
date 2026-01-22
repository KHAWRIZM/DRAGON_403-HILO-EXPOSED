package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminUpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller<AdminUpdateDeviceStatusResult, JsonUnmarshallerContext> {
    private static AdminUpdateDeviceStatusResultJsonUnmarshaller instance;

    public static AdminUpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminUpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminUpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminUpdateDeviceStatusResult();
    }
}

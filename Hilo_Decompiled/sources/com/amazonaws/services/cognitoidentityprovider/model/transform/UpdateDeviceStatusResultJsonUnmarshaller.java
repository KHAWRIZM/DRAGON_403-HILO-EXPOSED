package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateDeviceStatusResultJsonUnmarshaller implements Unmarshaller<UpdateDeviceStatusResult, JsonUnmarshallerContext> {
    private static UpdateDeviceStatusResultJsonUnmarshaller instance;

    public static UpdateDeviceStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateDeviceStatusResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateDeviceStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateDeviceStatusResult();
    }
}

package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminResetUserPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminResetUserPasswordResultJsonUnmarshaller implements Unmarshaller<AdminResetUserPasswordResult, JsonUnmarshallerContext> {
    private static AdminResetUserPasswordResultJsonUnmarshaller instance;

    public static AdminResetUserPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminResetUserPasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminResetUserPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminResetUserPasswordResult();
    }
}

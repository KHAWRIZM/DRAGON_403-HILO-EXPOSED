package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ChangePasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ChangePasswordResultJsonUnmarshaller implements Unmarshaller<ChangePasswordResult, JsonUnmarshallerContext> {
    private static ChangePasswordResultJsonUnmarshaller instance;

    public static ChangePasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ChangePasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public ChangePasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ChangePasswordResult();
    }
}

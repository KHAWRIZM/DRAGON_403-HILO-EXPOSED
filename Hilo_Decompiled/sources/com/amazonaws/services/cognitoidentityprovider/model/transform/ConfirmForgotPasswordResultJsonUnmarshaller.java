package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConfirmForgotPasswordResultJsonUnmarshaller implements Unmarshaller<ConfirmForgotPasswordResult, JsonUnmarshallerContext> {
    private static ConfirmForgotPasswordResultJsonUnmarshaller instance;

    public static ConfirmForgotPasswordResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmForgotPasswordResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public ConfirmForgotPasswordResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ConfirmForgotPasswordResult();
    }
}

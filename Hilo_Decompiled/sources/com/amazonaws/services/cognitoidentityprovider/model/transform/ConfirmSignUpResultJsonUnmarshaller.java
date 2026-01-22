package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConfirmSignUpResultJsonUnmarshaller implements Unmarshaller<ConfirmSignUpResult, JsonUnmarshallerContext> {
    private static ConfirmSignUpResultJsonUnmarshaller instance;

    public static ConfirmSignUpResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmSignUpResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public ConfirmSignUpResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new ConfirmSignUpResult();
    }
}

package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.VerifyUserAttributeResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerifyUserAttributeResultJsonUnmarshaller implements Unmarshaller<VerifyUserAttributeResult, JsonUnmarshallerContext> {
    private static VerifyUserAttributeResultJsonUnmarshaller instance;

    public static VerifyUserAttributeResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifyUserAttributeResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public VerifyUserAttributeResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new VerifyUserAttributeResult();
    }
}

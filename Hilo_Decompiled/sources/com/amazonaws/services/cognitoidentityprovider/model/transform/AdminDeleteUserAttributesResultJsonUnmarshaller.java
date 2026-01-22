package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminDeleteUserAttributesResultJsonUnmarshaller implements Unmarshaller<AdminDeleteUserAttributesResult, JsonUnmarshallerContext> {
    private static AdminDeleteUserAttributesResultJsonUnmarshaller instance;

    public static AdminDeleteUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminDeleteUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminDeleteUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminDeleteUserAttributesResult();
    }
}

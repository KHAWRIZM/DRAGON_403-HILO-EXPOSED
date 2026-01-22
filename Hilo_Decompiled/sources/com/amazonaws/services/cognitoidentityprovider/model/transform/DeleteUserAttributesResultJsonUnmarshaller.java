package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeleteUserAttributesResultJsonUnmarshaller implements Unmarshaller<DeleteUserAttributesResult, JsonUnmarshallerContext> {
    private static DeleteUserAttributesResultJsonUnmarshaller instance;

    public static DeleteUserAttributesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteUserAttributesResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public DeleteUserAttributesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteUserAttributesResult();
    }
}

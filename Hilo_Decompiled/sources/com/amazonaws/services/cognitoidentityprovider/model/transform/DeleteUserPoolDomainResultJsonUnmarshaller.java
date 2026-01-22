package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeleteUserPoolDomainResultJsonUnmarshaller implements Unmarshaller<DeleteUserPoolDomainResult, JsonUnmarshallerContext> {
    private static DeleteUserPoolDomainResultJsonUnmarshaller instance;

    public static DeleteUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public DeleteUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new DeleteUserPoolDomainResult();
    }
}

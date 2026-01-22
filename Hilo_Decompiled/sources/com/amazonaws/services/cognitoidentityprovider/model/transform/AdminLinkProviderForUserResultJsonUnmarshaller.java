package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminLinkProviderForUserResultJsonUnmarshaller implements Unmarshaller<AdminLinkProviderForUserResult, JsonUnmarshallerContext> {
    private static AdminLinkProviderForUserResultJsonUnmarshaller instance;

    public static AdminLinkProviderForUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminLinkProviderForUserResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminLinkProviderForUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminLinkProviderForUserResult();
    }
}

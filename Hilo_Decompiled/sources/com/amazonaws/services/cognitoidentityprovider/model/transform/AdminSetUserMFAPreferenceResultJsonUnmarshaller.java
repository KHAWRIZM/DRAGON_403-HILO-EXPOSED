package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminSetUserMFAPreferenceResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminSetUserMFAPreferenceResultJsonUnmarshaller implements Unmarshaller<AdminSetUserMFAPreferenceResult, JsonUnmarshallerContext> {
    private static AdminSetUserMFAPreferenceResultJsonUnmarshaller instance;

    public static AdminSetUserMFAPreferenceResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminSetUserMFAPreferenceResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminSetUserMFAPreferenceResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new AdminSetUserMFAPreferenceResult();
    }
}

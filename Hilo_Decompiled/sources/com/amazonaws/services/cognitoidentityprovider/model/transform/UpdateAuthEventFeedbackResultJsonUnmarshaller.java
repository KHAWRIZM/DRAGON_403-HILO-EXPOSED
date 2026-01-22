package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateAuthEventFeedbackResultJsonUnmarshaller implements Unmarshaller<UpdateAuthEventFeedbackResult, JsonUnmarshallerContext> {
    private static UpdateAuthEventFeedbackResultJsonUnmarshaller instance;

    public static UpdateAuthEventFeedbackResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateAuthEventFeedbackResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateAuthEventFeedbackResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new UpdateAuthEventFeedbackResult();
    }
}

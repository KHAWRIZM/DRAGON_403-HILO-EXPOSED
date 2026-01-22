package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminCreateUserResultJsonUnmarshaller implements Unmarshaller<AdminCreateUserResult, JsonUnmarshallerContext> {
    private static AdminCreateUserResultJsonUnmarshaller instance;

    public static AdminCreateUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminCreateUserResultJsonUnmarshaller();
        }
        return instance;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminCreateUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AdminCreateUserResult adminCreateUserResult = new AdminCreateUserResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("User")) {
                adminCreateUserResult.setUser(UserTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminCreateUserResult;
    }
}

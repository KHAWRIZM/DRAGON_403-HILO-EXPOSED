package com.amazonaws.auth.policy.conditions;

import com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class BooleanCondition extends Condition {
    public BooleanCondition(String str, boolean z10) {
        this.type = "Bool";
        this.conditionKey = str;
        this.values = Arrays.asList(Boolean.toString(z10));
    }
}

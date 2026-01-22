package com.tencent.imsdk.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ConversationAtInfo implements Serializable {
    public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
    public static final int TIM_AT_ALL = 2;
    public static final int TIM_AT_ALL_AT_ME = 3;
    public static final int TIM_AT_ME = 1;
    public static final int TIM_AT_UNKNOWN = 0;
    private long atMessageSequence;
    private List<Integer> atTypes = new ArrayList();

    protected void addAtType(int i) {
        this.atTypes.add(Integer.valueOf(i));
    }

    public long getAtMessageSequence() {
        return this.atMessageSequence;
    }

    public int getAtType() {
        Iterator<Integer> it = this.atTypes.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue == 1) {
                i |= 1;
            } else if (intValue == 2) {
                i |= 2;
            }
        }
        return i;
    }
}

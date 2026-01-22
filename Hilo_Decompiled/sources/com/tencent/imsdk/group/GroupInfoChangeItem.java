package com.tencent.imsdk.group;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class GroupInfoChangeItem implements Serializable {
    public static final int GROUP_INFO_CHANGE_TYPE_CUSTOM = 6;
    public static final int GROUP_INFO_CHANGE_TYPE_FACE = 4;
    public static final int GROUP_INFO_CHANGE_TYPE_GROUP_ADD_OPT = 11;
    public static final int GROUP_INFO_CHANGE_TYPE_GROUP_APPROVE_OPT = 12;
    public static final int GROUP_INFO_CHANGE_TYPE_INTRODUCTION = 2;
    public static final int GROUP_INFO_CHANGE_TYPE_NAME = 1;
    public static final int GROUP_INFO_CHANGE_TYPE_NOTIFICATION = 3;
    public static final int GROUP_INFO_CHANGE_TYPE_OWNER = 5;
    public static final int GROUP_INFO_CHANGE_TYPE_RECEIVE_MESSAGE_OPT = 10;
    public static final int GROUP_INFO_CHANGE_TYPE_SHUT_UP_ALL = 8;
    public static final int GROUP_INFO_CHANGE_TYPE_TOPIC_CUSTOM_DATA = 9;
    private boolean boolValueChanged;
    private String customInfoKey;
    private int groupInfoChangeType;
    private int intValueChanged;
    private long longValueChanged;
    private String valueChanged;

    public boolean getBoolValueChanged() {
        return this.boolValueChanged;
    }

    public String getCustomInfoKey() {
        return this.customInfoKey;
    }

    public int getGroupInfoChangeType() {
        return this.groupInfoChangeType;
    }

    public int getIntValueChanged() {
        return this.intValueChanged;
    }

    public long getLongValueChanged() {
        return this.longValueChanged;
    }

    public String getValueChanged() {
        return this.valueChanged;
    }

    public void setCustomInfoKey(String str) {
        this.customInfoKey = str;
    }

    public void setGroupInfoChangeType(int i) {
        this.groupInfoChangeType = i;
    }

    public void setValueChanged(String str) {
        this.valueChanged = str;
    }
}

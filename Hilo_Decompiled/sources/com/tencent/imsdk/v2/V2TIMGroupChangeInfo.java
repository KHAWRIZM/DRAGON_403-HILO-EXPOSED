package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMGroupChangeInfo implements Serializable {
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_CUSTOM = 6;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_DEFAULT_PERMISSIONS = 14;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_ENABLE_PERMISSION_GROUP = 13;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_FACE_URL = 4;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_GROUP_ADD_OPT = 11;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_GROUP_APPROVE_OPT = 12;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_INTRODUCTION = 2;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_NAME = 1;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_NOTIFICATION = 3;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_OWNER = 5;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_RECEIVE_MESSAGE_OPT = 10;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_SHUT_UP_ALL = 8;
    public static final int V2TIM_GROUP_INFO_CHANGE_TYPE_TOPIC_CUSTOM_DATA = 9;
    public static final int V2TIM_GROUP_INFO_INVALID = 0;
    private GroupInfoChangeItem groupInfoChangeItem = new GroupInfoChangeItem();

    public boolean getBoolValue() {
        return this.groupInfoChangeItem.getBoolValueChanged();
    }

    GroupInfoChangeItem getGroupInfoChangeItem() {
        return this.groupInfoChangeItem;
    }

    public int getIntValue() {
        int groupInfoChangeType = this.groupInfoChangeItem.getGroupInfoChangeType();
        if (groupInfoChangeType != 11 && groupInfoChangeType != 12) {
            return this.groupInfoChangeItem.getIntValueChanged();
        }
        int intValueChanged = this.groupInfoChangeItem.getIntValueChanged();
        if (intValueChanged == GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY) {
            return 2;
        }
        if (intValueChanged == GroupInfo.GROUP_ADD_OPTION_FORBID_ANY) {
            return 0;
        }
        if (intValueChanged != GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION) {
            return 2;
        }
        return 1;
    }

    public String getKey() {
        return this.groupInfoChangeItem.getCustomInfoKey();
    }

    public long getLongValue() {
        return this.groupInfoChangeItem.getLongValueChanged();
    }

    public int getType() {
        return this.groupInfoChangeItem.getGroupInfoChangeType();
    }

    public String getValue() {
        return this.groupInfoChangeItem.getValueChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupInfoChangeItem(GroupInfoChangeItem groupInfoChangeItem) {
        this.groupInfoChangeItem = groupInfoChangeItem;
    }
}

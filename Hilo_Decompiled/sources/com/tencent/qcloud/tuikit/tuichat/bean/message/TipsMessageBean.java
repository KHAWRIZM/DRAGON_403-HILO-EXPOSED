package com.tencent.qcloud.tuikit.tuichat.bean.message;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMGroupChangeInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberChangeInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfo;
import com.tencent.imsdk.v2.V2TIMGroupTipsElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TipsMessageBean extends TUIMessageBean {
    public static final int MSG_TYPE_GROUP_CREATE = 257;
    public static final int MSG_TYPE_GROUP_DELETE = 258;
    public static final int MSG_TYPE_GROUP_JOIN = 259;
    public static final int MSG_TYPE_GROUP_KICK = 261;
    public static final int MSG_TYPE_GROUP_MODIFY_NAME = 262;
    public static final int MSG_TYPE_GROUP_MODIFY_NOTICE = 263;
    public static final int MSG_TYPE_GROUP_QUITE = 260;
    private String text;
    private int tipType;

    private static String getDisplayName(V2TIMGroupMemberInfo v2TIMGroupMemberInfo) {
        if (v2TIMGroupMemberInfo == null) {
            return null;
        }
        if (!TextUtils.isEmpty(v2TIMGroupMemberInfo.getNameCard())) {
            return v2TIMGroupMemberInfo.getNameCard();
        }
        if (!TextUtils.isEmpty(v2TIMGroupMemberInfo.getFriendRemark())) {
            return v2TIMGroupMemberInfo.getFriendRemark();
        }
        if (!TextUtils.isEmpty(v2TIMGroupMemberInfo.getNickName())) {
            return v2TIMGroupMemberInfo.getNickName();
        }
        return v2TIMGroupMemberInfo.getUserID();
    }

    public String getText() {
        return this.text;
    }

    public int getTipType() {
        return this.tipType;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    public String onGetDisplayString() {
        return getExtra();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x033d A[SYNTHETIC] */
    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        String str;
        V2TIMGroupTipsElem groupTipsElem = v2TIMMessage.getGroupTipsElem();
        if (groupTipsElem == null) {
            return;
        }
        int type = groupTipsElem.getType();
        String str2 = "";
        int i = 3;
        if (groupTipsElem.getMemberList().size() <= 0) {
            str = "";
        } else {
            List<V2TIMGroupMemberInfo> memberList = groupTipsElem.getMemberList();
            str = "";
            int i2 = 0;
            while (true) {
                if (i2 >= memberList.size()) {
                    break;
                }
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = memberList.get(i2);
                if (i2 == 0) {
                    str = str + getDisplayName(v2TIMGroupMemberInfo);
                } else {
                    if (i2 == 2 && memberList.size() > 3) {
                        str = str + ServiceInitializer.getAppContext().getString(R.string.etc);
                        break;
                    }
                    str = str + "，" + getDisplayName(v2TIMGroupMemberInfo);
                }
                i2++;
            }
        }
        String displayName = getDisplayName(groupTipsElem.getOpMember());
        if (!TextUtils.isEmpty(str)) {
            str = TUIChatConstants.covert2HTMLString(str);
        }
        if (!TextUtils.isEmpty(displayName)) {
            displayName = TUIChatConstants.covert2HTMLString(displayName);
        }
        int i3 = 1;
        if (type == 1) {
            setTipType(259);
            str2 = str + ServiceInitializer.getAppContext().getString(R.string.join_group);
        }
        if (type == 2) {
            setTipType(259);
            str2 = str + ServiceInitializer.getAppContext().getString(R.string.invite_joined_group);
        }
        if (type == 3) {
            setTipType(260);
            str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.quit_group);
        }
        if (type == 4) {
            setTipType(MSG_TYPE_GROUP_KICK);
            str2 = str + ServiceInitializer.getAppContext().getString(R.string.kick_group_tip);
        }
        if (type == 5) {
            setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
            str2 = str + ServiceInitializer.getAppContext().getString(R.string.be_group_manager);
        }
        if (type == 6) {
            setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
            str2 = str + ServiceInitializer.getAppContext().getString(R.string.cancle_group_manager);
        }
        if (type == 7) {
            List<V2TIMGroupChangeInfo> groupChangeInfoList = groupTipsElem.getGroupChangeInfoList();
            int i4 = 0;
            while (i4 < groupChangeInfoList.size()) {
                V2TIMGroupChangeInfo v2TIMGroupChangeInfo = groupChangeInfoList.get(i4);
                int type2 = v2TIMGroupChangeInfo.getType();
                if (type2 == i3) {
                    setTipType(MSG_TYPE_GROUP_MODIFY_NAME);
                    str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.modify_group_name_is) + "\"" + v2TIMGroupChangeInfo.getValue() + "\"";
                } else if (type2 == i) {
                    setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                    str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.modify_notice) + "\"" + v2TIMGroupChangeInfo.getValue() + "\"";
                } else if (type2 == 5) {
                    setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                    if (!TextUtils.isEmpty(str)) {
                        str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.move_owner) + "\"" + str + "\"";
                    } else {
                        str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.move_owner) + "\"" + TUIChatConstants.covert2HTMLString(v2TIMGroupChangeInfo.getValue()) + "\"";
                    }
                } else if (type2 == 4) {
                    setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                    str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.modify_group_avatar);
                } else {
                    if (type2 == 2) {
                        setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                        str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.modify_introduction) + "\"" + v2TIMGroupChangeInfo.getValue() + "\"";
                    } else if (type2 == 8) {
                        setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                        if (v2TIMGroupChangeInfo.getBoolValue()) {
                            str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.modify_shut_up_all);
                        } else {
                            str2 = displayName + ServiceInitializer.getAppContext().getString(R.string.modify_cancel_shut_up_all);
                        }
                    } else if (type2 == 11) {
                        setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                        String string = ServiceInitializer.getAppContext().getString(R.string.modify_group_add_opt);
                        int intValue = v2TIMGroupChangeInfo.getIntValue();
                        if (intValue == 0) {
                            str2 = string + ServiceInitializer.getAppContext().getString(R.string.group_add_opt_join_disable);
                        } else if (intValue == 1) {
                            str2 = string + ServiceInitializer.getAppContext().getString(R.string.group_add_opt_admin_approve);
                        } else {
                            str2 = string + ServiceInitializer.getAppContext().getString(R.string.group_add_opt_auto_approval);
                        }
                    }
                    if (i4 >= groupChangeInfoList.size() - 1) {
                        str2 = str2 + "、";
                    }
                    i4++;
                    i = 3;
                    i3 = 1;
                }
                if (i4 >= groupChangeInfoList.size() - 1) {
                }
                i4++;
                i = 3;
                i3 = 1;
            }
        }
        if (type == 8) {
            List<V2TIMGroupMemberChangeInfo> memberChangeInfoList = groupTipsElem.getMemberChangeInfoList();
            if (memberChangeInfoList.size() > 0) {
                long muteTime = memberChangeInfoList.get(0).getMuteTime();
                setTipType(MSG_TYPE_GROUP_MODIFY_NOTICE);
                if (muteTime > 0) {
                    str2 = str + ServiceInitializer.getAppContext().getString(R.string.banned) + "\"" + DateTimeUtil.formatSeconds(muteTime) + "\"";
                } else {
                    str2 = str + ServiceInitializer.getAppContext().getString(R.string.cancle_banned);
                }
            }
        }
        this.text = str2;
        setExtra(str2);
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTipType(int i) {
        this.tipType = i;
    }
}

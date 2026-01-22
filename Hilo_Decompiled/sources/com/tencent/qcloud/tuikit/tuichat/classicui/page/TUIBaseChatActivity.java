package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.activities.BaseLightActivity;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.DraftInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class TUIBaseChatActivity extends BaseLightActivity {
    private static final String TAG = "TUIBaseChatActivity";

    /* JADX WARN: Multi-variable type inference failed */
    private void chat(Intent intent) {
        Bundle extras = intent.getExtras();
        String str = TAG;
        TUIChatLog.i(str, "bundle: " + extras + " intent: " + intent);
        if (!TUILogin.isUserLogined()) {
            ToastUtil.toastShortMessage(getString(R.string.chat_tips_not_login));
            finish();
            return;
        }
        ChatInfo chatInfo = getChatInfo(intent);
        TUIChatLog.i(str, "start chatActivity chatInfo: " + chatInfo);
        if (chatInfo != null) {
            initChat(chatInfo);
            return;
        }
        ToastUtil.toastShortMessage("init chat failed , chatInfo is empty.");
        TUIChatLog.e(str, "init chat failed , chatInfo is empty.");
        finish();
    }

    private ChatInfo getChatInfo(Intent intent) {
        ChatInfo groupInfo;
        int intExtra = intent.getIntExtra(TUIConstants.TUIChat.CHAT_TYPE, 0);
        if (intExtra == 1) {
            groupInfo = new ChatInfo();
        } else {
            if (intExtra != 2) {
                return null;
            }
            groupInfo = new GroupInfo();
        }
        groupInfo.setType(intExtra);
        groupInfo.setId(intent.getStringExtra("chatId"));
        groupInfo.setChatName(intent.getStringExtra(TUIConstants.TUIChat.CHAT_NAME));
        DraftInfo draftInfo = new DraftInfo();
        draftInfo.setDraftText(intent.getStringExtra(TUIConstants.TUIChat.DRAFT_TEXT));
        draftInfo.setDraftTime(intent.getLongExtra(TUIConstants.TUIChat.DRAFT_TIME, 0L));
        groupInfo.setDraft(draftInfo);
        groupInfo.setTopChat(intent.getBooleanExtra(TUIConstants.TUIChat.IS_TOP_CHAT, false));
        groupInfo.setLocateMessage(ChatMessageBuilder.buildMessage((V2TIMMessage) intent.getSerializableExtra(TUIConstants.TUIChat.LOCATE_MESSAGE)));
        groupInfo.setAtInfoList((List) intent.getSerializableExtra(TUIConstants.TUIChat.AT_INFO_LIST));
        groupInfo.setFaceUrl(intent.getStringExtra(TUIConstants.TUIChat.FACE_URL));
        if (intExtra == 2) {
            GroupInfo groupInfo2 = (GroupInfo) groupInfo;
            groupInfo2.setGroupName(intent.getStringExtra("groupName"));
            groupInfo2.setGroupType(intent.getStringExtra(TUIConstants.TUIChat.GROUP_TYPE));
            groupInfo2.setJoinType(intent.getIntExtra(TUIConstants.TUIChat.JOIN_TYPE, 0));
            groupInfo2.setMemberCount(intent.getIntExtra(TUIConstants.TUIChat.MEMBER_COUNT, 0));
            groupInfo2.setMessageReceiveOption(intent.getBooleanExtra(TUIConstants.TUIChat.RECEIVE_OPTION, false));
            groupInfo2.setNotice(intent.getStringExtra(TUIConstants.TUIChat.NOTICE));
            groupInfo2.setOwner(intent.getStringExtra(TUIConstants.TUIChat.OWNER));
            groupInfo2.setMemberDetails((List) intent.getSerializableExtra(TUIConstants.TUIChat.MEMBER_DETAILS));
        }
        if (TextUtils.isEmpty(groupInfo.getId())) {
            return null;
        }
        return groupInfo;
    }

    public abstract void initChat(ChatInfo chatInfo);

    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList<String> stringArrayListExtra;
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 == 3 && intent != null && i == 11 && (stringArrayListExtra = intent.getStringArrayListExtra("list")) != null && !stringArrayListExtra.isEmpty()) {
            intent.putExtra(TUIConstants.TUICalling.PARAM_NAME_USERIDS, (String[]) stringArrayListExtra.toArray(new String[0]));
            HashMap hashMap = new HashMap();
            for (String str : intent.getExtras().keySet()) {
                hashMap.put(str, intent.getExtras().get(str));
            }
            TUICore.callService("TUICallingService", TUIConstants.TUICalling.METHOD_NAME_CALL, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity
    public void onCreate(Bundle bundle) {
        TUIChatLog.i(TAG, "onCreate " + this);
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity);
        chat(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        TUIChatLog.i(TAG, "onNewIntent");
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        chat(intent);
    }

    protected void onResume() {
        TUIChatLog.i(TAG, "onResume");
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
    }
}

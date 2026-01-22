package com.tencent.imsdk.community;

import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class CommunityListener {
    public void onAddMembersToPermissionGroup(String str, String str2, List<String> list) {
    }

    public void onAddTopicPermission(String str, String str2, HashMap<String, Long> hashMap) {
    }

    public void onChangePermissionGroupInfo(String str, PermissionGroupInfo permissionGroupInfo) {
    }

    public void onChangeTopicInfo(String str, TopicInfo topicInfo) {
    }

    public void onCreatePermissionGroup(String str, PermissionGroupInfo permissionGroupInfo) {
    }

    public void onCreateTopic(String str, String str2) {
    }

    public void onDeletePermissionGroup(String str, List<String> list) {
    }

    public void onDeleteTopic(String str, List<String> list) {
    }

    public void onDeleteTopicPermission(String str, String str2, List<String> list) {
    }

    public void onModifyTopicPermission(String str, String str2, HashMap<String, Long> hashMap) {
    }

    public void onReceiveTopicRESTCustomData(String str, byte[] bArr) {
    }

    public void onRemoveMembersFromPermissionGroup(String str, String str2, List<String> list) {
    }
}

package com.tencent.qcloud.tuikit.tuichat.component.face;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceGroup {
    private String desc;
    private String faceGroupIconUrl;
    private final Map<String, ChatFace> faces = new LinkedHashMap();
    private int groupID;
    private String groupName;
    private int pageColumnCount;
    private int pageRowCount;

    public void addFace(String str, ChatFace chatFace) {
        chatFace.setFaceGroup(this);
        this.faces.put(str, chatFace);
    }

    public String getDesc() {
        return this.desc;
    }

    public ChatFace getFace(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ChatFace chatFace = this.faces.get(str);
        if (chatFace == null) {
            int lastIndexOf = str.lastIndexOf("@2x");
            if (lastIndexOf == -1) {
                return null;
            }
            return this.faces.get(str.substring(0, lastIndexOf));
        }
        return chatFace;
    }

    public String getFaceGroupIconUrl() {
        return this.faceGroupIconUrl;
    }

    public ArrayList<ChatFace> getFaces() {
        return new ArrayList<>(this.faces.values());
    }

    public int getGroupID() {
        return this.groupID;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getPageColumnCount() {
        return this.pageColumnCount;
    }

    public int getPageRowCount() {
        return this.pageRowCount;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFaceGroupIconUrl(String str) {
        this.faceGroupIconUrl = str;
    }

    public void setGroupID(int i) {
        this.groupID = i;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setPageColumnCount(int i) {
        this.pageColumnCount = i;
    }

    public void setPageRowCount(int i) {
        this.pageRowCount = i;
    }
}

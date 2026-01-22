package com.tencent.qcloud.tuikit.tuichat.util;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TUIChatUtils {
    public static final String SPLIT_TEXT = "split_result";
    public static final String SPLIT_TEXT_FOR_TRANSLATION = "split_translation";
    public static final String SPLIT_TEXT_INDEX_FOR_TRANSLATION = "split_translation_index";

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, String str, int i, String str2) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(str, i, ErrorMessageConverter.convertIMError(i, str2));
        }
    }

    public static void callbackOnProgress(IUIKitCallback iUIKitCallback, Object obj) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onProgress(obj);
        }
    }

    public static <T> void callbackOnSuccess(IUIKitCallback<T> iUIKitCallback, T t) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(t);
        }
    }

    public static String getConversationIdByUserId(String str, boolean z) {
        String str2;
        if (z) {
            str2 = TUIConstants.TUIConversation.CONVERSATION_GROUP_PREFIX;
        } else {
            str2 = TUIConstants.TUIConversation.CONVERSATION_C2C_PREFIX;
        }
        return str2 + str;
    }

    public static String getGroupIDFromTopicID(String str) {
        return str.substring(0, str.indexOf("@TOPIC#_"));
    }

    public static String getOriginImagePath(TUIMessageBean tUIMessageBean) {
        V2TIMMessage v2TIMMessage;
        V2TIMImageElem imageElem;
        String str = null;
        if (tUIMessageBean == null || (v2TIMMessage = tUIMessageBean.getV2TIMMessage()) == null || (imageElem = v2TIMMessage.getImageElem()) == null) {
            return null;
        }
        String localImagePath = ChatMessageParser.getLocalImagePath(tUIMessageBean);
        if (localImagePath == null) {
            Iterator<V2TIMImageElem.V2TIMImage> it = imageElem.getImageList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                V2TIMImageElem.V2TIMImage next = it.next();
                if (next.getType() == 0) {
                    str = next.getUUID();
                    break;
                }
            }
            String generateImagePath = ImageUtil.generateImagePath(str, 0);
            if (new File(generateImagePath).exists()) {
                return generateImagePath;
            }
            return localImagePath;
        }
        return localImagePath;
    }

    public static long getServerTime() {
        return V2TIMManager.getInstance().getServerTime();
    }

    public static boolean isC2CChat(int i) {
        return i == 1;
    }

    public static boolean isCommunityGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("@TGS#_");
    }

    public static boolean isGroupChat(int i) {
        return i == 2;
    }

    public static boolean isTopicGroup(String str) {
        if (!isCommunityGroup(str)) {
            return false;
        }
        return str.contains("@TOPIC#_");
    }

    public static List<String> splitByKeyList(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        if (list != null && !list.isEmpty()) {
            int i = 0;
            for (String str2 : list) {
                int indexOf = str.indexOf(str2, i);
                if (indexOf >= 0) {
                    if (i < indexOf) {
                        arrayList.add(str.substring(i, indexOf));
                    }
                    arrayList.add(str2);
                    i = indexOf + str2.length();
                }
            }
            if (i < str.length()) {
                arrayList.add(str.substring(i));
            }
            return arrayList;
        }
        arrayList.add(str);
        return arrayList;
    }

    public static HashMap<String, List<String>> splitTextByEmojiAndAtUsers(String str, List<String> list) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add("@" + it.next());
            }
        }
        List<String> splitByKeyList = splitByKeyList(arrayList2, str);
        ArrayList arrayList3 = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < splitByKeyList.size(); i2++) {
            String str4 = splitByKeyList.get(i2);
            if (arrayList2.size() <= 0) {
                str2 = "";
            } else {
                str2 = (String) arrayList2.get(0);
            }
            if (!TextUtils.isEmpty(str2) && str4.equals(str2)) {
                arrayList.add(str4);
                arrayList2.remove(0);
            } else {
                List<String> findEmojiKeyListFromText = FaceManager.findEmojiKeyListFromText(str4);
                if (findEmojiKeyListFromText != null && findEmojiKeyListFromText.size() > 0) {
                    List<String> splitByKeyList2 = splitByKeyList(findEmojiKeyListFromText, str4);
                    for (int i3 = 0; i3 < splitByKeyList2.size(); i3++) {
                        String str5 = splitByKeyList2.get(i3);
                        arrayList.add(str5);
                        if (findEmojiKeyListFromText.size() <= 0) {
                            str3 = "";
                        } else {
                            str3 = findEmojiKeyListFromText.get(0);
                        }
                        if (!TextUtils.isEmpty(str3) && str5.equals(str3)) {
                            findEmojiKeyListFromText.remove(0);
                        } else {
                            arrayList3.add(String.valueOf(i));
                        }
                        i++;
                    }
                } else {
                    if (!TextUtils.isEmpty(str4.trim())) {
                        arrayList3.add(String.valueOf(i));
                    }
                    arrayList.add(str4);
                }
            }
            i++;
        }
        ArrayList arrayList4 = new ArrayList();
        for (int i4 = 0; i4 < arrayList3.size(); i4++) {
            arrayList4.add((String) arrayList.get(Integer.valueOf((String) arrayList3.get(i4)).intValue()));
        }
        hashMap.put(SPLIT_TEXT, arrayList);
        hashMap.put(SPLIT_TEXT_FOR_TRANSLATION, arrayList4);
        hashMap.put(SPLIT_TEXT_INDEX_FOR_TRANSLATION, arrayList3);
        return hashMap;
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i, String str, T t) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(i, ErrorMessageConverter.convertIMError(i, str), (String) t);
        }
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i, String str) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError((String) null, i, ErrorMessageConverter.convertIMError(i, str));
        }
    }
}

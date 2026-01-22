package com.tencent.qcloud.tuikit.tuichat.component.face;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import c5.h;
import com.bumptech.glide.Glide;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceManager {
    private static final int EMOJI_COLUMN_COUNT = 8;
    public static final int EMOJI_GROUP_ID = 0;
    private static final int EMOJI_ROW_COUNT = 3;
    private static final int EMOJI_SIZE = 20;
    private static final String TAG = "FaceManager";
    private final Context context;
    private final String[] emojiKeys;
    private final Map<String, Emoji> emojiMap;
    private final String[] emojiNames;
    private final Map<Integer, FaceGroup> faceGroupMap;
    private boolean needLoad;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class EmojiData {
        private String emojiText;
        private int end;
        private int start;

        public String getEmojiText() {
            return this.emojiText;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public void setEmojiText(String str) {
            this.emojiText = str;
        }

        public void setEnd(int i) {
            this.end = i;
        }

        public void setStart(int i) {
            this.start = i;
        }

        private EmojiData() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class FaceManagerHolder {

        @SuppressLint({"StaticFieldLeak"})
        private static final FaceManager instance = new FaceManager();

        private FaceManagerHolder() {
        }
    }

    public static void addFaceGroup(int i, FaceGroup faceGroup) {
        faceGroup.setGroupID(i);
        getInstance().faceGroupMap.put(Integer.valueOf(i), faceGroup);
    }

    public static String emojiJudge(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] emojiKey = getEmojiKey();
        if (emojiKey != null && emojiKey.length != 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(str);
            ArrayList arrayList = new ArrayList();
            int i = -1;
            while (matcher.find()) {
                String group = matcher.group();
                if (i != -1) {
                    indexOf = str.indexOf(group, i);
                } else {
                    indexOf = str.indexOf(group);
                }
                int length = group.length() + indexOf;
                int findEmoji = findEmoji(group);
                String[] emojiNames = getEmojiNames();
                if (findEmoji != -1 && emojiNames != null && emojiNames.length >= findEmoji) {
                    group = emojiNames[findEmoji];
                }
                EmojiData emojiData = new EmojiData();
                emojiData.setStart(indexOf);
                emojiData.setEnd(length);
                emojiData.setEmojiText(group);
                arrayList.add(emojiData);
                i = length;
            }
            if (arrayList.isEmpty()) {
                return str;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                EmojiData emojiData2 = (EmojiData) arrayList.get(size);
                String emojiText = emojiData2.getEmojiText();
                int start = emojiData2.getStart();
                int end = emojiData2.getEnd();
                if (!TextUtils.isEmpty(emojiText) && start != -1 && end != -1) {
                    spannableStringBuilder.replace(start, end, (CharSequence) emojiText);
                }
            }
            return spannableStringBuilder.toString();
        }
        return str;
    }

    private static int findEmoji(String str) {
        String[] emojiKey;
        if (TextUtils.isEmpty(str) || (emojiKey = getEmojiKey()) == null || emojiKey.length == 0) {
            return -1;
        }
        for (int i = 0; i < emojiKey.length; i++) {
            if (str.equals(emojiKey[i])) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> findEmojiKeyListFromText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            Emoji emoji = getEmojiMap().get(group);
            if (emoji != null && emoji.getIcon() != null) {
                arrayList.add(group);
            }
        }
        Matcher matcher2 = Pattern.compile(getRegexOfUniversalEmoji()).matcher(str);
        while (matcher2.find()) {
            if (!TextUtils.isEmpty(matcher2.group())) {
                arrayList.add(matcher2.group());
            }
        }
        return arrayList;
    }

    public static Bitmap getEmoji(String str) {
        Emoji emoji = getEmojiMap().get(str);
        if (emoji != null) {
            return emoji.getIcon();
        }
        return null;
    }

    public static String[] getEmojiKey() {
        return getInstance().emojiKeys;
    }

    public static ArrayList<Emoji> getEmojiList() {
        return new ArrayList<>(getInstance().emojiMap.values());
    }

    public static Map<String, Emoji> getEmojiMap() {
        return getInstance().emojiMap;
    }

    public static String[] getEmojiNames() {
        return getInstance().emojiNames;
    }

    public static List<FaceGroup> getFaceGroupList() {
        return new ArrayList(getInstance().faceGroupMap.values());
    }

    public static FaceManager getInstance() {
        return FaceManagerHolder.instance;
    }

    private static String getRegexOfUniversalEmoji() {
        String str = "[[\\U0001F1E6-\\U0001F1FF]][[\\U0001F1E6-\\U0001F1FF]]";
        String str2 = "[" + ("0x0023|0x002A|[0x0030-0x0039]|\\U000000A9|\\U000000AE|\\u203C|\\u2049|\\u2122|\\u2139|[\\u2194-\\u2199]|[\\u21A9-\\u21AA]|[\\u231A-\\u231B]|\\u2328|\\u23CF|[\\u23E9-\\u23EF]|[\\u23F0-\\u23F3]|[\\u23F8-\\u23FA]|\\u24C2|[\\u25AA-\\u25AB]|\\u25B6|\\u25C0|[\\u25FB-\\u25FE]|[\\u2600-\\u2604]|\\u260E|\\u2611|[\\u2614-\\u2615]|\\u2618|\\u261D|\\u2620|[\\u2622-\\u2623]|\\u2626|\\u262A|[\\u262E-\\u262F]|[\\u2638-\\u263A]|\\u2640|\\u2642|[\\u2648-\\u264F]|[\\u2650-\\u2653]|\\u265F|\\u2660|\\u2663|[\\u2665-\\u2666]|\\u2668|\\u267B|[\\u267E-\\u267F]|[\\u2692-\\u2697]|\\u2699|[\\u269B-\\u269C]|[\\u26A0-\\u26A1]|\\u26A7|[\\u26AA-\\u26AB]|[\\u26B0-\\u26B1]|[\\u26BD-\\u26BE]|[\\u26C4-\\u26C5]|\\u26C8|[\\u26CE-\\u26CF]|\\u26D1|[\\u26D3-\\u26D4]|[\\u26E9-\\u26EA]|[\\u26F0-\\u26F5]|[\\u26F7-\\u26FA]|\\u26FD|\\u2702|\\u2705|[\\u2708-\\u270D]|\\u270F|\\u2712|\\u2714|\\u2716|\\u271D|\\u2721|\\u2728|[\\u2733-\\u2734]|\\u2744|\\u2747|\\u274C|\\u274E|[\\u2753-\\u2755]|\\u2757|[\\u2763-\\u2764]|[\\u2795-\\u2797]|\\u27A1|\\u27B0|\\u27BF|[\\u2934-\\u2935]|[\\u2B05-\\u2B07]|[\\u2B1B-\\u2B1C]|\\u2B50|\\u2B55|\\u3030|\\u303D|\\u3297|\\u3299|\\U0001F004|\\U0001F0CF|[\\U0001F170-\\U0001F171]|[\\U0001F17E-\\U0001F17F]|\\U0001F18E|[\\U0001F191-\\U0001F19A]|[\\U0001F1E6-\\U0001F1FF]|[\\U0001F201-\\U0001F202]|\\U0001F21A|\\U0001F22F|[\\U0001F232-\\U0001F23A]|[\\U0001F250-\\U0001F251]|[\\U0001F300-\\U0001F30F]|[\\U0001F310-\\U0001F31F]|[\\U0001F320-\\U0001F321]|[\\U0001F324-\\U0001F32F]|[\\U0001F330-\\U0001F33F]|[\\U0001F340-\\U0001F34F]|[\\U0001F350-\\U0001F35F]|[\\U0001F360-\\U0001F36F]|[\\U0001F370-\\U0001F37F]|[\\U0001F380-\\U0001F38F]|[\\U0001F390-\\U0001F393]|[\\U0001F396-\\U0001F397]|[\\U0001F399-\\U0001F39B]|[\\U0001F39E-\\U0001F39F]|[\\U0001F3A0-\\U0001F3AF]|[\\U0001F3B0-\\U0001F3BF]|[\\U0001F3C0-\\U0001F3CF]|[\\U0001F3D0-\\U0001F3DF]|[\\U0001F3E0-\\U0001F3EF]|\\U0001F3F0|[\\U0001F3F3-\\U0001F3F5]|[\\U0001F3F7-\\U0001F3FF]|[\\U0001F400-\\U0001F40F]|[\\U0001F410-\\U0001F41F]|[\\U0001F420-\\U0001F42F]|[\\U0001F430-\\U0001F43F]|[\\U0001F440-\\U0001F44F]|[\\U0001F450-\\U0001F45F]|[\\U0001F460-\\U0001F46F]|[\\U0001F470-\\U0001F47F]|[\\U0001F480-\\U0001F48F]|[\\U0001F490-\\U0001F49F]|[\\U0001F4A0-\\U0001F4AF]|[\\U0001F4B0-\\U0001F4BF]|[\\U0001F4C0-\\U0001F4CF]|[\\U0001F4D0-\\U0001F4DF]|[\\U0001F4E0-\\U0001F4EF]|[\\U0001F4F0-\\U0001F4FF]|[\\U0001F500-\\U0001F50F]|[\\U0001F510-\\U0001F51F]|[\\U0001F520-\\U0001F52F]|[\\U0001F530-\\U0001F53D]|[\\U0001F549-\\U0001F54E]|[\\U0001F550-\\U0001F55F]|[\\U0001F560-\\U0001F567]|\\U0001F56F|\\U0001F570|[\\U0001F573-\\U0001F57A]|\\U0001F587|[\\U0001F58A-\\U0001F58D]|\\U0001F590|[\\U0001F595-\\U0001F596]|[\\U0001F5A4-\\U0001F5A5]|\\U0001F5A8|[\\U0001F5B1-\\U0001F5B2]|\\U0001F5BC|[\\U0001F5C2-\\U0001F5C4]|[\\U0001F5D1-\\U0001F5D3]|[\\U0001F5DC-\\U0001F5DE]|\\U0001F5E1|\\U0001F5E3|\\U0001F5E8|\\U0001F5EF|\\U0001F5F3|[\\U0001F5FA-\\U0001F5FF]|[\\U0001F600-\\U0001F60F]|[\\U0001F610-\\U0001F61F]|[\\U0001F620-\\U0001F62F]|[\\U0001F630-\\U0001F63F]|[\\U0001F640-\\U0001F64F]|[\\U0001F650-\\U0001F65F]|[\\U0001F660-\\U0001F66F]|[\\U0001F670-\\U0001F67F]|[\\U0001F680-\\U0001F68F]|[\\U0001F690-\\U0001F69F]|[\\U0001F6A0-\\U0001F6AF]|[\\U0001F6B0-\\U0001F6BF]|[\\U0001F6C0-\\U0001F6C5]|[\\U0001F6CB-\\U0001F6CF]|[\\U0001F6D0-\\U0001F6D2]|[\\U0001F6D5-\\U0001F6D7]|[\\U0001F6DD-\\U0001F6DF]|[\\U0001F6E0-\\U0001F6E5]|\\U0001F6E9|[\\U0001F6EB-\\U0001F6EC]|\\U0001F6F0|[\\U0001F6F3-\\U0001F6FC]|[\\U0001F7E0-\\U0001F7EB]|\\U0001F7F0|[\\U0001F90C-\\U0001F90F]|[\\U0001F910-\\U0001F91F]|[\\U0001F920-\\U0001F92F]|[\\U0001F930-\\U0001F93A]|[\\U0001F93C-\\U0001F93F]|[\\U0001F940-\\U0001F945]|[\\U0001F947-\\U0001F94C]|[\\U0001F94D-\\U0001F94F]|[\\U0001F950-\\U0001F95F]|[\\U0001F960-\\U0001F96F]|[\\U0001F970-\\U0001F97F]|[\\U0001F980-\\U0001F98F]|[\\U0001F990-\\U0001F99F]|[\\U0001F9A0-\\U0001F9AF]|[\\U0001F9B0-\\U0001F9BF]|[\\U0001F9C0-\\U0001F9CF]|[\\U0001F9D0-\\U0001F9DF]|[\\U0001F9E0-\\U0001F9EF]|[\\U0001F9F0-\\U0001F9FF]|[\\U0001FA70-\\U0001FA74]|[\\U0001FA78-\\U0001FA7C]|[\\U0001FA80-\\U0001FA86]|[\\U0001FA90-\\U0001FA9F]|[\\U0001FAA0-\\U0001FAAC]|[\\U0001FAB0-\\U0001FABA]|[\\U0001FAC0-\\U0001FAC5]|[\\U0001FAD0-\\U0001FAD9]|[\\U0001FAE0-\\U0001FAE7]|[\\U0001FAF0-\\U0001FAF6]") + "]([[\\U0001F3FB-\\U0001F3FF]]|\\uFE0F\\u20E3?|[[\\U000E0020-\\U000E007E]]+\\U000E007F?)?";
        return str + "|" + str2 + "(\\u200D(" + str + "|" + str2 + "))*";
    }

    public static boolean handlerEmojiText(TextView textView, CharSequence charSequence, boolean z) {
        Spannable spannableStringBuilder;
        Bitmap icon;
        if (charSequence == null) {
            textView.setText((CharSequence) null);
            return false;
        }
        if ((textView instanceof EditText) && (charSequence instanceof Editable)) {
            spannableStringBuilder = (Editable) charSequence;
            for (ImageSpan imageSpan : (ImageSpan[]) spannableStringBuilder.getSpans(0, charSequence.length(), ImageSpan.class)) {
                spannableStringBuilder.removeSpan(imageSpan);
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        }
        Matcher matcher = Pattern.compile("\\[(\\S+?)\\]").matcher(charSequence);
        boolean z2 = false;
        while (matcher.find()) {
            Emoji emoji = getEmojiMap().get(matcher.group());
            if (emoji != null && (icon = emoji.getIcon()) != null) {
                spannableStringBuilder.setSpan(new ImageSpan(getInstance().context, icon), matcher.start(), matcher.end(), 17);
                z2 = true;
            }
        }
        if (!z2 && z) {
            return false;
        }
        int selectionStart = textView.getSelectionStart();
        boolean z3 = textView instanceof EditText;
        if (!z3) {
            textView.setText(spannableStringBuilder);
        }
        if (z3) {
            ((EditText) textView).setSelection(selectionStart);
        }
        return true;
    }

    private synchronized void internalLoadEmojis() {
        if (!this.needLoad) {
            return;
        }
        this.needLoad = false;
        TUIChatLog.i(TAG, "start load emojis");
        Thread thread = new Thread() { // from class: com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                FaceGroup faceGroup = new FaceGroup();
                for (String str : FaceManager.getInstance().emojiKeys) {
                    Emoji loadAssetEmoji = FaceManager.this.loadAssetEmoji(str, "emoji/" + str + "@2x.png");
                    if (loadAssetEmoji != null) {
                        FaceManager.this.emojiMap.put(str, loadAssetEmoji);
                        faceGroup.addFace(str, loadAssetEmoji);
                    }
                }
                faceGroup.setPageColumnCount(8);
                faceGroup.setPageRowCount(3);
                faceGroup.setFaceGroupIconUrl("file:///android_asset/emoji/[可爱]@2x.png");
                FaceManager.addFaceGroup(0, faceGroup);
                TUIChatLog.i(FaceManager.TAG, "load emojis finished");
            }
        };
        thread.setName("TUIChatLoadEmojiThread");
        ThreadHelper.INST.execute(thread);
    }

    private void internalLoadFace(ChatFace chatFace, ImageView imageView, boolean z) {
        String str;
        ChatFace face;
        if (imageView == null || chatFace == null) {
            return;
        }
        if (chatFace instanceof Emoji) {
            Glide.with(imageView.getContext()).m(((Emoji) chatFace).getIcon()).d().q0(new h().j(R.drawable.ic_menu_report_image)).D0(imageView);
            return;
        }
        FaceGroup faceGroup = chatFace.getFaceGroup();
        if (faceGroup != null && (face = faceGroup.getFace(chatFace.getFaceKey())) != null) {
            str = face.getFaceUrl();
        } else {
            str = "";
        }
        if (z) {
            Glide.with(imageView.getContext()).b().K0(str).d().q0(new h().j(R.drawable.ic_menu_report_image)).D0(imageView);
        } else {
            Glide.with(imageView.getContext()).q(str).d().q0(new h().j(R.drawable.ic_menu_report_image)).D0(imageView);
        }
    }

    public static boolean isFaceChar(String str) {
        if (getEmojiMap().get(str) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Emoji loadAssetEmoji(String str, String str2) {
        int dip2px = ScreenUtil.dip2px(20.0f);
        Bitmap loadBitmap = loadBitmap("file:///android_asset/" + str2, dip2px, dip2px);
        if (loadBitmap == null) {
            return null;
        }
        Emoji emoji = new Emoji();
        emoji.setIcon(loadBitmap);
        emoji.setFaceKey(str);
        return emoji;
    }

    private Bitmap loadBitmap(String str, int i, int i2) {
        try {
            return (Bitmap) Glide.with(this.context).b().K0(str).q0(new h().j(R.drawable.ic_menu_report_image)).R0(i, i2).get();
        } catch (InterruptedException | ExecutionException e) {
            TUIChatLog.e(TAG, "load bitmap failed : " + e.getMessage());
            return null;
        }
    }

    public static void loadEmojis() {
        getInstance().internalLoadEmojis();
    }

    public static void loadFace(ChatFace chatFace, ImageView imageView) {
        getInstance().internalLoadFace(chatFace, imageView, true);
    }

    private FaceManager() {
        this.emojiMap = new LinkedHashMap();
        this.faceGroupMap = new ConcurrentHashMap();
        this.needLoad = true;
        Context appContext = ServiceInitializer.getAppContext();
        this.context = appContext;
        this.emojiKeys = appContext.getResources().getStringArray(com.tencent.qcloud.tuikit.tuichat.R.array.emoji_key);
        this.emojiNames = appContext.getResources().getStringArray(com.tencent.qcloud.tuikit.tuichat.R.array.emoji_name);
    }

    public static void loadFace(int i, String str, ImageView imageView) {
        getInstance().internalLoadFace(i, str, imageView);
    }

    private void internalLoadFace(int i, String str, ImageView imageView) {
        String str2;
        ChatFace face;
        if (imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Glide.with(imageView.getContext()).o(Integer.valueOf(R.drawable.ic_menu_report_image)).d().D0(imageView);
            return;
        }
        FaceGroup faceGroup = this.faceGroupMap.get(Integer.valueOf(i));
        if (faceGroup != null && (face = faceGroup.getFace(str)) != null) {
            str2 = face.getFaceUrl();
        } else {
            str2 = "";
        }
        Glide.with(imageView.getContext()).q(str2).d().q0(new h().j(R.drawable.ic_menu_report_image)).D0(imageView);
    }
}

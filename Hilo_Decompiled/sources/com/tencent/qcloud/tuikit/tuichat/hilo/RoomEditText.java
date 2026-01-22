package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class RoomEditText extends AppCompatEditText {
    public static final Pattern TIM_MENTION_PATTERN = Pattern.compile("@[^\\s]+\\s");
    public static final String TIM_METION_TAG = "@";
    public HashMap<String, String> atUserInfoMap;
    public boolean isGroupInput;
    private boolean mIsSelected;
    private Range mLastSelectedRange;
    private OnMentionInputListener mOnMentionInputListener;
    private final Map<String, Pattern> mPatternMap;
    private List<Range> mRangeArrayList;
    private int mTIMMentionTextColor;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private class HackInputConnection extends InputConnectionWrapper {
        private final EditText editText;

        /* JADX WARN: Multi-variable type inference failed */
        HackInputConnection(InputConnection inputConnection, boolean z, RoomEditText roomEditText) {
            super(inputConnection, z);
            this.editText = roomEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                try {
                    if (sendKeyEvent(new KeyEvent(0, 67))) {
                        if (sendKeyEvent(new KeyEvent(1, 67))) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                int selectionStart = this.editText.getSelectionStart();
                Range rangeOfClosestMentionString = RoomEditText.this.getRangeOfClosestMentionString(selectionStart, this.editText.getSelectionEnd());
                if (rangeOfClosestMentionString == null) {
                    RoomEditText.this.mIsSelected = false;
                    return super.sendKeyEvent(keyEvent);
                }
                if (RoomEditText.this.mIsSelected || selectionStart == rangeOfClosestMentionString.from) {
                    RoomEditText.this.mIsSelected = false;
                    return super.sendKeyEvent(keyEvent);
                }
                RoomEditText.this.mIsSelected = true;
                RoomEditText.this.mLastSelectedRange = rangeOfClosestMentionString;
                setSelection(rangeOfClosestMentionString.to, rangeOfClosestMentionString.from);
                sendKeyEvent(new KeyEvent(0, 67));
                return true;
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class MentionTextWatcher implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 == 1 && !TextUtils.isEmpty(charSequence)) {
                char charAt = charSequence.toString().charAt(i);
                for (Map.Entry entry : RoomEditText.this.mPatternMap.entrySet()) {
                    if (((String) entry.getKey()).equals(String.valueOf(charAt)) && RoomEditText.this.mOnMentionInputListener != null) {
                        RoomEditText.this.mOnMentionInputListener.onMentionCharacterInput((String) entry.getKey());
                    }
                }
            }
        }

        private MentionTextWatcher() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnMentionInputListener {
        void onMentionCharacterInput(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class Range {
        int from;
        int to;

        Range(int i, int i2) {
            this.from = i;
            this.to = i2;
        }

        boolean contains(int i, int i2) {
            if (this.from <= i && this.to >= i2) {
                return true;
            }
            return false;
        }

        int getAnchorPosition(int i) {
            int i2 = this.from;
            int i3 = this.to;
            if ((i - i2) - (i3 - i) >= 0) {
                return i3;
            }
            return i2;
        }

        boolean isEqual(int i, int i2) {
            int i3 = this.from;
            if ((i3 == i && this.to == i2) || (i3 == i2 && this.to == i)) {
                return true;
            }
            return false;
        }

        boolean isWrappedBy(int i, int i2) {
            int i3 = this.from;
            if ((i > i3 && i < this.to) || (i2 > i3 && i2 < this.to)) {
                return true;
            }
            return false;
        }
    }

    public RoomEditText(Context context) {
        super(context);
        this.mPatternMap = new HashMap();
        this.mRangeArrayList = new ArrayList();
        this.isGroupInput = false;
        init();
    }

    private void colorMentionString() {
        this.mIsSelected = false;
        List<Range> list = this.mRangeArrayList;
        if (list != null) {
            list.clear();
        }
        Editable text = getText();
        if (text != null && !TextUtils.isEmpty(text.toString())) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) text.getSpans(0, text.length(), ForegroundColorSpan.class)) {
                text.removeSpan(foregroundColorSpan);
            }
            String obj = text.toString();
            try {
                Iterator<Map.Entry<String, String>> it = this.atUserInfoMap.entrySet().iterator();
                while (it.hasNext()) {
                    String str = "@" + it.next().getKey() + " ";
                    int i = 0;
                    while (true) {
                        int indexOf = obj.indexOf(str, i);
                        if (indexOf != -1) {
                            int length = str.length() + indexOf;
                            int length2 = str.length() + indexOf;
                            text.setSpan(new ForegroundColorSpan(this.mTIMMentionTextColor), indexOf, length, 33);
                            this.mRangeArrayList.add(new Range(indexOf, length));
                            i = length2;
                        }
                    }
                }
            } catch (Exception e) {
                Log.d("TIMMentionEditText", "groupColorMentionString: " + e.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range getRangeOfClosestMentionString(int i, int i2) {
        List<Range> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (Range range : list) {
            if (range.contains(i, i2)) {
                return range;
            }
        }
        return null;
    }

    private Range getRangeOfNearbyMentionString(int i, int i2) {
        List<Range> list = this.mRangeArrayList;
        if (list == null) {
            return null;
        }
        for (Range range : list) {
            if (range.isWrappedBy(i, i2)) {
                return range;
            }
        }
        return null;
    }

    private void groupColorMentionString() {
        HashMap<String, String> hashMap = this.atUserInfoMap;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        this.mIsSelected = false;
        List<Range> list = this.mRangeArrayList;
        if (list != null) {
            list.clear();
        }
        Editable text = getText();
        if (text != null && !TextUtils.isEmpty(text.toString())) {
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) text.getSpans(0, text.length(), ForegroundColorSpan.class)) {
                text.removeSpan(foregroundColorSpan);
            }
            String obj = text.toString();
            try {
                Iterator<Map.Entry<String, String>> it = this.atUserInfoMap.entrySet().iterator();
                while (it.hasNext()) {
                    String str = "@" + it.next().getKey() + " ";
                    int i = 0;
                    while (true) {
                        int indexOf = obj.indexOf(str, i);
                        if (indexOf != -1) {
                            int length = str.length() + indexOf;
                            int length2 = str.length() + indexOf;
                            text.setSpan(new ForegroundColorSpan(this.mTIMMentionTextColor), indexOf, length, 33);
                            this.mRangeArrayList.add(new Range(indexOf, length));
                            i = length2;
                        }
                    }
                }
            } catch (Exception e) {
                Log.d("TIMMentionEditText", "groupColorMentionString: " + e.getLocalizedMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        this.mPatternMap.clear();
        this.mPatternMap.put("@", TIM_MENTION_PATTERN);
        addTextChangedListener(new MentionTextWatcher());
    }

    public void clearRangeList() {
        this.mRangeArrayList.clear();
    }

    public List<String> getMentionList(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(getText().toString())) {
            return arrayList;
        }
        Iterator<Map.Entry<String, Pattern>> it = this.mPatternMap.entrySet().iterator();
        while (it.hasNext()) {
            Matcher matcher = it.next().getValue().matcher(getText().toString());
            while (matcher.find()) {
                String group = matcher.group();
                if (z) {
                    group = group.substring(1, group.length() - 1);
                }
                if (!arrayList.contains(group)) {
                    arrayList.add(group);
                }
            }
        }
        return arrayList;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new HackInputConnection(super.onCreateInputConnection(editorInfo), true, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSelectionChanged(int i, int i2) {
        super/*android.widget.EditText*/.onSelectionChanged(i, i2);
        Range range = this.mLastSelectedRange;
        if (range != null && range.isEqual(i, i2)) {
            return;
        }
        Range rangeOfClosestMentionString = getRangeOfClosestMentionString(i, i2);
        if (rangeOfClosestMentionString != null && rangeOfClosestMentionString.to == i2) {
            this.mIsSelected = false;
        }
        Range rangeOfNearbyMentionString = getRangeOfNearbyMentionString(i, i2);
        if (rangeOfNearbyMentionString == null) {
            return;
        }
        int length = getText().length();
        if (i == i2) {
            setSelection(Math.min(length, rangeOfNearbyMentionString.getAnchorPosition(i)));
            return;
        }
        if (i2 < rangeOfNearbyMentionString.to) {
            setSelection(Math.min(length, i), Math.min(length, rangeOfNearbyMentionString.to));
        }
        int i3 = rangeOfNearbyMentionString.from;
        if (i > i3) {
            setSelection(Math.min(length, i3), Math.min(length, i2));
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.isGroupInput) {
            groupColorMentionString();
        } else {
            colorMentionString();
        }
    }

    public void setOnMentionInputListener(OnMentionInputListener onMentionInputListener) {
        this.mOnMentionInputListener = onMentionInputListener;
    }

    public void setTIMMentionTextColor(int i) {
        this.mTIMMentionTextColor = i;
    }

    public RoomEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPatternMap = new HashMap();
        this.mRangeArrayList = new ArrayList();
        this.isGroupInput = false;
        init();
    }

    public RoomEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPatternMap = new HashMap();
        this.mRangeArrayList = new ArrayList();
        this.isGroupInput = false;
        init();
    }
}

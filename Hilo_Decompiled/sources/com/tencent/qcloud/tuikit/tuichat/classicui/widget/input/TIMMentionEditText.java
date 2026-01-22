package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TIMMentionEditText extends EditText {
    public static final String TIM_MENTION_TAG = "@";
    public static final String TIM_MENTION_TAG_FULL = "＠";
    private boolean mIsSelected;
    private Range mLastSelectedRange;
    private OnMentionInputListener mOnMentionInputListener;
    private List<Range> mRangeArrayList;
    private Map<String, String> mentionMap;
    private List<String> mentionTagList;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private class HackInputConnection extends InputConnectionWrapper {
        private EditText editText;

        HackInputConnection(InputConnection inputConnection, boolean z, TIMMentionEditText tIMMentionEditText) {
            super(inputConnection, z);
            this.editText = tIMMentionEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                if (sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67))) {
                    return true;
                }
                return false;
            }
            return super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                int selectionStart = this.editText.getSelectionStart();
                Range rangeOfClosestMentionString = TIMMentionEditText.this.getRangeOfClosestMentionString(selectionStart, this.editText.getSelectionEnd());
                if (rangeOfClosestMentionString == null) {
                    TIMMentionEditText.this.mIsSelected = false;
                    return super.sendKeyEvent(keyEvent);
                }
                if (TIMMentionEditText.this.mIsSelected || selectionStart == rangeOfClosestMentionString.from) {
                    TIMMentionEditText.this.mIsSelected = false;
                    return super.sendKeyEvent(keyEvent);
                }
                TIMMentionEditText.this.mIsSelected = true;
                TIMMentionEditText.this.mLastSelectedRange = rangeOfClosestMentionString;
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
            if (i3 == 1 && !TextUtils.isEmpty(charSequence) && TIMMentionEditText.this.hasFocus()) {
                char charAt = charSequence.toString().charAt(i);
                for (String str : TIMMentionEditText.this.mentionTagList) {
                    if (str.equals(String.valueOf(charAt)) && TIMMentionEditText.this.mOnMentionInputListener != null) {
                        TIMMentionEditText.this.mOnMentionInputListener.onMentionCharacterInput(str);
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
        String userID;

        Range(int i, int i2, String str) {
            this.from = i;
            this.to = i2;
            this.userID = str;
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

    public TIMMentionEditText(Context context) {
        super(context);
        this.mentionTagList = new ArrayList();
        this.mRangeArrayList = new ArrayList();
        this.mentionMap = new HashMap();
        init();
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

    private void init() {
        this.mentionTagList.clear();
        this.mentionTagList.add("@");
        this.mentionTagList.add("＠");
        addTextChangedListener(new MentionTextWatcher());
    }

    private void setMentionStringRange() {
        updateMentionList();
        this.mIsSelected = false;
        List<Range> list = this.mRangeArrayList;
        if (list != null) {
            list.clear();
        }
        Editable text = getText();
        if (text != null && !TextUtils.isEmpty(text.toString())) {
            String obj = text.toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            for (String str : this.mentionMap.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    int i = 0;
                    while (true) {
                        int indexOf = obj.indexOf(str, i);
                        if (indexOf == -1) {
                            break;
                        }
                        int length = str.length() + indexOf;
                        this.mRangeArrayList.add(new Range(indexOf, length, this.mentionMap.get(str)));
                        i = length;
                    }
                }
            }
            Collections.sort(this.mRangeArrayList, new Comparator<Range>() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText.1
                @Override // java.util.Comparator
                public int compare(Range range, Range range2) {
                    return range.from - range2.from;
                }
            });
        }
    }

    private void updateMentionList() {
        Editable text;
        if (this.mentionMap == null || (text = getText()) == null) {
            return;
        }
        String obj = text.toString();
        if (TextUtils.isEmpty(obj)) {
            this.mentionMap.clear();
        }
        Iterator it = new ArrayList(this.mentionMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!obj.contains(str)) {
                this.mentionMap.remove(str);
            }
        }
    }

    public List<String> getMentionIdList() {
        ArrayList arrayList = new ArrayList();
        Iterator<Range> it = this.mRangeArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().userID);
        }
        return arrayList;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new HackInputConnection(super.onCreateInputConnection(editorInfo), true, this);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
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
        if (i == i2) {
            setSelection(rangeOfNearbyMentionString.getAnchorPosition(i));
            return;
        }
        int i3 = rangeOfNearbyMentionString.to;
        if (i2 < i3) {
            setSelection(i, i3);
        }
        int i4 = rangeOfNearbyMentionString.from;
        if (i > i4) {
            setSelection(i4, i2);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        setMentionStringRange();
    }

    public void setMentionMap(Map<String, String> map) {
        this.mentionMap.putAll(map);
    }

    public void setOnMentionInputListener(OnMentionInputListener onMentionInputListener) {
        this.mOnMentionInputListener = onMentionInputListener;
    }

    public TIMMentionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mentionTagList = new ArrayList();
        this.mRangeArrayList = new ArrayList();
        this.mentionMap = new HashMap();
        init();
    }

    public TIMMentionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mentionTagList = new ArrayList();
        this.mRangeArrayList = new ArrayList();
        this.mentionMap = new HashMap();
        init();
    }
}

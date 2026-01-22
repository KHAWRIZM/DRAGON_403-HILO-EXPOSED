package com.qiahao.nextvideo.room.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ViewGroupInputLayoutBinding;
import com.qiahao.nextvideo.room.view.OnGroupInputLayoutListener;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.hilo.RoomEditText;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020!J\b\u0010&\u001a\u00020#H\u0003J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J*\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0016J*\u0010/\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0016J\u0012\u00101\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u000102H\u0016J$\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u00010\u00152\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u001eH\u0007J \u00107\u001a\u00020#2\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u001eH\u0002J\b\u00108\u001a\u00020#H\u0014R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R6\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GroupInputLayoutView;", "Landroid/widget/FrameLayout;", "Landroid/text/TextWatcher;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewGroupInputLayoutBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewGroupInputLayoutBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewGroupInputLayoutBinding;)V", "atUserInfoMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAtUserInfoMap", "()Ljava/util/HashMap;", "setAtUserInfoMap", "(Ljava/util/HashMap;)V", "displayInputString", "mInputContent", "mSendEnable", "", "mLastMsgLineCount", "mListener", "Lcom/qiahao/nextvideo/room/view/OnGroupInputLayoutListener;", "initView", "", "setOnGroupInputLayoutListener", "onGroupInputLayoutListener", "initChatMessageInput", "showSoftInput", "hideSoftInput", "beforeTextChanged", "s", "", "start", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "updateInputText", "names", "ids", "isNeedAddAtStr", "updateAtUserInfoMap", "onDetachedFromWindow", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupInputLayoutView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupInputLayoutView.kt\ncom/qiahao/nextvideo/room/view/GroupInputLayoutView\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,300:1\n106#2:301\n78#2,22:302\n106#2:324\n78#2,22:325\n106#2:347\n78#2,22:348\n106#2:370\n78#2,22:371\n106#2:393\n78#2,22:394\n*S KotlinDebug\n*F\n+ 1 GroupInputLayoutView.kt\ncom/qiahao/nextvideo/room/view/GroupInputLayoutView\n*L\n219#1:301\n219#1:302,22\n102#1:324\n102#1:325,22\n109#1:347\n109#1:348,22\n165#1:370\n165#1:371,22\n171#1:393\n171#1:394,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class GroupInputLayoutView extends FrameLayout implements TextWatcher {

    @NotNull
    private HashMap<String, String> atUserInfoMap;
    public ViewGroupInputLayoutBinding binding;

    @NotNull
    private String displayInputString;

    @NotNull
    private String mInputContent;
    private int mLastMsgLineCount;

    @Nullable
    private OnGroupInputLayoutListener mListener;
    private boolean mSendEnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupInputLayoutView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initChatMessageInput() {
        getBinding().chatMessageInput1.addTextChangedListener(this);
        getBinding().chatMessageInput1.setOnTouchListener(new View.OnTouchListener() { // from class: com.qiahao.nextvideo.room.view.k
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean initChatMessageInput$lambda$4;
                initChatMessageInput$lambda$4 = GroupInputLayoutView.initChatMessageInput$lambda$4(GroupInputLayoutView.this, view, motionEvent);
                return initChatMessageInput$lambda$4;
            }
        });
        getBinding().chatMessageInput1.setOnKeyListener(new View.OnKeyListener() { // from class: com.qiahao.nextvideo.room.view.l
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean initChatMessageInput$lambda$5;
                initChatMessageInput$lambda$5 = GroupInputLayoutView.initChatMessageInput$lambda$5(view, i, keyEvent);
                return initChatMessageInput$lambda$5;
            }
        });
        getBinding().chatMessageInput1.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.qiahao.nextvideo.room.view.m
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean initChatMessageInput$lambda$8;
                initChatMessageInput$lambda$8 = GroupInputLayoutView.initChatMessageInput$lambda$8(GroupInputLayoutView.this, textView, i, keyEvent);
                return initChatMessageInput$lambda$8;
            }
        });
        getBinding().chatMessageInput1.setOnMentionInputListener(new RoomEditText.OnMentionInputListener() { // from class: com.qiahao.nextvideo.room.view.n
            @Override // com.tencent.qcloud.tuikit.tuichat.hilo.RoomEditText.OnMentionInputListener
            public final void onMentionCharacterInput(String str) {
                GroupInputLayoutView.initChatMessageInput$lambda$9(GroupInputLayoutView.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initChatMessageInput$lambda$4(GroupInputLayoutView groupInputLayoutView, View view, MotionEvent motionEvent) {
        groupInputLayoutView.showSoftInput();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initChatMessageInput$lambda$5(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initChatMessageInput$lambda$8(GroupInputLayoutView groupInputLayoutView, TextView textView, int i, KeyEvent keyEvent) {
        int i2;
        boolean z;
        int i3;
        boolean z2;
        if (i != 4) {
            return false;
        }
        if (groupInputLayoutView.mSendEnable) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null && service.checkSensitive(String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText()))) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, groupInputLayoutView.getContext(), ResourcesKtxKt.getStringById(groupInputLayoutView, 2131954057), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                groupInputLayoutView.getBinding().chatMessageInput1.setText("");
                groupInputLayoutView.hideSoftInput();
                return false;
            }
            if (!groupInputLayoutView.atUserInfoMap.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (String str : groupInputLayoutView.atUserInfoMap.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                    String str2 = str;
                    if (!TextUtils.isEmpty(groupInputLayoutView.atUserInfoMap.get(str2))) {
                        arrayList.add(groupInputLayoutView.atUserInfoMap.get(str2));
                        RoomMessage.TextElemContentAt.Builder newBuilder = RoomMessage.TextElemContentAt.newBuilder();
                        String str3 = groupInputLayoutView.atUserInfoMap.get(str2);
                        if (str3 == null) {
                            str3 = "";
                        }
                        newBuilder.setAtAccount(str3);
                        newBuilder.setAtNick(str2);
                        arrayList2.add(newBuilder.m٩١٠build());
                    }
                }
                groupInputLayoutView.atUserInfoMap.clear();
                groupInputLayoutView.getBinding().chatMessageInput1.clearRangeList();
                if (arrayList.isEmpty()) {
                    OnGroupInputLayoutListener onGroupInputLayoutListener = groupInputLayoutView.mListener;
                    if (onGroupInputLayoutListener != null) {
                        String valueOf = String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText());
                        int length = valueOf.length() - 1;
                        int i4 = 0;
                        boolean z3 = false;
                        while (i4 <= length) {
                            if (!z3) {
                                i3 = i4;
                            } else {
                                i3 = length;
                            }
                            if (Intrinsics.compare(valueOf.charAt(i3), 32) <= 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z3) {
                                if (!z2) {
                                    z3 = true;
                                } else {
                                    i4++;
                                }
                            } else {
                                if (!z2) {
                                    break;
                                }
                                length--;
                            }
                        }
                        OnGroupInputLayoutListener.DefaultImpls.sendMessage$default(onGroupInputLayoutListener, valueOf.subSequence(i4, length + 1).toString(), null, 2, null);
                    }
                } else {
                    OnGroupInputLayoutListener onGroupInputLayoutListener2 = groupInputLayoutView.mListener;
                    if (onGroupInputLayoutListener2 != null) {
                        onGroupInputLayoutListener2.sendMessage(String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText()), arrayList2);
                    }
                }
            } else {
                OnGroupInputLayoutListener onGroupInputLayoutListener3 = groupInputLayoutView.mListener;
                if (onGroupInputLayoutListener3 != null) {
                    String valueOf2 = String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText());
                    int length2 = valueOf2.length() - 1;
                    int i5 = 0;
                    boolean z4 = false;
                    while (i5 <= length2) {
                        if (!z4) {
                            i2 = i5;
                        } else {
                            i2 = length2;
                        }
                        if (Intrinsics.compare(valueOf2.charAt(i2), 32) <= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z4) {
                            if (!z) {
                                z4 = true;
                            } else {
                                i5++;
                            }
                        } else {
                            if (!z) {
                                break;
                            }
                            length2--;
                        }
                    }
                    OnGroupInputLayoutListener.DefaultImpls.sendMessage$default(onGroupInputLayoutListener3, valueOf2.subSequence(i5, length2 + 1).toString(), null, 2, null);
                }
            }
            groupInputLayoutView.getBinding().chatMessageInput1.setText("");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initChatMessageInput$lambda$9(GroupInputLayoutView groupInputLayoutView, String str) {
        OnGroupInputLayoutListener onGroupInputLayoutListener;
        if (Intrinsics.areEqual(str, "@") && (onGroupInputLayoutListener = groupInputLayoutView.mListener) != null) {
            onGroupInputLayoutListener.onStartGroupMemberSelectActivity();
        }
    }

    private final void initView() {
        setBinding((ViewGroupInputLayoutBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_group_input_layout, this, true));
        getBinding().chatMessageInput1.isGroupInput = true;
        getBinding().chatMessageInput1.atUserInfoMap = this.atUserInfoMap;
        getBinding().chatMessageInput1.setTIMMentionTextColor(Color.parseColor("#ffe222"));
        initChatMessageInput();
        getBinding().sendImage1.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupInputLayoutView.initView$lambda$2(GroupInputLayoutView.this, view);
            }
        });
        getBinding().picVideoBtn1.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupInputLayoutView.initView$lambda$3(GroupInputLayoutView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(GroupInputLayoutView groupInputLayoutView, View view) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        if (groupInputLayoutView.mSendEnable) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null && service.checkSensitive(String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText()))) {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, groupInputLayoutView.getContext(), ResourcesKtxKt.getStringById(groupInputLayoutView, 2131954057), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                groupInputLayoutView.getBinding().chatMessageInput1.setText("");
                groupInputLayoutView.hideSoftInput();
                return;
            }
            if (!groupInputLayoutView.atUserInfoMap.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (String str : groupInputLayoutView.atUserInfoMap.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                    String str2 = str;
                    if (!TextUtils.isEmpty(groupInputLayoutView.atUserInfoMap.get(str2))) {
                        arrayList.add(groupInputLayoutView.atUserInfoMap.get(str2));
                        RoomMessage.TextElemContentAt.Builder newBuilder = RoomMessage.TextElemContentAt.newBuilder();
                        String str3 = groupInputLayoutView.atUserInfoMap.get(str2);
                        if (str3 == null) {
                            str3 = "";
                        }
                        newBuilder.setAtAccount(str3);
                        newBuilder.setAtNick(str2);
                        arrayList2.add(newBuilder.m٩١٠build());
                    }
                }
                groupInputLayoutView.atUserInfoMap.clear();
                groupInputLayoutView.getBinding().chatMessageInput1.clearRangeList();
                if (arrayList.isEmpty()) {
                    OnGroupInputLayoutListener onGroupInputLayoutListener = groupInputLayoutView.mListener;
                    if (onGroupInputLayoutListener != null) {
                        String valueOf = String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText());
                        int length = valueOf.length() - 1;
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 <= length) {
                            if (!z3) {
                                i2 = i3;
                            } else {
                                i2 = length;
                            }
                            if (Intrinsics.compare(valueOf.charAt(i2), 32) <= 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z3) {
                                if (!z2) {
                                    z3 = true;
                                } else {
                                    i3++;
                                }
                            } else if (!z2) {
                                break;
                            } else {
                                length--;
                            }
                        }
                        OnGroupInputLayoutListener.DefaultImpls.sendMessage$default(onGroupInputLayoutListener, valueOf.subSequence(i3, length + 1).toString(), null, 2, null);
                    }
                } else {
                    OnGroupInputLayoutListener onGroupInputLayoutListener2 = groupInputLayoutView.mListener;
                    if (onGroupInputLayoutListener2 != null) {
                        onGroupInputLayoutListener2.sendMessage(String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText()), arrayList2);
                    }
                }
            } else {
                OnGroupInputLayoutListener onGroupInputLayoutListener3 = groupInputLayoutView.mListener;
                if (onGroupInputLayoutListener3 != null) {
                    String valueOf2 = String.valueOf(groupInputLayoutView.getBinding().chatMessageInput1.getText());
                    int length2 = valueOf2.length() - 1;
                    int i4 = 0;
                    boolean z4 = false;
                    while (i4 <= length2) {
                        if (!z4) {
                            i = i4;
                        } else {
                            i = length2;
                        }
                        if (Intrinsics.compare(valueOf2.charAt(i), 32) <= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z4) {
                            if (!z) {
                                z4 = true;
                            } else {
                                i4++;
                            }
                        } else if (!z) {
                            break;
                        } else {
                            length2--;
                        }
                    }
                    OnGroupInputLayoutListener.DefaultImpls.sendMessage$default(onGroupInputLayoutListener3, valueOf2.subSequence(i4, length2 + 1).toString(), null, 2, null);
                }
            }
            groupInputLayoutView.getBinding().chatMessageInput1.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(GroupInputLayoutView groupInputLayoutView, View view) {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.checkLevelMoreThree()) {
            OnGroupInputLayoutListener onGroupInputLayoutListener = groupInputLayoutView.mListener;
            if (onGroupInputLayoutListener != null) {
                onGroupInputLayoutListener.setShowSelectPicVideo();
                return;
            }
            return;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, groupInputLayoutView.getContext(), ResourcesKtxKt.getStringById(groupInputLayoutView, 2131952169), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    private final void updateAtUserInfoMap(String names, String ids, boolean isNeedAddAtStr) {
        this.displayInputString = "";
        if (Intrinsics.areEqual(ids, "__kImSDK_MesssageAtALL__")) {
            this.atUserInfoMap.put(names, ids);
            String str = this.displayInputString + names;
            this.displayInputString = str;
            String str2 = str + " ";
            this.displayInputString = str2;
            this.displayInputString = str2 + "@";
            return;
        }
        String[] strArr = {names};
        this.atUserInfoMap.put(strArr[0], new String[]{ids}[0]);
        if (isNeedAddAtStr) {
            this.displayInputString = this.displayInputString + "@";
        }
        String str3 = this.displayInputString + strArr[0];
        this.displayInputString = str3;
        this.displayInputString = str3 + " ";
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s) {
        int i;
        boolean z;
        String valueOf = String.valueOf(s);
        int length = valueOf.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            if (!z2) {
                i = i2;
            } else {
                i = length;
            }
            if (Intrinsics.compare(valueOf.charAt(i), 32) <= 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z2) {
                if (!z) {
                    z2 = true;
                } else {
                    i2++;
                }
            } else if (!z) {
                break;
            } else {
                length--;
            }
        }
        if (TextUtils.isEmpty(valueOf.subSequence(i2, length + 1).toString())) {
            this.mSendEnable = false;
            return;
        }
        this.mSendEnable = true;
        if (getBinding().chatMessageInput1.getLineCount() != this.mLastMsgLineCount) {
            this.mLastMsgLineCount = getBinding().chatMessageInput1.getLineCount();
        }
        if (!TextUtils.equals(this.mInputContent, String.valueOf(getBinding().chatMessageInput1.getText()))) {
            FaceManager.handlerEmojiText(getBinding().chatMessageInput1, String.valueOf(getBinding().chatMessageInput1.getText()), true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
        this.mInputContent = String.valueOf(s);
    }

    @NotNull
    public final HashMap<String, String> getAtUserInfoMap() {
        return this.atUserInfoMap;
    }

    @NotNull
    public final ViewGroupInputLayoutBinding getBinding() {
        ViewGroupInputLayoutBinding viewGroupInputLayoutBinding = this.binding;
        if (viewGroupInputLayoutBinding != null) {
            return viewGroupInputLayoutBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void hideSoftInput() {
        setVisibility(8);
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        frameLayout.setVisibility(8);
        frameLayout.setOnClickListener(null);
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getBinding().chatMessageInput1.getWindowToken(), 0);
        getBinding().chatMessageInput1.clearFocus();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getBinding().chatMessageInput1.removeTextChangedListener(this);
        this.atUserInfoMap.clear();
        getBinding().chatMessageInput1.clearRangeList();
        this.mListener = null;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
    }

    public final void setAtUserInfoMap(@NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.atUserInfoMap = hashMap;
    }

    public final void setBinding(@NotNull ViewGroupInputLayoutBinding viewGroupInputLayoutBinding) {
        Intrinsics.checkNotNullParameter(viewGroupInputLayoutBinding, "<set-?>");
        this.binding = viewGroupInputLayoutBinding;
    }

    public final void setOnGroupInputLayoutListener(@NotNull OnGroupInputLayoutListener onGroupInputLayoutListener) {
        Intrinsics.checkNotNullParameter(onGroupInputLayoutListener, "onGroupInputLayoutListener");
        this.mListener = onGroupInputLayoutListener;
    }

    public final void showSoftInput() {
        setVisibility(0);
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        frameLayout.setVisibility(0);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupInputLayoutView.this.hideSoftInput();
            }
        });
        getBinding().chatMessageInput1.requestFocus();
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(getBinding().chatMessageInput1, 0);
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateInputText(@Nullable String names, @Nullable String ids, boolean isNeedAddAtStr) {
        int i;
        if (names != null && ids != null && names.length() != 0 && ids.length() != 0) {
            updateAtUserInfoMap(names, ids, isNeedAddAtStr);
            AppCompatEditText appCompatEditText = getBinding().chatMessageInput1;
            Editable text = getBinding().chatMessageInput1.getText();
            appCompatEditText.setText(((Object) text) + this.displayInputString);
            AppCompatEditText appCompatEditText2 = getBinding().chatMessageInput1;
            Editable text2 = getBinding().chatMessageInput1.getText();
            if (text2 != null) {
                i = text2.length();
            } else {
                i = 0;
            }
            appCompatEditText2.setSelection(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupInputLayoutView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInputLayoutView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.atUserInfoMap = new HashMap<>();
        this.displayInputString = "";
        this.mInputContent = "";
        initView();
    }
}

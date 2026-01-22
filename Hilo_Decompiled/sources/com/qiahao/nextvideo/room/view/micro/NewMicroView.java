package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020%J\b\u0010.\u001a\u00020+H\u0002J\b\u0010/\u001a\u00020+H\u0002J\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u000bJ\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u000bJ\u0006\u00104\u001a\u00020+J\u000e\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u000bJ\u0006\u00107\u001a\u00020+J\u0006\u00108\u001a\u00020+J\u0014\u00109\u001a\u00020+2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b0;J\u0016\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bJ\u001a\u0010A\u001a\u00020+2\u0006\u00106\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010C\u001a\u00020+2\u0006\u00106\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010D\u001a\u00020+2\u0006\u00106\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010E\u001a\u00020+2\u0006\u00106\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/NewMicroView;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMicroBeanListData", "", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "getMMicroBeanListData", "()Ljava/util/List;", "setMMicroBeanListData", "(Ljava/util/List;)V", "mMicListView", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "getMMicListView", "setMMicListView", "mContext", "mMicType", "getMMicType", "()I", "setMMicType", "(I)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "mOnMeetingRoomMicroItemClickListener", "Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "getMOnMeetingRoomMicroItemClickListener", "()Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "setMOnMeetingRoomMicroItemClickListener", "(Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;)V", "initView", "", "setOnMeetingRoomMicroItemClickListener", "onMeetingRoomMicroItemClickListener", "updateView", "changeThisViewHeight", "changeMicType", "type", "refreshSVIP", "svipLevel", "notificationMicChange", "refreshMicByPosition", "position", "stopMicSVGA", "recoverMicSVGA", "showMicSpeakWaveAnim", "list", "", "showFace", "index", "faceSVGAUrl", "", "getMicTypeLayout", "onAvatarBtnClick", "micBean", "onMicroClick", "onUnLockMic", "onUnMuteAvatarClick", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNewMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/NewMicroView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1869#2,2:311\n1869#2,2:313\n1869#2,2:315\n1#3:317\n*S KotlinDebug\n*F\n+ 1 NewMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/NewMicroView\n*L\n161#1:311,2\n213#1:313,2\n222#1:315,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NewMicroView extends FrameLayout implements OnMicroItemClickListener {

    @NotNull
    private static final String TAG = "NewMicroView";

    @NotNull
    private Context mContext;

    @NotNull
    private List<BaseItemMicroView> mMicListView;
    private int mMicType;

    @NotNull
    private List<MicroBean> mMicroBeanListData;
    public OnMeetingRoomMicroItemClickListener mOnMeetingRoomMicroItemClickListener;

    @Nullable
    private View view;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void changeThisViewHeight() {
        switch (MeetingRoomManager.INSTANCE.getMCurrentRoomMicType()) {
            case 1:
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = Dimens.INSTANCE.dpToPx(85);
                setLayoutParams(layoutParams);
                return;
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = Dimens.INSTANCE.dpToPx(UserProxyUtility.strangeChatMatch);
                setLayoutParams(layoutParams2);
                return;
            case 5:
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
                ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                layoutParams3.width = -1;
                layoutParams3.height = -2;
                setLayoutParams(layoutParams3);
                return;
            case 14:
            case 19:
            default:
                return;
            case 16:
            case 17:
            case 18:
            case 20:
                ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
                layoutParams4.width = -1;
                layoutParams4.height = -2;
                setLayoutParams(layoutParams4);
                return;
        }
    }

    private final void initView() {
        setClipChildren(false);
        setClipToPadding(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notificationMicChange$lambda$3(NewMicroView newMicroView) {
        boolean z;
        int i;
        User owner;
        SvipData svip;
        Log.d(TAG, "notificationMicChange: 更新麦位信息");
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int micSize = meetingRoomManager.getMicSize(meetingRoomManager.getMCurrentRoomMicType());
        if (newMicroView.mMicroBeanListData.size() == micSize) {
            if (newMicroView.mMicroBeanListData.size() == micSize) {
                z = true;
            } else {
                z = false;
            }
            Log.d(TAG, "notificationMicChange: " + z);
            newMicroView.mMicroBeanListData.clear();
            if (micSize <= MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).size()) {
                Log.d(TAG, "notificationMicChange: 重置microbean的view的数据");
                if (1 <= micSize) {
                    int i2 = 1;
                    while (true) {
                        MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2));
                        if (microBean != null) {
                            newMicroView.mMicroBeanListData.add(microBean);
                        }
                        if (i2 == micSize) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            } else {
                Log.d(TAG, "notificationMicChange: 重置microbean的view的数据--失败");
            }
            if (newMicroView.mMicListView.size() == newMicroView.mMicroBeanListData.size()) {
                int size = newMicroView.mMicListView.size();
                for (int i3 = 0; i3 < size; i3++) {
                    BaseItemMicroView baseItemMicroView = newMicroView.mMicListView.get(i3);
                    MicroBean microBean2 = newMicroView.mMicroBeanListData.get(i3);
                    GroupDetailBean groupDetailBean = MeetingRoomManager.INSTANCE.getGroupDetailBean();
                    if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (svip = owner.getSvip()) != null) {
                        i = svip.getSvipLevel();
                    } else {
                        i = 0;
                    }
                    baseItemMicroView.updateDate(microBean2, i);
                }
                Log.d(TAG, "notificationMicChange: 重置microbean的view页面展示");
                return;
            }
            Log.d(TAG, "notificationMicChange: 重置microbean的view页面展示--失败");
            return;
        }
        Log.d(TAG, "notificationMicChange: 麦位类型出错！！！有问题");
    }

    private final void updateView() {
        post(new Runnable() { // from class: com.qiahao.nextvideo.room.view.micro.w
            @Override // java.lang.Runnable
            public final void run() {
                NewMicroView.updateView$lambda$0(NewMicroView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$0(NewMicroView newMicroView) {
        int i;
        User owner;
        SvipData svip;
        newMicroView.removeAllViews();
        newMicroView.mMicListView.clear();
        newMicroView.mMicroBeanListData.clear();
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        newMicroView.mMicType = meetingRoomManager.getMCurrentRoomMicType();
        newMicroView.changeThisViewHeight();
        View inflate = LayoutInflater.from(newMicroView.getContext()).inflate(newMicroView.getMicTypeLayout(meetingRoomManager.getMCurrentRoomMicType()), (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        newMicroView.addView(viewGroup);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        viewGroup.setLayoutParams(layoutParams);
        if (viewGroup.getChildCount() > 0) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) instanceof BaseItemMicroView) {
                    List<BaseItemMicroView> list = newMicroView.mMicListView;
                    View childAt = viewGroup.getChildAt(i2);
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.qiahao.nextvideo.room.view.micro.BaseItemMicroView");
                    list.add((BaseItemMicroView) childAt);
                    MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2 + 1));
                    if (microBean == null) {
                        Log.d(TAG, "initView: 加载不存在的麦位数据");
                        newMicroView.mMicroBeanListData.add(MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i2, false, 2, null));
                    } else {
                        Log.d(TAG, "initView: 加载已经存在的麦位数据");
                        newMicroView.mMicroBeanListData.add(microBean);
                    }
                }
            }
            int size = newMicroView.mMicListView.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                newMicroView.mMicListView.get(i3).setMPosition(i4);
                BaseItemMicroView baseItemMicroView = newMicroView.mMicListView.get(i3);
                MicroBean microBean2 = newMicroView.mMicroBeanListData.get(i3);
                GroupDetailBean groupDetailBean = MeetingRoomManager.INSTANCE.getGroupDetailBean();
                if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (svip = owner.getSvip()) != null) {
                    i = svip.getSvipLevel();
                } else {
                    i = 0;
                }
                baseItemMicroView.updateDate(microBean2, i);
                newMicroView.mMicListView.get(i3).setMicroItemClickListener(newMicroView);
                i3 = i4;
            }
        }
        newMicroView.setVisibility(0);
    }

    public final void changeMicType(int type) {
        Log.d(TAG, "changeMicType: notificationMicChange");
        this.mMicType = type;
        updateView();
    }

    @NotNull
    public final List<BaseItemMicroView> getMMicListView() {
        return this.mMicListView;
    }

    public final int getMMicType() {
        return this.mMicType;
    }

    @NotNull
    public final List<MicroBean> getMMicroBeanListData() {
        return this.mMicroBeanListData;
    }

    @NotNull
    public final OnMeetingRoomMicroItemClickListener getMOnMeetingRoomMicroItemClickListener() {
        OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener = this.mOnMeetingRoomMicroItemClickListener;
        if (onMeetingRoomMicroItemClickListener != null) {
            return onMeetingRoomMicroItemClickListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOnMeetingRoomMicroItemClickListener");
        return null;
    }

    public final int getMicTypeLayout(int type) {
        switch (type) {
            case 1:
            case 14:
            case 19:
            default:
                return R.layout.view_room_micro_style_5;
            case 2:
                return R.layout.view_room_micro_style_10;
            case 3:
                return R.layout.view_room_micro_style_3;
            case 4:
                return R.layout.view_room_micro_style_4;
            case 5:
                return R.layout.view_room_micro_style_1;
            case 6:
                return R.layout.view_room_micro_style_6;
            case 7:
                return R.layout.view_room_micro_style_7;
            case 8:
                return R.layout.view_room_micro_style_8;
            case 9:
                return R.layout.view_room_micro_style_9;
            case 10:
                return R.layout.view_room_micro_style_2;
            case 11:
                return R.layout.view_room_micro_style_11;
            case 12:
                return R.layout.view_room_micro_style_12;
            case 13:
                return R.layout.view_room_micro_style_13;
            case 15:
                return R.layout.view_room_micro_style_15;
            case 16:
                return R.layout.view_room_micro_style_16;
            case 17:
                return R.layout.view_room_micro_style_17;
            case 18:
                return R.layout.view_room_micro_style_18;
            case 20:
                return R.layout.view_room_micro_style_20;
        }
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    public final void notificationMicChange() {
        post(new Runnable() { // from class: com.qiahao.nextvideo.room.view.micro.x
            @Override // java.lang.Runnable
            public final void run() {
                NewMicroView.notificationMicChange$lambda$3(NewMicroView.this);
            }
        });
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onAvatarBtnClick(int position, @Nullable MicroBean micBean) {
        Integer num;
        if (micBean != null) {
            num = Integer.valueOf(micBean.getI());
        } else {
            num = null;
        }
        Log.d(TAG, "onAvatarBtnClick: " + position + " " + num);
        getMOnMeetingRoomMicroItemClickListener().onAvatarBtnClick(position, micBean);
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onMicroClick(int position, @Nullable MicroBean micBean) {
        Log.d(TAG, "onMicroClick: " + position);
        getMOnMeetingRoomMicroItemClickListener().onMicroClick(position, micBean);
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onUnLockMic(int position, @Nullable MicroBean micBean) {
        Log.d(TAG, "onUnLockMic: " + position);
        getMOnMeetingRoomMicroItemClickListener().onUnLockMic(position, micBean);
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onUnMuteAvatarClick(int position, @Nullable MicroBean micBean) {
        Integer num;
        if (micBean != null) {
            num = Integer.valueOf(micBean.getI());
        } else {
            num = null;
        }
        Log.d(TAG, "onUnMuteAvatarClick: " + position + " " + num);
        getMOnMeetingRoomMicroItemClickListener().onUnMuteAvatarClick(position, micBean);
    }

    public final void recoverMicSVGA() {
        Iterator<T> it = this.mMicListView.iterator();
        while (it.hasNext()) {
            ((BaseItemMicroView) it.next()).recoverMicSVGA();
        }
    }

    public final void refreshMicByPosition(int position) {
        int i = position - 1;
        if (this.mMicListView.size() > i) {
            this.mMicListView.get(i).updateView();
        }
    }

    public final void refreshSVIP(int svipLevel) {
        Iterator<T> it = this.mMicListView.iterator();
        while (it.hasNext()) {
            ((BaseItemMicroView) it.next()).refreshSVIP(svipLevel);
        }
    }

    public final void setMMicListView(@NotNull List<BaseItemMicroView> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mMicListView = list;
    }

    public final void setMMicType(int i) {
        this.mMicType = i;
    }

    public final void setMMicroBeanListData(@NotNull List<MicroBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mMicroBeanListData = list;
    }

    public final void setMOnMeetingRoomMicroItemClickListener(@NotNull OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener) {
        Intrinsics.checkNotNullParameter(onMeetingRoomMicroItemClickListener, "<set-?>");
        this.mOnMeetingRoomMicroItemClickListener = onMeetingRoomMicroItemClickListener;
    }

    public final void setOnMeetingRoomMicroItemClickListener(@NotNull OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener) {
        Intrinsics.checkNotNullParameter(onMeetingRoomMicroItemClickListener, "onMeetingRoomMicroItemClickListener");
        setMOnMeetingRoomMicroItemClickListener(onMeetingRoomMicroItemClickListener);
    }

    public final void setView(@Nullable View view) {
        this.view = view;
    }

    public final void showFace(int index, @NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (index < 0 || index > this.mMicListView.size() - 1 || faceSVGAUrl.length() == 0) {
            return;
        }
        this.mMicListView.get(index).showFaceSvga(faceSVGAUrl);
    }

    public final void showMicSpeakWaveAnim(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int intValue = list.get(i).intValue() - 1;
            if (intValue < this.mMicroBeanListData.size() && intValue >= 0 && intValue < this.mMicListView.size() && intValue >= 0 && this.mMicroBeanListData.get(intValue).getUser() != null) {
                this.mMicListView.get(intValue).showMicSpeakWaveAnim();
            }
        }
    }

    public final void stopMicSVGA() {
        Iterator<T> it = this.mMicListView.iterator();
        while (it.hasNext()) {
            ((BaseItemMicroView) it.next()).stopMicSVGA();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMicroBeanListData = new ArrayList();
        this.mMicListView = new ArrayList();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        initView();
    }
}

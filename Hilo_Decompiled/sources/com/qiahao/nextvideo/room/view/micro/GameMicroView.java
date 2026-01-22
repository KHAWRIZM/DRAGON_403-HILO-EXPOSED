package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.databinding.RoomMicroGameBinding;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u00100\u001a\u000201H\u0002J\u000e\u00102\u001a\u0002012\u0006\u00103\u001a\u00020+J\u0006\u00104\u001a\u000201J\u000e\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u000bJ\u000e\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u000bJ\u0006\u00109\u001a\u000201J\u0006\u0010:\u001a\u000201J\u0014\u0010;\u001a\u0002012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0=J\u0016\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020AJ\u001a\u0010B\u001a\u0002012\u0006\u00108\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010D\u001a\u0002012\u0006\u00108\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010E\u001a\u0002012\u0006\u00108\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010F\u001a\u0002012\u0006\u00108\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u000fH\u0016R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/GameMicroView;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMicroBeanListData", "", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "getMMicroBeanListData", "()Ljava/util/List;", "setMMicroBeanListData", "(Ljava/util/List;)V", "mMicListView", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "getMMicListView", "setMMicListView", "binding", "Lcom/qiahao/nextvideo/databinding/RoomMicroGameBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/RoomMicroGameBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/RoomMicroGameBinding;)V", "mContext", "mMicType", "getMMicType", "()I", "setMMicType", "(I)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "mListener", "Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "getMListener", "()Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "setMListener", "(Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;)V", "initView", "", "setOnMeetingRoomMicroItemClickListener", "onMeetingRoomMicroItemClickListener", "refreshMic", "refreshSVIP", "svipLevel", "refreshMicByPosition", "position", "stopMicSVGA", "recoverMicSVGA", "showMicSpeakWaveAnim", "list", "", "showFace", "index", "faceSVGAUrl", "", "onAvatarBtnClick", "micBean", "onMicroClick", "onUnLockMic", "onUnMuteAvatarClick", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/GameMicroView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,160:1\n1869#2,2:161\n1869#2,2:163\n1869#2,2:165\n*S KotlinDebug\n*F\n+ 1 GameMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/GameMicroView\n*L\n86#1:161,2\n105#1:163,2\n114#1:165,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameMicroView extends FrameLayout implements OnMicroItemClickListener {

    @Nullable
    private RoomMicroGameBinding binding;

    @NotNull
    private Context mContext;

    @Nullable
    private OnMeetingRoomMicroItemClickListener mListener;

    @NotNull
    private List<BaseItemMicroView> mMicListView;
    private int mMicType;

    @NotNull
    private List<MicroBean> mMicroBeanListData;

    @Nullable
    private View view;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        setClipChildren(false);
        setClipToPadding(false);
        this.binding = (RoomMicroGameBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.room_micro_game, this, true);
        this.mMicListView.clear();
        RoomMicroGameBinding roomMicroGameBinding = this.binding;
        if (roomMicroGameBinding != null) {
            List<BaseItemMicroView> list = this.mMicListView;
            GameItemMicroView gameItemMicroView = roomMicroGameBinding.microView1;
            Intrinsics.checkNotNullExpressionValue(gameItemMicroView, "microView1");
            list.add(gameItemMicroView);
            List<BaseItemMicroView> list2 = this.mMicListView;
            GameItemMicroView gameItemMicroView2 = roomMicroGameBinding.microView2;
            Intrinsics.checkNotNullExpressionValue(gameItemMicroView2, "microView2");
            list2.add(gameItemMicroView2);
        }
        refreshMic();
    }

    @Nullable
    public final RoomMicroGameBinding getBinding() {
        return this.binding;
    }

    @Nullable
    public final OnMeetingRoomMicroItemClickListener getMListener() {
        return this.mListener;
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

    @Nullable
    public final View getView() {
        return this.view;
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onAvatarBtnClick(int position, @Nullable MicroBean micBean) {
        OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener = this.mListener;
        if (onMeetingRoomMicroItemClickListener != null) {
            onMeetingRoomMicroItemClickListener.onAvatarBtnClick(position, micBean);
        }
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onMicroClick(int position, @Nullable MicroBean micBean) {
        OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener = this.mListener;
        if (onMeetingRoomMicroItemClickListener != null) {
            onMeetingRoomMicroItemClickListener.onMicroClick(position, micBean);
        }
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onUnLockMic(int position, @Nullable MicroBean micBean) {
        OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener = this.mListener;
        if (onMeetingRoomMicroItemClickListener != null) {
            onMeetingRoomMicroItemClickListener.onUnLockMic(position, micBean);
        }
    }

    @Override // com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener
    public void onUnMuteAvatarClick(int position, @Nullable MicroBean micBean) {
        OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener = this.mListener;
        if (onMeetingRoomMicroItemClickListener != null) {
            onMeetingRoomMicroItemClickListener.onUnMuteAvatarClick(position, micBean);
        }
    }

    public final void recoverMicSVGA() {
        Iterator<T> it = this.mMicListView.iterator();
        while (it.hasNext()) {
            ((BaseItemMicroView) it.next()).recoverMicSVGA();
        }
    }

    public final void refreshMic() {
        int i;
        User owner;
        SvipData svip;
        this.mMicroBeanListData.clear();
        int size = this.mMicListView.size();
        int i2 = 0;
        while (i2 < size) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            int i3 = i2 + 1;
            MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).get(Integer.valueOf(i3));
            if (microBean == null) {
                this.mMicroBeanListData.add(MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i2, false, 2, null));
            } else {
                this.mMicroBeanListData.add(microBean);
            }
            this.mMicListView.get(i2).setMPosition(i3);
            BaseItemMicroView baseItemMicroView = this.mMicListView.get(i2);
            MicroBean microBean2 = this.mMicroBeanListData.get(i2);
            GroupDetailBean groupDetailBean = meetingRoomManager.getGroupDetailBean();
            if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (svip = owner.getSvip()) != null) {
                i = svip.getSvipLevel();
            } else {
                i = 0;
            }
            baseItemMicroView.updateDate(microBean2, i);
            this.mMicListView.get(i2).setMicroItemClickListener(this);
            i2 = i3;
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

    public final void setBinding(@Nullable RoomMicroGameBinding roomMicroGameBinding) {
        this.binding = roomMicroGameBinding;
    }

    public final void setMListener(@Nullable OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener) {
        this.mListener = onMeetingRoomMicroItemClickListener;
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

    public final void setOnMeetingRoomMicroItemClickListener(@NotNull OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener) {
        Intrinsics.checkNotNullParameter(onMeetingRoomMicroItemClickListener, "onMeetingRoomMicroItemClickListener");
        this.mListener = onMeetingRoomMicroItemClickListener;
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
    public GameMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
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

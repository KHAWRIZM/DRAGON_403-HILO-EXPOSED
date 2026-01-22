package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.databinding.RoomMicroPkBinding;
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

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u001c\u0010)\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\bH\u0002J\u000e\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020$J\u000e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u001fJ\u0006\u00100\u001a\u00020*J\u000e\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u000bJ\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000bJ\u0006\u00105\u001a\u00020*J\u0006\u00106\u001a\u00020*J\u0014\u00107\u001a\u00020*2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b09J\u0016\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=J\u001a\u0010>\u001a\u00020*2\u0006\u00104\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010@\u001a\u00020*2\u0006\u00104\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010A\u001a\u00020*2\u0006\u00104\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010B\u001a\u00020*2\u0006\u00104\u001a\u00020\u000b2\b\u0010?\u001a\u0004\u0018\u00010\u000fH\u0016R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006C"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/PKMicroView;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/nextvideo/room/adapter/OnMicroItemClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMicroBeanListData", "", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "getMMicroBeanListData", "()Ljava/util/List;", "setMMicroBeanListData", "(Ljava/util/List;)V", "mMicListView", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "getMMicListView", "setMMicListView", "binding", "Lcom/qiahao/nextvideo/databinding/RoomMicroPkBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/RoomMicroPkBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/RoomMicroPkBinding;)V", "isRed", "", "()Z", "setRed", "(Z)V", "mListener", "Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "getMListener", "()Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;", "setMListener", "(Lcom/qiahao/nextvideo/room/view/micro/OnMeetingRoomMicroItemClickListener;)V", "initView", "", "attrs", "setOnMeetingRoomMicroItemClickListener", "onMeetingRoomMicroItemClickListener", "setViewRed", "red", "refreshMic", "refreshSVIP", "svipLevel", "refreshMicByPosition", "position", "stopMicSVGA", "recoverMicSVGA", "showMicSpeakWaveAnim", "list", "", "showFace", "index", "faceSVGAUrl", "", "onAvatarBtnClick", "micBean", "onMicroClick", "onUnLockMic", "onUnMuteAvatarClick", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/PKMicroView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,179:1\n51#2,9:180\n1869#3,2:189\n1869#3,2:191\n1869#3,2:193\n*S KotlinDebug\n*F\n+ 1 PKMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/PKMicroView\n*L\n40#1:180,9\n105#1:189,2\n124#1:191,2\n133#1:193,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKMicroView extends FrameLayout implements OnMicroItemClickListener {

    @Nullable
    private RoomMicroPkBinding binding;
    private boolean isRed;

    @Nullable
    private OnMeetingRoomMicroItemClickListener mListener;

    @NotNull
    private List<BaseItemMicroView> mMicListView;

    @NotNull
    private List<MicroBean> mMicroBeanListData;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PKMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView(Context context, AttributeSet attrs) {
        setClipChildren(false);
        setClipToPadding(false);
        if (attrs != null) {
            int[] iArr = R.styleable.PKMicroView;
            Intrinsics.checkNotNullExpressionValue(iArr, "PKMicroView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
            this.isRed = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }
        this.binding = RoomMicroPkBinding.inflate(LayoutInflater.from(context), this, true);
        this.mMicListView.clear();
        RoomMicroPkBinding roomMicroPkBinding = this.binding;
        if (roomMicroPkBinding != null) {
            List<BaseItemMicroView> list = this.mMicListView;
            PKItemMicroView pKItemMicroView = roomMicroPkBinding.microView1;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView, "microView1");
            list.add(pKItemMicroView);
            List<BaseItemMicroView> list2 = this.mMicListView;
            PKItemMicroView pKItemMicroView2 = roomMicroPkBinding.microView2;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView2, "microView2");
            list2.add(pKItemMicroView2);
            List<BaseItemMicroView> list3 = this.mMicListView;
            PKItemMicroView pKItemMicroView3 = roomMicroPkBinding.microView3;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView3, "microView3");
            list3.add(pKItemMicroView3);
            List<BaseItemMicroView> list4 = this.mMicListView;
            PKItemMicroView pKItemMicroView4 = roomMicroPkBinding.microView4;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView4, "microView4");
            list4.add(pKItemMicroView4);
            List<BaseItemMicroView> list5 = this.mMicListView;
            PKItemMicroView pKItemMicroView5 = roomMicroPkBinding.microView5;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView5, "microView5");
            list5.add(pKItemMicroView5);
            List<BaseItemMicroView> list6 = this.mMicListView;
            PKItemMicroView pKItemMicroView6 = roomMicroPkBinding.microView6;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView6, "microView6");
            list6.add(pKItemMicroView6);
            List<BaseItemMicroView> list7 = this.mMicListView;
            PKItemMicroView pKItemMicroView7 = roomMicroPkBinding.microView7;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView7, "microView7");
            list7.add(pKItemMicroView7);
            List<BaseItemMicroView> list8 = this.mMicListView;
            PKItemMicroView pKItemMicroView8 = roomMicroPkBinding.microView8;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView8, "microView8");
            list8.add(pKItemMicroView8);
            List<BaseItemMicroView> list9 = this.mMicListView;
            PKItemMicroView pKItemMicroView9 = roomMicroPkBinding.microView9;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView9, "microView9");
            list9.add(pKItemMicroView9);
            List<BaseItemMicroView> list10 = this.mMicListView;
            PKItemMicroView pKItemMicroView10 = roomMicroPkBinding.microView10;
            Intrinsics.checkNotNullExpressionValue(pKItemMicroView10, "microView10");
            list10.add(pKItemMicroView10);
        }
        refreshMic();
    }

    static /* synthetic */ void initView$default(PKMicroView pKMicroView, Context context, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 2) != 0) {
            attributeSet = null;
        }
        pKMicroView.initView(context, attributeSet);
    }

    @Nullable
    public final RoomMicroPkBinding getBinding() {
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

    @NotNull
    public final List<MicroBean> getMMicroBeanListData() {
        return this.mMicroBeanListData;
    }

    /* renamed from: isRed, reason: from getter */
    public final boolean getIsRed() {
        return this.isRed;
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
        MicroBean microBean;
        int i;
        User owner;
        SvipData svip;
        this.mMicroBeanListData.clear();
        int size = this.mMicListView.size();
        int i2 = 0;
        while (i2 < size) {
            if (this.isRed) {
                microBean = MeetingRoomManager.INSTANCE.getMMicQueueMemberMap().get(Integer.valueOf(i2 + 1));
            } else {
                microBean = MeetingRoomManager.INSTANCE.getMPKMicQueueMemberMap().get(Integer.valueOf(i2 + 1));
            }
            if (microBean == null) {
                this.mMicroBeanListData.add(MicroBean.INSTANCE.emptyMicroBean(i2 + 1, this.isRed));
            } else {
                microBean.setRed(this.isRed);
                this.mMicroBeanListData.add(microBean);
            }
            int i3 = i2 + 1;
            this.mMicListView.get(i2).setMPosition(i3);
            BaseItemMicroView baseItemMicroView = this.mMicListView.get(i2);
            MicroBean microBean2 = this.mMicroBeanListData.get(i2);
            GroupDetailBean groupDetailBean = MeetingRoomManager.INSTANCE.getGroupDetailBean();
            if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (svip = owner.getSvip()) != null) {
                i = svip.getSvipLevel();
            } else {
                i = 0;
            }
            baseItemMicroView.updateDate(microBean2, i);
            this.mMicListView.get(i2).updateScore();
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

    public final void setBinding(@Nullable RoomMicroPkBinding roomMicroPkBinding) {
        this.binding = roomMicroPkBinding;
    }

    public final void setMListener(@Nullable OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener) {
        this.mListener = onMeetingRoomMicroItemClickListener;
    }

    public final void setMMicListView(@NotNull List<BaseItemMicroView> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mMicListView = list;
    }

    public final void setMMicroBeanListData(@NotNull List<MicroBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.mMicroBeanListData = list;
    }

    public final void setOnMeetingRoomMicroItemClickListener(@NotNull OnMeetingRoomMicroItemClickListener onMeetingRoomMicroItemClickListener) {
        Intrinsics.checkNotNullParameter(onMeetingRoomMicroItemClickListener, "onMeetingRoomMicroItemClickListener");
        this.mListener = onMeetingRoomMicroItemClickListener;
    }

    public final void setRed(boolean z) {
        this.isRed = z;
    }

    public final void setViewRed(boolean red) {
        this.isRed = red;
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
    public PKMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMicroBeanListData = new ArrayList();
        this.mMicListView = new ArrayList();
        this.isRed = true;
        initView(context, attributeSet);
    }
}

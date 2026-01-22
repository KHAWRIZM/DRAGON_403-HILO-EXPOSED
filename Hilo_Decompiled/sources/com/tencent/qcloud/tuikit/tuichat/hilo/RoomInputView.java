package com.tencent.qcloud.tuikit.tuichat.hilo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.databinding.ChatGroupInputLayoutBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0013H\u0002J-\u0010\u0019\u001a\u00020\u00132%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0016J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u0016J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\nJ\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0016H\u0002J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020\nH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010+0*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/RoomInputView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/ChatGroupInputLayoutBinding;", "mListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "", "mNoble", "mSoundOff", "", "mIsOpenMic", "initViews", "setListener", "listener", "changeRoomSoundStatus", "isOpenMic", "changeRoomMicStatus", "isShow", "hasNewMessage", "isHas", "hideGame", "hide", "refreshGoldView", "noble", "getSoundIcon", "isMuted", "getMicIcon", "isOpen", "cachedDrawables", "", "Landroid/graphics/drawable/Drawable;", "getCachedDrawable", "resId", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomInputView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomInputView.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/RoomInputView\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,294:1\n61#2,9:295\n61#2,9:304\n61#2,9:313\n61#2,9:322\n61#2,9:331\n61#2,9:340\n61#2,9:349\n61#2,9:358\n61#2,9:367\n382#3,3:376\n385#3,4:380\n1#4:379\n*S KotlinDebug\n*F\n+ 1 RoomInputView.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/RoomInputView\n*L\n67#1:295,9\n70#1:304,9\n73#1:313,9\n76#1:322,9\n79#1:331,9\n82#1:340,9\n85#1:349,9\n88#1:358,9\n91#1:367,9\n290#1:376,3\n290#1:380,4\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomInputView extends FrameLayout {
    public static final int FACE = 6;
    public static final int GAME = 4;
    public static final int GIFT = 5;
    public static final int MESSAGE = 3;
    public static final int MIC_FORBID = 7;
    public static final int SOUND = 2;
    public static final int TEXT = 1;
    public static final int TOOL = 8;

    @Nullable
    private ChatGroupInputLayoutBinding binding;

    @NotNull
    private Map<Integer, Drawable> cachedDrawables;
    private boolean mIsOpenMic;

    @Nullable
    private Function1<? super Integer, Unit> mListener;
    private int mNoble;
    private boolean mSoundOff;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomInputView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSoundOff = true;
        this.mIsOpenMic = true;
        this.cachedDrawables = new LinkedHashMap();
        initViews();
    }

    public static /* synthetic */ void changeRoomMicStatus$default(RoomInputView roomInputView, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        roomInputView.changeRoomMicStatus(i, z);
    }

    private final Drawable getCachedDrawable(int resId) {
        Drawable drawable;
        Map<Integer, Drawable> map = this.cachedDrawables;
        Integer valueOf = Integer.valueOf(resId);
        Drawable drawable2 = map.get(valueOf);
        if (drawable2 == null) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, resId);
            } else {
                drawable = null;
            }
            drawable2 = drawable;
            map.put(valueOf, drawable2);
        }
        return drawable2;
    }

    private final int getMicIcon(boolean isOpen) {
        int i = this.mNoble;
        if (i == 9) {
            if (isOpen) {
                return R.drawable.icon_room_mic_gold;
            }
            return R.drawable.icon_room_un_mic_gold;
        }
        if (i >= 10) {
            if (isOpen) {
                return R.drawable.icon_room_mic_gold10;
            }
            return R.drawable.icon_room_un_mic_gold10;
        }
        if (isOpen) {
            return R.drawable.icon_room_mic;
        }
        return R.drawable.icon_room_un_mic;
    }

    private final int getSoundIcon(boolean isMuted) {
        int i = this.mNoble;
        if (i == 9) {
            if (isMuted) {
                return R.drawable.icon_room_chat_mute_gold;
            }
            return R.drawable.icon_room_chat_un_mute_gold;
        }
        if (i >= 10) {
            if (isMuted) {
                return R.drawable.icon_room_chat_mute_gold10;
            }
            return R.drawable.icon_room_chat_un_mute_gold10;
        }
        if (isMuted) {
            return R.drawable.icon_room_chat_mute;
        }
        return R.drawable.icon_room_chat_un_mute;
    }

    private final void initViews() {
        final ImageView imageView;
        final ImageView imageView2;
        final ImageView imageView3;
        final SVGAImageView sVGAImageView;
        final ImageView imageView4;
        final FrameLayout frameLayout;
        final ImageView imageView5;
        final ImageView imageView6;
        final LinearLayout linearLayout;
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding = (ChatGroupInputLayoutBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.chat_group_input_layout, this, true);
        this.binding = chatGroupInputLayoutBinding;
        final long j = 800;
        if (chatGroupInputLayoutBinding != null && (linearLayout = chatGroupInputLayoutBinding.chatClickInput) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(1);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding2 = this.binding;
        if (chatGroupInputLayoutBinding2 != null && (imageView6 = chatGroupInputLayoutBinding2.chatBtnInput) != null) {
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView6) > j || (imageView6 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView6, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(1);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding3 = this.binding;
        if (chatGroupInputLayoutBinding3 != null && (imageView5 = chatGroupInputLayoutBinding3.roomSoundBtn) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView5) > j || (imageView5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView5, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(2);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding4 = this.binding;
        if (chatGroupInputLayoutBinding4 != null && (frameLayout = chatGroupInputLayoutBinding4.chatBtn) != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(3);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding5 = this.binding;
        if (chatGroupInputLayoutBinding5 != null && (imageView4 = chatGroupInputLayoutBinding5.gameBtn) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(4);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding6 = this.binding;
        if (chatGroupInputLayoutBinding6 != null && (sVGAImageView = chatGroupInputLayoutBinding6.giftBtn) != null) {
            sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j || (sVGAImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                        SVGAImageView sVGAImageView2 = sVGAImageView;
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(5);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding7 = this.binding;
        if (chatGroupInputLayoutBinding7 != null && (imageView3 = chatGroupInputLayoutBinding7.faceBtn) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(6);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding8 = this.binding;
        if (chatGroupInputLayoutBinding8 != null && (imageView2 = chatGroupInputLayoutBinding8.micBtn) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(7);
                        }
                    }
                }
            });
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding9 = this.binding;
        if (chatGroupInputLayoutBinding9 != null && (imageView = chatGroupInputLayoutBinding9.toolBtn) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$initViews$$inlined$singleClick$default$9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        function1 = this.mListener;
                        if (function1 != null) {
                            function1.invoke(8);
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setListener$default(RoomInputView roomInputView, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        roomInputView.setListener(function1);
    }

    public final void changeRoomMicStatus(int isShow, boolean isOpenMic) {
        ImageView imageView;
        Context context;
        int i;
        LinearLayout linearLayout;
        int i2;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        this.mIsOpenMic = isOpenMic;
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding = this.binding;
        if (chatGroupInputLayoutBinding != null && (imageView4 = chatGroupInputLayoutBinding.faceBtn) != null) {
            imageView4.setVisibility(isShow);
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding2 = this.binding;
        if (chatGroupInputLayoutBinding2 != null && (imageView3 = chatGroupInputLayoutBinding2.chatBtnInput) != null) {
            imageView3.setVisibility(isShow);
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding3 = this.binding;
        if (chatGroupInputLayoutBinding3 != null && (imageView2 = chatGroupInputLayoutBinding3.micBtn) != null) {
            imageView2.setVisibility(isShow);
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding4 = this.binding;
        if (chatGroupInputLayoutBinding4 != null && (linearLayout = chatGroupInputLayoutBinding4.chatClickInput) != null) {
            if (isShow == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            linearLayout.setVisibility(i2);
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding5 = this.binding;
        if (chatGroupInputLayoutBinding5 != null && (imageView = chatGroupInputLayoutBinding5.micBtn) != null && (context = getContext()) != null) {
            if (isOpenMic) {
                int i3 = this.mNoble;
                if (i3 == 9) {
                    i = R.drawable.icon_room_mic_gold;
                } else if (i3 >= 10) {
                    i = R.drawable.icon_room_mic_gold10;
                } else {
                    i = R.drawable.icon_room_mic;
                }
            } else {
                int i4 = this.mNoble;
                if (i4 == 9) {
                    i = R.drawable.icon_room_un_mic_gold;
                } else if (i4 >= 10) {
                    i = R.drawable.icon_room_un_mic_gold10;
                } else {
                    i = R.drawable.icon_room_un_mic;
                }
            }
            Drawable drawable = androidx.core.content.a.getDrawable(context, i);
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    public final void changeRoomSoundStatus(boolean isOpenMic) {
        ImageView imageView;
        int i;
        ImageView imageView2;
        int i2;
        this.mSoundOff = isOpenMic;
        if (isOpenMic) {
            ChatGroupInputLayoutBinding chatGroupInputLayoutBinding = this.binding;
            if (chatGroupInputLayoutBinding != null && (imageView2 = chatGroupInputLayoutBinding.roomSoundBtn) != null) {
                Context context = getContext();
                int i3 = this.mNoble;
                if (i3 == 9) {
                    i2 = R.drawable.icon_room_chat_un_mute_gold;
                } else if (i3 >= 10) {
                    i2 = R.drawable.icon_room_chat_un_mute_gold10;
                } else {
                    i2 = R.drawable.icon_room_chat_un_mute;
                }
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, i2));
                return;
            }
            return;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding2 = this.binding;
        if (chatGroupInputLayoutBinding2 != null && (imageView = chatGroupInputLayoutBinding2.roomSoundBtn) != null) {
            Context context2 = getContext();
            int i4 = this.mNoble;
            if (i4 == 9) {
                i = R.drawable.icon_room_chat_mute_gold;
            } else if (i4 >= 10) {
                i = R.drawable.icon_room_chat_mute_gold10;
            } else {
                i = R.drawable.icon_room_chat_mute;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context2, i));
        }
    }

    public final void hasNewMessage(boolean isHas) {
        View view;
        View view2;
        if (isHas) {
            ChatGroupInputLayoutBinding chatGroupInputLayoutBinding = this.binding;
            if (chatGroupInputLayoutBinding != null && (view2 = chatGroupInputLayoutBinding.hasMessageRedDoc) != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding2 = this.binding;
        if (chatGroupInputLayoutBinding2 != null && (view = chatGroupInputLayoutBinding2.hasMessageRedDoc) != null) {
            view.setVisibility(8);
        }
    }

    public final void hideGame(boolean hide) {
        ImageView imageView;
        int i;
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding = this.binding;
        if (chatGroupInputLayoutBinding != null && (imageView = chatGroupInputLayoutBinding.gameBtn) != null) {
            if (hide) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    public final void refreshGoldView(int noble) {
        boolean z;
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding;
        ImageView imageView;
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding2;
        ImageView imageView2;
        String str2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        TextView textView;
        ImageView imageView8;
        ImageView imageView9;
        LinearLayout linearLayout;
        this.mNoble = noble;
        boolean z2 = true;
        int i8 = 0;
        if (noble == 9) {
            z = true;
        } else {
            z = false;
        }
        if (noble < 10) {
            z2 = false;
        }
        if (z) {
            i = R.drawable.bg_group_input_editext_gold;
        } else if (z2) {
            i = R.drawable.bg_group_input_editext_gold10;
        } else {
            i = R.drawable.bg_group_input_editext;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding3 = this.binding;
        if (chatGroupInputLayoutBinding3 != null && (linearLayout = chatGroupInputLayoutBinding3.chatClickInput) != null) {
            linearLayout.setBackground(androidx.core.content.a.getDrawable(getContext(), i));
        }
        if (z) {
            i2 = R.drawable.ic_chat_input_gold;
        } else if (z2) {
            i2 = R.drawable.ic_chat_input_gold10;
        } else {
            i2 = R.drawable.ic_chat_input;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding4 = this.binding;
        if (chatGroupInputLayoutBinding4 != null && (imageView9 = chatGroupInputLayoutBinding4.inputImage) != null) {
            imageView9.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i2));
        }
        if (this.mNoble < 9) {
            i8 = UiKtxKt.getDp(7);
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding5 = this.binding;
        if (chatGroupInputLayoutBinding5 != null && (imageView8 = chatGroupInputLayoutBinding5.inputImage) != null) {
            imageView8.setPadding(i8, i8, i8, i8);
        }
        if (this.mNoble >= 9) {
            str = "#FFD02B";
        } else {
            str = "#ffffff";
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding6 = this.binding;
        if (chatGroupInputLayoutBinding6 != null && (textView = chatGroupInputLayoutBinding6.inputText) != null) {
            textView.setTextColor(Color.parseColor(str));
        }
        if (z) {
            i3 = R.drawable.icon_room_input_chat_gold;
        } else if (z2) {
            i3 = R.drawable.icon_room_input_chat_gold10;
        } else {
            i3 = R.drawable.icon_room_input_chat;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding7 = this.binding;
        if (chatGroupInputLayoutBinding7 != null && (imageView7 = chatGroupInputLayoutBinding7.chatBtnInput) != null) {
            imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i3));
        }
        if (z) {
            i4 = R.drawable.icon_group_input_emoji_gold;
        } else if (z2) {
            i4 = R.drawable.icon_group_input_emoji_gold10;
        } else {
            i4 = R.drawable.icon_group_input_emoji;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding8 = this.binding;
        if (chatGroupInputLayoutBinding8 != null && (imageView6 = chatGroupInputLayoutBinding8.faceBtn) != null) {
            imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i4));
        }
        if (z) {
            i5 = R.drawable.icon_group_input_chat_gold;
        } else if (z2) {
            i5 = R.drawable.icon_group_input_chat_gold10;
        } else {
            i5 = R.drawable.icon_group_input_chat;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding9 = this.binding;
        if (chatGroupInputLayoutBinding9 != null && (imageView5 = chatGroupInputLayoutBinding9.chatImage) != null) {
            imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i5));
        }
        if (z) {
            i6 = R.drawable.icon_room_tool_gold;
        } else if (z2) {
            i6 = R.drawable.icon_room_tool_gold10;
        } else {
            i6 = R.drawable.icon_room_tool;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding10 = this.binding;
        if (chatGroupInputLayoutBinding10 != null && (imageView4 = chatGroupInputLayoutBinding10.toolBtn) != null) {
            imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i6));
        }
        if (z) {
            i7 = R.drawable.icon_room_game_gold;
        } else if (z2) {
            i7 = R.drawable.icon_room_game_gold10;
        } else {
            i7 = R.drawable.icon_room_game;
        }
        ChatGroupInputLayoutBinding chatGroupInputLayoutBinding11 = this.binding;
        if (chatGroupInputLayoutBinding11 != null && (imageView3 = chatGroupInputLayoutBinding11.gameBtn) != null) {
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i7));
        }
        try {
            SVGAParser shareParser = SVGAParser.Companion.shareParser();
            int i9 = this.mNoble;
            if (i9 == 9) {
                str2 = "svga/room_gift_icon_gold.svga";
            } else if (i9 >= 10) {
                str2 = "svga/room_gift_icon_gold10.svga";
            } else {
                str2 = "svga/room_gift_icon.svga";
            }
            shareParser.decodeFromAssets(str2, new SVGAParser.ParseCompletion() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.RoomInputView$refreshGoldView$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    ChatGroupInputLayoutBinding chatGroupInputLayoutBinding12;
                    ChatGroupInputLayoutBinding chatGroupInputLayoutBinding13;
                    ChatGroupInputLayoutBinding chatGroupInputLayoutBinding14;
                    SVGAImageView sVGAImageView;
                    SVGAImageView sVGAImageView2;
                    SVGAImageView sVGAImageView3;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    chatGroupInputLayoutBinding12 = RoomInputView.this.binding;
                    if (chatGroupInputLayoutBinding12 != null && (sVGAImageView3 = chatGroupInputLayoutBinding12.giftBtn) != null) {
                        sVGAImageView3.stopAnimation(true);
                    }
                    chatGroupInputLayoutBinding13 = RoomInputView.this.binding;
                    if (chatGroupInputLayoutBinding13 != null && (sVGAImageView2 = chatGroupInputLayoutBinding13.giftBtn) != null) {
                        sVGAImageView2.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                    }
                    chatGroupInputLayoutBinding14 = RoomInputView.this.binding;
                    if (chatGroupInputLayoutBinding14 != null && (sVGAImageView = chatGroupInputLayoutBinding14.giftBtn) != null) {
                        sVGAImageView.startAnimation();
                    }
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Drawable cachedDrawable = getCachedDrawable(getSoundIcon(this.mSoundOff));
        if (cachedDrawable != null && (chatGroupInputLayoutBinding2 = this.binding) != null && (imageView2 = chatGroupInputLayoutBinding2.roomSoundBtn) != null) {
            imageView2.setImageDrawable(cachedDrawable);
        }
        Drawable cachedDrawable2 = getCachedDrawable(getMicIcon(this.mIsOpenMic));
        if (cachedDrawable2 != null && (chatGroupInputLayoutBinding = this.binding) != null && (imageView = chatGroupInputLayoutBinding.micBtn) != null) {
            imageView.setImageDrawable(cachedDrawable2);
        }
    }

    public final void setListener(@Nullable Function1<? super Integer, Unit> listener) {
        this.mListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSoundOff = true;
        this.mIsOpenMic = true;
        this.cachedDrawables = new LinkedHashMap();
        initViews();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSoundOff = true;
        this.mIsOpenMic = true;
        this.cachedDrawables = new LinkedHashMap();
        initViews();
    }
}

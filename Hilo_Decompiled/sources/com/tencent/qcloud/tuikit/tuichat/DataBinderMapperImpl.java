package com.tencent.qcloud.tuikit.tuichat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.tencent.qcloud.tuikit.tuichat.databinding.ChatGroupInputLayoutBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.DialogImMessageClickBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloChatLayoutBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloChatStrangeInputLayoutBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloChatStrangeLayoutBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloGameFragmentBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageAdapterItemContentBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageBroadcastBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageCommonTextBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageCpExitBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageCpInviteBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageCpSuccessBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageCpTipBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageFamilyInviteBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageGiftBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageHeadWearBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageImageTextBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageLikeBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageLinkBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageNobleBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessagePictureLinkBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationExitBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationInviteBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationSuccessBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageRelationTipBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageShareRoomBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageSheepInviteBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageUnionFirstBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageVideoCallBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomActivityBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomEnvolopeBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomEnvolopeGetBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomGiftBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomGlobalGiftBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomJoinUserBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomLudoBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomMatchGameBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomOwnWelcomeBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomPk1v1BindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomRocketBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomRolledBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomTipBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomUnNoBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomUserEnterBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloStrangeMessagePlayTipBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloViewMessageGiftBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.IncludeMessageTitleChatBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.ItemGameBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.MessageAdapterContentImageBindingImpl;
import com.tencent.qcloud.tuikit.tuichat.databinding.MessageAdapterContentTextBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class DataBinderMapperImpl extends e {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_CHATGROUPINPUTLAYOUT = 1;
    private static final int LAYOUT_DIALOGIMMESSAGECLICK = 2;
    private static final int LAYOUT_HILOCHATLAYOUT = 3;
    private static final int LAYOUT_HILOCHATSTRANGEINPUTLAYOUT = 4;
    private static final int LAYOUT_HILOCHATSTRANGELAYOUT = 5;
    private static final int LAYOUT_HILOGAMEFRAGMENT = 6;
    private static final int LAYOUT_HILOMESSAGEADAPTERITEMCONTENT = 7;
    private static final int LAYOUT_HILOMESSAGEBROADCAST = 8;
    private static final int LAYOUT_HILOMESSAGECOMMONTEXT = 9;
    private static final int LAYOUT_HILOMESSAGECPEXIT = 10;
    private static final int LAYOUT_HILOMESSAGECPINVITE = 11;
    private static final int LAYOUT_HILOMESSAGECPSUCCESS = 12;
    private static final int LAYOUT_HILOMESSAGECPTIP = 13;
    private static final int LAYOUT_HILOMESSAGEFAMILYINVITE = 14;
    private static final int LAYOUT_HILOMESSAGEGIFT = 15;
    private static final int LAYOUT_HILOMESSAGEHEADWEAR = 16;
    private static final int LAYOUT_HILOMESSAGEIMAGETEXT = 17;
    private static final int LAYOUT_HILOMESSAGELIKE = 18;
    private static final int LAYOUT_HILOMESSAGELINK = 19;
    private static final int LAYOUT_HILOMESSAGENOBLE = 20;
    private static final int LAYOUT_HILOMESSAGEPICTURELINK = 21;
    private static final int LAYOUT_HILOMESSAGERELATIONEXIT = 22;
    private static final int LAYOUT_HILOMESSAGERELATIONINVITE = 23;
    private static final int LAYOUT_HILOMESSAGERELATIONSUCCESS = 24;
    private static final int LAYOUT_HILOMESSAGERELATIONTIP = 25;
    private static final int LAYOUT_HILOMESSAGESHAREROOM = 26;
    private static final int LAYOUT_HILOMESSAGESHEEPINVITE = 27;
    private static final int LAYOUT_HILOMESSAGEUNIONFIRST = 28;
    private static final int LAYOUT_HILOMESSAGEVIDEOCALL = 29;
    private static final int LAYOUT_HILOROOMACTIVITY = 30;
    private static final int LAYOUT_HILOROOMENVOLOPE = 31;
    private static final int LAYOUT_HILOROOMENVOLOPEGET = 32;
    private static final int LAYOUT_HILOROOMGIFT = 33;
    private static final int LAYOUT_HILOROOMGLOBALGIFT = 34;
    private static final int LAYOUT_HILOROOMJOINUSER = 35;
    private static final int LAYOUT_HILOROOMLUDO = 36;
    private static final int LAYOUT_HILOROOMMATCHGAME = 37;
    private static final int LAYOUT_HILOROOMOWNWELCOME = 38;
    private static final int LAYOUT_HILOROOMPK1V1 = 39;
    private static final int LAYOUT_HILOROOMROCKET = 40;
    private static final int LAYOUT_HILOROOMROLLED = 41;
    private static final int LAYOUT_HILOROOMTIP = 42;
    private static final int LAYOUT_HILOROOMUNNO = 43;
    private static final int LAYOUT_HILOROOMUSERENTER = 44;
    private static final int LAYOUT_HILOSTRANGEMESSAGEPLAYTIP = 45;
    private static final int LAYOUT_HILOVIEWMESSAGEGIFT = 46;
    private static final int LAYOUT_INCLUDEMESSAGETITLECHAT = 47;
    private static final int LAYOUT_ITEMGAME = 48;
    private static final int LAYOUT_MESSAGEADAPTERCONTENTIMAGE = 49;
    private static final int LAYOUT_MESSAGEADAPTERCONTENTTEXT = 50;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(2);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "click");
        }

        private InnerBrLookup() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(50);
            sKeys = hashMap;
            hashMap.put("layout/chat_group_input_layout_0", Integer.valueOf(R.layout.chat_group_input_layout));
            hashMap.put("layout/dialog_im_message_click_0", Integer.valueOf(R.layout.dialog_im_message_click));
            hashMap.put("layout/hilo_chat_layout_0", Integer.valueOf(R.layout.hilo_chat_layout));
            hashMap.put("layout/hilo_chat_strange_input_layout_0", Integer.valueOf(R.layout.hilo_chat_strange_input_layout));
            hashMap.put("layout/hilo_chat_strange_layout_0", Integer.valueOf(R.layout.hilo_chat_strange_layout));
            hashMap.put("layout/hilo_game_fragment_0", Integer.valueOf(R.layout.hilo_game_fragment));
            hashMap.put("layout/hilo_message_adapter_item_content_0", Integer.valueOf(R.layout.hilo_message_adapter_item_content));
            hashMap.put("layout/hilo_message_broadcast_0", Integer.valueOf(R.layout.hilo_message_broadcast));
            hashMap.put("layout/hilo_message_common_text_0", Integer.valueOf(R.layout.hilo_message_common_text));
            hashMap.put("layout/hilo_message_cp_exit_0", Integer.valueOf(R.layout.hilo_message_cp_exit));
            hashMap.put("layout/hilo_message_cp_invite_0", Integer.valueOf(R.layout.hilo_message_cp_invite));
            hashMap.put("layout/hilo_message_cp_success_0", Integer.valueOf(R.layout.hilo_message_cp_success));
            hashMap.put("layout/hilo_message_cp_tip_0", Integer.valueOf(R.layout.hilo_message_cp_tip));
            hashMap.put("layout/hilo_message_family_invite_0", Integer.valueOf(R.layout.hilo_message_family_invite));
            hashMap.put("layout/hilo_message_gift_0", Integer.valueOf(R.layout.hilo_message_gift));
            hashMap.put("layout/hilo_message_head_wear_0", Integer.valueOf(R.layout.hilo_message_head_wear));
            hashMap.put("layout/hilo_message_image_text_0", Integer.valueOf(R.layout.hilo_message_image_text));
            hashMap.put("layout/hilo_message_like_0", Integer.valueOf(R.layout.hilo_message_like));
            hashMap.put("layout/hilo_message_link_0", Integer.valueOf(R.layout.hilo_message_link));
            hashMap.put("layout/hilo_message_noble_0", Integer.valueOf(R.layout.hilo_message_noble));
            hashMap.put("layout/hilo_message_picture_link_0", Integer.valueOf(R.layout.hilo_message_picture_link));
            hashMap.put("layout/hilo_message_relation_exit_0", Integer.valueOf(R.layout.hilo_message_relation_exit));
            hashMap.put("layout/hilo_message_relation_invite_0", Integer.valueOf(R.layout.hilo_message_relation_invite));
            hashMap.put("layout/hilo_message_relation_success_0", Integer.valueOf(R.layout.hilo_message_relation_success));
            hashMap.put("layout/hilo_message_relation_tip_0", Integer.valueOf(R.layout.hilo_message_relation_tip));
            hashMap.put("layout/hilo_message_share_room_0", Integer.valueOf(R.layout.hilo_message_share_room));
            hashMap.put("layout/hilo_message_sheep_invite_0", Integer.valueOf(R.layout.hilo_message_sheep_invite));
            hashMap.put("layout/hilo_message_union_first_0", Integer.valueOf(R.layout.hilo_message_union_first));
            hashMap.put("layout/hilo_message_video_call_0", Integer.valueOf(R.layout.hilo_message_video_call));
            hashMap.put("layout/hilo_room_activity_0", Integer.valueOf(R.layout.hilo_room_activity));
            hashMap.put("layout/hilo_room_envolope_0", Integer.valueOf(R.layout.hilo_room_envolope));
            hashMap.put("layout/hilo_room_envolope_get_0", Integer.valueOf(R.layout.hilo_room_envolope_get));
            hashMap.put("layout/hilo_room_gift_0", Integer.valueOf(R.layout.hilo_room_gift));
            hashMap.put("layout/hilo_room_global_gift_0", Integer.valueOf(R.layout.hilo_room_global_gift));
            hashMap.put("layout/hilo_room_join_user_0", Integer.valueOf(R.layout.hilo_room_join_user));
            hashMap.put("layout/hilo_room_ludo_0", Integer.valueOf(R.layout.hilo_room_ludo));
            hashMap.put("layout/hilo_room_match_game_0", Integer.valueOf(R.layout.hilo_room_match_game));
            hashMap.put("layout/hilo_room_own_welcome_0", Integer.valueOf(R.layout.hilo_room_own_welcome));
            hashMap.put("layout/hilo_room_pk1v1_0", Integer.valueOf(R.layout.hilo_room_pk1v1));
            hashMap.put("layout/hilo_room_rocket_0", Integer.valueOf(R.layout.hilo_room_rocket));
            hashMap.put("layout/hilo_room_rolled_0", Integer.valueOf(R.layout.hilo_room_rolled));
            hashMap.put("layout/hilo_room_tip_0", Integer.valueOf(R.layout.hilo_room_tip));
            hashMap.put("layout/hilo_room_un_no_0", Integer.valueOf(R.layout.hilo_room_un_no));
            hashMap.put("layout/hilo_room_user_enter_0", Integer.valueOf(R.layout.hilo_room_user_enter));
            hashMap.put("layout/hilo_strange_message_play_tip_0", Integer.valueOf(R.layout.hilo_strange_message_play_tip));
            hashMap.put("layout/hilo_view_message_gift_0", Integer.valueOf(R.layout.hilo_view_message_gift));
            hashMap.put("layout/include_message_title_chat_0", Integer.valueOf(R.layout.include_message_title_chat));
            hashMap.put("layout/item_game_0", Integer.valueOf(R.layout.item_game));
            hashMap.put("layout/message_adapter_content_image_0", Integer.valueOf(R.layout.message_adapter_content_image));
            hashMap.put("layout/message_adapter_content_text_0", Integer.valueOf(R.layout.message_adapter_content_text));
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(50);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.chat_group_input_layout, 1);
        sparseIntArray.put(R.layout.dialog_im_message_click, 2);
        sparseIntArray.put(R.layout.hilo_chat_layout, 3);
        sparseIntArray.put(R.layout.hilo_chat_strange_input_layout, 4);
        sparseIntArray.put(R.layout.hilo_chat_strange_layout, 5);
        sparseIntArray.put(R.layout.hilo_game_fragment, 6);
        sparseIntArray.put(R.layout.hilo_message_adapter_item_content, 7);
        sparseIntArray.put(R.layout.hilo_message_broadcast, 8);
        sparseIntArray.put(R.layout.hilo_message_common_text, 9);
        sparseIntArray.put(R.layout.hilo_message_cp_exit, 10);
        sparseIntArray.put(R.layout.hilo_message_cp_invite, 11);
        sparseIntArray.put(R.layout.hilo_message_cp_success, 12);
        sparseIntArray.put(R.layout.hilo_message_cp_tip, 13);
        sparseIntArray.put(R.layout.hilo_message_family_invite, 14);
        sparseIntArray.put(R.layout.hilo_message_gift, 15);
        sparseIntArray.put(R.layout.hilo_message_head_wear, 16);
        sparseIntArray.put(R.layout.hilo_message_image_text, 17);
        sparseIntArray.put(R.layout.hilo_message_like, 18);
        sparseIntArray.put(R.layout.hilo_message_link, 19);
        sparseIntArray.put(R.layout.hilo_message_noble, 20);
        sparseIntArray.put(R.layout.hilo_message_picture_link, 21);
        sparseIntArray.put(R.layout.hilo_message_relation_exit, 22);
        sparseIntArray.put(R.layout.hilo_message_relation_invite, 23);
        sparseIntArray.put(R.layout.hilo_message_relation_success, 24);
        sparseIntArray.put(R.layout.hilo_message_relation_tip, 25);
        sparseIntArray.put(R.layout.hilo_message_share_room, 26);
        sparseIntArray.put(R.layout.hilo_message_sheep_invite, 27);
        sparseIntArray.put(R.layout.hilo_message_union_first, 28);
        sparseIntArray.put(R.layout.hilo_message_video_call, 29);
        sparseIntArray.put(R.layout.hilo_room_activity, 30);
        sparseIntArray.put(R.layout.hilo_room_envolope, 31);
        sparseIntArray.put(R.layout.hilo_room_envolope_get, 32);
        sparseIntArray.put(R.layout.hilo_room_gift, 33);
        sparseIntArray.put(R.layout.hilo_room_global_gift, 34);
        sparseIntArray.put(R.layout.hilo_room_join_user, 35);
        sparseIntArray.put(R.layout.hilo_room_ludo, 36);
        sparseIntArray.put(R.layout.hilo_room_match_game, 37);
        sparseIntArray.put(R.layout.hilo_room_own_welcome, 38);
        sparseIntArray.put(R.layout.hilo_room_pk1v1, 39);
        sparseIntArray.put(R.layout.hilo_room_rocket, 40);
        sparseIntArray.put(R.layout.hilo_room_rolled, 41);
        sparseIntArray.put(R.layout.hilo_room_tip, 42);
        sparseIntArray.put(R.layout.hilo_room_un_no, 43);
        sparseIntArray.put(R.layout.hilo_room_user_enter, 44);
        sparseIntArray.put(R.layout.hilo_strange_message_play_tip, 45);
        sparseIntArray.put(R.layout.hilo_view_message_gift, 46);
        sparseIntArray.put(R.layout.include_message_title_chat, 47);
        sparseIntArray.put(R.layout.item_game, 48);
        sparseIntArray.put(R.layout.message_adapter_content_image, 49);
        sparseIntArray.put(R.layout.message_adapter_content_text, 50);
    }

    public List<e> collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.qiahao.base_common.DataBinderMapperImpl());
        arrayList.add(new com.ruffian.library.widget.DataBinderMapperImpl());
        return arrayList;
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public ViewDataBinding getDataBinder(f fVar, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/chat_group_input_layout_0".equals(tag)) {
                        return new ChatGroupInputLayoutBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for chat_group_input_layout is invalid. Received: " + tag);
                case 2:
                    if ("layout/dialog_im_message_click_0".equals(tag)) {
                        return new DialogImMessageClickBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_im_message_click is invalid. Received: " + tag);
                case 3:
                    if ("layout/hilo_chat_layout_0".equals(tag)) {
                        return new HiloChatLayoutBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_chat_layout is invalid. Received: " + tag);
                case 4:
                    if ("layout/hilo_chat_strange_input_layout_0".equals(tag)) {
                        return new HiloChatStrangeInputLayoutBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_chat_strange_input_layout is invalid. Received: " + tag);
                case 5:
                    if ("layout/hilo_chat_strange_layout_0".equals(tag)) {
                        return new HiloChatStrangeLayoutBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_chat_strange_layout is invalid. Received: " + tag);
                case 6:
                    if ("layout/hilo_game_fragment_0".equals(tag)) {
                        return new HiloGameFragmentBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_game_fragment is invalid. Received: " + tag);
                case 7:
                    if ("layout/hilo_message_adapter_item_content_0".equals(tag)) {
                        return new HiloMessageAdapterItemContentBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_adapter_item_content is invalid. Received: " + tag);
                case 8:
                    if ("layout/hilo_message_broadcast_0".equals(tag)) {
                        return new HiloMessageBroadcastBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_broadcast is invalid. Received: " + tag);
                case 9:
                    if ("layout/hilo_message_common_text_0".equals(tag)) {
                        return new HiloMessageCommonTextBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_common_text is invalid. Received: " + tag);
                case 10:
                    if ("layout/hilo_message_cp_exit_0".equals(tag)) {
                        return new HiloMessageCpExitBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_cp_exit is invalid. Received: " + tag);
                case 11:
                    if ("layout/hilo_message_cp_invite_0".equals(tag)) {
                        return new HiloMessageCpInviteBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_cp_invite is invalid. Received: " + tag);
                case 12:
                    if ("layout/hilo_message_cp_success_0".equals(tag)) {
                        return new HiloMessageCpSuccessBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_cp_success is invalid. Received: " + tag);
                case 13:
                    if ("layout/hilo_message_cp_tip_0".equals(tag)) {
                        return new HiloMessageCpTipBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_cp_tip is invalid. Received: " + tag);
                case 14:
                    if ("layout/hilo_message_family_invite_0".equals(tag)) {
                        return new HiloMessageFamilyInviteBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_family_invite is invalid. Received: " + tag);
                case 15:
                    if ("layout/hilo_message_gift_0".equals(tag)) {
                        return new HiloMessageGiftBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_gift is invalid. Received: " + tag);
                case 16:
                    if ("layout/hilo_message_head_wear_0".equals(tag)) {
                        return new HiloMessageHeadWearBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_head_wear is invalid. Received: " + tag);
                case 17:
                    if ("layout/hilo_message_image_text_0".equals(tag)) {
                        return new HiloMessageImageTextBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_image_text is invalid. Received: " + tag);
                case 18:
                    if ("layout/hilo_message_like_0".equals(tag)) {
                        return new HiloMessageLikeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_like is invalid. Received: " + tag);
                case 19:
                    if ("layout/hilo_message_link_0".equals(tag)) {
                        return new HiloMessageLinkBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_link is invalid. Received: " + tag);
                case 20:
                    if ("layout/hilo_message_noble_0".equals(tag)) {
                        return new HiloMessageNobleBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_noble is invalid. Received: " + tag);
                case 21:
                    if ("layout/hilo_message_picture_link_0".equals(tag)) {
                        return new HiloMessagePictureLinkBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_picture_link is invalid. Received: " + tag);
                case 22:
                    if ("layout/hilo_message_relation_exit_0".equals(tag)) {
                        return new HiloMessageRelationExitBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_relation_exit is invalid. Received: " + tag);
                case 23:
                    if ("layout/hilo_message_relation_invite_0".equals(tag)) {
                        return new HiloMessageRelationInviteBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_relation_invite is invalid. Received: " + tag);
                case 24:
                    if ("layout/hilo_message_relation_success_0".equals(tag)) {
                        return new HiloMessageRelationSuccessBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_relation_success is invalid. Received: " + tag);
                case 25:
                    if ("layout/hilo_message_relation_tip_0".equals(tag)) {
                        return new HiloMessageRelationTipBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_relation_tip is invalid. Received: " + tag);
                case 26:
                    if ("layout/hilo_message_share_room_0".equals(tag)) {
                        return new HiloMessageShareRoomBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_share_room is invalid. Received: " + tag);
                case 27:
                    if ("layout/hilo_message_sheep_invite_0".equals(tag)) {
                        return new HiloMessageSheepInviteBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_sheep_invite is invalid. Received: " + tag);
                case 28:
                    if ("layout/hilo_message_union_first_0".equals(tag)) {
                        return new HiloMessageUnionFirstBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_union_first is invalid. Received: " + tag);
                case 29:
                    if ("layout/hilo_message_video_call_0".equals(tag)) {
                        return new HiloMessageVideoCallBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_message_video_call is invalid. Received: " + tag);
                case 30:
                    if ("layout/hilo_room_activity_0".equals(tag)) {
                        return new HiloRoomActivityBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_activity is invalid. Received: " + tag);
                case 31:
                    if ("layout/hilo_room_envolope_0".equals(tag)) {
                        return new HiloRoomEnvolopeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_envolope is invalid. Received: " + tag);
                case 32:
                    if ("layout/hilo_room_envolope_get_0".equals(tag)) {
                        return new HiloRoomEnvolopeGetBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_envolope_get is invalid. Received: " + tag);
                case 33:
                    if ("layout/hilo_room_gift_0".equals(tag)) {
                        return new HiloRoomGiftBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_gift is invalid. Received: " + tag);
                case 34:
                    if ("layout/hilo_room_global_gift_0".equals(tag)) {
                        return new HiloRoomGlobalGiftBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_global_gift is invalid. Received: " + tag);
                case 35:
                    if ("layout/hilo_room_join_user_0".equals(tag)) {
                        return new HiloRoomJoinUserBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_join_user is invalid. Received: " + tag);
                case 36:
                    if ("layout/hilo_room_ludo_0".equals(tag)) {
                        return new HiloRoomLudoBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_ludo is invalid. Received: " + tag);
                case 37:
                    if ("layout/hilo_room_match_game_0".equals(tag)) {
                        return new HiloRoomMatchGameBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_match_game is invalid. Received: " + tag);
                case 38:
                    if ("layout/hilo_room_own_welcome_0".equals(tag)) {
                        return new HiloRoomOwnWelcomeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_own_welcome is invalid. Received: " + tag);
                case 39:
                    if ("layout/hilo_room_pk1v1_0".equals(tag)) {
                        return new HiloRoomPk1v1BindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_pk1v1 is invalid. Received: " + tag);
                case 40:
                    if ("layout/hilo_room_rocket_0".equals(tag)) {
                        return new HiloRoomRocketBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_rocket is invalid. Received: " + tag);
                case 41:
                    if ("layout/hilo_room_rolled_0".equals(tag)) {
                        return new HiloRoomRolledBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_rolled is invalid. Received: " + tag);
                case 42:
                    if ("layout/hilo_room_tip_0".equals(tag)) {
                        return new HiloRoomTipBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_tip is invalid. Received: " + tag);
                case 43:
                    if ("layout/hilo_room_un_no_0".equals(tag)) {
                        return new HiloRoomUnNoBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_un_no is invalid. Received: " + tag);
                case 44:
                    if ("layout/hilo_room_user_enter_0".equals(tag)) {
                        return new HiloRoomUserEnterBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_room_user_enter is invalid. Received: " + tag);
                case 45:
                    if ("layout/hilo_strange_message_play_tip_0".equals(tag)) {
                        return new HiloStrangeMessagePlayTipBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_strange_message_play_tip is invalid. Received: " + tag);
                case 46:
                    if ("layout/hilo_view_message_gift_0".equals(tag)) {
                        return new HiloViewMessageGiftBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for hilo_view_message_gift is invalid. Received: " + tag);
                case 47:
                    if ("layout/include_message_title_chat_0".equals(tag)) {
                        return new IncludeMessageTitleChatBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for include_message_title_chat is invalid. Received: " + tag);
                case 48:
                    if ("layout/item_game_0".equals(tag)) {
                        return new ItemGameBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_game is invalid. Received: " + tag);
                case 49:
                    if ("layout/message_adapter_content_image_0".equals(tag)) {
                        return new MessageAdapterContentImageBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for message_adapter_content_image is invalid. Received: " + tag);
                case 50:
                    if ("layout/message_adapter_content_text_0".equals(tag)) {
                        return new MessageAdapterContentTextBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException("The tag for message_adapter_content_text is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

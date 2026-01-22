package com.qiahao.hilo_message;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.qiahao.hilo_message.databinding.IncludeMessageTitleBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomActivityBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomCreateSudGameBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomEnvolopeGetBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomGiftBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomJoinUserBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomMatchGameBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomPk1v1BindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomReceiveEnvolopeBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomRocketMessageBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomRolledBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomTaskBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomTipBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomUserEnterBindingImpl;
import com.qiahao.hilo_message.databinding.RoomCustomWelcomeBindingImpl;
import com.qiahao.hilo_message.databinding.RoomMessageDefaultTextBindingImpl;
import com.qiahao.hilo_message.databinding.RoomMessageImageBindingImpl;
import com.qiahao.hilo_message.databinding.RoomMessageNoSupportCostomBindingImpl;
import com.qiahao.hilo_message.databinding.RoomMessageTextBindingImpl;
import java.util.ArrayList;
import java.util.List;
import p1.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DataBinderMapperImpl extends e {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f١٢٦٩٩a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(20);
        f١٢٦٩٩a = sparseIntArray;
        sparseIntArray.put(R.layout.include_message_title, 1);
        sparseIntArray.put(R.layout.room_custom_activity, 2);
        sparseIntArray.put(R.layout.room_custom_create_sud_game, 3);
        sparseIntArray.put(R.layout.room_custom_envolope_get, 4);
        sparseIntArray.put(R.layout.room_custom_gift, 5);
        sparseIntArray.put(R.layout.room_custom_global_gift, 6);
        sparseIntArray.put(R.layout.room_custom_join_user, 7);
        sparseIntArray.put(R.layout.room_custom_match_game, 8);
        sparseIntArray.put(R.layout.room_custom_pk1v1, 9);
        sparseIntArray.put(R.layout.room_custom_receive_envolope, 10);
        sparseIntArray.put(R.layout.room_custom_rocket_message, 11);
        sparseIntArray.put(R.layout.room_custom_rolled, 12);
        sparseIntArray.put(R.layout.room_custom_task, 13);
        sparseIntArray.put(R.layout.room_custom_tip, 14);
        sparseIntArray.put(R.layout.room_custom_user_enter, 15);
        sparseIntArray.put(R.layout.room_custom_welcome, 16);
        sparseIntArray.put(R.layout.room_message_default_text, 17);
        sparseIntArray.put(R.layout.room_message_image, 18);
        sparseIntArray.put(R.layout.room_message_no_support_costom, 19);
        sparseIntArray.put(R.layout.room_message_text, 20);
    }

    @Override // androidx.databinding.e
    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.qiahao.base_common.DataBinderMapperImpl());
        arrayList.add(new com.ruffian.library.widget.DataBinderMapperImpl());
        arrayList.add(new com.tencent.qcloud.tuikit.tuichat.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public final ViewDataBinding getDataBinder(f fVar, View view, int i10) {
        int i11 = f١٢٦٩٩a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i11) {
                case 1:
                    if ("layout/include_message_title_0".equals(tag)) {
                        return new IncludeMessageTitleBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for include_message_title is invalid. Received: ", tag));
                case 2:
                    if ("layout/room_custom_activity_0".equals(tag)) {
                        return new RoomCustomActivityBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_activity is invalid. Received: ", tag));
                case 3:
                    if ("layout/room_custom_create_sud_game_0".equals(tag)) {
                        return new RoomCustomCreateSudGameBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_create_sud_game is invalid. Received: ", tag));
                case 4:
                    if ("layout/room_custom_envolope_get_0".equals(tag)) {
                        return new RoomCustomEnvolopeGetBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_envolope_get is invalid. Received: ", tag));
                case 5:
                    if ("layout/room_custom_gift_0".equals(tag)) {
                        return new RoomCustomGiftBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_gift is invalid. Received: ", tag));
                case 6:
                    if ("layout/room_custom_global_gift_0".equals(tag)) {
                        return new RoomCustomGlobalGiftBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_global_gift is invalid. Received: ", tag));
                case 7:
                    if ("layout/room_custom_join_user_0".equals(tag)) {
                        return new RoomCustomJoinUserBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_join_user is invalid. Received: ", tag));
                case 8:
                    if ("layout/room_custom_match_game_0".equals(tag)) {
                        return new RoomCustomMatchGameBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_match_game is invalid. Received: ", tag));
                case 9:
                    if ("layout/room_custom_pk1v1_0".equals(tag)) {
                        return new RoomCustomPk1v1BindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_pk1v1 is invalid. Received: ", tag));
                case 10:
                    if ("layout/room_custom_receive_envolope_0".equals(tag)) {
                        return new RoomCustomReceiveEnvolopeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_receive_envolope is invalid. Received: ", tag));
                case 11:
                    if ("layout/room_custom_rocket_message_0".equals(tag)) {
                        return new RoomCustomRocketMessageBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_rocket_message is invalid. Received: ", tag));
                case 12:
                    if ("layout/room_custom_rolled_0".equals(tag)) {
                        return new RoomCustomRolledBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_rolled is invalid. Received: ", tag));
                case 13:
                    if ("layout/room_custom_task_0".equals(tag)) {
                        return new RoomCustomTaskBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_task is invalid. Received: ", tag));
                case 14:
                    if ("layout/room_custom_tip_0".equals(tag)) {
                        return new RoomCustomTipBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_tip is invalid. Received: ", tag));
                case 15:
                    if ("layout/room_custom_user_enter_0".equals(tag)) {
                        return new RoomCustomUserEnterBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_user_enter is invalid. Received: ", tag));
                case 16:
                    if ("layout/room_custom_welcome_0".equals(tag)) {
                        return new RoomCustomWelcomeBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_custom_welcome is invalid. Received: ", tag));
                case 17:
                    if ("layout/room_message_default_text_0".equals(tag)) {
                        return new RoomMessageDefaultTextBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_message_default_text is invalid. Received: ", tag));
                case 18:
                    if ("layout/room_message_image_0".equals(tag)) {
                        return new RoomMessageImageBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_message_image is invalid. Received: ", tag));
                case 19:
                    if ("layout/room_message_no_support_costom_0".equals(tag)) {
                        return new RoomMessageNoSupportCostomBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_message_no_support_costom is invalid. Received: ", tag));
                case 20:
                    if ("layout/room_message_text_0".equals(tag)) {
                        return new RoomMessageTextBindingImpl(fVar, view);
                    }
                    throw new IllegalArgumentException(c.a("The tag for room_message_text is invalid. Received: ", tag));
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.e
    public final int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) a.f١٢٧٠١a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public final ViewDataBinding getDataBinder(f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f١٢٦٩٩a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

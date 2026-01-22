package tech.sud.mgp.SudMGPWrapper.utils;

import com.taobao.agoo.a.a.b;
import tech.sud.gip.core.ISudFSMStateHandle;
import tech.sud.mgp.SudMGPWrapper.state.MGStateResponse;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ISudFSMStateHandleUtils {
    public static void handleSuccess(ISudFSMStateHandle iSudFSMStateHandle) {
        MGStateResponse mGStateResponse = new MGStateResponse();
        mGStateResponse.ret_code = 0;
        mGStateResponse.ret_msg = b.JSON_SUCCESS;
        iSudFSMStateHandle.success(SudJsonUtils.toJson(mGStateResponse));
    }
}

package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class AbstractRequestHandler implements RequestHandler {
    @Override // com.amazonaws.handlers.RequestHandler
    public void afterError(Request<?> request, Exception exc) {
    }

    @Override // com.amazonaws.handlers.RequestHandler
    public void afterResponse(Request<?> request, Object obj, TimingInfo timingInfo) {
    }

    @Override // com.amazonaws.handlers.RequestHandler
    public void beforeRequest(Request<?> request) {
    }
}

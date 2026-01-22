package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.File;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface ObjectMetadataProvider {
    void provideObjectMetadata(File file, ObjectMetadata objectMetadata);
}

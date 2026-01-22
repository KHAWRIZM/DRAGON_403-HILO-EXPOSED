package com.amazonaws.util.json;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface AwsJsonWriter {
    AwsJsonWriter beginArray() throws IOException;

    AwsJsonWriter beginObject() throws IOException;

    void close() throws IOException;

    AwsJsonWriter endArray() throws IOException;

    AwsJsonWriter endObject() throws IOException;

    void flush() throws IOException;

    AwsJsonWriter name(String str) throws IOException;

    AwsJsonWriter value() throws IOException;

    AwsJsonWriter value(double d10) throws IOException;

    AwsJsonWriter value(long j10) throws IOException;

    AwsJsonWriter value(Number number) throws IOException;

    AwsJsonWriter value(String str) throws IOException;

    AwsJsonWriter value(ByteBuffer byteBuffer) throws IOException;

    AwsJsonWriter value(Date date) throws IOException;

    AwsJsonWriter value(boolean z10) throws IOException;
}

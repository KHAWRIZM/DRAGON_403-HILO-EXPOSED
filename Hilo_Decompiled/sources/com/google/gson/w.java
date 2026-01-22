package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class w {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends w {
        a() {
        }

        @Override // com.google.gson.w
        public Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return w.this.read(jsonReader);
        }

        @Override // com.google.gson.w
        public void write(JsonWriter jsonWriter, Object obj) {
            if (obj == null) {
                jsonWriter.nullValue();
            } else {
                w.this.write(jsonWriter, obj);
            }
        }
    }

    public final Object fromJson(Reader reader) throws IOException {
        return read(new JsonReader(reader));
    }

    public final Object fromJsonTree(i iVar) {
        try {
            return read(new r8.f(iVar));
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    public final w nullSafe() {
        return new a();
    }

    public abstract Object read(JsonReader jsonReader);

    public final void toJson(Writer writer, Object obj) throws IOException {
        write(new JsonWriter(writer), obj);
    }

    public final i toJsonTree(Object obj) {
        try {
            r8.g gVar = new r8.g();
            write(gVar, obj);
            return gVar.a();
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    public abstract void write(JsonWriter jsonWriter, Object obj);

    public final Object fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, obj);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new j(e10);
        }
    }
}

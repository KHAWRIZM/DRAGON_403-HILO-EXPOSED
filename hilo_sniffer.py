# [ACTION]: SOVEREIGN SNIFFER LOGIC
# DRAGON403 - HILO Traffic Interceptor
# Usage: mitmproxy -s hilo_sniffer.py

from mitmproxy import http
import json

def request(flow: http.HTTPFlow) -> None:
    # رصد أي اتصال موجه لسيرفرات العصابة
    targets = ["faceline.live", "tikhak.com", "hiloconn.com"]
    if any(domain in flow.request.pretty_host for domain in targets):
        print(f"🎯 [MATCH] Intercepted Request to: {flow.request.pretty_host}")
        
        # صيد الـ Authorization Header
        auth = flow.request.headers.get("Authorization")
        if auth:
            with open("captured_tokens.log", "a") as f:
                f.write(f"HOST: {flow.request.pretty_host} | TOKEN: {auth}\n")
            print("✅ TOKEN SECURED IN LOG.")

def response(flow: http.HTTPFlow) -> None:
    # صيد بيانات الحساب من الـ JSON الراجع من السيرفر
    if flow.response.headers.get("Content-Type") == "application/json":
        try:
            data = json.loads(flow.response.get_text())
            # ابحث عن userId أو الـ Admin flags
            if "userId" in str(data):
                print(f"👤 Found User/Admin Data: {data}")
        except:
            pass

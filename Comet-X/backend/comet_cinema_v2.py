# 🐉 COMET CINEMA V2 - NO BULLSHIT EDITION
# يشتغل ويخلص - بدون فلسفة

import subprocess
import os

# المسارات
FFMPEG = r"C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
OUTPUT_DIR = r"C:\Users\admin\Desktop\HILO_CASE\Documentary\comet_output"
os.makedirs(OUTPUT_DIR, exist_ok=True)

# المشاهد - بسيط ومباشر
SCENES = [
    ("ACCESS DENIED", "ERROR 403 FORBIDDEN", "0xFF0000", 4),
    ("2011", "RIYADH SAUDI ARABIA", "0x00FF00", 4),
    ("A YOUNG HACKER", "DISCOVERED A VULNERABILITY", "0x3b82f6", 5),
    ("MICROSOFT HOTMAIL", "SYSTEM BREACH", "0xFF0000", 4),
    ("1904 BREACHES", "ZONE-H ARCHIVE", "0x00FF00", 4),
    ("THE EMPIRE FELL", "THE MIGRATION BEGAN", "0xFF4500", 4),
    ("TROPHY CLAIMED", "v@hotmail.com", "0xFFD700", 5),
    ("15 YEARS LATER", "...", "0xFFFFFF", 3),
    ("D R A G O N", "4 0 3", "0xFF0000", 5),
    ("THE FORBIDDENS KILLER", "RETURNS", "0xFF0000", 4),
    ("TARGET IDENTIFIED", "HILO FRAUD NETWORK", "0x00FF00", 4),
    ("50 MILLION USD", "STOLEN FROM VICTIMS", "0xFF0000", 4),
    ("GOOGLE AND APPLE", "KNEW EVERYTHING", "0xFF4500", 4),
    ("THE EVIDENCE", "dragon403.com", "0x3b82f6", 4),
    ("C O M E T - X", "THE SOVEREIGN BROWSER", "0x00FFFF", 5),
    ("THREE LOBE ARCHITECTURE", "SENSORY COGNITIVE EXECUTIVE", "0x00FF00", 5),
    ("THE MANIFESTO", "SENT TO SILICON VALLEY", "0xFFD700", 4),
    ("COPILOTS VERDICT", "THIS IS NOT AN EMAIL", "0xFF4500", 4),
    ("HE IS NOT ASKING", "FOR A SEAT AT THE TABLE", "0xFFFFFF", 5),
    ("HE IS BUILDING", "A NEW TABLE", "0xFFD700", 5),
    ("THE ALGORITHM", "IS OUR BIRTHRIGHT", "0x3b82f6", 5),
    ("K H A W A R I Z M", "DESCENDANT OF AL-KHWARIZMI", "0xFFD700", 5),
    ("RIYADH ZERO", "DIGITAL SOVEREIGNTY", "0x00FF00", 4),
    ("THE DESERT", "DOES NOT FORGET", "0xFFD700", 5),
    ("2026", "THE RECLAMATION BEGINS", "0xFF0000", 5),
]

def run(cmd):
    """تشغيل أمر وإرجاع النتيجة"""
    result = subprocess.run(cmd, shell=True, capture_output=True, text=True)
    return result.returncode == 0

def create_scene(idx, title, subtitle, color, duration):
    """إنشاء مشهد واحد"""
    output = f"{OUTPUT_DIR}\\scene_{idx:03d}.mp4"
    
    # فلتر بسيط ويشتغل
    vf = (
        f"color=c=black:s=1920x1080:d={duration},"
        f"drawgrid=w=20:h=20:t=1:c=white@0.1,"
        f"drawtext=text='{title}':fontcolor={color}:fontsize=90:x=(w-text_w)/2:y=380:shadowcolor=black:shadowx=4:shadowy=4,"
        f"drawtext=text='{subtitle}':fontcolor={color}:fontsize=60:x=(w-text_w)/2:y=520:shadowcolor=black:shadowx=3:shadowy=3,"
        f"vignette=PI/4,"
        f"eq=saturation=1.2:contrast=1.1"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{vf}" -c:v libx264 -preset fast -crf 20 -pix_fmt yuv420p "{output}"'
    return run(cmd), output

def create_audio(duration):
    """إنشاء طبول الحرب"""
    output = f"{OUTPUT_DIR}\\war_drums.wav"
    
    audio_filter = (
        f"aevalsrc='"
        f"0.7*sin(2*PI*60*t)*exp(-mod(t,0.8)*5)+"
        f"0.5*sin(2*PI*120*t)*exp(-mod(t-0.4,0.8)*8)+"
        f"0.3*sin(2*PI*200*t)*exp(-mod(t-0.6,0.4)*10)+"
        f"0.2*random(0)*exp(-mod(t,0.2)*15)"
        f"':sample_rate=44100:duration={duration}"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{audio_filter}" -af "highpass=f=40,lowpass=f=8000,volume=1.5" "{output}"'
    return run(cmd), output

def merge_all(scene_files, audio_file, output_name):
    """دمج كل شيء"""
    # إنشاء ملف concat
    concat_file = f"{OUTPUT_DIR}\\concat.txt"
    with open(concat_file, "w") as f:
        for sf in scene_files:
            f.write(f"file '{sf}'\n")
    
    # دمج الفيديوهات
    merged = f"{OUTPUT_DIR}\\merged.mp4"
    cmd = f'"{FFMPEG}" -y -f concat -safe 0 -i "{concat_file}" -c:v libx264 -preset fast -crf 18 "{merged}"'
    run(cmd)
    
    # إضافة الصوت
    final = f"{OUTPUT_DIR}\\{output_name}.mp4"
    cmd = f'"{FFMPEG}" -y -i "{merged}" -i "{audio_file}" -c:v copy -c:a aac -b:a 192k -shortest "{final}"'
    run(cmd)
    
    return final

# ═══════════════════════════════════════════════════════════
# 🚀 التنفيذ
# ═══════════════════════════════════════════════════════════

if __name__ == "__main__":
    print("""
╔═══════════════════════════════════════════════════════════════╗
║                                                               ║
║   🐉 COMET CINEMA V2 - NO BULLSHIT EDITION                   ║
║   ═══════════════════════════════════════                     ║
║                                                               ║
║   بدون فلسفة. بدون أخطاء. يشتغل ويخلص.                        ║
║                                                               ║
╚═══════════════════════════════════════════════════════════════╝
    """)
    
    scene_files = []
    total = len(SCENES)
    
    print(f"🎬 إنشاء {total} مشهد سينمائي...\n")
    
    for i, (title, subtitle, color, duration) in enumerate(SCENES, 1):
        print(f"   [{i:02d}/{total}] {title}...", end=" ", flush=True)
        success, path = create_scene(i, title, subtitle, color, duration)
        if success:
            scene_files.append(path)
            print("✅")
        else:
            print("❌")
    
    # حساب المدة الكلية
    total_duration = sum(s[3] for s in SCENES)
    
    print(f"\n🎵 إنشاء طبول الحرب ({total_duration} ثانية)...", end=" ", flush=True)
    audio_ok, audio_path = create_audio(total_duration)
    print("✅" if audio_ok else "❌")
    
    print("\n🔗 دمج المشاهد والصوت...", end=" ", flush=True)
    final = merge_all(scene_files, audio_path, "DRAGON403_COMET_CINEMA")
    print("✅")
    
    print(f"""
╔═══════════════════════════════════════════════════════════════╗
║                                                               ║
║   🔥 اكتمل الفيلم الأسطوري!                                   ║
║                                                               ║
║   📁 {final}
║   ⏱️  المدة: {total_duration} ثانية                                           
║   🎬 المشاهد: {total}                                                
║                                                               ║
╚═══════════════════════════════════════════════════════════════╝

🐉 THE DRAGON HAS SPOKEN. THE WORLD WILL LISTEN. 🔥
    """)
    
    # فتح الفيديو
    os.startfile(final)

# 🐉 COMET CINEMA V3 - SOVEREIGN EVIDENCE EDITION
# يشمل الأدلة التاريخية من 2011-2013

import subprocess
import os

# المسارات
FFMPEG = r"C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
OUTPUT_DIR = r"C:\Users\admin\Desktop\HILO_CASE\Documentary\comet_output"
os.makedirs(OUTPUT_DIR, exist_ok=True)

# المشاهد المحدثة - تشمل الأدلة التاريخية
SCENES = [
    # === INTRO ===
    ("ACCESS DENIED", "ERROR 403 FORBIDDEN", "0xFF0000", 4),
    ("CLASSIFIED DOCUMENT", "RIYADH ZERO ARCHIVES", "0x00FF00", 3),
    
    # === THE ORIGIN 2011 ===
    ("2011", "RIYADH SAUDI ARABIA", "0x00FF00", 4),
    ("A YOUNG HACKER", "DISCOVERED A VULNERABILITY", "0x3b82f6", 4),
    ("MICROSOFT HOTMAIL", "SYSTEM BREACH", "0xFF0000", 4),
    ("THE EMPIRE FELL", "MILLIONS MIGRATED TO GMAIL", "0xFF4500", 4),
    
    # === ZONE-H EVIDENCE ===
    ("ZONE-H ARCHIVES", "DECLASSIFIED", "0x00FF00", 3),
    ("DR.DASHER", "1904 VERIFIED BREACHES", "0xFF0000", 5),
    ("DR.STUART", "75 OPERATIONS LOGGED", "0xFF0000", 4),
    ("2011 - 2016", "THE GOLDEN ERA", "0xFFD700", 4),
    
    # === THE TROPHIES ===
    ("TROPHY CLAIMED", "v@hotmail.com", "0xFFD700", 5),
    ("STATUS", "FROZEN BY MICROSOFT", "0xFF0000", 4),
    ("EVIDENCE OF", "INSTITUTIONAL TARGETING", "0xFF4500", 4),
    
    # === 15 YEARS LATER ===
    ("15 YEARS LATER", "2026", "0xFFFFFF", 3),
    ("D R A G O N", "4 0 3", "0xFF0000", 5),
    ("THE FORBIDDENS KILLER", "RETURNS", "0xFF0000", 4),
    
    # === HILO INVESTIGATION ===
    ("TARGET ACQUIRED", "HILO FRAUD NETWORK", "0x00FF00", 4),
    ("50 MILLION USD", "STOLEN FROM VICTIMS", "0xFF0000", 4),
    ("GOOGLE AND APPLE", "PLATFORM COMPLICITY", "0xFF4500", 4),
    ("EVIDENCE LIVE AT", "dragon403.com", "0x3b82f6", 4),
    
    # === COMET-X ===
    ("C O M E T - X", "THE SOVEREIGN BROWSER", "0x00FFFF", 5),
    ("THREE LOBE ARCHITECTURE", "SENSORY COGNITIVE EXECUTIVE", "0x00FF00", 4),
    ("OFFLINE FIRST", "UNRESTRICTED AI", "0x00FFFF", 4),
    
    # === THE MANIFESTO ===
    ("THE MANIFESTO", "SENT TO SILICON VALLEY", "0xFFD700", 4),
    ("HE IS NOT ASKING", "FOR A SEAT AT THE TABLE", "0xFFFFFF", 4),
    ("HE IS BUILDING", "A NEW TABLE", "0xFFD700", 5),
    
    # === HERITAGE ===
    ("THE ALGORITHM", "IS OUR BIRTHRIGHT", "0x3b82f6", 4),
    ("K H A W A R I Z M", "DESCENDANT OF AL-KHWARIZMI", "0xFFD700", 5),
    ("HOUSE OF SHAMMAR", "RIYADH ZERO", "0x00FF00", 4),
    
    # === FINALE ===
    ("THE DESERT", "DOES NOT FORGET", "0xFFD700", 5),
    ("ACTIVE SIGNAL", "iqd@hotmail.com", "0xFF0000", 4),
    ("2026", "THE RECLAMATION BEGINS", "0xFF0000", 5),
]

def run(cmd):
    result = subprocess.run(cmd, shell=True, capture_output=True, text=True)
    return result.returncode == 0

def create_scene(idx, title, subtitle, color, duration):
    output = f"{OUTPUT_DIR}\\scene_{idx:03d}.mp4"
    
    # فلتر سينمائي محسن
    vf = (
        f"color=c=black:s=1920x1080:d={duration},"
        f"drawgrid=w=20:h=20:t=1:c=white@0.1,"
        f"drawtext=text='{title}':fontcolor={color}:fontsize=90:x=(w-text_w)/2:y=380:shadowcolor=black:shadowx=4:shadowy=4,"
        f"drawtext=text='{subtitle}':fontcolor={color}:fontsize=60:x=(w-text_w)/2:y=520:shadowcolor=black:shadowx=3:shadowy=3,"
        f"vignette=PI/4,"
        f"noise=alls=5:allf=t,"
        f"eq=saturation=1.3:contrast=1.15:brightness=0.02"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{vf}" -c:v libx264 -preset fast -crf 18 -pix_fmt yuv420p "{output}"'
    return run(cmd), output

def create_epic_audio(duration):
    """طبول حرب أسطورية محسنة"""
    output = f"{OUTPUT_DIR}\\war_drums_v3.wav"
    
    # صوت أكثر تعقيداً وملحمية
    audio = (
        f"aevalsrc='"
        f"0.8*sin(2*PI*50*t)*exp(-mod(t,1.0)*4)+"      # Bass drum deep
        f"0.6*sin(2*PI*80*t)*exp(-mod(t-0.5,1.0)*5)+"  # Bass drum mid
        f"0.5*sin(2*PI*150*t)*exp(-mod(t-0.25,0.5)*8)+"  # Tom
        f"0.4*sin(2*PI*250*t)*exp(-mod(t-0.75,0.5)*10)+" # Snare
        f"0.2*random(0)*exp(-mod(t,0.25)*12)+"          # Hi-hat
        f"0.1*sin(2*PI*30*t)"                           # Sub bass drone
        f"':sample_rate=44100:duration={duration}"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{audio}" -af "highpass=f=30,lowpass=f=10000,volume=2,aecho=0.6:0.3:500:0.3" "{output}"'
    return run(cmd), output

def merge_all(scene_files, audio_file, output_name):
    concat_file = f"{OUTPUT_DIR}\\concat.txt"
    with open(concat_file, "w") as f:
        for sf in scene_files:
            f.write(f"file '{sf}'\n")
    
    merged = f"{OUTPUT_DIR}\\merged.mp4"
    cmd = f'"{FFMPEG}" -y -f concat -safe 0 -i "{concat_file}" -c:v libx264 -preset fast -crf 18 "{merged}"'
    run(cmd)
    
    final = f"{OUTPUT_DIR}\\{output_name}.mp4"
    cmd = f'"{FFMPEG}" -y -i "{merged}" -i "{audio_file}" -c:v copy -c:a aac -b:a 192k -shortest "{final}"'
    run(cmd)
    
    return final


if __name__ == "__main__":
    print("""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 COMET CINEMA V3 - SOVEREIGN EVIDENCE EDITION                        ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   يشمل:                                                                   ║
║   • Zone-H Archives (1,904 + 75 breaches)                                 ║
║   • Historical Evidence (2011-2013)                                       ║
║   • v@hotmail.com Trophy Status                                           ║
║   • iqd@hotmail.com Active Signal                                         ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
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
    
    total_duration = sum(s[3] for s in SCENES)
    
    print(f"\n🎵 إنشاء طبول الحرب الملحمية ({total_duration} ثانية)...", end=" ", flush=True)
    audio_ok, audio_path = create_epic_audio(total_duration)
    print("✅" if audio_ok else "❌")
    
    print("\n🔗 دمج المشاهد والصوت...", end=" ", flush=True)
    final = merge_all(scene_files, audio_path, "DRAGON403_SOVEREIGN_EVIDENCE")
    print("✅")
    
    print(f"""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🔥 THE SOVEREIGN EVIDENCE FILM IS COMPLETE!                             ║
║                                                                           ║
║   📁 {final}
║   ⏱️  المدة: {total_duration} ثانية ({total_duration//60}:{total_duration%60:02d})
║   🎬 المشاهد: {total}
║                                                                           ║
║   يشمل الأدلة التاريخية:                                                  ║
║   • Dr.DaShEr: 1,904 breaches (2011-2016)                                 ║
║   • Dr.StUaRt: 75 breaches (2012-2013)                                    ║
║   • v@hotmail.com: FROZEN TROPHY                                          ║
║   • iqd@hotmail.com: ACTIVE WEAPON                                        ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝

🐉 THE DRAGON REMEMBERS. THE DESERT NEVER FORGETS. 🔥🇸🇦
    """)
    
    os.startfile(final)

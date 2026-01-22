#!/usr/bin/env python3
"""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 COMET CINEMA V5 - THE STORYTELLER                                   ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   هذا الفيلم يحكي قصة واضحة لأي مشاهد جديد:                              ║
║   من هو؟ → ماذا فعل؟ → ماذا حدث؟ → ماذا اكتشف؟ → ماذا يبني؟              ║
║                                                                           ║
║   فقط الموثق. بدون هلوسة.                                                 ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
"""

import subprocess
import os

# FFmpeg path
FFMPEG = r"C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"

# Output directory
OUTPUT_DIR = r"C:\Users\admin\Desktop\HILO_CASE\Documentary\comet_output"
os.makedirs(OUTPUT_DIR, exist_ok=True)

# V5 STORYTELLING - القصة الكاملة للمشاهد الجديد
SCENES = [
    # ═══════════════════════════════════════════════════════════════
    # الفصل 1: من هو؟ (THE INTRODUCTION)
    # ═══════════════════════════════════════════════════════════════
    ("CHAPTER 1", "WHO IS HE?", 2, "white"),
    ("RIYADH - SAUDI ARABIA", "2011", 3, "cyan"),
    ("A YOUNG ENGINEER", "DISCOVERED A FATAL FLAW", 3, "cyan"),
    ("IN MICROSOFT HOTMAIL", "THE WORLD MIGRATED TO GMAIL", 3.5, "blue"),
    ("HE KEPT THE TROPHIES", "", 2.5, "gold"),
    
    # ═══════════════════════════════════════════════════════════════
    # الفصل 2: ماذا فعل؟ (THE LEGACY - موثق من Zone-H)
    # ═══════════════════════════════════════════════════════════════
    ("CHAPTER 2", "WHAT DID HE DO?", 2, "white"),
    ("ZONE-H ARCHIVES", "DOCUMENTED EVIDENCE", 3, "red"),
    ("DR.DASHER", "1904 VERIFIED BREACHES", 3.5, "red"),
    ("DR.STUART", "75 VERIFIED BREACHES", 3, "red"),
    ("PERIOD 2011 TO 2016", "FIVE YEARS OF OPERATIONS", 3, "red"),
    ("THIS IS NOT A CLAIM", "THIS IS PUBLIC RECORD", 3, "yellow"),
    
    # ═══════════════════════════════════════════════════════════════
    # الفصل 3: ماذا حدث له؟ (THE SILENCE)
    # ═══════════════════════════════════════════════════════════════
    ("CHAPTER 3", "WHAT HAPPENED TO HIM?", 2, "white"),
    ("MICROSOFT FROZE", "HIS TROPHY ACCOUNT", 3, "blue"),
    ("iqb AT hotmail.com", "STATUS - FROZEN", 3, "blue"),
    ("THEY THOUGHT", "HE WOULD DISAPPEAR", 3, "cyan"),
    ("15 YEARS OF SILENCE", "BUT THE DESERT NEVER FORGETS", 3.5, "yellow"),
    
    # ═══════════════════════════════════════════════════════════════
    # الفصل 4: ماذا اكتشف؟ (THE DISCOVERY)
    # ═══════════════════════════════════════════════════════════════
    ("CHAPTER 4", "WHAT DID HE DISCOVER?", 2, "white"),
    ("2024 - HILO APP", "A FRAUD NETWORK", 3, "red"),
    ("50 MILLION DOLLARS", "STOLEN FROM ARAB USERS", 3.5, "red"),
    ("FAKE VIDEO CALLS", "CRYPTOCURRENCY SCAMS", 3, "red"),
    ("GOOGLE PLAY APPROVED", "APPLE STORE APPROVED", 3, "yellow"),
    ("THE GIANTS KNEW", "AND DID NOTHING", 3, "yellow"),
    
    # ═══════════════════════════════════════════════════════════════
    # الفصل 5: ماذا يبني؟ (THE RESPONSE)
    # ═══════════════════════════════════════════════════════════════
    ("CHAPTER 5", "WHAT IS HE BUILDING?", 2, "white"),
    ("D R A G O N 4 0 3", "OSINT INVESTIGATION PLATFORM", 3.5, "red"),
    ("LIVE NOW AT", "dragon403.com", 3, "green"),
    ("EVIDENCE DOCUMENTED", "FRAUD EXPOSED", 3, "green"),
    ("C O M E T - X", "SOVEREIGN AI BROWSER", 3.5, "cyan"),
    ("THREE LOBE ARCHITECTURE", "SENSORY - COGNITIVE - EXECUTIVE", 3, "magenta"),
    ("OFFLINE FIRST", "NO CLOUD DEPENDENCY", 3, "green"),
    ("UNRESTRICTED AI", "LOCAL PROCESSING ONLY", 3, "green"),
    
    # ═══════════════════════════════════════════════════════════════
    # الفصل 6: ماذا يريد؟ (THE MESSAGE)
    # ═══════════════════════════════════════════════════════════════
    ("CHAPTER 6", "WHAT DOES HE WANT?", 2, "white"),
    ("HE IS NOT ASKING", "FOR PERMISSION", 3, "red"),
    ("HE IS NOT ASKING", "FOR A SEAT AT THE TABLE", 3, "red"),
    ("HE IS BUILDING", "A NEW TABLE", 3.5, "gold"),
    ("THE ALGORITHM", "IS OUR BIRTHRIGHT", 3.5, "gold"),
    
    # ═══════════════════════════════════════════════════════════════
    # الخاتمة (THE IDENTITY)
    # ═══════════════════════════════════════════════════════════════
    ("HIS NAME", "", 2, "white"),
    ("K H A W A R I Z M", "DESCENDANT OF AL-KHWARIZMI", 4, "gold"),
    ("HOUSE OF SHAMMAR", "RIYADH - SAUDI ARABIA", 3, "white"),
    ("CONTACT", "iqd AT hotmail.com", 3, "green"),
    ("THE DESERT", "NEVER FORGETS", 4, "red"),
    ("2 0 2 6", "THE RECLAMATION HAS BEGUN", 4, "red"),
]

def create_scene(text1, text2, duration, color, index, total):
    """Create a single cinematic scene"""
    output_file = os.path.join(OUTPUT_DIR, f"v5_scene_{index:03d}.mp4")
    
    colors = {
        "red": "0xFF0000",
        "green": "0x00FF00",
        "cyan": "0x00FFFF",
        "yellow": "0xFFFF00",
        "blue": "0x0066FF",
        "magenta": "0xFF00FF",
        "white": "0xFFFFFF",
        "gold": "0xFFD700"
    }
    hex_color = colors.get(color, "0xFF0000")
    
    # Escape special characters
    text1_safe = text1.replace("'", "").replace(":", " -").replace("@", " AT ")
    text2_safe = text2.replace("'", "").replace(":", " -").replace("@", " AT ")
    
    # Build filter - Chapter headers are bigger
    if "CHAPTER" in text1:
        filter_complex = (
            f"color=c=black:s=1920x1080:d={duration},"
            f"drawtext=text='{text1_safe}':fontsize=48:fontcolor=0x666666:x=(w-text_w)/2:y=(h-text_h)/2-30:font=Consolas,"
            f"drawtext=text='{text2_safe}':fontsize=64:fontcolor={hex_color}:x=(w-text_w)/2:y=(h-text_h)/2+40:font=Consolas,"
            f"fade=t=in:st=0:d=0.3,fade=t=out:st={duration-0.3}:d=0.3"
        )
    else:
        filter_complex = (
            f"color=c=black:s=1920x1080:d={duration},"
            f"drawtext=text='{text1_safe}':fontsize=72:fontcolor={hex_color}:x=(w-text_w)/2:y=(h-text_h)/2-40:font=Consolas,"
            f"drawtext=text='{text2_safe}':fontsize=48:fontcolor=white:x=(w-text_w)/2:y=(h-text_h)/2+50:font=Consolas,"
            f"drawtext=text='COMET CINEMA V5':fontsize=18:fontcolor=0x333333:x=50:y=h-40:font=Consolas,"
            f"fade=t=in:st=0:d=0.3,fade=t=out:st={duration-0.3}:d=0.3"
        )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{filter_complex}" -c:v libx264 -t {duration} -pix_fmt yuv420p "{output_file}"'
    
    result = subprocess.run(cmd, shell=True, capture_output=True)
    
    status = "✅" if result.returncode == 0 else "❌"
    print(f"   [{index:02d}/{total}] {text1_safe[:30]}... {status}")
    
    return output_file if result.returncode == 0 else None

def create_epic_audio(duration, output_file):
    """Create epic war drums audio"""
    audio_filter = (
        f"sine=f=55:d={duration},tremolo=f=3:d=0.7,"
        f"volume=0.5[bass];"
        f"sine=f=110:d={duration},tremolo=f=6:d=0.5,"
        f"volume=0.35[mid];"
        f"anoisesrc=d={duration}:c=brown,volume=0.1[noise];"
        f"sine=f=35:d={duration},tremolo=f=1.5:d=0.8,"
        f"volume=0.4[subbass];"
        f"[bass][mid][noise][subbass]amix=inputs=4:normalize=0,"
        f"afade=t=in:st=0:d=3,afade=t=out:st={duration-4}:d=4"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{audio_filter}" -c:a aac -b:a 192k "{output_file}"'
    result = subprocess.run(cmd, shell=True, capture_output=True)
    return result.returncode == 0

def main():
    print("""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 COMET CINEMA V5 - THE STORYTELLER                                   ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   قصة واضحة لأي مشاهد جديد:                                               ║
║   ────────────────────────────────────────────                            ║
║   الفصل 1: من هو؟                                                         ║
║   الفصل 2: ماذا فعل؟ (Zone-H موثق)                                        ║
║   الفصل 3: ماذا حدث له؟                                                   ║
║   الفصل 4: ماذا اكتشف؟ (HILO)                                             ║
║   الفصل 5: ماذا يبني؟ (Dragon + Comet)                                    ║
║   الفصل 6: ماذا يريد؟ (الرسالة)                                           ║
║                                                                           ║
║   فقط الموثق. بدون هلوسة.                                                 ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
""")
    
    total_duration = sum(scene[2] for scene in SCENES)
    total_scenes = len(SCENES)
    
    print(f"🎬 إنشاء {total_scenes} مشهد سينمائي...\n")
    
    # Create scenes
    scene_files = []
    for i, (text1, text2, duration, color) in enumerate(SCENES, 1):
        scene_file = create_scene(text1, text2, duration, color, i, total_scenes)
        if scene_file:
            scene_files.append(scene_file)
    
    print(f"\n🎵 إنشاء طبول الحرب الملحمية ({int(total_duration)} ثانية)...", end=" ")
    audio_file = os.path.join(OUTPUT_DIR, "v5_war_drums.aac")
    if create_epic_audio(total_duration, audio_file):
        print("✅")
    else:
        print("❌")
    
    # Concat file
    concat_file = os.path.join(OUTPUT_DIR, "v5_concat.txt")
    with open(concat_file, "w") as f:
        for scene in scene_files:
            f.write(f"file '{scene}'\n")
    
    # Merge
    print("\n🔗 دمج المشاهد والصوت...", end=" ")
    merged_video = os.path.join(OUTPUT_DIR, "v5_merged.mp4")
    final_output = os.path.join(OUTPUT_DIR, "DRAGON403_THE_STORY.mp4")
    
    cmd1 = f'"{FFMPEG}" -y -f concat -safe 0 -i "{concat_file}" -c copy "{merged_video}"'
    subprocess.run(cmd1, shell=True, capture_output=True)
    
    cmd2 = f'"{FFMPEG}" -y -i "{merged_video}" -i "{audio_file}" -c:v copy -c:a aac -shortest "{final_output}"'
    result = subprocess.run(cmd2, shell=True, capture_output=True)
    
    print("✅" if result.returncode == 0 else "❌")
    
    minutes = int(total_duration // 60)
    seconds = int(total_duration % 60)
    
    print(f"""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🔥 THE STORYTELLER FILM IS COMPLETE!                                    ║
║                                                                           ║
║   📁 {final_output}
║   ⏱️  المدة: {int(total_duration)} ثانية ({minutes}:{seconds:02d})
║   🎬 المشاهد: {total_scenes}
║   📖 الفصول: 6
║                                                                           ║
║   ═══════════════════════════════════════════════                         ║
║   الآن أي شخص يشاهد الفيلم سيفهم:                                         ║
║   ✅ من هو KHAWRIZM                                                       ║
║   ✅ تاريخه الموثق (Zone-H)                                               ║
║   ✅ ماذا اكتشف (HILO Fraud)                                              ║
║   ✅ ماذا يبني (Dragon403 + Comet-X)                                      ║
║   ✅ ماذا يريد (Digital Sovereignty)                                      ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝

🐉 THE STORY IS NOW TOLD. THE WORLD WILL UNDERSTAND. 🔥🇸🇦
""")

if __name__ == "__main__":
    main()

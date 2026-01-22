#!/usr/bin/env python3
"""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 COMET CINEMA V4 - FORENSIC ARCHIVE EDITION                          ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   يشمل Gmail Archive Evidence (2011-2012):                                ║
║   • 7rs.org - حرس الحدود للاختراق الهادف (22 يونيو 2011)                   ║
║   • hotm-il.net - هوتميل الخليج (29 سبتمبر 2012)                          ║
║   • Zone-H Archives (1,904 + 75 breaches)                                 ║
║   • iqb@hotmail.com FROZEN / iqd@hotmail.com ACTIVE                       ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
"""

import subprocess
import os
import math

# FFmpeg path
FFMPEG = r"C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"

# Output directory
OUTPUT_DIR = r"C:\Users\admin\Desktop\HILO_CASE\Documentary\comet_output"
os.makedirs(OUTPUT_DIR, exist_ok=True)

# V4 Enhanced Scenes - 38 scenes with Gmail Archive Evidence
SCENES = [
    # === INTRO ===
    ("ACCESS DENIED", "403", 2.5, "red"),
    ("CLASSIFIED DOCUMENT", "LEVEL SOVEREIGN", 2.5, "red"),
    
    # === GMAIL ARCHIVE EVIDENCE (NEW!) ===
    ("G M A I L   A R C H I V E", "FORENSIC RECOVERY 2011-2012", 3, "cyan"),
    ("22 JUNE 2011", "POINT ZERO", 2.5, "green"),
    ("7 R S . O R G", "HARAS AL-HUDOOD", 3, "green"),
    ("PASSWORD RESET", "OPERATOR Dr.StUaRt", 2.5, "green"),
    ("29 SEPTEMBER 2012", "LEGACY CONFIRMED", 2.5, "yellow"),
    ("H O T M - I L . N E T", "HOTMAIL AL-KHALEEJ", 3, "yellow"),
    ("WE MISS YOU", "INSTITUTIONAL RECOGNITION", 2.5, "yellow"),
    ("Dr.StUaRt", "IRC ELITE TAG", 2.5, "magenta"),
    
    # === ZONE-H ARCHIVES ===
    ("Z O N E - H", "DEFACEMENT ARCHIVES", 3, "red"),
    ("D R . D A S H E R", "1904 BREACHES", 3.5, "red"),
    ("136 SINGLE IP", "1768 MASS DEFACEMENTS", 2.5, "red"),
    ("D R . S T U A R T", "75 BREACHES", 3, "cyan"),
    ("39 SINGLE IP", "36 MASS DEFACEMENTS", 2.5, "cyan"),
    ("THE TEAM", "Nex HaCkEr - Nakos - Mr.aBu HaLiL", 3, "yellow"),
    ("2011 - 2016", "FIVE YEARS OF WAR", 3, "red"),
    
    # === HOTMAIL TROPHIES ===
    ("M I C R O S O F T", "HOTMAIL LEGACY", 3, "blue"),
    ("I Q B AT HOTMAIL", "STATUS FROZEN TROPHY", 3, "blue"),
    ("I Q D AT HOTMAIL", "STATUS ACTIVE WEAPON", 3, "green"),
    ("EVIDENCE OF EMPIRE", "THE ACCOUNTS REMAIN", 2.5, "cyan"),
    
    # === 15 YEARS LATER ===
    ("15 YEARS LATER", "2011 TO 2026", 3, "white"),
    ("THE HACKER", "BECAME THE ARCHITECT", 2.5, "cyan"),
    
    # === DRAGON 403 ===
    ("D R A G O N", "4 0 3", 3.5, "red"),
    ("THE FORBIDDENS KILLER", "OSINT PLATFORM", 2.5, "red"),
    ("TARGET ACQUIRED", "HILO APP FRAUD DETECTED", 3, "yellow"),
    ("50 MILLION USD", "STOLEN FROM ARAB USERS", 3, "red"),
    ("EVIDENCE LIVE AT", "dragon403.com", 3, "green"),
    
    # === COMET-X ===
    ("C O M E T - X", "SOVEREIGN BROWSER", 3.5, "cyan"),
    ("THREE LOBE", "ARCHITECTURE", 2.5, "magenta"),
    ("SENSORY - COGNITIVE", "EXECUTIVE", 2.5, "magenta"),
    ("OFFLINE FIRST", "NO CLOUD DEPENDENCY", 2.5, "green"),
    
    # === THE MANIFESTO ===
    ("THE MANIFESTO", "DIGITAL SOVEREIGNTY", 3, "yellow"),
    ("HE IS NOT ASKING", "FOR PERMISSION", 2.5, "red"),
    ("HE IS BUILDING", "THE ALTERNATIVE", 2.5, "green"),
    
    # === FINALE ===
    ("K H A W A R I Z M", "KHAWARIZM", 4, "gold"),
    ("HOUSE OF SHAMMAR", "RIYADH SAUDI ARABIA", 3, "white"),
    ("THE DESERT", "NEVER FORGETS", 3, "red"),
    ("2 0 2 6", "THE DRAGON RISES", 4, "red"),
]

def create_scene(text1, text2, duration, color, index, total):
    """Create a single cinematic scene with FFmpeg"""
    
    output_file = os.path.join(OUTPUT_DIR, f"scene_{index:03d}.mp4")
    
    # Color mapping
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
    
    # Build FFmpeg filter
    filter_complex = (
        f"color=c=black:s=1920x1080:d={duration},"
        f"drawtext=text='{text1}':fontsize=72:fontcolor={hex_color}:x=(w-text_w)/2:y=(h-text_h)/2-50:font=Consolas,"
        f"drawtext=text='{text2}':fontsize=48:fontcolor=white:x=(w-text_w)/2:y=(h-text_h)/2+50:font=Consolas,"
        f"drawtext=text='COMET CINEMA V4':fontsize=20:fontcolor=0x333333:x=50:y=h-50:font=Consolas,"
        f"fade=t=in:st=0:d=0.3,fade=t=out:st={duration-0.3}:d=0.3"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{filter_complex}" -c:v libx264 -t {duration} -pix_fmt yuv420p "{output_file}"'
    
    result = subprocess.run(cmd, shell=True, capture_output=True)
    
    if result.returncode == 0:
        print(f"   [{index:02d}/{total}] {text1}... ✅")
        return output_file
    else:
        print(f"   [{index:02d}/{total}] {text1}... ❌")
        return None

def create_war_drums(duration, output_file):
    """Create epic war drums audio"""
    
    # Enhanced war drums formula
    audio_filter = (
        f"sine=f=60:d={duration},tremolo=f=4:d=0.7,"
        f"volume=0.6[bass];"
        f"sine=f=120:d={duration},tremolo=f=8:d=0.5,"
        f"volume=0.4[mid];"
        f"anoisesrc=d={duration}:c=brown,volume=0.15[noise];"
        f"sine=f=40:d={duration},tremolo=f=2:d=0.8,"
        f"volume=0.5[subbass];"
        f"[bass][mid][noise][subbass]amix=inputs=4:normalize=0,"
        f"afade=t=in:st=0:d=2,afade=t=out:st={duration-3}:d=3"
    )
    
    cmd = f'"{FFMPEG}" -y -f lavfi -i "{audio_filter}" -c:a aac -b:a 192k "{output_file}"'
    
    result = subprocess.run(cmd, shell=True, capture_output=True)
    return result.returncode == 0

def main():
    print("""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 COMET CINEMA V4 - FORENSIC ARCHIVE EDITION                          ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   NEW! Gmail Archive Evidence (2011-2012):                                ║
║   • 7rs.org - حرس الحدود (22 June 2011)                                   ║
║   • hotm-il.net - هوتميل الخليج (29 Sept 2012)                            ║
║   • Zone-H Archives (1,904 + 75 breaches)                                 ║
║   • iqb@hotmail.com FROZEN / iqd@hotmail.com ACTIVE                       ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
""")
    
    # Calculate total duration
    total_duration = sum(scene[2] for scene in SCENES)
    total_scenes = len(SCENES)
    
    print(f"🎬 إنشاء {total_scenes} مشهد سينمائي...\n")
    
    # Create all scenes
    scene_files = []
    for i, (text1, text2, duration, color) in enumerate(SCENES, 1):
        scene_file = create_scene(text1, text2, duration, color, i, total_scenes)
        if scene_file:
            scene_files.append(scene_file)
    
    print(f"\n🎵 إنشاء طبول الحرب الملحمية ({int(total_duration)} ثانية)...", end=" ")
    audio_file = os.path.join(OUTPUT_DIR, "war_drums_v4.aac")
    if create_war_drums(total_duration, audio_file):
        print("✅")
    else:
        print("❌")
    
    # Create concat file
    concat_file = os.path.join(OUTPUT_DIR, "concat_v4.txt")
    with open(concat_file, "w") as f:
        for scene in scene_files:
            f.write(f"file '{scene}'\n")
    
    # Merge all scenes
    print("\n🔗 دمج المشاهد والصوت...", end=" ")
    merged_video = os.path.join(OUTPUT_DIR, "merged_v4.mp4")
    final_output = os.path.join(OUTPUT_DIR, "DRAGON403_FORENSIC_ARCHIVE.mp4")
    
    # Concat videos
    cmd1 = f'"{FFMPEG}" -y -f concat -safe 0 -i "{concat_file}" -c copy "{merged_video}"'
    subprocess.run(cmd1, shell=True, capture_output=True)
    
    # Add audio
    cmd2 = f'"{FFMPEG}" -y -i "{merged_video}" -i "{audio_file}" -c:v copy -c:a aac -shortest "{final_output}"'
    result = subprocess.run(cmd2, shell=True, capture_output=True)
    
    if result.returncode == 0:
        print("✅")
    else:
        print("❌")
    
    # Final summary
    minutes = int(total_duration // 60)
    seconds = int(total_duration % 60)
    
    print(f"""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🔥 THE FORENSIC ARCHIVE FILM IS COMPLETE!                               ║
║                                                                           ║
║   📁 {final_output}
║   ⏱️  المدة: {int(total_duration)} ثانية ({minutes}:{seconds:02d})
║   🎬 المشاهد: {total_scenes}
║                                                                           ║
║   ═══════════════════════════════════════════════                         ║
║   📧 GMAIL ARCHIVE EVIDENCE:                                              ║
║   • 7rs.org (22 June 2011) - حرس الحدود                                   ║
║   • hotm-il.net (29 Sept 2012) - هوتميل الخليج                            ║
║                                                                           ║
║   🌐 ZONE-H ARCHIVES:                                                     ║
║   • Dr.DaShEr: 1,904 breaches (2011-2016)                                 ║
║   • Dr.StUaRt: 75 breaches (2012-2013)                                    ║
║                                                                           ║
║   📬 HOTMAIL TROPHIES:                                                    ║
║   • iqb@hotmail.com: FROZEN TROPHY                                        ║
║   • iqd@hotmail.com: ACTIVE WEAPON                                        ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝

🐉 WAR SCARS DOCUMENTED. SOVEREIGNTY PROVEN. 🔥🇸🇦
""")

if __name__ == "__main__":
    main()

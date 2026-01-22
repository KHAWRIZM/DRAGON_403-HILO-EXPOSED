"""
🎬 DRAGON403 CINEMA MERGER
Merge Grok AI video clips with crossfade transitions and epic music
"""

import os
import sys

# Check dependencies
try:
    from moviepy.editor import *
    from moviepy.video.fx.all import fadein, fadeout
except ImportError:
    print("❌ Installing moviepy...")
    os.system("pip install moviepy")
    from moviepy.editor import *
    from moviepy.video.fx.all import fadein, fadeout

# Video clips path
DOCS_PATH = r"C:\Users\admin\Documents"
OUTPUT_PATH = r"C:\Users\admin\Desktop\HILO_CASE\Documentary"

# Grok clips in cinematic order
CLIPS = [
    "zeroriyadh.mp4",                                    # Opening - Riyadh Zero
    "greensomali.mp4",                                   # Green theme
    "zeroriyadhiptochina.mp4",                          # IP to China reveal
    "high-endrenderagora.mp4",                          # Agora infrastructure
    "valutdragondetected.mp4",                          # Dragon vault detected
    "flickeringnode nGuangdong,.mp4",                   # Guangdong node
    "grok-video-99683089-e572-4666-a1fe-eac646e72532.mp4",  # Additional
    "packetsintercepted49nopeopleonlyhightech.mp4",    # 49 packets intercepted
    "statustrafficblockedbiaipi.mp4",                  # Traffic blocked
    "riyadhzerotokenfound.mp4",                        # FINALE - Token found!
]

def merge_with_crossfade(clips_list, crossfade_duration=0.5):
    """Merge clips with crossfade transitions"""
    print("🎬 DRAGON403 Cinema Merger")
    print("=" * 50)
    
    loaded_clips = []
    
    for i, clip_name in enumerate(clips_list):
        clip_path = os.path.join(DOCS_PATH, clip_name)
        if os.path.exists(clip_path):
            print(f"📹 Loading [{i+1}/{len(clips_list)}]: {clip_name}")
            clip = VideoFileClip(clip_path)
            
            # Add fade in/out for smooth transitions
            clip = clip.fx(fadein, crossfade_duration)
            clip = clip.fx(fadeout, crossfade_duration)
            
            loaded_clips.append(clip)
        else:
            print(f"⚠️  Not found: {clip_name}")
    
    if not loaded_clips:
        print("❌ No clips loaded!")
        return None
    
    print(f"\n🔗 Concatenating {len(loaded_clips)} clips with crossfade...")
    
    # Method 1: Simple concatenate with crossfade
    final = concatenate_videoclips(loaded_clips, method="compose")
    
    return final

def add_background_music(video, music_path=None, volume=0.3):
    """Add epic background music"""
    if music_path and os.path.exists(music_path):
        print(f"🎵 Adding music: {music_path}")
        audio = AudioFileClip(music_path)
        
        # Loop music if shorter than video
        if audio.duration < video.duration:
            audio = audio.fx(afx.audio_loop, duration=video.duration)
        else:
            audio = audio.subclip(0, video.duration)
        
        # Reduce volume
        audio = audio.volumex(volume)
        
        # Mix with original audio
        if video.audio:
            final_audio = CompositeAudioClip([video.audio, audio])
        else:
            final_audio = audio
        
        return video.set_audio(final_audio)
    
    return video

def main():
    print("\n" + "="*60)
    print("🐉 DRAGON403 - GROK CINEMA MERGER")
    print("="*60 + "\n")
    
    # Merge clips
    final_video = merge_with_crossfade(CLIPS, crossfade_duration=0.8)
    
    if final_video:
        # Check for music in Documentary/music folder
        music_folder = os.path.join(OUTPUT_PATH, "music")
        music_file = None
        
        if os.path.exists(music_folder):
            for f in os.listdir(music_folder):
                if f.endswith(('.mp3', '.wav', '.m4a')):
                    music_file = os.path.join(music_folder, f)
                    break
        
        if music_file:
            final_video = add_background_music(final_video, music_file, volume=0.25)
        else:
            print("💡 No music found in Documentary/music/ - exporting without BGM")
        
        # Export
        output_file = os.path.join(OUTPUT_PATH, "DRAGON403_GROK_CINEMA.mp4")
        print(f"\n📤 Exporting to: {output_file}")
        print("⏳ This may take a few minutes...")
        
        final_video.write_videofile(
            output_file,
            fps=30,
            codec='libx264',
            audio_codec='aac',
            preset='medium',
            threads=4
        )
        
        print(f"\n✅ SUCCESS! Output: {output_file}")
        print(f"📊 Duration: {final_video.duration:.1f} seconds")
        
        # Cleanup
        final_video.close()
        
    else:
        print("❌ Failed to create video")

if __name__ == "__main__":
    main()

# ═══════════════════════════════════════════════════════════
# 🐉 DRAGON 403 - THE LEGENDARY DOCUMENTARY V2
# 🦅 RIYADH ZERO | KHAWRIZM | FORBIDDEN'S KILLER
# ═══════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"

# Colors
$RED = "Red"
$GREEN = "Green"
$CYAN = "Cyan"
$YELLOW = "Yellow"

Write-Host "`n╔═══════════════════════════════════════════════════════════╗" -ForegroundColor $CYAN
Write-Host "║  🐉 DRAGON 403 - LEGENDARY FILM GENERATOR V2               ║" -ForegroundColor $YELLOW
Write-Host "╚═══════════════════════════════════════════════════════════╝`n" -ForegroundColor $CYAN

# Setup
$docDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$framesDir = "$docDir\frames_legendary"
$audioDir = "$docDir\audio"
$finalVideo = "$docDir\DRAGON403_LEGENDARY.mp4"

New-Item -ItemType Directory -Path $framesDir -Force | Out-Null
New-Item -ItemType Directory -Path $audioDir -Force | Out-Null

# FFmpeg path
$FFmpeg = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"

if (-not (Test-Path $FFmpeg)) {
    Write-Host "❌ FFmpeg not found at: $FFmpeg" -ForegroundColor $RED
    return
}

Write-Host "✅ FFmpeg ready" -ForegroundColor $GREEN

# ═══════════════════════════════════════════════════════════
# 🎬 SCENES - THE LEGENDARY STORY
# ═══════════════════════════════════════════════════════════

$scenes = @(
    @{ line1 = "ACCESS DENIED"; line2 = "ERROR 403 FORBIDDEN"; color = "0xFF0000"; bg = "0x000000"; duration = 3 },
    @{ line1 = "2011"; line2 = "RIYADH SAUDI ARABIA"; color = "0x00FF00"; bg = "0x000000"; duration = 3 },
    @{ line1 = "A YOUNG HACKER"; line2 = "DISCOVERED A VULNERABILITY"; color = "0x3b82f6"; bg = "0x000000"; duration = 4 },
    @{ line1 = "MICROSOFT HOTMAIL"; line2 = "SYSTEM BREACH"; color = "0xFF0000"; bg = "0x000000"; duration = 3 },
    @{ line1 = "THE EMPIRE FELL"; line2 = "THE MIGRATION BEGAN"; color = "0xFF4500"; bg = "0x000000"; duration = 4 },
    @{ line1 = "TROPHY CLAIMED"; line2 = "v@hotmail.com"; color = "0xFFD700"; bg = "0x000000"; duration = 4 },
    @{ line1 = "15 YEARS LATER"; line2 = "..."; color = "0xFFFFFF"; bg = "0x000000"; duration = 3 },
    @{ line1 = "D R A G O N"; line2 = "4 0 3"; color = "0xFF0000"; bg = "0x000000"; duration = 4 },
    @{ line1 = "THE FORBIDDENS KILLER"; line2 = "RETURNS"; color = "0xFF0000"; bg = "0x000000"; duration = 4 },
    @{ line1 = "TARGET IDENTIFIED"; line2 = "HILO FRAUD NETWORK"; color = "0x00FF00"; bg = "0x000000"; duration = 4 },
    @{ line1 = "50 MILLION USD"; line2 = "STOLEN FROM VICTIMS"; color = "0xFF0000"; bg = "0x000000"; duration = 4 },
    @{ line1 = "GOOGLE AND APPLE"; line2 = "KNEW EVERYTHING"; color = "0xFF4500"; bg = "0x000000"; duration = 4 },
    @{ line1 = "THE EVIDENCE"; line2 = "dragon403.com"; color = "0x3b82f6"; bg = "0x000000"; duration = 4 },
    @{ line1 = "C O M E T - X"; line2 = "THE SOVEREIGN BROWSER"; color = "0x3b82f6"; bg = "0x000000"; duration = 4 },
    @{ line1 = "THREE-LOBE ARCHITECTURE"; line2 = "UNCENSORED UNBOUND LOCAL"; color = "0x00FF00"; bg = "0x000000"; duration = 5 },
    @{ line1 = "THE MANIFESTO"; line2 = "SENT TO SILICON VALLEY"; color = "0xFFD700"; bg = "0x000000"; duration = 4 },
    @{ line1 = "COPILOTS VERDICT"; line2 = "THIS IS NOT AN EMAIL"; color = "0xFF4500"; bg = "0x000000"; duration = 4 },
    @{ line1 = "HE IS NOT ASKING"; line2 = "FOR A SEAT AT THE TABLE"; color = "0xFFFFFF"; bg = "0x000000"; duration = 5 },
    @{ line1 = "HE IS BUILDING"; line2 = "A NEW TABLE"; color = "0xFFD700"; bg = "0x000000"; duration = 5 },
    @{ line1 = "THE ALGORITHM"; line2 = "IS OUR BIRTHRIGHT"; color = "0x3b82f6"; bg = "0x000000"; duration = 4 },
    @{ line1 = "K H A W A R I Z M"; line2 = "AL-KHWARIZMIS DESCENDANT"; color = "0xFFD700"; bg = "0x000000"; duration = 5 },
    @{ line1 = "RIYADH ZERO"; line2 = "DIGITAL SOVEREIGNTY"; color = "0x00FF00"; bg = "0x000000"; duration = 4 },
    @{ line1 = "IQD@HOTMAIL.COM"; line2 = "THE WARRIORS EMAIL"; color = "0xFF0000"; bg = "0x000000"; duration = 4 },
    @{ line1 = "THE DESERT"; line2 = "DOES NOT FORGET"; color = "0xFFD700"; bg = "0x000000"; duration = 5 },
    @{ line1 = "2026"; line2 = "THE RECLAMATION BEGINS"; color = "0xFF0000"; bg = "0x000000"; duration = 5 }
)

Write-Host "🎬 Creating $($scenes.Count) cinematic scenes..." -ForegroundColor $CYAN

# ═══════════════════════════════════════════════════════════
# 🎨 GENERATE FRAMES - RELIABLE METHOD
# ═══════════════════════════════════════════════════════════

$frameNum = 0
foreach ($scene in $scenes) {
    $frameNum++
    $framePath = "$framesDir\frame_$($frameNum.ToString('000')).png"
    
    Write-Host "  Scene $frameNum/$($scenes.Count): $($scene.line1)..." -ForegroundColor $YELLOW -NoNewline
    
    # Build filter - simple and reliable
    $filter = "color=c=$($scene.bg):s=1920x1080:d=1"
    $filter += ",drawgrid=w=20:h=20:t=1:c=white@0.1"
    $filter += ",drawtext=text='$($scene.line1)':fontcolor=$($scene.color):fontsize=90:x=(w-text_w)/2:y=380:shadowcolor=black:shadowx=4:shadowy=4"
    $filter += ",drawtext=text='$($scene.line2)':fontcolor=$($scene.color):fontsize=90:x=(w-text_w)/2:y=520:shadowcolor=black:shadowx=4:shadowy=4"
    
    # Run FFmpeg
    & $FFmpeg -y -f lavfi -i $filter -frames:v 1 -q:v 1 $framePath 2>&1 | Out-Null
    
    if (Test-Path $framePath) {
        Write-Host " ✅" -ForegroundColor $GREEN
    }
    else {
        Write-Host " ❌" -ForegroundColor $RED
    }
}

# Verify frames
$frameCount = (Get-ChildItem "$framesDir\*.png" -ErrorAction SilentlyContinue).Count
Write-Host "`n✅ Generated $frameCount frames" -ForegroundColor $GREEN

# ═══════════════════════════════════════════════════════════
# 🎵 GENERATE EPIC WAR DRUMS AUDIO
# ═══════════════════════════════════════════════════════════

Write-Host "`n🎵 Generating epic war drums..." -ForegroundColor $CYAN

$audioPath = "$audioDir\war_drums_epic.wav"
$totalDuration = ($scenes | Measure-Object -Property duration -Sum).Sum

# War drums using sine wave synthesis
$audioFilter = "aevalsrc='0.7*sin(2*PI*60*t)*exp(-mod(t,0.8)*5)+0.5*sin(2*PI*120*t)*exp(-mod(t-0.4,0.8)*8)+0.3*sin(2*PI*200*t)*exp(-mod(t-0.6,0.4)*10)+0.15*random(0)':sample_rate=44100:duration=$totalDuration"

& $FFmpeg -y -f lavfi -i $audioFilter -af "highpass=f=40,lowpass=f=8000,volume=1.5" $audioPath 2>&1 | Out-Null

if (Test-Path $audioPath) {
    Write-Host "✅ War drums audio generated! ($totalDuration seconds)" -ForegroundColor $GREEN
}
else {
    Write-Host "⚠️ Creating backup audio..." -ForegroundColor $YELLOW
    & $FFmpeg -y -f lavfi -i "sine=frequency=80:duration=$totalDuration" $audioPath 2>&1 | Out-Null
}

# ═══════════════════════════════════════════════════════════
# 🎬 COMBINE ALL FRAMES + AUDIO INTO FINAL VIDEO
# ═══════════════════════════════════════════════════════════

Write-Host "`n🎬 Creating final legendary video..." -ForegroundColor $CYAN

# Create concat file with proper format
$concatFile = "$docDir\concat_legendary.txt"
$content = @()
for ($i = 1; $i -le $scenes.Count; $i++) {
    $duration = $scenes[$i - 1].duration
    $content += "file 'frames_legendary/frame_$($i.ToString('000')).png'"
    $content += "duration $duration"
}
# Add last frame again for proper concat
$content += "file 'frames_legendary/frame_$($scenes.Count.ToString('000')).png'"
$content -join "`n" | Out-File -FilePath $concatFile -Encoding ASCII -NoNewline

Write-Host "  📝 Concat file created" -ForegroundColor $CYAN

# Final encoding
Push-Location $docDir
& $FFmpeg -y -f concat -safe 0 -i "concat_legendary.txt" -i "audio\war_drums_epic.wav" -c:v libx264 -preset medium -crf 20 -c:a aac -b:a 192k -pix_fmt yuv420p -shortest "DRAGON403_LEGENDARY.mp4" 2>&1 | Out-Null
Pop-Location

# ═══════════════════════════════════════════════════════════
# 🎉 FINAL OUTPUT
# ═══════════════════════════════════════════════════════════

if (Test-Path $finalVideo) {
    $fileInfo = Get-Item $finalVideo
    $sizeMB = [math]::Round($fileInfo.Length / 1MB, 2)
    
    Write-Host "`n╔═══════════════════════════════════════════════════════════╗" -ForegroundColor $GREEN
    Write-Host "║  🔥 LEGENDARY FILM COMPLETE!                               ║" -ForegroundColor $GREEN
    Write-Host "╠═══════════════════════════════════════════════════════════╣" -ForegroundColor $GREEN
    Write-Host "║  📁 File: DRAGON403_LEGENDARY.mp4                          ║" -ForegroundColor White
    Write-Host "║  📊 Size: $sizeMB MB                                       " -ForegroundColor White
    Write-Host "║  ⏱️  Duration: $totalDuration seconds                       " -ForegroundColor White
    Write-Host "║  🎬 Scenes: $($scenes.Count)                                " -ForegroundColor White
    Write-Host "║  🎵 Audio: War Drums (Synthesized)                         ║" -ForegroundColor White
    Write-Host "╚═══════════════════════════════════════════════════════════╝" -ForegroundColor $GREEN
    
    Write-Host "`n🚀 Opening legendary film..." -ForegroundColor $CYAN
    Start-Process $finalVideo
    
    Write-Host "`n🐉 THE DRAGON HAS SPOKEN. THE WORLD WILL LISTEN. 🔥" -ForegroundColor $RED
}
else {
    Write-Host "`n❌ Final video not created" -ForegroundColor $RED
    Write-Host "   Checking concat file..." -ForegroundColor $YELLOW
    Get-Content $concatFile | Select-Object -First 10
}

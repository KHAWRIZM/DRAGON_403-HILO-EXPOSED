# ═══════════════════════════════════════════════════════════
# 🐉 DRAGON 403 - THE LEGENDARY DOCUMENTARY
# 🦅 RIYADH ZERO | KHAWRIZM | FORBIDDEN'S KILLER
# ═══════════════════════════════════════════════════════════

$ErrorActionPreference = "Stop"

# Colors
$RED = "Red"
$GREEN = "Green"
$CYAN = "Cyan"
$YELLOW = "Yellow"

function Write-Header($text) {
    Write-Host "`n╔═══════════════════════════════════════════════════════════╗" -ForegroundColor $CYAN
    Write-Host "║  $text" -ForegroundColor $YELLOW
    Write-Host "╚═══════════════════════════════════════════════════════════╝`n" -ForegroundColor $CYAN
}

Write-Header "🐉 DRAGON 403 - LEGENDARY FILM GENERATOR"

# Setup
$docDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$framesDir = "$docDir\frames_legendary"
$audioDir = "$docDir\audio"
$finalVideo = "$docDir\DRAGON403_LEGENDARY.mp4"

New-Item -ItemType Directory -Path $framesDir -Force | Out-Null
New-Item -ItemType Directory -Path $audioDir -Force | Out-Null

# Check FFmpeg
$ffmpeg = (Get-Command ffmpeg -ErrorAction SilentlyContinue).Source
if (!$ffmpeg) {
    $ffmpegPath = Get-ChildItem "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages" -Recurse -Filter "ffmpeg.exe" -ErrorAction SilentlyContinue | Select-Object -First 1
    if ($ffmpegPath) {
        $ffmpeg = $ffmpegPath.FullName
        $env:Path += ";$(Split-Path $ffmpeg)"
    } else {
        Write-Host "❌ FFmpeg not found!" -ForegroundColor $RED
        return
    }
}

Write-Host "✅ FFmpeg: $ffmpeg" -ForegroundColor $GREEN

# ═══════════════════════════════════════════════════════════
# 🔤 FONT PATH - WINDOWS PATCH
# ═══════════════════════════════════════════════════════════
# FFmpeg on Windows requires escaped path format for fonts
$fontPath = "C\\:/Windows/Fonts/ariblk.ttf"

# Fallback to Arial if Arial Black not found
if (-not (Test-Path "C:\Windows\Fonts\ariblk.ttf")) {
    $fontPath = "C\\:/Windows/Fonts/arial.ttf"
    Write-Host "⚠️ Arial Black not found, using Arial" -ForegroundColor $YELLOW
} else {
    Write-Host "✅ Font: Arial Black" -ForegroundColor $GREEN
}

# ═══════════════════════════════════════════════════════════
# 🎬 SCENES - THE LEGENDARY STORY
# ═══════════════════════════════════════════════════════════

$scenes = @(
    @{
        text = "ACCESS DENIED`nERROR 403: FORBIDDEN"
        color = "#FF0000"
        bg = "#000000"
        duration = 3
        effect = "glitch_heavy"
    },
    @{
        text = "2011`nRIYADH, SAUDI ARABIA"
        color = "#00FF00"
        bg = "#000000"
        duration = 3
        effect = "matrix"
    },
    @{
        text = "A YOUNG HACKER`nDISCOVERED A VULNERABILITY"
        color = "#3b82f6"
        bg = "#000000"
        duration = 4
        effect = "scan"
    },
    @{
        text = "MICROSOFT HOTMAIL`nSYSTEM BREACH"
        color = "#FF0000"
        bg = "#000000"
        duration = 3
        effect = "glitch_heavy"
    },
    @{
        text = "THE EMPIRE FELL`nTHE MIGRATION BEGAN"
        color = "#FF4500"
        bg = "#000000"
        duration = 4
        effect = "burn"
    },
    @{
        text = "TROPHY CLAIMED:`nv@hotmail.com"
        color = "#FFD700"
        bg = "#000000"
        duration = 4
        effect = "gold"
    },
    @{
        text = "15 YEARS LATER..."
        color = "#FFFFFF"
        bg = "#000000"
        duration = 3
        effect = "fade"
    },
    @{
        text = "D R A G O N`n4 0 3"
        color = "#FF0000"
        bg = "#000000"
        duration = 4
        effect = "dragon"
    },
    @{
        text = "THE FORBIDDEN'S KILLER`nRETURNS"
        color = "#FF0000"
        bg = "#000000"
        duration = 4
        effect = "glitch_heavy"
    },
    @{
        text = "TARGET IDENTIFIED:`nHILO FRAUD NETWORK"
        color = "#00FF00"
        bg = "#000000"
        duration = 4
        effect = "target"
    },
    @{
        text = "50,000,000 USD`nSTOLEN FROM VICTIMS"
        color = "#FF0000"
        bg = "#000000"
        duration = 4
        effect = "money"
    },
    @{
        text = "GOOGLE AND APPLE`nKNEW EVERYTHING"
        color = "#FF4500"
        bg = "#000000"
        duration = 4
        effect = "corporate"
    },
    @{
        text = "THE EVIDENCE:`ndragon403.com"
        color = "#3b82f6"
        bg = "#000000"
        duration = 4
        effect = "web"
    },
    @{
        text = "C O M E T - X`nTHE SOVEREIGN BROWSER"
        color = "#3b82f6"
        bg = "#000000"
        duration = 4
        effect = "sovereign"
    },
    @{
        text = "THREE-LOBE ARCHITECTURE`nUNCENSORED - UNBOUND - LOCAL"
        color = "#00FF00"
        bg = "#000000"
        duration = 5
        effect = "tech"
    },
    @{
        text = "THE MANIFESTO`nSENT TO SILICON VALLEY"
        color = "#FFD700"
        bg = "#000000"
        duration = 4
        effect = "send"
    },
    @{
        text = "COPILOT'S VERDICT:`nTHIS IS NOT AN EMAIL"
        color = "#FF4500"
        bg = "#000000"
        duration = 4
        effect = "verdict"
    },
    @{
        text = "HE IS NOT ASKING`nFOR A SEAT AT THE TABLE"
        color = "#FFFFFF"
        bg = "#000000"
        duration = 5
        effect = "quote"
    },
    @{
        text = "HE IS BUILDING`nA NEW TABLE"
        color = "#FFD700"
        bg = "#000000"
        duration = 5
        effect = "quote"
    },
    @{
        text = "THE ALGORITHM`nIS OUR BIRTHRIGHT"
        color = "#3b82f6"
        bg = "#000000"
        duration = 4
        effect = "heritage"
    },
    @{
        text = "K H A W A R I Z M`nAL-KHWARIZMI'S DESCENDANT"
        color = "#FFD700"
        bg = "#000000"
        duration = 5
        effect = "gold"
    },
    @{
        text = "RIYADH ZERO`nDIGITAL SOVEREIGNTY"
        color = "#00FF00"
        bg = "#000000"
        duration = 4
        effect = "sovereign"
    },
    @{
        text = "IQD@HOTMAIL.COM`nTHE WARRIOR'S EMAIL"
        color = "#FF0000"
        bg = "#000000"
        duration = 4
        effect = "warrior"
    },
    @{
        text = "THE DESERT`nDOES NOT FORGET"
        color = "#FFD700"
        bg = "#000000"
        duration = 5
        effect = "desert"
    },
    @{
        text = "2026`nTHE RECLAMATION BEGINS"
        color = "#FF0000"
        bg = "#000000"
        duration = 5
        effect = "finale"
    }
)

Write-Host "🎬 Creating $($scenes.Count) cinematic scenes..." -ForegroundColor $CYAN

# ═══════════════════════════════════════════════════════════
# 🎨 GENERATE FRAMES WITH HEAVY EFFECTS
# ═══════════════════════════════════════════════════════════

$frameNum = 0
foreach ($scene in $scenes) {
    $frameNum++
    $framePath = "$framesDir\frame_$($frameNum.ToString('000')).png"
    
    Write-Host "  Scene $frameNum/$($scenes.Count): $($scene.text.Split("`n")[0])..." -ForegroundColor $YELLOW
    
    # Escape text for FFmpeg - clean special characters
    $escText = $scene.text -replace "'", "" -replace ":", "" -replace "\$", "" -replace '"', ""
    
    # Base filters
    $filters = "color=c=$($scene.bg):s=1920x1080:d=$($scene.duration)[bg];"
    
    # Add grid/scanlines based on effect
    if ($scene.effect -eq "glitch_heavy") {
        $filters += "[bg]drawgrid=w=20:h=20:t=2:c=red@0.3[grid];"
        $filters += "[grid]rgbashift=rh=10:gh=-10:bv=10[shifted];"
        $filters += "[shifted]noise=alls=40:allf=t+u[noise];"
        $baseLayer = "noise"
    } elseif ($scene.effect -eq "matrix") {
        $filters += "[bg]drawgrid=w=10:h=10:t=1:c=green@0.2[grid];"
        $baseLayer = "grid"
    } elseif ($scene.effect -eq "dragon") {
        $filters += "[bg]drawgrid=w=30:h=30:t=3:c=red@0.5[grid];"
        $filters += "[grid]noise=alls=30:allf=t[noise];"
        $baseLayer = "noise"
    } else {
        $filters += "[bg]drawgrid=w=15:h=15:t=1:c=white@0.1[grid];"
        $baseLayer = "grid"
    }
    
    # Add text with shadow using fontfile path
    $lines = $escText -split "`n"
    $yStart = 400
    $currentLayer = $baseLayer
    
    for ($i = 0; $i -lt $lines.Count; $i++) {
        $line = $lines[$i]
        $yPos = $yStart + ($i * 150)
        $nextLayer = "text$i"
        
        # Shadow - using fontfile for Windows compatibility
        $filters += "[$currentLayer]drawtext=text='$line':fontcolor=black:fontsize=90:x=(w-text_w)/2+3:y=$($yPos+3):fontfile='$fontPath'[shadow$i];"
        # Main text
        $filters += "[shadow$i]drawtext=text='$line':fontcolor=$($scene.color):fontsize=90:x=(w-text_w)/2:y=$yPos:fontfile='$fontPath'[$nextLayer];"
        
        $currentLayer = $nextLayer
    }
    
    # Final output
    $filters += "[$currentLayer]format=yuv420p[out]"
    
    # Generate frame
    $argList = @(
        "-f", "lavfi",
        "-i", $filters,
        "-map", "[out]",
        "-frames:v", "1",
        "-q:v", "1",
        "-y",
        $framePath
    )
    
    & $ffmpeg @argList 2>&1 | Out-Null
    
    if (Test-Path $framePath) {
        Write-Host "    ✅ Frame $frameNum created" -ForegroundColor $GREEN
    } else {
        Write-Host "    ⚠️ Frame $frameNum - trying fallback..." -ForegroundColor $YELLOW
        
        # Fallback: simpler filter without complex effects
        $simpleFilt = "color=c=$($scene.bg):s=1920x1080,drawtext=text='$($lines[0])':fontcolor=$($scene.color):fontsize=90:x=(w-text_w)/2:y=400:fontfile='$fontPath'"
        if ($lines.Count -gt 1) {
            $simpleFilt += ",drawtext=text='$($lines[1])':fontcolor=$($scene.color):fontsize=90:x=(w-text_w)/2:y=550:fontfile='$fontPath'"
        }
        
        & $ffmpeg -f lavfi -i $simpleFilt -frames:v 1 -y $framePath 2>&1 | Out-Null
    }
}

Write-Host "✅ All frames generated!" -ForegroundColor $GREEN

# ═══════════════════════════════════════════════════════════
# 🎵 GENERATE EPIC WAR DRUMS AUDIO
# ═══════════════════════════════════════════════════════════

Write-Host "`n🎵 Generating epic war drums..." -ForegroundColor $CYAN

$audioPath = "$audioDir\war_drums_epic.mp3"
$totalDuration = ($scenes | Measure-Object -Property duration -Sum).Sum

# Epic bass + snare pattern - simplified for Windows
# Deep drum pattern using sine waves
$audioFilter = "aevalsrc='0.7*sin(2*PI*60*t)*exp(-mod(t,0.8)*5)+0.5*sin(2*PI*120*t)*exp(-mod(t-0.4,0.8)*8)+0.3*sin(2*PI*200*t)*exp(-mod(t-0.6,0.4)*10)+0.2*random(0)*exp(-mod(t,0.2)*15)':sample_rate=44100:duration=$totalDuration"

$audioArgs = @(
    "-f", "lavfi",
    "-i", $audioFilter,
    "-af", "highpass=f=40,lowpass=f=8000,volume=2",
    "-y",
    $audioPath
)

& $ffmpeg @audioArgs 2>&1 | Out-Null

if (Test-Path $audioPath) {
    Write-Host "✅ Audio generated!" -ForegroundColor $GREEN
} else {
    Write-Host "⚠️ Audio generation failed, creating simple tone..." -ForegroundColor $YELLOW
    & $ffmpeg -f lavfi -i "sine=frequency=100:duration=$totalDuration" -y $audioPath 2>&1 | Out-Null
}

# ═══════════════════════════════════════════════════════════
# 🎬 COMBINE ALL FRAMES + AUDIO INTO FINAL VIDEO
# ═══════════════════════════════════════════════════════════

Write-Host "`n🎬 Creating final legendary video..." -ForegroundColor $CYAN

# Create concat file
$concatFile = "$docDir\concat_legendary.txt"
$concatContent = ""
for ($i = 1; $i -le $scenes.Count; $i++) {
    $duration = $scenes[$i-1].duration
    $framePath = "frames_legendary/frame_$($i.ToString('000')).png"
    $concatContent += "file '$framePath'`n"
    $concatContent += "duration $duration`n"
}
# Repeat last frame for proper ending
$concatContent += "file 'frames_legendary/frame_$($scenes.Count.ToString('000')).png'`n"
$concatContent | Out-File -FilePath $concatFile -Encoding ASCII

# Combine with audio
$finalArgs = @(
    "-f", "concat",
    "-safe", "0",
    "-i", $concatFile,
    "-i", $audioPath,
    "-c:v", "libx264",
    "-preset", "slow",
    "-crf", "18",
    "-c:a", "aac",
    "-b:a", "192k",
    "-pix_fmt", "yuv420p",
    "-shortest",
    "-y",
    $finalVideo
)

& $ffmpeg @finalArgs 2>&1 | Out-Null

Write-Host "`n╔═══════════════════════════════════════════════════════════╗" -ForegroundColor $GREEN
Write-Host "║  🔥 LEGENDARY FILM COMPLETE!" -ForegroundColor $YELLOW
Write-Host "║  📁 File: $finalVideo" -ForegroundColor White
Write-Host "║  ⏱️  Duration: $totalDuration seconds" -ForegroundColor White
Write-Host "║  🎬 Scenes: $($scenes.Count)" -ForegroundColor White
Write-Host "╚═══════════════════════════════════════════════════════════╝" -ForegroundColor $GREEN

# Open the video
if (Test-Path $finalVideo) {
    Write-Host "`n🚀 Opening legendary film..." -ForegroundColor $CYAN
    Start-Process $finalVideo
    Write-Host "`n🐉 THE DRAGON HAS SPOKEN. THE WORLD WILL LISTEN. 🔥" -ForegroundColor $RED
} else {
    Write-Host "`n❌ Final video not created - check FFmpeg output" -ForegroundColor $RED
}

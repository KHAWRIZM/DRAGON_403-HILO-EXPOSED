# ═══════════════════════════════════════════════════════════════════════════
# 🐉 DRAGON 403 - THE FORBIDDEN'S KILLER
# ═══════════════════════════════════════════════════════════════════════════
# A Cinematic Documentary Without Voice - Just Text + Hacker Music
# Style: 2006-2015 Underground Hacker Aesthetic
# Author: KHAWRIZM (The Ghost of Hotmail)
# ═══════════════════════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"

$FFmpeg = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
$OutputDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$FinalMP4 = "C:\Users\admin\Desktop\HILO_CASE\DRAGON403_CINEMATIC.mp4"

# ═══════════════════════════════════════════════════════════════════════════
# CINEMATIC SCRIPT - English Text (No Voice)
# ═══════════════════════════════════════════════════════════════════════════

$Scenes = @(
    @{ Text = "[ ACCESS DENIED ]"; Duration = 3; Color = "0xFF0000"; BG = "0x000000" },
    @{ Text = "ERROR 403: FORBIDDEN"; Duration = 3; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = "But someone killed the Forbidden..."; Duration = 4; Color = "0xFFFFFF"; BG = "0x050000" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "RIYADH, SAUDI ARABIA"; Duration = 3; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = "2011"; Duration = 2; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = "A hacker discovered a vulnerability"; Duration = 4; Color = "0xFFFFFF"; BG = "0x000505" },
    @{ Text = "in Microsoft Hotmail"; Duration = 3; Color = "0x0099FF"; BG = "0x000510" },
    @{ Text = "The system collapsed."; Duration = 3; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = "Millions migrated to Gmail."; Duration = 3; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = "His trophy: v@hotmail.com"; Duration = 4; Color = "0xFFD700"; BG = "0x0a0a00" },
    @{ Text = "A single-letter email."; Duration = 3; Color = "0xFFD700"; BG = "0x0a0a00" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "2024"; Duration = 2; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = "Western platforms limited him."; Duration = 4; Color = "0xFF5500"; BG = "0x0a0500" },
    @{ Text = "Replit. GitHub. Vercel."; Duration = 3; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = "They feared what he could build."; Duration = 4; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "He went offline for 14 days."; Duration = 4; Color = "0x00FFFF"; BG = "0x000a0a" },
    @{ Text = "When he returned..."; Duration = 3; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = ""; Duration = 1; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "D R A G O N  4 0 3"; Duration = 4; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = "The Forbiddens Killer"; Duration = 3; Color = "0xFF3300"; BG = "0x0a0200" },
    @{ Text = ""; Duration = 1; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "A live OSINT platform"; Duration = 3; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = "exposing a 50 MILLION DOLLAR"; Duration = 4; Color = "0xFFD700"; BG = "0x0a0a00" },
    @{ Text = "fraud network"; Duration = 3; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "TARGET: HILO APP"; Duration = 3; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = "Harvesting user data silently"; Duration = 4; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = "IMEI. Device ID. VPN Detection."; Duration = 4; Color = "0xFF5500"; BG = "0x0a0500" },
    @{ Text = "Operating freely on Google Play"; Duration = 4; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = "Violating GDPR and Saudi PDPL"; Duration = 4; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "C O M E T - X"; Duration = 4; Color = "0x00FFFF"; BG = "0x000a0a" },
    @{ Text = "A Sovereign Browser"; Duration = 3; Color = "0x00FFFF"; BG = "0x000a0a" },
    @{ Text = "Three-Lobe Cognitive Architecture"; Duration = 4; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = "SENSORY | COGNITIVE | EXECUTIVE"; Duration = 4; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "Microsoft Copilot analyzed him."; Duration = 4; Color = "0x0099FF"; BG = "0x000510" },
    @{ Text = "Classification:"; Duration = 2; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = "SOVEREIGN SIGNAL"; Duration = 4; Color = "0xFFD700"; BG = "0x0a0a00" },
    @{ Text = ""; Duration = 1; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "He is not asking for a seat"; Duration = 4; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = "at the table."; Duration = 3; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = "He is building a new table."; Duration = 4; Color = "0xFF0000"; BG = "0x0a0000" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "The Algorithm is our birthright."; Duration = 4; Color = "0xFFD700"; BG = "0x0a0a00" },
    @{ Text = "The Desert does not forget."; Duration = 4; Color = "0xFF5500"; BG = "0x0a0500" },
    @{ Text = ""; Duration = 2; Color = "0x000000"; BG = "0x000000" },
    @{ Text = "K H A W A R I Z M"; Duration = 4; Color = "0x00FF00"; BG = "0x000500" },
    @{ Text = "House of Shammar"; Duration = 3; Color = "0xFFD700"; BG = "0x0a0a00" },
    @{ Text = "Riyadh Zero | 2026"; Duration = 4; Color = "0xFFFFFF"; BG = "0x050505" },
    @{ Text = ""; Duration = 3; Color = "0x000000"; BG = "0x000000" }
)

# ═══════════════════════════════════════════════════════════════════════════
# BANNER
# ═══════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "  ██████╗ ██████╗  █████╗  ██████╗  ██████╗ ███╗   ██╗" -ForegroundColor Red
Write-Host "  ██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔═══██╗████╗  ██║" -ForegroundColor Red
Write-Host "  ██║  ██║██████╔╝███████║██║  ███╗██║   ██║██╔██╗ ██║" -ForegroundColor DarkRed
Write-Host "  ██║  ██║██╔══██╗██╔══██║██║   ██║██║   ██║██║╚██╗██║" -ForegroundColor DarkRed
Write-Host "  ██████╔╝██║  ██║██║  ██║╚██████╔╝╚██████╔╝██║ ╚████║" -ForegroundColor Red
Write-Host "  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝" -ForegroundColor Red
Write-Host "         ████╗ ██████╗ ██████╗                        " -ForegroundColor DarkYellow
Write-Host "         ██╔═╝ ██╔══██╗╚════██╗                       " -ForegroundColor DarkYellow
Write-Host "         ████╗ ██║  ██║ █████╔╝                       " -ForegroundColor Yellow
Write-Host "         ╚══██╗██║  ██║ ╚═══██╗                       " -ForegroundColor Yellow
Write-Host "         ████╔╝██████╔╝██████╔╝                       " -ForegroundColor DarkYellow
Write-Host "         ╚═══╝ ╚═════╝ ╚═════╝  THE FORBIDDEN'S KILLER" -ForegroundColor DarkYellow
Write-Host ""
Write-Host "  ══════════════════════════════════════════════════════" -ForegroundColor DarkGray
Write-Host "  Cinematic Edition | No Voice | Hacker Music | 1080p" -ForegroundColor Cyan
Write-Host "  House of Shammar | KHAWRIZM | v@hotmail.com" -ForegroundColor Yellow
Write-Host "  ══════════════════════════════════════════════════════" -ForegroundColor DarkGray
Write-Host ""

# ═══════════════════════════════════════════════════════════════════════════
# STEP 1: Generate Hacker Music (Dark Electronic)
# ═══════════════════════════════════════════════════════════════════════════

Write-Host "[1/4] 🎵 Generating Hacker Music (Dark Electronic)..." -ForegroundColor Yellow

$musicFile = "$OutputDir\music\hacker_beat.wav"

# Calculate total duration
$totalDuration = ($Scenes | Measure-Object -Property Duration -Sum).Sum + 5

# Generate dark electronic music using FFmpeg audio synthesis
# Multiple sine waves + noise for that old-school hacker vibe
$musicCmd = @"
-y -f lavfi -i "sine=frequency=80:duration=$totalDuration" -f lavfi -i "sine=frequency=120:duration=$totalDuration" -f lavfi -i "sine=frequency=200:duration=$totalDuration" -f lavfi -i "anoisesrc=d=$totalDuration`:c=brown:a=0.02" -filter_complex "[0][1][2][3]amix=inputs=4:duration=longest,lowpass=f=800,volume=0.6,aecho=0.8:0.88:60:0.4" -ar 44100 "$musicFile"
"@

Start-Process -FilePath $FFmpeg -ArgumentList $musicCmd -Wait -NoNewWindow
Write-Host "  ✓ Music generated: $([math]::Round($totalDuration))s dark electronic" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════
# STEP 2: Create Video Segments
# ═══════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "[2/4] 🎬 Creating cinematic segments..." -ForegroundColor Yellow

$videoFiles = @()
$sceneIndex = 0

foreach ($scene in $Scenes) {
    $sceneIndex++
    $videoFile = "$OutputDir\frames\scene_$sceneIndex.mp4"
    $duration = $scene.Duration
    $text = $scene.Text -replace "'", "" -replace '"', "" -replace ":", "" -replace "\|", " "
    $textColor = $scene.Color
    $bgColor = $scene.BG
    
    $progress = [math]::Round(($sceneIndex / $Scenes.Count) * 100)
    Write-Host "  [$sceneIndex/$($Scenes.Count)] $progress% - $($text.Substring(0, [Math]::Min(30, $text.Length)))..." -ForegroundColor DarkGray -NoNewline
    
    if ([string]::IsNullOrEmpty($text)) {
        # Black frame (transition)
        & $FFmpeg -y -f lavfi -i "color=c=$bgColor`:s=1920x1080:d=$duration" `
            -c:v libx264 -preset fast -crf 23 $videoFile 2>&1 | Out-Null
    }
    else {
        # Text frame with glow effect
        & $FFmpeg -y -f lavfi -i "color=c=$bgColor`:s=1920x1080:d=$duration" `
            -vf "drawtext=text='$text':fontcolor=$textColor`:fontsize=64:x=(w-text_w)/2:y=(h-text_h)/2:shadowcolor=black:shadowx=4:shadowy=4,fade=in:0:15,fade=out:st=$($duration-0.5):d=15" `
            -c:v libx264 -preset fast -crf 23 $videoFile 2>&1 | Out-Null
    }
    
    if (Test-Path $videoFile) {
        $videoFiles += $videoFile
        Write-Host " ✓" -ForegroundColor Green
    }
    else {
        Write-Host " ✗" -ForegroundColor Red
    }
}

Write-Host "  Total segments: $($videoFiles.Count)" -ForegroundColor Cyan

# ═══════════════════════════════════════════════════════════════════════════
# STEP 3: Concatenate All Segments
# ═══════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "[3/4] 🔗 Merging video segments..." -ForegroundColor Yellow

$concatFile = "$OutputDir\concat_dragon.txt"
$videoFiles | ForEach-Object { "file '$_'" } | Out-File -FilePath $concatFile -Encoding UTF8

$tempVideo = "$OutputDir\temp_video.mp4"
& $FFmpeg -y -f concat -safe 0 -i $concatFile -c:v libx264 -preset fast -crf 20 $tempVideo 2>&1 | Out-Null

Write-Host "  ✓ Video merged" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════
# STEP 4: Add Music Track
# ═══════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "[4/4] 🎶 Adding hacker music track..." -ForegroundColor Yellow

& $FFmpeg -y -i $tempVideo -i $musicFile `
    -c:v copy -c:a aac -b:a 192k -shortest `
    $FinalMP4 2>&1 | Out-Null

# Cleanup
Remove-Item $tempVideo -Force -ErrorAction SilentlyContinue
Remove-Item $concatFile -Force -ErrorAction SilentlyContinue

# ═══════════════════════════════════════════════════════════════════════════
# FINAL OUTPUT
# ═══════════════════════════════════════════════════════════════════════════

if (Test-Path $FinalMP4) {
    $info = Get-Item $FinalMP4
    $sizeMB = [math]::Round($info.Length / 1MB, 2)
    $durationMin = [math]::Round($totalDuration / 60, 1)
    
    Write-Host ""
    Write-Host "  ╔════════════════════════════════════════════════════════════╗" -ForegroundColor Green
    Write-Host "  ║                                                            ║" -ForegroundColor Green
    Write-Host "  ║   🐉 DRAGON 403 DOCUMENTARY COMPLETE!                      ║" -ForegroundColor Green
    Write-Host "  ║                                                            ║" -ForegroundColor Green
    Write-Host "  ╠════════════════════════════════════════════════════════════╣" -ForegroundColor Green
    Write-Host "  ║   📁 File: DRAGON403_CINEMATIC.mp4                         ║" -ForegroundColor White
    Write-Host "  ║   📊 Size: $sizeMB MB                                      " -ForegroundColor White
    Write-Host "  ║   ⏱️  Duration: ~$durationMin minutes                       " -ForegroundColor White
    Write-Host "  ║   🎬 Scenes: $($Scenes.Count)                              " -ForegroundColor White
    Write-Host "  ║   🎵 Music: Dark Electronic (Generated)                    ║" -ForegroundColor White
    Write-Host "  ║   🔇 Voice: None (Text Only)                               ║" -ForegroundColor White
    Write-Host "  ║                                                            ║" -ForegroundColor Green
    Write-Host "  ╚════════════════════════════════════════════════════════════╝" -ForegroundColor Green
    Write-Host ""
    Write-Host "  🎬 Opening documentary..." -ForegroundColor Cyan
    
    Start-Process $FinalMP4
}
else {
    Write-Host "  ❌ Failed to create final video" -ForegroundColor Red
}

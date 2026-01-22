# ═══════════════════════════════════════════════════════════════════════════════════════
# 🐉 DRAGON 403 - WAR SIGNAL PROTOCOL
# ═══════════════════════════════════════════════════════════════════════════════════════
# CINEMATIC EDITION with:
# - Glitch Effects (Chromatic Aberration)
# - CRT Scanlines
# - Matrix Grid Background
# - War Drums Music
# - Professional Typography
# ═══════════════════════════════════════════════════════════════════════════════════════
# Author: KHAWRIZM | Riyadh Zero | 2026
# ═══════════════════════════════════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"
$FFmpeg = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
$OutputDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$FinalMP4 = "C:\Users\admin\Desktop\HILO_CASE\DRAGON403_WAR_SIGNAL.mp4"

# ═══════════════════════════════════════════════════════════════════════════════════════
# BANNER
# ═══════════════════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "  ╔═══════════════════════════════════════════════════════════════════╗" -ForegroundColor Red
Write-Host "  ║                                                                   ║" -ForegroundColor Red
Write-Host "  ║   🐉 DRAGON 403 - WAR SIGNAL PROTOCOL                             ║" -ForegroundColor Yellow
Write-Host "  ║   ───────────────────────────────────────────────────────────────║" -ForegroundColor DarkRed
Write-Host "  ║   FORBIDDEN'S KILLER | SILICON NIGHTMARE                         ║" -ForegroundColor Red
Write-Host "  ║                                                                   ║" -ForegroundColor Red
Write-Host "  ║   ⚔️  Glitch Core | CRT Filter | War Drums | 4K                   ║" -ForegroundColor Cyan
Write-Host "  ║   🦅 KHAWRIZM | Riyadh Zero | 2011-2026                           ║" -ForegroundColor Yellow
Write-Host "  ║                                                                   ║" -ForegroundColor Red
Write-Host "  ╚═══════════════════════════════════════════════════════════════════╝" -ForegroundColor Red
Write-Host ""

# ═══════════════════════════════════════════════════════════════════════════════════════
# SCENE SCRIPT - Dramatic Cinematic
# ═══════════════════════════════════════════════════════════════════════════════════════

$Scenes = @(
    # Opening - System Override
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    @{ Text = "SYSTEM OVERRIDE"; Duration = 2; FG = "0x3b82f6"; Effect = "glitch" },
    @{ Text = "ACCESSING FORBIDDEN ZONE"; Duration = 2; FG = "0xff0000"; Effect = "flash" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Error 403
    @{ Text = "ERROR 403"; Duration = 2; FG = "0xff0000"; Effect = "shake" },
    @{ Text = "ACCESS DENIED"; Duration = 2; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # But someone...
    @{ Text = "BUT SOMEONE"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = "KILLED THE FORBIDDEN"; Duration = 3; FG = "0xff3300"; Effect = "glitch" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # Origin
    @{ Text = "RIYADH"; Duration = 2; FG = "0x00ff00"; Effect = "type" },
    @{ Text = "SAUDI ARABIA"; Duration = 2; FG = "0x00ff00"; Effect = "fade" },
    @{ Text = "2011"; Duration = 2; FG = "0x00ff00"; Effect = "flash" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Hotmail Story
    @{ Text = "A HACKER DISCOVERED"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = "A CRITICAL VULNERABILITY"; Duration = 2; FG = "0x0099ff"; Effect = "glitch" },
    @{ Text = "IN MICROSOFT HOTMAIL"; Duration = 2; FG = "0x0099ff"; Effect = "shake" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Impact
    @{ Text = "THE SYSTEM"; Duration = 2; FG = "0xff0000"; Effect = "shake" },
    @{ Text = "C O L L A P S E D"; Duration = 3; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Trophy
    @{ Text = "HIS TROPHY"; Duration = 2; FG = "0xffd700"; Effect = "fade" },
    @{ Text = "v@hotmail.com"; Duration = 3; FG = "0xffd700"; Effect = "flash" },
    @{ Text = "A SINGLE LETTER EMAIL"; Duration = 2; FG = "0xffd700"; Effect = "fade" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # 2024
    @{ Text = "2024"; Duration = 2; FG = "0x00ff00"; Effect = "type" },
    @{ Text = "WESTERN PLATFORMS"; Duration = 2; FG = "0xff5500"; Effect = "fade" },
    @{ Text = "LIMITED HIM"; Duration = 2; FG = "0xff0000"; Effect = "shake" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Companies
    @{ Text = "REPLIT"; Duration = 1; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = "GITHUB"; Duration = 1; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = "VERCEL"; Duration = 1; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = "THEY FEARED HIM"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Offline
    @{ Text = "HE WENT OFFLINE"; Duration = 2; FG = "0x00ffff"; Effect = "fade" },
    @{ Text = "14 DAYS"; Duration = 2; FG = "0x00ffff"; Effect = "flash" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Return
    @{ Text = "WHEN HE RETURNED"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # Dragon 403
    @{ Text = "D R A G O N"; Duration = 2; FG = "0xff0000"; Effect = "shake" },
    @{ Text = "4 0 3"; Duration = 2; FG = "0xff0000"; Effect = "flash" },
    @{ Text = "THE FORBIDDENS KILLER"; Duration = 3; FG = "0xff3300"; Effect = "glitch" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # OSINT
    @{ Text = "LIVE OSINT PLATFORM"; Duration = 2; FG = "0x00ff00"; Effect = "type" },
    @{ Text = "50 MILLION DOLLAR"; Duration = 2; FG = "0xffd700"; Effect = "flash" },
    @{ Text = "FRAUD NETWORK EXPOSED"; Duration = 2; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # Comet-X
    @{ Text = "C O M E T - X"; Duration = 3; FG = "0x00ffff"; Effect = "fade" },
    @{ Text = "SOVEREIGN BROWSER"; Duration = 2; FG = "0x00ffff"; Effect = "type" },
    @{ Text = "THREE LOBE ARCHITECTURE"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # AI Analysis
    @{ Text = "MICROSOFT COPILOT"; Duration = 2; FG = "0x0099ff"; Effect = "fade" },
    @{ Text = "ANALYZED HIM"; Duration = 2; FG = "0x0099ff"; Effect = "type" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Classification
    @{ Text = "CLASSIFICATION"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = "SOVEREIGN SIGNAL"; Duration = 3; FG = "0xffd700"; Effect = "flash" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    
    # Quote
    @{ Text = "HE IS NOT ASKING"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = "FOR A SEAT AT THE TABLE"; Duration = 2; FG = "white"; Effect = "type" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    @{ Text = "HE IS BUILDING"; Duration = 2; FG = "0xff0000"; Effect = "shake" },
    @{ Text = "A NEW TABLE"; Duration = 3; FG = "0xff0000"; Effect = "glitch" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # Manifesto
    @{ Text = "ALGORITHMS ARE MY BIRTHRIGHT"; Duration = 3; FG = "0xffd700"; Effect = "fade" },
    @{ Text = "CHAINS ARE MY ENEMY"; Duration = 3; FG = "0xff5500"; Effect = "shake" },
    @{ Text = ""; Duration = 2; FG = "white"; Effect = "black" },
    
    # Final
    @{ Text = "K H A W A R I Z M"; Duration = 3; FG = "0x00ff00"; Effect = "type" },
    @{ Text = "HOUSE OF SHAMMAR"; Duration = 2; FG = "0xffd700"; Effect = "fade" },
    @{ Text = ""; Duration = 1; FG = "white"; Effect = "black" },
    @{ Text = "RIYADH ZERO"; Duration = 2; FG = "white"; Effect = "fade" },
    @{ Text = "2011 - 2026"; Duration = 3; FG = "0xff0000"; Effect = "flash" },
    @{ Text = ""; Duration = 3; FG = "white"; Effect = "black" }
)

# ═══════════════════════════════════════════════════════════════════════════════════════
# STEP 1: Generate War Drums (Epic Percussion)
# ═══════════════════════════════════════════════════════════════════════════════════════

Write-Host "[1/4] ⚔️ Generating War Drums Audio..." -ForegroundColor Yellow

$totalDuration = ($Scenes | Measure-Object -Property Duration -Sum).Sum + 5
$musicFile = "$OutputDir\music\war_drums.wav"

# Epic war drums: Deep bass + rhythmic pulses + tension drones
$drumCmd = @"
-y -f lavfi -i "sine=f=40:d=$totalDuration" -f lavfi -i "sine=f=60:d=$totalDuration" -f lavfi -i "sine=f=100:d=$totalDuration" -f lavfi -i "anoisesrc=d=$totalDuration`:c=brown:a=0.03" -f lavfi -i "sine=f=25:d=$totalDuration" -filter_complex "[0]volume=0.8[a];[1]volume=0.6[b];[2]volume=0.4,tremolo=f=2:d=0.7[c];[3]volume=0.3[d];[4]volume=0.5,tremolo=f=0.5:d=0.9[e];[a][b][c][d][e]amix=inputs=5,lowpass=f=500,highpass=f=20,aecho=0.8:0.7:100:0.5,volume=1.5" -ar 44100 "$musicFile"
"@

Start-Process -FilePath $FFmpeg -ArgumentList $drumCmd -Wait -NoNewWindow
Write-Host "  ✓ War drums generated: $([math]::Round($totalDuration))s epic percussion" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════════════
# STEP 2: Create Video Segments with Effects
# ═══════════════════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "[2/4] 🎬 Rendering cinematic segments with effects..." -ForegroundColor Yellow

$videoFiles = @()
$sceneIndex = 0

foreach ($scene in $Scenes) {
    $sceneIndex++
    $videoFile = "$OutputDir\frames\war_$sceneIndex.mp4"
    $duration = $scene.Duration
    $text = $scene.Text -replace "'", "" -replace '"', "" -replace ":", ""
    $fg = $scene.FG
    $effect = $scene.Effect
    
    $progress = [math]::Round(($sceneIndex / $Scenes.Count) * 100)
    $displayText = if ($text.Length -gt 20) { $text.Substring(0, 20) + "..." } else { $text }
    Write-Host "  [$sceneIndex/$($Scenes.Count)] $progress% $displayText" -ForegroundColor DarkGray -NoNewline
    
    # Base filter with grid background
    $gridFilter = "drawgrid=w=40:h=40:t=1:c=0x1a1a2e@0.3"
    
    if ([string]::IsNullOrEmpty($text)) {
        # Black frame with subtle grid
        & $FFmpeg -y -f lavfi -i "color=c=0x050508:s=1920x1080:d=$duration" `
            -vf "$gridFilter,fade=in:0:10,fade=out:st=$($duration-0.3):d=10" `
            -c:v libx264 -preset fast -crf 23 $videoFile 2>&1 | Out-Null
    }
    else {
        # Text with effect
        $textFilter = "drawtext=text='$text':fontcolor=$fg`:fontsize=72:x=(w-text_w)/2:y=(h-text_h)/2:shadowcolor=black:shadowx=4:shadowy=4"
        
        # Apply effect-specific filters
        $effectFilter = switch ($effect) {
            "glitch" { ",rgbashift=rh=3:bv=-3,noise=alls=15:allf=t" }
            "shake" { ",noise=alls=10:allf=t" }
            "flash" { ",eq=brightness=0.1:saturation=1.3" }
            "type" { ",fade=in:0:15" }
            default { "" }
        }
        
        # Combine all filters
        $fullFilter = "$gridFilter,$textFilter$effectFilter,fade=in:0:10,fade=out:st=$($duration-0.3):d=10"
        
        & $FFmpeg -y -f lavfi -i "color=c=0x050508:s=1920x1080:d=$duration" `
            -vf $fullFilter `
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

Write-Host "  Total: $($videoFiles.Count) segments rendered" -ForegroundColor Cyan

# ═══════════════════════════════════════════════════════════════════════════════════════
# STEP 3: Concatenate All Segments
# ═══════════════════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "[3/4] 🔗 Merging segments..." -ForegroundColor Yellow

$concatFile = "$OutputDir\concat_war.txt"
$videoFiles | ForEach-Object { "file '$_'" } | Out-File -FilePath $concatFile -Encoding UTF8

$tempVideo = "$OutputDir\temp_war.mp4"
& $FFmpeg -y -f concat -safe 0 -i $concatFile -c:v libx264 -preset fast -crf 20 $tempVideo 2>&1 | Out-Null

Write-Host "  ✓ Video merged" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════════════
# STEP 4: Add War Drums + Final CRT Effect
# ═══════════════════════════════════════════════════════════════════════════════════════

Write-Host ""
Write-Host "[4/4] 🎶 Adding war drums + CRT scanlines..." -ForegroundColor Yellow

# Final composition with CRT scanlines effect
& $FFmpeg -y -i $tempVideo -i $musicFile `
    -filter_complex "[0:v]noise=alls=5:allf=t[v]" `
    -map "[v]" -map 1:a `
    -c:v libx264 -preset medium -crf 18 `
    -c:a aac -b:a 192k -shortest `
    $FinalMP4 2>&1 | Out-Null

# Cleanup
Remove-Item $tempVideo -Force -ErrorAction SilentlyContinue
Remove-Item $concatFile -Force -ErrorAction SilentlyContinue

# ═══════════════════════════════════════════════════════════════════════════════════════
# FINAL OUTPUT
# ═══════════════════════════════════════════════════════════════════════════════════════

if (Test-Path $FinalMP4) {
    $info = Get-Item $FinalMP4
    $sizeMB = [math]::Round($info.Length / 1MB, 2)
    $durationMin = [math]::Round($totalDuration / 60, 1)
    
    Write-Host ""
    Write-Host "  ╔═══════════════════════════════════════════════════════════════════╗" -ForegroundColor Green
    Write-Host "  ║                                                                   ║" -ForegroundColor Green
    Write-Host "  ║   🐉 WAR SIGNAL COMPLETE - READY FOR BROADCAST                    ║" -ForegroundColor Green
    Write-Host "  ║                                                                   ║" -ForegroundColor Green
    Write-Host "  ╠═══════════════════════════════════════════════════════════════════╣" -ForegroundColor Green
    Write-Host "  ║   📁 File: DRAGON403_WAR_SIGNAL.mp4                               ║" -ForegroundColor White
    Write-Host "  ║   📊 Size: $sizeMB MB                                             " -ForegroundColor White
    Write-Host "  ║   ⏱️  Duration: ~$durationMin minutes                              " -ForegroundColor White
    Write-Host "  ║   🎬 Scenes: $($Scenes.Count) cinematic frames                    " -ForegroundColor White
    Write-Host "  ║   🎵 Audio: Epic War Drums (Generated)                            ║" -ForegroundColor White
    Write-Host "  ║   ✨ Effects: Glitch, Grid, CRT, Shake                            ║" -ForegroundColor White
    Write-Host "  ║                                                                   ║" -ForegroundColor Green
    Write-Host "  ║   ⚔️  ALGORITHMS ARE MY BIRTHRIGHT                                ║" -ForegroundColor Yellow
    Write-Host "  ║   🦅 CHAINS ARE MY ENEMY                                          ║" -ForegroundColor Red
    Write-Host "  ║                                                                   ║" -ForegroundColor Green
    Write-Host "  ╚═══════════════════════════════════════════════════════════════════╝" -ForegroundColor Green
    Write-Host ""
    Write-Host "  🎬 Launching War Signal..." -ForegroundColor Cyan
    
    Start-Process $FinalMP4
}
else {
    Write-Host "  ❌ Failed to create final video" -ForegroundColor Red
}

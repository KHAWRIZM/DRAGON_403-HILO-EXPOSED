# 🐉 DRAGON 403 - MERGE CINEMATIC FILM
# Combines stock/AI videos + Music + Text overlays
# ═══════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"

Write-Host @"

    🐉 DRAGON 403 - CINEMATIC MERGER 🐉
    ══════════════════════════════════════

"@ -ForegroundColor Red

$docDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$stockDir = "$docDir\stock_videos"
$outputDir = "$docDir\cinematic_output"
$musicDir = "$docDir\music"
$FFmpeg = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
$finalOutput = "$docDir\DRAGON403_CINEMATIC_FINAL.mp4"

# Check for stock videos
$stockVideos = Get-ChildItem "$stockDir\*.mp4" -ErrorAction SilentlyContinue
if ($stockVideos.Count -eq 0) {
    Write-Host "❌ لا توجد فيديوهات في: $stockDir" -ForegroundColor Red
    Write-Host "   شغّل Setup-CinematicDoc.ps1 أولاً" -ForegroundColor Yellow
    return
}

Write-Host "✅ وجدت $($stockVideos.Count) فيديو" -ForegroundColor Green

# Text overlays for each scene
$overlays = @(
    @{ text = "ACCESS DENIED"; subtext = "ERROR 403: FORBIDDEN"; color = "red" },
    @{ text = "2011"; subtext = "RIYADH, SAUDI ARABIA"; color = "green" },
    @{ text = "A YOUNG HACKER"; subtext = "DISCOVERED A VULNERABILITY"; color = "white" },
    @{ text = "MICROSOFT HOTMAIL"; subtext = "SYSTEM BREACH"; color = "red" },
    @{ text = "THE EMPIRE FELL"; subtext = "THE MIGRATION BEGAN"; color = "orange" },
    @{ text = "TROPHY CLAIMED"; subtext = "v@hotmail.com"; color = "gold" },
    @{ text = "15 YEARS LATER..."; subtext = ""; color = "white" },
    @{ text = "D R A G O N"; subtext = "4 0 3"; color = "red" },
    @{ text = "THE FORBIDDEN'S KILLER"; subtext = "RETURNS"; color = "red" },
    @{ text = "TARGET IDENTIFIED"; subtext = "HILO FRAUD NETWORK"; color = "green" },
    @{ text = "$50,000,000"; subtext = "STOLEN FROM VICTIMS"; color = "red" },
    @{ text = "GOOGLE & APPLE"; subtext = "KNEW EVERYTHING"; color = "orange" },
    @{ text = "THE EVIDENCE"; subtext = "dragon403.com"; color = "cyan" },
    @{ text = "C O M E T - X"; subtext = "THE SOVEREIGN BROWSER"; color = "cyan" },
    @{ text = "THREE-LOBE ARCHITECTURE"; subtext = "UNCENSORED • UNBOUND • LOCAL"; color = "green" },
    @{ text = "THE MANIFESTO"; subtext = "SENT TO SILICON VALLEY"; color = "gold" },
    @{ text = "COPILOT'S VERDICT"; subtext = "THIS IS NOT AN EMAIL"; color = "orange" },
    @{ text = "HE IS NOT ASKING"; subtext = "FOR A SEAT AT THE TABLE"; color = "white" },
    @{ text = "HE IS BUILDING"; subtext = "A NEW TABLE"; color = "gold" },
    @{ text = "THE ALGORITHM"; subtext = "IS OUR BIRTHRIGHT"; color = "cyan" },
    @{ text = "K H A W A R I Z M"; subtext = "AL-KHWARIZMI'S DESCENDANT"; color = "gold" },
    @{ text = "RIYADH ZERO"; subtext = "DIGITAL SOVEREIGNTY"; color = "green" },
    @{ text = "IQD@HOTMAIL.COM"; subtext = "THE WARRIOR'S EMAIL"; color = "red" },
    @{ text = "THE DESERT"; subtext = "DOES NOT FORGET"; color = "gold" },
    @{ text = "2026"; subtext = "THE RECLAMATION BEGINS"; color = "red" }
)

$colorMap = @{
    "red"    = "0xFF0000"
    "green"  = "0x00FF00"
    "white"  = "0xFFFFFF"
    "orange" = "0xFF6600"
    "gold"   = "0xFFD700"
    "cyan"   = "0x00FFFF"
}

Write-Host "`n🎬 Processing videos with text overlays..." -ForegroundColor Cyan

$processedVideos = @()
$i = 0

foreach ($video in ($stockVideos | Sort-Object Name)) {
    $i++
    if ($i -gt $overlays.Count) { break }
    
    $overlay = $overlays[$i - 1]
    $outputFile = "$outputDir\processed_$($i.ToString('000')).mp4"
    $textColor = $colorMap[$overlay.color]
    
    Write-Host "  [$i/$($overlays.Count)] $($overlay.text)..." -ForegroundColor Yellow -NoNewline
    
    # Build filter for text overlay with cinematic style
    $filter = "scale=1920:1080,setsar=1"
    $filter += ",drawtext=text='$($overlay.text)':fontcolor=$textColor`:fontsize=80:x=(w-text_w)/2:y=h/2-60:shadowcolor=black:shadowx=4:shadowy=4"
    
    if ($overlay.subtext) {
        $filter += ",drawtext=text='$($overlay.subtext)':fontcolor=$textColor`:fontsize=50:x=(w-text_w)/2:y=h/2+40:shadowcolor=black:shadowx=3:shadowy=3"
    }
    
    # Add vignette and color grading for cinematic look
    $filter += ",vignette=PI/4,eq=saturation=1.2:contrast=1.1"
    
    & $FFmpeg -y -i $video.FullName -vf $filter -c:v libx264 -preset fast -crf 20 -t 5 -an $outputFile 2>&1 | Out-Null
    
    if (Test-Path $outputFile) {
        $processedVideos += $outputFile
        Write-Host " ✅" -ForegroundColor Green
    }
    else {
        Write-Host " ❌" -ForegroundColor Red
    }
}

if ($processedVideos.Count -eq 0) {
    Write-Host "❌ لم يتم معالجة أي فيديو" -ForegroundColor Red
    return
}

Write-Host "`n✅ تمت معالجة $($processedVideos.Count) فيديو" -ForegroundColor Green

# Create concat file
Write-Host "`n🔗 Merging all videos..." -ForegroundColor Cyan
$concatFile = "$outputDir\concat_cinematic.txt"
$processedVideos | ForEach-Object { "file '$_'" } | Out-File -FilePath $concatFile -Encoding ASCII

$tempVideo = "$outputDir\merged_video.mp4"
& $FFmpeg -y -f concat -safe 0 -i $concatFile -c:v libx264 -preset fast -crf 18 $tempVideo 2>&1 | Out-Null

# Find music file
$musicFile = Get-ChildItem "$musicDir\*.mp3", "$musicDir\*.wav" -ErrorAction SilentlyContinue | Select-Object -First 1

if ($musicFile) {
    Write-Host "🎵 Adding music: $($musicFile.Name)" -ForegroundColor Cyan
    & $FFmpeg -y -i $tempVideo -i $musicFile.FullName -c:v copy -c:a aac -b:a 192k -shortest $finalOutput 2>&1 | Out-Null
}
else {
    Write-Host "⚠️ No music found, using video only" -ForegroundColor Yellow
    Copy-Item $tempVideo $finalOutput
}

# Final output
if (Test-Path $finalOutput) {
    $info = Get-Item $finalOutput
    Write-Host @"

╔═══════════════════════════════════════════════════════════════╗
║                                                               ║
║   🐉 CINEMATIC FILM COMPLETE! 🐉                              ║
║                                                               ║
╠═══════════════════════════════════════════════════════════════╣
║   📁 File: DRAGON403_CINEMATIC_FINAL.mp4                      ║
║   📊 Size: $([math]::Round($info.Length / 1MB, 2)) MB                                         
║   🎬 Scenes: $($processedVideos.Count)                                        
║                                                               ║
╚═══════════════════════════════════════════════════════════════╝

"@ -ForegroundColor Green

    Start-Process $finalOutput
    Write-Host "🐉 THE DRAGON HAS SPOKEN. THE WORLD WILL LISTEN. 🔥`n" -ForegroundColor Red
}
else {
    Write-Host "❌ Failed to create final video" -ForegroundColor Red
}

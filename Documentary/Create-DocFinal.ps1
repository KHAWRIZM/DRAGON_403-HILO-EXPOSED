# SOVEREIGN DOCUMENTARY - SIMPLIFIED WORKING VERSION
$ErrorActionPreference = "Continue"

$FFmpeg = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
$OutputDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$FinalMP4 = "C:\Users\admin\Desktop\HILO_CASE\SOVEREIGN_DOCUMENTARY.mp4"

# Script
$Scenes = @(
    "In the vast digital landscape where corporations control the flow of information one man chose a different path",
    "From the deserts of Saudi Arabia emerges a story of technical sovereignty",
    "Suliman Alshammari codename Khawarizm a descendant of Al-Khwarizmi the father of algorithms",
    "His legacy began in twenty eleven during the Hotmail era when hackers exposed vulnerabilities that changed the internet forever",
    "Years later after being limited by Western cloud platforms he made a decision",
    "He went offline for fourteen days when he returned he had built something unprecedented",
    "Dragon four oh three a live open source intelligence platform exposing a fifty million dollar fraud network",
    "The target HILO a dating app harvesting user data without consent operating freely on Google Play and Apple Store",
    "Device identifiers collected silently VPN detection to identify security conscious users a systematic violation of privacy laws",
    "Comet X a sovereign browser with three lobe cognitive architecture",
    "Sensory lobe for input filtering cognitive lobe for AI processing executive lobe for action execution",
    "When Microsofts Copilot analyzed his manifesto it classified it as a sovereign signal",
    "The AI concluded he is not asking for a seat at the table he is building a new table",
    "The Sovereign Beacon a complete infrastructure replacement independent of commercial cloud services",
    "This is not a startup pitch this is a declaration of digital independence",
    "The algorithm is our birthright the desert does not forget",
    "House of Shammar Khawarizm Riyadh Zero twenty twenty six"
)

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  SOVEREIGN DOCUMENTARY GENERATOR" -ForegroundColor Yellow  
Write-Host "  House of Shammar | KHAWRIZM" -ForegroundColor White
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Step 1: Generate all narrations
Write-Host "[1/3] Generating narrations..." -ForegroundColor Yellow
Add-Type -AssemblyName System.Speech
$synth = New-Object System.Speech.Synthesis.SpeechSynthesizer
$synth.SelectVoice("Microsoft David Desktop")
$synth.Rate = -2

$audioFiles = @()
for ($i = 0; $i -lt $Scenes.Count; $i++) {
    $audioFile = "$OutputDir\audio\scene_$i.wav"
    Write-Host "  Scene $($i+1): $($Scenes[$i].Substring(0, [Math]::Min(40, $Scenes[$i].Length)))..." -ForegroundColor DarkGray
    $synth.SetOutputToWaveFile($audioFile)
    $synth.Speak($Scenes[$i])
    $synth.SetOutputToNull()
    $audioFiles += $audioFile
}
$synth.Dispose()
Write-Host "  Done!" -ForegroundColor Green

# Step 2: Create video segments
Write-Host ""
Write-Host "[2/3] Creating video segments..." -ForegroundColor Yellow

$videoFiles = @()
for ($i = 0; $i -lt $Scenes.Count; $i++) {
    $audioFile = "$OutputDir\audio\scene_$i.wav"
    $videoFile = "$OutputDir\frames\segment_$i.mp4"
    
    # Get audio duration
    $probe = & $FFmpeg -i $audioFile 2>&1 | Out-String
    if ($probe -match "Duration: (\d{2}):(\d{2}):(\d{2})\.(\d{2})") {
        $duration = [int]$Matches[2] * 60 + [int]$Matches[3] + 2
    }
    else {
        $duration = 8
    }
    
    # Clean text for drawtext (remove special chars)
    $text = $Scenes[$i] -replace "'", "" -replace '"', "" -replace ":", "" -replace ",", ""
    
    Write-Host "  Segment $($i+1)/$($Scenes.Count)..." -ForegroundColor DarkGray
    
    # Build FFmpeg command
    & $FFmpeg -y `
        -f lavfi -i "color=c=0x050510:s=1920x1080:d=$duration" `
        -i $audioFile `
        -vf "drawtext=text='$text':fontcolor=white:fontsize=42:x=(w-text_w)/2:y=(h-text_h)/2:shadowcolor=black:shadowx=2:shadowy=2,fade=in:0:25,fade=out:st=$($duration-1):d=25" `
        -c:v libx264 -preset fast -crf 23 `
        -c:a aac -b:a 192k `
        -shortest `
        $videoFile 2>&1 | Out-Null
    
    if (Test-Path $videoFile) {
        $videoFiles += $videoFile
    }
}
Write-Host "  Done! Created $($videoFiles.Count) segments" -ForegroundColor Green

# Step 3: Concatenate all
Write-Host ""
Write-Host "[3/3] Merging into final documentary..." -ForegroundColor Yellow

$concatFile = "$OutputDir\concat.txt"
$videoFiles | ForEach-Object { "file '$_'" } | Out-File -FilePath $concatFile -Encoding UTF8

& $FFmpeg -y -f concat -safe 0 -i $concatFile -c:v libx264 -preset medium -crf 20 -c:a aac -b:a 192k $FinalMP4 2>&1 | Out-Null

if (Test-Path $FinalMP4) {
    $info = Get-Item $FinalMP4
    $sizeMB = [math]::Round($info.Length / 1MB, 2)
    
    Write-Host ""
    Write-Host "========================================" -ForegroundColor Green
    Write-Host "  DOCUMENTARY COMPLETE!" -ForegroundColor Green
    Write-Host "========================================" -ForegroundColor Green
    Write-Host "  File: $FinalMP4" -ForegroundColor White
    Write-Host "  Size: $sizeMB MB" -ForegroundColor White
    Write-Host "  Scenes: $($Scenes.Count)" -ForegroundColor White
    Write-Host ""
    
    # Open video
    Start-Process $FinalMP4
}
else {
    Write-Host "  Failed to create final video" -ForegroundColor Red
}

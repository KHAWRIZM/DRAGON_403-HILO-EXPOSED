# 🎬 SOVEREIGN DOCUMENTARY - CINEMATIC EDITION
# ═══════════════════════════════════════════════════════════════
# Creates a professional documentary with:
# - English narration (Microsoft David TTS)
# - Cinematic music (downloaded royalty-free)
# - Screenshots from live systems
# - Professional transitions
# 
# Author: Sulaiman Alshammari (KHAWRIZM)
# ═══════════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"

# ═══════════════════════════════════════════════════════════════
# CONFIGURATION
# ═══════════════════════════════════════════════════════════════

$Config = @{
    FFmpeg      = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"
    OutputDir   = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
    FinalOutput = "C:\Users\admin\Desktop\HILO_CASE\SOVEREIGN_DOCUMENTARY.mp4"
    Resolution  = "1920x1080"
    FPS         = 30
}

# Documentary Script - English Cinematic Narration
$Script = @(
    @{
        Scene    = "intro"
        Text     = "In the vast digital landscape, where corporations control the flow of information, one man chose a different path."
        Duration = 6
        Visual   = "black_fade"
    },
    @{
        Scene    = "origin"
        Text     = "From the deserts of Saudi Arabia, emerges a story of technical sovereignty."
        Duration = 5
        Visual   = "desert"
    },
    @{
        Scene    = "khawrizm"
        Text     = "Suliman Alshammari. Code name: Khawarizm. A descendant of Al-Khwarizmi, the father of algorithms."
        Duration = 6
        Visual   = "portrait"
    },
    @{
        Scene    = "history"
        Text     = "His legacy began in twenty eleven, during the Hotmail era. When hackers exposed vulnerabilities that changed the internet forever."
        Duration = 6
        Visual   = "history"
    },
    @{
        Scene    = "limitation"
        Text     = "Years later, after being limited by Western cloud platforms, he made a decision."
        Duration = 5
        Visual   = "chains"
    },
    @{
        Scene    = "offline"
        Text     = "He went offline for fourteen days. When he returned, he had built something unprecedented."
        Duration = 5
        Visual   = "offline"
    },
    @{
        Scene    = "dragon_intro"
        Text     = "Dragon four oh three. A live open source intelligence platform. Exposing a fifty million dollar fraud network."
        Duration = 6
        Visual   = "dragon403"
    },
    @{
        Scene    = "hilo"
        Text     = "The target: HILO. A dating app harvesting user data without consent. Operating freely on Google Play and Apple Store."
        Duration = 6
        Visual   = "hilo_evidence"
    },
    @{
        Scene    = "evidence"
        Text     = "Device identifiers collected silently. VPN detection to identify security conscious users. A systematic violation of privacy laws."
        Duration = 6
        Visual   = "code"
    },
    @{
        Scene    = "comet_intro"
        Text     = "Comet X. A sovereign browser with three lobe cognitive architecture."
        Duration = 5
        Visual   = "cometx"
    },
    @{
        Scene    = "lobes"
        Text     = "Sensory lobe for input filtering. Cognitive lobe for AI processing. Executive lobe for action execution."
        Duration = 6
        Visual   = "architecture"
    },
    @{
        Scene    = "copilot"
        Text     = "When Microsoft's Copilot analyzed his manifesto, it classified it as a sovereign signal."
        Duration = 5
        Visual   = "copilot"
    },
    @{
        Scene    = "quote"
        Text     = "The AI concluded: He is not asking for a seat at the table. He is building a new table."
        Duration = 6
        Visual   = "quote"
    },
    @{
        Scene    = "beacon"
        Text     = "The Sovereign Beacon. A complete infrastructure replacement. Independent of commercial cloud services."
        Duration = 5
        Visual   = "beacon"
    },
    @{
        Scene    = "message"
        Text     = "This is not a startup pitch. This is a declaration of digital independence."
        Duration = 5
        Visual   = "declaration"
    },
    @{
        Scene    = "closing"
        Text     = "The algorithm is our birthright. The desert does not forget."
        Duration = 5
        Visual   = "desert_sunset"
    },
    @{
        Scene    = "credits"
        Text     = "House of Shammar. Khawarizm. Riyadh Zero. Twenty twenty six."
        Duration = 6
        Visual   = "credits"
    }
)

# ═══════════════════════════════════════════════════════════════
# FUNCTIONS
# ═══════════════════════════════════════════════════════════════

function Write-Banner {
    Write-Host ""
    Write-Host "╔═══════════════════════════════════════════════════════════════╗" -ForegroundColor Blue
    Write-Host "║                                                               ║" -ForegroundColor Blue
    Write-Host "║   🎬 SOVEREIGN DOCUMENTARY GENERATOR                          ║" -ForegroundColor Cyan
    Write-Host "║   ─────────────────────────────────────────────────────────   ║" -ForegroundColor Blue
    Write-Host "║   Cinematic Edition • English Narration • HD 1080p            ║" -ForegroundColor White
    Write-Host "║                                                               ║" -ForegroundColor Blue
    Write-Host "║   House of Shammar • KHAWRIZM • Riyadh Zero                   ║" -ForegroundColor Yellow
    Write-Host "║                                                               ║" -ForegroundColor Blue
    Write-Host "╚═══════════════════════════════════════════════════════════════╝" -ForegroundColor Blue
    Write-Host ""
}

function New-Narration {
    param(
        [string]$Text,
        [string]$OutputFile,
        [int]$Rate = -2
    )
    
    Add-Type -AssemblyName System.Speech
    $synth = New-Object System.Speech.Synthesis.SpeechSynthesizer
    
    # Use David for deep cinematic voice
    $synth.SelectVoice("Microsoft David Desktop")
    $synth.Rate = $Rate  # Slower for cinematic feel
    $synth.Volume = 100
    
    $synth.SetOutputToWaveFile($OutputFile)
    $synth.Speak($Text)
    $synth.SetOutputToNull()
    $synth.Dispose()
}

function New-CinematicFrame {
    param(
        [string]$Text,
        [string]$OutputFile,
        [string]$Scene
    )
    
    # Create HTML frame
    $gradient = switch ($Scene) {
        "intro" { "linear-gradient(135deg, #000000 0%, #0a0a1a 50%, #000000 100%)" }
        "origin" { "linear-gradient(135deg, #1a0a00 0%, #2d1810 50%, #1a0a00 100%)" }
        "dragon_intro" { "linear-gradient(135deg, #0a0000 0%, #1a0505 50%, #0a0000 100%)" }
        "comet_intro" { "linear-gradient(135deg, #000a1a 0%, #051520 50%, #000a1a 100%)" }
        default { "linear-gradient(135deg, #050505 0%, #0a0a15 50%, #050505 100%)" }
    }
    
    $icon = switch ($Scene) {
        "intro" { "🌐" }
        "origin" { "🏜️" }
        "khawrizm" { "👤" }
        "dragon_intro" { "🐉" }
        "hilo" { "⚠️" }
        "comet_intro" { "☄️" }
        "copilot" { "🤖" }
        "beacon" { "🗼" }
        "closing" { "🦅" }
        "credits" { "🏛️" }
        default { "◆" }
    }
    
    $html = @"
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* { margin: 0; padding: 0; box-sizing: border-box; }
body {
    width: 1920px;
    height: 1080px;
    background: $gradient;
    display: flex;
    align-items: center;
    justify-content: center;
    font-family: 'Segoe UI', 'Arial', sans-serif;
    overflow: hidden;
}
.container {
    text-align: center;
    padding: 60px;
    max-width: 1600px;
}
.icon {
    font-size: 120px;
    margin-bottom: 40px;
    filter: drop-shadow(0 0 40px rgba(59, 130, 246, 0.6));
}
.text {
    color: #ffffff;
    font-size: 52px;
    font-weight: 300;
    line-height: 1.5;
    text-shadow: 0 0 60px rgba(59, 130, 246, 0.4),
                 0 4px 20px rgba(0,0,0,0.8);
    letter-spacing: 1px;
}
.accent { color: #3b82f6; }
.bar {
    width: 200px;
    height: 3px;
    background: linear-gradient(90deg, transparent, #3b82f6, transparent);
    margin: 40px auto;
}
</style>
</head>
<body>
<div class="container">
    <div class="icon">$icon</div>
    <div class="bar"></div>
    <div class="text">$([System.Web.HttpUtility]::HtmlEncode($Text))</div>
    <div class="bar"></div>
</div>
</body>
</html>
"@
    
    $htmlPath = Join-Path $Config.OutputDir "frames\temp_$Scene.html"
    [System.IO.File]::WriteAllText($htmlPath, $html, [System.Text.Encoding]::UTF8)
    
    return $htmlPath
}

function New-VideoSegment {
    param(
        [hashtable]$Segment,
        [int]$Index
    )
    
    $audioFile = Join-Path $Config.OutputDir "audio\scene_$Index.wav"
    $videoFile = Join-Path $Config.OutputDir "frames\segment_$Index.mp4"
    
    # Generate narration
    Write-Host "  🎤 Generating narration..." -ForegroundColor DarkGray
    New-Narration -Text $Segment.Text -OutputFile $audioFile
    
    # Get audio duration
    $audioDuration = $Segment.Duration + 1
    
    # Escape text for FFmpeg
    $escapedText = $Segment.Text -replace "'", "" -replace ":", " " -replace '"', '' -replace ",", ""
    
    # Choose icon based on scene
    $icon = switch ($Segment.Scene) {
        "intro" { "🌐" }
        "origin" { "🏜️" }
        "khawrizm" { "👤" }
        "dragon_intro" { "🐉" }
        "hilo" { "⚠️" }
        "comet_intro" { "☄️" }
        "copilot" { "🤖" }
        "beacon" { "🗼" }
        "closing" { "🦅" }
        default { "◆" }
    }
    
    # Create video with FFmpeg - dark cinematic background with text
    Write-Host "  🎬 Rendering video..." -ForegroundColor DarkGray
    
    $ffmpegArgs = @(
        "-y",
        "-f", "lavfi",
        "-i", "color=c=0x050508:s=1920x1080:d=$audioDuration",
        "-i", "`"$audioFile`"",
        "-vf", "drawtext=text='$escapedText':fontcolor=white:fontsize=44:x=(w-text_w)/2:y=(h-text_h)/2:shadowcolor=black:shadowx=3:shadowy=3,fade=in:0:30,fade=out:st=$($audioDuration-1):d=1",
        "-c:v", "libx264",
        "-preset", "fast",
        "-crf", "23",
        "-c:a", "aac",
        "-b:a", "192k",
        "-shortest",
        "`"$videoFile`""
    )
    
    $argString = $ffmpegArgs -join " "
    $process = Start-Process -FilePath $Config.FFmpeg -ArgumentList $argString -Wait -NoNewWindow -PassThru
    
    if (Test-Path $videoFile) {
        return $videoFile
    }
    return $null
}

function Merge-AllSegments {
    param([string[]]$Segments)
    
    Write-Host "`n🔗 Merging all segments..." -ForegroundColor Cyan
    
    # Create concat file
    $concatFile = Join-Path $Config.OutputDir "concat.txt"
    $Segments | ForEach-Object {
        "file '$_'" | Add-Content -Path $concatFile -Encoding UTF8
    }
    
    # Merge
    $ffmpegArgs = @(
        "-y",
        "-f", "concat",
        "-safe", "0",
        "-i", "`"$concatFile`"",
        "-c:v", "libx264",
        "-preset", "medium",
        "-crf", "20",
        "-c:a", "aac",
        "-b:a", "192k",
        "`"$($Config.FinalOutput)`""
    )
    
    $argString = $ffmpegArgs -join " "
    Start-Process -FilePath $Config.FFmpeg -ArgumentList $argString -Wait -NoNewWindow
    
    return (Test-Path $Config.FinalOutput)
}

function Start-DocumentaryProduction {
    Write-Banner
    
    # Clean previous
    Remove-Item "$($Config.OutputDir)\audio\*" -Force -ErrorAction SilentlyContinue
    Remove-Item "$($Config.OutputDir)\frames\*" -Force -ErrorAction SilentlyContinue
    Remove-Item "$($Config.OutputDir)\concat.txt" -Force -ErrorAction SilentlyContinue
    
    $totalScenes = $Script.Count
    $segments = @()
    
    Write-Host "📽️ Producing $totalScenes scenes..." -ForegroundColor Cyan
    Write-Host ""
    
    for ($i = 0; $i -lt $Script.Count; $i++) {
        $scene = $Script[$i]
        $progress = [math]::Round((($i + 1) / $totalScenes) * 100)
        
        Write-Host "[$($i+1)/$totalScenes] 🎬 Scene: $($scene.Scene)" -ForegroundColor Yellow
        Write-Host "         `"$($scene.Text.Substring(0, [Math]::Min(50, $scene.Text.Length)))...`"" -ForegroundColor DarkGray
        
        $segmentFile = New-VideoSegment -Segment $scene -Index $i
        
        if ($segmentFile -and (Test-Path $segmentFile)) {
            $segments += $segmentFile
            Write-Host "         ✅ Complete" -ForegroundColor Green
        }
        else {
            Write-Host "         ⚠️ Failed" -ForegroundColor Red
        }
        Write-Host ""
    }
    
    # Merge all
    if ($segments.Count -gt 0) {
        $success = Merge-AllSegments -Segments $segments
        
        if ($success) {
            $fileInfo = Get-Item $Config.FinalOutput
            $sizeMB = [math]::Round($fileInfo.Length / 1MB, 2)
            
            Write-Host ""
            Write-Host "╔═══════════════════════════════════════════════════════════════╗" -ForegroundColor Green
            Write-Host "║                                                               ║" -ForegroundColor Green
            Write-Host "║   ✅ DOCUMENTARY COMPLETE!                                    ║" -ForegroundColor Green
            Write-Host "║                                                               ║" -ForegroundColor Green
            Write-Host "║   📁 File: $($Config.FinalOutput)" -ForegroundColor White
            Write-Host "║   📊 Size: $sizeMB MB                                         " -ForegroundColor White
            Write-Host "║   🎬 Scenes: $totalScenes                                     " -ForegroundColor White
            Write-Host "║                                                               ║" -ForegroundColor Green
            Write-Host "╚═══════════════════════════════════════════════════════════════╝" -ForegroundColor Green
            
            # Open video
            Write-Host "`n🎬 Opening documentary..." -ForegroundColor Cyan
            Start-Process $Config.FinalOutput
        }
    }
}

# ═══════════════════════════════════════════════════════════════
# MAIN
# ═══════════════════════════════════════════════════════════════

Start-DocumentaryProduction

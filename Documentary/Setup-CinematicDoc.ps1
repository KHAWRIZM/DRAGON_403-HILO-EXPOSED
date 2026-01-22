# 🐉 DRAGON 403 - CINEMATIC DOCUMENTARY BUILDER
# Uses FREE stock videos + Epic effects
# ═══════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"

Write-Host @"

╔═══════════════════════════════════════════════════════════════════════════╗
║     ██████╗ ██████╗  █████╗  ██████╗  ██████╗ ███╗   ██╗    ██╗  ██╗ ██████╗ ██████╗  ║
║     ██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔═══██╗████╗  ██║    ██║  ██║██╔═══██╗╚════██╗ ║
║     ██║  ██║██████╔╝███████║██║  ███╗██║   ██║██╔██╗ ██║    ███████║██║   ██║ █████╔╝ ║
║     ██║  ██║██╔══██╗██╔══██║██║   ██║██║   ██║██║╚██╗██║    ╚════██║██║   ██║ ╚═══██╗ ║
║     ██████╔╝██║  ██║██║  ██║╚██████╔╝╚██████╔╝██║ ╚████║         ██║╚██████╔╝██████╔╝ ║
║     ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝         ╚═╝ ╚═════╝ ╚═════╝  ║
║                                                                                         ║
║                    🐉 CINEMATIC DOCUMENTARY BUILDER 🐉                                  ║
║                         THE FORBIDDEN'S KILLER                                          ║
╚═══════════════════════════════════════════════════════════════════════════════════════╝

"@ -ForegroundColor Red

$docDir = "C:\Users\admin\Desktop\HILO_CASE\Documentary"
$stockDir = "$docDir\stock_videos"
$outputDir = "$docDir\cinematic_output"
$FFmpeg = "C:\Users\admin\AppData\Local\Microsoft\WinGet\Packages\Gyan.FFmpeg_Microsoft.Winget.Source_8wekyb3d8bbwe\ffmpeg-8.0.1-full_build\bin\ffmpeg.exe"

New-Item -ItemType Directory -Path $stockDir -Force | Out-Null
New-Item -ItemType Directory -Path $outputDir -Force | Out-Null

Write-Host "═══════════════════════════════════════════════════════════════" -ForegroundColor DarkGray
Write-Host ""
Write-Host "  🎬 لإنشاء فيلم وثائقي أسطوري، اختر أحد الخيارات:" -ForegroundColor Cyan
Write-Host ""
Write-Host "  [1] 🤖 AI Video Generation (الأفضل - Runway/Pika)" -ForegroundColor Yellow
Write-Host "      → افتح الملف: CINEMATIC_PROMPTS.md"
Write-Host "      → انسخ الـ Prompts إلى Runway أو Pika"
Write-Host "      → احفظ الفيديوهات في: $stockDir"
Write-Host ""
Write-Host "  [2] 📥 Download Stock Videos (مجاني)" -ForegroundColor Yellow
Write-Host "      → سأفتح لك مواقع فيديوهات مجانية"
Write-Host "      → حمّل فيديوهات مناسبة لكل مشهد"
Write-Host "      → احفظها بأسماء: scene_01.mp4, scene_02.mp4, etc."
Write-Host ""
Write-Host "  [3] 🎵 Download Epic Music (مجاني)" -ForegroundColor Yellow
Write-Host "      → سأفتح لك مواقع موسيقى ملحمية مجانية"
Write-Host ""
Write-Host "═══════════════════════════════════════════════════════════════" -ForegroundColor DarkGray
Write-Host ""

$choice = Read-Host "اختر الخيار (1/2/3)"

switch ($choice) {
    "1" {
        Write-Host "`n🤖 فتح أدوات AI Video Generation..." -ForegroundColor Green
        Start-Process "https://runwayml.com"
        Start-Process "https://pika.art"
        Start-Process "$docDir\CINEMATIC_PROMPTS.md"
        Write-Host @"

✅ تم فتح:
   - Runway ML (أفضل جودة)
   - Pika Labs (مجاني)
   - ملف الـ Prompts

📋 الخطوات:
   1. سجّل في Runway أو Pika
   2. انسخ كل Prompt من الملف
   3. اصنع فيديو 5 ثواني لكل مشهد
   4. حمّل الفيديوهات إلى: $stockDir
   5. سمّ الملفات: scene_01.mp4, scene_02.mp4, etc.
   6. شغّل هذا السكربت مرة أخرى واختر "4" للدمج

"@ -ForegroundColor Cyan
    }
    "2" {
        Write-Host "`n📥 فتح مواقع Stock Videos المجانية..." -ForegroundColor Green
        Start-Process "https://www.pexels.com/search/videos/cyberpunk/"
        Start-Process "https://www.pexels.com/search/videos/hacker/"
        Start-Process "https://www.pexels.com/search/videos/technology/"
        Start-Process "https://pixabay.com/videos/search/cyber/"
        Write-Host @"

✅ تم فتح:
   - Pexels (أفضل جودة)
   - Pixabay (متنوع)

📋 ابحث عن:
   - cyberpunk, hacker, technology, code
   - desert, saudi, middle east
   - corporate, office, dramatic
   - fire, dragon, epic

💾 احفظ الفيديوهات في: $stockDir

"@ -ForegroundColor Cyan
    }
    "3" {
        Write-Host "`n🎵 فتح مواقع Epic Music المجانية..." -ForegroundColor Green
        Start-Process "https://pixabay.com/music/search/epic%20cinematic/"
        Start-Process "https://www.youtube.com/results?search_query=epic+cinematic+music+no+copyright"
        Write-Host @"

✅ تم فتح:
   - Pixabay Music (مجاني 100%)
   - YouTube (No Copyright)

📋 ابحث عن:
   - Epic Cinematic
   - War Drums
   - Hans Zimmer Style
   - Trailer Music

💾 احفظ الموسيقى في: $docDir\music\epic_soundtrack.mp3

"@ -ForegroundColor Cyan
    }
    default {
        Write-Host "`n⚠️ خيار غير صالح" -ForegroundColor Yellow
    }
}

Write-Host @"

═══════════════════════════════════════════════════════════════
📁 المجلدات:
   - Stock Videos: $stockDir
   - Music: $docDir\music
   - Output: $outputDir
═══════════════════════════════════════════════════════════════

🐉 بعد تجهيز الفيديوهات والموسيقى، شغّل:
   .\Merge-CinematicFilm.ps1

"@ -ForegroundColor DarkGray

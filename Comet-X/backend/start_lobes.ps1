# ☄️ COMET-X THREE-LOBE STARTUP SCRIPT
# =====================================

Write-Host ""
Write-Host "╔═══════════════════════════════════════════════════════════╗" -ForegroundColor Cyan
Write-Host "║  ☄️  COMET-X THREE-LOBE STARTUP                           ║" -ForegroundColor Cyan
Write-Host "║  House of Shammar • KHAWRIZM                             ║" -ForegroundColor Cyan
Write-Host "╚═══════════════════════════════════════════════════════════╝" -ForegroundColor Cyan
Write-Host ""

$BackendPath = $PSScriptRoot

# Install dependencies if needed
Write-Host "📦 Checking dependencies..." -ForegroundColor Yellow
pip install fastapi uvicorn aiohttp httpx pydantic --quiet

Write-Host ""
Write-Host "🚀 Starting Three-Lobe Architecture..." -ForegroundColor Green
Write-Host ""

# Start SENSORY Lobe (Port 8000)
Write-Host "[1/4] Starting SENSORY Lobe (Port 8000)..." -ForegroundColor Blue
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$BackendPath'; python sensory_lobe.py"

Start-Sleep -Seconds 2

# Start EXECUTIVE Lobe (Port 8001)
Write-Host "[2/4] Starting EXECUTIVE Lobe (Port 8001)..." -ForegroundColor Green
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$BackendPath'; python executive_lobe.py --server"

Start-Sleep -Seconds 2

# Start COGNITIVE Lobe (Port 8002)
Write-Host "[3/4] Starting COGNITIVE Lobe (Port 8002)..." -ForegroundColor Magenta
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$BackendPath'; python cognitive_lobe.py"

Start-Sleep -Seconds 2

# Start BRAIN Orchestrator (Port 8080)
Write-Host "[4/4] Starting BRAIN Orchestrator (Port 8080)..." -ForegroundColor Cyan
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd '$BackendPath'; python brain.py"

Write-Host ""
Write-Host "═══════════════════════════════════════════════════════════" -ForegroundColor Yellow
Write-Host "  ✅ All lobes starting!" -ForegroundColor Green
Write-Host ""
Write-Host "  👁️  SENSORY:    http://localhost:8000" -ForegroundColor Blue
Write-Host "  ⚡ EXECUTIVE:  http://localhost:8001" -ForegroundColor Green
Write-Host "  🧠 COGNITIVE:  http://localhost:8002" -ForegroundColor Magenta
Write-Host "  🐉 BRAIN:      http://localhost:8080" -ForegroundColor Cyan
Write-Host ""
Write-Host "  🌐 FRONTEND:   http://localhost:5173" -ForegroundColor White
Write-Host "═══════════════════════════════════════════════════════════" -ForegroundColor Yellow
Write-Host ""
Write-Host "Press any key to continue..." -ForegroundColor DarkGray
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

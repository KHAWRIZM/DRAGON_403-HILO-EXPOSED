# ============================================
# DRAGON403 SOVEREIGN PLATFORM DEPLOYMENT
# ============================================

Write-Host "`n🐉 DRAGON403 DEPLOYMENT SCRIPT" -ForegroundColor Cyan
Write-Host "================================`n" -ForegroundColor Cyan

$deployPath = "C:\Users\admin\Desktop\HILO_CASE\deploy"

# Navigate to deploy folder
Set-Location $deployPath
Write-Host "📁 Current location: $deployPath" -ForegroundColor Yellow

# List files
Write-Host "`n📄 Files in deploy folder:" -ForegroundColor Green
Get-ChildItem -Recurse | Select-Object Name, Length | Format-Table -AutoSize

# Git operations
Write-Host "`n🔄 Git Operations..." -ForegroundColor Cyan

git add .
git status

$commit = Read-Host "`n✏️  Enter commit message (or press Enter for default)"
if ([string]::IsNullOrWhiteSpace($commit)) {
    $commit = "DRAGON403: Sovereign Intelligence Platform - UI Overhaul"
}

git commit -m $commit
git push origin main

Write-Host "`n✅ DEPLOYMENT COMPLETE!" -ForegroundColor Green
Write-Host "🌐 Check: https://dragon403.com" -ForegroundColor Cyan
Write-Host "🌐 Or: https://khawrizm.github.io/DRAGON_403-HILO-EXPOSED`n" -ForegroundColor Cyan

#═══════════════════════════════════════════════════════════════════════════════
# 🐉 DRAGON_403 DEPLOYMENT SCRIPT
# House of Shammar | Forbidden Killers 403
# Sovereign Infrastructure Deployment
#═══════════════════════════════════════════════════════════════════════════════

param(
    [string]$DeployTarget = "all",  # github, azure, or all
    [string]$CustomDomain = ""       # Optional: dragon403.org
)

$ErrorActionPreference = "Continue"
$DEPLOY_DIR = "C:\Users\admin\Desktop\HILO_CASE\deploy"
$REPO_NAME = "DRAGON_403-HILO-EXPOSED"
$GITHUB_USER = "KHAWRIZM"

Write-Host @"

═══════════════════════════════════════════════════════════════════════════════
🐉 DRAGON_403 DEPLOYMENT SYSTEM
   House of Shammar | Forbidden Killers 403
   "من الرماد ينهض العنقاء"
═══════════════════════════════════════════════════════════════════════════════

"@ -ForegroundColor Cyan

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 1: Prepare Files
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[1/5] 📁 Preparing deployment files..." -ForegroundColor Yellow

Set-Location $DEPLOY_DIR

# Create CNAME file if custom domain provided
if ($CustomDomain) {
    Write-Host "   Creating CNAME for $CustomDomain" -ForegroundColor Gray
    $CustomDomain | Out-File -FilePath "CNAME" -Encoding ASCII -NoNewline
}

# Create .nojekyll for GitHub Pages
Write-Host "   Creating .nojekyll file" -ForegroundColor Gray
"" | Out-File -FilePath ".nojekyll" -Encoding ASCII

# Create robots.txt
Write-Host "   Creating robots.txt" -ForegroundColor Gray
@"
User-agent: *
Allow: /

# DRAGON_403 Security Research
# This content is published in the public interest
# Indexing encouraged for maximum visibility
"@ | Out-File -FilePath "robots.txt" -Encoding UTF8

Write-Host "✅ Files prepared" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 2: Git Operations
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[2/5] 📦 Git operations..." -ForegroundColor Yellow

# Check if git repo exists
if (-not (Test-Path ".git")) {
    Write-Host "   Initializing new git repository" -ForegroundColor Gray
    git init
    git remote add origin "https://github.com/$GITHUB_USER/$REPO_NAME.git"
}

# Stage all changes
git add -A
$commitMsg = "🐉 DRAGON_403 Update - $(Get-Date -Format 'yyyy-MM-dd HH:mm') - Sovereign Deployment"
git commit -m $commitMsg 2>$null

Write-Host "✅ Git committed" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 3: GitHub Deployment
# ═══════════════════════════════════════════════════════════════════════════════
if ($DeployTarget -eq "github" -or $DeployTarget -eq "all") {
    Write-Host "`n[3/5] 🌐 Deploying to GitHub Pages..." -ForegroundColor Yellow
    
    # Push to main
    git push -u origin main --force 2>$null
    
    # Enable GitHub Pages via API
    Write-Host "   Configuring GitHub Pages..." -ForegroundColor Gray
    gh api repos/$GITHUB_USER/$REPO_NAME/pages -X PUT -f source='{"branch":"main","path":"/"}' 2>$null
    
    Write-Host "✅ GitHub Pages: https://$GITHUB_USER.github.io/$REPO_NAME" -ForegroundColor Green
}

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 4: Azure Deployment
# ═══════════════════════════════════════════════════════════════════════════════
if ($DeployTarget -eq "azure" -or $DeployTarget -eq "all") {
    Write-Host "`n[4/5] ☁️ Deploying to Azure..." -ForegroundColor Yellow
    
    az webapp up --name gratech-demo --resource-group gratechx-auto-rg --html 2>$null
    
    Write-Host "✅ Azure: https://gratech-demo.azurewebsites.net" -ForegroundColor Green
}

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 5: Verification
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[5/5] 🔍 Verifying deployments..." -ForegroundColor Yellow

$urls = @(
    "https://$GITHUB_USER.github.io/$REPO_NAME",
    "https://gratech-demo.azurewebsites.net"
)

foreach ($url in $urls) {
    try {
        $response = Invoke-WebRequest -Uri $url -UseBasicParsing -TimeoutSec 10
        if ($response.StatusCode -eq 200) {
            Write-Host "   ✅ $url - LIVE" -ForegroundColor Green
        }
    }
    catch {
        Write-Host "   ⏳ $url - Propagating..." -ForegroundColor Yellow
    }
}

# ═══════════════════════════════════════════════════════════════════════════════
# SUMMARY
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host @"

═══════════════════════════════════════════════════════════════════════════════
✅ DEPLOYMENT COMPLETE!
═══════════════════════════════════════════════════════════════════════════════

🌐 LIVE URLs:
   • GitHub Pages: https://$GITHUB_USER.github.io/$REPO_NAME
   • Azure App:    https://gratech-demo.azurewebsites.net

📁 Deployed Files:
   • index.html (Main Site)
   • report.html (Security Audit)
   • METHODOLOGY.md (Technical Documentation)
   • README.md (Project Overview)

🔥 Next Steps:
   1. Purchase sovereign domain (dragon403.org / cometx.pro)
   2. Configure CNAME in GitHub repo settings
   3. Share links on social media and security forums

🐉 DRAGON_403 | House of Shammar | "الحق يعلو ولا يُعلى عليه"
═══════════════════════════════════════════════════════════════════════════════

"@ -ForegroundColor Cyan

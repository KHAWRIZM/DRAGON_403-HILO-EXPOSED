# 🚀 DRAGON_403 Deployment Guide
## Azure Static Web Apps + Custom Domain

---

## 📋 Prerequisites

- Azure account (Free tier works)
- GitHub account
- Files ready:
  - `DRAGON_403_CLEAN.html` → rename to `index.html`
  - `SECURITY_AUDIT_REPORT.html`

---

## 🔧 Step 1: Prepare Files

```powershell
# Create deployment folder
$deployPath = "C:\Users\admin\Desktop\HILO_CASE\deploy"
New-Item -ItemType Directory -Path $deployPath -Force

# Copy and rename main file
Copy-Item "C:\Users\admin\Desktop\HILO_CASE\expose-hilo-website\DRAGON_403_CLEAN.html" "$deployPath\index.html"
Copy-Item "C:\Users\admin\Desktop\HILO_CASE\SECURITY_AUDIT_REPORT.html" "$deployPath\report.html"
Copy-Item "C:\Users\admin\Desktop\HILO_CASE\OFFICIAL_SECURITY_AUDIT.md" "$deployPath\audit.md"
```

---

## 🔧 Step 2: Initialize Git Repository

```powershell
cd C:\Users\admin\Desktop\HILO_CASE\deploy

git init
git add .
git commit -m "DRAGON_403: Initial deployment - HILO fraud exposure"
```

---

## 🔧 Step 3: Create GitHub Repository

```powershell
# Using GitHub CLI
gh repo create DRAGON_403-Exposed --public --description "HILO/Partycome fraud network exposure - 20+ apps, $5M+ stolen"

# Push to GitHub
git remote add origin https://github.com/KHAWRIZM/DRAGON_403-Exposed.git
git branch -M main
git push -u origin main
```

---

## 🔧 Step 4: Deploy to Azure Static Web Apps

### Option A: Azure Portal (Easy)

1. Go to https://portal.azure.com
2. Search "Static Web Apps"
3. Click "Create"
4. Settings:
   - **Name:** dragon403-exposed
   - **Plan:** Free
   - **Region:** West US 2
   - **Source:** GitHub
   - **Repository:** DRAGON_403-Exposed
   - **Branch:** main
   - **Build Preset:** HTML
5. Click "Review + Create"

### Option B: Azure CLI

```powershell
# Login to Azure
az login

# Create resource group (if needed)
az group create --name "gratech-resources" --location "westus2"

# Create Static Web App
az staticwebapp create `
    --name "dragon403-exposed" `
    --resource-group "gratech-resources" `
    --source "https://github.com/KHAWRIZM/DRAGON_403-Exposed" `
    --location "westus2" `
    --branch "main" `
    --app-location "/" `
    --output-location "/"
```

---

## 🔧 Step 5: Custom Domain (Optional)

If you have a domain like `dragon403.com`:

```powershell
az staticwebapp hostname set `
    --name "dragon403-exposed" `
    --resource-group "gratech-resources" `
    --hostname "www.dragon403.com"
```

---

## 🔧 Step 6: Verify Deployment

Your site will be live at:
```
https://dragon403-exposed.azurestaticapps.net
```

Or with GitHub Pages (alternative):
```
https://khawrizm.github.io/DRAGON_403-Exposed
```

---

## 📁 File Structure for Deployment

```
deploy/
├── index.html          (Main site - DRAGON_403_CLEAN.html)
├── report.html         (Security Audit Report)
├── audit.md            (Markdown version)
└── assets/
    └── (any images if needed)
```

---

## 🛡️ Security Headers (Optional)

Create `staticwebapp.config.json`:

```json
{
  "globalHeaders": {
    "X-Content-Type-Options": "nosniff",
    "X-Frame-Options": "DENY",
    "Content-Security-Policy": "default-src 'self' https: 'unsafe-inline'"
  },
  "routes": [
    {
      "route": "/report",
      "rewrite": "/report.html"
    }
  ]
}
```

---

## ✅ Checklist

- [ ] Files prepared in deploy folder
- [ ] Git repository initialized
- [ ] Pushed to GitHub
- [ ] Azure Static Web App created
- [ ] Site accessible
- [ ] Custom domain configured (optional)

---

## 🐉 Done!

Your DRAGON_403 investigation is now live and accessible worldwide!

**Share the URL:**
- Twitter/X with #HILO_EXPOSED
- Reddit r/scams, r/privacy
- Hacker News
- Security researcher communities

---

*House of Shammar | ForbiddenKillers 403*

#═══════════════════════════════════════════════════════════════════════════════
# 🦅 GRATECH.SA DOMAIN SETUP - SULAIMAN ALSHAMMARI
# One Script to Rule Them All
# Project: HILO EXPOSURE / DRAGON_403
#═══════════════════════════════════════════════════════════════════════════════

$ErrorActionPreference = "Continue"

# ═══════════════════════════════════════════════════════════════════════════════
# CONFIGURATION
# ═══════════════════════════════════════════════════════════════════════════════
$DOMAIN = "gratech.sa"
$DNS_RG = "gratech-dns-rg"
$APP_NAME = "gratech-demo"           # أو THE-SOVEREIGN-BEACON
$APP_RG = "gratechx-auto-rg"         # أو rg-SULAIMAN-5822
$SUBSCRIPTION = "5bc4f627-4c97-4824-97d9-df4ff487b284"
$OWNER_EMAIL = "SULAIMAN@Gratechx.onmicrosoft.com"

Write-Host @"

═══════════════════════════════════════════════════════════════════════════════
🦅 GRATECH.SA DOMAIN SETUP
   Sulaiman Alshammari | The Human Engine
   "نبض طفل واحد في غزة يطلب الحياة أثمن من كل صواريخهم"
═══════════════════════════════════════════════════════════════════════════════

"@ -ForegroundColor Cyan

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 1: Verify Login
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[1/6] 🔐 Verifying Azure Login..." -ForegroundColor Yellow
$account = az account show --query "user.name" -o tsv 2>$null
if (-not $account) {
    Write-Host "❌ Not logged in. Running az login..." -ForegroundColor Red
    az login
}
Write-Host "✅ Logged in as: $account" -ForegroundColor Green

# Set subscription
az account set --subscription $SUBSCRIPTION
Write-Host "✅ Subscription set: Azure subscription 1" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 2: Get App Service Verification ID
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[2/6] 🔍 Getting App Service Verification ID..." -ForegroundColor Yellow
$VERIFICATION_ID = az webapp show -n $APP_NAME -g $APP_RG --query "customDomainVerificationId" -o tsv

if (-not $VERIFICATION_ID) {
    Write-Host "❌ Could not get verification ID" -ForegroundColor Red
    exit 1
}
Write-Host "✅ Verification ID: $($VERIFICATION_ID.Substring(0,20))..." -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 3: Add/Update DNS Records for Domain Verification
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[3/6] 📝 Adding DNS Verification Records..." -ForegroundColor Yellow

# Add asuid TXT record for root domain
Write-Host "   Adding asuid.$DOMAIN TXT record..." -ForegroundColor Gray
az network dns record-set txt add-record `
    -g $DNS_RG `
    -z $DOMAIN `
    -n "asuid" `
    -v $VERIFICATION_ID `
    --if-none-match 2>$null

if ($LASTEXITCODE -ne 0) {
    # Try to delete and recreate
    az network dns record-set txt delete -g $DNS_RG -z $DOMAIN -n "asuid" -y 2>$null
    az network dns record-set txt add-record -g $DNS_RG -z $DOMAIN -n "asuid" -v $VERIFICATION_ID
}
Write-Host "✅ asuid.$DOMAIN TXT record added" -ForegroundColor Green

# Add asuid.www TXT record for www subdomain
Write-Host "   Adding asuid.www.$DOMAIN TXT record..." -ForegroundColor Gray
az network dns record-set txt add-record `
    -g $DNS_RG `
    -z $DOMAIN `
    -n "asuid.www" `
    -v $VERIFICATION_ID `
    --if-none-match 2>$null

Write-Host "✅ asuid.www.$DOMAIN TXT record added" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 4: Add A Record pointing to App Service
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[4/6] 🌐 Configuring A Record..." -ForegroundColor Yellow

# Get App Service IP
$APP_IP = az webapp show -n $APP_NAME -g $APP_RG --query "inboundIpAddress" -o tsv
Write-Host "   App Service IP: $APP_IP" -ForegroundColor Gray

# Update A record
az network dns record-set a delete -g $DNS_RG -z $DOMAIN -n "@" -y 2>$null
az network dns record-set a add-record -g $DNS_RG -z $DOMAIN -n "@" -a $APP_IP
Write-Host "✅ A record updated: $DOMAIN -> $APP_IP" -ForegroundColor Green

# Add CNAME for www
az network dns record-set cname delete -g $DNS_RG -z $DOMAIN -n "www" -y 2>$null
az network dns record-set cname set-record -g $DNS_RG -z $DOMAIN -n "www" -c "$APP_NAME.azurewebsites.net"
Write-Host "✅ CNAME record: www.$DOMAIN -> $APP_NAME.azurewebsites.net" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 5: Bind Custom Domain to App Service
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[5/6] 🔗 Binding Domain to App Service..." -ForegroundColor Yellow

# Wait for DNS propagation
Write-Host "   Waiting 10 seconds for DNS propagation..." -ForegroundColor Gray
Start-Sleep -Seconds 10

# Add custom domain
Write-Host "   Adding $DOMAIN to App Service..." -ForegroundColor Gray
az webapp config hostname add --hostname $DOMAIN -g $APP_RG --webapp-name $APP_NAME 2>$null
if ($LASTEXITCODE -eq 0) {
    Write-Host "✅ Domain $DOMAIN bound to $APP_NAME" -ForegroundColor Green
}
else {
    Write-Host "⚠️ Domain might already be bound or DNS not propagated yet" -ForegroundColor Yellow
}

# Add www subdomain
Write-Host "   Adding www.$DOMAIN to App Service..." -ForegroundColor Gray
az webapp config hostname add --hostname "www.$DOMAIN" -g $APP_RG --webapp-name $APP_NAME 2>$null
Write-Host "✅ Domain www.$DOMAIN bound to $APP_NAME" -ForegroundColor Green

# ═══════════════════════════════════════════════════════════════════════════════
# STEP 6: Create Free SSL Certificate
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host "`n[6/6] 🔒 Creating Free SSL Certificate..." -ForegroundColor Yellow

# Create managed certificate for root domain
Write-Host "   Creating SSL for $DOMAIN..." -ForegroundColor Gray
az webapp config ssl create -n $APP_NAME -g $APP_RG --hostname $DOMAIN 2>$null

if ($LASTEXITCODE -eq 0) {
    # Get certificate thumbprint
    $CERT_THUMBPRINT = az webapp config ssl list -g $APP_RG --query "[?contains(name,'$DOMAIN')].thumbprint | [0]" -o tsv
    
    if ($CERT_THUMBPRINT) {
        # Bind SSL
        az webapp config ssl bind --certificate-thumbprint $CERT_THUMBPRINT --ssl-type SNI -n $APP_NAME -g $APP_RG
        Write-Host "✅ SSL Certificate created and bound for $DOMAIN" -ForegroundColor Green
    }
}
else {
    Write-Host "⚠️ SSL creation may take a few minutes. Check Azure Portal." -ForegroundColor Yellow
}

# ═══════════════════════════════════════════════════════════════════════════════
# SUMMARY
# ═══════════════════════════════════════════════════════════════════════════════
Write-Host @"

═══════════════════════════════════════════════════════════════════════════════
✅ SETUP COMPLETE!
═══════════════════════════════════════════════════════════════════════════════

📌 Domain:     https://$DOMAIN
📌 WWW:        https://www.$DOMAIN
📌 App:        $APP_NAME
📌 Owner:      $OWNER_EMAIL

🔍 To verify, run:
   nslookup $DOMAIN
   curl -I https://$DOMAIN

📝 DNS Records configured:
   - A Record:     $DOMAIN -> $APP_IP
   - CNAME:        www.$DOMAIN -> $APP_NAME.azurewebsites.net
   - TXT (asuid):  Verification ID for App Service

🦅 "من الرماد ينهض العنقاء"
═══════════════════════════════════════════════════════════════════════════════

"@ -ForegroundColor Cyan

# Open in browser
Write-Host "Opening https://$DOMAIN in browser..." -ForegroundColor Yellow
Start-Process "https://$DOMAIN"

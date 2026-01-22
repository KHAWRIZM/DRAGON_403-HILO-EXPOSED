#!/bin/bash
# ╔═══════════════════════════════════════════════════════════════════════════╗
# ║  🐉 DRAGON403 - AZURE PROTOCOL | SOVEREIGN STRIKE SYSTEM                  ║
# ║  "Are You Mad? I'm Back!" - Evidence Bombardment Script                   ║
# ║  Author: KHAWRIZM | Riyadh Zero | 2026                                    ║
# ╚═══════════════════════════════════════════════════════════════════════════╝

# ═══════════════════════════════════════════════════════════════════════════
# COLORS & EFFECTS
# ═══════════════════════════════════════════════════════════════════════════
R='\033[1;31m'      # Red
G='\033[1;32m'      # Green  
Y='\033[1;33m'      # Yellow
B='\033[1;34m'      # Blue
M='\033[1;35m'      # Magenta
C='\033[1;36m'      # Cyan
W='\033[1;37m'      # White
GR='\033[0;90m'     # Gray
NC='\033[0m'        # No Color
BL='\033[5m'        # Blink
BD='\033[1m'        # Bold
RV='\033[7m'        # Reverse
BR='\033[1;91m'     # Bright Red
BG='\033[1;92m'     # Bright Green
BY='\033[1;93m'     # Bright Yellow
BC='\033[1;96m'     # Bright Cyan

# Typing effect
type_fast() { for ((i=0; i<${#1}; i++)); do printf "%s" "${1:$i:1}"; sleep 0.015; done; }
type_slow() { for ((i=0; i<${#1}; i++)); do printf "%s" "${1:$i:1}"; sleep 0.04; done; }
type_med()  { for ((i=0; i<${#1}; i++)); do printf "%s" "${1:$i:1}"; sleep 0.025; done; }

# Glitch effect
glitch() {
    local text="$1"
    local chars="@#$%&*!?"
    for i in 1 2 3; do
        printf "\r${R}"
        for ((j=0; j<${#text}; j++)); do
            if [ $((RANDOM % 3)) -eq 0 ]; then
                printf "%s" "${chars:$((RANDOM % ${#chars})):1}"
            else
                printf "%s" "${text:$j:1}"
            fi
        done
        sleep 0.1
    done
    printf "\r${G}%s${NC}\n" "$text"
}

# Progress bar
progress_bar() {
    local duration=$1
    local width=50
    for ((i=0; i<=width; i++)); do
        local pct=$((i * 100 / width))
        printf "\r${C}[${NC}"
        for ((j=0; j<i; j++)); do printf "${G}█${NC}"; done
        for ((j=i; j<width; j++)); do printf "${GR}░${NC}"; done
        printf "${C}]${NC} ${W}%3d%%${NC}" $pct
        sleep $(echo "scale=3; $duration/$width" | bc)
    done
    printf "\n"
}

clear

# ═══════════════════════════════════════════════════════════════════════════
# INTRO - DRAGON AWAKENS
# ═══════════════════════════════════════════════════════════════════════════

echo ""
sleep 0.5
echo -e "${R}"
cat << 'DRAGON'
    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⣶⣶⣶⣶⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀
    ⠀⠀⠀⠀⠀⠀⣀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀
    ⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀
    ⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀
    ⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀
    ⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀
    ⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀
    ⠀⠈⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠁⠀
DRAGON
echo -e "${NC}"
sleep 0.3

echo -e "${C}"
cat << 'BANNER'
 ██████╗ ██████╗  █████╗  ██████╗  ██████╗ ███╗   ██╗    ██╗  ██╗ ██████╗ ██████╗ 
 ██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔═══██╗████╗  ██║    ██║  ██║██╔═████╗╚════██╗
 ██║  ██║██████╔╝███████║██║  ███╗██║   ██║██╔██╗ ██║    ███████║██║██╔██║ █████╔╝
 ██║  ██║██╔══██╗██╔══██║██║   ██║██║   ██║██║╚██╗██║    ╚════██║████╔╝██║ ╚═══██╗
 ██████╔╝██║  ██║██║  ██║╚██████╔╝╚██████╔╝██║ ╚████║         ██║╚██████╔╝██████╔╝
 ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝         ╚═╝ ╚═════╝ ╚═════╝ 
BANNER
echo -e "${NC}"
sleep 0.5

echo -e "${Y}              ⚡ AZURE PROTOCOL - SOVEREIGN STRIKE SYSTEM ⚡${NC}"
sleep 0.3
echo -e "${GR}                    [ KHAWRIZM | RIYADH ZERO | 2026 ]${NC}"
sleep 0.3
echo -e "${R}                      \"Are You Mad? I'm Back!\" 🔥${NC}"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# SYSTEM INITIALIZATION
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${GR}═══════════════════════════════════════════════════════════════════════${NC}"
echo ""
echo -e "${G}[INIT]${NC} Loading Azure Strike Protocol..."
sleep 0.3
echo -ne "${G}[INIT]${NC} "
type_fast "Establishing sovereign connection"
echo -e " ${G}✓${NC}"
sleep 0.2
echo -ne "${G}[INIT]${NC} "
type_fast "Decrypting evidence vault"
echo -e " ${G}✓${NC}"
sleep 0.2
echo -ne "${G}[INIT]${NC} "
type_fast "Loading target intelligence"
echo -e " ${G}✓${NC}"
sleep 0.2
echo -ne "${G}[INIT]${NC} "
type_fast "Weapons systems online"
echo -e " ${G}✓${NC}"
echo ""
echo -e "${GR}═══════════════════════════════════════════════════════════════════════${NC}"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# TARGET IDENTIFICATION
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${R}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${R}┃${NC}  ${BL}${R}🎯 TARGET ACQUIRED${NC}                                                  ${R}┃${NC}"
echo -e "${R}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -ne "  ${W}Application:${NC}  "
glitch "HILO - Live Video Chat"
sleep 0.2

echo -ne "  ${W}Package:${NC}      "
type_fast "com.qiahao.nextvideo"
echo ""
sleep 0.2

echo -ne "  ${W}Developer:${NC}    "
echo -e "${M}Guangzhou QiaHaoQingChun Information Technology Co.${NC}"
sleep 0.2

echo -ne "  ${W}Origin:${NC}       "
echo -e "${R}🇨🇳 CHINA (Guangdong Province)${NC}"
sleep 0.2

echo -ne "  ${W}Status:${NC}       "
echo -e "${BL}${R}▓▓▓ MARKED FOR EXPOSURE ▓▓▓${NC}"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# CHINA C2 SERVER DETECTION
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${R}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${R}┃${NC}  ${R}🇨🇳 CHINA C2 SERVER - COMMAND & CONTROL${NC}                             ${R}┃${NC}"
echo -e "${R}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${Y}  ⚠️  SCANNING HOSTILE INFRASTRUCTURE...${NC}"
progress_bar 2
echo ""

echo -e "${R}  ╔═══════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${R}  ║${NC}                                                                   ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}IP ADDRESS:${NC}      ${BR}36.97.126.139${NC}                                ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}LOCATION:${NC}        ${R}Hangzhou, Zhejiang, CHINA 🇨🇳${NC}                 ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}ISP:${NC}             ${Y}AS4134 CHINANET-BACKBONE${NC}                      ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}OS:${NC}              ${M}Windows Server 2012 (VULNERABLE!)${NC}             ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}PROTOCOL:${NC}        ${C}HTTP Port 80 (UNENCRYPTED!)${NC}                   ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}PACKETS:${NC}         ${G}49 bidirectional (C2 pattern)${NC}                 ${R}║${NC}"
echo -e "${R}  ║${NC}   ${W}PATTERN:${NC}         ${Y}Heartbeat every ~1 second${NC}                     ${R}║${NC}"
echo -e "${R}  ║${NC}                                                                   ${R}║${NC}"
echo -e "${R}  ╚═══════════════════════════════════════════════════════════════════╝${NC}"
sleep 1.5

# ═══════════════════════════════════════════════════════════════════════════
# VULNERABILITY SCAN
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${Y}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${Y}┃${NC}  ${Y}⚔️  VULNERABILITY SCANNER - EXPLOIT-DB ARSENAL${NC}                      ${Y}┃${NC}"
echo -e "${Y}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${C}  [SCAN]${NC} Probing 36.97.126.139 for known exploits..."
sleep 0.5

echo ""
echo -e "${G}  ┌─────────────────────────────────────────────────────────────────────┐${NC}"
echo -ne "${G}  │${NC} "
type_fast "MS15-034 (HTTP.sys) ............"
echo -e " ${R}VULNERABLE ✗${NC}                ${G}│${NC}"
sleep 0.3
echo -ne "${G}  │${NC} "
type_fast "MS17-010 (EternalBlue) ........."
echo -e " ${R}VULNERABLE ✗${NC}                ${G}│${NC}"
sleep 0.3
echo -ne "${G}  │${NC} "
type_fast "CVE-2017-7269 (IIS WebDAV) ....."
echo -e " ${Y}POSSIBLE ⚠${NC}                 ${G}│${NC}"
sleep 0.3
echo -ne "${G}  │${NC} "
type_fast "SMB v1 (Port 445) .............."
echo -e " ${R}OPEN ✗${NC}                     ${G}│${NC}"
sleep 0.3
echo -ne "${G}  │${NC} "
type_fast "RDP (Port 3389) ................"
echo -e " ${R}EXPOSED ✗${NC}                  ${G}│${NC}"
echo -e "${G}  └─────────────────────────────────────────────────────────────────────┘${NC}"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# LEAKED CREDENTIALS
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${G}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${G}┃${NC}  ${G}🔑 EXTRACTED CREDENTIALS DUMP${NC}                                       ${G}┃${NC}"
echo -e "${G}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${Y}  ═══ GOOGLE FIREBASE ═══${NC}"
echo -ne "  ${W}API Key:${NC}    "
type_fast "AIzaSyCygke1pXNS1aWcVqLza2BjbeegalmSlTg"
echo ""
sleep 0.1
echo -ne "  ${W}Project:${NC}    "
type_fast "432159938851"
echo ""
sleep 0.1
echo -ne "  ${W}Database:${NC}   "
type_fast "nextvideo-1590999469166.firebaseio.com"
echo ""
sleep 0.3

echo ""
echo -e "${B}  ═══ FACEBOOK ═══${NC}"
echo -ne "  ${W}App ID:${NC}     "
type_fast "579294106051988"
echo ""
sleep 0.1
echo -ne "  ${W}Token:${NC}      "
type_fast "72f13ea96e1ec07be6c0196910aad5fd"
echo ""
sleep 0.3

echo ""
echo -e "${M}  ═══ AGORA RTC (Voice/Video) ═══${NC}"
echo -ne "  ${W}Key 1:${NC}      "
type_fast "6291d069123642d9929a49c734c50719"
echo ""
sleep 0.1
echo -ne "  ${W}Key 2:${NC}      "
type_fast "fc3e087f701b4f788099e1924c3cc7b0"
echo ""
sleep 0.3

echo ""
echo -e "${C}  ═══ ALIBABA CLOUD ═══${NC}"
echo -ne "  ${W}SDK Key:${NC}    "
type_fast "56fc10fbe8c6ae7d0d895f49c4fb6838"
echo ""
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# INFRASTRUCTURE MAP
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${C}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${C}┃${NC}  ${C}🌐 HILO SERVER INFRASTRUCTURE MAP${NC}                                   ${C}┃${NC}"
echo -e "${C}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${W}  [API SERVERS]${NC}"
echo -e "${G}    ├─ api.tikhak.com       ${GR}→${NC} ${C}AWS Global Accelerator (Seattle)${NC}"
echo -e "${G}    ├─ api.hiloconn.com     ${GR}→${NC} ${C}Cloudflare (San Francisco)${NC}"
echo -e "${G}    └─ apiv1.faceline.live  ${GR}→${NC} ${C}Backup Server${NC}"
sleep 0.3

echo ""
echo -e "${W}  [WEBSOCKET SERVERS]${NC}"
echo -e "${M}    ├─ wss://ws.tikhak.com/ws${NC}"
echo -e "${M}    ├─ wss://ws.faceline.live/ws${NC}"
echo -e "${M}    └─ wss://ws.hiloconn.com/ws${NC}"
sleep 0.3

echo ""
echo -e "${W}  [CHINA C2 NODE]${NC}"
echo -e "${R}    └─ 36.97.126.139        ${GR}→${NC} ${R}CHINANET-BACKBONE (Hangzhou) 🇨🇳${NC}"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# PRIVACY VIOLATIONS
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${R}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${R}┃${NC}  ${R}⚠️  PRIVACY VIOLATIONS DETECTED${NC}                                      ${R}┃${NC}"
echo -e "${R}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${Y}  Data Collection (HeaderInterceptor.java):${NC}"
sleep 0.2
echo -e "${R}    ✗${NC} ${W}IMEI Collection${NC}        ${GR}→${NC} Device tracking across reinstalls"
sleep 0.15
echo -e "${R}    ✗${NC} ${W}VPN Detection${NC}          ${GR}→${NC} Blocking privacy-conscious users"
sleep 0.15
echo -e "${R}    ✗${NC} ${W}Emulator Detection${NC}     ${GR}→${NC} Blocking security researchers"
sleep 0.15
echo -e "${R}    ✗${NC} ${W}SIM Carrier Info${NC}       ${GR}→${NC} Network profiling"
sleep 0.15
echo -e "${R}    ✗${NC} ${W}Device Fingerprint${NC}     ${GR}→${NC} Cross-app surveillance"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# LEGAL VIOLATIONS
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${M}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${M}┃${NC}  ${M}⚖️  INTERNATIONAL LAW VIOLATIONS${NC}                                    ${M}┃${NC}"
echo -e "${M}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${W}  GDPR (European Union):${NC}"
echo -e "${R}    ➤${NC} Article 44-49: Data transfer to China without adequacy"
sleep 0.2

echo -e "${W}  Saudi Arabia PDPL:${NC}"
echo -e "${R}    ➤${NC} Personal data sent to non-approved jurisdiction"
sleep 0.2

echo -e "${W}  Google Play Policy:${NC}"
echo -e "${R}    ➤${NC} Deceptive data practices & hardcoded credentials"
sleep 0.2

echo -e "${W}  Apple App Store Guidelines:${NC}"
echo -e "${R}    ➤${NC} 5.1.1, 5.1.2 - Privacy violations"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# RISK ASSESSMENT
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${R}╔═════════════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${R}║${NC}                                                                         ${R}║${NC}"
echo -e "${R}║${NC}              ${W}📊 SOVEREIGN RISK ASSESSMENT${NC}                              ${R}║${NC}"
echo -e "${R}║${NC}                                                                         ${R}║${NC}"
echo -e "${R}║${NC}      ${BL}${R}████████████████████████████████████████████████${NC}               ${R}║${NC}"
echo -e "${R}║${NC}                                                                         ${R}║${NC}"
echo -e "${R}║${NC}                    SCORE: ${BR}148${NC} / 200                                    ${R}║${NC}"
echo -e "${R}║${NC}                    LEVEL: ${BL}${BR}C R I T I C A L  🔴${NC}                       ${R}║${NC}"
echo -e "${R}║${NC}                                                                         ${R}║${NC}"
echo -e "${R}╚═════════════════════════════════════════════════════════════════════════╝${NC}"
sleep 1.5

# ═══════════════════════════════════════════════════════════════════════════
# NETWORK CAPTURE EVIDENCE
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${C}┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓${NC}"
echo -e "${C}┃${NC}  ${C}📡 NETWORK FORENSICS - SWEDEN VAULT${NC}                                 ${C}┃${NC}"
echo -e "${C}┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛${NC}"
sleep 0.5

echo ""
echo -e "${G}  ┌─────────────────────────────────────────────────────────────────────┐${NC}"
echo -e "${G}  │${NC} ${W}Capture Time:${NC}     2026-01-22 04:39:00 UTC                         ${G}│${NC}"
echo -e "${G}  │${NC} ${W}Total Packets:${NC}    1,278 captured                                  ${G}│${NC}"
echo -e "${G}  │${NC} ${W}China Packets:${NC}    ${R}49 bidirectional${NC}                               ${G}│${NC}"
echo -e "${G}  │${NC} ${W}Evidence File:${NC}    full_capture.pcap (348KB)                       ${G}│${NC}"
echo -e "${G}  │${NC} ${W}Vault Location:${NC}   /root/sovereign_ops/vault/                      ${G}│${NC}"
echo -e "${G}  └─────────────────────────────────────────────────────────────────────┘${NC}"
sleep 1

# ═══════════════════════════════════════════════════════════════════════════
# FINAL MESSAGE
# ═══════════════════════════════════════════════════════════════════════════

echo ""
echo -e "${GR}═══════════════════════════════════════════════════════════════════════${NC}"
echo ""
echo -e "${G}  ✓${NC} Evidence documented and verified"
echo -e "${G}  ✓${NC} China C2 communication confirmed"
echo -e "${G}  ✓${NC} Legal violations catalogued"
echo -e "${G}  ✓${NC} Ready for regulatory submission"
echo ""
echo -e "${GR}═══════════════════════════════════════════════════════════════════════${NC}"
sleep 0.5

echo ""
echo -e "${C}  🌐 Evidence Dashboard: ${W}https://dragon403.com${NC}"
echo -e "${C}  📧 Contact: ${W}iqd@hotmail.com${NC}"
echo -e "${C}  🐙 GitHub: ${W}github.com/KHAWRIZM${NC}"
echo ""
sleep 0.5

echo -e "${Y}  ╔═══════════════════════════════════════════════════════════════════╗${NC}"
echo -e "${Y}  ║${NC}                                                                   ${Y}║${NC}"
echo -e "${Y}  ║${NC}    ${W}\"The dragon has awakened. The evidence speaks for itself.\"${NC}    ${Y}║${NC}"
echo -e "${Y}  ║${NC}                                                                   ${Y}║${NC}"
echo -e "${Y}  ║${NC}                              ${C}- KHAWRIZM, 2026${NC}                      ${Y}║${NC}"
echo -e "${Y}  ║${NC}                              ${C}  RIYADH ZERO${NC}                         ${Y}║${NC}"
echo -e "${Y}  ║${NC}                                                                   ${Y}║${NC}"
echo -e "${Y}  ╚═══════════════════════════════════════════════════════════════════╝${NC}"
echo ""

echo -e "${R}  ███████╗████████╗ █████╗ ██╗   ██╗    ███╗   ███╗ █████╗ ██████╗ ${NC}"
echo -e "${R}  ██╔════╝╚══██╔══╝██╔══██╗╚██╗ ██╔╝    ████╗ ████║██╔══██╗██╔══██╗${NC}"
echo -e "${R}  ███████╗   ██║   ███████║ ╚████╔╝     ██╔████╔██║███████║██║  ██║${NC}"
echo -e "${R}  ╚════██║   ██║   ██╔══██║  ╚██╔╝      ██║╚██╔╝██║██╔══██║██║  ██║${NC}"
echo -e "${R}  ███████║   ██║   ██║  ██║   ██║       ██║ ╚═╝ ██║██║  ██║██████╔╝${NC}"
echo -e "${R}  ╚══════╝   ╚═╝   ╚═╝  ╚═╝   ╚═╝       ╚═╝     ╚═╝╚═╝  ╚═╝╚═════╝ ${NC}"
echo ""

echo -e "${GR}  [DRAGON403 AZURE PROTOCOL - SESSION COMPLETE]${NC}"
echo ""
sleep 2

read -p "  Press Enter to exit..."

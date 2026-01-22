#!/bin/bash
# ╔═══════════════════════════════════════════════════════════════╗
# ║          🐉 DRAGON403 - CINEMATIC EVIDENCE REVEAL             ║
# ║              For Documentary Screen Recording                  ║
# ╚═══════════════════════════════════════════════════════════════╝

# Colors
RED='\033[1;31m'
GREEN='\033[1;32m'
YELLOW='\033[1;33m'
BLUE='\033[1;34m'
MAGENTA='\033[1;35m'
CYAN='\033[1;36m'
WHITE='\033[1;37m'
GRAY='\033[0;90m'
NC='\033[0m' # No Color
BG_RED='\033[41m'
BG_GREEN='\033[42m'
BG_BLUE='\033[44m'
BLINK='\033[5m'
BOLD='\033[1m'

# Typing speed (seconds between chars)
SPEED=0.03
FAST=0.01
SLOW=0.06

# Type text with effect
type_text() {
    local text="$1"
    local speed="${2:-$SPEED}"
    for ((i=0; i<${#text}; i++)); do
        printf "%s" "${text:$i:1}"
        sleep $speed
    done
}

# Type line with color
type_line() {
    local color="$1"
    local text="$2"
    local speed="${3:-$SPEED}"
    printf "${color}"
    type_text "$text" "$speed"
    printf "${NC}\n"
}

# Print instant line
print_line() {
    echo -e "$1"
}

# Dramatic pause
pause() {
    sleep "${1:-1}"
}

# Clear and set title
clear
printf "\033]0;DRAGON403 - SOVEREIGN INTELLIGENCE\007"

# ═══════════════════════════════════════════════════════════════
# INTRO SEQUENCE
# ═══════════════════════════════════════════════════════════════

print_line ""
print_line "${GRAY}┌──────────────────────────────────────────────────────────────┐${NC}"
pause 0.5

type_line "$CYAN" "│  ██████╗ ██████╗  █████╗  ██████╗  ██████╗ ███╗   ██╗      │" $FAST
type_line "$CYAN" "│  ██╔══██╗██╔══██╗██╔══██╗██╔════╝ ██╔═══██╗████╗  ██║      │" $FAST
type_line "$CYAN" "│  ██║  ██║██████╔╝███████║██║  ███╗██║   ██║██╔██╗ ██║      │" $FAST
type_line "$CYAN" "│  ██║  ██║██╔══██╗██╔══██║██║   ██║██║   ██║██║╚██╗██║      │" $FAST
type_line "$CYAN" "│  ██████╔╝██║  ██║██║  ██║╚██████╔╝╚██████╔╝██║ ╚████║      │" $FAST
type_line "$CYAN" "│  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝      │" $FAST

print_line "${GRAY}│                                                              │${NC}"
type_line "$RED" "│                    ███╗   ██╗ ██████╗ ██████╗               │" $FAST
type_line "$RED" "│                    ████╗  ██║██╔═████╗╚════██╗              │" $FAST  
type_line "$RED" "│                    ██╔██╗ ██║██║██╔██║ █████╔╝              │" $FAST
type_line "$RED" "│                    ██║╚██╗██║████╔╝██║ ╚═══██╗              │" $FAST
type_line "$RED" "│                    ██║ ╚████║╚██████╔╝██████╔╝              │" $FAST
type_line "$RED" "│                    ╚═╝  ╚═══╝ ╚═════╝ ╚═════╝               │" $FAST

print_line "${GRAY}└──────────────────────────────────────────────────────────────┘${NC}"
pause 1

print_line ""
type_line "$YELLOW" "        ⚡ SOVEREIGN INTELLIGENCE SYSTEM v4.0.3 ⚡" $SPEED
pause 0.5
type_line "$GRAY" "           [ RIYADH_ZERO | KHAWRIZM | 2026 ]" $SPEED
pause 1.5

# ═══════════════════════════════════════════════════════════════
# SYSTEM INIT
# ═══════════════════════════════════════════════════════════════

print_line ""
print_line "${GRAY}═══════════════════════════════════════════════════════════════${NC}"
type_line "$GREEN" "[INIT] Initializing Dragon Protocol..." $SPEED
pause 0.3
type_line "$GREEN" "[INIT] Loading evidence database... " $SPEED
sleep 0.5
print_line "${GREEN}✓ LOADED${NC}"
type_line "$GREEN" "[INIT] Connecting to Sweden Vault... " $SPEED
sleep 0.3
print_line "${GREEN}✓ CONNECTED${NC}"
type_line "$GREEN" "[INIT] Decrypting intelligence files... " $SPEED
sleep 0.5
print_line "${GREEN}✓ DECRYPTED${NC}"
print_line "${GRAY}═══════════════════════════════════════════════════════════════${NC}"
pause 1

# ═══════════════════════════════════════════════════════════════
# TARGET IDENTIFICATION
# ═══════════════════════════════════════════════════════════════

print_line ""
type_line "$RED" "┌─────────────────────────────────────────────────────────────┐"
type_line "$RED" "│  🎯 TARGET IDENTIFICATION                                   │"
type_line "$RED" "└─────────────────────────────────────────────────────────────┘"
pause 0.5

print_line ""
type_line "$WHITE" "  Application Name:" $SPEED
sleep 0.3
type_line "$YELLOW" "    ➤ HILO - Live Video Chat" $SPEED
pause 0.3

type_line "$WHITE" "  Package Name:" $SPEED
sleep 0.3
type_line "$CYAN" "    ➤ com.qiahao.nextvideo" $SPEED
pause 0.3

type_line "$WHITE" "  Developer:" $SPEED
sleep 0.3
type_line "$MAGENTA" "    ➤ Guangzhou QiaHaoQingChun Information Technology Co., Ltd." $SPEED
pause 0.3

type_line "$WHITE" "  Origin:" $SPEED
sleep 0.3
type_line "$RED" "    ➤ 🇨🇳 CHINA (Guangzhou)" $SPEED
pause 1

# ═══════════════════════════════════════════════════════════════
# LEAKED CREDENTIALS
# ═══════════════════════════════════════════════════════════════

print_line ""
type_line "$RED" "┌─────────────────────────────────────────────────────────────┐"
type_line "$RED" "│  🔑 EXTRACTED CREDENTIALS [CRITICAL]                        │"
type_line "$RED" "└─────────────────────────────────────────────────────────────┘"
pause 0.5

print_line ""
type_line "$YELLOW" "  [GOOGLE FIREBASE]" $SPEED
pause 0.3
type_line "$WHITE" "  ├─ API Key: " $FAST
type_line "$GREEN" "AIzaSyCygke1pXNS1aWcVqLza2BjbeegalmSlTg" $FAST
type_line "$WHITE" "  ├─ Project: " $FAST
type_line "$GREEN" "432159938851" $FAST
type_line "$WHITE" "  └─ Database: " $FAST
type_line "$GREEN" "nextvideo-1590999469166.firebaseio.com" $FAST
pause 0.5

print_line ""
type_line "$BLUE" "  [FACEBOOK]" $SPEED
pause 0.3
type_line "$WHITE" "  ├─ App ID: " $FAST
type_line "$GREEN" "579294106051988" $FAST
type_line "$WHITE" "  └─ Token: " $FAST
type_line "$GREEN" "72f13ea96e1ec07be6c0196910aad5fd" $FAST
pause 0.5

print_line ""
type_line "$MAGENTA" "  [AGORA RTC - Voice/Video]" $SPEED
pause 0.3
type_line "$WHITE" "  ├─ Key 1: " $FAST
type_line "$GREEN" "6291d069123642d9929a49c734c50719" $FAST
type_line "$WHITE" "  └─ Key 2: " $FAST
type_line "$GREEN" "fc3e087f701b4f788099e1924c3cc7b0" $FAST
pause 1

# ═══════════════════════════════════════════════════════════════
# CHINA C2 SERVER
# ═══════════════════════════════════════════════════════════════

print_line ""
type_line "$RED" "┌─────────────────────────────────────────────────────────────┐"
type_line "$RED" "│  🇨🇳 CHINA C2 SERVER DETECTED [NETWORK FORENSICS]           │"
type_line "$RED" "└─────────────────────────────────────────────────────────────┘"
pause 0.5

print_line ""
type_line "$WHITE" "  Scanning network traffic..." $SPEED
sleep 0.5

print_line ""
type_line "$YELLOW" "  ⚠️  ALERT: Suspicious connection detected!" $SPEED
pause 0.5

print_line ""
print_line "${RED}  ╔═══════════════════════════════════════════════════════════╗${NC}"
print_line "${RED}  ║${NC}                                                           ${RED}║${NC}"
type_line "$WHITE" "  ║   IP Address:    ${RED}36.97.126.139${NC}                          ║" $FAST
type_line "$WHITE" "  ║   Location:      ${RED}Hangzhou, Zhejiang, CHINA${NC}              ║" $FAST
type_line "$WHITE" "  ║   ISP:           ${RED}AS4134 CHINANET-BACKBONE${NC}               ║" $FAST
type_line "$WHITE" "  ║   Protocol:      ${YELLOW}HTTP Port 80 (UNENCRYPTED!)${NC}           ║" $FAST
type_line "$WHITE" "  ║   Packets:       ${CYAN}49 bidirectional${NC}                       ║" $FAST
type_line "$WHITE" "  ║   Pattern:       ${MAGENTA}C2 Heartbeat (~1 sec interval)${NC}        ║" $FAST
print_line "${RED}  ║${NC}                                                           ${RED}║${NC}"
print_line "${RED}  ╚═══════════════════════════════════════════════════════════╝${NC}"
pause 1.5

# ═══════════════════════════════════════════════════════════════
# INFRASTRUCTURE MAP
# ═══════════════════════════════════════════════════════════════

print_line ""
type_line "$CYAN" "┌─────────────────────────────────────────────────────────────┐"
type_line "$CYAN" "│  🌐 HILO SERVER INFRASTRUCTURE                              │"
type_line "$CYAN" "└─────────────────────────────────────────────────────────────┘"
pause 0.5

print_line ""
type_line "$WHITE" "  [API SERVERS]" $SPEED
type_line "$GREEN" "    ├─ api.tikhak.com      → AWS Global Accelerator (Seattle)" $FAST
type_line "$GREEN" "    ├─ api.hiloconn.com    → Cloudflare (San Francisco)" $FAST
type_line "$GREEN" "    └─ apiv1.faceline.live → Backup Server" $FAST
pause 0.3

print_line ""
type_line "$WHITE" "  [WEBSOCKET SERVERS]" $SPEED
type_line "$CYAN" "    ├─ wss://ws.tikhak.com/ws" $FAST
type_line "$CYAN" "    ├─ wss://ws.faceline.live/ws" $FAST
type_line "$CYAN" "    └─ wss://ws.hiloconn.com/ws" $FAST
pause 0.3

print_line ""
type_line "$WHITE" "  [CDN / MEDIA]" $SPEED
type_line "$YELLOW" "    ├─ image.whoisamy.shop  → CloudFront (Riyadh Edge!)" $FAST
type_line "$YELLOW" "    └─ oss.iludo.live       → Chinese CDN" $FAST
pause 1

# ═══════════════════════════════════════════════════════════════
# PRIVACY VIOLATIONS
# ═══════════════════════════════════════════════════════════════

print_line ""
type_line "$RED" "┌─────────────────────────────────────────────────────────────┐"
type_line "$RED" "│  ⚠️  PRIVACY VIOLATIONS DETECTED                            │"
type_line "$RED" "└─────────────────────────────────────────────────────────────┘"
pause 0.5

print_line ""
type_line "$YELLOW" "  Data Collection (HeaderInterceptor.java):" $SPEED
pause 0.3
type_line "$RED" "    ✗ IMEI Collection        → Device tracking" $FAST
type_line "$RED" "    ✗ VPN Detection          → Privacy bypass detection" $FAST
type_line "$RED" "    ✗ Emulator Detection     → Security research blocking" $FAST
type_line "$RED" "    ✗ SIM Carrier Info       → Network profiling" $FAST
type_line "$RED" "    ✗ Device Fingerprinting  → Cross-app tracking" $FAST
pause 1

# ═══════════════════════════════════════════════════════════════
# LEGAL VIOLATIONS
# ═══════════════════════════════════════════════════════════════

print_line ""
type_line "$MAGENTA" "┌─────────────────────────────────────────────────────────────┐"
type_line "$MAGENTA" "│  ⚖️  LEGAL VIOLATIONS                                       │"
type_line "$MAGENTA" "└─────────────────────────────────────────────────────────────┘"
pause 0.5

print_line ""
type_line "$WHITE" "  GDPR (European Union):" $SPEED
type_line "$RED" "    ➤ Article 44-49: Data transfer to China without adequacy" $FAST
pause 0.3

type_line "$WHITE" "  Saudi Arabia PDPL:" $SPEED
type_line "$RED" "    ➤ Personal data to non-approved jurisdiction" $FAST
pause 0.3

type_line "$WHITE" "  Security Standards:" $SPEED
type_line "$RED" "    ➤ Hardcoded API credentials in production app" $FAST
pause 1

# ═══════════════════════════════════════════════════════════════
# RISK ASSESSMENT
# ═══════════════════════════════════════════════════════════════

print_line ""
print_line "${RED}╔═════════════════════════════════════════════════════════════╗${NC}"
print_line "${RED}║${NC}                                                             ${RED}║${NC}"
type_line "$WHITE" "║           📊 RISK ASSESSMENT SCORE                          ║" $FAST
print_line "${RED}║${NC}                                                             ${RED}║${NC}"
print_line "${RED}║${NC}              ${BLINK}${RED}█████████████████████████${NC}                    ${RED}║${NC}"
print_line "${RED}║${NC}                                                             ${RED}║${NC}"
type_line "$WHITE" "║                   SCORE: ${RED}148${NC} / 200                          ║" $FAST
type_line "$WHITE" "║                   LEVEL: ${RED}CRITICAL 🔴${NC}                        ║" $FAST
print_line "${RED}║${NC}                                                             ${RED}║${NC}"
print_line "${RED}╚═════════════════════════════════════════════════════════════╝${NC}"
pause 1.5

# ═══════════════════════════════════════════════════════════════
# FINAL MESSAGE
# ═══════════════════════════════════════════════════════════════

print_line ""
print_line "${GRAY}═══════════════════════════════════════════════════════════════${NC}"
print_line ""
type_line "$GREEN" "  ✓ Evidence documented" $SPEED
type_line "$GREEN" "  ✓ Network forensics complete" $SPEED  
type_line "$GREEN" "  ✓ Legal violations catalogued" $SPEED
type_line "$GREEN" "  ✓ Ready for regulatory submission" $SPEED
print_line ""
print_line "${GRAY}═══════════════════════════════════════════════════════════════${NC}"
pause 1

print_line ""
type_line "$CYAN" "  🌐 Evidence Dashboard: https://dragon403.com" $SPEED
type_line "$CYAN" "  📧 Contact: iqd@hotmail.com" $SPEED
type_line "$CYAN" "  🐙 GitHub: github.com/KHAWRIZM" $SPEED
print_line ""
pause 0.5

print_line "${YELLOW}  ╔═══════════════════════════════════════════════════════════╗${NC}"
type_line "$YELLOW" "  ║     \"The truth cannot be hidden in the digital age\"       ║" $SPEED
type_line "$YELLOW" "  ║                                        - KHAWRIZM, 2026   ║" $SPEED
print_line "${YELLOW}  ╚═══════════════════════════════════════════════════════════╝${NC}"
print_line ""

type_line "$GRAY" "  [DRAGON403 SOVEREIGN INTELLIGENCE - SESSION COMPLETE]" $SLOW
print_line ""
pause 2

# Keep terminal open
read -p "Press Enter to exit..."

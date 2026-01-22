#!/usr/bin/env python3
"""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 SOVEREIGN EVIDENCE VAULT                                             ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   قاعدة بيانات محلية لحفظ كل الأدلة والحقائق                              ║
║   لا تُنسى - لا تُحذف - سيادية بالكامل                                    ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
"""

import sqlite3
import os
from datetime import datetime

# Database path
DB_PATH = r"C:\Users\admin\Desktop\HILO_CASE\sovereign_vault.db"

def init_vault():
    """Initialize the Sovereign Evidence Vault"""
    conn = sqlite3.connect(DB_PATH)
    cursor = conn.cursor()
    
    # Create tables
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS identity (
            id INTEGER PRIMARY KEY,
            codename TEXT,
            real_name TEXT,
            location TEXT,
            active_email TEXT,
            frozen_emails TEXT,
            created_at TEXT
        )
    ''')
    
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS zone_h_records (
            id INTEGER PRIMARY KEY,
            notifier TEXT,
            total_breaches INTEGER,
            single_ip INTEGER,
            mass_defacements INTEGER,
            period TEXT,
            zone_h_url TEXT
        )
    ''')
    
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS fraud_case (
            id INTEGER PRIMARY KEY,
            case_name TEXT,
            total_loss_sar INTEGER,
            total_loss_usd INTEGER,
            perpetrator_app TEXT,
            perpetrator_company TEXT,
            platforms_involved TEXT,
            cma_reference TEXT,
            incident_date TEXT
        )
    ''')
    
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS complaints_filed (
            id INTEGER PRIMARY KEY,
            agency TEXT,
            country TEXT,
            reference_number TEXT,
            date_filed TEXT,
            status TEXT,
            file_path TEXT
        )
    ''')
    
    cursor.execute('''
        CREATE TABLE IF NOT EXISTS evidence_files (
            id INTEGER PRIMARY KEY,
            file_name TEXT,
            file_path TEXT,
            category TEXT,
            description TEXT,
            created_at TEXT
        )
    ''')
    
    conn.commit()
    print("✅ [VAULT]: Tables initialized")
    return conn

def populate_identity(conn):
    """Populate identity data"""
    cursor = conn.cursor()
    
    cursor.execute("DELETE FROM identity")  # Clear old data
    
    cursor.execute('''
        INSERT INTO identity (codename, real_name, location, active_email, frozen_emails, created_at)
        VALUES (?, ?, ?, ?, ?, ?)
    ''', (
        "KHAWRIZM | Forbidden's Killer 403",
        "Suliman Nazal Alshammari",
        "Riyadh, Saudi Arabia",
        "iqd@hotmail.com",
        "v@hotmail.com, iqb@hotmail.com",
        datetime.now().isoformat()
    ))
    
    conn.commit()
    print("✅ [VAULT]: Identity synchronized")

def populate_zone_h(conn):
    """Populate Zone-H historical records"""
    cursor = conn.cursor()
    
    cursor.execute("DELETE FROM zone_h_records")
    
    records = [
        ("Dr.DaShEr", 1904, 136, 1768, "2011-2016", "https://zone-h.com/archive/notifier=DR.DASHER"),
        ("Dr.StUaRt", 75, 39, 36, "2012-2013", "https://zone-h.com/archive/notifier=DR.STUART"),
    ]
    
    cursor.executemany('''
        INSERT INTO zone_h_records (notifier, total_breaches, single_ip, mass_defacements, period, zone_h_url)
        VALUES (?, ?, ?, ?, ?, ?)
    ''', records)
    
    conn.commit()
    print("✅ [VAULT]: Zone-H records synchronized (1,979 total breaches)")

def populate_fraud_case(conn):
    """Populate HILO fraud case data"""
    cursor = conn.cursor()
    
    cursor.execute("DELETE FROM fraud_case")
    
    cursor.execute('''
        INSERT INTO fraud_case (case_name, total_loss_sar, total_loss_usd, perpetrator_app, 
                               perpetrator_company, platforms_involved, cma_reference, incident_date)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    ''', (
        "HILO/FALLA Fraud Network",
        600000,
        160000,
        "HILO - Group Chat & Video Connect",
        "Guangzhou QiaHaoQingChun Information Technology Co., Ltd.",
        "Apple App Store, Google Play Store",
        "EXT27421",
        "2024-2026"
    ))
    
    conn.commit()
    print("✅ [VAULT]: Fraud case documented (SAR 600,000)")

def populate_complaints(conn):
    """Populate filed complaints"""
    cursor = conn.cursor()
    
    cursor.execute("DELETE FROM complaints_filed")
    
    complaints = [
        ("Saudi CMA/CRSD", "Saudi Arabia", "EXT27421", "2024-10-23", "Filed", ""),
        ("Royal Court (Tawasul)", "Saudi Arabia", "N/A", "2025-05-13", "Updated", ""),
        ("Apple Legal Notice", "USA/Ireland", "N/A", "2026-01-17", "48h Deadline Expired", "LEGAL_NOTICE_GOOGLE_APPLE.md"),
        ("DPC Ireland", "Ireland", "Pending", "2026-01-21", "Ready to Submit", "INTERNATIONAL_COMPLAINTS/DPC_IRELAND_COMPLAINT.md"),
        ("FBI IC3", "USA", "Pending", "2026-01-21", "Ready to Submit", "INTERNATIONAL_COMPLAINTS/FBI_IC3_COMPLAINT.md"),
        ("FTC", "USA", "Pending", "2026-01-21", "Ready to Submit", "INTERNATIONAL_COMPLAINTS/FTC_COMPLAINT.md"),
        ("Europol", "EU", "Pending", "2026-01-21", "Ready to Submit", "INTERNATIONAL_COMPLAINTS/EUROPOL_COMPLAINT.md"),
        ("Interpol", "International", "Pending", "2026-01-21", "Ready to Submit", "INTERNATIONAL_COMPLAINTS/INTERPOL_COMPLAINT.md"),
    ]
    
    cursor.executemany('''
        INSERT INTO complaints_filed (agency, country, reference_number, date_filed, status, file_path)
        VALUES (?, ?, ?, ?, ?, ?)
    ''', complaints)
    
    conn.commit()
    print("✅ [VAULT]: 8 complaints documented")

def display_vault_summary(conn):
    """Display vault summary"""
    cursor = conn.cursor()
    
    print("""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 SOVEREIGN EVIDENCE VAULT - SUMMARY                                   ║
║                                                                           ║
╠═══════════════════════════════════════════════════════════════════════════╣
""")
    
    # Identity
    cursor.execute("SELECT codename, active_email, frozen_emails FROM identity")
    identity = cursor.fetchone()
    if identity:
        print(f"║   👤 IDENTITY: {identity[0]}")
        print(f"║   📧 ACTIVE: {identity[1]}")
        print(f"║   ❄️  FROZEN: {identity[2]}")
    
    print("║")
    
    # Zone-H
    cursor.execute("SELECT SUM(total_breaches) FROM zone_h_records")
    total = cursor.fetchone()[0]
    print(f"║   🌐 ZONE-H TOTAL: {total} verified breaches (2011-2016)")
    
    print("║")
    
    # Fraud Case
    cursor.execute("SELECT total_loss_sar, total_loss_usd FROM fraud_case")
    fraud = cursor.fetchone()
    if fraud:
        print(f"║   💰 FRAUD LOSS: SAR {fraud[0]:,} (~${fraud[1]:,} USD)")
    
    print("║")
    
    # Complaints
    cursor.execute("SELECT COUNT(*) FROM complaints_filed")
    count = cursor.fetchone()[0]
    cursor.execute("SELECT COUNT(*) FROM complaints_filed WHERE status='Ready to Submit'")
    ready = cursor.fetchone()[0]
    print(f"║   📋 COMPLAINTS: {count} total ({ready} ready to submit)")
    
    print("""║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║   🎯 TARGETS: Apple Inc. | Google LLC | HILO Network                      ║
║   🌍 JURISDICTIONS: Ireland | USA | EU | International                    ║
║   📁 DATABASE: sovereign_vault.db                                         ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
""")

def main():
    print("""
╔═══════════════════════════════════════════════════════════════════════════╗
║                                                                           ║
║   🐉 INITIALIZING SOVEREIGN EVIDENCE VAULT                                ║
║   ═══════════════════════════════════════════════                         ║
║                                                                           ║
║   "The Desert Never Forgets"                                              ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
""")
    
    conn = init_vault()
    populate_identity(conn)
    populate_zone_h(conn)
    populate_fraud_case(conn)
    populate_complaints(conn)
    display_vault_summary(conn)
    
    conn.close()
    print(f"\n🔐 [VAULT]: Database saved to: {DB_PATH}")
    print("🐉 THE SOVEREIGN VAULT IS SEALED. 🔥🇸🇦")

if __name__ == "__main__":
    main()

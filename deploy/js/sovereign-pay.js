/**
 * 💳 DRAGON403 - Sovereign Payment Gateway
 * Moyasar Integration for Saudi Arabia
 */

class SovereignPay {
    constructor() {
        // Moyasar API - LIVE MODE (Real Payments!)
        this.publishableKey = 'pk_live_gd6jjYDZJ28R87zoXv2bbsxwqBK7PfB69uQLcqni';
        this.apiBase = 'https://api.moyasar.com/v1';
        this.callbackUrl = 'https://dragon403.com/payment/callback';
        
        // Payment tiers (SAR)
        this.tiers = {
            hunter: { name: 'Hunter', price: 37, priceUSD: 9.99 },
            warrior: { name: 'Warrior', price: 112, priceUSD: 29.99 },
            sovereign: { name: 'Sovereign', price: 375, priceUSD: 99.99 }
        };
        
        // Promo codes
        this.promoCodes = {
            'DRAGON2026': 50,
            'LAUNCH30': 30,
            'KHAWRIZM': 100,
            'HILO_VICTIM': 100
        };
        
        this.isOpen = false;
    }

    /**
     * Initialize Moyasar SDK
     */
    async init() {
        // Load Moyasar JS
        if (!window.Moyasar) {
            const script = document.createElement('script');
            script.src = 'https://cdn.moyasar.com/mpf/1.14.0/moyasar.js';
            document.head.appendChild(script);
            
            const css = document.createElement('link');
            css.rel = 'stylesheet';
            css.href = 'https://cdn.moyasar.com/mpf/1.14.0/moyasar.css';
            document.head.appendChild(css);
            
            await new Promise(resolve => script.onload = resolve);
        }
        console.log('💳 Sovereign Payment initialized');
    }

    /**
     * Create payment modal
     */
    createModal() {
        if (document.getElementById('sovereign-pay-modal')) return;
        
        const modal = document.createElement('div');
        modal.id = 'sovereign-pay-modal';
        modal.innerHTML = `
            <div class="sp-overlay" onclick="sovereignPay.close()"></div>
            <div class="sp-container">
                <div class="sp-header">
                    <span class="sp-logo">🐉</span>
                    <h2>SOVEREIGN PAY</h2>
                    <button class="sp-close" onclick="sovereignPay.close()">×</button>
                </div>
                
                <div class="sp-content">
                    <!-- Plan Selection -->
                    <div class="sp-plans" id="sp-plans">
                        <h3>اختر خطتك</h3>
                        <div class="sp-plan-grid">
                            ${Object.entries(this.tiers).map(([id, tier]) => `
                                <div class="sp-plan" data-tier="${id}" onclick="sovereignPay.selectPlan('${id}')">
                                    <div class="sp-plan-name">${tier.name}</div>
                                    <div class="sp-plan-price">${tier.price} <small>SAR/mo</small></div>
                                    <div class="sp-plan-usd">~$${tier.priceUSD}</div>
                                </div>
                            `).join('')}
                        </div>
                        
                        <div class="sp-promo">
                            <input type="text" id="sp-promo-input" placeholder="كود خصم">
                            <button onclick="sovereignPay.applyPromo()">تطبيق</button>
                        </div>
                        <div id="sp-promo-result"></div>
                    </div>
                    
                    <!-- Payment Form -->
                    <div class="sp-payment" id="sp-payment" style="display:none">
                        <div class="sp-selected-plan">
                            <span id="sp-selected-tier"></span>
                            <span id="sp-selected-price"></span>
                        </div>
                        
                        <div class="sp-methods">
                            <button class="sp-method active" data-method="mada" onclick="sovereignPay.selectMethod('mada')">
                                مدى
                            </button>
                            <button class="sp-method" data-method="creditcard" onclick="sovereignPay.selectMethod('creditcard')">
                                Visa/MC
                            </button>
                            <button class="sp-method" data-method="applepay" onclick="sovereignPay.selectMethod('applepay')">
                                Apple Pay
                            </button>
                            <button class="sp-method" data-method="stcpay" onclick="sovereignPay.selectMethod('stcpay')">
                                STC Pay
                            </button>
                        </div>
                        
                        <div id="moyasar-form"></div>
                        
                        <div class="sp-security">
                            🔒 مشفر بـ PCI-DSS Level 1 | معتمد من ساما
                        </div>
                    </div>
                    
                    <!-- Success -->
                    <div class="sp-success" id="sp-success" style="display:none">
                        <div class="sp-success-icon">✅</div>
                        <h3>تم الدفع بنجاح!</h3>
                        <p>شكراً لانضمامك لـ Dragon403 Sovereign</p>
                        <p id="sp-receipt"></p>
                        <button onclick="sovereignPay.close()">إغلاق</button>
                    </div>
                </div>
            </div>
        `;
        
        document.body.appendChild(modal);
        this.addStyles();
    }

    /**
     * Add CSS styles
     */
    addStyles() {
        if (document.getElementById('sovereign-pay-styles')) return;
        
        const style = document.createElement('style');
        style.id = 'sovereign-pay-styles';
        style.textContent = `
            #sovereign-pay-modal {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                z-index: 10000;
                display: none;
            }
            #sovereign-pay-modal.open {
                display: block;
            }
            .sp-overlay {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: rgba(0,0,0,0.8);
                backdrop-filter: blur(10px);
            }
            .sp-container {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                width: 90%;
                max-width: 500px;
                background: #0a0a0a;
                border: 2px solid #dc2626;
                border-radius: 16px;
                box-shadow: 0 0 60px rgba(220,38,38,0.3);
            }
            .sp-header {
                display: flex;
                align-items: center;
                gap: 12px;
                padding: 20px;
                border-bottom: 1px solid #333;
            }
            .sp-logo {
                font-size: 32px;
            }
            .sp-header h2 {
                flex: 1;
                margin: 0;
                font-size: 20px;
                color: #dc2626;
                letter-spacing: 0.2em;
            }
            .sp-close {
                background: none;
                border: none;
                color: #666;
                font-size: 28px;
                cursor: pointer;
            }
            .sp-close:hover {
                color: #dc2626;
            }
            .sp-content {
                padding: 24px;
            }
            .sp-plans h3 {
                text-align: center;
                color: #888;
                margin-bottom: 20px;
            }
            .sp-plan-grid {
                display: grid;
                grid-template-columns: repeat(3, 1fr);
                gap: 12px;
                margin-bottom: 20px;
            }
            .sp-plan {
                background: #111;
                border: 2px solid #333;
                border-radius: 12px;
                padding: 16px;
                text-align: center;
                cursor: pointer;
                transition: all 0.3s;
            }
            .sp-plan:hover {
                border-color: #dc2626;
            }
            .sp-plan.selected {
                border-color: #dc2626;
                background: rgba(220,38,38,0.1);
            }
            .sp-plan-name {
                font-weight: bold;
                color: #fff;
                margin-bottom: 8px;
            }
            .sp-plan-price {
                font-size: 24px;
                color: #dc2626;
            }
            .sp-plan-price small {
                font-size: 12px;
                color: #888;
            }
            .sp-plan-usd {
                font-size: 12px;
                color: #666;
            }
            .sp-promo {
                display: flex;
                gap: 8px;
                margin-top: 16px;
            }
            .sp-promo input {
                flex: 1;
                background: #111;
                border: 1px solid #333;
                padding: 10px;
                color: #fff;
                border-radius: 8px;
            }
            .sp-promo button {
                background: #333;
                border: none;
                padding: 10px 20px;
                color: #fff;
                border-radius: 8px;
                cursor: pointer;
            }
            .sp-promo button:hover {
                background: #dc2626;
            }
            #sp-promo-result {
                text-align: center;
                margin-top: 8px;
                font-size: 14px;
            }
            #sp-promo-result.success {
                color: #22c55e;
            }
            #sp-promo-result.error {
                color: #dc2626;
            }
            .sp-methods {
                display: flex;
                gap: 8px;
                margin-bottom: 20px;
            }
            .sp-method {
                flex: 1;
                background: #111;
                border: 2px solid #333;
                padding: 12px;
                color: #888;
                border-radius: 8px;
                cursor: pointer;
                font-size: 12px;
            }
            .sp-method:hover {
                border-color: #666;
            }
            .sp-method.active {
                border-color: #dc2626;
                color: #fff;
            }
            .sp-selected-plan {
                display: flex;
                justify-content: space-between;
                padding: 16px;
                background: #111;
                border-radius: 8px;
                margin-bottom: 20px;
            }
            #sp-selected-tier {
                font-weight: bold;
            }
            #sp-selected-price {
                color: #dc2626;
                font-size: 20px;
            }
            .sp-security {
                text-align: center;
                color: #666;
                font-size: 12px;
                margin-top: 16px;
            }
            .sp-success {
                text-align: center;
                padding: 40px;
            }
            .sp-success-icon {
                font-size: 64px;
                margin-bottom: 20px;
            }
            .sp-success h3 {
                color: #22c55e;
                margin-bottom: 16px;
            }
            .sp-success button {
                background: #dc2626;
                border: none;
                padding: 12px 40px;
                color: #fff;
                border-radius: 8px;
                cursor: pointer;
                margin-top: 20px;
            }
            #moyasar-form {
                min-height: 200px;
            }
        `;
        document.head.appendChild(style);
    }

    /**
     * Open payment modal
     */
    open() {
        this.createModal();
        document.getElementById('sovereign-pay-modal').classList.add('open');
        this.isOpen = true;
        this.selectedTier = null;
        this.discount = 0;
    }

    /**
     * Close modal
     */
    close() {
        const modal = document.getElementById('sovereign-pay-modal');
        if (modal) modal.classList.remove('open');
        this.isOpen = false;
    }

    /**
     * Select plan
     */
    selectPlan(tierId) {
        this.selectedTier = tierId;
        const tier = this.tiers[tierId];
        
        // Update UI
        document.querySelectorAll('.sp-plan').forEach(el => el.classList.remove('selected'));
        document.querySelector(`[data-tier="${tierId}"]`).classList.add('selected');
        
        // Show payment section
        document.getElementById('sp-plans').style.display = 'none';
        document.getElementById('sp-payment').style.display = 'block';
        
        // Calculate price
        let finalPrice = tier.price;
        if (this.discount > 0) {
            finalPrice = Math.round(tier.price * (100 - this.discount) / 100);
        }
        
        document.getElementById('sp-selected-tier').textContent = tier.name;
        document.getElementById('sp-selected-price').textContent = `${finalPrice} SAR`;
        
        // Initialize Moyasar form
        this.initMoyasarForm(finalPrice);
    }

    /**
     * Apply promo code
     */
    applyPromo() {
        const code = document.getElementById('sp-promo-input').value.toUpperCase();
        const resultEl = document.getElementById('sp-promo-result');
        
        if (this.promoCodes[code]) {
            this.discount = this.promoCodes[code];
            resultEl.className = 'success';
            resultEl.textContent = `✓ خصم ${this.discount}% مفعّل!`;
        } else {
            this.discount = 0;
            resultEl.className = 'error';
            resultEl.textContent = '✗ كود غير صالح';
        }
    }

    /**
     * Select payment method
     */
    selectMethod(method) {
        document.querySelectorAll('.sp-method').forEach(el => el.classList.remove('active'));
        document.querySelector(`[data-method="${method}"]`).classList.add('active');
        
        // Reinitialize with new method
        const tier = this.tiers[this.selectedTier];
        let finalPrice = Math.round(tier.price * (100 - this.discount) / 100);
        this.initMoyasarForm(finalPrice, method);
    }

    /**
     * Initialize Moyasar payment form
     */
    initMoyasarForm(amount, method = 'mada') {
        const formContainer = document.getElementById('moyasar-form');
        formContainer.innerHTML = '';
        
        // Check if Moyasar is loaded
        if (!window.Moyasar) {
            formContainer.innerHTML = `
                <div style="text-align:center; padding:40px; color:#666;">
                    جاري تحميل بوابة الدفع...
                </div>
            `;
            return;
        }
        
        try {
            Moyasar.init({
                element: formContainer,
                amount: amount * 100, // Convert to halalas
                currency: 'SAR',
                description: `Dragon403 ${this.tiers[this.selectedTier].name} Subscription`,
                publishable_api_key: this.publishableKey,
                callback_url: this.callbackUrl,
                methods: [method],
                on_completed: (payment) => {
                    this.onPaymentSuccess(payment);
                },
                on_failure: (error) => {
                    this.onPaymentFailure(error);
                }
            });
        } catch (e) {
            // Demo mode fallback
            formContainer.innerHTML = `
                <div style="text-align:center; padding:20px;">
                    <p style="color:#888; margin-bottom:20px;">🔧 وضع التجربة</p>
                    <button onclick="sovereignPay.simulatePayment()" style="
                        background: #dc2626;
                        border: none;
                        padding: 16px 40px;
                        color: #fff;
                        border-radius: 8px;
                        cursor: pointer;
                        font-size: 16px;
                    ">
                        ادفع ${amount} SAR
                    </button>
                </div>
            `;
        }
    }

    /**
     * Simulate payment (for testing)
     */
    simulatePayment() {
        this.onPaymentSuccess({
            id: 'demo_' + Date.now(),
            status: 'paid',
            amount: this.tiers[this.selectedTier].price * 100
        });
    }

    /**
     * Payment success handler
     */
    onPaymentSuccess(payment) {
        console.log('✅ Payment success:', payment);
        
        // Show success
        document.getElementById('sp-payment').style.display = 'none';
        document.getElementById('sp-success').style.display = 'block';
        document.getElementById('sp-receipt').textContent = `رقم العملية: ${payment.id}`;
        
        // Log to evidence (if dragon403 AI is available)
        if (window.addToChat) {
            addToChat('ai', `[LEDGER] تم تسجيل عملية دفع جديدة: ${payment.id} | المبلغ: ${payment.amount/100} SAR | الحالة: ${payment.status}`);
        }
        
        // Store locally
        const transactions = JSON.parse(localStorage.getItem('dragon403_transactions') || '[]');
        transactions.push({
            id: payment.id,
            tier: this.selectedTier,
            amount: payment.amount / 100,
            timestamp: new Date().toISOString(),
            status: payment.status
        });
        localStorage.setItem('dragon403_transactions', JSON.stringify(transactions));
    }

    /**
     * Payment failure handler
     */
    onPaymentFailure(error) {
        console.error('❌ Payment failed:', error);
        alert('فشل الدفع: ' + (error.message || 'حاول مرة أخرى'));
    }
}

// Global instance
const sovereignPay = new SovereignPay();

// Auto-initialize when DOM ready
document.addEventListener('DOMContentLoaded', () => {
    sovereignPay.init();
});

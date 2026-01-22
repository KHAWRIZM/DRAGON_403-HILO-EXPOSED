/**
 * 🐉 PAYMENT SERVICE
 * Stripe integration for SaaS billing
 */

// Stripe configuration (to be replaced with real keys in production)
const STRIPE_PUBLIC_KEY = import.meta.env.VITE_STRIPE_PUBLIC_KEY || 'pk_test_demo';
const STRIPE_WEBHOOK_SECRET = import.meta.env.VITE_STRIPE_WEBHOOK_SECRET;

export interface PaymentPlan {
  id: string;
  name: string;
  priceId: string;
  amount: number;
  currency: 'USD' | 'SAR';
  interval: 'month' | 'year';
}

export interface CheckoutSession {
  sessionId: string;
  url: string;
}

export interface PaymentIntent {
  id: string;
  status: 'succeeded' | 'pending' | 'failed';
  amount: number;
}

// Available plans
export const PAYMENT_PLANS: PaymentPlan[] = [
  {
    id: 'hunter_monthly',
    name: 'Hunter',
    priceId: 'price_hunter_monthly',
    amount: 999, // $9.99
    currency: 'USD',
    interval: 'month'
  },
  {
    id: 'hunter_yearly',
    name: 'Hunter (Yearly)',
    priceId: 'price_hunter_yearly',
    amount: 9588, // $95.88 (20% off)
    currency: 'USD',
    interval: 'year'
  },
  {
    id: 'warrior_monthly',
    name: 'Warrior',
    priceId: 'price_warrior_monthly',
    amount: 2999, // $29.99
    currency: 'USD',
    interval: 'month'
  },
  {
    id: 'warrior_yearly',
    name: 'Warrior (Yearly)',
    priceId: 'price_warrior_yearly',
    amount: 28788, // $287.88 (20% off)
    currency: 'USD',
    interval: 'year'
  },
  {
    id: 'sovereign_monthly',
    name: 'Sovereign',
    priceId: 'price_sovereign_monthly',
    amount: 9999, // $99.99
    currency: 'USD',
    interval: 'month'
  },
  {
    id: 'sovereign_yearly',
    name: 'Sovereign (Yearly)',
    priceId: 'price_sovereign_yearly',
    amount: 95988, // $959.88 (20% off)
    currency: 'USD',
    interval: 'year'
  }
];

class PaymentService {
  private stripe: any = null;

  async initialize(): Promise<void> {
    // Load Stripe.js dynamically
    if (typeof window !== 'undefined' && !this.stripe) {
      const { loadStripe } = await import('@stripe/stripe-js');
      this.stripe = await loadStripe(STRIPE_PUBLIC_KEY);
    }
  }

  /**
   * Create a checkout session for subscription
   */
  async createCheckoutSession(
    planId: string,
    customerId: string,
    successUrl: string,
    cancelUrl: string
  ): Promise<CheckoutSession> {
    const plan = PAYMENT_PLANS.find(p => p.id === planId);
    if (!plan) {
      throw new Error(`Invalid plan: ${planId}`);
    }

    // In production, this would call your backend API
    // which would create a Stripe checkout session
    const response = await fetch('/api/create-checkout-session', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        priceId: plan.priceId,
        customerId,
        successUrl,
        cancelUrl
      })
    });

    if (!response.ok) {
      // Fallback for demo mode
      console.log('🎭 Demo mode: Simulating checkout session');
      return {
        sessionId: `demo_session_${Date.now()}`,
        url: `${successUrl}?demo=true`
      };
    }

    return response.json();
  }

  /**
   * Redirect to Stripe checkout
   */
  async redirectToCheckout(sessionId: string): Promise<void> {
    if (!this.stripe) {
      await this.initialize();
    }
    
    if (sessionId.startsWith('demo_')) {
      console.log('🎭 Demo mode: Would redirect to Stripe checkout');
      return;
    }

    const result = await this.stripe?.redirectToCheckout({ sessionId });
    if (result?.error) {
      throw new Error(result.error.message);
    }
  }

  /**
   * Handle one-time payment (e.g., for credits)
   */
  async createPaymentIntent(
    amount: number,
    currency: string = 'usd',
    metadata?: Record<string, string>
  ): Promise<PaymentIntent> {
    const response = await fetch('/api/create-payment-intent', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ amount, currency, metadata })
    });

    if (!response.ok) {
      // Demo mode fallback
      return {
        id: `demo_pi_${Date.now()}`,
        status: 'pending',
        amount
      };
    }

    return response.json();
  }

  /**
   * Manage customer portal (update payment, cancel subscription)
   */
  async createPortalSession(customerId: string): Promise<string> {
    const response = await fetch('/api/create-portal-session', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ customerId })
    });

    if (!response.ok) {
      console.log('🎭 Demo mode: Would open customer portal');
      return '#';
    }

    const { url } = await response.json();
    return url;
  }

  /**
   * Apply promo code to subscription
   */
  async applyPromoCode(code: string, subscriptionId: string): Promise<{
    valid: boolean;
    discount?: number;
    message: string;
  }> {
    // Built-in promo codes
    const PROMO_CODES: Record<string, { discount: number; maxUses?: number }> = {
      'DRAGON2026': { discount: 50 },
      'LAUNCH30': { discount: 30 },
      'KHAWRIZM': { discount: 100, maxUses: 10 }, // VIP
      'HILO_VICTIM': { discount: 100 }, // Free for HILO fraud victims
      'EARLYBIRD': { discount: 40 }
    };

    const promo = PROMO_CODES[code.toUpperCase()];
    if (!promo) {
      return {
        valid: false,
        message: 'Invalid promo code'
      };
    }

    return {
      valid: true,
      discount: promo.discount,
      message: `${promo.discount}% discount applied!`
    };
  }

  /**
   * Calculate price with discount
   */
  calculateDiscountedPrice(amount: number, discountPercent: number): number {
    return Math.round(amount * (1 - discountPercent / 100));
  }

  /**
   * Format price for display
   */
  formatPrice(amount: number, currency: string = 'USD'): string {
    const formatter = new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency,
      minimumFractionDigits: 2
    });
    return formatter.format(amount / 100);
  }

  /**
   * Get plan by ID
   */
  getPlan(planId: string): PaymentPlan | undefined {
    return PAYMENT_PLANS.find(p => p.id === planId);
  }
}

export const paymentService = new PaymentService();
export default paymentService;

// Webhook handler types (for backend use)
export interface StripeWebhookEvent {
  type: string;
  data: {
    object: any;
  };
}

export interface WebhookHandlers {
  'checkout.session.completed': (session: any) => Promise<void>;
  'customer.subscription.created': (subscription: any) => Promise<void>;
  'customer.subscription.updated': (subscription: any) => Promise<void>;
  'customer.subscription.deleted': (subscription: any) => Promise<void>;
  'invoice.paid': (invoice: any) => Promise<void>;
  'invoice.payment_failed': (invoice: any) => Promise<void>;
}

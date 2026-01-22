/**
 * ╔═══════════════════════════════════════════════════════════════════════════════╗
 * ║                                                                               ║
 * ║   🐉 SOVEREIGN PLATFORM - SUBSCRIPTION & BILLING SYSTEM                       ║
 * ║   ═══════════════════════════════════════════                                 ║
 * ║                                                                               ║
 * ║   Revenue Model: Freemium SaaS with Usage-Based Pricing                       ║
 * ║                                                                               ║
 * ╚═══════════════════════════════════════════════════════════════════════════════╝
 */

import { create } from 'zustand';
import { persist } from 'zustand/middleware';

// ═══════════════════════════════════════════════════════════════════════════════
// 💰 PRICING TIERS
// ═══════════════════════════════════════════════════════════════════════════════

export enum PlanType {
  FREE = 'FREE',
  HUNTER = 'HUNTER',
  WARRIOR = 'WARRIOR', 
  SOVEREIGN = 'SOVEREIGN',
  ENTERPRISE = 'ENTERPRISE'
}

export interface PricingPlan {
  id: PlanType;
  name: string;
  nameAr: string;
  price: number; // USD per month
  priceYearly: number; // USD per year (2 months free)
  features: string[];
  limits: {
    aiMessages: number; // per day
    ttsMinutes: number; // per month
    imageGenerations: number; // per month
    storageGB: number;
    teamMembers: number;
  };
  badge?: string;
}

export const PRICING_PLANS: PricingPlan[] = [
  {
    id: PlanType.FREE,
    name: 'Free Scout',
    nameAr: 'كشاف مجاني',
    price: 0,
    priceYearly: 0,
    features: [
      '10 AI messages/day',
      'Basic text analysis',
      'Community support',
      '100MB storage'
    ],
    limits: {
      aiMessages: 10,
      ttsMinutes: 0,
      imageGenerations: 0,
      storageGB: 0.1,
      teamMembers: 1
    }
  },
  {
    id: PlanType.HUNTER,
    name: 'Hunter',
    nameAr: 'صياد',
    price: 9.99,
    priceYearly: 99.99,
    features: [
      '100 AI messages/day',
      'DeepSeek R1 access',
      '30 min TTS/month',
      '5 images/month',
      '5GB storage',
      'Email support'
    ],
    limits: {
      aiMessages: 100,
      ttsMinutes: 30,
      imageGenerations: 5,
      storageGB: 5,
      teamMembers: 1
    },
    badge: 'POPULAR'
  },
  {
    id: PlanType.WARRIOR,
    name: 'Warrior',
    nameAr: 'محارب',
    price: 29.99,
    priceYearly: 299.99,
    features: [
      'Unlimited AI messages',
      'All models (DeepSeek, Llama, GPT)',
      '120 min TTS/month',
      '50 images/month',
      '50GB storage',
      'Priority support',
      'API access'
    ],
    limits: {
      aiMessages: -1, // unlimited
      ttsMinutes: 120,
      imageGenerations: 50,
      storageGB: 50,
      teamMembers: 3
    },
    badge: 'BEST VALUE'
  },
  {
    id: PlanType.SOVEREIGN,
    name: 'Sovereign',
    nameAr: 'سيادي',
    price: 99.99,
    priceYearly: 999.99,
    features: [
      'Everything in Warrior',
      'Llama 405B access',
      'Unlimited TTS',
      'Unlimited images',
      '500GB storage',
      'White-label option',
      'Dedicated support',
      'Custom training'
    ],
    limits: {
      aiMessages: -1,
      ttsMinutes: -1,
      imageGenerations: -1,
      storageGB: 500,
      teamMembers: 10
    }
  },
  {
    id: PlanType.ENTERPRISE,
    name: 'Enterprise',
    nameAr: 'مؤسسي',
    price: -1, // Contact sales
    priceYearly: -1,
    features: [
      'Everything in Sovereign',
      'On-premise deployment',
      'Custom models',
      'SLA guarantee',
      'Dedicated infrastructure',
      'Unlimited everything'
    ],
    limits: {
      aiMessages: -1,
      ttsMinutes: -1,
      imageGenerations: -1,
      storageGB: -1,
      teamMembers: -1
    }
  }
];

// ═══════════════════════════════════════════════════════════════════════════════
// 📊 USAGE TRACKING
// ═══════════════════════════════════════════════════════════════════════════════

export interface UsageStats {
  aiMessagesToday: number;
  ttsMinutesThisMonth: number;
  imagesThisMonth: number;
  storageUsedGB: number;
  lastReset: string;
}

export interface UserSubscription {
  odId: string;
  email: string;
  plan: PlanType;
  status: 'active' | 'cancelled' | 'past_due' | 'trialing';
  currentPeriodEnd: string;
  usage: UsageStats;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🏪 SUBSCRIPTION STORE
// ═══════════════════════════════════════════════════════════════════════════════

interface SubscriptionStore {
  subscription: UserSubscription | null;
  isLoading: boolean;
  
  // Actions
  setSubscription: (sub: UserSubscription) => void;
  checkLimit: (type: 'ai' | 'tts' | 'image') => boolean;
  incrementUsage: (type: 'ai' | 'tts' | 'image', amount?: number) => void;
  canUseFeature: (feature: string) => boolean;
  getPlan: () => PricingPlan | undefined;
  resetDailyUsage: () => void;
}

export const useSubscriptionStore = create<SubscriptionStore>()(
  persist(
    (set, get) => ({
      subscription: null,
      isLoading: false,
      
      setSubscription: (sub) => set({ subscription: sub }),
      
      checkLimit: (type) => {
        const { subscription } = get();
        if (!subscription) return false;
        
        const plan = PRICING_PLANS.find(p => p.id === subscription.plan);
        if (!plan) return false;
        
        const { usage } = subscription;
        
        switch (type) {
          case 'ai':
            return plan.limits.aiMessages === -1 || usage.aiMessagesToday < plan.limits.aiMessages;
          case 'tts':
            return plan.limits.ttsMinutes === -1 || usage.ttsMinutesThisMonth < plan.limits.ttsMinutes;
          case 'image':
            return plan.limits.imageGenerations === -1 || usage.imagesThisMonth < plan.limits.imageGenerations;
          default:
            return false;
        }
      },
      
      incrementUsage: (type, amount = 1) => {
        const { subscription } = get();
        if (!subscription) return;
        
        set({
          subscription: {
            ...subscription,
            usage: {
              ...subscription.usage,
              ...(type === 'ai' && { aiMessagesToday: subscription.usage.aiMessagesToday + amount }),
              ...(type === 'tts' && { ttsMinutesThisMonth: subscription.usage.ttsMinutesThisMonth + amount }),
              ...(type === 'image' && { imagesThisMonth: subscription.usage.imagesThisMonth + amount })
            }
          }
        });
      },
      
      canUseFeature: (feature) => {
        const { subscription } = get();
        if (!subscription) return false;
        
        const plan = PRICING_PLANS.find(p => p.id === subscription.plan);
        if (!plan) return false;
        
        return plan.features.some(f => f.toLowerCase().includes(feature.toLowerCase()));
      },
      
      getPlan: () => {
        const { subscription } = get();
        if (!subscription) return PRICING_PLANS[0]; // Free plan
        return PRICING_PLANS.find(p => p.id === subscription.plan);
      },
      
      resetDailyUsage: () => {
        const { subscription } = get();
        if (!subscription) return;
        
        const today = new Date().toDateString();
        if (subscription.usage.lastReset !== today) {
          set({
            subscription: {
              ...subscription,
              usage: {
                ...subscription.usage,
                aiMessagesToday: 0,
                lastReset: today
              }
            }
          });
        }
      }
    }),
    {
      name: 'sovereign-subscription'
    }
  )
);

// ═══════════════════════════════════════════════════════════════════════════════
// 💳 PAYMENT INTEGRATION (Stripe-compatible)
// ═══════════════════════════════════════════════════════════════════════════════

export interface PaymentIntent {
  id: string;
  amount: number;
  currency: string;
  status: 'pending' | 'succeeded' | 'failed';
}

export async function createCheckoutSession(planId: PlanType, yearly: boolean = false): Promise<string> {
  // In production, this would call your backend which calls Stripe
  const plan = PRICING_PLANS.find(p => p.id === planId);
  if (!plan || plan.price === 0 || plan.price === -1) {
    throw new Error('Invalid plan for checkout');
  }
  
  const price = yearly ? plan.priceYearly : plan.price;
  
  // Simulated checkout URL - replace with actual Stripe integration
  const checkoutUrl = `https://checkout.stripe.com/pay/${planId}?amount=${price * 100}&currency=usd`;
  
  return checkoutUrl;
}

export async function cancelSubscription(): Promise<boolean> {
  // In production, call backend to cancel Stripe subscription
  useSubscriptionStore.getState().setSubscription({
    ...useSubscriptionStore.getState().subscription!,
    status: 'cancelled'
  });
  return true;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🎁 PROMOTIONAL CODES
// ═══════════════════════════════════════════════════════════════════════════════

export interface PromoCode {
  code: string;
  discount: number; // percentage
  validUntil: string;
  maxUses: number;
  currentUses: number;
}

const PROMO_CODES: PromoCode[] = [
  { code: 'DRAGON2026', discount: 50, validUntil: '2026-12-31', maxUses: 1000, currentUses: 0 },
  { code: 'KHAWRIZM', discount: 100, validUntil: '2027-01-01', maxUses: 10, currentUses: 0 }, // VIP
  { code: 'LAUNCH30', discount: 30, validUntil: '2026-03-01', maxUses: 500, currentUses: 0 }
];

export function validatePromoCode(code: string): PromoCode | null {
  const promo = PROMO_CODES.find(p => 
    p.code.toLowerCase() === code.toLowerCase() &&
    new Date(p.validUntil) > new Date() &&
    p.currentUses < p.maxUses
  );
  return promo || null;
}

export function applyPromoCode(code: string, price: number): number {
  const promo = validatePromoCode(code);
  if (!promo) return price;
  return price * (1 - promo.discount / 100);
}

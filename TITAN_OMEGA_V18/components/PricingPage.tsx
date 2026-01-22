/**
 * 🐉 SOVEREIGN PRICING PAGE
 * Beautiful, conversion-optimized pricing component
 */

import React, { useState } from 'react';
import { motion } from 'framer-motion';
import { Check, Zap, Crown, Shield, Building2, Sparkles } from 'lucide-react';
import { 
  PRICING_PLANS, 
  PlanType, 
  createCheckoutSession,
  validatePromoCode,
  applyPromoCode,
  useSubscriptionStore 
} from '../services/subscriptionService';

const PLAN_ICONS: Record<PlanType, React.ReactNode> = {
  [PlanType.FREE]: <Sparkles className="w-8 h-8" />,
  [PlanType.HUNTER]: <Zap className="w-8 h-8" />,
  [PlanType.WARRIOR]: <Shield className="w-8 h-8" />,
  [PlanType.SOVEREIGN]: <Crown className="w-8 h-8" />,
  [PlanType.ENTERPRISE]: <Building2 className="w-8 h-8" />
};

const PLAN_COLORS: Record<PlanType, string> = {
  [PlanType.FREE]: 'from-gray-500 to-gray-700',
  [PlanType.HUNTER]: 'from-green-500 to-emerald-700',
  [PlanType.WARRIOR]: 'from-blue-500 to-indigo-700',
  [PlanType.SOVEREIGN]: 'from-amber-500 to-orange-700',
  [PlanType.ENTERPRISE]: 'from-purple-500 to-violet-700'
};

interface PricingPageProps {
  lang?: 'AR' | 'EN';
  onClose?: () => void;
}

export const PricingPage: React.FC<PricingPageProps> = ({ lang = 'EN', onClose }) => {
  const [isYearly, setIsYearly] = useState(true);
  const [promoCode, setPromoCode] = useState('');
  const [promoApplied, setPromoApplied] = useState<{ code: string; discount: number } | null>(null);
  const [loading, setLoading] = useState<PlanType | null>(null);
  
  const { subscription } = useSubscriptionStore();
  const isArabic = lang === 'AR';
  
  const handlePromoCode = () => {
    const promo = validatePromoCode(promoCode);
    if (promo) {
      setPromoApplied({ code: promo.code, discount: promo.discount });
    } else {
      alert(isArabic ? 'كود غير صالح' : 'Invalid promo code');
    }
  };
  
  const handleSubscribe = async (planId: PlanType) => {
    if (planId === PlanType.FREE) {
      // Free plan - just activate
      alert(isArabic ? 'تم تفعيل الخطة المجانية!' : 'Free plan activated!');
      return;
    }
    
    if (planId === PlanType.ENTERPRISE) {
      window.open('mailto:enterprise@dragon403.com?subject=Enterprise Inquiry', '_blank');
      return;
    }
    
    setLoading(planId);
    try {
      const checkoutUrl = await createCheckoutSession(planId, isYearly);
      window.open(checkoutUrl, '_blank');
    } catch (error) {
      console.error('Checkout error:', error);
    } finally {
      setLoading(null);
    }
  };
  
  const getDisplayPrice = (price: number): string => {
    if (price === 0) return isArabic ? 'مجاني' : 'Free';
    if (price === -1) return isArabic ? 'تواصل معنا' : 'Contact Us';
    
    let finalPrice = isYearly ? price / 12 : price; // Show monthly equivalent
    if (promoApplied) {
      finalPrice = applyPromoCode(promoApplied.code, finalPrice);
    }
    
    return `$${finalPrice.toFixed(2)}`;
  };
  
  return (
    <div className={`min-h-screen bg-gradient-to-b from-gray-900 via-black to-gray-900 py-16 px-4 ${isArabic ? 'rtl' : 'ltr'}`}>
      {/* Header */}
      <div className="text-center mb-16">
        <motion.h1 
          initial={{ opacity: 0, y: -20 }}
          animate={{ opacity: 1, y: 0 }}
          className="text-5xl font-bold text-white mb-4"
        >
          {isArabic ? '🐉 اختر قوتك' : '🐉 Choose Your Power'}
        </motion.h1>
        <p className="text-gray-400 text-xl">
          {isArabic ? 'ذكاء اصطناعي سيادي - بدون قيود الشركات' : 'Sovereign AI - Free from Corporate Chains'}
        </p>
        
        {/* Billing Toggle */}
        <div className="flex items-center justify-center gap-4 mt-8">
          <span className={`text-lg ${!isYearly ? 'text-white' : 'text-gray-500'}`}>
            {isArabic ? 'شهري' : 'Monthly'}
          </span>
          <button
            onClick={() => setIsYearly(!isYearly)}
            className={`relative w-16 h-8 rounded-full transition-colors ${isYearly ? 'bg-green-500' : 'bg-gray-600'}`}
          >
            <motion.div
              animate={{ x: isYearly ? 32 : 4 }}
              className="absolute top-1 w-6 h-6 bg-white rounded-full shadow-lg"
            />
          </button>
          <span className={`text-lg ${isYearly ? 'text-white' : 'text-gray-500'}`}>
            {isArabic ? 'سنوي' : 'Yearly'}
            <span className="text-green-400 text-sm ml-2">
              {isArabic ? '(وفر شهرين!)' : '(Save 2 months!)'}
            </span>
          </span>
        </div>
        
        {/* Promo Code */}
        <div className="flex items-center justify-center gap-2 mt-6">
          <input
            type="text"
            value={promoCode}
            onChange={(e) => setPromoCode(e.target.value.toUpperCase())}
            placeholder={isArabic ? 'كود الخصم' : 'Promo Code'}
            className="px-4 py-2 bg-gray-800 border border-gray-700 rounded-lg text-white"
          />
          <button
            onClick={handlePromoCode}
            className="px-4 py-2 bg-green-600 hover:bg-green-700 rounded-lg text-white"
          >
            {isArabic ? 'تطبيق' : 'Apply'}
          </button>
        </div>
        {promoApplied && (
          <p className="text-green-400 mt-2">
            ✅ {promoApplied.discount}% {isArabic ? 'خصم مطبق!' : 'discount applied!'}
          </p>
        )}
      </div>
      
      {/* Pricing Cards */}
      <div className="max-w-7xl mx-auto grid grid-cols-1 md:grid-cols-2 lg:grid-cols-5 gap-6">
        {PRICING_PLANS.map((plan, index) => {
          const isCurrentPlan = subscription?.plan === plan.id;
          const isPremium = plan.id === PlanType.WARRIOR || plan.id === PlanType.SOVEREIGN;
          
          return (
            <motion.div
              key={plan.id}
              initial={{ opacity: 0, y: 30 }}
              animate={{ opacity: 1, y: 0 }}
              transition={{ delay: index * 0.1 }}
              className={`relative rounded-2xl overflow-hidden ${
                isPremium ? 'ring-2 ring-amber-500 scale-105' : ''
              }`}
            >
              {/* Badge */}
              {plan.badge && (
                <div className="absolute top-0 right-0 bg-gradient-to-r from-amber-500 to-orange-600 text-white text-xs font-bold px-3 py-1 rounded-bl-lg">
                  {plan.badge}
                </div>
              )}
              
              {/* Card Content */}
              <div className={`h-full bg-gradient-to-br ${PLAN_COLORS[plan.id]} p-1`}>
                <div className="h-full bg-gray-900 rounded-xl p-6 flex flex-col">
                  {/* Icon & Name */}
                  <div className="text-center mb-6">
                    <div className={`inline-flex p-3 rounded-xl bg-gradient-to-br ${PLAN_COLORS[plan.id]} mb-4`}>
                      {PLAN_ICONS[plan.id]}
                    </div>
                    <h3 className="text-2xl font-bold text-white">
                      {isArabic ? plan.nameAr : plan.name}
                    </h3>
                  </div>
                  
                  {/* Price */}
                  <div className="text-center mb-6">
                    <div className="text-4xl font-bold text-white">
                      {getDisplayPrice(isYearly ? plan.priceYearly : plan.price)}
                    </div>
                    {plan.price > 0 && (
                      <div className="text-gray-400 text-sm">
                        /{isArabic ? 'شهر' : 'month'}
                        {isYearly && ` (${isArabic ? 'سنوي' : 'billed yearly'})`}
                      </div>
                    )}
                  </div>
                  
                  {/* Features */}
                  <ul className="space-y-3 mb-8 flex-grow">
                    {plan.features.map((feature, i) => (
                      <li key={i} className="flex items-center gap-2 text-gray-300 text-sm">
                        <Check className="w-5 h-5 text-green-400 flex-shrink-0" />
                        <span>{feature}</span>
                      </li>
                    ))}
                  </ul>
                  
                  {/* CTA Button */}
                  <button
                    onClick={() => handleSubscribe(plan.id)}
                    disabled={isCurrentPlan || loading === plan.id}
                    className={`w-full py-3 rounded-lg font-bold transition-all ${
                      isCurrentPlan
                        ? 'bg-gray-700 text-gray-400 cursor-not-allowed'
                        : isPremium
                        ? 'bg-gradient-to-r from-amber-500 to-orange-600 hover:from-amber-600 hover:to-orange-700 text-white'
                        : 'bg-gray-700 hover:bg-gray-600 text-white'
                    }`}
                  >
                    {loading === plan.id ? (
                      <span className="animate-spin">⏳</span>
                    ) : isCurrentPlan ? (
                      isArabic ? 'خطتك الحالية' : 'Current Plan'
                    ) : plan.price === 0 ? (
                      isArabic ? 'ابدأ مجاناً' : 'Start Free'
                    ) : plan.price === -1 ? (
                      isArabic ? 'تواصل معنا' : 'Contact Sales'
                    ) : (
                      isArabic ? 'اشترك الآن' : 'Subscribe Now'
                    )}
                  </button>
                </div>
              </div>
            </motion.div>
          );
        })}
      </div>
      
      {/* Trust Badges */}
      <div className="max-w-4xl mx-auto mt-16 text-center">
        <div className="flex flex-wrap justify-center gap-8 text-gray-500">
          <div className="flex items-center gap-2">
            <Shield className="w-5 h-5" />
            <span>{isArabic ? 'دفع آمن' : 'Secure Payment'}</span>
          </div>
          <div className="flex items-center gap-2">
            <Zap className="w-5 h-5" />
            <span>{isArabic ? 'إلغاء فوري' : 'Cancel Anytime'}</span>
          </div>
          <div className="flex items-center gap-2">
            <Crown className="w-5 h-5" />
            <span>{isArabic ? 'ضمان 30 يوم' : '30-Day Guarantee'}</span>
          </div>
        </div>
      </div>
      
      {/* Close Button */}
      {onClose && (
        <button
          onClick={onClose}
          className="fixed top-4 right-4 text-gray-400 hover:text-white text-3xl"
        >
          ×
        </button>
      )}
    </div>
  );
};

export default PricingPage;

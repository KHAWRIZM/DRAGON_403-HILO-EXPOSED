/**
 * 🐉 SOVEREIGN LANDING PAGE
 * High-converting marketing page
 */

import React, { useState, useEffect } from 'react';
import { motion, useScroll, useTransform } from 'framer-motion';
import { 
  Zap, Shield, Globe, Brain, Mic, Image, 
  MessageSquare, ArrowRight, Check, Star,
  Play, ChevronDown
} from 'lucide-react';

interface LandingPageProps {
  lang?: 'AR' | 'EN';
  onGetStarted?: () => void;
}

const FEATURES = [
  {
    icon: Brain,
    title: 'Multi-Model AI',
    titleAr: 'ذكاء متعدد النماذج',
    desc: 'DeepSeek R1, Llama 405B, GPT-4o - all in one platform',
    descAr: 'DeepSeek R1، Llama 405B، GPT-4o - كلها في منصة واحدة'
  },
  {
    icon: Mic,
    title: 'Arabic Neural TTS',
    titleAr: 'صوت عربي عصبي',
    desc: 'Natural Arabic voices with emotional expression',
    descAr: 'أصوات عربية طبيعية مع تعبير عاطفي'
  },
  {
    icon: Image,
    title: 'DALL-E 3 Images',
    titleAr: 'صور DALL-E 3',
    desc: 'Generate stunning images from text',
    descAr: 'أنشئ صور مذهلة من النص'
  },
  {
    icon: Globe,
    title: '100+ Languages',
    titleAr: '+100 لغة',
    desc: 'Instant translation and localization',
    descAr: 'ترجمة فورية وتوطين'
  },
  {
    icon: Shield,
    title: 'Privacy First',
    titleAr: 'الخصوصية أولاً',
    desc: 'Your data never leaves our servers',
    descAr: 'بياناتك لا تغادر خوادمنا أبداً'
  },
  {
    icon: Zap,
    title: 'Lightning Fast',
    titleAr: 'سريع كالبرق',
    desc: 'Optimized for real-time responses',
    descAr: 'محسّن للردود الفورية'
  }
];

const TESTIMONIALS = [
  {
    name: 'Ahmed Al-Rashid',
    role: 'CEO, TechStartup',
    avatar: '👨‍💼',
    text: 'Finally, an AI platform that understands Arabic properly. Game changer for our business.',
    textAr: 'أخيراً، منصة ذكاء اصطناعي تفهم العربية بشكل صحيح. غيرت قواعد اللعبة لأعمالنا.'
  },
  {
    name: 'Sarah Chen',
    role: 'Research Scientist',
    avatar: '👩‍🔬',
    text: 'The multi-model approach means I always get the best answer. DeepSeek for reasoning, Llama for creativity.',
    textAr: 'النهج متعدد النماذج يعني أنني أحصل دائماً على أفضل إجابة.'
  },
  {
    name: 'Mohammed Hassan',
    role: 'Content Creator',
    avatar: '🎬',
    text: 'The Arabic TTS is incredible. My audience thinks I hired a voice actor!',
    textAr: 'الصوت العربي مذهل. جمهوري يظن أنني استأجرت ممثل صوتي!'
  }
];

const STATS = [
  { value: '500K+', label: 'Messages/Day', labelAr: 'رسالة/يوم' },
  { value: '99.9%', label: 'Uptime', labelAr: 'وقت التشغيل' },
  { value: '50ms', label: 'Avg Response', labelAr: 'متوسط الاستجابة' },
  { value: '10K+', label: 'Happy Users', labelAr: 'مستخدم سعيد' }
];

export const LandingPage: React.FC<LandingPageProps> = ({ lang = 'EN', onGetStarted }) => {
  const [showDemo, setShowDemo] = useState(false);
  const isArabic = lang === 'AR';
  const { scrollY } = useScroll();
  const heroOpacity = useTransform(scrollY, [0, 300], [1, 0]);
  const heroScale = useTransform(scrollY, [0, 300], [1, 0.95]);
  
  return (
    <div className={`min-h-screen bg-black text-white ${isArabic ? 'rtl font-arabic' : 'ltr'}`}>
      {/* Navigation */}
      <nav className="fixed top-0 left-0 right-0 z-50 bg-black/80 backdrop-blur-lg border-b border-gray-800">
        <div className="max-w-7xl mx-auto px-6 py-4 flex items-center justify-between">
          <div className="flex items-center gap-2">
            <span className="text-2xl">🐉</span>
            <span className="text-xl font-bold">DRAGON403</span>
          </div>
          
          <div className="hidden md:flex items-center gap-8">
            <a href="#features" className="text-gray-400 hover:text-white transition">
              {isArabic ? 'المميزات' : 'Features'}
            </a>
            <a href="#pricing" className="text-gray-400 hover:text-white transition">
              {isArabic ? 'الأسعار' : 'Pricing'}
            </a>
            <a href="#testimonials" className="text-gray-400 hover:text-white transition">
              {isArabic ? 'آراء العملاء' : 'Testimonials'}
            </a>
          </div>
          
          <div className="flex items-center gap-4">
            <button className="text-gray-400 hover:text-white transition">
              {isArabic ? 'EN' : 'عربي'}
            </button>
            <button
              onClick={onGetStarted}
              className="px-4 py-2 bg-gradient-to-r from-amber-500 to-orange-600 rounded-lg font-medium hover:opacity-90 transition"
            >
              {isArabic ? 'ابدأ مجاناً' : 'Start Free'}
            </button>
          </div>
        </div>
      </nav>
      
      {/* Hero Section */}
      <motion.section 
        style={{ opacity: heroOpacity, scale: heroScale }}
        className="relative min-h-screen flex items-center justify-center px-6 pt-20"
      >
        {/* Background */}
        <div className="absolute inset-0 bg-[radial-gradient(ellipse_at_top,_var(--tw-gradient-stops))] from-red-900/30 via-black to-black" />
        <div className="absolute inset-0 bg-grid-pattern bg-[size:50px_50px] opacity-10" />
        
        <div className="relative z-10 max-w-5xl mx-auto text-center">
          {/* Badge */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="inline-flex items-center gap-2 px-4 py-2 bg-amber-500/10 border border-amber-500/30 rounded-full text-amber-400 text-sm mb-8"
          >
            <Zap className="w-4 h-4" />
            {isArabic ? 'الإصدار 2.0 متاح الآن!' : 'Version 2.0 Now Available!'}
          </motion.div>
          
          {/* Headline */}
          <motion.h1
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ delay: 0.1 }}
            className="text-5xl md:text-7xl font-bold mb-6 leading-tight"
          >
            {isArabic ? (
              <>
                ذكاء اصطناعي
                <span className="text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-orange-500"> سيادي </span>
                بلا قيود
              </>
            ) : (
              <>
                Sovereign AI
                <span className="text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-orange-500"> Without </span>
                Limits
              </>
            )}
          </motion.h1>
          
          {/* Subheadline */}
          <motion.p
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ delay: 0.2 }}
            className="text-xl md:text-2xl text-gray-400 mb-10 max-w-3xl mx-auto"
          >
            {isArabic
              ? 'منصة واحدة، نماذج متعددة. DeepSeek للتفكير، Llama للإبداع، وصوت عربي طبيعي.'
              : 'One platform, multiple models. DeepSeek for reasoning, Llama for creativity, and natural Arabic voice.'
            }
          </motion.p>
          
          {/* CTAs */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ delay: 0.3 }}
            className="flex flex-col sm:flex-row items-center justify-center gap-4"
          >
            <button
              onClick={onGetStarted}
              className="group px-8 py-4 bg-gradient-to-r from-amber-500 to-orange-600 rounded-xl font-bold text-lg hover:opacity-90 transition flex items-center gap-2"
            >
              {isArabic ? 'ابدأ مجاناً' : 'Start Free Trial'}
              <ArrowRight className="w-5 h-5 group-hover:translate-x-1 transition" />
            </button>
            <button
              onClick={() => setShowDemo(true)}
              className="px-8 py-4 border border-gray-700 hover:border-gray-600 rounded-xl font-bold text-lg transition flex items-center gap-2"
            >
              <Play className="w-5 h-5" />
              {isArabic ? 'شاهد العرض' : 'Watch Demo'}
            </button>
          </motion.div>
          
          {/* Stats */}
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            transition={{ delay: 0.4 }}
            className="grid grid-cols-2 md:grid-cols-4 gap-8 mt-16 pt-16 border-t border-gray-800"
          >
            {STATS.map((stat, i) => (
              <div key={i} className="text-center">
                <div className="text-3xl md:text-4xl font-bold text-amber-400">{stat.value}</div>
                <div className="text-gray-500">{isArabic ? stat.labelAr : stat.label}</div>
              </div>
            ))}
          </motion.div>
        </div>
        
        {/* Scroll Indicator */}
        <motion.div
          animate={{ y: [0, 10, 0] }}
          transition={{ duration: 2, repeat: Infinity }}
          className="absolute bottom-10 left-1/2 -translate-x-1/2"
        >
          <ChevronDown className="w-8 h-8 text-gray-600" />
        </motion.div>
      </motion.section>
      
      {/* Features Section */}
      <section id="features" className="py-24 px-6">
        <div className="max-w-7xl mx-auto">
          <div className="text-center mb-16">
            <h2 className="text-4xl font-bold mb-4">
              {isArabic ? 'لماذا DRAGON403؟' : 'Why DRAGON403?'}
            </h2>
            <p className="text-gray-400 text-lg max-w-2xl mx-auto">
              {isArabic
                ? 'نجمع أفضل نماذج الذكاء الاصطناعي في منصة واحدة، مع دعم كامل للغة العربية.'
                : 'We combine the best AI models in one platform, with full Arabic language support.'
              }
            </p>
          </div>
          
          <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
            {FEATURES.map((feature, i) => (
              <motion.div
                key={i}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: i * 0.1 }}
                className="p-6 bg-gray-900/50 border border-gray-800 rounded-2xl hover:border-amber-500/50 transition group"
              >
                <div className="w-12 h-12 bg-gradient-to-br from-amber-500 to-orange-600 rounded-xl flex items-center justify-center mb-4 group-hover:scale-110 transition">
                  <feature.icon className="w-6 h-6" />
                </div>
                <h3 className="text-xl font-bold mb-2">
                  {isArabic ? feature.titleAr : feature.title}
                </h3>
                <p className="text-gray-400">
                  {isArabic ? feature.descAr : feature.desc}
                </p>
              </motion.div>
            ))}
          </div>
        </div>
      </section>
      
      {/* Testimonials */}
      <section id="testimonials" className="py-24 px-6 bg-gray-900/30">
        <div className="max-w-7xl mx-auto">
          <div className="text-center mb-16">
            <h2 className="text-4xl font-bold mb-4">
              {isArabic ? 'ماذا يقول عملاؤنا' : 'What Our Users Say'}
            </h2>
          </div>
          
          <div className="grid md:grid-cols-3 gap-6">
            {TESTIMONIALS.map((t, i) => (
              <motion.div
                key={i}
                initial={{ opacity: 0, y: 20 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: i * 0.1 }}
                className="p-6 bg-black border border-gray-800 rounded-2xl"
              >
                <div className="flex items-center gap-1 mb-4">
                  {[...Array(5)].map((_, i) => (
                    <Star key={i} className="w-5 h-5 fill-amber-400 text-amber-400" />
                  ))}
                </div>
                <p className="text-gray-300 mb-6">
                  "{isArabic ? t.textAr : t.text}"
                </p>
                <div className="flex items-center gap-3">
                  <span className="text-3xl">{t.avatar}</span>
                  <div>
                    <div className="font-medium">{t.name}</div>
                    <div className="text-gray-500 text-sm">{t.role}</div>
                  </div>
                </div>
              </motion.div>
            ))}
          </div>
        </div>
      </section>
      
      {/* CTA Section */}
      <section className="py-24 px-6">
        <div className="max-w-4xl mx-auto text-center">
          <motion.div
            initial={{ opacity: 0, scale: 0.95 }}
            whileInView={{ opacity: 1, scale: 1 }}
            viewport={{ once: true }}
            className="p-12 bg-gradient-to-br from-amber-500/10 to-orange-600/10 border border-amber-500/30 rounded-3xl"
          >
            <h2 className="text-4xl font-bold mb-4">
              {isArabic ? 'جاهز للبدء؟' : 'Ready to Start?'}
            </h2>
            <p className="text-gray-400 text-lg mb-8">
              {isArabic
                ? 'ابدأ مجاناً. لا حاجة لبطاقة ائتمان.'
                : 'Start free today. No credit card required.'
              }
            </p>
            <button
              onClick={onGetStarted}
              className="px-8 py-4 bg-gradient-to-r from-amber-500 to-orange-600 rounded-xl font-bold text-lg hover:opacity-90 transition"
            >
              {isArabic ? 'ابدأ مجاناً الآن' : 'Start Free Now'}
            </button>
          </motion.div>
        </div>
      </section>
      
      {/* Footer */}
      <footer className="py-12 px-6 border-t border-gray-800">
        <div className="max-w-7xl mx-auto flex flex-col md:flex-row items-center justify-between gap-6">
          <div className="flex items-center gap-2">
            <span className="text-2xl">🐉</span>
            <span className="font-bold">DRAGON403</span>
          </div>
          <div className="flex items-center gap-6 text-gray-400 text-sm">
            <a href="#" className="hover:text-white">{isArabic ? 'الشروط' : 'Terms'}</a>
            <a href="#" className="hover:text-white">{isArabic ? 'الخصوصية' : 'Privacy'}</a>
            <a href="#" className="hover:text-white">{isArabic ? 'تواصل' : 'Contact'}</a>
          </div>
          <div className="text-gray-500 text-sm">
            © 2026 Dragon403. {isArabic ? 'جميع الحقوق محفوظة' : 'All rights reserved.'}
          </div>
        </div>
      </footer>
    </div>
  );
};

export default LandingPage;

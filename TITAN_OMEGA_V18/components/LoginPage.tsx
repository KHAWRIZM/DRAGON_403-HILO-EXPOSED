/**
 * 🐉 SOVEREIGN LOGIN PAGE
 * Beautiful, conversion-optimized authentication
 */

import React, { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { Mail, Github, Loader2, Shield, Zap, Eye, EyeOff } from 'lucide-react';
import { useAuthStore, sendMagicLink, getGoogleAuthUrl, getGitHubAuthUrl } from '../services/authService';

interface LoginPageProps {
  lang?: 'AR' | 'EN';
  onSuccess?: () => void;
}

export const LoginPage: React.FC<LoginPageProps> = ({ lang = 'EN', onSuccess }) => {
  const [email, setEmail] = useState('');
  const [showEmailForm, setShowEmailForm] = useState(false);
  const [magicLinkSent, setMagicLinkSent] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  
  const { login, loginAnonymous, error } = useAuthStore();
  const isArabic = lang === 'AR';
  
  const handleGoogleLogin = () => {
    window.location.href = getGoogleAuthUrl();
  };
  
  const handleGitHubLogin = () => {
    window.location.href = getGitHubAuthUrl();
  };
  
  const handleEmailLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!email) return;
    
    setIsLoading(true);
    const sent = await sendMagicLink(email);
    if (sent) {
      setMagicLinkSent(true);
    }
    setIsLoading(false);
  };
  
  const handleGuestAccess = async () => {
    setIsLoading(true);
    await loginAnonymous();
    setIsLoading(false);
    onSuccess?.();
  };
  
  // Animated dragon eyes
  const DragonEyes = () => (
    <div className="relative w-32 h-16 mx-auto mb-8">
      <motion.div
        animate={{ 
          scale: [1, 1.1, 1],
          opacity: [0.8, 1, 0.8]
        }}
        transition={{ duration: 2, repeat: Infinity }}
        className="absolute left-4 w-10 h-10 bg-gradient-to-br from-red-500 to-orange-600 rounded-full shadow-lg shadow-red-500/50"
      >
        <div className="absolute inset-2 bg-black rounded-full flex items-center justify-center">
          <div className="w-1 h-4 bg-red-500 rounded-full" />
        </div>
      </motion.div>
      <motion.div
        animate={{ 
          scale: [1, 1.1, 1],
          opacity: [0.8, 1, 0.8]
        }}
        transition={{ duration: 2, repeat: Infinity, delay: 0.3 }}
        className="absolute right-4 w-10 h-10 bg-gradient-to-br from-red-500 to-orange-600 rounded-full shadow-lg shadow-red-500/50"
      >
        <div className="absolute inset-2 bg-black rounded-full flex items-center justify-center">
          <div className="w-1 h-4 bg-red-500 rounded-full" />
        </div>
      </motion.div>
    </div>
  );
  
  return (
    <div className={`min-h-screen bg-black flex items-center justify-center p-4 ${isArabic ? 'rtl' : 'ltr'}`}>
      {/* Background Effects */}
      <div className="absolute inset-0 overflow-hidden">
        <div className="absolute inset-0 bg-[radial-gradient(ellipse_at_center,_var(--tw-gradient-stops))] from-red-900/20 via-black to-black" />
        <motion.div
          animate={{ rotate: 360 }}
          transition={{ duration: 100, repeat: Infinity, ease: 'linear' }}
          className="absolute -top-1/2 -left-1/2 w-full h-full border border-red-900/20 rounded-full"
        />
        <motion.div
          animate={{ rotate: -360 }}
          transition={{ duration: 80, repeat: Infinity, ease: 'linear' }}
          className="absolute -bottom-1/2 -right-1/2 w-full h-full border border-amber-900/20 rounded-full"
        />
      </div>
      
      {/* Login Card */}
      <motion.div
        initial={{ opacity: 0, y: 20 }}
        animate={{ opacity: 1, y: 0 }}
        className="relative z-10 w-full max-w-md"
      >
        <div className="bg-gradient-to-br from-gray-900/90 to-black/90 backdrop-blur-xl rounded-2xl p-8 border border-gray-800 shadow-2xl">
          {/* Logo */}
          <DragonEyes />
          
          <h1 className="text-3xl font-bold text-center text-white mb-2">
            {isArabic ? '🐉 منصة التنين' : '🐉 DRAGON403'}
          </h1>
          <p className="text-gray-400 text-center mb-8">
            {isArabic ? 'ذكاء اصطناعي سيادي' : 'Sovereign AI Platform'}
          </p>
          
          <AnimatePresence mode="wait">
            {magicLinkSent ? (
              <motion.div
                key="magic-sent"
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                exit={{ opacity: 0 }}
                className="text-center py-8"
              >
                <div className="w-16 h-16 bg-green-500/20 rounded-full flex items-center justify-center mx-auto mb-4">
                  <Mail className="w-8 h-8 text-green-400" />
                </div>
                <h3 className="text-xl font-bold text-white mb-2">
                  {isArabic ? 'تحقق من بريدك!' : 'Check Your Email!'}
                </h3>
                <p className="text-gray-400">
                  {isArabic 
                    ? `أرسلنا رابط تسجيل دخول إلى ${email}`
                    : `We sent a magic link to ${email}`
                  }
                </p>
                <button
                  onClick={() => setMagicLinkSent(false)}
                  className="mt-4 text-amber-400 hover:text-amber-300"
                >
                  {isArabic ? 'جرب طريقة أخرى' : 'Try another method'}
                </button>
              </motion.div>
            ) : showEmailForm ? (
              <motion.form
                key="email-form"
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                exit={{ opacity: 0 }}
                onSubmit={handleEmailLogin}
                className="space-y-4"
              >
                <input
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  placeholder={isArabic ? 'بريدك الإلكتروني' : 'your@email.com'}
                  className="w-full px-4 py-3 bg-gray-800/50 border border-gray-700 rounded-xl text-white placeholder-gray-500 focus:outline-none focus:border-amber-500"
                  required
                />
                <button
                  type="submit"
                  disabled={isLoading}
                  className="w-full py-3 bg-gradient-to-r from-amber-500 to-orange-600 hover:from-amber-600 hover:to-orange-700 text-white font-bold rounded-xl transition-all flex items-center justify-center gap-2"
                >
                  {isLoading ? (
                    <Loader2 className="w-5 h-5 animate-spin" />
                  ) : (
                    <>
                      <Mail className="w-5 h-5" />
                      {isArabic ? 'إرسال رابط الدخول' : 'Send Magic Link'}
                    </>
                  )}
                </button>
                <button
                  type="button"
                  onClick={() => setShowEmailForm(false)}
                  className="w-full text-gray-400 hover:text-white text-sm"
                >
                  {isArabic ? '← رجوع' : '← Back'}
                </button>
              </motion.form>
            ) : (
              <motion.div
                key="social-buttons"
                initial={{ opacity: 0 }}
                animate={{ opacity: 1 }}
                exit={{ opacity: 0 }}
                className="space-y-3"
              >
                {/* Google */}
                <button
                  onClick={handleGoogleLogin}
                  className="w-full py-3 bg-white hover:bg-gray-100 text-gray-900 font-medium rounded-xl transition-all flex items-center justify-center gap-3"
                >
                  <svg className="w-5 h-5" viewBox="0 0 24 24">
                    <path fill="#4285F4" d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z"/>
                    <path fill="#34A853" d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z"/>
                    <path fill="#FBBC05" d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z"/>
                    <path fill="#EA4335" d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z"/>
                  </svg>
                  {isArabic ? 'الدخول بجوجل' : 'Continue with Google'}
                </button>
                
                {/* GitHub */}
                <button
                  onClick={handleGitHubLogin}
                  className="w-full py-3 bg-gray-800 hover:bg-gray-700 text-white font-medium rounded-xl transition-all flex items-center justify-center gap-3 border border-gray-700"
                >
                  <Github className="w-5 h-5" />
                  {isArabic ? 'الدخول بجيتهب' : 'Continue with GitHub'}
                </button>
                
                {/* Email */}
                <button
                  onClick={() => setShowEmailForm(true)}
                  className="w-full py-3 bg-gray-800/50 hover:bg-gray-700/50 text-white font-medium rounded-xl transition-all flex items-center justify-center gap-3 border border-gray-700"
                >
                  <Mail className="w-5 h-5" />
                  {isArabic ? 'الدخول بالبريد' : 'Continue with Email'}
                </button>
                
                <div className="relative my-6">
                  <div className="absolute inset-0 flex items-center">
                    <div className="w-full border-t border-gray-700" />
                  </div>
                  <div className="relative flex justify-center text-sm">
                    <span className="px-2 bg-gray-900 text-gray-500">
                      {isArabic ? 'أو' : 'or'}
                    </span>
                  </div>
                </div>
                
                {/* Guest Access */}
                <button
                  onClick={handleGuestAccess}
                  disabled={isLoading}
                  className="w-full py-3 border-2 border-dashed border-gray-700 hover:border-amber-500/50 text-gray-400 hover:text-amber-400 font-medium rounded-xl transition-all flex items-center justify-center gap-2"
                >
                  {isLoading ? (
                    <Loader2 className="w-5 h-5 animate-spin" />
                  ) : (
                    <>
                      <Zap className="w-5 h-5" />
                      {isArabic ? 'دخول كضيف (محدود)' : 'Guest Access (Limited)'}
                    </>
                  )}
                </button>
              </motion.div>
            )}
          </AnimatePresence>
          
          {/* Error */}
          {error && (
            <p className="mt-4 text-red-400 text-center text-sm">{error}</p>
          )}
          
          {/* Terms */}
          <p className="mt-6 text-gray-500 text-xs text-center">
            {isArabic 
              ? 'بالدخول، توافق على شروط الخدمة وسياسة الخصوصية'
              : 'By continuing, you agree to our Terms & Privacy Policy'
            }
          </p>
        </div>
        
        {/* Trust Badges */}
        <div className="flex justify-center gap-6 mt-6 text-gray-600 text-sm">
          <div className="flex items-center gap-1">
            <Shield className="w-4 h-4" />
            <span>{isArabic ? 'تشفير E2E' : 'E2E Encrypted'}</span>
          </div>
          <div className="flex items-center gap-1">
            <Zap className="w-4 h-4" />
            <span>{isArabic ? 'بدون تتبع' : 'No Tracking'}</span>
          </div>
        </div>
      </motion.div>
    </div>
  );
};

export default LoginPage;

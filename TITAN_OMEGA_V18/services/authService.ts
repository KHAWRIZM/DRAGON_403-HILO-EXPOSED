/**
 * ╔═══════════════════════════════════════════════════════════════════════════════╗
 * ║   🔐 SOVEREIGN AUTHENTICATION SYSTEM                                          ║
 * ║   Social Login + Email Magic Link + Anonymous Guest                           ║
 * ╚═══════════════════════════════════════════════════════════════════════════════╝
 */

import { create } from 'zustand';
import { persist } from 'zustand/middleware';
import { PlanType, useSubscriptionStore, UsageStats } from './subscriptionService';

// ═══════════════════════════════════════════════════════════════════════════════
// 👤 USER TYPES
// ═══════════════════════════════════════════════════════════════════════════════

export interface User {
  id: string;
  email?: string;
  displayName: string;
  photoURL?: string;
  provider: 'google' | 'github' | 'email' | 'anonymous';
  createdAt: string;
  lastLoginAt: string;
  metadata: {
    locale: string;
    timezone: string;
    referrer?: string;
    utmSource?: string;
    utmCampaign?: string;
  };
}

export interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  isLoading: boolean;
  error: string | null;
  
  // Actions
  login: (provider: 'google' | 'github' | 'email', credential?: string) => Promise<void>;
  loginAnonymous: () => Promise<void>;
  logout: () => void;
  updateProfile: (updates: Partial<User>) => void;
}

// ═══════════════════════════════════════════════════════════════════════════════
// 🏪 AUTH STORE
// ═══════════════════════════════════════════════════════════════════════════════

export const useAuthStore = create<AuthState>()(
  persist(
    (set, get) => ({
      user: null,
      isAuthenticated: false,
      isLoading: false,
      error: null,
      
      login: async (provider, credential) => {
        set({ isLoading: true, error: null });
        
        try {
          // In production, this would call your OAuth backend
          const mockUser: User = {
            id: `user_${Date.now()}`,
            email: credential || `user_${Date.now()}@sovereign.ai`,
            displayName: provider === 'google' ? 'Google User' : 'Sovereign User',
            provider,
            createdAt: new Date().toISOString(),
            lastLoginAt: new Date().toISOString(),
            metadata: {
              locale: navigator.language,
              timezone: Intl.DateTimeFormat().resolvedOptions().timeZone,
              referrer: document.referrer,
              utmSource: new URLSearchParams(window.location.search).get('utm_source') || undefined,
              utmCampaign: new URLSearchParams(window.location.search).get('utm_campaign') || undefined
            }
          };
          
          // Initialize with free plan
          const { setSubscription } = useSubscriptionStore.getState();
          setSubscription({
            odId: mockUser.id,
            email: mockUser.email || '',
            plan: PlanType.FREE,
            status: 'active',
            currentPeriodEnd: new Date(Date.now() + 365 * 24 * 60 * 60 * 1000).toISOString(),
            usage: {
              aiMessagesToday: 0,
              ttsMinutesThisMonth: 0,
              imagesThisMonth: 0,
              storageUsedGB: 0,
              lastReset: new Date().toDateString()
            }
          });
          
          set({ user: mockUser, isAuthenticated: true, isLoading: false });
          
        } catch (error) {
          set({ error: (error as Error).message, isLoading: false });
        }
      },
      
      loginAnonymous: async () => {
        set({ isLoading: true, error: null });
        
        const guestId = localStorage.getItem('sovereign_guest_id') || `guest_${Date.now()}`;
        localStorage.setItem('sovereign_guest_id', guestId);
        
        const guestUser: User = {
          id: guestId,
          displayName: 'Guest Operator',
          provider: 'anonymous',
          createdAt: new Date().toISOString(),
          lastLoginAt: new Date().toISOString(),
          metadata: {
            locale: navigator.language,
            timezone: Intl.DateTimeFormat().resolvedOptions().timeZone
          }
        };
        
        // Guest gets limited free plan
        const { setSubscription } = useSubscriptionStore.getState();
        setSubscription({
          odId: guestUser.id,
          email: '',
          plan: PlanType.FREE,
          status: 'active',
          currentPeriodEnd: new Date(Date.now() + 7 * 24 * 60 * 60 * 1000).toISOString(), // 7 days
          usage: {
            aiMessagesToday: 0,
            ttsMinutesThisMonth: 0,
            imagesThisMonth: 0,
            storageUsedGB: 0,
            lastReset: new Date().toDateString()
          }
        });
        
        set({ user: guestUser, isAuthenticated: true, isLoading: false });
      },
      
      logout: () => {
        set({ user: null, isAuthenticated: false, error: null });
        useSubscriptionStore.getState().setSubscription(null as any);
      },
      
      updateProfile: (updates) => {
        const { user } = get();
        if (user) {
          set({ user: { ...user, ...updates } });
        }
      }
    }),
    {
      name: 'sovereign-auth'
    }
  )
);

// ═══════════════════════════════════════════════════════════════════════════════
// 🔗 OAUTH HELPERS (Replace with actual implementation)
// ═══════════════════════════════════════════════════════════════════════════════

export function getGoogleAuthUrl(): string {
  // In production: return actual Google OAuth URL
  const clientId = import.meta.env.VITE_GOOGLE_CLIENT_ID || 'YOUR_CLIENT_ID';
  const redirectUri = `${window.location.origin}/auth/callback`;
  return `https://accounts.google.com/o/oauth2/v2/auth?client_id=${clientId}&redirect_uri=${redirectUri}&response_type=code&scope=email%20profile`;
}

export function getGitHubAuthUrl(): string {
  const clientId = import.meta.env.VITE_GITHUB_CLIENT_ID || 'YOUR_CLIENT_ID';
  const redirectUri = `${window.location.origin}/auth/callback`;
  return `https://github.com/login/oauth/authorize?client_id=${clientId}&redirect_uri=${redirectUri}&scope=user:email`;
}

export async function sendMagicLink(email: string): Promise<boolean> {
  // In production: call your backend to send magic link email
  console.log(`Magic link sent to: ${email}`);
  return true;
}

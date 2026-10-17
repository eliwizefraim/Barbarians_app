import { createClient } from '@supabase/supabase-js';
import Constants from 'expo-constants';

// Try several places where Expo apps commonly expose public values:
// 1. process.env (when using babel plugin or Metro env injection)
// 2. app.config.extra / expoConfig.extra (EAS / app.config.js)
// 3. Constants.manifest?.extra (older Expo manifests)

const SUPABASE_URL =
  process.env.EXPO_PUBLIC_SUPABASE_URL ||
  Constants.expoConfig?.extra?.EXPO_PUBLIC_SUPABASE_URL ||
  Constants.manifest?.extra?.EXPO_PUBLIC_SUPABASE_URL;

const SUPABASE_ANON_KEY =
  process.env.EXPO_PUBLIC_SUPABASE_ANON_KEY ||
  Constants.expoConfig?.extra?.EXPO_PUBLIC_SUPABASE_ANON_KEY ||
  Constants.manifest?.extra?.EXPO_PUBLIC_SUPABASE_ANON_KEY;

if (!SUPABASE_URL || !SUPABASE_ANON_KEY) {
  console.warn(
    'Supabase environment variables are missing. Add EXPO_PUBLIC_SUPABASE_URL and EXPO_PUBLIC_SUPABASE_ANON_KEY to your .env (or to app.json expo.extra / EAS secrets).'
  );
}

export const supabase = createClient(
  SUPABASE_URL || 'https://example.supabase.co',
  SUPABASE_ANON_KEY || 'demo-anon-key',
  {
    auth: {
      persistSession: true,
      autoRefreshToken: true,
      detectSessionInUrl: false,
    },
  }
);

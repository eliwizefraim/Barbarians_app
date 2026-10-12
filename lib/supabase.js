import { createClient } from '@supabase/supabase-js';

const supabaseUrl = 'WEKA_SUPABASE_URL_HAPA';
const supabaseKey = 'WEKA_SUPABASE_PUBLISHABLE_KEY_HAPA';

export const supabase = createClient(
  supabaseUrl,
  supabaseKey
);

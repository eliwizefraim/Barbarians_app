# Barbarians_app

App hii ni programu ya Expo / React Native yenye UI ya kuvutia ya kuvutia kwa jamii ya "Barbarians". Hivi sasa iko kwenye hatua ya mpango wa UI na inahitaji kusanidi Supabase kabla ya kuunganishwa kwa data halisi.

## Maelekezo ya haraka

1. Nakili `.env.example` na uiweke `.env`
2. Weka thamani zako za Supabase
3. Fungua repo na usakinishe dependencies
4. Zindua app na Expo

## Setup

```bash
npm install
cp .env.example .env
npm run start
```

## Env variables inayohitajika

```env
EXPO_PUBLIC_SUPABASE_URL=https://your-project.supabase.co
EXPO_PUBLIC_SUPABASE_ANON_KEY=your-anon-key
```

## Run app

```bash
npm run android
# au
npm run web
```

## Kitu kinachohitaji kukamilika

- Supabase URL na anon key zinapaswa kuwekwa kwa usalama
- README hii inafaa kutokomeza baada ya app kuanza kutumia DB
- Kama unatumia `MainActivity.kt`, hakikisha Android project inaonekana vizuri na imesakinishwa kwa kitambulisho sahihi
- Kifaa cha icon na assets kinafaa kubadilishwa na picha halisi

## Mafunzo ya ziada

- Tumia Expo secrets/EAS secrets kwa production
- Usikabidhi `SUPABASE_SERVICE_ROLE_KEY` kwenye client-side app
- Tumia anon key tu kwenye frontend, na service role key kwenye backend/server only

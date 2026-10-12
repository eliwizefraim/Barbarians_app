import React from 'react';
import {
  SafeAreaView,
  View,
  Text,
  StyleSheet,
  ScrollView,
  TouchableOpacity,
} from 'react-native';

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <ScrollView showsVerticalScrollIndicator={false}>
        <View style={styles.header}>
          <View>
            <Text style={styles.brand}>BARBARIANS</Text>
            <Text style={styles.subtitle}>THINK. SPEAK. CONNECT.</Text>
          </View>

          <TouchableOpacity style={styles.profile}>
            <Text style={styles.profileText}>B</Text>
          </TouchableOpacity>
        </View>

        <View style={styles.hero}>
          <Text style={styles.heroSmall}>GLOBAL DISCUSSIONS</Text>
          <Text style={styles.heroTitle}>
            Ideas that{'\n'}move people.
          </Text>
          <Text style={styles.heroText}>
            Join conversations, discover opinions and build communities.
          </Text>

          <TouchableOpacity style={styles.button}>
            <Text style={styles.buttonText}>START DISCUSSING</Text>
          </TouchableOpacity>
        </View>

        <View style={styles.sectionHeader}>
          <Text style={styles.sectionTitle}>TRENDING</Text>
          <Text style={styles.seeAll}>See all</Text>
        </View>

        {[
          ['01', 'Is AI changing the way humans think?', '2.4K'],
          ['02', 'What does success really mean?', '1.8K'],
          ['03', 'The future of Africa is digital.', '1.2K'],
        ].map(([number, title, votes]) => (
          <TouchableOpacity style={styles.card} key={number}>
            <Text style={styles.number}>{number}</Text>

            <View style={styles.cardContent}>
              <Text style={styles.cardTitle}>{title}</Text>
              <Text style={styles.cardMeta}>{votes} UPVOTES • DISCUSSION</Text>
            </View>

            <Text style={styles.arrow}>›</Text>
          </TouchableOpacity>
        ))}
      </ScrollView>

      <View style={styles.nav}>
        <Text style={styles.navActive}>HOME</Text>
        <Text style={styles.navItem}>DISCUSS</Text>
        <Text style={styles.navItem}>COMMUNITIES</Text>
        <Text style={styles.navItem}>PROFILE</Text>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#0A0A0A',
  },

  header: {
    paddingHorizontal: 22,
    paddingTop: 18,
    paddingBottom: 20,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },

  brand: {
    color: '#FFFFFF',
    fontSize: 22,
    fontWeight: '900',
    letterSpacing: 3,
  },

  subtitle: {
    color: '#777777',
    fontSize: 8,
    letterSpacing: 2,
    marginTop: 4,
  },

  profile: {
    width: 40,
    height: 40,
    borderRadius: 20,
    borderWidth: 1,
    borderColor: '#333333',
    justifyContent: 'center',
    alignItems: 'center',
  },

  profileText: {
    color: '#FFFFFF',
    fontWeight: '800',
  },

  hero: {
    marginHorizontal: 18,
    padding: 26,
    minHeight: 330,
    borderRadius: 24,
    backgroundColor: '#151515',
    justifyContent: 'flex-end',
  },

  heroSmall: {
    color: '#888888',
    fontSize: 10,
    fontWeight: '700',
    letterSpacing: 2,
    marginBottom: 12,
  },

  heroTitle: {
    color: '#FFFFFF',
    fontSize: 42,
    lineHeight: 45,
    fontWeight: '900',
    letterSpacing: -1,
  },

  heroText: {
    color: '#999999',
    fontSize: 14,
    lineHeight: 21,
    marginTop: 15,
    maxWidth: 300,
  },

  button: {
    marginTop: 24,
    backgroundColor: '#FFFFFF',
    paddingVertical: 15,
    borderRadius: 30,
    alignItems: 'center',
  },

  buttonText: {
    color: '#080808',
    fontSize: 11,
    fontWeight: '900',
    letterSpacing: 1.5,
  },

  sectionHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingHorizontal: 22,
    marginTop: 30,
    marginBottom: 12,
  },

  sectionTitle: {
    color: '#FFFFFF',
    fontSize: 13,
    fontWeight: '900',
    letterSpacing: 2,
  },

  seeAll: {
    color: '#777777',
    fontSize: 11,
  },

  card: {
    marginHorizontal: 18,
    marginBottom: 10,
    padding: 18,
    backgroundColor: '#121212',
    borderRadius: 16,
    flexDirection: 'row',
    alignItems: 'center',
  },

  number: {
    color: '#555555',
    fontSize: 12,
    fontWeight: '800',
    width: 32,
  },

  cardContent: {
    flex: 1,
  },

  cardTitle: {
    color: '#FFFFFF',
    fontSize: 15,
    fontWeight: '700',
    lineHeight: 21,
  },

  cardMeta: {
    color: '#666666',
    fontSize: 8,
    letterSpacing: 1,
    marginTop: 7,
  },

  arrow: {
    color: '#FFFFFF',
    fontSize: 25,
    marginLeft: 10,
  },

  nav: {
    height: 68,
    borderTopWidth: 1,
    borderTopColor: '#202020',
    backgroundColor: '#0A0A0A',
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
  },

  navItem: {
    color: '#555555',
    fontSize: 8,
    fontWeight: '800',
    letterSpacing: 0.5,
  },

  navActive: {
    color: '#FFFFFF',
    fontSize: 8,
    fontWeight: '900',
    letterSpacing: 0.5,
  },
});

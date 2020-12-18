# Arkkitehtuurikuvaus
## Sovelluksen rakenne

Ohjelma on jaettu kahteen erilliseen pakettiin. yatzy.applogic sisältää kolme eri luokkaa, jotka muodostavat suurimman osan sovelluksen toiminnasta.`yazty.gui` sisältää käyttöliittymän rakentavan luokan `App.java`, sekä sovelluksen käynnistävän `Main.java`-luokan.


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne.png">

## Sovelluksen käyttöliittymä

Sovelluksen käyttöliittymälle on luotu kolme näkymää:

* Pelaajien lisäämiseen ja poistamiseen tarkoitettu näkymä
* Pelin "pääikkuna" eli näkymä, joka tarjoaa yatzyn pelaamiseen oleelliset toiminnot
* Lopulliset tulokset pelin päätyttyä

## Sovelluslogiikka

Sovellus hyödyntää kolmea eri luokkaa pakkauksessa `yatzy.applogic` tiedon käsittelyyn ja luomiseen. 

### Dice.java
Tämä luokka sisältää metodeja, jotka mahdollistavat arvojen luomisen käyttöliittymässä oleville nopille. Luokka myös tarjoaa metodeja, joiden avulla voidaan laskea tiettyjä tuloksia noppien arvoista.
* `roll()` luo enintään 5 satunnaista arvoa riippuen siitä, onko käyttäjä "lukinnut" joitain noppia ennen heittoa. Metodi lisää satunnaiset arvot 1-6 väliltä luokassa olevaan `HashMap<Integer, Integer> diceValues` kokoelmaluokkaan.
> Metodin `diceIsSelected()` avulla voidaan tarkastaa, onko jokin nopista "lukittu".


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/rollmethod.png">

Kuvassa `roll()` on luonut 5 satunnaista arvoa, jotka muodostavat täyskäden.

### Players.java
Luokkassa olevien metodien avulla voidaan hallita pelaajien luomista tai poistamista. Luokassa sijaitsee kokoelmaluokka `HashMap<String, ScoreCard> players`, johon tallennetaan pelaajien nimet ja jokaisen pelaajan henkilökohtainen tuloskortti.
* Metodi `getPlayerScorecard(String name)` on todella tärkeä sovelluksen toiminnan kannalta. Tätä metodia kutsutaan pelin edetessä aina kun pelaajalle merkitään tuloksia.

### ScoreCard.java 

Tämä luokka on vastuussa tuloksien merkkaamiseen.
* `addScore(String scorename, int value)`
* `getScore(String scorename)`
* `doesNotContainScore(String scorename)` 

> Kyseiset metodit mahdollistavat tuloksien etsimisen ja niiden lisäämisen pelaajan henkilökohtaiseen tuloskorttiin.

## Sovelluksen toiminta

Otetaan aikaisemmin mainittu esimerkki, kun käyttäjä heittää nopilla täyskäden.
Pelaaja lisää kyseisen tuloksen omaan tuloskorttiinsa, jolloin sovelluksen toiminta näyttää tältä:


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/addingfullhouse.png">

Tapahtuma etenee näin:

1. Käyttäjä painaa täyskäden lisäämiseen tarkoitettua nappulaa `fullAdd`, joka sijaitsee kuvassa korostetussa kohdassa.


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/esimerkki1.png">

2. Kutsutaan metodia `fullHouseSum()`, joka laskee noppien summan. **Jos käyttäjällä ei ole täyskättä, metodi palauttaa arvon 0**

3. Seuraavaksi haetaan käyttäjän henkilökohtainen tuloskortti metodilla `getPlayerScorecard(String name)`, joka palauttaa ScoreCard-olion.

4. Kutsutaan luokan ScoreCard metodia `addScore("full house", 28)`, joka asettaa pelaajan tuloskorttiin kyseisen tuloksen.

5. `fullAdd` asetetaan pois käytöstä ja `fullValue` kohdalle asetetaan kyseisen täyskäden summa.


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/esimerkki2.png">

**Jos** pelaajalla on jo tämä tulos merkittynä tuloskorttiinsa, nappula `fullAdd` on poistettu käytöstä. Tämä kertoo pelaajalle sen, että hänellä on jo kyseinen tulos merkittynä ja se myös estää sovelluksen väärinkäytön.


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/cantaddfullhouse.png">

# Arkkitehtuurikuvaus
## Sovelluksen rakenne

Ohjelma on jaettu kahteen erilliseen pakettiin. yatzy.applogic sisältää kolme eri luokkaa, jotka muodostavat suurimman osan sovelluksen toiminnasta. yazty.gui sisältää käyttöliittymän rakentavan luokan `App.java`.


<img src="https://github.com/matiasonnelainen/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne1.png" width="160">

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

### Players.java
Luokkassa olevien metodien avulla voidaan hallita pelaajien luomista tai poistamista. Luokassa sijaitsee kokoelmaluokka `HashMap<String, ScoreCard> players`, johon tallennetaan pelaajien nimet ja jokaisen pelaajan henkilökohtainen tuloskortti.
* Metodi `getPlayerScorecard(String name)` on todella tärkeä sovelluksen toiminnan kannalta. Tätä metodia kutsutaan pelin edetessä aina kun pelaajalle merkitään tuloksia.

### ScoreCard.java 

Tämä luokka on vastuussa tuloksien merkkaamiseen.
* `addScore(String scorename, int value)`
* `getScore(String scorename)`
* `doesNotContainScore(String scorename)` 

> Kyseiset metodit mahdollistavat tuloksien etsimisen ja niiden lisäämisen pelaajan henkilökohtaiseen tuloskorttiin.

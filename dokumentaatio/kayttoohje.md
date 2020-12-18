# Yatzysovelluksen käyttöohje

## Ohjelman käynnistäminen

Ohjelma käynnistyy komennolla
```
java -jar yatzyproject.jar
```
Suoritettavan jarin generointi onnistuu menemällä kansioon `yatzyproject` ja suorittamalla komennon
```
mvn package
```

## Pelaajien lisääminen

Sovellus aukeaa näkymään jossa pelaajia lisätään kirjoittamalla haluama nimi tekstikenttään ja painamalla "Add player" nappulaa. Lisätyt pelaajat näkyvät vasemmalla puolella olevasta listasta.
Pelaajien poistaminen toimii valitsemalla haluama pelaaja listasta ja painamalla "Remove player" nappulaa.

**Saman nimisiä pelaajia ei voida lisätä listaan**

## Pelin pelaaminen

### Noppien heittäminen

Oikeassa yläkulmassa noppien yläpuolella näkyy pelaaja, jonka vuoro on pelata. Pelaaja heittää noppia painamalla "Roll" nappulaa, joka arpoo 5 satunnaista arvoa.
Pelaaja voi "lukita" noppia painamalla niitä. Nämä nopat eivät saa uusia arvoja pelaajan heittäessä uudelleen. Pelaaja voi heittää noppia maksimissaan 3 kertaa.

### Tulosten lisääminen

Pelaaja voi lisätä haluamiaan tuloksia painamalla tietylle tulokselle tarkoitettua nappia ikkunan vasemmassa laidassa. Kun pelaaja on asettanut tuloksen tiettyyn kohtaan, sitä ei ole tulevilla kierroksilla mahdollista muuttaa.

**HUOM!**
On mahdollista, että pelaaja ei pysty lisäämään noppien arvoa mihinkään kohtaan "laillisesti". Tässä tilanteessa pelaajan pitää "ruksaa" jokin vapaista kohdista pois. Tämä toimii painamalla minkä vaan vapaana olevan tuloksen nappia. Tämä lisää kyseiselle kohdalle arvon nolla. Tässäkin tapauksessa kyseinen kohta on lukittu pelin loppuun asti.
 
### Pelaajan vaihtaminen

Pelaajaa vaihdetaan painamalla "Next player" nappulaa. Tämä onnistuu vasta sitten kun sen hetkinen pelaaja on asettanut jonkin tulokset tuloskorttiin.

### Pelin loppuminen

Peli loppuu kun kaikki pelaajat ovat täyttäneet tuloskorttinsa. Näkymä siirtyy ikkunaan missä pelaajat on lueteltu heidän saavuttamiensa pisteiden kanssa.
Pelin voi aloittaa uudestaan painamalla nappulaa `Restart game`, joka siirtää näkymän takaisin pelaajien luomiseen tarkoitettuun näkymään. Aikaisemmat tiedot pelaajista pyyhitään samalla.

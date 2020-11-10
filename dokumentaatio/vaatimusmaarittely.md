# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on tarkoitus olla yatzy-peli. Perinteisesti peliä pelataan viidellä nopalla ja pelin edetessä, tuloksia merkataan paperille.
Tämä sovellus tarjoaa graafisen käyttöliittymän kyseisen pelin pelaamista varten.
Jos yatzy ei ole ennestään tuttu peli, voit lukea sen säännöistä [täältä.](https://fi.wikipedia.org/wiki/Yatzy)

## Sovelluksen tarjoama toiminnallisuus

### Pelaajien lisääminen

Sovellus aukeaa näkymään, jossa peliin osallistuvat pelaajat lisätään. Pelaajien lukumäärää ei ole rajoitettu. Pelaajia on myös
mahdollista poistaa.

### Pelin pelaaminen

Pelin aloittaessa näkymä muuttuu. Tässä näkymässä ikkunan vasemmalla puolella näkyy kenen vuoro on pelata ja lisäksi kyseisen pelaajan saavuttamat arvot hänen tuloskortissa.
Ikkunan oikealla puolella on viisi noppaa vastaavaa nappulaa, joiden avulla pelaaja voi heittovuoroillaan lukita haluamiaan noppia.
Noppien lisäksi on myös heittämiseen tarkoitettu nappula, jota painaessa lukitsemattomille nopille arvotaan satunnainen arvo 1-6 väliltä.

### Pelin päättyminen

Peli päättyy kun kaikki pelaajat ovat täyttäneet oman tuloskorttinsa. Pelin voittajaksi julistetaan se pelaaja, jonka tuloskortin summa on korkein.
Peli tarjoaa mahdollisuuden palata alkuun, jos halutaan lisätä tai poistaa pelaajia.

## Ideoita jatkokehitykseen

* Noppien "animaatio". Nopan arvo vaihtelee nopeasti ennen sen lukitsemista yhdelle arvolle. Tämä voisi olla hauska lisä imitoimaan noppien pyörimistä.
* Highscoret


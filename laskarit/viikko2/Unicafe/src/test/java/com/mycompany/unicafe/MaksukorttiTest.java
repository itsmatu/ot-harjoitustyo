package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void toStringToimii() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoAlussaOikein() {
        
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoa() {
        kortti.lataaRahaa(5);
        
        assertEquals(15, kortti.saldo());
    }
    
    @Test
    public void saldoVaheneeJosRahaaTarpeeksi() {
        kortti.otaRahaa(5);
        
        assertEquals(5, kortti.saldo());
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void saldoEiVaheneJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(15);
        
        assertEquals(10, kortti.saldo());
        assertEquals(false, kortti.otaRahaa(15));
    }
}

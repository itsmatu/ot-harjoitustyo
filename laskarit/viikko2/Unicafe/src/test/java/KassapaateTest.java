
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matu
 */
public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(10000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void rahamaaraOikea() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void lounaitaMyytyOikein() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void maksuRiittavaEdulliseen() {
        kassa.syoEdullisesti(240);

        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());

    }

    @Test
    public void maksuRiittavaMaukkaaseen() {
        kassa.syoMaukkaasti(400);

        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maksuEiOleRiittava() {
        kassa.syoMaukkaasti(390);
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void maksukortillaTarpeeksiSaldoa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(10000-640, kortti.saldo());
        assertEquals(2, kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
        assertEquals(true, kassa.syoEdullisesti(kortti));
        assertEquals(true, kassa.syoMaukkaasti(kortti));
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maksukortillaEiTarpeeksiSaldoa() {
        Maksukortti eiSaldoa = new Maksukortti(200);
        kassa.syoEdullisesti(eiSaldoa);
        kassa.syoMaukkaasti(eiSaldoa);
        
        assertEquals(false, kassa.syoEdullisesti(eiSaldoa));
        assertEquals(false, kassa.syoMaukkaasti(eiSaldoa));
        assertEquals(200, eiSaldoa.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattuRahaKasvattaaKassanMaaraa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        
        assertEquals(101000, kassa.kassassaRahaa());
    }
    
    @Test
    public void eiVoidaTallettaaNegatiivistaMaaraa() {
        kassa.lataaRahaaKortille(kortti, -400);
        
        assertEquals(100000, kassa.kassassaRahaa());
    }
}

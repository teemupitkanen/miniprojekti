package ohtu;

import com.ohtu.miniprojektiv2.domain.Inproceeding;
import com.ohtu.miniprojektiv2.service.InMemoryCitationService;
import org.junit.Test;
import static org.junit.Assert.*;

public class InMemoryCitationServiceTest {

   private InMemoryCitationService serv;

   public InMemoryCitationServiceTest() {
   }

   @Test
   public void addingNewEmptyInproceedings() {
      Inproceeding in = new Inproceeding();
      serv.insert(in);

      String author = serv.listAll().get(0).getAuthor();

      assertEquals(null, author);

   }
   @Test
   public void addingNewInproceedings() {
      Inproceeding in = new Inproceeding("Bill", "How to Code", "Coding fo Dummies", "2999");
      serv.insert(in);

      String author = serv.listAll().get(0).getAuthor();

      assertEquals(in.getAuthor(), author);

   }
   @Test
   public void addingSeveralInproceedings() {
      
      Inproceeding in = new Inproceeding();
      serv.insert(in);

      String author = serv.listAll().get(0).getAuthor();

      assertEquals(in.getAuthor(), author);

   }
}
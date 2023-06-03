package DemoApp;

import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AppTest {
    @Test
    void testCodeFrancja(){
       String textToCode="FRANCJA";
       String codedText="FCRNJAA";
       assert(Main.Code(textToCode,3).equals(codedText));

    }
    @Test
    void testCodeDobrydzien(){
        String textToCode="DOBRYDZIEN";
        String codedText="DYEORDINBZ";
        assert(Main.Code(textToCode,3).equals(codedText));

    }
    @Test
    void testCodePolitechnika(){
        String textToCode="POLITECHNIKA";
        String codedText="PTNOIEHIALCK";
        assert(Main.Code(textToCode,3).equals(codedText));

    }
    @Test
    void testCodeUniversity(){
        String textToCode="UNIVERSITY";
        String codedText="UETNVRIYIS";
        assert(Main.Code(textToCode,3).equals(codedText));

    }

    @Test
    void testDecodeFrancja(){
        String decodedText="FRANCJA";
        String codedText="FCRNJAA";
        assert(Main.Decode(codedText,3).equals(decodedText));

    }

    @Test
    void testDecodeDobrydzien(){
        String decodedText="DOBRYDZIEN";
        String codedText="DYEORDINBZ";
        assert(Main.Decode(codedText,3).equals(decodedText));

    }

    @Test
    void testDecodePolitechnika(){
        String decodedText="POLITECHNIKA";
        String codedText="PTNOIEHIALCK";
        assert(Main.Decode(codedText,3).equals(decodedText));

    }

    @Test
    void testDecodeUniversity(){
        String decodedText="UNIVERSITY";
        String codedText="UETNVRIYIS";
        assert(Main.Decode(codedText,3).equals(decodedText));

    }


}
package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class HtmlTextConverterTest {

    @Test
    public void shouldReturnPathFileName() {
        //Arrange
        HtmlTextConverter htmlTextConverter = new HtmlTextConverter("test.txt");

        //Assert
        assertEquals(htmlTextConverter.getFilename(), "test.txt");
    }

    @Test
    public void shouldReturnHtmlHelloFile () throws IOException{
        //Arrange
        HtmlTextConverter htmlTextConverter = new HtmlTextConverter("C:\\Users\\bapti\\Desktop\\Kata\\race-car-katas\\Java\\TextConverter\\src\\test\\java\\tddmicroexercises\\textconvertor\\hello.txt");

        //Assert
        assertEquals(htmlTextConverter.convertToHtml(), "Hello !<br />How are you ?<br />");
        
    }
    
    @Test
    public void shouldReturnError () throws IOException{
        //Arrange
        HtmlTextConverter htmlTextConverter = new HtmlTextConverter("");

        //Assert
        assertThrows(FileNotFoundException.class, () -> {
            htmlTextConverter.convertToHtml();
        });
        
    }
}

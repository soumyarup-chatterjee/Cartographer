package testCartographer.flow;

import com.cartographer.xml.message.PACS004.Document;
import com.cartographer.xml.parsing.Parser;
import com.cartographer.xml.serialization.Serializer;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import testCartographer.mapping.Pacs004ToPacs008;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, SAXException, IOException, ParserConfigurationException {
        JAXBContext pacs004Context = JAXBContext.newInstance(com.cartographer.xml.message.PACS004.Document.class);
        JAXBContext pacs008context = JAXBContext.newInstance(com.cartographer.xml.message.PACS008.Document.class);

        // Using JAXB parsing
        Parser parser = new Parser(pacs004Context, "src/main/resources/pacs.004.001.12.xsd");
        parser.createJAXBHierarchy(true);
        Document pacs004JAXB = (Document) parser.<JAXBElement, File>parse(new File("src/main/resources/sample/pacs004-sample.xml")).getValue();

        //Using DOM parsing
        parser = new Parser("src/main/resources/pacs.004.001.12.xsd");
        Node pacs004DOM = parser.<Node, File>parse(new File("src/main/resources/sample/pacs004-sample.xml"));

        Pacs004ToPacs008 mapPacs04ToPacs08 = new Pacs004ToPacs008(pacs004JAXB);
        com.cartographer.xml.message.PACS008.Document pacs008 = mapPacs04ToPacs08.map();

        Serializer serializer = new Serializer(pacs008context, "src/main/resources/pacs.008.001.11.xsd");
        String output = serializer.serialize(pacs008);

        System.out.println(output);
        parser.getParsingExceptions().print();
        serializer.getSerializingExceptions().print();
    }
}

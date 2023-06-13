package com.cartographer.xml.parsing;

import com.cartographer.activity.ActivityType;
import com.cartographer.exception.CGException;
import com.cartographer.exception.CGExceptionFactory;
import com.cartographer.exception.Event;
import com.cartographer.xml.ModelHandler;
import jakarta.xml.bind.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Parser {
    private final CGException parsingEventHandler = CGExceptionFactory.newInstance(ActivityType.PARSING);
    private final ModelHandler modelHandler;
    private final Schema schema;
    private boolean createJAXBHierarchy = false;
    private JAXBElement root;
    private Unmarshaller unmarshaller;
    private Validator validator;
    private JAXBHierarchy hierarchy;

    public Parser(JAXBContext context) throws JAXBException {
        this.unmarshaller = context.createUnmarshaller();
        this.schema = null;
        this.modelHandler = ModelHandler.JAXB;
        this.setUnmarshallerProperties();
    }

    public Parser(JAXBContext context, String schemaLocation) throws SAXException, JAXBException {
        this.unmarshaller = context.createUnmarshaller();
        this.schema = SchemaFactory.newDefaultInstance().newSchema(new File(schemaLocation));
        this.modelHandler = ModelHandler.JAXB;
        this.setUnmarshallerProperties();
    }

    public Parser(String schemaLocation) throws SAXException {
        this.schema = SchemaFactory.newDefaultInstance().newSchema(new File(schemaLocation));
        this.validator = this.schema.newValidator();
        this.modelHandler = ModelHandler.DOM;
        this.validator.setErrorHandler(parsingEventHandler);
    }

    private void setUnmarshallerProperties() throws JAXBException {
        this.unmarshaller.setEventHandler(this.parsingEventHandler);
        if (this.schema != null)
            this.unmarshaller.setSchema(this.schema);
    }

    public <K, T> K parse(T source) {
        try {
            if (source instanceof String && this.modelHandler.compareTo(ModelHandler.DOM) == 0)
                return (K) this.parseDOM(new ByteArrayInputStream(((String) source).getBytes(StandardCharsets.UTF_8)));
            else if (source instanceof File && this.modelHandler.compareTo(ModelHandler.DOM) == 0)
                return (K) this.parseDOM(new FileInputStream((File) source));
            else if (source instanceof String && this.modelHandler.compareTo(ModelHandler.JAXB) == 0)
                return (K) this.parseJAXB(new StreamSource((String) source));
            else if (source instanceof File && this.modelHandler.compareTo(ModelHandler.JAXB) == 0)
                return (K) this.parseJAXB(new StreamSource((File) source));
        } catch (SAXException | ParserConfigurationException | IOException | JAXBException e) {
            parsingEventHandler.add(new Event(e));
        }
        return null;

    }

    private Node parseDOM(InputStream source) throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(source);
        this.validator.validate(new DOMSource(document));
        return document.getDocumentElement();
    }

    private JAXBElement parseJAXB(StreamSource source) throws JAXBException {
        try {
            if (this.createJAXBHierarchy) {
                this.hierarchy = new JAXBHierarchy();
                this.unmarshaller.setListener(this.hierarchy);
            }
            this.root = (JAXBElement) this.unmarshaller.unmarshal(source);
        } catch (UnmarshalException ue) {
            //parsingEventHandler.add(new Event((Exception) ue.getLinkedException()));
        }
        return this.root;
    }

    public CGException getParsingExceptions() {
        return this.parsingEventHandler;
    }

    public String getModelHandler() {
        return this.modelHandler.toString();
    }

    public JAXBHierarchy getDocumentHierarchy() {
        return this.hierarchy;
    }

    public void createJAXBHierarchy(boolean flag) {
        this.createJAXBHierarchy = flag;
    }

}

package com.cartographer.xml.serialization;

import com.cartographer.activity.ActivityType;
import com.cartographer.exception.*;
import jakarta.xml.bind.*;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringWriter;

public class Serializer {
    private final CGException serializingEventHandler;
    private final Marshaller marshaller;
    private Schema schema;
    private JAXBElement root;

    public Serializer(JAXBContext context, String schemaLocation) throws JAXBException, SAXException {
        this.serializingEventHandler = CGExceptionFactory.newInstance(ActivityType.SERIALIZATION);
        this.marshaller = context.createMarshaller();
        this.schema = SchemaFactory.newDefaultInstance().newSchema(new File(schemaLocation));
        this.marshaller.setEventHandler(this.serializingEventHandler);
        this.marshaller.setSchema(this.schema);

    }

    public String serialize(Object node) throws JAXBException {
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        try {
            this.marshaller.marshal(node, sw);
        } catch (MarshalException me){
            //serializingEventHandler.add(new Event((Exception) me.getLinkedException()));
        }
        return sw.toString();
    }

    public CGException getSerializingExceptions() {
        return serializingEventHandler;
    }
}

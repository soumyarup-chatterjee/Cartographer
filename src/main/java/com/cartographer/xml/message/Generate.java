package com.cartographer.xml.message;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.Options;
import com.sun.tools.xjc.Plugin;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import com.sun.tools.xjc.outline.Outline;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class Generate {

    public static void main(String[] args) throws IOException {
        Generate generate = new Generate();
        String[][] generationData = {
                {"com.cartographer.message.PACS008", "src/main/resources/pacs.008.001.11.xsd", "src/main/java"},
                {"com.cartographer.xml.message.PACS004_2", "src/main/resources/pacs.004.001.12.xsd", "src/main/java"}
        };
        for (String[] generationDatum : generationData)
            generate.run(generationDatum[0], generationDatum[1], generationDatum[2]);
    }

    private void run(String pkgName, String xsdLocation, String targetLocation) throws IOException {
        SchemaCompiler sc = XJC.createSchemaCompiler();
        sc.setDefaultPackageName(pkgName);
        sc.parseSchema(new InputSource(xsdLocation));
        S2JJAXBModel model = sc.bind();
        JCodeModel codeModel = model.generateCode(null, null);
        codeModel.build(new File(targetLocation));
    }
}

class runPlugin extends Plugin {

    @Override
    public String getOptionName() {
        return "XExtend-super-class";
    }

    @Override
    public String getUsage() {
        return " XExtending super class  :  Plugin";
    }

    @Override
    public boolean run(Outline outline, Options options, ErrorHandler errorHandler) throws SAXException {
        options.addBindFile(new File("src/main/java/com/cartographer/xml/message/GlobalBinding.xjb"));
        return true;
    }
}


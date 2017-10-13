
package com.ifpb.TCCQuery.daos;

import com.ifpb.TCCQuery.interfaces.ILeitorPdfDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import jdk.internal.org.xml.sax.SAXException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

public class LeitorPdfDao implements ILeitorPdfDao{
    
    private final BodyContentHandler handler;
    private final Metadata metadata;
    private final FileInputStream inputStream;
    private final ParseContext parseContext;

    public LeitorPdfDao(String path) throws FileNotFoundException{
        handler = new BodyContentHandler(-1);
        metadata = new Metadata();
        inputStream = new FileInputStream(new File(path));
        parseContext = new ParseContext();
    }
    
    @Override
    public String getText() throws IOException, SAXException, TikaException, org.xml.sax.SAXException{
        PDFParser pdfParser = new PDFParser();
        pdfParser.parse(inputStream, handler, metadata, parseContext);
        return handler.toString();
    }
    
}

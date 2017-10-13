package com.ifpb.TCCQuery.interfaces;

import java.io.IOException;
import jdk.internal.org.xml.sax.SAXException;
import org.apache.tika.exception.TikaException;

public interface ILeitorPdfDao {

    public String getText()
            throws IOException, SAXException, TikaException, org.xml.sax.SAXException;

}

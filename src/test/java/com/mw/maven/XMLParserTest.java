package com.mw.maven;

import java.io.*;
import org.easymock.EasyMock;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import junit.framework.TestCase;

/**
 * Created by Administrator on 2017/7/8.
 */

public class XMLParserTest extends TestCase {

    private  XMLReader parser;

    protected void setUp() throws Exception {
        parser = XMLReaderFactory.createXMLReader();
    }

    public void testSimpleDoc() throws IOException, SAXException {
        String doc = "<root>\n  Hello World!\n</root>";
        ContentHandler mock = EasyMock.createStrictMock(ContentHandler.class);

        mock.setDocumentLocator((Locator) EasyMock.anyObject());
        EasyMock.expectLastCall().times(0, 1);
        mock.startDocument();
        mock.startElement(EasyMock.eq(""), EasyMock.eq("root"), EasyMock.eq("root"),
                (Attributes) EasyMock.anyObject());
        mock.characters((char[]) EasyMock.anyObject(),
                EasyMock.anyInt(), EasyMock.anyInt());
        EasyMock.expectLastCall().atLeastOnce();
        mock.endElement(EasyMock.eq(""), EasyMock.eq("root"), EasyMock.eq("root"));
        mock.endDocument();
        EasyMock.replay(mock);

        parser.setContentHandler(mock);
        InputStream in = new ByteArrayInputStream(doc.getBytes("UTF-8"));
        parser.parse(new InputSource(in));

        EasyMock.verify(mock);
    }
}

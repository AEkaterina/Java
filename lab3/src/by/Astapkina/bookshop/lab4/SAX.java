package by.Astapkina.bookshop.lab4;

import by.Astapkina.bookshop.book.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {
    Book element = new Book();
    String thisElement = "";

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void endDocument() {
        System.out.println("end parsing");
    }

    public Book getResult() {
        return element;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(thisElement.equals("author")){
            element.setAuthor(new String(ch,start,length));
        }
        if (thisElement.equals("name")) {
            element.setName(new String(ch, start, length));
        }
        if (thisElement.equals("year")) {
            element.setYear(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("cost")) {
            element.setCost(new Integer(new String(ch, start, length)));
        }
        if(thisElement.equals("num_of_pages")){
            element.setNum_of_pages(new Integer(new String(ch,start,length)));
        }
    }
}

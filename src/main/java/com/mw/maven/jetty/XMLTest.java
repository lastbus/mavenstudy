package com.mw.maven.jetty;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by Administrator on 2017/7/9.
 */
@XmlRootElement(name = "XMLTest")
public class XMLTest implements Serializable {



    public static void XMLTest() {
        try {
            JAXBContext jc = JAXBContext.newInstance(XMLTest.class);
            Marshaller ms = jc.createMarshaller();
            XMLTest st = new XMLTest();
            st.setMailContent("邮件内容");
            st.setMailSubject("邮件主题");
            st.setMailTo("给袁义锐");
            StringWriter writer = new StringWriter();
            ms.marshal(st, writer);
            String result = writer.toString();
            System.out.println("对象转XML字符串： "+ result +"\n");
            System.out.println("---------------------------------------- \n");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            XMLTest _XMLTest = (XMLTest) unmarshaller
                    .unmarshal(new StringReader(result));

            System.out.println("翻转XML为对象："+_XMLTest.getMailContent());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static final long serialVersionUID = 641996587236478146L;
    private String mailTo;
    private String mailSubject;
    private String mailContent;

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }



    public static void main(String args[]) {
        XMLTest();
    }

}


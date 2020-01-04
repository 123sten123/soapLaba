package com.test.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Степан1 on 04.01.2020.
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL uri = new URL("http://127.0.0.1:8081/hello");
        QName qName = new QName("http://soap.test.com/", "HelloWorldImplService");
        Service service = Service.create(uri, qName);
        HelloWorld helloWorld = service.getPort(HelloWorld.class);
        System.out.println(helloWorld.getString("111"));
    }
}

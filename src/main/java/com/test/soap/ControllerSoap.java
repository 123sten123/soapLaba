package com.test.soap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Степан1 on 04.01.2020.
 */
@Controller
public class ControllerSoap {



    @RequestMapping("/")
    public String home(){return "redirect:/index";}

    @RequestMapping("/index")
    public ModelAndView main() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("index");
       return modelAndView;
    }




    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public ModelAndView index(@RequestParam(value = "test") String string) throws MalformedURLException {
        ModelAndView modelAndView = new ModelAndView();

        URL uri = new URL("http://127.0.0.1:8081/hello");
        QName qName = new QName("http://soap.test.com/", "HelloWorldImplService");
        Service service = Service.create(uri, qName);
        HelloWorld helloWorld = service.getPort(HelloWorld.class);
        System.out.println(helloWorld.getString(string));


        modelAndView.addObject("test", helloWorld.getString(string));
        //modelAndView.setViewName("redirect:/index");



        modelAndView.setViewName("request");
        return modelAndView;
    }


}

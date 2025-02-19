package org.bhanu;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;

public class Employee {
    public static void main(String[] args) {
        Resource r=new ClassPathResource("config.xml");
        BeanFactory b=new XmlBeanFactory(r);
        Empdetails emp = (Empdetails)b.getBean("empBean");
        emp.display();
    }
}

package org.bhanu;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DisplayDetails {
	public static void main(String arg[]) {
		Resource r=new ClassPathResource("config.xml");
	    BeanFactory b=new XmlBeanFactory(r);
	    LoanDetails d= (LoanDetails)b.getBean("loanBean");
	    d.display();
	}
}

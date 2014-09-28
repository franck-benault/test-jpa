package net.franckbenault.jpa.hibernate;

import java.io.File;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XmlReader {
	
	private static String pathFileName = "./src/main/resources/META-INF/persistence.xml";
	private static String hibernateUrl = "hibernate.connection.url";
	
	public static String getHibernateUrl(String databaseName) {
		
		
		SAXBuilder sxb = new SAXBuilder();
		org.jdom2.Document document = null;
		try {
			document = sxb.build(new File(pathFileName));
		} catch (Exception e) {
		}

		Element racine = document.getRootElement();
		List<Element> listPersistenceUnit = racine.getChildren();
		//System.out.println(listPersistenceUnit.size());
		for (Element courant : listPersistenceUnit) {
			if(courant.getAttributeValue("name").equals(databaseName)) {
				List<Element> properties = courant.getChildren().get(0).getChildren();
				//System.out.println(properties.size());
				for (Element property : properties) {
					//System.out.println(property.getAttribute("name").getValue());
					if(property.getAttribute("name").getValue().equals(hibernateUrl))
						return property.getAttributeValue("value");
				}
				
			}
			
			//System.out.println(courant);
		}
		return null;
		
	}
	
}

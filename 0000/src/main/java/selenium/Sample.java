package selenium;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Sample {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
		// TODO Auto-generated method stub
		File file=new File(System.getProperty("user.dir")+"/Additional_Files/Data.xml");
		if(file.exists()) {
			DocumentBuilderFactory dbFact=DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuild=dbFact.newDocumentBuilder();
			Document doc=dbBuild.parse(file);
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList list=doc.getChildNodes();
			for(int i=0;i<list.getLength();i++) {
			
			Node node=list.item(i);
			if(node.hasChildNodes()) {
				System.out.println("node name is "+node.getNodeName());
				 	if(node.hasAttributes()) {
				 		System.out.println("node attribute is "+node.getAttributes().item(0));
				 			}
				 	if(node.getChildNodes().getLength()==1) {
				 		System.out.println("node text content is "+node.getTextContent());
				 		
				 	}
			}
		}
			 	 
	
	}

}
}
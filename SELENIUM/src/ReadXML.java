
import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

 

            public static void main(String[] args) {

                        // TODO Auto-generated method stub

                       

                        File file = new File("C:\\Users\\Suresh M\\Desktop\\plant_catalog.xml");

                        try {

                                    FileInputStream ofile = new FileInputStream(file);

                                    DocumentBuilderFactory oFact = DocumentBuilderFactory.newInstance();
                                    		

                                    DocumentBuilder obuild = oFact.newDocumentBuilder();

                                    Document oDoc = obuild.parse(ofile);

                                    NodeList oNodelist = oDoc.getElementsByTagName("PLANT");

                                    System.out.println("Node List is : "+oNodelist.getLength());

                                    Node oNode = oNodelist.item(1);

                                    System.out.println("Node Name is : "+oNode.getNodeName());

                                    Element oElement = (Element) oNode;

                                    System.out.println(oElement.getTextContent());

//                                    System.out.println("Name is : " + oElement.getElementsByTagName("LIGHT")).item(0).getTextContent();

                        } catch (Exception e) {

                                    // TODO Auto-generated catch block

                                    e.printStackTrace();

                        }

                       

 

            }

 

}



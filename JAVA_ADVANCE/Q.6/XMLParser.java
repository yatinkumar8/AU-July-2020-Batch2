/*
* 6) Create a dummy xml and parse and print its data using java program.
* */



import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;

class Employee {
    private String ID;
    private String Firstname;
    private String Lastname;
    private int age;
    private double salary;

    public Employee(String ID, String Firstname, String Lastname, int age, double salary) {
        this.ID = ID;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "<" + ID + ", " + Firstname + ", " + Lastname + ", " + age + ", " + salary + ">";
    }

}

public class XMLParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(new File("sample.xml"));

        List<Employee> employees = new ArrayList<Employee>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                // Get the value of the ID attribute.
                String ID = node.getAttributes().getNamedItem("ID").getNodeValue();

                // Get the value of all sub-elements.
                String firstname = elem.getElementsByTagName("Firstname")
                        .item(0).getChildNodes().item(0).getNodeValue();

                String lastname = elem.getElementsByTagName("Lastname").item(0)
                        .getChildNodes().item(0).getNodeValue();

                Integer age = Integer.parseInt(elem.getElementsByTagName("Age")
                        .item(0).getChildNodes().item(0).getNodeValue());

                Double salary = Double.parseDouble(elem.getElementsByTagName("Salary")
                        .item(0).getChildNodes().item(0).getNodeValue());

                employees.add(new Employee(ID, firstname, lastname, age, salary));
            }
        }

        // Print all employees.
        for (Employee empl: employees)
            System.out.println(empl.toString());
    }
}
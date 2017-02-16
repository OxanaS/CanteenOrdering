package appl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 16.02.2017.
 */
public class Chek {
    {
        String filepath = "D:\\CanteenOrdering\\src\\main\\resources\\orders.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            // получаем узлы с именем Language
            // теперь XML полностью загружен в память
            // в виде объекта Document
            NodeList nodeList = doc.getElementsByTagName("order");

            // создадим из него список объектов Language
           List<Employee> employeeList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
              employeeList.add(getEmployee(nodeList.item(i)));
           }

            // печатаем в консоль информацию по каждому объекту Language
          // for (Employee employee : employeeList) {
            //    System.out.println(employee.toString());
         //  }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }


    // создаем из узла документа объект Language
    public static Employee getEmployee(Node node) {
        Employee employee = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            employee.setEmployee_name(getTagValue("employee_name", element));
            employee.setFoods(Integer.parseInt(getTagValue("foods", element)));
        }

        return employee;
    }
    // получаем значение элемента по указанному тегу
    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}

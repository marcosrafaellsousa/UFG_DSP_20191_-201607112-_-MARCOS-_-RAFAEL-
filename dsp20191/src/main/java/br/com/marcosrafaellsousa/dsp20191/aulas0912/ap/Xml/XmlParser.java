package br.com.marcosrafaellsousa.dsp20191.aulas0912.ap.Xml;

import java.io.*;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.*;

public class XmlParser {

    private String fileSeparator = System.getProperty("file.separator");
    String fileName = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
            + "students.xml";
    private String minhaMatricula = "201607112";

    private Document gerarDocument() throws DocumentException {
        File inputFile = new File(fileName);
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputFile);
        return document;
    }

    private Node separarMeuNode () {

        Node baseElement = null;
        try {
            Document baseDocument = gerarDocument();
            List<Node> nodes = baseDocument.selectNodes("/class/student");

            for (Node node : nodes) {
                if (node.selectSingleNode("matricula").getText().equals(minhaMatricula))
                    baseElement = node;
            }
        } catch (DocumentException e) {
            System.out.println("Nao foi possivel encoutrar o estudante de matricula " + minhaMatricula + " no arquivo");
        }
        return baseElement;
    }

    public void imprimirElementos() {
        try {
            Document document = gerarDocument();
            System.out.println("Root element :" + document.getRootElement().getName());

            List<Node> nodes = document.selectNodes("/class/student");
            System.out.println("----------------------------");

            for (Node node : nodes) {
                System.out.println("\nMatricula : "
                        + node.selectSingleNode("matricula").getText());
                System.out.println("Primeiro Nome : "
                        + node.selectSingleNode("firstname").getText());
                System.out.println("Ultimo nome : "
                        + node.selectSingleNode("lastname").getText());
                System.out.println("nickname : "
                        + node.selectSingleNode("nickname").getText());

                List<Node> frequencias = (node.selectSingleNode("frequencia").selectNodes("aulas"));
                for (Node frequencia : frequencias) {
                    System.out.print("Aulas dia "
                            + frequencia.valueOf("@numero") + ": ");
                    System.out.println(frequencia.getText());
                }
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void criaStudent() {
        String newFileName = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                + "student.xml";

        Node baseElement = separarMeuNode();
        if (baseElement != null) {
            try {
                Document document = DocumentHelper.createDocument();

                Element root = document.addElement("student");

                Element matriculaElement = root.addElement("matricula");
                matriculaElement.addText(baseElement.selectSingleNode("matricula").getText());

                Element firstNameElement = root.addElement("firstname");
                firstNameElement.addText(baseElement.selectSingleNode("firstname").getText());

                Element lastNameElement = root.addElement("lastname");
                lastNameElement.addText(baseElement.selectSingleNode("lastname").getText());

                Element nicknameElement = root.addElement("nickname");
                nicknameElement.addText(baseElement.selectSingleNode("nickname").getText());

                Element frequenciaElement = root.addElement("frequencia");

                List<Node> frequencias = (baseElement.selectSingleNode("frequencia").selectNodes("aulas"));
                for (Node frequencia : frequencias) {
                    frequenciaElement.addElement("aulas")
                            .addAttribute("numero", frequencia.valueOf("@numero"))
                            .addText(frequencia.getText());
                }

                OutputFormat format = OutputFormat.createPrettyPrint();
                FileOutputStream fileOutputStream = new FileOutputStream(newFileName);
                XMLWriter writer;
                writer = new XMLWriter(fileOutputStream, format);
                writer.write(document);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void alterarStudent () {

        String aulaAlterar = "0104";

        try {
            Document document = gerarDocument();

            List<Node> nodes = document.selectNodes("/class/student");

            for (Node node : nodes) {
                if (node.selectSingleNode("matricula").getText().equals(minhaMatricula)) {

                    List<Node> frequencias = (node.selectSingleNode("frequencia").selectNodes("aulas"));
                    for (Node frequencia : frequencias) {
                        if (frequencia.valueOf("@numero").equals(aulaAlterar)) {
                            frequencia.setText("F");
                        }
                    }
                }
            }

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            XMLWriter writer;
            writer = new XMLWriter(fileOutputStream);
            writer.write(document);

    } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

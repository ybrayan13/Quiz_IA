package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
	// write your code here
        listarXML();
    }
    public static void listarXML(){
        String url="http://localhost:8080/JavaWebServiceServerCRUDRestful/restful/empleados/xml/listarempleados";
        try{
            URL urlObj=new URL(url);
            //abrimos la conexion
            HttpURLConnection conexion=(HttpURLConnection)urlObj.openConnection();
            conexion.setRequestProperty("Accept-Language", "UTF-8");
            conexion.setRequestMethod("GET");
            conexion.connect();
            //Almacenamos la respuesta
            InputSource resultado=new InputSource(conexion.getInputStream());

            //convertimos la respuesta que viene en binario a un archivo xml
            Document xmlDoc= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resultado);
            conexion.disconnect();//desconecto la url

            XPath xpath= XPathFactory.newInstance().newXPath();

            Boolean nodoStatusBool=(Boolean)xpath.evaluate("/collection/empleado",xmlDoc, XPathConstants.BOOLEAN);
            if(nodoStatusBool){
                NodeList nodoStatus=(NodeList)xpath.evaluate("/collection/empleado",xmlDoc, XPathConstants.NODESET);
                for (int i = 0; i < nodoStatus.getLength(); i++) {
                    Node nodeId=(Node)xpath.evaluate("/collection/empleado["+(i+1)+"]/id",xmlDoc, XPathConstants.NODE);
                    String id=nodeId.getTextContent().toUpperCase();

                    Node nodeNombre=(Node)xpath.evaluate("/collection/empleado["+(i+1)+"]/nombre",xmlDoc, XPathConstants.NODE);
                    String nombre=nodeNombre.getTextContent().toUpperCase();

                    Node nodePuesto=(Node)xpath.evaluate("/collection/empleado["+(i+1)+"]/puesto",xmlDoc, XPathConstants.NODE);
                    String puesto=nodePuesto.getTextContent().toUpperCase();
                    System.out.println("XML-> El id es: "+id+", el nombre es: "+nombre+", el puesto es: "+puesto);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public void listarJson(){
//        String urlstr="http://localhost:8080/JavaWebServiceServerCRUDRestful/restful/empleados/json/listarempleados";
//        try{
//            URL url = new  URL(urlstr);
//            InputStream is = url.openStream();
//            JsonReader rdr=Json.createReader(new InputStreamReader(is, "UTF-8"));
//            JsonArray results= rdr.readArray();
//            Iterator<?> iterator = results.iterator();
//            while(iterator.hasNext()){
//                JsonObject jsonObject = (JsonObject) iterator.next();
//                System.out.println("JSON-> El id es: "+jsonObject.get("id").toString().toUpperCase()+", el nombre es: "+jsonObject.get("nombre").toString().toUpperCase()+", el puesto es: "+jsonObject.get("puesto").toString().toUpperCase());
//            }
//        }catch (Exception e) {
//            e.getMessage();
//            e.printStackTrace();
//        }
//    }
}

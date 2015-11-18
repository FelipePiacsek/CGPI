package computacao_grafica.geometria.io.out;

import java.io.File;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;

public class Saver {

    public Saver() {
    }

    public void salva(List<Forma2D> formas, String filename) {
        Document documento = construirDocumento(formas);
        salvarDocumento(documento, filename);
    }

    private void salvarDocumento(Document documento, String filename) throws TransformerFactoryConfigurationError {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
            System.out.println("XML gerado com sucesso!");
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    private Document construirDocumento(List<Forma2D> formas) {
        Document documento = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.newDocument();
            Element rootElement = documento.createElement("Figura");
            documento.appendChild(rootElement);
            Element elementoForma2D = null;
            for (Forma2D forma : formas) {
                elementoForma2D = documento.createElement(forma.getSaveElements().getNome());
                for (Ponto2D ponto : forma.getSaveElements().getPontos()) {

                    Element x = documento.createElement("x");
                    x.appendChild(documento.createTextNode(String.valueOf(ponto.getX())));
                    Element y = documento.createElement("y");
                    y.appendChild(documento.createTextNode(String.valueOf(ponto.getY())));

                    Element elementoPonto = documento.createElement("Ponto");
                    elementoPonto.appendChild(x);
                    elementoPonto.appendChild(y);

                    elementoForma2D.appendChild(elementoPonto);
                }
                if (forma instanceof Circunferencia2D) {
                    Element elementoRaio = documento.createElement("Raio");
                    elementoRaio.appendChild(documento.createTextNode(String.valueOf(forma.getSaveElements().getElementByName("Raio"))));
                    elementoForma2D.appendChild(elementoRaio);
                }
                Element r = documento.createElement("R");
                r.appendChild(documento.createTextNode(String.valueOf(forma.getSaveElements().getR())));

                Element g = documento.createElement("G");
                g.appendChild(documento.createTextNode(String.valueOf(forma.getSaveElements().getG())));

                Element b = documento.createElement("B");
                b.appendChild(documento.createTextNode(String.valueOf(forma.getSaveElements().getB())));

                Element cor = documento.createElement("Cor");
                cor.appendChild(r);
                cor.appendChild(g);
                cor.appendChild(b);
                elementoForma2D.appendChild(cor);

                rootElement.appendChild(elementoForma2D);
            }
        } catch (ParserConfigurationException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar as figuras.");
        }
        return documento;
    }

}

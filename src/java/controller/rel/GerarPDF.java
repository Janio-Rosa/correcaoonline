/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.rel;

/**
 *
 * @author Janio
 */
public class GerarPDF {

    
public void makePDF(long contractId, int documentType) {

//response.setHeader("Content-Disposition", "inline");
    
/*    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    String basePath = externalContext.getRealPath("/");

    try {
        fopFactory.setUserConfig(new File(basePath + "/pdf_transform/config/userconfig.xml"));
        fopFactory.setBaseURL(basePath);
        fopFactory.getFontManager().setFontBaseURL(basePath);
    } catch (Exception e) {
        e.printStackTrace();
    } 
    FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
    foUserAgent.setBaseURL(fopFactory.getBaseURL());

    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
    response.reset();
    response.setHeader("Content-Type", "application/pdf");
    response.setHeader("Content-disposition", "attachment");
    BufferedOutputStream output = null;

    try {
        output = new BufferedOutputStream(response.getOutputStream(), 10240);
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, output);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsltfile));

        Source src = new DOMSource(makeXML(contract)); // my method
        Result res = new SAXResult(fop.getDefaultHandler());

        transformer.transform(src, res);

    } catch (Exception e) {
        e.printStackTrace();
    } 

    facesContext.responseComplete();
*/
}
}

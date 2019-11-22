package controller.docentes;

import controller.CorrecaoBasic;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Janio
 */
@ManagedBean(name = "CorrecaoDocente")
@SessionScoped

public class CorrecaoDocente extends CorrecaoBasic  {

    public CorrecaoDocente() {
    }

    public static CorrecaoDocente getInstance() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Object temp = session.getAttribute("CorrecaoDocente");
        if (temp instanceof CorrecaoDocente) {
            CorrecaoDocente cd = (CorrecaoDocente) temp;
            return cd;
        }
        return null;
    }

}

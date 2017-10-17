
package com.ifpb.TCCQuery.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "filtroTCCQuery", urlPatterns = 
        {"/buscaTccPorConteudo.jsp", "/cadastroTcc.jsp", "/editarPerfil.jsp", "/inicial.jsp", "/viewTcc.jsp", "/buacaTccPorAno", "/pesquisaTcc"})
public class FiltroTCCQuery implements Filter {
 
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();

        String usuario = (String) session.getAttribute("email");

        if (usuario == null) {

            ((HttpServletResponse) res).sendRedirect("erroFiltro.jsp");

        } else {

            chain.doFilter(req, res);

        }
    }

    @Override
    public void destroy() {

    }
    
}

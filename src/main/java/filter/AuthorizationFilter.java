//package filter;
//
//import constance.CoreConstant;
//import model.UsersModel;
//import utl.SessionUtil;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public abstract  class AuthorizationFilter implements Filter {
//    private ServletContext context;
//
//    @Override
//    public void init(FilterConfig config) throws ServletException{
//        this.context = config.getServletContext();
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        String url = request.getRequestURI();
//
//        if (url.startsWith("/admin")){
//            UsersModel user = (UsersModel) SessionUtil.getInstance().getValue(request, CoreConstant.SESSION_DATA);
//            if (user != null){
//                String role = user.getRoleModel().getRoleName();
//
//                if (role.equals(CoreConstant.ROLE_ADMIN))
//                    filter.doFilter(req, res);
//                else if (role.equals(CoreConstant.ROLE_USER))
//                    response.sendRedirect(request.getContextPath() + "/login?action=login&messageResponse=not_permission&alert=danger");
//                else
//                    response.sendRedirect(request.getContextPath() + "/login?action=login&messageResponse=not_login&alert=danger");
//            }
//            else {
//                filter.doFilter(req, res);
//            }
//        }
//    }
//}

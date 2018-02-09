package java100.app.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class JsonAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object handler)
            throws Exception {
        
        // 세션 보관소에 "loginUser"가 저장되었는지 검사한다.
        HttpSession session = request.getSession();
        
        // 로그인 정보가 없으면 로그인 폼으로 보낸다.
            String path = request.getContextPath();
            boolean result = false;
            try {
                if(session.getAttribute("loginUser") == null){
                    if(isAjaxRequest(request)){
                        response.sendError(401);
                        return false;
                    }else{
                        response.sendRedirect(path + "/app/auth/login");  
                        result =  false;
                    }
                }else{
                    result =  true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return result;
        }
         
        private boolean isAjaxRequest(HttpServletRequest req) {
            String header = req.getHeader("AJAX");
            if ("true".equals(header)){
             return true;
            }else{
             return false;
            }
        }



}
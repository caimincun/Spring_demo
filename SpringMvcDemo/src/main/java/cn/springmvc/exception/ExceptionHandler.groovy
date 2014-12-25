package cn.springmvc.exception

import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by cmc on 14-12-24.
 */
class ExceptionHandler implements HandlerExceptionResolver{

    @Override
    ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof NumberFormatException) {
            //doSomething...
            return new ModelAndView("number");/*HTTP Status 404 - /WEB-INF/jsp/number.jsp*/
        } else if (ex instanceof NullPointerException) {
            //doSomething...
            return new ModelAndView("null");
            /* return new ModelAndView("error", model);  */
        }
        return new ModelAndView("exception");
    }
}

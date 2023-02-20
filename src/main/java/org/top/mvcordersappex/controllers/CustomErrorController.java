package org.top.mvcordersappex.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletResponse response, Model model) {
        model.addAttribute("errorCode",response.getStatus());
        model.addAttribute("msg", "Ой! Что-то пошло не так...");
        return "layout/error";
    }
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request, Model model) {
//        //do something like logging
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (status != null) {
//            Integer statusCode = Integer.valueOf(status.toString());
//
//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                model.addAttribute("err","error-404");
//
//            }
//            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                model.addAttribute("err","error-500");
//            }
//        }
//    }

}

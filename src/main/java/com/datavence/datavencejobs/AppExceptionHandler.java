package com.datavence.datavencejobs;

import com.datavence.datavencejobs.exceptions.StorageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(StorageException.class)
    public ModelAndView handleException(StorageException exception, RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.setViewName("error");
        return mav;
    }
}

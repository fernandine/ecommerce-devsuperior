package com.jean.dsCommerce.controller;

import com.jean.dsCommerce.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

}

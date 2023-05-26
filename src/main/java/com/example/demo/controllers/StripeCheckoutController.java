package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.StripeCheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.stripe.model.checkout.Session;
import java.util.Collection;

@RestController
@CrossOrigin(origins = {"http://127.0.0.1:5173", "http://localhost:5173", "${react.address}"})
@RequestMapping("/api/checkouts")
public class StripeCheckoutController {
    private final StripeCheckoutService stripeCheckoutService;

    public StripeCheckoutController(StripeCheckoutService stripeCheckoutService) {
        this.stripeCheckoutService = stripeCheckoutService;
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<String> createCheckoutSession(@RequestBody Collection<Product> cartItems) {
        try {
            Session session = stripeCheckoutService.createCheckoutSession(cartItems);
            String sessionJson = session.getLastResponse().body();
            return new ResponseEntity<>(sessionJson, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

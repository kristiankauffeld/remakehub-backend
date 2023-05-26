package com.example.demo.services;
import com.example.demo.models.Product;
import com.stripe.model.checkout.Session;
import java.util.Collection;

public interface StripeCheckoutService {
    //Session createStripeCheckoutSession(Collection<Product> lineItems) throws Exception;
    Session createCheckoutSession(Collection<Product> cartItems) throws Exception;
}

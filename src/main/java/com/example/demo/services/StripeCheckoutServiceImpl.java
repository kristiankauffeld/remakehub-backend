package com.example.demo.services;
import com.example.demo.models.Product;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StripeCheckoutServiceImpl implements StripeCheckoutService {
    @Value("${stripe.apiKey}")
    private String stripeApiKey;
    
    @Value("${REACT_ADDRESS}")
    private String YOUR_DOMAIN;

    @Override
    public Session createCheckoutSession(Collection<Product> cartItems) throws Exception {
        Stripe.apiKey = stripeApiKey;

        // Create line items from cart items
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
        for (Product cartItem : cartItems) {
            SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                    .setQuantity(1L) // Assuming a quantity of 1 for each product in the cart
                    .setPrice(cartItem.getPrice()) // Product has a getPrice() method provided by Lombok
                    .build();
            lineItems.add(lineItem);
        }

        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(YOUR_DOMAIN + "/success")
                        .setCancelUrl(YOUR_DOMAIN + "/canceled")
                        .addAllLineItem(lineItems) // Add all the line items to the session
                        .build();

        return Session.create(params);
    }
}

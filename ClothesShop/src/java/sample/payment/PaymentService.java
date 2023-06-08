/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;
import sample.model.payment.OrderPayment;

/**
 *
 * @author ACER
 */
public class PaymentService {

    private static final String CLIENT_ID = "ASMZzrjokluzYyGqL89LEABYqOfuhhp4sjR7zkvs0_SxjFjZdplad8ArOAxnkwhi5ucW2tgfWvUbpBkQ";
    private static final String CLIENT_SECRET = "ELjUv9DIZ6qyiZWrGJczQH-umvvscjhDR5rkDyLXabJt234P2FPoqYH3kePrdFuhzul5FrsIqjdMFmjF";
    private static final String MODE = "sandbox";
    private static final String PORT="8080";

    public String authorizePayment(List<OrderPayment> orderPayments) throws PayPalRESTException {
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransactions = getTransactionInformation(orderPayments);
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransactions).setRedirectUrls(redirectUrls).setPayer(payer)
                .setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = requestPayment.create(apiContext);

        System.out.println(approvedPayment);
        return getApprovalLink(approvedPayment);
    }

    private List<Transaction> getTransactionInformation(List<OrderPayment> listOrderPayment) {
        List<Transaction> listTransaction = new ArrayList<>();
        List<Item> listItem = new ArrayList<>();

        Details details = new Details();
        Amount amount = new Amount();
        ItemList itemList = new ItemList();
        Transaction transaction = new Transaction();

        double shipping_raw = 0;
        double tax_raw = 0;
        double subTotal = 0;
        
        for (OrderPayment orderPayment : listOrderPayment) {
            shipping_raw+=Double.parseDouble(orderPayment.getShipping());
            tax_raw+=Double.parseDouble(orderPayment.getTax());
            subTotal+=Double.parseDouble(orderPayment.getSubTotal());
        }
        
        details.setShipping(String.format("%.2f", shipping_raw));
        details.setTax(String.format("%.2f", tax_raw));
        details.setSubtotal(String.format("%.2f", subTotal));
  
        amount.setTotal(String.format("%.2f", (shipping_raw+tax_raw+subTotal)));
        amount.setDetails(details);
        amount.setCurrency("USD");
        
        transaction.setAmount(amount);
        transaction.setDescription("FASHION SHOP");
        
        for (OrderPayment orderPayment : listOrderPayment) {
            Item item = new Item(orderPayment.getNameProduct(), orderPayment.getQuantity(), orderPayment.getPrice(),"USD");
            listItem.add(item);
        }
        itemList.setItems(listItem);
        transaction.setItemList(itemList);
        listTransaction.add(transaction);
        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
            }
        }
        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:"+PORT+"/ClothesShop/LoadDetailCartController");
        redirectUrls.setReturnUrl("http://localhost:"+PORT+"/ClothesShop/PaymentReview");
        return redirectUrls;
    }
}

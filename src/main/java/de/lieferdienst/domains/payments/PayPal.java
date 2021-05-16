package de.lieferdienst.domains.payments;
///////////////////////// Start Class PayPal //////////////////////
public class PayPal extends PaypalAuthorizationService
{
    private String userName;
    private String password;

    ///////////////////////// Constructor //////////////////////
    public PayPal(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    ///////////////////////// Getter //////////////////////
    public String getUserName() {                                   // Method to return PayPalUserName
        return userName;
    }

    public String getPassword() {                                   // Method to return PayPalPassword
        return password;
    }
}
///////////////////////// End Class PayPal //////////////////////

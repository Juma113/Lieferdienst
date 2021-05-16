package de.lieferdienst.domains.payments;
///////////////////////// Start Class CreditCard //////////////////////
public class CreditCard extends CreditCardAuthorizationService
{
    private String cardHolderName;
    private String cardNumber;
    private String expirationDate;
    private int cvcCode;
    ///////////////////////// Constructer //////////////////////
    public CreditCard(String cardHolderName, String cardNumber, String expirationDate, int cvcCode)
    {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvcCode = cvcCode;
    }
    ///////////////////////// Getter //////////////////////
    public String getCardHolderName()
    {                                             // Method to return HolderName
        return cardHolderName;
    }
    public String getCardNumber()
    {                                              // Method to return CardNumber
        return cardNumber;
    }
    public String getExpirationDate()
    {                                               // Method to return ExpirationDate
        return expirationDate;
    }
    public int getCvcCode()
    {                                                 // Method to return CvcCode
        return cvcCode;
    }
}
///////////////////////// End Class CreditCard //////////////////////

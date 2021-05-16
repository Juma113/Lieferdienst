package de.lieferdienst.domains.payments;
///////////////////////// Start Class DepitCard //////////////////////
public class DepitCard extends DepitCardAuthorizationService
{
    private String bankName;
    private String cardHolderName;
    private String IBAN;
    private String BIC;
    ///////////////////////// Consructor //////////////////////
    public DepitCard(String bankName, String cardHolderName, String IBAN, String BIC)
    {
        this.bankName = bankName;
        this.cardHolderName = cardHolderName;
        this.IBAN = IBAN;
        this.BIC = BIC;
    }
    ///////////////////////// Getter //////////////////////
    public String getBankName()
    {                                               // Method to return BankName
        return bankName;
    }
    public String getCardHolderName()
    {                                               // Method to return HoderName
        return cardHolderName;
    }
    public String getIBAN()
    {                                               // Method to return IBAN
        return IBAN;
    }
    public String getBIC()
    {                                               // Method to return BIC
        return BIC;
    }
}
///////////////////////// End Class DepitCard //////////////////////

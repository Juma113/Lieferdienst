package de.lieferdienst.domains.payments;


///////////////////////// Start Class CreditCardAuthorizationService //////////////////////
public class CreditCardAuthorizationService extends AuthorizaionServices
{
    public boolean creditCardAuthorization(CreditCard object1, CreditCard object2)
    {
        if (object1.getCardNumber() == object2.getCardNumber() && object1.getExpirationDate()==object2.getExpirationDate() && object1.getCvcCode() ==object2.getCvcCode() && object1.getCardHolderName()==object2.getCardHolderName())
            return true;
        else
            return false;
    }
}
///////////////////////// ENd Class CreditCardAuthorizationService //////////////////////
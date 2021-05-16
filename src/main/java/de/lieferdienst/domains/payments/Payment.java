package de.lieferdienst.domains.payments;

import java.util.ArrayList;
import java.util.List;
///////////////////////// Start Class Payment //////////////////////
// PayPal has 1 to 1 relation, however DepitCard and CreditCard have 1 to many, then
// we made to them Lists
public class Payment
{
    private PayPal paypal;
    private List<DepitCard> depitCard;
    private List<de.lieferdienst.domains.payments.CreditCard> CreditCard;
    ///////////////////////// Constroctor for initializing the lists //////////////////////
    public Payment()
    {
        this.depitCard = new ArrayList<DepitCard>();
        this.CreditCard = new ArrayList<CreditCard>();
    }
    public CreditCard AddCreditCard(CreditCard object)
    {                                                           //Add Elements to CreditCard list
        CreditCard.add(object);
        System.out.println("CreditCard added");
        return object;
    }
    public DepitCard AddDepitCard(DepitCard object)
    {                                                            //Add Elements to DepitCard list
        depitCard.add(object);
        System.out.println("depitCard added");
        return object;
    }
    public PayPal AddPayPal(PayPal object)
    {                                                           //Add Elements to PayPal list
        paypal=object;
        System.out.println("paypal added");
        return object;

    }
    public CreditCard removeCreditCard(CreditCard object)
{                                                           //remove CreditCard from the list.//to remove I must find it, so I assume that he is null(didn't find), then I search one by one in the list, when I find it, I save it in Item and Stop.
    CreditCard item=null;                                   // Item found, then remove it.
    for (int i = 0; i < CreditCard.size(); i++)
    {
        if(object.creditCardAuthorization(object, CreditCard.get(i)))
        {
            item=CreditCard.get(i);
            break;
        }
    }
    if(item != null){
        CreditCard.remove(item);
        System.out.println("CreditCard removed");
    }
    else System.out.println("No Item found");
    return item;
}
    public DepitCard removeDepitCard(DepitCard object)
    {                                                           ////remove DdepitCard from the list
        DepitCard item=null;                                      ////to remove I must find it, so I assume that he is null(didn't find), then I search one by one in the list, when I find it, I save it in Item and Stop.
        for (int i = 0; i < depitCard.size(); i++)
        {                 //// Item found, then remove it.
            if(object.depitCardAuthorization(object, depitCard.get(i)))
            {
                item=depitCard.get(i);
                break;
            }
        }
        if(item != null) {
            depitCard.remove(item);
            System.out.println("CreditCard removed");
        }
        else System.out.println("No Item found");
        return item;
    }
    public PayPal removePayPal(PayPal object){                      ////remove PayPal from the list
        if(object.paypalAuthorization(object, paypal))
        {
            paypal=null;
            System.out.println("paypal removed");
        }
        else
            System.out.println("invalid paypal");
        return object;
    }


}
///////////////////////// End Class Payment //////////////////////

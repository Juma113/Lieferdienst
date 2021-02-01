package lieferdienst;
///////////////////////// Start Class PaypalAuthorizationService //////////////////////
public class PaypalAuthorizationService extends AuthorizaionServices
{
    public boolean paypalAuthorization(PayPal object1, PayPal object2)
    {
        if (object1.getUserName()==object2.getUserName() && object1.getPassword()==object2.getPassword())
            return true;
        else
            return false;
    }
}
///////////////////////// End Class PaypalAuthorizationService //////////////////////

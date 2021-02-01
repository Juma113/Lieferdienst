package lieferdienst;
///////////////////////// Start Class DepitCardAuthorizationService //////////////////////
public class DepitCardAuthorizationService extends AuthorizaionServices
{
    public boolean depitCardAuthorization(DepitCard object1, DepitCard object2){
        if (object1.getIBAN()==object2.getIBAN() && object1.getCardHolderName()==object2.getCardHolderName())
            return true;
        else
            return false;
    }
}
///////////////////////// End Class DepitCardAuthorizationService //////////////////////

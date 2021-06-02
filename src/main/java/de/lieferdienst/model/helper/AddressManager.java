package de.lieferdienst.model.helper;

import de.lieferdienst.model.errors.AddressDoesNotExistsException;
import de.lieferdienst.model.errors.AddressExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AddressManager {

    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static List<Address> addressList;


    public AddressManager() {

        addressList = new ArrayList<Address>();
    }

    public static List<Address> getAddressList() {
        return addressList;
    }

    public void addAddress(Address address) throws AddressExistsException
    {
        if (address != null)
        {
            if (!addressList.contains((address)))
            {
                addressList.add(address);
            } else
            {
                throw new AddressExistsException("Address already Exists!");
            }
        } else
        {
            logger.warning("Given Address is null...");
        }
    }

    public void removeAddress(Address address) throws AddressDoesNotExistsException
    {
        if (addressList.contains(address))
        {
            addressList.remove(address);
        } else
        {
            throw new AddressDoesNotExistsException("Address does not exist!");
        }
    }


}

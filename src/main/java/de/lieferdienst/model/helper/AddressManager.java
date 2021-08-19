package de.lieferdienst.model.helper;

import de.lieferdienst.model.errors.AddressDoesNotExistsException;
import de.lieferdienst.model.errors.AddressExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
/**
 * Class which contains a list of Addresses
 *
 * @author Lieferdienst Team
 */
public class AddressManager {

    private transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static List<Address> addressList;


    public AddressManager() {

        addressList = new ArrayList<Address>();
    }

    public static List<Address> getAddressList() {
        return addressList;
    }

    /**
     * @param address address that should be added to the addressList
     *                when the address is not null and is not in the list it will be added
     *                if the address is already in the list an exception will be thrown
     *                if the address is null a warning will be logged
     */

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
    /**
     * @param address address that should be removed from the addressList
     *                if the address is in the list the address will be removed
     *                if the address is not in the list an exception will be thrown
     */
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

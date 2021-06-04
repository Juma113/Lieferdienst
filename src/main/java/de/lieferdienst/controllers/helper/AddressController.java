package de.lieferdienst.controllers.helper;


import de.lieferdienst.model.errors.AddressDoesNotExistsException;
import de.lieferdienst.model.helper.Address;
import de.lieferdienst.repository.storage.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @GetMapping("/default")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Iterable<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Address> findAddressById(@PathVariable(value = "id") Long id) throws AddressDoesNotExistsException {
        return ResponseEntity.ok(this.addressRepository
                .findById(id)
                .orElseThrow(() -> new AddressDoesNotExistsException("No Address found for id " + id)));
    }

    @PostMapping(path = "/add", produces = "application/json")
    ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        return ResponseEntity.ok(this.addressRepository.save(address));
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address newAddress) {
        return addressRepository.findById(id)
                .map( address -> {
                    address.setStreet(newAddress.getStreet());
                    address.setHouseNumber(newAddress.getHouseNumber());
                    address.setZipCode(newAddress.getZipCode());
                    address.setCity(newAddress.getCity());
                    return ResponseEntity.ok(this.addressRepository.save(address));
                })
                .orElseGet(() -> {
                    newAddress.setId(id);
                    return ResponseEntity.ok(this.addressRepository.save(newAddress));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteAddress(@PathVariable Long id) {
        this.addressRepository.deleteById(id);
    }
}

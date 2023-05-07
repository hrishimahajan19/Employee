package employeeAddressb.demo.controller;


import employeeAddressb.demo.model.Address;
import employeeAddressb.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("/id")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id,@RequestBody Address address){
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        return addressService.deleteAddressById(id);
    }




}


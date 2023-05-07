package employeeAddressb.demo.service;



import employeeAddressb.demo.model.Address;
import employeeAddressb.demo.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@Service
public class AddressService {
    @Autowired
    private IAddressRepository addressRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public ResponseEntity<Address> getAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Address> createAddress(Address address) {
        Address saved = addressRepository.save(address);
        return ResponseEntity.created(URI.create(""+saved.getId())).body(saved);
    }


    public ResponseEntity<Address> updateAddress(Long id,Address address) {
        Optional<Address> existingAddress = addressRepository.findById(id);
        if (existingAddress.isPresent()) {
            address.setId(id);
            Address savedAddress = addressRepository.save(address);
            return ResponseEntity.ok(savedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


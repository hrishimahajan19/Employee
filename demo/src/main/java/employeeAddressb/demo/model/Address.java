package employeeAddressb.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @Enumerated(EnumType.STRING)
    private State state;

    @NotBlank
    @Digits(message = "Zipcode cannot be letters", integer = 6, fraction = 0)
    private String zipcode;
}


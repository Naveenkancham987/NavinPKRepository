package com.pk.publisher.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

/**
 * Customer class
 * @author  navi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-18T12:14:57.498Z")

public class Customer {

  @JsonProperty("customerNumber")
  @NotNull
  @Size(max = 10)
  private String customerNumber = null;


  @JsonProperty("firstName")
  @NotNull
  @Size(min = 10,max = 50)
  private String firstName = null;

  @JsonProperty("lastName")
  @NotNull
  @Size(min = 10,max = 50)
  private String lastName = null;
  
  @JsonSerialize(as = LocalDate.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @JsonProperty("birthdate")
  @NotNull
  private LocalDate birthdate = null;

  @JsonProperty("country")
  @NotNull(message = "value cannot be null")
  private String country = null;

  @JsonProperty("countryCode")
  @NotNull
  @Size(max = 2)
  private String countryCode = null;

  @JsonProperty("mobileNumber")
  @NotNull
  @Pattern(regexp = "^\\d{10}$")
  private String mobileNumber = null;

  @JsonProperty("email")
  @Email
  @Size(max = 50)
  @NotNull
  private String email = null;
  
  @JsonProperty("customerStatus")
  @Enum(enumClass=CustomerStatus.class, ignoreCase=true) 
  private String customerStatus = null;

  @JsonProperty("address")
  @NotNull
  private Address address = null;
 
  /**
   * Gets or Sets customerStatus
   */
  public enum CustomerStatus {
    OPEN("Open"),

    CLOSE("Close"),

    SUSPENDED("Suspended"),

    RESTORED("Restored");

    private String value;

    CustomerStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatus fromValue(String text) {
      for (CustomerStatus b : CustomerStatus.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
        else 
          throw new RuntimeException("Not valid");
      }
      return null;
    }
  }

  
  
  
  /**
   * Get customerStatus
   * 
   * @return customerStatus
   **/
  @ApiModelProperty(required = true)
  public String getCustomerStatus() {
    return customerStatus;
  }
  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
  }

  public Customer customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  /**
   * Get customerNumber
   * 
   * @return customerNumber
   **/
  @ApiModelProperty(example = "C000000001", required = true, value = "")

  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * 
   * @return firstName
   **/
  @ApiModelProperty(example = "doggie", required = true, value = "")

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * 
   * @return lastName
   **/
  @ApiModelProperty(example = "doggie", required = true, value = "")

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  @JsonSerialize(as = LocalDate.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @JsonProperty("birthdate")
  public Customer birthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Birthdate
   * 
   * @return birthdate
   **/
  @ApiModelProperty(example = "01-01-2020", required = true, value = "Birthdate")
  @JsonSerialize(as = LocalDate.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @JsonProperty("birthdate")
  public LocalDate getBirthdate() {
    return birthdate;
  }
      
  @JsonSerialize(as = LocalDate.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @JsonProperty("birthdate")
  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public Customer country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * 
   * @return country
   **/
  @ApiModelProperty(example = "India", required = true)

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Customer countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * 
   * @return countryCode
   **/
  @ApiModelProperty(example = "IN", required = true)

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Customer mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * 
   * @return mobileNumber
   **/
  @ApiModelProperty(example = "9849558454", required = true, value = "")

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * email id of customer
   * 
   * @return email
   **/
  @ApiModelProperty(example = "navin@gmail.com", required = true, value = "email id of customer")
  @NotNull
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }



  public Customer address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/
  @ApiModelProperty(value = "")
  @Valid
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerNumber, customer.customerNumber)
        && Objects.equals(this.firstName, customer.firstName)
        && Objects.equals(this.lastName, customer.lastName)
        && Objects.equals(this.birthdate, customer.birthdate)
        && Objects.equals(this.country, customer.country)
        && Objects.equals(this.countryCode, customer.countryCode)
        && Objects.equals(this.mobileNumber, customer.mobileNumber)
        && Objects.equals(this.email, customer.email)
        && Objects.equals(this.customerStatus, customer.customerStatus)
        && Objects.equals(this.address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, firstName, lastName, birthdate, country, countryCode,
        mobileNumber, email, customerStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");

    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}


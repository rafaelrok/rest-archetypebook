package br.com.rafaelvieira.restarchetypebook.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "firstName", "lastName", "address", "gender", "enabled" })
public class PersonVO extends ResourceSupport implements Serializable {
    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Boolean enabled;

    public PersonVO(){
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO)) return false;

        PersonVO personVO = (PersonVO) o;

        if (!getKey().equals(personVO.getKey())) return false;
        if (!getFirstName().equals(personVO.getFirstName())) return false;
        if (!getLastName().equals(personVO.getLastName())) return false;
        if (!getAddress().equals(personVO.getAddress())) return false;
        if (!getGender().equals(personVO.getGender())) return false;
        return getEnabled().equals(personVO.getEnabled());
    }

    @Override
    public int hashCode() {
        int result = getKey().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getGender().hashCode();
        result = 31 * result + getEnabled().hashCode();
        return result;
    }
}

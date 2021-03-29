package com.java_tutorials.decorator_kata_java;

import java.util.Objects;

public class EmailAddress {

    private final String address;

    public EmailAddress(String address) {
	this.address = address;
    }

    public String getAddress() {
	return address;
    }

    @Override public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	EmailAddress that = (EmailAddress) o;
	return Objects.equals(address, that.address);
    }

    @Override public int hashCode() {
	return Objects.hash(address);
    }

    @Override public String toString() {
	return "EmailAddress{" +
			"address='" + address + '\'' +
			'}';
    }
}

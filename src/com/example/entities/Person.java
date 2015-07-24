package com.example.entities;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String id;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final String mobile;

	private Person(final Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.mobile = builder.mobile;
	}

	public static class Builder {
		private String id;
		private String firstName;
		private String lastName;
		private String email;
		private String mobile;

		public Builder() {
		}

		public Builder id(final String id) {
			this.id = id;
			return this;
		}

		public Builder firstName(final String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(final String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder email(final String email) {
			this.email = email;
			return this;
		}

		public Builder mobile(final String mobile) {
			this.mobile = mobile;
			return this;
		}

		public Person build() {
			return new Person(this);
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getId() {
		return id;
	}

}

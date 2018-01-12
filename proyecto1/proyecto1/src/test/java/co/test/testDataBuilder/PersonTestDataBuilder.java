/**
 * 
 */
package co.test.testDataBuilder;

import co.ceiba.domain.Person;

/**
 * @author juan.salazar
 *
 */
public class PersonTestDataBuilder {
	
	private String name;
	private String lastName;
	
	public PersonTestDataBuilder() {
		super();
		this.name = "Ceiba";
		this.lastName = "Software House";
	}

	public PersonTestDataBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public PersonTestDataBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public Person build() {
		return new Person(this.name, this.lastName);
	}

}

/**
 * 
 */
package co.ceiba.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import co.ceiba.domain.Person;
import co.ceiba.service.EmailService;
import co.ceiba.service.NotifyPersonService;
import co.test.testDataBuilder.PersonTestDataBuilder;

/**
 * @author juan.salazar
 *
 */
public class NotifyPersonServiceTest {
	
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;
	private EmailService emailServiceMock;
	
	@Before
	public void setup() {
		emailService = new EmailService();
		notifyPersonService = new NotifyPersonService(emailService);
		
		// Mockito fake object
		emailServiceMock = Mockito.mock(EmailService.class);
	}
	
	@Test
	public void notifyTest() {
		
		// Arrange
		Person person = new PersonTestDataBuilder().build();
		// Act
		String message = notifyPersonService.notify(person);
		// Assert
		Assert.assertNotNull(message);
		
	}
	
	@Test
	public void notifyTestMock() {
		
		// Arrange
		Person person = new PersonTestDataBuilder().build();
		// Act
		String message = notifyPersonService.notify(person);
		Mockito.when(emailServiceMock.sendEmail(Mockito.anyString())).thenReturn("Hola Mundo");
		// Assert
		Assert.assertNotNull(message);
		
	}

}

package com.example.pet.resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import au.com.dius.pact.provider.junitsupport.target.TestTarget;
import au.com.dius.pact.provider.spring.junit5.MockMvcTestTarget;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Provider("pet-service")
@PactFolder("src/test/resources/pacts")
public class PetResourceTest {

	@Autowired
	private PetResource petResource;

	@TestTarget
	public final MockMvcTestTarget target = new MockMvcTestTarget();

	@LocalServerPort
	private int port;

	@BeforeEach
	void before() {
		target.setControllers(petResource);
	}

	@State({ "Pet exists", "Create a new pet", "Update a new pet", "delete a new pet" })
	public void toState() {
	}

}

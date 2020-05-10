package nl.gidsopenstandaarden.hti.testsuite.portal.controllers;

import nl.gidsopenstandaarden.hti.testsuite.portal.configuration.HtiPortalConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class PublicKeyController {
	private HtiPortalConfiguration htiPortalConfiguration;

	@RequestMapping(value = "public_key.txt", produces = MediaType.TEXT_PLAIN_VALUE)
	public String get() {
		return htiPortalConfiguration.getSigningPublicKey();
	}

	@Autowired
	public void setHtiPortalConfiguration(HtiPortalConfiguration htiPortalConfiguration) {
		this.htiPortalConfiguration = htiPortalConfiguration;
	}
}

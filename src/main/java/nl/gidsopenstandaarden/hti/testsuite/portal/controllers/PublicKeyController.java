/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * Copyright Headease B.V. (c) 2020.
 */

package nl.gidsopenstandaarden.hti.testsuite.portal.controllers;

import nl.gidsopenstandaarden.hti.testsuite.portal.configuration.HtiPortalConfiguration;
import nl.gidsopenstandaarden.hti.testsuite.portal.utils.KeyUtils;
import org.apache.commons.lang3.StringUtils;
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
	public String getText() {
		return htiPortalConfiguration.getSigningPublicKey();
	}

	@RequestMapping(value = "public_key.pem", produces = "application/x-pem-file")
	public String getPem() {
		return KeyUtils.formatPem(htiPortalConfiguration.getSigningPublicKey());
	}

	@Autowired
	public void setHtiPortalConfiguration(HtiPortalConfiguration htiPortalConfiguration) {
		this.htiPortalConfiguration = htiPortalConfiguration;
	}
}

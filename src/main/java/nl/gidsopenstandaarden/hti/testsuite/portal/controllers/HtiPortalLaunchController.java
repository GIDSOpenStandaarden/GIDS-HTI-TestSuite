package nl.gidsopenstandaarden.hti.testsuite.portal.controllers;

import nl.gidsopenstandaarden.hti.testsuite.portal.service.HtiPortalService;
import nl.gidsopenstandaarden.hti.testsuite.portal.valueobject.HtiPortalLaunchRequest;
import nl.gidsopenstandaarden.hti.testsuite.portal.valueobject.LaunchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.GeneralSecurityException;

/**
 *
 */

@RestController
@RequestMapping("portal_launch")
public class HtiPortalLaunchController {
	@Autowired
	public void setHtiPortalService(HtiPortalService htiPortalService) {
		this.htiPortalService = htiPortalService;
	}

	private HtiPortalService htiPortalService;


	@RequestMapping(method = RequestMethod.POST)
	public LaunchData launch(@RequestBody HtiPortalLaunchRequest request) throws GeneralSecurityException {
		LaunchData rv = new LaunchData();
		rv.setToken(htiPortalService.getLaunchToken(request));
		rv.setUrl(request.getLaunchUrl());
		rv.setRedirect(false);
		return rv;
	}

	@RequestMapping(method = RequestMethod.GET)
	public HtiPortalLaunchRequest get(HttpServletRequest request) {
		return htiPortalService.getPrototype(request);
	}
}

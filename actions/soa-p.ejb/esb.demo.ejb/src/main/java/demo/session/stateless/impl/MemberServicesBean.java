package demo.session.stateless.impl;

import demo.session.stateless.InvalidActivationDetails;
import demo.session.stateless.InvalidUserName;

import demo.session.stateless.MemberServices;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.ejb.Stateless;
import javax.ejb.PostActivate;
import javax.annotation.Resource;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

/**
 * <p/>
 * <p/>
 * </p>
 * This component and its source code representation are copyright protected
 * and proprietary to EDC4IT Ltd.
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of EDC4IT Ltd.
 * <p/>
 * Copyright (c) 2005 EDC4IT Ltd.
 *
 * @author EDC4IT Ltd
 * @version $Revision: 3248 $
 */
@Stateless
public class MemberServicesBean implements MemberServices {


  private static final Log log = LogFactory.getLog(MemberServicesBean.class);

  private static final Set<String> fakedDB = new HashSet<String>();

  public String register(String username, String password) throws InvalidUserName {

    log.info("Starting register...");


    if (fakedDB.contains(username)) {
      throw new InvalidUserName("Already Registered");
    }
    fakedDB.add(username);

    log.info("Registered " + username);
    String activationCode = ActivationCode.generate(username);
    return activationCode;

  }


  public void activate(String username, String activationCode) throws InvalidActivationDetails {
    log.info("Starting activate...");
    if (ActivationCode.isValid(username, activationCode)) {
      log.info("Activated account for "+ username);
    } else {
      throw new InvalidActivationDetails("Wrong activation code for this user");
    }


  }
}

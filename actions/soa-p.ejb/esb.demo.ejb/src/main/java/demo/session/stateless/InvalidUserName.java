package demo.session.stateless;

import javax.ejb.ApplicationException;

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
 * @version $Revision: 989 $
 */

public class InvalidUserName extends Exception {

  public InvalidUserName() {
  }

  public InvalidUserName(String message) {
    super(message);
  }

  public InvalidUserName(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidUserName(Throwable cause) {
    super(cause);
  }
}

/**
 * $Id$
 *
 * @author alvgarcia
 * @date 19/10/2015 10:11
 * Copyright (C) 2015 Scytl Secure Electronic Voting SA
 * All rights reserved.
 */

package org.jseats.unit;

import java.util.Properties;

import org.jseats.model.Tally;
import org.jseats.model.methods.DHondtHighestAveragesMethod;
import org.junit.Before;

public class DHondtExtendedShould extends DHondtShould {

	@Override
	public void setUpSut() {
		sut = new DHondtExtendedMethod();
	}

	private class DHondtExtendedMethod extends DHondtHighestAveragesMethod {
	}
}

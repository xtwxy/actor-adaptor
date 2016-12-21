package com.wincom.actor.adaptor.messages;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class JaxbContextUtil {
	static private JAXBContext context;

	static public JAXBContext getContext() {
		if (context == null) {
			try {
				context = JAXBContext.newInstance(new Class[] {
						Actor.class,
						Connection.class,
						Diagram.class,
						Port.class
				});
			} catch (JAXBException e) {
				throw new RuntimeException(e);
			}
		}
		return context;
	}
}

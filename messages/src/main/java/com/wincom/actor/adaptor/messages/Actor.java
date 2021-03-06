//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.21 at 03:04:07 PM CST 
//


package com.wincom.actor.adaptor.messages;

import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Actor", propOrder = {
    "input",
    "output"
})
public class Actor {

	private static final String INPUT_PORT_NAME = "input";
	@XmlElement(required = true)
	protected Port input;
	@XmlElement(required = true)
	protected PortList output = new PortList();
	@XmlAttribute(name = "id")
	protected String id;
	@XmlAttribute(name = "name")
	protected String name;

	public Actor() {
	}

	public Actor(String id, String name) {
		this();
		this.id = id;
		this.name = name;
		this.input = new Port(id, INPUT_PORT_NAME);
	}

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link Port }
     *     
     */
    public Port getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link Port }
     *     
     */
    public void setInput(Port value) {
        this.input = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link PortList }
     *     
     */
    public PortList getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortList }
     *     
     */
    public void setOutput(PortList value) {
        this.output = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }
    
	public void addOutput(Port port) {
		this.output.getPort().add(port);
	}

	public Port getOutput(String string) {
		return this.output.getPort().stream().filter(x -> x.name.equals(string)).collect(Collectors.toList()).get(0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

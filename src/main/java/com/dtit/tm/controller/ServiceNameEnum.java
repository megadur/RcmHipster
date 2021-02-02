package com.dtit.tm.controller;

/**
 * ServiceName<br>
 * <br>
 * <br>
 * Hier ist kein Service im Sinne eines "SERVICES" gemeint, sondern der Inhalt
 * des Feldes "name" in einem TMF Service Objekt.<br>
 *
 * <br>
 * todo : Durch die harte Kopplung im Projekt von Schnittstellen- und Domain
 * (Business) Typen, ist aktuell keine saubere Trennung in Packages moeglich und
 * die Nutzung findet sowohl durch BL als auch Schnittstellenklassen statt.
 * <br>
 *
 * <br>
 * Die Klasse ist ein Resultat von
 * https://gard.telekom.de/gard/browse/RCM-458.<br>
 * <br>
 *
 */
public enum ServiceNameEnum {

	/** The ipaccessconfigoperational. */
	IPACCESSCONFIGOPERATIONAL("IpAccessConfigOperational"),

	/** The gigaip accesscredentials. */
	GIGAIP_ACCESSCREDENTIALS("GigaIP_AccessCredentials");

	/**
	 * Wert des Service.Name
	 */
	private String serviceName;

	/**
	 * Instantiates a new service name enum.
	 *
	 * @param serviceName Wert des Service.Name
	 */
	private ServiceNameEnum(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Wert des Service.Name
	 *
	 * @return the value
	 */
	public String serviceName() {
		return serviceName;
	}

	/**
	 * liefert ServiceNameEnum anhand eines serviceName.
	 *
	 * @param serviceName the service name
	 * @return null wenn nicht vorhanden
	 */
	public static ServiceNameEnum fromServiceName(String serviceName) {
		for (ServiceNameEnum servEnum : ServiceNameEnum.values()) {
			if (servEnum.serviceName.equals(serviceName)) {
				return servEnum;
			}
		}
		return null;
	}

}

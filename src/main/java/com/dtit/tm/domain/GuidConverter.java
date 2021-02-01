package com.dtit.tm.domain;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility Klasse für Guids.<br>
 * <br>
 * Mapping :  From and To a "ToNr".<br>
 * <br>
 *
 * TODO Überarbeiten des allgemeinen Design ( Verwendung, etc. ) , Package-Wahl, etc.
 */
public final class GuidConverter {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(GuidConverter.class);

	/** GUID ist eine 24-stellige Ziffer im Format VVLLDDDDTTTTTTTTTTTTSSSS <br>. */
	private static final int GUID_LENGTH = 24;

	/** The Constant TONR_MINLENGTH. */
	private static final int TONR_MINLENGTH = 6;

	/** The Constant TONR_MAXLENGTH. */
	private static final int TONR_MAXLENGTH = 12;

	/** The Constant LEADINGZEROSSTART. */
	private static final int LEADINGZEROSSTART = 2;

	/** The Constant LEADINGZEROSEND. */
	private static final int LEADINGZEROSEND = 4;

	/** The Constant NUMBERSBEFORETONUMMER. */
	private static final int NUMBERSBEFORETONUMMER = 8;

	/**
	 * util constr.
	 */
	private GuidConverter() {
		super();
	}

	/**
     * Die GUID ist eine 24-stellige Ziffer im Format VVLLDDDDTTTTTTTTTTTTSSSS,
     * wobei die einzelnen Ziffern die folgende Bedeutung haben:<br>
     * <br>
     * VV: 2-stellige Versionsnummer, z.Zt. „10“ für GUID<br>
     * LL: Anzahl der zu entfernenden Nullen aus dem T-Teil<br>
     * DDDD: 4-stellige Domain-ID – IDM-A verwendet den konstanten Wert "4901"<br>
     * TTTTTTTTTTTT:  12-Stellige T-Online-Nummer (mit führenden Nullen aufgefüllt)<br>
     * SSSS: 4-stelliger SUFFIX, "0001" für Hauptnutzer<br>
     * <br>
     * Die GUID wird wie folgt gebildet:
     * <br>
     * VV = "10"<br>
     * LL = 12 - length(TO-Nummer)<br>
     * DDDD = „4901“<br>
     * TTTTTTTTTTTT = TO-Nummer<br>
     * SSSS = „0001“<br>
     * <br>
     * Dabei werden fehlende Ziffern jeweils mit 0'en aufgefüllt,<br>
     * z.B. LL = "02" für den Wert 2 und<br>
     * TTTTTTTTTTTT = "000615193773" für die TO_NR "0615193773"<br>
     * <br>
     * <code>
     * Beispiel:<br>
     * ---------<br>
     * Eingabe:<br>
     * TO-Nummer:  "987654321" (9 Stellen)<br>
     * SUFFIX:     "0001"<br>
     * AAA-Domain: "4901"<br>
     * <br>
     * Berechnet<br>
     * LL = "03" (12-9)<br>
     * <br>
     * Ergebnis:<br>
     * GUID: 100349010009876543210001<br>
     * </code>
     *
     *
     * @param toNr // Tonummer: 6..12 (Normalfall 12!) Stellen, numerisch!
     * @return die resultierende Guid : null wenn to nummer das falsche format hat
     *
     */
	public static String convert(final String toNr) {
		LOGGER.debug("enter #convert toNr :[{}]", toNr);
		//
		if (!isValidToNR(toNr)) {
			LOGGER.debug("leave #convert Invalid-Rule result-guid :[null]");
			return null;
		}
		//TODO StringBuilder
		String result;
		final int len = toNr.length();
		if (len < TONR_MAXLENGTH) {
			result = "100" + (TONR_MAXLENGTH - len) + "4901" + ("000000000000" + toNr).substring(len) + "0001";
		} else {
			result = "10004901" + toNr + "0001";
		}
		LOGGER.debug("leave #convert result-guid :[{}]", result);
		return result;
	}

    /**
     * Die GUID ist eine 24-stellige Ziffer im Format VVLLDDDDTTTTTTTTTTTTSSSS,
     * wobei die einzelnen Ziffern die folgende Bedeutung haben:<br>
     * <br>
     * VV: 2-stellige Versionsnummer, z.Zt. „10“ für GUID<br>
     * LL: Anzahl der zu entfernenden Nullen aus dem T-Teil<br>
     * DDDD: 4-stellige Domain-ID – IDM-A verwendet den konstanten Wert "4901"<br>
     * TTTTTTTTTTTT:  12-Stellige T-Online-Nummer (mit führenden Nullen aufgefüllt)<br>
     * SSSS: 4-stelliger SUFFIX, "0001" für Hauptnutzer<br>
     * <br>
     * Die ToNummer wird aus der GUID extrahiert, indem der Teil mit den T's zurückgegeben wird
     * Beispiel:<br>
     * ---------<br>
     * Eingabe:<br>
     * GUID: 100349010009876543210001
     * <br>
     * <br>
     * Ergebnis:<br>
     * TO-Nummer:  "987654321" (9 Stellen)<br><br>
     *
     * @param guid // 24 Stellen, numerisch!
     * @return ToNummer (Normalfall 12 stellig) : null wenn die gegebene Guid nicht dem Format einer Guid entspricht
     *
     */
	public static String convertToToNr(String guid) {
		LOGGER.debug("enter #convertToToNr toNr :[{}]", guid);
		if (!isValidGUID(guid)) {
			LOGGER.warn("leave #convertToToNr Invalid-Rule result-toNr :[null]");
			return null;
		}
		//
		int zeroesCount = Integer.parseInt(guid.substring(LEADINGZEROSSTART, LEADINGZEROSEND));
		// Ignoriere vorangehende Nullen
		String result = guid.substring(NUMBERSBEFORETONUMMER + zeroesCount, NUMBERSBEFORETONUMMER + TONR_MAXLENGTH);
		LOGGER.debug("leave #convertToToNr result-toNr :[{}]", result);
		return result;
	}

	/**
	 * Prüft ob der gegebene String eine ToNummer ist.
	 *
	 * @param input zu prüfender String
	 * @return true wenn String eine ToNummer ist
	 */
	private static boolean isValidToNR(String input) {
		return StringUtils.isNumeric(input) && TONR_MINLENGTH <= StringUtils.length(input)
				&& StringUtils.length(input) <= TONR_MAXLENGTH;
	}

	/**
	 * Prüft ob der gegebene String eine Guid ist.
	 *
	 * @param input zu prüfender String
	 * @return true wenn String eine Guid ist
	 */
	private static boolean isValidGUID(String input) {
		return StringUtils.length(input) == GUID_LENGTH && StringUtils.isNumeric(input);
	}

}


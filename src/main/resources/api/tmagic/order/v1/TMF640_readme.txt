
TMF640: createCredentials und activateIPAccess
========================================================

1. createCredentials

Beispiel:
createCredentials (synchron)
Request:

=>

POST /api/service
Accept: application/json

{
	"id": "1234567890xyz",
	"name": "GigaIP_AccessCredentials",
	"state": "active",
	"characteristic": [
	{
		"name": "TO-Nr",
		"value": {
			"value": "584400000550"
		}
	},
	{
		"name": "anschlusskennung_necessary",
		"value": {
			"value": "1"
		}
	}
	]
}

Response:

<=

201 Created

{
	"id": "1234567890xyz",
	"name": "GigaIP_AccessCredentials",
	"state": "active",
	"characteristic": [
	{
		"name": "TO-Nr",
		"value": {
			"value": "584400000550"
		}
	},
	{
		"name": "pwd",
		"value": {
			"value": "Je4ExJ7CD5eoZ95tkbwF3JPHN2/t4RiD"
		}
	},
	{
		"name": "anschlusskennung",
		"value": {
			"value": "v69Ih1owMoRUpAG+63ew6XUHu0cqynbx"
		}
	},
	{
		"name": "probewort",
		"value": {
			"value": "7XJ0stxRRimGDjD5nkATwAmaddtaNd9P"
		}
	},
	{
		"name": "anschlusskennung_necessary",
		"value": {
			"value": "1"
		}
	}
	]
}


Fehlerfall:


500 Internal error



2. activateIPAccess

Die Schnittstelle activateIPAccess wird grundsätzlich asynchron verwendet. 
Dabei wird der Callback nicht registriert, sondern per Konfiguration hinterlegt. 

Es sind folgende UseCases über diese Schnittstelle abgebildet:
# NEW_ACTIVATION (POST)
# PRODUCT_CHANGE_WITH_LINE_ID_CHANGE (POST)
# PRODUCT_CHANGE_WITHOUT_LINE_ID_CHANGE (POST)
# TERMINATION (POST)

Beispiel:

activateIPAccess (asynchron)
Request:

=>

POST /api/service
Accept: application/json
Expect: 202-accepted (optional)

{
	"id": "1234567890xyz",
	"name": "IpAccessConfigOperational",
	"state": "active",
	"characteristic": [
	{
		"name": "BSS_OE_OrderID",
		"value": {
			"value": "4711"
		}
	},
	{
		"name": "UseCase",
		"value": {
			"value": "NEW_ACTIVATION"
		}
	},
	{
		"name": "TO-Nr",
		"value": {
			"value": "584400000550"
		}
	},
	{
		"name": "LineID",
		"value": {
			"value": "DEU.DTAG.NBGD001020"
		}
	},
	{
		"name": "ProfileID",
		"value": {
			"value": "1200012"
		}
	},
	{
		"name": "MaxUpspeed",
		"value": {
			"value": "384"
		}
	},
	{
		"name": "MaxDownspeed",
		"value": {
			"value": "384"
		}
	},
	{
		"name": "MaxSessionDuration",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "IPVersion",
		"value": {
			"value": "3"
		}
	},
	{
		"name": "MehrfachZugang",
		"value": {
			"value": "1"
		}
	},
	{
		"name": "DNSProfile",
		"value": {
			"value": ""
		}
	},
	{
		"name": "FilterID",
		"value": {
			"value": ""
		}
	},
	{
		"name": "UMT_Service_Data_OCSSubscriptionID",
		"value": {
			"value": "584400000550"
		}
	},
	{
		"name": "UMT_Service_Data_ThrottleProfile",
		"value": {
			"value": "ignoreComplete"
		}
	},
	{
		"name": "UMT_Service_Data_ThrottleDownL3"
	},
	{
		"name": "UMT_Service_Data_ThrottleUpL3"
	},
	{
		"name": "TunnelProfile"
	},
	{
		"name": "IPv4Address"
	},
	{
		"name": "IPv4NetMask"
	},
	{
		"name": "DelegatedIPv6Prefix"
	},
	{
		"name": "DelegatedIPv6PrefixLength"
	},
	{
		"name": "FramedIPv6Prefix"
	},
	{
		"name": "FramedIPv6PrefixLength"
	},
	{
		"name": "ReservePrefix",
		"value": {
			"value": ""
		}
	},
	{
		"name": "User-Auth-Required",
		"value": {
			"value": ""
		}
	},
	{
		"name": "InfluenceSession",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "CoANAKReaction",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "TerminationProfile"
	},
	{
		"name": "TeilnehmerSperre",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "ProfilSet",
		"value": {
			"value": ""
		}
	},
	{
		"name": "haMSISDN"
	}
	]
}


Response bei asynchroner Verarbeitung:

<=

202 Accepted
Content-Type: application/json
Location: http://server/api/activation/service/1234567890xyz

{
// same as in request
}

Link:
http://server/api/activation/monitor/1234567890xyz



Callback bei asynchroner Verarbeitung (Endpoint aus Konfiguration (URL+ "/{Service.id}"); später API GW):
{noformat}
=>

POST /path/1234567890xyz
Accept: application/json

{
	"id": "1234567890xyz",
	"name": "IpAccessConfigOperational",
	"state": "active",
	"characteristic": [
	{
		"name": "BSS_OE_OrderID",
		"value": {
			"value": "4711"
		}
	},
	{
		"name": "UseCase",
		"value": {
			"value": "NEW_ACTIVATION"
		}
	},
	{
		"name": "TO-Nr",
		"value": {
			"value": "584400000550"
		}
	},
	{
		"name": "LineID",
		"value": {
			"value": "DEU.DTAG.NBGD001020"
		}
	},
	{
		"name": "ProfileID",
		"value": {
			"value": "1200012"
		}
	},
	{
		"name": "MaxUpspeed",
		"value": {
			"value": "384"
		}
	},
	{
		"name": "MaxDownspeed",
		"value": {
			"value": "384"
		}
	},
	{
		"name": "MaxSessionDuration",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "IPVersion",
		"value": {
			"value": "3"
		}
	},
	{
		"name": "MehrfachZugang",
		"value": {
			"value": "1"
		}
	},
	{
		"name": "DNSProfile",
		"value": {
			"value": ""
		}
	},
	{
		"name": "FilterID",
		"value": {
			"value": ""
		}
	},
	{
		"name": "UMT_Service_Data_OCSSubscriptionID",
		"value": {
			"value": "584400000550"
		}
	},
	{
		"name": "UMT_Service_Data_ThrottleProfile",
		"value": {
			"value": "ignoreComplete"
		}
	},
	{
		"name": "UMT_Service_Data_ThrottleDownL3"
	},
	{
		"name": "UMT_Service_Data_ThrottleUpL3"
	},
	{
		"name": "TunnelProfile"
	},
	{
		"name": "IPv4Address"
	},
	{
		"name": "IPv4NetMask"
	},
	{
		"name": "DelegatedIPv6Prefix"
	},
	{
		"name": "DelegatedIPv6PrefixLength"
	},
	{
		"name": "FramedIPv6Prefix"
	},
	{
		"name": "FramedIPv6PrefixLength"
	},
	{
		"name": "ReservePrefix",
		"value": {
			"value": ""
		}
	},
	{
		"name": "User-Auth-Required",
		"value": {
			"value": ""
		}
	},
	{
		"name": "InfluenceSession",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "CoANAKReaction",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "TerminationProfile"
	},
	{
		"name": "TeilnehmerSperre",
		"value": {
			"value": "0"
		}
	},
	{
		"name": "ProfilSet",
		"value": {
			"value": ""
		}
	},
	{
		"name": "haMSISDN"
	}
	]
}


Response:

=>

200 Ok



Hinweise zum Umgang mit komplexen Datentypen
========================================================

Mit dem Parameter umt-service-data wurde ein komplexer Datentyp eingeführt.

Aufbau von "umt-service-data":
Das komplexe XML-Element "umt-service-data" beinhaltet weitere Sub-Elemente, 
so dass sich folgende Struktur ergibt:

<!--Optional:-->
<umt-service-data>
	<ocs-subscription-id>?</ocs-subscription-id>
	<!--You have a CHOICE of the next 2 items at this level-->
	<throttle-profile>?</throttle-profile>
	<!-- alternatively -->
	<throttle-down-l3>?</throttle-down-l3>
	<throttle-up-l3>?</throttle-up-l3>
</umt-service-data>

Erläuterung der Elemente:

- ocs-subscription-id (string 1..32)
  Eindeutiger Schlüssel welcher mit der Teilnehmernummer (TLNR) für 
  den FUP-Service gesetzt ist.

- throttle-profile (Drosselprofil) (nonNegativeInteger)
  Der neue Parameter "throttle-profile" ist ein numerischer Wert, der das externe 
  Drosselprofil auf ein internes Drosselprofil mapped.

- throttle-down-l3 (positiveInteger)

- throttle-up-l3 (positiveInteger)



Für CreateRequestSubscriber und UpdateRequestSubscriber ist umt-service-data
etwas unterschiedlich definiert:


CreateRequestSubscriber:

	<xs:complexType name="UMTServiceData">
		<xs:sequence>
			<xs:element name="ocs-subscription-id" type="OCSSubscriptionID"></xs:element>
			<xs:choice>
				<xs:element name="throttle-profile" type="ThrottleProfile"></xs:element>
				<xs:sequence>
					<xs:element name="throttle-down-l3" type="ThrottleDownL3"></xs:element>
					<xs:element name="throttle-up-l3" type="ThrottleUpL3"></xs:element>
				</xs:sequence>
			</xs:choice>
		</xs:sequence>
	</xs:complexType>


UpdateRequestSubscriber:

	<xs:complexType name="UMTServiceDataUpdate">
		<xs:sequence minOccurs="0">
			<xs:element name="ocs-subscription-id" type="OCSSubscriptionID"></xs:element>
			<xs:choice>
				<xs:element name="throttle-profile" type="ThrottleProfile"></xs:element>
				<xs:sequence>
					<xs:element name="throttle-down-l3" type="ThrottleDownL3"></xs:element>
					<xs:element name="throttle-up-l3" type="ThrottleUpL3"></xs:element>
				</xs:sequence>
			</xs:choice>
		</xs:sequence>
	</xs:complexType>

Beim UpdateRequestSubscriber kann also ein leeres Tag vorkommen,
was dazu verwendet wird, um umt-service-data zu löschen.

<umt-service-data></umt-service-data>

Bei CreateRequestSubscriber darf dieses nicht verwendet werden,
es kommt sonst zu folgendem berechtigten Fehler:

<?xml version="1.0" encoding="iso-8859-1"?>
<CreateResponseSubscriber xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://dummydomain.telekom.de/RDQ/IN_1">
  <RequestID>44767f0195c88e699598f061</RequestID>
  <origin>ver.sul.t-online.de</origin>
  <netprofileid>1</netprofileid>
  <rc>0003</rc>
  <returnmessage>Elementanzahl nicht korrekt.</returnmessage>
  <errormessage>Das Element muss mindestens ein Sub-Element enthalten.</errormessage>
  <errorelement>umt-service-data</errorelement>
  <rectime>20181211180045085</rectime>
  <rsptime>20181211180045089</rsptime>
  <tlnnr>446051335002</tlnnr>
</CreateResponseSubscriber>


Wie wird umt-service-data an den Schnittstellen TMF638 und TMF640 abgebildet?

Die ServiceCharacteristic lassen nur name-value Paare vom Typ String zu.


...

        }, {
        	"name": "UMT_Service_Data_OCSSubscriptionID",
        	"valueType": null,
        	"value": {
        		"value": 551979001350,
        		"@type": null,
        		"@schemaLocation": null
        	}			
        }, {
        	"name": "UMT_Service_Data_ThrottleProfile",
        	"valueType": null,
        	"value": {
        		"value": 1001,
        		"@type": null,
        		"@schemaLocation": null
        	}			
        }, {
        	"name": "UMT_Service_Data_ThrottleUpL3",
        	"valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
        	"name": "UMT_Service_Data_ThrottleDownL3",
        	"valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
        	...

wird abgebildet als

<umt-service-data>
  <ocs-subscription-id>551979001350</ocs-subscription-id>
  <throttle-profile>1001</throttle-profile>
</umt-service-data>



...
        }, {
            "name": "UMT_Service_Data_OCSSubscriptionID",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
            "name": "UMT_Service_Data_ThrottleProfile",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
            "name": "UMT_Service_Data_ThrottleUpL3",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
            "name": "UMT_Service_Data_ThrottleDownL3",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
... 

wird abgebildet als

<umt-service-data></umt-service-data>



Wie kann verhindert werden, dass umt-service-data überhaupt im RDQ_IN generiert wird?

Dies ist bei CreateRequestSubscriber notwendig, wenn das Drosselprofil nicht zum Einsatz kommt.

Hier kommt eines der Schlüsselworte zum Einsatz, welches bei der RGW-Rule-Engine 
verwendet wird. Es handelt sich dabei um einen generischen Mechanismus für die
Generierung des RDQ_IN.


...
        }, {
            "name": "UMT_Service_Data_OCSSubscriptionID",
            "valueType": null,
        	"value": {
        		"value": ignoreComplete,
        		"@type": null,
        		"@schemaLocation": null
        	}			
        }, {
            "name": "UMT_Service_Data_ThrottleProfile",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
            "name": "UMT_Service_Data_ThrottleUpL3",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
            "name": "UMT_Service_Data_ThrottleDownL3",
            "valueType": null,
        	"value": {
        		"value": null,
        		"@type": null,
        		"@schemaLocation": null
        	}
        }, {
... 

führt dazu, dass die Struktur von umt-service-data nicht im RDQ_IN generiert wird.

Es gibt folgende Schlüsselworte:

1. ignore

Das entsprechende Radius-Feld wird bei dem Request in Richtung Radius ignoriert und nicht im
XML aufgeführt.

Ausprägungen:
• ignore: Sowohl bei Create- als auch Update-Requests ignorieren
• ignoreCreate: Nur bei Create-Requests ignorieren
• ignoreUpdate: Nur bei Update-Requests ignorieren

2. ignoreComplete

Der komplette XML-Block in dem das entsprechende Radius-Feld enthalten ist wird bei dem
Request in Richtung Radius ignoriert und nicht im XML aufgeführt.

Ausprägungen:
• ignoreComplete: Sowohl bei Create- als auch Update-Requests ignorieren
• ignoreCompleteCreate: Nur bei Create-Requests ignorieren
• ignoreCompleteUpdate: Nur bei Update-Requests ignorieren

3. emptyRootElement

Das Root-Element eines Radius-Feldes welches als XML-Block mit verschiedenen Ebenen abgebildet
ist, wird leer ohne Unter-Elemente an den Radius übermittelt. Zusätzlich wird das neue Attribut
"levelToRoot" implementiert. Mit diesem Attribut wird angegeben, wie viele Ebenen höher sich das
Root-XML-Element befindet.

Ausprägungen:
• emptyRootElement: Sowohl bei Create- als auch Update-Requests ausschließlich das Root-Element leer an Radius übermitteln
• emptyRootElementCreate: Nur bei Create-Requests ausschließlich das Root-Element leer an Radius übermitteln
• emptyRootElementUpdate: Nur bei Update-Requests ausschließlich das Root-Element leer an Radius übermitteln

Die Schlüsselworte sind in Kap. "2.2.7. Regeln und Steuerung der Übergabe an Radius" 
Radius-GW_Regelwerk.pdf beschrieben.

Hinweis:
Bei emptyRootElement an den TMF-Schnittstellen wird "levelToRoot" immer mit levelToRoot=1 angenommen.















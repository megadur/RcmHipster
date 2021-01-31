
TMF638: getIPAccess und updateIPAccess
========================================================

1. getIPAccess

Request:
GET https://ftth-service-inventory-app-digihub-develop.appao17.appagile.io/ftth-service-inventory-rs/service?name=IpAccessConfigOperational&state=active&ServiceCharacteristics.name=TO-Nr&ServiceCharacteristics.value.value=551100085002

Response:
{
	"id": "f3a6c1c0-e6ae-4716-9266-90aae8f4c65c",
	"href": " http://api-gateway/ftth-service-inventory-rs/v1/service/10",
	"type": "RFS",
	"name": "IpAccessConfigOperational",
	"description": null,
	"@type": null,
	"@baseType": null,
	"@schemaLocation": null,
	"state": "active",
	"category": "RFS",
	"isServiceEnabled": true,
	"hasStarted": true,
	"startMode": "ManuallyByServiceProvider",
	"isStateful": false,
	"serviceDate": "2018-11-21T10:33:31.615Z",
	"startDate": "2018-11-21T10:33:32.491Z",
	"endDate": null,
	"serviceSpecification": null,
	"characteristic": [
		{
			"name": "FilterID",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "DNSProfile",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "MehrfachZugang",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "UMT_Service_Data_OCSSubscriptionID",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "MaxUpspeed",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "MaxSessionDuration",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "IPVersion",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "LineID",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "TO-Nr",
			"valueType": null,
			"value": {
				"value": "551100085002",
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "MaxDownspeed",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "UMT_Service_Data_ThrottleProfile",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "UMT_Service_Data_ThrottleDownL3",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "UMT_Service_Data_ThrottleUpL3",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},
		{
			"name": "ProfileID",
			"valueType": null,
			"value": {
				"value": null,
				"@type": null,
				"@schemaLocation": null
			}
		},

...

	],
	"serviceRelationship": [],
	"supportingService": [],
	"supportingResource": [],
	"relatedParty": [],
	"serviceOrder": [],
	"place": [],
	"note": []
}

- der GET-Request erfolgt bei der SLUP-Verarbeitung vor dem PATCH-Reqest; in der GET-Response wird die ServiceID mitgeliefert, die im PATCH-Request benötigt wird


Infos in GARD Team Merlin:

Das Service Inventory befindet sich unter diesem Link:
https://gard.telekom.de/gardwiki/display/DGHB/DO+Service+Inventory+Management+%28SIM%29+Interface+Features

Das Interface ist hier beschrieben:
https://gard.telekom.de/gardwiki/display/DGHB/IF+Service+Inventory+Interface+Resource+Model%2C+State+Model+and+Interface+Definition

Die Anpassung ist hier beschrieben:
https://gard.telekom.de/gardwiki/display/DGHB/TMF638+Modifications+on+Service+Inventory+Interface


2. updateIPAccess

Das ist ein PATCH mit der gleichen Service.id und den ggf. geänderten Charakteristiken.


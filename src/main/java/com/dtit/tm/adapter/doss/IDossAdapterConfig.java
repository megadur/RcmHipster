package com.dtit.tm.adapter.doss;

import com.dtit.tm.client.api.order.ServiceApi;

public interface IDossAdapterConfig {

    ServiceApi dossClientApi();

    String getDossAdapterBasePath();
}

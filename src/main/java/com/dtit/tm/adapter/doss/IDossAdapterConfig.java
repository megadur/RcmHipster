package com.dtit.tm.adapter.doss;

import com.dtit.tm.adapter.doss.order.ServiceApi;

public interface IDossAdapterConfig {

    ServiceApi dossClientApi();

    String getDossAdapterBasePath();
}

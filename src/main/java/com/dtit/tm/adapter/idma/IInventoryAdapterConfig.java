package com.dtit.tm.adapter.idma;

import com.dtit.tm.client.api.inventory.DefaultApi;

public interface IInventoryAdapterConfig {

    DefaultApi idmaInventoryClientApi();

    String getIdmaAdapterBasePath();
}

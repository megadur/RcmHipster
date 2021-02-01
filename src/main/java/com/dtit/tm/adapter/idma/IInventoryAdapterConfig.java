package com.dtit.tm.adapter.idma;

import com.dtit.tm.adapter.idma.inventory.DefaultApi;

public interface IInventoryAdapterConfig {

    DefaultApi idmaInventoryClientApi();

    String getIdmaAdapterBasePath();
}

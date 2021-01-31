package com.dtit.tm.adapter.idma;

import com.dtit.tm.client.api.credentials.DefaultApi;

public interface ICredentialAdapterConfig {

    DefaultApi idmaCredetialClientApi();

    String getIdmaAdapterBasePath();
}

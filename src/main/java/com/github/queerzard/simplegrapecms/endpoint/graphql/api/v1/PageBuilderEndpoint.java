package com.github.queerzard.simplegrapecms.endpoint.graphql.api.v1;

public class PageBuilderEndpoint {


    /*
    GET: api/v1/cms/editor?id={id}&items={'parameterName', ...}
        response: unpublished ? ((authorized & (admin || creator)) ? [fetchItems] : refuse ) : ((page
            .requiresAuthorized) ? (authorized ? [fetchItems] : refuse) : (unauthorized ? refuse : [fetchItems]))


    POST: api/v1/cms/editor?
        response: Create template

    PATCH: api/v1/cms/editor?id={id}&<parameter>={base64 encoded edit}  --> contents
        response: (creator || admin) ? edit : refuse                        context

    PATCH: api/v1/cms/editor?id={id}&context={base64 encoded new URI}
        response: (creator || admin) ? edit : refuse

    PUT: api/v1/cms/editor?id={id}&contents={base64 encoded content}&context={base64 uri}&role={roleName}
        response: (creator || admin) ? replace : refuse


    DELETE: /api/v1/cms/editor?{id}
        response: admin ? -> delete : refuse

     */

}

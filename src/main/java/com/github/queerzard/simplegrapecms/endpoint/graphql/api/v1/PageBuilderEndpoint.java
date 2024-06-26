package com.github.queerzard.simplegrapecms.endpoint.graphql.api.v1;

import com.github.queerzard.simplegrapecms.database.dto.CustomPageEntity;
import com.github.queerzard.simplegrapecms.database.services.impl.PageServiceImpl;
import com.github.queerzard.simplegrapecms.database.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/editor")
public class PageBuilderEndpoint {
    /*
    GET: api/v1/editor?id={id}&items={'parameterName', ...}
        response: unpublished ? ((authorized & (admin || creator)) ? [fetchItems] : refuse ) : ((page
            .requiresAuthorized) ? (authorized ? [fetchItems] : refuse) : (unauthorized ? refuse : [fetchItems]))


    POST: api/v1/editor?
        response: Create template

    PATCH: api/v1/editor?id={id}&<parameter>={base64 encoded edit}  --> contents
        response: (creator || admin) ? edit : refuse                        context

    PATCH: api/v1/editor?id={id}&context={base64 encoded new URI}
        response: (creator || admin) ? edit : refuse

    PUT: api/v1/editor?id={id}&contents={base64 encoded content}&context={base64 uri}&role={roleName}
        response: (creator || admin) ? replace : refuse


    DELETE: /api/v1/editor?{id}
    response: admin ? -> delete : refuse

     */

    @Autowired
    private PageServiceImpl pageService;
    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/{id}")
    public String getPage(@PathVariable String id, HttpServletRequest request) {
        return "";
    }

    @PostMapping
    public String postPage(HttpServletRequest request) {
        return "";
    }

    @PutMapping("/{id}")
    public String putPage(@PathVariable String id, @RequestBody CustomPageEntity customPageEntity, HttpServletRequest request) {
        return "";
    }

    @PatchMapping("/{id}")
    public String patchPage(@PathVariable String id, @RequestBody CustomPageEntity customPageEntity, HttpServletRequest request) {
        return "";
    }


}

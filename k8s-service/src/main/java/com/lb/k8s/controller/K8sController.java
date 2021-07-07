package com.lb.k8s.controller;

import com.google.gson.Gson;
import com.lb.k8s.api.model.R;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1NamespaceList;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Status;
import org.springframework.web.bind.annotation.*;

/**
 * @Class: K8sController
 * @Desc: K8s 控制层
 * @Author: liubin
 * @Date: 2021/7/7
 */
@RestController
public class K8sController {

    private static Gson gson = new Gson();

    @GetMapping("/createNamespace")
    public R<String> createNamespace(@RequestParam("name") String name) {
        CoreV1Api api = new CoreV1Api();
        V1Namespace v1Namespace = new V1Namespace();
        v1Namespace.setApiVersion("v1");
        v1Namespace.setKind("Namespace");
        V1ObjectMeta v1ObjectMeta = new V1ObjectMeta();
        v1ObjectMeta.setName(name);
        v1Namespace.setMetadata(v1ObjectMeta);
        try {
            v1Namespace = api.createNamespace(v1Namespace, null, null, null);
        } catch (ApiException e) {
            return R.fail("创建命名空间失败");
        }
        return R.ok(gson.toJson(v1Namespace));
    }

    @GetMapping("/deleteNamespace")
    public R<String> deleteNamespace(@RequestParam("name") String name) {
        CoreV1Api api = new CoreV1Api();
        V1Status v1Status;
        try {
            v1Status = api.deleteNamespace(name, null, null, null, null, null, null);
        } catch (ApiException e) {
            return R.fail("删除命名空间失败");
        }
        return R.ok(gson.toJson(v1Status));
    }

    @GetMapping("/listNamespace")
    public R<String> listNamespace() {
        CoreV1Api api = new CoreV1Api();
        V1NamespaceList v1NamespaceList;
        try {
            v1NamespaceList = api.listNamespace(null, null, null, null, null, null, null, null, null);
        } catch (ApiException e) {
            return R.fail("获取命名空间列表失败");
        }
        return R.ok(gson.toJson(v1NamespaceList));
    }

    @GetMapping("/listNamespace2")
    public R<V1NamespaceList> listNamespace2() {
        CoreV1Api api = new CoreV1Api();
        V1NamespaceList v1NamespaceList;
        try {
            v1NamespaceList = api.listNamespace(null, null, null, null, null, null, null, null, null);
        } catch (ApiException e) {
            return R.fail("获取命名空间列表失败");
        }
        return R.ok(v1NamespaceList);
    }
}
